package com.facebook.ads.internal.util;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.google.analytics.tracking.android.ModelFields;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.util.a */
public class C2486a {
    private static SensorManager f8549a;
    private static Sensor f8550b;
    private static Sensor f8551c;
    private static volatile float[] f8552d;
    private static volatile float[] f8553e;
    private static Map<String, Object> f8554f;
    private static String[] f8555g;

    static {
        f8549a = null;
        f8550b = null;
        f8551c = null;
        f8554f = new ConcurrentHashMap();
        f8555g = new String[]{"x", "y", ModelFields.CACHE_BUSTER};
    }

    public static Map<String, Object> m9449a() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.putAll(f8554f);
        C2486a.m9450a(hashMap);
        return hashMap;
    }

    private static void m9450a(Map<String, Object> map) {
        int i;
        int i2 = 0;
        float[] fArr = f8552d;
        float[] fArr2 = f8553e;
        if (fArr != null) {
            int min = Math.min(f8555g.length, fArr.length);
            for (i = 0; i < min; i++) {
                map.put("accelerometer_" + f8555g[i], Float.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            i = Math.min(f8555g.length, fArr2.length);
            while (i2 < i) {
                map.put("rotation_" + f8555g[i2], Float.valueOf(fArr2[i2]));
                i2++;
            }
        }
    }
}
