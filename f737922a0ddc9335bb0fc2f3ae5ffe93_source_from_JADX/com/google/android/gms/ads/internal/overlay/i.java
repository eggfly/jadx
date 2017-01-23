package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.internal.aw;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.fj;
import java.util.HashMap;
import java.util.Map;

@eh
public class i extends FrameLayout implements g {
    private final FrameLayout DW;
    private final q FH;
    private zzi Hw;
    private TextView VH;
    private boolean Zo;
    private long gn;
    private final fj j6;
    private String tp;
    private String u7;
    private boolean v5;

    public i(Context context, fj fjVar, int i, boolean z, ay ayVar, aw awVar) {
        super(context);
        this.j6 = fjVar;
        this.DW = new FrameLayout(context);
        addView(this.DW, new LayoutParams(-1, -1));
        com.google.android.gms.common.internal.i.j6(fjVar.u7());
        this.Hw = fjVar.u7().DW.j6(context, fjVar, i, z, ayVar, awVar);
        if (this.Hw != null) {
            this.DW.addView(this.Hw, new LayoutParams(-1, -1, 17));
        }
        this.VH = new TextView(context);
        this.VH.setBackgroundColor(-16777216);
        u7();
        this.FH = new q(this);
        this.FH.DW();
        if (this.Hw != null) {
            this.Hw.j6((g) this);
        }
        if (this.Hw == null) {
            j6("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private boolean EQ() {
        return this.VH.getParent() != null;
    }

    public static void j6(fj fjVar) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        fjVar.j6("onVideoEvent", hashMap);
    }

    private void j6(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.j6.j6("onVideoEvent", hashMap);
    }

    private void tp() {
        if (EQ()) {
            this.DW.removeView(this.VH);
        }
    }

    private void u7() {
        if (!EQ()) {
            this.DW.addView(this.VH, new LayoutParams(-1, -1));
            this.DW.bringChildToFront(this.VH);
        }
    }

    private void we() {
        if (this.j6.VH() != null && this.v5 && !this.Zo) {
            this.j6.VH().getWindow().clearFlags(128);
            this.v5 = false;
        }
    }

    public void DW() {
        if (this.Hw != null) {
            this.Hw.Hw();
        }
    }

    public void FH() {
        if (this.Hw != null) {
            this.Hw.DW();
        }
    }

    public void Hw() {
        if (this.Hw != null) {
            this.Hw.v5();
        }
    }

    public void VH() {
        this.FH.j6();
        if (this.Hw != null) {
            this.Hw.FH();
        }
        we();
    }

    public void Zo() {
        if (this.Hw != null) {
            View textView = new TextView(this.Hw.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.Hw.j6());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.DW.addView(textView, new LayoutParams(-2, -2, 17));
            this.DW.bringChildToFront(textView);
        }
    }

    void gn() {
        if (this.Hw != null) {
            long currentPosition = (long) this.Hw.getCurrentPosition();
            if (this.gn != currentPosition && currentPosition > 0) {
                tp();
                float f = ((float) currentPosition) / 1000.0f;
                j6("timeupdate", "time", String.valueOf(f));
                this.gn = currentPosition;
            }
        }
    }

    public void j6() {
        if (this.Hw != null) {
            if (TextUtils.isEmpty(this.tp)) {
                j6("no_src", new String[0]);
                return;
            }
            this.Hw.setMimeType(this.u7);
            this.Hw.setVideoPath(this.tp);
        }
    }

    public void j6(float f) {
        if (this.Hw != null) {
            this.Hw.j6(f);
        }
    }

    public void j6(float f, float f2) {
        if (this.Hw != null) {
            this.Hw.j6(f, f2);
        }
    }

    public void j6(int i) {
        if (this.Hw != null) {
            this.Hw.j6(i);
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.DW.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void j6(MotionEvent motionEvent) {
        if (this.Hw != null) {
            this.Hw.dispatchTouchEvent(motionEvent);
        }
    }

    public void j6(String str) {
        this.tp = str;
    }

    public void j6(String str, String str2) {
        j6("error", "what", str, "extra", str2);
    }

    public void setMimeType(String str) {
        this.u7 = str;
    }

    public void v5() {
        if (this.Hw != null) {
            this.Hw.Zo();
        }
    }
}
