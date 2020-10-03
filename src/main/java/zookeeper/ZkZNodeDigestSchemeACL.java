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

        zk.addAuthInfo("digest", "userName:password".getBytes());
        byte[] data = zk.getData("/zNodeTest", true, zk.exists("/zNodeTest", true));
        for(byte b: data)
            System.out.print((char) b);
    }
}
