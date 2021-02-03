package com.wygdove.dvconfig.service.interfaces;

import org.apache.zookeeper.data.Stat;

/**
 * @Title: IConfigCenter
 * @Description:
 */
public interface IConfigCenter {
    public String create(String path,String data);
    public Stat update(String path,String data);
    public String delete(String path);
    public String get(String path);
}
