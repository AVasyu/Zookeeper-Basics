package zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZKTestConnection {

    private static ZooKeeper zk;
    private static ZKConnect zkc;
    private static List<String> zNodeList = new ArrayList<String>();

    public static void main(String[] args) throws IOException, InterruptedException, IllegalStateException, KeeperException {
        zkc = new ZKConnect();
        zk = zkc.connect("localhost");

        zNodeList = zk.getChildren("/", true);
        for(String zNode: zNodeList)
            System.out.println(zNode);
    }
}
