import com.aide.uidesigner.ProxyTextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import org.eclipse.jgit.JGitText;

public class asc {
    public static anx j6(byte[] bArr, anb anb) {
        asg asg = new asg(null);
        try {
            anx j6 = j6(new ByteArrayInputStream(bArr), null, anb, asg);
            return j6;
        } finally {
            asg.FH();
        }
    }

    static anx j6(InputStream inputStream, File file, anb anb, asg asg) {
        try {
            InputStream DW = DW(inputStream);
            DW.mark(20);
            byte[] bArr = new byte[64];
            awx.j6(DW, bArr, 0, 2);
            Inflater Zo;
            int DW2;
            int j6;
            long DW3;
            alf$a alf_a;
            int i;
            if (DW(bArr)) {
                DW.reset();
                Zo = asg.Zo();
                InputStream j62 = j6(DW, Zo);
                DW2 = DW(j62, bArr, 0, 64);
                if (DW2 < 5) {
                    throw new ala(anb, JGitText.j6().corruptObjectNoHeader);
                }
                axa axa = new axa();
                j6 = anj.j6(anb, bArr, (byte) 32, axa);
                DW3 = axe.DW(bArr, axa.j6, axa);
                if (DW3 < 0) {
                    throw new ala(anb, JGitText.j6().corruptObjectNegativeSize);
                }
                int i2 = axa.j6;
                axa.j6 = i2 + 1;
                if (bArr[i2] != null) {
                    throw new ala(anb, JGitText.j6().corruptObjectGarbageAfterSize);
                } else if (file == null && 2147483647L < DW3) {
                    alf_a = new alf$a();
                    alf_a.j6(anb);
                    throw alf_a;
                } else if (DW3 < ((long) asg.VH()) || file == null) {
                    Object obj = new byte[((int) DW3)];
                    i = DW2 - axa.j6;
                    if (i > 0) {
                        System.arraycopy(bArr, axa.j6, obj, 0, i);
                    }
                    awx.j6(j62, obj, i, obj.length - i);
                    DW(DW, Zo, anb, bArr);
                    return new anx$a(j6, obj);
                } else {
                    return new asc$a(DW3, file, anb, asg.DW, null);
                }
            }
            DW(DW, bArr, 2, 18);
            i = bArr[0] & 255;
            j6 = (i >> 4) & 7;
            int i3 = 1;
            long j = (long) (i & 15);
            DW2 = 4;
            int i4 = i;
            DW3 = j;
            while ((i4 & 128) != 0) {
                int i5 = bArr[i3] & 255;
                DW3 += (long) ((i5 & 127) << DW2);
                DW2 += 7;
                i3++;
                i4 = i5;
            }
            switch (j6) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    if (file == null && 2147483647L < DW3) {
                        alf_a = new alf$a();
                        alf_a.j6(anb);
                        throw alf_a;
                    } else if (DW3 < ((long) asg.VH()) || file == null) {
                        DW.reset();
                        awx.j6(DW, (long) i3);
                        Zo = asg.Zo();
                        byte[] bArr2 = new byte[((int) DW3)];
                        awx.j6(j6(DW, Zo), bArr2, 0, bArr2.length);
                        DW(DW, Zo, anb, bArr);
                        return new anx$a(j6, bArr2);
                    } else {
                        return new asc$a(DW3, file, anb, asg.DW, null);
                    }
                default:
                    throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
            }
        } catch (ZipException e) {
            throw new ala(anb, JGitText.j6().corruptObjectBadStream);
        }
    }

    static long j6(InputStream inputStream, anb anb, asg asg) {
        try {
            long DW;
            InputStream DW2 = DW(inputStream);
            DW2.mark(20);
            byte[] bArr = new byte[64];
            awx.j6(DW2, bArr, 0, 2);
            if (DW(bArr)) {
                DW2.reset();
                if (DW(j6(DW2, asg.Zo()), bArr, 0, 64) < 5) {
                    throw new ala(anb, JGitText.j6().corruptObjectNoHeader);
                }
                axa axa = new axa();
                anj.j6(anb, bArr, (byte) 32, axa);
                DW = axe.DW(bArr, axa.j6, axa);
                if (DW < 0) {
                    throw new ala(anb, JGitText.j6().corruptObjectNegativeSize);
                }
            }
            DW(DW2, bArr, 2, 18);
            int i = bArr[0] & 255;
            DW = (long) (i & 15);
            int i2 = 1;
            int i3 = i;
            i = 4;
            while ((i3 & 128) != 0) {
                i3 = i2 + 1;
                i2 = bArr[i2] & 255;
                long j = ((long) ((i2 & 127) << i)) + DW;
                i += 7;
                DW = j;
                int i4 = i3;
                i3 = i2;
                i2 = i4;
            }
            return DW;
        } catch (ZipException e) {
            throw new ala(anb, JGitText.j6().corruptObjectBadStream);
        }
    }

    private static void DW(InputStream inputStream, Inflater inflater, anb anb, byte[] bArr) {
        while (inflater.inflate(bArr) == 0) {
            try {
                if (inflater.finished()) {
                    if (inflater.getRemaining() != 0 || inputStream.read() != -1) {
                        throw new ala(anb, JGitText.j6().corruptObjectBadStream);
                    }
                    return;
                } else if (inflater.needsInput()) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        throw new ala(anb, JGitText.j6().corruptObjectBadStream);
                    }
                    inflater.setInput(bArr, 0, read);
                } else {
                    throw new ala(anb, JGitText.j6().corruptObjectBadStream);
                }
            } catch (DataFormatException e) {
                throw new ala(anb, JGitText.j6().corruptObjectBadStream);
            }
        }
        throw new ala(anb, JGitText.j6().corruptObjectIncorrectLength);
    }

    private static boolean DW(byte[] bArr) {
        int i = bArr[0] & 255;
        if ((i & 143) == 8 && ((i << 8) | (bArr[1] & 255)) % 31 == 0) {
            return true;
        }
        return false;
    }

    private static InputStream DW(InputStream inputStream, long j, ans ans) {
        return new asc$1(inputStream, ann.j6(), j, ans);
    }

    private static InflaterInputStream j6(InputStream inputStream, Inflater inflater) {
        return new InflaterInputStream(inputStream, inflater, 8192);
    }

    private static BufferedInputStream DW(InputStream inputStream) {
        return new BufferedInputStream(inputStream, 8192);
    }

    private static int DW(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read < 0) {
                break;
            }
            i3 += read;
            i += read;
            i2 -= read;
        }
        return i3;
    }
}
