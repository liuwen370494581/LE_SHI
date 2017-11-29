package star.liuwen.com.le_shi.Base;

import android.app.ActivityManager;
import android.content.Context;
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


    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃日志记录
        String currentProcessName = getCurrentProcessName();
        Log.e(Config.TAG, "当前进程的名字" + currentProcessName);
        CrashHandler.getInstance().init(this);
        mRefWatcher = LeakCanary.install(this);


    }

    // 检测内存工具
    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context
                .getApplicationContext();
        return application.mRefWatcher;
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
