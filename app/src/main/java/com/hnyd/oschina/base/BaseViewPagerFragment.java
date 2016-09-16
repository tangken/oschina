package com.hnyd.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hnyd.oschina.R;
import com.hnyd.oschina.adapter.ViewPageFragmentAdapter;
import com.hnyd.oschina.empty.EmptyLayout;
import com.hnyd.oschina.widget.PagerSlidingTabStrip;

/**
 * 带有导航条的基类
 * Created by tangk on 2016/9/13.
 */
public abstract class BaseViewPagerFragment extends BaseFragment {
    protected PagerSlidingTabStrip mTabStrip;
    protected ViewPager mViewPager;
    protected ViewPageFragmentAdapter mTabsAdapter;
    protected EmptyLayout mErrorLayout;
    protected View mRoot;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        if (mRoot == null) {
            View root = inflater.inflate(R.layout.base_viewpage_fragment, null);
            mTabStrip = (PagerSlidingTabStrip) root.findViewById(R.id.pager_tabstrip);
            mViewPager = (ViewPager) root.findViewById(R.id.pager);
            mErrorLayout = (EmptyLayout) root.findViewById(R.id.error_layout);
            mTabsAdapter = new ViewPageFragmentAdapter(getChildFragmentManager(), mTabStrip,
                    mViewPager);

            setScreenPageLimit();
            onSetupTabAdapter(mTabsAdapter);
            mRoot = root;
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            int pos = savedInstanceState.getInt("position");
            mViewPager.setCurrentItem(pos, true);
        }
    }

    protected abstract void onSetupTabAdapter(ViewPageFragmentAdapter mTabsAdapter);


    protected void setScreenPageLimit() {
    }
}
