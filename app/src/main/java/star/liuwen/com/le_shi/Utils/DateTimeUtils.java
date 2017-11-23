package star.liuwen.com.le_shi.Utils;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import star.liuwen.com.le_shi.R;

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

}
