package com.miui.calculator.tax;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.widget.SuffixNumberInput;
import com.miui.calculator.tax.TaxRateGetter.CityTaxData;
import com.miui.support.internal.C0264R;

public class SiExtendableView extends FrameLayout {
    private boolean f1789a;
    private OnClickListener f1790b;
    private ViewGroup f1791c;
    private View f1792d;
    private View f1793e;
    private SuffixNumberInput f1794f;
    private SuffixNumberInput f1795g;
    private SuffixNumberInput f1796h;
    private SuffixNumberInput f1797i;
    private SuffixNumberInput f1798j;
    private SuffixNumberInput f1799k;
    private OnClickListener f1800l;

    /* renamed from: com.miui.calculator.tax.SiExtendableView.1 */
    class C02151 implements OnClickListener {
        final /* synthetic */ SiExtendableView f1788a;

        C02151(SiExtendableView siExtendableView) {
            this.f1788a = siExtendableView;
        }

        public void onClick(View view) {
            if (this.f1788a.f1790b != null) {
                this.f1788a.f1790b.onClick(this.f1788a);
            }
        }
    }

    public SiExtendableView(Context context) {
        this(context, null);
    }

    public SiExtendableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SiExtendableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1800l = new C02151(this);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.si_extendable_view, this, true);
        this.f1791c = (ViewGroup) inflate.findViewById(C0264R.id.lyt_si);
        this.f1794f = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_fund);
        this.f1795g = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_endowment);
        this.f1796h = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_medical);
        this.f1797i = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_unemployment);
        this.f1798j = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_injury);
        this.f1799k = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_birth);
        this.f1793e = inflate.findViewById(C0264R.id.imv_arrow_right);
        this.f1794f.setType(6);
        this.f1795g.setType(6);
        this.f1796h.setType(6);
        this.f1797i.setType(6);
        this.f1798j.setType(6);
        this.f1799k.setType(6);
        this.f1792d = inflate.findViewById(C0264R.id.div_h);
        this.f1789a = true;
        m3160a();
    }

    public void setData(CityTaxData cityTaxData) {
        this.f1794f.setText(String.valueOf(cityTaxData.f1849h * 100.0d));
        this.f1795g.setText(String.valueOf(cityTaxData.f1845d * 100.0d));
        this.f1796h.setText(String.valueOf(cityTaxData.f1844c * 100.0d));
        this.f1797i.setText(String.valueOf(cityTaxData.f1846e * 100.0d));
        this.f1798j.setText(String.valueOf(cityTaxData.f1847f * 100.0d));
        this.f1799k.setText(String.valueOf(cityTaxData.f1848g * 100.0d));
        this.f1794f.setHint(String.valueOf(cityTaxData.f1849h * 100.0d));
        this.f1795g.setHint(String.valueOf(cityTaxData.f1845d * 100.0d));
        this.f1796h.setHint(String.valueOf(cityTaxData.f1844c * 100.0d));
        this.f1797i.setHint(String.valueOf(cityTaxData.f1846e * 100.0d));
        this.f1798j.setHint(String.valueOf(cityTaxData.f1847f * 100.0d));
        this.f1799k.setHint(String.valueOf(cityTaxData.f1848g * 100.0d));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f1790b = onClickListener;
        findViewById(C0264R.id.lyt_header).setOnClickListener(this.f1800l);
    }

    public CityTaxData getParams() {
        CityTaxData cityTaxData = new CityTaxData();
        cityTaxData.f1849h = CalculatorUtils.m2813a(this.f1794f.getText()) / 100.0d;
        cityTaxData.f1845d = CalculatorUtils.m2813a(this.f1795g.getText()) / 100.0d;
        cityTaxData.f1844c = CalculatorUtils.m2813a(this.f1796h.getText()) / 100.0d;
        cityTaxData.f1846e = CalculatorUtils.m2813a(this.f1797i.getText()) / 100.0d;
        cityTaxData.f1847f = CalculatorUtils.m2813a(this.f1798j.getText()) / 100.0d;
        cityTaxData.f1848g = CalculatorUtils.m2813a(this.f1799k.getText()) / 100.0d;
        return cityTaxData;
    }

    public void m3160a() {
        this.f1789a = !this.f1789a;
        if (this.f1789a) {
            this.f1791c.setVisibility(0);
            this.f1792d.setVisibility(0);
            this.f1793e.setRotation(-90.0f);
            return;
        }
        this.f1791c.setVisibility(8);
        this.f1792d.setVisibility(8);
        this.f1793e.setRotation(90.0f);
    }
}
