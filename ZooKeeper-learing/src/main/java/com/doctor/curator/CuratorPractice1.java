package com.doctor.curator;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

/**
 * @author sdcuike
 *
 * @time 2016年1月31日 下午4:39:58
 * 
 * @see http://ifeve.com/zookeeper-curato-framework/
 * 
 *      Curator框架提供了一套高级的API， 简化了ZooKeeper的操作。 它增加了很多使用ZooKeeper开发的特性，可以处理ZooKeeper集群复杂的连接管理和重试机制。 这些特性包括：
 * 
 *      自动化的连接管理: 重新建立到ZooKeeper的连接和重试机制存在一些潜在的错误case。 Curator帮助你处理这些事情，对你来说是透明的。
 *      清理API:
 *      简化了原生的ZooKeeper的方法，事件等
 *      提供了一个现代的流式接口
 *      提供了Recipes实现： 如前面的文章介绍的那样，基于这些Recipes可以创建很多复杂的分布式应用
 *      Curator框架通过CuratorFrameworkFactory以工厂模式和builder模式创建CuratorFramework实 例。 CuratorFramework实例都是线程安全的，你应该在你的应用中共享同一个CuratorFramework实例.
 * 
 *      工厂方法newClient()提供了一个简单方式创建实例。 而Builder提供了更多的参数控制。一旦你创建了一个CuratorFramework实例，你必须调用它的start()启动，在应用退出时调用close()方法关闭.
 */
public class CuratorPractice1 {

    private static final String PATH = "/example/basic";

    public static void main(String[] args) throws Exception {
        try (TestingServer testingServer = new TestingServer();
                CuratorFramework client = CuratorFrameworkFactory.newClient(testingServer.getConnectString(), new ExponentialBackoffRetry(1000, 3));) {

            client.start();

            client.create().creatingParentsIfNeeded().forPath(PATH, "test".getBytes(StandardCharsets.UTF_8));
            System.out.println(new String(client.getData().forPath(PATH), StandardCharsets.UTF_8));
            TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
