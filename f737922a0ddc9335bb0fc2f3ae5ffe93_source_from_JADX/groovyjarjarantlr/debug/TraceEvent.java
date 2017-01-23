package groovyjarjarantlr.debug;

public class TraceEvent extends GuessingEvent {
    public static int DW;
    public static int FH;
    public static int j6;
    private int Hw;

    static {
        j6 = 0;
        DW = 1;
        FH = 2;
    }

    public int FH() {
        return this.Hw;
    }

    public String toString() {
        return new StringBuffer().append("ParserTraceEvent [").append(j6() == j6 ? "enter," : "exit,").append(FH()).append(",").append(DW()).append("]").toString();
    }
}
