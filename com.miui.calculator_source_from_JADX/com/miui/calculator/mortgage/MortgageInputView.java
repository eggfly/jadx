package com.miui.calculator.mortgage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.widget.SuffixNumberInput;
import com.miui.calculator.common.widget.SuffixNumberInput.OnTextChangedListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.math.BigDecimal;

public class MortgageInputView extends LinearLayout {
    private int f1708a;
    private int f1709b;
    private TextView f1710c;
    private TextView f1711d;
    private TextView f1712e;
    private TextView f1713f;
    private TextView f1714g;
    private SuffixNumberInput f1715h;
    private SuffixNumberInput f1716i;
    private OnTextChangedListener f1717j;

    /* renamed from: com.miui.calculator.mortgage.MortgageInputView.1 */
    class C02041 implements OnTextChangedListener {
        final /* synthetic */ MortgageInputView f1707a;

        C02041(MortgageInputView mortgageInputView) {
            this.f1707a = mortgageInputView;
        }

        public void m3071a() {
            if (this.f1707a.f1708a == 4 || this.f1707a.f1708a == 5) {
                this.f1707a.m3074b();
            }
        }
    }

    public MortgageInputView(Context context) {
        this(context, null);
    }

    public MortgageInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MortgageInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1717j = new C02041(this);
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.mortgage_input_view, this, true);
        this.f1710c = (TextView) viewGroup.findViewById(C0264R.id.txv_title);
        this.f1711d = (TextView) viewGroup.findViewById(C0264R.id.txv_multiply);
        this.f1712e = (TextView) viewGroup.findViewById(C0264R.id.txv_equal);
        this.f1713f = (TextView) viewGroup.findViewById(C0264R.id.txv_result);
        this.f1714g = (TextView) viewGroup.findViewById(C0264R.id.txv_tip);
        this.f1715h = (SuffixNumberInput) viewGroup.findViewById(C0264R.id.met_input_1);
        this.f1716i = (SuffixNumberInput) viewGroup.findViewById(C0264R.id.met_input_2);
        this.f1715h.setOnTextChangedListener(this.f1717j);
        this.f1716i.setOnTextChangedListener(this.f1717j);
    }

    public String getText1() {
        return this.f1715h.getText();
    }

    public String getText2() {
        return this.f1716i.getText();
    }

    public void setText1(String str) {
        this.f1715h.setText(str);
        if (!CalculatorUtils.m2821b()) {
            if (this.f1708a == 4 || this.f1708a == 5) {
                this.f1714g.setText(getResources().getString(this.f1709b == 1 ? C0264R.string.mortgage_descript_commercial : C0264R.string.mortgage_descript_accumulation, new Object[]{this.f1715h.getText() + "%"}));
            }
        }
    }

    public void setText2(String str) {
        this.f1716i.setText(str);
    }

    public double getInterestRateReulst() {
        Object text = this.f1715h.getText();
        Object text2 = this.f1716i.getText();
        if (TextUtils.isEmpty(text) || TextUtils.isEmpty(text2)) {
            return 0.0d;
        }
        return new BigDecimal(text).multiply(new BigDecimal(text2)).divide(new BigDecimal(100)).setScale(6, 4).doubleValue();
    }

    public void m3076a(int i) {
        this.f1715h.setError(i);
    }

    public void m3077a(int i, int i2) {
        this.f1708a = i;
        this.f1709b = i2;
        m3073a();
    }

    private void m3073a() {
        switch (this.f1708a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f1711d.setVisibility(8);
                this.f1712e.setVisibility(8);
                this.f1713f.setVisibility(8);
                this.f1714g.setVisibility(8);
                this.f1715h.setVisibility(0);
                this.f1715h.getLayoutParams().width = -1;
                this.f1716i.setVisibility(8);
                this.f1710c.setText(C0264R.string.mortgage_amount);
                this.f1715h.setType(1);
                this.f1716i.setType(1);
                if (this.f1709b == 1) {
                    this.f1715h.setType(2);
                } else if (this.f1709b == 2) {
                    this.f1715h.setType(3);
                }
                if (this.f1708a == 1) {
                    this.f1710c.setVisibility(0);
                } else if (this.f1708a == 2) {
                    this.f1710c.setVisibility(4);
                } else {
                    String string;
                    this.f1710c.setVisibility(8);
                    SuffixNumberInput suffixNumberInput = this.f1715h;
                    if (this.f1709b == 1) {
                        string = getContext().getString(C0264R.string.loan_edittext_hint_commercial_combined);
                    } else {
                        string = getContext().getString(C0264R.string.loan_edittext_hint_fund_combined);
                    }
                    suffixNumberInput.setHint(string);
                }
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                if (CalculatorUtils.m2821b()) {
                    this.f1711d.setVisibility(8);
                    this.f1712e.setVisibility(8);
                    this.f1713f.setVisibility(8);
                    this.f1716i.setVisibility(8);
                    this.f1715h.getLayoutParams().width = -1;
                } else {
                    this.f1711d.setVisibility(0);
                    this.f1712e.setVisibility(0);
                    this.f1713f.setVisibility(0);
                    this.f1716i.setVisibility(0);
                    if (this.f1709b == 1) {
                        this.f1715h.setHint("4.9");
                    } else if (this.f1709b == 2) {
                        this.f1715h.setHint("3.25");
                    }
                }
                this.f1714g.setVisibility(0);
                this.f1715h.setVisibility(0);
                if (this.f1708a == 4) {
                    this.f1710c.setVisibility(0);
                } else {
                    this.f1710c.setVisibility(4);
                }
                this.f1710c.setText(C0264R.string.mortgage_interest_rate);
                this.f1715h.setType(5);
                this.f1716i.setType(4);
                if (!CalculatorUtils.m2821b()) {
                    if (this.f1709b == 1) {
                        this.f1714g.setText(C0264R.string.mortgage_descript_commercial);
                        this.f1714g.setText(getResources().getString(C0264R.string.mortgage_descript_commercial, new Object[]{this.f1715h.getText() + "%"}));
                    } else {
                        this.f1714g.setText(C0264R.string.mortgage_descript_accumulation);
                        this.f1714g.setText(getResources().getString(C0264R.string.mortgage_descript_accumulation, new Object[]{this.f1715h.getText() + "%"}));
                    }
                }
                m3074b();
            default:
        }
    }

    private void m3074b() {
        if (this.f1708a == 4 || this.f1708a == 5) {
            this.f1713f.setText(new BigDecimal(String.valueOf(getInterestRateReulst())).multiply(new BigDecimal(100)).doubleValue() + "%");
        }
    }
}
