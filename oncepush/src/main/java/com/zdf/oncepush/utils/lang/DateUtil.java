/**
 * Copyright (c) 2014, www.xinxindai.com All Rights Reserved.
 *
 */

package com.zdf.oncepush.utils.lang;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 *
 * @version $Id: DateUtil.java 20763 2015-06-30 07:06:41Z qiansenyi $
 * @since jdk1.6
 */
public class DateUtil {
    public static final String ShortDateFormat = "yyyy-MM-dd";
    public static final String LongDateFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String LongCompactDateFormat = "yyyyMMddHHmmss";
    public static final String FullDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FullCompactDateFormat = "yyyyMMddHHmmssSSS";
    public static final String TimeFormat = "HH:mm:ss";
    public static final String FullTimeFormat = "HH:mm:ss.SSS";

    private static Calendar getCalendar() {
        TimeZone tz = TimeZone.getDefault();
        return Calendar.getInstance(tz);
    }

    /**
     * 获取年份
     */
    public static int getYear() {
        return getCalendar().get(Calendar.YEAR);
    }

    /**
     * 获取月份
     */
    public static int getMonth() {
        return getCalendar().get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期
     */
    public static int getDay() {
        return getCalendar().get(Calendar.DATE);
    }

    /**
     * 获取小时
     */
    public static int getHour() {
        return getCalendar().get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分
     */
    public static int getMinute() {
        return getCalendar().get(Calendar.MINUTE);
    }

    /**
     * 获取秒
     */
    public static int getSecond() {
        return getCalendar().get(Calendar.SECOND);
    }

    /**
     * 格式化日期
     *
     * @param date    日期
     * @param pattern 格式
     * @return
     */
    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 格式化日期
     *
     * @param cal     日期
     * @param pattern 格式
     * @return
     */
    public static String format(Calendar cal, String pattern) {
        return DateFormatUtils.format(cal, pattern);
    }

    /**
     * 格式化时间戳
     *
     * @param time    时间戳
     * @param pattern 格式
     * @return 格式化文本
     */
    public static String format(Long time, String pattern) {
        long mills = String.valueOf(time).length() < 13 ? time * 1000 : time;
        return DateFormatUtils.format(mills, pattern);
    }

    /**
     * 解析日期字符串
     */
    public static Date parseDate(String date, String pattern) throws ParseException {
        return DateUtils.parseDate(date, pattern);
    }

    /**
     * 获取当前时间戳，秒
     *
     * @return 返回1970-1-1至今的时间戳，精确到秒
     */
    public static String getCurrentTime() {
        return String.valueOf((long) (System.currentTimeMillis() * 0.001));
    }

    /**
     * 将日期转换成秒数
     *
     * @param date 精确到秒的日期字符串
     */
    public static String convertToSeconds(String date, String pattern) throws ParseException {
        Date s = DateUtils.parseDate(date, pattern);
        return String.valueOf(s.getTime() / 1000);
    }

    /**
     * 日期格式转换
     */
    public static String convertPattern(String date, String patternOld, String patternNew) throws ParseException {
        Date d = DateUtils.parseDate(date, patternOld);
        return DateFormatUtils.format(d, patternNew);
    }

    /**
     * 获取前几个月或者下几个月的时间戳，秒
     */
    public static String addMonths(int months) {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, months);
        return String.valueOf(cal.getTimeInMillis() / 1000);
    }

    /**
     * 获取前几天或者后几天的时间戳，秒
     */
    public static String addDays(int days) {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, days);
        return String.valueOf(cal.getTimeInMillis() / 1000);
    }

    /**
     * 获取前几年或者下几年的时间戳，秒
     */
    public static String addYears(int years) {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, years);
        return String.valueOf(cal.getTimeInMillis() / 1000);
    }

    /**
     * 比较2个时间戳相差多少天
     */
    public static int diffDays(long time1, long time2) {
        long m1 = String.valueOf(time1).length() < 13 ? time1 * 1000 : time1;
        long m2 = String.valueOf(time2).length() < 13 ? time2 * 1000 : time2;
        long offset = m2 - m1;
        return (int) Math.ceil(offset / (1000 * 3600 * 24));
    }

    /**
     * 比较2个时间相差多少天
     */
    public static int diffDays(Date d1, Date d2) {
        long offset = d2.getTime() - d1.getTime();
        return (int) Math.ceil(offset / (1000 * 3600 * 24));
    }

    /**
     * 比较2个时间相差多少天
     */
    public static int diffDays(Calendar c1, Calendar c2) {
        long offset = c2.getTimeInMillis() - c1.getTimeInMillis();
        return (int) Math.ceil(offset / (1000 * 3600 * 24));
    }

    /**
     * 传入一个日期获得所传日期的月的天数
     *
     * @param date 日期
     * @return
     */
    public static String getDayCountOfMonth(Date date) throws ParseException {
        Date nextMonthFirst = DateUtils.ceiling(date, Calendar.MONTH); //下月第一天
        Calendar cal = Calendar.getInstance();
        cal.setTime(nextMonthFirst);
        cal.add(Calendar.DAY_OF_MONTH, -1);  //当月最后一天
        return String.valueOf(DateUtils.getFragmentInDays(cal, Calendar.MONTH));
    }

    /**
     * 获取当天最后一秒钟的秒数
     */
    public static String getLastSecondOfCurDay() {
        Calendar c = Calendar.getInstance();
        c = DateUtils.ceiling(c, Calendar.DAY_OF_MONTH);
        c.add(Calendar.SECOND, -1);
        return String.valueOf(c.getTimeInMillis() / 1000);
    }

    /**
     * 本月第一天
     */
    public static String getFirstDayOfTheMonth(Calendar c, String pattern) {
        Calendar c1 = DateUtils.truncate(c, Calendar.MONTH);
        return DateFormatUtils.format(c1, pattern);
    }

    /**
     * 本月最后一天
     */
    public static String getLastDayOfTheMonth(Calendar c, String pattern) {
        Calendar c1 = DateUtils.ceiling(c, Calendar.MONTH);
        c1.add(Calendar.DAY_OF_MONTH, -1);
        return DateFormatUtils.format(c1, pattern);
    }

    /**
     * 前台页面显示的时间格式
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static String dateToSqlTime(String date) throws Exception {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(ShortDateFormat);
            Date s = dateformat.parse(date);
            return String.valueOf(s.getTime() / 1000L);
        } catch (ParseException e) {
            throw e;
        }
    }

    /**
     * 相对输入时间往后，往前计算日期
     * ：type='M' 月份往后,往前 num 个月
     * ：type='D' 天数份往后,往前 num 个天
     * ：type='Y' 年份份往后,往前 num 个年
     *
     * @param inputdate 输入的时间
     * @param type      类型：Y，M，D
     * @param num       相加，相减的数量
     * @return 处理后的时间
     */
    public static Date getCalDate(Date inputdate, String type, int num) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(LongDateFormat);
            Calendar c = Calendar.getInstance();
            c.setTime(inputdate);
            int MaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            int day = c.get(Calendar.DATE);
            if ("D".equals(type)) {
                c.add(Calendar.DATE, num);
            } else if ("M".equals(type)) {
                c.add(Calendar.MONTH, num);
                if (MaxDay == day) {
                    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
                }
            } else if ("Y".equals(type)) {
                c.add(Calendar.YEAR, num);
                if (MaxDay == day) {
                    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
                }
            }
            String dayAfter = sdf.format(c.getTime());
            Date outdate = sdf.parse(dayAfter);
            return outdate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 加天
     *
     * @param date
     * @param i
     */
    public static Date addDate(Date date, int i) {
        Calendar _cldr = Calendar.getInstance();
        _cldr.setTime(date);
        _cldr.add(Calendar.DATE, i);
        return _cldr.getTime();
    }

    /**
     * 加月
     *
     * @param date
     * @param i
     */
    public static Date addMonth(Date date, int i) {
        Calendar _cldr = Calendar.getInstance();
        _cldr.setTime(date);
        _cldr.add(Calendar.MONTH, i);
        return _cldr.getTime();
    }


    /**
     *  获取Calendar（Date转Calendar）
     * @param date
     * @return
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


}
