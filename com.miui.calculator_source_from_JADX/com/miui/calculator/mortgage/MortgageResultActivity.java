package com.miui.calculator.mortgage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.common.widget.OptionItemView;
import com.miui.calculator.common.widget.ResultItemView;
import com.miui.calculator.mortgage.MortgageCalculator.MortgageResult;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;

public class MortgageResultActivity extends Activity {
    private MortgageResult f1719a;
    private long f1720b;
    private TextView f1721c;
    private TextView f1722d;
    private ResultItemView f1723e;
    private ResultItemView f1724f;
    private ResultItemView f1725g;
    private ResultItemView f1726h;
    private OptionItemView f1727i;
    private OnClickListener f1728j;

    /* renamed from: com.miui.calculator.mortgage.MortgageResultActivity.1 */
    class C02051 implements OnClickListener {
        final /* synthetic */ MortgageResultActivity f1718a;

        C02051(MortgageResultActivity mortgageResultActivity) {
            this.f1718a = mortgageResultActivity;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f1718a, MortgageDetailActivity.class);
            intent.putExtra("extra_mortgage_result", this.f1718a.f1719a);
            intent.putExtra("extra_start_time", this.f1718a.f1720b);
            this.f1718a.startActivity(intent);
        }
    }

    public MortgageResultActivity() {
        this.f1728j = new C02051(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.mortgage_result_activity);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("extra_mortgage_type", 0);
        double doubleExtra = intent.getDoubleExtra("extra_loans1", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("extra_loans2", 0.0d);
        int intExtra2 = intent.getIntExtra("extra_repayment_type", 0);
        int intExtra3 = intent.getIntExtra("extra_mortgage_years", 0);
        this.f1720b = intent.getLongExtra("extra_start_time", 0);
        this.f1719a = MortgageCalculator.m3059a(intExtra, intExtra2, doubleExtra, doubleExtra2, intExtra3, intent.getDoubleExtra("extra_rate1", 0.0d), intent.getDoubleExtra("extra_rate2", 0.0d));
        m3079a();
        m3081b();
    }

    private void m3079a() {
        this.f1721c = (TextView) findViewById(C0264R.id.txv_repayment_monthly);
        this.f1722d = (TextView) findViewById(C0264R.id.txv_repayment_monthly_tip);
        this.f1723e = (ResultItemView) findViewById(C0264R.id.riv_interest);
        this.f1724f = (ResultItemView) findViewById(C0264R.id.riv_repayment_amount);
        this.f1725g = (ResultItemView) findViewById(C0264R.id.riv_loans_amount);
        this.f1726h = (ResultItemView) findViewById(C0264R.id.riv_years_amount);
        this.f1727i = (OptionItemView) findViewById(C0264R.id.miv_details);
        this.f1723e.setTitle((int) C0264R.string.mortgage_interest_amount);
        this.f1724f.setTitle((int) C0264R.string.mortgage_repayment_amount);
        this.f1725g.setTitle((int) C0264R.string.mortgage_loans_amount);
        this.f1726h.setTitle((int) C0264R.string.mortgage_years_amount);
        this.f1727i.setTitle((int) C0264R.string.mortgage_show_details);
        this.f1727i.setOnClickListener(this.f1728j);
    }

    private void m3081b() {
        if (this.f1719a != null) {
            this.f1721c.setText(NumberFormatUtils.m2884d(this.f1719a.f1674b));
            this.f1722d.setText(this.f1719a.f1673a == 0 ? C0264R.string.mortgage_average_repayment_monthly : C0264R.string.mortgage_average_repayment_first_month);
            this.f1723e.setSummary(NumberFormatUtils.m2881c(this.f1719a.f1675c));
            this.f1724f.setSummary(NumberFormatUtils.m2881c(this.f1719a.f1676d));
            this.f1725g.setSummary(NumberFormatUtils.m2881c(this.f1719a.f1677e));
            this.f1726h.setSummary(getResources().getQuantityString(C0264R.plurals.mortgage_summary_years, r0, new Object[]{Integer.valueOf(r0), Integer.valueOf(this.f1719a.f1678f * 12)}));
        }
    }
}
