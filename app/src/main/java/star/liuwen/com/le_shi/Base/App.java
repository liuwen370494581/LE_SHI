package star.liuwen.com.le_shi.Base;

import android.support.multidex.MultiDexApplication;

import star.liuwen.com.le_shi.Utils.CrashHandler;

/**
 * Created by liuwen on 2017/10/12.
 */
public class App extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃日志记录
        CrashHandler.getInstance().init(this);
    }
}
