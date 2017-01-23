package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class LengthUnitsData extends UnitsDataBase {
    public LengthUnitsData(Context context) {
        super(context, 2);
    }

    public void m3020a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_length"));
    }

    protected String m3021b() {
        return "length_";
    }
}
