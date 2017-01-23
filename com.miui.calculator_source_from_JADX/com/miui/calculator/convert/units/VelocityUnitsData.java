package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class VelocityUnitsData extends UnitsDataBase {
    public VelocityUnitsData(Context context) {
        super(context, 6);
    }

    public void m3028a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_velocity"));
    }

    protected String m3029b() {
        return "velocity_";
    }
}
