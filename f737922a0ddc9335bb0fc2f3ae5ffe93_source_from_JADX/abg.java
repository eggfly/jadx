public final class abg extends adm implements aai {
    private final aah[] j6;

    public abg(int i) {
        super(i > 1);
        if (i < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        this.j6 = new aah[i];
    }

    public aah FH(int i) {
        try {
            return this.j6[i];
        } catch (IndexOutOfBoundsException e) {
            return Hw(i);
        }
    }

    public aah DW(int i) {
        if (i == 0) {
            return null;
        }
        return j6(i);
    }

    public aah j6(int i) {
        try {
            aah aah = this.j6[i];
            if (aah != null) {
                return aah;
            }
            Hw(i);
            return aah;
        } catch (IndexOutOfBoundsException e) {
            return Hw(i);
        }
    }

    public void j6(int i, aah aah) {
        we();
        Object obj = (aah == null || !aah.VH()) ? null : 1;
        if (i < 1) {
            throw new IllegalArgumentException("n < 1");
        }
        if (obj != null) {
            if (i == this.j6.length - 1) {
                throw new IllegalArgumentException("(n == size - 1) && cst.isCategory2()");
            }
            this.j6[i + 1] = null;
        }
        if (aah != null && this.j6[i] == null) {
            aah aah2 = this.j6[i - 1];
            if (aah2 != null && aah2.VH()) {
                this.j6[i - 1] = null;
            }
        }
        this.j6[i] = aah;
    }

    private static aah Hw(int i) {
        throw new ada("invalid constant pool index " + add.FH(i));
    }
}
