package star.liuwen.com.le_shi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import star.liuwen.com.le_shi.Activity.AboutActivity;
import star.liuwen.com.le_shi.Activity.HelpActivity;
import star.liuwen.com.le_shi.Activity.ShareActivity;
import star.liuwen.com.le_shi.Activity.UserInfoActivity;
import star.liuwen.com.le_shi.Activity.WatchHistoryActivity;
import star.liuwen.com.le_shi.Base.App;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.EventBus.C;
import star.liuwen.com.le_shi.EventBus.Event;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideCircleTransform;
import star.liuwen.com.le_shi.Utils.GlideUtils;

/**
 * Created by liuwen on 2017/10/12.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private ImageView imgUserPhoto;
    private TextView tvMall, tvWatchRecode, tvUpdate, tvShare, tvHelp, tvAbout, tvTel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        init();
        return view;
    }

    private void init() {
        String userTel = App.getUserInfoTel();
        if (App.getUserInfo(userTel) != null) {
            loadImgUserUrl(App.getUserInfo(userTel).getUserPhoto());
            tvTel.setText(userTel);
        }
    }

    private void initView(View view) {
        imgUserPhoto = (ImageView) view.findViewById(R.id.id_avatar_img);
        tvMall = (TextView) view.findViewById(R.id.id_mall_tv);
        tvWatchRecode = (TextView) view.findViewById(R.id.id_local_tv);
        tvUpdate = (TextView) view.findViewById(R.id.id_update_tv);
        tvShare = (TextView) view.findViewById(R.id.id_share_tv);
        tvHelp = (TextView) view.findViewById(R.id.id_help_tv);
        tvAbout = (TextView) view.findViewById(R.id.id_about_tv);
        tvTel = (TextView) view.findViewById(R.id.id_tel_tv);
        imgUserPhoto.setOnClickListener(this);
        tvMall.setOnClickListener(this);
        tvWatchRecode.setOnClickListener(this);
        tvUpdate.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tvHelp.setOnClickListener(this);
        tvAbout.setOnClickListener(this);
    }

    //懒加载
    @Override
    public void initData() {

    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    private void loadImgUserUrl(String url) {
        GlideUtils.loadImage(imgUserPhoto, url, R.mipmap.ic_default_gray_avatar,
                R.mipmap.ic_default_gray_avatar, new GlideCircleTransform(getFragmentContext()));
    }

    @Override
    public void onEventBusCome(Event event) {
        super.onEventBusCome(event);
        switch (event.getCode()) {
            case C.EventCode.UserURl:
                loadImgUserUrl(event.getData().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (imgUserPhoto == view) {
            openActivity(UserInfoActivity.class, imgUserPhoto, R.string.transition_name);
        } else if (tvMall == view) {
        } else if (tvWatchRecode == view) {
            openActivity(WatchHistoryActivity.class);
        } else if (tvUpdate == view) {
        } else if (tvShare == view) {
            openActivity(ShareActivity.class);
        } else if (tvHelp == view) {
            openActivity(HelpActivity.class);
        } else if (tvAbout == view) {
            openActivity(AboutActivity.class);
        }
    }

}
