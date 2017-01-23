package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.xiaomi.smack.util.C4496g;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.smack.packet.f */
public class C4485f extends C4468d {
    private C4484b f15415c;
    private String f15416d;
    private int f15417e;
    private C4483a f15418f;

    /* renamed from: com.xiaomi.smack.packet.f.a */
    public enum C4483a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* renamed from: com.xiaomi.smack.packet.f.b */
    public enum C4484b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public C4485f(Bundle bundle) {
        super(bundle);
        this.f15415c = C4484b.available;
        this.f15416d = null;
        this.f15417e = LinearLayoutManager.INVALID_OFFSET;
        this.f15418f = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f15415c = C4484b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f15416d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f15417e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f15418f = C4483a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public C4485f(C4484b c4484b) {
        this.f15415c = C4484b.available;
        this.f15416d = null;
        this.f15417e = LinearLayoutManager.INVALID_OFFSET;
        this.f15418f = null;
        m18613a(c4484b);
    }

    public String m18610a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<presence");
        if (m18531t() != null) {
            stringBuilder.append(" xmlns=\"").append(m18531t()).append("\"");
        }
        if (m18515k() != null) {
            stringBuilder.append(" id=\"").append(m18515k()).append("\"");
        }
        if (m18519m() != null) {
            stringBuilder.append(" to=\"").append(C4496g.m18647a(m18519m())).append("\"");
        }
        if (m18521n() != null) {
            stringBuilder.append(" from=\"").append(C4496g.m18647a(m18521n())).append("\"");
        }
        if (m18517l() != null) {
            stringBuilder.append(" chid=\"").append(C4496g.m18647a(m18517l())).append("\"");
        }
        if (this.f15415c != null) {
            stringBuilder.append(" type=\"").append(this.f15415c).append("\"");
        }
        stringBuilder.append(">");
        if (this.f15416d != null) {
            stringBuilder.append("<status>").append(C4496g.m18647a(this.f15416d)).append("</status>");
        }
        if (this.f15417e != LinearLayoutManager.INVALID_OFFSET) {
            stringBuilder.append("<priority>").append(this.f15417e).append("</priority>");
        }
        if (!(this.f15418f == null || this.f15418f == C4483a.available)) {
            stringBuilder.append("<show>").append(this.f15418f).append("</show>");
        }
        stringBuilder.append(m18530s());
        C4488h p = m18526p();
        if (p != null) {
            stringBuilder.append(p.m18621d());
        }
        stringBuilder.append("</presence>");
        return stringBuilder.toString();
    }

    public void m18611a(int i) {
        if (i < -128 || i > SpdyProtocol.SLIGHTSSLV2) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f15417e = i;
    }

    public void m18612a(C4483a c4483a) {
        this.f15418f = c4483a;
    }

    public void m18613a(C4484b c4484b) {
        if (c4484b == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f15415c = c4484b;
    }

    public void m18614a(String str) {
        this.f15416d = str;
    }

    public Bundle m18615c() {
        Bundle c = super.m18514c();
        if (this.f15415c != null) {
            c.putString("ext_pres_type", this.f15415c.toString());
        }
        if (this.f15416d != null) {
            c.putString("ext_pres_status", this.f15416d);
        }
        if (this.f15417e != LinearLayoutManager.INVALID_OFFSET) {
            c.putInt("ext_pres_prio", this.f15417e);
        }
        if (!(this.f15418f == null || this.f15418f == C4483a.available)) {
            c.putString("ext_pres_mode", this.f15418f.toString());
        }
        return c;
    }
}
