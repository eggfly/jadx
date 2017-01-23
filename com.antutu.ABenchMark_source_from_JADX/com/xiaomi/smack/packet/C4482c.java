package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.util.C4496g;

/* renamed from: com.xiaomi.smack.packet.c */
public class C4482c extends C4468d {
    private String f15387c;
    private String f15388d;
    private String f15389e;
    private String f15390f;
    private String f15391g;
    private String f15392h;
    private boolean f15393i;
    private String f15394j;
    private String f15395k;
    private String f15396l;
    private String f15397m;
    private String f15398n;
    private boolean f15399o;

    public C4482c() {
        this.f15387c = null;
        this.f15388d = null;
        this.f15393i = false;
        this.f15395k = BuildConfig.FLAVOR;
        this.f15396l = BuildConfig.FLAVOR;
        this.f15397m = BuildConfig.FLAVOR;
        this.f15398n = BuildConfig.FLAVOR;
        this.f15399o = false;
    }

    public C4482c(Bundle bundle) {
        super(bundle);
        this.f15387c = null;
        this.f15388d = null;
        this.f15393i = false;
        this.f15395k = BuildConfig.FLAVOR;
        this.f15396l = BuildConfig.FLAVOR;
        this.f15397m = BuildConfig.FLAVOR;
        this.f15398n = BuildConfig.FLAVOR;
        this.f15399o = false;
        this.f15387c = bundle.getString("ext_msg_type");
        this.f15389e = bundle.getString("ext_msg_lang");
        this.f15388d = bundle.getString("ext_msg_thread");
        this.f15390f = bundle.getString("ext_msg_sub");
        this.f15391g = bundle.getString("ext_msg_body");
        this.f15392h = bundle.getString("ext_body_encode");
        this.f15394j = bundle.getString("ext_msg_appid");
        this.f15393i = bundle.getBoolean("ext_msg_trans", false);
        this.f15399o = bundle.getBoolean("ext_msg_encrypt", false);
        this.f15395k = bundle.getString("ext_msg_seq");
        this.f15396l = bundle.getString("ext_msg_mseq");
        this.f15397m = bundle.getString("ext_msg_fseq");
        this.f15398n = bundle.getString("ext_msg_status");
    }

    public String m18588a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<message");
        if (m18531t() != null) {
            stringBuilder.append(" xmlns=\"").append(m18531t()).append("\"");
        }
        if (this.f15389e != null) {
            stringBuilder.append(" xml:lang=\"").append(m18607i()).append("\"");
        }
        if (m18515k() != null) {
            stringBuilder.append(" id=\"").append(m18515k()).append("\"");
        }
        if (m18519m() != null) {
            stringBuilder.append(" to=\"").append(C4496g.m18647a(m18519m())).append("\"");
        }
        if (!TextUtils.isEmpty(m18599e())) {
            stringBuilder.append(" seq=\"").append(m18599e()).append("\"");
        }
        if (!TextUtils.isEmpty(m18601f())) {
            stringBuilder.append(" mseq=\"").append(m18601f()).append("\"");
        }
        if (!TextUtils.isEmpty(m18603g())) {
            stringBuilder.append(" fseq=\"").append(m18603g()).append("\"");
        }
        if (!TextUtils.isEmpty(m18605h())) {
            stringBuilder.append(" status=\"").append(m18605h()).append("\"");
        }
        if (m18521n() != null) {
            stringBuilder.append(" from=\"").append(C4496g.m18647a(m18521n())).append("\"");
        }
        if (m18517l() != null) {
            stringBuilder.append(" chid=\"").append(C4496g.m18647a(m18517l())).append("\"");
        }
        if (this.f15393i) {
            stringBuilder.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f15394j)) {
            stringBuilder.append(" appid=\"").append(m18597d()).append("\"");
        }
        if (!TextUtils.isEmpty(this.f15387c)) {
            stringBuilder.append(" type=\"").append(this.f15387c).append("\"");
        }
        if (this.f15399o) {
            stringBuilder.append(" s=\"1\"");
        }
        stringBuilder.append(">");
        if (this.f15390f != null) {
            stringBuilder.append("<subject>").append(C4496g.m18647a(this.f15390f));
            stringBuilder.append("</subject>");
        }
        if (this.f15391g != null) {
            stringBuilder.append("<body");
            if (!TextUtils.isEmpty(this.f15392h)) {
                stringBuilder.append(" encode=\"").append(this.f15392h).append("\"");
            }
            stringBuilder.append(">").append(C4496g.m18647a(this.f15391g)).append("</body>");
        }
        if (this.f15388d != null) {
            stringBuilder.append("<thread>").append(this.f15388d).append("</thread>");
        }
        if (C4233j.f14375B.equalsIgnoreCase(this.f15387c)) {
            C4488h p = m18526p();
            if (p != null) {
                stringBuilder.append(p.m18621d());
            }
        }
        stringBuilder.append(m18530s());
        stringBuilder.append("</message>");
        return stringBuilder.toString();
    }

    public void m18589a(String str) {
        this.f15394j = str;
    }

    public void m18590a(String str, String str2) {
        this.f15391g = str;
        this.f15392h = str2;
    }

    public void m18591a(boolean z) {
        this.f15393i = z;
    }

    public String m18592b() {
        return this.f15387c;
    }

    public void m18593b(String str) {
        this.f15395k = str;
    }

    public void m18594b(boolean z) {
        this.f15399o = z;
    }

    public Bundle m18595c() {
        Bundle c = super.m18514c();
        if (!TextUtils.isEmpty(this.f15387c)) {
            c.putString("ext_msg_type", this.f15387c);
        }
        if (this.f15389e != null) {
            c.putString("ext_msg_lang", this.f15389e);
        }
        if (this.f15390f != null) {
            c.putString("ext_msg_sub", this.f15390f);
        }
        if (this.f15391g != null) {
            c.putString("ext_msg_body", this.f15391g);
        }
        if (!TextUtils.isEmpty(this.f15392h)) {
            c.putString("ext_body_encode", this.f15392h);
        }
        if (this.f15388d != null) {
            c.putString("ext_msg_thread", this.f15388d);
        }
        if (this.f15394j != null) {
            c.putString("ext_msg_appid", this.f15394j);
        }
        if (this.f15393i) {
            c.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f15395k)) {
            c.putString("ext_msg_seq", this.f15395k);
        }
        if (!TextUtils.isEmpty(this.f15396l)) {
            c.putString("ext_msg_mseq", this.f15396l);
        }
        if (!TextUtils.isEmpty(this.f15397m)) {
            c.putString("ext_msg_fseq", this.f15397m);
        }
        if (this.f15399o) {
            c.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f15398n)) {
            c.putString("ext_msg_status", this.f15398n);
        }
        return c;
    }

    public void m18596c(String str) {
        this.f15396l = str;
    }

    public String m18597d() {
        return this.f15394j;
    }

    public void m18598d(String str) {
        this.f15397m = str;
    }

    public String m18599e() {
        return this.f15395k;
    }

    public void m18600e(String str) {
        this.f15398n = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C4482c c4482c = (C4482c) obj;
        if (!super.equals(c4482c)) {
            return false;
        }
        if (this.f15391g != null) {
            if (!this.f15391g.equals(c4482c.f15391g)) {
                return false;
            }
        } else if (c4482c.f15391g != null) {
            return false;
        }
        if (this.f15389e != null) {
            if (!this.f15389e.equals(c4482c.f15389e)) {
                return false;
            }
        } else if (c4482c.f15389e != null) {
            return false;
        }
        if (this.f15390f != null) {
            if (!this.f15390f.equals(c4482c.f15390f)) {
                return false;
            }
        } else if (c4482c.f15390f != null) {
            return false;
        }
        if (this.f15388d != null) {
            if (!this.f15388d.equals(c4482c.f15388d)) {
                return false;
            }
        } else if (c4482c.f15388d != null) {
            return false;
        }
        if (this.f15387c != c4482c.f15387c) {
            z = false;
        }
        return z;
    }

    public String m18601f() {
        return this.f15396l;
    }

    public void m18602f(String str) {
        this.f15387c = str;
    }

    public String m18603g() {
        return this.f15397m;
    }

    public void m18604g(String str) {
        this.f15390f = str;
    }

    public String m18605h() {
        return this.f15398n;
    }

    public void m18606h(String str) {
        this.f15391g = str;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f15389e != null ? this.f15389e.hashCode() : 0) + (((this.f15388d != null ? this.f15388d.hashCode() : 0) + (((this.f15391g != null ? this.f15391g.hashCode() : 0) + ((this.f15387c != null ? this.f15387c.hashCode() : 0) * 31)) * 31)) * 31)) * 31;
        if (this.f15390f != null) {
            i = this.f15390f.hashCode();
        }
        return hashCode + i;
    }

    public String m18607i() {
        return this.f15389e;
    }

    public void m18608i(String str) {
        this.f15388d = str;
    }

    public void m18609j(String str) {
        this.f15389e = str;
    }
}
