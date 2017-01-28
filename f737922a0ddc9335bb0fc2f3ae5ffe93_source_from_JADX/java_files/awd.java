import com.aide.uidesigner.ProxyTextView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import org.eclipse.jgit.JGitText;

public abstract class awd extends avx {
    protected static final awd$a[] FH;
    private static final Comparator<awd$a> Mr;
    private static /* synthetic */ int[] U2;
    private static /* synthetic */ int[] a8;
    private static final byte[] aM;
    private static final byte[] j3;
    private static /* synthetic */ int[] lg;
    private byte[] DW;
    protected aoh Hw;
    private int J0;
    private awd$a[] J8;
    private int QX;
    private int Ws;
    private amx XL;
    private final awd$b j6;

    static /* synthetic */ int[] U2() {
        int[] iArr = U2;
        if (iArr == null) {
            iArr = new int[ank$a.values().length];
            try {
                iArr[ank$a.FALSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ank$a.INPUT.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ank$a.TRUE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            U2 = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] a8() {
        int[] iArr = a8;
        if (iArr == null) {
            iArr = new int[amx$a.values().length];
            try {
                iArr[amx$a.CHECK_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[amx$a.IGNORED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[amx$a.NOT_IGNORED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            a8 = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] lg() {
        int[] iArr = lg;
        if (iArr == null) {
            iArr = new int[awd$c.values().length];
            try {
                iArr[awd$c.DIFFER_BY_METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[awd$c.DIFFER_BY_TIMESTAMP.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[awd$c.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[awd$c.SMUDGED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            lg = iArr;
        }
        return iArr;
    }

    static {
        FH = new awd$a[0];
        aM = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57};
        j3 = anj.DW(3);
        Mr = new awd$1();
    }

    protected awd(awe awe) {
        this.j6 = new awd$b(awe);
    }

    protected awd(awd awd) {
        super((avx) awd);
        this.j6 = awd.j6;
    }

    protected void j6(aoh aoh) {
        awd$a awd_a;
        this.Hw = aoh;
        if (this.XL instanceof awd$d) {
            awd_a = ((awd$d) this.XL).j6;
        } else {
            awd_a = null;
        }
        this.XL = new awd$e(awd_a, aoh);
    }

    public boolean Hw() {
        if (this.J0 == this.QX || (this.u7 & 61440) == 32768) {
            return true;
        }
        return false;
    }

    public byte[] v5() {
        if (this.J0 == this.QX) {
            return this.DW;
        }
        if (this.j6.v5 != null) {
            aku aku = (aku) this.j6.v5.j6(this.j6.Zo, aku.class);
            if (aku != null) {
                akt tp = aku.tp();
                if (tp != null && j6(tp) == awd$c.EQUAL) {
                    return aku.v5();
                }
            }
        }
        byte[] FH;
        switch (this.u7 & 61440) {
            case 32768:
                this.J0 = this.QX;
                FH = FH(this.J8[this.QX]);
                this.DW = FH;
                return FH;
            case 40960:
                return v5;
            case 57344:
                this.J0 = this.QX;
                FH = j6(this.J8[this.QX]);
                this.DW = FH;
                return FH;
            default:
                return v5;
        }
    }

    protected byte[] j6(awd$a awd_a) {
        if (this.Hw == null) {
            return v5;
        }
        try {
            return j6(this.Hw.Mr(), awd_a);
        } catch (all e) {
            return v5;
        }
    }

    protected byte[] j6(File file, awd$a awd_a) {
        try {
            aoh j6 = atd.j6(file, awd_a.DW());
            if (j6 == null) {
                return v5;
            }
            byte[] bArr;
            try {
                bArr = "HEAD";
                ans DW = j6.DW(bArr);
                if (DW == null) {
                    return v5;
                }
                bArr = new byte[20];
                DW.DW(bArr, 0);
                return bArr;
            } catch (IOException e) {
                bArr = v5;
                return bArr;
            } finally {
                j6.tp();
            }
        } catch (IOException e2) {
            return v5;
        }
    }

    private byte[] FH(awd$a awd_a) {
        try {
            InputStream v5 = awd_a.v5();
            if (v5 == null) {
                return v5;
            }
            byte[] j6;
            try {
                this.j6.j6();
                long FH = awd_a.FH();
                if (tp()) {
                    long j = 65536;
                    if (FH <= j) {
                        ByteBuffer j62 = awx.j6(v5, (int) FH);
                        byte[] array = j62.array();
                        int limit = j62.limit();
                        if (!j6(array, limit)) {
                            j62 = DW(array, limit);
                            array = j62.array();
                            limit = j62.limit();
                        }
                        j6 = j6(new ByteArrayInputStream(array, 0, limit), (long) limit);
                        j6(v5);
                        return j6;
                    } else if (Hw(awd_a)) {
                        j6 = j6(v5, FH);
                        j6(v5);
                        return j6;
                    } else {
                        j6 = DW(awd_a.v5());
                        j = FH((InputStream) j6);
                        j6 = j6(DW(v5), j);
                        j6(v5);
                        return j6;
                    }
                }
                j6 = j6(v5, FH);
                return j6;
            } catch (Throwable th) {
                j6 = th;
            } finally {
                j6(r0);
            }
        } catch (IOException e) {
            return v5;
        }
    }

    private static void j6(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
        }
    }

    private boolean tp() {
        switch (U2()[Ws().DW().ordinal()]) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return true;
            default:
                return false;
        }
    }

    private boolean j6(byte[] bArr, int i) {
        return ake.j6(bArr, i);
    }

    private boolean Hw(awd$a awd_a) {
        InputStream v5 = awd_a.v5();
        try {
            boolean j6 = ake.j6(v5);
            return j6;
        } finally {
            j6(v5);
        }
    }

    private ByteBuffer DW(byte[] bArr, int i) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ByteBuffer j6 = awx.j6(DW(byteArrayInputStream), i);
            return j6;
        } finally {
            j6(byteArrayInputStream);
        }
    }

    private InputStream DW(InputStream inputStream) {
        return new axm(inputStream);
    }

    public awe Ws() {
        return this.j6.j6;
    }

    public int Zo() {
        return 0;
    }

    public void VH() {
        if (!gn()) {
            this.QX = 0;
            if (!u7()) {
                rN();
            }
        }
    }

    public boolean gn() {
        return this.QX == 0;
    }

    public boolean u7() {
        return this.QX == this.Ws;
    }

    public void j6(int i) {
        this.QX += i;
        if (!u7()) {
            rN();
        }
    }

    public void DW(int i) {
        this.QX -= i;
        rN();
    }

    private void rN() {
        awd$a awd_a = this.J8[this.QX];
        this.u7 = awd_a.j6().FH();
        int i = awd_a.FH;
        j6(this.EQ + i, this.EQ);
        System.arraycopy(awd_a.DW, 0, this.tp, this.EQ, i);
        this.we = this.EQ + i;
    }

    public long QX() {
        return Mr().FH();
    }

    public long XL() {
        return Mr().Hw();
    }

    public InputStream aM() {
        InputStream v5 = Mr().v5();
        if (Ws().DW() != ank$a.FALSE) {
            return new axm(v5);
        }
        return v5;
    }

    public boolean j3() {
        return Hw(this.we);
    }

    protected boolean Hw(int i) {
        amx er = er();
        if (er != null) {
            int i2 = this.EQ;
            if (i2 > 0) {
                i2--;
            }
            switch (a8()[er.j6(awc.j6(this.tp, i2, i), anl.j6.DW(this.u7)).ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    return false;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    return true;
            }
        }
        if (this.Zo instanceof awd) {
            return ((awd) this.Zo).Hw(i);
        }
        return false;
    }

    private amx er() {
        if (this.XL instanceof awd$d) {
            this.XL = ((awd$d) this.XL).DW();
        }
        return this.XL;
    }

    static int DW(awd$a awd_a) {
        return awd_a.j6() == anl.j6 ? 47 : 0;
    }

    protected void j6(awd$a[] awd_aArr) {
        this.J8 = awd_aArr;
        CharsetEncoder charsetEncoder = this.j6.DW;
        int i = 0;
        for (int i2 = 0; i2 < this.J8.length; i2++) {
            awd$a awd_a = this.J8[i2];
            if (awd_a != null) {
                String DW = awd_a.DW();
                if (!(".".equals(DW) || "..".equals(DW) || ".git".equals(DW))) {
                    if (".gitignore".equals(DW)) {
                        this.XL = new awd$d(awd_a);
                    }
                    if (i2 != i) {
                        this.J8[i] = awd_a;
                    }
                    awd_a.j6(charsetEncoder);
                    i++;
                }
            }
        }
        this.Ws = i;
        Arrays.sort(this.J8, 0, this.Ws, Mr);
        this.J0 = -1;
        this.QX = 0;
        if (!u7()) {
            rN();
        }
    }

    protected awd$a Mr() {
        return this.J8[this.QX];
    }

    public awd$c j6(akt akt) {
        if (akt.v5()) {
            return awd$c.EQUAL;
        }
        if (akt.Zo()) {
            return awd$c.DIFFER_BY_METADATA;
        }
        if (!akt.DW() && QX() != ((long) akt.we())) {
            return awd$c.DIFFER_BY_METADATA;
        }
        int J0 = J0() ^ akt.u7();
        if (!(J0 == 0 || anl.DW.DW(akt.u7()))) {
            if (!this.j6.j6.j6()) {
                J0 &= anl.Hw.FH() ^ -1;
            }
            if (J0 != 0) {
                return awd$c.DIFFER_BY_METADATA;
            }
        }
        long EQ = akt.EQ();
        long XL = XL();
        if (EQ % 1000 == 0) {
            XL -= XL % 1000;
        }
        if (XL != EQ) {
            return awd$c.DIFFER_BY_TIMESTAMP;
        }
        if (akt.DW()) {
            return awd$c.SMUDGED;
        }
        return awd$c.EQUAL;
    }

    public boolean j6(akt akt, boolean z) {
        switch (lg()[j6(akt).ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return false;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return true;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return DW(akt);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                if (z) {
                    return DW(akt);
                }
                return true;
            default:
                throw new IllegalStateException(MessageFormat.format(JGitText.j6().unexpectedCompareResult, new Object[]{r2.name()}));
        }
    }

    public anl j6(aku aku) {
        anl we = we();
        if (aku == null || Ws().j6()) {
            return we;
        }
        anl we2 = aku.we();
        if (anl.FH == we && anl.Hw == we2) {
            return we2;
        }
        if (anl.Hw == we && anl.FH == we2) {
            return we2;
        }
        return we;
    }

    private boolean DW(akt akt) {
        if (!EQ().DW(akt.J0())) {
            return true;
        }
        akt.j6((int) QX());
        return false;
    }

    private long FH(InputStream inputStream) {
        long j = 0;
        while (true) {
            long skip = inputStream.skip(1048576);
            if (skip <= 0) {
                return j;
            }
            j += skip;
        }
    }

    private byte[] j6(InputStream inputStream, long j) {
        long j2;
        int i;
        MessageDigest messageDigest = this.j6.FH;
        byte[] bArr = this.j6.Hw;
        messageDigest.reset();
        messageDigest.update(j3);
        messageDigest.update((byte) 32);
        if (j == 0) {
            messageDigest.update((byte) 48);
            j2 = j;
        } else {
            int length = bArr.length;
            i = length;
            j2 = j;
            do {
                i--;
                bArr[i] = aM[(int) (j2 % 10)];
                j2 /= 10;
            } while (j2 > 0);
            messageDigest.update(bArr, i, length - i);
        }
        messageDigest.update((byte) 0);
        while (true) {
            i = inputStream.read(bArr);
            if (i <= 0) {
                break;
            }
            messageDigest.update(bArr, 0, i);
            j2 += (long) i;
        }
        if (j2 != j) {
            return v5;
        }
        return messageDigest.digest();
    }
}
