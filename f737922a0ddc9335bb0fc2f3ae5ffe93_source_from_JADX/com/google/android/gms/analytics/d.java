package com.google.android.gms.analytics;

import afi;
import afj;
import afk;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class d {

    protected static class d<T extends d> {
        Map<String, List<afi>> DW;
        List<afk> FH;
        List<afi> Hw;
        afj j6;
        private Map<String, String> v5;

        protected d() {
            this.v5 = new HashMap();
            this.DW = new HashMap();
            this.FH = new ArrayList();
            this.Hw = new ArrayList();
        }

        public T j6(int i, String str) {
            j6(j.j6(i), str);
            return this;
        }

        public final T j6(String str, String str2) {
            if (str != null) {
                this.v5.put(str, str2);
            } else {
                com.google.android.gms.analytics.internal.f.FH("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public Map<String, String> j6() {
            Map<String, String> hashMap = new HashMap(this.v5);
            if (this.j6 != null) {
                hashMap.putAll(this.j6.j6());
            }
            int i = 1;
            for (afk j6 : this.FH) {
                hashMap.putAll(j6.j6(j.Zo(i)));
                i++;
            }
            i = 1;
            for (afi j62 : this.Hw) {
                hashMap.putAll(j62.j6(j.Hw(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.DW.entrySet()) {
                List<afi> list = (List) entry.getValue();
                String u7 = j.u7(i2);
                int i3 = 1;
                for (afi afi : list) {
                    String valueOf = String.valueOf(u7);
                    String valueOf2 = String.valueOf(j.gn(i3));
                    hashMap.putAll(afi.j6(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(u7);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }
    }

    @Deprecated
    public static class a extends d<a> {
        public a() {
            j6("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map j6() {
            return super.j6();
        }
    }

    public static class b extends d<b> {
        public b() {
            j6("&t", "event");
        }

        public b DW(String str) {
            j6("&ea", str);
            return this;
        }

        public b FH(String str) {
            j6("&el", str);
            return this;
        }

        public b j6(long j) {
            j6("&ev", Long.toString(j));
            return this;
        }

        public b j6(String str) {
            j6("&ec", str);
            return this;
        }

        public /* bridge */ /* synthetic */ Map j6() {
            return super.j6();
        }
    }

    public static class c extends d<c> {
        public c() {
            j6("&t", "exception");
        }

        public c j6(String str) {
            j6("&exd", str);
            return this;
        }

        public c j6(boolean z) {
            j6("&exf", p.j6(z));
            return this;
        }

        public /* bridge */ /* synthetic */ Map j6() {
            return super.j6();
        }
    }

    @Deprecated
    public static class e extends d<e> {
        public e() {
            j6("&t", "item");
        }

        public e DW(String str) {
            j6("&in", str);
            return this;
        }

        public e FH(String str) {
            j6("&ic", str);
            return this;
        }

        public e Hw(String str) {
            j6("&iv", str);
            return this;
        }

        public e j6(double d) {
            j6("&ip", Double.toString(d));
            return this;
        }

        public e j6(long j) {
            j6("&iq", Long.toString(j));
            return this;
        }

        public e j6(String str) {
            j6("&ti", str);
            return this;
        }

        public /* bridge */ /* synthetic */ Map j6() {
            return super.j6();
        }

        public e v5(String str) {
            j6("&cu", str);
            return this;
        }
    }

    @Deprecated
    public static class f extends d<f> {
        public f() {
            j6("&t", "transaction");
        }

        public f DW(double d) {
            j6("&tt", Double.toString(d));
            return this;
        }

        public f DW(String str) {
            j6("&ta", str);
            return this;
        }

        public f FH(double d) {
            j6("&ts", Double.toString(d));
            return this;
        }

        public f FH(String str) {
            j6("&cu", str);
            return this;
        }

        public f j6(double d) {
            j6("&tr", Double.toString(d));
            return this;
        }

        public f j6(String str) {
            j6("&ti", str);
            return this;
        }

        public /* bridge */ /* synthetic */ Map j6() {
            return super.j6();
        }
    }
}
