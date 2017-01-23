package com.miui.support.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.date.Calendar;
import com.miui.support.date.CalendarFormatSymbols;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import java.util.TimeZone;

public class PictureClock extends LinearLayout {
    private final Handler f4308a;
    private final BroadcastReceiver f4309b;
    private Calendar f4310c;
    private ImageTextView f4311d;
    private AmPm f4312e;
    private boolean f4313f;
    private boolean f4314g;

    /* renamed from: com.miui.support.widget.PictureClock.1 */
    class C04981 extends BroadcastReceiver {
        final /* synthetic */ PictureClock f4304a;

        /* renamed from: com.miui.support.widget.PictureClock.1.1 */
        class C04971 implements Runnable {
            final /* synthetic */ C04981 f4303a;

            C04971(C04981 c04981) {
                this.f4303a = c04981;
            }

            public void run() {
                this.f4303a.f4304a.m5994a();
            }
        }

        C04981(PictureClock pictureClock) {
            this.f4304a = pictureClock;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f4304a.f4313f && intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                this.f4304a.f4310c = new Calendar(TimeZone.getTimeZone(intent.getStringExtra("time-zone")));
            }
            this.f4304a.f4308a.post(new C04971(this));
        }
    }

    static class AmPm {
        private TextView f4305a;
        private String f4306b;
        private String f4307c;

        AmPm(View view) {
            this.f4305a = (TextView) view.findViewById(C0264R.id.am_pm);
            String[] f = CalendarFormatSymbols.m3401a().m3406f();
            this.f4306b = f[0];
            this.f4307c = f[1];
        }

        void m5991a(boolean z) {
            if (this.f4305a != null) {
                this.f4305a.setVisibility(z ? 0 : 8);
            }
        }

        void m5992b(boolean z) {
            if (this.f4305a != null) {
                this.f4305a.setText(z ? this.f4306b : this.f4307c);
            }
        }
    }

    public PictureClock(Context context) {
        this(context, null);
    }

    public PictureClock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4308a = new Handler();
        this.f4309b = new C04981(this);
        this.f4313f = true;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4311d = (ImageTextView) findViewById(C0264R.id.time_display);
        this.f4312e = new AmPm(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f4314g) {
            this.f4314g = true;
            if (this.f4313f) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_TICK");
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
                getContext().registerReceiver(this.f4309b, intentFilter);
            }
            this.f4310c = new Calendar();
            m5994a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4314g) {
            this.f4314g = false;
            if (this.f4313f) {
                getContext().unregisterReceiver(this.f4309b);
            }
        }
    }

    private void m5994a() {
        boolean z;
        boolean z2 = true;
        if (this.f4313f) {
            this.f4310c.m3385a(System.currentTimeMillis());
        }
        this.f4311d.setText(DateUtils.m3428a(this.f4310c.m3382a(), 76));
        AmPm amPm = this.f4312e;
        if (DateFormat.is24HourFormat(getContext())) {
            z = false;
        } else {
            z = true;
        }
        amPm.m5991a(z);
        AmPm amPm2 = this.f4312e;
        if (this.f4310c.m3380a(17) != 0) {
            z2 = false;
        }
        amPm2.m5992b(z2);
    }

    void setLive(boolean z) {
        this.f4313f = z;
    }
}
