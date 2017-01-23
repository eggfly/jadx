package com.igexin.push.core.p175b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.util.C3937p;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.igexin.push.core.b.b */
public class C3795b implements C3741a {
    private static C3795b f12739c;
    C3937p f12740a;
    private Map f12741b;

    private C3795b() {
        this.f12741b = new HashMap();
        this.f12740a = new C3937p();
    }

    public static C3795b m15607a() {
        if (f12739c == null) {
            f12739c = new C3795b();
        }
        return f12739c;
    }

    public void m15608a(SQLiteDatabase sQLiteDatabase) {
    }

    public void m15609b(SQLiteDatabase sQLiteDatabase) {
    }

    public void m15610c(SQLiteDatabase sQLiteDatabase) {
    }
}
