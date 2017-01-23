package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Iterator;

@eh
public class ad {
    private final int DW;
    private int EQ;
    private final int FH;
    private final ai Hw;
    private String J0;
    private ArrayList<String> VH;
    private ArrayList<String> Zo;
    private int gn;
    private final int j6;
    private int tp;
    private int u7;
    private final Object v5;
    private String we;

    public ad(int i, int i2, int i3, int i4) {
        this.v5 = new Object();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.gn = 0;
        this.u7 = 0;
        this.tp = 0;
        this.we = "";
        this.J0 = "";
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = new ai(i4);
    }

    private void FH(String str, boolean z) {
        if (str != null && str.length() >= this.FH) {
            synchronized (this.v5) {
                this.Zo.add(str);
                this.gn += str.length();
                if (z) {
                    this.VH.add(str);
                }
            }
        }
    }

    private String j6(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    public String DW() {
        return this.we;
    }

    public void DW(String str, boolean z) {
        FH(str, z);
    }

    public void FH() {
        synchronized (this.v5) {
            this.tp--;
        }
    }

    public void Hw() {
        synchronized (this.v5) {
            this.tp++;
        }
    }

    int Zo() {
        return this.gn;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ad adVar = (ad) obj;
        return adVar.DW() != null && adVar.DW().equals(DW());
    }

    public int hashCode() {
        return DW().hashCode();
    }

    int j6(int i, int i2) {
        return (this.j6 * i) + (this.DW * i2);
    }

    public void j6(int i) {
        this.u7 = i;
    }

    public void j6(String str, boolean z) {
        FH(str, z);
        synchronized (this.v5) {
            if (this.tp < 0) {
                b.j6("ActivityContent: negative number of WebViews.");
            }
            v5();
        }
    }

    public boolean j6() {
        boolean z;
        synchronized (this.v5) {
            z = this.tp == 0;
        }
        return z;
    }

    public String toString() {
        int i = this.u7;
        int i2 = this.EQ;
        int i3 = this.gn;
        String valueOf = String.valueOf(j6(this.Zo, 100));
        String valueOf2 = String.valueOf(j6(this.VH, 100));
        String str = this.we;
        String str2 = this.J0;
        return new StringBuilder((((String.valueOf(valueOf).length() + 133) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(valueOf).append("\n viewableText").append(valueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).toString();
    }

    public void v5() {
        synchronized (this.v5) {
            int j6 = j6(this.gn, this.u7);
            if (j6 > this.EQ) {
                this.EQ = j6;
                this.we = this.Hw.j6(this.Zo);
                this.J0 = this.Hw.j6(this.VH);
            }
        }
    }
}
