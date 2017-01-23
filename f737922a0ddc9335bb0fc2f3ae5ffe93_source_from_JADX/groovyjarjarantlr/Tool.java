package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;
import java.io.InputStreamReader;
import java.io.Reader;

public class Tool {
    public static String j6;
    ToolErrorHandler DW;
    protected NameSpace EQ;
    protected boolean FH;
    boolean Hw;
    protected String J0;
    protected boolean J8;
    private BitSet QX;
    protected String VH;
    protected boolean Ws;
    boolean Zo;
    transient Reader gn;
    protected boolean tp;
    protected String u7;
    boolean v5;
    protected String we;

    static {
        j6 = "";
    }

    public Tool() {
        this.FH = false;
        this.Hw = false;
        this.v5 = false;
        this.Zo = false;
        this.VH = ".";
        this.gn = new InputStreamReader(System.in);
        this.u7 = "LITERAL_";
        this.tp = false;
        this.EQ = null;
        this.we = null;
        this.J0 = null;
        this.J8 = true;
        this.Ws = false;
        this.QX = new BitSet();
        this.DW = new DefaultToolErrorHandler(this);
    }

    public void j6(String str) {
        this.FH = true;
        System.err.println(new StringBuffer().append("error: ").append(str).toString());
    }

    public void j6(String str, String str2, int i, int i2) {
        this.FH = true;
        System.err.println(new StringBuffer().append(FileLineFormatter.j6().j6(str2, i, i2)).append(str).toString());
    }

    public void DW(String str) {
        System.err.println(str);
        Utils.DW(str);
    }

    public void FH(String str) {
        DW(new StringBuffer().append("panic: ").append(str).toString());
    }

    public void Hw(String str) {
        System.err.println(new StringBuffer().append("warning: ").append(str).toString());
    }

    public void DW(String str, String str2, int i, int i2) {
        System.err.println(new StringBuffer().append(FileLineFormatter.j6().j6(str2, i, i2)).append("warning:").append(str).toString());
    }
}
