package anet.channel.strategy;

import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.dispatch.C0714a;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import java.util.Locale;

/* renamed from: anet.channel.strategy.n */
public class C0734n {
    public static String[] f2415a;
    public static String[][] f2416b;
    public static String f2417c;
    public static String[] f2418d;
    public static String f2419e;
    public static String[] f2420f;

    static {
        f2415a = new String[]{"acs.m.taobao.com", "acs.wapa.taobao.com", "acs.waptest.taobao.com"};
        r0 = new String[3][];
        r0[0] = new String[]{StringUtils.longToIP(140205166083L), StringUtils.longToIP(106011052093L)};
        r0[1] = new String[]{StringUtils.longToIP(110075206079L)};
        r0[2] = new String[]{StringUtils.longToIP(10125050231L)};
        f2416b = r0;
        f2417c = "unitacs.m.taobao.com";
        f2418d = new String[]{StringUtils.longToIP(42156146086L), StringUtils.longToIP(140205117097L)};
        f2419e = "unszacs.m.taobao.com";
        f2420f = new String[]{StringUtils.longToIP(106011011086L), StringUtils.longToIP(106011012009L)};
    }

    public static String m2950a() {
        return f2415a[GlobalAppRuntimeInfo.getEnv().getEnvMode()];
    }

    public static String m2951a(String str, String str2) {
        return StringUtils.buildString(str, HttpConstant.SCHEME_SPLIT, str2);
    }

    public static boolean m2952a(String str) {
        return TextUtils.isEmpty(str) ? false : str.equalsIgnoreCase(C0734n.m2950a());
    }

    public static String m2953b(String str) {
        return StringUtils.buildString(str, C0734n.m2950a());
    }

    public static String[] m2954b() {
        return f2416b[GlobalAppRuntimeInfo.getEnv().getEnvMode()];
    }

    public static boolean m2955c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String toLowerCase = str.toLowerCase(Locale.US);
        String a = C0734n.m2950a();
        return toLowerCase.equals(a) || (toLowerCase.startsWith("un") && toLowerCase.endsWith(a));
    }

    public static boolean m2956d(String str) {
        return C0734n.m2955c(str) || C0714a.m2915a(str);
    }

    public static String m2957e(String str) {
        int indexOf = str.indexOf(HttpConstant.SCHEME_SPLIT);
        if (indexOf != -1) {
            return str.substring(indexOf + 3);
        }
        throw new RuntimeException("invalid key");
    }

    public static boolean m2958f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray.length <= 0 || toCharArray.length > MotionEventCompat.ACTION_MASK) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (i < toCharArray.length) {
            if ((toCharArray[i] >= 'A' && toCharArray[i] <= 'Z') || (toCharArray[i] >= 'a' && toCharArray[i] <= 'z')) {
                z = true;
            } else if (!((toCharArray[i] >= '0' && toCharArray[i] <= '9') || toCharArray[i] == '.' || toCharArray[i] == '-')) {
                return false;
            }
            i++;
        }
        return z;
    }
}
