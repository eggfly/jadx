package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@eh
public class zzkd {
    private String DW;
    private final float FH;
    private float Hw;
    private int VH;
    private float Zo;
    private final Context j6;
    private float v5;

    class 1 implements OnClickListener {
        final /* synthetic */ zzkd DW;
        final /* synthetic */ String j6;

        1(zzkd com_google_android_gms_internal_zzkd, String str) {
            this.DW = com_google_android_gms_internal_zzkd;
            this.j6 = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            f.FH().j6(this.DW.j6, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.j6), "Share via"));
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ zzkd j6;

        2(zzkd com_google_android_gms_internal_zzkd) {
            this.j6 = com_google_android_gms_internal_zzkd;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public zzkd(Context context) {
        this.VH = 0;
        this.j6 = context;
        this.FH = context.getResources().getDisplayMetrics().density;
    }

    public zzkd(Context context, String str) {
        this(context);
        this.DW = str;
    }

    static String j6(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map j6 = f.FH().j6(build);
        for (String str2 : j6.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) j6.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    private void j6() {
        if (this.j6 instanceof Activity) {
            Object j6 = j6(this.DW);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.j6);
            builder.setMessage(j6);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new 1(this, j6));
            builder.setNegativeButton("Close", new 2(this));
            builder.create().show();
            return;
        }
        b.FH("Can not create dialog without Activity Context");
    }

    void j6(int i, float f, float f2) {
        if (i == 0) {
            this.VH = 0;
            this.Hw = f;
            this.v5 = f2;
            this.Zo = f2;
        } else if (this.VH == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.v5) {
                    this.v5 = f2;
                } else if (f2 < this.Zo) {
                    this.Zo = f2;
                }
                if (this.v5 - this.Zo > 30.0f * this.FH) {
                    this.VH = -1;
                    return;
                }
                if (this.VH == 0 || this.VH == 2) {
                    if (f - this.Hw >= 50.0f * this.FH) {
                        this.Hw = f;
                        this.VH++;
                    }
                } else if ((this.VH == 1 || this.VH == 3) && f - this.Hw <= -50.0f * this.FH) {
                    this.Hw = f;
                    this.VH++;
                }
                if (this.VH == 1 || this.VH == 3) {
                    if (f > this.Hw) {
                        this.Hw = f;
                    }
                } else if (this.VH == 2 && f < this.Hw) {
                    this.Hw = f;
                }
            } else if (i == 1 && this.VH == 4) {
                j6();
            }
        }
    }

    public void j6(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            j6(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        j6(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
