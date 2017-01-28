import java.util.Map;

class l$1 extends q<K, V> {
    final /* synthetic */ l j6;

    l$1(l lVar) {
        this.j6 = lVar;
    }

    protected int j6() {
        return this.j6.gn;
    }

    protected Object j6(int i, int i2) {
        return this.j6.VH[(i << 1) + i2];
    }

    protected int j6(Object obj) {
        return this.j6.j6(obj);
    }

    protected int DW(Object obj) {
        return this.j6.DW(obj);
    }

    protected Map<K, V> DW() {
        return this.j6;
    }

    protected void j6(K k, V v) {
        this.j6.put(k, v);
    }

    protected V j6(int i, V v) {
        return this.j6.j6(i, (Object) v);
    }

    protected void j6(int i) {
        this.j6.Hw(i);
    }

    protected void FH() {
        this.j6.clear();
    }
}
