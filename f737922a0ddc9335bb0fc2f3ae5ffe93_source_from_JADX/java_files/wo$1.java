import java.util.Comparator;

class wo$1 implements Comparator<ut$a> {
    final /* synthetic */ wo j6;

    wo$1(wo woVar) {
        this.j6 = woVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((ut$a) obj, (ut$a) obj2);
    }

    public int j6(ut$a ut_a, ut$a ut_a2) {
        return ut_a.j6() - ut_a2.j6();
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
