package com.hnyd.oschina.viewpagerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hnyd.oschina.R;
import com.hnyd.oschina.adapter.ViewPageFragmentAdapter;
import com.hnyd.oschina.base.BaseListFragment;
import com.hnyd.oschina.base.BaseViewPagerFragment;
import com.hnyd.oschina.bean.BlogList;
import com.hnyd.oschina.bean.NewsList;
import com.hnyd.oschina.improve.general.fragments.BlogFragment;
import com.hnyd.oschina.improve.general.fragments.EventFragment;
import com.hnyd.oschina.improve.general.fragments.NewsFragment;
import com.hnyd.oschina.improve.general.fragments.QuestionFragment;

/**
 * 综合Tab界面
 * Created by tangk on 2016/9/13.
 */
public class GeneralViewPagerFragment extends BaseViewPagerFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[] tilte = getResources().getStringArray(R.array.general_viewpage_arrays);
        adapter.addTab(tilte[0], "new", NewsFragment.class, getBundle(NewsList.CATALOG_ALL));
        adapter.addTab(tilte[1], "latest_blog", BlogFragment.class, getBundle(NewsList
                .CATALOG_WEEK));
        adapter.addTab(tilte[2], "question", QuestionFragment.class, getBundle(BlogList
                .CATALOG_LATEST));
        adapter.addTab(tilte[3], "activity", EventFragment.class, getBundle(BlogList
                .CATALOG_RECOMMEND));
    }

    private Bundle getBundle(int newType) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, newType);
        return bundle;
    }
  
}
