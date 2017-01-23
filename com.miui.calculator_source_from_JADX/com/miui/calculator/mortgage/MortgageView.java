package com.miui.calculator.mortgage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.common.widget.OptionItemView;
import com.miui.calculator.mortgage.InterestRateGetter.MortgageRate;
import com.miui.support.app.AlertDialog.Builder;
import com.miui.support.app.DatePickerDialog;
import com.miui.support.app.DatePickerDialog.OnDateSetListener;
import com.miui.support.date.Calendar;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.widget.DatePicker;
import com.miui.support.widget.NumberPicker;
import com.miui.support.widget.NumberPicker.OnValueChangeListener;

public class MortgageView extends ScrollView {
    private int f1736a;
    private OnSizeChangeListener f1737b;
    private int f1738c;
    private int f1739d;
    private int f1740e;
    private int f1741f;
    private long f1742g;
    private Dialog f1743h;
    private MortgageInputView f1744i;
    private MortgageInputView f1745j;
    private MortgageInputView f1746k;
    private MortgageInputView f1747l;
    private OptionItemView f1748m;
    private OptionItemView f1749n;
    private OptionItemView f1750o;
    private InterestRateGetter f1751p;
    private OnClickListener f1752q;

    public interface OnSizeChangeListener {
        void m3043a(MortgageView mortgageView);
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageView.1 */
    class C02061 implements OnClickListener {
        final /* synthetic */ MortgageView f1729a;

        C02061(MortgageView mortgageView) {
            this.f1729a = mortgageView;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0264R.id.miv_repayment /*2131689627*/:
                    this.f1729a.m3091b();
                case C0264R.id.miv_mortgage_years /*2131689628*/:
                    this.f1729a.m3096c();
                case C0264R.id.miv_start_time /*2131689629*/:
                    this.f1729a.m3100d();
                default:
            }
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageView.2 */
    class C02072 implements DialogInterface.OnClickListener {
        final /* synthetic */ MortgageView f1730a;

        C02072(MortgageView mortgageView) {
            this.f1730a = mortgageView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1730a.f1739d = i;
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageView.3 */
    class C02083 implements DialogInterface.OnClickListener {
        final /* synthetic */ MortgageView f1731a;

        C02083(MortgageView mortgageView) {
            this.f1731a = mortgageView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1731a.m3087a(this.f1731a.f1739d);
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageView.4 */
    class C02094 implements OnValueChangeListener {
        final /* synthetic */ MortgageView f1732a;

        C02094(MortgageView mortgageView) {
            this.f1732a = mortgageView;
        }

        public void m3083a(NumberPicker numberPicker, int i, int i2) {
            this.f1732a.f1741f = i2;
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageView.5 */
    class C02105 implements DialogInterface.OnClickListener {
        final /* synthetic */ MortgageView f1733a;

        C02105(MortgageView mortgageView) {
            this.f1733a = mortgageView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1733a.f1740e = this.f1733a.f1741f;
            this.f1733a.m3092b(this.f1733a.f1741f);
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageView.6 */
    class C02116 implements OnDateSetListener {
        final /* synthetic */ Calendar f1734a;
        final /* synthetic */ MortgageView f1735b;

        C02116(MortgageView mortgageView, Calendar calendar) {
            this.f1735b = mortgageView;
            this.f1734a = calendar;
        }

        public void m3085a(DatePicker datePicker, int i, int i2, int i3) {
            this.f1734a.m3383a(1, i);
            this.f1734a.m3383a(5, i2);
            this.f1734a.m3383a(9, i3);
            this.f1735b.m3088a(this.f1734a.m3382a());
        }
    }

    public MortgageView(Context context) {
        this(context, null);
    }

    public MortgageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MortgageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1739d = this.f1738c;
        this.f1741f = 30;
        this.f1752q = new C02061(this);
        this.f1751p = InterestRateGetter.m3037a(context);
        this.f1751p.m3041a();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.mortgage_view, this, true);
        this.f1744i = (MortgageInputView) inflate.findViewById(C0264R.id.miv_total_1);
        this.f1745j = (MortgageInputView) inflate.findViewById(C0264R.id.miv_total_2);
        this.f1746k = (MortgageInputView) inflate.findViewById(C0264R.id.miv_rate_1);
        this.f1747l = (MortgageInputView) inflate.findViewById(C0264R.id.miv_rate_2);
        this.f1748m = (OptionItemView) inflate.findViewById(C0264R.id.miv_repayment);
        this.f1749n = (OptionItemView) inflate.findViewById(C0264R.id.miv_mortgage_years);
        this.f1750o = (OptionItemView) inflate.findViewById(C0264R.id.miv_start_time);
        this.f1748m.setTitle((int) C0264R.string.mortgage_item_repayment);
        this.f1749n.setTitle((int) C0264R.string.mortgage_item_years);
        this.f1750o.setTitle((int) C0264R.string.mortgage_item_start_time);
        inflate.findViewById(C0264R.id.rate_data_provider).setVisibility(CalculatorUtils.m2821b() ? 8 : 0);
        this.f1748m.setOnClickListener(this.f1752q);
        this.f1749n.setOnClickListener(this.f1752q);
        this.f1750o.setOnClickListener(this.f1752q);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1737b != null) {
            this.f1737b.m3043a(this);
        }
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.f1737b = onSizeChangeListener;
    }

    public void setMortgageType(int i) {
        this.f1736a = i;
        switch (this.f1736a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f1744i.m3077a(1, 0);
                this.f1745j.setVisibility(8);
                if (this.f1736a == 1) {
                    this.f1746k.m3077a(4, 1);
                } else {
                    this.f1746k.m3077a(4, 2);
                }
                this.f1747l.setVisibility(8);
                this.f1746k.setText2(String.valueOf(1));
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f1744i.m3077a(3, 1);
                this.f1745j.m3077a(3, 2);
                this.f1746k.m3077a(4, 1);
                this.f1747l.m3077a(5, 2);
                this.f1744i.setVisibility(0);
                this.f1745j.setVisibility(0);
                this.f1746k.setVisibility(0);
                this.f1747l.setVisibility(0);
                this.f1746k.setText2(String.valueOf(1));
                this.f1747l.setText2(String.valueOf(1));
                break;
        }
        m3087a(0);
        m3092b(30);
        m3088a(new Calendar().m3382a());
    }

    private void m3091b() {
        if (this.f1743h != null) {
            this.f1743h.dismiss();
        }
        Builder builder = new Builder(getContext());
        builder.m3261a((int) C0264R.array.mortgage_repayment, this.f1738c, new C02072(this));
        builder.m3260a((int) C0264R.string.mortgage_item_repayment);
        builder.m3262a(17039370, new C02083(this));
        builder.m3270b(17039360, null);
        this.f1743h = builder.m3272b();
    }

    private void m3096c() {
        if (this.f1743h != null) {
            this.f1743h.cancel();
        }
        Builder builder = new Builder(getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(C0264R.layout.mortgage_year_picker_dialog, null);
        NumberPicker numberPicker = (NumberPicker) inflate.findViewById(C0264R.id.nbp_year);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(30);
        numberPicker.setValue(this.f1740e);
        numberPicker.setOnValueChangedListener(new C02094(this));
        builder.m3265a(inflate).m3270b(17039360, null).m3262a(17039370, new C02105(this)).m3266a(getResources().getString(C0264R.string.mortgage_item_years));
        this.f1743h = builder.m3268a();
        this.f1743h.show();
    }

    private void m3100d() {
        if (this.f1743h != null) {
            this.f1743h.dismiss();
        }
        Calendar calendar = new Calendar();
        calendar.m3385a(this.f1742g);
        this.f1743h = new DatePickerDialog(getContext(), new C02116(this, calendar), calendar.m3380a(1), calendar.m3380a(5), calendar.m3380a(10));
        this.f1743h.setTitle(C0264R.string.mortgage_item_start_time);
        this.f1743h.show();
    }

    public boolean m3103a() {
        if (TextUtils.isEmpty(this.f1744i.getText1())) {
            this.f1744i.m3076a((int) C0264R.string.mortgage_input_error);
            return false;
        } else if (this.f1736a != 3 || !TextUtils.isEmpty(this.f1745j.getText1())) {
            return true;
        } else {
            this.f1745j.m3076a((int) C0264R.string.mortgage_input_error);
            return false;
        }
    }

    public double getTotalLoans() {
        String text1 = this.f1744i.getText1();
        if (TextUtils.isEmpty(text1)) {
            return 0.0d;
        }
        return ((double) (CalculatorUtils.m2821b() ? 1 : 10000)) * CalculatorUtils.m2813a(text1);
    }

    public double getTotalLoansCombined() {
        String text1 = this.f1745j.getText1();
        if (TextUtils.isEmpty(text1)) {
            return 0.0d;
        }
        return ((double) (CalculatorUtils.m2821b() ? 1 : 10000)) * CalculatorUtils.m2813a(text1);
    }

    public int getRepaymentType() {
        return this.f1738c;
    }

    public int getMortgageyears() {
        return this.f1740e;
    }

    public long getStartTime() {
        return this.f1742g;
    }

    public double getInterestRate() {
        return this.f1746k.getInterestRateReulst();
    }

    public double getInterestRateCombined() {
        return this.f1747l.getInterestRateReulst();
    }

    private void m3087a(int i) {
        this.f1738c = i;
        this.f1748m.setSummary(getResources().getStringArray(C0264R.array.mortgage_repayment)[this.f1738c]);
    }

    private void m3092b(int i) {
        this.f1740e = i;
        int i2 = this.f1740e * 12;
        this.f1749n.setSummary(getResources().getQuantityString(C0264R.plurals.mortgage_summary_years, this.f1740e, new Object[]{Integer.valueOf(this.f1740e), Integer.valueOf(i2)}));
        if (!CalculatorUtils.m2821b()) {
            MortgageRate a = this.f1751p.m3040a(i2);
            if (this.f1736a == 1) {
                this.f1746k.setText1(NumberFormatUtils.m2885d(a.f1647a * 100.0d, 2));
            } else if (this.f1736a == 2) {
                this.f1746k.setText1(NumberFormatUtils.m2885d(a.f1648b * 100.0d, 2));
            } else {
                this.f1746k.setText1(NumberFormatUtils.m2885d(a.f1647a * 100.0d, 2));
                this.f1747l.setText1(NumberFormatUtils.m2885d(a.f1648b * 100.0d, 2));
            }
        }
    }

    private void m3088a(long j) {
        this.f1742g = j;
        this.f1750o.setSummary(DateUtils.m3428a(this.f1742g, 4992));
    }
}
