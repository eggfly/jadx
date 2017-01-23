package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.smack.packet.h */
public class C4488h {
    private int f15445a;
    private String f15446b;
    private String f15447c;
    private String f15448d;
    private String f15449e;
    private List<C4479a> f15450f;

    /* renamed from: com.xiaomi.smack.packet.h.a */
    public static class C4487a {
        public static final C4487a f15420a;
        public static final C4487a f15421b;
        public static final C4487a f15422c;
        public static final C4487a f15423d;
        public static final C4487a f15424e;
        public static final C4487a f15425f;
        public static final C4487a f15426g;
        public static final C4487a f15427h;
        public static final C4487a f15428i;
        public static final C4487a f15429j;
        public static final C4487a f15430k;
        public static final C4487a f15431l;
        public static final C4487a f15432m;
        public static final C4487a f15433n;
        public static final C4487a f15434o;
        public static final C4487a f15435p;
        public static final C4487a f15436q;
        public static final C4487a f15437r;
        public static final C4487a f15438s;
        public static final C4487a f15439t;
        public static final C4487a f15440u;
        public static final C4487a f15441v;
        public static final C4487a f15442w;
        public static final C4487a f15443x;
        private String f15444y;

        static {
            f15420a = new C4487a("internal-server-error");
            f15421b = new C4487a("forbidden");
            f15422c = new C4487a("bad-request");
            f15423d = new C4487a("conflict");
            f15424e = new C4487a("feature-not-implemented");
            f15425f = new C4487a("gone");
            f15426g = new C4487a("item-not-found");
            f15427h = new C4487a("jid-malformed");
            f15428i = new C4487a("not-acceptable");
            f15429j = new C4487a("not-allowed");
            f15430k = new C4487a("not-authorized");
            f15431l = new C4487a("payment-required");
            f15432m = new C4487a("recipient-unavailable");
            f15433n = new C4487a("redirect");
            f15434o = new C4487a("registration-required");
            f15435p = new C4487a("remote-server-error");
            f15436q = new C4487a("remote-server-not-found");
            f15437r = new C4487a("remote-server-timeout");
            f15438s = new C4487a("resource-constraint");
            f15439t = new C4487a("service-unavailable");
            f15440u = new C4487a("subscription-required");
            f15441v = new C4487a("undefined-condition");
            f15442w = new C4487a("unexpected-request");
            f15443x = new C4487a("request-timeout");
        }

        public C4487a(String str) {
            this.f15444y = str;
        }

        public String toString() {
            return this.f15444y;
        }
    }

    public C4488h(int i, String str, String str2, String str3, String str4, List<C4479a> list) {
        this.f15450f = null;
        this.f15445a = i;
        this.f15446b = str;
        this.f15448d = str2;
        this.f15447c = str3;
        this.f15449e = str4;
        this.f15450f = list;
    }

    public C4488h(Bundle bundle) {
        this.f15450f = null;
        this.f15445a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f15446b = bundle.getString("ext_err_type");
        }
        this.f15447c = bundle.getString("ext_err_cond");
        this.f15448d = bundle.getString("ext_err_reason");
        this.f15449e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f15450f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C4479a a = C4479a.m18568a((Bundle) parcelable);
                if (a != null) {
                    this.f15450f.add(a);
                }
            }
        }
    }

    public C4488h(C4487a c4487a) {
        this.f15450f = null;
        m18617a(c4487a);
        this.f15449e = null;
    }

    private void m18617a(C4487a c4487a) {
        this.f15447c = c4487a.f15444y;
    }

    public String m18618a() {
        return this.f15448d;
    }

    public String m18619b() {
        return this.f15446b;
    }

    public Bundle m18620c() {
        Bundle bundle = new Bundle();
        if (this.f15446b != null) {
            bundle.putString("ext_err_type", this.f15446b);
        }
        bundle.putInt("ext_err_code", this.f15445a);
        if (this.f15448d != null) {
            bundle.putString("ext_err_reason", this.f15448d);
        }
        if (this.f15447c != null) {
            bundle.putString("ext_err_cond", this.f15447c);
        }
        if (this.f15449e != null) {
            bundle.putString("ext_err_msg", this.f15449e);
        }
        if (this.f15450f != null) {
            Parcelable[] parcelableArr = new Bundle[this.f15450f.size()];
            int i = 0;
            for (C4479a e : this.f15450f) {
                int i2;
                Bundle e2 = e.m18577e();
                if (e2 != null) {
                    i2 = i + 1;
                    parcelableArr[i] = e2;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            bundle.putParcelableArray("ext_exts", parcelableArr);
        }
        return bundle;
    }

    public String m18621d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<error code=\"").append(this.f15445a).append("\"");
        if (this.f15446b != null) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(this.f15446b);
            stringBuilder.append("\"");
        }
        if (this.f15448d != null) {
            stringBuilder.append(" reason=\"");
            stringBuilder.append(this.f15448d);
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        if (this.f15447c != null) {
            stringBuilder.append("<").append(this.f15447c);
            stringBuilder.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f15449e != null) {
            stringBuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            stringBuilder.append(this.f15449e);
            stringBuilder.append("</text>");
        }
        for (C4478e d : m18622e()) {
            stringBuilder.append(d.m18567d());
        }
        stringBuilder.append("</error>");
        return stringBuilder.toString();
    }

    public synchronized List<C4479a> m18622e() {
        return this.f15450f == null ? Collections.emptyList() : Collections.unmodifiableList(this.f15450f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f15447c != null) {
            stringBuilder.append(this.f15447c);
        }
        stringBuilder.append(C4233j.f14396s).append(this.f15445a).append(C4233j.f14397t);
        if (this.f15449e != null) {
            stringBuilder.append(" ").append(this.f15449e);
        }
        return stringBuilder.toString();
    }
}
