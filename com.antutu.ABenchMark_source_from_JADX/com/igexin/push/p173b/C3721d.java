package com.igexin.push.p173b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.push.config.C3753l;
import com.igexin.push.core.C3854f;

/* renamed from: com.igexin.push.b.d */
public abstract class C3721d extends C3666d {
    private static final String f12541a;
    protected SQLiteDatabase f12542c;
    protected Cursor f12543d;
    protected ContentValues f12544e;
    public C3720c f12545f;

    static {
        f12541a = C3753l.f12646a;
    }

    public C3721d() {
        super(1);
    }

    public C3721d(ContentValues contentValues) {
        super(1);
        this.f12544e = contentValues;
    }

    public abstract void m15248a();

    public void a_() {
        super.a_();
        this.f12542c = C3854f.m15859a().m15881k().getWritableDatabase();
        m15248a();
        if (this.f12545f != null) {
            C3685c.m15060b().m15055a((Object) this.f12545f);
            C3685c.m15060b().m15070c();
        }
    }

    public final int m15249b() {
        return -2147483640;
    }

    public void m15250c() {
        super.m14960c();
        if (this.f12543d != null && !this.f12543d.isClosed()) {
            try {
                this.f12543d.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m15251d() {
        this.n = true;
        this.I = true;
    }

    protected void m15252e() {
    }
}
