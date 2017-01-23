public final class zg implements Comparable<zg> {
    private final aah DW;
    private final abe j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((zg) obj);
    }

    public zg(abe abe, aah aah) {
        if (abe == null) {
            throw new NullPointerException("name == null");
        } else if (aah == null) {
            throw new NullPointerException("value == null");
        } else {
            this.j6 = abe;
            this.DW = aah;
        }
    }

    public String toString() {
        return this.j6.Hw() + ":" + this.DW;
    }

    public int hashCode() {
        return (this.j6.hashCode() * 31) + this.DW.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zg)) {
            return false;
        }
        zg zgVar = (zg) obj;
        if (this.j6.equals(zgVar.j6) && this.DW.equals(zgVar.DW)) {
            return true;
        }
        return false;
    }

    public int j6(zg zgVar) {
        int j6 = this.j6.j6(zgVar.j6);
        return j6 != 0 ? j6 : this.DW.j6(zgVar.DW);
    }

    public abe j6() {
        return this.j6;
    }

    public aah DW() {
        return this.DW;
    }
}
