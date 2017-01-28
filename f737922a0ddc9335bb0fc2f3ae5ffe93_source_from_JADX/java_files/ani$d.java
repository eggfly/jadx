class ani$d {
    private int DW;
    private final char[] j6;

    ani$d(String str) {
        this.j6 = str.toCharArray();
    }

    int j6() {
        try {
            char[] cArr = this.j6;
            int i = this.DW;
            this.DW = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.DW = this.j6.length;
            return -1;
        }
    }

    void DW() {
        this.DW--;
    }
}
