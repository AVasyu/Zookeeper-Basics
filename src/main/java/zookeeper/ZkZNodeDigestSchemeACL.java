package zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZkZNodeDigestSchemeACL {
    private static ZooKeeper zk;
    private static ZKConnect zkc;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zkc = new ZKConnect();
        zk = zkc.connect("localhost");

        zk.addAuthInfo("digest", "avasyu:avasyu".getBytes());
        byte[] data = zk.getData("/avasyu", true, zk.exists("/avasyu", true));
        for(byte b: data)
            System.out.print((char) b);
    }
}
