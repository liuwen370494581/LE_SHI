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

    public static Calendar CALENDAR = Calendar.getInstance();

    public static String getCurrentTime_Today() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return sdf.format(new Date());
    }


    public static String formatDataToYMD(long timeMillis) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        CALENDAR.setTimeInMillis(timeMillis);
        return formatter.format(CALENDAR.getTime());
    }


    /**
     * 得到昨天的日期
     *
     * @return
     */
    public static String getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String yestoday = sdf.format(calendar.getTime());
        return yestoday;
    }

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
     * 根据Date对象获取当前是星期几
     *
     * @param date
     * @return
     */
    public static String getWeekOfDate(Context context, Date date) {
        String[] weekDays = {context.getString(R.string.sun), context.getString(R.string.mon), context.getString(R.string.thu), context.getString(R.string.wed), context.getString(R.string.thu),
                context.getString(R.string.fri), context.getString(R.string.sat)};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK);
        if ((w - 1) < 0)
            w = 0;
        return weekDays[w - 1];
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
