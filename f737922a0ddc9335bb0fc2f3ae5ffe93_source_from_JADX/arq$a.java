import java.util.NoSuchElementException;

class arq$a extends arp$a {
    final /* synthetic */ arq Hw;
    private int Zo;
    private int v5;

    private arq$a(arq arq) {
        this.Hw = arq;
        super(arq);
    }

    protected arp$b j6() {
        return new arq$a$1(this);
    }

    public arp$b DW() {
        while (this.v5 < this.Hw.FH.length) {
            if (this.Hw.FH[this.v5] != null) {
                if (this.Zo < this.Hw.FH[this.v5].length) {
                    this.j6.DW = axb.FH(this.Hw.FH[this.v5], this.Zo);
                    this.Zo += 24;
                    this.DW++;
                    return this.j6;
                }
                this.Zo = 0;
            }
            this.v5++;
        }
        throw new NoSuchElementException();
    }
}
