import java.io.OutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ahs {
    static agz j6;
    OutputStream DW;
    int FH;
    List<ahn> Hw;
    Set<String> v5;

    public ahs(OutputStream outputStream) {
        this.DW = null;
        this.FH = 0;
        this.Hw = new LinkedList();
        this.v5 = new HashSet();
        this.DW = outputStream;
    }

    private static agz FH() {
        if (j6 == null) {
            j6 = aha.j6(ahs.class.getName());
        }
        return j6;
    }

    public void j6(ahn ahn) {
        String gn = ahn.gn();
        if (this.v5.contains(gn)) {
            FH().DW("Skipping duplicate file in output: " + gn);
            return;
        }
        ahn.j6(this);
        this.Hw.add(ahn);
        this.v5.add(gn);
        if (FH().j6()) {
            ahr.j6(FH(), ahn);
        }
    }

    public void j6() {
        ahm ahm = new ahm();
        ahm.VH = DW();
        short size = (short) this.Hw.size();
        ahm.v5 = size;
        ahm.Hw = size;
        for (ahn DW : this.Hw) {
            DW.DW(this);
        }
        ahm.Zo = DW() - ahm.VH;
        ahm.gn = "";
        ahm.j6(this);
        if (this.DW != null) {
            try {
                this.DW.close();
            } catch (Throwable th) {
            }
        }
    }

    public int DW() {
        return this.FH;
    }

    public void j6(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i & 255);
            i >>= 8;
        }
        this.DW.write(bArr);
        this.FH += 4;
    }

    public void j6(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < 2; i++) {
            bArr[i] = (byte) (s & 255);
            s = (short) (s >> 8);
        }
        this.DW.write(bArr);
        this.FH += 2;
    }

    public void j6(String str) {
        byte[] bytes = str.getBytes();
        this.DW.write(bytes);
        this.FH = bytes.length + this.FH;
    }

    public void j6(byte[] bArr) {
        this.DW.write(bArr);
        this.FH += bArr.length;
    }

    public void j6(byte[] bArr, int i, int i2) {
        this.DW.write(bArr, i, i2);
        this.FH += i2;
    }
}
