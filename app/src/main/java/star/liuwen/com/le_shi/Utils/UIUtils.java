package star.liuwen.com.le_shi.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.widget.Toast;

import star.liuwen.com.le_shi.Base.App;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2017/12/21 17:03
 * desc   :  获取应用环境和资源
 */
public class UIUtils {

    public static Toast mToast;

    public static void showToast(String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }

    public static void showToast(String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), "", duration);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 用于在线程中执行弹土司操作
     */
    public static void showToastSafely(final String msg) {
        UIUtils.getMainThreadHandler().post(new Runnable() {

            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);
                }
                mToast.setText(msg);
                mToast.show();
            }
        });
    }


    //得到整个应用的上下文
    public static Context getContext() {
        return App.getContext();
    }

    //得到Resources
    public static Resources getResources_() {
        return getContext().getResources();
    }

    //得到String.xml字符串
    public static String getString(int resId) {
        return getContext().getString(resId);
    }

    //得到Color.xml的颜色
    public static int getColor(int colorId) {
        return ContextCompat.getColor(getContext(), colorId);
    }

    //得到包名
    public static String getPackName() {
        return getContext().getPackageName();
    }

    /**
     * 得到主线程Handler
     *
     * @return
     */
    public static Handler getMainThreadHandler() {
        return App.getMainHandler();
    }

    /**
     * 得到主线程id
     *
     * @return
     */
    public static long getMainThreadId() {
        return App.getMainThreadId();
    }

    /**
     * 安全的执行一个任务
     *
     * @param task
     */
    public static void postTaskSafely(Runnable task) {
        int curThreadId = android.os.Process.myTid();
        // 如果当前线程是主线程
        if (curThreadId == getMainThreadId()) {
            task.run();
        } else {
            // 如果当前线程不是主线程
            getMainThreadHandler().post(task);
        }
    }

    /**
     * 延迟执行任务
     *
     * @param task
     * @param delayMillis
     */
    public static void postTaskDelay(Runnable task, int delayMillis) {
        getMainThreadHandler().postDelayed(task, delayMillis);
    }

    /**
     * 移除任务
     */
    public static void removeTask(Runnable task) {
        getMainThreadHandler().removeCallbacks(task);
    }

    /**
     * dip-->px
     */
    public static int dip2Px(int dip) {
        // px/dip = density;
        // density = dpi/160
        // 320*480 density = 1 1px = 1dp
        // 1280*720 density = 2 2px = 1dp

        float density = getResources_().getDisplayMetrics().density;
        int px = (int) (dip * density + 0.5f);
        return px;
    }

    /**
     * px-->dip
     */
    public static int px2dip(int px) {

        float density = getResources_().getDisplayMetrics().density;
        int dip = (int) (px / density + 0.5f);
        return dip;
    }

    /**
     * sp-->px
     */
    public static int sp2px(int sp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources_().getDisplayMetrics()) + 0.5f);
    }

}
