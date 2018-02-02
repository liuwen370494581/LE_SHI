package star.liuwen.com.le_shi.Activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Dao.DaoUserQuery;
import star.liuwen.com.le_shi.MainActivity;
import star.liuwen.com.le_shi.Model.UserModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.KeyboardUtil;
import star.liuwen.com.le_shi.Utils.SharedPreferencesUtil;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/26 15:28
 * desc   : 登陆页面
 */
public class LoginActivity extends BaseActivity {
    private AutoCompleteTextView mAutoTel;
    private EditText mEditPassword;
    private ImageView imgTelClear, imgPassWordClear;
    private TextView tvVersion;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setCenterText("登陆");
        mAutoTel = getView(R.id.id_login_tel_ac_tv);
        mEditPassword = getView(R.id.id_psw_et);
        imgTelClear = getView(R.id.id_tel_clear_img);
        imgPassWordClear = getView(R.id.id_psw_clear_img);
        tvVersion = getView(R.id.id_version_tv);
    }

    private String commGetTxt(EditText editText) {
        return editText.getText().toString().trim();
    }

    public void onClickLogin(View view) {
        startLogin();
    }


    public void onClickReg(View view) {
        openActivity(RegisterActivity.class);
    }

    private void startLogin() {
        String txtTel = commGetTxt(mAutoTel);
        String txtPassword = commGetTxt(mEditPassword);
        if (TextUtils.isEmpty(txtTel)) {
            UIUtils.showToast("电话不能为空");
            return;
        }

        if (TextUtils.isEmpty(txtPassword)) {
            UIUtils.showToast("密码不能为空");
            return;
        }

        List<UserModel> temUserList = DaoUserQuery.query();
        if (temUserList != null && temUserList.size() != 0) {
            for (UserModel userModel : temUserList) {
                if (!userModel.getUserTel().equals(txtTel)) {
                    UIUtils.showToast("此号码未被注册");
                    return;
                }

                if (!userModel.getUserPassword().equals(txtPassword)) {
                    UIUtils.showToast("密码错误,请重新输入");
                    return;
                }
            }
        }
        SharedPreferencesUtil.setStringPreferences(getActivityContext(), Config.SHARD_USER_TEL, txtTel);
        SharedPreferencesUtil.setStringPreferences(getActivityContext(), Config.SHARD_USER_PASSWORD, txtPassword);
        KeyboardUtil.hideInputMethodWindow(this, tvVersion);
        openActivity(MainActivity.class);
        finish();

    }

    public void onClickTelClearImg(View view) {
        mAutoTel.setText("");
    }

    public void onClickPswClearImg(View view) {
        mEditPassword.setText("");
    }

    @Override
    protected void initData() {
        mAutoTel.setText(SharedPreferencesUtil.getStringPreferences(getActivityContext(), Config.SHARD_USER_TEL, ""));
        mEditPassword.setText(SharedPreferencesUtil.getStringPreferences(getActivityContext(), Config.SHARD_USER_PASSWORD, ""));
        if (!SharedPreferencesUtil.getStringPreferences(getActivityContext(), Config.SHARD_USER_TEL, "").isEmpty() &&
                !SharedPreferencesUtil.getStringPreferences(getActivityContext(), Config.SHARD_USER_PASSWORD, "").isEmpty()) {
            startLogin();
        }
    }

    @Override
    protected void setListener() {
        mAutoTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence sequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
                imgTelClear.setVisibility(mAutoTel.getText().toString().length() != 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mEditPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence sequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
                imgPassWordClear.setVisibility(mEditPassword.getText().toString().length() != 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
