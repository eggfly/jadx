import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

public final class yt {
    private int DW;
    private final List<yt$a> FH;
    private final yu j6;

    public yt() {
        this.j6 = new yu();
        this.FH = new ArrayList();
    }

    public void j6() {
        Zo();
        VH();
        gn();
    }

    private void Zo() {
        yt$a j6 = j6(this.j6.gn, ((this.FH.size() + 1) * 12) + 4, 1);
        List arrayList = new ArrayList();
        for (yt$a j62 : this.FH) {
            arrayList.add(j62.DW);
        }
        this.j6.j6(j6, arrayList);
    }

    private void VH() {
        this.j6.er = this.DW - this.j6.yS;
        this.j6.a8 = this.DW;
        this.j6.j6(FH(this.j6.j6));
    }

    public void j6(OutputStream outputStream) {
        for (yt$a yt_a : this.FH) {
            if (yt_a.v5 > 0) {
                outputStream.write(yt_a.Zo, 0, yt_a.v5);
            }
        }
    }

    private void gn() {
        byte[] DW = DW();
        yt$a yt_a = (yt$a) this.FH.get(0);
        yt_a.Hw = 12;
        yt_a.j6(DW);
        int FH = FH();
        yt_a.Hw = 8;
        yt_a.v5(FH);
    }

    public byte[] DW() {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            yt$a yt_a = (yt$a) this.FH.get(0);
            instance.update(yt_a.Zo, 32, yt_a.v5 - 32);
            for (int i = 1; i < this.FH.size(); i++) {
                yt_a = (yt$a) this.FH.get(i);
                if (yt_a.v5 > 0) {
                    instance.update(yt_a.Zo, 0, yt_a.v5);
                }
            }
            return instance.digest();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int FH() {
        Adler32 adler32 = new Adler32();
        yt$a yt_a = (yt$a) this.FH.get(0);
        adler32.update(yt_a.Zo, 12, yt_a.v5 - 12);
        for (int i = 1; i < this.FH.size(); i++) {
            yt_a = (yt$a) this.FH.get(i);
            if (yt_a.v5 > 0) {
                adler32.update(yt_a.Zo, 0, yt_a.v5);
            }
        }
        return (int) adler32.getValue();
    }

    public yu Hw() {
        return this.j6;
    }

    public yt$a j6(yu$a yu_a, int i, int i2) {
        u7();
        Hw(yu_a);
        int v5 = v5(i);
        yu_a.FH = this.DW;
        yu_a.DW = i2;
        yt$a yt_a = new yt$a(yu_a, this.DW, v5, null);
        this.DW += v5;
        this.FH.add(yt_a);
        return yt_a;
    }

    public yt$a j6(yu$a yu_a, byte[] bArr, int i, int i2) {
        u7();
        Hw(yu_a);
        int v5 = v5(i);
        yu_a.FH = this.DW;
        yu_a.DW = i2;
        yt$a yt_a = new yt$a(yu_a, this.DW, v5, bArr, null);
        this.DW += v5;
        this.FH.add(yt_a);
        return yt_a;
    }

    public yt$a j6(yu$a yu_a) {
        u7();
        Hw(yu_a);
        yt$a yt_a = new yt$a(yu_a, this.DW, null);
        this.FH.add(yt_a);
        return yt_a;
    }

    public yt$a DW(yu$a yu_a) {
        Hw(yu_a);
        yt$a yt_a = new yt$a(yu_a, null);
        this.FH.add(yt_a);
        return yt_a;
    }

    public void j6(int i) {
        if (this.FH.size() == 0) {
            throw new IllegalStateException("No sections present");
        }
        int size = this.FH.size() - 1;
        yt$a yt_a = (yt$a) this.FH.get(size);
        if (yt_a.Zo()) {
            throw new IllegalStateException("Last section already finished");
        }
        int DW = yt_a.DW();
        if (DW == 0 && i == 0) {
            this.FH.remove(size);
            return;
        }
        yt_a.DW.FH = this.DW;
        yt_a.DW.DW = i;
        this.DW += DW;
    }

    public void DW(int i) {
        if (this.FH.size() < 2) {
            throw new IllegalStateException("Less than two sections present");
        }
        int size = this.FH.size() - 2;
        yt$a yt_a = (yt$a) this.FH.get(size);
        if (yt_a.Zo()) {
            throw new IllegalStateException("Second-to-last section already finished");
        }
        int DW = yt_a.DW();
        if (DW == 0 && i == 0) {
            this.FH.remove(size);
            return;
        }
        yt_a.DW.FH = this.DW;
        yt_a.DW.DW = i;
        this.DW += DW;
    }

    public int FH(int i) {
        if (this.FH.size() == 0) {
            throw new IllegalStateException("No sections present");
        }
        int size = this.FH.size() - 1;
        yt$a yt_a = (yt$a) this.FH.get(size);
        if (yt_a.Zo()) {
            throw new IllegalStateException("Last section already finished");
        } else if (yt_a.VH()) {
            throw new IllegalStateException("Last section already placed");
        } else {
            int DW = yt_a.DW();
            if (DW == 0 && i == 0) {
                this.FH.remove(size);
                return 0;
            }
            yt_a.FH = this.DW;
            yt_a.DW.FH = this.DW;
            yt_a.DW.DW = i;
            this.DW += DW;
            return yt_a.FH;
        }
    }

    public yt$a FH(yu$a yu_a) {
        for (int i = 0; i < this.FH.size(); i++) {
            yt$a yt_a = (yt$a) this.FH.get(i);
            if (yt_a.DW == yu_a) {
                return yt_a;
            }
        }
        throw new IllegalArgumentException("TOC section not present");
    }

    private void Hw(yu$a yu_a) {
        for (int i = 0; i < this.FH.size(); i++) {
            if (((yt$a) this.FH.get(i)).DW == yu_a) {
                throw new IllegalArgumentException("TOC section already added");
            }
        }
    }

    private void u7() {
        if (!this.FH.isEmpty()) {
            if (!((yt$a) this.FH.get(this.FH.size() - 1)).Zo() || !((yt$a) this.FH.get(this.FH.size() - 1)).VH()) {
                throw new IllegalArgumentException("Can not append section when size of last section is still unknown or not placed");
            }
        }
    }

    public int v5() {
        return this.DW;
    }

    private static int v5(int i) {
        return (i + 3) & -4;
    }
}
