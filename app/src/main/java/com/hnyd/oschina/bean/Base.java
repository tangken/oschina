package com.hnyd.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 实体类基类
 * Created by tangk on 2016/9/16.
 */
public abstract class Base implements Serializable {
    @XStreamAlias("notice")
    protected Notice notice;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}
