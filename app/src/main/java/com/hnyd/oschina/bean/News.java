package com.hnyd.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by tangk on 2016/9/16.
 */

@SuppressWarnings("serial")
@XStreamAlias("news")
public class News extends Entity{
    public final static int NEWSTYPE_NEWS = 0x00;//0 新闻
    public final static int NEWSTYPE_SOFTWARE = 0x01;//1 软件
    public final static int NEWSTYPE_POST = 0x02;//2 帖子
    public final static int NEWSTYPE_BLOG = 0x03;//3 博客
}
