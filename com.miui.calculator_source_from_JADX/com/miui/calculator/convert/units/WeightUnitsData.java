package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class WeightUnitsData extends UnitsDataBase {
    public WeightUnitsData(Context context) {
        super(context, 6);
    }

    public void m3032a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_weight"));
    }

    protected String m3033b() {
        return "weight_";
    }
}
