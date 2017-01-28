import java.lang.ref.ReferenceQueue;

class asl {
    private final int DW;
    private final ReferenceQueue<byte[]> FH;
    private long Hw;
    private final long j6;

    asl(asw asw) {
        this.j6 = asw.gn();
        this.DW = asw.u7();
        this.FH = new ReferenceQueue();
    }

    boolean j6(int i, asv asv, asv asv2) {
        if (0 < this.j6 && this.j6 < this.Hw + ((long) i)) {
            j6();
            if (0 < this.j6 && this.j6 < this.Hw + ((long) i)) {
                return false;
            }
        }
        if (i < this.DW) {
            this.Hw += (long) i;
            return true;
        } else if ((i >> 10) >= (asv.lg() >> 20) + (asv2.lg() >> 21)) {
            return false;
        } else {
            this.Hw += (long) i;
            return true;
        }
    }

    void j6(int i) {
        this.Hw -= (long) i;
    }

    asl$a j6(byte[] bArr, int i, int i2) {
        byte[] j6 = j6(bArr, i);
        if (i2 != j6.length) {
            this.Hw -= (long) i2;
            this.Hw += (long) j6.length;
        }
        return new asl$a(j6, this.FH);
    }

    byte[] j6(byte[] bArr, int i) {
        if (bArr.length == i) {
            return bArr;
        }
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }

    private void j6() {
        while (true) {
            asl$a asl_a = (asl$a) this.FH.poll();
            if (asl_a != null) {
                this.Hw -= (long) asl_a.j6;
            } else {
                return;
            }
        }
    }
}
