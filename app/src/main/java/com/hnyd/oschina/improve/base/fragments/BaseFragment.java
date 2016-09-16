package com.hnyd.oschina.improve.base.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;

import java.io.Serializable;

import butterknife.ButterKnife;

/**
 * fragment基础类
 * Created by tangk on 2016/9/14.
 */
public abstract class BaseFragment<T> extends Fragment {
    protected View mRoot;
    protected Bundle mBundle;
    private RequestManager mImgLoader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments();
        initBundle(mBundle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        if (mRoot != null) {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null)
                parent.removeView(mRoot);
        } else {
            mRoot = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mRoot);
            if (savedInstanceState != null)
                onRestartInstance(savedInstanceState);
            initWidget(mRoot);
            initData();
        }
        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RequestManager manager = mImgLoader;
        if (manager != null)
            manager.onDestroy();
        mRoot = null;
        mBundle = null;
    }

    protected void initData() {

    }

    protected void initWidget(View mRoot) {
    }

    protected void onRestartInstance(Bundle bundle) {

    }

    protected void initBundle(Bundle mBundle) {
    }

    protected abstract int getLayoutId();


    protected <T extends View> T findView(int viewId) {
        return (T) mRoot.findViewById(viewId);
    }

    protected <T extends Serializable> T getBundleSerializable(String key) {
        if (mBundle == null) {
            return null;
        }
        return (T) mBundle.getSerializable(key);
    }

//TODO


}
