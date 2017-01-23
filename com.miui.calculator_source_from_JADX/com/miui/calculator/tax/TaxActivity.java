package com.miui.calculator.tax;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.calculator.common.utils.LocationGetter;
import com.miui.calculator.common.utils.LocationGetter.LocatedCallback;
import com.miui.calculator.tax.TaxRateGetter.CityTaxData;
import com.miui.calculator.tax.TaxRateGetter.TaxRateUpdateListener;
import com.miui.calculator.tax.TaxView.OnItemClickListener;
import com.miui.calculator.tax.TaxView.OnSizeChangeListener;
import com.miui.support.app.AlertDialog.Builder;
import com.miui.support.date.Calendar;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class TaxActivity extends BaseActivity implements OnRequestPermissionsResultCallback {
    private TaxView f1811a;
    private TextView f1812b;
    private TextView f1813c;
    private Button f1814d;
    private TextView f1815e;
    private TextView f1816f;
    private View f1817g;
    private int f1818h;
    private int f1819i;
    private Dialog f1820j;
    private LocationGetter f1821k;
    private TaxRateGetter f1822l;
    private String f1823m;
    private OnClickListener f1824n;
    private OnItemClickListener f1825o;
    private LocatedCallback f1826p;
    private TaxRateUpdateListener f1827q;

    /* renamed from: com.miui.calculator.tax.TaxActivity.1 */
    class C02171 extends Thread {
        final /* synthetic */ TaxActivity f1802a;

        /* renamed from: com.miui.calculator.tax.TaxActivity.1.1 */
        class C02161 implements Runnable {
            final /* synthetic */ C02171 f1801a;

            C02161(C02171 c02171) {
                this.f1801a = c02171;
            }

            public void run() {
                this.f1801a.f1802a.m3183g();
            }
        }

        C02171(TaxActivity taxActivity) {
            this.f1802a = taxActivity;
        }

        public void run() {
            this.f1802a.f1822l.m3222d();
            this.f1802a.runOnUiThread(new C02161(this));
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.2 */
    class C02182 implements OnSizeChangeListener {
        final /* synthetic */ TaxActivity f1803a;

        C02182(TaxActivity taxActivity) {
            this.f1803a = taxActivity;
        }

        public void m3162a(TaxView taxView) {
            if (this.f1803a.f1811a.getChildAt(0).getHeight() > this.f1803a.f1811a.getHeight()) {
                this.f1803a.f1817g.setVisibility(0);
                this.f1803a.f1816f.setVisibility(0);
            } else {
                this.f1803a.f1817g.setVisibility(4);
                this.f1803a.f1815e.setVisibility(0);
                this.f1803a.f1816f.setVisibility(4);
            }
            if (this.f1803a.f1818h == 2) {
                this.f1803a.f1815e.setVisibility(4);
                this.f1803a.f1816f.setVisibility(4);
            }
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.3 */
    class C02193 implements DialogInterface.OnClickListener {
        final /* synthetic */ TaxActivity f1804a;

        C02193(TaxActivity taxActivity) {
            this.f1804a = taxActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1804a.f1819i = i == 0 ? 0 : 1;
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.4 */
    class C02204 implements DialogInterface.OnClickListener {
        final /* synthetic */ TaxActivity f1805a;

        C02204(TaxActivity taxActivity) {
            this.f1805a = taxActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1805a.m3170a(this.f1805a.f1819i);
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.5 */
    class C02215 implements DialogInterface.OnClickListener {
        final /* synthetic */ TaxActivity f1806a;

        C02215(TaxActivity taxActivity) {
            this.f1806a = taxActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            DefaultPreferenceHelper.m2833a(this.f1806a, true);
            this.f1806a.m3177c();
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.6 */
    class C02226 implements OnClickListener {
        final /* synthetic */ TaxActivity f1807a;

        C02226(TaxActivity taxActivity) {
            this.f1807a = taxActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case C0264R.id.btn_calculate /*2131689582*/:
                    this.f1807a.m3185h();
                case C0264R.id.txv_tab_salary /*2131689739*/:
                    this.f1807a.m3170a(0);
                case C0264R.id.txv_tab_bonus /*2131689740*/:
                    this.f1807a.m3170a(2);
                default:
            }
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.7 */
    class C02237 implements OnItemClickListener {
        final /* synthetic */ TaxActivity f1808a;

        C02237(TaxActivity taxActivity) {
            this.f1808a = taxActivity;
        }

        public void m3164a(int i) {
            switch (i) {
                case C0264R.id.oiv_city /*2131689762*/:
                    this.f1808a.startActivityForResult(new Intent(this.f1808a, CityPickerActivity.class), 1);
                case C0264R.id.oiv_threshold /*2131689763*/:
                    this.f1808a.m3188j();
                default:
            }
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.8 */
    class C02248 implements LocatedCallback {
        final /* synthetic */ TaxActivity f1809a;

        C02248(TaxActivity taxActivity) {
            this.f1809a = taxActivity;
        }

        public void m3165a(boolean z, Location location, String str, String str2, String str3) {
            if (z && TextUtils.isEmpty(this.f1809a.f1822l.m3216a())) {
                CityTaxData b = this.f1809a.f1822l.m3219b(str);
                if (b == null) {
                    b = this.f1809a.f1822l.m3219b(str2);
                }
                this.f1809a.m3175b(b == null ? this.f1809a.f1822l.m3220b() : b.f1842a);
            }
        }
    }

    /* renamed from: com.miui.calculator.tax.TaxActivity.9 */
    class C02259 implements TaxRateUpdateListener {
        final /* synthetic */ TaxActivity f1810a;

        C02259(TaxActivity taxActivity) {
            this.f1810a = taxActivity;
        }

        public void m3167a(boolean z) {
            this.f1810a.m3175b(this.f1810a.f1823m);
            this.f1810a.m3186i();
        }
    }

    public TaxActivity() {
        this.f1818h = 0;
        this.f1824n = new C02226(this);
        this.f1825o = new C02237(this);
        this.f1826p = new C02248(this);
        this.f1827q = new C02259(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.tax_activity);
        this.f1822l = TaxRateGetter.m3208a((Context) this);
        this.f1821k = LocationGetter.m2850a((Context) this);
        new C02171(this).start();
        if (DefaultPreferenceHelper.m2835a(this)) {
            m3177c();
        } else {
            m3190k();
        }
        m3179d();
    }

    private void m3177c() {
        if (m3172a("android.permission.ACCESS_FINE_LOCATION")) {
            this.f1821k.m2861a(this.f1826p, false);
        } else {
            ActivityCompat.m80a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
        }
        this.f1822l.m3217a(this.f1827q);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f1820j != null) {
            this.f1820j.cancel();
            this.f1820j = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length > 0 && iArr[0] == 0 && i == 2) {
            this.f1821k.m2861a(this.f1826p, false);
        }
    }

    private boolean m3172a(String str) {
        return ContextCompat.m77a((Context) this, str) == 0;
    }

    private void m3179d() {
        this.f1814d = (Button) findViewById(C0264R.id.btn_calculate);
        this.f1811a = (TaxView) findViewById(C0264R.id.tax_taxview);
        this.f1812b = (TextView) findViewById(C0264R.id.txv_tab_salary);
        this.f1813c = (TextView) findViewById(C0264R.id.txv_tab_bonus);
        this.f1815e = (TextView) findViewById(C0264R.id.txv_updatetime);
        this.f1816f = (TextView) findViewById(C0264R.id.txv_updatetime_1);
        this.f1817g = findViewById(C0264R.id.div_divider);
        this.f1812b.setOnClickListener(this.f1824n);
        this.f1813c.setOnClickListener(this.f1824n);
        this.f1811a.setOnItemClickListener(this.f1825o);
        this.f1814d.setOnClickListener(this.f1824n);
        this.f1811a.setOnSizeChangeListener(new C02182(this));
        m3183g();
    }

    private void m3183g() {
        m3175b(this.f1822l.m3220b());
        m3170a(this.f1818h);
        m3186i();
    }

    private void m3170a(int i) {
        this.f1818h = i;
        this.f1813c.setSelected(false);
        this.f1812b.setSelected(false);
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                this.f1812b.setSelected(true);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f1813c.setSelected(true);
                break;
        }
        this.f1811a.setTaxType(i);
    }

    private void m3185h() {
        if (this.f1811a.m3239a(true)) {
            int income = this.f1811a.getIncome();
            int lastSalary = this.f1811a.getLastSalary();
            Intent intent = new Intent(this, TaxResultActivity.class);
            Parcelable params = this.f1811a.getParams();
            intent.putExtra("extra_income", income);
            intent.putExtra("extra_income_type", this.f1818h);
            intent.putExtra("extra_last_salary", lastSalary);
            intent.putExtra("extra_city_tax_data", params);
            startActivity(intent);
        }
    }

    private void m3175b(String str) {
        this.f1823m = str;
        CityTaxData b = this.f1822l.m3219b(str);
        if (b == null) {
            b = this.f1822l.m3215a(0);
        }
        if (b != null && this.f1811a != null) {
            this.f1811a.m3237a(b);
            this.f1823m = b.f1842a;
        }
    }

    private void m3186i() {
        new Calendar().m3385a(this.f1822l.m3223e());
        CharSequence string = getString(C0264R.string.tax_update_time_format, new Object[]{String.valueOf(r0.m3380a(1))});
        this.f1815e.setText(string);
        this.f1816f.setText(string);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    String stringExtra = intent.getStringExtra("result_city");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        m3175b(stringExtra);
                        this.f1822l.m3218a(stringExtra);
                    }
                default:
            }
        }
    }

    private void m3188j() {
        if (this.f1820j != null) {
            this.f1820j.cancel();
        }
        Builder builder = new Builder(this);
        int i = this.f1818h == 0 ? 0 : 1;
        CharSequence[] charSequenceArr = new String[2];
        charSequenceArr[0] = getResources().getString(C0264R.string.tax_thershold_native, new Object[]{String.valueOf(TaxCalculator.f1838a)});
        charSequenceArr[1] = getResources().getString(C0264R.string.tax_thershold_foreign, new Object[]{String.valueOf(TaxCalculator.f1839b)});
        builder.m3267a(charSequenceArr, i, new C02193(this));
        builder.m3260a((int) C0264R.string.tax_threshold);
        builder.m3262a(17039370, new C02204(this));
        builder.m3270b(17039360, null);
        this.f1820j = builder.m3272b();
    }

    private void m3190k() {
        if (this.f1820j != null) {
            this.f1820j.cancel();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(C0264R.string.network_confirm_title);
        builder.setMessage(C0264R.string.network_confirm_content);
        builder.setPositiveButton(17039370, new C02215(this));
        builder.setNegativeButton(17039360, null);
        this.f1820j = builder.show();
    }
}
