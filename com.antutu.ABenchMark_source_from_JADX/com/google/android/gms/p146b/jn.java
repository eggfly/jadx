package com.google.android.gms.p146b;

import android.text.TextUtils;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.jn */
public final class jn {
    private static final Pattern f11564a;
    private static final Pattern f11565b;

    static {
        f11564a = Pattern.compile("\\\\.");
        f11565b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    }

    public static String m13564a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f11565b.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case jni.SID_UX_SEC /*34*/:
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case C1692R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case C1692R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
