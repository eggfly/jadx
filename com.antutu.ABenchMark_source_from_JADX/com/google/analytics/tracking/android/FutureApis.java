package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

class FutureApis {
    FutureApis() {
    }

    static boolean setOwnerOnlyReadWrite(String str) {
        if (version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            Log.m10257e("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}
