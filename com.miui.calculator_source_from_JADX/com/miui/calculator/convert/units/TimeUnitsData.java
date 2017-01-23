package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class TimeUnitsData extends UnitsDataBase {
    public TimeUnitsData(Context context) {
        super(context, 5);
    }

    public void m3024a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_time"));
    }

    protected String m3025b() {
        return "time_";
    }
}
