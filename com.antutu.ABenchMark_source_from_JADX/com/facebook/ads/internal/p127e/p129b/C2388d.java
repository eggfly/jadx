package com.facebook.ads.internal.p127e.p129b;

import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.internal.e.b.d */
class C2388d {
    private static final Pattern f8281d;
    private static final Pattern f8282e;
    public final String f8283a;
    public final long f8284b;
    public final boolean f8285c;

    static {
        f8281d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
        f8282e = Pattern.compile("GET /(.*) HTTP");
    }

    public C2388d(String str) {
        C2404j.m9249a(str);
        long a = m9180a(str);
        this.f8284b = Math.max(0, a);
        this.f8285c = a >= 0;
        this.f8283a = m9182b(str);
    }

    private long m9180a(String str) {
        Matcher matcher = f8281d.matcher(str);
        return matcher.find() ? Long.parseLong(matcher.group(1)) : -1;
    }

    public static C2388d m9181a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HttpRequest.f14548a));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new C2388d(stringBuilder.toString());
            }
            stringBuilder.append(readLine).append('\n');
        }
    }

    private String m9182b(String str) {
        Matcher matcher = f8282e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f8284b + ", partial=" + this.f8285c + ", uri='" + this.f8283a + '\'' + '}';
    }
}
