package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class TemperatureUnitsData extends UnitsDataBase {
    public TemperatureUnitsData(Context context) {
        super(context, 5);
    }

    public void m3022a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_temperature"));
    }

    protected String m3023b() {
        return "temperature_";
    }
}
