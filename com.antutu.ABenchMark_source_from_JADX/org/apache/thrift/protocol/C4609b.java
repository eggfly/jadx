package org.apache.thrift.protocol;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: org.apache.thrift.protocol.b */
public class C4609b {
    public final String f16475a;
    public final byte f16476b;
    public final short f16477c;

    public C4609b() {
        this(BuildConfig.FLAVOR, (byte) 0, (short) 0);
    }

    public C4609b(String str, byte b, short s) {
        this.f16475a = str;
        this.f16476b = b;
        this.f16477c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f16475a + "' type:" + this.f16476b + " field-id:" + this.f16477c + ">";
    }
}
