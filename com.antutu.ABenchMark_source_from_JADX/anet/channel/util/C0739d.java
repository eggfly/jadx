package anet.channel.util;

import android.text.TextUtils;
import anet.channel.request.Request;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.ErrorCode;
import com.umeng.message.util.HttpRequest;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* renamed from: anet.channel.util.d */
public class C0739d {
    static final Pattern f2429a;

    static {
        f2429a = Pattern.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
    }

    public static String m2967a(URL url) {
        String str = null;
        if (url != null) {
            try {
                String path = url.getPath();
                int length = path.length();
                if (length > 1) {
                    int lastIndexOf = path.lastIndexOf(47);
                    if (!(lastIndexOf == -1 || lastIndexOf == length - 1)) {
                        int lastIndexOf2 = path.lastIndexOf(46);
                        if (lastIndexOf2 != -1 && lastIndexOf2 > lastIndexOf) {
                            str = path.substring(lastIndexOf2 + 1, length);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static List<String> m2968a(Map<String, List<String>> map, String str) {
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return (List) entry.getValue();
            }
        }
        return null;
    }

    public static Map<String, List<String>> m2969a(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(map.size());
        for (Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
        }
        return hashMap;
    }

    public static boolean m2970a(int i) {
        return i >= ErrorCode.APP_NOT_BIND && i < NetWorkError.STUB_NETWORK_ERROR && i != ErrorCode.DM_PACKAGENAME_INVALID;
    }

    public static boolean m2971a(Request request, int i, Map<String, List<String>> map) {
        if (request.isRedirectEnable() && request.isRedirectAllow() && C0739d.m2970a(i)) {
            String b = C0739d.m2973b(map, HttpRequest.f14565r);
            if (b != null) {
                if (!b.startsWith(HttpConstant.HTTP)) {
                    b = b.startsWith("//") ? "http:" + b : null;
                }
                request.redirectToUrl(b);
                return true;
            }
        }
        return false;
    }

    public static boolean m2972a(String str) {
        return str == null ? false : f2429a.matcher(str).matches();
    }

    public static String m2973b(Map<String, List<String>> map, String str) {
        List a = C0739d.m2968a(map, str);
        return (a == null || a.isEmpty()) ? null : (String) a.get(0);
    }

    public static boolean m2974b(Map<String, List<String>> map) {
        try {
            if (HttpRequest.f14551d.equalsIgnoreCase(C0739d.m2973b(map, HttpRequest.f14557j))) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static int m2975c(Map<String, List<String>> map) {
        try {
            return Integer.parseInt(C0739d.m2973b(map, HttpRequest.f14558k));
        } catch (Exception e) {
            return 0;
        }
    }
}
