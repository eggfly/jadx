package com.antutu.benchmark.p038b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.antutu.utils.MLog;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.b.f */
public class C1341f implements OnTouchListener {
    private C1196a f4605a;
    private int f4606b;
    private int f4607c;

    /* renamed from: com.antutu.benchmark.b.f.a */
    public interface C1196a {
        void m4959g();
    }

    public C1341f(Context context) {
        this.f4606b = 0;
        this.f4607c = 0;
    }

    public void m5400a(C1196a c1196a) {
        this.f4605a = c1196a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f4606b = (int) motionEvent.getX();
                this.f4607c = (int) motionEvent.getY();
                MLog.m6865d("onTouch", "hzd, ------startX=" + this.f4606b);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                MLog.m6865d("onTouch", "hzd, ------action_up");
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                MLog.m6865d("onTouch", "hzd, ------endX=" + x);
                MLog.m6865d("onTouch", "hzd, ------endX - startX=" + (x - this.f4606b));
                MLog.m6865d("onTouch", "hzd, ------endY - startY=" + (y - this.f4607c));
                if (x - this.f4606b > 100 && Math.abs(y - this.f4607c) < 80) {
                    MLog.m6865d("onTouch", "hzd, ------\u5411\u53f3\u6ed1\u52a8");
                    if (this.f4605a != null) {
                        this.f4605a.m4959g();
                    }
                    return true;
                }
        }
        return false;
    }
}
