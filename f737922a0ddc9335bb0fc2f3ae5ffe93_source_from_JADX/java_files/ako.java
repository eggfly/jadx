import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import org.eclipse.jgit.JGitText;

public class ako {
    private static final byte[] DW;
    private static final akt[] FH;
    private static final byte[] Hw;
    static final Comparator<akt> j6;
    private are EQ;
    private byte[] J0;
    private ami J8;
    private int VH;
    private akt[] Zo;
    private akv gn;
    private final awp tp;
    private ark u7;
    private final File v5;
    private byte[] we;

    static {
        DW = new byte[]{(byte) 68, (byte) 73, (byte) 82, (byte) 67};
        FH = new akt[0];
        Hw = new byte[0];
        j6 = new ako$1();
    }

    static int j6(akt akt, akt akt2) {
        return j6(akt.j6, akt.j6.length, akt2);
    }

    static int j6(byte[] bArr, int i, akt akt) {
        return j6(bArr, i, akt.j6, akt.j6.length);
    }

    static int j6(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (i3 < i && i3 < i2) {
            int i4 = (bArr[i3] & 255) - (bArr2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
            i3++;
        }
        return i - i2;
    }

    public static ako j6() {
        return new ako(null, null);
    }

    public static ako j6(File file, awp awp) {
        ako ako = new ako(file, awp);
        ako.Hw();
        return ako;
    }

    public static ako DW(File file, awp awp) {
        ako ako = new ako(file, awp);
        if (ako.Zo()) {
            try {
                ako.Hw();
                return ako;
            } catch (IOException e) {
                ako.u7();
                throw e;
            } catch (RuntimeException e2) {
                ako.u7();
                throw e2;
            } catch (Error e3) {
                ako.u7();
                throw e3;
            }
        }
        throw new alg(file);
    }

    public static ako j6(File file, awp awp, ami ami) {
        ako DW = DW(file, awp);
        DW.j6(ami);
        return DW;
    }

    public ako(File file, awp awp) {
        this.v5 = file;
        this.tp = awp;
        v5();
    }

    public akq DW() {
        return new akq(this, this.VH + 16);
    }

    public aks FH() {
        return new aks(this, this.VH + 16);
    }

    void j6(akt[] aktArr, int i) {
        this.Zo = aktArr;
        this.VH = i;
        this.gn = null;
    }

    public void Hw() {
        if (this.v5 == null) {
            throw new IOException(JGitText.j6().dirCacheDoesNotHaveABackingFile);
        } else if (!this.v5.exists()) {
            v5();
        } else if (this.EQ == null || this.EQ.DW(this.v5)) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(this.v5);
                v5();
                j6(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (FileNotFoundException e2) {
                v5();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
            }
            this.EQ = are.j6(this.v5);
        }
    }

    public void v5() {
        this.EQ = null;
        this.Zo = FH;
        this.VH = 0;
        this.gn = null;
        this.we = Hw;
    }

    private void j6(InputStream inputStream) {
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        MessageDigest j6 = anj.j6();
        byte[] bArr = new byte[20];
        awx.j6(bufferedInputStream, bArr, 0, 12);
        j6.update(bArr, 0, 12);
        if (DW(bArr)) {
            boolean z;
            int DW = axb.DW(bArr, 4);
            if (DW == 3) {
                z = true;
            } else if (DW != 2) {
                throw new ala(MessageFormat.format(JGitText.j6().unknownDIRCVersion, new Object[]{Integer.valueOf(DW)}));
            } else {
                z = false;
            }
            this.VH = axb.DW(bArr, 8);
            if (this.VH >= 0) {
                byte[] bArr2 = new byte[(akt.j6(z) * this.VH)];
                this.Zo = new akt[this.VH];
                axa axa = new axa();
                for (DW = 0; DW < this.VH; DW++) {
                    this.Zo[DW] = new akt(bArr2, axa, bufferedInputStream, j6);
                }
                this.EQ = are.j6(this.v5);
                while (true) {
                    bufferedInputStream.mark(21);
                    awx.j6(bufferedInputStream, bArr, 0, 20);
                    if (bufferedInputStream.read() >= 0) {
                        bufferedInputStream.reset();
                        j6.update(bArr, 0, 8);
                        awx.j6(bufferedInputStream, 8);
                        long FH = axb.FH(bArr, 4);
                        switch (axb.DW(bArr, 0)) {
                            case 1414677829:
                                if (2147483647L >= FH) {
                                    byte[] bArr3 = new byte[((int) FH)];
                                    awx.j6(bufferedInputStream, bArr3, 0, bArr3.length);
                                    j6.update(bArr3, 0, bArr3.length);
                                    this.gn = new akv(bArr3, new axa(), null);
                                    break;
                                }
                                throw new ala(MessageFormat.format(JGitText.j6().DIRCExtensionIsTooLargeAt, new Object[]{j6(bArr), Long.valueOf(FH)}));
                            default:
                                if (bArr[0] >= 65 && bArr[0] <= 90) {
                                    j6(bufferedInputStream, j6, bArr, FH);
                                    break;
                                }
                                throw new ala(MessageFormat.format(JGitText.j6().DIRCExtensionNotSupportedByThisVersion, new Object[]{j6(bArr)}));
                                break;
                        }
                    }
                    this.we = j6.digest();
                    if (!Arrays.equals(this.we, bArr)) {
                        throw new ala(JGitText.j6().DIRCChecksumMismatch);
                    }
                    return;
                }
            }
            throw new ala(JGitText.j6().DIRCHasTooManyEntries);
        }
        throw new ala(JGitText.j6().notADIRCFile);
    }

    private void j6(InputStream inputStream, MessageDigest messageDigest, byte[] bArr, long j) {
        byte[] bArr2 = new byte[4096];
        while (0 < j) {
            int read = inputStream.read(bArr2, 0, (int) Math.min((long) bArr2.length, j));
            if (read < 0) {
                throw new EOFException(MessageFormat.format(JGitText.j6().shortReadOfOptionalDIRCExtensionExpectedAnotherBytes, new Object[]{j6(bArr), Long.valueOf(j)}));
            }
            messageDigest.update(bArr2, 0, read);
            j -= (long) read;
        }
    }

    private static String j6(byte[] bArr) {
        return "'" + new String(bArr, 0, 4, "ISO-8859-1") + "'";
    }

    private static boolean DW(byte[] bArr) {
        if (bArr.length < DW.length) {
            return false;
        }
        for (int i = 0; i < DW.length; i++) {
            if (bArr[i] != DW[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean Zo() {
        if (this.v5 == null) {
            throw new IOException(JGitText.j6().dirCacheDoesNotHaveABackingFile);
        }
        ark ark = new ark(this.v5, this.tp);
        if (!ark.j6()) {
            return false;
        }
        ark.j6(true);
        this.u7 = ark;
        return true;
    }

    public void VH() {
        ark ark = this.u7;
        j6(ark);
        try {
            j6(new axp(ark.DW()));
        } catch (IOException e) {
            ark.Zo();
            throw e;
        } catch (RuntimeException e2) {
            ark.Zo();
            throw e2;
        } catch (Error e3) {
            ark.Zo();
            throw e3;
        }
    }

    void j6(OutputStream outputStream) {
        int i;
        MessageDigest j6 = anj.j6();
        OutputStream digestOutputStream = new DigestOutputStream(outputStream, j6);
        int i2 = 0;
        for (i = 0; i < this.VH; i++) {
            i2 |= this.Zo[i].Ws();
        }
        byte[] bArr = new byte[128];
        System.arraycopy(DW, 0, bArr, 0, DW.length);
        axb.DW(bArr, 4, i2 != 0 ? 3 : 2);
        axb.DW(bArr, 8, this.VH);
        digestOutputStream.write(bArr, 0, 12);
        if (this.EQ == null) {
            for (i = 0; i < this.VH; i++) {
                this.Zo[i].j6(digestOutputStream);
            }
        } else {
            i2 = (int) (this.EQ.j6() / 1000);
            int j62 = 1000000 * ((int) (this.EQ.j6() % 1000));
            for (i = 0; i < this.VH; i++) {
                akt akt = this.Zo[i];
                if (akt.j6(i2, j62)) {
                    akt.j6();
                }
                akt.j6(digestOutputStream);
            }
        }
        if (this.gn != null) {
            OutputStream axj_d = new axj$d();
            this.gn.j6(bArr, axj_d);
            axj_d.close();
            axb.DW(bArr, 0, 1414677829);
            axb.DW(bArr, 4, (int) axj_d.DW());
            digestOutputStream.write(bArr, 0, 8);
            axj_d.j6(digestOutputStream, null);
        }
        this.J0 = j6.digest();
        outputStream.write(this.J0);
        outputStream.close();
    }

    public boolean gn() {
        ark ark = this.u7;
        j6(ark);
        this.u7 = null;
        if (!ark.Hw()) {
            return false;
        }
        this.EQ = ark.v5();
        if (!(this.J8 == null || Arrays.equals(this.we, this.J0))) {
            this.J8.j6(new amh());
        }
        return true;
    }

    private void j6(ark ark) {
        if (this.v5 == null) {
            throw new IllegalStateException(JGitText.j6().dirCacheIsNotLocked);
        } else if (ark == null) {
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().dirCacheFileIsNotLocked, new Object[]{this.v5.getAbsolutePath()}));
        }
    }

    public void u7() {
        ark ark = this.u7;
        if (ark != null) {
            this.u7 = null;
            ark.Zo();
        }
    }

    public int j6(String str) {
        byte[] DW = anj.DW(str);
        return j6(DW, DW.length);
    }

    int j6(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = this.VH;
        while (i2 < i3) {
            int i4 = (i2 + i3) >>> 1;
            int j6 = j6(bArr, i, this.Zo[i4]);
            if (j6 < 0) {
                i3 = i4;
            } else if (j6 == 0) {
                while (i4 > 0 && j6(bArr, i, this.Zo[i4 - 1]) == 0) {
                    i4--;
                }
                return i4;
            } else {
                i2 = i4 + 1;
            }
        }
        return -(i2 + 1);
    }

    public int j6(int i) {
        akt akt = this.Zo[i];
        int i2 = i + 1;
        while (i2 < this.VH) {
            akt akt2 = this.Zo[i2];
            if (j6(akt, akt2) != 0) {
                break;
            }
            i2++;
            akt = akt2;
        }
        return i2;
    }

    int j6(byte[] bArr, int i, int i2) {
        while (i2 < this.VH && akv.j6(bArr, this.Zo[i2].j6, i)) {
            i2++;
        }
        return i2;
    }

    public int tp() {
        return this.VH;
    }

    public akt DW(int i) {
        return this.Zo[i];
    }

    public akt DW(String str) {
        int j6 = j6(str);
        return j6 < 0 ? null : this.Zo[j6];
    }

    void j6(int i, akt[] aktArr, int i2, int i3) {
        System.arraycopy(this.Zo, i, aktArr, i2, i3);
    }

    public akv j6(boolean z) {
        if (z) {
            if (this.gn == null) {
                this.gn = new akv();
            }
            this.gn.j6(this.Zo, this.VH, 0, 0);
        }
        return this.gn;
    }

    public ans j6(anw anw) {
        return j6(true).j6(this.Zo, 0, 0, anw);
    }

    public boolean EQ() {
        for (int i = 0; i < this.VH; i++) {
            if (this.Zo[i].VH() > 0) {
                return true;
            }
        }
        return false;
    }

    private void j6(ami ami) {
        this.J8 = ami;
    }
}
