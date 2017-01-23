package com.facebook.ads.internal;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C2510r;

/* renamed from: com.facebook.ads.internal.b */
public class C2343b {
    private final AdErrorType f8158a;
    private final String f8159b;

    public C2343b(AdErrorType adErrorType, String str) {
        if (C2510r.m9516a(str)) {
            str = adErrorType.getDefaultErrorMessage();
        }
        this.f8158a = adErrorType;
        this.f8159b = str;
    }

    public AdErrorType m9035a() {
        return this.f8158a;
    }

    public AdError m9036b() {
        return this.f8158a.m8646a() ? new AdError(this.f8158a.getErrorCode(), this.f8159b) : new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}
