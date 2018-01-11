package star.liuwen.com.le_shi.Base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import star.liuwen.com.le_shi.Utils.CrashHandler;

/**
 * Created by liuwen on 2017/10/12.
 */
public class App extends MultiDexApplication {
    private RefWatcher mRefWatcher;
    //以下是属性应用用于整个应用程序 合理利用资源 减少资源浪费
    private static Context mContext;//上下文
    private static Thread mMainThread;//主线程
    private static long mMainThreadId;//主线程ID
    private static Looper mMainLooper;//循环队列
    private static Handler mHandler;//主线程handler


    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃日志记录
        String currentProcessName = getCurrentProcessName();
        Log.e(Config.TAG, "当前进程的名字" + currentProcessName);
        CrashHandler.getInstance().init(this);
        mRefWatcher = LeakCanary.install(this);


        //对全局属性赋值
        mContext=getApplicationContext();
        mMainThread=Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();

    }

    // 检测内存工具
    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context
                .getApplicationContext();
        return application.mRefWatcher;
    }


    //重启当前应用
    public static void restart(){
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        App.mContext = mContext;
    }


    public static Thread getMainThread() {
        return mMainThread;
    }

    public static void setMainThread(Thread mMainThread) {
        App.mMainThread = mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static void setMainThreadId(long mMainThreadId) {
        App.mMainThreadId = mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static void setMainThreadLooper(Looper mMainLooper) {
        App.mMainLooper = mMainLooper;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }

    public static void setMainHandler(Handler mHandler) {
        App.mHandler = mHandler;
    }



    private String getCurrentProcessName() {
        String currentProcessName = "";
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                currentProcessName = processInfo.processName;
                break;
            }
        }
        return currentProcessName;
    }

}
