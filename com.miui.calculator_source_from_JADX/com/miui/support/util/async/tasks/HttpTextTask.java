package com.miui.support.util.async.tasks;

import com.miui.support.net.http.HttpResponse;
import com.miui.support.util.IOUtils;
import java.nio.charset.Charset;

public abstract class HttpTextTask<T> extends HttpTask<T> {
    protected final String m5566i() {
        HttpResponse j = m5560j();
        String c = j.m5098c();
        if (c == null || c.length() <= 0) {
            byte[] b = IOUtils.m5392b(j.m5096a());
            c = new String(b, Charset.forName(m5565a(b)));
        } else {
            c = IOUtils.m5386a(j.m5096a(), c.toUpperCase());
        }
        j.m5100e();
        return c;
    }

    static String m5565a(byte[] bArr) {
        String substring;
        int i = 500;
        if (bArr.length <= 500) {
            i = bArr.length;
        }
        String toUpperCase = new String(bArr, 0, i, Charset.forName("UTF-8")).toUpperCase();
        if (toUpperCase.indexOf("CONTENT-TYPE") >= 0) {
            i = toUpperCase.lastIndexOf(10);
            if (i < 0) {
                i = 0;
            }
            int indexOf = toUpperCase.indexOf(10);
            if (indexOf < 0) {
                indexOf = toUpperCase.length();
            }
            substring = toUpperCase.substring(i, indexOf);
        } else {
            substring = null;
        }
        if (substring != null) {
            String toUpperCase2 = substring.toUpperCase();
            i = toUpperCase2.indexOf("CHARSET=");
            if (i >= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (i += 8; i < toUpperCase2.length(); i++) {
                    char charAt = toUpperCase2.charAt(i);
                    if (charAt == '\'' || charAt == '\"' || charAt == ' ') {
                        stringBuilder.append(charAt);
                    }
                }
                return stringBuilder.toString();
            }
        }
        return "UTF-8";
    }
}
