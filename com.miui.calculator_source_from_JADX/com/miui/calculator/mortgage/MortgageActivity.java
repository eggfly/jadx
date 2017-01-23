package com.miui.calculator.mortgage;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.calculator.mortgage.MortgageView.OnSizeChangeListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class MortgageActivity extends BaseActivity {
    private MortgageView f1659a;
    private Button f1660b;
    private View f1661c;
    private TextView f1662d;
    private TextView f1663e;
    private TextView f1664f;
    private Dialog f1665g;
    private int f1666h;
    private InterestRateGetter f1667i;
    private OnClickListener f1668j;

    /* renamed from: com.miui.calculator.mortgage.MortgageActivity.1 */
    class C01961 implements OnSizeChangeListener {
        final /* synthetic */ MortgageActivity f1656a;

        C01961(MortgageActivity mortgageActivity) {
            this.f1656a = mortgageActivity;
        }

        public void m3044a(MortgageView mortgageView) {
            if (this.f1656a.f1659a.getChildAt(0).getHeight() > this.f1656a.f1659a.getHeight()) {
                this.f1656a.f1661c.setVisibility(0);
            } else {
                this.f1656a.f1661c.setVisibility(8);
            }
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageActivity.2 */
    class C01972 implements DialogInterface.OnClickListener {
        final /* synthetic */ MortgageActivity f1657a;

        C01972(MortgageActivity mortgageActivity) {
            this.f1657a = mortgageActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            DefaultPreferenceHelper.m2833a(this.f1657a, true);
            this.f1657a.f1667i.m3042b();
        }
    }

    /* renamed from: com.miui.calculator.mortgage.MortgageActivity.3 */
    class C01983 implements OnClickListener {
        final /* synthetic */ MortgageActivity f1658a;

        C01983(MortgageActivity mortgageActivity) {
            this.f1658a = mortgageActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0264R.id.txv_commercial_loan /*2131689577*/:
                    this.f1658a.m3046a(1);
                case C0264R.id.txv_accumulation_fund /*2131689578*/:
                    this.f1658a.m3046a(2);
                case C0264R.id.txv_combining_loan /*2131689579*/:
                    this.f1658a.m3046a(3);
                case C0264R.id.btn_calculate /*2131689582*/:
                    this.f1658a.m3053g();
                default:
            }
        }
    }

    public MortgageActivity() {
        this.f1668j = new C01983(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1667i = InterestRateGetter.m3037a((Context) this);
        if (DefaultPreferenceHelper.m2835a(this)) {
            this.f1667i.m3042b();
        } else {
            m3051d();
        }
        setContentView(C0264R.layout.mortgage_activity);
        m3050c();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f1665g != null) {
            this.f1665g.cancel();
            this.f1665g = null;
        }
    }

    private void m3050c() {
        this.f1659a = (MortgageView) findViewById(C0264R.id.mgv_mortgage);
        this.f1661c = findViewById(C0264R.id.viw_divider);
        this.f1662d = (TextView) findViewById(C0264R.id.txv_commercial_loan);
        this.f1663e = (TextView) findViewById(C0264R.id.txv_accumulation_fund);
        this.f1664f = (TextView) findViewById(C0264R.id.txv_combining_loan);
        this.f1660b = (Button) findViewById(C0264R.id.btn_calculate);
        findViewById(C0264R.id.mortgage_tab).setVisibility(CalculatorUtils.m2821b() ? 8 : 0);
        this.f1662d.setOnClickListener(this.f1668j);
        this.f1663e.setOnClickListener(this.f1668j);
        this.f1664f.setOnClickListener(this.f1668j);
        this.f1660b.setOnClickListener(this.f1668j);
        this.f1659a.setOnSizeChangeListener(new C01961(this));
        m3046a(1);
    }

    private void m3051d() {
        if (this.f1665g != null) {
            this.f1665g.cancel();
        }
        Builder builder = new Builder(this);
        builder.setTitle(C0264R.string.network_confirm_title);
        builder.setMessage(C0264R.string.network_confirm_content);
        builder.setPositiveButton(17039370, new C01972(this));
        builder.setNegativeButton(17039360, null);
        this.f1665g = builder.show();
    }

    private void m3046a(int i) {
        if (this.f1666h != i) {
            this.f1659a.setMortgageType(i);
            this.f1666h = i;
            this.f1662d.setSelected(false);
            this.f1663e.setSelected(false);
            this.f1664f.setSelected(false);
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    this.f1662d.setSelected(true);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f1663e.setSelected(true);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    this.f1664f.setSelected(true);
                default:
            }
        }
    }

    private void m3053g() {
        if (this.f1659a.m3103a()) {
            double totalLoans = this.f1659a.getTotalLoans();
            double totalLoansCombined = this.f1659a.getTotalLoansCombined();
            int repaymentType = this.f1659a.getRepaymentType();
            int mortgageyears = this.f1659a.getMortgageyears();
            long startTime = this.f1659a.getStartTime();
            double interestRate = this.f1659a.getInterestRate();
            double interestRateCombined = this.f1659a.getInterestRateCombined();
            StatisticUtils.m2887a(this.f1666h, repaymentType, totalLoans, totalLoansCombined, mortgageyears, startTime, interestRate, interestRateCombined);
            Intent intent = new Intent(this, MortgageResultActivity.class);
            intent.putExtra("extra_mortgage_type", this.f1666h);
            intent.putExtra("extra_repayment_type", repaymentType);
            intent.putExtra("extra_loans1", totalLoans);
            intent.putExtra("extra_loans2", totalLoansCombined);
            intent.putExtra("extra_mortgage_years", mortgageyears);
            intent.putExtra("extra_start_time", startTime);
            intent.putExtra("extra_rate1", interestRate);
            intent.putExtra("extra_rate2", interestRateCombined);
            startActivity(intent);
        }
    }
}
