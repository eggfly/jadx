package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;
import java.util.Hashtable;

class SimpleTokenManager implements TokenManager, Cloneable {
    protected int DW;
    protected Vector FH;
    protected Tool Hw;
    private Hashtable j6;
    protected String v5;

    public Object clone() {
        try {
            SimpleTokenManager simpleTokenManager = (SimpleTokenManager) super.clone();
            simpleTokenManager.FH = (Vector) this.FH.clone();
            simpleTokenManager.j6 = (Hashtable) this.j6.clone();
            simpleTokenManager.DW = this.DW;
            simpleTokenManager.Hw = this.Hw;
            simpleTokenManager.v5 = this.v5;
            return simpleTokenManager;
        } catch (CloneNotSupportedException e) {
            this.Hw.FH("cannot clone token manager");
            return null;
        }
    }

    public TokenSymbol j6(String str) {
        return (TokenSymbol) this.j6.get(str);
    }

    public Vector j6() {
        return this.FH;
    }

    public int DW() {
        return this.DW - 1;
    }

    public boolean DW(String str) {
        return this.j6.containsKey(str);
    }
}
