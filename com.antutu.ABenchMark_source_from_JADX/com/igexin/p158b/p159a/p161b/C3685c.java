package com.igexin.p158b.p159a.p161b;

import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p165d.C3684e;
import com.igexin.p158b.p159a.p165d.p166a.C3689b;
import com.igexin.p158b.p159a.p165d.p166a.C3691d;
import com.igexin.p158b.p159a.p165d.p166a.C3693g;
import com.igexin.p158b.p168b.C3700a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.b.a.b.c */
public class C3685c extends C3684e {
    static C3685c f12429a;
    public volatile long f12430b;
    public volatile long f12431c;
    public volatile long f12432d;
    public volatile long f12433e;
    C3689b f12434f;
    private byte[] f12435v;
    private byte[] f12436w;

    public static C3685c m15060b() {
        if (f12429a == null) {
            f12429a = new C3685c();
        }
        return f12429a;
    }

    public static void m15061d() {
        f12429a.f12430b = 0;
        f12429a.f12432d = 0;
        f12429a.f12431c = 0;
        f12429a.f12433e = 0;
    }

    public C3667e m15062a(String str, int i, C3683b c3683b, Object obj, boolean z) {
        return m15063a(str, i, c3683b, obj, z, -1, -1, (byte) 0, null, null);
    }

    public C3667e m15063a(String str, int i, C3683b c3683b, Object obj, boolean z, int i2, long j, byte b, Object obj2, C3691d c3691d) {
        return m15064a(str, i, c3683b, obj, z, i2, j, b, obj2, c3691d, 0, null);
    }

    public C3667e m15064a(String str, int i, C3683b c3683b, Object obj, boolean z, int i2, long j, byte b, Object obj2, C3691d c3691d, int i3, C3693g c3693g) {
        if (this.f12434f == null) {
            return null;
        }
        C3667e c3667e = (C3667e) this.f12434f.m15099a(str, Integer.valueOf(i), c3683b);
        if (c3667e == null || c3667e.m14968r()) {
            return null;
        }
        if (c3693g != null) {
            c3667e.m14957a(i3, c3693g);
        }
        m15068a(c3667e, obj, z, i2, j, b, obj2, c3691d);
        return c3667e;
    }

    public C3667e m15065a(String str, int i, C3683b c3683b, Object obj, boolean z, int i2, C3693g c3693g) {
        return m15064a(str, i, c3683b, obj, z, -1, -1, (byte) 0, null, null, i2, c3693g);
    }

    public void m15066a(C3689b c3689b) {
        this.f12434f = c3689b;
    }

    public void m15067a(byte[] bArr) {
        this.f12435v = bArr;
        this.f12436w = C3700a.m15134a(bArr);
        if (this.f12436w == null) {
        }
    }

    boolean m15068a(C3667e c3667e, Object obj, boolean z, int i, long j, byte b, Object obj2, C3691d c3691d) {
        c3667e.f12356c = obj;
        c3667e.m14954a(j, TimeUnit.MILLISECONDS);
        c3667e.x = i;
        c3667e.m14956a((int) b);
        c3667e.C = obj2;
        c3667e.m14958a(c3691d);
        return m15052a((C3666d) c3667e, z);
    }

    public byte[] m15069a() {
        return this.f12436w;
    }

    public final void m15070c() {
        m15058f();
    }
}
