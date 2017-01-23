package com.facebook.ads.internal.p121f;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.p121f.C2455i.C2257a;

/* renamed from: com.facebook.ads.internal.f.o */
public class C2468o implements C2455i {
    private C2462h f8495a;

    public C2468o(InterstitialAdActivity interstitialAdActivity, C2257a c2257a) {
        this.f8495a = new C2462h(interstitialAdActivity);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f8495a.setLayoutParams(layoutParams);
        c2257a.m8550a(this.f8495a);
    }

    public void m9386a() {
    }

    public void m9387a(Intent intent, Bundle bundle) {
        boolean booleanExtra = intent.getBooleanExtra(InterstitialAdActivity.AUTOPLAY, false);
        String stringExtra = intent.getStringExtra(InterstitialAdActivity.VIDEO_URL);
        String stringExtra2 = intent.getStringExtra(InterstitialAdActivity.VIDEO_PLAY_REPORT_URL);
        String stringExtra3 = intent.getStringExtra(InterstitialAdActivity.VIDEO_TIME_REPORT_URL);
        int intExtra = intent.getIntExtra(InterstitialAdActivity.VIDEO_PLAY_REPORT_MS, 10000);
        this.f8495a.setAutoplay(booleanExtra);
        this.f8495a.setVideoPlayReportMS(intExtra);
        this.f8495a.setVideoPlayReportURI(stringExtra2);
        this.f8495a.setVideoTimeReportURI(stringExtra3);
        this.f8495a.setVideoURI(stringExtra);
        this.f8495a.m9381a();
    }

    public void m9388a(Bundle bundle) {
    }

    public void m9389b() {
    }

    public void m9390c() {
        this.f8495a.m9382b();
    }
}
