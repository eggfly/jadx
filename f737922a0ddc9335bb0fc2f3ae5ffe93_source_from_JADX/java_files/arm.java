import com.aide.uidesigner.ProxyTextView;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

class arm extends anw {
    private static /* synthetic */ int[] Hw;
    private final ash DW;
    private Deflater FH;
    private final arb j6;

    static /* synthetic */ int[] Zo() {
        int[] iArr = Hw;
        if (iArr == null) {
            iArr = new int[arb$c.values().length];
            try {
                iArr[arb$c.EXISTS_LOOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[arb$c.EXISTS_PACKED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[arb$c.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[arb$c.INSERTED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            Hw = iArr;
        }
        return iArr;
    }

    arm(arb arb, ani ani) {
        this.j6 = arb;
        this.DW = (ash) ani.j6(ash.j6);
    }

    public ans DW(int i, byte[] bArr, int i2, int i3) {
        anb j6 = j6(i, bArr, i2, i3);
        return this.j6.j6(j6) ? j6 : j6(FH(i, bArr, i2, i3), j6);
    }

    public ans j6(int i, long j, InputStream inputStream) {
        if (j <= ((long) j6().length)) {
            byte[] j6 = j6();
            return DW(i, j6, 0, awx.j6(inputStream, j6, 0));
        }
        MessageDigest DW = DW();
        return j6(j6(DW, i, j, inputStream), ans.j6(DW.digest()));
    }

    private ans j6(File file, ans ans) {
        switch (Zo()[this.j6.j6(file, ans, false).ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return ans;
            default:
                throw new aln("Unable to create new object: " + this.j6.FH((anb) ans));
        }
    }

    public aub j6(InputStream inputStream) {
        return new arn(this.j6, inputStream);
    }

    public void FH() {
    }

    public void Hw() {
        if (this.FH != null) {
            try {
                this.FH.end();
            } finally {
                this.FH = null;
            }
        }
    }

    private File j6(MessageDigest messageDigest, int i, long j, InputStream inputStream) {
        File v5 = v5();
        OutputStream fileOutputStream;
        try {
            OutputStream newOutputStream;
            fileOutputStream = new FileOutputStream(v5);
            if (this.DW.DW()) {
                newOutputStream = Channels.newOutputStream(fileOutputStream.getChannel());
            } else {
                newOutputStream = fileOutputStream;
            }
            newOutputStream = j6(newOutputStream);
            OutputStream digestOutputStream = new DigestOutputStream(newOutputStream, messageDigest);
            j6(digestOutputStream, i, j);
            byte[] j6 = j6();
            while (j > 0) {
                int read = inputStream.read(j6, 0, (int) Math.min(j, (long) j6.length));
                if (read <= 0) {
                    throw j6(j);
                }
                digestOutputStream.write(j6, 0, read);
                j -= (long) read;
            }
            digestOutputStream.flush();
            newOutputStream.finish();
            if (this.DW.DW()) {
                fileOutputStream.getChannel().force(true);
            }
            fileOutputStream.close();
            return v5;
        } catch (Throwable th) {
            awv.j6(v5);
        }
    }

    private File FH(int i, byte[] bArr, int i2, int i3) {
        File v5 = v5();
        OutputStream fileOutputStream;
        try {
            OutputStream newOutputStream;
            fileOutputStream = new FileOutputStream(v5);
            if (this.DW.DW()) {
                newOutputStream = Channels.newOutputStream(fileOutputStream.getChannel());
            } else {
                newOutputStream = fileOutputStream;
            }
            newOutputStream = j6(newOutputStream);
            j6(newOutputStream, i, (long) i3);
            newOutputStream.write(bArr, i2, i3);
            newOutputStream.finish();
            if (this.DW.DW()) {
                fileOutputStream.getChannel().force(true);
            }
            fileOutputStream.close();
            return v5;
        } catch (Throwable th) {
            awv.j6(v5);
        }
    }

    void j6(OutputStream outputStream, int i, long j) {
        outputStream.write(anj.DW(i));
        outputStream.write(32);
        outputStream.write(anj.j6(j));
        outputStream.write(0);
    }

    File v5() {
        return File.createTempFile("noz", null, this.j6.gn());
    }

    DeflaterOutputStream j6(OutputStream outputStream) {
        if (this.FH == null) {
            this.FH = new Deflater(this.DW.j6());
        } else {
            this.FH.reset();
        }
        return new DeflaterOutputStream(outputStream, this.FH, 8192);
    }

    private static EOFException j6(long j) {
        return new EOFException("Input did not match supplied length. " + j + " bytes are missing.");
    }
}
