package com.miui.calculator.cal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.TextView;
import com.miui.calculator.cal.ResultTextView.PopupMenuCallback;
import com.miui.calculator.cal.TypingTextView.OnEditModeListener;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.Calculator;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.calculator.common.widget.NumberPad;
import com.miui.calculator.common.widget.NumberPad.OnNumberClickListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.HashMap;

public class AllInOneCalculatorActivity extends BaseActivity {
    private static final String f1380a;
    private NumberPad f1381b;
    private TextView f1382c;
    private TextView f1383d;
    private EditText f1384e;
    private TypingTextView f1385f;
    private ResultTextView f1386g;
    private String f1387h;
    private String f1388i;
    private Calculator f1389j;
    private int f1390k;
    private boolean f1391l;
    private OnNumberClickListener f1392m;
    private OnClickListener f1393n;
    private OnEditModeListener f1394o;
    private PopupMenuCallback f1395p;

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.1 */
    class C01391 implements OnNumberClickListener {
        final /* synthetic */ AllInOneCalculatorActivity f1360a;

        C01391(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1360a = allInOneCalculatorActivity;
        }

        public void m2616a(NumberPad numberPad, int i) {
            if (this.f1360a.f1385f.isInEditMode()) {
                this.f1360a.m2645a(i);
            } else {
                this.f1360a.m2652b(i);
            }
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.2 */
    class C01402 implements AnimatorUpdateListener {
        final /* synthetic */ AllInOneCalculatorActivity f1361a;

        C01402(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1361a = allInOneCalculatorActivity;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1361a.f1384e.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.3 */
    class C01413 implements AnimatorListener {
        final /* synthetic */ AllInOneCalculatorActivity f1362a;

        C01413(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1362a = allInOneCalculatorActivity;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1362a.f1391l) {
                this.f1362a.f1384e.setVisibility(8);
                this.f1362a.f1385f.setVisibility(0);
            }
            this.f1362a.f1384e.setText(this.f1362a.f1388i);
            this.f1362a.f1384e.setTranslationX(0.0f);
            this.f1362a.f1385f.setText(this.f1362a.f1388i);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.4 */
    class C01424 implements AnimatorUpdateListener {
        final /* synthetic */ AllInOneCalculatorActivity f1363a;

        C01424(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1363a = allInOneCalculatorActivity;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1363a.f1386g.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.5 */
    class C01435 implements AnimatorUpdateListener {
        final /* synthetic */ int f1364a;
        final /* synthetic */ int f1365b;
        final /* synthetic */ AllInOneCalculatorActivity f1366c;

        C01435(AllInOneCalculatorActivity allInOneCalculatorActivity, int i, int i2) {
            this.f1366c = allInOneCalculatorActivity;
            this.f1364a = i;
            this.f1365b = i2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f1366c.f1386g.setTextColor(Color.argb((int) ((((float) (Color.alpha(this.f1364a) - Color.alpha(this.f1365b))) * floatValue) + ((float) Color.alpha(this.f1365b))), (int) ((((float) (Color.red(this.f1364a) - Color.red(this.f1365b))) * floatValue) + ((float) Color.red(this.f1365b))), (int) ((((float) (Color.green(this.f1364a) - Color.green(this.f1365b))) * floatValue) + ((float) Color.green(this.f1365b))), (int) ((floatValue * ((float) (Color.blue(this.f1364a) - Color.blue(this.f1365b)))) + ((float) Color.blue(this.f1365b)))));
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.6 */
    class C01446 implements AnimatorListener {
        final /* synthetic */ AllInOneCalculatorActivity f1367a;

        C01446(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1367a = allInOneCalculatorActivity;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f1367a.m2663g();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.7 */
    class C01457 implements OnClickListener {
        final /* synthetic */ AllInOneCalculatorActivity f1368a;

        C01457(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1368a = allInOneCalculatorActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0264R.id.txv_equation /*2131689531*/:
                    if (this.f1368a.f1390k != 2) {
                        this.f1368a.m2649a(true);
                        this.f1368a.f1390k = 2;
                    }
                case C0264R.id.txv_result /*2131689533*/:
                    if (this.f1368a.f1390k == 2) {
                        this.f1368a.m2652b((int) C0264R.id.btn_equal);
                    }
                default:
            }
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.8 */
    class C01468 implements OnEditModeListener {
        final /* synthetic */ AllInOneCalculatorActivity f1369a;

        C01468(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1369a = allInOneCalculatorActivity;
        }

        public void m2618a(TextView textView, boolean z) {
            this.f1369a.m2650a(true, z ? 6 : 5);
        }
    }

    /* renamed from: com.miui.calculator.cal.AllInOneCalculatorActivity.9 */
    class C01479 implements PopupMenuCallback {
        final /* synthetic */ AllInOneCalculatorActivity f1370a;

        C01479(AllInOneCalculatorActivity allInOneCalculatorActivity) {
            this.f1370a = allInOneCalculatorActivity;
        }

        public void m2622a(HashMap<Integer, String> hashMap) {
            StatisticUtils.m2900d(this.f1370a.getClass().getSimpleName());
            hashMap.put(Integer.valueOf(2), this.f1370a.getString(C0264R.string.cal_copy));
            if (CalculatorUtils.m2827f() && this.f1370a.f1390k == 0 && NumberFormatUtils.m2886d(this.f1370a.f1387h) != null) {
                hashMap.put(Integer.valueOf(1), this.f1370a.getString(C0264R.string.cal_convert_to_word_figure));
            }
        }

        public void m2621a(int i) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    StatisticUtils.m2902f(this.f1370a.getClass().getSimpleName());
                    this.f1370a.f1386g.setText(NumberFormatUtils.m2886d(this.f1370a.f1387h));
                    this.f1370a.m2649a(false);
                    this.f1370a.f1390k = 4;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    StatisticUtils.m2901e(this.f1370a.getClass().getSimpleName());
                    CalculatorUtils.m2818a(this.f1370a.getApplicationContext(), this.f1370a.f1386g.getText());
                default:
            }
        }
    }

    public AllInOneCalculatorActivity() {
        this.f1387h = "";
        this.f1392m = new C01391(this);
        this.f1393n = new C01457(this);
        this.f1394o = new C01468(this);
        this.f1395p = new C01479(this);
    }

    static {
        f1380a = String.valueOf('0');
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.calculator_activity);
        this.f1391l = getIntent().getBooleanExtra("extra_is_scientific", false);
        this.f1389j = Calculator.m2801a();
        this.f1390k = 2;
        m2656c();
    }

    private void m2656c() {
        setTitle((CharSequence) "");
        this.f1381b = (NumberPad) findViewById(C0264R.id.nbp_pad);
        this.f1382c = (TextView) findViewById(C0264R.id.txv_history_out);
        this.f1383d = (TextView) findViewById(C0264R.id.txv_history);
        this.f1384e = (EditText) findViewById(C0264R.id.txv_equation);
        this.f1385f = (TypingTextView) findViewById(C0264R.id.txv_equation_typing);
        this.f1386g = (ResultTextView) findViewById(C0264R.id.txv_result);
        this.f1386g.setPopupMenuCallback(this.f1395p);
        this.f1382c.setTypeface(CalculatorUtils.m2817a((Context) this));
        this.f1383d.setTypeface(CalculatorUtils.m2817a((Context) this));
        this.f1384e.setTypeface(CalculatorUtils.m2817a((Context) this));
        this.f1385f.setTypeFace(CalculatorUtils.m2817a((Context) this));
        this.f1386g.setTypeface(CalculatorUtils.m2817a((Context) this));
        this.f1385f.setTextSize((float) getResources().getDimensionPixelSize(C0264R.dimen.cal_primary));
        this.f1385f.setOnEditModeListener(this.f1394o);
        m2659d();
        this.f1381b.setOnNumberClickListener(this.f1392m);
        this.f1384e.setOnClickListener(this.f1393n);
        this.f1386g.setOnClickListener(this.f1393n);
        if (this.f1391l) {
            this.f1381b.setPadType(4);
            this.f1385f.setVisibility(8);
            this.f1384e.setVisibility(0);
            return;
        }
        this.f1381b.setPadType(3);
        this.f1385f.setVisibility(0);
        this.f1384e.setVisibility(8);
    }

    private void m2659d() {
        this.f1384e.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_primary));
        this.f1384e.setTranslationY((float) getResources().getDimensionPixelOffset(C0264R.dimen.cal_equation_margin_top));
        this.f1384e.setText(f1380a);
        this.f1385f.setText(f1380a);
        this.f1388i = f1380a;
        if (this.f1391l) {
            this.f1384e.setVisibility(0);
            this.f1385f.setVisibility(8);
        } else {
            this.f1385f.setVisibility(0);
            this.f1384e.setVisibility(8);
        }
        this.f1386g.animate().cancel();
        this.f1386g.clearAnimation();
        if (this.f1386g.getAnimation() != null) {
            this.f1386g.getAnimation().cancel();
        }
        this.f1386g.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        this.f1386g.setTranslationY((float) getResources().getDimensionPixelOffset(C0264R.dimen.cal_result_margin_top));
        this.f1386g.setText("");
        this.f1386g.setTextColor(getResources().getColor(C0264R.color.cal_result_realtime));
    }

    private void m2645a(int i) {
        boolean z = true;
        if (i == C0264R.id.btn_ok) {
            m2650a(false, 3);
            return;
        }
        String a = this.f1381b.m2921a(this.f1385f.getEditingString(), i, true);
        NumberPad numberPad = this.f1381b;
        String b = NumberPad.m2910b(i);
        TypingTextView typingTextView = this.f1385f;
        if (String.valueOf('\u2212').equals(b)) {
            z = false;
        }
        typingTextView.m2792a(a, z);
        this.f1388i = this.f1385f.getText();
        m2663g();
    }

    private void m2652b(int i) {
        boolean z = true;
        if (this.f1390k == 0 || this.f1390k == 4) {
            if (i == C0264R.id.btn_c) {
                i = C0264R.id.btn_0;
            }
            if (!(i == C0264R.id.btn_del || i == C0264R.id.btn_equal)) {
                if (!(TextUtils.isEmpty(this.f1388i) || TextUtils.isEmpty(this.f1387h))) {
                    if (this.f1390k == 4) {
                        this.f1383d.setText(this.f1388i + '=' + NumberFormatUtils.m2886d(this.f1387h));
                    } else {
                        this.f1383d.setText(this.f1388i + '=' + this.f1387h);
                    }
                    m2654b(true);
                }
                m2659d();
                NumberPad numberPad = this.f1381b;
                String b = NumberPad.m2910b(i);
                if (!((b.length() == 1 && (i == C0264R.id.btn_percent || Calculator.m2804b(b.charAt(0)))) || i == C0264R.id.btn_del)) {
                    this.f1387h = f1380a;
                }
                this.f1388i = this.f1381b.m2921a(this.f1387h, i, true);
                this.f1384e.setText(this.f1388i);
                this.f1385f.setText(this.f1388i);
                this.f1390k = 2;
                m2663g();
            }
        } else if (this.f1390k == 2) {
            if (this.f1388i.equals(f1380a) && i == C0264R.id.btn_c) {
                m2654b(false);
            }
            if (i == C0264R.id.btn_equal) {
                this.f1387h = this.f1389j.m2811a(this.f1388i, true);
                Object obj = this.f1388i + '=';
                this.f1384e.setText(obj);
                this.f1385f.setText(obj);
                this.f1386g.setText(this.f1387h);
                if ("NaN".equalsIgnoreCase(this.f1387h)) {
                    this.f1386g.setText(C0264R.string.error);
                    this.f1390k = 1;
                } else {
                    this.f1390k = 0;
                }
                m2649a(false);
            } else {
                this.f1388i = this.f1381b.m2921a(this.f1388i, i, true);
                this.f1384e.setText(this.f1388i);
                this.f1385f.setText(this.f1388i);
                m2663g();
            }
        } else if (i == C0264R.id.btn_c) {
            this.f1387h = "";
            m2659d();
            this.f1390k = 0;
        }
        ResultTextView resultTextView = this.f1386g;
        if (this.f1390k != 0) {
            z = false;
        }
        resultTextView.m2786a(z);
    }

    private void m2649a(boolean z) {
        float dimensionPixelSize;
        Resources resources = getResources();
        this.f1384e.setVisibility(0);
        float[] fArr = new float[2];
        fArr[0] = this.f1384e.getTextSize();
        if (z) {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_primary);
        } else {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_secondary);
        }
        fArr[1] = dimensionPixelSize;
        ObjectAnimator.ofFloat(fArr).addUpdateListener(new C01402(this));
        EditText editText = this.f1384e;
        String str = "translationY";
        float[] fArr2 = new float[2];
        fArr2[0] = this.f1384e.getTranslationY();
        if (z) {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_equation_margin_top);
        } else {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_equation_r_margin_top);
        }
        fArr2[1] = dimensionPixelSize;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(editText, str, fArr2);
        Paint paint = new Paint(this.f1384e.getPaint());
        paint.setTextSize((float) resources.getDimensionPixelSize(C0264R.dimen.cal_primary));
        float measureText = paint.measureText(String.valueOf('='));
        EditText editText2 = this.f1384e;
        String str2 = "translationX";
        float[] fArr3 = new float[2];
        if (z) {
            dimensionPixelSize = 0.0f;
        } else {
            dimensionPixelSize = measureText;
        }
        fArr3[0] = dimensionPixelSize;
        if (!z) {
            measureText = 0.0f;
        }
        fArr3[1] = measureText;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(editText2, str2, fArr3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200);
        animatorSet.playTogether(new Animator[]{r4, ofFloat, ofFloat2});
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (!this.f1391l) {
            this.f1385f.setVisibility(8);
        }
        if (z) {
            animatorSet.addListener(new C01413(this));
        }
        animatorSet.start();
        fArr = new float[2];
        fArr[0] = this.f1386g.getTextSize();
        if (z) {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_secondary);
        } else {
            dimensionPixelSize = CalculatorUtils.m2815a(0, 0.0f, this.f1386g);
        }
        fArr[1] = dimensionPixelSize;
        ObjectAnimator.ofFloat(fArr).addUpdateListener(new C01424(this));
        ResultTextView resultTextView = this.f1386g;
        String str3 = "translationY";
        float[] fArr4 = new float[2];
        fArr4[0] = this.f1386g.getTranslationY();
        if (z) {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_result_margin_top);
        } else {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(C0264R.dimen.cal_result_r_margin_top);
        }
        fArr4[1] = dimensionPixelSize;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(resultTextView, str3, fArr4);
        ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).addUpdateListener(new C01435(this, z ? resources.getColor(C0264R.color.cal_result_realtime) : resources.getColor(C0264R.color.cal_result), z ? resources.getColor(C0264R.color.cal_result) : resources.getColor(C0264R.color.cal_result_realtime)));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setInterpolator(new DecelerateInterpolator());
        animatorSet2.setDuration(200);
        animatorSet2.playTogether(new Animator[]{r2, ofFloat3, r3});
        if (z) {
            animatorSet2.addListener(new C01446(this));
        }
        animatorSet2.start();
    }

    private void m2654b(boolean z) {
        if (this.f1383d.getVisibility() == 0 && !TextUtils.isEmpty(this.f1383d.getText())) {
            this.f1382c.setText(this.f1383d.getText());
            this.f1382c.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f1382c, "translationY", new float[]{this.f1383d.getTranslationY(), (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_history_out_margin_top)});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f1382c, "alpha", new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
        if (z) {
            this.f1383d.setVisibility(0);
            ofFloat = ObjectAnimator.ofFloat(this.f1383d, "translationY", new float[]{this.f1384e.getTranslationY(), (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_history_margin_top)});
            ofFloat.setDuration(200);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.start();
            return;
        }
        this.f1383d.setVisibility(8);
    }

    private void m2663g() {
        this.f1387h = this.f1389j.m2812a(this.f1388i, true, this.f1387h);
        if (f1380a.equals(this.f1388i)) {
            this.f1386g.setText("");
            return;
        }
        this.f1386g.setText(getString(C0264R.string.cal_result_format, new Object[]{this.f1387h}));
        if ("NaN".equals(this.f1387h) || "error".equals(this.f1387h)) {
            this.f1386g.setText(C0264R.string.error);
        }
    }

    private void m2650a(boolean z, int i) {
        if (z) {
            setTitle((int) C0264R.string.cal_edit_mode);
            this.f1381b.setPadType(i);
            return;
        }
        setTitle((CharSequence) "");
        this.f1385f.m2791a();
        this.f1381b.setPadType(i);
    }
}
