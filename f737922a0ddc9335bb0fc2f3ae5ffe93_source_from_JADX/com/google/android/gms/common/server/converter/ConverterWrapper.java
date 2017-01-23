package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.a;

public class ConverterWrapper extends AbstractSafeParcelable {
    public static final a CREATOR;
    private final StringToIntConverter DW;
    private final int j6;

    static {
        CREATOR = new a();
    }

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.j6 = i;
        this.DW = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.j6 = 1;
        this.DW = stringToIntConverter;
    }

    public static ConverterWrapper j6(a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    StringToIntConverter DW() {
        return this.DW;
    }

    public a<?, ?> FH() {
        if (this.DW != null) {
            return this.DW;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    int j6() {
        return this.j6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a aVar = CREATOR;
        a.j6(this, parcel, i);
    }
}
