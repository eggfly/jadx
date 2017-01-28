import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.aide.common.m;
import com.aide.common.w;
import com.aide.ui.e;
import com.aide.ui.h;
import com.dropbox.client2.android.a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.InterruptibleChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class nz {
    private static final aem$a j6;
    private adv<a> DW;
    private String EQ;
    private boolean FH;
    private boolean Hw;
    private List<nz$c> J0;
    private HashSet<nz$e> J8;
    private InterruptibleChannel Mr;
    private String QX;
    private Object U2;
    private Object VH;
    private Object Ws;
    private boolean XL;
    private boolean Zo;
    private boolean a8;
    private int aM;
    private boolean gn;
    private Object j3;
    private String tp;
    private Set<nz$e> u7;
    private boolean v5;
    private nz$b we;

    public nz() {
        this.FH = false;
        this.Hw = false;
        this.v5 = false;
        this.Zo = false;
        this.VH = new Object();
        this.u7 = new HashSet();
        this.J0 = new ArrayList();
        this.J8 = new HashSet();
        this.Ws = new Object();
        this.j3 = new Object();
        this.U2 = new Object();
    }

    static {
        j6 = aem$a.DROPBOX;
    }

    public void j6() {
        if (!VH()) {
            ((a) this.DW.j6()).FH();
            J8();
            this.v5 = false;
            this.Hw = false;
        }
    }

    public void DW() {
        EQ();
        this.DW = null;
    }

    public void j6(String str) {
        if (h.Ws() && gn(str)) {
            j6(e.ei().Hw(str), false);
        }
    }

    public void j6(List<String> list) {
        if (h.Ws()) {
            for (String str : list) {
                if (gn(str)) {
                    this.Zo = false;
                    j6(str, false);
                    if (e.ei().FH(str)) {
                        j6(e.ei().Hw(str), false);
                    }
                }
            }
        }
    }

    public void DW(String str) {
        if (h.Ws() && gn(str) && !e.a8().J8(str)) {
            j6(str, false);
        }
    }

    public void FH(String str) {
        if (h.Ws() && gn(str)) {
            j6(str, false);
        }
    }

    public void Hw(String str) {
        if (h.Ws() && gn(str)) {
            j6(str, false);
        }
    }

    public void v5(String str) {
        if (h.Ws() && gn(str)) {
            j6(str, false);
        }
    }

    public void DW(List<String> list) {
        if (h.Ws()) {
            for (String str : list) {
                if (gn(str)) {
                    j6(str, false);
                }
            }
        }
    }

    public void FH() {
        if (this.FH) {
            this.FH = false;
            this.Hw = false;
            a aVar = (a) this.DW.j6();
            if (aVar.j6()) {
                try {
                    aVar.DW();
                    aen v5 = aVar.v5();
                    DW(v5.j6, v5.DW);
                    synchronized (this.VH) {
                        this.v5 = true;
                        this.VH.notifyAll();
                    }
                    return;
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                    we();
                    m.j6(e.u7(), "Dropbox", "Couldn't authenticate with Dropbox.");
                    return;
                }
            }
            we();
        }
    }

    private void we() {
        synchronized (this.VH) {
            this.EQ = null;
            this.tp = null;
            this.u7.clear();
        }
    }

    public boolean Zo(String str) {
        return gn(str);
    }

    public boolean VH(String str) {
        return (e.a8().J8(str) || e.ei().FH(str) || gn(str) || qh.tp(str)) ? false : true;
    }

    public void j6(String str, nz$b nz_b) {
        synchronized (this.VH) {
            this.gn = true;
            this.EQ = str;
            this.we = nz_b;
            this.Hw = false;
            this.VH.notifyAll();
        }
    }

    public void Hw() {
        if (VH()) {
            e.u7().ef();
        }
        String j6 = e.er().j6();
        synchronized (this.VH) {
            this.gn = true;
            this.tp = j6;
            this.Hw = false;
            this.VH.notifyAll();
        }
    }

    public void j6(String str, String str2) {
        if (VH()) {
            e.u7().ef();
        }
        synchronized (this.VH) {
            this.gn = true;
            this.u7.add(new nz$e(str, str2));
            this.Hw = false;
            this.VH.notifyAll();
        }
    }

    public void j6(String str, boolean z) {
        if (z && VH()) {
            e.u7().ef();
        }
        synchronized (this.VH) {
            nz$e nz_e = new nz$e(str, null);
            Iterator it = this.J8.iterator();
            while (it.hasNext()) {
                if (((nz$e) it.next()).j6(nz_e)) {
                    return;
                }
            }
            this.gn = z;
            this.u7.add(nz_e);
            this.Hw = false;
            this.VH.notifyAll();
        }
    }

    public void v5() {
        new Thread(new nz$1(this)).start();
    }

    private boolean J0() {
        if (e.gn() != null) {
            if (this.DW == null) {
                ael ael;
                aem aem;
                if (e.j6.equals("com.aide.phonegap")) {
                    ael = new ael("2hlvmjwfmylgnjp", "99o0k7gok4ktizu");
                } else if (e.j6.equals("com.aide.web")) {
                    ael = new ael("jnyrhqjnzlzatzo", "fi1pqoyzax8vktt");
                } else {
                    ael = new ael("fkerp7oej8u61j0", "5rqhagcf14jbzcd");
                }
                String[] Ws = Ws();
                a aVar;
                if (Ws != null) {
                    aVar = new a(ael, j6, new aek(Ws[0], Ws[1]));
                    this.v5 = true;
                    aem = aVar;
                } else {
                    aVar = new a(ael, j6);
                    this.v5 = false;
                    Object obj = aVar;
                }
                this.DW = new adv(aem);
                if (this.v5) {
                    try {
                        long j = this.DW.DW().Zo;
                    } catch (Exception e) {
                        this.v5 = false;
                    }
                }
                if (this.v5) {
                    this.Zo = true;
                }
            }
            if (!(this.v5 || this.Hw)) {
                this.Hw = true;
                if (this.gn || !this.Zo) {
                    this.Zo = true;
                    e.j6(new nz$2(this));
                }
            }
        }
        return this.v5;
    }

    private void DW(String str, String str2) {
        Editor edit = e.gn().getSharedPreferences("DropBox", 0).edit();
        edit.putString("ACCESS_KEY", str);
        edit.putString("ACCESS_SECRET", str2);
        edit.commit();
    }

    private void J8() {
        Editor edit = e.gn().getSharedPreferences("DropBox", 0).edit();
        edit.clear();
        edit.commit();
    }

    private String[] Ws() {
        SharedPreferences sharedPreferences = e.gn().getSharedPreferences("DropBox", 0);
        String string = sharedPreferences.getString("ACCESS_KEY", null);
        String string2 = sharedPreferences.getString("ACCESS_SECRET", null);
        if (string == null || string2 == null) {
            return null;
        }
        return new String[]{string, string2};
    }

    private boolean gn(String str) {
        return u7(str) != null;
    }

    private String u7(String str) {
        if (!qh.gn(str)) {
            while (!qh.Hw(str)) {
                if (tp(str)) {
                    return str;
                }
                str = qh.v5(str);
            }
        }
        return null;
    }

    private boolean tp(String str) {
        return qh.VH(str + "/" + ".aidedropbox");
    }

    private void j6(nz$e nz_e) {
        String str;
        nz$d nz_d;
        synchronized (this.U2) {
            this.a8 = false;
        }
        String str2 = nz_e.j6;
        if (nz_e.DW != null) {
            String str3 = nz_e.j6;
            str = nz_e.DW;
            qh.Mr(str3);
            adv$a DW = this.DW.DW();
            nz_d = new nz$d(DW.Zo, DW.DW, str3, str);
            nz_d.j6();
            e.j6(new nz$3(this, str3));
        } else {
            String u7 = u7(str2);
            nz_d = new nz$d(u7);
            str = nz_d.j6(str2);
            if (this.DW.DW().Zo != nz_d.j6) {
                throw new IOException("Directory '" + u7 + "' was downloaded from the Dropbox of '" + nz_d.DW + "'. Please login to this account.");
            }
        }
        try {
            j6(nz_d, str2, str);
        } finally {
            nz_d.j6();
        }
    }

    private void j6(nz$d nz_d, String str, String str2) {
        com.aide.common.e.j6("Syncing " + str);
        if (qh.J8(str)) {
            j6(nz_d, str, false);
            return;
        }
        EQ(str2);
        j6(nz_d, str, str2, 0.0f, 100.0f);
    }

    private void EQ(String str) {
        adv$e j6;
        adv$e adv_e = null;
        try {
            j6 = this.DW.j6(str, 0, null, false, null);
            try {
                if (j6.J0) {
                    j6 = null;
                }
            } catch (aea e) {
                adv_e = j6;
                j6 = adv_e;
                if (j6 != null) {
                    this.DW.j6(str);
                }
            }
        } catch (aea e2) {
            j6 = adv_e;
            if (j6 != null) {
                this.DW.j6(str);
            }
        }
        if (j6 != null) {
            this.DW.j6(str);
        }
    }

    private void j6(nz$d nz_d, String str, String str2, float f, float f2) {
        j6(true, str2, f);
        Set<String> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        adv$e j6 = this.DW.j6(str2, 0, null, true, null);
        if (j6.J8 != null) {
            for (adv$e j62 : j62.J8) {
                if (!j62.J0) {
                    String str3 = str + "/" + j62.j6();
                    hashSet.add(str3);
                    hashMap.put(str3, j62);
                }
            }
        }
        for (String str4 : qh.QX(str)) {
            hashSet.add(str4);
            hashSet2.add(str4);
        }
        int size = hashSet.size();
        int i = 0;
        for (String str32 : hashSet) {
            nz$d$a FH = nz_d.FH(str32);
            adv$e adv_e = (adv$e) hashMap.get(str32);
            Object obj = FH != null ? 1 : null;
            float f3 = f + (((f2 - f) * ((float) i)) / ((float) size));
            float f4 = f3 + ((f2 - f) / ((float) size));
            if (!hashSet2.contains(str32) || hashMap.containsKey(str32)) {
                if (hashSet2.contains(str32) || !hashMap.containsKey(str32)) {
                    if (!adv_e.Hw) {
                        j6(nz_d, str32, FH, str2 + "/" + qh.Zo(str32), adv_e, false);
                    } else if (!J8(str32)) {
                        j6(nz_d, str32, adv_e.VH, f3, f4);
                    }
                } else if (obj != null) {
                    com.aide.common.e.j6("Dropbox delete " + str32);
                    this.DW.DW(adv_e.VH);
                    nz_d.DW(str32);
                } else if (adv_e.Hw) {
                    if (!J8(str32)) {
                        if (qh.VH(str32) || qh.Mr(str32)) {
                            nz_d.j6(str32, adv_e.EQ, 0);
                            j6(nz_d, str32, adv_e.VH, f3, f4);
                        } else {
                            throw new IOException("Could not create " + str32);
                        }
                    }
                } else if (!J0(str32)) {
                    com.aide.common.e.j6("Download new " + str32);
                    DW(nz_d, str32, adv_e);
                }
            } else if (obj != null) {
                com.aide.common.e.j6("Delete local " + str32);
                qh.j3(str32);
                nz_d.DW(str32);
            } else {
                String str5 = str2 + "/" + qh.Zo(str32);
                if (qh.we(str32)) {
                    if (!J8(str32)) {
                        nz_d.j6(str32, this.DW.j6(str5).EQ, 0);
                        j6(nz_d, str32, str5, f3, f4);
                    }
                } else if (!J0(str32)) {
                    com.aide.common.e.j6("Upload new " + str32);
                    long a8 = qh.a8(str32);
                    InputStream fileInputStream = new FileInputStream(str32);
                    j62 = this.DW.j6(str5, fileInputStream, a8, null, null);
                    fileInputStream.close();
                    nz_d.j6(str32, j62.EQ, qh.U2(str32));
                }
            }
            synchronized (this.U2) {
                if (this.a8) {
                    throw new nz$a();
                }
            }
            i++;
        }
    }

    private void j6(nz$d nz_d, String str, nz$d$a nz_d_a, String str2, adv$e adv_e, boolean z) {
        if (!J0(str)) {
            Object obj = nz_d_a != null ? 1 : null;
            long a8;
            InputStream fileInputStream;
            adv$e j6;
            if ((adv_e != null ? 1 : null) == null) {
                if (obj == null) {
                    com.aide.common.e.j6("Upload new " + str);
                    a8 = qh.a8(str);
                    fileInputStream = new FileInputStream(str);
                    j6 = this.DW.j6(str2, fileInputStream, a8, null);
                    fileInputStream.close();
                    nz_d.j6(str, j6.EQ, qh.U2(str));
                }
            } else if (obj != null) {
                long U2 = qh.U2(str);
                long j = nz_d_a.DW;
                String str3 = adv_e.EQ;
                String str4 = nz_d_a.j6;
                Object obj2 = !qh.j6(U2, j) ? 1 : null;
                obj = !str3.equals(str4) ? 1 : null;
                if (obj2 == null || obj == null) {
                    if (obj2 != null) {
                        com.aide.common.e.j6("Upload " + str + " " + U2 + " != " + j);
                        a8 = qh.a8(str);
                        fileInputStream = new FileInputStream(str);
                        j6 = this.DW.j6(str2, fileInputStream, a8, null);
                        fileInputStream.close();
                        nz_d.j6(str, j6.EQ, U2);
                    } else if (obj != null && !z) {
                        com.aide.common.e.j6("Download " + str + " " + str3 + " != " + str4);
                        DW(nz_d, str, adv_e);
                    }
                } else if (!z) {
                    j6(nz_d, str, adv_e);
                }
            } else if (!z) {
                j6(nz_d, str, adv_e);
            }
        }
    }

    private void j6(nz$d nz_d, String str, adv$e adv_e) {
        if (j6(str, adv_e)) {
            com.aide.common.e.j6("Resolve conflict " + str);
            nz_d.j6(str, adv_e.EQ, qh.U2(str));
            return;
        }
        com.aide.common.e.j6("Download conflict " + str);
        we(str);
        DW(nz_d, str, adv_e);
    }

    private boolean j6(String str, adv$e adv_e) {
        if (qh.a8(str) != adv_e.j6) {
            return false;
        }
        return w.j6(this.DW.j6(adv_e.VH, null), new FileInputStream(str));
    }

    private void we(String str) {
        w.j6(new FileInputStream(str), new FileOutputStream(qh.v5(str) + "/" + (qh.Zo(str) + ".syncconflict." + qh.U2(str))));
    }

    private void DW(nz$d nz_d, String str, adv$e adv_e) {
        InputStream j6 = this.DW.j6(adv_e.VH, null);
        ReadableByteChannel newChannel = Channels.newChannel(j6);
        if (newChannel instanceof InterruptibleChannel) {
            synchronized (this.j3) {
                this.Mr = (InterruptibleChannel) newChannel;
            }
        }
        try {
            w.j6(j6, new FileOutputStream(str));
            synchronized (this.U2) {
                if (this.a8) {
                    try {
                        qh.j3(str);
                        nz_d.DW(str);
                    } catch (IOException e) {
                    }
                    synchronized (this.j3) {
                        this.Mr = null;
                    }
                    return;
                }
                nz_d.j6(str, adv_e.EQ, qh.U2(str));
                synchronized (this.j3) {
                    this.Mr = null;
                }
                return;
            }
            while (true) {
                break;
            }
        } catch (IOException e2) {
            try {
                qh.j3(str);
                nz_d.DW(str);
            } catch (IOException e3) {
            }
            try {
                synchronized (this.U2) {
                }
                if (this.a8) {
                    synchronized (this.j3) {
                    }
                    this.Mr = null;
                    return;
                }
                throw e2;
            } catch (Throwable th) {
                synchronized (this.j3) {
                }
                this.Mr = null;
            }
        }
    }

    private void j6(nz$d nz_d, String str, boolean z) {
        adv$e adv_e = null;
        String j6 = nz_d.j6(str);
        try {
            adv_e = this.DW.j6(j6, 0, null, false, null);
        } catch (aeg e) {
            if (e.DW != 404) {
                throw e;
            }
        }
        j6(nz_d, str, nz_d.FH(str), j6, adv_e, z);
    }

    private boolean J0(String str) {
        String Zo = qh.Zo(str);
        return ".aidedropbox".equals(Zo) || Zo.contains(".syncconflict.");
    }

    private boolean J8(String str) {
        return "bin".equals(qh.Zo(str));
    }

    private void j6(boolean z, String str, float f) {
        synchronized (this.Ws) {
            this.XL = z;
            this.QX = str;
            this.aM = (int) f;
            e.j6(new nz$4(this));
        }
    }

    public String Zo() {
        return "Sync with Dropbox...";
    }

    public boolean VH() {
        boolean z;
        synchronized (this.Ws) {
            z = this.XL;
        }
        return z;
    }

    public int gn() {
        return this.aM;
    }

    public int u7() {
        return 0;
    }

    public String tp() {
        String str;
        synchronized (this.Ws) {
            str = this.QX;
        }
        return str;
    }

    public void j6(nz$c nz_c) {
        this.J0.add(nz_c);
    }

    public void DW(nz$c nz_c) {
        this.J0.remove(nz_c);
    }

    public void EQ() {
        synchronized (this.U2) {
            this.a8 = true;
        }
        synchronized (this.j3) {
            if (this.Mr != null) {
                new Thread(new nz$5(this, this.Mr)).start();
            }
        }
    }
}
