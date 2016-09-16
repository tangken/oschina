package com.hnyd.oschina.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangk on 2016/9/16.
 */
public interface ListEntity<T extends Entity> extends Serializable {
    public List<T> getList();
}
