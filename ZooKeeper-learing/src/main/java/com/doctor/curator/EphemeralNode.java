package com.doctor.curator;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.nodes.PersistentEphemeralNode;
import org.apache.curator.framework.recipes.nodes.PersistentEphemeralNode.Mode;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.KillSession;
import org.apache.curator.test.TestingServer;

/**
 * @author sdcuike
 *
 * @time 2016年1月31日 下午5:10:18
 * 
 * @see http://ifeve.com/zookeeper-ephemeral-node/
 */
public class EphemeralNode {

    private static final String PATH = "/example/ephemeralNode";
    private static final String PATH2 = "/example/node";

    public static void main(String[] args) {
        try (TestingServer testingServer = new TestingServer();
                CuratorFramework client = CuratorFrameworkFactory.newClient(testingServer.getConnectString(), new ExponentialBackoffRetry(1000, 3));) {

            client.getConnectionStateListenable().addListener(new ConnectionStateListener() {

                @Override
                public void stateChanged(CuratorFramework client, ConnectionState newState) {
                    System.out.println("===client state:" + newState.name());

                }
            });

            client.start();

            PersistentEphemeralNode node = new PersistentEphemeralNode(client, Mode.EPHEMERAL, PATH, "test path".getBytes());
            node.start();
            node.waitForInitialCreate(3, TimeUnit.SECONDS);
            String actualPath = node.getActualPath();
            System.out.println("node:" + actualPath + "value:" + new String(client.getData().forPath(actualPath)));

            client.create().forPath(PATH2, "persistent node".getBytes());
            System.out.println("node " + PATH2 + "value:" + new String(client.getData().forPath(PATH2)));

            KillSession.kill(client.getZookeeperClient().getZooKeeper());

            System.out.println("node" + actualPath + "doesn't exist:" + (client.checkExists().forPath(actualPath) == null));

            System.out.println("node:" + PATH2 + "doesn't exist " + (client.checkExists().forPath(PATH2)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
