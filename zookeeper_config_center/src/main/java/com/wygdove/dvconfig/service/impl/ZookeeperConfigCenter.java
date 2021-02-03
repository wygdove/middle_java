package com.wygdove.dvconfig.service.impl;

import com.alibaba.fastjson.JSON;
import com.wygdove.dvconfig.config.ZooKeeperConfigAware;
import com.wygdove.dvconfig.constants.DvConfigConstants;
import com.wygdove.dvconfig.service.interfaces.IConfigCenter;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @Title: ZookeeperConfigCenter
 * @Description:
 */
@Service
@ConditionalOnProperty(name=DvConfigConstants.ConfigMode.PROP_KEY,havingValue=DvConfigConstants.ConfigMode.ZOOKEEPER)
public class ZookeeperConfigCenter implements IConfigCenter {
    private static final Logger log=LoggerFactory.getLogger(ZookeeperConfigCenter.class);

    private ZooKeeper zooKeeper;

    public ZookeeperConfigCenter(ZooKeeperConfigAware zooKeeperConfig) {
        String zooKeeperAddress=zooKeeperConfig.getZooKeeperAddress();
        int zooKeeperTimeout=zooKeeperConfig.getZooKeeperTimeout();
        Watcher connectedWatcher=event->{
            if(Watcher.Event.EventType.None.equals(event.getType())&&
                    Watcher.Event.KeeperState.SyncConnected.equals(event.getState())) {
                log.info("ZookeeperConfigCenter.init -- trigger watcher -- zookeeper[{}] connected",zooKeeperAddress);
            }
        };
        try {
            zooKeeper=new ZooKeeper(zooKeeperAddress,zooKeeperTimeout,connectedWatcher);
        }catch(Exception e) {
            zooKeeper=null;
            log.error("ZookeeperConfigCenter.init error -- zk connect: {}",e.getMessage(),e);
        }
    }


    @Override
    public String create(String path,String data) {
        log.info("ZookeeperConfigCenter.create request {}={}",path,data);
        String result=null;
        if(zooKeeper==null) {
            return result;
        }
        try {
            result=zooKeeper.create(path,data.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }catch(Exception e) {
            result=null;
            log.error("ZookeeperConfigCenter.create error: {}",e.getMessage(),e);
        }
        log.info("ZookeeperConfigCenter.create result: {}",result);
        return result;
    }

    @Override
    public Stat update(String path,String data) {
        log.info("ZookeeperConfigCenter.update request {}={}",path,data);
        Stat result=null;
        if(zooKeeper==null) {
            return result;
        }
        try {
            result=zooKeeper.setData(path,data.getBytes(),-1);
        }catch(Exception e) {
            result=null;
            log.error("ZookeeperConfigCenter.update error: {}",e.getMessage(),e);
        }
        if(log.isInfoEnabled()) {
            log.info("ZookeeperConfigCenter.update result: {}",JSON.toJSONString(result));
        }
        return result;
    }

    @Override
    public String delete(String path) {
        log.info("ZookeeperConfigCenter.delete request: {}",path);
        String result=null;
        if(zooKeeper==null) {
            return result;
        }
        try {
            zooKeeper.delete(path,-1);
            result="ok";
        }catch(Exception e) {
            result=null;
            log.error("ZookeeperConfigCenter.delete error: {}",e.getMessage(),e);
        }
        log.info("ZookeeperConfigCenter.delete result: {}",result);
        return result;
    }

    @Override
    public String get(String path) {
        log.info("ZookeeperConfigCenter.get request: {}",path);
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
                    log.debug("ZookeeperConfigCenter.get -- trigger watcher -- NodeDataChanged path: {}",event.getPath());
                    try {
                        byte[] changedDataBytes=zooKeeper.getData(event.getPath(),this,stat);
                        if(log.isDebugEnabled()) {
                            log.debug("ZookeeperConfigCenter.get -- trigger watcher -- NodeDataChanged {}={}",event.getPath(),new String(changedDataBytes));
                        }
                    }catch(Exception e) {
                        log.error("ZookeeperConfigCenter.get error -- NodeDataChanged getData: {}",e.getMessage(),e);
                    }
                }
            }
        };
        try {
            byte[] dataBytes=zooKeeper.getData(path,dataWatcher,stat);
            result=new String(dataBytes);
        }catch(Exception e) {
            log.error("ZookeeperConfigCenter.get error -- getData: {}",e.getMessage(),e);
        }
        log.info("ZookeeperConfigCenter.get result: {}={}",path,result);
        return result;
    }
}
