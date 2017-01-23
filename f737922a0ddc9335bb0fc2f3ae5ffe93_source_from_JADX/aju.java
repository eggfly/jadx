import com.aide.uidesigner.ProxyTextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aju {
    private static final byte[] DW;
    private static final byte[] FH;
    private static /* synthetic */ int[] aM;
    private static /* synthetic */ int[] j3;
    private static final byte[] j6;
    private int EQ;
    private final OutputStream Hw;
    private String J0;
    private awl J8;
    private aob QX;
    private int VH;
    private akg Ws;
    private ajq$c XL;
    private any Zo;
    private int gn;
    private akf tp;
    private ajr u7;
    private aoh v5;
    private String we;

    static /* synthetic */ int[] DW() {
        int[] iArr = j3;
        if (iArr == null) {
            iArr = new int[ajt$b.values().length];
            try {
                iArr[ajt$b.NEW.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajt$b.OLD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            j3 = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] j6() {
        int[] iArr = aM;
        if (iArr == null) {
            iArr = new int[ajt$a.values().length];
            try {
                iArr[ajt$a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajt$a.COPY.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ajt$a.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ajt$a.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ajt$a.RENAME.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            aM = iArr;
        }
        return iArr;
    }

    static {
        j6 = anj.j6("\\ No newline at end of file\n");
        DW = new byte[0];
        FH = new byte[0];
    }

    public aju(OutputStream outputStream) {
        this.VH = 3;
        this.gn = 7;
        this.tp = akf.j6;
        this.EQ = 52428800;
        this.we = "a/";
        this.J0 = "b/";
        this.J8 = awl.FH;
        this.Hw = outputStream;
    }

    public void j6(aoh aoh) {
        if (this.Zo != null) {
            this.Zo.FH();
        }
        this.v5 = aoh;
        this.Zo = this.v5.v5();
        ajq j6 = ajq.j6(this.Zo);
        this.XL = new ajq$c(j6, j6);
        ajs ajs = (ajs) this.v5.VH().j6(ajs.j6);
        if (ajs.j6()) {
            j6("");
            DW("");
        }
        j6(ajs.DW());
        this.u7 = ajr.j6((ajr$a) this.v5.VH().j6("diff", null, "algorithm", ajr$a.HISTOGRAM));
    }

    public void j6(String str) {
        this.we = str;
    }

    public void DW(String str) {
        this.J0 = str;
    }

    public void j6(boolean z) {
        if (z && this.Ws == null) {
            FH();
            this.Ws = new akg(this.v5);
        } else if (!z) {
            this.Ws = null;
        }
    }

    public List<ajt> j6(anb anb, anb anb2) {
        FH();
        aql aql = new aql(this.Zo);
        return j6(aql.VH(anb), aql.VH(anb2));
    }

    public List<ajt> j6(aqk aqk, aqk aqk2) {
        FH();
        avx avy = new avy();
        avx avy2 = new avy();
        avy.j6(this.Zo, (anb) aqk);
        avy2.j6(this.Zo, (anb) aqk2);
        return j6(avy, avy2);
    }

    public List<ajt> j6(avx avx, avx avx2) {
        FH();
        awc awc = new awc(this.Zo);
        awc.j6(avx);
        awc.j6(avx2);
        awc.j6(true);
        awl DW = DW(avx, avx2);
        if (this.J8 instanceof apu) {
            awc.j6(awf.j6(awi.j6(((apu) this.J8).FH()), DW));
        } else {
            awc.j6(awf.j6(this.J8, DW));
        }
        this.XL = new ajq$c(j6(avx), j6(avx2));
        List j6 = ajt.j6(awc);
        if ((this.J8 instanceof apu) && FH(j6)) {
            avx.VH();
            avx2.VH();
            awc.u7();
            awc.j6(avx);
            awc.j6(avx2);
            awc.j6(DW);
            if (this.Ws == null) {
                j6(true);
            }
            return Hw(DW(ajt.j6(awc)));
        } else if (this.Ws != null) {
            return DW(j6);
        } else {
            return j6;
        }
    }

    private static awl DW(avx avx, avx avx2) {
        if ((avx instanceof aku) && (avx2 instanceof awd)) {
            return new awg(0, 1);
        }
        if ((avx instanceof awd) && (avx2 instanceof aku)) {
            return new awg(1, 0);
        }
        awl awl = awl.Hw;
        if (avx instanceof awd) {
            awl = awf.j6(new awh(0), awl);
        }
        if (avx2 instanceof awd) {
            return awf.j6(new awh(1), awl);
        }
        return awl;
    }

    private ajq j6(avx avx) {
        if (avx instanceof awd) {
            return ajq.j6((awd) avx);
        }
        return ajq.j6(this.Zo);
    }

    private List<ajt> DW(List<ajt> list) {
        this.Ws.Hw();
        this.Ws.j6((Collection) list);
        return this.Ws.j6(this.Zo, this.QX);
    }

    private boolean FH(List<ajt> list) {
        String FH = ((apu) this.J8).FH();
        for (ajt ajt : list) {
            if (ajt.v5() == ajt$a.ADD && ajt.DW().equals(FH)) {
                return true;
            }
        }
        return false;
    }

    private List<ajt> Hw(List<ajt> list) {
        String FH = ((apu) this.J8).FH();
        for (ajt ajt : list) {
            if (DW(ajt) && ajt.DW().equals(FH)) {
                this.J8 = apu.j6(ajt.j6());
                return Collections.singletonList(ajt);
            }
        }
        return Collections.emptyList();
    }

    private static boolean DW(ajt ajt) {
        return ajt.v5() == ajt$a.RENAME || ajt.v5() == ajt$a.COPY;
    }

    public void DW(anb anb, anb anb2) {
        j6(j6(anb, anb2));
    }

    public void j6(List<? extends ajt> list) {
        for (ajt j6 : list) {
            j6(j6);
        }
    }

    public void j6(ajt ajt) {
        aju$a FH = FH(ajt);
        j6(FH.j6, FH.DW, FH.FH);
    }

    private void DW(OutputStream outputStream, ajt ajt) {
        if (ajt.FH() == anl.v5) {
            outputStream.write(anj.j6("-Subproject commit " + ajt.VH().v5() + "\n"));
        }
        if (ajt.Hw() == anl.v5) {
            outputStream.write(anj.j6("+Subproject commit " + ajt.gn().v5() + "\n"));
        }
    }

    private String j6(amz amz) {
        if (amz.DW() && this.v5 != null) {
            try {
                amz = this.Zo.j6(amz.FH(), this.gn);
            } catch (IOException e) {
            }
        }
        return amz.v5();
    }

    private static String FH(String str) {
        return axc.j6.j6(str);
    }

    public void j6(apg apg, ake ake, ake ake2) {
        int EQ = apg.EQ();
        int we = apg.we();
        if (!apg.J8().isEmpty()) {
            we = ((aph) apg.J8().get(0)).DW();
        }
        this.Hw.write(apg.tp(), EQ, we - EQ);
        if (apg.J0() == apg$a.UNIFIED) {
            j6(apg.Ws(), ake, ake2);
        }
    }

    public void j6(ajw ajw, ake ake, ake ake2) {
        int i;
        for (int i2 = 0; i2 < ajw.size(); i2 = i) {
            ajv ajv = (ajv) ajw.get(i2);
            int j6 = j6((List) ajw, i2);
            ajv ajv2 = (ajv) ajw.get(j6);
            int max = Math.max(0, ajv.FH() - this.VH);
            int max2 = Math.max(0, ajv.v5() - this.VH);
            int min = Math.min(ake.j6(), ajv2.Hw() + this.VH);
            int min2 = Math.min(ake2.j6(), ajv2.Zo() + this.VH);
            j6(max, min, max2, min2);
            int i3 = max2;
            ajv ajv3 = ajv;
            i = i2;
            i2 = max;
            while (true) {
                if (i2 >= min && i3 >= min2) {
                    break;
                }
                if (i2 < ajv3.FH() || j6 + 1 < i) {
                    j6(ake, i2);
                    if (Hw(ake, i2)) {
                        this.Hw.write(j6);
                    }
                    i2++;
                    i3++;
                } else if (i2 < ajv3.Hw()) {
                    FH(ake, i2);
                    if (Hw(ake, i2)) {
                        this.Hw.write(j6);
                    }
                    i2++;
                } else if (i3 < ajv3.Zo()) {
                    DW(ake2, i3);
                    if (Hw(ake2, i3)) {
                        this.Hw.write(j6);
                    }
                    i3++;
                }
                if (j6(ajv3, i2, i3)) {
                    max = i + 1;
                    if (max < ajw.size()) {
                        ajv3 = (ajv) ajw.get(max);
                        i = max;
                    } else {
                        i = max;
                    }
                }
            }
        }
    }

    protected void j6(ake ake, int i) {
        j6(' ', ake, i);
    }

    private boolean Hw(ake ake, int i) {
        return i + 1 == ake.j6() && ake.DW();
    }

    protected void DW(ake ake, int i) {
        j6('+', ake, i);
    }

    protected void FH(ake ake, int i) {
        j6('-', ake, i);
    }

    protected void j6(int i, int i2, int i3, int i4) {
        this.Hw.write(64);
        this.Hw.write(64);
        j6('-', i + 1, i2 - i);
        j6('+', i3 + 1, i4 - i3);
        this.Hw.write(32);
        this.Hw.write(64);
        this.Hw.write(64);
        this.Hw.write(10);
    }

    private void j6(char c, int i, int i2) {
        this.Hw.write(32);
        this.Hw.write(c);
        switch (i2) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.Hw.write(anj.j6((long) (i - 1)));
                this.Hw.write(44);
                this.Hw.write(48);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                this.Hw.write(anj.j6((long) i));
            default:
                this.Hw.write(anj.j6((long) i));
                this.Hw.write(44);
                this.Hw.write(anj.j6((long) i2));
        }
    }

    protected void j6(char c, ake ake, int i) {
        this.Hw.write(c);
        ake.j6(this.Hw, i);
        this.Hw.write(10);
    }

    private aju$a FH(ajt ajt) {
        ajw j6;
        apg$a apg_a;
        aju$a aju_a = new aju$a();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j6(byteArrayOutputStream, ajt);
        if (ajt.FH() != anl.v5 && ajt.Hw() != anl.v5) {
            FH();
            byte[] j62 = j6(ajt$b.OLD, ajt);
            byte[] j63 = j6(ajt$b.NEW, ajt);
            if (j62 != FH && j63 != FH && !ake.j6(j62) && !ake.j6(j63)) {
                aju_a.DW = new ake(j62);
                aju_a.FH = new ake(j63);
                j6 = j6(aju_a.DW, aju_a.FH);
                apg_a = apg$a.UNIFIED;
                switch (j6()[ajt.v5().ordinal()]) {
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                        if (!j6.isEmpty()) {
                            DW(byteArrayOutputStream, ajt);
                            break;
                        }
                        break;
                    default:
                        DW(byteArrayOutputStream, ajt);
                        break;
                }
            }
            DW(byteArrayOutputStream, ajt);
            byteArrayOutputStream.write(anj.j6("Binary files differ\n"));
            j6 = new ajw();
            apg_a = apg$a.BINARY;
        } else {
            DW(byteArrayOutputStream, ajt);
            DW((OutputStream) byteArrayOutputStream, ajt);
            j6 = new ajw();
            apg_a = apg$a.UNIFIED;
        }
        aju_a.j6 = new apg(byteArrayOutputStream.toByteArray(), j6, apg_a);
        return aju_a;
    }

    private ajw j6(ake ake, ake ake2) {
        return this.u7.j6(this.tp, ake, ake2);
    }

    private void FH() {
        if (this.v5 == null) {
            throw new IllegalStateException(JGitText.j6().repositoryIsRequired);
        }
    }

    private byte[] j6(ajt$b ajt_b, ajt ajt) {
        amz amz;
        if (ajt.DW(ajt_b) == anl.Zo) {
            return DW;
        }
        if (ajt.DW(ajt_b).DW() != 3) {
            return DW;
        }
        if (Hw(ajt.j6(ajt_b))) {
            return FH;
        }
        amz FH = ajt.FH(ajt_b);
        if (FH.DW()) {
            amz = FH;
        } else {
            Collection j6 = this.Zo.j6(FH);
            if (j6.size() == 1) {
                FH = amz.j6((anb) j6.iterator().next());
                switch (DW()[ajt_b.ordinal()]) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        ajt.gn = FH;
                        amz = FH;
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        ajt.u7 = FH;
                        break;
                }
                amz = FH;
            } else if (j6.size() == 0) {
                throw new ali(FH, 3);
            } else {
                throw new akw(FH, j6);
            }
        }
        try {
            return this.XL.DW(ajt_b, ajt).j6(this.EQ);
        } catch (alf$b e) {
            return FH;
        } catch (alf$a e2) {
            return FH;
        } catch (alf$c e3) {
            return FH;
        } catch (alf e4) {
            e4.j6(amz.FH());
            throw e4;
        }
    }

    private boolean Hw(String str) {
        return false;
    }

    private void j6(ByteArrayOutputStream byteArrayOutputStream, ajt ajt) {
        String str;
        ajt$a v5 = ajt.v5();
        String j6 = ajt.j6();
        String DW = ajt.DW();
        anl FH = ajt.FH();
        anl Hw = ajt.Hw();
        byteArrayOutputStream.write(anj.j6("diff --git "));
        byteArrayOutputStream.write(anj.DW(FH(this.we + (v5 == ajt$a.ADD ? DW : j6))));
        byteArrayOutputStream.write(32);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.J0));
        if (v5 == ajt$a.DELETE) {
            str = j6;
        } else {
            str = DW;
        }
        byteArrayOutputStream.write(anj.DW(FH(stringBuilder.append(str).toString())));
        byteArrayOutputStream.write(10);
        switch (j6()[v5.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                byteArrayOutputStream.write(anj.j6("new file mode "));
                Hw.j6((OutputStream) byteArrayOutputStream);
                byteArrayOutputStream.write(10);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (ajt.Zo() > 0) {
                    byteArrayOutputStream.write(anj.j6("dissimilarity index " + (100 - ajt.Zo()) + "%"));
                    byteArrayOutputStream.write(10);
                    break;
                }
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                byteArrayOutputStream.write(anj.j6("deleted file mode "));
                FH.j6((OutputStream) byteArrayOutputStream);
                byteArrayOutputStream.write(10);
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                byteArrayOutputStream.write(anj.j6("similarity index " + ajt.Zo() + "%"));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(anj.DW("rename from " + FH(j6)));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(anj.DW("rename to " + FH(DW)));
                byteArrayOutputStream.write(10);
                break;
            case 5:
                byteArrayOutputStream.write(anj.j6("similarity index " + ajt.Zo() + "%"));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(anj.DW("copy from " + FH(j6)));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(anj.DW("copy to " + FH(DW)));
                byteArrayOutputStream.write(10);
                if (!FH.equals(Hw)) {
                    byteArrayOutputStream.write(anj.j6("new file mode "));
                    Hw.j6((OutputStream) byteArrayOutputStream);
                    byteArrayOutputStream.write(10);
                    break;
                }
                break;
        }
        if ((v5 == ajt$a.MODIFY || v5 == ajt$a.RENAME) && !FH.equals(Hw)) {
            byteArrayOutputStream.write(anj.j6("old mode "));
            FH.j6((OutputStream) byteArrayOutputStream);
            byteArrayOutputStream.write(10);
            byteArrayOutputStream.write(anj.j6("new mode "));
            Hw.j6((OutputStream) byteArrayOutputStream);
            byteArrayOutputStream.write(10);
        }
        if (!ajt.VH().equals(ajt.gn())) {
            j6((OutputStream) byteArrayOutputStream, ajt);
        }
    }

    protected void j6(OutputStream outputStream, ajt ajt) {
        outputStream.write(anj.j6("index " + j6(ajt.VH()) + ".." + j6(ajt.gn())));
        if (ajt.FH().equals(ajt.Hw())) {
            outputStream.write(32);
            ajt.Hw().j6(outputStream);
        }
        outputStream.write(10);
    }

    private void DW(ByteArrayOutputStream byteArrayOutputStream, ajt ajt) {
        if (!ajt.gn.equals(ajt.u7)) {
            String str;
            String FH;
            switch (j6()[ajt.v5().ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    str = "/dev/null";
                    FH = FH(this.J0 + ajt.DW());
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str = FH(this.we + ajt.j6());
                    FH = "/dev/null";
                    break;
                default:
                    str = FH(this.we + ajt.j6());
                    FH = FH(this.J0 + ajt.DW());
                    break;
            }
            byteArrayOutputStream.write(anj.DW("--- " + str + "\n"));
            byteArrayOutputStream.write(anj.DW("+++ " + FH + "\n"));
        }
    }

    private int j6(List<ajv> list, int i) {
        int i2 = i + 1;
        while (i2 < list.size() && (DW((List) list, i2) || FH((List) list, i2))) {
            i2++;
        }
        return i2 - 1;
    }

    private boolean DW(List<ajv> list, int i) {
        return ((ajv) list.get(i)).FH() - ((ajv) list.get(i + -1)).Hw() <= this.VH * 2;
    }

    private boolean FH(List<ajv> list, int i) {
        return ((ajv) list.get(i)).v5() - ((ajv) list.get(i + -1)).Zo() <= this.VH * 2;
    }

    private static boolean j6(ajv ajv, int i, int i2) {
        return ajv.Hw() <= i && ajv.Zo() <= i2;
    }
}
