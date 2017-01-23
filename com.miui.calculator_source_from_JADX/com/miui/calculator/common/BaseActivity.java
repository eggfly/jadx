package com.miui.calculator.common;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.miui.calculator.cal.CalculatorActivity;
import com.miui.calculator.common.utils.AnimationUtils;
import com.miui.calculator.common.utils.AnimationUtils.ExitAnimationEndListener;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;

public class BaseActivity extends Activity {
    private TextView f1372a;
    private View f1373b;
    private int f1374c;
    private int f1375d;
    private boolean f1376e;
    private boolean f1377f;
    private boolean f1378g;
    private boolean f1379h;

    /* renamed from: com.miui.calculator.common.BaseActivity.1 */
    class C01711 implements OnClickListener {
        final /* synthetic */ BaseActivity f1515a;

        /* renamed from: com.miui.calculator.common.BaseActivity.1.1 */
        class C01701 implements ExitAnimationEndListener {
            final /* synthetic */ C01711 f1514a;

            C01701(C01711 c01711) {
                this.f1514a = c01711;
            }

            public void m2795a() {
                this.f1514a.f1515a.m2638g();
                this.f1514a.f1515a.f1378g = false;
            }
        }

        C01711(BaseActivity baseActivity) {
            this.f1515a = baseActivity;
        }

        public void onClick(View view) {
            if (!this.f1515a.m2635d()) {
                this.f1515a.m2638g();
            } else if (!this.f1515a.f1378g) {
                AnimationUtils.m2799a(this.f1515a.f1373b, this.f1515a.f1374c, this.f1515a.f1375d, new C01701(this));
            }
        }
    }

    /* renamed from: com.miui.calculator.common.BaseActivity.2 */
    class C01722 implements OnPreDrawListener {
        final /* synthetic */ BaseActivity f1516a;

        C01722(BaseActivity baseActivity) {
            this.f1516a = baseActivity;
        }

        public boolean onPreDraw() {
            this.f1516a.f1373b.getViewTreeObserver().removeOnPreDrawListener(this);
            AnimationUtils.m2798a(this.f1516a.f1373b, this.f1516a.f1374c, this.f1516a.f1375d);
            return true;
        }
    }

    /* renamed from: com.miui.calculator.common.BaseActivity.3 */
    class C01733 implements Runnable {
        final /* synthetic */ BaseActivity f1517a;

        C01733(BaseActivity baseActivity) {
            this.f1517a = baseActivity;
        }

        public void run() {
            super.onBackPressed();
            this.f1517a.f1379h = false;
        }
    }

    /* renamed from: com.miui.calculator.common.BaseActivity.4 */
    class C01744 implements ExitAnimationEndListener {
        final /* synthetic */ BaseActivity f1518a;

        C01744(BaseActivity baseActivity) {
            this.f1518a = baseActivity;
        }

        public void m2796a() {
            super.onBackPressed();
            this.f1518a.overridePendingTransition(0, 0);
        }
    }

    public BaseActivity() {
        this.f1378g = false;
        this.f1379h = false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2626e().setCustomView(C0264R.layout.layout_title);
        this.f1372a = (TextView) m2626e().getCustomView().findViewById(C0264R.id.txv_title);
        this.f1372a.setText(getTitle());
        this.f1373b = (View) findViewById(16908290).getParent();
        m2626e().getCustomView().findViewById(C0264R.id.imv_home_menu).setOnClickListener(new C01711(this));
        m2633c();
        m2642a();
    }

    protected void m2642a() {
        StatisticUtils.m2890a(m2643b(), getIntent());
    }

    private void m2633c() {
        if (m2635d()) {
            this.f1376e = getIntent().getBooleanExtra(CalculatorActivity.f1462d, false);
            this.f1377f = getIntent().getBooleanExtra(CalculatorActivity.f1463e, false);
            this.f1374c = getIntent().getIntExtra(CalculatorActivity.f1460b, 0);
            this.f1375d = getIntent().getIntExtra(CalculatorActivity.f1461c, 0);
            if (!this.f1376e) {
                this.f1373b.getViewTreeObserver().addOnPreDrawListener(new C01722(this));
            }
        }
    }

    private boolean m2635d() {
        return getIntent().hasExtra(CalculatorActivity.f1460b) && getIntent().hasExtra(CalculatorActivity.f1461c);
    }

    private void m2638g() {
        StatisticUtils.m2899c(getClass().getSimpleName());
        Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
        intent.putExtra(CalculatorActivity.f1464f, false);
        intent.setFlags(67108864);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        if (this.f1377f) {
            sendBroadcast(new Intent(CalculatorActivity.f1465g));
            if (VERSION.SDK_INT < 24) {
                super.onBackPressed();
            } else if (!this.f1379h) {
                this.f1379h = true;
                new Handler().postDelayed(new C01733(this), 150);
            }
        } else if (!m2635d()) {
            super.onBackPressed();
            overridePendingTransition(0, 0);
        } else if (!this.f1378g) {
            this.f1378g = true;
            AnimationUtils.m2799a(this.f1373b, this.f1374c, this.f1375d, new C01744(this));
        }
    }

    protected void onResume() {
        super.onResume();
        StatisticUtils.m2889a(m2643b());
    }

    protected void onPause() {
        super.onPause();
        StatisticUtils.m2897b(m2643b());
    }

    protected String m2643b() {
        return getClass().getSimpleName();
    }

    public void setTitle(int i) {
        setTitle(getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f1372a.setText(charSequence);
        super.setTitle(charSequence);
    }
}
