package com.miui.calculator.cal;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.miui.calculator.cal.CalVerticalView.EditModeListener;
import com.miui.calculator.cal.CalVerticalView.ResultMenuCallback;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.Calculator;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.calculator.common.widget.NumberPad;
import com.miui.calculator.common.widget.NumberPad.OnNumberClickListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;

public class NormalCalculatorActivity extends BaseActivity {
    public static final String f1477a;
    private String f1478b;
    private String f1479c;
    private NumberPad f1480d;
    private CalVerticalView f1481e;
    private Calculator f1482f;
    private int f1483g;
    private int f1484h;
    private boolean f1485i;
    private OnNumberClickListener f1486j;
    private EditModeListener f1487k;
    private ResultMenuCallback f1488l;

    /* renamed from: com.miui.calculator.cal.NormalCalculatorActivity.1 */
    class C01621 implements OnNumberClickListener {
        final /* synthetic */ NormalCalculatorActivity f1474a;

        C01621(NormalCalculatorActivity normalCalculatorActivity) {
            this.f1474a = normalCalculatorActivity;
        }

        public void m2754a(NumberPad numberPad, int i) {
            if (this.f1474a.f1481e.isInEditMode()) {
                this.f1474a.m2759a(i);
                return;
            }
            this.f1474a.m2764b(i);
            this.f1474a.m2772d();
        }
    }

    /* renamed from: com.miui.calculator.cal.NormalCalculatorActivity.2 */
    class C01632 implements EditModeListener {
        final /* synthetic */ NormalCalculatorActivity f1475a;

        C01632(NormalCalculatorActivity normalCalculatorActivity) {
            this.f1475a = normalCalculatorActivity;
        }

        public void m2755a(boolean z) {
            StatisticUtils.m2896b();
            this.f1475a.f1484h = this.f1475a.f1483g;
            this.f1475a.f1483g = 2;
            this.f1475a.f1480d.setPadType(z ? 6 : 5);
            this.f1475a.f1485i = true;
        }
    }

    /* renamed from: com.miui.calculator.cal.NormalCalculatorActivity.3 */
    class C01643 implements ResultMenuCallback {
        final /* synthetic */ NormalCalculatorActivity f1476a;

        C01643(NormalCalculatorActivity normalCalculatorActivity) {
            this.f1476a = normalCalculatorActivity;
        }

        public void m2757a(ArrayList<Pair<Integer, String>> arrayList, CalElementView calElementView) {
            StatisticUtils.m2900d(this.f1476a.getClass().getSimpleName());
            arrayList.clear();
            if (!(!CalculatorUtils.m2827f() || NumberFormatUtils.m2886d(calElementView.getElement()) == null || this.f1476a.f1483g == 4)) {
                arrayList.add(new Pair(Integer.valueOf(1), this.f1476a.getString(C0264R.string.cal_convert_to_word_figure)));
            }
            arrayList.add(new Pair(Integer.valueOf(2), this.f1476a.getString(C0264R.string.cal_copy)));
        }

        public void m2756a(int i, CalElementView calElementView) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    StatisticUtils.m2901e(this.f1476a.getClass().getSimpleName());
                    this.f1476a.m2762a(calElementView.getElement());
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    StatisticUtils.m2902f(this.f1476a.getClass().getSimpleName());
                    CalculatorUtils.m2818a(this.f1476a.getApplicationContext(), calElementView.getElement());
                default:
            }
        }
    }

    public NormalCalculatorActivity() {
        this.f1478b = "";
        this.f1479c = "";
        this.f1486j = new C01621(this);
        this.f1487k = new C01632(this);
        this.f1488l = new C01643(this);
    }

    static {
        f1477a = String.valueOf('0');
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.cal_activity);
        this.f1482f = Calculator.m2801a();
        m2769c();
    }

    protected void onPause() {
        super.onPause();
        this.f1481e.m2716a(this.f1483g);
    }

    private void m2769c() {
        setTitle((CharSequence) "");
        this.f1480d = (NumberPad) findViewById(C0264R.id.nbp_pad);
        this.f1481e = (CalVerticalView) findViewById(C0264R.id.cvv_cal_vertical_view);
        Resources resources = getResources();
        this.f1481e.m2717a(resources.getDimensionPixelOffset(C0264R.dimen.cal_typing_line_margin_top), resources.getDimensionPixelOffset(C0264R.dimen.cal_typing_line_margin_bottom));
        this.f1481e.setEditModeListener(this.f1487k);
        this.f1480d.setPadType(3);
        this.f1480d.setOnNumberClickListener(this.f1486j);
        this.f1483g = this.f1481e.m2720c();
        this.f1478b = this.f1481e.getLastResult();
        Log.d("NormalCalculatorActivity", "2 mResult = " + this.f1478b);
        this.f1481e.setResultMenuCallback(this.f1488l);
        m2772d();
    }

    private void m2772d() {
        this.f1480d.m2925c(TextUtils.isEmpty(this.f1478b));
    }

    private void m2759a(int i) {
        if (i == C0264R.id.btn_ok) {
            if (this.f1484h == 0) {
                this.f1483g = 0;
            }
            this.f1481e.m2715a();
            this.f1480d.setPadType(3);
            return;
        }
        if (this.f1481e.m2719b()) {
            NumberPad numberPad = this.f1480d;
            this.f1481e.setEditOperator(NumberPad.m2910b(i));
        } else {
            String editElement = this.f1481e.getEditElement();
            if (this.f1485i) {
                editElement = String.valueOf('0');
                this.f1485i = false;
            }
            this.f1481e.setEditElement(this.f1480d.m2922a(this.f1481e.getEquationText(), editElement, i, true));
        }
        if (Calculator.m2808d(this.f1481e.getEditingText())) {
            this.f1478b = "syntax_error";
            this.f1481e.setEquationClickable(false);
        } else {
            this.f1481e.setEquationClickable(true);
            this.f1478b = this.f1482f.m2811a(this.f1481e.getEquationText(), true);
            Log.d("NormalCalculatorActivity", "1 mResult = " + this.f1478b);
        }
        m2773g();
    }

    private void m2764b(int i) {
        if (i == C0264R.id.btn_c) {
            if (TextUtils.isEmpty(this.f1478b)) {
                this.f1481e.m2721d();
            } else {
                this.f1481e.m2722e();
            }
            this.f1478b = "";
            Log.d("NormalCalculatorActivity", "3 mResult = " + this.f1478b);
            this.f1483g = 2;
            this.f1479c = "";
            return;
        }
        NumberPad numberPad = this.f1480d;
        String b = NumberPad.m2910b(i);
        if (this.f1483g == 0 || this.f1483g == 4) {
            if (i != C0264R.id.btn_del && i != C0264R.id.btn_equal) {
                this.f1479c = "";
                this.f1481e.m2727j();
                if (i == C0264R.id.btn_percent) {
                    b = this.f1480d.m2921a(this.f1478b, i, true);
                }
                if (b != null && b.length() == 1 && Calculator.m2804b(b.charAt(0))) {
                    this.f1481e.setTypingText(this.f1478b);
                    this.f1481e.m2723f();
                    this.f1481e.setTypingText(b);
                    this.f1478b = this.f1482f.m2811a(this.f1481e.getEquationText(), true);
                    Log.d("NormalCalculatorActivity", "4 mResult = " + this.f1478b);
                } else {
                    this.f1481e.setTypingText(b);
                    this.f1478b = this.f1482f.m2811a(b, true);
                    Log.d("NormalCalculatorActivity", "5 mResult = " + this.f1478b);
                }
                this.f1483g = 2;
                m2773g();
            }
        } else if (this.f1483g != 2) {
        } else {
            String typingText;
            if (b == null || b.length() != 1 || !Calculator.m2804b(b.charAt(0))) {
                typingText = this.f1481e.getTypingText();
                if (i != C0264R.id.btn_equal) {
                    if (i == C0264R.id.btn_del) {
                        this.f1479c = "";
                        b = this.f1480d.m2921a(typingText, i, true);
                        if (String.valueOf('0').equals(b) && typingText.length() > 1 && Calculator.m2804b(typingText.charAt(0))) {
                            b = typingText.substring(0, 1);
                        }
                        if (TextUtils.isEmpty(b)) {
                            b = String.valueOf('0');
                        }
                    } else {
                        b = this.f1480d.m2922a(this.f1481e.getEquationText(), typingText, i, true);
                        if (NumberFormatUtils.m2880b(b).length() > 20) {
                            b = typingText;
                        }
                    }
                    this.f1481e.setTypingText(b);
                    if (String.valueOf('0').equals(b)) {
                        this.f1481e.m2724g();
                    }
                    if (Calculator.m2808d(b)) {
                        this.f1478b = "syntax_error";
                    } else {
                        b = this.f1481e.getEquationText();
                        if (String.valueOf('0').equals(b)) {
                            this.f1478b = "";
                            Log.d("NormalCalculatorActivity", "6 mResult = " + this.f1478b);
                        } else {
                            this.f1478b = this.f1482f.m2811a(b, true);
                            Log.d("NormalCalculatorActivity", "7 mResult = " + this.f1478b);
                        }
                    }
                    m2773g();
                    return;
                }
                if (!String.valueOf('0').equals(this.f1481e.getTypingText())) {
                    if ("NaN".equalsIgnoreCase(this.f1478b)) {
                        this.f1483g = 1;
                    } else {
                        this.f1483g = 0;
                    }
                    m2773g();
                    this.f1481e.m2726i();
                    if (TextUtils.equals("syntax_error", this.f1479c)) {
                        this.f1481e.setEquationClickable(false);
                    }
                }
            } else if ("syntax_error" != this.f1479c) {
                typingText = this.f1481e.getTypingText();
                if (typingText.length() == 1 && Calculator.m2804b(typingText.charAt(0))) {
                    this.f1481e.setTypingText(String.valueOf(b));
                    return;
                }
                this.f1481e.m2723f();
                this.f1481e.setTypingText(String.valueOf(b));
            }
        }
    }

    private void m2773g() {
        this.f1479c = this.f1478b;
        if (TextUtils.isEmpty(this.f1478b)) {
            this.f1481e.setResult(String.valueOf('=') + f1477a);
            this.f1481e.setResultMenuCallback(this.f1488l);
        } else if ("NaN".equalsIgnoreCase(this.f1478b)) {
            this.f1481e.setResult(getString(C0264R.string.error));
            this.f1481e.setResultMenuCallback(null);
        } else if ("syntax_error".equals(this.f1478b)) {
            this.f1481e.setResult(getString(C0264R.string.devided_by_zero_reminder_message));
            this.f1481e.setResultMenuCallback(null);
        } else {
            this.f1481e.setResult(String.valueOf('=') + this.f1478b);
            if (!this.f1481e.isInEditMode()) {
                this.f1481e.setResultMenuCallback(this.f1488l);
            }
        }
    }

    private void m2762a(String str) {
        String d = NumberFormatUtils.m2886d(str);
        if (d != null) {
            this.f1481e.m2718a(d);
            this.f1483g = 4;
        }
    }
}
