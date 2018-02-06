package star.liuwen.com.le_shi.Activity;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/05 17:18
 * desc   :
 */
public class HelpActivity extends BaseActivity {
    @Override
    protected int setLayoutRes() {
        return R.layout.activity_help;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("帮助");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
