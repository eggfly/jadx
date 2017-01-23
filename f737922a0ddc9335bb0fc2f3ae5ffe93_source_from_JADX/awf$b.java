class awf$b extends awf {
    private final awl[] j6;

    awf$b(awl[] awlArr) {
        this.j6 = awlArr;
    }

    public boolean j6(awc awc) {
        for (awl j6 : this.j6) {
            if (!j6.j6(awc)) {
                return false;
            }
        }
        return true;
    }

    public boolean j6() {
        for (awl j6 : this.j6) {
            if (j6.j6()) {
                return true;
            }
        }
        return false;
    }

    public awl DW() {
        awl[] awlArr = new awl[this.j6.length];
        for (int i = 0; i < awlArr.length; i++) {
            awlArr[i] = this.j6[i].DW();
        }
        return new awf$b(awlArr);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < this.j6.length; i++) {
            if (i > 0) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append(this.j6[i].toString());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
