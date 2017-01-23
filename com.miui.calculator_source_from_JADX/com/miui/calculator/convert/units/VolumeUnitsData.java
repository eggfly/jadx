package com.miui.calculator.convert.units;

import android.content.Context;
import com.miui.calculator.common.utils.AssetReader;

public class VolumeUnitsData extends UnitsDataBase {
    public VolumeUnitsData(Context context) {
        super(context, 4);
    }

    public void m3030a() {
        m2999i(AssetReader.m2800a(this.b, "default_data/units_volume"));
    }

    protected String m3031b() {
        return "volume_";
    }
}
