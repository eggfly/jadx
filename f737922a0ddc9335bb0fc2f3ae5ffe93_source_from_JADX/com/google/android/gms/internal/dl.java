package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.dk.a;
import java.util.Map;

@eh
public class dl extends dm implements by {
    int DW;
    private final zzcm EQ;
    int FH;
    int Hw;
    private int J0;
    int VH;
    int Zo;
    private final fj gn;
    DisplayMetrics j6;
    private final WindowManager tp;
    private final Context u7;
    int v5;
    private float we;

    public dl(fj fjVar, Context context, zzcm com_google_android_gms_internal_zzcm) {
        super(fjVar);
        this.DW = -1;
        this.FH = -1;
        this.Hw = -1;
        this.v5 = -1;
        this.Zo = -1;
        this.VH = -1;
        this.gn = fjVar;
        this.u7 = context;
        this.EQ = com_google_android_gms_internal_zzcm;
        this.tp = (WindowManager) context.getSystemService("window");
    }

    private void VH() {
        this.j6 = new DisplayMetrics();
        Display defaultDisplay = this.tp.getDefaultDisplay();
        defaultDisplay.getMetrics(this.j6);
        this.we = this.j6.density;
        this.J0 = defaultDisplay.getRotation();
    }

    private void gn() {
        int[] iArr = new int[2];
        this.gn.getLocationOnScreen(iArr);
        j6(w.j6().DW(this.u7, iArr[0]), w.j6().DW(this.u7, iArr[1]));
    }

    private dk u7() {
        return new a().DW(this.EQ.j6()).j6(this.EQ.DW()).FH(this.EQ.Zo()).Hw(this.EQ.FH()).v5(this.EQ.Hw()).j6();
    }

    void DW() {
        if (this.gn.we().v5) {
            this.Zo = this.DW;
            this.VH = this.FH;
            return;
        }
        this.gn.measure(0, 0);
        this.Zo = w.j6().DW(this.u7, this.gn.getMeasuredWidth());
        this.VH = w.j6().DW(this.u7, this.gn.getMeasuredHeight());
    }

    public void FH() {
        VH();
        j6();
        DW();
        v5();
        Zo();
        gn();
        Hw();
    }

    void Hw() {
        if (b.j6(2)) {
            b.FH("Dispatching Ready Event.");
        }
        FH(this.gn.QX().DW);
    }

    void Zo() {
        this.gn.j6("onDeviceFeaturesReceived", u7().j6());
    }

    void j6() {
        this.DW = w.j6().DW(this.j6, this.j6.widthPixels);
        this.FH = w.j6().DW(this.j6, this.j6.heightPixels);
        Activity VH = this.gn.VH();
        if (VH == null || VH.getWindow() == null) {
            this.Hw = this.DW;
            this.v5 = this.FH;
            return;
        }
        int[] j6 = f.FH().j6(VH);
        this.Hw = w.j6().DW(this.j6, j6[0]);
        this.v5 = w.j6().DW(this.j6, j6[1]);
    }

    public void j6(int i, int i2) {
        DW(i, i2 - (this.u7 instanceof Activity ? f.FH().Hw((Activity) this.u7)[0] : 0), this.Zo, this.VH);
        this.gn.J0().j6(i, i2);
    }

    public void j6(fj fjVar, Map<String, String> map) {
        FH();
    }

    void v5() {
        j6(this.DW, this.FH, this.Hw, this.v5, this.we, this.J0);
    }
}
