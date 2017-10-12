package star.liuwen.com.le_shi.Utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by liuwen on 2017/9/8.
 */
public class ServiceUtils {

    public static boolean isServiceRunning(Context context, String className) {

        boolean isRunning = false;
        if (context == null) {
            return isRunning;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceInfoList = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (!(serviceInfoList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceInfoList.size(); i++) {
            if (serviceInfoList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }

        return isRunning;

    }
}
