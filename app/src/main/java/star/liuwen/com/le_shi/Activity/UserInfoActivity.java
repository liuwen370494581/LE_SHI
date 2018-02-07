package star.liuwen.com.le_shi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import star.liuwen.com.le_shi.Base.App;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Dao.DaoUserQuery;
import star.liuwen.com.le_shi.EventBus.C;
import star.liuwen.com.le_shi.EventBus.Event;
import star.liuwen.com.le_shi.EventBus.EventBusUtil;
import star.liuwen.com.le_shi.Model.UserModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideCircleTransform;
import star.liuwen.com.le_shi.Utils.GlideUtils;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/05 17:23
 * desc   :
 */
public class UserInfoActivity extends BaseActivity {

    private PopupWindow mAvatarPopupWindow;
    private View mZheZhaoView;
    public static final int Req_Nick = 100, Req_Address = 101, Req_Avatar = 102;
    private ImageView imgUserUrl;
    private String UserPhotoUrl, userName, userTel, userAddress;
    private TextView tvUserTel, tvNickName, tvAddress;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("个人中心");
        mZheZhaoView = getView(R.id.id_zhezhao_view);
        imgUserUrl = getView(R.id.id_avatar_img);
        tvUserTel = getView(R.id.id_tel_tv);
        tvNickName = getView(R.id.id_nick_tv);
        tvAddress = getView(R.id.id_address_tv);
    }

    @Override
    protected void initData() {
        userTel = App.getUserInfoTel();
        if (App.getUserInfo(userTel) != null) {
            UserModel temModel = App.getUserInfo(userTel);
            GlideUtils.loadImage(imgUserUrl, temModel.getUserPhoto(), R.mipmap.ic_default_gray_avatar, R.mipmap.ic_default_gray_avatar, new GlideCircleTransform(getActivityContext()));
            tvUserTel.setText(temModel.getUserTel());
            tvNickName.setText(temModel.getUserName() != null ? temModel.getUserName() : "");
            tvAddress.setText(temModel.getUserAddress() != null ? temModel.getUserAddress() : "");
        }
    }

    @Override
    protected void setListener() {

    }

    public void clickExitAccount(View view) {
        App.clearAll();
        openActivity(LoginActivity.class);
    }

    public void clickNickName(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(Config.INTENT_MODIFY, Req_Nick);
        openActivity(ModifyActivity.class, Req_Nick, bundle);
    }

    public void clickAddress(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(Config.INTENT_MODIFY, Req_Address);
        openActivity(ModifyActivity.class, Req_Address, bundle);
    }

    public void clickAvatar(View view) {
        View popupView = LayoutInflater.from(this).inflate(R.layout.layout_popup_window_choose_photo, null, false);
        popupView.findViewById(R.id.id_take_photo_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAvatarPopupWindow.dismiss();
                Bundle bundle = new Bundle();
                bundle.putInt("EChoosePhotoFrom", ToTakePhotoActivity.EChoosePhotoFrom.TakePhoto.ordinal());
                openActivity(ToTakePhotoActivity.class, Req_Avatar, bundle);
            }
        });

        popupView.findViewById(R.id.id_from_album_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAvatarPopupWindow.dismiss();
                Bundle bundle = new Bundle();
                bundle.putInt("EChoosePhotoFrom", ToTakePhotoActivity.EChoosePhotoFrom.Album.ordinal());
                openActivity(ToTakePhotoActivity.class, Req_Avatar, bundle);
            }
        });

        popupView.findViewById(R.id.id_cancel_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAvatarPopupWindow.dismiss();
            }
        });
        popupView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mAvatarPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
        mAvatarPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mZheZhaoView.setVisibility(View.GONE);
            }
        });
        mAvatarPopupWindow.showAtLocation(findViewById(R.id.id_exit_app_tv), Gravity.BOTTOM, 0, 0);
        mZheZhaoView.setVisibility(View.VISIBLE);
    }

    public void clickZheZhao(View view) {
        if (mAvatarPopupWindow != null && mAvatarPopupWindow.isShowing()) {
            mAvatarPopupWindow.dismiss();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == Req_Avatar) {
                String imgLocalPath = data.getStringExtra("ImgLocalPath");
                if (!TextUtils.isEmpty(imgLocalPath)) {
                    showLoadDialog("正在上传图片");
                    //上传到服务器中 代码可以写这里
                    if (App.getUserInfo(userTel) != null) {
                        UserModel model = App.getUserInfo(userTel);
                        model.setUserPhoto(imgLocalPath);
                        DaoUserQuery.update(model);
                        UIUtils.showToast("修改成功");
                        GlideUtils.loadImage(imgUserUrl, imgLocalPath, R.mipmap.ic_default_gray_avatar, R.mipmap.ic_default_gray_avatar, new GlideCircleTransform(getActivityContext()));
                        EventBusUtil.sendEvent(new Event(C.EventCode.UserURl, imgLocalPath));
                    }
                    hideLoadDialog();
                }
            } else if (requestCode == Req_Address) {
                tvAddress.setText(data.getExtras().getString(Config.INTENT_ADDRESS));

            } else if (requestCode == Req_Nick) {
                tvNickName.setText(data.getExtras().getString(Config.INTENT_NICK_NAME));
            }
        }
    }


}
