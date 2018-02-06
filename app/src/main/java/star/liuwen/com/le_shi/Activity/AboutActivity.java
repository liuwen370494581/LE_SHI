package star.liuwen.com.le_shi.Activity;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/05 17:20
 * desc   :
 */
public class AboutActivity extends BaseActivity {
    @Override
    protected int setLayoutRes() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("关于");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
