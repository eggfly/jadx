package groovyjarjarantlr.debug;

public interface TraceListener extends ListenerBase {
    void DW(TraceEvent traceEvent);

    void FH(TraceEvent traceEvent);
}
