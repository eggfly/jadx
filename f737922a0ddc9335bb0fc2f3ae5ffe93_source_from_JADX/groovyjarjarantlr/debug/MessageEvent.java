package groovyjarjarantlr.debug;

public class MessageEvent extends Event {
    public static int DW;
    public static int j6;
    private String FH;

    static {
        j6 = 0;
        DW = 1;
    }

    public String DW() {
        return this.FH;
    }

    public String toString() {
        return new StringBuffer().append("ParserMessageEvent [").append(j6() == j6 ? "warning," : "error,").append(DW()).append("]").toString();
    }
}
