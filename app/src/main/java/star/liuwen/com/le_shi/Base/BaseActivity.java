package star.liuwen.com.le_shi.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import star.liuwen.com.le_shi.EventBus.Event;
import star.liuwen.com.le_shi.EventBus.EventBusUtil;
import star.liuwen.com.le_shi.Listener.OnCommonBarListener;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.ActivityKiller;
import star.liuwen.com.le_shi.Utils.ToastUtils;


/**
 * Created by liuwen on 2017/6/21.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private LinearLayout lyCommonBar, lyRightBar;
    private TextView mTvCenter;//toobar中间文字
    private App mApp;
    private Context mActivityContext, mAppContext;//尽量地采用 Application Context 避免内存泄漏

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //设置系统的bar全部显示出来
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        initView();
        initData();
        setListener();
        mActivityContext = this;
        mAppContext = getApplicationContext();
        //加入EventBus
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
//        //大于android 4.4版本才有这种沉侵式状态
//        StatusBarUtils.setWindowStatusBarColor(this, R.color.bg_color);
        ActivityKiller.getInstance().addActivity(this);
    }

    public App getApp() {
        if (null == mApp) {
            mApp = (App) getApplication();
        }
        return mApp;
    }

    protected Context getActivityContext() {
        if (null == mActivityContext) {
            mActivityContext = this;
        }
        return mActivityContext;
    }

    protected Context getAppContext() {
        if (null == mAppContext) {
            mAppContext = getApplicationContext();
        }
        return mAppContext;
    }

    protected abstract int setLayoutRes();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setListener();


    public <T extends View> T getView(int viewId) {
        return (T) this.findViewById(viewId);
    }

    protected void openActivity(Class toActivity) {
        Intent intent = new Intent(this, toActivity);
        startActivity(intent);
    }

    protected void openActivity(Class toActivity, Bundle bundle) {
        Intent intent = new Intent(this, toActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void closeActivity() {
        finish();
    }

    protected void openActivity(Class toActivity, int reqCode) {
        Intent intent = new Intent(this, toActivity);
        startActivityForResult(intent, reqCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityKiller.getInstance().removeActivity(this);
        ToastUtils.removeToast();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
        //内存检测器
        RefWatcher refWatcher = App.getRefWatcher(this);
        refWatcher.watch(this);
    }

    protected void showLeftView() {
        lyCommonBar = getView(R.id.back_view);
        if (lyCommonBar == null) {
            return;
        }
        lyCommonBar.setVisibility(View.VISIBLE);
        lyCommonBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void setRightListener(final OnCommonBarListener listener) {
        lyRightBar = getView(R.id.right_view);
        if (lyRightBar == null) {
            return;
        }
        lyRightBar.setVisibility(View.VISIBLE);
        lyRightBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onRightChoiceListener();
                }
            }
        });
    }

    protected void setCenterText(String str) {
        mTvCenter = getView(R.id.title);
        if (mTvCenter == null) {
            return;
        }
        mTvCenter.setText(str);
        mTvCenter.setVisibility(View.VISIBLE);
    }


    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }



}
