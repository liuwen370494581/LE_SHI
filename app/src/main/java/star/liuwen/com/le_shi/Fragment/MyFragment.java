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
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/12.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private ImageView imgUserPhoto;
    private TextView tvMall, tvWatchRecode, tvUpdate, tvShare, tvHelp, tvAbout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        imgUserPhoto = (ImageView) view.findViewById(R.id.id_avatar_img);
        tvMall = (TextView) view.findViewById(R.id.id_mall_tv);
        tvWatchRecode = (TextView) view.findViewById(R.id.id_local_tv);
        tvUpdate = (TextView) view.findViewById(R.id.id_update_tv);
        tvShare = (TextView) view.findViewById(R.id.id_share_tv);
        tvHelp = (TextView) view.findViewById(R.id.id_help_tv);
        tvAbout = (TextView) view.findViewById(R.id.id_about_tv);
        imgUserPhoto.setOnClickListener(this);
        tvMall.setOnClickListener(this);
        tvWatchRecode.setOnClickListener(this);
        tvUpdate.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tvHelp.setOnClickListener(this);
        tvAbout.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        if (imgUserPhoto == view) {
            openActivity(UserInfoActivity.class, imgUserPhoto, R.string.transition_name);
        } else if (tvMall == view) {
        } else if (tvWatchRecode == view) {

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
