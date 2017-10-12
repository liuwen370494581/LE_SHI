package star.liuwen.com.le_shi.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuwen on 2017/7/31.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/CrashTest/log";
    private static final String FILE_NAME = "Crash";
    private static final String FILE_NAME_SUFFIX = ".txt";
    private static CrashHandler crashHandler = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static final boolean DEBUG = true;
    private Context mContext;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return crashHandler;
    }

    public void init(Context context) {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context;
    }

    //最重要的重写的方法在这里处理错误
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            dumpExceptionToSDcard(e);
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        uploadExceptionToserver();
        e.printStackTrace();
        if (mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(t, e);
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private void dumpExceptionToSDcard(Throwable e) throws PackageManager.NameNotFoundException {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (DEBUG) {
                Log.e("CrashHandrler", "dumpExceptionToSDcard: SDcard unmounted,skip dump exception");
                return;
            }
        }
        File dir = new File(PATH);
        if (!dir.exists())
            dir.mkdirs();
        long current = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(current));
        File file = new File(PATH + FILE_NAME + FILE_NAME_SUFFIX);
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            writer.print(time);
            dumpPhoneInfo(writer);
            writer.println();
            e.printStackTrace(writer);
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void dumpPhoneInfo(PrintWriter writer) throws PackageManager.NameNotFoundException {
        PackageManager manager = mContext.getPackageManager();
        PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
        writer.print("APP Version");
        writer.print(info.versionName);
        writer.print("_");
        writer.print(info.versionCode);
        writer.print("OS Version:");
        writer.print(Build.VERSION.RELEASE);
        writer.print("_");
        writer.print(Build.VERSION.SDK_INT);
        writer.print("Vendor:");//手机制造商
        writer.print(Build.MANUFACTURER);
        writer.print("Model: ");//手机型号
        writer.print(Build.MODEL);
        writer.print("CUP ABi");//CPU型号
        writer.print(Build.CPU_ABI);
    }

    private void uploadExceptionToserver() {
    }

}

