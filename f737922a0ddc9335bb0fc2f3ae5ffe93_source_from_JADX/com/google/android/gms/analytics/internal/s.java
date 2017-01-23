package com.google.android.gms.analytics.internal;

import afq;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.p;
import com.google.android.gms.common.internal.b;

public class s {
    private final v j6;

    protected s(v vVar) {
        b.j6((Object) vVar);
        this.j6 = vVar;
    }

    protected static String FH(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object j6 = j6(obj);
        Object j62 = j6(obj2);
        Object j63 = j6(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(j6)) {
            stringBuilder.append(str2);
            stringBuilder.append(j6);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(j62)) {
            stringBuilder.append(str2);
            stringBuilder.append(j62);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(j63)) {
            stringBuilder.append(str2);
            stringBuilder.append(j63);
            str2 = ", ";
        }
        return stringBuilder.toString();
    }

    private static String j6(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        } else {
            return obj == Boolean.TRUE ? "true" : "false";
        }
    }

    private void j6(int i, String str, Object obj, Object obj2, Object obj3) {
        g gVar = null;
        if (this.j6 != null) {
            gVar = this.j6.VH();
        }
        if (gVar != null) {
            gVar.j6(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) an.FH.j6();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, FH(str, obj, obj2, obj3));
        }
    }

    public boolean BT() {
        return Log.isLoggable((String) an.FH.j6(), 2);
    }

    public void DW(String str) {
        j6(2, str, null, null, null);
    }

    public void DW(String str, Object obj) {
        j6(3, str, obj, null, null);
    }

    public void DW(String str, Object obj, Object obj2) {
        j6(3, str, obj, obj2, null);
    }

    public void DW(String str, Object obj, Object obj2, Object obj3) {
        j6(5, str, obj, obj2, obj3);
    }

    public v EQ() {
        return this.j6;
    }

    public void FH(String str) {
        j6(3, str, null, null, null);
    }

    public void FH(String str, Object obj) {
        j6(4, str, obj, null, null);
    }

    public void FH(String str, Object obj, Object obj2) {
        j6(5, str, obj, obj2, null);
    }

    public void Hw(String str) {
        j6(4, str, null, null, null);
    }

    public void Hw(String str, Object obj) {
        j6(5, str, obj, null, null);
    }

    public void Hw(String str, Object obj, Object obj2) {
        j6(6, str, obj, obj2, null);
    }

    protected void J0() {
        this.j6.j3();
    }

    protected afq J8() {
        return this.j6.Hw();
    }

    protected r Mr() {
        return this.j6.u7();
    }

    protected g QX() {
        return this.j6.Zo();
    }

    protected ak U2() {
        return this.j6.tp();
    }

    protected Context Ws() {
        return this.j6.DW();
    }

    protected ag XL() {
        return this.j6.v5();
    }

    public void Zo(String str) {
        j6(6, str, null, null, null);
    }

    protected q a8() {
        return this.j6.we();
    }

    protected p aM() {
        return this.j6.gn();
    }

    protected a er() {
        return this.j6.Ws();
    }

    protected aj gW() {
        return this.j6.aM();
    }

    public c j3() {
        return this.j6.EQ();
    }

    public void j6(String str, Object obj) {
        j6(2, str, obj, null, null);
    }

    public void j6(String str, Object obj, Object obj2) {
        j6(2, str, obj, obj2, null);
    }

    public void j6(String str, Object obj, Object obj2, Object obj3) {
        j6(3, str, obj, obj2, obj3);
    }

    protected j lg() {
        return this.j6.J0();
    }

    protected ac rN() {
        return this.j6.QX();
    }

    public void v5(String str) {
        j6(5, str, null, null, null);
    }

    public void v5(String str, Object obj) {
        j6(6, str, obj, null, null);
    }

    protected void we() {
        if (XL().j6()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    protected z yS() {
        return this.j6.XL();
    }
}
