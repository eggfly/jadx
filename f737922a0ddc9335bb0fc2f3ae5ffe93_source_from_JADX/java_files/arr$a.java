import java.util.NoSuchElementException;

class arr$a extends arp$a {
    final /* synthetic */ arr Hw;
    private int Zo;
    private int v5;

    private arr$a(arr arr) {
        this.Hw = arr;
        super(arr);
    }

    protected arp$b j6() {
        return new arr$a$1(this);
    }

    public arp$b DW() {
        while (this.v5 < this.Hw.Zo.length) {
            if (this.Zo < this.Hw.Zo[this.v5].length) {
                long FH = axb.FH(this.Hw.VH[this.v5], (this.Zo / 5) * 4);
                if ((2147483648L & FH) != 0) {
                    FH = axb.Hw(this.Hw.u7, ((int) (FH & -2147483649L)) * 8);
                }
                this.j6.DW = FH;
                this.Zo += 5;
                this.DW++;
                return this.j6;
            }
            this.Zo = 0;
            this.v5++;
        }
        throw new NoSuchElementException();
    }
}
