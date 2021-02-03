package com.wygdove.dvconfig.service.impl;

import com.alibaba.fastjson.JSON;
import com.wygdove.dvconfig.config.ZooKeeperConfigAware;
import com.wygdove.dvconfig.constants.DvConfigConstants;
import com.wygdove.dvconfig.service.interfaces.IConfigCenter;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


/**
 * @Title: CuratorConfigCenter
 * @Description:
 */
@Service
@ConditionalOnProperty(name=DvConfigConstants.ConfigMode.PROP_KEY,havingValue=DvConfigConstants.ConfigMode.CURATOR)
public class CuratorConfigCenter implements IConfigCenter {
    private static final Logger log=LoggerFactory.getLogger(CuratorConfigCenter.class);

    private CuratorFramework curatorClient;

    public CuratorConfigCenter(ZooKeeperConfigAware zooKeeperConfig) {
        String zooKeeperAddress=zooKeeperConfig.getZooKeeperAddress();
        int zooKeeperTimeout=zooKeeperConfig.getZooKeeperTimeout();
        int zooKeeperMaxRetries=zooKeeperConfig.getZooKeeperMaxRetries();
        RetryPolicy retryPolicy=new ExponentialBackoffRetry(zooKeeperTimeout,zooKeeperMaxRetries);
        curatorClient=CuratorFrameworkFactory.builder()
                .connectString(zooKeeperAddress)
                .retryPolicy(retryPolicy)
                .build();
        curatorClient.start();
    }


    @Override
    public String create(String path,String data) {
        log.info("CuratorConfigCenter.create request {}={}",path,data);
        String result=null;
        if(curatorClient==null) {
            return result;
        }
        try {
            result=curatorClient.create().forPath(path,data.getBytes());
        }catch(Exception e) {
            result=null;
            log.error("CuratorConfigCenter.create error: {}",e.getMessage(),e);
        }
        log.info("CuratorConfigCenter.create result: {}",result);
        return result;
    }

    @Override
    public Stat update(String path,String data) {
        log.info("CuratorConfigCenter.update request {}={}",path,data);
        Stat result=null;
        if(curatorClient==null) {
            return result;
        }
        try {
            result=curatorClient.setData().forPath(path,data.getBytes());
        }catch(Exception e) {
            result=null;
            log.error("CuratorConfigCenter.update error: {}",e.getMessage(),e);
        }
        if(log.isInfoEnabled()) {
            log.info("CuratorConfigCenter.update result: {}",JSON.toJSONString(result));
        }
        return result;
    }

    @Override
    public String delete(String path) {
        log.info("CuratorConfigCenter.delete request: {}",path);
        String result=null;
        if(curatorClient==null) {
            return result;
        }
        try {
            curatorClient.delete().forPath(path);
            result="ok";
        }catch(Exception e) {
            result=null;
            log.error("CuratorConfigCenter.delete error: {}",e.getMessage(),e);
        }
        log.info("CuratorConfigCenter.delete result: {}",result);
        return result;
    }

    @Override
    public String get(String path) {
        log.info("CuratorConfigCenter.get request: {}",path);
        String result=null;
        if(curatorClient==null) {
            return result;
        }
        Stat stat=new Stat();
        Watcher dataWatcher=new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if(Watcher.Event.EventType.NodeDataChanged.equals(event.getType())&&
                        Watcher.Event.KeeperState.SyncConnected.equals(event.getState())) {
                    log.info("CuratorConfigCenter.get -- trigger watcher -- NodeDataChanged path: {}",event.getPath());
                    try {
                        byte[] changedDataBytes=curatorClient.getData().storingStatIn(stat).usingWatcher(this).forPath(path);
                        if(log.isInfoEnabled()) {
                            log.info("CuratorConfigCenter.get -- trigger watcher -- NodeDataChanged {}={}",event.getPath(),new String(changedDataBytes));
                        }
                    }catch(Exception e) {
                        log.error("CuratorConfigCenter.get error -- NodeDataChanged getData: {}",e.getMessage(),e);
                    }
                }
            }
        };
        try {
            byte[] dataBytes=curatorClient.getData().storingStatIn(stat).usingWatcher(dataWatcher).forPath(path);
            if(log.isInfoEnabled()) {
                log.info("CuratorConfigCenter.get data stat: {}",JSON.toJSONString(stat));
            }
            result=new String(dataBytes);
        }catch(Exception e) {
            log.error("CuratorConfigCenter.get error -- getData: {}",e.getMessage(),e);
        }
        log.info("CuratorConfigCenter.get result: {}={}",path,result);
        return result;
    }
}
