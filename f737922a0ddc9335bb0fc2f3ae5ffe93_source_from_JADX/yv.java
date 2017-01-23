import com.aide.uidesigner.ProxyTextView;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

public class yv {
    private zb DW;
    private HashMap<yd, Integer> EQ;
    private yz FH;
    private yz Hw;
    private HashMap<yb, Integer> J0;
    private HashMap<yf, Integer> J8;
    private yt QX;
    private HashMap<yn, Integer> VH;
    private HashMap<Integer, yg> Ws;
    private yt$a XL;
    private HashMap<yl, Integer> Zo;
    private yt$a aM;
    private HashMap<ys, Integer> gn;
    private boolean j6;
    private HashMap<yc, Integer> tp;
    private HashMap<ya, Integer> u7;
    private HashMap<yq, Integer> v5;
    private HashMap<yj, Integer> we;

    public yv() {
        this.j6 = true;
        this.DW = new zb();
        this.FH = new yz();
        this.Hw = new yz();
        this.gn = new HashMap();
        this.v5 = new HashMap();
        this.Zo = new HashMap();
        this.VH = new HashMap();
        this.u7 = new HashMap();
        this.tp = new HashMap();
        this.EQ = new HashMap();
        this.we = new HashMap();
        this.J0 = new HashMap();
        this.J8 = new HashMap();
        this.Ws = new HashMap();
        this.QX = new yt();
    }

    public void j6(OutputStream outputStream) {
        this.QX.j6(outputStream);
    }

    private void FH() {
        yu Hw = this.QX.Hw();
        this.QX.j6(Hw.j6, 112, 1);
        this.QX.j6(Hw.DW, this.FH.FH() * 4, this.FH.FH());
        this.QX.j6(Hw.FH, this.Hw.FH() * 4, this.Hw.FH());
        this.QX.j6(Hw.Hw, this.v5.size() * 12, this.v5.size());
        this.QX.j6(Hw.v5, this.Zo.size() * 8, this.Zo.size());
        this.QX.j6(Hw.Zo, this.VH.size() * 8, this.VH.size());
        this.QX.j6(Hw.VH, this.Ws.size() * 32, this.Ws.size());
        Hw.yS = this.QX.v5();
    }

    private void j6(yw ywVar) {
        int i = 0;
        if (this.gn.size() != 0) {
            ys ysVar;
            HashMap hashMap = new HashMap();
            Vector vector = new Vector(this.gn.size());
            vector.setSize(this.gn.size());
            for (Entry entry : this.gn.entrySet()) {
                ys ysVar2 = (ys) entry.getKey();
                int intValue = ((Integer) entry.getValue()).intValue();
                ysVar2 = ywVar.j6(ysVar2);
                hashMap.put(ysVar2, Integer.valueOf(intValue));
                vector.set(intValue - 1, ysVar2);
            }
            this.gn = null;
            Collections.sort(vector);
            HashMap hashMap2 = new HashMap();
            yz yzVar = new yz();
            yzVar.j6(0, 0);
            for (int i2 = 0; i2 < vector.size(); i2++) {
                ysVar = (ys) vector.get(i2);
                yzVar.j6(i2 + 1, ((Integer) hashMap.get(ysVar)).intValue());
                hashMap2.put(ysVar, Integer.valueOf(i2 + 1));
            }
            HashMap hashMap3 = new HashMap();
            yt$a j6 = this.QX.j6(this.QX.Hw().u7);
            while (i < vector.size()) {
                ysVar = (ys) vector.get(i);
                int FH = j6.FH();
                hashMap3.put(ysVar, Integer.valueOf(FH));
                ywVar.j6(yzVar.j6(i + 1), FH);
                j6.j6(ysVar);
                i++;
            }
            this.gn = hashMap3;
            this.QX.j6(vector.size());
        }
    }

    private void DW(yw ywVar) {
        this.u7 = j6(this.QX.Hw().QX, this.u7, new yv$1(this), ywVar);
    }

    private void FH(yw ywVar) {
        this.tp = j6(this.QX.Hw().EQ, this.tp, new yv$7(this), ywVar);
    }

    private void Hw(yw ywVar) {
        this.EQ = j6(this.QX.Hw().tp, this.EQ, new yv$8(this), ywVar);
    }

    private void v5(yw ywVar) {
        this.J0 = j6(this.QX.Hw().aM, this.J0, new yv$9(this), ywVar);
    }

    private void Hw() {
        yz yzVar = new yz();
        this.J8 = j6(this.QX.Hw().we, this.J8, new yv$10(this, yzVar), null);
        HashMap hashMap = new HashMap();
        for (Entry entry : this.Ws.entrySet()) {
            int i;
            Integer num = (Integer) entry.getKey();
            yg ygVar = (yg) entry.getValue();
            int intValue = num.intValue();
            int v5 = ygVar.v5();
            int FH = ygVar.FH();
            int Hw = ygVar.Hw();
            int Zo = ygVar.Zo();
            int VH = ygVar.VH();
            if (ygVar.gn() == 0) {
                i = 0;
            } else {
                i = yzVar.j6(ygVar.gn());
            }
            hashMap.put(num, new yg(null, 0, intValue, v5, FH, Hw, Zo, VH, i, ygVar.u7()));
        }
        this.Ws = hashMap;
    }

    private void Zo(yw ywVar) {
        this.we = j6(this.QX.Hw().XL, this.we, new yv$11(this), ywVar);
    }

    private <T> HashMap<T, Integer> j6(yu$a yu_a, HashMap<T, Integer> hashMap, yv$d<T> yv_d_T, yw ywVar) {
        if (hashMap.size() == 0) {
            return hashMap;
        }
        yt$a j6 = this.QX.j6(yu_a);
        HashMap<T, Integer> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            Object j62 = yv_d_T.j6(entry.getKey(), ywVar);
            int FH = j6.FH();
            hashMap2.put(j62, Integer.valueOf(FH));
            yv_d_T.j6(j6, j62, ((Integer) entry.getValue()).intValue(), FH, ywVar);
        }
        this.QX.j6(hashMap.size());
        return hashMap2;
    }

    public void j6(int i, yg ygVar) {
        this.Ws.put(Integer.valueOf(i), ygVar);
    }

    private static int[] j6(yz yzVar) {
        int[] iArr = new int[yzVar.FH()];
        yzVar.j6.j6();
        while (yzVar.j6.DW()) {
            iArr[yzVar.j6.Hw()] = yzVar.j6.FH();
        }
        return iArr;
    }

    private static <T> List<T> j6(HashMap<T, Integer> hashMap) {
        List vector = new Vector(hashMap.size());
        vector.setSize(hashMap.size());
        for (Entry entry : hashMap.entrySet()) {
            vector.set(((Integer) entry.getValue()).intValue(), entry.getKey());
        }
        return vector;
    }

    public boolean j6(int i) {
        return this.Ws.containsKey(Integer.valueOf(i));
    }

    public void j6(yi yiVar) {
        DW(new yx(this, yiVar).j6(), yiVar);
    }

    public void DW(yi yiVar) {
        j6(new yx(this, yiVar).j6(), yiVar);
    }

    private void j6(yw ywVar, yi yiVar) {
        za zaVar = new za();
        tr$a tr_a = yiVar.j6().VH;
        if (tr_a.j6()) {
            yi$a j6 = yiVar.j6(tr_a.FH);
            for (int i = 0; i < tr_a.DW; i++) {
                yg Ws = j6.Ws();
                int DW = ywVar.DW(Ws.DW());
                if (!(zaVar.DW(DW) || Ws.gn() == 0)) {
                    yf j62 = ywVar.j6(yiVar.j6(Ws));
                    j6(j62.FH(), ywVar, yiVar);
                    j6(j62.Hw(), ywVar, yiVar);
                    this.Ws.put(Integer.valueOf(DW), j6(DW, (yg) this.Ws.get(Integer.valueOf(DW)), j6(j62)));
                }
            }
        }
    }

    private void j6(yf$b[] yf_bArr, yw ywVar, yi yiVar) {
        for (int i = 0; i < yf_bArr.length; i++) {
            yf$b yf_b = yf_bArr[i];
            if (yf_b.FH() != 0) {
                yf_bArr[i] = new yf$b(yf_b.j6(), yf_b.DW(), j6(yf_b, ywVar, yiVar));
            } else {
                yf_bArr[i] = new yf$b(yf_b.j6(), yf_b.DW(), -1);
            }
        }
    }

    private yg j6(int i, yg ygVar, int i2) {
        return new yg(null, 0, i, ygVar.v5(), ygVar.FH(), ygVar.Hw(), ygVar.Zo(), ygVar.VH(), i2, ygVar.u7());
    }

    public void j6() {
        this.QX.DW(this.QX.Hw().Ws.DW);
        FH(this.QX.FH(this.QX.Hw().J0.DW));
        Hw();
        gn();
        v5();
        Zo();
        VH();
        j6(this.QX.Hw().Hw, this.v5, new yv$12(this));
        j6(this.QX.Hw().v5, this.Zo, new yv$13(this));
        j6(this.QX.Hw().Zo, this.VH, new yv$14(this));
        this.QX.j6();
    }

    private void FH(int i) {
        for (yf v5 : this.J8.keySet()) {
            for (yf$b yf_b : v5.v5()) {
                if (yf_b.FH() != -1) {
                    yf_b.j6(yf_b.FH() + i);
                } else {
                    yf_b.j6(0);
                }
            }
        }
    }

    private <T> void j6(yu$a yu_a, HashMap<T, Integer> hashMap, yv$b<T> yv_b_T) {
        yt$a FH = this.QX.FH(yu_a);
        for (Object j6 : j6((HashMap) hashMap)) {
            yv_b_T.j6(FH, j6);
        }
    }

    private void v5() {
        int v5 = this.QX.j6(this.QX.Hw().J8, this.DW.j6(), this.DW.DW(), this.DW.FH()).v5();
        yz yzVar = new yz();
        this.FH.j6.j6();
        while (this.FH.j6.DW()) {
            yzVar.j6(this.FH.j6.FH() + v5, this.FH.j6.Hw());
        }
        this.FH = yzVar;
    }

    private void Zo() {
        yt$a FH = this.QX.FH(this.QX.Hw().DW);
        int[] j6 = j6(this.FH);
        for (int v5 : j6) {
            FH.v5(v5);
        }
    }

    private void VH() {
        yt$a FH = this.QX.FH(this.QX.Hw().FH);
        int[] j6 = j6(this.Hw);
        for (int v5 : j6) {
            FH.v5(v5);
        }
    }

    private void gn() {
        yz yzVar = new yz();
        HashMap DW = DW(this.gn);
        za zaVar = new za();
        for (Entry entry : this.Ws.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            yg ygVar = (yg) entry.getValue();
            zaVar.j6(intValue);
            int FH = ygVar.FH();
            if (FH != 0 && this.Ws.containsKey(Integer.valueOf(FH))) {
                yzVar.j6(intValue, FH);
            }
            if (ygVar.Hw() != 0) {
                for (short s : ((ys) DW.get(Integer.valueOf(ygVar.Hw()))).j6()) {
                    if (s != (short) 0 && this.Ws.containsKey(Short.valueOf(s))) {
                        yzVar.j6(intValue, s);
                    }
                }
            }
        }
        List arrayList = new ArrayList();
        za zaVar2 = new za();
        zaVar.j6.j6();
        while (zaVar.j6.DW()) {
            j6(zaVar.j6.FH(), zaVar2, arrayList, zaVar, yzVar);
        }
        yt$a FH2 = this.QX.FH(this.QX.Hw().VH);
        for (intValue = 0; intValue < arrayList.size(); intValue++) {
            ((yg) this.Ws.get(arrayList.get(intValue))).j6(FH2);
        }
    }

    private <K, V> HashMap<V, K> DW(HashMap<K, V> hashMap) {
        HashMap<V, K> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(entry.getValue(), entry.getKey());
        }
        return hashMap2;
    }

    private void j6(int i, za zaVar, List<Integer> list, za zaVar2, yz yzVar) {
        if (!zaVar.DW(i)) {
            zaVar.j6(i);
            yz$a j6 = yzVar.j6();
            j6.j6(i);
            while (j6.DW()) {
                int Hw = j6.Hw();
                if (zaVar2.DW(Hw)) {
                    j6(Hw, zaVar, list, zaVar2, yzVar);
                }
            }
            list.add(Integer.valueOf(i));
        }
    }

    private int j6(yf$b yf_b, yw ywVar, yi yiVar) {
        int Hw = this.XL.Hw();
        j6(yiVar, yiVar.j6(yf_b), ywVar);
        yu$a yu_a = this.QX.Hw().J0;
        yu_a.DW++;
        return Hw;
    }

    private void j6(yi yiVar, yh yhVar, yw ywVar) {
        int i = 0;
        this.XL.u7();
        this.XL.Hw(yhVar.j6());
        this.XL.Hw(yhVar.DW());
        this.XL.Hw(yhVar.FH());
        yh$b[] Zo = yhVar.Zo();
        this.XL.Hw(Zo.length);
        int Hw = yhVar.Hw();
        if (Hw != 0) {
            yi$a j6 = yiVar.j6(Hw);
            int FH = this.aM.FH();
            j6(j6, ywVar);
            this.XL.v5(FH);
        } else {
            this.XL.v5(0);
        }
        short[] v5 = yhVar.v5();
        yy.j6(v5, ywVar);
        this.XL.v5(v5.length);
        this.XL.j6(v5);
        if (Zo.length > 0) {
            if (v5.length % 2 == 1) {
                this.XL.j6((short) 0);
            }
            FH = this.XL.j6();
            this.XL.j6(Zo.length * 8);
            yh$a[] VH = yhVar.VH();
            int j62 = this.XL.j6();
            this.XL.Zo(VH.length);
            yz yzVar = new yz();
            for (yh$a j63 : VH) {
                j6(yzVar, j62, j63, ywVar);
            }
            Hw = this.XL.j6();
            this.XL.DW(FH);
            FH = Zo.length;
            while (i < FH) {
                yh$b yh_b = Zo[i];
                this.XL.v5(yh_b.j6());
                this.XL.Hw(yh_b.DW());
                this.XL.Hw(yzVar.j6(yh_b.FH()));
                i++;
            }
            this.XL.DW(Hw);
        }
        this.XL.gn();
    }

    private void j6(yi$a yi_a, yw ywVar) {
        int i;
        this.aM.Zo(yi_a.VH());
        int VH = yi_a.VH();
        this.aM.Zo(VH);
        for (i = 0; i < VH; i++) {
            this.aM.VH(ywVar.j6(yi_a.gn()));
        }
        while (true) {
            i = yi_a.Zo();
            this.aM.FH(i);
            switch (i) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    yu$a yu_a = this.QX.Hw().Ws;
                    yu_a.DW++;
                    return;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.aM.Zo(yi_a.VH());
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.aM.gn(yi_a.u7());
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    this.aM.Zo(yi_a.VH());
                    this.aM.VH(ywVar.j6(yi_a.gn()));
                    this.aM.VH(ywVar.DW(yi_a.gn()));
                    if (i != 4) {
                        break;
                    }
                    this.aM.VH(ywVar.j6(yi_a.gn()));
                    break;
                case 5:
                case 6:
                    this.aM.Zo(yi_a.VH());
                    break;
                case 9:
                    this.aM.VH(ywVar.j6(yi_a.gn()));
                    break;
                default:
                    break;
            }
        }
    }

    private void j6(yz yzVar, int i, yh$a yh_a, yw ywVar) {
        yzVar.j6(yh_a.j6(), this.XL.j6() - i);
        int Hw = yh_a.Hw();
        int[] DW = yh_a.DW();
        int[] FH = yh_a.FH();
        if (Hw != -1) {
            this.XL.gn(-DW.length);
        } else {
            this.XL.gn(DW.length);
        }
        for (int i2 = 0; i2 < DW.length; i2++) {
            this.XL.Zo(ywVar.DW(DW[i2]));
            this.XL.Zo(FH[i2]);
        }
        if (Hw != -1) {
            this.XL.Zo(Hw);
        }
    }

    private void DW(yw ywVar, yi yiVar) {
        tr$a tr_a = yiVar.j6().VH;
        if (tr_a.j6()) {
            yi$a j6 = yiVar.j6(tr_a.FH);
            for (int i = 0; i < tr_a.DW; i++) {
                yg Ws = j6.Ws();
                int DW = ywVar.DW(Ws.DW());
                if (!j6(DW)) {
                    int VH = Ws.VH();
                    int i2 = 0;
                    if (VH != 0) {
                        i2 = j6(ywVar.j6(yiVar.j6(VH).j3()));
                    }
                    j6(DW, new yg(null, 0, DW, Ws.v5(), ywVar.DW(Ws.FH()), ywVar.Zo(Ws.Hw()), ywVar.j6(Ws.Zo()), i2, 0, ywVar.EQ(Ws.u7())));
                }
            }
        }
    }

    public int j6(byte[] bArr, int i) {
        int j6 = this.DW.j6(bArr, i);
        int j62 = this.FH.j6(j6);
        if (j62 != -1) {
            return j62;
        }
        u7();
        j62 = this.FH.FH();
        this.FH.j6(j6, j62);
        return j62;
    }

    public int DW(int i) {
        int j6 = this.Hw.j6(i);
        if (j6 != -1) {
            return j6;
        }
        u7();
        j6 = this.Hw.FH();
        this.Hw.j6(i, j6);
        return j6;
    }

    public int j6(yq yqVar) {
        Integer num = (Integer) this.v5.get(yqVar);
        if (num == null) {
            u7();
            yq DW = DW(yqVar);
            num = Integer.valueOf(this.v5.size());
            this.v5.put(DW, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public void DW() {
        yw ywVar = new yw(this.FH.FH(), this.Hw.FH(), this.v5.size(), this.Zo.size(), this.VH.size());
        FH();
        gn(ywVar);
        u7(ywVar);
        this.Zo = j6(this.Zo, ywVar, new yv$2(this, ywVar));
        j6(ywVar);
        this.v5 = j6(this.v5, ywVar, new yv$3(this, ywVar));
        this.VH = j6(this.VH, ywVar, new yv$4(this, ywVar));
        DW(ywVar);
        FH(ywVar);
        Hw(ywVar);
        v5(ywVar);
        Zo(ywVar);
        VH(ywVar);
        this.aM = this.QX.j6(this.QX.Hw().Ws);
        this.XL = this.QX.DW(this.QX.Hw().J0);
        this.j6 = false;
    }

    private void VH(yw ywVar) {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.Ws.entrySet()) {
            hashMap.put(Integer.valueOf(ywVar.DW(((Integer) entry.getKey()).intValue())), ywVar.j6((yg) entry.getValue()));
        }
        this.Ws = hashMap;
    }

    private void gn(yw ywVar) {
        int[] j6 = j6(this.FH);
        j6(j6, new yv$5(this));
        yz yzVar = new yz(j6.length);
        for (int i = 0; i < j6.length; i++) {
            yzVar.j6(j6[i], i);
            ywVar.VH(this.FH.j6(j6[i]), i);
        }
        this.FH = yzVar;
    }

    private void u7(yw ywVar) {
        yz yzVar = new yz(this.Hw.FH());
        this.Hw.j6.j6();
        while (this.Hw.j6.DW()) {
            int FH = this.Hw.j6.FH();
            yzVar.j6(ywVar.j6(FH), this.Hw.j6.Hw());
        }
        int[] j6 = j6(yzVar);
        j6(j6, new yv$6(this));
        this.Hw.DW();
        for (FH = 0; FH < j6.length; FH++) {
            this.Hw.j6(j6[FH], FH);
            ywVar.gn(yzVar.j6(j6[FH]), FH);
        }
    }

    private static <T extends Comparable<T>> HashMap<T, Integer> j6(HashMap<T, Integer> hashMap, yw ywVar, yv$a<T> yv_a_T) {
        HashMap hashMap2 = new HashMap(hashMap.size());
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(yv_a_T.j6((Comparable) entry.getKey(), ywVar), Integer.valueOf(((Integer) entry.getValue()).intValue()));
        }
        List j6 = j6(hashMap2);
        Collections.sort(j6);
        HashMap<T, Integer> hashMap3 = new HashMap(hashMap.size());
        for (int i = 0; i < j6.size(); i++) {
            hashMap3.put(j6.get(i), Integer.valueOf(i));
            yv_a_T.j6(((Integer) hashMap2.get(j6.get(i))).intValue(), i);
        }
        return hashMap3;
    }

    public int j6(yl ylVar) {
        Integer num = (Integer) this.Zo.get(ylVar);
        if (num == null) {
            u7();
            yl DW = DW(ylVar);
            num = Integer.valueOf(this.Zo.size());
            this.Zo.put(DW, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public int j6(yn ynVar) {
        Integer num = (Integer) this.VH.get(ynVar);
        if (num == null) {
            u7();
            yn DW = DW(ynVar);
            num = Integer.valueOf(this.VH.size());
            this.VH.put(DW, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public int j6(ys ysVar) {
        Integer num = (Integer) this.gn.get(ysVar);
        if (num == null) {
            u7();
            ys DW = DW(ysVar);
            num = Integer.valueOf(this.gn.size() + 1);
            this.gn.put(DW, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public int j6(ya yaVar) {
        Integer num = (Integer) this.u7.get(yaVar);
        if (num == null) {
            u7();
            ya DW = DW(yaVar);
            num = Integer.valueOf(this.u7.size() + 1);
            this.u7.put(DW, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public int j6(yc ycVar) {
        Integer num = (Integer) this.tp.get(ycVar);
        if (num == null) {
            u7();
            num = Integer.valueOf(this.tp.size() + 1);
            this.tp.put(ycVar, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public int j6(yd ydVar) {
        Integer num = (Integer) this.EQ.get(ydVar);
        if (num == null) {
            u7();
            num = Integer.valueOf(this.EQ.size() + 1);
            this.EQ.put(ydVar, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    public int j6(yj yjVar) {
        Integer num = (Integer) this.we.get(yjVar);
        if (num == null) {
            u7();
            num = Integer.valueOf(this.we.size() + 1);
            this.we.put(yjVar, Integer.valueOf(num.intValue()));
        }
        return num.intValue();
    }

    private void u7() {
        if (!this.j6) {
            throw new IllegalStateException("Too many classes/methods/fields/strings. Consider using 'multiDexEnabled true' or 'minSdkVersion 21' in your build.gradle file.");
        }
    }

    public int j6(yb ybVar) {
        int size = this.J0.size() + 1;
        this.J0.put(ybVar, Integer.valueOf(size));
        return size;
    }

    public int j6(yf yfVar) {
        int size = this.J8.size() + 1;
        this.J8.put(yfVar, Integer.valueOf(size));
        return size;
    }

    private ys DW(ys ysVar) {
        return new ys(null, ysVar.j6());
    }

    private yq DW(yq yqVar) {
        return new yq(null, yqVar.j6(), yqVar.DW(), yqVar.FH());
    }

    private yl DW(yl ylVar) {
        return new yl(null, ylVar.j6(), ylVar.DW(), ylVar.FH());
    }

    private yn DW(yn ynVar) {
        return new yn(null, ynVar.j6(), ynVar.DW(), ynVar.FH());
    }

    private ya DW(ya yaVar) {
        return new ya(null, yaVar.j6(), yaVar.DW(), yaVar.FH(), yaVar.Hw());
    }

    public static void j6(int[] iArr, yv$c yv_c) {
        j6(iArr, 0, iArr.length - 1, yv_c);
    }

    private static void j6(int[] iArr, int i, int i2, yv$c yv_c) {
        if (i < i2) {
            int i3 = iArr[((i2 - i) / 2) + i];
            int i4 = i2;
            int i5 = i;
            while (i5 <= i4) {
                while (yv_c.j6(iArr[i5], i3) < 0) {
                    i5++;
                }
                while (yv_c.j6(i3, iArr[i4]) < 0) {
                    i4--;
                }
                if (i5 <= i4) {
                    int i6 = iArr[i4];
                    iArr[i4] = iArr[i5];
                    iArr[i5] = i6;
                    i5++;
                    i4--;
                }
            }
            j6(iArr, i, i4, yv_c);
            j6(iArr, i5, i2, yv_c);
        }
    }
}
