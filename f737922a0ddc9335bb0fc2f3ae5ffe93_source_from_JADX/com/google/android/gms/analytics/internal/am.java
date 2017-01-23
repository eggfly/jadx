package com.google.android.gms.analytics.internal;

import android.os.Build.VERSION;
import java.io.File;

public class am {
    public static int j6() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            f.j6("Invalid version number", VERSION.SDK);
            return 0;
        }
    }

    public static boolean j6(String str) {
        if (j6() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
