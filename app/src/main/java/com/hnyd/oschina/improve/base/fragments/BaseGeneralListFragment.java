package com.hnyd.oschina.improve.base.fragments;

import com.hnyd.oschina.interf.OnTabReselectListener;

/**
 * Created by tangk on 2016/9/14.
 */
public abstract class BaseGeneralListFragment<T> extends BaseListFragment<T> implements
        OnTabReselectListener {

    @Override
    public void onTabReselect() {

        if (mListView != null) {
            mListView.setSelection(0);
            mRefreshLayout.setRefreshing(true);
           // onRefreshing();
        }

    }
}
