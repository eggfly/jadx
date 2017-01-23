package com.miui.calculator.tax;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class TaxCalMethodActivity extends Activity {
    private int f1828a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.tax_cal_method_activity);
        this.f1828a = getIntent().getIntExtra("extra_type", 2);
        m3194a();
    }

    private void m3194a() {
        switch (this.f1828a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                setTitle(C0264R.string.tax_cal_method_fixed_salary);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                setTitle(C0264R.string.tax_cal_method_annual);
            default:
        }
    }

    public static void m3195a(Context context, int i) {
        Intent intent = new Intent(context, TaxCalMethodActivity.class);
        intent.putExtra("extra_type", i);
        context.startActivity(intent);
    }
}
