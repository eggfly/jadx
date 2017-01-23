package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

class j {
    public static int j6() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            String str = "Invalid version number: ";
            String valueOf = String.valueOf(VERSION.SDK);
            r.j6(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 0;
        }
    }

    @TargetApi(9)
    static boolean j6(String str) {
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
