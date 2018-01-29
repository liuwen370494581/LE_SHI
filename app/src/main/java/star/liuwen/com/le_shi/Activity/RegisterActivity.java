package star.liuwen.com.le_shi.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.NetUtil;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/26 15:28
 * desc   : 注册页面
 */
public class RegisterActivity extends BaseActivity {
    private EditText mEdTelCode, mEdTel, mEdPassWord, mEdPassWord_02;
    private EventHandler handler;

    private final int ReqCode_AreaCode = 100;
    private TextView mTvAreaCode, mTvAgree;
    private CheckBox mCheckBox;
    private Button btnSmsSend;
    private TimeCount mTimerCounter;
    private String txtTel, txtAreaCode;


    @Override
    protected int setLayoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mEdTel = getView(R.id.id_tel_et);
        mEdTelCode = getView(R.id.id_sms_code_et);
        mTvAreaCode = getView(R.id.id_area_code_tv);
        mEdPassWord = getView(R.id.id_first_psw_et);
        mEdPassWord_02 = getView(R.id.id_psw_again_et);
        mCheckBox = getView(R.id.id_cb);
        mTvAgree = getView(R.id.reg_agreement);
        btnSmsSend = getView(R.id.id_send_sms_code_btn);
    }

    @Override
    protected void initData() {
        handler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                UIUtils.showToast("注册成功");
                                openActivity(LoginActivity.class);
                                finish();
                            }
                        });
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        //获取验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                UIUtils.showToast("验证码已发送");
                            }
                        });
                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                    Throwable throwable = (Throwable) data;
                    try {
                        JSONObject obj = new JSONObject(throwable.getMessage());
                        final String des = obj.optString("detail");
                        if (!TextUtils.isEmpty(des)) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    UIUtils.showToast("注册失败" + des);
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        UIUtils.showToast("注册失败,解析错误");
                    }
                }
            }
        };
        SMSSDK.registerEventHandler(handler);
    }


    @Override
    protected void setListener() {

    }

    public void play(View view) {
        //获取验证码
        SMSSDK.getVerificationCode("86", "18229971814");
    }

//    public void tijiao(View view) {
//        String number = mEdTelCode.getText().toString();
//        SMSSDK.submitVerificationCode("86", "18229971814", number);
//    }


    public void toGetSmsCode(View view) {
        txtTel = commGetTxt(mEdTel);
        txtAreaCode = mTvAreaCode.getText().toString();
        if (TextUtils.isEmpty(txtTel)) {
            UIUtils.showToast("请输入电话号码");
            return;
        }

        SMSSDK.getVerificationCode(txtAreaCode, txtTel);
        mTimerCounter = new TimeCount(60000, 1000, btnSmsSend);
        mTimerCounter.start();
    }

    public void toReg(View view) {
        txtTel = commGetTxt(mEdTel);
        txtAreaCode = mTvAreaCode.getText().toString();
        String txtSmsCode = commGetTxt(mEdTelCode);
        String edPassword = commGetTxt(mEdPassWord);
        String edPassword_02 = commGetTxt(mEdPassWord_02);
        if (TextUtils.isEmpty(txtTel)) {
            UIUtils.showToast("请输入电话号码");
            return;
        }
        if (TextUtils.isEmpty(txtSmsCode)) {
            UIUtils.showToast("请输入验证码");
            return;
        }
        if (TextUtils.isEmpty(edPassword)) {
            UIUtils.showToast("请输入密码");
            return;
        }

        if (TextUtils.isEmpty(edPassword_02)) {
            UIUtils.showToast("请再次输入密码");
            return;
        }
        if (edPassword.length() < 6 || edPassword.length() < 6) {
            UIUtils.showToast("密码不能小于6位");
            return;
        }
        if (!edPassword.equals(edPassword)) {
            UIUtils.showToast("两次密码输入不一致");
            return;
        }
        if (NetUtil.checkNet(getActivityContext())) {
            //提交注册
            SMSSDK.submitVerificationCode(txtAreaCode, txtTel, txtSmsCode);
        }
    }

    private String commGetTxt(EditText editText) {
        return editText.getText().toString().trim();
    }

    public void toAreaSelection(View view) {
        openActivity(AreaSelectionActivity.class, ReqCode_AreaCode);
    }


    class TimeCount extends CountDownTimer {
        Button mButton = null;

        public TimeCount(long millisInFuture, long countDownInterval, Button btn) {
            super(millisInFuture, countDownInterval);
            this.mButton = btn;
            mButton.setClickable(false);
            mButton.setBackgroundResource(R.drawable.rounded_rectangle_background_light_gray);
            mButton.setTextColor(ContextCompat.getColor(getActivityContext(), R.color.gray2));
            mButton.getBackground().setAlpha(100);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mButton.setText(String.format(getString(R.string.get_ver_code_again), millisUntilFinished / 1000 + ""));
        }

        @Override
        public void onFinish() {
            mButton.setText(getString(R.string.get_again));
            mButton.setBackgroundResource(R.drawable.rounded_rectangle_background_blue);
            mButton.setTextColor(ContextCompat.getColor(getActivityContext(), R.color.white));
            mButton.setClickable(true);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == ReqCode_AreaCode) {
                String areaCode = data.getStringExtra(Config.INTENT_AREA_CODE);
                mTvAreaCode.setText("+" + areaCode);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }
}
