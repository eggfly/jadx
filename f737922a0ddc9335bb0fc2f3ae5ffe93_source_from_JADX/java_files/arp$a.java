import java.util.Iterator;

abstract class arp$a implements Iterator<arp$b> {
    protected long DW;
    final /* synthetic */ arp FH;
    protected final arp$b j6;

    public abstract arp$b DW();

    protected abstract arp$b j6();

    public /* synthetic */ Object next() {
        return DW();
    }

    arp$a(arp arp) {
        this.FH = arp;
        this.j6 = j6();
        this.DW = 0;
    }

    public boolean hasNext() {
        return this.DW < this.FH.j6();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
