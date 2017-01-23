package com.antutu.utils;

import com.xiaomi.pushsdk.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String formatDate(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String str = BuildConfig.FLAVOR;
        try {
            str = simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int getTimeIntervalHours(long j) {
        return (int) (((((double) (System.currentTimeMillis() - j)) / 1000.0d) / 60.0d) / 60.0d);
    }

    public static int getTimeIntervalMinutes(long j) {
        return (int) ((((double) (System.currentTimeMillis() - j)) / 1000.0d) / 60.0d);
    }
}
