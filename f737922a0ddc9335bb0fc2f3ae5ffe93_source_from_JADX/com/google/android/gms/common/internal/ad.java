package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.hl;

public class ad {
    private static boolean DW;
    private static String FH;
    private static int Hw;
    private static Object j6;

    static {
        j6 = new Object();
    }

    public static int DW(Context context) {
        FH(context);
        return Hw;
    }

    private static void FH(Context context) {
        synchronized (j6) {
            if (DW) {
                return;
            }
            DW = true;
            try {
                Bundle bundle = hl.DW(context).j6(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                FH = bundle.getString("com.google.app.id");
                Hw = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }

    public static String j6(Context context) {
        FH(context);
        return FH;
    }
}
