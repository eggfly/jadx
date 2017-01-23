package p023b.p024a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.cj */
public class cj {

    /* renamed from: b.a.cj.a */
    private static class C0859a {
        private static final cj f2852a;

        static {
            f2852a = new cj();
        }
    }

    private cj() {
    }

    public static cj m3741a() {
        return C0859a.f2852a;
    }

    private boolean m3742a(String str, int i) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) < i) {
                return false;
            }
        }
        return true;
    }

    public boolean m3743a(String str) {
        return BuildConfig.FLAVOR.equals(str) ? true : str == null ? false : str.getBytes().length < 160 && m3742a(str, 48);
    }

    public boolean m3744a(List<String> list) {
        if (list == null) {
            return false;
        }
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (TextUtils.isEmpty((CharSequence) list.get(i))) {
                return false;
            }
            if (!m3742a((String) list.get(i), 48)) {
                return false;
            }
        }
        return true;
    }

    public int m3745b() {
        return 8;
    }

    public boolean m3746b(String str) {
        return !TextUtils.isEmpty(str) && str.length() < 16 && m3742a(str, 48);
    }

    public boolean m3747b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        int i = 0;
        for (String bytes : list) {
            i = bytes.getBytes().length + i;
        }
        return i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    public int m3748c() {
        return SpdyProtocol.SLIGHTSSLV2;
    }

    public int m3749d() {
        return AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    }
}
