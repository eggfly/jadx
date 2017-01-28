import com.aide.uidesigner.ProxyTextView;
import java.io.InputStream;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jgit.JGitText;

class auu extends InputStream {
    private static Pattern DW;
    private static Pattern FH;
    private static final String j6;
    private boolean EQ;
    private final InputStream Hw;
    private int J0;
    private final Writer VH;
    private final aob Zo;
    private String gn;
    private int tp;
    private String u7;
    private final aue v5;
    private int we;

    static {
        j6 = JGitText.j6().prefixRemote;
        DW = Pattern.compile("^([\\w ]+): +(\\d+)(?:, done\\.)? *[\r\n]$");
        FH = Pattern.compile("^([\\w ]+): +\\d+% +\\( *(\\d+)/ *(\\d+)\\)(?:, done\\.)? *[\r\n]$");
    }

    auu(InputStream inputStream, aob aob, Writer writer) {
        this.gn = "";
        this.Hw = inputStream;
        this.v5 = new aue(this.Hw);
        this.Zo = aob;
        this.VH = writer;
        this.u7 = "";
    }

    public int read() {
        j6();
        if (this.EQ) {
            return -1;
        }
        this.J0--;
        return this.Hw.read();
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > 0) {
            j6();
            if (!this.EQ) {
                int read = this.Hw.read(bArr, i, Math.min(i2, this.J0));
                if (read < 0) {
                    break;
                }
                i3 += read;
                i += read;
                i2 -= read;
                this.J0 -= read;
            } else {
                break;
            }
        }
        return (this.EQ && i3 == 0) ? -1 : i3;
    }

    private void j6() {
        if (!this.EQ) {
            if (this.we != 1 || this.J0 <= 0) {
                while (true) {
                    this.J0 = this.v5.FH();
                    if (this.J0 == 0) {
                        this.EQ = true;
                        return;
                    }
                    this.we = this.Hw.read() & 255;
                    this.J0 -= 5;
                    if (this.J0 != 0) {
                        switch (this.we) {
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                                return;
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                                j6(DW(this.J0));
                                break;
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                this.EQ = true;
                                throw new amb(j6 + DW(this.J0));
                            default:
                                throw new alq(MessageFormat.format(JGitText.j6().invalidChannel, new Object[]{Integer.valueOf(this.we)}));
                        }
                    }
                }
            }
        }
    }

    private void j6(String str) {
        String str2 = this.gn + str;
        while (true) {
            int indexOf = str2.indexOf(10);
            int indexOf2 = str2.indexOf(13);
            if (indexOf >= 0 && indexOf2 >= 0) {
                indexOf = Math.min(indexOf, indexOf2);
            } else if (indexOf >= 0) {
                continue;
            } else if (indexOf2 >= 0) {
                indexOf = indexOf2;
            } else {
                this.gn = str2;
                return;
            }
            DW(str2.substring(0, indexOf + 1));
            str2 = str2.substring(indexOf + 1);
        }
    }

    private void DW(String str) {
        Matcher matcher = FH.matcher(str);
        String group;
        if (matcher.matches()) {
            group = matcher.group(1);
            if (!this.u7.equals(group)) {
                this.u7 = group;
                this.tp = 0;
                j6(Integer.parseInt(matcher.group(3)));
            }
            int parseInt = Integer.parseInt(matcher.group(2));
            this.Zo.j6(parseInt - this.tp);
            this.tp = parseInt;
            return;
        }
        matcher = DW.matcher(str);
        if (matcher.matches()) {
            group = matcher.group(1);
            if (!this.u7.equals(group)) {
                this.u7 = group;
                this.tp = 0;
                j6(0);
            }
            parseInt = Integer.parseInt(matcher.group(2));
            this.Zo.j6(parseInt - this.tp);
            this.tp = parseInt;
            return;
        }
        this.VH.write(str);
    }

    private void j6(int i) {
        this.Zo.j6(j6 + this.u7, i);
    }

    private String DW(int i) {
        byte[] bArr = new byte[i];
        awx.j6(this.Hw, bArr, 0, i);
        return axe.j6(anj.DW, bArr, 0, i);
    }
}
