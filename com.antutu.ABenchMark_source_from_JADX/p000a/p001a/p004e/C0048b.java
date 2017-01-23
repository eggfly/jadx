package p000a.p001a.p004e;

/* renamed from: a.a.e.b */
public enum C0048b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    public final int f162g;

    private C0048b(int i) {
        this.f162g = i;
    }

    public static C0048b m190a(int i) {
        for (C0048b c0048b : C0048b.values()) {
            if (c0048b.f162g == i) {
                return c0048b;
            }
        }
        return null;
    }
}
