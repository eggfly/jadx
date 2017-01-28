import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.util.Collection;
import java.util.Set;

class aqy extends arb {
    private static /* synthetic */ int[] Hw;
    private final arl DW;
    private arb$a[] FH;
    private final ant<aqy$a> j6;

    static /* synthetic */ int[] J8() {
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

    aqy(arl arl) {
        this.j6 = new ant();
        this.DW = arl;
        File gn = arl.gn();
        String[] list = gn.list();
        if (list == null) {
            list = new String[0];
        }
        for (String str : r0) {
            if (str.length() == 2) {
                String[] list2 = new File(gn, str).list();
                if (list2 != null) {
                    for (String str2 : list2) {
                        if (str2.length() == 38) {
                            try {
                                this.j6.j6(new aqy$a(ans.DW(new StringBuilder(String.valueOf(str)).append(str2).toString())));
                            } catch (IllegalArgumentException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    public void v5() {
    }

    public anr Zo() {
        return this;
    }

    arb VH() {
        return this;
    }

    File gn() {
        return this.DW.gn();
    }

    ani u7() {
        return this.DW.u7();
    }

    awp tp() {
        return this.DW.tp();
    }

    Collection<? extends ask> EQ() {
        return this.DW.EQ();
    }

    arb$a[] we() {
        if (this.FH == null) {
            arb$a[] we = this.DW.we();
            this.FH = new arb$a[we.length];
            for (int i = 0; i < this.FH.length; i++) {
                this.FH[i] = new arb$a(we[i].j6.VH());
            }
        }
        return this.FH;
    }

    void j6(Set<ans> set, amz amz) {
        this.DW.j6((Set) set, amz);
    }

    boolean J0() {
        return this.DW.J0();
    }

    public boolean j6(anb anb) {
        return Hw(anb);
    }

    boolean DW(anb anb) {
        return this.j6.DW(anb) || this.DW.DW(anb);
    }

    anx j6(asg asg, anb anb) {
        return Hw(asg, anb);
    }

    anx DW(asg asg, anb anb) {
        if (this.j6.DW(anb)) {
            return this.DW.j6(asg, anb.DW(), anb);
        }
        return this.DW.DW(asg, anb);
    }

    boolean j6(String str) {
        return this.j6.DW(ans.DW(str));
    }

    anx j6(asg asg, String str, anb anb) {
        if (this.j6.DW(anb)) {
            return this.DW.j6(asg, str, anb);
        }
        return null;
    }

    long FH(asg asg, anb anb) {
        if (this.j6.DW(anb)) {
            return this.DW.DW(asg, anb.DW(), anb);
        }
        return this.DW.FH(asg, anb);
    }

    long DW(asg asg, String str, anb anb) {
        if (this.j6.DW(anb)) {
            return this.DW.DW(asg, str, anb);
        }
        return -1;
    }

    arb$c j6(File file, ans ans, boolean z) {
        arb$c j6 = this.DW.j6(file, ans, z);
        switch (J8()[j6.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.j6.DW(new aqy$a(ans));
                break;
        }
        return j6;
    }

    aro j6(File file, File file2) {
        return this.DW.j6(file, file2);
    }

    void j6(asy asy, asv asv, asg asg) {
        this.DW.j6(asy, asv, asg);
    }
}
