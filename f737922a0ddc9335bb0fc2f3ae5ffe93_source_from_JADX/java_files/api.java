public class api {
    static final byte[] DW;
    private static final byte[] FH;
    private static final byte[] Hw;
    private static final byte[] VH;
    private static final byte[] Zo;
    static final byte[] j6;
    private static final byte[][] v5;

    static {
        j6 = anj.j6("diff --git ");
        FH = anj.j6("diff --cc ");
        Hw = anj.j6("diff --combined ");
        v5 = new byte[][]{anj.j6("Binary files "), anj.j6("Files ")};
        Zo = anj.j6(" differ\n");
        VH = anj.j6("GIT binary patch\n");
        DW = anj.j6("-- \n");
    }
}
