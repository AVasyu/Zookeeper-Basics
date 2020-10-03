package zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.util.List;

public class ZKZnodeACL {
    private static ZooKeeper zk;
    private static ZKConnect zkc;

    private static List<ACL> getAcl(String path) throws KeeperException, InterruptedException {
        return zk.getACL(path, zk.exists(path, true));
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zkc = new ZKConnect();
        zk = zkc.connect("localhost");

        List<ACL> acl = getAcl("/znodeTest/test1");
        for(ACL aclItem: acl){
            System.out.println(aclItem.toString());
        }
    }
}
