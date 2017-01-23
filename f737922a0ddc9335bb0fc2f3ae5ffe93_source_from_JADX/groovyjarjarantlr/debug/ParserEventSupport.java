package groovyjarjarantlr.debug;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.collections.impl.BitSet;
import java.util.Vector;

public class ParserEventSupport {
    private Vector DW;
    private ParserMatchEvent FH;
    private MessageEvent Hw;
    private SyntacticPredicateEvent VH;
    private SemanticPredicateEvent Zo;
    private TraceEvent gn;
    private Vector j6;
    private ParserController tp;
    private NewLineEvent u7;
    private ParserTokenEvent v5;

    public void j6(int i) {
        this.v5.j6(ParserTokenEvent.DW, 1, i);
        j6(0, this.DW);
    }

    public void j6(int i, ListenerBase listenerBase) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                ((ParserTokenListener) listenerBase).j6(this.v5);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                ((TraceListener) listenerBase).DW(this.gn);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                ((TraceListener) listenerBase).FH(this.gn);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                ((ParserTokenListener) listenerBase).DW(this.v5);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                ((ParserMatchListener) listenerBase).j6(this.FH);
            case 5:
                ((ParserMatchListener) listenerBase).DW(this.FH);
            case 6:
                ((ParserMatchListener) listenerBase).FH(this.FH);
            case 7:
                ((ParserMatchListener) listenerBase).Hw(this.FH);
            case 8:
                ((MessageListener) listenerBase).j6(this.Hw);
            case 9:
                ((MessageListener) listenerBase).DW(this.Hw);
            case 10:
                ((SemanticPredicateListener) listenerBase).j6(this.Zo);
            case 11:
                ((SyntacticPredicateListener) listenerBase).j6(this.VH);
            case 12:
                ((SyntacticPredicateListener) listenerBase).DW(this.VH);
            case 13:
                ((SyntacticPredicateListener) listenerBase).FH(this.VH);
            case 14:
                ((NewLineListener) listenerBase).j6(this.u7);
            case 15:
                listenerBase.j6(this.gn);
            default:
                throw new IllegalArgumentException(new StringBuffer().append("bad type ").append(i).append(" for fireEvent()").toString());
        }
    }

    public void j6(int i, Vector vector) {
        if (vector != null) {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                j6(i, (ListenerBase) vector.elementAt(i2));
            }
        }
        if (this.tp != null) {
            this.tp.j6();
        }
    }

    public void j6(int i, int i2) {
        this.v5.j6(ParserTokenEvent.j6, i, i2);
        j6(3, this.DW);
    }

    public void j6(int i, BitSet bitSet, String str, int i2) {
        this.FH.j6(ParserMatchEvent.DW, i, bitSet, str, i2, false, true);
        j6(4, this.j6);
    }

    public void j6(int i, String str, int i2) {
        this.FH.j6(ParserMatchEvent.j6, i, new Integer(i), str, i2, false, true);
        j6(4, this.j6);
    }

    public void j6(int i, int i2, String str, int i3) {
        this.FH.j6(ParserMatchEvent.j6, i, new Integer(i2), str, i3, true, true);
        j6(5, this.j6);
    }

    public void DW(int i, int i2, String str, int i3) {
        this.FH.j6(ParserMatchEvent.j6, i, new Integer(i2), str, i3, false, false);
        j6(6, this.j6);
    }

    public void DW(int i, BitSet bitSet, String str, int i2) {
        this.FH.j6(ParserMatchEvent.DW, i, bitSet, str, i2, false, true);
        j6(6, this.j6);
    }

    public void FH(int i, int i2, String str, int i3) {
        this.FH.j6(ParserMatchEvent.j6, i, new Integer(i2), str, i3, true, true);
        j6(7, this.j6);
    }
}
