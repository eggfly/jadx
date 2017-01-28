import com.aide.uidesigner.ProxyTextView;

class arz extends aof {
    private static /* synthetic */ int[] FH;
    private ark DW;
    private final ary j6;

    protected /* synthetic */ aoe j6() {
        return aM();
    }

    static /* synthetic */ int[] j3() {
        int[] iArr = FH;
        if (iArr == null) {
            iArr = new int[aof$a.values().length];
            try {
                iArr[aof$a.FAST_FORWARD.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aof$a.FORCED.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[aof$a.IO_FAILURE.ordinal()] = 9;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[aof$a.LOCK_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[aof$a.NEW.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[aof$a.NOT_ATTEMPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[aof$a.NO_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[aof$a.REJECTED.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[aof$a.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[aof$a.RENAMED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            FH = iArr;
        }
        return iArr;
    }

    arz(ary ary, aoc aoc) {
        super(aoc);
        this.j6 = ary;
    }

    protected ary aM() {
        return this.j6;
    }

    protected aoh DW() {
        return this.j6.FH();
    }

    protected boolean j6(boolean z) {
        aoc v5 = v5();
        if (z) {
            v5 = v5.FH();
        }
        String j6 = v5.j6();
        this.DW = new ark(this.j6.Hw(j6), DW().gn());
        if (!this.DW.j6()) {
            return false;
        }
        v5 = this.j6.DW(j6);
        j6(v5 != null ? v5.v5() : null);
        return true;
    }

    protected void FH() {
        if (this.DW != null) {
            this.DW.Zo();
            this.DW = null;
        }
    }

    protected aof$a j6(aof$a aof_a) {
        this.DW.FH(((ash) this.j6.FH().VH().j6(ash.j6)).FH());
        this.DW.j6(true);
        this.DW.j6(Zo());
        String tp = tp();
        if (tp != null) {
            String FH;
            if (EQ()) {
                FH = FH(aof_a);
                if (FH != null) {
                    if (tp.length() > 0) {
                        FH = new StringBuilder(String.valueOf(tp)).append(": ").append(FH).toString();
                    }
                    this.j6.j6((aof) this, FH, true);
                }
            }
            FH = tp;
            this.j6.j6((aof) this, FH, true);
        }
        if (!this.DW.Hw()) {
            return aof$a.LOCK_FAILURE;
        }
        this.j6.j6(this, this.DW.v5());
        return aof_a;
    }

    private String FH(aof$a aof_a) {
        switch (j3()[aof_a.ordinal()]) {
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "created";
            case 5:
                return "forced-update";
            case 6:
                return "fast forward";
            default:
                return null;
        }
    }

    protected aof$a DW(aof$a aof_a) {
        if (v5().FH().Zo() != aoc$a.NEW) {
            this.j6.j6(this);
        }
        return aof_a;
    }

    protected aof$a j6(String str) {
        this.DW.FH(((ash) this.j6.FH().VH().j6(ash.j6)).FH());
        this.DW.j6(true);
        this.DW.j6(anj.DW("ref: " + str + '\n'));
        String tp = tp();
        if (tp != null) {
            this.j6.j6((aof) this, tp, false);
        }
        if (!this.DW.Hw()) {
            return aof$a.LOCK_FAILURE;
        }
        this.j6.j6(this, this.DW.v5(), str);
        if (v5().Zo() == aoc$a.NEW) {
            return aof$a.NEW;
        }
        return aof$a.FORCED;
    }
}
