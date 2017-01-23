import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.eclipse.jgit.JGitText;

public class arn extends aub {
    private final CRC32 DW;
    private long EQ;
    private final MessageDigest FH;
    private int Hw;
    private Deflater J0;
    private aro J8;
    private File VH;
    private File Zo;
    private RandomAccessFile gn;
    private final arb j6;
    private byte[] tp;
    private long u7;
    private boolean v5;
    private byte[] we;

    arn(arb arb, InputStream inputStream) {
        super(arb, inputStream);
        this.j6 = arb;
        this.DW = new CRC32();
        this.FH = anj.j6();
        this.Hw = ((ank) this.j6.u7().j6(ank.j6)).DW();
    }

    public arw j6(aob aob, aob aob2) {
        this.Zo = File.createTempFile("incoming_", ".pack", this.j6.gn());
        this.VH = new File(this.j6.gn(), new StringBuilder(String.valueOf(j6(this.Zo))).append(".idx").toString());
        try {
            this.gn = new RandomAccessFile(this.Zo, "rw");
            super.j6(aob, aob2);
            this.gn.seek(this.EQ);
            this.gn.write(this.we);
            this.gn.getChannel().force(true);
            this.gn.close();
            J0();
            this.Zo.setReadOnly();
            this.VH.setReadOnly();
            arw DW = DW(gn());
            try {
                if (this.gn != null && this.gn.getChannel().isOpen()) {
                    this.gn.close();
                }
            } catch (IOException e) {
            }
            we();
            return DW;
        } finally {
            if (this.J0 != null) {
                this.J0.end();
            }
            try {
                if (this.gn != null && this.gn.getChannel().isOpen()) {
                    this.gn.close();
                }
            } catch (IOException e2) {
            }
            we();
        }
    }

    protected void j6(long j) {
    }

    protected void j6(long j, int i, long j2) {
        this.DW.reset();
    }

    protected void j6(aud aud) {
        aud.Zo((int) this.DW.getValue());
    }

    protected void j6(long j, long j2, long j3) {
        this.DW.reset();
    }

    protected void j6(long j, anb anb, long j2) {
        this.DW.reset();
    }

    protected aub$f j6() {
        aub$f aub_f = new aub$f();
        aub_f.j6((int) this.DW.getValue());
        return aub_f;
    }

    protected void j6(aud aud, int i, byte[] bArr) {
    }

    protected void j6(aub$e aub_e, byte[] bArr, int i, int i2) {
        this.DW.update(bArr, i, i2);
    }

    protected void DW(aub$e aub_e, byte[] bArr, int i, int i2) {
        this.DW.update(bArr, i, i2);
    }

    protected void j6(byte[] bArr, int i, int i2) {
        this.gn.write(bArr, i, i2);
    }

    protected void j6(byte[] bArr) {
        this.EQ = this.gn.getFilePointer();
        this.u7 = this.EQ;
        this.tp = bArr;
        this.we = bArr;
    }

    protected aub$d j6(aub$f aub_f, aub$d aub_d) {
        this.gn.seek(aub_f.j6());
        this.DW.reset();
        return j6(aub_d);
    }

    protected aub$d j6(aud aud, aub$d aub_d) {
        this.gn.seek(aud.yS());
        this.DW.reset();
        return j6(aub_d);
    }

    protected int DW(byte[] bArr, int i, int i2) {
        return this.gn.read(bArr, i, i2);
    }

    protected boolean j6(int i) {
        return i == ((int) this.DW.getValue());
    }

    private static String j6(File file) {
        String name = file.getName();
        return name.substring(0, name.lastIndexOf(46));
    }

    private void we() {
        if (!(this.VH == null || this.VH.delete() || !this.VH.exists())) {
            this.VH.deleteOnExit();
        }
        if (this.Zo != null && !this.Zo.delete() && this.Zo.exists()) {
            this.Zo.deleteOnExit();
        }
    }

    protected boolean j6(int i, byte[] bArr, aud aud) {
        aud.j6(this.EQ);
        byte[] tp = tp();
        int length = bArr.length;
        tp[0] = (byte) ((i << 4) | (length & 15));
        int i2 = length >>> 4;
        length = 1;
        while (i2 > 0) {
            int i3 = length - 1;
            tp[i3] = (byte) (tp[i3] | 128);
            i3 = length + 1;
            tp[length] = (byte) (i2 & 127);
            i2 >>>= 7;
            length = i3;
        }
        this.FH.update(tp, 0, length);
        this.DW.reset();
        this.DW.update(tp, 0, length);
        this.gn.seek(this.EQ);
        this.gn.write(tp, 0, length);
        this.EQ += (long) length;
        if (this.J0 == null) {
            this.J0 = new Deflater(-1, false);
        } else {
            this.J0.reset();
        }
        this.J0.setInput(bArr);
        this.J0.finish();
        while (!this.J0.finished()) {
            length = this.J0.deflate(tp);
            this.FH.update(tp, 0, length);
            this.DW.update(tp, 0, length);
            this.gn.write(tp, 0, length);
            this.EQ += (long) length;
        }
        aud.Zo((int) this.DW.getValue());
        return true;
    }

    protected void DW() {
        byte[] digest = this.FH.digest();
        byte[] tp = tp();
        MessageDigest j6 = anj.j6();
        MessageDigest j62 = anj.j6();
        MessageDigest j63 = anj.j6();
        long j = this.u7;
        this.gn.seek(0);
        this.gn.readFully(tp, 0, 12);
        j6.update(tp, 0, 12);
        j -= 12;
        axb.DW(tp, 8, u7());
        this.gn.seek(0);
        this.gn.write(tp, 0, 12);
        j63.update(tp, 0, 12);
        while (true) {
            int read = this.gn.read(tp);
            if (read < 0) {
                break;
            }
            if (j != 0) {
                int min = (int) Math.min((long) read, j);
                j6.update(tp, 0, min);
                j -= (long) min;
                if (j == 0) {
                    j62.update(tp, min, read - min);
                }
            } else {
                j62.update(tp, 0, read);
            }
            j63.update(tp, 0, read);
        }
        if (Arrays.equals(j6.digest(), this.tp) && Arrays.equals(j62.digest(), digest)) {
            this.we = j63.digest();
            return;
        }
        throw new IOException(JGitText.j6().packCorruptedWhileWritingToFilesystem);
    }

    private void J0() {
        List j6 = j6(null);
        OutputStream fileOutputStream = new FileOutputStream(this.VH);
        try {
            ars j62;
            if (this.Hw <= 0) {
                j62 = ars.j6(fileOutputStream, j6);
            } else {
                j62 = ars.j6(fileOutputStream, this.Hw);
            }
            j62.j6(j6, this.we);
            fileOutputStream.getChannel().force(true);
        } finally {
            fileOutputStream.close();
        }
    }

    private arw DW(String str) {
        if (this.v5 || u7() != 0) {
            MessageDigest j6 = anj.j6();
            byte[] bArr = new byte[20];
            for (int i = 0; i < u7(); i++) {
                DW(i).DW(bArr, 0);
                j6.update(bArr);
            }
            String DW = ans.j6(j6.digest()).DW();
            File file = new File(this.j6.gn(), "pack");
            File file2 = new File(file, "pack-" + DW + ".pack");
            File file3 = new File(file, "pack-" + DW + ".idx");
            arw arw = new arw(file2, this.j6.tp());
            if (!file.exists() && !file.mkdir() && !file.exists()) {
                we();
                throw new IOException(MessageFormat.format(JGitText.j6().cannotCreateDirectory, new Object[]{file.getAbsolutePath()}));
            } else if (file2.exists()) {
                we();
                return null;
            } else {
                if (str != null) {
                    try {
                        if (!arw.j6(str)) {
                            throw new alg(file2, MessageFormat.format(JGitText.j6().cannotLockPackIn, new Object[]{file2}));
                        }
                    } catch (IOException e) {
                        we();
                        throw e;
                    }
                }
                if (!this.Zo.renameTo(file2)) {
                    we();
                    arw.j6();
                    throw new IOException(MessageFormat.format(JGitText.j6().cannotMovePackTo, new Object[]{file2}));
                } else if (this.VH.renameTo(file3)) {
                    try {
                        this.J8 = this.j6.j6(file2, file3);
                        if (str == null) {
                            arw = null;
                        }
                        return arw;
                    } catch (IOException e2) {
                        arw.j6();
                        if (file2.exists()) {
                            awv.j6(file2);
                        }
                        if (file3.exists()) {
                            awv.j6(file3);
                        }
                        throw e2;
                    }
                } else {
                    we();
                    arw.j6();
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                    throw new IOException(MessageFormat.format(JGitText.j6().cannotMoveIndexTo, new Object[]{file3}));
                }
            }
        }
        we();
        return null;
    }
}
