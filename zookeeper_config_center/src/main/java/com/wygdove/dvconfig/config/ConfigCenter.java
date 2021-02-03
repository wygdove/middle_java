package com.wygdove.dvconfig.config;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: ConfigCenter
 * @Description:
 */
@Configuration
public class ConfigCenter {
    private static final Logger log=LoggerFactory.getLogger(ConfigCenter.class);

    private ZooKeeper zooKeeper;


    public ConfigCenter(ZooKeeperConfigAware zooKeeperConfig) {
        init(zooKeeperConfig);
    }


    public void init(ZooKeeperConfigAware zooKeeperConfig) {
        if(zooKeeper==null) {
            String zooKeeperAddress=zooKeeperConfig.getZooKeeperAddress();
            int zooKeeperTimeout=zooKeeperConfig.getZooKeeperTimeout();
            Watcher connectedWatcher=event->{
                if(Watcher.Event.EventType.None.equals(event.getType())&&
                   Watcher.Event.KeeperState.SyncConnected.equals(event.getState())) {
                    log.info("trigger watcher --- zookeeper[{}] connected",zooKeeperAddress);
                }
            };
            try {
                zooKeeper=new ZooKeeper(zooKeeperAddress,zooKeeperTimeout,connectedWatcher);
            }catch(Exception e) {
                zooKeeper=null;
                log.error("ConfigCenter.init error-zk connect: {}",e.getMessage(),e);
            }
        }
    }

    public String create(String path,String data) {
        log.info("ConfigCenter.create request {}={}",path,data);
        String result=null;
        if(zooKeeper==null) {
            return result;
        }
        try {
            result=zooKeeper.create(path,data.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }catch(Exception e) {
            result=null;
            log.error("ConfigCenter.create error: {}",e.getMessage(),e);
        }
        log.info("ConfigCenter.create result: {}",result);
        return result;
    }

    public String get(String path) {
        log.info("ConfigCenter.get request: {}",path);
        String result=null;
        if(zooKeeper==null) {
            return result;
        }
        Stat stat=new Stat();
        Watcher dataWatcher=new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if(Watcher.Event.EventType.NodeDataChanged.equals(event.getType())&&
                   Watcher.Event.KeeperState.SyncConnected.equals(event.getState())) {
                    log.debug("trigger watcher --- NodeDataChanged path: {}",event.getPath());
                    try {
                        byte[] changedDataBytes=zooKeeper.getData(event.getPath(),this,stat);
                        if(log.isDebugEnabled()) {
                            log.debug("trigger watcher --- NodeDataChanged {}={}",event.getPath(),new String(changedDataBytes));
                        }
                    }catch(Exception e) {
                        log.error("ConfigCenter.get NodeDataChanged getData error: {}",e.getMessage(),e);
                    }
                }
            }
        };
        try {
            byte[] dataBytes=zooKeeper.getData(path,dataWatcher,stat);
            result=new String(dataBytes);
        }catch(Exception e) {
            log.error("ConfigCenter.get error: {}",e.getMessage(),e);
        }
        log.info("ConfigCenter.get result: {}={}",path,result);
        return result;
    }


    public Stat update(String path,String data) {
        log.info("ConfigCenter.update request {}={}",path,data);
        Stat result=null;
        if(zooKeeper==null) {
            return result;
        }
        try {
            result=zooKeeper.setData(path,data.getBytes(),-1);
        }catch(Exception e) {
            result=null;
            log.error("ConfigCenter.update error: {}",e.getMessage(),e);
        }
        return result;
    }


    public String delete(String path) {
        log.info("ConfigCenter.get request: {}",path);
        String result=null;
        if(zooKeeper==null) {
            return result;
        }
        try {
            zooKeeper.delete(path,-1);
            result="ok";
        }catch(Exception e) {
            result=null;
            log.error("ConfigCenter.update error: {}",e.getMessage(),e);
        }
        return result;
    }




}
