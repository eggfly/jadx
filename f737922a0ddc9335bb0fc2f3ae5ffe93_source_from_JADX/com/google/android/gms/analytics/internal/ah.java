package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.e;

class ah implements e {
    private boolean DW;
    private int j6;

    ah() {
        this.j6 = 2;
    }

    public void DW(String str) {
    }

    public void FH(String str) {
    }

    public void Hw(String str) {
    }

    public int j6() {
        return this.j6;
    }

    public void j6(int i) {
        this.j6 = i;
        if (!this.DW) {
            String str = (String) an.FH.j6();
            Log.i((String) an.FH.j6(), new StringBuilder(String.valueOf(str).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.DW = true;
        }
    }

    public void j6(String str) {
    }
}
