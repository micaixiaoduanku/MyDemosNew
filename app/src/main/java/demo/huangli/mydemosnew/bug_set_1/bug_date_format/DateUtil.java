package demo.huangli.mydemosnew.bug_set_1.bug_date_format;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat DATE_FORMAT_DATE_TIME =
            new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static final SimpleDateFormat DATE_FORMAT_TIME = new SimpleDateFormat("HH:mm");

    public static final SimpleDateFormat DATE_FORMAT_DATE_CHINESE =
            new SimpleDateFormat("yyyy年MM月dd日");

    public static final SimpleDateFormat DATA_FORMAT_MONTH_DATA_HOURS =
            new SimpleDateFormat("MM月dd日 HH:mm");


    /**
     * long time to string
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    public static Date strToDate(String dateStr) {
        Date date = null;
        try {
            if (!TextUtils.isEmpty(dateStr)) {
                date = DATE_FORMAT_DATE.parse(dateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化时间显示
     *
     * @param time 时间 (秒)
     * @return 字符串 格式为 HH:mm:ss
     */
    public static String formatTimeValue(int time) {
        time = time < 0 ? 0 : time;
        int i = time;
        // i /= 1000;//毫秒的转换
        int minute = i / 60;
        int hour = minute / 60;
        int second = i % 60;
        minute %= 60;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", hour, minute, second);
    }

    public static String time2sss(long time) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.sss");
        Date currentTime = new Date();
        currentTime.setTime(time);
        String stime = sDateFormat.format(currentTime);
        return stime;
    }

    public static String time2ss(long time) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        currentTime.setTime(time);
        String stime = sDateFormat.format(currentTime);
        return stime;
    }

    public static String formateCountDownTime(long millisUntilFinished) {
        long minute = (millisUntilFinished % (60 * 60 * 1000)) / (60 * 1000);
        long second = (millisUntilFinished % (60 * 1000)) / 1000;
        long millSecond = (millisUntilFinished % 1000);
        StringBuilder stringBuilder = new StringBuilder();
        if (minute < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(minute);
        stringBuilder.append(":");
        if (second < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(second);
        stringBuilder.append(":");
        stringBuilder.append(millSecond);
        return stringBuilder.toString();
    }

    /**
     * 将String格式的日期 转出相应的时间戳
     * String time="1970-01-06 11:45:55"  ==》445555000
     */
    public static long fromateDateStringToLong(String dateStr, SimpleDateFormat simpleDateFormat) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (null != date) {
            return date.getTime();
        } else {
            return 0;
        }
    }

}
