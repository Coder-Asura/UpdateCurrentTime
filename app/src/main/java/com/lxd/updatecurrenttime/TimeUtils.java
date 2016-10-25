package com.lxd.updatecurrenttime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Liuxd on 2016/10/25 16:11.
 * 时间工具类
 */
public class TimeUtils {
    /**
     * 获取当前时间
     *
     * @return HH:mm:ss
     */
    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return MMdd EEEE
     */
    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日  E", Locale.CHINA);
        return simpleDateFormat.format(new Date());
    }

    /**
     * @return 当前时间
     */
    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyy年MM月dd日  E  HH:mm:ss:SSS", Locale.CHINA).format(new Date());
    }
}
