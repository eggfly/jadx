package com.miui.calculator.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.miui.calculator.CalculatorApplication;
import com.miui.calculator.common.utils.Calculator;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class NumberPad extends FrameLayout {
    private static final HashMap<Integer, Integer> f1560b;
    private static final HashMap<Integer, String> f1561c;
    private static final ArrayList<Integer> f1562d;
    private static final ArrayList<Integer> f1563e;
    private static final ArrayList<Integer> f1564f;
    private int f1565a;
    private OnNumberClickListener f1566g;
    private Stack<Boolean> f1567h;
    private OnClickListener f1568i;

    public interface OnNumberClickListener {
        void m2615a(NumberPad numberPad, int i);
    }

    /* renamed from: com.miui.calculator.common.widget.NumberPad.1 */
    class C01771 implements OnClickListener {
        final /* synthetic */ NumberPad f1559a;

        C01771(NumberPad numberPad) {
            this.f1559a = numberPad;
        }

        public void onClick(View view) {
            Integer num = (Integer) NumberPad.f1560b.get(Integer.valueOf(view.getId()));
            if (num == null) {
                Log.e("Calculator:Numberpad", "No btnId machted for viewId: " + view.getId());
            } else if (this.f1559a.f1566g != null) {
                this.f1559a.f1566g.m2615a(this.f1559a, num.intValue());
            }
        }
    }

    static {
        f1560b = new HashMap();
        f1561c = new HashMap();
        f1562d = new ArrayList();
        f1563e = new ArrayList();
        f1564f = new ArrayList();
        f1563e.add(Integer.valueOf(C0264R.id.btn_0));
        f1563e.add(Integer.valueOf(C0264R.id.btn_1));
        f1563e.add(Integer.valueOf(C0264R.id.btn_2));
        f1563e.add(Integer.valueOf(C0264R.id.btn_3));
        f1563e.add(Integer.valueOf(C0264R.id.btn_4));
        f1563e.add(Integer.valueOf(C0264R.id.btn_5));
        f1563e.add(Integer.valueOf(C0264R.id.btn_6));
        f1563e.add(Integer.valueOf(C0264R.id.btn_7));
        f1563e.add(Integer.valueOf(C0264R.id.btn_8));
        f1563e.add(Integer.valueOf(C0264R.id.btn_9));
        f1563e.add(Integer.valueOf(C0264R.id.btn_dot));
        f1562d.add(Integer.valueOf(C0264R.id.btn_div));
        f1562d.add(Integer.valueOf(C0264R.id.btn_minus));
        f1562d.add(Integer.valueOf(C0264R.id.btn_mul));
        f1562d.add(Integer.valueOf(C0264R.id.btn_plus));
        f1564f.add(Integer.valueOf(C0264R.id.btn_husband));
        f1564f.add(Integer.valueOf(C0264R.id.btn_wife));
        f1564f.add(Integer.valueOf(C0264R.id.btn_father));
        f1564f.add(Integer.valueOf(C0264R.id.btn_mother));
        f1564f.add(Integer.valueOf(C0264R.id.btn_elder_brother));
        f1564f.add(Integer.valueOf(C0264R.id.btn_younger_brother));
        f1564f.add(Integer.valueOf(C0264R.id.btn_elder_sister));
        f1564f.add(Integer.valueOf(C0264R.id.btn_younger_sister));
        f1564f.add(Integer.valueOf(C0264R.id.btn_son));
        f1564f.add(Integer.valueOf(C0264R.id.btn_daughter));
        f1560b.put(Integer.valueOf(C0264R.id.btn_0), Integer.valueOf(C0264R.id.btn_0));
        f1560b.put(Integer.valueOf(C0264R.id.btn_0_p), Integer.valueOf(C0264R.id.btn_0));
        f1560b.put(Integer.valueOf(C0264R.id.btn_1), Integer.valueOf(C0264R.id.btn_1));
        f1560b.put(Integer.valueOf(C0264R.id.btn_2), Integer.valueOf(C0264R.id.btn_2));
        f1560b.put(Integer.valueOf(C0264R.id.btn_3), Integer.valueOf(C0264R.id.btn_3));
        f1560b.put(Integer.valueOf(C0264R.id.btn_4), Integer.valueOf(C0264R.id.btn_4));
        f1560b.put(Integer.valueOf(C0264R.id.btn_5), Integer.valueOf(C0264R.id.btn_5));
        f1560b.put(Integer.valueOf(C0264R.id.btn_6), Integer.valueOf(C0264R.id.btn_6));
        f1560b.put(Integer.valueOf(C0264R.id.btn_7), Integer.valueOf(C0264R.id.btn_7));
        f1560b.put(Integer.valueOf(C0264R.id.btn_8), Integer.valueOf(C0264R.id.btn_8));
        f1560b.put(Integer.valueOf(C0264R.id.btn_9), Integer.valueOf(C0264R.id.btn_9));
        f1560b.put(Integer.valueOf(C0264R.id.btn_c), Integer.valueOf(C0264R.id.btn_c));
        f1560b.put(Integer.valueOf(C0264R.id.btn_c_1), Integer.valueOf(C0264R.id.btn_c));
        f1560b.put(Integer.valueOf(C0264R.id.btn_c_2), Integer.valueOf(C0264R.id.btn_c));
        f1560b.put(Integer.valueOf(C0264R.id.btn_del), Integer.valueOf(C0264R.id.btn_del));
        f1560b.put(Integer.valueOf(C0264R.id.btn_del_1), Integer.valueOf(C0264R.id.btn_del));
        f1560b.put(Integer.valueOf(C0264R.id.btn_del_2), Integer.valueOf(C0264R.id.btn_del));
        f1560b.put(Integer.valueOf(C0264R.id.btn_div), Integer.valueOf(C0264R.id.btn_div));
        f1560b.put(Integer.valueOf(C0264R.id.btn_dot), Integer.valueOf(C0264R.id.btn_dot));
        f1560b.put(Integer.valueOf(C0264R.id.btn_equal), Integer.valueOf(C0264R.id.btn_equal));
        f1560b.put(Integer.valueOf(C0264R.id.btn_minus), Integer.valueOf(C0264R.id.btn_minus));
        f1560b.put(Integer.valueOf(C0264R.id.btn_mul), Integer.valueOf(C0264R.id.btn_mul));
        f1560b.put(Integer.valueOf(C0264R.id.btn_plus), Integer.valueOf(C0264R.id.btn_plus));
        f1560b.put(Integer.valueOf(C0264R.id.btn_0_s), Integer.valueOf(C0264R.id.btn_0));
        f1560b.put(Integer.valueOf(C0264R.id.btn_1_s), Integer.valueOf(C0264R.id.btn_1));
        f1560b.put(Integer.valueOf(C0264R.id.btn_2_s), Integer.valueOf(C0264R.id.btn_2));
        f1560b.put(Integer.valueOf(C0264R.id.btn_3_s), Integer.valueOf(C0264R.id.btn_3));
        f1560b.put(Integer.valueOf(C0264R.id.btn_4_s), Integer.valueOf(C0264R.id.btn_4));
        f1560b.put(Integer.valueOf(C0264R.id.btn_5_s), Integer.valueOf(C0264R.id.btn_5));
        f1560b.put(Integer.valueOf(C0264R.id.btn_6_s), Integer.valueOf(C0264R.id.btn_6));
        f1560b.put(Integer.valueOf(C0264R.id.btn_7_s), Integer.valueOf(C0264R.id.btn_7));
        f1560b.put(Integer.valueOf(C0264R.id.btn_8_s), Integer.valueOf(C0264R.id.btn_8));
        f1560b.put(Integer.valueOf(C0264R.id.btn_9_s), Integer.valueOf(C0264R.id.btn_9));
        f1560b.put(Integer.valueOf(C0264R.id.btn_c_s), Integer.valueOf(C0264R.id.btn_c));
        f1560b.put(Integer.valueOf(C0264R.id.btn_del_s), Integer.valueOf(C0264R.id.btn_del));
        f1560b.put(Integer.valueOf(C0264R.id.btn_div_s), Integer.valueOf(C0264R.id.btn_div));
        f1560b.put(Integer.valueOf(C0264R.id.btn_dot_s), Integer.valueOf(C0264R.id.btn_dot));
        f1560b.put(Integer.valueOf(C0264R.id.btn_equal_s), Integer.valueOf(C0264R.id.btn_equal));
        f1560b.put(Integer.valueOf(C0264R.id.btn_minus_s), Integer.valueOf(C0264R.id.btn_minus));
        f1560b.put(Integer.valueOf(C0264R.id.btn_mul_s), Integer.valueOf(C0264R.id.btn_mul));
        f1560b.put(Integer.valueOf(C0264R.id.btn_plus_s), Integer.valueOf(C0264R.id.btn_plus));
        f1560b.put(Integer.valueOf(C0264R.id.btn_fac), Integer.valueOf(C0264R.id.btn_fac));
        f1560b.put(Integer.valueOf(C0264R.id.btn_pow), Integer.valueOf(C0264R.id.btn_pow));
        f1560b.put(Integer.valueOf(C0264R.id.btn_sqrt), Integer.valueOf(C0264R.id.btn_sqrt));
        f1560b.put(Integer.valueOf(C0264R.id.btn_pi), Integer.valueOf(C0264R.id.btn_pi));
        f1560b.put(Integer.valueOf(C0264R.id.btn_sin), Integer.valueOf(C0264R.id.btn_sin));
        f1560b.put(Integer.valueOf(C0264R.id.btn_lp), Integer.valueOf(C0264R.id.btn_lp));
        f1560b.put(Integer.valueOf(C0264R.id.btn_rp), Integer.valueOf(C0264R.id.btn_rp));
        f1560b.put(Integer.valueOf(C0264R.id.btn_e), Integer.valueOf(C0264R.id.btn_e));
        f1560b.put(Integer.valueOf(C0264R.id.btn_cos), Integer.valueOf(C0264R.id.btn_cos));
        f1560b.put(Integer.valueOf(C0264R.id.btn_tan), Integer.valueOf(C0264R.id.btn_tan));
        f1560b.put(Integer.valueOf(C0264R.id.btn_ln), Integer.valueOf(C0264R.id.btn_ln));
        f1560b.put(Integer.valueOf(C0264R.id.btn_lg), Integer.valueOf(C0264R.id.btn_lg));
        f1560b.put(Integer.valueOf(C0264R.id.btn_ok), Integer.valueOf(C0264R.id.btn_ok));
        f1560b.put(Integer.valueOf(C0264R.id.btn_percent), Integer.valueOf(C0264R.id.btn_percent));
        f1560b.put(Integer.valueOf(C0264R.id.btn_neg), Integer.valueOf(C0264R.id.btn_neg));
        f1560b.put(Integer.valueOf(C0264R.id.lyt_simple), Integer.valueOf(0));
        f1560b.put(Integer.valueOf(C0264R.id.lyt_c_d_d), Integer.valueOf(0));
        f1560b.put(Integer.valueOf(C0264R.id.lyt_c_d), Integer.valueOf(0));
        f1560b.put(Integer.valueOf(C0264R.id.lyt_m_m_p_e), Integer.valueOf(0));
        f1560b.put(Integer.valueOf(C0264R.id.lyt_scientific), Integer.valueOf(0));
        f1560b.put(Integer.valueOf(C0264R.id.btn_husband), Integer.valueOf(C0264R.id.btn_husband));
        f1560b.put(Integer.valueOf(C0264R.id.btn_wife), Integer.valueOf(C0264R.id.btn_wife));
        f1560b.put(Integer.valueOf(C0264R.id.btn_father), Integer.valueOf(C0264R.id.btn_father));
        f1560b.put(Integer.valueOf(C0264R.id.btn_mother), Integer.valueOf(C0264R.id.btn_mother));
        f1560b.put(Integer.valueOf(C0264R.id.btn_elder_brother), Integer.valueOf(C0264R.id.btn_elder_brother));
        f1560b.put(Integer.valueOf(C0264R.id.btn_younger_brother), Integer.valueOf(C0264R.id.btn_younger_brother));
        f1560b.put(Integer.valueOf(C0264R.id.btn_elder_sister), Integer.valueOf(C0264R.id.btn_elder_sister));
        f1560b.put(Integer.valueOf(C0264R.id.btn_younger_sister), Integer.valueOf(C0264R.id.btn_younger_sister));
        f1560b.put(Integer.valueOf(C0264R.id.btn_son), Integer.valueOf(C0264R.id.btn_son));
        f1560b.put(Integer.valueOf(C0264R.id.btn_daughter), Integer.valueOf(C0264R.id.btn_daughter));
        f1560b.put(Integer.valueOf(C0264R.id.relationship_btn_cross_check), Integer.valueOf(C0264R.id.relationship_btn_cross_check));
        f1560b.put(Integer.valueOf(C0264R.id.btn_del_relationship), Integer.valueOf(C0264R.id.btn_del));
        f1560b.put(Integer.valueOf(C0264R.id.btn_c_relationship), Integer.valueOf(C0264R.id.btn_c));
        f1560b.put(Integer.valueOf(C0264R.id.btn_equal_relationship), Integer.valueOf(C0264R.id.btn_equal));
        f1561c.put(Integer.valueOf(C0264R.id.btn_husband), CalculatorApplication.m2559b().getString(C0264R.string.husband));
        f1561c.put(Integer.valueOf(C0264R.id.btn_wife), CalculatorApplication.m2559b().getString(C0264R.string.wife));
        f1561c.put(Integer.valueOf(C0264R.id.btn_father), CalculatorApplication.m2559b().getString(C0264R.string.father));
        f1561c.put(Integer.valueOf(C0264R.id.btn_mother), CalculatorApplication.m2559b().getString(C0264R.string.mother));
        f1561c.put(Integer.valueOf(C0264R.id.btn_elder_brother), CalculatorApplication.m2559b().getString(C0264R.string.elder_brother));
        f1561c.put(Integer.valueOf(C0264R.id.btn_younger_brother), CalculatorApplication.m2559b().getString(C0264R.string.younger_brother));
        f1561c.put(Integer.valueOf(C0264R.id.btn_elder_sister), CalculatorApplication.m2559b().getString(C0264R.string.elder_sister));
        f1561c.put(Integer.valueOf(C0264R.id.btn_younger_sister), CalculatorApplication.m2559b().getString(C0264R.string.younger_sister));
        f1561c.put(Integer.valueOf(C0264R.id.btn_son), CalculatorApplication.m2559b().getString(C0264R.string.son));
        f1561c.put(Integer.valueOf(C0264R.id.btn_daughter), CalculatorApplication.m2559b().getString(C0264R.string.daughter));
        f1561c.put(Integer.valueOf(C0264R.id.btn_dot), String.valueOf('.'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_0), String.valueOf('0'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_1), String.valueOf('1'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_2), String.valueOf('2'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_3), String.valueOf('3'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_4), String.valueOf('4'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_5), String.valueOf('5'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_6), String.valueOf('6'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_7), String.valueOf('7'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_8), String.valueOf('8'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_9), String.valueOf('9'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_mul), String.valueOf('\u00d7'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_minus), String.valueOf('\u2212'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_div), String.valueOf('\u00f7'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_plus), String.valueOf('+'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_fac), String.valueOf('!'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_pow), String.valueOf('^'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_sqrt), String.valueOf('\u221a'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_pi), String.valueOf('\u03c0'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_sin), String.valueOf("sin"));
        f1561c.put(Integer.valueOf(C0264R.id.btn_lp), String.valueOf('('));
        f1561c.put(Integer.valueOf(C0264R.id.btn_rp), String.valueOf(')'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_e), String.valueOf('e'));
        f1561c.put(Integer.valueOf(C0264R.id.btn_cos), String.valueOf("cos"));
        f1561c.put(Integer.valueOf(C0264R.id.btn_tan), String.valueOf("tan"));
        f1561c.put(Integer.valueOf(C0264R.id.btn_ln), String.valueOf("ln"));
        f1561c.put(Integer.valueOf(C0264R.id.btn_lg), String.valueOf("lg"));
        f1561c.put(Integer.valueOf(C0264R.id.btn_percent), String.valueOf('%'));
    }

    public NumberPad(Context context) {
        this(context, null);
    }

    public NumberPad(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberPad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1567h = new Stack();
        this.f1568i = new C01771(this);
    }

    private void m2917c(int i) {
        int i2;
        int i3 = 0;
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                i2 = C0264R.layout.number_pad_simple;
                i3 = C0264R.id.lyt_simple;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                i2 = C0264R.layout.number_pad_scientific;
                i3 = C0264R.id.lyt_scientific;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                i2 = C0264R.layout.number_pad_relationship;
                i3 = C0264R.id.lyt_relationship;
                break;
            default:
                i2 = 0;
                break;
        }
        if (findViewById(i3) == null) {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i2, this, true);
            for (Integer intValue : f1560b.keySet()) {
                int intValue2 = intValue.intValue();
                if (((Integer) f1560b.get(Integer.valueOf(intValue2))).intValue() != 0) {
                    View findViewById = findViewById(intValue2);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(this.f1568i);
                    }
                }
            }
        }
    }

    public void setOnNumberClickListener(OnNumberClickListener onNumberClickListener) {
        this.f1566g = onNumberClickListener;
    }

    public void setPadType(int i) {
        if (this.f1565a != i) {
            m2913b();
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    m2917c(0);
                    m2907a(C0264R.id.lyt_c_d_d, false);
                    m2907a(C0264R.id.lyt_m_m_p_e, false);
                    m2907a(C0264R.id.btn_ok, false);
                    m2907a(C0264R.id.btn_percent, false);
                    m2907a(C0264R.id.btn_0_p, false);
                    if (i != 2) {
                        m2907a(C0264R.id.btn_del_2, false);
                        m2907a(C0264R.id.btn_neg, false);
                        break;
                    }
                    m2907a(C0264R.id.btn_del, false);
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    m2917c(0);
                    m2907a(C0264R.id.lyt_c_d, false);
                    m2907a(C0264R.id.btn_ok, false);
                    m2907a(C0264R.id.btn_0, false);
                    break;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    m2917c(1);
                    break;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    m2917c(0);
                    m2907a(C0264R.id.btn_equal, false);
                    m2907a(C0264R.id.lyt_c_d, false);
                    m2907a(C0264R.id.btn_0, false);
                    m2920e(true);
                    m2919d(false);
                    m2914b(C0264R.id.btn_c, false);
                    break;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    m2917c(0);
                    m2907a(C0264R.id.btn_equal, false);
                    m2907a(C0264R.id.lyt_c_d, false);
                    m2907a(C0264R.id.btn_0, false);
                    m2920e(false);
                    m2919d(true);
                    m2914b(C0264R.id.btn_c, false);
                    m2914b(C0264R.id.btn_del, false);
                    m2914b(C0264R.id.btn_percent, false);
                    break;
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    m2917c(2);
                    break;
            }
            this.f1565a = i;
        }
    }

    private void m2907a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
    }

    private void m2914b(int i, boolean z) {
        for (Integer num : f1560b.keySet()) {
            if (i == ((Integer) f1560b.get(num)).intValue() && findViewById(num.intValue()) != null) {
                findViewById(num.intValue()).setEnabled(z);
            }
        }
    }

    private void m2919d(boolean z) {
        Iterator it = f1562d.iterator();
        while (it.hasNext()) {
            m2914b(((Integer) it.next()).intValue(), z);
        }
    }

    private void m2920e(boolean z) {
        Iterator it = f1563e.iterator();
        while (it.hasNext()) {
            m2914b(((Integer) it.next()).intValue(), z);
        }
    }

    public void m2923a(boolean z) {
        Iterator it = f1564f.iterator();
        while (it.hasNext()) {
            findViewById(((Integer) it.next()).intValue()).setEnabled(z);
        }
    }

    public void m2924b(boolean z) {
        findViewById(C0264R.id.relationship_btn_cross_check).setEnabled(z);
    }

    private void m2913b() {
        for (Integer intValue : f1560b.keySet()) {
            View findViewById = findViewById(intValue.intValue());
            if (findViewById != null) {
                findViewById.setEnabled(true);
                findViewById.setVisibility(0);
            }
        }
    }

    public void m2925c(boolean z) {
        for (Integer num : f1560b.keySet()) {
            if (C0264R.id.btn_c == ((Integer) f1560b.get(num)).intValue()) {
                View findViewById = findViewById(num.intValue());
                if (findViewById != null && (findViewById instanceof ImageView)) {
                    ((ImageView) findViewById).setImageResource(z ? C0264R.drawable.btn_pad_ac : C0264R.drawable.btn_pad_c);
                }
            }
        }
    }

    public static boolean m2909a(int i) {
        return f1563e.contains(Integer.valueOf(i));
    }

    public static String m2910b(int i) {
        String str = (String) f1561c.get(Integer.valueOf(i));
        return str == null ? "" : str;
    }

    public String m2921a(String str, int i, boolean z) {
        return m2922a("", str, i, z);
    }

    public String m2922a(String str, String str2, int i, boolean z) {
        String str3;
        if (str2 == null) {
            str2 = String.valueOf('0');
        }
        String b = NumberFormatUtils.m2880b(str2);
        switch (i) {
            case C0264R.id.btn_c /*2131689698*/:
                str3 = "0";
                break;
            case C0264R.id.btn_del /*2131689700*/:
                str3 = m2911b(b);
                break;
            case C0264R.id.btn_neg /*2131689702*/:
                str3 = m2915c(b);
                break;
            case C0264R.id.btn_equal /*2131689707*/:
                str3 = b;
                break;
            case C0264R.id.btn_ok /*2131689708*/:
                str3 = b;
                break;
            default:
                str3 = m2910b(i);
                if (Calculator.m2805b(str3)) {
                    str3 = str3 + '(';
                }
                if (!TextUtils.isEmpty(str3)) {
                    if (this.f1565a != 6 && this.f1565a != 5) {
                        str3 = m2912b(str, b, str3);
                        break;
                    }
                    str3 = m2905a(str, b, str3);
                    break;
                }
                str3 = b;
                break;
                break;
        }
        if (DefaultPreferenceHelper.m2834a()) {
            this.f1567h.clear();
            m2908a(str3);
        }
        if (!z) {
            return str3;
        }
        String a = NumberFormatUtils.m2874a(str3);
        if (NumberFormatUtils.m2880b(a).equals(str3)) {
            return a;
        }
        return NumberFormatUtils.m2874a(b);
    }

    private void m2908a(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(41);
            if (indexOf < 0 && indexOf2 < 0) {
                return;
            }
            if (indexOf >= 0 && (indexOf2 < 0 || indexOf < indexOf2)) {
                String substring = str.substring(0, indexOf);
                if (substring.contains("sin") || substring.contains("cos") || substring.contains("tan")) {
                    this.f1567h.push(Boolean.valueOf(true));
                } else if (substring.length() == 0) {
                    Stack stack = this.f1567h;
                    if (!this.f1567h.isEmpty()) {
                        z = ((Boolean) this.f1567h.peek()).booleanValue();
                    }
                    stack.push(Boolean.valueOf(z));
                } else {
                    this.f1567h.push(Boolean.valueOf(false));
                }
                m2908a(str.substring(indexOf + 1));
            } else if (!this.f1567h.empty()) {
                this.f1567h.pop();
                m2908a(str.substring(indexOf2 + 1));
            }
        }
    }

    private boolean m2918c() {
        if (this.f1567h.size() <= 0) {
            return false;
        }
        return ((Boolean) this.f1567h.peek()).booleanValue();
    }

    private String m2911b(String str) {
        int i = 0;
        if (str == null) {
            return str;
        }
        String str2;
        int length = str.length();
        if ((length > 0 ? str.charAt(length - 1) : '\u0000') == '\u00b0') {
            char charAt;
            if (length > 2) {
                charAt = str.charAt(length - 3);
            } else {
                charAt = '\u0000';
            }
            if (Character.isDigit(charAt)) {
                str2 = str.substring(0, length - 2) + '\u00b0';
            } else {
                str2 = str.substring(0, length - 2);
            }
        } else {
            str2 = str.substring(0, length - 1);
        }
        length = 0;
        while (i < str2.length()) {
            if (Character.isDigit(str2.charAt(i))) {
                length = 1;
            }
            i++;
        }
        if (length == 0 || TextUtils.isEmpty(str2)) {
            return "0";
        }
        return str2;
    }

    private String m2915c(String str) {
        if (str == null) {
            return str;
        }
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!(i2 == 0 || ((charAt != '\u2212' && charAt != '-') || Character.isDigit(charAt) || charAt == 'e'))) {
                i = 0;
            }
        }
        if (i == 0) {
            return String.valueOf('\u2212') + '(' + str + ')';
        }
        char charAt2 = str.charAt(0);
        if (charAt2 == '\u2212' || charAt2 == '-') {
            if (str.length() > 1) {
                return str.substring(1);
            }
            return String.valueOf('0');
        } else if (charAt2 == '0' && str.length() == 1) {
            return str;
        } else {
            return String.valueOf('\u2212') + str;
        }
    }

    private String m2905a(String str, String str2, String str3) {
        int i = 0;
        int length = str3.length();
        if (this.f1565a == 6) {
            return length == 1 ? str3 : str2;
        } else {
            if (this.f1565a != 5 || length != 1) {
                return str2;
            }
            char charAt = str3.charAt(0);
            if ('\u2212' == charAt) {
                String substring;
                if (str2.length() > 0) {
                    i = str2.charAt(0);
                }
                if (8722 == i) {
                    substring = str2.substring(1);
                } else {
                    substring = '\u2212' + str2;
                }
                return substring;
            } else if (charAt == '%') {
                return m2916c(String.valueOf(str.charAt(str.lastIndexOf(str2) - 1)), str, str2);
            } else {
                if (Calculator.m2804b(charAt)) {
                    return str2;
                }
                return m2912b(str, str2, str3);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2912b(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
        r9 = this;
        r7 = 48;
        r5 = 46;
        r6 = 8722; // 0x2212 float:1.2222E-41 double:4.309E-320;
        r3 = 1;
        r2 = 0;
        r0 = r12.length();
        r1 = java.lang.String.valueOf(r7);
        r1 = r1.equals(r11);
        if (r1 == 0) goto L_0x0211;
    L_0x0016:
        if (r0 == r3) goto L_0x003a;
    L_0x0018:
        r11 = "";
        r1 = r11;
    L_0x001b:
        if (r0 != r3) goto L_0x01f8;
    L_0x001d:
        r4 = r12.charAt(r2);
        r0 = 37;
        if (r4 != r0) goto L_0x00e8;
    L_0x0025:
        r0 = r1.length();
        r0 = r0 + -1;
    L_0x002b:
        if (r0 < 0) goto L_0x0067;
    L_0x002d:
        r4 = r1.charAt(r0);
        r4 = com.miui.calculator.common.utils.Calculator.m2804b(r4);
        if (r4 != 0) goto L_0x0052;
    L_0x0037:
        r0 = r0 + -1;
        goto L_0x002b;
    L_0x003a:
        r1 = r12.charAt(r2);
        r4 = com.miui.calculator.common.utils.Calculator.m2804b(r1);
        if (r4 == 0) goto L_0x0048;
    L_0x0044:
        r4 = 8730; // 0x221a float:1.2233E-41 double:4.313E-320;
        if (r1 != r4) goto L_0x0211;
    L_0x0048:
        if (r1 == r5) goto L_0x0211;
    L_0x004a:
        r4 = 37;
        if (r1 == r4) goto L_0x0211;
    L_0x004e:
        r11 = "";
        r1 = r11;
        goto L_0x001b;
    L_0x0052:
        if (r0 <= r3) goto L_0x0067;
    L_0x0054:
        r4 = r1.charAt(r0);
        if (r4 != r6) goto L_0x0067;
    L_0x005a:
        r4 = r0 + -1;
        r4 = r1.charAt(r4);
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r4 != r5) goto L_0x0067;
    L_0x0064:
        r0 = r0 + -1;
        goto L_0x002b;
    L_0x0067:
        r4 = r0 + 1;
        r4 = r1.substring(r4);
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r5 = r4.lastIndexOf(r5);
        r6 = android.text.TextUtils.isEmpty(r4);
        if (r6 != 0) goto L_0x020e;
    L_0x0079:
        r0 = r0 + 1;
        r0 = r1.substring(r2, r0);
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r0);
        r0 = r9.m2916c(r0, r10, r4);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4 = java.lang.String.valueOf(r7);
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x00e7;
    L_0x009e:
        r4 = -1;
        if (r5 == r4) goto L_0x00e7;
    L_0x00a1:
        r4 = r5 + 1;
        r4 = r1.substring(r2, r4);
        r5 = r5 + 1;
        r1 = r1.substring(r5);
        r5 = com.miui.calculator.common.utils.Calculator.m2801a();
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r1 = r6.append(r1);
        r6 = "-2";
        r1 = r1.append(r6);
        r1 = r1.toString();
        r1 = r5.m2810a(r1);
        r5 = 8722; // 0x2212 float:1.2222E-41 double:4.309E-320;
        r6 = 45;
        r5 = r1.replace(r5, r6);	 Catch:{ Exception -> 0x020b }
        java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x020b }
        r2 = r3;
    L_0x00d4:
        if (r2 == 0) goto L_0x00e7;
    L_0x00d6:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r4);
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x00e7:
        return r0;
    L_0x00e8:
        if (r4 != r5) goto L_0x0109;
    L_0x00ea:
        r0 = r1.length();
        r0 = r0 + -1;
    L_0x00f0:
        if (r0 < 0) goto L_0x00ff;
    L_0x00f2:
        r3 = r1.charAt(r0);
        r3 = java.lang.Character.isDigit(r3);
        if (r3 == 0) goto L_0x00ff;
    L_0x00fc:
        r0 = r0 + -1;
        goto L_0x00f0;
    L_0x00ff:
        if (r0 < 0) goto L_0x0109;
    L_0x0101:
        r0 = r1.charAt(r0);
        if (r0 != r5) goto L_0x0109;
    L_0x0107:
        r0 = r1;
        goto L_0x00e7;
    L_0x0109:
        r3 = r1.length();
        if (r3 <= 0) goto L_0x013f;
    L_0x010f:
        r0 = r3 + -1;
        r0 = r1.charAt(r0);
    L_0x0115:
        r5 = com.miui.calculator.common.utils.Calculator.m2804b(r4);
        if (r5 == 0) goto L_0x0146;
    L_0x011b:
        r5 = 8730; // 0x221a float:1.2233E-41 double:4.313E-320;
        if (r4 != r5) goto L_0x0123;
    L_0x011f:
        r5 = 94;
        if (r0 != r5) goto L_0x0146;
    L_0x0123:
        r8 = r3;
        r3 = r1;
        r1 = r8;
    L_0x0126:
        r5 = com.miui.calculator.common.utils.Calculator.m2804b(r0);
        if (r5 == 0) goto L_0x0143;
    L_0x012c:
        r5 = 33;
        if (r0 == r5) goto L_0x0143;
    L_0x0130:
        r1 = r1 + -1;
        r3 = r3.substring(r2, r1);
        if (r1 <= 0) goto L_0x0141;
    L_0x0138:
        r0 = r1 + -1;
        r0 = r3.charAt(r0);
        goto L_0x0126;
    L_0x013f:
        r0 = r2;
        goto L_0x0115;
    L_0x0141:
        r0 = r2;
        goto L_0x0126;
    L_0x0143:
        r8 = r1;
        r1 = r3;
        r3 = r8;
    L_0x0146:
        if (r3 > 0) goto L_0x0166;
    L_0x0148:
        r0 = com.miui.calculator.common.utils.Calculator.m2804b(r4);
        if (r0 == 0) goto L_0x0166;
    L_0x014e:
        r0 = 8730; // 0x221a float:1.2233E-41 double:4.313E-320;
        if (r4 == r0) goto L_0x0166;
    L_0x0152:
        if (r4 == r6) goto L_0x0166;
    L_0x0154:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r7);
        r0 = r0.append(r12);
        r0 = r0.toString();
        goto L_0x00e7;
    L_0x0166:
        r3 = r1.length();
        if (r3 <= 0) goto L_0x019b;
    L_0x016c:
        r0 = r3 + -1;
        r0 = r1.charAt(r0);
    L_0x0172:
        r5 = 176; // 0xb0 float:2.47E-43 double:8.7E-322;
        if (r0 != r5) goto L_0x01b0;
    L_0x0176:
        r0 = com.miui.calculator.common.utils.Calculator.m2806c(r4);
        if (r0 == 0) goto L_0x019d;
    L_0x017c:
        r0 = r3 + -1;
        r0 = r1.substring(r2, r0);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r0 = r0.append(r4);
        r1 = 176; // 0xb0 float:2.47E-43 double:8.7E-322;
        r0 = r0.append(r1);
        r0 = r0.toString();
        goto L_0x00e7;
    L_0x019b:
        r0 = r2;
        goto L_0x0172;
    L_0x019d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r1);
        r0 = r0.append(r4);
        r0 = r0.toString();
        goto L_0x00e7;
    L_0x01b0:
        r2 = com.miui.calculator.common.utils.DefaultPreferenceHelper.m2834a();
        if (r2 == 0) goto L_0x01e5;
    L_0x01b6:
        r2 = r9.m2918c();
        if (r2 == 0) goto L_0x01e5;
    L_0x01bc:
        if (r0 == r6) goto L_0x01c6;
    L_0x01be:
        r2 = 43;
        if (r0 == r2) goto L_0x01c6;
    L_0x01c2:
        r2 = 40;
        if (r0 != r2) goto L_0x01e5;
    L_0x01c6:
        r0 = com.miui.calculator.common.utils.Calculator.m2806c(r4);
        if (r0 == 0) goto L_0x01e5;
    L_0x01cc:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r1);
        r0 = r0.append(r4);
        r1 = 176; // 0xb0 float:2.47E-43 double:8.7E-322;
        r0 = r0.append(r1);
        r0 = r0.toString();
        goto L_0x00e7;
    L_0x01e5:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r1);
        r0 = r0.append(r12);
        r0 = r0.toString();
        goto L_0x00e7;
    L_0x01f8:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r1);
        r0 = r0.append(r12);
        r0 = r0.toString();
        goto L_0x00e7;
    L_0x020b:
        r3 = move-exception;
        goto L_0x00d4;
    L_0x020e:
        r0 = r1;
        goto L_0x00e7;
    L_0x0211:
        r1 = r11;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.calculator.common.widget.NumberPad.b(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private String m2916c(String str, String str2, String str3) {
        String str4 = "";
        if (TextUtils.isEmpty(str2)) {
            return str4;
        }
        Calculator a = Calculator.m2801a();
        if (TextUtils.equals(str, String.valueOf('+')) || TextUtils.equals(str, String.valueOf('\u2212'))) {
            return a.m2810a(Calculator.m2801a().m2810a(str2.substring(0, str2.lastIndexOf(str3) - 1)) + '\u00d7' + str3 + '%');
        }
        return a.m2810a(str3 + '%');
    }
}
