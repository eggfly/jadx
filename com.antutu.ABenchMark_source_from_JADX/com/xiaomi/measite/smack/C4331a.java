package com.xiaomi.measite.smack;

import com.xiaomi.smack.C4336f;
import com.xiaomi.smack.C4338d;
import com.xiaomi.smack.C4461a;
import com.xiaomi.smack.debugger.C4330a;
import com.xiaomi.smack.util.C4332f;
import com.xiaomi.smack.util.C4334l;
import com.xiaomi.smack.util.C4491a;
import com.xiaomi.smack.util.C4492b;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

/* renamed from: com.xiaomi.measite.smack.a */
public class C4331a implements C4330a {
    public static boolean f14773a;
    private SimpleDateFormat f14774b;
    private C4461a f14775c;
    private C4336f f14776d;
    private C4338d f14777e;
    private Writer f14778f;
    private Reader f14779g;
    private C4332f f14780h;
    private C4334l f14781i;

    static {
        f14773a = false;
    }

    public C4331a(C4461a c4461a, Writer writer, Reader reader) {
        this.f14774b = new SimpleDateFormat("hh:mm:ss aaa");
        this.f14775c = null;
        this.f14776d = null;
        this.f14777e = null;
        this.f14775c = c4461a;
        this.f14778f = writer;
        this.f14779g = reader;
        m17756e();
    }

    private void m17756e() {
        Reader c4491a = new C4491a(this.f14779g);
        this.f14780h = new C4333b(this);
        c4491a.m18629a(this.f14780h);
        Writer c4492b = new C4492b(this.f14778f);
        this.f14781i = new C4335c(this);
        c4492b.m18632a(this.f14781i);
        this.f14779g = c4491a;
        this.f14778f = c4492b;
        this.f14776d = new C4337d(this);
        this.f14777e = new C4339e(this);
    }

    public Reader m17757a() {
        return this.f14779g;
    }

    public Reader m17758a(Reader reader) {
        ((C4491a) this.f14779g).m18630b(this.f14780h);
        Reader c4491a = new C4491a(reader);
        c4491a.m18629a(this.f14780h);
        this.f14779g = c4491a;
        return this.f14779g;
    }

    public Writer m17759a(Writer writer) {
        ((C4492b) this.f14778f).m18633b(this.f14781i);
        Writer c4492b = new C4492b(writer);
        c4492b.m18632a(this.f14781i);
        this.f14778f = c4492b;
        return this.f14778f;
    }

    public Writer m17760b() {
        return this.f14778f;
    }

    public C4336f m17761c() {
        return this.f14776d;
    }

    public C4336f m17762d() {
        return null;
    }
}
