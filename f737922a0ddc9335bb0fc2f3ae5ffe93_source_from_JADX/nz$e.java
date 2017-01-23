class nz$e {
    public String DW;
    public String j6;

    public nz$e(String str, String str2) {
        this.j6 = str;
        this.DW = str2;
    }

    public boolean j6(nz$e nz_e) {
        return qh.FH(this.j6, nz_e.j6);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.DW == null ? 0 : this.DW.hashCode()) + 31) * 31;
        if (this.j6 != null) {
            i = this.j6.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        nz$e nz_e = (nz$e) obj;
        if (this.DW == null) {
            if (nz_e.DW != null) {
                return false;
            }
        } else if (!this.DW.equals(nz_e.DW)) {
            return false;
        }
        if (this.j6 == null) {
            if (nz_e.j6 != null) {
                return false;
            }
            return true;
        } else if (this.j6.equals(nz_e.j6)) {
            return true;
        } else {
            return false;
        }
    }
}
