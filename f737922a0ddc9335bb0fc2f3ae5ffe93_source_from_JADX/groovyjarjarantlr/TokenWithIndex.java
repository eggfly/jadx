package groovyjarjarantlr;

public class TokenWithIndex extends CommonToken {
    int j6;

    public void Hw(int i) {
        this.j6 = i;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.j6).append(":\"").append(FH()).append("\",<").append(Hw()).append(">,line=").append(this.FH).append(",col=").append(this.v5).append("]\n").toString();
    }
}
