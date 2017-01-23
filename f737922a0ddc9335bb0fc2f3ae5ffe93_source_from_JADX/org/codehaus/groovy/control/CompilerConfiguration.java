package org.codehaus.groovy.control;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.codehaus.groovy.control.customizers.CompilationCustomizer;
import org.codehaus.groovy.control.io.NullWriter;

public class CompilerConfiguration {
    public static final CompilerConfiguration DW;
    private static final String[] FH;
    public static final String j6;
    private int EQ;
    private int Hw;
    private String J0;
    private Set<String> J8;
    private int QX;
    private File VH;
    private boolean Ws;
    private String XL;
    private PrintWriter Zo;
    private Map<String, Boolean> aM;
    private LinkedList<String> gn;
    private List<CompilationCustomizer> j3;
    private boolean tp;
    private boolean u7;
    private String v5;
    private String we;

    static {
        FH = new String[]{"1.4", "1.5", "1.6", "1.7", "1.8"};
        j6 = v5();
        DW = new CompilerConfiguration();
    }

    public CompilerConfiguration() {
        String property;
        boolean z;
        this.J8 = new LinkedHashSet();
        this.j3 = new LinkedList();
        j6(1);
        j6(null);
        j6((File) null);
        FH("");
        j6(false);
        DW(false);
        DW(10);
        Hw(null);
        FH(false);
        FH(100);
        try {
            property = System.getProperty("groovy.target.bytecode", null);
        } catch (Exception e) {
            property = null;
        }
        if (property != null) {
            Zo(property);
        } else {
            Zo(v5());
        }
        try {
            property = System.getProperty("groovy.default.scriptExtension");
        } catch (Exception e2) {
            property = null;
        }
        if (property != null) {
            v5(property);
        } else {
            v5(".groovy");
        }
        try {
            property = System.getProperty("file.encoding", "US-ASCII");
        } catch (Exception e3) {
            property = null;
        }
        try {
            property = System.getProperty("groovy.source.encoding", property);
        } catch (Exception e4) {
        }
        j6(property);
        try {
            j6(new PrintWriter(System.err));
        } catch (Exception e5) {
        }
        try {
            property = System.getProperty("groovy.target.directory");
            if (property != null) {
                DW(property);
            }
        } catch (Exception e6) {
        }
        try {
            z = Boolean.getBoolean("groovy.target.indy");
        } catch (Exception e7) {
            z = false;
        }
        if (DW != null && Boolean.TRUE.equals(DW.FH().get("indy"))) {
            z = true;
        }
        Map hashMap = new HashMap(3);
        if (z) {
            hashMap.put("indy", Boolean.TRUE);
        }
        j6(hashMap);
    }

    public void j6(int i) {
        if (i < 0 || i > 3) {
            this.Hw = 1;
        } else {
            this.Hw = i;
        }
    }

    public void j6(String str) {
        if (str == null) {
            str = "US-ASCII";
        }
        this.v5 = str;
    }

    public void j6(PrintWriter printWriter) {
        if (printWriter == null) {
            this.Zo = new PrintWriter(NullWriter.j6);
        } else {
            this.Zo = printWriter;
        }
    }

    public File j6() {
        return this.VH;
    }

    public void DW(String str) {
        if (str == null || str.length() <= 0) {
            this.VH = null;
        } else {
            this.VH = new File(str);
        }
    }

    public void j6(File file) {
        this.VH = file;
    }

    public void FH(String str) {
        this.gn = new LinkedList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, File.pathSeparator);
        while (stringTokenizer.hasMoreTokens()) {
            this.gn.add(stringTokenizer.nextToken());
        }
    }

    public void j6(boolean z) {
        this.u7 = z;
    }

    public boolean DW() {
        return this.tp;
    }

    public void DW(boolean z) {
        this.tp = z;
    }

    public void DW(int i) {
        this.EQ = i;
    }

    public void Hw(String str) {
        this.we = str;
    }

    public void v5(String str) {
        this.J0 = str;
    }

    public void FH(boolean z) {
        this.Ws = z;
    }

    public void FH(int i) {
        this.QX = Math.max(0, i);
    }

    public void Zo(String str) {
        for (String equals : FH) {
            if (equals.equals(str)) {
                this.XL = str;
            }
        }
    }

    private static String v5() {
        try {
            Class.forName("java.lang.annotation.Annotation");
            return "1.5";
        } catch (Exception e) {
            return "1.4";
        }
    }

    public Map<String, Boolean> FH() {
        return this.aM;
    }

    public void j6(Map<String, Boolean> map) {
        if (map == null) {
            throw new IllegalArgumentException("provided option map must not be null");
        }
        this.aM = map;
    }

    public List<CompilationCustomizer> Hw() {
        return this.j3;
    }
}
