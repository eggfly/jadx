package com.antutu.benchmark.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.MotionEventCompat;
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
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

public class HuijieActivity extends C1197a {
    private String[] f4246a;
    private LayoutParams f4247b;
    private int f4248c;
    private int f4249d;
    private LinearLayout f4250e;
    private View f4251f;
    private View f4252g;
    private TextView f4253h;
    private ImageView f4254i;
    private AnimationDrawable f4255k;
    private ArrayList<LinearLayout> f4256l;
    private AlphaAnimation f4257m;
    private C1251a f4258n;
    private boolean f4259o;

    /* renamed from: com.antutu.benchmark.activity.HuijieActivity.1 */
    class C12481 implements AnimationListener {
        final /* synthetic */ HuijieActivity f4242a;

        C12481(HuijieActivity huijieActivity) {
            this.f4242a = huijieActivity;
        }

        public void onAnimationEnd(Animation animation) {
            this.f4242a.f4252g.setVisibility(8);
            this.f4242a.f4259o = true;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f4242a.f4259o = false;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.HuijieActivity.2 */
    class C12492 implements OnClickListener {
        final /* synthetic */ HuijieActivity f4243a;

        C12492(HuijieActivity huijieActivity) {
            this.f4243a = huijieActivity;
        }

        public void onClick(View view) {
            this.f4243a.f4251f.setVisibility(8);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.HuijieActivity.3 */
    class C12503 implements OnClickListener {
        final /* synthetic */ HuijieActivity f4244a;

        C12503(HuijieActivity huijieActivity) {
            this.f4244a = huijieActivity;
        }

        public void onClick(View view) {
            this.f4244a.f4251f.setVisibility(8);
            this.f4244a.m5110b();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.HuijieActivity.a */
    public class C1251a extends CountDownTimer {
        final /* synthetic */ HuijieActivity f4245a;

        public C1251a(HuijieActivity huijieActivity, long j, long j2) {
            this.f4245a = huijieActivity;
            super(j, j2);
        }

        public void onFinish() {
            this.f4245a.m5110b();
        }

        public void onTick(long j) {
        }
    }

    public HuijieActivity() {
        this.f4247b = new LayoutParams(-1, -1);
        this.f4248c = 1;
        this.f4249d = 0;
        this.f4256l = new ArrayList();
        this.f4259o = true;
    }

    private LinearLayout m5104a(int i) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(this.f4247b);
        linearLayout.setLayerType(1, null);
        linearLayout.setBackgroundDrawable(getResources().getDrawable(i));
        return linearLayout;
    }

    private LinearLayout m5105a(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(this.f4247b);
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

    private void m5106a(boolean z) {
        this.f4257m = new AlphaAnimation(1.0f, 0.0f);
        this.f4257m.setDuration(500);
        this.f4257m.setAnimationListener(new C12481(this));
        this.f4251f = findViewById(C1082R.id.intro);
        if (z) {
            this.f4251f.setVisibility(8);
            this.f4253h.setText(this.f4246a[this.f4248c]);
            return;
        }
        this.f4254i = (ImageView) findViewById(C1082R.id.intro_anim);
        this.f4255k = new AnimationDrawable();
        this.f4255k.addFrame(getResources().getDrawable(C1082R.drawable.anim_1), 100);
        this.f4255k.addFrame(getResources().getDrawable(C1082R.drawable.anim_2), 100);
        this.f4255k.addFrame(getResources().getDrawable(C1082R.drawable.anim_3), 100);
        this.f4255k.addFrame(getResources().getDrawable(C1082R.drawable.anim_4), 100);
        this.f4255k.addFrame(getResources().getDrawable(C1082R.drawable.anim_5), 100);
        this.f4255k.addFrame(getResources().getDrawable(C1082R.drawable.anim_6), 100);
        this.f4255k.setOneShot(false);
        this.f4254i.setBackgroundDrawable(this.f4255k);
        if (!(this.f4255k == null || this.f4255k.isRunning())) {
            this.f4255k.start();
            getSharedPreferences("other_record", 0).edit().putBoolean("isAnimated_huijie", true).commit();
        }
        this.f4254i.setOnClickListener(new C12492(this));
        this.f4251f.setOnClickListener(new C12503(this));
    }

    private boolean m5107a() {
        return getSharedPreferences("other_record", 0).getBoolean("isAnimated_huijie", false);
    }

    private void m5110b() {
        this.f4252g.startAnimation(this.f4257m);
    }

    private void m5111c() {
        this.f4250e = (LinearLayout) findViewById(C1692R.id.container);
        this.f4252g = findViewById(C1082R.id.ttp);
        this.f4253h = (TextView) this.f4252g.findViewById(C1082R.id.title_tip);
        View a = m5105a((int) C1082R.drawable.step_left1, (int) C1082R.drawable.step_right1);
        this.f4256l.add(a);
        this.f4256l.add(m5104a((int) C1082R.drawable.step02));
        this.f4256l.add(m5104a((int) C1082R.drawable.step03));
        this.f4256l.add(m5104a((int) C1082R.drawable.step04));
        this.f4256l.add(m5104a((int) C1082R.drawable.step05));
        this.f4256l.add(m5104a((int) C1082R.drawable.step06));
        this.f4256l.add(m5104a((int) C1082R.drawable.step07));
        this.f4256l.add(m5104a((int) C1082R.drawable.step08));
        this.f4256l.add(m5104a((int) C1082R.drawable.step09));
        this.f4256l.add(m5104a((int) C1082R.drawable.step10));
        this.f4256l.add(m5104a((int) C1082R.drawable.step11));
        this.f4256l.add(m5104a((int) C1082R.drawable.pic_anjie1));
        this.f4256l.add(m5104a((int) C1082R.drawable.pic_anjie2));
        this.f4256l.add(m5104a((int) C1082R.drawable.pic_liangjie));
        this.f4256l.add(m5105a((int) C1082R.drawable.step15_left, (int) C1082R.drawable.step15_right));
        this.f4256l.add(m5105a((int) C1082R.drawable.step16_left, (int) C1082R.drawable.step16_right));
        this.f4256l.add(m5105a((int) C1082R.drawable.step17_left, (int) C1082R.drawable.step17_right));
        this.f4256l.add(m5104a((int) C1082R.drawable.step18));
        this.f4256l.add(m5104a((int) C1082R.drawable.step19));
        this.f4256l.add(m5104a((int) C1082R.drawable.red_gradient));
        this.f4256l.add(m5104a((int) C1082R.drawable.step21));
        this.f4256l.add(m5104a((int) C1082R.drawable.step22));
        this.f4256l.add(m5104a((int) C1082R.drawable.green_gradient));
        this.f4256l.add(m5104a((int) C1082R.drawable.step24));
        this.f4256l.add(m5104a((int) C1082R.drawable.step25));
        this.f4256l.add(m5104a((int) C1082R.drawable.blue_gradient));
        this.f4250e.addView(a, 0);
    }

    private void m5113d() {
        this.f4250e.removeViewAt(0);
        try {
            if (this.f4248c + 1 >= this.f4256l.size()) {
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, -1);
                this.f4252g.setLayoutParams(layoutParams);
            }
            this.f4250e.addView((View) this.f4256l.get(this.f4248c));
            this.f4252g.setVisibility(0);
            this.f4253h.setText(this.f4246a[this.f4248c]);
            this.f4258n.start();
        } catch (Exception e) {
            finish();
        }
        this.f4248c++;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        this.f4249d = Utils.getScreenBrightness(this);
        Utils.setScreenBrightness(this, MotionEventCompat.ACTION_MASK);
        this.f4246a = getResources().getStringArray(C1082R.array.test_title);
        this.f4258n = new C1251a(this, 2000, 1000);
        setContentView(C1082R.layout.huijie_layout);
        boolean a = m5107a();
        m5111c();
        m5106a(a);
        this.f4253h.setText(this.f4246a[this.f4248c]);
        if (a) {
            this.f4251f.setVisibility(8);
        } else {
            m5110b();
        }
    }

    public void onDestroy() {
        if (this.f4249d != -1) {
            Utils.setScreenBrightness(this, this.f4249d);
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4251f.getVisibility() != 8) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (this.f4259o) {
                    m5113d();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
