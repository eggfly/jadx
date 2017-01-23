package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.smack.util.C4496g;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.intent.IntentUtil;

/* renamed from: com.xiaomi.smack.packet.b */
public class C4481b extends C4468d {
    private C4480a f15385c;
    private final Map<String, String> f15386d;

    /* renamed from: com.xiaomi.smack.packet.b.a */
    public static class C4480a {
        public static final C4480a f15379a;
        public static final C4480a f15380b;
        public static final C4480a f15381c;
        public static final C4480a f15382d;
        public static final C4480a f15383e;
        private String f15384f;

        static {
            f15379a = new C4480a("get");
            f15380b = new C4480a("set");
            f15381c = new C4480a("result");
            f15382d = new C4480a(C4233j.f14375B);
            f15383e = new C4480a(IntentUtil.AGOO_COMMAND);
        }

        private C4480a(String str) {
            this.f15384f = str;
        }

        public static C4480a m18579a(String str) {
            if (str == null) {
                return null;
            }
            String toLowerCase = str.toLowerCase();
            return f15379a.toString().equals(toLowerCase) ? f15379a : f15380b.toString().equals(toLowerCase) ? f15380b : f15382d.toString().equals(toLowerCase) ? f15382d : f15381c.toString().equals(toLowerCase) ? f15381c : f15383e.toString().equals(toLowerCase) ? f15383e : null;
        }

        public String toString() {
            return this.f15384f;
        }
    }

    public C4481b() {
        this.f15385c = C4480a.f15379a;
        this.f15386d = new HashMap();
    }

    public C4481b(Bundle bundle) {
        super(bundle);
        this.f15385c = C4480a.f15379a;
        this.f15386d = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f15385c = C4480a.m18579a(bundle.getString("ext_iq_type"));
        }
    }

    public String m18580a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<iq ");
        if (m18515k() != null) {
            stringBuilder.append("id=\"" + m18515k() + "\" ");
        }
        if (m18519m() != null) {
            stringBuilder.append("to=\"").append(C4496g.m18647a(m18519m())).append("\" ");
        }
        if (m18521n() != null) {
            stringBuilder.append("from=\"").append(C4496g.m18647a(m18521n())).append("\" ");
        }
        if (m18517l() != null) {
            stringBuilder.append("chid=\"").append(C4496g.m18647a(m18517l())).append("\" ");
        }
        for (Entry entry : this.f15386d.entrySet()) {
            stringBuilder.append(C4496g.m18647a((String) entry.getKey())).append("=\"");
            stringBuilder.append(C4496g.m18647a((String) entry.getValue())).append("\" ");
        }
        if (this.f15385c == null) {
            stringBuilder.append("type=\"get\">");
        } else {
            stringBuilder.append("type=\"").append(m18585b()).append("\">");
        }
        String d = m18587d();
        if (d != null) {
            stringBuilder.append(d);
        }
        stringBuilder.append(m18530s());
        C4488h p = m18526p();
        if (p != null) {
            stringBuilder.append(p.m18621d());
        }
        stringBuilder.append("</iq>");
        return stringBuilder.toString();
    }

    public synchronized String m18581a(String str) {
        return (String) this.f15386d.get(str);
    }

    public void m18582a(C4480a c4480a) {
        if (c4480a == null) {
            this.f15385c = C4480a.f15379a;
        } else {
            this.f15385c = c4480a;
        }
    }

    public synchronized void m18583a(String str, String str2) {
        this.f15386d.put(str, str2);
    }

    public synchronized void m18584a(Map<String, String> map) {
        this.f15386d.putAll(map);
    }

    public C4480a m18585b() {
        return this.f15385c;
    }

    public Bundle m18586c() {
        Bundle c = super.m18514c();
        if (this.f15385c != null) {
            c.putString("ext_iq_type", this.f15385c.toString());
        }
        return c;
    }

    public String m18587d() {
        return null;
    }
}
