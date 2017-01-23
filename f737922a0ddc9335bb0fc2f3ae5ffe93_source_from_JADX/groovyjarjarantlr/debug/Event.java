package groovyjarjarantlr.debug;

import java.util.EventObject;

public abstract class Event extends EventObject {
    private int j6;

    public int j6() {
        return this.j6;
    }

    void j6(int i) {
        this.j6 = i;
    }

    void DW(int i) {
        j6(i);
    }
}
