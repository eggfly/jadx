import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterInputStream;

class arf extends anx {
    private long DW;
    private final long FH;
    private final long Hw;
    private final arb VH;
    private final aro Zo;
    private int j6;
    private final int v5;

    arf(long j, long j2, int i, aro aro, arb arb) {
        this.j6 = -1;
        this.DW = -1;
        this.FH = j;
        this.Hw = j2;
        this.v5 = i;
        this.Zo = aro;
        this.VH = arb;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int DW() {
        /*
        r4 = this;
        r0 = r4.j6;
        r1 = -1;
        if (r0 != r1) goto L_0x0019;
    L_0x0005:
        r1 = new asg;
        r0 = r4.VH;
        r1.<init>(r0);
        r0 = r4.Zo;	 Catch:{ IOException -> 0x001c, all -> 0x002f }
        r2 = r4.FH;	 Catch:{ IOException -> 0x001c, all -> 0x002f }
        r0 = r0.FH(r1, r2);	 Catch:{ IOException -> 0x001c, all -> 0x002f }
        r4.j6 = r0;	 Catch:{ IOException -> 0x001c, all -> 0x002f }
        r1.FH();
    L_0x0019:
        r0 = r4.j6;
        return r0;
    L_0x001c:
        r0 = move-exception;
        r0 = r4.Zo();	 Catch:{ IOException -> 0x0034, all -> 0x002f }
        r0 = r1.FH(r0);	 Catch:{ IOException -> 0x0034, all -> 0x002f }
        r0 = r0.DW();	 Catch:{ IOException -> 0x0034, all -> 0x002f }
        r4.j6 = r0;	 Catch:{ IOException -> 0x0034, all -> 0x002f }
    L_0x002b:
        r1.FH();
        goto L_0x0019;
    L_0x002f:
        r0 = move-exception;
        r1.FH();
        throw r0;
    L_0x0034:
        r0 = move-exception;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: arf.DW():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long j6() {
        /*
        r6 = this;
        r0 = r6.DW;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0024;
    L_0x0008:
        r1 = new asg;
        r0 = r6.VH;
        r1.<init>(r0);
        r0 = r6.Zo;	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r2 = r6.FH;	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r4 = r6.v5;	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r4 = (long) r4;	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r2 = r2 + r4;
        r0 = r0.DW(r1, r2);	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r2 = asj.j6(r0);	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r6.DW = r2;	 Catch:{ DataFormatException -> 0x0027, IOException -> 0x002c, all -> 0x003f }
        r1.FH();
    L_0x0024:
        r0 = r6.DW;
        return r0;
    L_0x0027:
        r0 = move-exception;
        r1.FH();
        goto L_0x0024;
    L_0x002c:
        r0 = move-exception;
        r0 = r6.Zo();	 Catch:{ IOException -> 0x0044, all -> 0x003f }
        r0 = r1.FH(r0);	 Catch:{ IOException -> 0x0044, all -> 0x003f }
        r2 = r0.j6();	 Catch:{ IOException -> 0x0044, all -> 0x003f }
        r6.DW = r2;	 Catch:{ IOException -> 0x0044, all -> 0x003f }
    L_0x003b:
        r1.FH();
        goto L_0x0024;
    L_0x003f:
        r0 = move-exception;
        r1.FH();
        throw r0;
    L_0x0044:
        r0 = move-exception;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: arf.j6():long");
    }

    public boolean Hw() {
        return true;
    }

    public byte[] v5() {
        try {
            throw new alf(Zo());
        } catch (Throwable e) {
            alf alf = new alf();
            alf.initCause(e);
            throw alf;
        }
    }

    public anz FH() {
        anb Zo = Zo();
        asg asg = new asg(this.VH);
        anx j6 = this.VH.j6(asg, Zo.DW(), Zo);
        if (j6 != null) {
            return j6.FH();
        }
        InputStream bufferedInputStream = new BufferedInputStream(j6(asg), 8192);
        int DW = DW();
        long j62 = j6();
        arm Ws = this.VH.Ws();
        File v5 = Ws.v5();
        OutputStream j63 = Ws.j6(new FileOutputStream(v5));
        Ws.j6(j63, DW, j62);
        return new arf$1(this, DW, j62, new axr(bufferedInputStream, j63), Ws, asg, v5, Zo);
    }

    private InputStream j6(asg asg) {
        try {
            InputStream inflaterInputStream = new InflaterInputStream(new arv(this.Zo, this.FH + ((long) this.v5), asg));
            anx j6 = this.Zo.j6(asg, this.Hw);
            InputStream arf_2 = new arf$2(this, inflaterInputStream, j6, asg);
            if (this.j6 == -1 && !(j6 instanceof arf)) {
                this.j6 = j6.DW();
            }
            if (this.DW != -1) {
                return arf_2;
            }
            this.DW = arf_2.FH();
            return arf_2;
        } catch (IOException e) {
            return asg.FH(Zo()).FH();
        }
    }

    private ans Zo() {
        return this.Zo.j6(this.FH);
    }
}
