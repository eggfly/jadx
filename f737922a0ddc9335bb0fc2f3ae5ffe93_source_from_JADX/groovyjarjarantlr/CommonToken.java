package groovyjarjarantlr;

public class CommonToken extends Token {
    protected int FH;
    protected String Hw;
    protected int v5;

    public CommonToken() {
        this.Hw = null;
    }

    public CommonToken(int i, String str) {
        this.Hw = null;
        this.Zo = i;
        j6(str);
    }

    public CommonToken(String str) {
        this.Hw = null;
        this.Hw = str;
    }

    public int v5() {
        return this.FH;
    }

    public String FH() {
        return this.Hw;
    }

    public void j6(int i) {
        this.FH = i;
    }

    public void j6(String str) {
        this.Hw = str;
    }

    public String toString() {
        return new StringBuffer().append("[\"").append(FH()).append("\",<").append(this.Zo).append(">,line=").append(this.FH).append(",col=").append(this.v5).append("]").toString();
    }

    public int Zo() {
        return this.v5;
    }

    public void DW(int i) {
        this.v5 = i;
    }
}
