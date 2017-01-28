import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;

public class ahq {
    static agz j6;
    public String DW;
    RandomAccessFile FH;
    long Hw;
    ahm VH;
    Map<String, ahn> Zo;
    int v5;

    public ahq(String str) {
        this.FH = null;
        this.v5 = 0;
        this.Zo = new LinkedHashMap();
        this.DW = str;
        this.FH = new RandomAccessFile(new File(this.DW), "r");
        this.Hw = this.FH.length();
    }

    private static agz v5() {
        if (j6 == null) {
            j6 = aha.j6(ahq.class.getName());
        }
        return j6;
    }

    public static ahq j6(String str) {
        ahq ahq = new ahq(str);
        ahq.Zo();
        return ahq;
    }

    public Map<String, ahn> j6() {
        return this.Zo;
    }

    public long j6(int i) {
        if (((long) i) > this.Hw || i > 65536) {
            throw new IllegalStateException("End of central directory not found in " + this.DW);
        }
        int min = (int) Math.min(this.Hw, (long) i);
        byte[] bArr = new byte[min];
        this.FH.seek(this.Hw - ((long) min));
        this.FH.readFully(bArr);
        int i2 = min - 22;
        while (i2 >= 0) {
            this.v5++;
            if (bArr[i2] == 80 && bArr[i2 + 1] == 75 && bArr[i2 + 2] == 5 && bArr[i2 + 3] == 6) {
                return ((long) i2) + (this.Hw - ((long) min));
            }
            i2--;
        }
        return j6(i * 2);
    }

    private void Zo() {
        try {
            this.FH.seek(j6(256));
            this.VH = ahm.j6(this);
            boolean j6 = v5().j6();
            if (j6) {
                v5().Hw(String.format("EOCD found in %d iterations", new Object[]{Integer.valueOf(this.v5)}));
                v5().Hw(String.format("Directory entries=%d, size=%d, offset=%d/0x%08x", new Object[]{Short.valueOf(this.VH.v5), Integer.valueOf(this.VH.Zo), Integer.valueOf(this.VH.VH), Integer.valueOf(this.VH.VH)}));
                ahr.j6(v5());
            }
            this.FH.seek((long) this.VH.VH);
            for (short s = (short) 0; s < this.VH.v5; s++) {
                ahn j62 = ahn.j6(this);
                this.Zo.put(j62.gn(), j62);
                if (j6) {
                    ahr.j6(v5(), j62);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public long DW() {
        return this.FH.getFilePointer();
    }

    public void j6(long j) {
        this.FH.seek(j);
    }

    public int FH() {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 |= this.FH.readUnsignedByte() << (i * 8);
            i++;
        }
        return i2;
    }

    public short Hw() {
        int i = 0;
        short s = (short) 0;
        while (i < 2) {
            s = (short) (s | (this.FH.readUnsignedByte() << (i * 8)));
            i++;
        }
        return s;
    }

    public String DW(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = this.FH.readByte();
        }
        return new String(bArr);
    }

    public byte[] FH(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = this.FH.readByte();
        }
        return bArr;
    }
}
