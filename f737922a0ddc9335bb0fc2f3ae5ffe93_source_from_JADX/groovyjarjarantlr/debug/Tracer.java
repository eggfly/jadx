package groovyjarjarantlr.debug;

public class Tracer extends TraceAdapter implements TraceListener {
    String j6;

    public Tracer() {
        this.j6 = "";
    }

    protected void j6() {
        if (this.j6.length() < 2) {
            this.j6 = "";
        } else {
            this.j6 = this.j6.substring(2);
        }
    }

    public void DW(TraceEvent traceEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(traceEvent).toString());
        DW();
    }

    public void FH(TraceEvent traceEvent) {
        j6();
        System.out.println(new StringBuffer().append(this.j6).append(traceEvent).toString());
    }

    protected void DW() {
        this.j6 = new StringBuffer().append(this.j6).append("  ").toString();
    }
}
