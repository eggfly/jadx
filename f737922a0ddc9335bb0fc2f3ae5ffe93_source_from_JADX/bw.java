import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CRC32;

public class bw {
    private HashMap<bh, List<String>> BT;
    protected byte[] DW;
    private bv EQ;
    protected CRC32 FH;
    private final by Hw;
    private ec J0;
    private String J8;
    private dx Mr;
    private bj[] P8;
    private int QX;
    private eb U2;
    private final cw VH;
    private bv[] Ws;
    private dg XL;
    private final cz Zo;
    private eb a8;
    private dg aM;
    private boolean ei;
    private eb er;
    private HashMap<Integer, bw$a> gW;
    private du gn;
    private dy j3;
    protected char[] j6;
    private eb lg;
    private eb rN;
    private dh tp;
    private dx u7;
    private final cx v5;
    private bh[] vy;
    private ec we;
    private HashMap<Integer, String> yS;

    public bw(by byVar, cx cxVar, cz czVar, cw cwVar) {
        this.j6 = new char[10000];
        this.DW = new byte[10000];
        this.FH = new CRC32();
        this.we = new ec();
        this.J0 = new ec();
        this.Hw = byVar;
        this.v5 = cxVar;
        this.Zo = czVar;
        this.VH = cwVar;
        this.Ws = new bv[1000];
        this.Ws[0] = new bv(byVar, this, cxVar, byVar.j6(""), null);
        this.QX = 1;
        this.tp = new dh();
        this.gn = new du();
        this.u7 = new dx();
        this.XL = new dg();
        this.aM = new dg();
        this.j3 = new dy();
        this.Mr = new dx();
        this.U2 = new eb(this);
        this.a8 = new eb(this);
        this.lg = new eb(this);
        this.rN = new eb(this);
        this.er = new eb(this);
        this.gW = new HashMap();
        this.yS = new HashMap();
        this.BT = new HashMap();
    }

    protected void j6(bh bhVar, List<String> list) {
        this.BT.put(bhVar, list);
    }

    protected void j6(bh[] bhVarArr) {
        this.vy = bhVarArr;
        List arrayList = new ArrayList();
        for (bh Zo : bhVarArr) {
            for (bj bjVar : Zo.Zo()) {
                if (!arrayList.contains(bjVar)) {
                    arrayList.add(bjVar);
                }
            }
        }
        this.P8 = new bj[arrayList.size()];
        arrayList.toArray(this.P8);
    }

    public void j6() {
        for (bh bhVar : this.vy) {
            if (bhVar != null && bhVar.VH()) {
                bhVar.gn();
            }
        }
    }

    public void j6(ef efVar) {
        efVar.writeInt(this.QX);
    }

    public void j6(ee eeVar) {
        this.QX = eeVar.readInt();
        this.Ws = new bv[(this.QX * 2)];
        for (int i = 0; i < this.QX; i++) {
            this.Ws[i] = new bv(this.Hw, this, this.v5);
        }
    }

    protected void DW(ee eeVar) {
        for (int i = 0; i < this.QX; i++) {
            this.Ws[i].j6(eeVar);
            if (eeVar.readChar() != 'E') {
                throw new IOException();
            }
        }
        this.gn = new du(eeVar);
        this.u7 = new dx(eeVar);
        this.XL = new dg(eeVar);
    }

    protected void DW(ef efVar) {
        for (int i = 0; i < this.QX; i++) {
            this.Ws[i].j6(efVar);
            efVar.writeChar(69);
        }
        this.gn.j6(efVar);
        this.u7.j6(efVar);
        this.XL.j6(efVar);
    }

    protected void j6(boolean z) {
        if (z) {
            tp();
        }
        this.we.j6();
        this.gn.j6.j6();
        while (this.gn.j6.DW()) {
            bv gn = gn(this.gn.j6.FH());
            if (this.gn.j6.Hw() != gn.aM()) {
                this.we.j6(gn.vy());
            }
        }
        this.we.j6.j6();
        while (this.we.j6.DW()) {
            this.gn.DW(this.we.j6.FH());
        }
        this.J0.j6();
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            gn = gn(this.u7.j6.Hw());
            bv gn2 = gn(this.u7.j6.FH());
            if (this.we.FH(gn.vy())) {
                this.J0.j6(gn2.vy());
            }
        }
        this.J0.j6.j6();
        while (this.J0.j6.DW()) {
            int FH = this.J0.j6.FH();
            this.u7.j6(FH);
            this.tp.j6(FH);
        }
    }

    private void tp() {
        for (bv bvVar : this.Ws) {
            if (bvVar != null) {
                bvVar.ei();
            }
        }
        this.ei = false;
    }

    public bh[] DW() {
        return this.vy;
    }

    protected int j6(bh bhVar) {
        for (int i = 0; i < this.vy.length; i++) {
            if (bhVar == this.vy[i]) {
                return i;
            }
        }
        return -1;
    }

    protected bh j6(int i) {
        if (i < 0) {
            return null;
        }
        return this.vy[i];
    }

    public int j6(bj bjVar) {
        for (int i = 0; i < this.P8.length; i++) {
            if (bjVar == this.P8[i]) {
                return i;
            }
        }
        return -1;
    }

    public bj DW(int i) {
        return this.P8[i];
    }

    public bj FH(int i) {
        return DW(i & 255);
    }

    public bv Hw(int i) {
        return gn(i >> 8);
    }

    public int j6(bv bvVar, bj bjVar) {
        return (bvVar.vy() << 8) | j6(bjVar);
    }

    protected int j6(bv bvVar) {
        EQ();
        return this.aM.FH(bvVar.vy());
    }

    public bv v5(int i) {
        return DW(((bw$a) this.gW.get(Integer.valueOf(i))).FH);
    }

    public String Zo(int i) {
        if (this.gW.containsKey(Integer.valueOf(i))) {
            return ((bw$a) this.gW.get(Integer.valueOf(i))).DW;
        }
        return "";
    }

    public String VH(int i) {
        return ((bw$a) this.gW.get(Integer.valueOf(i))).Hw;
    }

    public String DW(bv bvVar) {
        if (this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).EQ;
        }
        return "";
    }

    public boolean FH(bv bvVar) {
        return u7(bvVar) == null && tp(bvVar) == null;
    }

    public boolean Hw(bv bvVar) {
        if (this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).we;
        }
        return false;
    }

    public boolean v5(bv bvVar) {
        return bvVar.Zo() == this.Hw.j6("R");
    }

    public boolean Zo(bv bvVar) {
        if (v5(bvVar) && this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).Ws;
        }
        return false;
    }

    public boolean VH(bv bvVar) {
        if (!FH(bvVar) && this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).J8;
        }
        return false;
    }

    public boolean gn(bv bvVar) {
        if (this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).J0;
        }
        return false;
    }

    protected String u7(bv bvVar) {
        if (this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).u7;
        }
        return null;
    }

    protected String tp(bv bvVar) {
        if (this.gW.containsKey(Integer.valueOf(j6(bvVar)))) {
            return ((bw$a) this.gW.get(Integer.valueOf(j6(bvVar)))).tp;
        }
        return null;
    }

    protected void j6(int i, String str, String str2, String str3, String str4, String str5, List<String> list, List<String> list2, List<String> list3, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, boolean z4) {
        HashMap hashMap = this.gW;
        Integer valueOf = Integer.valueOf(i);
        hashMap.put(r19, new bw$a(str, str2, str3, str4, str5, list3, list, list2, str6, str7, str8, z, z2, z3, z4));
    }

    protected void j6(String str) {
        this.J8 = str;
    }

    protected void j6(int i, int i2) {
        this.j3.DW(i, i2);
        this.Mr.DW(i, i2);
    }

    protected void j6(bv bvVar, bh bhVar) {
        this.XL.j6(bvVar.vy(), j6(bhVar));
    }

    protected void j6(bv bvVar, int i, bh bhVar, boolean z) {
        this.XL.j6(bvVar.vy(), j6(bhVar));
        this.aM.j6(bvVar.vy(), i);
        if (z) {
            this.U2.j6(bvVar);
        }
        this.a8.j6(bvVar);
    }

    protected void j6(bv bvVar, int i, String str) {
        this.aM.j6(bvVar.vy(), i);
        if (str != null) {
            this.yS.put(Integer.valueOf(bvVar.vy()), str);
        }
        this.lg.j6(bvVar);
    }

    protected void FH() {
        this.aM.j6();
        this.j3.j6();
        this.Mr.j6();
        this.U2.j6();
        this.a8.j6();
        this.lg.j6();
        this.rN.j6();
        this.er.j6();
        this.gW.clear();
        this.yS.clear();
        this.BT.clear();
        tp();
    }

    protected boolean j6(bv bvVar, bv bvVar2, bv bvVar3) {
        int FH = this.aM.FH(bvVar2.vy());
        int FH2 = this.aM.FH(bvVar3.vy());
        this.Mr.j6.j6(this.aM.FH(bvVar.vy()));
        while (this.Mr.j6.DW()) {
            int Hw = this.Mr.j6.Hw();
            if (Hw == FH) {
                return true;
            }
            if (Hw == FH2) {
                return false;
            }
        }
        return false;
    }

    protected boolean j6(bv bvVar, bv bvVar2) {
        EQ();
        return this.j3.FH(this.aM.FH(bvVar2.vy()), this.aM.FH(bvVar.vy()));
    }

    protected boolean DW(int i, int i2) {
        EQ();
        return this.j3.FH(i2, i);
    }

    private void EQ() {
        if (!this.ei) {
            bv FH;
            this.ei = true;
            this.U2.j6.j6();
            while (this.U2.j6.DW()) {
                FH = this.U2.j6.FH();
                j6(FH, this.aM.FH(FH.vy()), this.XL.FH(FH.vy()), this.rN);
            }
            this.a8.j6.j6();
            while (this.a8.j6.DW()) {
                FH = this.a8.j6.FH();
                j6(FH, this.aM.FH(FH.vy()), this.XL.FH(FH.vy()), this.er);
            }
        }
    }

    private void j6(bv bvVar, int i, int i2, eb ebVar) {
        if (bvVar.Mr()) {
            int yS = bvVar.yS();
            for (int i3 = 0; i3 < yS; i3++) {
                j6(bvVar.FH(i3), i, i2, ebVar);
            }
            return;
        }
        this.aM.j6(bvVar.vy(), i);
        this.XL.j6(bvVar.vy(), i2);
        ebVar.j6(bvVar);
    }

    public String EQ(bv bvVar) {
        if (this.yS.containsKey(Integer.valueOf(bvVar.vy()))) {
            return (String) this.yS.get(Integer.valueOf(bvVar.vy()));
        }
        return null;
    }

    public bh we(bv bvVar) {
        return j6(this.XL.FH(bvVar.vy()));
    }

    public bh J0(bv bvVar) {
        if (this.XL.DW(bvVar.vy())) {
            return j6(this.XL.FH(bvVar.vy()));
        }
        EQ();
        bh j6 = j6(this.XL.FH(bvVar.vy()));
        if (j6 != null) {
            return j6;
        }
        String v5 = bvVar.v5();
        for (bh bhVar : this.vy) {
            if (this.BT.containsKey(bhVar)) {
                for (String str : (List) this.BT.get(bhVar)) {
                    if (eo.j6() != null && eo.j6().j6(v5, str)) {
                        this.XL.j6(bvVar.vy(), j6(bhVar));
                        return bhVar;
                    }
                }
                continue;
            }
        }
        this.XL.j6(bvVar.vy(), -1);
        return null;
    }

    protected boolean J8(bv bvVar) {
        EQ();
        return this.rN.FH(bvVar);
    }

    protected boolean Ws(bv bvVar) {
        EQ();
        return this.er.FH(bvVar);
    }

    public eb Hw() {
        EQ();
        return this.rN;
    }

    public eb v5() {
        EQ();
        return this.er;
    }

    public eb Zo() {
        EQ();
        return this.lg;
    }

    public int QX(bv bvVar) {
        if (bvVar == null) {
            return -1;
        }
        return bvVar.vy();
    }

    public bv gn(int i) {
        if (i == -1) {
            return null;
        }
        return this.Ws[i];
    }

    public boolean VH() {
        for (int i = 0; i < this.QX; i++) {
            bv bvVar = this.Ws[i];
            if (!bvVar.P8() && bvVar.BT() != null) {
                return false;
            }
            if (this.Zo.gn()) {
                throw new InterruptedException();
            }
        }
        return true;
    }

    public bv gn() {
        return this.Ws[0];
    }

    public bv DW(String str) {
        int i = 0;
        while (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        bv gn = gn();
        int i2 = 0;
        bv bvVar = gn;
        int indexOf = str.indexOf(File.separatorChar, 0);
        while (indexOf != -1) {
            String substring = str.substring(i2, indexOf);
            if (substring.equals(".")) {
                i = 1;
            } else if (substring.equals("..") && gn() != bvVar) {
                bvVar = bvVar.u7();
                i = 1;
            } else if (!substring.equals("")) {
                bvVar = bvVar.j6(substring);
                i = 1;
            } else if (i == 0) {
                bvVar = bvVar.j6(substring);
            }
            i2 = indexOf + 1;
            indexOf = str.indexOf(File.separatorChar, i2);
        }
        return bvVar.j6(str.substring(i2, str.length()));
    }

    protected String u7() {
        return this.J8;
    }

    protected int XL(bv bvVar) {
        if (this.QX >= this.Ws.length) {
            Object obj = new bv[((this.Ws.length * 2) + 1)];
            System.arraycopy(this.Ws, 0, obj, 0, this.Ws.length);
            this.Ws = obj;
        }
        this.Ws[this.QX] = bvVar;
        int i = this.QX;
        this.QX = i + 1;
        return i;
    }

    protected long aM(bv bvVar) {
        if (bvVar.BT() == null) {
            return bvVar.aM();
        }
        if (this.tp.DW(bvVar.vy())) {
            return this.tp.FH(bvVar.vy());
        }
        if (!this.u7.DW(bvVar.vy())) {
            this.u7.j6(bvVar.vy(), bvVar.vy());
            this.gn.j6(bvVar.vy(), bvVar.aM());
            for (bj bjVar : bvVar.BT().Zo()) {
                this.EQ = bvVar;
                bvVar.BT().j6(bvVar, bjVar);
                this.EQ = null;
            }
        }
        long j = 0;
        this.u7.j6.j6(bvVar.vy());
        while (this.u7.j6.DW()) {
            j = (j * 37) ^ gn(this.u7.j6.Hw()).aM();
        }
        this.tp.j6(bvVar.vy(), j);
        return j;
    }

    protected Reader j6(InputStream inputStream, String str) {
        return this.VH.j6(inputStream, str);
    }

    public Reader j6(Reader reader) {
        return new bw$b(reader);
    }
}
