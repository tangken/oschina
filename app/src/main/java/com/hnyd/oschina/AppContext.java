package com.hnyd.oschina;

import com.hnyd.oschina.base.BaseApplication;
import com.hnyd.oschina.bean.User;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

import java.util.Properties;

/**
 * 全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 * Created by tangk on 2016/9/13.
 */
public class AppContext extends BaseApplication {
    public static final int PAGER_SIZE = 20;//默认分页大小
    private static AppContext instance;
    private int loginUp;
    private boolean login;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
//        initLogin();
//
//        UIHelper.sendBroadcastForNotice(this);
    }

    private void init() {
        //初始化网络请求
        AsyncHttpClient client = new AsyncHttpClient();
        PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
        client.setCookieStore(myCookieStore);

    }
    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }

    public boolean containsProperty(String key) {
        Properties props = getProperties();
        return props.containsKey(key);
    }

    public void setProperties(Properties ps) {
        AppConfig.getAppConfig(this).set(ps);
    }

    public Properties getProperties() {
        return AppConfig.getAppConfig(this).get();
    }

    public void setProperty(String key, String value) {
        AppConfig.getAppConfig(this).set(key, value);
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @SuppressWarnings("serial")
    public void updateUserInfo(final User user) {
        setProperties(new Properties() {
            {
                setProperty("user.name", user.getName());
                setProperty("user.face", user.getPortrait());// 用户头像-文件名
                setProperty("user.followers",
                        String.valueOf(user.getFollowers()));
                setProperty("user.fans", String.valueOf(user.getFans()));
                setProperty("user.score", String.valueOf(user.getScore()));
                setProperty("user.favoritecount",
                        String.valueOf(user.getFavoritecount()));
                setProperty("user.gender", String.valueOf(user.getGender()));
            }
        });
    }
}
