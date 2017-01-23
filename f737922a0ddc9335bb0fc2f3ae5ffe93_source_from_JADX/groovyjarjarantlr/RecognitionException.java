package groovyjarjarantlr;

public class RecognitionException extends ANTLRException {
    public String gn;
    public int tp;
    public int u7;

    public RecognitionException() {
        super("parsing error");
        this.gn = null;
        this.u7 = -1;
        this.tp = -1;
    }

    public RecognitionException(String str) {
        super(str);
        this.gn = null;
        this.u7 = -1;
        this.tp = -1;
    }

    public RecognitionException(String str, String str2, int i, int i2) {
        super(str);
        this.gn = str2;
        this.u7 = i;
        this.tp = i2;
    }

    public int j6() {
        return this.u7;
    }

    public int DW() {
        return this.tp;
    }

    public String toString() {
        return new StringBuffer().append(FileLineFormatter.j6().j6(this.gn, this.u7, this.tp)).append(getMessage()).toString();
    }
}
