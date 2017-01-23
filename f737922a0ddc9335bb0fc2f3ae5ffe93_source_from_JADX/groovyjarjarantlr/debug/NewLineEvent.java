package groovyjarjarantlr.debug;

public class NewLineEvent extends Event {
    private int j6;

    void FH(int i) {
        this.j6 = i;
    }

    void DW(int i) {
        FH(i);
    }

    public String toString() {
        return new StringBuffer().append("NewLineEvent [").append(this.j6).append("]").toString();
    }
}
