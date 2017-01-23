public abstract class aah implements adq, Comparable<aah> {
    protected abstract int DW(aah aah);

    public abstract boolean VH();

    public abstract String gn();

    public /* synthetic */ int compareTo(Object obj) {
        return j6((aah) obj);
    }

    public final int j6(aah aah) {
        Class cls = getClass();
        Class cls2 = aah.getClass();
        if (cls != cls2) {
            return cls.getName().compareTo(cls2.getName());
        }
        return DW(aah);
    }
}
