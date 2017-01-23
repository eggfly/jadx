import com.aide.common.e;
import com.aide.engine.aa;
import com.aide.engine.service.CharArray;
import com.aide.engine.service.i.a;

class pl$2 extends a {
    final /* synthetic */ pl DW;
    private aa FH;
    private CharArray Hw;
    final /* synthetic */ pl$a j6;

    pl$2(pl plVar, pl$a pl_a) {
        this.DW = plVar;
        this.j6 = pl_a;
        this.FH = new aa();
        this.Hw = new CharArray(10000);
    }

    public long j6() {
        return this.j6.Zo();
    }

    public long DW() {
        try {
            this.j6.j6(this.FH);
            this.FH.j6 = this.FH.j6;
            this.FH.DW = this.FH.DW;
            this.FH.FH = this.FH.FH;
        } catch (Throwable e) {
            e.j6(e);
            this.FH.DW = 0;
        }
        return this.FH.FH;
    }

    public int FH() {
        return this.FH.DW;
    }

    public CharArray j6(int i) {
        char[] cArr = this.FH.j6;
        char[] cArr2 = this.Hw.j6;
        int i2 = this.FH.DW;
        int length = cArr2.length;
        int i3 = 0;
        while (i < i2 && i3 < length) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            cArr2[i3] = cArr[i];
            i3 = i4;
            i = i5;
        }
        this.Hw.DW = i3;
        return this.Hw;
    }
}
