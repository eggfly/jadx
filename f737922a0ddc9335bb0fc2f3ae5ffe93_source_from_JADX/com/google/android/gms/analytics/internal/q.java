package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.aide.uidesigner.ProxyTextView;

public class q extends t {
    protected String DW;
    protected int FH;
    protected boolean Hw;
    protected boolean VH;
    protected boolean Zo;
    protected String j6;
    protected int v5;

    public q(v vVar) {
        super(vVar);
    }

    private static int j6(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    public String DW() {
        P8();
        return this.j6;
    }

    public String FH() {
        P8();
        return this.DW;
    }

    public boolean Hw() {
        P8();
        return false;
    }

    public int VH() {
        P8();
        return this.v5;
    }

    public boolean Zo() {
        P8();
        return this.Hw;
    }

    public boolean gn() {
        P8();
        return this.Zo;
    }

    protected void j6() {
        tp();
    }

    void j6(b bVar) {
        int j6;
        DW("Loading global XML config values");
        if (bVar.j6()) {
            String DW = bVar.DW();
            this.DW = DW;
            DW("XML config - app name", DW);
        }
        if (bVar.FH()) {
            DW = bVar.Hw();
            this.j6 = DW;
            DW("XML config - app version", DW);
        }
        if (bVar.v5()) {
            j6 = j6(bVar.Zo());
            if (j6 >= 0) {
                this.FH = j6;
                j6("XML config - log level", Integer.valueOf(j6));
            }
        }
        if (bVar.VH()) {
            j6 = bVar.gn();
            this.v5 = j6;
            this.Hw = true;
            DW("XML config - dispatch period (sec)", Integer.valueOf(j6));
        }
        if (bVar.u7()) {
            boolean tp = bVar.tp();
            this.VH = tp;
            this.Zo = true;
            DW("XML config - dry run", Boolean.valueOf(tp));
        }
    }

    protected void tp() {
        ApplicationInfo applicationInfo;
        Context Ws = Ws();
        try {
            applicationInfo = Ws.getPackageManager().getApplicationInfo(Ws.getPackageName(), ProxyTextView.INPUTTYPE_textPassword);
        } catch (NameNotFoundException e) {
            Hw("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            v5("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                b bVar = (b) new ao(EQ()).j6(i);
                if (bVar != null) {
                    j6(bVar);
                }
            }
        }
    }

    public boolean u7() {
        P8();
        return this.VH;
    }

    public int v5() {
        P8();
        return this.FH;
    }
}
