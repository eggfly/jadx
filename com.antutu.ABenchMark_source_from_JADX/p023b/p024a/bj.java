package p023b.p024a;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: b.a.bj */
public class bj {
    public final String f2781a;
    public final byte f2782b;
    public final short f2783c;

    public bj() {
        this(BuildConfig.FLAVOR, (byte) 0, (short) 0);
    }

    public bj(String str, byte b, short s) {
        this.f2781a = str;
        this.f2782b = b;
        this.f2783c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f2781a + "' type:" + this.f2782b + " field-id:" + this.f2783c + ">";
    }
}
