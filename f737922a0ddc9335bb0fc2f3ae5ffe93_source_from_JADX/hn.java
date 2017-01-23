import com.aide.uidesigner.ProxyTextView;
import java.util.StringTokenizer;

public class hn implements bl {
    public boolean Ws(int i) {
        return i < 10;
    }

    public boolean lg(int i) {
        return i == 2 || i == 1;
    }

    public boolean J8(int i) {
        return i == 2 || i == 1;
    }

    public boolean QX(int i) {
        return false;
    }

    public boolean j6(int i) {
        return i == 2;
    }

    public boolean DW(int i) {
        return false;
    }

    public boolean FH(int i) {
        return false;
    }

    public boolean Hw(int i) {
        return false;
    }

    public boolean v5(int i) {
        return false;
    }

    public boolean Zo(int i) {
        return false;
    }

    public boolean VH(int i) {
        return false;
    }

    public boolean gn(int i) {
        return false;
    }

    public boolean u7(int i) {
        return false;
    }

    public boolean tp(int i) {
        return false;
    }

    public boolean EQ(int i) {
        return false;
    }

    public boolean we(int i) {
        return false;
    }

    public boolean J0(int i) {
        return false;
    }

    public boolean U2(int i) {
        return false;
    }

    public boolean a8(int i) {
        return false;
    }

    public boolean rN(int i) {
        return false;
    }

    public boolean j3(int i) {
        return false;
    }

    public boolean Mr(int i) {
        return false;
    }

    public boolean er(int i) {
        return false;
    }

    public boolean yS(int i) {
        return false;
    }

    public String XL(int i) {
        return null;
    }

    public int aM(int i) {
        return 0;
    }

    public boolean gW(int i) {
        return false;
    }

    public boolean BT(int i) {
        return false;
    }

    public boolean vy(int i) {
        return false;
    }

    public boolean P8(int i) {
        return false;
    }

    public boolean ei(int i) {
        return false;
    }

    public boolean j6(cj cjVar, int i) {
        return false;
    }

    public boolean DW(cj cjVar, int i) {
        return false;
    }

    public boolean FH(cj cjVar, int i) {
        return false;
    }

    public int QX(cj cjVar, int i) {
        return 0;
    }

    public boolean Hw(cj cjVar, int i) {
        return false;
    }

    public int v5(cj cjVar, int i) {
        return 0;
    }

    public int Zo(cj cjVar, int i) {
        return 0;
    }

    public boolean VH(cj cjVar, int i) {
        return false;
    }

    public boolean gn(cj cjVar, int i) {
        return false;
    }

    public boolean u7(cj cjVar, int i) {
        return false;
    }

    public int j6(cj cjVar, int i, int i2) {
        return 0;
    }

    public int tp(cj cjVar, int i) {
        return 0;
    }

    public int EQ(cj cjVar, int i) {
        return 0;
    }

    public int we(cj cjVar, int i) {
        return 0;
    }

    public int DW(cj cjVar, int i, int i2) {
        return 0;
    }

    public int J0(cj cjVar, int i) {
        return 0;
    }

    public int J8(cj cjVar, int i) {
        return 0;
    }

    public int Ws(cj cjVar, int i) {
        return 0;
    }

    public do j6(cj cjVar) {
        return null;
    }

    public do DW(cj cjVar) {
        return null;
    }

    public int FH(cj cjVar) {
        return 0;
    }

    public int Hw(cj cjVar) {
        return 0;
    }

    public int v5(cj cjVar) {
        return 0;
    }

    public int Zo(cj cjVar) {
        return 0;
    }

    public boolean XL(cj cjVar, int i) {
        return cjVar.rN(i) == 2;
    }

    public String aM(cj cjVar, int i) {
        return j6(j3(cjVar, i));
    }

    public String j3(cj cjVar, int i) {
        String str = "";
        StringTokenizer stringTokenizer = new StringTokenizer(cjVar.a8(i), "\n");
        while (stringTokenizer.hasMoreElements()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim.equals("*/")) {
                trim = "";
            } else if (trim.startsWith("*")) {
                trim = trim.substring(1, trim.length());
            } else if (trim.startsWith("/**")) {
                trim = trim.substring(3, trim.length());
            }
            if (trim.endsWith("*/")) {
                trim = trim.substring(0, trim.length() - 2);
            }
            if (trim.length() != 0) {
                str = str + trim + "\n";
            }
        }
        return str;
    }

    public String j6(String str) {
        String replace;
        while (true) {
            int indexOf = str.indexOf("{@link");
            if (indexOf <= 0) {
                break;
            }
            int indexOf2 = str.indexOf(125, indexOf);
            if (indexOf2 < indexOf) {
                indexOf2 = indexOf + 6;
            }
            replace = str.substring(indexOf + 6, indexOf2).trim().replace('#', '.');
            if (replace.startsWith(".")) {
                replace = replace.substring(1, replace.length());
            }
            str = str.substring(0, indexOf) + "<code>" + replace + "</code>" + str.substring(indexOf2 + 1, str.length());
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        Object obj = null;
        for (indexOf2 = 0; indexOf2 < str.length(); indexOf2++) {
            char charAt = str.charAt(indexOf2);
            switch (obj) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    switch (charAt) {
                        case '\t':
                        case '\f':
                        case ' ':
                        case '*':
                            break;
                        case '\n':
                            stringBuffer.append(charAt);
                            break;
                        case '@':
                            obj = 2;
                            break;
                        default:
                            stringBuffer.append(charAt);
                            obj = 1;
                            break;
                    }
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    switch (charAt) {
                        case '\n':
                            stringBuffer.append(charAt);
                            obj = null;
                            break;
                        default:
                            stringBuffer.append(charAt);
                            break;
                    }
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    switch (charAt) {
                        case '\n':
                            stringBuffer2.append(' ');
                            obj = 3;
                            break;
                        default:
                            stringBuffer2.append(charAt);
                            break;
                    }
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    switch (charAt) {
                        case '\t':
                        case '\n':
                        case '\f':
                        case ' ':
                        case '*':
                            break;
                        case '@':
                            stringBuffer2.append('\n');
                            obj = 2;
                            break;
                        default:
                            stringBuffer2.append(charAt);
                            obj = 2;
                            break;
                    }
                default:
                    break;
            }
        }
        String stringBuffer3 = stringBuffer.toString();
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        replace = "";
        String str7 = "";
        StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer2.toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf3 = nextToken.indexOf(32);
            if (indexOf3 > 0) {
                String substring = nextToken.substring(0, indexOf3);
                if (substring.equals("param")) {
                    nextToken = nextToken.substring(indexOf3, nextToken.length()).trim();
                    indexOf3 = nextToken.indexOf(32);
                    if (indexOf3 > 0) {
                        if (str2.equals("")) {
                            str2 = "<DT><b>Parameters:</b>";
                        }
                        str2 = str2 + "<DD><code>" + nextToken.substring(0, indexOf3) + "</code> -" + nextToken.substring(indexOf3, nextToken.length());
                    }
                } else if (substring.equals("throws") || substring.equals("exception")) {
                    nextToken = nextToken.substring(indexOf3, nextToken.length()).trim();
                    indexOf3 = nextToken.indexOf(32);
                    if (indexOf3 > 0) {
                        if (str3.equals("")) {
                            str3 = "<DT><b>Throws:</b>";
                        }
                        str3 = str3 + "<DD><code>" + nextToken.substring(0, indexOf3) + "</code> -" + nextToken.substring(indexOf3, nextToken.length());
                    }
                } else if (substring.equals("return")) {
                    str4 = "<DT><b>Returns:</b><DD>" + nextToken.substring(indexOf3, nextToken.length());
                } else if (substring.equals("since")) {
                    str5 = "<DT><b>Since:</b><DD>" + nextToken.substring(indexOf3, nextToken.length());
                } else if (substring.equals("version")) {
                    str6 = "<DT><b>Version:</b><DD>" + nextToken.substring(indexOf3, nextToken.length());
                } else if (substring.equals("author")) {
                    replace = "<DT><b>Author:</b><DD>" + nextToken.substring(indexOf3, nextToken.length());
                } else if (substring.equals("deprecated")) {
                    str7 = "<DT><b>Deprecated. </b>" + nextToken.substring(indexOf3, nextToken.length()) + "<DD>";
                }
            }
        }
        return str7 + stringBuffer3 + "<DL>" + str4 + str2 + str3 + str5 + replace + str6 + "</DL>";
    }
}
