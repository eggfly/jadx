package com.google.android.gms.p146b;

import com.google.android.gms.p146b.jb.C3268a;
import com.google.android.gms.p146b.jb.C3273b;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.android.gms.b.c */
public class C3057c extends it<String> {
    private final C3273b<String> f10399a;

    public C3057c(int i, String str, C3273b<String> c3273b, C3268a c3268a) {
        super(i, str, c3268a);
        this.f10399a = c3273b;
    }

    public C3057c(String str, C3273b<String> c3273b, C3268a c3268a) {
        this(0, str, c3273b, c3268a);
    }

    protected jb<String> m12010a(gs gsVar) {
        Object str;
        try {
            str = new String(gsVar.f11162b, kv.m13771a(gsVar.f11163c));
        } catch (UnsupportedEncodingException e) {
            str = new String(gsVar.f11162b);
        }
        return jb.m13529a(str, kv.m13770a(gsVar));
    }

    protected /* synthetic */ void m12011a(Object obj) {
        m12012a((String) obj);
    }

    protected void m12012a(String str) {
        this.f10399a.m13146a(str);
    }
}
