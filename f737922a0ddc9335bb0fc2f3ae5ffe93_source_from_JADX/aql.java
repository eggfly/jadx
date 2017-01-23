import com.aide.uidesigner.ProxyTextView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aql implements Iterable<aqc> {
    final any DW;
    private final EnumSet<aqi> EQ;
    final ano FH;
    ant<aqg> Hw;
    private awl J0;
    private boolean J8;
    apj VH;
    final ArrayList<aqc> Zo;
    apv gn;
    final aoh j6;
    private int tp;
    private int u7;
    int v5;
    private aqt we;

    public aql(aoh aoh) {
        this(aoh, aoh.v5());
    }

    public aql(any any) {
        this(null, any);
    }

    private aql(aoh aoh, any any) {
        this.u7 = -64;
        this.v5 = 4;
        this.j6 = aoh;
        this.DW = any;
        this.FH = new ano();
        this.Hw = new ant();
        this.Zo = new ArrayList();
        this.VH = new apo();
        this.gn = new aqo(this);
        this.EQ = EnumSet.of(aqi.NONE);
        this.we = aqt.DW;
        this.J0 = awl.FH;
        this.J8 = true;
    }

    public any EQ() {
        return this.DW;
    }

    public void we() {
        this.DW.FH();
    }

    public void DW(aqc aqc) {
        if ((aqc.we & 2) == 0) {
            if ((aqc.we & 1) == 0) {
                aqc.j6(this);
            }
            aqc.we |= 2;
            this.Zo.add(aqc);
            this.VH.j6(aqc);
        }
    }

    public void j6(Collection<aqc> collection) {
        for (aqc DW : collection) {
            DW(DW);
        }
    }

    public void FH(aqc aqc) {
        aqc.we |= 4;
        Hw(aqc);
        DW(aqc);
    }

    public boolean j6(aqc aqc, aqc aqc2) {
        aqt aqt = this.we;
        awl awl = this.J0;
        try {
            j6();
            j6((this.u7 ^ -1) & -64);
            this.we = aqt.v5;
            this.J0 = awl.FH;
            DW(aqc2);
            DW(aqc);
            boolean z = Hw() == aqc;
            this.we = aqt;
            this.J0 = awl;
            return z;
        } catch (Throwable th) {
            this.we = aqt;
            this.J0 = awl;
        }
    }

    public aqc Hw() {
        return this.gn.j6();
    }

    public boolean DW(aqi aqi) {
        return this.EQ.contains(aqi);
    }

    public void j6(aqi aqi) {
        aM();
        this.EQ.clear();
        this.EQ.add(aqi);
    }

    public void j6(aqi aqi, boolean z) {
        aM();
        if (z) {
            this.EQ.add(aqi);
        } else {
            this.EQ.remove(aqi);
        }
        if (this.EQ.size() > 1) {
            this.EQ.remove(aqi.NONE);
        } else if (this.EQ.size() == 0) {
            this.EQ.add(aqi.NONE);
        }
    }

    public aqt J0() {
        return this.we;
    }

    public void j6(aqt aqt) {
        aM();
        if (aqt == null) {
            aqt = aqt.DW;
        }
        this.we = aqt;
    }

    public awl J8() {
        return this.J0;
    }

    public void j6(awl awl) {
        aM();
        if (awl == null) {
            awl = awl.FH;
        }
        this.J0 = awl;
    }

    public boolean Ws() {
        return this.J8;
    }

    public void j6(boolean z) {
        this.J8 = z;
    }

    public aqb DW(anb anb) {
        aqb aqb = (aqb) this.Hw.j6(anb);
        if (aqb != null) {
            return aqb;
        }
        ant$a aqb2 = new aqb(anb);
        this.Hw.j6(aqb2);
        return aqb2;
    }

    public aqk FH(anb anb) {
        aqk aqk = (aqk) this.Hw.j6(anb);
        if (aqk != null) {
            return aqk;
        }
        ant$a aqk2 = new aqk(anb);
        this.Hw.j6(aqk2);
        return aqk2;
    }

    public aqc Hw(anb anb) {
        aqc aqc = (aqc) this.Hw.j6(anb);
        if (aqc != null) {
            return aqc;
        }
        ant$a j6 = j6(anb);
        this.Hw.j6(j6);
        return j6;
    }

    public aqg j6(anb anb, int i) {
        aqg aqg = (aqg) this.Hw.j6(anb);
        if (aqg == null) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    aqg = j6(anb);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    aqg = new aqk(anb);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    aqg = new aqb(anb);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    aqg = new aqj(anb);
                    break;
                default:
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidGitType, new Object[]{Integer.valueOf(i)}));
            }
            this.Hw.j6((ant$a) aqg);
        }
        return aqg;
    }

    public aqg v5(anb anb) {
        return (aqg) this.Hw.j6(anb);
    }

    public aqc Zo(anb anb) {
        aqg VH = VH(gn(anb));
        if (VH instanceof aqc) {
            return (aqc) VH;
        }
        throw new alb(anb.v5(), "commit");
    }

    public aqk VH(anb anb) {
        aqg VH = VH(gn(anb));
        if (VH instanceof aqc) {
            VH = ((aqc) VH).u7();
        } else if (VH instanceof aqk) {
            aqk aqk = (aqk) VH;
        } else {
            throw new alb(anb.v5(), "tree");
        }
        Zo(VH);
        return VH;
    }

    public aqg gn(anb anb) {
        aqg aqg = (aqg) this.Hw.j6(anb);
        if (aqg == null) {
            return j6(anb, this.DW.FH(anb));
        }
        Zo(aqg);
        return aqg;
    }

    private aqg j6(anb anb, anx anx) {
        ant$a j6;
        switch (anx.DW()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6 = j6(anb);
                j6.j6(this, j6((aqg) j6, anx));
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6 = new aqk(anb);
                j6.we |= 1;
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6 = new aqb(anb);
                j6.we |= 1;
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                aqg aqj = new aqj(anb);
                aqj.j6(this, j6(aqj, anx));
                break;
            default:
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().badObjectType, new Object[]{Integer.valueOf(r0)}));
        }
        this.Hw.j6(j6);
        return j6;
    }

    byte[] v5(aqg aqg) {
        return j6(aqg, this.DW.FH(aqg, aqg.v_()));
    }

    byte[] j6(aqg aqg, anx anx) {
        try {
            return anx.DW(5242880);
        } catch (alf e) {
            e.j6(aqg);
            throw e;
        }
    }

    public <T extends ans> apk j6(Iterable<T> iterable, boolean z) {
        Iterable arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (T t : iterable) {
            aqg aqg = (aqg) this.Hw.j6((anb) t);
            if (aqg == null || (aqg.we & 1) == 0) {
                arrayList.add(t);
            } else {
                arrayList2.add(aqg);
            }
        }
        Iterator it = arrayList2.iterator();
        return arrayList.isEmpty() ? new aql$1(this, it) : new aql$2(this, it, this.DW.j6(arrayList, z));
    }

    public void Zo(aqg aqg) {
        if ((aqg.we & 1) == 0) {
            aqg.j6(this);
        }
    }

    public aqg VH(aqg aqg) {
        aqg aqg2 = aqg;
        while (aqg2 instanceof aqj) {
            Zo(aqg2);
            aqg2 = ((aqj) aqg2).gn();
        }
        Zo(aqg2);
        return aqg2;
    }

    public aqe j6(String str) {
        return new aqe(this, str, QX());
    }

    int QX() {
        if (this.u7 == 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().flagsAlreadyCreated, new Object[]{Integer.valueOf(26)}));
        }
        int lowestOneBit = Integer.lowestOneBit(this.u7);
        this.u7 &= lowestOneBit ^ -1;
        return lowestOneBit;
    }

    public void j6(aqe aqe) {
        if ((this.u7 & aqe.Hw) != 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().flagIsDisposed, new Object[]{aqe.FH}));
        } else if (aqe.DW != this) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().flagNotFromThis, new Object[]{aqe.FH}));
        } else {
            this.v5 |= aqe.Hw;
        }
    }

    void DW(int i) {
        if (DW()) {
            this.u7 |= i;
            this.v5 &= i ^ -1;
            return;
        }
        this.tp |= i;
    }

    private void j6() {
        if (this.tp != 0) {
            this.u7 |= this.tp;
            this.v5 &= this.tp ^ -1;
            this.tp = 0;
        }
    }

    public final void XL() {
        j6(0);
    }

    public final void j6(aqf aqf) {
        j6(aqf.j6);
    }

    public final void j6(aqe... aqeArr) {
        int i = 0;
        int i2 = 0;
        while (i < aqeArr.length) {
            i2 |= aqeArr[i].Hw;
            i++;
        }
        j6(i2);
    }

    protected void j6(int i) {
        j6();
        int i2 = i | 1;
        int i3 = i2 ^ -1;
        aps aps = new aps();
        Iterator it = this.Zo.iterator();
        while (it.hasNext()) {
            aqc aqc = (aqc) it.next();
            if ((aqc.we & i3) != 0) {
                aqc.we &= i2;
                aqc.Ws();
                aps.j6(aqc);
            }
        }
        while (true) {
            aqc = aps.j6();
            if (aqc == null) {
                this.Zo.clear();
                this.VH = new apo();
                this.gn = new aqo(this);
                return;
            } else if (aqc.u7 != null) {
                for (aqc aqc2 : aqc.u7) {
                    if ((aqc2.we & i3) != 0) {
                        aqc2.we &= i2;
                        aqc2.Ws();
                        aps.j6(aqc2);
                    }
                }
            }
        }
    }

    public void tp() {
        this.DW.FH();
        this.u7 = -64;
        this.tp = 0;
        this.v5 = 4;
        this.Hw.j6();
        this.DW.FH();
        this.Zo.clear();
        this.VH = new apo();
        this.gn = new aqo(this);
    }

    public Iterator<aqc> iterator() {
        try {
            return new aql$3(this, Hw());
        } catch (Throwable e) {
            throw new alt(e);
        } catch (Throwable e2) {
            throw new alt(e2);
        } catch (Throwable e22) {
            throw new alt(e22);
        }
    }

    protected void aM() {
        if (!DW()) {
            throw new IllegalStateException(JGitText.j6().outputHasAlreadyBeenStarted);
        }
    }

    private boolean DW() {
        return this.gn instanceof aqo;
    }

    public apy j3() {
        aql apy = new apy(this.DW);
        apy.Hw = this.Hw;
        apy.u7 = this.u7;
        return apy;
    }

    protected aqc j6(anb anb) {
        return new aqc(anb);
    }

    void Hw(aqc aqc) {
        int i = aqc.we & this.v5;
        if (i != 0) {
            aqc.j6(aqc, i);
        }
    }
}
