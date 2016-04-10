package com.doctor.curator;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceProvider;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import com.alibaba.dubbo.common.URL;
import com.google.common.collect.Maps;

import discovery.InstanceDetails;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月9日 下午8:22:03
 */
public class DiscoveryExample {
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
        try (TestingServer testingServer = new TestingServer(2188);
                CuratorFramework client = CuratorFrameworkFactory.newClient(testingServer.getConnectString(), new ExponentialBackoffRetry(1000, 3));) {

            client.start();
            client.create().creatingParentsIfNeeded().forPath(PATH_1, "empty".getBytes(StandardCharsets.UTF_8));
            client.create().creatingParentsIfNeeded().forPath(PATH_2, "empty".getBytes(StandardCharsets.UTF_8));

            TimeUnit.SECONDS.sleep(3);
            List<String> serverUrls = client.getChildren().forPath(BasePath + SERVICE_PATH).stream().map(URL::decode).collect(Collectors.toList());
            serverUrls.forEach(System.err::println);

            //
            Map<String, ServiceProvider<InstanceDetails>> providers = Maps.newHashMap();
            JsonInstanceSerializer<InstanceDetails> serializer = new JsonInstanceSerializer<InstanceDetails>(InstanceDetails.class);

            try (ServiceDiscovery<InstanceDetails> serviceDiscovery = ServiceDiscoveryBuilder.builder(InstanceDetails.class).client(client).basePath(BasePath + SERVICE_PATH + SERVICE_PROVIDERS).serializer(serializer).build();) {
                serviceDiscovery.start();

                Collection<String> serviceNames = serviceDiscovery.queryForNames();
                System.err.println(serviceNames.size() + " type(s)");
                for (String serviceName : serviceNames) {
                    Collection<ServiceInstance<InstanceDetails>> instances = serviceDiscovery.queryForInstances(serviceName);
                    System.err.println(serviceName);
                    for (ServiceInstance<InstanceDetails> instance : instances) {
                        outputInstance(instance);
                    }
                }

                TimeUnit.MINUTES.sleep(1);

            } finally {
                for (ServiceProvider<InstanceDetails> cache : providers.values()) {
                    CloseableUtils.closeQuietly(cache);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void outputInstance(ServiceInstance<InstanceDetails> instance) {
        System.err.println("\t" + instance.getPayload().getDescription() + ": " + instance.buildUriSpec());
    }
}
