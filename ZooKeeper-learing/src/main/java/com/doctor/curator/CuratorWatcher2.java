package com.doctor.curator;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ThreadUtils;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月10日 下午3:52:26
 */
public class CuratorWatcher2 {
    private static final String zookeeprUrls = "localhost:2181";

    private static final String PATH_SEPARATOR = "/";
    private static final String BasePath = PATH_SEPARATOR + "dubbo";
    private static final String SERVICE_PATH = PATH_SEPARATOR + "com.doctor.demo.service.HelloRestService";
    private static final String SERVICE_PROVIDERS = PATH_SEPARATOR + "providers";

    static final ThreadFactory defaultThreadFactory = ThreadUtils.newThreadFactory("TreeCache");

    public static void main(String[] args) throws InterruptedException {
        // Connect to zk
        try (
                CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeprUrls, new ExponentialBackoffRetry(1000, 3));) {

            client.start();
            System.err.println("CuratorFramework start....");
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

            TimeUnit.MINUTES.sleep(5);
            treeCache.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
