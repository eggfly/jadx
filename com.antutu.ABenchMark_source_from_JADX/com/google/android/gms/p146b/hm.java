package com.google.android.gms.p146b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.hm */
public class hm {
    private final Context f11307a;
    private String f11308b;
    private final float f11309c;
    private float f11310d;
    private float f11311e;
    private float f11312f;
    private int f11313g;

    /* renamed from: com.google.android.gms.b.hm.1 */
    class C32621 implements OnClickListener {
        final /* synthetic */ String f11304a;
        final /* synthetic */ hm f11305b;

        C32621(hm hmVar, String str) {
            this.f11305b = hmVar;
            this.f11304a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C2968s.m11525e().m13033a(this.f11305b.f11307a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.f11304a), "Share via"));
        }
    }

    /* renamed from: com.google.android.gms.b.hm.2 */
    class C32632 implements OnClickListener {
        final /* synthetic */ hm f11306a;

        C32632(hm hmVar) {
            this.f11306a = hmVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public hm(Context context) {
        this.f11313g = 0;
        this.f11307a = context;
        this.f11309c = context.getResources().getDisplayMetrics().density;
    }

    public hm(Context context, String str) {
        this(context);
        this.f11308b = str;
    }

    private void m13122a() {
        if (this.f11307a instanceof Activity) {
            Object b = hm.m13123b(this.f11308b);
            Builder builder = new Builder(this.f11307a);
            builder.setMessage(b);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new C32621(this, b));
            builder.setNegativeButton("Close", new C32632(this));
            builder.create().show();
            return;
        }
        C2972b.m11581c("Can not create dialog without Activity Context");
    }

    static String m13123b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map a = C2968s.m11525e().m13028a(build);
        for (String str2 : a.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) a.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    void m13124a(int i, float f, float f2) {
        if (i == 0) {
            this.f11313g = 0;
            this.f11310d = f;
            this.f11311e = f2;
            this.f11312f = f2;
        } else if (this.f11313g == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f11311e) {
                    this.f11311e = f2;
                } else if (f2 < this.f11312f) {
                    this.f11312f = f2;
                }
                if (this.f11311e - this.f11312f > 30.0f * this.f11309c) {
                    this.f11313g = -1;
                    return;
                }
                if (this.f11313g == 0 || this.f11313g == 2) {
                    if (f - this.f11310d >= 50.0f * this.f11309c) {
                        this.f11310d = f;
                        this.f11313g++;
                    }
                } else if ((this.f11313g == 1 || this.f11313g == 3) && f - this.f11310d <= -50.0f * this.f11309c) {
                    this.f11310d = f;
                    this.f11313g++;
                }
                if (this.f11313g == 1 || this.f11313g == 3) {
                    if (f > this.f11310d) {
                        this.f11310d = f;
                    }
                } else if (this.f11313g == 2 && f < this.f11310d) {
                    this.f11310d = f;
                }
            } else if (i == 1 && this.f11313g == 4) {
                m13122a();
            }
        }
    }

    public void m13125a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m13124a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m13124a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public void m13126a(String str) {
        this.f11308b = str;
    }
}
