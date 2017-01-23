package groovyjarjarantlr.preprocessor;

import groovyjarjarantlr.collections.impl.IndexedVector;
import java.util.Enumeration;

public class GrammarFile {
    protected IndexedVector DW;
    protected IndexedVector FH;
    protected String j6;

    public String toString() {
        String str = this.j6 == null ? "" : this.j6;
        String j6 = this.DW == null ? "" : Hierarchy.j6(this.DW);
        StringBuffer stringBuffer = new StringBuffer(10000);
        stringBuffer.append(str);
        stringBuffer.append(j6);
        Enumeration j62 = this.FH.j6();
        while (j62.hasMoreElements()) {
            stringBuffer.append(((Grammar) j62.nextElement()).toString());
        }
        return stringBuffer.toString();
    }
}
