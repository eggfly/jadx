package com.google.android.gms.internal;

import com.google.android.gms.internal.gh.a;
import com.google.android.gms.internal.gh.b;
import java.io.UnsupportedEncodingException;

public class c extends es<String> {
    private final b<String> j6;

    public c(int i, String str, b<String> bVar, a aVar) {
        super(i, str, aVar);
        this.j6 = bVar;
    }

    protected gh<String> j6(ef efVar) {
        Object str;
        try {
            str = new String(efVar.DW, ic.j6(efVar.FH));
        } catch (UnsupportedEncodingException e) {
            str = new String(efVar.DW);
        }
        return gh.j6(str, ic.j6(efVar));
    }

    protected /* synthetic */ void j6(Object obj) {
        j6((String) obj);
    }

    protected void j6(String str) {
        this.j6.j6(str);
    }
}
