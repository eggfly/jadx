package com.antutu.benchmark.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.antutu.benchmark.p037f.C1500c;
import com.antutu.utils.MLog;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class CustomWebView extends WebView {
    float f5758a;
    float f5759b;
    private C1500c f5760c;
    private int f5761d;
    private int f5762e;

    public CustomWebView(Context context) {
        super(context);
        this.f5761d = 20;
        this.f5762e = 0;
        this.f5758a = 0.0f;
        this.f5759b = 0.0f;
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5761d = 20;
        this.f5762e = 0;
        this.f5758a = 0.0f;
        this.f5759b = 0.0f;
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5761d = 20;
        this.f5762e = 0;
        this.f5758a = 0.0f;
        this.f5759b = 0.0f;
    }

    @TargetApi(21)
    public CustomWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5761d = 20;
        this.f5762e = 0;
        this.f5758a = 0.0f;
        this.f5759b = 0.0f;
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        this.f5761d = 20;
        this.f5762e = 0;
        this.f5758a = 0.0f;
        this.f5759b = 0.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        float y;
        switch (motionEvent.getAction()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f5758a = motionEvent.getX();
                this.f5759b = motionEvent.getY();
                MLog.m6864d("ACTION_DOWN---X:" + motionEvent.getX() + "-----ACTION_DOWN----Y:" + motionEvent.getY());
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                f = motionEvent.getX();
                y = motionEvent.getY();
                float f2 = f - this.f5758a;
                float f3 = y - this.f5759b;
                MLog.m6864d("upX:" + f + "---upY:" + y + "  ---ACTION_UP-X:" + f2 + "ACTION_UP--Y:" + f3);
                if (f2 > 160.0f && Math.abs(f3) < 100.0f) {
                    if (this.f5760c != null) {
                        this.f5760c.onEventTrack();
                    }
                    return true;
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (0.0f == 0.0f) {
                    y = motionEvent.getX();
                    f = motionEvent.getY();
                } else {
                    y = 0.0f;
                }
                MLog.m6864d("ACTION_MOVE-mx:" + y + "ACTION_MOVE-my:" + f);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFilingListener(C1500c c1500c) {
        this.f5760c = c1500c;
    }
}
