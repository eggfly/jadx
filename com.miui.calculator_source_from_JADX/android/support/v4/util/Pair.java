package android.support.v4.util;

public class Pair<F, S> {
    public final F f741a;
    public final S f742b;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (m1105a(pair.f741a, this.f741a) && m1105a(pair.f742b, this.f742b)) {
            return true;
        }
        return false;
    }

    private static boolean m1105a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f741a == null ? 0 : this.f741a.hashCode();
        if (this.f742b != null) {
            i = this.f742b.hashCode();
        }
        return hashCode ^ i;
    }
}
