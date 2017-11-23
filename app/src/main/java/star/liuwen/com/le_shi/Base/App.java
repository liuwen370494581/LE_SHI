package star.liuwen.com.le_shi.Base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

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
        CrashHandler.getInstance().init(this);
        mRefWatcher = LeakCanary.install(this);
    }

    // 检测内存工具
    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context
                .getApplicationContext();
        return application.mRefWatcher;
    }


}
