import com.aide.uidesigner.ProxyTextView;
import java.io.Reader;

public class fv implements et {
    private static final int[] DW;
    private static final int[] FH;
    private static final int[] Hw;
    private static final int[] Zo;
    private static final char[] j6;
    private static final String[] v5;
    private int EQ;
    private int J0;
    private int J8;
    private boolean Mr;
    private int QX;
    private int U2;
    private Reader VH;
    private int Ws;
    private int XL;
    private int a8;
    private int aM;
    private int gn;
    private boolean j3;
    private int lg;
    private boolean rN;
    private char[] tp;
    private int u7;
    private int we;

    static {
        j6 = j6("\t\u0000\u0001\u0001\u0001\u0001\u0002\u0000\u0001\u0001\u0012\u0000\u0001\u0001\u0001\n\u0001 \u0001\u0006\u0001\u0000\u0001\u0015\u0001\u0005\u0001\u001f\u0001!\u0001\"\u0001#\u0001$\u0001&\u0001\u0004\u0001\u0003\u0001\u0000\n\u0003\u0001\u0002\u0001\u0007\u0001\t\u0001\u0000\u0001\u0018\u0001\u0019\u0001\u0000\u0001\u0012\u0001\u0002\u0001\u001a\u0001\u001c\u0001\u000b\u0001)\u0001\u001d\u0001\u0002\u0001\u000e\u0002\u0002\u0001\u0010\u0001\u0011\u0001\f\u0001\u0014\u0001(\u0001'\u0001\u001e\u0001\u0013\u0001\r\u0001\u001b\u0002\u0002\u0001\b\u0001\u000f\u0001\u0002\u0001\u0016\u0001\u0000\u0001\u0017\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0012\u0001\u0002\u0001\u001a\u0001\u001c\u0001\u000b\u0001)\u0001\u001d\u0001\u0002\u0001\u000e\u0002\u0002\u0001\u0010\u0001\u0011\u0001\f\u0001\u0014\u0001(\u0001'\u0001\u001e\u0001\u0013\u0001\r\u0001\u001b\u0002\u0002\u0001\b\u0001\u000f\u0001\u0002\u0001\u0000\u0001%:\u0000\u0001\u0003\b\u0000\u0017\u0002\u0001\u0000\u001f\u0002\u0001\u0000\b\u00022\u0002\u0002\u0000\u000b\u0002\u0002\u0000\b\u0002\u0001\u00005\u0002\u0001\u0000D\u0002\t\u0000$\u0002\u0003\u0000\u0002\u0002\u0004\u0000\u001e\u00028\u0000Y\u0002\u0012\u0000\u0007\u0002\u000e\u0000\u0001\u0003\u0001\u0003.\u0000F\u0003\u001a\u0000\u0002\u0003$\u0000\u0001\u0002\u0001\u0003\u0003\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u000b\u0002\u0001\u0002\b\u0002\u0001\u0000\t\u0002\u0001\u0002\u001c\u0002\u0001\u0002\u0002\u0002\u0001\u0002\u0002\u0002\u0001\u0000\u0007\u0002\u0003\u0000\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0012\u0002\r\u0000\f\u0002\u0001\u0000B\u0002\u0001\u0000\f\u0002\u0001\u0000$\u0002\u0001\u0000\u0004\u0003\t\u00005\u0002\u0002\u0000\u0002\u0002\u0002\u0000\u0002\u0002\u0003\u0000\u001c\u0002\u0002\u0000\b\u0002\u0002\u0000\u0002\u00027\u0000&\u0002\u0002\u0000\u0001\u0002\u0007\u0000&\u0002\n\u0000\u0011\u0003\u0001\u0000\u0017\u0003\u0001\u0000\u0003\u0003\u0001\u0000\u0001\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0001\u0003\u000b\u0000\u001b\u0002\u0005\u0000\u0003\u0002.\u0000\u001a\u0002\u0005\u0000\u0001\u0003\n\u0002\b\u0003\r\u0000\n\u0003\u0006\u0000\u0001\u0003G\u0002\u0002\u0000\u0005\u0002\u0001\u0000\u000f\u0002\u0001\u0000\u0004\u0002\u0001\u0000\u0001\u0002\u0007\u0003\u0003\u0003\u0005\u0003\u0002\u0002\u0002\u0003\u0001\u0000\u0004\u0003\u0002\u0000\n\u0003\u0207\u0000\u0003\u0003\u0001\u00005\u0002\u0002\u0000\u0001\u0003\u0001\u0002\u000f\u0003\u0001\u0003\u0003\u0000\u0004\u0003\u0003\u0000\n\u0002\u0002\u0003\u0002\u0000\n\u0003\u0011\u0000\u0003\u0003\u0001\u0000\b\u0002\u0002\u0000\u0002\u0002\u0002\u0000\u0016\u0002\u0001\u0000\u0007\u0002\u0001\u0000\u0001\u0002\u0003\u0000\u0004\u0002\u0002\u0000\u0001\u0003\u0001\u0000\u0001\u0003\u0001\u0003\u0005\u0003\u0002\u0000\u0002\u0003\u0002\u0000\u0003\u0003\t\u0000\u0001\u0003\u0004\u0000\u0002\u0002\u0001\u0000\u0003\u0002\u0002\u0003\u0002\u0000\n\u0003\u0002\u0002\u0010\u0000\u0001\u0003\u0002\u0000\u0006\u0002\u0004\u0000\u0002\u0002\u0002\u0000\u0016\u0002\u0001\u0000\u0007\u0002\u0001\u0000\u0002\u0002\u0001\u0000\u0002\u0002\u0001\u0000\u0002\u0002\u0002\u0000\u0001\u0003\u0001\u0000\u0001\u0003\u0001\u0003\u0003\u0003\u0004\u0000\u0002\u0003\u0002\u0000\u0003\u0003\u000b\u0000\u0004\u0002\u0001\u0000\u0001\u0002\u0007\u0000\n\u0003\u0002\u0003\u0003\u0002\f\u0000\u0003\u0003\u0001\u0000\u0007\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0002\u0001\u0000\u0016\u0002\u0001\u0000\u0007\u0002\u0001\u0000\u0002\u0002\u0001\u0000\u0005\u0002\u0002\u0000\u0001\u0003\u0001\u0002\b\u0003\u0001\u0000\u0003\u0003\u0001\u0000\u0003\u0003\u0012\u0000\u0001\u0002\u0005\u0000\n\u0003\u0011\u0000\u0003\u0003\u0001\u0000\b\u0002\u0002\u0000\u0002\u0002\u0002\u0000\u0016\u0002\u0001\u0000\u0007\u0002\u0001\u0000\u0002\u0002\u0002\u0000\u0004\u0002\u0002\u0000\u0001\u0003\u0001\u0002\u0006\u0003\u0003\u0000\u0002\u0003\u0002\u0000\u0003\u0003\b\u0000\u0002\u0003\u0004\u0000\u0002\u0002\u0001\u0000\u0003\u0002\u0004\u0000\n\u0003\u0012\u0000\u0002\u0003\u0001\u0000\u0006\u0002\u0003\u0000\u0003\u0002\u0001\u0000\u0004\u0002\u0003\u0000\u0002\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0002\u0002\u0003\u0000\u0002\u0002\u0003\u0000\u0003\u0002\u0003\u0000\b\u0002\u0001\u0000\u0003\u0002\u0004\u0000\u0005\u0003\u0003\u0000\u0003\u0003\u0001\u0000\u0004\u0003\t\u0000\u0001\u0003\u000f\u0000\t\u0003\u0011\u0000\u0003\u0003\u0001\u0000\b\u0002\u0001\u0000\u0003\u0002\u0001\u0000\u0017\u0002\u0001\u0000\n\u0002\u0001\u0000\u0005\u0002\u0004\u0000\u0007\u0003\u0001\u0000\u0003\u0003\u0001\u0000\u0004\u0003\u0007\u0000\u0002\u0003\t\u0000\u0002\u0002\u0004\u0000\n\u0003\u0012\u0000\u0002\u0003\u0001\u0000\b\u0002\u0001\u0000\u0003\u0002\u0001\u0000\u0017\u0002\u0001\u0000\n\u0002\u0001\u0000\u0005\u0002\u0004\u0000\u0007\u0003\u0001\u0000\u0003\u0003\u0001\u0000\u0004\u0003\u0007\u0000\u0002\u0003\u0007\u0000\u0001\u0002\u0001\u0000\u0002\u0002\u0004\u0000\n\u0003\u0012\u0000\u0002\u0003\u0001\u0000\b\u0002\u0001\u0000\u0003\u0002\u0001\u0000\u0017\u0002\u0001\u0000\u0010\u0002\u0004\u0000\u0006\u0003\u0002\u0000\u0003\u0003\u0001\u0000\u0004\u0003\t\u0000\u0001\u0003\b\u0000\u0002\u0002\u0004\u0000\n\u0003\u0091\u0000.\u0002\u0001\u0000\u0001\u0002\u0001\u0003\u0002\u0002\u0007\u0003\u0005\u0000\u0006\u0002\u0001\u0003\b\u0003\u0001\u0000\n\u0003'\u0000\u0002\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0001\u0002\u0006\u0000\u0004\u0002\u0001\u0000\u0007\u0002\u0001\u0000\u0003\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001\u0000\u0002\u0002\u0001\u0000\u0001\u0002\u0001\u0003\u0002\u0002\u0006\u0003\u0001\u0000\u0002\u0003\u0001\u0002\u0002\u0000\u0005\u0002\u0001\u0000\u0001\u0003\u0001\u0000\u0006\u0003\u0002\u0000\n\u0003>\u0000\u0002\u0003\u0006\u0000\n\u0003\u000b\u0000\u0001\u0003\u0001\u0000\u0001\u0003\u0001\u0000\u0001\u0003\u0004\u0000\u0001\u0003\u0001\u0003\b\u0002\u0001\u0000!\u0002\u0007\u0000\u0014\u0003\u0001\u0000\u0006\u0003\u0004\u0000\u0006\u0003\u0001\u0000\u0001\u0003\u0001\u0000\u0015\u0003\u0003\u0000\u0007\u0003\u0001\u0000\u0001\u0003\u00e6\u0000&\u0002\n\u0000'\u0002\t\u0000\u0001\u0002\u0001\u0000\u0002\u0002\u0001\u0000\u0003\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0002\u0002\u0001\u0000\u0005\u0002)\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u000b\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0003\u0000\u0002\u0002\u0003\u0000\u0001\u0002\u0005\u0000\u0003\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0003\u0000\u0002\u0002\u0003\u0000\u0002\u0002\u0001\u0000\u0001\u0002(\u0000\u0001\u0002\t\u0000\u0001\u0002\u0002\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0007\u0000\u0002\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0007\u0002(\u0000\u0001\u0002\u0004\u0000\u0001\u0002\b\u0000\u0001\u0002\u0c06\u0000\u009c\u0002\u0004\u0000Z\u0002\u0006\u0000\u0016\u0002\u0002\u0000\u0006\u0002\u0002\u0000&\u0002\u0002\u0000\u0006\u0002\u0002\u0000\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0002\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u001f\u0002\u0002\u00005\u0002\u0001\u0000\u0007\u0002\u0001\u0000\u0001\u0002\u0003\u0000\u0003\u0002\u0001\u0000\u0007\u0002\u0003\u0000\u0004\u0002\u0002\u0000\u0006\u0002\u0004\u0000\r\u0002\u0005\u0000\u0003\u0002\u0001\u0000\u0007\u0002\u00d3\u0000\r\u0003\u0004\u0000\u0001\u0003D\u0000\u0001\u0002\u0003\u0000\u0002\u0002\u0002\u0000\u0001\u0002Q\u0000\u0003\u0002\u0e82\u0000\u0001\u0003\u0001\u0000\u0001\u0002\u0019\u0000\t\u0002\u0006\u0003\u0001\u0000\u0005\u0003\u000b\u0000T\u0002\u0004\u0000\u0001\u0003\u0001\u0003\u0002\u0000\u0002\u0003\u0002\u0000Z\u0002\u0001\u0000\u0003\u0003\u0006\u0000(\u0002\u1cd3\u0000\u51a6\u0002\u0c5a\u0000\u2ba4\u0002\\\u0000\u0800\u0000\u1ffe\u0000\u0002\u0000");
        DW = Zo();
        FH = VH();
        Hw = gn();
        v5 = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
        Zo = u7();
    }

    private static int[] Zo() {
        int[] iArr = new int[139];
        j6("\u0005\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0003\u0001\u0007\u0001\u0003\u0001\b\u0001\u0003\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0001\u0001\u0003\u0001\u0013\u0001\u0014\u0001\u0003\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0018\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u001c\u0001\u001d\u0001\u001e\u0001\u0003\u0001\u001f\u0001 \u0001\u001f\u0001!\u0001\"\u0003\u0002\u0001\u0000\u0001#\u0002\u0000\u0001$\u0001\u0000\u0001\u0001\u0001%\u0004\u0000\u0001&\u0002\u001f\u0006\u0000\u0001'\u0001\u0000\u0001(\u0001\u0000\u0001)\u0004\u0000\u0002\u001f\u0001*\u0001+\u0001,\t\u0000\u0002\u001f\u0004\u0000\u0001-\u0004\u0000\u0002\u001f\u0007\u0000\u0001.\u0001\u001f\u0001/\u0006\u0000\u00010\u00011\u00012\u0003\u0000\u00013\u0001\u0000\u00014\u0001\u0000\u00015\u00016\u00017", 0, iArr);
        return iArr;
    }

    private static int j6(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        int i3 = i;
        while (i2 < length) {
            int i4 = i2 + 1;
            i2 = str.charAt(i2);
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            while (true) {
                i4 = i3 + 1;
                iArr[i3] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i3 = i4;
            }
            i3 = i4;
            i2 = i5;
        }
        return i3;
    }

    private static int[] VH() {
        int[] iArr = new int[139];
        DW("\u0000\u0000\u0000*\u0000T\u0000~\u0000\u00a8\u0000\u00d2\u0000\u00fc\u0000\u0126\u0000\u0150\u0000\u017a\u0000\u01a4\u0000\u01ce\u0000\u01f8\u0000\u01a4\u0000\u0222\u0000\u01a4\u0000\u024c\u0000\u0276\u0000\u02a0\u0000\u02ca\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u02f4\u0000\u031e\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u0348\u0000\u0372\u0000\u039c\u0000\u01a4\u0000\u03c6\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u03f0\u0000\u041a\u0000\u01a4\u0000\u0444\u0000\u01a4\u0000\u01a4\u0000\u046e\u0000\u0498\u0000\u04c2\u0000\u04ec\u0000\u0516\u0000\u0540\u0000\u056a\u0000\u01a4\u0000\u0594\u0000\u05be\u0000\u01f8\u0000\u05e8\u0000\u0612\u0000\u063c\u0000\u0666\u0000\u01a4\u0000\u0690\u0000\u06ba\u0000\u06e4\u0000\u070e\u0000\u0738\u0000\u0762\u0000\u078c\u0000\u07b6\u0000\u01a4\u0000\u07e0\u0000\u01a4\u0000\u05be\u0000\u01a4\u0000\u080a\u0000\u0834\u0000\u085e\u0000\u0888\u0000\u08b2\u0000\u08dc\u0000\u01a4\u0000\u01a4\u0000\u01a4\u0000\u0906\u0000\u0930\u0000\u095a\u0000\u0984\u0000\u09ae\u0000\u09d8\u0000\u0a02\u0000\u0a2c\u0000\u0a56\u0000\u0a80\u0000\u0aaa\u0000\u0ad4\u0000\u0afe\u0000\u0b28\u0000\u0b52\u0000\u01a4\u0000\u0b7c\u0000\u0ba6\u0000\u0bd0\u0000\u0bfa\u0000\u0c24\u0000\u0c4e\u0000\u0c78\u0000\u0ca2\u0000\u0ccc\u0000\u0cf6\u0000\u0d20\u0000\u0d4a\u0000\u0d74\u0000\u01a4\u0000\u0d9e\u0000\u041a\u0000\u0dc8\u0000\u0df2\u0000\u0e1c\u0000\u0e46\u0000\u0e70\u0000\u0e9a\u0000\u01a4\u0000\u041a\u0000\u01a4\u0000\u0ec4\u0000\u0eee\u0000\u0f18\u0000\u01a4\u0000\u0f42\u0000\u01a4\u0000\u0f6c\u0000\u01a4\u0000\u01a4\u0000\u01a4", 0, iArr);
        return iArr;
    }

    private static int DW(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2) << 16;
            i2 = i + 1;
            int i4 = i3 + 1;
            iArr[i] = str.charAt(i3) | charAt;
            i = i2;
            i2 = i4;
        }
        return i;
    }

    private static int[] gn() {
        int[] iArr = new int[3990];
        FH("\u0001\u000b\u0001\f\u0003\r\u0002\u000b\u0001\u000e\u0001\r\u0001\u000f\u0001\u000b\n\r\u0001\u0010\u0001\u000b\u0001\u0011\u0002\u000b\u0005\r\b\u000b\u0003\r*\u000b\u0019\u0012\u0001\u0013\u0010\u0012\u0015\u0014\u0001\u0015\t\u0014\u0001\u0016\u0001\u0017\t\u0014\u0002\u0018\u0001\u0019\u0004\u0018\u0001\u001a\u0001\u0019\u0002\u0018\n\u0019\u0001\u001b\u0004\u0018\u0005\u0019\u0001\u001c\u0001\u001d\u0006\u0018\u0003\u0019\u0004\u001e\u0001\u001f%\u001e\u0001\u000b\u0001\f\u0002\r\u0001 \u0001!\u0001\"\u0001\u000e\u0001\r\u0002\u000b\n\r\u0001\u0010\u0002\u000b\u0001#\u0001$\u0005\r\u0001%\u0001&\u0001'\u0001(\u0001)\u0001*\u0001+\u0001,\u0003\r\u0004\u001e\u0001-%\u001e\u0001\u000b\u0001\f\u0001.\u0004\u000b\u0001/\u0001.\u0002\u000b\u0003.\u00010\u0006.\u00011\u00012\u0003\u000b\u0005.\b\u000b\u0003.\t3\u00014\r3\u00015\u00123+\u0000\u0001\f*\u0000\u0003\r\u0003\u0000\u0001\r\u0002\u0000\n\r\u0005\u0000\u0005\r\b\u0000\u0003\r\n\u0000\u00016\u000e\u0000\u00017'\u0000\u00018\u0012\u0000\u0019\u0012\u00019(\u0012\u0001:\u0011\u0012\u0015\u0014\u0001\u0000\t\u0014\u0002\u0000\t\u0014\u0007\u0018\u0001\u0000\r\u0018\u0001\u0000\t\u0018\u0002\u0000\u000b\u0018\u0003\u0019\u0002\u0018\u0001\u0000\u0001\u0019\u0002\u0018\n\u0019\u0001\u0000\u0004\u0018\u0005\u0019\u0002\u0000\u0006\u0018\u0003\u0019\u0004\u001e\u0001;)\u001e\u0001<%\u001e\u0002\u0000\u0002\r\u0001=\u0003\u0000\u0001\r\u0002\u0000\n\r\u0005\u0000\u0005\r\b\u0000\u0003\r\u000e\u0000\u0001>\u000f\u0000\u0001?\t\u0000\u0001@\u0001A\u0004\u001e\u0001B%\u001e\u0002\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\n.\u0005\u0000\u0005.\b\u0000\u0003.\u0002\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\u0001.\u0001C\b.\u0005\u0000\u0003.\u0001D\u0001.\b\u0000\u0003.\t3\u0001\u0000\r3\u0001\u0000\u00123\n\u0000\u0001E6\u0000\u0001F\u0016\u0000\u0001G\u0006\u0000\u0001H\u0001I\u0005\u0000\u0001J\u0003\u0000\u0001K\u001b\u0000\u0001L9\u0000\u0001M\u0011\u0000\u0018\u0012\u0001\u0000\u0011\u0012\u0004\u001e\u0001\u0000%\u001e\u0001\u0000\u0001N\u0016\u0000\u0001O\"\u0000\u0001P#\u0000\u0001Q8\u0000\u0001R\u001d\u0000\u0001S\u001d\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\n.\u0005\u0000\u0001T\u0004.\b\u0000\u0003.\u0002\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\u0001.\u0001U\b.\u0005\u0000\u0005.\b\u0000\u0003.\u0016\u0000\u0001V+\u0000\u0001W\u0015\u0000\u0001X1\u0000\u0001Y\u0003\u0000\u0001Z-\u0000\u0001[\"\u0000\u0001\\-\u0000\u0001]@\u0000\u0001^(\u0000\u0001_\u001e\u0000\u0001`\u0015\u0000\u0001a#\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\u0005.\u0001b\u0004.\u0005\u0000\u0005.\b\u0000\u0003.\u0002\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\t.\u0001c\u0005\u0000\u0005.\b\u0000\u0003.\r\u0000\u0001d'\u0000\u0001e+\u0000\u0001f)\u0000\u0001g,\u0000\u0001h)\u0000\u0001i4\u0000\u0001j \u0000\u0001k\"\u0000\u0001l \u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\n.\u0005\u0000\u0001.\u0001m\u0003.\b\u0000\u0003.\u0002\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\n.\u0005\u0000\u0004.\u0001n\b\u0000\u0003.\u000e\u0000\u0001o,\u0000\u0001p*\u0000\u0001q'\u0000\u0001r'\u0000\u0001s)\u0000\u0001t(\u0000\u0001u8\u0000\u0001v\u000f\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\n.\u0005\u0000\u0002.\u0001w\u0002.\b\u0000\u0003.\u0002\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\u0001x\t.\u0005\u0000\u0005.\b\u0000\u0003.\r\u0000\u0001y'\u0000\u0001z+\u0000\u0001{*\u0000\u0001|&\u0000\u0001}<\u0000\u0001~\u001d\u0000\u0001\u007f\u0019\u0000\u0003.\u0003\u0000\u0001.\u0002\u0000\u0001\u0080\t.\u0005\u0000\u0005.\b\u0000\u0003.\u000f\u0000\u0001\u0081&\u0000\u0001\u0082+\u0000\u0001\u0083.\u0000\u0001\u00842\u0000\u0001\u0085\u0018\u0000\u0001\u0086+\u0000\u0001\u00870\u0000\u0001\u0088\"\u0000\u0001\u00898\u0000\u0001\u008a\u0019\u0000\u0001\u008b\u001d\u0000", 0, iArr);
        return iArr;
    }

    private static int FH(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        int i3 = i;
        while (i2 < length) {
            int i4 = i2 + 1;
            i2 = str.charAt(i2);
            int i5 = i4 + 1;
            int charAt = str.charAt(i4) - 1;
            while (true) {
                i4 = i3 + 1;
                iArr[i3] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i3 = i4;
            }
            i3 = i4;
            i2 = i5;
        }
        return i3;
    }

    private static int[] u7() {
        int[] iArr = new int[139];
        Hw("\u0005\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\t\u0002\u0001\u0001\t\u0001\u0001\u0001\t\u0004\u0001\u0003\t\u0002\u0001\u0004\t\u0003\u0001\u0001\t\u0001\u0001\n\t\u0002\u0001\u0001\t\u0001\u0001\u0002\t\u0003\u0001\u0001\u0000\u0001\u0001\u0002\u0000\u0001\t\u0001\u0000\u0002\u0001\u0004\u0000\u0001\t\u0002\u0001\u0006\u0000\u0001\t\u0001\u0000\u0001\t\u0001\u0000\u0001\t\u0004\u0000\u0002\u0001\u0003\t\t\u0000\u0002\u0001\u0004\u0000\u0001\t\u0004\u0000\u0002\u0001\u0007\u0000\u0001\t\u0002\u0001\u0006\u0000\u0001\t\u0001\u0001\u0001\t\u0003\u0000\u0001\t\u0001\u0000\u0001\t\u0001\u0000\u0003\t", 0, iArr);
        return iArr;
    }

    private static int Hw(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        int i3 = i;
        while (i2 < length) {
            int i4 = i2 + 1;
            i2 = str.charAt(i2);
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            while (true) {
                i4 = i3 + 1;
                iArr[i3] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i3 = i4;
            }
            i3 = i4;
            i2 = i5;
        }
        return i3;
    }

    public char[] DW() {
        return this.tp;
    }

    public int FH() {
        return this.J8;
    }

    public int j6() {
        return this.XL;
    }

    public fv(Reader reader) {
        this.u7 = 0;
        this.tp = new char[8192];
        this.j3 = true;
        this.U2 = -1;
        this.a8 = -1;
        this.lg = 0;
        this.VH = reader;
    }

    private static char[] j6(String str) {
        int i = 0;
        char[] cArr = new char[65536];
        int i2 = 0;
        while (i2 < 1410) {
            int i3 = i2 + 1;
            i2 = str.charAt(i2);
            int i4 = i3 + 1;
            char charAt = str.charAt(i3);
            while (true) {
                i3 = i + 1;
                cArr[i] = charAt;
                i2--;
                if (i2 <= 0) {
                    break;
                }
                i = i3;
            }
            i = i3;
            i2 = i4;
        }
        return cArr;
    }

    private boolean tp() {
        if (this.J8 > 0) {
            System.arraycopy(this.tp, this.J8, this.tp, 0, this.Ws - this.J8);
            this.Ws -= this.J8;
            this.J0 -= this.J8;
            this.EQ -= this.J8;
            this.we -= this.J8;
            this.J8 = 0;
        }
        if (this.J0 >= this.tp.length) {
            Object obj = new char[(this.J0 * 2)];
            System.arraycopy(this.tp, 0, obj, 0, this.tp.length);
            this.tp = obj;
        }
        int read = this.VH.read(this.tp, this.Ws, this.tp.length - this.Ws);
        if (read < 0) {
            return true;
        }
        this.Ws = read + this.Ws;
        return false;
    }

    public final void j6(Reader reader) {
        this.VH = reader;
        this.j3 = true;
        this.Mr = false;
        this.J8 = 0;
        this.Ws = 0;
        this.we = 0;
        this.EQ = 0;
        this.J0 = 0;
        this.aM = 0;
        this.XL = 0;
        this.QX = 0;
        this.u7 = 0;
    }

    public final void DW(int i) {
        this.u7 = i;
    }

    public final char j6(int i) {
        return this.tp[this.J8 + i];
    }

    public final int Hw() {
        return this.EQ - this.J8;
    }

    private void FH(int i) {
        String str;
        try {
            str = v5[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            str = v5[0];
        }
        throw new Error(str);
    }

    public int v5() {
        int i = this.Ws;
        char[] cArr = this.tp;
        char[] cArr2 = j6;
        int[] iArr = Hw;
        int[] iArr2 = FH;
        int[] iArr3 = Zo;
        while (true) {
            int i2 = this.EQ;
            this.XL += i2 - this.J8;
            int i3 = -1;
            this.J8 = i2;
            this.J0 = i2;
            this.gn = this.u7;
            int i4 = i2;
            while (true) {
                if (i4 >= i) {
                    if (this.Mr) {
                        i4 = -1;
                    } else {
                        this.J0 = i4;
                        this.EQ = i2;
                        boolean tp = tp();
                        i4 = this.J0;
                        i2 = this.EQ;
                        cArr = this.tp;
                        i = this.Ws;
                        if (tp) {
                            i4 = -1;
                        } else {
                            int i5 = i4 + 1;
                            i4 = cArr[i4];
                        }
                    }
                    this.EQ = i2;
                    if (i3 >= 0) {
                        i3 = DW[i3];
                    }
                    switch (i3) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            return 16;
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            return 49;
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            return 1;
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            return 10;
                        case 5:
                            return 30;
                        case 6:
                            return 21;
                        case 7:
                            return 20;
                        case 8:
                            return 53;
                        case 9:
                            return 27;
                        case 10:
                            DW(4);
                            return 28;
                        case 11:
                            if (this.U2 == 1) {
                                return 27;
                            }
                            DW(6);
                            return 18;
                        case 12:
                            if (this.U2 == 0) {
                                return 27;
                            }
                            DW(6);
                            return 19;
                        case 13:
                            DW(3);
                            return 27;
                        case 14:
                            return 31;
                        case 15:
                            DW(3);
                            return 29;
                        case 16:
                            return 28;
                        case ProxyTextView.INPUTTYPE_textUri /*17*/:
                            if (this.U2 == 0) {
                                return 27;
                            }
                            DW(1);
                            return 18;
                        case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                            if (this.U2 == 0) {
                                return 27;
                            }
                            DW(1);
                            return 19;
                        case 19:
                            return 22;
                        case ProxyTextView.INPUTTYPE_date /*20*/:
                            return 50;
                        case 21:
                            DW(0);
                            return 26;
                        case 22:
                            return 43;
                        case 23:
                            this.U2 = 1;
                            DW(3);
                            return 18;
                        case 24:
                            this.U2 = 0;
                            DW(3);
                            return 19;
                        case 25:
                            return 34;
                        case 26:
                            return 35;
                        case 27:
                            return 36;
                        case 28:
                            return 37;
                        case 29:
                            return 33;
                        case 30:
                            return 42;
                        case 31:
                            this.rN = false;
                            return 30;
                        case 32:
                            this.rN = false;
                            return 21;
                        case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                            this.rN = false;
                            return 20;
                        case 34:
                            if (this.rN) {
                                DW(0);
                            } else {
                                this.lg = 0;
                                DW(9);
                            }
                            return 47;
                        case 35:
                            DW(2);
                            return 52;
                        case ProxyTextView.INPUTTYPE_time /*36*/:
                            DW(0);
                            return 54;
                        case 37:
                            DW(7);
                            return 16;
                        case 38:
                            DW(6);
                            return 16;
                        case 39:
                            this.rN = false;
                            DW(8);
                            return 46;
                        case 40:
                            return 48;
                        case 41:
                            DW(this.a8);
                            return 17;
                        case 42:
                            this.lg++;
                            return 49;
                        case 43:
                            if (this.lg <= 0) {
                                this.lg--;
                                return 49;
                            }
                            DW(0);
                            return 48;
                        case 44:
                            this.a8 = 0;
                            DW(5);
                            return 15;
                        case 45:
                            DW(2);
                            return 55;
                        case 46:
                            return 41;
                        case 47:
                            this.rN = true;
                            return 45;
                        case 48:
                            return 40;
                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                            this.rN = false;
                            return 44;
                        case 50:
                            DW(6);
                            return 11;
                        case 51:
                            return 39;
                        case 52:
                            DW(6);
                            return 12;
                        case 53:
                            DW(6);
                            return 13;
                        case 54:
                            return 38;
                        case 55:
                            DW(6);
                            return 14;
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                            break;
                        default:
                            if (i4 == -1 || this.J8 != this.J0) {
                                FH(1);
                                break;
                            }
                            this.Mr = true;
                            return 0;
                            break;
                    }
                }
                i5 = i4 + 1;
                i4 = cArr[i4];
                int i6 = iArr[iArr2[this.gn] + cArr2[i4]];
                if (i6 != -1) {
                    this.gn = i6;
                    i6 = iArr3[this.gn];
                    if ((i6 & 1) == 1) {
                        i2 = this.gn;
                        if ((i6 & 8) == 8) {
                            i3 = i2;
                            i2 = i5;
                        } else {
                            i4 = i2;
                            i2 = i5;
                        }
                    } else {
                        i4 = i3;
                    }
                    i3 = i4;
                    i4 = i5;
                }
                this.EQ = i2;
                if (i3 >= 0) {
                    i3 = DW[i3];
                }
                switch (i3) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        return 16;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        return 49;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        return 1;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        return 10;
                    case 5:
                        return 30;
                    case 6:
                        return 21;
                    case 7:
                        return 20;
                    case 8:
                        return 53;
                    case 9:
                        return 27;
                    case 10:
                        DW(4);
                        return 28;
                    case 11:
                        if (this.U2 == 1) {
                            return 27;
                        }
                        DW(6);
                        return 18;
                    case 12:
                        if (this.U2 == 0) {
                            return 27;
                        }
                        DW(6);
                        return 19;
                    case 13:
                        DW(3);
                        return 27;
                    case 14:
                        return 31;
                    case 15:
                        DW(3);
                        return 29;
                    case 16:
                        return 28;
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        if (this.U2 == 0) {
                            return 27;
                        }
                        DW(1);
                        return 18;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        if (this.U2 == 0) {
                            return 27;
                        }
                        DW(1);
                        return 19;
                    case 19:
                        return 22;
                    case ProxyTextView.INPUTTYPE_date /*20*/:
                        return 50;
                    case 21:
                        DW(0);
                        return 26;
                    case 22:
                        return 43;
                    case 23:
                        this.U2 = 1;
                        DW(3);
                        return 18;
                    case 24:
                        this.U2 = 0;
                        DW(3);
                        return 19;
                    case 25:
                        return 34;
                    case 26:
                        return 35;
                    case 27:
                        return 36;
                    case 28:
                        return 37;
                    case 29:
                        return 33;
                    case 30:
                        return 42;
                    case 31:
                        this.rN = false;
                        return 30;
                    case 32:
                        this.rN = false;
                        return 21;
                    case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                        this.rN = false;
                        return 20;
                    case 34:
                        if (this.rN) {
                            DW(0);
                        } else {
                            this.lg = 0;
                            DW(9);
                        }
                        return 47;
                    case 35:
                        DW(2);
                        return 52;
                    case ProxyTextView.INPUTTYPE_time /*36*/:
                        DW(0);
                        return 54;
                    case 37:
                        DW(7);
                        return 16;
                    case 38:
                        DW(6);
                        return 16;
                    case 39:
                        this.rN = false;
                        DW(8);
                        return 46;
                    case 40:
                        return 48;
                    case 41:
                        DW(this.a8);
                        return 17;
                    case 42:
                        this.lg++;
                        return 49;
                    case 43:
                        if (this.lg <= 0) {
                            DW(0);
                            return 48;
                        }
                        this.lg--;
                        return 49;
                    case 44:
                        this.a8 = 0;
                        DW(5);
                        return 15;
                    case 45:
                        DW(2);
                        return 55;
                    case 46:
                        return 41;
                    case 47:
                        this.rN = true;
                        return 45;
                    case 48:
                        return 40;
                    case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                        this.rN = false;
                        return 44;
                    case 50:
                        DW(6);
                        return 11;
                    case 51:
                        return 39;
                    case 52:
                        DW(6);
                        return 12;
                    case 53:
                        DW(6);
                        return 13;
                    case 54:
                        return 38;
                    case 55:
                        DW(6);
                        return 14;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                        break;
                    default:
                        if (i4 == -1) {
                            break;
                        }
                        FH(1);
                        break;
                }
            }
        }
    }
}
