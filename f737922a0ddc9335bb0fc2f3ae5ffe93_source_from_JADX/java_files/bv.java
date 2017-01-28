import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

public class bv {
    private final by DW;
    private boolean EQ;
    private final cx FH;
    private int Hw;
    private boolean J0;
    private long J8;
    private boolean QX;
    private dt VH;
    private boolean Ws;
    private long XL;
    private int Zo;
    private long aM;
    private do gn;
    private final bw j6;
    private String tp;
    private bv u7;
    private bv v5;
    private boolean we;

    public bv(by byVar, bw bwVar, cx cxVar, int i, bv bvVar) {
        this.DW = byVar;
        this.j6 = bwVar;
        this.FH = cxVar;
        this.Hw = i;
        this.v5 = bvVar;
        this.Zo = bwVar.XL(this);
        this.J8 = -1;
        KD();
    }

    public bv(by byVar, bw bwVar, cx cxVar) {
        this.DW = byVar;
        this.j6 = bwVar;
        this.FH = cxVar;
        this.J8 = -1;
        KD();
    }

    public boolean j6() {
        if (BT() == null) {
            return false;
        }
        for (bj u7 : BT().Zo()) {
            if (u7.u7() != null) {
                return true;
            }
        }
        return false;
    }

    protected void j6(ee eeVar) {
        this.Zo = eeVar.readInt();
        this.Hw = eeVar.readInt();
        this.v5 = this.j6.gn(eeVar.readInt());
        if (eeVar.readBoolean()) {
            this.VH = new dt(eeVar);
        }
        this.J8 = eeVar.readLong();
        this.EQ = eeVar.readBoolean();
        this.XL = eeVar.readLong();
        this.aM = eeVar.readLong();
    }

    protected void j6(ef efVar) {
        efVar.writeInt(this.Zo);
        efVar.writeInt(this.Hw);
        efVar.writeInt(this.j6.QX(this.v5));
        efVar.writeBoolean(this.VH != null);
        if (this.VH != null) {
            this.VH.j6(efVar);
        }
        efVar.writeLong(this.J8);
        efVar.writeBoolean(this.EQ);
        efVar.writeLong(this.XL);
        efVar.writeLong(this.aM);
    }

    public boolean DW() {
        return this.j6.J8(this);
    }

    public boolean FH() {
        return this.j6.Ws(this);
    }

    public String Hw() {
        String v5 = v5();
        if (v5.lastIndexOf(46) > 0) {
            return v5.substring(v5.lastIndexOf(46), v5.length());
        }
        return "";
    }

    public String v5() {
        return this.DW.j6(this.Hw);
    }

    public int Zo() {
        String v5 = v5();
        if (!Mr() && v5.lastIndexOf(46) > 0) {
            v5 = v5.substring(0, v5.lastIndexOf(46));
        }
        return this.DW.j6(v5);
    }

    public int VH() {
        return this.Hw;
    }

    public int gn() {
        return this.j6.j6(this);
    }

    public boolean j6(bv bvVar) {
        return this.j6.j6(this, bvVar);
    }

    public bv u7() {
        return this.v5;
    }

    public long tp() {
        sh();
        if (j3()) {
            return this.FH.FH(this);
        }
        String er = er();
        if (new File(er).exists()) {
            return new File(er).length();
        }
        return 0;
    }

    public bv EQ() {
        return this.u7;
    }

    public String we() {
        return this.tp;
    }

    public String DW(bv bvVar) {
        if (!bvVar.FH(this)) {
            return "";
        }
        String er = er();
        return er.substring(bvVar.er().length(), er.length());
    }

    public boolean J0() {
        return this.we;
    }

    public boolean J8() {
        return this.EQ;
    }

    public long Ws() {
        if (J8()) {
            return EQ().QX();
        }
        return 0;
    }

    public boolean FH(bv bvVar) {
        while (!bvVar.U2()) {
            if (bvVar == this) {
                return true;
            }
            bvVar = bvVar.u7();
        }
        return false;
    }

    public long QX() {
        return this.j6.aM(this);
    }

    public long XL() {
        sh();
        if (j3()) {
            return ro();
        }
        return aM();
    }

    public long aM() {
        sh();
        if (this.EQ || !j3()) {
            if (this.J8 == -1) {
                this.J8 = ro();
            }
            return this.J8;
        }
        this.J8 = -1;
        return this.FH.DW(this);
    }

    public boolean j3() {
        return this.FH != null && this.FH.Hw(this);
    }

    public boolean Mr() {
        sh();
        return this.J0;
    }

    public boolean U2() {
        return this.v5 == null;
    }

    public dg j6(int i) {
        dg dgVar = new dg();
        Reader rN;
        try {
            rN = rN();
            int i2 = 1;
            char[] cArr = this.j6.j6;
            int i3 = 0;
            while (true) {
                int read = rN.read(cArr);
                if (read != -1) {
                    for (int i4 = 0; i4 < read; i4++) {
                        switch (cArr[i4]) {
                            case '\t':
                                i3 = ((i3 + i) / i) * i;
                                break;
                            case '\n':
                                if (!dgVar.DW(i2)) {
                                    dgVar.j6(i2, i3);
                                }
                                i2++;
                                i3 = 0;
                                break;
                            case ' ':
                                i3++;
                                break;
                            default:
                                if (!dgVar.DW(i2)) {
                                    dgVar.j6(i2, i3);
                                    break;
                                }
                                break;
                        }
                    }
                } else {
                    rN.close();
                    return dgVar;
                }
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            rN.close();
        }
    }

    public String j6(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        Reader rN;
        try {
            rN = rN();
            char[] cArr = this.j6.j6;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                int read = rN.read(cArr);
                if (read != -1) {
                    int i5 = i3;
                    i3 = i4;
                    for (i4 = 0; i4 < read; i4++) {
                        char c = cArr[i4];
                        switch (c) {
                            case '\n':
                                i3++;
                                i5 = 1;
                                break;
                            default:
                                if (i3 == i && i5 < i2) {
                                    stringBuffer.append(c);
                                }
                                i5++;
                                break;
                        }
                    }
                    i4 = i3;
                    i3 = i5;
                } else {
                    rN.close();
                    return stringBuffer.toString();
                }
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            rN.close();
        }
    }

    public String toString() {
        return er();
    }

    public int a8() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:42)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:66)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r9 = this;
        r1 = 0;
        r3 = r9.rN();	 Catch:{ IOException -> 0x0028 }
        r0 = r9.j6;	 Catch:{ all -> 0x0023 }
        r4 = r0.j6;	 Catch:{ all -> 0x0023 }
        r0 = r1;
    L_0x000a:
        r5 = r3.read(r4);	 Catch:{ all -> 0x002d }
        r2 = -1;	 Catch:{ all -> 0x002d }
        if (r5 == r2) goto L_0x001f;	 Catch:{ all -> 0x002d }
    L_0x0011:
        r2 = r1;	 Catch:{ all -> 0x002d }
    L_0x0012:
        if (r2 >= r5) goto L_0x000a;	 Catch:{ all -> 0x002d }
    L_0x0014:
        r6 = r4[r2];	 Catch:{ all -> 0x002d }
        r7 = 10;
        if (r6 != r7) goto L_0x001c;
    L_0x001a:
        r0 = r0 + 1;
    L_0x001c:
        r2 = r2 + 1;
        goto L_0x0012;
    L_0x001f:
        r3.close();	 Catch:{ IOException -> 0x002b }
    L_0x0022:
        return r0;
    L_0x0023:
        r0 = move-exception;
    L_0x0024:
        r3.close();	 Catch:{ IOException -> 0x0028 }
        throw r0;	 Catch:{ IOException -> 0x0028 }
    L_0x0028:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0022;
    L_0x002b:
        r1 = move-exception;
        goto L_0x0022;
    L_0x002d:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: bv.a8():int");
    }

    public List<String> lg() {
        List<String> arrayList = new ArrayList();
        arrayList.add("");
        Reader rN;
        try {
            rN = rN();
            StringBuffer stringBuffer = new StringBuffer();
            char[] cArr = this.j6.j6;
            while (true) {
                int read = rN.read(cArr);
                if (read != -1) {
                    for (int i = 0; i < read; i++) {
                        char c = cArr[i];
                        switch (c) {
                            case '\n':
                                arrayList.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                break;
                            default:
                                stringBuffer.append(c);
                                break;
                        }
                    }
                } else {
                    rN.close();
                    return arrayList;
                }
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            rN.close();
        }
    }

    public String DW(int i) {
        return DW(i, 1);
    }

    public String DW(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        Reader rN;
        try {
            rN = rN();
            char[] cArr = this.j6.j6;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                int read = rN.read(cArr);
                if (read != -1) {
                    int i5 = i3;
                    i3 = i4;
                    for (i4 = 0; i4 < read; i4++) {
                        char c = cArr[i4];
                        switch (c) {
                            case '\n':
                                i3++;
                                i5 = 1;
                                break;
                            default:
                                if (i3 == i && i5 >= i2) {
                                    stringBuffer.append(c);
                                }
                                i5++;
                                break;
                        }
                    }
                    i4 = i3;
                    i3 = i5;
                } else {
                    rN.close();
                    return stringBuffer.toString();
                }
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            rN.close();
        }
    }

    public Reader rN() {
        sh();
        if (j3()) {
            return this.j6.j6(this.FH.j6(this));
        }
        if (!nw()) {
            return new CharArrayReader(new char[0]);
        }
        if (!P8()) {
            System.out.println("File not synchronized " + er());
        }
        try {
            if (this.EQ) {
                String u7 = this.j6.u7();
                return this.j6.j6(BT().j6(this.u7.er(), we(), u7));
            }
            return this.j6.j6(this.j6.j6(new FileInputStream(er()), this.j6.u7()));
        } catch (IOException e) {
            return new CharArrayReader(new char[0]);
        }
    }

    public String er() {
        if (this.v5 == null) {
            return "";
        }
        if (this.v5.v5 == null) {
            return v5();
        }
        return this.v5.er() + File.separator + v5();
    }

    public int yS() {
        sh();
        if (this.gn == null) {
            return 0;
        }
        return this.gn.Hw();
    }

    public bv FH(int i) {
        return this.j6.gn(this.gn.FH(i));
    }

    public bv j6(String str) {
        if (this.VH == null) {
            this.VH = new dt();
        }
        int j6 = this.DW.j6(str);
        if (!this.VH.FH(j6)) {
            this.VH.DW(j6, new bv(this.DW, this.j6, this.FH, j6, this).vy());
        }
        return this.j6.gn(this.VH.Hw(j6));
    }

    public bv gW() {
        bv u7 = u7();
        int yS = u7.yS();
        for (int i = 0; i < yS - 1; i++) {
            if (u7.FH(i) == this) {
                return u7.FH(i + 1);
            }
        }
        return null;
    }

    private bh SI() {
        return this.j6.we(this);
    }

    public bh BT() {
        return this.j6.J0(this);
    }

    public int vy() {
        return this.Zo;
    }

    public boolean P8() {
        if (j3() || this.J8 == -1) {
            return true;
        }
        if (this.we) {
            if (this.J8 != ro()) {
                return false;
            }
            return true;
        } else if (this.J0 || this.EQ || this.J8 == cn()) {
            return true;
        } else {
            return false;
        }
    }

    public void ei() {
        if (this.v5 != null) {
            this.v5.Ws = false;
        }
        if (this.u7 != null) {
            this.u7.Ws = false;
            bv bvVar = this.v5;
            while (bvVar != null && bvVar != this.u7) {
                bvVar.Ws = false;
                bvVar = bvVar.v5;
            }
        }
        if (this.gn != null) {
            this.gn.j6();
        }
        if (this.J0 || this.EQ || this.we || this.J8 == -1) {
            this.J8 = -1;
        } else {
            this.J8 = cn();
        }
        KD();
    }

    public boolean nw() {
        sh();
        return this.QX;
    }

    public int hashCode() {
        return this.Zo;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof bv) && ((bv) obj).vy() == this.Zo) {
            return true;
        }
        return false;
    }

    private void KD() {
        this.Ws = false;
        this.u7 = null;
        this.tp = null;
        this.EQ = false;
        this.J0 = false;
        this.we = false;
        this.QX = false;
    }

    private long ro() {
        if (!nw()) {
            return 0;
        }
        if (this.we) {
            return BT().j6(er());
        }
        if (this.EQ) {
            return this.u7.aM();
        }
        if (!U2() || System.getProperty("os.name").toUpperCase(Locale.US).indexOf("WINDOWS") == -1) {
            return cn();
        }
        return 0;
    }

    private long cn() {
        File file = new File(er());
        if (file.isDirectory()) {
            return file.lastModified();
        }
        if (!file.isFile()) {
            return 0;
        }
        long lastModified = file.lastModified();
        if (this.aM == -1 || this.aM != lastModified) {
            this.aM = lastModified;
            InputStream fileInputStream;
            try {
                CRC32 crc32 = this.j6.FH;
                byte[] bArr = this.j6.DW;
                crc32.reset();
                fileInputStream = new FileInputStream(file);
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                fileInputStream.close();
                this.XL = crc32.getValue();
                if (this.XL == 0) {
                    this.XL = 4294967296L;
                }
            } catch (IOException e) {
            } catch (Throwable th) {
                fileInputStream.close();
            }
        }
        return this.XL;
    }

    private void sh() {
        int i = 0;
        if (!this.Ws) {
            if (this.v5 != null) {
                this.v5.sh();
            }
            if (!this.Ws) {
                this.Ws = true;
                try {
                    String er = er();
                    if (U2() && System.getProperty("os.name").toUpperCase(Locale.US).indexOf("WINDOWS") != -1) {
                        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
                            DW(c + ":");
                        }
                        this.QX = true;
                    } else if (SI() != null && SI().VH()) {
                        this.we = true;
                        try {
                            this.J8 = SI().j6(er);
                            String[] DW = SI().DW(er);
                            if (DW != null) {
                                this.u7 = this;
                                this.J0 = true;
                                int length = DW.length;
                                while (i < length) {
                                    String str = DW[i];
                                    if (str != null) {
                                        j6(str, str);
                                    }
                                    i++;
                                }
                            }
                        } catch (IOException e) {
                        }
                        this.QX = true;
                    } else if (new File(er).isDirectory()) {
                        String[] list = new File(er + File.separatorChar).list();
                        if (list != null) {
                            while (i < list.length) {
                                if (new File(er + File.separatorChar + list[i]).isDirectory()) {
                                    DW(list[i]);
                                } else {
                                    FH(list[i]);
                                }
                                i++;
                            }
                        }
                        this.QX = true;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private void j6(String str, String str2) {
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            indexOf = str.indexOf(92);
        }
        if (indexOf == -1) {
            bv FH = FH(str);
            FH.Ws = true;
            FH.EQ = true;
            FH.tp = str2;
            FH.u7 = this.u7;
            return;
        }
        String substring = str.substring(0, indexOf);
        bv j6 = j6(substring);
        if (!j6.QX) {
            DW(substring);
        }
        j6.Ws = true;
        j6.EQ = true;
        j6.u7 = this.u7;
        j6.tp = str2;
        j6.j6(str.substring(indexOf + 1, str.length()), str2);
    }

    private bv DW(String str) {
        bv j6 = j6(str);
        j6.J0 = true;
        j6.QX = true;
        if (this.gn == null) {
            this.gn = new do();
        }
        this.gn.DW(j6.vy());
        return j6;
    }

    private bv FH(String str) {
        bv j6 = j6(str);
        j6.J0 = false;
        j6.QX = true;
        if (this.gn == null) {
            this.gn = new do();
        }
        this.gn.DW(j6.vy());
        return j6;
    }
}
