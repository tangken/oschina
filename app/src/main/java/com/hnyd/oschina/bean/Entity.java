package com.hnyd.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by tangk on 2016/9/16.
 */
public abstract class Entity extends Base{
    @XStreamAlias("id")
    protected int id;

    protected String cacheKey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }
}
