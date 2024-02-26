package org.example;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        startServer(2181, "/Users/gerlowskija/checkouts/zk-quorum-test/zoo-data/z1"); // Start server 1 on port 2181
        //startServer(2182, "/Users/gerlowskija/checkouts/zk-quorum-test/zoo-data/z2"); // Start server 2 on port 2182
        //startServer(2183, "/Users/gerlowskija/checkouts/zk-quorum-test/zoo-data/z3"); // Start server 3 on port 2183

        Thread.sleep(60*5*1000);
    }

    private static void startServer(int port, String dataDir) throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(dataDir + "/zoo.cfg"));
        p.setProperty("clientPort", String.valueOf(port));

        QuorumPeerConfig config = new QuorumPeerConfig();
        config.parseProperties(p);
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.readFrom(config);
        ZooKeeperServerMain server = new ZooKeeperServerMain();
        new Thread(() -> {
            try {
                server.runFromConfig(serverConfig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}