package star.liuwen.com.le_shi.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import star.liuwen.com.le_shi.EventBus.Event;
import star.liuwen.com.le_shi.EventBus.EventBusUtil;
import star.liuwen.com.le_shi.Utils.ToastUtils;
import star.liuwen.com.le_shi.View.LoadingProgressDialog;

/**
 * Created by liuwen on 2017/6/21.
 */
public abstract class BaseFragment extends Fragment {

    private LoadingProgressDialog mLoadingDialog;
    public Context mContext;
    protected boolean isVisible;
    private boolean isPrepared;

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
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        //加入EventBus
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
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


    public void showLoadingDialog(String loadingText, boolean isCanCancel, LoadingProgressDialog.ILoadingDialogListener listener) {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingProgressDialog(getActivity(), loadingText);
            mLoadingDialog.show();
            if (isCanCancel) {
                mLoadingDialog.setCannotCancel();
                mLoadingDialog.setListener(listener);
            }
        }
    }

    public void hideLoadingDialog() {
        if (null != mLoadingDialog && mLoadingDialog.isShowing()) {
            mLoadingDialog.closeDialog();
        }
    }

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
