package anet.channel.util;

import anet.channel.strategy.C0734n;
import anet.channel.strategy.dispatch.C0714a;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* renamed from: anet.channel.util.g */
public class C0746g {
    private static Map<String, Integer> f2435a;

    static {
        f2435a = new HashMap();
        f2435a.put("html", Integer.valueOf(2));
        f2435a.put("htm", Integer.valueOf(2));
        f2435a.put("css", Integer.valueOf(3));
        f2435a.put("js", Integer.valueOf(3));
        f2435a.put("json", Integer.valueOf(4));
        f2435a.put("webp", Integer.valueOf(5));
        f2435a.put("png", Integer.valueOf(5));
        f2435a.put("jpg", Integer.valueOf(5));
        f2435a.put("zip", Integer.valueOf(9));
        f2435a.put("bin", Integer.valueOf(9));
    }

    public static int m2983a(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("url is null!");
        }
        String host = url.getHost();
        if (C0734n.m2955c(host)) {
            return 0;
        }
        if (C0714a.m2914a().equalsIgnoreCase(host)) {
            return 1;
        }
        host = C0739d.m2967a(url);
        if (host == null) {
            return 4;
        }
        Integer num = (Integer) f2435a.get(host);
        return num != null ? num.intValue() : 6;
    }
}
