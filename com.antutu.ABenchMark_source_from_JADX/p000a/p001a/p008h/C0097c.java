package p000a.p001a.p008h;

import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.igexin.download.Downloads;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import javax.security.auth.x500.X500Principal;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;

/* renamed from: a.a.h.c */
final class C0097c {
    private final String f358a;
    private final int f359b;
    private int f360c;
    private int f361d;
    private int f362e;
    private int f363f;
    private char[] f364g;

    public C0097c(X500Principal x500Principal) {
        this.f358a = x500Principal.getName("RFC2253");
        this.f359b = this.f358a.length();
    }

    private int m425a(int i) {
        if (i + 1 >= this.f359b) {
            throw new IllegalStateException("Malformed DN: " + this.f358a);
        }
        int i2;
        int i3;
        char c = this.f364g[i];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f358a);
        } else {
            i2 = c - 55;
        }
        char c2 = this.f364g[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - 48;
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 87;
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f358a);
        } else {
            i3 = c2 - 55;
        }
        return (i2 << 4) + i3;
    }

    private String m426a() {
        while (this.f360c < this.f359b && this.f364g[this.f360c] == ' ') {
            this.f360c++;
        }
        if (this.f360c == this.f359b) {
            return null;
        }
        this.f361d = this.f360c;
        this.f360c++;
        while (this.f360c < this.f359b && this.f364g[this.f360c] != '=' && this.f364g[this.f360c] != ' ') {
            this.f360c++;
        }
        if (this.f360c >= this.f359b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
        }
        this.f362e = this.f360c;
        if (this.f364g[this.f360c] == ' ') {
            while (this.f360c < this.f359b && this.f364g[this.f360c] != '=' && this.f364g[this.f360c] == ' ') {
                this.f360c++;
            }
            if (this.f364g[this.f360c] != '=' || this.f360c == this.f359b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
            }
        }
        this.f360c++;
        while (this.f360c < this.f359b && this.f364g[this.f360c] == ' ') {
            this.f360c++;
        }
        if (this.f362e - this.f361d > 4 && this.f364g[this.f361d + 3] == '.' && ((this.f364g[this.f361d] == 'O' || this.f364g[this.f361d] == 'o') && ((this.f364g[this.f361d + 1] == 'I' || this.f364g[this.f361d + 1] == 'i') && (this.f364g[this.f361d + 2] == 'D' || this.f364g[this.f361d + 2] == 'd')))) {
            this.f361d += 4;
        }
        return new String(this.f364g, this.f361d, this.f362e - this.f361d);
    }

    private String m427b() {
        this.f360c++;
        this.f361d = this.f360c;
        this.f362e = this.f361d;
        while (this.f360c != this.f359b) {
            if (this.f364g[this.f360c] == '\"') {
                this.f360c++;
                while (this.f360c < this.f359b && this.f364g[this.f360c] == ' ') {
                    this.f360c++;
                }
                return new String(this.f364g, this.f361d, this.f362e - this.f361d);
            }
            if (this.f364g[this.f360c] == '\\') {
                this.f364g[this.f362e] = m430e();
            } else {
                this.f364g[this.f362e] = this.f364g[this.f360c];
            }
            this.f360c++;
            this.f362e++;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
    }

    private String m428c() {
        if (this.f360c + 4 >= this.f359b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
        }
        int i;
        this.f361d = this.f360c;
        this.f360c++;
        while (this.f360c != this.f359b && this.f364g[this.f360c] != '+' && this.f364g[this.f360c] != ',' && this.f364g[this.f360c] != ';') {
            int i2;
            if (this.f364g[this.f360c] == ' ') {
                this.f362e = this.f360c;
                this.f360c++;
                while (this.f360c < this.f359b && this.f364g[this.f360c] == ' ') {
                    this.f360c++;
                }
                i = this.f362e - this.f361d;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
                }
                byte[] bArr = new byte[(i / 2)];
                int i3 = this.f361d + 1;
                for (i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) m425a(i3);
                    i3 += 2;
                }
                return new String(this.f364g, this.f361d, i);
            }
            if (this.f364g[this.f360c] >= 'A' && this.f364g[this.f360c] <= 'F') {
                char[] cArr = this.f364g;
                i2 = this.f360c;
                cArr[i2] = (char) (cArr[i2] + 32);
            }
            this.f360c++;
        }
        this.f362e = this.f360c;
        i = this.f362e - this.f361d;
        if (i >= 5) {
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
    }

    private String m429d() {
        this.f361d = this.f360c;
        this.f362e = this.f360c;
        while (this.f360c < this.f359b) {
            char[] cArr;
            int i;
            switch (this.f364g[this.f360c]) {
                case C4574a.ORDERED /*32*/:
                    this.f363f = this.f362e;
                    this.f360c++;
                    cArr = this.f364g;
                    i = this.f362e;
                    this.f362e = i + 1;
                    cArr[i] = ' ';
                    while (this.f360c < this.f359b && this.f364g[this.f360c] == ' ') {
                        cArr = this.f364g;
                        i = this.f362e;
                        this.f362e = i + 1;
                        cArr[i] = ' ';
                        this.f360c++;
                    }
                    if (this.f360c != this.f359b && this.f364g[this.f360c] != ',' && this.f364g[this.f360c] != '+' && this.f364g[this.f360c] != ';') {
                        break;
                    }
                    return new String(this.f364g, this.f361d, this.f363f - this.f361d);
                    break;
                case C1692R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                case C1692R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                case C1692R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    return new String(this.f364g, this.f361d, this.f362e - this.f361d);
                case C1692R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                    cArr = this.f364g;
                    i = this.f362e;
                    this.f362e = i + 1;
                    cArr[i] = m430e();
                    this.f360c++;
                    break;
                default:
                    cArr = this.f364g;
                    i = this.f362e;
                    this.f362e = i + 1;
                    cArr[i] = this.f364g[this.f360c];
                    this.f360c++;
                    break;
            }
        }
        return new String(this.f364g, this.f361d, this.f362e - this.f361d);
    }

    private char m430e() {
        this.f360c++;
        if (this.f360c == this.f359b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f358a);
        }
        switch (this.f364g[this.f360c]) {
            case C4574a.ORDERED /*32*/:
            case jni.SID_UX_SEC /*34*/:
            case jni.SID_UX_DATA /*35*/:
            case jni.SID_UX_IMG /*37*/:
            case C1692R.styleable.AppCompatTheme_dialogTheme /*42*/:
            case C1692R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case C1692R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case C1692R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
            case C4156a.f13954p /*60*/:
            case C1692R.styleable.AppCompatTheme_popupWindowStyle /*61*/:
            case C1692R.styleable.AppCompatTheme_editTextColor /*62*/:
            case C1692R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
            case C1692R.styleable.AppCompatTheme_textColorAlertDialogListItem /*95*/:
                return this.f364g[this.f360c];
            default:
                return m431f();
        }
    }

    private char m431f() {
        int a = m425a(this.f360c);
        this.f360c++;
        if (a < SpdyProtocol.SLIGHTSSLV2) {
            return (char) a;
        }
        if (a < Downloads.STATUS_RUNNING || a > 247) {
            return '?';
        }
        int i;
        if (a <= 223) {
            i = 1;
            a &= 31;
        } else if (a <= 239) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = a;
        for (a = 0; a < i; a++) {
            this.f360c++;
            if (this.f360c == this.f359b || this.f364g[this.f360c] != '\\') {
                return '?';
            }
            this.f360c++;
            int a2 = m425a(this.f360c);
            this.f360c++;
            if ((a2 & Downloads.STATUS_RUNNING) != SpdyProtocol.SLIGHTSSLV2) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    public String m432a(String str) {
        this.f360c = 0;
        this.f361d = 0;
        this.f362e = 0;
        this.f363f = 0;
        this.f364g = this.f358a.toCharArray();
        String a = m426a();
        if (a == null) {
            return null;
        }
        do {
            String str2 = BuildConfig.FLAVOR;
            if (this.f360c == this.f359b) {
                return null;
            }
            switch (this.f364g[this.f360c]) {
                case jni.SID_UX_SEC /*34*/:
                    str2 = m427b();
                    break;
                case jni.SID_UX_DATA /*35*/:
                    str2 = m428c();
                    break;
                case C1692R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                case C1692R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                case C1692R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    break;
                default:
                    str2 = m429d();
                    break;
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            if (this.f360c >= this.f359b) {
                return null;
            }
            if (this.f364g[this.f360c] == ',' || this.f364g[this.f360c] == ';' || this.f364g[this.f360c] == '+') {
                this.f360c++;
                a = m426a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f358a);
            }
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.f358a);
    }
}
