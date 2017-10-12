package star.liuwen.com.le_shi.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
