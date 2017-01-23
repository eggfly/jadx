package groovyjarjarantlr;

public class ParseTreeRule extends ParseTree {
    protected String FH;
    protected int Hw;

    public String toString() {
        if (this.Hw == -1) {
            return new StringBuffer().append('<').append(this.FH).append('>').toString();
        }
        return new StringBuffer().append('<').append(this.FH).append("[").append(this.Hw).append("]>").toString();
    }
}
