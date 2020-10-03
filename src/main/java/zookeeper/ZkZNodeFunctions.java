package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import zookeeper.ZKConnect;

import java.io.IOException;

public class ZkZNodeFunctions {

    private static ZooKeeper zk;
    private static ZKConnect zkc;

    public static void delete(String path) throws KeeperException, InterruptedException{
        zk.delete(path, zk.exists(path, true).getVersion());
    }

    public static void update(String path, byte[] data) throws KeeperException, InterruptedException{
        zk.setData(path, data, zk.exists(path, true).getVersion());
    }

    public static byte[] read(String path) throws  KeeperException, InterruptedException{
        return zk.getData(path, true, zk.exists(path, true));
    }

    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        // Unsafe - no need to authenticate zNodes, visible to everyone
        // CreateMode - zNode to be persistent, persistent_sequential, ephemeral, ephemeral_sequential
        // To Open zkCli in localhost, go to folder where zookeeper-shell.bat is and run ->  zookeeper-shell.bat localhost:2181
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zkc = new ZKConnect();
        zk = zkc.connect("localhost");

        String path = "/zNodeTest/test1";
        byte[] createData = "Test".getBytes();

        // create(path, createData);

        update(path, "Test2".getBytes());

        byte[] readData = read(path);
        for(byte b: readData){
            System.out.print((char) b);
        }
    }
}
