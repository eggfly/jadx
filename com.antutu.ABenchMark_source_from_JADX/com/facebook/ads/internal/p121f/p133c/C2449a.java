package com.facebook.ads.internal.p121f.p133c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.antutu.utils.widget.SystemBarTintManager;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.InterstitialAdActivity.Type;
import com.facebook.ads.NativeAdVideoActivity;
import com.facebook.ads.internal.adapters.C2310e;
import com.facebook.ads.internal.adapters.C2310e.C2266a;
import com.facebook.ads.internal.p121f.p133c.p134a.C2446a;
import com.facebook.ads.internal.p121f.p133c.p134a.C2447b;
import com.facebook.ads.internal.p121f.p133c.p134a.C2448c;
import com.facebook.ads.internal.util.C2290u;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2507o;
import com.facebook.ads.internal.util.C2512t;
import com.umeng.message.proguard.C4233j;
import java.util.Map;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.f.c.a */
public class C2449a extends FrameLayout implements C2448c {
    private C2446a f8433a;
    private ImageView f8434b;
    private ProgressBar f8435c;
    private C2445c f8436d;
    private C2310e f8437e;
    private String f8438f;
    private int f8439g;
    private String f8440h;
    private String f8441i;
    private boolean f8442j;
    private int f8443k;
    private Handler f8444l;
    private Handler f8445m;
    private Runnable f8446n;
    private Runnable f8447o;

    /* renamed from: com.facebook.ads.internal.f.c.a.1 */
    class C24371 extends C2266a {
        final /* synthetic */ C2449a f8403a;

        C24371(C2449a c2449a) {
            this.f8403a = c2449a;
        }

        public void m9306a() {
            if (this.f8403a.f8442j) {
                this.f8403a.m9334b();
            }
        }

        public void m9307b() {
            this.f8403a.m9335c();
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.2 */
    class C24382 implements OnTouchListener {
        final /* synthetic */ C2449a f8404a;

        C24382(C2449a c2449a) {
            this.f8404a = c2449a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || this.f8404a.f8438f == null) {
                return false;
            }
            this.f8404a.m9328f();
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.3 */
    class C24393 implements OnClickListener {
        final /* synthetic */ C2449a f8405a;

        C24393(C2449a c2449a) {
            this.f8405a = c2449a;
        }

        public void onClick(View view) {
            if (this.f8405a.f8438f != null) {
                this.f8405a.m9328f();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.4 */
    class C24404 implements OnTouchListener {
        final /* synthetic */ C2449a f8406a;

        C24404(C2449a c2449a) {
            this.f8406a = c2449a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (this.f8406a.f8436d.m9313c()) {
                this.f8406a.m9334b();
                return true;
            }
            this.f8406a.m9335c();
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.5 */
    class C24415 implements OnClickListener {
        final /* synthetic */ C2449a f8407a;

        C24415(C2449a c2449a) {
            this.f8407a = c2449a;
        }

        public void onClick(View view) {
            if (this.f8407a.f8436d.m9313c()) {
                this.f8407a.m9334b();
            } else {
                this.f8407a.m9335c();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.a */
    private static final class C2442a extends C2290u<C2449a> {
        public C2442a(C2449a c2449a) {
            super(c2449a);
        }

        public void run() {
            C2449a c2449a = (C2449a) m8655a();
            if (c2449a != null) {
                if (c2449a.f8433a.getCurrentPosition() > c2449a.f8439g) {
                    new C2507o(C2512t.m9520a(((C2449a) m8655a()).getContext(), c2449a.getAutoplay(), true)).execute(new String[]{c2449a.getVideoPlayReportURI()});
                    return;
                }
                c2449a.f8444l.postDelayed(this, 250);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.b */
    private static final class C2443b extends C2290u<C2449a> {
        public C2443b(C2449a c2449a) {
            super(c2449a);
        }

        public void run() {
            C2449a c2449a = (C2449a) m8655a();
            if (c2449a != null && c2449a != null) {
                int currentPosition = c2449a.f8433a.getCurrentPosition();
                if (currentPosition > c2449a.f8443k) {
                    c2449a.f8443k = currentPosition;
                }
                c2449a.f8445m.postDelayed(this, 250);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a.c */
    class C2445c extends Button {
        final /* synthetic */ C2449a f8409a;
        private Paint f8410b;
        private Path f8411c;
        private Path f8412d;
        private Path f8413e;
        private int f8414f;
        private boolean f8415g;

        /* renamed from: com.facebook.ads.internal.f.c.a.c.1 */
        class C24441 extends Paint {
            final /* synthetic */ C2445c f8408a;

            C24441(C2445c c2445c) {
                this.f8408a = c2445c;
                setStyle(Style.FILL_AND_STROKE);
                setStrokeCap(Cap.ROUND);
                setStrokeWidth(3.0f);
                setAntiAlias(true);
                setColor(-1);
            }
        }

        public C2445c(C2449a c2449a, Context context) {
            this.f8409a = c2449a;
            super(context);
            this.f8415g = true;
            m9308a();
        }

        private void m9308a() {
            this.f8414f = 60;
            this.f8411c = new Path();
            this.f8412d = new Path();
            this.f8413e = new Path();
            this.f8410b = new C24441(this);
            m9312b();
            setClickable(true);
            setBackgroundColor(0);
        }

        private void m9310a(boolean z) {
            this.f8415g = z;
            refreshDrawableState();
            invalidate();
        }

        private void m9312b() {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f8414f) * displayMetrics.density), (int) (displayMetrics.density * ((float) this.f8414f)));
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            setLayoutParams(layoutParams);
        }

        private boolean m9313c() {
            return this.f8415g;
        }

        protected void onDraw(Canvas canvas) {
            if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            float max = ((float) Math.max(canvas.getWidth(), canvas.getHeight())) / 100.0f;
            if (m9313c()) {
                this.f8413e.rewind();
                this.f8413e.moveTo(26.5f * max, 15.5f * max);
                this.f8413e.lineTo(26.5f * max, 84.5f * max);
                this.f8413e.lineTo(82.5f * max, 50.5f * max);
                this.f8413e.lineTo(26.5f * max, max * 15.5f);
                this.f8413e.close();
                canvas.drawPath(this.f8413e, this.f8410b);
            } else {
                this.f8411c.rewind();
                this.f8411c.moveTo(29.0f * max, 21.0f * max);
                this.f8411c.lineTo(29.0f * max, 79.0f * max);
                this.f8411c.lineTo(45.0f * max, 79.0f * max);
                this.f8411c.lineTo(45.0f * max, 21.0f * max);
                this.f8411c.lineTo(29.0f * max, 21.0f * max);
                this.f8411c.close();
                this.f8412d.rewind();
                this.f8412d.moveTo(55.0f * max, 21.0f * max);
                this.f8412d.lineTo(55.0f * max, 79.0f * max);
                this.f8412d.lineTo(71.0f * max, 79.0f * max);
                this.f8412d.lineTo(71.0f * max, 21.0f * max);
                this.f8412d.lineTo(55.0f * max, max * 21.0f);
                this.f8412d.close();
                canvas.drawPath(this.f8411c, this.f8410b);
                canvas.drawPath(this.f8412d, this.f8410b);
            }
            super.onDraw(canvas);
        }
    }

    public C2449a(Context context) {
        super(context);
        m9324d();
    }

    private void m9318a(Context context, Intent intent) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        intent.putExtra("useNativeCloseButton", true);
        intent.putExtra(InterstitialAdActivity.VIEW_TYPE, Type.VIDEO);
        intent.putExtra(InterstitialAdActivity.VIDEO_URL, this.f8438f);
        intent.putExtra(InterstitialAdActivity.VIDEO_PLAY_REPORT_URL, getVideoPlayReportURI());
        intent.putExtra(InterstitialAdActivity.VIDEO_TIME_REPORT_URL, getVideoTimeReportURI());
        intent.putExtra(InterstitialAdActivity.PREDEFINED_ORIENTATION_KEY, 13);
        intent.putExtra(InterstitialAdActivity.AUTOPLAY, getAutoplay());
        intent.addFlags(268435456);
    }

    private boolean m9320a(Class<?> cls) {
        try {
            Context context = getContext();
            Intent intent = new Intent(context, cls);
            m9318a(context, intent);
            context.startActivity(intent);
            return true;
        } catch (Throwable e) {
            C2490c.m9456a(C2489b.m9453a(e, "Error occurred while loading fullscreen video activity."));
            return false;
        }
    }

    private void m9324d() {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f8433a = new C2446a(getContext());
        this.f8433a.setVideoStateChangeListener(this);
        addView(this.f8433a, layoutParams);
        this.f8434b = new ImageView(getContext());
        this.f8434b.setScaleType(ScaleType.CENTER_CROP);
        this.f8434b.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        addView(this.f8434b, layoutParams);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.f8435c = new ProgressBar(getContext());
        this.f8435c.setIndeterminate(true);
        this.f8435c.getIndeterminateDrawable().setColorFilter(-1, Mode.SRC_IN);
        this.f8435c.setVisibility(8);
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams2.gravity = 17;
        addView(this.f8435c, layoutParams2);
        this.f8445m = new Handler();
        this.f8446n = new C2443b(this);
        this.f8445m.postDelayed(this.f8446n, 250);
        this.f8444l = new Handler();
        this.f8447o = new C2442a(this);
        this.f8444l.postDelayed(this.f8447o, 250);
        this.f8439g = 10000;
        this.f8437e = new C2310e(getContext(), this, 50, true, new C24371(this));
        this.f8437e.m8811a(0);
        this.f8437e.m8813b(250);
        this.f8437e.m8810a();
        setOnTouchListenerInternal(new C24382(this));
        setOnClickListenerInternal(new C24393(this));
        this.f8436d = new C2445c(this, getContext());
        this.f8436d.setLayoutParams(new FrameLayout.LayoutParams(100, 100, 80));
        this.f8436d.setOnTouchListener(new C24404(this));
        this.f8436d.setOnClickListener(new C24415(this));
        addView(this.f8436d);
    }

    private void m9326e() {
        if (getVideoTimeReportURI() != null) {
            Map a = C2512t.m9520a(getContext(), getAutoplay(), true);
            a.put(C4233j.f14377D, Integer.toString(this.f8443k / AdError.NETWORK_ERROR_CODE));
            new C2507o(a).execute(new String[]{getVideoTimeReportURI()});
            this.f8443k = 0;
        }
    }

    private void m9328f() {
        if (!m9320a(NativeAdVideoActivity.class)) {
            m9320a(InterstitialAdActivity.class);
        }
    }

    private void setOnClickListenerInternal(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    private void setOnTouchListenerInternal(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void m9332a() {
        if (this.f8443k > 0) {
            m9326e();
            this.f8443k = 0;
        }
    }

    public void m9333a(MediaPlayer mediaPlayer, C2447b c2447b) {
        int i = 8;
        if (c2447b == C2447b.PREPARED) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.setLooping(false);
            this.f8434b.setVisibility(0);
        } else if (c2447b == C2447b.STARTED) {
            this.f8434b.setVisibility(8);
        } else if (c2447b == C2447b.PLAYBACK_COMPLETED || c2447b == C2447b.ERROR) {
            this.f8436d.m9310a(true);
            this.f8434b.setVisibility(0);
        }
        ProgressBar progressBar = this.f8435c;
        if (c2447b == C2447b.PREPARING || c2447b == C2447b.BUFFERING) {
            i = 0;
        }
        progressBar.setVisibility(i);
    }

    public void m9334b() {
        this.f8436d.m9310a(false);
        this.f8433a.m9314a();
    }

    public void m9335c() {
        this.f8436d.m9310a(true);
        this.f8433a.m9315b();
    }

    public boolean getAutoplay() {
        return this.f8442j;
    }

    public ImageView getPlaceholderView() {
        return this.f8434b;
    }

    public String getVideoPlayReportURI() {
        return this.f8440h;
    }

    public String getVideoTimeReportURI() {
        return this.f8441i;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8437e.m8810a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9326e();
        this.f8437e.m8812b();
    }

    public void setAutoplay(boolean z) {
        this.f8442j = z;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void setVideoPlayReportMS(int i) {
        this.f8439g = i;
    }

    public void setVideoPlayReportURI(String str) {
        this.f8440h = str;
    }

    public void setVideoTimeReportURI(String str) {
        m9332a();
        this.f8441i = str;
    }

    public void setVideoURI(String str) {
        this.f8438f = str;
        if (str != null) {
            this.f8433a.setup(Uri.parse(str));
            if (this.f8442j) {
                m9334b();
            }
        }
    }
}
