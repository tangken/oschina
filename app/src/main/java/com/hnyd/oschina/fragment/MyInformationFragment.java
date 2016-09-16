package com.hnyd.oschina.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.hnyd.oschina.AppContext;
import com.hnyd.oschina.R;
import com.hnyd.oschina.base.BaseFragment;
import com.hnyd.oschina.bean.MyInformation;
import com.hnyd.oschina.bean.User;
import com.hnyd.oschina.cache.CacheManager;
import com.hnyd.oschina.empty.EmptyLayout;
import com.hnyd.oschina.improve.widget.SolarSystemView;
import com.hnyd.oschina.util.XmlUtils;
import com.hnyd.oschina.widget.AvatarView;
import com.hnyd.oschina.widget.BaseView;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;

import butterknife.Bind;
import cz.msebera.android.httpclient.Header;

/**
 * 登录用户中心页面
 * Created by tangk on 2016/9/14.
 */
public class MyInformationFragment extends BaseFragment {
    private static BaseView mMesCount;
    @Bind(R.id.iv_avatar)
    AvatarView mIvAvatar;
    @Bind(R.id.iv_gender)
    ImageView mIvGender;
    @Bind(R.id.tv_name)
    TextView mTvName;

    @Bind(R.id.tv_score)
    TextView mTvScore;
    @Bind(R.id.tv_favorite)
    TextView mTvFavorite;
    @Bind(R.id.tv_following)
    TextView mTvFollowing;
    @Bind(R.id.tv_follower)
    TextView mTvFans;
    @Bind(R.id.tv_mes)
    View mMesView;
    @Bind(R.id.error_layout)
    EmptyLayout mErrorLayout;
    @Bind(R.id.iv_qr_code)
    ImageView mQrCode;
    @Bind(R.id.ll_user_container)
    View mUserContainer;
    @Bind(R.id.rl_user_unlogin)
    View mUserUnLogin;
  //  @Bind(R.id.view_solar_system)
    SolarSystemView mSolarSystem;
    @Bind(R.id.rl_user_center)
    LinearLayout mLayUserCenter;
    @Bind(R.id.lay_about_info)
    LinearLayout mLayAboutInfo;
    private boolean mIsWatingLogin;

    private User mInfo;
    private final AsyncHttpResponseHandler mHandler = new AsyncHttpResponseHandler() {

        @Override
        public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
            try {
                mInfo = XmlUtils.toBean(MyInformation.class,
                        new ByteArrayInputStream(arg2)).getUser();
                if (mInfo!=null){
                    fillUI();
                    AppContext.getInstance().updateUserInfo(mInfo);
                    new SaveCacheTask(getActivity(), mInfo, getCacheKey())
                            .execute();
                }
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable
                error) {

        }
    };
    private class SaveCacheTask extends AsyncTask<Void, Void, Void> {
        private final WeakReference<Context> mContext;
        private final Serializable seri;
        private final String key;

        private SaveCacheTask(Context context, Serializable seri, String key) {
            mContext = new WeakReference<>(context);
            this.seri = seri;
            this.key = key;
        }

        @Override
        protected Void doInBackground(Void... params) {
            CacheManager.saveObject(mContext.get(), seri, key);
            return null;
        }
    }
}
