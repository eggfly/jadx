package com.miui.calculator.tax;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.common.widget.ResultItemView;
import com.miui.calculator.tax.TaxCalculator.TaxResult;
import com.miui.calculator.tax.TaxRateGetter.CityTaxData;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class TaxResultActivity extends Activity {
    private TaxResult f1865a;
    private int f1866b;
    private TextView f1867c;
    private TextView f1868d;
    private ResultItemView f1869e;
    private ResultItemView f1870f;
    private ResultItemView f1871g;
    private ResultItemView f1872h;
    private ResultItemView f1873i;
    private ResultItemView f1874j;
    private ResultItemView f1875k;
    private TextView f1876l;

    /* renamed from: com.miui.calculator.tax.TaxResultActivity.1 */
    class C02281 extends ClickableSpan {
        final /* synthetic */ TaxResultActivity f1864a;

        C02281(TaxResultActivity taxResultActivity) {
            this.f1864a = taxResultActivity;
        }

        public void onClick(View view) {
            TaxCalMethodActivity.m3195a(this.f1864a, this.f1864a.f1866b);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.tax_result_activity);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("extra_income", 0);
        this.f1866b = intent.getIntExtra("extra_income_type", 0);
        int intExtra2 = intent.getIntExtra("extra_last_salary", 0);
        this.f1865a = TaxCalculator.m3199a(intExtra, this.f1866b, (CityTaxData) intent.getParcelableExtra("extra_city_tax_data"), intExtra2);
        m3227a();
        m3228b();
    }

    private void m3227a() {
        this.f1867c = (TextView) findViewById(C0264R.id.txv_real_get);
        this.f1868d = (TextView) findViewById(C0264R.id.txv_income_tax);
        this.f1869e = (ResultItemView) findViewById(C0264R.id.riv_income);
        this.f1870f = (ResultItemView) findViewById(C0264R.id.riv_accumulation_fund);
        this.f1871g = (ResultItemView) findViewById(C0264R.id.riv_endowment);
        this.f1872h = (ResultItemView) findViewById(C0264R.id.riv_medical);
        this.f1873i = (ResultItemView) findViewById(C0264R.id.riv_unemployment);
        this.f1874j = (ResultItemView) findViewById(C0264R.id.riv_injuery);
        this.f1875k = (ResultItemView) findViewById(C0264R.id.riv_birth);
        this.f1876l = (TextView) findViewById(C0264R.id.txv_cal_method);
        this.f1869e.setTitle((int) C0264R.string.tax_income_before_tax);
        this.f1870f.setTitle((int) C0264R.string.tax_accumulation_fund);
        this.f1871g.setTitle((int) C0264R.string.tax_endowment);
        this.f1872h.setTitle((int) C0264R.string.tax_medical);
        this.f1873i.setTitle((int) C0264R.string.tax_unemployment);
        this.f1874j.setTitle((int) C0264R.string.tax_injury);
        this.f1875k.setTitle((int) C0264R.string.tax_birth);
        String str = null;
        switch (this.f1866b) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                this.f1870f.setVisibility(0);
                this.f1871g.setVisibility(0);
                this.f1872h.setVisibility(0);
                this.f1873i.setVisibility(0);
                this.f1874j.setVisibility(0);
                this.f1875k.setVisibility(0);
                str = getString(C0264R.string.tax_cal_method_fixed_salary);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f1870f.setVisibility(8);
                this.f1871g.setVisibility(8);
                this.f1872h.setVisibility(8);
                this.f1873i.setVisibility(8);
                this.f1874j.setVisibility(8);
                this.f1875k.setVisibility(8);
                str = getString(C0264R.string.tax_cal_method_annual);
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(getString(C0264R.string.tax_cal_method_format, new Object[]{str}));
            int lastIndexOf = spannableStringBuilder.toString().lastIndexOf(str);
            if (lastIndexOf != -1) {
                spannableStringBuilder.setSpan(new C02281(this), lastIndexOf, str.length() + lastIndexOf, 17);
                this.f1876l.setText(spannableStringBuilder);
                this.f1876l.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    private void m3228b() {
        this.f1867c.setText(m3226a(NumberFormatUtils.m2884d(this.f1865a.f1830b), false));
        this.f1868d.setText(m3226a(NumberFormatUtils.m2884d(this.f1865a.f1831c), true));
        this.f1869e.setSummary(NumberFormatUtils.m2876b((double) this.f1865a.f1829a));
        this.f1875k.setSummary(NumberFormatUtils.m2876b(this.f1865a.f1836h));
        this.f1872h.setSummary(NumberFormatUtils.m2876b(this.f1865a.f1833e));
        this.f1874j.setSummary(NumberFormatUtils.m2876b(this.f1865a.f1835g));
        this.f1873i.setSummary(NumberFormatUtils.m2876b(this.f1865a.f1834f));
        this.f1871g.setSummary(NumberFormatUtils.m2876b(this.f1865a.f1832d));
        this.f1870f.setSummary(NumberFormatUtils.m2876b(this.f1865a.f1837i));
    }

    private SpannableString m3226a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = getString(C0264R.string.unit_yuan);
        int length = string == null ? 0 : string.length();
        SpannableString spannableString = new SpannableString(str + string);
        spannableString.setSpan(new TextAppearanceSpan(this, z ? C0264R.style.tax_result_primary_blue_text_style : C0264R.style.tax_result_primary_text_style), 0, str.length(), 33);
        spannableString.setSpan(new TextAppearanceSpan(this, z ? C0264R.style.tax_result_primary_unit_blue_text_style : C0264R.style.tax_result_primary_unit_text_style), str.length(), length + str.length(), 33);
        return spannableString;
    }
}
