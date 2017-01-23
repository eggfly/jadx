import java.util.Comparator;

class wo$2 implements Comparator<un$b> {
    final /* synthetic */ wo j6;

    wo$2(wo woVar) {
        this.j6 = woVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((un$b) obj, (un$b) obj2);
    }

    public int j6(un$b un_b, un$b un_b2) {
        return un_b.VH() - un_b2.VH();
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
