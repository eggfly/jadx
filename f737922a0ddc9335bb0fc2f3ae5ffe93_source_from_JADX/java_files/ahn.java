import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class ahn implements Cloneable {
    private static byte[] a8;
    private static agz lg;
    private short DW;
    private String EQ;
    private short FH;
    private short Hw;
    private short J0;
    private String J8;
    private byte[] Mr;
    private short QX;
    private ahp U2;
    private short VH;
    private short Ws;
    private int XL;
    private short Zo;
    private int aM;
    private int gn;
    private long j3;
    private ahq j6;
    private int tp;
    private int u7;
    private short v5;
    private byte[] we;

    static {
        a8 = new byte[4];
    }

    public ahn(ahq ahq) {
        this.J0 = (short) 0;
        this.j3 = -1;
        this.Mr = null;
        this.U2 = null;
        this.j6 = ahq;
    }

    public static agz j6() {
        if (lg == null) {
            lg = aha.j6(ahn.class.getName());
        }
        return lg;
    }

    public ahn(String str) {
        this.J0 = (short) 0;
        this.j3 = -1;
        this.Mr = null;
        this.U2 = null;
        this.EQ = str;
        this.J8 = "";
        this.v5 = (short) 8;
        this.we = new byte[0];
        j6(System.currentTimeMillis());
    }

    public void DW() {
        ahq ahq = this.j6;
        boolean j6 = j6().j6();
        ahq.j6((long) this.aM);
        if (j6) {
            j6().Hw(String.format("FILE POSITION: 0x%08x", new Object[]{Long.valueOf(ahq.DW())}));
        }
        if (ahq.FH() != 67324752) {
            throw new IllegalStateException(String.format("Local header not found at pos=0x%08x, file=%s", new Object[]{Long.valueOf(ahq.DW()), this.EQ}));
        }
        short Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Version required: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("General purpose bits: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Compression: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Modification time: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Modification date: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        int FH = ahq.FH();
        if (j6) {
            lg.Hw(String.format("CRC-32: 0x%04x", new Object[]{Integer.valueOf(FH)}));
        }
        FH = ahq.FH();
        if (j6) {
            lg.Hw(String.format("Compressed size: 0x%04x", new Object[]{Integer.valueOf(FH)}));
        }
        FH = ahq.FH();
        if (j6) {
            lg.Hw(String.format("Size: 0x%04x", new Object[]{Integer.valueOf(FH)}));
        }
        Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("File name length: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        short Hw2 = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Extra length: 0x%04x", new Object[]{Short.valueOf(Hw2)}));
        }
        String DW = ahq.DW(Hw);
        if (j6) {
            lg.Hw("Filename: " + DW);
        }
        ahq.FH(Hw2);
        this.j3 = ahq.DW();
        if (j6) {
            lg.Hw(String.format("Data position: 0x%08x", new Object[]{Long.valueOf(this.j3)}));
        }
    }

    public void j6(ahs ahs) {
        if (this.Mr == null && this.j3 < 0 && this.j6 != null) {
            DW();
        }
        this.aM = ahs.DW();
        boolean j6 = j6().j6();
        if (j6) {
            j6().Hw(String.format("Writing local header at 0x%08x - %s", new Object[]{Integer.valueOf(this.aM), this.EQ}));
        }
        if (this.U2 != null) {
            this.U2.close();
            this.tp = this.U2.DW();
            this.Mr = ((ByteArrayOutputStream) this.U2.FH()).toByteArray();
            this.u7 = this.Mr.length;
            this.gn = this.U2.j6();
        }
        ahs.j6(67324752);
        ahs.j6(this.FH);
        ahs.j6(this.Hw);
        ahs.j6(this.v5);
        ahs.j6(this.Zo);
        ahs.j6(this.VH);
        ahs.j6(this.gn);
        ahs.j6(this.u7);
        ahs.j6(this.tp);
        ahs.j6((short) this.EQ.length());
        this.J0 = (short) 0;
        if (this.v5 == (short) 0) {
            short DW = (short) ((int) (((long) (((ahs.DW() + 2) + this.EQ.length()) + this.we.length)) % 4));
            if (DW > (short) 0) {
                this.J0 = (short) (4 - DW);
            }
        }
        ahs.j6((short) (this.we.length + this.J0));
        ahs.j6(this.EQ);
        ahs.j6(this.we);
        if (this.J0 > (short) 0) {
            ahs.j6(a8, 0, this.J0);
        }
        if (j6) {
            j6().Hw(String.format("Data position 0x%08x", new Object[]{Integer.valueOf(ahs.DW())}));
        }
        if (this.Mr != null) {
            ahs.j6(this.Mr);
            if (j6) {
                j6().Hw(String.format("Wrote %d bytes", new Object[]{Integer.valueOf(this.Mr.length)}));
                return;
            }
            return;
        }
        if (j6) {
            j6().Hw(String.format("Seeking to position 0x%08x", new Object[]{Long.valueOf(this.j3)}));
        }
        this.j6.j6(this.j3);
        int min = Math.min(this.u7, 8096);
        byte[] bArr = new byte[min];
        long j = 0;
        while (j != ((long) this.u7)) {
            int read = this.j6.FH.read(bArr, 0, (int) Math.min(((long) this.u7) - j, (long) min));
            if (read > 0) {
                ahs.j6(bArr, 0, read);
                if (j6) {
                    j6().Hw(String.format("Wrote %d bytes", new Object[]{Integer.valueOf(read)}));
                }
                j += (long) read;
            } else {
                throw new IllegalStateException(String.format("EOF reached while copying %s with %d bytes left to go", new Object[]{this.EQ, Long.valueOf(((long) this.u7) - j)}));
            }
        }
    }

    public static ahn j6(ahq ahq) {
        if (ahq.FH() != 33639248) {
            ahq.j6(ahq.DW() - 4);
            return null;
        }
        ahn ahn = new ahn(ahq);
        ahn.DW(ahq);
        return ahn;
    }

    private void DW(ahq ahq) {
        boolean j6 = j6().j6();
        this.DW = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Version made by: 0x%04x", new Object[]{Short.valueOf(this.DW)}));
        }
        this.FH = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Version required: 0x%04x", new Object[]{Short.valueOf(this.FH)}));
        }
        this.Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("General purpose bits: 0x%04x", new Object[]{Short.valueOf(this.Hw)}));
        }
        if ((this.Hw & 63473) != 0) {
            throw new IllegalStateException("Can't handle general purpose bits == " + String.format("0x%04x", new Object[]{Short.valueOf(this.Hw)}));
        }
        this.v5 = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Compression: 0x%04x", new Object[]{Short.valueOf(this.v5)}));
        }
        this.Zo = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Modification time: 0x%04x", new Object[]{Short.valueOf(this.Zo)}));
        }
        this.VH = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Modification date: 0x%04x", new Object[]{Short.valueOf(this.VH)}));
        }
        this.gn = ahq.FH();
        if (j6) {
            lg.Hw(String.format("CRC-32: 0x%04x", new Object[]{Integer.valueOf(this.gn)}));
        }
        this.u7 = ahq.FH();
        if (j6) {
            lg.Hw(String.format("Compressed size: 0x%04x", new Object[]{Integer.valueOf(this.u7)}));
        }
        this.tp = ahq.FH();
        if (j6) {
            lg.Hw(String.format("Size: 0x%04x", new Object[]{Integer.valueOf(this.tp)}));
        }
        short Hw = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("File name length: 0x%04x", new Object[]{Short.valueOf(Hw)}));
        }
        short Hw2 = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Extra length: 0x%04x", new Object[]{Short.valueOf(Hw2)}));
        }
        short Hw3 = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("File comment length: 0x%04x", new Object[]{Short.valueOf(Hw3)}));
        }
        this.Ws = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Disk number start: 0x%04x", new Object[]{Short.valueOf(this.Ws)}));
        }
        this.QX = ahq.Hw();
        if (j6) {
            lg.Hw(String.format("Internal attributes: 0x%04x", new Object[]{Short.valueOf(this.QX)}));
        }
        this.XL = ahq.FH();
        if (j6) {
            lg.Hw(String.format("External attributes: 0x%08x", new Object[]{Integer.valueOf(this.XL)}));
        }
        this.aM = ahq.FH();
        if (j6) {
            lg.Hw(String.format("Local header offset: 0x%08x", new Object[]{Integer.valueOf(this.aM)}));
        }
        this.EQ = ahq.DW(Hw);
        if (j6) {
            lg.Hw("Filename: " + this.EQ);
        }
        this.we = ahq.FH(Hw2);
        this.J8 = ahq.DW(Hw3);
        if (j6) {
            lg.Hw("File comment: " + this.J8);
        }
        this.Hw = (short) (this.Hw & 2048);
        if (this.tp == 0) {
            this.u7 = 0;
            this.v5 = (short) 0;
            this.gn = 0;
        }
    }

    public byte[] FH() {
        if (this.Mr != null) {
            return this.Mr;
        }
        byte[] bArr = new byte[this.tp];
        InputStream Hw = Hw();
        int i = 0;
        while (i != this.tp) {
            int read = Hw.read(bArr, i, this.tp - i);
            if (read < 0) {
                throw new IllegalStateException(String.format("Read failed, expecting %d bytes, got %d instead", new Object[]{Integer.valueOf(this.tp), Integer.valueOf(i)}));
            }
            i += read;
        }
        return bArr;
    }

    public InputStream Hw() {
        return j6(null);
    }

    public InputStream j6(OutputStream outputStream) {
        if (this.U2 != null) {
            this.U2.close();
            this.tp = this.U2.DW();
            this.Mr = ((ByteArrayOutputStream) this.U2.FH()).toByteArray();
            this.u7 = this.Mr.length;
            this.gn = this.U2.j6();
            this.U2 = null;
            InputStream byteArrayInputStream = new ByteArrayInputStream(this.Mr);
            if (this.v5 == (short) 0) {
                return byteArrayInputStream;
            }
            return new InflaterInputStream(new SequenceInputStream(byteArrayInputStream, new ByteArrayInputStream(new byte[1])), new Inflater(true));
        }
        InputStream aho = new aho(this);
        if (outputStream != null) {
            aho.j6(outputStream);
        }
        if (this.v5 == (short) 0) {
            return aho;
        }
        aho.j6(true);
        return new InflaterInputStream(aho, new Inflater(true));
    }

    public OutputStream v5() {
        this.U2 = new ahp(this.v5, new ByteArrayOutputStream());
        return this.U2;
    }

    public void DW(ahs ahs) {
        j6().j6();
        ahs.j6(33639248);
        ahs.j6(this.DW);
        ahs.j6(this.FH);
        ahs.j6(this.Hw);
        ahs.j6(this.v5);
        ahs.j6(this.Zo);
        ahs.j6(this.VH);
        ahs.j6(this.gn);
        ahs.j6(this.u7);
        ahs.j6(this.tp);
        ahs.j6((short) this.EQ.length());
        ahs.j6((short) (this.we.length + this.J0));
        ahs.j6((short) this.J8.length());
        ahs.j6(this.Ws);
        ahs.j6(this.QX);
        ahs.j6(this.XL);
        ahs.j6(this.aM);
        ahs.j6(this.EQ);
        ahs.j6(this.we);
        if (this.J0 > (short) 0) {
            ahs.j6(a8, 0, this.J0);
        }
        ahs.j6(this.J8);
    }

    public long Zo() {
        return new Date(((this.VH >> 9) & 127) + 80, ((this.VH >> 5) & 15) - 1, this.VH & 31, (this.Zo >> 11) & 31, (this.Zo >> 5) & 63, (this.Zo << 1) & 62).getTime();
    }

    public void j6(long j) {
        long j2;
        Date date = new Date(j);
        int year = date.getYear() + 1900;
        if (year < 1980) {
            j2 = 2162688;
        } else {
            j2 = (long) ((date.getSeconds() >> 1) | ((((((year - 1980) << 25) | ((date.getMonth() + 1) << 21)) | (date.getDate() << 16)) | (date.getHours() << 11)) | (date.getMinutes() << 5)));
        }
        this.VH = (short) ((int) (j2 >> 16));
        this.Zo = (short) ((int) (j2 & 65535));
    }

    public boolean VH() {
        return this.EQ.endsWith("/");
    }

    public String gn() {
        return this.EQ;
    }

    public short u7() {
        return this.v5;
    }

    public int tp() {
        return this.gn;
    }

    public int EQ() {
        return this.u7;
    }

    public int we() {
        return this.tp;
    }

    public long J0() {
        return this.j3;
    }

    public ahq J8() {
        return this.j6;
    }
}
