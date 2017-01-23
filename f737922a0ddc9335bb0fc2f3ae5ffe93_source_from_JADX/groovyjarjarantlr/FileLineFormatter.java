package groovyjarjarantlr;

public abstract class FileLineFormatter {
    private static FileLineFormatter j6;

    public abstract String j6(String str, int i, int i2);

    static {
        j6 = new DefaultFileLineFormatter();
    }

    public static FileLineFormatter j6() {
        return j6;
    }
}
