package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;

public class TokenStreamHiddenTokenFilter extends TokenStreamBasicFilter implements TokenStream {
    protected BitSet FH;
    protected CommonHiddenStreamToken Hw;
    protected CommonHiddenStreamToken Zo;
    protected CommonHiddenStreamToken v5;

    protected void DW() {
        this.Hw = (CommonHiddenStreamToken) this.DW.j6();
    }

    private void FH() {
        DW();
        CommonHiddenStreamToken commonHiddenStreamToken = null;
        while (true) {
            if (this.FH.Hw(j6(1).Hw()) || this.j6.Hw(j6(1).Hw())) {
                if (this.FH.Hw(j6(1).Hw())) {
                    if (commonHiddenStreamToken == null) {
                        commonHiddenStreamToken = j6(1);
                    } else {
                        commonHiddenStreamToken.j6(j6(1));
                        j6(1).DW(commonHiddenStreamToken);
                        commonHiddenStreamToken = j6(1);
                    }
                    this.v5 = commonHiddenStreamToken;
                    if (this.Zo == null) {
                        this.Zo = commonHiddenStreamToken;
                    }
                }
                DW();
            } else {
                return;
            }
        }
    }

    protected CommonHiddenStreamToken j6(int i) {
        return this.Hw;
    }

    public Token j6() {
        if (j6(1) == null) {
            FH();
        }
        Token j6 = j6(1);
        j6.DW(this.v5);
        this.v5 = null;
        DW();
        CommonHiddenStreamToken commonHiddenStreamToken = j6;
        while (true) {
            if (!this.FH.Hw(j6(1).Hw()) && !this.j6.Hw(j6(1).Hw())) {
                return j6;
            }
            if (this.FH.Hw(j6(1).Hw())) {
                commonHiddenStreamToken.j6(j6(1));
                if (commonHiddenStreamToken != j6) {
                    j6(1).DW(commonHiddenStreamToken);
                }
                commonHiddenStreamToken = j6(1);
                this.v5 = commonHiddenStreamToken;
            }
            DW();
        }
    }
}
