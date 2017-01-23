package com.igexin.push.p173b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.p175b.C3741a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.igexin.push.b.a */
public class C3718a extends C3666d {
    private static final String f12534e;
    protected SQLiteDatabase f12535a;
    protected Cursor f12536b;
    List f12537c;
    boolean f12538d;

    static {
        f12534e = C3718a.class.getName();
    }

    public C3718a() {
        super(1);
        this.f12537c = new LinkedList();
    }

    public void m15235a(C3741a c3741a) {
        this.f12537c.add(c3741a);
    }

    public void a_() {
        super.a_();
        this.f12535a = C3854f.m15859a().m15881k().getWritableDatabase();
        this.f12535a.setVersion(3);
        for (C3741a a : this.f12537c) {
            a.m15379a(this.f12535a);
        }
        for (C3741a a2 : this.f12537c) {
            if (this.f12538d) {
                a2.m15381c(this.f12535a);
            } else {
                a2.m15380b(this.f12535a);
            }
        }
        C3685c.m15060b().m15055a((Object) new C3720c(-980948));
        C3685c.m15060b().m15070c();
    }

    public final int m15236b() {
        return -2147483639;
    }

    public void m15237c() {
        super.m14960c();
        if (this.f12536b != null) {
            try {
                this.f12536b.close();
            } catch (Exception e) {
            }
        }
    }

    public void m15238d() {
        super.m14961d();
        this.n = true;
        this.I = true;
    }

    protected void m15239e() {
    }
}
