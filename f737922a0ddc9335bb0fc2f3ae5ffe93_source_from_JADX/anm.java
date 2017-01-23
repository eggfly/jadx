import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class anm {
    private final aqk DW;
    private Set<String> EQ;
    private awl FH;
    private final awd Hw;
    private ako J0;
    private awg J8;
    private Set<String> VH;
    private Set<String> Zo;
    private Set<String> gn;
    private final aoh j6;
    private Set<String> tp;
    private Set<String> u7;
    private Set<String> v5;
    private Set<String> we;

    public anm(aoh aoh, String str, awd awd) {
        this.FH = null;
        this.v5 = new HashSet();
        this.Zo = new HashSet();
        this.VH = new HashSet();
        this.gn = new HashSet();
        this.u7 = new HashSet();
        this.tp = new HashSet();
        this.EQ = new HashSet();
        this.j6 = aoh;
        anb DW = aoh.DW(str);
        if (DW != null) {
            this.DW = new aql(aoh).VH(DW);
        } else {
            this.DW = null;
        }
        this.Hw = awd;
    }

    public boolean j6() {
        return j6(null, 0, 0, "");
    }

    public boolean j6(aob aob, int i, int i2, String str) {
        this.J0 = this.j6.QX();
        awc awc = new awc(this.j6);
        awc.j6(true);
        if (this.DW != null) {
            awc.DW(this.DW);
        } else {
            awc.j6(new avz());
        }
        awc.j6(new aku(this.J0));
        awc.j6(this.Hw);
        Collection arrayList = new ArrayList(4);
        if (aob != null) {
            if (i2 == 0) {
                i2 = this.J0.tp();
            }
            int max = Math.max((i2 * 10) / 9, (i * 10) / 9);
            aob.j6(str, max);
            arrayList.add(new anm$a(max, null));
        }
        if (this.FH != null) {
            arrayList.add(this.FH);
        }
        arrayList.add(new awk(1));
        this.J8 = new awg(1, 2);
        arrayList.add(this.J8);
        awc.j6(awf.j6(arrayList));
        while (awc.EQ()) {
            avx j6 = awc.j6(0, avx.class);
            avx avx = (aku) awc.j6(1, aku.class);
            awd awd = (awd) awc.j6(2, awd.class);
            if (avx != null) {
                akt tp = avx.tp();
                if (tp != null && tp.VH() > 0) {
                    this.EQ.add(awc.we());
                }
            }
            if (j6 != null) {
                if (avx == null) {
                    this.VH.add(awc.we());
                    if (awd != null) {
                        this.tp.add(awc.we());
                    }
                } else if (!(j6.DW(avx) && j6.J0() == avx.J0())) {
                    this.Zo.add(awc.we());
                }
            } else if (avx != null) {
                this.v5.add(awc.we());
            } else if (!(awd == null || awd.j3())) {
                this.tp.add(awc.we());
            }
            if (avx != null) {
                if (awd == null) {
                    this.gn.add(awc.we());
                } else if (awd.j6(avx.tp(), true)) {
                    this.u7.add(awc.we());
                }
            }
        }
        if (aob != null) {
            aob.DW();
        }
        this.we = this.J8.FH();
        if (this.v5.isEmpty() && this.Zo.isEmpty() && this.VH.isEmpty() && this.gn.isEmpty() && this.u7.isEmpty() && this.tp.isEmpty()) {
            return false;
        }
        return true;
    }

    public Set<String> DW() {
        return this.v5;
    }

    public Set<String> FH() {
        return this.Zo;
    }

    public Set<String> Hw() {
        return this.VH;
    }

    public Set<String> v5() {
        return this.gn;
    }

    public Set<String> Zo() {
        return this.u7;
    }

    public Set<String> VH() {
        return this.tp;
    }

    public Set<String> gn() {
        return this.EQ;
    }
}
