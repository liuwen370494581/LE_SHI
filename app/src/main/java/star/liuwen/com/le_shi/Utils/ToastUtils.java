package star.liuwen.com.le_shi.Utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by liuwen on 2017/6/22.
 */
public class ToastUtils {

    private static Toast mToast;

    public static void showToast(Context context, String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        } else {
            mToast.setText(message);
        }
        mToast.show();
    }

    public static void removeToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    public static void showCenterToast(Context context, String msg) {
        if (null != msg && !msg.equals("")) {
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(msg);
                mToast.setDuration(Toast.LENGTH_SHORT);
            }
            mToast.setGravity(Gravity.CENTER, 0, 0);
            if (context instanceof Activity && !((Activity) context).isFinishing())
                mToast.show();
        }
    }
}
