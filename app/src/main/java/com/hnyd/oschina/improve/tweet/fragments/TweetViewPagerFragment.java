package com.hnyd.oschina.improve.tweet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hnyd.oschina.R;
import com.hnyd.oschina.adapter.ViewPageFragmentAdapter;
import com.hnyd.oschina.base.BaseViewPagerFragment;

/**
 * Created by tangk on 2016/9/14.
 */
public class TweetViewPagerFragment extends BaseViewPagerFragment{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[]title=getResources().getStringArray(R.array.tweets_viewpage_arrays);
        adapter.addTab(title[0], "tweet_new", TweetFragment.class,
                getBundle(TweetFragment.CATEGORY_TYPE, TweetFragment.TWEET_TYPE_NEW));
        adapter.addTab(title[1], "tweet_hot", TweetFragment.class,
                getBundle(TweetFragment.CATEGORY_TYPE, TweetFragment.TWEET_TYPE_HOT));
        adapter.addTab(title[2], "tweet_mine", TweetFragment.class,
                getBundle(TweetFragment.CATEGORY_USER, 0));

    }
}
