package groovyjarjarantlr.debug;

public class InputBufferReporter implements InputBufferListener {
    public void j6(TraceEvent traceEvent) {
    }

    public void j6(InputBufferEvent inputBufferEvent) {
        System.out.println(inputBufferEvent);
    }

    public void DW(InputBufferEvent inputBufferEvent) {
        System.out.println(inputBufferEvent);
    }

    public void FH(InputBufferEvent inputBufferEvent) {
        System.out.println(inputBufferEvent);
    }

    public void Hw(InputBufferEvent inputBufferEvent) {
        System.out.println(inputBufferEvent);
    }
}
