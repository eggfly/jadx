package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.network.C4316c;
import com.xiaomi.channel.commonutils.network.C4321d;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HttpUtils {

    public static class DefaultHttpGetProcessor extends HttpProcessor {
        public DefaultHttpGetProcessor() {
            super(1);
        }

        public String m17926b(Context context, String str, List<C4316c> list) {
            if (list == null) {
                return C4321d.m17699a(context, new URL(str));
            }
            Builder buildUpon = Uri.parse(str).buildUpon();
            for (C4316c c4316c : list) {
                buildUpon.appendQueryParameter(c4316c.m17689a(), c4316c.m17690b());
            }
            return C4321d.m17699a(context, new URL(buildUpon.toString()));
        }
    }

    static int m17927a(int i, int i2) {
        return (((((i2 + 243) / 1448) * 132) + 1080) + i) + i2;
    }

    static int m17928a(int i, int i2, int i3) {
        return ((((((i2 + Constants.COMMAND_HANDSHAKE) / 1448) * 132) + 1011) + i2) + i) + i3;
    }

    private static int m17929a(HttpProcessor httpProcessor, String str, List<C4316c> list, String str2) {
        if (httpProcessor.m17923a() == 1) {
            return m17927a(str.length(), m17930a(str2));
        }
        if (httpProcessor.m17923a() != 2) {
            return -1;
        }
        return m17928a(str.length(), m17931a((List) list), m17930a(str2));
    }

    static int m17930a(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = str.getBytes(HttpRequest.f14548a).length;
            } catch (UnsupportedEncodingException e) {
            }
        }
        return i;
    }

    static int m17931a(List<C4316c> list) {
        int i = 0;
        for (C4316c c4316c : list) {
            if (!TextUtils.isEmpty(c4316c.m17689a())) {
                i += c4316c.m17689a().length();
            }
            i = !TextUtils.isEmpty(c4316c.m17690b()) ? c4316c.m17690b().length() + i : i;
        }
        return i * 2;
    }

    public static String m17932a(Context context, String str, List<C4316c> list) {
        return m17933a(context, str, list, new DefaultHttpGetProcessor(), true);
    }

    public static String m17933a(Context context, String str, List<C4316c> list, HttpProcessor httpProcessor, boolean z) {
        if (C4321d.m17709d(context)) {
            try {
                ArrayList arrayList = new ArrayList();
                Fallback fallback = null;
                if (z) {
                    fallback = HostManager.getInstance().getFallbacksByURL(str);
                    if (fallback != null) {
                        arrayList = fallback.m17893a(str);
                    }
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                String str2 = null;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    List arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!httpProcessor.m17924a(context, str3, arrayList2)) {
                            return str2;
                        }
                        str2 = httpProcessor.m17925b(context, str3, arrayList2);
                        if (TextUtils.isEmpty(str2)) {
                            if (fallback != null) {
                                fallback.m17900a(str3, System.currentTimeMillis() - currentTimeMillis, (long) m17929a(httpProcessor, str3, arrayList2, str2), null);
                            }
                            str3 = str2;
                            str2 = str3;
                        } else if (fallback == null) {
                            return str2;
                        } else {
                            fallback.m17899a(str3, System.currentTimeMillis() - currentTimeMillis, (long) m17929a(httpProcessor, str3, arrayList2, str2));
                            return str2;
                        }
                    } catch (Exception e) {
                        if (fallback != null) {
                            fallback.m17900a(str3, System.currentTimeMillis() - currentTimeMillis, (long) m17929a(httpProcessor, str3, arrayList2, str2), e);
                        }
                        e.printStackTrace();
                        str3 = str2;
                    }
                }
                return str2;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
