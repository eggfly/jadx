package com.miui.calculator.mortgage;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.miui.calculator.common.utils.CalculatorUtils;

public class MortgageDatas {
    public static String m3064a(Context context) {
        String string = context.getSharedPreferences("mortgage_rates", 0).getString("pref_key_mortgage_data", null);
        if (string == null) {
            return m3063a();
        }
        return string;
    }

    public static String m3063a() {
        return CalculatorUtils.m2820b("default_data/mortgage_rate");
    }

    public static void m3065a(Context context, String str) {
        Editor edit = context.getSharedPreferences("mortgage_rates", 0).edit();
        edit.putString("pref_key_mortgage_data", str);
        edit.putLong("pref_key_sync_time", System.currentTimeMillis());
        edit.commit();
    }
}
