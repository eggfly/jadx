import java.util.Iterator;

class aql$3 implements Iterator<aqc> {
    final /* synthetic */ aql DW;
    aqc j6;

    aql$3(aql aql, aqc aqc) {
        this.DW = aql;
        this.j6 = aqc;
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        return this.j6 != null;
    }

    public aqc j6() {
        try {
            aqc aqc = this.j6;
            this.j6 = this.DW.Hw();
            return aqc;
        } catch (Throwable e) {
            throw new alt(e);
        } catch (Throwable e2) {
            throw new alt(e2);
        } catch (Throwable e22) {
            throw new alt(e22);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
