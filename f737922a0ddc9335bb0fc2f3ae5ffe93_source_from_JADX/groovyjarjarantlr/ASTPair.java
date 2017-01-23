package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;

public class ASTPair {
    public AST DW;
    public AST j6;

    public final void j6() {
        if (this.DW != null) {
            while (this.DW.DW() != null) {
                this.DW = this.DW.DW();
            }
        }
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.j6 == null ? "null" : this.j6.FH()).append(",").append(this.DW == null ? "null" : this.DW.FH()).append("]").toString();
    }
}
