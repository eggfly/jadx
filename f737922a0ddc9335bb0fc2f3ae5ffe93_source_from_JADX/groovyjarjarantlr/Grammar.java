package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class Grammar {
    protected Hashtable DW;
    protected boolean FH;
    protected TokenManager Hw;
    protected int VH;
    protected String Zo;
    protected LLkGrammarAnalyzer j6;
    protected Vector v5;

    public String j6() {
        return this.Zo;
    }

    public GrammarSymbol j6(String str) {
        return (GrammarSymbol) this.DW.get(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(20000);
        Enumeration j6 = this.v5.j6();
        while (j6.hasMoreElements()) {
            RuleSymbol ruleSymbol = (RuleSymbol) j6.nextElement();
            if (!ruleSymbol.j6.equals("mnextToken")) {
                stringBuffer.append(ruleSymbol.j6().toString());
                stringBuffer.append("\n\n");
            }
        }
        return stringBuffer.toString();
    }
}
