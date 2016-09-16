package com.hnyd.oschina.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hnyd.oschina.R;
import com.hnyd.oschina.interf.BaseViewInterface;
import com.hnyd.oschina.widget.MyFragmentTabHost;

import butterknife.ButterKnife;

/**
 * Created by tangk on 2016/9/13.
 */
public class MainActivity extends AppCompatActivity implements BaseViewInterface {
    private CharSequence mTitle;
    private Context mContext4Umeng;
    private final String packageName4Umeng = "MainActivity";
    private String[] mTitles;
    MyFragmentTabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.mContext4Umeng = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        mTitle = getResources().getString(R.string.main_tab_name_news);
        mTitles = getResources().getStringArray(R.array.main_titles_arrays);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        initTabs();

    }

    @Override
    public void initData() {

    }

    private void initTabs() {
        MainTab[] tabs = MainTab.values();
    }
}