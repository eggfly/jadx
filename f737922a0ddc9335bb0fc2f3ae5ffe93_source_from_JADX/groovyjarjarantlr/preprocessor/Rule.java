package groovyjarjarantlr.preprocessor;

import groovyjarjarantlr.collections.impl.IndexedVector;
import java.util.Enumeration;

class Rule {
    protected String DW;
    protected String FH;
    protected String Hw;
    protected IndexedVector VH;
    protected String Zo;
    protected String gn;
    protected String j6;
    protected boolean tp;
    protected Grammar u7;
    protected String v5;

    public boolean j6() {
        return this.tp;
    }

    public String toString() {
        String stringBuffer = new StringBuffer().append(new StringBuffer().append("").append(this.gn == null ? "" : new StringBuffer().append(this.gn).append(" ").toString()).toString()).append(this.j6).append(j6() ? "!" : "").append(this.FH == null ? "" : this.FH).append(" ").append(this.Hw == null ? "" : new StringBuffer().append("returns ").append(this.Hw).toString()).append(this.v5).toString();
        if (this.VH != null) {
            stringBuffer = new StringBuffer().append(stringBuffer).append(System.getProperty("line.separator")).append("options {").append(System.getProperty("line.separator")).toString();
            Enumeration j6 = this.VH.j6();
            while (j6.hasMoreElements()) {
                stringBuffer = new StringBuffer().append(stringBuffer).append((Option) j6.nextElement()).append(System.getProperty("line.separator")).toString();
            }
            stringBuffer = new StringBuffer().append(stringBuffer).append("}").append(System.getProperty("line.separator")).toString();
        }
        if (this.Zo != null) {
            stringBuffer = new StringBuffer().append(stringBuffer).append(this.Zo).append(System.getProperty("line.separator")).toString();
        }
        return new StringBuffer().append(stringBuffer).append(this.DW).toString();
    }
}
