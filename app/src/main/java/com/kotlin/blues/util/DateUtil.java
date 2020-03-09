package com.kotlin.blues.util;

import android.net.Uri;
import android.text.format.Time;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

public class DateUtil {
    // 短日期格式
    public static String DATE_FORMAT = "yyyy-MM-dd";
    //    public static String DATE_FORMAT = "yyyyMMdd";
    public static String DATE_FORMAT1 = "yyyy/MM/dd";
    public static String DATE_FORMAT_DATE_TIME = "yyyy/MM/dd HH:mm";

    // 长日期格式
    public static String MONTH_FORMAT = "MM月dd日";
    public static String MONTH_DAY_FORMAT = "MM-dd";
    public static String DEFAULT_TIME_HOUR_FORMAT = "HH:mm";
    // 长日期格式
    public static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DEFAULT_TIME_FORMAT_FRZ = "HH:mm:ss";
    public static String DEFAULT_TIME_FORMAT_TIME = "MM-dd HH:mm";
    public static String DATE_TIME_FORMAT_TIME = "yyyy-MM-dd HH:mm";
    public static String DEFAULT_TIME_FORMAT_MIN = "yyyy-MM-dd HH:mm";

    /**
     * 当前日期
     *
     * @return
     */
    public static String getStringToday(String dateFormat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 转换 日期
     *
     * @param dateStr
     * @param startFormat
     * @param endFormat
     * @return
     */
    public static String getStringDateFormat(String dateStr, String startFormat, String endFormat) {
        if (dateStr == null || dateStr.equals("")) {
            return dateStr;
        }
        Date date = null;
        if (startFormat == null || startFormat.equals("")) {
            startFormat = DEFAULT_TIME_FORMAT;
        }
        if (endFormat == null || endFormat.equals("")) {
            endFormat = DEFAULT_TIME_FORMAT;
        }
        SimpleDateFormat startDF = new SimpleDateFormat(startFormat);
        SimpleDateFormat endDF = new SimpleDateFormat(endFormat);
        try {
            date = startDF.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return endDF.format(date);
    }

    /**
     * 将日期格式的字符串转换为长整型
     *
     * @param date
     * @param format
     * @return
     */
    public static long convertTolong(String date, String format) {
        if (isStringEmpty(date)) {
            return 0;
        }
        try {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            return sf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static String getTimeToDateFormat(String currentTime, String formatType) {
        if (isStringEmpty(currentTime)) {
            return "";
        }
        String sDateTime = "";
        Date dateOld = new Date(Long.parseLong(currentTime)); // 根据long类型的毫秒数生命一个date类型的时间
        try {
            // 把date类型的时间转换为string
            sDateTime = new SimpleDateFormat(formatType).format(dateOld);
            // (TODO) SimpleDateFormat is not thread-safe. Users should create a separate instance for
            // each thread
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return sDateTime;
    }

    public static String longTimetoString(long currentTime, String formatType) {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        // 把date类型的时间转换为string
        String sDateTime = new SimpleDateFormat(formatType).format(dateOld);
        return sDateTime;
    }

    public static String getApartTime(long timeStamp) {
        int second = (int) ((System.currentTimeMillis() - timeStamp) / 1000);
        if (second <= 0) {
            return "1分钟内";
        }
        if (second < 60) {
            return "1分钟内";
        }
        int minute = second / 60;
        if (minute < 60) {
            return minute + "分钟内";
        }
        int hour = minute / 60;
        if (hour < 4) {
            return hour + "小时内";
        }
        return getTalkTime(timeStamp);
    }

    /**
     * 显示录音时间 显示格式：00：00
     *
     * @param secondTime
     * @return
     */
    public static String showRecordTime(long secondTime) {
        String timeType = "0";
        String time = null;
        if (secondTime >= 3600) {
            return "00:00";
        }
        long minute = secondTime / 60;
        if (minute < 10) {
            time = timeType + minute + ":";
        }
        if (minute >= 10) {
            time = minute + ":";
        }

        long second = secondTime % 60;
        if (second < 10) {
            time = time + timeType + second;
        }
        if (second >= 10) {
            time = time + second + "";
        }
        return time;
    }

    /**
     * x小时x分钟
     */
    public static String secondConvertChineseTime(long second) {// 分钟
        String result = "";
        if (second > 60) {
            int hour = (int) (second / 60);
            int sec = (int) (second % 60);
            if (hour > 24) {// 大于一天
                int day = hour / 24;
                int hourStr = hour % 24;
                result = day + "天" + hourStr + "小时" + sec + "分钟";
            } else {// 小于
                result = hour + "小时" + sec + "分钟";
            }
        } else {
            result = second + "分钟";
        }
        return result;
    }

    /**
     * x小时x分钟x秒
     *
     * @param second
     * @return
     */
    public static String getSecondFormatTime(long second) {// 秒
        String result = "";
        if (second > 60) {
            int minute = (int) (second / 60);
            int sec = (int) (second % 60);
            if (minute > 60) {// 大于一天
                int houre = minute / 60;
                result = houre + "小时" + minute + "分" + sec + "秒";
            } else {// 小于
                result = minute + "分" + sec + "秒";
            }
        } else {
            result = second + "秒";
        }
        return result;
    }

    /**
     * x小时x分钟x秒
     *
     * @param second
     * @return
     */
    public static String getHourFormatTime(long second) {// 秒
        String result = "";
        String hourString = "00";
        String minString = "00";
        String secString = "00";
        if (second > 60) {
            int minute = (int) (second / 60);
            int sec = (int) (second % 60);
            if (minute > 60) {// 大于一天
                int houre = minute / 60;
                int min = minute % 60;
                hourString = getFormatTime(houre);
                minString = getFormatTime(min);
                secString = getFormatTime(sec);
            } else {// 小于
                hourString = "00";
                minString = getFormatTime(minute);
                secString = getFormatTime(sec);
            }
        } else {
            hourString = "00";
            minString = "00";
            secString = getFormatTime((int) second);
        }
        result = hourString + ":" + minString + ":" + secString;
        return result;
    }

    private static String getFormatTime(int time) {
        if (time < 10) {
            return "0" + time;
        } else {
            return String.valueOf(time);
        }
    }

    public static String getTimeToDuration(long minute) {
        String tempHour;
        String tempMinute;
        int h = (int) (minute / 60);
        int m = (int) (minute % 60);
        tempHour = (h == 0 ? "" : h + "时");
        tempMinute = (m == 0 ? "" : m + "分");
        return tempHour + tempMinute;
    }

    public static String getTalkTime(long timestmap) {
        Time time = new Time();
        time.set(System.currentTimeMillis());
        int year = time.year;
        int day = time.yearDay;
        time.set(timestmap);
        int year1 = time.year;
        int day1 = time.yearDay;
        if (year1 == year) {
            if (day - day1 == 1) {
                return "昨天  " + longTimetoString(timestmap, "HH:mm");
            } else if (day1 - day == 0) {
                return "" + longTimetoString(timestmap, "HH:mm");
            } else {
                return longTimetoString(timestmap, "MM-dd hh:mm");
            }
        } else {
            return longTimetoString(timestmap, "yyyy-MM-dd");
        }
    }

    public static boolean isOutOneDay(long timestamp) {// 超过了一天;
        Time time = new Time();
        time.set(System.currentTimeMillis());
        int day = time.yearDay;
        time.set(timestamp);
        int day1 = time.yearDay;
        if (Math.abs(day - day1) >= 1) {
            return true;
        }
        return false;
    }

    public static boolean isOutNumDay(long timestamp, int num) {// 超过了N天;
        Time time = new Time();
        time.set(System.currentTimeMillis());
        int day = time.yearDay;
        time.set(timestamp);
        int day1 = time.yearDay;
        if (Math.abs(day - day1) >= num) {
            return true;
        }
        return false;
    }

    /**
     * 时间的转换
     *
     * @param time
     * @return
     */
    public static String toTime(int time) {

        time /= 1000;
        int minute = time / 60;
        int second = time % 60;
        minute %= 60;
        return String.format("%02d:%02d", minute, second);
    }

    public static String getTalkTime3(long timestmap) {
        Time time = new Time();
        time.set(System.currentTimeMillis());
        int year = time.year;
        int day = time.yearDay;
        time.set(timestmap);
        int year1 = time.year;
        int day1 = time.yearDay;
        if (year1 == year && day == day1) {
            return "今天";
        } else if (year1 == year && (day - day1) == 1) {
            return "昨天";
        } else {
            return longTimetoString(timestmap, DATE_FORMAT);
        }
    }

    //日期字符串转时间戳
    public static String getDateToTime(String timeString) {
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIME_FORMAT_MIN);
        Date d;
        try {
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStamp;
    }

    /**
     * 当前时间和 上次时间的 间隔  返回  分钟(m)
     *
     * @param lastTime
     * @return
     */
    public static int getcurrentTimeDistanceMin(long lastTime) {
        int distanceMin = 0;
        long currentTime = System.currentTimeMillis();
        long distanceTime = currentTime - lastTime;
        if (distanceTime > 0) {
            distanceMin = (int) distanceTime / (1000 * 60);
        }
        return distanceMin;
    }


    /**
     * 当前时间和 上次时间的 间隔  返回  分钟(m)
     *
     * @param lastTime
     * @return
     */
    public static int getcurrentTimeDistanceDay1(long lastTime) {
        int distanceMin = 0;
        long currentTime = System.currentTimeMillis();
        long distanceTime = currentTime - lastTime;
        if (distanceTime > 0) {
            distanceMin = (int) distanceTime / (1000 * 60 * 60 * 24);
        }
        return distanceMin;
    }


    public static int getcurrentTimeDistanceDay(long lastTime) {
        int distanceMin = 0;
        try {
            if (lastTime != 0) {
                String lastTimeDate = longTimetoString(lastTime, DateUtil.DATE_FORMAT);
                System.out.println("----lastTimeDate--" + lastTimeDate);
                lastTime = convertTolong(lastTimeDate, DateUtil.DATE_FORMAT);
            }
            long currentTime = System.currentTimeMillis();
            String currentTimeDate = longTimetoString(currentTime, DateUtil.DATE_FORMAT);
            System.out.println("----currentTimeDate--" + currentTimeDate);
            currentTime = convertTolong(currentTimeDate, DateUtil.DATE_FORMAT);
            System.out.println("----currentTime--" + currentTime);
            long distanceTime = currentTime - lastTime;
            if (distanceTime > 0) {
                distanceMin = (int) distanceTime / (1000 * 60 * 60 * 24);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distanceMin;
    }

    /**
     * 获取当前小时
     *
     * @return
     */
    public static int getCurrentHourTime() {
        Calendar cal = Calendar.getInstance();
        int mHour = cal.get(Calendar.HOUR_OF_DAY);
        return mHour;
    }

    /**
     * 今天则返回时间，否则返回日期
     *
     * @param timestmap
     * @return
     */
    public static String getChatMessageTime(long timestmap) {
        Time time = new Time();
        time.set(System.currentTimeMillis());
        int year = time.year;
        int day = time.yearDay;
        time.set(timestmap);
        int year1 = time.year;
        int day1 = time.yearDay;
        if (year1 == year && day == day1) {
            return longTimetoString(timestmap, DEFAULT_TIME_HOUR_FORMAT);
        } else {
            return longTimetoString(timestmap, MONTH_DAY_FORMAT);
        }
    }


    /**
     * 获取从1970年开始到当天00:00的毫秒值
     *
     * @return
     */
    public static long getStartTimeOfToday() {
        return getStartTimeOfDay(System.currentTimeMillis());
    }

    /**
     * 获取从1970年开始到某天00:00的毫秒值
     *
     * @return
     */
    public static long getStartTimeOfDay(long nowTime) {
        TimeZone curTimeZone = TimeZone.getTimeZone("GMT+8");
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(nowTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    public static String getStudyPlanCurrentTimeType() {
        int hour = getCurrentHourTime();
        if (hour >= 5 && hour < 12) {
            return "morning";
        } else if (hour >= 12 && hour < 14) {
            return "midday";
        } else if (hour >= 14 && hour < 22) {
            return "afternoon";
        } else {
            return "evening";
        }
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public Integer getDayInterval(Date start, Date end) {
        final long nd = 1000 * 24 * 60 * 60;
        Date startDay = new Date(start.getTime() - start.getTime() % nd);
        Date endDay = new Date(end.getTime() - end.getTime() % nd);
        return (int) ((endDay.getTime() - startDay.getTime()) / nd);
    }

    public static int getDayDiffer(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long startDateTime = dateFormat.parse(dateFormat.format(startDate)).getTime();
        long endDateTime = dateFormat.parse(dateFormat.format(endDate)).getTime();
        return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
    }


    public static int getIntervalDay(long lastTime) {
        int distanceDay = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date lastDate = new Date(lastTime);
            Date old = sdf.parse(sdf.format(lastDate));
            Date now = sdf.parse(sdf.format(new Date()));
            long oldTime = old.getTime();
            long nowTime = now.getTime();
            System.out.println("------oldTime" + oldTime);
            System.out.println("------nowTime" + nowTime);
            System.out.println("------nowTime" + nowTime);
            String dateOld = DateUtil.getTimeToDateFormat(oldTime + "", DEFAULT_TIME_FORMAT);
            System.out.println("------oldTimeDeta" + dateOld);
            String nowTimeOld = DateUtil.getTimeToDateFormat(nowTime + "", DEFAULT_TIME_FORMAT);
            System.out.println("------nowTimeOld" + nowTimeOld);

            distanceDay = (int) ((nowTime - oldTime) / (24 * 60 * 60 * 1000));
            return distanceDay;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
        return distanceDay;
    }

    public static String buildUrlDefineAddParem(String url, String key, String value) {
        if (isStringEmpty(url))
            return "";
        String[] urlArray = url.split("#");
        if (urlArray != null && urlArray.length > 0) {
            String strUrl = "";
            for (int i = 0; i < urlArray.length; i++) {
                if (i == 0) {
                    strUrl = buildUrlDefineAddParemInfo(urlArray[0], key, value);
                } else {
                    strUrl = strUrl + "#" + urlArray[i];
                }
            }
            url = strUrl;
        } else {
            url = buildUrlDefineAddParemInfo(url, key, value);
        }
        return url;
    }

    private static String buildUrlDefineAddParemInfo(String url, String key, String value) {

        if (isStringEmpty(url))
            return "";
        StringBuilder builder = new StringBuilder(url);
        if (!url.contains("?")) {
            builder.append("?");
        } else {
            Uri uri = Uri.parse(url);
            String scheme = uri.getScheme();
            if (!isStringEmpty(scheme) && url.toLowerCase().startsWith("http")) {
                Set<String> parameter = uri.getQueryParameterNames();
                if (parameter != null && parameter.contains(key)) {
                    return url;
                }
                if (parameter.size() > 0) {
                    builder.append("&");
                }
            } else {
                builder.append("&");
            }

        }
        builder.append(key).append("=").append(value);
        return builder.toString();
    }


}
