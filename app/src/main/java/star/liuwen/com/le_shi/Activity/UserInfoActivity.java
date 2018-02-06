package star.liuwen.com.le_shi.Activity;

import android.view.View;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/05 17:23
 * desc   :
 */
public class UserInfoActivity extends BaseActivity {
    @Override
    protected int setLayoutRes() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("个人中心");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    public void clickExitAccount(View view) {

    }
}
