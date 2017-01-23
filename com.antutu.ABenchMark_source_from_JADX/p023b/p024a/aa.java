package p023b.p024a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: b.a.aa */
public class aa {
    private static aa f2514c;
    private static SQLiteOpenHelper f2515d;
    private AtomicInteger f2516a;
    private AtomicInteger f2517b;
    private SQLiteDatabase f2518e;

    public aa() {
        this.f2516a = new AtomicInteger();
        this.f2517b = new AtomicInteger();
    }

    public static synchronized aa m3074a(Context context) {
        aa aaVar;
        synchronized (aa.class) {
            if (f2514c == null) {
                aa.m3075b(context);
            }
            aaVar = f2514c;
        }
        return aaVar;
    }

    private static synchronized void m3075b(Context context) {
        synchronized (aa.class) {
            if (f2514c == null) {
                f2514c = new aa();
                f2515d = az.m3471a(context);
            }
        }
    }

    public synchronized SQLiteDatabase m3076a() {
        if (this.f2516a.incrementAndGet() == 1) {
            this.f2518e = f2515d.getReadableDatabase();
        }
        return this.f2518e;
    }

    public synchronized SQLiteDatabase m3077b() {
        if (this.f2516a.incrementAndGet() == 1) {
            this.f2518e = f2515d.getWritableDatabase();
        }
        return this.f2518e;
    }

    public synchronized void m3078c() {
        if (this.f2516a.decrementAndGet() == 0) {
            this.f2518e.close();
        }
        if (this.f2517b.decrementAndGet() == 0) {
            this.f2518e.close();
        }
    }
}
