package com.miui.support.net.http;

import java.io.InputStream;
import java.util.Map;

public interface Cache {

    public static class Entry {
        public InputStream f3400a;
        public long f3401b;
        public String f3402c;
        public String f3403d;
        public String f3404e;
        public long f3405f;
        public long f3406g;
        public long f3407h;
        public Map<String, String> f3408i;
    }

    Entry m5094a(String str);

    boolean m5095a(String str, Entry entry);
}
