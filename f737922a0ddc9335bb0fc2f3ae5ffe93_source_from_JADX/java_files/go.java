import com.aide.engine.service.Native;
import com.aide.uidesigner.ProxyTextView;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class go {
    private do AL;
    private int BT;
    private dn CU;
    private dt DW;
    private String EQ;
    private boolean Eq;
    private do Ev;
    private dt FH;
    private int FN;
    private dw Hw;
    private int I;
    private String J0;
    private int J8;
    private int KD;
    private byte[] Mr;
    private int Mz;
    private int OW;
    private int P8;
    private do Q6;
    private int QX;
    private do Qq;
    private int SI;
    private byte[] Sf;
    private int U2;
    private dw VH;
    private do WB;
    private boolean Ws;
    private boolean XG;
    private int XL;
    private int XX;
    private boolean Xa;
    private do Z1;
    private dw Zo;
    private int a8;
    private do aM;
    private int aj;
    private int aq;
    private int br;
    private do cT;
    private boolean ca;
    private int cb;
    private int cn;
    private int dx;
    private boolean ef;
    private int ei;
    private int er;
    private byte[] et;
    private do fY;
    private int g3;
    private int gW;
    private int gn;
    private do hK;
    private int hz;
    private int j3;
    private by j6;
    private boolean jJ;
    private int jO;
    private do jw;
    private int k2;
    private boolean kQ;
    private do ko;
    private int lg;
    private int lp;
    private do mb;
    private do n5;
    private int nw;
    private dt oY;
    private do q7;
    private byte[] qp;
    private int rN;
    private int ro;
    private int sG;
    private int sh;
    private int sy;
    private byte[] tp;
    private int u7;
    private dw v5;
    private boolean vJ;
    private int vy;
    private do w9;
    private int wc;
    private String we;
    private byte[] x9;
    private boolean yO;
    private int yS;
    private dt ye;
    private int zh;

    public go() {
        this.j6 = new by();
        this.DW = new dt();
        this.FH = new dt();
        this.Hw = new dw();
        this.v5 = new dw();
        this.Zo = new dw();
        this.VH = new dw();
        this.tp = new byte[1000];
        this.aM = new do();
        this.Mr = new byte[1000];
        this.Sf = new byte[1000];
        this.x9 = new byte[1000];
        this.Qq = new do();
        this.et = new byte[1000];
        this.CU = new dn();
        this.oY = new dt();
        this.ko = new do();
        this.Ev = new do();
        this.ye = new dt();
        this.WB = new do();
        this.mb = new do();
        this.jw = new do();
        this.fY = new do();
        this.qp = new byte[1000];
        this.AL = new do();
        this.w9 = new do();
        this.hK = new do();
        this.cT = new do();
        this.q7 = new do();
        this.Z1 = new do();
        this.n5 = new do();
        this.Q6 = new do();
    }

    public void j6(OutputStream outputStream) {
        int i;
        int i2 = 0;
        fN();
        if (this.Xa && this.vy == -1) {
            this.vy = u7("RuntimeVisibleAnnotations");
        }
        if (this.Ws && this.cn == -1) {
            this.cn = u7("Deprecated");
        }
        if (this.U2 > 0) {
            this.SI = u7("InnerClasses");
        }
        if (this.cb != -1 && this.gW == -1) {
            this.gW = u7("Signature");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(-889275714);
        dataOutputStream.writeChar(this.lg);
        dataOutputStream.writeChar(this.a8);
        dataOutputStream.writeChar(this.gn + 1);
        dataOutputStream.write(this.tp, 0, this.u7);
        dataOutputStream.writeChar(this.J8);
        dataOutputStream.writeChar(this.QX);
        dataOutputStream.writeChar(this.XL);
        dataOutputStream.writeChar(this.aM.Hw());
        for (i = 0; i < this.aM.Hw(); i++) {
            dataOutputStream.writeChar(this.aM.FH(i));
        }
        dataOutputStream.writeChar(this.dx);
        dataOutputStream.write(this.Sf, 0, this.sG);
        dataOutputStream.writeChar(this.Mz);
        dataOutputStream.write(this.x9, 0, this.I);
        i = 1;
        if (this.Xa) {
            i = 2;
        }
        if (this.U2 > 0) {
            i++;
        }
        if (this.cb != -1) {
            i++;
        }
        if (this.Ws) {
            i++;
        }
        dataOutputStream.writeChar(i);
        dataOutputStream.writeChar(this.rN);
        dataOutputStream.writeInt(2);
        dataOutputStream.writeChar(this.j3);
        if (this.Ws) {
            dataOutputStream.writeChar(this.cn);
            dataOutputStream.writeInt(0);
        }
        if (this.U2 > 0) {
            dataOutputStream.writeChar(this.SI);
            dataOutputStream.writeInt(this.U2 + 2);
            dataOutputStream.writeChar(this.U2 / 8);
            dataOutputStream.write(this.Mr, 0, this.U2);
        }
        if (this.cb != -1) {
            dataOutputStream.writeChar(this.gW);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeChar(this.cb);
        }
        if (this.Xa) {
            dataOutputStream.writeChar(this.vy);
            dataOutputStream.writeInt(this.CU.DW());
            while (i2 < this.CU.DW()) {
                dataOutputStream.writeByte(this.CU.j6(i2));
                i2++;
            }
        }
    }

    public int j6() {
        return this.wc;
    }

    public void j6(String str, int i, char[] cArr, int i2, int i3, String str2, int i4, int i5) {
        this.j6.j6();
        this.DW.j6(100);
        this.FH.j6(30);
        this.Zo.j6(30);
        this.VH.j6(30);
        this.v5.j6(30);
        this.Hw.j6(60);
        this.lg = i5;
        this.a8 = i4;
        this.Xa = false;
        this.gn = 0;
        this.u7 = 0;
        this.Ws = false;
        if (i4 < 49) {
            i |= 32;
        }
        this.J8 = i;
        this.QX = a8(J8(cArr, i2, i3));
        this.XL = 0;
        this.aM.j6();
        this.j3 = u7(str);
        this.cb = -1;
        this.U2 = 0;
        this.J0 = str2;
        this.Mz = 0;
        this.I = 0;
        this.ca = false;
        this.ef = false;
        this.dx = 0;
        this.sG = 0;
        this.ef = false;
        this.rN = u7("SourceFile");
        this.aq = u7("Code");
        this.yS = u7("Exceptions");
        this.ei = u7("LineNumberTable");
        this.nw = u7("LocalVariableTable");
        this.ro = u7("ParameterTable");
        this.P8 = -1;
        this.SI = -1;
        this.gW = -1;
        this.cn = -1;
        this.BT = -1;
        this.er = -1;
        this.vy = -1;
        this.KD = -1;
    }

    public void j6(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6, int i7) {
        int i8 = this.U2 + 8;
        if (this.Mr.length <= i8) {
            Object obj = new byte[Math.max(i8, (this.Mr.length * 2) + 1)];
            System.arraycopy(this.Mr, 0, obj, 0, this.Mr.length);
            this.Mr = obj;
        }
        i8 = a8(J8(cArr, i, i2));
        int a8 = a8(J8(cArr2, i3, i4));
        int J8 = J8(cArr3, i5, i6);
        byte[] bArr = this.Mr;
        int i9 = this.U2;
        this.U2 = i9 + 1;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        bArr = this.Mr;
        i9 = this.U2;
        this.U2 = i9 + 1;
        bArr[i9] = (byte) ((i8 >>> 0) & 255);
        byte[] bArr2 = this.Mr;
        int i10 = this.U2;
        this.U2 = i10 + 1;
        bArr2[i10] = (byte) ((a8 >>> 8) & 255);
        bArr2 = this.Mr;
        i10 = this.U2;
        this.U2 = i10 + 1;
        bArr2[i10] = (byte) ((a8 >>> 0) & 255);
        bArr2 = this.Mr;
        a8 = this.U2;
        this.U2 = a8 + 1;
        bArr2[a8] = (byte) ((J8 >>> 8) & 255);
        bArr2 = this.Mr;
        a8 = this.U2;
        this.U2 = a8 + 1;
        bArr2[a8] = (byte) ((J8 >>> 0) & 255);
        bArr2 = this.Mr;
        a8 = this.U2;
        this.U2 = a8 + 1;
        bArr2[a8] = (byte) ((i7 >>> 8) & 255);
        bArr2 = this.Mr;
        a8 = this.U2;
        this.U2 = a8 + 1;
        bArr2[a8] = (byte) ((i7 >>> 0) & 255);
    }

    public void j6(char[] cArr, int i, int i2) {
        this.XL = a8(J8(cArr, i, i2));
    }

    public void j6(String str) {
        this.XL = a8(u7(str));
    }

    public void DW(char[] cArr, int i, int i2) {
        this.aM.DW(a8(J8(cArr, i, i2)));
    }

    public void j6(int i, String str, String str2, boolean z, boolean z2) {
        j6(i, str.toCharArray(), 0, str.length(), str2.toCharArray(), 0, str2.length(), z, z2);
    }

    public void j6(int i, String str, char[] cArr, int i2, int i3, boolean z, boolean z2) {
        j6(i, str.toCharArray(), 0, str.length(), cArr, i2, i3, z, z2);
    }

    public void j6(int i, char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5, boolean z, boolean z2) {
        fN();
        this.ef = true;
        this.vJ = z2;
        this.Xa = false;
        this.sh = -1;
        this.yO = z;
        this.dx++;
        int i6 = this.sG + 8;
        if (this.Sf.length <= i6) {
            Object obj = new byte[Math.max(i6, (this.Sf.length * 2) + 1)];
            System.arraycopy(this.Sf, 0, obj, 0, this.Sf.length);
            this.Sf = obj;
        }
        this.XG = false;
        byte[] bArr = this.Sf;
        int i7 = this.sG;
        this.sG = i7 + 1;
        bArr[i7] = (byte) ((i >>> 8) & 255);
        bArr = this.Sf;
        i7 = this.sG;
        this.sG = i7 + 1;
        bArr[i7] = (byte) ((i >>> 0) & 255);
        i6 = J8(cArr, i2, i3);
        byte[] bArr2 = this.Sf;
        int i8 = this.sG;
        this.sG = i8 + 1;
        bArr2[i8] = (byte) ((i6 >>> 8) & 255);
        bArr2 = this.Sf;
        i8 = this.sG;
        this.sG = i8 + 1;
        bArr2[i8] = (byte) ((i6 >>> 0) & 255);
        i6 = J8(cArr2, i4, i5);
        bArr2 = this.Sf;
        i8 = this.sG;
        this.sG = i8 + 1;
        bArr2[i8] = (byte) ((i6 >>> 8) & 255);
        bArr2 = this.Sf;
        i8 = this.sG;
        this.sG = i8 + 1;
        bArr2[i8] = (byte) ((i6 >>> 0) & 255);
    }

    public void j6(int i) {
        this.g3 = Mr(i);
    }

    public void j6(long j) {
        this.g3 = FH(j);
    }

    public void j6(float f) {
        this.g3 = FH(f);
    }

    public void j6(double d) {
        this.g3 = FH(d);
    }

    public void DW(String str) {
        this.g3 = U2(u7(str));
    }

    public void j6(int i, String str, char[] cArr, int i2, int i3, boolean z, boolean z2, boolean z3) {
        j6(i, str.toCharArray(), 0, str.length(), cArr, i2, i3, z, z2, z3);
    }

    public void j6(int i, String str, String str2, boolean z, boolean z2, boolean z3) {
        j6(i, str.toCharArray(), 0, str.length(), str2.toCharArray(), 0, str2.length(), z, z2, z3);
    }

    public void j6(int i, char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5, boolean z, boolean z2, boolean z3) {
        fN();
        this.ca = true;
        this.EQ = new String(cArr2, i4, i5);
        this.we = new String(cArr, i2, i3);
        this.br = Native.j6.d(J8(cArr, i2, i3));
        this.XX = J8(cArr2, i4, i5);
        this.OW = i;
        this.XG = false;
        this.sh = -1;
        this.Qq.j6();
        this.kQ = z3;
        this.yO = z;
        this.jJ = z2;
        this.lp = J0(cArr2, i4, i5);
        this.Xa = false;
        this.Eq = false;
        DW();
    }

    public void DW() {
        this.sy = 0;
        this.aj = 0;
        this.wc = 0;
        this.FN = 0;
        this.WB.j6();
        this.jw.j6();
        this.mb.j6();
        this.fY.j6();
        this.AL.j6();
        this.w9.j6();
        this.hK.j6();
        this.cT.j6();
        this.q7.j6();
        this.Z1.j6();
        this.n5.j6();
        this.Q6.j6();
        this.Ev.j6();
        this.ko.j6();
        this.oY.DW();
        this.ye.DW();
        this.k2 = 0;
        this.zh = -1;
    }

    public void FH() {
        if (!this.Xa) {
            this.CU.j6();
        }
        this.Eq = true;
        this.hz = this.CU.DW();
    }

    public void DW(int i) {
        this.Xa = true;
        this.CU.j6();
        this.CU.j6((byte) ((i >>> 8) & 255));
        this.CU.j6((byte) ((i >>> 0) & 255));
    }

    public void j6(char[] cArr, int i, int i2, int i3) {
        int J8 = J8(cArr, i, i2);
        this.CU.j6((byte) ((J8 >>> 8) & 255));
        this.CU.j6((byte) ((J8 >>> 0) & 255));
        this.CU.j6((byte) ((i3 >>> 8) & 255));
        this.CU.j6((byte) ((i3 >>> 0) & 255));
    }

    public void FH(char[] cArr, int i, int i2) {
        int J8 = J8(cArr, i, i2);
        this.CU.j6((byte) ((J8 >>> 8) & 255));
        this.CU.j6((byte) ((J8 >>> 0) & 255));
    }

    public void j6(char c, int i) {
        int Mr = Mr(i);
        this.CU.j6((byte) ((c >>> 0) & 255));
        this.CU.j6((byte) ((Mr >>> 8) & 255));
        this.CU.j6((byte) ((Mr >>> 0) & 255));
    }

    public void j6(char c, float f) {
        int FH = FH(f);
        this.CU.j6((byte) ((c >>> 0) & 255));
        this.CU.j6((byte) ((FH >>> 8) & 255));
        this.CU.j6((byte) ((FH >>> 0) & 255));
    }

    public void j6(char c, long j) {
        int FH = FH(j);
        this.CU.j6((byte) ((c >>> 0) & 255));
        this.CU.j6((byte) ((FH >>> 8) & 255));
        this.CU.j6((byte) ((FH >>> 0) & 255));
    }

    public void j6(char c, double d) {
        int FH = FH(d);
        this.CU.j6((byte) ((c >>> 0) & 255));
        this.CU.j6((byte) ((FH >>> 8) & 255));
        this.CU.j6((byte) ((FH >>> 0) & 255));
    }

    public void FH(String str) {
        int u7 = u7(str);
        this.CU.j6((byte) 115);
        this.CU.j6((byte) ((u7 >>> 8) & 255));
        this.CU.j6((byte) ((u7 >>> 0) & 255));
    }

    public void j6(char[] cArr, int i, int i2, String str) {
        int J8 = J8(cArr, i, i2);
        int u7 = u7(str);
        this.CU.j6((byte) 101);
        this.CU.j6((byte) ((J8 >>> 8) & 255));
        this.CU.j6((byte) ((J8 >>> 0) & 255));
        this.CU.j6((byte) ((u7 >>> 8) & 255));
        this.CU.j6((byte) ((u7 >>> 0) & 255));
    }

    public void FH(int i) {
        this.CU.j6((byte) 91);
        this.CU.j6((byte) ((i >>> 8) & 255));
        this.CU.j6((byte) ((i >>> 0) & 255));
    }

    public void Hw() {
        this.CU.j6((byte) 64);
    }

    public void Hw(char[] cArr, int i, int i2) {
        int J8 = J8(cArr, i, i2);
        this.CU.j6((byte) 99);
        this.CU.j6((byte) ((J8 >>> 8) & 255));
        this.CU.j6((byte) ((J8 >>> 0) & 255));
    }

    public void v5(char[] cArr, int i, int i2) {
        this.sh = J8(cArr, i, i2);
    }

    public void Zo(char[] cArr, int i, int i2) {
        this.cb = J8(cArr, i, i2);
    }

    public void VH(char[] cArr, int i, int i2) {
        this.Qq.DW(a8(J8(cArr, i, i2)));
    }

    public void j6(int i, int i2, char[] cArr, int i3, int i4, char[] cArr2, int i5, int i6) {
        int v5 = v5();
        v5(v5);
        this.AL.DW(v5);
        this.w9.DW(i);
        this.q7.DW(J8(cArr2, i5, i6));
        this.hK.DW(J8(cArr, i3, i4));
        this.cT.DW(i2);
    }

    public void j6(int i, char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5) {
        this.Q6.DW(J8(cArr2, i4, i5));
        this.Z1.DW(J8(cArr, i2, i3));
        this.n5.DW(i);
    }

    public void Hw(int i) {
        if (i != this.zh) {
            this.zh = i;
            int i2 = this.k2 + 4;
            if (this.qp.length <= i2) {
                Object obj = new byte[Math.max(i2, (this.qp.length * 2) + 1)];
                System.arraycopy(this.qp, 0, obj, 0, this.qp.length);
                this.qp = obj;
            }
            byte[] bArr = this.qp;
            int i3 = this.k2;
            this.k2 = i3 + 1;
            bArr[i3] = (byte) ((this.wc >>> 8) & 255);
            bArr = this.qp;
            i3 = this.k2;
            this.k2 = i3 + 1;
            bArr[i3] = (byte) ((this.wc >>> 0) & 255);
            bArr = this.qp;
            i3 = this.k2;
            this.k2 = i3 + 1;
            bArr[i3] = (byte) ((i >>> 8) & 255);
            bArr = this.qp;
            i3 = this.k2;
            this.k2 = i3 + 1;
            bArr[i3] = (byte) ((i >>> 0) & 255);
        }
    }

    public int v5() {
        int i = this.FN;
        this.FN = i + 1;
        return i;
    }

    public void v5(int i) {
        this.ye.j6(i, this.wc);
    }

    public void j6(int i, int i2) {
        int v5 = v5();
        v5(v5);
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        this.WB.DW(i);
        this.jw.DW(i2);
        this.mb.DW(v5);
        this.fY.DW(0);
    }

    public void j6(int i, int i2, char[] cArr, int i3, int i4) {
        int v5 = v5();
        v5(v5);
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        this.WB.DW(i);
        this.jw.DW(i2);
        this.mb.DW(v5);
        this.fY.DW(a8(J8(cArr, i3, i4)));
    }

    public void Zo() {
        j3(0);
    }

    public void j6(String str, int i) {
        DW(str.toCharArray(), 0, str.length(), i);
    }

    public void DW(char[] cArr, int i, int i2, int i3) {
        this.sy -= i3;
        this.sy++;
        char c = cArr[i + 1];
        if (c != '[' && c != 'L') {
            j3(188);
            switch (c) {
                case 'B':
                    j3(8);
                case 'C':
                    j3(5);
                case 'D':
                    j3(7);
                case 'F':
                    j3(6);
                case 'I':
                    j3(10);
                case 'J':
                    j3(11);
                case 'S':
                    j3(9);
                case 'Z':
                    j3(4);
                default:
            }
        } else if (i3 == 1) {
            j3(189);
            if (c == 'L') {
                r0 = a8(J8(cArr, i + 2, i2 - 3));
            } else {
                r0 = a8(J8(cArr, i + 1, i2 - 1));
            }
            j3((r0 >>> 8) & 255);
            j3((r0 >>> 0) & 255);
        } else {
            j3(197);
            r0 = a8(J8(cArr, i, i2));
            j3((r0 >>> 8) & 255);
            j3((r0 >>> 0) & 255);
            j3(i3);
        }
    }

    public void j6(String str, String str2, String str3) {
        this.sy -= VH(str3);
        j3(179);
        int VH = VH(a8(u7(str)), gn(u7(str2), u7(str3)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void j6(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy -= we(cArr3, i5, i6);
        j3(179);
        int VH = VH(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void DW(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy -= we(cArr3, i5, i6);
        this.sy--;
        j3(181);
        int VH = VH(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void j6(char[] cArr, int i, int i2, String str, char[] cArr2, int i3, int i4) {
        this.sy -= we(cArr2, i3, i4);
        this.sy--;
        j3(181);
        int VH = VH(a8(J8(cArr, i, i2)), gn(u7(str), J8(cArr2, i3, i4)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void DW(String str, String str2, String str3) {
        this.sy += VH(str3);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(178);
        int VH = VH(a8(u7(str)), gn(u7(str2), u7(str3)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void FH(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy += we(cArr3, i5, i6);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(178);
        int VH = VH(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void j6(char[] cArr, int i, int i2, String str, String str2) {
        this.sy += VH(str2);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(178);
        int VH = VH(a8(J8(cArr, i, i2)), gn(u7(str), u7(str2)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void DW(char[] cArr, int i, int i2, String str, char[] cArr2, int i3, int i4) {
        this.sy--;
        this.sy += we(cArr2, i3, i4);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(180);
        int VH = VH(a8(J8(cArr, i, i2)), gn(u7(str), J8(cArr2, i3, i4)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void Hw(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy--;
        this.sy += we(cArr3, i5, i6);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(180);
        int VH = VH(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((VH >>> 8) & 255);
        j3((VH >>> 0) & 255);
    }

    public void v5(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        int J0 = J0(cArr3, i5, i6);
        this.sy -= J0;
        this.sy--;
        this.sy += we(cArr3, i5, i6);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(185);
        int v5 = v5(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((v5 >>> 8) & 255);
        j3((v5 >>> 0) & 255);
        j3(J0 + 1);
        j3(0);
    }

    public void FH(String str, String str2, String str3) {
        int gn = gn(str3);
        this.sy -= gn;
        this.sy--;
        this.sy += VH(str3);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(185);
        int v5 = v5(a8(u7(str)), gn(u7(str2), u7(str3)));
        j3((v5 >>> 8) & 255);
        j3((v5 >>> 0) & 255);
        j3(gn + 1);
        j3(0);
    }

    public void Zo(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy -= J0(cArr3, i5, i6);
        this.sy += we(cArr3, i5, i6);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(184);
        int Zo = Zo(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void FH(char[] cArr, int i, int i2, String str, char[] cArr2, int i3, int i4) {
        this.sy -= J0(cArr2, i3, i4);
        this.sy += we(cArr2, i3, i4);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(184);
        int Zo = Zo(a8(J8(cArr, i, i2)), gn(u7(str), J8(cArr2, i3, i4)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void DW(char[] cArr, int i, int i2, String str, String str2) {
        this.sy -= gn(str2);
        this.sy += VH(str2);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(184);
        int Zo = Zo(a8(J8(cArr, i, i2)), gn(u7(str), u7(str2)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void Hw(String str, String str2, String str3) {
        this.sy -= gn(str3);
        this.sy += VH(str3);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(184);
        int Zo = Zo(a8(u7(str)), gn(u7(str2), u7(str3)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void Hw(char[] cArr, int i, int i2, String str, char[] cArr2, int i3, int i4) {
        this.sy -= J0(cArr2, i3, i4);
        this.sy--;
        this.sy += we(cArr2, i3, i4);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(183);
        int Zo = Zo(a8(J8(cArr, i, i2)), gn(u7(str), J8(cArr2, i3, i4)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void VH(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy -= J0(cArr3, i5, i6);
        this.sy--;
        this.sy += we(cArr3, i5, i6);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(182);
        int Zo = Zo(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void v5(String str, String str2, String str3) {
        this.sy -= gn(str3);
        this.sy--;
        this.sy += VH(str3);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(182);
        int Zo = Zo(a8(u7(str)), gn(u7(str2), u7(str3)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void Zo(String str, String str2, String str3) {
        this.sy -= gn(str3);
        this.sy--;
        this.sy += VH(str3);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(183);
        int Zo = Zo(a8(u7(str)), gn(u7(str2), u7(str3)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void gn(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
        this.sy -= J0(cArr3, i5, i6);
        this.sy--;
        this.sy += we(cArr3, i5, i6);
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(183);
        int Zo = Zo(a8(J8(cArr, i, i2)), gn(J8(cArr2, i3, i4), J8(cArr3, i5, i6)));
        j3((Zo >>> 8) & 255);
        j3((Zo >>> 0) & 255);
    }

    public void Hw(String str) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(187);
        int a8 = a8(u7(str));
        j3((a8 >>> 8) & 255);
        j3((a8 >>> 0) & 255);
    }

    public void gn(char[] cArr, int i, int i2) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(187);
        int a8 = a8(J8(cArr, i, i2));
        j3((a8 >>> 8) & 255);
        j3((a8 >>> 0) & 255);
    }

    public void v5(String str) {
        j3(192);
        int a8 = a8(u7(str));
        j3((a8 >>> 8) & 255);
        j3((a8 >>> 0) & 255);
    }

    public void u7(char[] cArr, int i, int i2) {
        j3(192);
        int a8 = a8(J8(cArr, i, i2));
        j3((a8 >>> 8) & 255);
        j3((a8 >>> 0) & 255);
    }

    public void tp(char[] cArr, int i, int i2) {
        j3(ProxyTextView.INPUTTYPE_textPhonetic);
        int a8 = a8(J8(cArr, i, i2));
        j3((a8 >>> 8) & 255);
        j3((a8 >>> 0) & 255);
    }

    public void VH() {
        j3(167);
        j3(0);
        j3(0);
    }

    public void gn() {
        j3(190);
    }

    public void u7() {
        this.sy--;
        j3(194);
    }

    public void tp() {
        this.sy--;
        j3(195);
    }

    public void Zo(int i) {
        j3(167);
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void j6(int i, int i2, int i3) {
        this.sy--;
        this.jO = this.wc;
        j3(170);
        int i4 = 4 - (this.wc % 4);
        if (i4 == 4) {
            i4 = 0;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            j3(0);
        }
        j3(0);
        j3(0);
        this.oY.j6(this.wc, this.jO);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
        j3((i2 >>> 24) & 255);
        j3((i2 >>> 16) & 255);
        j3((i2 >>> 8) & 255);
        j3((i2 >>> 0) & 255);
        j3((i3 >>> 24) & 255);
        j3((i3 >>> 16) & 255);
        j3((i3 >>> 8) & 255);
        j3((i3 >>> 0) & 255);
    }

    public void VH(int i) {
        j3(0);
        j3(0);
        this.oY.j6(this.wc, this.jO);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void DW(int i, int i2) {
        this.sy--;
        this.jO = this.wc;
        j3(171);
        int i3 = 4 - (this.wc % 4);
        if (i3 == 4) {
            i3 = 0;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            j3(0);
        }
        j3(0);
        j3(0);
        this.oY.j6(this.wc, this.jO);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
        j3((i2 >>> 24) & 255);
        j3((i2 >>> 16) & 255);
        j3((i2 >>> 8) & 255);
        j3((i2 >>> 0) & 255);
    }

    public void FH(int i, int i2) {
        j3((i >>> 24) & 255);
        j3((i >>> 16) & 255);
        j3((i >>> 8) & 255);
        j3((i >>> 0) & 255);
        j3(0);
        j3(0);
        this.oY.j6(this.wc, this.jO);
        this.Ev.DW(i2);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void j6(int i, boolean z) {
        this.sy--;
        if (z) {
            j3(154);
        } else {
            j3(153);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void DW(int i, boolean z) {
        this.sy--;
        if (z) {
            j3(198);
        } else {
            j3(199);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void FH(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(165);
        } else {
            j3(166);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void Hw(int i, boolean z) {
        FH(i, !z);
    }

    public void v5(int i, boolean z) {
        this.sy -= 4;
        j3(148);
        if (z) {
            j3(155);
        } else {
            j3(156);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void Zo(int i, boolean z) {
        v5(i, !z);
    }

    public void VH(int i, boolean z) {
        this.sy -= 4;
        j3(148);
        if (z) {
            j3(157);
        } else {
            j3(158);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void gn(int i, boolean z) {
        VH(i, !z);
    }

    public void u7(int i, boolean z) {
        tp(i, !z);
    }

    public void tp(int i, boolean z) {
        this.sy -= 4;
        j3(148);
        if (z) {
            j3(153);
        } else {
            j3(154);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void EQ(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(149);
            j3(155);
        } else {
            j3(150);
            j3(156);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void we(int i, boolean z) {
        EQ(i, !z);
    }

    public void J0(int i, boolean z) {
        J8(i, !z);
    }

    public void J8(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(149);
            j3(158);
        } else {
            j3(150);
            j3(157);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void Ws(int i, boolean z) {
        QX(i, !z);
    }

    public void QX(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(149);
            j3(153);
        } else {
            j3(150);
            j3(154);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void XL(int i, boolean z) {
        this.sy -= 4;
        if (z) {
            j3(151);
            j3(155);
        } else {
            j3(152);
            j3(156);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void aM(int i, boolean z) {
        XL(i, !z);
    }

    public void j3(int i, boolean z) {
        this.sy -= 4;
        if (z) {
            j3(151);
            j3(158);
        } else {
            j3(152);
            j3(157);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void Mr(int i, boolean z) {
        j3(i, !z);
    }

    public void U2(int i, boolean z) {
        a8(i, !z);
    }

    public void a8(int i, boolean z) {
        this.sy -= 4;
        if (z) {
            j3(152);
            j3(153);
        } else {
            j3(152);
            j3(154);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void lg(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(ProxyTextView.INPUTTYPE_textWebEditText);
        } else {
            j3(162);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void rN(int i, boolean z) {
        lg(i, !z);
    }

    public void er(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(164);
        } else {
            j3(163);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void yS(int i, boolean z) {
        er(i, !z);
    }

    public void gW(int i, boolean z) {
        BT(i, !z);
    }

    public void BT(int i, boolean z) {
        this.sy -= 2;
        if (z) {
            j3(159);
        } else {
            j3(160);
        }
        this.oY.j6(this.wc, this.wc - 1);
        this.Ev.DW(i);
        this.ko.DW(this.wc);
        j3(0);
        j3(0);
    }

    public void EQ() {
        this.sy--;
        j3(191);
    }

    public void we() {
        j3(ProxyTextView.INPUTTYPE_textFilter);
    }

    public void J0() {
        this.sy--;
        j3(172);
    }

    public void J8() {
        this.sy -= 2;
        j3(173);
    }

    public void Ws() {
        this.sy--;
        j3(174);
    }

    public void QX() {
        this.sy -= 2;
        j3(175);
    }

    public void XL() {
        this.sy--;
        j3(176);
    }

    public void aM() {
        j3(95);
    }

    public void j3() {
        this.sy--;
        j3(87);
    }

    public void Mr() {
        this.sy -= 2;
        j3(88);
    }

    public void U2() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(90);
    }

    public void a8() {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(93);
    }

    public void lg() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(91);
    }

    public void rN() {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(94);
    }

    public void er() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(89);
    }

    public void yS() {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(92);
    }

    public void gW() {
        this.sy -= 3;
        j3(79);
    }

    public void BT() {
        this.sy -= 4;
        j3(80);
    }

    public void vy() {
        this.sy -= 3;
        j3(81);
    }

    public void P8() {
        this.sy -= 4;
        j3(82);
    }

    public void ei() {
        this.sy -= 3;
        j3(83);
    }

    public void nw() {
        this.sy -= 3;
        j3(84);
    }

    public void SI() {
        this.sy -= 3;
        j3(85);
    }

    public void KD() {
        this.sy -= 3;
        j3(86);
    }

    public void ro() {
        this.sy--;
        j3(46);
    }

    public void cn() {
        j3(47);
    }

    public void sh() {
        this.sy--;
        j3(48);
    }

    public void cb() {
        j3(49);
    }

    public void dx() {
        this.sy--;
        j3(50);
    }

    public void sG() {
        this.sy--;
        j3(51);
    }

    public void ef() {
        this.sy--;
        j3(52);
    }

    public void Sf() {
        this.sy--;
        j3(53);
    }

    public void DW(float f) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (((double) f) == 0.0d && (Float.floatToIntBits(f) & Integer.MIN_VALUE) == 0) {
            j3(11);
        } else if (((double) f) == 1.0d) {
            j3(12);
        } else if (((double) f) == 2.0d) {
            j3(13);
        } else {
            int FH = FH(f);
            if (FH <= 255) {
                j3(18);
                j3(FH);
                return;
            }
            j3(19);
            j3((FH >>> 8) & 255);
            j3((FH >>> 0) & 255);
        }
    }

    public void DW(double d) {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (d == 0.0d && (Double.doubleToLongBits(d) & Long.MIN_VALUE) == 0) {
            j3(14);
        } else if (d == 1.0d) {
            j3(15);
        } else {
            int FH = FH(d);
            j3(20);
            j3((FH >>> 8) & 255);
            j3((FH >>> 0) & 255);
        }
    }

    public void DW(long j) {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (j == 0) {
            j3(9);
        } else if (j == 1) {
            j3(10);
        } else {
            int FH = FH(j);
            j3(20);
            j3((FH >>> 8) & 255);
            j3((FH >>> 0) & 255);
        }
    }

    public void vJ() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(1);
    }

    public void EQ(char[] cArr, int i, int i2) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        int U2 = U2(J8(cArr, i, i2));
        if (U2 <= 255) {
            j3(18);
            j3(U2);
            return;
        }
        j3(19);
        j3((U2 >>> 8) & 255);
        j3((U2 >>> 0) & 255);
    }

    public void Zo(String str) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        int U2 = U2(u7(str));
        if (U2 <= 255) {
            j3(18);
            j3(U2);
            return;
        }
        j3(19);
        j3((U2 >>> 8) & 255);
        j3((U2 >>> 0) & 255);
    }

    public void gn(int i) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        switch (i) {
            case -1:
                j3(2);
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(3);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(4);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(5);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(6);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j3(7);
            case 5:
                j3(8);
            default:
                if (i >= -128 && i <= 127) {
                    j3(16);
                    j3(i);
                } else if (i > 32767 || i < -32768) {
                    int Mr = Mr(i);
                    if (Mr <= 255) {
                        j3(18);
                        j3(Mr);
                        return;
                    }
                    j3(19);
                    j3((Mr >>> 8) & 255);
                    j3((Mr >>> 0) & 255);
                } else {
                    j3(17);
                    j3((i >>> 8) & 255);
                    j3((i >>> 0) & 255);
                }
        }
    }

    public void g3() {
        this.sy--;
        j3(96);
    }

    public void Mz() {
        this.sy--;
        j3(126);
    }

    public void I() {
        this.sy--;
        j3(108);
    }

    public void ca() {
        this.sy--;
        j3(104);
    }

    public void x9() {
        j3(116);
    }

    public void Qq() {
        this.sy--;
        j3(128);
    }

    public void sy() {
        this.sy--;
        j3(112);
    }

    public void aj() {
        this.sy--;
        j3(120);
    }

    public void lp() {
        this.sy--;
        j3(122);
    }

    public void OW() {
        this.sy--;
        j3(100);
    }

    public void br() {
        this.sy--;
        j3(124);
    }

    public void XX() {
        this.sy--;
        j3(130);
    }

    public void kQ() {
        this.sy -= 2;
        j3(97);
    }

    public void yO() {
        this.sy -= 2;
        j3(127);
    }

    public void XG() {
        this.sy -= 2;
        j3(109);
    }

    public void jJ() {
        this.sy -= 2;
        j3(105);
    }

    public void wc() {
        j3(117);
    }

    public void et() {
        this.sy -= 2;
        j3(ProxyTextView.INPUTTYPE_textPassword);
    }

    public void CU() {
        this.sy -= 2;
        j3(ProxyTextView.INPUTTYPE_textPostalAddress);
    }

    public void Xa() {
        this.sy--;
        j3(121);
    }

    public void Eq() {
        this.sy--;
        j3(123);
    }

    public void hz() {
        this.sy -= 2;
        j3(101);
    }

    public void aq() {
        this.sy--;
        j3(125);
    }

    public void FN() {
        this.sy -= 2;
        j3(131);
    }

    public void jO() {
        this.sy--;
        j3(98);
    }

    public void oY() {
        this.sy--;
        j3(110);
    }

    public void ko() {
        this.sy--;
        j3(106);
    }

    public void Ev() {
        j3(118);
    }

    public void ye() {
        this.sy--;
        j3(114);
    }

    public void WB() {
        this.sy--;
        j3(102);
    }

    public void mb() {
        this.sy -= 2;
        j3(99);
    }

    public void jw() {
        this.sy -= 2;
        j3(111);
    }

    public void fY() {
        this.sy -= 2;
        j3(107);
    }

    public void qp() {
        j3(119);
    }

    public void k2() {
        this.sy -= 2;
        j3(115);
    }

    public void zh() {
        this.sy -= 2;
        j3(103);
    }

    public void AL() {
        this.sy--;
        j3(144);
    }

    public void w9() {
        this.sy--;
        j3(142);
    }

    public void hK() {
        j3(143);
    }

    public void cT() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(141);
    }

    public void q7() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(140);
    }

    public void Z1() {
        j3(139);
    }

    public void n5() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(135);
    }

    public void Q6() {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        j3(133);
    }

    public void kf() {
        j3(ProxyTextView.INPUTTYPE_textVisiblePassword);
    }

    public void Jl() {
        j3(146);
    }

    public void iW() {
        j3(134);
    }

    public void eU() {
        j3(147);
    }

    public void e3() {
        j3(138);
    }

    public void sE() {
        this.sy--;
        j3(137);
    }

    public void sg() {
        this.sy--;
        j3(136);
    }

    public void u7(int i) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (i >= this.lp) {
            this.lp = i;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(42);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(43);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(44);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(45);
            default:
                if (i <= 255) {
                    j3(25);
                    j3(i);
                    return;
                }
                j3(196);
                j3(25);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void tp(int i) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (i >= this.lp) {
            this.lp = i;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(26);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(27);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(28);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(29);
            default:
                if (i <= 255) {
                    j3(21);
                    j3(i);
                    return;
                }
                j3(196);
                j3(21);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void EQ(int i) {
        this.sy++;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (i >= this.lp) {
            this.lp = i;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(34);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(35);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(36);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(37);
            default:
                if (i <= 255) {
                    j3(23);
                    j3(i);
                    return;
                }
                j3(196);
                j3(23);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void we(int i) {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (i + 1 >= this.lp) {
            this.lp = i + 1;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(38);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(39);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(40);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(41);
            default:
                if (i <= 255) {
                    j3(24);
                    j3(i);
                    return;
                }
                j3(196);
                j3(24);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void J0(int i) {
        this.sy += 2;
        if (this.sy > this.aj) {
            this.aj = this.sy;
        }
        if (i + 1 >= this.lp) {
            this.lp = i + 1;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(30);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(31);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(32);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(33);
            default:
                if (i <= 255) {
                    j3(22);
                    j3(i);
                    return;
                }
                j3(196);
                j3(22);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void J8(int i) {
        this.sy--;
        if (i >= this.lp) {
            this.lp = i;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(75);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(76);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(77);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(78);
            default:
                if (i <= 255) {
                    j3(58);
                    j3(i);
                    return;
                }
                j3(196);
                j3(58);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void Hw(int i, int i2) {
        if (i >= this.lp) {
            this.lp = i;
        }
        if (i2 >= -128 && i2 <= 127 && i <= 255) {
            j3(132);
            j3(i);
            j3(i2);
        } else if (i2 > 32767 || i2 < -32768 || i > 65535) {
            tp(i);
            gn(i2);
            g3();
            Ws(i);
        } else {
            j3(196);
            j3(132);
            j3((i >>> 8) & 255);
            j3((i >>> 0) & 255);
            j3((i2 >>> 8) & 255);
            j3((i2 >>> 0) & 255);
        }
    }

    public void Ws(int i) {
        this.sy--;
        if (i >= this.lp) {
            this.lp = i;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(59);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(60);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(61);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(62);
            default:
                if (i <= 255) {
                    j3(54);
                    j3(i);
                    return;
                }
                j3(196);
                j3(54);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void QX(int i) {
        this.sy--;
        if (i >= this.lp) {
            this.lp = i;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(67);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(68);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(69);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(70);
            default:
                if (i <= 255) {
                    j3(56);
                    j3(i);
                    return;
                }
                j3(196);
                j3(56);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void XL(int i) {
        this.sy -= 2;
        if (i + 1 >= this.lp) {
            this.lp = i + 1;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(63);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(64);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(65);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(66);
            default:
                if (i <= 255) {
                    j3(55);
                    j3(i);
                    return;
                }
                j3(196);
                j3(55);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void aM(int i) {
        this.sy -= 2;
        if (i + 1 >= this.lp) {
            this.lp = i + 1;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j3(71);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j3(72);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j3(73);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j3(74);
            default:
                if (i <= 255) {
                    j3(57);
                    j3(i);
                    return;
                }
                j3(196);
                j3(57);
                j3((i >>> 8) & 255);
                j3((i >>> 0) & 255);
        }
    }

    public void pO() {
        fN();
        this.Xa = false;
    }

    private void j3(int i) {
        if (this.wc >= this.et.length) {
            Object obj = new byte[((this.et.length * 2) + 1)];
            System.arraycopy(this.et, 0, obj, 0, this.et.length);
            this.et = obj;
        }
        byte[] bArr = this.et;
        int i2 = this.wc;
        this.wc = i2 + 1;
        bArr[i2] = (byte) i;
    }

    private void fN() {
        int i = 1;
        int i2 = 0;
        int i3;
        Object obj;
        int i4;
        byte[] bArr;
        byte[] bArr2;
        int i5;
        int i6;
        if (this.ef) {
            this.ef = false;
            if (this.vJ) {
                i3 = 10;
            } else {
                i3 = 2;
            }
            if (this.yO) {
                i3 += 6;
            }
            if (this.XG) {
                i3 += 6;
            }
            if (this.sh != -1) {
                i3 += 8;
            }
            if (this.Xa) {
                i3 += this.CU.DW() + 6;
            }
            i3 += this.sG;
            if (this.Sf.length <= i3) {
                obj = new byte[Math.max(i3, (this.Sf.length * 2) + 1)];
                System.arraycopy(this.Sf, 0, obj, 0, this.Sf.length);
                this.Sf = obj;
            }
            if (this.vJ) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.yO) {
                i3++;
            }
            if (this.XG) {
                i3++;
            }
            if (this.Xa) {
                i3++;
            }
            if (this.sh != -1) {
                i3++;
            }
            byte[] bArr3 = this.Sf;
            i4 = this.sG;
            this.sG = i4 + 1;
            bArr3[i4] = (byte) ((i3 >>> 8) & 255);
            bArr3 = this.Sf;
            i4 = this.sG;
            this.sG = i4 + 1;
            bArr3[i4] = (byte) ((i3 >>> 0) & 255);
            if (this.yO) {
                if (this.P8 == -1) {
                    this.P8 = u7("Synthetic");
                }
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.P8 >>> 8) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.P8 >>> 0) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
            }
            if (this.Xa) {
                if (this.vy == -1) {
                    this.vy = u7("RuntimeVisibleAnnotations");
                }
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.vy >>> 8) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.vy >>> 0) & 255);
                i = this.CU.DW();
                bArr = this.Sf;
                i4 = this.sG;
                this.sG = i4 + 1;
                bArr[i4] = (byte) ((i >>> 24) & 255);
                bArr = this.Sf;
                i4 = this.sG;
                this.sG = i4 + 1;
                bArr[i4] = (byte) ((i >>> 16) & 255);
                bArr = this.Sf;
                i4 = this.sG;
                this.sG = i4 + 1;
                bArr[i4] = (byte) ((i >>> 8) & 255);
                bArr = this.Sf;
                i4 = this.sG;
                this.sG = i4 + 1;
                bArr[i4] = (byte) ((i >>> 0) & 255);
                for (i3 = 0; i3 < i; i3++) {
                    bArr2 = this.Sf;
                    i5 = this.sG;
                    this.sG = i5 + 1;
                    bArr2[i5] = this.CU.j6(i3);
                }
            }
            if (this.XG) {
                if (this.cn == -1) {
                    this.cn = u7("Deprecated");
                }
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.cn >>> 8) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.cn >>> 0) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
            }
            if (this.vJ) {
                if (this.er == -1) {
                    this.er = u7("ConstantValue");
                }
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.er >>> 8) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.er >>> 0) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 2;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.g3 >>> 8) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.g3 >>> 0) & 255);
            }
            if (this.sh != -1) {
                if (this.gW == -1) {
                    this.gW = u7("Signature");
                }
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.gW >>> 8) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) ((this.gW >>> 0) & 255);
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 0;
                bArr = this.Sf;
                i = this.sG;
                this.sG = i + 1;
                bArr[i] = (byte) 2;
                bArr = this.Sf;
                i6 = this.sG;
                this.sG = i6 + 1;
                bArr[i6] = (byte) ((this.sh >>> 8) & 255);
                bArr = this.Sf;
                i6 = this.sG;
                this.sG = i6 + 1;
                bArr[i6] = (byte) ((this.sh >>> 0) & 255);
            }
        } else if (this.ca) {
            int i7;
            byte[] bArr4;
            byte[] bArr5;
            int i8;
            this.ca = false;
            this.Mz++;
            i3 = 0;
            while (i3 < this.WB.Hw()) {
                if (this.ye.Hw(this.WB.FH(i3)) == this.ye.Hw(this.jw.FH(i3))) {
                    this.WB.v5(i3);
                    this.jw.v5(i3);
                    this.mb.v5(i3);
                    this.fY.v5(i3);
                    i3--;
                }
                i3++;
            }
            if (this.Qq.Hw() > 0) {
                i3 = ((this.Qq.Hw() * 2) + 8) + 2;
            } else {
                i3 = 2;
            }
            if (this.kQ) {
                i3 += (this.wc + 18) + (this.WB.Hw() * 8);
            }
            if (this.Xa || this.Eq) {
                i3 += this.CU.DW() + 6;
            }
            if (this.yO) {
                i3 += 6;
            }
            if (this.jJ) {
                i3 += 6;
            }
            if (this.XG) {
                i3 += 6;
            }
            if (this.kQ && this.zh != -1) {
                i3 += this.k2 + 8;
            }
            if (this.cT.Hw() > 0) {
                i3 += (this.cT.Hw() * 10) + 8;
            }
            if (this.n5.Hw() > 0) {
                i3 += (this.n5.Hw() * 10) + 8;
            }
            if (this.sh != -1) {
                i3 += 8;
            }
            i3 = (i3 + 6) + this.I;
            if (this.x9.length <= i3) {
                obj = new byte[Math.max(i3, (this.x9.length * 2) + 1)];
                System.arraycopy(this.x9, 0, obj, 0, this.x9.length);
                this.x9 = obj;
            }
            bArr = this.x9;
            i4 = this.I;
            this.I = i4 + 1;
            bArr[i4] = (byte) ((this.OW >>> 8) & 255);
            bArr = this.x9;
            i4 = this.I;
            this.I = i4 + 1;
            bArr[i4] = (byte) ((this.OW >>> 0) & 255);
            bArr = this.x9;
            i4 = this.I;
            this.I = i4 + 1;
            bArr[i4] = (byte) ((this.br >>> 8) & 255);
            bArr = this.x9;
            i4 = this.I;
            this.I = i4 + 1;
            bArr[i4] = (byte) ((this.br >>> 0) & 255);
            bArr = this.x9;
            i4 = this.I;
            this.I = i4 + 1;
            bArr[i4] = (byte) ((this.XX >>> 8) & 255);
            bArr = this.x9;
            i4 = this.I;
            this.I = i4 + 1;
            bArr[i4] = (byte) ((this.XX >>> 0) & 255);
            if (this.kQ) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.Xa) {
                i3++;
            }
            if (this.Eq) {
                i3++;
            }
            if (this.yO) {
                i3++;
            }
            if (this.jJ) {
                i3++;
            }
            if (this.XG) {
                i3++;
            }
            if (this.Qq.Hw() > 0) {
                i3++;
            }
            if (this.n5.Hw() > 0) {
                i3++;
            }
            if (this.sh != -1) {
                i3++;
            }
            bArr2 = this.x9;
            i5 = this.I;
            this.I = i5 + 1;
            bArr2[i5] = (byte) ((i3 >>> 8) & 255);
            bArr2 = this.x9;
            i5 = this.I;
            this.I = i5 + 1;
            bArr2[i5] = (byte) ((i3 >>> 0) & 255);
            if (this.yO) {
                if (this.P8 == -1) {
                    this.P8 = u7("Synthetic");
                }
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.P8 >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.P8 >>> 0) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
            }
            if (this.Xa) {
                if (this.vy == -1) {
                    this.vy = u7("RuntimeVisibleAnnotations");
                }
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.vy >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.vy >>> 0) & 255);
                i3 = this.CU.DW();
                if (this.Eq) {
                    i3 = this.hz;
                }
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 24) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 16) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 8) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 0) & 255);
                for (i4 = 0; i4 < i3; i4++) {
                    byte[] bArr6 = this.x9;
                    i7 = this.I;
                    this.I = i7 + 1;
                    bArr6[i7] = this.CU.j6(i4);
                }
            }
            if (this.Eq) {
                if (this.KD == -1) {
                    this.KD = u7("AnnotationDefault");
                }
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.KD >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.KD >>> 0) & 255);
                i3 = this.CU.DW() - this.hz;
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 24) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 16) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 8) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 0) & 255);
                for (i3 = this.hz; i3 < this.CU.DW(); i3++) {
                    bArr2 = this.x9;
                    i5 = this.I;
                    this.I = i5 + 1;
                    bArr2[i5] = this.CU.j6(i3);
                }
            }
            if (this.jJ) {
                if (this.BT == -1) {
                    this.BT = u7("Varargs");
                }
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.BT >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.BT >>> 0) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
            }
            if (this.XG) {
                if (this.cn == -1) {
                    this.cn = u7("Deprecated");
                }
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.cn >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.cn >>> 0) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
            }
            if (this.Qq.Hw() > 0) {
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.yS >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.yS >>> 0) & 255);
                i3 = (this.Qq.Hw() * 2) + 2;
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 24) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 16) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 8) & 255);
                bArr2 = this.x9;
                i5 = this.I;
                this.I = i5 + 1;
                bArr2[i5] = (byte) ((i3 >>> 0) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.Qq.Hw() >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.Qq.Hw() >>> 0) & 255);
                for (i3 = 0; i3 < this.Qq.Hw(); i3++) {
                    bArr2 = this.x9;
                    i5 = this.I;
                    this.I = i5 + 1;
                    bArr2[i5] = (byte) ((this.Qq.FH(i3) >>> 8) & 255);
                    bArr2 = this.x9;
                    i5 = this.I;
                    this.I = i5 + 1;
                    bArr2[i5] = (byte) ((this.Qq.FH(i3) >>> 0) & 255);
                }
            }
            if (this.sh != -1) {
                if (this.gW == -1) {
                    this.gW = u7("Signature");
                }
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.gW >>> 8) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) ((this.gW >>> 0) & 255);
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 0;
                bArr = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr[i4] = (byte) 2;
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.sh >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.sh >>> 0) & 255);
            }
            if (this.n5.Hw() > 0) {
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.ro >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.ro >>> 0) & 255);
                i3 = (this.n5.Hw() * 10) + 2;
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 24) & 255);
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 16) & 255);
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 8) & 255);
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 0) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.n5.Hw() >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.n5.Hw() >>> 0) & 255);
                for (i3 = 0; i3 < this.n5.Hw(); i3++) {
                    i6 = this.n5.FH(i3);
                    i4 = this.Z1.FH(i3);
                    i5 = this.Q6.FH(i3);
                    bArr5 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr5[i8] = (byte) null;
                    bArr5 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr5[i8] = (byte) null;
                    bArr5 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr5[i8] = (byte) null;
                    bArr5 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr5[i8] = (byte) null;
                    bArr5 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr5[i8] = (byte) ((i4 >>> 8) & 255);
                    bArr5 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr5[i8] = (byte) ((i4 >>> 0) & 255);
                    bArr2 = this.x9;
                    i7 = this.I;
                    this.I = i7 + 1;
                    bArr2[i7] = (byte) ((i5 >>> 8) & 255);
                    bArr2 = this.x9;
                    i7 = this.I;
                    this.I = i7 + 1;
                    bArr2[i7] = (byte) ((i5 >>> 0) & 255);
                    bArr2 = this.x9;
                    i5 = this.I;
                    this.I = i5 + 1;
                    bArr2[i5] = (byte) ((i6 >>> 8) & 255);
                    bArr2 = this.x9;
                    i5 = this.I;
                    this.I = i5 + 1;
                    bArr2[i5] = (byte) ((i6 >>> 0) & 255);
                }
            }
            if (this.kQ) {
                for (i3 = 0; i3 < this.Ev.Hw(); i3++) {
                    i6 = this.ko.FH(i3);
                    i4 = this.ye.Hw(this.Ev.FH(i3)) - this.oY.Hw(i6);
                    this.et[i6] = (byte) ((i4 >>> 8) & 255);
                    this.et[i6 + 1] = (byte) ((i4 >>> 0) & 255);
                }
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.aq >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.aq >>> 0) & 255);
                i3 = (this.wc + 12) + (this.WB.Hw() * 8);
                if (this.zh != -1) {
                    i3 += this.k2 + 8;
                }
                if (this.cT.Hw() > 0) {
                    i3 += (this.cT.Hw() * 10) + 8;
                }
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 24) & 255);
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 16) & 255);
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 8) & 255);
                bArr4 = this.x9;
                i4 = this.I;
                this.I = i4 + 1;
                bArr4[i4] = (byte) ((i3 >>> 0) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.aj >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.aj >>> 0) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) (((this.lp + 2) >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) (((this.lp + 2) >>> 0) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.wc >>> 24) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.wc >>> 16) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.wc >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.wc >>> 0) & 255);
                System.arraycopy(this.et, 0, this.x9, this.I, this.wc);
                this.I += this.wc;
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.WB.Hw() >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((this.WB.Hw() >>> 0) & 255);
                for (i3 = 0; i3 < this.WB.Hw(); i3++) {
                    i6 = this.ye.Hw(this.WB.FH(i3));
                    i4 = this.ye.Hw(this.jw.FH(i3));
                    i5 = this.ye.Hw(this.mb.FH(i3));
                    i7 = this.fY.FH(i3);
                    byte[] bArr7 = this.x9;
                    int i9 = this.I;
                    this.I = i9 + 1;
                    bArr7[i9] = (byte) ((i6 >>> 8) & 255);
                    bArr7 = this.x9;
                    i9 = this.I;
                    this.I = i9 + 1;
                    bArr7[i9] = (byte) ((i6 >>> 0) & 255);
                    bArr4 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr4[i8] = (byte) ((i4 >>> 8) & 255);
                    bArr4 = this.x9;
                    i8 = this.I;
                    this.I = i8 + 1;
                    bArr4[i8] = (byte) ((i4 >>> 0) & 255);
                    bArr4 = this.x9;
                    i4 = this.I;
                    this.I = i4 + 1;
                    bArr4[i4] = (byte) ((i5 >>> 8) & 255);
                    bArr4 = this.x9;
                    i4 = this.I;
                    this.I = i4 + 1;
                    bArr4[i4] = (byte) ((i5 >>> 0) & 255);
                    bArr4 = this.x9;
                    i4 = this.I;
                    this.I = i4 + 1;
                    bArr4[i4] = (byte) ((i7 >>> 8) & 255);
                    bArr4 = this.x9;
                    i4 = this.I;
                    this.I = i4 + 1;
                    bArr4[i4] = (byte) ((i7 >>> 0) & 255);
                }
                if (this.zh == -1) {
                    i = 0;
                }
                if (this.cT.Hw() > 0) {
                    i++;
                }
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((i >>> 8) & 255);
                bArr = this.x9;
                i6 = this.I;
                this.I = i6 + 1;
                bArr[i6] = (byte) ((i >>> 0) & 255);
                if (this.zh != -1) {
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) ((this.ei >>> 8) & 255);
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) ((this.ei >>> 0) & 255);
                    i3 = this.k2 + 2;
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 24) & 255);
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 16) & 255);
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 8) & 255);
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 0) & 255);
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) (((this.k2 / 4) >>> 8) & 255);
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) (((this.k2 / 4) >>> 0) & 255);
                    System.arraycopy(this.qp, 0, this.x9, this.I, this.k2);
                    this.I += this.k2;
                }
                if (this.cT.Hw() > 0) {
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) ((this.nw >>> 8) & 255);
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) ((this.nw >>> 0) & 255);
                    i3 = (this.cT.Hw() * 10) + 2;
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 24) & 255);
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 16) & 255);
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 8) & 255);
                    bArr4 = this.x9;
                    i = this.I;
                    this.I = i + 1;
                    bArr4[i] = (byte) ((i3 >>> 0) & 255);
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) ((this.cT.Hw() >>> 8) & 255);
                    bArr = this.x9;
                    i6 = this.I;
                    this.I = i6 + 1;
                    bArr[i6] = (byte) ((this.cT.Hw() >>> 0) & 255);
                    while (i2 < this.cT.Hw()) {
                        i3 = this.ye.Hw(this.AL.FH(i2));
                        i6 = this.ye.Hw(this.w9.FH(i2)) - i3;
                        i = this.cT.FH(i2);
                        i4 = this.hK.FH(i2);
                        i5 = this.q7.FH(i2);
                        bArr5 = this.x9;
                        i8 = this.I;
                        this.I = i8 + 1;
                        bArr5[i8] = (byte) ((i3 >>> 8) & 255);
                        bArr5 = this.x9;
                        i8 = this.I;
                        this.I = i8 + 1;
                        bArr5[i8] = (byte) ((i3 >>> 0) & 255);
                        bArr = this.x9;
                        i7 = this.I;
                        this.I = i7 + 1;
                        bArr[i7] = (byte) ((i6 >>> 8) & 255);
                        bArr = this.x9;
                        i7 = this.I;
                        this.I = i7 + 1;
                        bArr[i7] = (byte) ((i6 >>> 0) & 255);
                        bArr = this.x9;
                        i6 = this.I;
                        this.I = i6 + 1;
                        bArr[i6] = (byte) ((i4 >>> 8) & 255);
                        bArr = this.x9;
                        i6 = this.I;
                        this.I = i6 + 1;
                        bArr[i6] = (byte) ((i4 >>> 0) & 255);
                        bArr = this.x9;
                        i6 = this.I;
                        this.I = i6 + 1;
                        bArr[i6] = (byte) ((i5 >>> 8) & 255);
                        bArr = this.x9;
                        i6 = this.I;
                        this.I = i6 + 1;
                        bArr[i6] = (byte) ((i5 >>> 0) & 255);
                        bArr = this.x9;
                        i6 = this.I;
                        this.I = i6 + 1;
                        bArr[i6] = (byte) ((i >>> 8) & 255);
                        bArr = this.x9;
                        i6 = this.I;
                        this.I = i6 + 1;
                        bArr[i6] = (byte) ((i >>> 0) & 255);
                        i2++;
                    }
                }
            }
        }
    }

    private int VH(String str) {
        int length = str.length();
        if (str.charAt(length - 1) == 'V') {
            return 0;
        }
        if (str.charAt(length - 1) == 'D' && (length == 1 || str.charAt(length - 2) != '[')) {
            return 2;
        }
        if (str.charAt(length - 1) != 'J' || (length != 1 && str.charAt(length - 2) == '[')) {
            return 1;
        }
        return 2;
    }

    private int we(char[] cArr, int i, int i2) {
        if (cArr[(i + i2) - 1] == 'V') {
            return 0;
        }
        if (cArr[(i + i2) - 1] == 'D' && (i2 == 1 || cArr[(i + i2) - 2] != '[')) {
            return 2;
        }
        if (cArr[(i + i2) - 1] != 'J' || (i2 != 1 && cArr[(i + i2) - 2] == '[')) {
            return 1;
        }
        return 2;
    }

    private int J0(char[] cArr, int i, int i2) {
        int i3 = 0;
        int i4 = i + 1;
        while (cArr[i4] != ')') {
            switch (cArr[i4]) {
                case 'D':
                case 'J':
                    i3 += 2;
                    break;
                case 'L':
                    i3++;
                    while (cArr[i4] != ';') {
                        i4++;
                    }
                    break;
                case '[':
                    i3++;
                    while (cArr[i4] == '[') {
                        i4++;
                    }
                    if (cArr[i4] != 'L') {
                        break;
                    }
                    while (cArr[i4] != ';') {
                        i4++;
                    }
                    break;
                default:
                    i3++;
                    break;
            }
            i4++;
        }
        return i3;
    }

    private int gn(String str) {
        int i = 0;
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            switch (str.charAt(i2)) {
                case 'D':
                case 'J':
                    i += 2;
                    break;
                case 'L':
                    i++;
                    while (str.charAt(i2) != ';') {
                        i2++;
                    }
                    break;
                case '[':
                    i++;
                    while (str.charAt(i2) == '[') {
                        i2++;
                    }
                    if (str.charAt(i2) != 'L') {
                        break;
                    }
                    while (str.charAt(i2) != ';') {
                        i2++;
                    }
                    break;
                default:
                    i++;
                    break;
            }
            i2++;
        }
        return i;
    }

    private int FH(long j) {
        int i = this.u7 + 9;
        if (this.tp.length <= i) {
            Object obj = new byte[Math.max(i, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) 5;
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 56) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 40) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 32) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 24) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 16) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 8) & 255));
        bArr = this.tp;
        i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 0) & 255));
        i = this.gn + 1;
        this.gn = i;
        this.gn++;
        return i;
    }

    private int FH(double d) {
        int i = this.u7 + 9;
        if (this.tp.length <= i) {
            Object obj = new byte[Math.max(i, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) 6;
        long doubleToLongBits = Double.doubleToLongBits(d);
        byte[] bArr2 = this.tp;
        int i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 56) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 48) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 40) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 32) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 24) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 16) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 8) & 255));
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((int) ((doubleToLongBits >>> 0) & 255));
        i = this.gn + 1;
        this.gn = i;
        this.gn++;
        return i;
    }

    private int Mr(int i) {
        int i2 = this.u7 + 5;
        if (this.tp.length <= i2) {
            Object obj = new byte[Math.max(i2, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) 3;
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 24) & 255);
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 0) & 255);
        i2 = this.gn + 1;
        this.gn = i2;
        return i2;
    }

    private int U2(int i) {
        int i2 = this.u7 + 3;
        if (this.tp.length <= i2) {
            Object obj = new byte[Math.max(i2, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) 8;
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 0) & 255);
        i2 = this.gn + 1;
        this.gn = i2;
        return i2;
    }

    private int FH(float f) {
        int i = this.u7 + 5;
        if (this.tp.length <= i) {
            Object obj = new byte[Math.max(i, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i2 = this.u7;
        this.u7 = i2 + 1;
        bArr[i2] = (byte) 4;
        i = Float.floatToIntBits(f);
        byte[] bArr2 = this.tp;
        int i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((i >>> 24) & 255);
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((i >>> 16) & 255);
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((i >>> 8) & 255);
        bArr2 = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr2[i3] = (byte) ((i >>> 0) & 255);
        i = this.gn + 1;
        this.gn = i;
        return i;
    }

    private int v5(int i, int i2) {
        if (this.VH.DW(i, i2)) {
            return this.VH.j6(i, i2);
        }
        int i3 = this.u7 + 5;
        if (this.tp.length <= i3) {
            Object obj = new byte[Math.max(i3, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) 11;
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 0) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 0) & 255);
        i3 = this.gn + 1;
        this.gn = i3;
        this.VH.j6(i, i2, i3);
        return i3;
    }

    private int Zo(int i, int i2) {
        if (this.Zo.DW(i, i2)) {
            return this.Zo.j6(i, i2);
        }
        int i3 = this.u7 + 5;
        if (this.tp.length <= i3) {
            Object obj = new byte[Math.max(i3, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) 10;
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 0) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 0) & 255);
        i3 = this.gn + 1;
        this.gn = i3;
        this.Zo.j6(i, i2, i3);
        return i3;
    }

    private int VH(int i, int i2) {
        if (this.v5.DW(i, i2)) {
            return this.v5.j6(i, i2);
        }
        int i3 = this.u7 + 5;
        if (this.tp.length <= i3) {
            Object obj = new byte[Math.max(i3, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) 9;
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 0) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 0) & 255);
        i3 = this.gn + 1;
        this.gn = i3;
        this.v5.j6(i, i2, i3);
        return i3;
    }

    private int gn(int i, int i2) {
        if (this.Hw.DW(i, i2)) {
            return this.Hw.j6(i, i2);
        }
        int i3 = this.u7 + 5;
        if (this.tp.length <= i3) {
            Object obj = new byte[Math.max(i3, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) 12;
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 0) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 8) & 255);
        bArr = this.tp;
        i4 = this.u7;
        this.u7 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 0) & 255);
        i3 = this.gn + 1;
        this.gn = i3;
        this.Hw.j6(i, i2, i3);
        return i3;
    }

    private int a8(int i) {
        if (this.FH.FH(i)) {
            return this.FH.Hw(i);
        }
        int i2 = this.u7 + 3;
        if (this.tp.length <= i2) {
            Object obj = new byte[Math.max(i2, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) 7;
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 0) & 255);
        i2 = this.gn + 1;
        this.gn = i2;
        this.FH.j6(i, i2);
        return i2;
    }

    private int u7(String str) {
        int length = str.length();
        int j6 = this.j6.j6(str);
        if (this.DW.FH(j6)) {
            return this.DW.Hw(j6);
        }
        int i;
        int i2 = 0;
        for (i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= '\u0001' && charAt <= '\u007f') {
                i2++;
            } else if (charAt > '\u07ff') {
                i2 += 3;
            } else {
                i2 += 2;
            }
        }
        i = (i2 + 3) + this.u7;
        if (this.tp.length <= i) {
            Object obj = new byte[Math.max(i, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) 1;
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr = this.tp;
        i3 = this.u7;
        this.u7 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 0) & 255);
        for (i2 = 0; i2 < length; i2++) {
            char charAt2 = str.charAt(i2);
            if (charAt2 >= '\u0001' && charAt2 <= '\u007f') {
                bArr = this.tp;
                i3 = this.u7;
                this.u7 = i3 + 1;
                bArr[i3] = (byte) charAt2;
            } else if (charAt2 > '\u07ff') {
                bArr = this.tp;
                i3 = this.u7;
                this.u7 = i3 + 1;
                bArr[i3] = (byte) (((charAt2 >> 12) & 15) | 224);
                bArr = this.tp;
                i3 = this.u7;
                this.u7 = i3 + 1;
                bArr[i3] = (byte) (((charAt2 >> 6) & 63) | 128);
                bArr = this.tp;
                i3 = this.u7;
                this.u7 = i3 + 1;
                bArr[i3] = (byte) (((charAt2 >> 0) & 63) | 128);
            } else {
                bArr = this.tp;
                i3 = this.u7;
                this.u7 = i3 + 1;
                bArr[i3] = (byte) (((charAt2 >> 6) & 31) | 192);
                bArr = this.tp;
                i3 = this.u7;
                this.u7 = i3 + 1;
                bArr[i3] = (byte) (((charAt2 >> 0) & 63) | 128);
            }
        }
        this.gn++;
        this.DW.j6(j6, this.gn);
        return this.gn;
    }

    private int J8(char[] cArr, int i, int i2) {
        int j6 = this.j6.j6(cArr, i, i2);
        if (this.DW.FH(j6)) {
            return this.DW.Hw(j6);
        }
        int i3;
        int i4 = 0;
        for (i3 = 0; i3 < i2; i3++) {
            char c = cArr[i3 + i];
            if (c >= '\u0001' && c <= '\u007f') {
                i4++;
            } else if (c > '\u07ff') {
                i4 += 3;
            } else {
                i4 += 2;
            }
        }
        i3 = (i4 + 3) + this.u7;
        if (this.tp.length <= i3) {
            Object obj = new byte[Math.max(i3, (this.tp.length * 2) + 1)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        byte[] bArr = this.tp;
        int i5 = this.u7;
        this.u7 = i5 + 1;
        bArr[i5] = (byte) 1;
        bArr = this.tp;
        i5 = this.u7;
        this.u7 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr = this.tp;
        i5 = this.u7;
        this.u7 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 0) & 255);
        for (i4 = 0; i4 < i2; i4++) {
            char c2 = cArr[i4 + i];
            if (c2 >= '\u0001' && c2 <= '\u007f') {
                bArr = this.tp;
                i5 = this.u7;
                this.u7 = i5 + 1;
                bArr[i5] = (byte) c2;
            } else if (c2 > '\u07ff') {
                bArr = this.tp;
                i5 = this.u7;
                this.u7 = i5 + 1;
                bArr[i5] = (byte) (((c2 >> 12) & 15) | 224);
                bArr = this.tp;
                i5 = this.u7;
                this.u7 = i5 + 1;
                bArr[i5] = (byte) (((c2 >> 6) & 63) | 128);
                bArr = this.tp;
                i5 = this.u7;
                this.u7 = i5 + 1;
                bArr[i5] = (byte) (((c2 >> 0) & 63) | 128);
            } else {
                bArr = this.tp;
                i5 = this.u7;
                this.u7 = i5 + 1;
                bArr[i5] = (byte) (((c2 >> 6) & 31) | 192);
                bArr = this.tp;
                i5 = this.u7;
                this.u7 = i5 + 1;
                bArr[i5] = (byte) (((c2 >> 0) & 63) | 128);
            }
        }
        this.gn++;
        this.DW.j6(j6, this.gn);
        return this.gn;
    }
}
