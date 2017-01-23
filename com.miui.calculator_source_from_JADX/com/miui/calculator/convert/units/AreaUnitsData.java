package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class AreaUnitsData extends UnitsDataBase {
    public AreaUnitsData(Context context) {
        super(context, 3);
    }

    public void m3000a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_square"));
    }

    protected String m3001b() {
        return "area_";
    }
}
