package com.hnyd.oschina.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.hnyd.oschina.AppManager;
import com.hnyd.oschina.R;
import com.hnyd.oschina.interf.BaseViewInterface;

import butterknife.ButterKnife;

/**
 * Created by tangk on 2016/9/13.
 */
public class BaseActivity extends AppCompatActivity implements BaseViewInterface {

    public static final String INTENT_ACTION_EXIT_APP = "INTENT_ACTION_EXIT_APP";
    private boolean _isVisible;
    private ProgressDialog _waitDialog;
    protected LayoutInflater mInflater;
    protected ActionBar mActionBar;

    private final String packageName4Umeng = this.getClass().getName();
    private Context mContext4Umeng;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.getAppManager().addActivity(this);
        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mActionBar = getSupportActionBar();
        mInflater = getLayoutInflater();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }
        //通过注解绑定控件
        ButterKnife.bind(this);

        init(savedInstanceState);
        initView();
        initData();
        _isVisible=true;
    }



    protected void init(Bundle savedInstanceState) {
    }

    protected void initActionBar(ActionBar mActionBar) {
        if (mActionBar == null)
            return;
        if (hasBackButton()) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        } else {
            mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            mActionBar.setDisplayUseLogoEnabled(false);
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                mActionBar.setTitle(titleRes);
            }
        }
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    protected boolean hasBackButton() {
        return false;
    }

    protected boolean hasActionBar() {
        return getSupportActionBar() != null;
    }

    protected void onBeforeSetContentLayout() {

    }

    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
