package groovyjarjarantlr.preprocessor;

import groovyjarjarantlr.collections.impl.IndexedVector;

class Grammar {
    protected String DW;
    protected String FH;
    protected IndexedVector Hw;
    protected String VH;
    protected String Zo;
    protected String gn;
    protected String j6;
    protected String u7;
    protected IndexedVector v5;

    public String j6() {
        return this.j6;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10000);
        if (this.VH != null) {
            stringBuffer.append(this.VH);
        }
        if (this.DW == null) {
            return new StringBuffer().append("class ").append(this.j6).append(";").toString();
        }
        if (this.u7 != null) {
            stringBuffer.append(new StringBuffer().append("class ").append(this.j6).append(" extends ").append(this.u7).append(";").toString());
        } else {
            stringBuffer.append(new StringBuffer().append("class ").append(this.j6).append(" extends ").append(this.FH).append(";").toString());
        }
        stringBuffer.append(new StringBuffer().append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).toString());
        if (this.v5 != null) {
            stringBuffer.append(Hierarchy.j6(this.v5));
        }
        if (this.Zo != null) {
            stringBuffer.append(new StringBuffer().append(this.Zo).append("\n").toString());
        }
        if (this.gn != null) {
            stringBuffer.append(new StringBuffer().append(this.gn).append(System.getProperty("line.separator")).toString());
        }
        for (int i = 0; i < this.Hw.DW(); i++) {
            Rule rule = (Rule) this.Hw.j6(i);
            if (!j6().equals(rule.u7.j6())) {
                stringBuffer.append(new StringBuffer().append("// inherited from grammar ").append(rule.u7.j6()).append(System.getProperty("line.separator")).toString());
            }
            stringBuffer.append(new StringBuffer().append(rule).append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).toString());
        }
        return stringBuffer.toString();
    }
}
