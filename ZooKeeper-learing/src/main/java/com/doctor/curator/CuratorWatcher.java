package com.doctor.curator;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

import com.alibaba.dubbo.common.URL;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月10日 上午11:45:01
 */
public class CuratorWatcher {
    private static final String PATH_SEPARATOR = "/";
    private static final String BasePath = PATH_SEPARATOR + "dubbo";
    private static final String SERVICE_PATH = PATH_SEPARATOR + "com.doctor.demo.service.HelloRestService";
    private static final String SERVICE_PROVIDERS = PATH_SEPARATOR + "providers";

    private static final String PATH_1 = BasePath + SERVICE_PATH + SERVICE_PROVIDERS + PATH_SEPARATOR
            + URL.encode(""
                    + "rest://192.168.228.1:8099/com.doctor.demo.service.HelloRestService?"
                    + "anyhost=true&application=demoServiceApplication&compiler=javassist&"
                    + "default.cluster=failover&default.delay=-1&default.loadbalance=leastactive&"
                    + "default.proxy=javassist&default.retries=3&default.serialization=fastjson&"
                    + "default.timeout=10000&delay=-1&dispatcher=message&dubbo=2.8.4&"
                    + "generic=false&interface=com.doctor.demo.service.HelloRestService&"
                    + "logger=slf4j&methods=test_ModelResult,hello&organization=doctor&"
                    + "owner=doctor&pid=9676&server=netty&side=provider&threadpool=limited&"
                    + "threads=20&timestamp=1460193720086, dubbo version: 2.8.4, current host: 127.0.0.1");
    private static final String PATH_2 = BasePath + SERVICE_PATH + SERVICE_PROVIDERS + PATH_SEPARATOR
            + URL.encode(""
                    + "rest://192.168.228.6:8099/com.doctor.demo.service.HelloRestService?"
                    + "anyhost=true&application=demoServiceApplication&compiler=javassist&"
                    + "default.cluster=failover&default.delay=-1&default.loadbalance=leastactive&"
                    + "default.proxy=javassist&default.retries=3&default.serialization=fastjson&"
                    + "default.timeout=10000&delay=-1&dispatcher=message&dubbo=2.8.4&"
                    + "generic=false&interface=com.doctor.demo.service.HelloRestService&"
                    + "logger=slf4j&methods=test_ModelResult,hello&organization=doctor&"
                    + "owner=doctor&pid=9676&server=netty&side=provider&threadpool=limited&"
                    + "threads=20&timestamp=1460193720086, dubbo version: 2.8.4, current host: 127.0.0.1");

    public static void main(String[] args) throws InterruptedException {
        // Connect to zk
        try (TestingServer testingServer = new TestingServer(2188);
                CuratorFramework client = CuratorFrameworkFactory.newClient(testingServer.getConnectString(), new ExponentialBackoffRetry(1000, 3));) {

            client.start();
            System.err.println("CuratorFramework start....");
            client.create().creatingParentsIfNeeded().forPath(PATH_1, "empty".getBytes(StandardCharsets.UTF_8));
            client.create().creatingParentsIfNeeded().forPath(PATH_2, "empty".getBytes(StandardCharsets.UTF_8));

            List<String> serverUrls = client.getChildren().forPath(BasePath + SERVICE_PATH + SERVICE_PROVIDERS).stream().map(URL::decode).collect(Collectors.toList());
            serverUrls.forEach(System.err::println);

            TimeUnit.SECONDS.sleep(8);
            // Register watcher
            TreeCache treeCache = new TreeCache(client, BasePath);
            treeCache.getListenable().addListener((curatorClient, treeCacheEvent) -> {
                ChildData childData = treeCacheEvent.getData();
                if (childData == null) {
                    System.err.println("No data in event" + treeCacheEvent);
                } else {
                    System.err.println("Receive event:"
                            + "type:" + treeCacheEvent.getType()
                            + ", path:" + childData.getPath()
                            + ", data:" + String.valueOf(childData.getData())
                            + ", stat:" + childData.getStat());
                }
            });

            treeCache.start();
            System.err.println("tree cache start..");

            TimeUnit.SECONDS.sleep(3);

            // client.create().creatingParentsIfNeeded().forPath(PATH_1, "empty".getBytes(StandardCharsets.UTF_8));
            // client.create().creatingParentsIfNeeded().forPath(PATH_2, "empty".getBytes(StandardCharsets.UTF_8));
            //
            // List<String> serverUrls = client.getChildren().forPath(BasePath + SERVICE_PATH + SERVICE_PROVIDERS).stream().map(URL::decode).collect(Collectors.toList());
            // serverUrls.forEach(System.err::println);

            Map<String, ChildData> currentChildren = treeCache.getCurrentChildren(BasePath + SERVICE_PATH + SERVICE_PROVIDERS);
            System.err.println("currentChildren:" + currentChildren);

            System.err.println("service urls ");
            currentChildren.keySet().stream().map(URL::decode).forEach(System.err::println);

            Map<String, ChildData> notHaveValue = treeCache.getCurrentChildren(BasePath + PATH_SEPARATOR + "com.test.not.exist");
            System.err.println("not have value:" + notHaveValue);
            TimeUnit.MINUTES.sleep(5);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
