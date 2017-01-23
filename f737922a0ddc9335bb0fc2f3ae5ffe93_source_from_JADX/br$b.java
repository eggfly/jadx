import java.io.File;
import java.io.OutputStream;
import java.util.Set;

class br$b extends OutputStream {
    private byte[] DW;
    private int FH;
    private long Hw;
    private String VH;
    private String Zo;
    private Set<String> gn;
    final /* synthetic */ br j6;
    private boolean tp;
    private String u7;
    private bv v5;

    public br$b(br brVar, Set<String> set, String str, String str2, long j, bv bvVar, String str3, boolean z) {
        this.j6 = brVar;
        if (brVar.v5 != null) {
            this.DW = brVar.v5;
            brVar.v5 = null;
        } else {
            this.DW = new byte[10000];
        }
        this.v5 = bvVar;
        this.Hw = j;
        this.Zo = str;
        this.VH = str2;
        this.gn = set;
        this.u7 = str3;
        this.tp = z;
    }

    public void write(int i) {
        int i2 = this.FH + 1;
        if (i2 > this.DW.length) {
            Object obj = new byte[Math.max(this.DW.length << 1, i2)];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
        this.DW[this.FH] = (byte) i;
        this.FH = i2;
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = this.FH + i2;
        if (i3 > this.DW.length) {
            Object obj = new byte[Math.max(this.DW.length << 1, i3)];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
        System.arraycopy(bArr, i, this.DW, this.FH, i2);
        this.FH = i3;
    }

    public void close() {
        long j;
        if (this.tp) {
            j = 0;
        } else {
            this.j6.gn.reset();
            this.j6.gn.update(this.DW, 0, this.FH);
            j = this.j6.gn.getValue();
        }
        br$1 br_1 = null;
        for (String str : this.gn) {
            String str2 = str + File.separator + this.Zo + this.VH;
            String str3 = str + File.separator + this.Zo;
            this.j6.j3.put(str2, new Long(this.Hw));
            this.j6.Mr.put(str2, this.v5);
            this.j6.J0.add(str);
            br$c br_c;
            br$a br_a;
            Object obj;
            if (this.tp) {
                if (br_1 == null) {
                    br_c = (br$c) this.j6.XL.get(str2);
                    if (br_c instanceof br$a) {
                        br_a = (br$a) br_c;
                    } else {
                        obj = br_1;
                    }
                    if (br_a == null) {
                        br_a = new br$a(null);
                    }
                    br_a.j6(this.DW, this.FH);
                } else {
                    obj = br_1;
                }
                this.j6.Ws = this.j6.Ws + br_a.FH;
                this.j6.XL.put(str2, br_a);
                this.j6.aM.put(str2, this.u7);
                this.j6.QX.put(str2, str3);
                br_1 = br_a;
            } else if (!this.j6.a8.containsKey(str2) || j != ((Long) this.j6.a8.get(str2)).longValue()) {
                this.j6.a8.put(str2, new Long(j));
                if (j6(str)) {
                    this.j6.XL.remove(str2);
                    this.j6.U2.remove(str2);
                    if (str2.endsWith(".class") && ((str2.indexOf(36) == -1 || str2.lastIndexOf(36) < str2.lastIndexOf(File.separatorChar)) && new File(str2).isFile())) {
                        this.j6.we.put(str2, new Long(new File(str2).lastModified()));
                    }
                } else if (!this.j6.U2.containsKey(str2) || j != ((Long) this.j6.U2.get(str2)).longValue()) {
                    if (br_1 == null) {
                        br_c = (br$c) this.j6.XL.get(str2);
                        if (br_c instanceof br$a) {
                            br_a = (br$a) br_c;
                        } else {
                            obj = br_1;
                        }
                        if (br_a == null) {
                            br_a = new br$a(null);
                        }
                        br_a.j6(this.DW, this.FH);
                    } else {
                        obj = br_1;
                    }
                    this.j6.Ws = this.j6.Ws + br_a.FH;
                    this.j6.XL.put(str2, br_a);
                    this.j6.aM.put(str2, this.u7);
                    this.j6.QX.put(str2, str3);
                    this.j6.U2.put(str2, new Long(j));
                    br_1 = br_a;
                }
            }
        }
        if (this.j6.v5 == null) {
            this.j6.v5 = this.DW;
        }
        this.DW = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j6(java.lang.String r9) {
        /*
        r8 = this;
        r2 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r9);
        r1 = java.io.File.separator;
        r0 = r0.append(r1);
        r1 = r8.Zo;
        r0 = r0.append(r1);
        r1 = r8.VH;
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = new java.io.File;
        r0.<init>(r9);
        r0 = r0.isDirectory();
        if (r0 == 0) goto L_0x0046;
    L_0x002b:
        r0 = new java.io.File;
        r0.<init>(r1);
        r0 = r0.exists();
        if (r0 == 0) goto L_0x0046;
    L_0x0036:
        r0 = new java.io.File;
        r0.<init>(r1);
        r4 = r0.length();
        r0 = r8.FH;
        r6 = (long) r0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0047;
    L_0x0046:
        return r2;
    L_0x0047:
        r0 = r8.j6;
        r0 = r0.FH;
        if (r0 == 0) goto L_0x0068;
    L_0x004f:
        r0 = java.lang.System.out;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Reading ";
        r3 = r3.append(r4);
        r3 = r3.append(r1);
        r3 = r3.toString();
        r0.println(r3);
    L_0x0068:
        r0 = r8.j6;
        r0 = r0.Zo;
        if (r0 == 0) goto L_0x00a1;
    L_0x0070:
        r0 = r8.j6;
        r0 = r0.Zo;
        r3 = r8.j6;
        r4 = 0;
        r3.Zo = r4;
    L_0x007c:
        r5 = new java.io.FileInputStream;
        r5.<init>(r1);
        r1 = r2;
    L_0x0082:
        r6 = r5.read(r0);
        r3 = -1;
        if (r6 == r3) goto L_0x00ad;
    L_0x0089:
        r3 = r2;
    L_0x008a:
        if (r3 >= r6) goto L_0x0082;
    L_0x008c:
        r4 = r8.FH;
        if (r1 > r4) goto L_0x0098;
    L_0x0090:
        r4 = r8.DW;
        r4 = r4[r1];
        r7 = r0[r3];
        if (r4 == r7) goto L_0x00a6;
    L_0x0098:
        r5.close();
        r1 = r8.j6;
        r1.Zo = r0;
        goto L_0x0046;
    L_0x00a1:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = new byte[r0];
        goto L_0x007c;
    L_0x00a6:
        r4 = r1 + 1;
        r1 = r3 + 1;
        r3 = r1;
        r1 = r4;
        goto L_0x008a;
    L_0x00ad:
        r3 = r8.FH;
        if (r1 == r3) goto L_0x00ba;
    L_0x00b1:
        r5.close();
        r1 = r8.j6;
        r1.Zo = r0;
        goto L_0x0046;
    L_0x00ba:
        r5.close();
        r1 = r8.j6;
        r1.Zo = r0;
        r2 = 1;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: br$b.j6(java.lang.String):boolean");
    }
}
