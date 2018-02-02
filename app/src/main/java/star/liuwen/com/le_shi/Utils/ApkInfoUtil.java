package star.liuwen.com.le_shi.Utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/31 14:33
 * desc   :
 */
public class ApkInfoUtil {

    /**
     * 获取本地apk文件的信息
     *
     * @param context
     * @param archiveFilePath apk文件的路径。如：/sdcard/download/xx.apk
     */
    public static Map<String, Object> getApkInfo(Context context, String archiveFilePath) {
        final PackageManager pm = context.getPackageManager();// 获取packagemanager
        PackageInfo info = pm.getPackageArchiveInfo(archiveFilePath, PackageManager.GET_ACTIVITIES);
        if (info != null) {
            ApplicationInfo appInfo = info.applicationInfo;
            if (appInfo != null) {
                Map<String, Object> map = new HashMap<String, Object>();
                String[] split = archiveFilePath.split("/");
                String appName = split[split.length - 1].split("_")[0];

                String packageName = appInfo.packageName;
                Drawable icon = pm.getApplicationIcon(appInfo);
                map.put("appName", appName);
                map.put("packageName", packageName);
                map.put("icon", icon);
                map.put("versionCode", info.versionCode);
                return map;
            }
        }
        return null;
    }

    public static String getVersionName(Context context) {
        String version = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            version = packInfo.versionName;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return version;
    }

    public static int getVersionCode(Context context) {
        int verCode = -1;
        try {
            verCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verCode;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        return packageInfo != null;
    }
}
