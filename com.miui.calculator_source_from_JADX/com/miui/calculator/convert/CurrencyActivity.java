package com.miui.calculator.convert;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.convert.units.CurrencyUnitsData;
import com.miui.calculator.convert.units.CurrencyUnitsData.UnitDataListener;
import com.miui.calculator.convert.units.UnitsDataBase;
import com.miui.support.internal.C0264R;

public class CurrencyActivity extends ConvertActivity {
    private CurrencyUnitsData f1605b;
    private AlertDialog f1606c;
    private TextView f1607d;
    private UnitDataListener f1608e;

    /* renamed from: com.miui.calculator.convert.CurrencyActivity.1 */
    class C01851 implements Runnable {
        final /* synthetic */ CurrencyActivity f1602a;

        C01851(CurrencyActivity currencyActivity) {
            this.f1602a = currencyActivity;
        }

        public void run() {
            this.f1602a.f1605b.m3011a(this.f1602a.f1608e);
        }
    }

    /* renamed from: com.miui.calculator.convert.CurrencyActivity.2 */
    class C01862 implements OnClickListener {
        final /* synthetic */ CurrencyActivity f1603a;

        C01862(CurrencyActivity currencyActivity) {
            this.f1603a = currencyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            DefaultPreferenceHelper.m2833a(this.f1603a, true);
            this.f1603a.f1605b.m3011a(this.f1603a.f1608e);
        }
    }

    /* renamed from: com.miui.calculator.convert.CurrencyActivity.3 */
    class C01873 implements UnitDataListener {
        final /* synthetic */ CurrencyActivity f1604a;

        C01873(CurrencyActivity currencyActivity) {
            this.f1604a = currencyActivity;
        }

        public void m2958a(boolean z) {
            this.f1604a.m2956d();
            this.f1604a.f1607d.setText(this.f1604a.getString(C0264R.string.currency_update_time_format, new Object[]{NumberFormatUtils.m2879b(this.f1604a.f1605b.m3015c())}));
        }
    }

    public CurrencyActivity() {
        this.f1608e = new C01873(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DefaultPreferenceHelper.m2835a(this)) {
            new Handler().postDelayed(new C01851(this), 1000);
        } else {
            m2962g();
        }
    }

    protected void m2964a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1 && lastIndexOf + 4 < str.length() - 1) {
            str = str.substring(0, (lastIndexOf + 4) + 1);
        }
        super.m2951a(str);
    }

    protected void m2965a(boolean z) {
        super.m2952a(z);
        this.f1607d = (TextView) findViewById(C0264R.id.txv_updatetime);
        this.f1607d.setVisibility(0);
        this.f1607d.setText(getString(C0264R.string.currency_update_time_format, new Object[]{NumberFormatUtils.m2879b(this.f1605b.m3015c())}));
    }

    protected UnitsDataBase m2966b(int i) {
        UnitsDataBase currencyUnitsData = new CurrencyUnitsData(this);
        this.f1605b = currencyUnitsData;
        return currencyUnitsData;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f1606c != null) {
            this.f1606c.cancel();
            this.f1606c = null;
        }
    }

    private void m2962g() {
        if (this.f1606c != null) {
            this.f1606c.cancel();
        }
        Builder builder = new Builder(this);
        builder.setTitle(C0264R.string.network_confirm_title);
        builder.setMessage(C0264R.string.network_confirm_content);
        builder.setPositiveButton(17039370, new C01862(this));
        builder.setNegativeButton(17039360, null);
        this.f1606c = builder.show();
    }

    protected void m2963a(int i) {
        if (this.a != i) {
            super.m2949a(i);
            m2964a("1");
        }
    }
}
