package com.hzb;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Hello world!
 *
 * 买苹果找我
 */
@Slf4j
public class App {

    CuratorFramework client;
    {
         client = CuratorFrameworkFactory.builder().connectString(connectString)
                //会话超时时间，默认60s
                .sessionTimeoutMs(50000)
                //连接超时时间 默认15s
                .connectionTimeoutMs(30000)
                .retryPolicy(new RetryUntilElapsed(3, 100)).build();
         client.start();

    }

    public static void main( String[] args ) throws Exception {
        App app = new App();
        String path = "/just/test2";
//        app.add();

//        app.check();
//        app.client.close();
//        app.set(path);

        app.watch(path);

        System.in.read();
    }

    private static String connectString = "192.168.193.128:2181,192.168.193.128:2182,192.168.193.128:2183";

    /**
     * 创建节点
     * @throws Exception
     */
    private void add() throws Exception {
//        client.start();

//        client.create().forPath("/just/test", "test".getBytes());
        //创建临时节点
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/just/test2", "test2".getBytes());
    }

    //Registering beans for JMX exposure on startup
    private void check(String path) throws Exception {
        Stat stat = client.checkExists().forPath(path);
        if(stat != null) {
            System.out.println(stat.getEphemeralOwner());
        } else {
            System.out.println("不存在");
        }
    }

    /**
     *
     * 根据节点版本修改数据内容
     *
     * @throws Exception
     */
    private void set(String path) throws Exception {
        System.out.println("Before -- "  + new String(client.getData().forPath(path)));
        Stat stat = client.checkExists().forPath(path);
        if(stat == null) {
            log.warn("节点不存在");
            return;
        }

        client.setData().withVersion(stat.getVersion()).forPath(path, "update".getBytes());
        System.out.println("After -> " + new String(client.getData().forPath(path)));
    }

    private void watch(String path) throws Exception {

        final NodeCache nodeCache = new NodeCache(client, path);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                ChildData data = nodeCache.getCurrentData();
                if(data == null) {
                    System.out.println(" 空");
                    return;
                }
                System.out.println(data.getPath() + " 数据: " + new String(data.getData()));
            }
        });
        nodeCache.start();
    }
}
