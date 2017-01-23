package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hf;
import com.google.android.gms.p146b.hj;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@gb
@TargetApi(14)
/* renamed from: com.google.android.gms.ads.internal.overlay.c */
public class C2855c extends C2854i implements OnAudioFocusChangeListener, OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> f9671a;
    private final C2876t f9672b;
    private int f9673c;
    private int f9674d;
    private MediaPlayer f9675e;
    private Uri f9676f;
    private int f9677g;
    private int f9678h;
    private int f9679i;
    private int f9680j;
    private int f9681k;
    private float f9682l;
    private boolean f9683m;
    private boolean f9684n;
    private int f9685o;
    private C2867h f9686p;

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.1 */
    class C28471 implements Runnable {
        final /* synthetic */ C2855c f9662a;

        C28471(C2855c c2855c) {
            this.f9662a = c2855c;
        }

        public void run() {
            if (this.f9662a.f9686p != null) {
                this.f9662a.f9686p.m11129b();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.2 */
    class C28482 implements Runnable {
        final /* synthetic */ C2855c f9663a;

        C28482(C2855c c2855c) {
            this.f9663a = c2855c;
        }

        public void run() {
            if (this.f9663a.f9686p != null) {
                this.f9663a.f9686p.m11132e();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.3 */
    class C28493 implements Runnable {
        final /* synthetic */ String f9664a;
        final /* synthetic */ String f9665b;
        final /* synthetic */ C2855c f9666c;

        C28493(C2855c c2855c, String str, String str2) {
            this.f9666c = c2855c;
            this.f9664a = str;
            this.f9665b = str2;
        }

        public void run() {
            if (this.f9666c.f9686p != null) {
                this.f9666c.f9686p.m11128a(this.f9664a, this.f9665b);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.4 */
    class C28504 implements Runnable {
        final /* synthetic */ C2855c f9667a;

        C28504(C2855c c2855c) {
            this.f9667a = c2855c;
        }

        public void run() {
            if (this.f9667a.f9686p != null) {
                this.f9667a.f9686p.m11127a();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.5 */
    class C28515 implements Runnable {
        final /* synthetic */ C2855c f9668a;

        C28515(C2855c c2855c) {
            this.f9668a = c2855c;
        }

        public void run() {
            if (this.f9668a.f9686p != null) {
                this.f9668a.f9686p.m11131d();
                this.f9668a.f9686p.m11133f();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.6 */
    class C28526 implements Runnable {
        final /* synthetic */ C2855c f9669a;

        C28526(C2855c c2855c) {
            this.f9669a = c2855c;
        }

        public void run() {
            if (this.f9669a.f9686p != null) {
                this.f9669a.f9686p.m11130c();
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.overlay.c.7 */
    class C28537 implements Runnable {
        final /* synthetic */ C2855c f9670a;

        C28537(C2855c c2855c) {
            this.f9670a = c2855c;
        }

        public void run() {
            if (this.f9670a.f9686p != null) {
                this.f9670a.f9686p.m11131d();
            }
        }
    }

    static {
        f9671a = new HashMap();
        f9671a.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        f9671a.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        f9671a.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        f9671a.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        f9671a.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f9671a.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f9671a.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f9671a.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f9671a.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        f9671a.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f9671a.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f9671a.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        f9671a.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f9671a.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        f9671a.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        f9671a.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public C2855c(Context context, C2876t c2876t) {
        super(context);
        this.f9673c = 0;
        this.f9674d = 0;
        this.f9682l = 1.0f;
        setSurfaceTextureListener(this);
        this.f9672b = c2876t;
        this.f9672b.m11183a((C2854i) this);
    }

    private void m11058a(boolean z) {
        hf.m12982e("AdMediaPlayerView release");
        if (this.f9675e != null) {
            this.f9675e.reset();
            this.f9675e.release();
            this.f9675e = null;
            m11060b(0);
            if (z) {
                this.f9674d = 0;
                m11061c(0);
            }
            m11065j();
        }
    }

    private void m11059b(float f) {
        if (this.f9675e != null) {
            try {
                this.f9675e.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        C2972b.m11583d("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private void m11060b(int i) {
        if (i == 3) {
            this.f9672b.m11186c();
        } else if (this.f9673c == 3 && i != 3) {
            this.f9672b.m11187d();
        }
        this.f9673c = i;
    }

    private void m11061c(int i) {
        this.f9674d = i;
    }

    private void m11062g() {
        Throwable e;
        hf.m12982e("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f9676f != null && surfaceTexture != null) {
            m11058a(false);
            try {
                this.f9675e = new MediaPlayer();
                this.f9675e.setOnBufferingUpdateListener(this);
                this.f9675e.setOnCompletionListener(this);
                this.f9675e.setOnErrorListener(this);
                this.f9675e.setOnInfoListener(this);
                this.f9675e.setOnPreparedListener(this);
                this.f9675e.setOnVideoSizeChangedListener(this);
                this.f9679i = 0;
                this.f9675e.setDataSource(getContext(), this.f9676f);
                this.f9675e.setSurface(new Surface(surfaceTexture));
                this.f9675e.setAudioStreamType(3);
                this.f9675e.setScreenOnWhilePlaying(true);
                this.f9675e.prepareAsync();
                m11060b(1);
            } catch (IOException e2) {
                e = e2;
                C2972b.m11584d("Failed to initialize MediaPlayer at " + this.f9676f, e);
                onError(this.f9675e, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                C2972b.m11584d("Failed to initialize MediaPlayer at " + this.f9676f, e);
                onError(this.f9675e, 1, 0);
            }
        }
    }

    private void m11063h() {
        if (m11066k() && this.f9675e.getCurrentPosition() > 0 && this.f9674d != 3) {
            hf.m12982e("AdMediaPlayerView nudging MediaPlayer");
            m11059b(0.0f);
            this.f9675e.start();
            int currentPosition = this.f9675e.getCurrentPosition();
            long a = C2968s.m11529i().m13543a();
            while (m11066k() && this.f9675e.getCurrentPosition() == currentPosition) {
                if (C2968s.m11529i().m13543a() - a > 250) {
                    break;
                }
            }
            this.f9675e.pause();
            m11069n();
        }
    }

    private void m11064i() {
        AudioManager o = m11070o();
        if (o != null && !this.f9684n) {
            if (o.requestAudioFocus(this, 3, 2) == 1) {
                m11067l();
            } else {
                C2972b.m11583d("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void m11065j() {
        hf.m12982e("AdMediaPlayerView abandon audio focus");
        AudioManager o = m11070o();
        if (o != null && this.f9684n) {
            if (o.abandonAudioFocus(this) == 1) {
                this.f9684n = false;
            } else {
                C2972b.m11583d("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean m11066k() {
        return (this.f9675e == null || this.f9673c == -1 || this.f9673c == 0 || this.f9673c == 1) ? false : true;
    }

    private void m11067l() {
        hf.m12982e("AdMediaPlayerView audio focus gained");
        this.f9684n = true;
        m11069n();
    }

    private void m11068m() {
        hf.m12982e("AdMediaPlayerView audio focus lost");
        this.f9684n = false;
        m11069n();
    }

    private void m11069n() {
        if (this.f9683m || !this.f9684n) {
            m11059b(0.0f);
        } else {
            m11059b(this.f9682l);
        }
    }

    private AudioManager m11070o() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    public String m11071a() {
        return "MediaPlayer";
    }

    public void m11072a(float f) {
        this.f9682l = f;
        m11069n();
    }

    public void m11073a(int i) {
        hf.m12982e("AdMediaPlayerView seek " + i);
        if (m11066k()) {
            this.f9675e.seekTo(i);
            this.f9685o = 0;
            return;
        }
        this.f9685o = i;
    }

    public void m11074a(C2867h c2867h) {
        this.f9686p = c2867h;
    }

    public void m11075b() {
        hf.m12982e("AdMediaPlayerView stop");
        if (this.f9675e != null) {
            this.f9675e.stop();
            this.f9675e.release();
            this.f9675e = null;
            m11060b(0);
            m11061c(0);
            m11065j();
        }
        this.f9672b.m11184b();
    }

    public void m11076c() {
        hf.m12982e("AdMediaPlayerView play");
        if (m11066k()) {
            this.f9675e.start();
            m11060b(3);
            hj.f11297a.post(new C28526(this));
        }
        m11061c(3);
    }

    public void m11077d() {
        hf.m12982e("AdMediaPlayerView pause");
        if (m11066k() && this.f9675e.isPlaying()) {
            this.f9675e.pause();
            m11060b(4);
            hj.f11297a.post(new C28537(this));
        }
        m11061c(4);
    }

    public void m11078e() {
        this.f9683m = true;
        m11069n();
    }

    public void m11079f() {
        this.f9683m = false;
        m11069n();
    }

    public int getCurrentPosition() {
        return m11066k() ? this.f9675e.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return m11066k() ? this.f9675e.getDuration() : -1;
    }

    public int getVideoHeight() {
        return this.f9675e != null ? this.f9675e.getVideoHeight() : 0;
    }

    public int getVideoWidth() {
        return this.f9675e != null ? this.f9675e.getVideoWidth() : 0;
    }

    public void onAudioFocusChange(int i) {
        if (i > 0) {
            m11067l();
        } else if (i < 0) {
            m11068m();
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f9679i = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        hf.m12982e("AdMediaPlayerView completion");
        m11060b(5);
        m11061c(5);
        hj.f11297a.post(new C28482(this));
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f9671a.get(Integer.valueOf(i));
        String str2 = (String) f9671a.get(Integer.valueOf(i2));
        C2972b.m11583d("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        m11060b(-1);
        m11061c(-1);
        hj.f11297a.post(new C28493(this, str, str2));
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f9671a.get(Integer.valueOf(i2));
        hf.m12982e("AdMediaPlayerView MediaPlayer info: " + ((String) f9671a.get(Integer.valueOf(i))) + ":" + str);
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = C2855c.getDefaultSize(this.f9677g, i);
        int defaultSize2 = C2855c.getDefaultSize(this.f9678h, i2);
        if (this.f9677g > 0 && this.f9678h > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f9677g * defaultSize2 < this.f9678h * size) {
                    defaultSize = (this.f9677g * defaultSize2) / this.f9678h;
                } else if (this.f9677g * defaultSize2 > this.f9678h * size) {
                    defaultSize2 = (this.f9678h * size) / this.f9677g;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f9678h * size) / this.f9677g;
                if (mode2 != LinearLayoutManager.INVALID_OFFSET || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f9677g * defaultSize2) / this.f9678h;
                if (mode == LinearLayoutManager.INVALID_OFFSET && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f9677g;
                defaultSize = this.f9678h;
                if (mode2 != LinearLayoutManager.INVALID_OFFSET || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f9677g * defaultSize2) / this.f9678h;
                }
                if (mode == LinearLayoutManager.INVALID_OFFSET && r1 > size) {
                    defaultSize2 = (this.f9678h * size) / this.f9677g;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (VERSION.SDK_INT == 16) {
            if ((this.f9680j > 0 && this.f9680j != defaultSize) || (this.f9681k > 0 && this.f9681k != defaultSize2)) {
                m11063h();
            }
            this.f9680j = defaultSize;
            this.f9681k = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        hf.m12982e("AdMediaPlayerView prepared");
        m11060b(2);
        this.f9672b.m11182a();
        hj.f11297a.post(new C28471(this));
        this.f9677g = mediaPlayer.getVideoWidth();
        this.f9678h = mediaPlayer.getVideoHeight();
        if (this.f9685o != 0) {
            m11073a(this.f9685o);
        }
        m11063h();
        C2972b.m11581c("AdMediaPlayerView stream dimensions: " + this.f9677g + " x " + this.f9678h);
        if (this.f9674d == 3) {
            m11076c();
        }
        m11064i();
        m11069n();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        hf.m12982e("AdMediaPlayerView surface created");
        m11062g();
        hj.f11297a.post(new C28504(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        hf.m12982e("AdMediaPlayerView surface destroyed");
        if (this.f9675e != null && this.f9685o == 0) {
            this.f9685o = this.f9675e.getCurrentPosition();
        }
        hj.f11297a.post(new C28515(this));
        m11058a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Object obj = 1;
        hf.m12982e("AdMediaPlayerView surface changed");
        Object obj2 = this.f9674d == 3 ? 1 : null;
        if (!(this.f9677g == i && this.f9678h == i2)) {
            obj = null;
        }
        if (this.f9675e != null && obj2 != null && r1 != null) {
            if (this.f9685o != 0) {
                m11073a(this.f9685o);
            }
            m11076c();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f9672b.m11185b(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        hf.m12982e("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.f9677g = mediaPlayer.getVideoWidth();
        this.f9678h = mediaPlayer.getVideoHeight();
        if (this.f9677g != 0 && this.f9678h != 0) {
            requestLayout();
        }
    }

    public void setMimeType(String str) {
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.f9676f = uri;
        this.f9685o = 0;
        m11062g();
        requestLayout();
        invalidate();
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
