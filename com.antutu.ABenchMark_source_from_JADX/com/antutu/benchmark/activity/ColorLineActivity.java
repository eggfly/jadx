package com.antutu.benchmark.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Utils;
import com.antutu.utils.widget.SystemBarTintManager;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

public class ColorLineActivity extends C1197a {
    private LayoutParams f4092a;
    private LayoutParams f4093b;
    private int f4094c;
    private ArrayList<LinearLayout> f4095d;
    private LinearLayout f4096e;
    private String[] f4097f;
    private View f4098g;
    private ImageView f4099h;
    private AnimationDrawable f4100i;
    private int f4101k;
    private AlphaAnimation f4102l;
    private C1219a f4103m;
    private boolean f4104n;
    private View f4105o;
    private TextView f4106p;
    private SharedPreferences f4107q;

    /* renamed from: com.antutu.benchmark.activity.ColorLineActivity.1 */
    class C12151 implements OnClickListener {
        final /* synthetic */ ColorLineActivity f4087a;

        C12151(ColorLineActivity colorLineActivity) {
            this.f4087a = colorLineActivity;
        }

        public void onClick(View view) {
            this.f4087a.f4098g.setVisibility(8);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ColorLineActivity.2 */
    class C12162 implements AnimationListener {
        final /* synthetic */ ColorLineActivity f4088a;

        C12162(ColorLineActivity colorLineActivity) {
            this.f4088a = colorLineActivity;
        }

        public void onAnimationEnd(Animation animation) {
            this.f4088a.f4105o.setVisibility(8);
            this.f4088a.f4104n = true;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f4088a.f4104n = false;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ColorLineActivity.3 */
    class C12173 implements OnClickListener {
        final /* synthetic */ ColorLineActivity f4089a;

        C12173(ColorLineActivity colorLineActivity) {
            this.f4089a = colorLineActivity;
        }

        public void onClick(View view) {
            this.f4089a.f4098g.setVisibility(8);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ColorLineActivity.4 */
    class C12184 implements OnClickListener {
        final /* synthetic */ ColorLineActivity f4090a;

        C12184(ColorLineActivity colorLineActivity) {
            this.f4090a = colorLineActivity;
        }

        public void onClick(View view) {
            this.f4090a.f4098g.setVisibility(8);
            this.f4090a.m5002a();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ColorLineActivity.a */
    public class C1219a extends CountDownTimer {
        final /* synthetic */ ColorLineActivity f4091a;

        public C1219a(ColorLineActivity colorLineActivity, long j, long j2) {
            this.f4091a = colorLineActivity;
            super(j, j2);
        }

        public void onFinish() {
            this.f4091a.m5002a();
        }

        public void onTick(long j) {
        }
    }

    public ColorLineActivity() {
        this.f4092a = new LayoutParams(-1, -1);
        this.f4093b = new LayoutParams(-1, 0);
        this.f4094c = 1;
        this.f4095d = new ArrayList();
        this.f4101k = 0;
        this.f4104n = true;
    }

    private LinearLayout m4998a(int i) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(this.f4092a);
        linearLayout.setLayerType(1, null);
        linearLayout.setBackgroundDrawable(getResources().getDrawable(i));
        return linearLayout;
    }

    private LinearLayout m4999a(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(this.f4092a);
        linearLayout.setLayerType(1, null);
        linearLayout.setOrientation(1);
        View imageView = new ImageView(this);
        imageView.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        imageView.setBackgroundDrawable(getResources().getDrawable(i));
        View imageView2 = new ImageView(this);
        imageView2.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        imageView2.setBackgroundDrawable(getResources().getDrawable(i2));
        linearLayout.addView(imageView2);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private LinearLayout m5000a(int i, int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i4 = displayMetrics.widthPixels;
        int i5 = (displayMetrics.heightPixels * 4) / 3;
        i4 = (i4 - i5) / 2;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(this.f4092a);
        linearLayout.setLayerType(1, null);
        linearLayout.setOrientation(0);
        View view = new View(this);
        View view2 = new View(this);
        view.setLayoutParams(new LayoutParams(i4, -1));
        view.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        view2.setLayoutParams(new LayoutParams(i4, -1));
        view2.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LayoutParams(i5, -1));
        linearLayout2.setOrientation(1);
        View imageView = new ImageView(this);
        View imageView2 = new ImageView(this);
        View imageView3 = new ImageView(this);
        imageView.setLayoutParams(new LayoutParams(-1, 0, 3.0f));
        imageView2.setLayoutParams(new LayoutParams(-1, 0, 1.0f));
        imageView3.setLayoutParams(new LayoutParams(-1, 0, 5.0f));
        imageView.setBackgroundDrawable(getResources().getDrawable(i));
        imageView2.setBackgroundDrawable(getResources().getDrawable(i2));
        imageView3.setBackgroundDrawable(getResources().getDrawable(i3));
        linearLayout2.addView(imageView3);
        linearLayout2.addView(imageView2);
        linearLayout2.addView(imageView);
        linearLayout.addView(view);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(view2);
        return linearLayout;
    }

    private LinearLayout m5001a(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(this.f4092a);
        linearLayout.setOrientation(1);
        linearLayout.setLayerType(1, null);
        View imageView = new ImageView(this);
        View imageView2 = new ImageView(this);
        View imageView3 = new ImageView(this);
        View imageView4 = new ImageView(this);
        imageView.setLayoutParams(new LayoutParams(-1, 0, 58.0f));
        imageView2.setLayoutParams(new LayoutParams(-1, 0, 13.0f));
        imageView3.setLayoutParams(new LayoutParams(-1, 0, 13.0f));
        imageView4.setLayoutParams(new LayoutParams(-1, 0, 90.0f));
        imageView.setBackgroundDrawable(getResources().getDrawable(i));
        imageView2.setBackgroundDrawable(getResources().getDrawable(i2));
        imageView3.setBackgroundDrawable(getResources().getDrawable(i3));
        imageView4.setBackgroundDrawable(getResources().getDrawable(i4));
        linearLayout.addView(imageView4);
        linearLayout.addView(imageView3);
        linearLayout.addView(imageView2);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private void m5002a() {
        this.f4105o.startAnimation(this.f4102l);
    }

    private LinearLayout m5005b(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = (displayMetrics.heightPixels * 4) / 3;
        i2 = (i2 - i3) / 2;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setLayerType(1, null);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, -1);
        View view = new View(this);
        View view2 = new View(this);
        view.setLayoutParams(new LayoutParams(i2, -1));
        view.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        view2.setLayoutParams(new LayoutParams(i2, -1));
        view2.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundDrawable(getResources().getDrawable(i));
        linearLayout.addView(view);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(view2);
        return linearLayout;
    }

    private void m5006b() {
        this.f4102l = new AlphaAnimation(1.0f, 0.0f);
        this.f4102l.setDuration(500);
        this.f4102l.setAnimationListener(new C12162(this));
        this.f4099h = (ImageView) findViewById(C1082R.id.intro_anim);
        this.f4100i = new AnimationDrawable();
        this.f4100i.addFrame(getResources().getDrawable(C1082R.drawable.anim_1), 100);
        this.f4100i.addFrame(getResources().getDrawable(C1082R.drawable.anim_2), 100);
        this.f4100i.addFrame(getResources().getDrawable(C1082R.drawable.anim_3), 100);
        this.f4100i.addFrame(getResources().getDrawable(C1082R.drawable.anim_4), 100);
        this.f4100i.addFrame(getResources().getDrawable(C1082R.drawable.anim_5), 100);
        this.f4100i.addFrame(getResources().getDrawable(C1082R.drawable.anim_6), 100);
        this.f4100i.setOneShot(false);
        this.f4099h.setBackgroundDrawable(this.f4100i);
        if (!(this.f4100i == null || this.f4100i.isRunning())) {
            this.f4100i.start();
            this.f4107q.edit().putBoolean("isAnimated_colorline", true).commit();
        }
        this.f4099h.setOnClickListener(new C12173(this));
        this.f4098g.setOnClickListener(new C12184(this));
    }

    private void m5007c() {
        this.f4096e.removeViewAt(0);
        try {
            if (this.f4094c + 1 >= this.f4095d.size()) {
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, -1);
                this.f4105o.setLayoutParams(layoutParams);
            }
            this.f4096e.addView((View) this.f4095d.get(this.f4094c));
            this.f4105o.setVisibility(0);
            this.f4106p.setText(this.f4097f[this.f4094c]);
            this.f4103m.start();
        } catch (Exception e) {
            finish();
        }
        this.f4094c++;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.color_line_layout);
        this.f4103m = new C1219a(this, 2000, 1000);
        this.f4107q = getSharedPreferences("other_record", 0);
        this.f4098g = findViewById(C1082R.id.intro);
        this.f4098g.setOnClickListener(new C12151(this));
        this.f4101k = Utils.getScreenBrightness(this);
        Utils.setScreenBrightness(this, MotionEventCompat.ACTION_MASK);
        m5006b();
        this.f4097f = getResources().getStringArray(C1082R.array.color_bar_tips);
        this.f4096e = (LinearLayout) findViewById(C1692R.id.container);
        this.f4105o = findViewById(C1082R.id.ttp);
        this.f4106p = (TextView) this.f4105o.findViewById(C1082R.id.title_tip);
        View a = m4999a((int) C1082R.drawable.step01_left, (int) C1082R.drawable.step01_right);
        LinearLayout a2 = m4999a((int) C1082R.drawable.step02_left, (int) C1082R.drawable.step02_right);
        LinearLayout b = m5005b((int) C1082R.drawable.step03_color);
        LinearLayout b2 = m5005b((int) C1082R.drawable.step04_color);
        LinearLayout a3 = m4998a((int) C1082R.drawable.step05_color);
        LinearLayout a4 = m4998a((int) C1082R.drawable.step06_color);
        LinearLayout a5 = m5000a(C1082R.drawable.step07_no1, C1082R.drawable.step07_no2, C1082R.drawable.step07_no3);
        LinearLayout a6 = m5001a(C1082R.drawable.step08_no1, C1082R.drawable.step08_no2, C1082R.drawable.step08_no3, C1082R.drawable.step08_no4);
        this.f4095d.add(a);
        this.f4095d.add(a2);
        this.f4095d.add(b);
        this.f4095d.add(b2);
        this.f4095d.add(a3);
        this.f4095d.add(a4);
        this.f4095d.add(a5);
        this.f4095d.add(a6);
        this.f4096e.addView(a, 0);
        this.f4106p.setText(this.f4097f[this.f4094c]);
        this.f4107q = getSharedPreferences("other_record", 0);
        if (this.f4107q.getBoolean("isAnimated_colorline", false)) {
            this.f4098g.setVisibility(8);
        } else {
            m5002a();
        }
    }

    public void onDestroy() {
        if (this.f4101k != -1) {
            Utils.setScreenBrightness(this, this.f4101k);
        }
        super.onDestroy();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4098g.getVisibility() != 8) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (this.f4104n) {
                    m5007c();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
