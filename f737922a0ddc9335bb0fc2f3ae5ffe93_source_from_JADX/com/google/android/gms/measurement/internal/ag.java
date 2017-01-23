package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import com.google.android.gms.internal.hs.a;
import com.google.android.gms.internal.hs.b;
import com.google.android.gms.internal.hs.c;
import com.google.android.gms.internal.m;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;
import l;

public class ag extends b {
    private final Map<String, Map<String, Boolean>> DW;
    private final Map<String, Map<String, Boolean>> FH;
    private final Map<String, b> Hw;
    private final Map<String, Map<String, String>> j6;
    private final Map<String, String> v5;

    ag(ai aiVar) {
        super(aiVar);
        this.j6 = new l();
        this.DW = new l();
        this.FH = new l();
        this.Hw = new l();
        this.v5 = new l();
    }

    private void Hw(String str) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        if (!this.Hw.containsKey(str)) {
            byte[] Hw = aM().Hw(str);
            if (Hw == null) {
                this.j6.put(str, null);
                this.DW.put(str, null);
                this.FH.put(str, null);
                this.Hw.put(str, null);
                this.v5.put(str, null);
                return;
            }
            b j6 = j6(str, Hw);
            this.j6.put(str, j6(j6));
            j6(str, j6);
            this.Hw.put(str, j6);
            this.v5.put(str, null);
        }
    }

    private b j6(String str, byte[] bArr) {
        if (bArr == null) {
            return new b();
        }
        com.google.android.gms.internal.l j6 = com.google.android.gms.internal.l.j6(bArr);
        b bVar = new b();
        try {
            b bVar2 = (b) bVar.DW(j6);
            lg().ei().j6("Parsed config. version, gmp_app_id", bVar.j6, bVar.DW);
            return bVar;
        } catch (IOException e) {
            lg().yS().j6("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map<String, String> j6(b bVar) {
        Map<String, String> lVar = new l();
        if (!(bVar == null || bVar.Hw == null)) {
            for (c cVar : bVar.Hw) {
                if (cVar != null) {
                    lVar.put(cVar.j6, cVar.DW);
                }
            }
        }
        return lVar;
    }

    private void j6(String str, b bVar) {
        Map lVar = new l();
        Map lVar2 = new l();
        if (!(bVar == null || bVar.v5 == null)) {
            for (a aVar : bVar.v5) {
                if (aVar != null) {
                    String str2 = (String) AppMeasurement.a.j6.get(aVar.j6);
                    if (str2 != null) {
                        aVar.j6 = str2;
                    }
                    lVar.put(aVar.j6, aVar.DW);
                    lVar2.put(aVar.j6, aVar.FH);
                }
            }
        }
        this.DW.put(str, lVar);
        this.FH.put(str, lVar2);
    }

    protected String DW(String str) {
        tp();
        return (String) this.v5.get(str);
    }

    boolean DW(String str, String str2) {
        tp();
        Hw(str);
        Map map = (Map) this.DW.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    protected void FH(String str) {
        tp();
        this.v5.put(str, null);
    }

    boolean FH(String str, String str2) {
        tp();
        Hw(str);
        Map map = (Map) this.FH.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    protected b j6(String str) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        Hw(str);
        return (b) this.Hw.get(str);
    }

    String j6(String str, String str2) {
        tp();
        Hw(str);
        Map map = (Map) this.j6.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected boolean j6(String str, byte[] bArr, String str2) {
        FH();
        tp();
        com.google.android.gms.common.internal.b.j6(str);
        b j6 = j6(str, bArr);
        if (j6 == null) {
            return false;
        }
        j6(str, j6);
        this.Hw.put(str, j6);
        this.v5.put(str, str2);
        this.j6.put(str, j6(j6));
        EQ().j6(str, j6.Zo);
        try {
            j6.Zo = null;
            byte[] bArr2 = new byte[j6.VH()];
            j6.j6(m.j6(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            lg().yS().j6("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        aM().j6(str, bArr);
        return true;
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    protected void v5() {
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }
}
