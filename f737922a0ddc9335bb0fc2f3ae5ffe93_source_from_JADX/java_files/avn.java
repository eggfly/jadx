import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jgit.JGitText;

public class avn implements Serializable {
    private static final Pattern DW;
    private static final Pattern FH;
    private static final Pattern Hw;
    private static final BitSet J0;
    private static final Pattern j6;
    private static final Pattern v5;
    private int EQ;
    private String VH;
    private String Zo;
    private String gn;
    private String tp;
    private String u7;
    private String we;

    static {
        j6 = Pattern.compile("^([a-z][a-z0-9+-]+)://(?:(?:([^/:@]+)(?::([^\\\\/]+))?@)?([^\\\\/:]+)(?::(\\d+))?((?:/~(?:[^\\\\/]+))?[\\\\/]))?(.+)?$");
        DW = Pattern.compile("^([\\\\/]?((?:[A-Za-z]:)?[\\\\/]?(?:(?:[^\\\\/]+[\\\\/])*[^\\\\/]+[\\\\/]?)))$");
        FH = Pattern.compile("^(file):([\\\\/](?![\\\\/])((?:[A-Za-z]:)?[\\\\/]?(?:(?:[^\\\\/]+[\\\\/])*[^\\\\/]+[\\\\/]?)))$");
        Hw = Pattern.compile("^(?:([^/:@]+)(?::([^\\\\/]+))?@)?([^\\\\/:]+):((?:(?:/~(?:[^\\\\/]+))[\\\\/])?(?:(?:[^\\\\/]+[\\\\/])*[^\\\\/]+[\\\\/]?))$");
        v5 = Pattern.compile("^(?:([^/:@]+)(?::([^\\\\/]+))?@)?([^\\\\/:]{2,}):([\\\\/](?:(?:[^\\\\/]+[\\\\/])*[^\\\\/]+[\\\\/]?))$");
        J0 = new BitSet(127);
        for (byte b : anj.j6("!*'();:@&=+$,/?#[]")) {
            J0.set(b);
        }
    }

    public avn(String str) {
        this.EQ = -1;
        if (axh.Hw(str)) {
            throw new URISyntaxException("The uri was empty or null", JGitText.j6().cannotParseGitURIish);
        }
        Matcher matcher = FH.matcher(str);
        if (matcher.matches()) {
            this.Zo = matcher.group(1);
            this.gn = j6(matcher.group(2), this.Zo);
            this.VH = Zo(this.gn);
            return;
        }
        matcher = j6.matcher(str);
        if (matcher.matches()) {
            this.Zo = matcher.group(1);
            this.u7 = Zo(matcher.group(2));
            this.tp = Zo(matcher.group(3));
            this.we = Zo(matcher.group(4));
            if (matcher.group(5) != null) {
                this.EQ = Integer.parseInt(matcher.group(5));
            }
            this.gn = j6(VH(matcher.group(6)) + VH(matcher.group(7)), this.Zo);
            this.VH = Zo(this.gn);
            return;
        }
        matcher = Hw.matcher(str);
        if (matcher.matches()) {
            this.u7 = matcher.group(1);
            this.tp = matcher.group(2);
            this.we = matcher.group(3);
            this.gn = matcher.group(4);
            this.VH = this.gn;
            return;
        }
        matcher = v5.matcher(str);
        if (matcher.matches()) {
            this.u7 = matcher.group(1);
            this.tp = matcher.group(2);
            this.we = matcher.group(3);
            this.gn = matcher.group(4);
            this.VH = this.gn;
            return;
        }
        matcher = DW.matcher(str);
        if (matcher.matches()) {
            this.gn = matcher.group(1);
            this.VH = this.gn;
            return;
        }
        throw new URISyntaxException(str, JGitText.j6().cannotParseGitURIish);
    }

    private static String Zo(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf(37) < 0) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length];
            int i = 0;
            int i2 = 0;
            while (i < bytes.length) {
                byte b = bytes[i];
                int i3;
                if (b != (byte) 37) {
                    i3 = i2 + 1;
                    bArr[i2] = b;
                    i2 = i3;
                } else if (i + 2 >= bytes.length) {
                    throw new URISyntaxException(str, JGitText.j6().cannotParseGitURIish);
                } else {
                    int j6 = axe.j6(bytes[i + 2]) | (axe.j6(bytes[i + 1]) << 4);
                    i3 = i2 + 1;
                    bArr[i2] = (byte) j6;
                    i += 2;
                    i2 = i3;
                }
                i++;
            }
            return axe.FH(bArr, 0, i2);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String j6(String str, boolean z, boolean z2) {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        try {
            byte[] bytes = str.getBytes("UTF-8");
            for (byte b : bytes) {
                int i = b & 255;
                if (i <= 32 || ((z2 && i > 127) || i == 37 || (z && J0.get(i)))) {
                    byteArrayOutputStream.write(37);
                    byte[] j6 = anj.j6(String.format("%02x", new Object[]{Integer.valueOf(i)}));
                    byteArrayOutputStream.write(j6[0]);
                    byteArrayOutputStream.write(j6[1]);
                } else {
                    byteArrayOutputStream.write(i);
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return axe.FH(toByteArray, 0, toByteArray.length);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private String VH(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private String j6(String str, String str2) {
        if (str.length() >= 3 && str.charAt(0) == '/' && str.charAt(2) == ':' && ((str.charAt(1) >= 'A' && str.charAt(1) <= 'Z') || (str.charAt(1) >= 'a' && str.charAt(1) <= 'z'))) {
            return str.substring(1);
        }
        if (str2 == null || str.length() < 2 || str.charAt(0) != '/' || str.charAt(1) != '~') {
            return str;
        }
        return str.substring(1);
    }

    public avn(URL url) {
        this.EQ = -1;
        this.Zo = url.getProtocol();
        this.VH = url.getPath();
        try {
            this.gn = url.toURI().getRawPath();
            String userInfo = url.getUserInfo();
            if (userInfo != null) {
                int indexOf = userInfo.indexOf(58);
                this.u7 = indexOf < 0 ? userInfo : userInfo.substring(0, indexOf);
                this.tp = indexOf < 0 ? null : userInfo.substring(indexOf + 1);
            }
            this.EQ = url.getPort();
            this.we = url.getHost();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public avn() {
        this.EQ = -1;
    }

    private avn(avn avn) {
        this.EQ = -1;
        this.Zo = avn.Zo;
        this.gn = avn.gn;
        this.VH = avn.VH;
        this.u7 = avn.u7;
        this.tp = avn.tp;
        this.EQ = avn.EQ;
        this.we = avn.we;
    }

    public String j6() {
        return this.we;
    }

    public avn j6(String str) {
        avn avn = new avn(this);
        avn.we = str;
        return avn;
    }

    public String DW() {
        return this.Zo;
    }

    public avn DW(String str) {
        avn avn = new avn(this);
        avn.Zo = str;
        return avn;
    }

    public String FH() {
        return this.VH;
    }

    public String Hw() {
        return this.gn;
    }

    public avn FH(String str) {
        avn avn = new avn(this);
        avn.VH = str;
        avn.gn = str;
        return avn;
    }

    public String v5() {
        return this.u7;
    }

    public avn Hw(String str) {
        avn avn = new avn(this);
        avn.u7 = str;
        return avn;
    }

    public String Zo() {
        return this.tp;
    }

    public avn v5(String str) {
        avn avn = new avn(this);
        avn.tp = str;
        return avn;
    }

    public int VH() {
        return this.EQ;
    }

    public avn j6(int i) {
        avn avn = new avn(this);
        if (i <= 0) {
            i = -1;
        }
        avn.EQ = i;
        return avn;
    }

    public int hashCode() {
        int i = 0;
        if (DW() != null) {
            i = DW().hashCode() + 0;
        }
        if (v5() != null) {
            i = (i * 31) + v5().hashCode();
        }
        if (Zo() != null) {
            i = (i * 31) + Zo().hashCode();
        }
        if (j6() != null) {
            i = (i * 31) + j6().hashCode();
        }
        if (VH() > 0) {
            i = (i * 31) + VH();
        }
        if (FH() != null) {
            return (i * 31) + FH().hashCode();
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof avn)) {
            return false;
        }
        avn avn = (avn) obj;
        if (DW(DW(), avn.DW()) && DW(v5(), avn.v5()) && DW(Zo(), avn.Zo()) && DW(j6(), avn.j6()) && VH() == avn.VH() && DW(FH(), avn.FH())) {
            return true;
        }
        return false;
    }

    private static boolean DW(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String gn() {
        return j6(true, false, false);
    }

    public String toString() {
        return j6(false, false, false);
    }

    private String j6(boolean z, boolean z2, boolean z3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (DW() != null) {
            stringBuilder.append(DW());
            stringBuilder.append("://");
        }
        if (v5() != null) {
            stringBuilder.append(j6(v5(), true, z3));
            if (z && Zo() != null) {
                stringBuilder.append(':');
                stringBuilder.append(j6(Zo(), true, z3));
            }
        }
        if (j6() != null) {
            if (v5() != null) {
                stringBuilder.append('@');
            }
            stringBuilder.append(j6(j6(), false, z3));
            if (DW() != null && VH() > 0) {
                stringBuilder.append(':');
                stringBuilder.append(VH());
            }
        }
        if (FH() != null) {
            if (DW() != null) {
                if (!FH().startsWith("/")) {
                    stringBuilder.append('/');
                }
            } else if (j6() != null) {
                stringBuilder.append(':');
            }
            if (DW() == null) {
                stringBuilder.append(FH());
            } else if (z3) {
                stringBuilder.append(j6(FH(), false, z3));
            } else {
                stringBuilder.append(Hw());
            }
        }
        return stringBuilder.toString();
    }

    public String u7() {
        if ("".equals(FH()) || FH() == null) {
            throw new IllegalArgumentException();
        }
        String[] split;
        String FH = FH();
        if ("file".equals(this.Zo) || DW.matcher(FH).matches()) {
            split = FH.split("[\\" + File.separatorChar + "/]");
        } else {
            split = FH.split("/");
        }
        if (split.length == 0) {
            throw new IllegalArgumentException();
        }
        String str = split[split.length - 1];
        if (".git".equals(str)) {
            return split[split.length - 2];
        }
        return str.endsWith(".git") ? str.substring(0, str.length() - ".git".length()) : str;
    }
}
