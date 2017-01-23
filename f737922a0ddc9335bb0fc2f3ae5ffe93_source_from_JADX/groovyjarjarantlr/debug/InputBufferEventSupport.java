package groovyjarjarantlr.debug;

import com.aide.uidesigner.ProxyTextView;
import java.util.Vector;

public class InputBufferEventSupport {
    private InputBufferEvent DW;
    private Vector j6;

    public void j6(char c) {
        this.DW.j6(0, c, 0);
        j6(0, this.j6);
    }

    public void j6(int i, ListenerBase listenerBase) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                ((InputBufferListener) listenerBase).j6(this.DW);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                ((InputBufferListener) listenerBase).DW(this.DW);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                ((InputBufferListener) listenerBase).FH(this.DW);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                ((InputBufferListener) listenerBase).Hw(this.DW);
            default:
                throw new IllegalArgumentException(new StringBuffer().append("bad type ").append(i).append(" for fireEvent()").toString());
        }
    }

    public void j6(int i, Vector vector) {
        synchronized (this) {
            if (vector == null) {
                return;
            }
            Vector vector2 = (Vector) vector.clone();
            if (vector2 != null) {
                for (int i2 = 0; i2 < vector2.size(); i2++) {
                    j6(i, (ListenerBase) vector2.elementAt(i2));
                }
            }
        }
    }

    public void j6(char c, int i) {
        this.DW.j6(1, c, i);
        j6(1, this.j6);
    }

    public void j6(int i) {
        this.DW.j6(2, ' ', i);
        j6(2, this.j6);
    }

    public void DW(int i) {
        this.DW.j6(3, ' ', i);
        j6(3, this.j6);
    }
}
