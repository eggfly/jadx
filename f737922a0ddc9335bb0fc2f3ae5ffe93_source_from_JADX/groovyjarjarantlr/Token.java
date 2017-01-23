package groovyjarjarantlr;

public class Token implements Cloneable {
    public static Token VH;
    protected int Zo;

    static {
        VH = new Token(0, "<no text>");
    }

    public Token() {
        this.Zo = 0;
    }

    public Token(int i) {
        this.Zo = 0;
        this.Zo = i;
    }

    public Token(int i, String str) {
        this.Zo = 0;
        this.Zo = i;
        j6(str);
    }

    public int Zo() {
        return 0;
    }

    public int v5() {
        return 0;
    }

    public String FH() {
        return "<no text>";
    }

    public void j6(String str) {
    }

    public void DW(int i) {
    }

    public void j6(int i) {
    }

    public int Hw() {
        return this.Zo;
    }

    public void FH(int i) {
        this.Zo = i;
    }

    public String toString() {
        return new StringBuffer().append("[\"").append(FH()).append("\",<").append(Hw()).append(">]").toString();
    }
}
