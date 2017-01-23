package com.miui.calculator.tax;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.calculator.common.widget.OptionItemView;
import com.miui.calculator.common.widget.SuffixNumberInput;
import com.miui.calculator.common.widget.SuffixNumberInput.OnTextChangedListener;
import com.miui.calculator.tax.TaxRateGetter.CityTaxData;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.HashMap;

public class TaxView extends ScrollView {
    private static HashMap<Integer, Integer> f1880b;
    private CityTaxData f1881a;
    private int f1882c;
    private SuffixNumberInput f1883d;
    private SuffixNumberInput f1884e;
    private OptionItemView f1885f;
    private OptionItemView f1886g;
    private SiExtendableView f1887h;
    private ViewGroup f1888i;
    private ViewGroup f1889j;
    private View f1890k;
    private TextView f1891l;
    private OnItemClickListener f1892m;
    private OnSizeChangeListener f1893n;
    private OnClickListener f1894o;

    public interface OnSizeChangeListener {
        void m3161a(TaxView taxView);
    }

    public interface OnItemClickListener {
        void m3163a(int i);
    }

    /* renamed from: com.miui.calculator.tax.TaxView.1 */
    class C02291 implements OnTextChangedListener {
        final /* synthetic */ TaxView f1877a;

        C02291(TaxView taxView) {
            this.f1877a = taxView;
        }

        public void m3229a() {
            this.f1877a.m3238a(this.f1877a.f1883d, false);
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxView.2 */
    class C02302 implements OnTextChangedListener {
        final /* synthetic */ TaxView f1878a;

        C02302(TaxView taxView) {
            this.f1878a = taxView;
        }

        public void m3230a() {
            this.f1878a.m3238a(this.f1878a.f1884e, false);
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxView.3 */
    class C02313 implements OnClickListener {
        final /* synthetic */ TaxView f1879a;

        C02313(TaxView taxView) {
            this.f1879a = taxView;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0264R.id.sev_si /*2131689764*/:
                    this.f1879a.f1887h.m3160a();
                default:
                    if (this.f1879a.f1892m != null) {
                        Integer num = (Integer) TaxView.f1880b.get(Integer.valueOf(view.getId()));
                        if (num != null) {
                            this.f1879a.f1892m.m3163a(num.intValue());
                        }
                    }
            }
        }
    }

    static {
        f1880b = new HashMap();
        f1880b.put(Integer.valueOf(C0264R.id.oiv_city), Integer.valueOf(C0264R.id.oiv_city));
        f1880b.put(Integer.valueOf(C0264R.id.oiv_threshold), Integer.valueOf(C0264R.id.oiv_threshold));
    }

    public TaxView(Context context) {
        this(context, null);
    }

    public TaxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1894o = new C02313(this);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.tax_view, this, true);
        this.f1883d = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_income_number);
        this.f1884e = (SuffixNumberInput) inflate.findViewById(C0264R.id.sni_last_salary_number);
        this.f1885f = (OptionItemView) inflate.findViewById(C0264R.id.oiv_city);
        this.f1886g = (OptionItemView) inflate.findViewById(C0264R.id.oiv_threshold);
        this.f1887h = (SiExtendableView) inflate.findViewById(C0264R.id.sev_si);
        this.f1888i = (ViewGroup) inflate.findViewById(C0264R.id.lyt_fixed);
        this.f1889j = (ViewGroup) inflate.findViewById(C0264R.id.lyt_last_salary);
        this.f1890k = inflate.findViewById(C0264R.id.div_h);
        this.f1891l = (TextView) inflate.findViewById(C0264R.id.tax_income_title);
        this.f1885f.setTitle((int) C0264R.string.tax_city);
        this.f1886g.setTitle((int) C0264R.string.tax_threshold);
        this.f1885f.setOnClickListener(this.f1894o);
        this.f1886g.setOnClickListener(this.f1894o);
        this.f1887h.setOnClickListener(this.f1894o);
        this.f1883d.setOnTextChangedListener(new C02291(this));
        this.f1884e.setOnTextChangedListener(new C02302(this));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1893n != null) {
            this.f1893n.m3161a(this);
        }
    }

    public boolean m3239a(boolean z) {
        switch (this.f1882c) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return m3238a(this.f1883d, z);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return m3238a(this.f1883d, z) && m3238a(this.f1884e, z);
            default:
                return false;
        }
    }

    public boolean m3238a(SuffixNumberInput suffixNumberInput, boolean z) {
        Object text = suffixNumberInput.getText();
        if (!TextUtils.isEmpty(text)) {
            boolean z2;
            try {
                Integer.parseInt(text);
                z2 = true;
            } catch (Exception e) {
                z2 = false;
            }
            if (!z2) {
                suffixNumberInput.setError(C0264R.string.tax_income_error);
                return false;
            } else if (z && this.f1881a == null) {
                Toast.makeText(getContext(), C0264R.string.tax_city_error, 0).show();
                return false;
            } else {
                CityTaxData params = this.f1887h.getParams();
                if (params.f1844c + ((((params.f1849h + params.f1848g) + params.f1845d) + params.f1847f) + params.f1846e) <= 50.0d) {
                    return true;
                }
                Toast.makeText(getContext(), C0264R.string.tax_param_error, 0).show();
                return false;
            }
        } else if (!z) {
            return false;
        } else {
            suffixNumberInput.setError(C0264R.string.tax_income_error);
            return false;
        }
    }

    public CityTaxData getParams() {
        if (this.f1881a == null) {
            return null;
        }
        CityTaxData params = this.f1887h.getParams();
        params.f1850i = this.f1881a.f1850i;
        params.f1842a = this.f1881a.f1842a;
        params.f1851j = this.f1881a.f1851j;
        params.f1852k = this.f1881a.f1852k;
        params.f1853l = this.f1881a.f1853l;
        params.f1854m = this.f1881a.f1854m;
        return params;
    }

    public int getIncome() {
        return m3231a(this.f1883d);
    }

    public int getLastSalary() {
        return m3231a(this.f1884e);
    }

    private int m3231a(SuffixNumberInput suffixNumberInput) {
        Object text = suffixNumberInput.getText();
        if (!TextUtils.isEmpty(text)) {
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void m3237a(CityTaxData cityTaxData) {
        this.f1881a = cityTaxData.m3207a();
        this.f1885f.setSummary(cityTaxData.f1842a);
        this.f1887h.setData(cityTaxData);
    }

    public void setTaxType(int i) {
        this.f1882c = i;
        switch (this.f1882c) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                String valueOf;
                this.f1883d.setType(7);
                this.f1884e.setVisibility(8);
                OptionItemView optionItemView = this.f1886g;
                if (this.f1882c == 0) {
                    valueOf = String.valueOf(TaxCalculator.f1838a);
                } else {
                    valueOf = String.valueOf(TaxCalculator.f1839b);
                }
                optionItemView.setSummary(valueOf);
                this.f1888i.setVisibility(0);
                this.f1889j.setVisibility(8);
                this.f1890k.setVisibility(0);
                this.f1891l.setText(C0264R.string.tax_income_number);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f1883d.setType(8);
                this.f1884e.setType(9);
                this.f1884e.setVisibility(0);
                this.f1889j.setVisibility(0);
                this.f1888i.setVisibility(8);
                this.f1890k.setVisibility(0);
                this.f1891l.setText(C0264R.string.tax_annual_bonus_number);
            default:
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f1892m = onItemClickListener;
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.f1893n = onSizeChangeListener;
    }
}
