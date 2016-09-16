package com.hnyd.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by tangk on 2016/9/16.
 */
public class MyInformation {

    @XStreamAlias("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
