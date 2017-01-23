package p023b.p024a;

import com.facebook.ads.AdError;
import com.umeng.analytics.C4156a;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* renamed from: b.a.cm */
public class cm {
    private static long m3767a(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = ((instance.get(12) / 6) + 1) + (instance.get(11) * 10);
        int i3 = instance.get(13);
        int i4 = 0;
        if (i == AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE) {
            i4 = 360 - (((instance.get(12) % 6) * 60) + i3);
        } else if (i == AdError.NO_FILL_ERROR_CODE) {
            i4 = 60 - (i3 % 60);
            if (i2 % 6 == 0) {
                i4 += 60;
            }
        }
        return (long) (i4 * AdError.NETWORK_ERROR_CODE);
    }

    public static String m3768a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return String.valueOf(((long) ((((instance.get(12) / 6) + 1) + (instance.get(11) * 10)) - 1)) + (cm.m3772d(j) * 240));
    }

    public static boolean m3769a(long j, long j2) {
        return cm.m3773e(j) == cm.m3773e(j2);
    }

    public static long m3770b(long j) {
        return cm.m3767a(j, (int) AdError.NO_FILL_ERROR_CODE);
    }

    public static long m3771c(long j) {
        return cm.m3767a(j, (int) AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE);
    }

    private static long m3772d(long j) {
        long j2 = 0;
        try {
            long time = new SimpleDateFormat("yyyy").parse("1970").getTime();
            long j3 = (j - time) / C4156a.f13948j;
            if ((j - time) % C4156a.f13948j > 0) {
                j2 = 1;
            }
            return j2 + j3;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static int m3773e(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(5);
    }
}
