package android.support.v4.text;

import android.os.Build.VERSION;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;

public final class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG;
    private static String HEBR_SCRIPT_SUBTAG;
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT;

    private static class TextUtilsCompatImpl {
        private TextUtilsCompatImpl() {
        }

        private static int getLayoutDirectionFromFirstChar(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return 1;
                default:
                    return 0;
            }
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (!(locale == null || locale.equals(TextUtilsCompat.ROOT))) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return getLayoutDirectionFromFirstChar(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                    return 1;
                }
            }
            return 0;
        }

        public String htmlEncode(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case jni.SID_UX_SEC /*34*/:
                        stringBuilder.append("&quot;");
                        break;
                    case jni.SID_UX_IO /*38*/:
                        stringBuilder.append("&amp;");
                        break;
                    case jni.SID_3D_GARDEN /*39*/:
                        stringBuilder.append("&#39;");
                        break;
                    case C4156a.f13954p /*60*/:
                        stringBuilder.append("&lt;");
                        break;
                    case C1692R.styleable.AppCompatTheme_editTextColor /*62*/:
                        stringBuilder.append("&gt;");
                        break;
                    default:
                        stringBuilder.append(charAt);
                        break;
                }
            }
            return stringBuilder.toString();
        }
    }

    private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        private TextUtilsCompatJellybeanMr1Impl() {
            super();
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }

        public String htmlEncode(String str) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(str);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            IMPL = new TextUtilsCompatJellybeanMr1Impl();
        } else {
            IMPL = new TextUtilsCompatImpl();
        }
        ROOT = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        ARAB_SCRIPT_SUBTAG = "Arab";
        HEBR_SCRIPT_SUBTAG = "Hebr";
    }

    private TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return IMPL.getLayoutDirectionFromLocale(locale);
    }

    public static String htmlEncode(String str) {
        return IMPL.htmlEncode(str);
    }
}
