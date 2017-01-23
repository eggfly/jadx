package com.antutu.utils;

import android.app.Activity;
import android.os.Build.VERSION;
import org.android.spdy.SpdyProtocol;

public class RealFullscreen {
    public static void setFullscreen(Activity activity) {
        if (VERSION.SDK_INT > 10) {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            if (VERSION.SDK_INT >= 14) {
                systemUiVisibility ^= 2;
            }
            if (VERSION.SDK_INT >= 16) {
                systemUiVisibility ^= 4;
            }
            if (VERSION.SDK_INT >= 18) {
                systemUiVisibility ^= SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }
}
