package anetwork.channel.aidl.p021a;

import anetwork.channel.C0766b;
import anetwork.channel.aidl.C0751d.C0752a;

/* renamed from: anetwork.channel.aidl.a.a */
public class C0753a extends C0752a {
    private C0766b f2473a;

    public int m2999a(byte[] bArr) {
        return this.f2473a != null ? this.f2473a.m3035a(bArr) : 0;
    }

    public boolean m3000a() {
        return this.f2473a != null ? this.f2473a.m3036a() : true;
    }

    public String toString() {
        return super.toString() + " handle:" + this.f2473a;
    }
}
