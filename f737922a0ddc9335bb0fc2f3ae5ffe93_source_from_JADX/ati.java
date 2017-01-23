import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public abstract class ati extends ath implements atq {
    private static /* synthetic */ int[] vy;
    private auf BT;
    final aqe J0;
    final aqe J8;
    private boolean Mr;
    private final aql QX;
    private boolean U2;
    final aqe Ws;
    private aqd<aqc> XL;
    private boolean a8;
    private final aqe aM;
    private String er;
    private axj$c gW;
    private ati$c j3;
    private boolean lg;
    private boolean rN;
    private arw yS;

    static /* synthetic */ int[] J0() {
        int[] iArr = vy;
        if (iArr == null) {
            iArr = new int[aue$a.values().length];
            try {
                iArr[aue$a.ACK.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aue$a.ACK_COMMON.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[aue$a.ACK_CONTINUE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[aue$a.ACK_READY.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[aue$a.NAK.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            vy = iArr;
        }
        return iArr;
    }

    public ati(auc auc) {
        super(auc);
        this.j3 = ati$c.OFF;
        ati$b ati_b = (ati$b) this.j6.VH().j6(ati$b.j6);
        this.a8 = this.FH.Zo() != auz.NO_TAGS;
        this.Mr = this.FH.VH();
        this.lg = ati_b.DW;
        this.QX = new aql(this.j6);
        this.XL = new aqd();
        this.J0 = this.QX.j6("REACHABLE");
        this.J8 = this.QX.j6("COMMON");
        this.aM = this.QX.j6("STATE");
        this.Ws = this.QX.j6("ADVERTISED");
        this.QX.j6(this.J8);
        this.QX.j6(this.J0);
        this.QX.j6(this.Ws);
    }

    public final void j6(aob aob, Collection<aoc> collection, Set<ans> set) {
        Hw();
        DW(aob, collection, set);
    }

    public boolean Zo() {
        return false;
    }

    public boolean EQ() {
        return false;
    }

    public void FH(String str) {
        this.er = str;
    }

    public Collection<arw> we() {
        if (this.yS != null) {
            return Collections.singleton(this.yS);
        }
        return Collections.emptyList();
    }

    protected void DW(aob aob, Collection<aoc> collection, Set<ans> set) {
        try {
            QX();
            j6((Set) set, j6((Collection) collection));
            if (this.EQ) {
                this.gW = new axj$c(Integer.MAX_VALUE);
                this.BT = new auf(this.gW);
            }
            if (DW((Collection) collection)) {
                j6(aob);
                this.QX.tp();
                this.XL = null;
                this.gW = null;
                this.BT = null;
                DW(aob);
            }
        } catch (ati$a e) {
            u7();
        } catch (Throwable e2) {
            u7();
            throw new amb(e2.getMessage(), e2);
        } catch (Throwable e22) {
            u7();
            throw new amb(e22.getMessage(), e22);
        }
    }

    public void u7() {
        this.QX.we();
        super.u7();
    }

    private int j6(Collection<aoc> collection) {
        int i = 0;
        for (aoc v5 : collection) {
            try {
                aqg gn = this.QX.gn(v5.v5());
                if (gn instanceof aqc) {
                    int gn2 = ((aqc) gn).gn();
                    if (i < gn2) {
                        i = gn2;
                    }
                }
            } catch (IOException e) {
            }
        }
        return i;
    }

    private void j6(Set<ans> set, int i) {
        ans v5;
        for (aoc aoc : this.j6.J8().values()) {
            ans VH = aoc.VH();
            if (VH == null) {
                v5 = aoc.v5();
            } else {
                v5 = VH;
            }
            if (v5 != null) {
                j6(v5);
            }
        }
        for (ans v52 : this.j6.J0()) {
            j6(v52);
        }
        for (ans v522 : set) {
            j6(v522);
        }
        if (i > 0) {
            Date date = new Date(((long) i) * 1000);
            this.QX.j6(aqi.COMMIT_TIME_DESC);
            this.QX.j6(this.XL);
            this.QX.j6(aqr.j6(date));
            while (true) {
                aqc Hw = this.QX.Hw();
                if (Hw != null) {
                    if (Hw.DW(this.Ws) && !Hw.DW(this.J8)) {
                        Hw.FH(this.J8);
                        Hw.j6(this.J8);
                        this.XL.add(Hw);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void j6(ans ans) {
        try {
            aqc Zo = this.QX.Zo((anb) ans);
            if (!Zo.DW(this.J0)) {
                Zo.FH(this.J0);
                this.XL.add(Zo);
            }
        } catch (IOException e) {
        }
    }

    private boolean DW(Collection<aoc> collection) {
        auf auf = this.EQ ? this.BT : this.u7;
        boolean z = true;
        for (aoc aoc : collection) {
            boolean z2;
            try {
                if (this.QX.gn(aoc.v5()).DW(this.J0)) {
                }
            } catch (IOException e) {
            }
            StringBuilder stringBuilder = new StringBuilder(46);
            stringBuilder.append("want ");
            stringBuilder.append(aoc.v5().DW());
            if (z) {
                stringBuilder.append(J8());
                z2 = false;
            } else {
                z2 = z;
            }
            stringBuilder.append('\n');
            auf.j6(stringBuilder.toString());
            z = z2;
        }
        if (z) {
            return false;
        }
        auf.j6();
        this.tp = false;
        return true;
    }

    private String J8() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a8) {
            this.a8 = j6(stringBuilder, "include-tag");
        }
        if (this.lg) {
            j6(stringBuilder, "ofs-delta");
        }
        if (j6(stringBuilder, "multi_ack_detailed")) {
            this.j3 = ati$c.DETAILED;
            if (this.EQ) {
                this.rN = j6(stringBuilder, "no-done");
            }
        } else if (j6(stringBuilder, "multi_ack")) {
            this.j3 = ati$c.CONTINUE;
        } else {
            this.j3 = ati$c.OFF;
        }
        if (this.Mr) {
            this.Mr = j6(stringBuilder, "thin-pack");
        }
        if (j6(stringBuilder, "side-band-64k")) {
            this.U2 = true;
        } else if (j6(stringBuilder, "side-band")) {
            this.U2 = true;
        }
        if (!this.EQ || this.j3 == ati$c.DETAILED) {
            return stringBuilder.toString();
        }
        throw new alq(this.DW, MessageFormat.format(JGitText.j6().statelessRPCRequiresOptionToBeEnabled, new Object[]{"multi_ack_detailed"}));
    }

    private void j6(aob aob) {
        anb ano = new ano();
        if (this.EQ) {
            this.gW.j6(this.VH, null);
        }
        Ws();
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            aqc Hw = this.QX.Hw();
            if (Hw != null) {
                this.u7.j6("have " + Hw.XL().DW() + "\n");
                i3++;
                i2++;
                if ((i3 & 31) == 0) {
                    if (aob.j6()) {
                        throw new ati$a();
                    }
                    this.u7.j6();
                    i4++;
                    if (i3 != 32 || this.EQ) {
                        while (true) {
                            aue$a j6 = this.gn.j6(ano);
                            int i5;
                            switch (J0()[j6.ordinal()]) {
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    i4--;
                                    if ((this.rN & i) == 0) {
                                        if (this.EQ) {
                                            this.gW.j6(this.VH, null);
                                        }
                                        if (obj2 != null && r4 > 256) {
                                            break;
                                        }
                                    }
                                    break;
                                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                    this.j3 = ati$c.OFF;
                                    if (!this.EQ) {
                                        i5 = 1;
                                        i4 = 0;
                                        break;
                                    }
                                    this.gW.j6(this.VH, null);
                                    i5 = 1;
                                    i4 = 0;
                                    break;
                                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                                case 5:
                                    j6(this.QX.gn(ano), j6);
                                    int i6;
                                    if (j6 != aue$a.ACK_READY) {
                                        i5 = 1;
                                        i6 = 1;
                                        i2 = 0;
                                        break;
                                    }
                                    i = 1;
                                    i5 = 1;
                                    i6 = 1;
                                    i2 = 0;
                                    break;
                            }
                            if (aob.j6()) {
                                throw new ati$a();
                            }
                        }
                    }
                }
            }
            if (aob.j6()) {
                throw new ati$a();
            }
            if (i == 0 || !this.rN) {
                this.u7.j6("done\n");
                this.u7.DW();
            }
            if (obj == null) {
                this.j3 = ati$c.OFF;
                i4++;
            }
            do {
                if (i4 > 0 || this.j3 != ati$c.OFF) {
                    i4--;
                    switch (J0()[this.gn.j6(ano).ordinal()]) {
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            return;
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                            this.j3 = ati$c.CONTINUE;
                            break;
                    }
                }
                return;
            } while (!aob.j6());
            throw new ati$a();
        }
    }

    private void Ws() {
        this.QX.j6(this.J0, this.Ws);
        this.QX.j6(this.XL);
        this.QX.j6(aqi.COMMIT_TIME_DESC);
        this.QX.j6(new ati$1(this));
    }

    private void QX() {
        for (aoc aoc : DW()) {
            j6(aoc.v5());
            if (aoc.VH() != null) {
                j6(aoc.VH());
            }
        }
    }

    private void j6(anb anb) {
        try {
            this.QX.gn(anb).FH(this.Ws);
        } catch (IOException e) {
        }
    }

    private void j6(aqg aqg, aue$a aue_a) {
        if (this.EQ && aue_a == aue$a.ACK_COMMON && !aqg.DW(this.aM)) {
            StringBuilder stringBuilder = new StringBuilder(46);
            stringBuilder.append("have ");
            stringBuilder.append(aqg.DW());
            stringBuilder.append('\n');
            this.BT.j6(stringBuilder.toString());
            aqg.FH(this.aM);
        }
        aqg.FH(this.J8);
        if (aqg instanceof aqc) {
            ((aqc) aqg).j6(this.J8);
        }
    }

    private void DW(aob aob) {
        InputStream auu;
        InputStream inputStream = this.Zo;
        if (this.U2) {
            auu = new auu(inputStream, aob, v5());
        } else {
            auu = inputStream;
        }
        anw Hw = this.j6.Hw();
        try {
            aub j6 = Hw.j6(auu);
            j6.j6(this.Mr);
            j6.v5(this.FH.gn());
            j6.j6(this.er);
            this.yS = j6.j6(aob);
            Hw.FH();
        } finally {
            Hw.Hw();
        }
    }
}
