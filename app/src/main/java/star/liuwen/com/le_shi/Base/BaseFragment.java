package star.liuwen.com.le_shi.Base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;

import star.liuwen.com.le_shi.EventBus.Event;
import star.liuwen.com.le_shi.EventBus.EventBusUtil;
import star.liuwen.com.le_shi.Utils.ToastUtils;

/**
 * Created by liuwen on 2017/6/21.
 */
public abstract class BaseFragment extends Fragment {
    protected boolean isVisible;
    private boolean isPrepared;
    private static WeakReference<Context> context;
    protected Activity mActivity;//解决Fragment中getActivity的空指针问题
    //这个问题原因是大部分在于Fragment已经和Activity接触了关联 给Activity赋值 就可以解决此问题


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //设置系统的bar全部显示出来
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        context = new WeakReference<Context>(getActivity());
        setHasOptionsMenu(true);
        //加入EventBus
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }


    public static Context getFragmentContext() {
        return context.get();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    /**
     * 懒加载
     */
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }

        initData();
    }

    // 不可见
    protected void onInvisible() {

    }


    public abstract void initData();


    protected void openActivity(Class toActivity) {
        Intent intent = new Intent(getActivity(), toActivity);
        startActivity(intent);
    }

    protected void openActivity(Class toActivity, Bundle bundle) {
        Intent intent = new Intent(getActivity(), toActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void openActivity(Class toActivity, int reqCode) {
        Intent intent = new Intent(getActivity(), toActivity);
        startActivityForResult(intent, reqCode);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ToastUtils.removeToast();
        //取消注册
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
        //内存检测器
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }

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
