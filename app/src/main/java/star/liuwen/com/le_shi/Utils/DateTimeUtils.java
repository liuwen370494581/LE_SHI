package star.liuwen.com.le_shi.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuwen on 2017/7/28.
 */
public class DateTimeUtils {

    /**
     * 得到今天的日期
     *
     * @return
     */
    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 获取当前时间的Date对象
     *
     * @return
     */
    public static Date getCurrentDateObject() {
        return new Date(System.currentTimeMillis());
    }

    public static String getCurrentTime_Y_M_D_H_M_S() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

}
