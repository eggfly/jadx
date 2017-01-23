final class awl$b extends awl {
    private awl$b() {
    }

    public boolean j6(awc awc) {
        int tp = awc.tp();
        if (tp == 1) {
            return true;
        }
        int j6 = awc.j6(0);
        int i = 1;
        while (i < tp) {
            if (awc.j6(i) != j6 || !awc.j6(i, 0)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean j6() {
        return false;
    }

    public awl DW() {
        return this;
    }

    public String toString() {
        return "ANY_DIFF";
    }
}
