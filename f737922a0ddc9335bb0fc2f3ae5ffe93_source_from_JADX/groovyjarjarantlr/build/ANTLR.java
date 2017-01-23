package groovyjarjarantlr.build;

import java.io.File;
import java.io.FilenameFilter;

public class ANTLR {
    public static String DW;
    public static String FH;
    public static String[] Hw;
    public static String j6;

    class 1 implements FilenameFilter {
        public boolean accept(File file, String str) {
            return file.isDirectory() && str.equals("antlr");
        }
    }

    static {
        j6 = "javac";
        DW = "groovyjarjarantlr.jar";
        FH = ".";
        Hw = new String[]{"antlr", "groovyjarjarantlr/actions/cpp", "groovyjarjarantlr/actions/java", "groovyjarjarantlr/actions/csharp", "groovyjarjarantlr/collections", "groovyjarjarantlr/collections/impl", "groovyjarjarantlr/debug", "groovyjarjarantlr/ASdebug", "groovyjarjarantlr/debug/misc", "groovyjarjarantlr/preprocessor"};
    }

    public ANTLR() {
        j6 = System.getProperty("groovyjarjarantlr.build.compiler", j6);
        FH = System.getProperty("groovyjarjarantlr.build.root", FH);
    }
}
