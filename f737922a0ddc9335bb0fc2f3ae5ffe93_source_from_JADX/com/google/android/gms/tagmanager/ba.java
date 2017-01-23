package com.google.android.gms.tagmanager;

import android.content.Context;

public class ba implements l {
    private static final Object DW;
    private static ba j6;
    private ae FH;
    private m Hw;

    static {
        DW = new Object();
    }

    private ba(Context context) {
        this(n.j6(context), new al());
    }

    ba(m mVar, ae aeVar) {
        this.Hw = mVar;
        this.FH = aeVar;
    }

    public static l j6(Context context) {
        l lVar;
        synchronized (DW) {
            if (j6 == null) {
                j6 = new ba(context);
            }
            lVar = j6;
        }
        return lVar;
    }

    public boolean j6(String str) {
        if (this.FH.j6()) {
            this.Hw.j6(str);
            return true;
        }
        r.DW("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
