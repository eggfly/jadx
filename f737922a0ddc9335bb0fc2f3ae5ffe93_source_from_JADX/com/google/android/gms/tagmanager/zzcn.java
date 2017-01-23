package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzcn extends i {
    private static final String j6;
    private final Context DW;

    static {
        j6 = f.RESOLUTION.toString();
    }

    public zzcn(Context context) {
        super(j6, new String[0]);
        this.DW = context;
    }

    public a j6(Map<String, a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.DW.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return as.FH(i + "x" + displayMetrics.heightPixels);
    }

    public boolean j6() {
        return true;
    }
}
