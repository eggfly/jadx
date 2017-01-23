package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C2290u;
import com.facebook.ads.internal.util.C2507o;
import com.facebook.ads.internal.util.C2512t;
import com.umeng.message.proguard.C4233j;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.f.h */
public class C2462h extends LinearLayout {
    private boolean f8478a;
    private VideoView f8479b;
    private int f8480c;
    private String f8481d;
    private String f8482e;
    private int f8483f;
    private Handler f8484g;
    private Handler f8485h;
    private MediaController f8486i;
    private C2459a f8487j;

    /* renamed from: com.facebook.ads.internal.f.h.1 */
    class C24571 implements OnCompletionListener {
        final /* synthetic */ C2462h f8476a;

        C24571(C2462h c2462h) {
            this.f8476a = c2462h;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.f8476a.f8487j != null) {
                this.f8476a.f8487j.m9369a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.f.h.2 */
    class C24582 implements OnErrorListener {
        final /* synthetic */ C2462h f8477a;

        C24582(C2462h c2462h) {
            this.f8477a = c2462h;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.f8477a.f8487j != null) {
                this.f8477a.f8487j.m9370b();
            }
            return false;
        }
    }

    /* renamed from: com.facebook.ads.internal.f.h.a */
    public interface C2459a {
        void m9369a();

        void m9370b();
    }

    /* renamed from: com.facebook.ads.internal.f.h.b */
    private static final class C2460b extends C2290u<C2462h> {
        public C2460b(C2462h c2462h) {
            super(c2462h);
        }

        public void run() {
            C2462h c2462h = (C2462h) m8655a();
            if (c2462h == null) {
                return;
            }
            if (c2462h.f8479b.getCurrentPosition() > c2462h.f8480c) {
                new C2507o(C2512t.m9520a(((C2462h) m8655a()).getContext(), ((C2462h) m8655a()).f8478a, false)).execute(new String[]{c2462h.getVideoPlayReportURI()});
                return;
            }
            c2462h.f8484g.postDelayed(this, 250);
        }
    }

    /* renamed from: com.facebook.ads.internal.f.h.c */
    private static final class C2461c extends C2290u<C2462h> {
        public C2461c(C2462h c2462h) {
            super(c2462h);
        }

        public void run() {
            C2462h c2462h = (C2462h) m8655a();
            if (c2462h != null) {
                int currentPosition = c2462h.f8479b.getCurrentPosition();
                if (currentPosition > c2462h.f8483f) {
                    c2462h.f8483f = currentPosition;
                }
                c2462h.f8485h.postDelayed(this, 250);
            }
        }
    }

    public C2462h(Context context) {
        super(context);
        m9375c();
    }

    private void m9375c() {
        this.f8486i = new MediaController(getContext());
        this.f8479b = new VideoView(getContext());
        this.f8486i.setAnchorView(this);
        this.f8479b.setMediaController(this.f8486i);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(13);
        this.f8479b.setLayoutParams(layoutParams);
        this.f8479b.setOnCompletionListener(new C24571(this));
        this.f8479b.setOnErrorListener(new C24582(this));
        addView(this.f8479b);
        this.f8485h = new Handler();
        this.f8485h.postDelayed(new C2461c(this), 250);
        this.f8484g = new Handler();
        this.f8484g.postDelayed(new C2460b(this), 250);
    }

    private void m9377d() {
        if (getVideoTimeReportURI() != null) {
            Map a = C2512t.m9520a(getContext(), this.f8478a, false);
            a.put(C4233j.f14377D, Integer.toString(this.f8483f / AdError.NETWORK_ERROR_CODE));
            new C2507o(a).execute(new String[]{getVideoTimeReportURI()});
            this.f8483f = 0;
        }
    }

    public void m9381a() {
        this.f8479b.start();
    }

    public void m9382b() {
        if (this.f8479b != null) {
            this.f8479b.stopPlayback();
        }
    }

    public String getVideoPlayReportURI() {
        return this.f8481d;
    }

    public String getVideoTimeReportURI() {
        return this.f8482e;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9377d();
    }

    public void setAutoplay(boolean z) {
        this.f8478a = z;
    }

    public void setVideoPlayReportMS(int i) {
        this.f8480c = i;
    }

    public void setVideoPlayReportURI(String str) {
        this.f8481d = str;
    }

    public void setVideoTimeReportURI(String str) {
        this.f8482e = str;
    }

    public void setVideoURI(Uri uri) {
        if (uri != null) {
            this.f8479b.setVideoURI(uri);
        }
    }

    public void setVideoURI(String str) {
        if (str != null) {
            setVideoURI(Uri.parse(str));
        }
    }
}
