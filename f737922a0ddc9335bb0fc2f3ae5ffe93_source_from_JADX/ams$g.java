final class ams$g implements ams$a {
    private static String DW;
    static final ams$g j6;

    private ams$g() {
    }

    static {
        j6 = new ams$g();
        DW = "-!\"#$%&'()*+,./:;<=>?@[\\]_`{|}~";
    }

    public boolean j6(char c) {
        return DW.indexOf(c) != -1;
    }
}
