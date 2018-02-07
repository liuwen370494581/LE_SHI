package star.liuwen.com.le_shi.Activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;

import star.liuwen.com.le_shi.Base.App;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Dao.DaoUserQuery;
import star.liuwen.com.le_shi.Listener.onRightListener;
import star.liuwen.com.le_shi.Model.UserModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/06 16:26
 * desc   :
 */
public class ModifyActivity extends BaseActivity {
    private EditText mEditText;
    private int type;
    private String nickName = "", address = "";
    private UserModel mUserModel;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_modify;
    }

    @Override
    protected void initView() {
        showLeftView();
        mEditText = getView(R.id.id_nick_tv);
        String tel = App.getUserInfoTel();
        if (App.getUserInfo(tel) != null) {
            mUserModel = App.getUserInfo(tel);
            nickName = mUserModel.getUserName();
            address = mUserModel.getUserAddress();
        }
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra(Config.INTENT_MODIFY, 0);
        if (type == UserInfoActivity.Req_Address) {
            setCenterText("编辑地址");
            mEditText.setHint(address);
        } else if (type == UserInfoActivity.Req_Nick) {
            setCenterText("编辑昵称");
            mEditText.setHint(nickName);
        } else {
            finish();
        }
    }

    @Override
    protected void setListener() {
        setRightText("保存", new onRightListener() {
            @Override
            public void rightTextListener() {
                saveEditContent();
            }
        });
    }


    private void saveEditContent() {
        String editContent = mEditText.getText().toString();
        if (TextUtils.isEmpty(editContent)) {
            UIUtils.showToast("修改的内容不能为空");
            return;
        }
        Intent intent = new Intent();
        switch (type) {
            case UserInfoActivity.Req_Address:
                intent.putExtra(Config.INTENT_ADDRESS, editContent);
                mUserModel.setUserAddress(editContent);
                DaoUserQuery.update(mUserModel);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case UserInfoActivity.Req_Nick:
                intent.putExtra(Config.INTENT_NICK_NAME, editContent);
                mUserModel.setUserName(editContent);
                DaoUserQuery.update(mUserModel);
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }

    }

}
