import com.aide.uidesigner.ProxyTextView;

class aka$a<S extends akh> {
    private static /* synthetic */ int[] Zo;
    final /* synthetic */ aka DW;
    private final ajy<S> FH;
    private final ajx<S> Hw;
    final ajw j6;
    private final ajx<S> v5;

    static /* synthetic */ int[] j6() {
        int[] iArr = Zo;
        if (iArr == null) {
            iArr = new int[ajv$a.values().length];
            try {
                iArr[ajv$a.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajv$a.EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ajv$a.INSERT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ajv$a.REPLACE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            Zo = iArr;
        }
        return iArr;
    }

    aka$a(aka aka, ajw ajw, ajy<S> ajy_S, ajx<S> ajx_S, ajx<S> ajx_S2) {
        this.DW = aka;
        this.FH = ajy_S;
        this.Hw = ajx_S;
        this.v5 = ajx_S2;
        this.j6 = ajw;
    }

    void j6(ajv ajv) {
        ajv j6 = new akb(this.DW.DW, this.FH, this.Hw, this.v5, ajv).j6();
        if (j6 != null) {
            if (j6.DW()) {
                this.j6.add(ajv);
                return;
            }
            DW(ajv.j6(j6));
            DW(ajv.DW(j6));
        } else if (this.DW.j6 instanceof akc) {
            ((akc) this.DW.j6).j6(this.j6, this.FH, this.Hw, this.v5, ajv);
        } else if (this.DW.j6 != null) {
            aki DW = DW();
            akl j62 = akl.j6(this.Hw, ajv);
            akl DW2 = akl.DW(this.v5, ajv);
            this.j6.addAll(akl.j6(this.DW.j6.DW(DW, j62, DW2), j62, DW2));
        } else {
            this.j6.add(ajv);
        }
    }

    private void DW(ajv ajv) {
        switch (j6()[ajv.j6().ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                this.j6.add(ajv);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6(ajv);
            default:
                throw new IllegalStateException();
        }
    }

    private akm<ajx<S>> DW() {
        return new akm(this.FH);
    }
}
