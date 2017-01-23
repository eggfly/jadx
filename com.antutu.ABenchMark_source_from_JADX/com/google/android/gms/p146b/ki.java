package com.google.android.gms.p146b;

import java.lang.reflect.Array;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.ki */
public class ki<M extends kh<M>, T> {
    protected final int f11615a;
    protected final Class<T> f11616b;
    public final int f11617c;
    protected final boolean f11618d;

    int m13673a(Object obj) {
        return this.f11618d ? m13675b(obj) : m13677c(obj);
    }

    void m13674a(Object obj, kg kgVar) {
        if (this.f11618d) {
            m13678c(obj, kgVar);
        } else {
            m13676b(obj, kgVar);
        }
    }

    protected int m13675b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m13677c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m13676b(Object obj, kg kgVar) {
        try {
            kgVar.m13668e(this.f11617c);
            switch (this.f11615a) {
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    km kmVar = (km) obj;
                    int a = kp.m13709a(this.f11617c);
                    kgVar.m13656a(kmVar);
                    kgVar.m13666c(a, 4);
                    return;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    kgVar.m13662b((km) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f11615a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m13677c(Object obj) {
        int a = kp.m13709a(this.f11617c);
        switch (this.f11615a) {
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return kg.m13627b(a, (km) obj);
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return kg.m13635c(a, (km) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f11615a);
        }
    }

    protected void m13678c(Object obj, kg kgVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m13676b(obj2, kgVar);
            }
        }
    }
}
