package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.C3516a;

public class ConverterWrapper implements SafeParcelable {
    public static final C3517a CREATOR;
    private final int f12122a;
    private final StringToIntConverter f12123b;

    static {
        CREATOR = new C3517a();
    }

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.f12122a = i;
        this.f12123b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.f12122a = 1;
        this.f12123b = stringToIntConverter;
    }

    public static ConverterWrapper m14600a(C3516a<?, ?> c3516a) {
        if (c3516a instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) c3516a);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    int m14601a() {
        return this.f12122a;
    }

    StringToIntConverter m14602b() {
        return this.f12123b;
    }

    public C3516a<?, ?> m14603c() {
        if (this.f12123b != null) {
            return this.f12123b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public int describeContents() {
        C3517a c3517a = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3517a c3517a = CREATOR;
        C3517a.m14611a(this, parcel, i);
    }
}
