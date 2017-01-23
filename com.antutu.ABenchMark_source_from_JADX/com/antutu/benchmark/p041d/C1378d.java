package com.antutu.benchmark.p041d;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;

/* renamed from: com.antutu.benchmark.d.d */
public class C1378d {
    private static C1378d f4687b;
    public ArrayList<C1377a> f4688a;
    private SQLiteDatabase f4689c;
    private Context f4690d;

    /* renamed from: com.antutu.benchmark.d.d.a */
    public class C1377a {
        public String f4682a;
        public int f4683b;
        public int f4684c;
        public String f4685d;
        final /* synthetic */ C1378d f4686e;

        public C1377a(C1378d c1378d) {
            this.f4686e = c1378d;
        }
    }

    public C1378d(Context context) {
        this.f4690d = context;
        this.f4688a = new ArrayList();
    }

    public static C1378d m5455a(Context context) {
        return f4687b != null ? f4687b : new C1378d(context);
    }

    public ArrayList<C1377a> m5456a() {
        Throwable th;
        Cursor cursor = null;
        Cursor rawQuery;
        try {
            C1373a.m5442a(this.f4690d);
            this.f4689c = C1373a.m5441a().m5446a("devinfo");
            if (this.f4689c == null) {
                ArrayList<C1377a> arrayList = this.f4688a;
                if (cursor == null) {
                    return arrayList;
                }
                cursor.close();
                return arrayList;
            }
            rawQuery = this.f4689c.rawQuery("SELECT * FROM lab_info WHERE core_count >= ?", new String[]{"-1"});
            while (rawQuery.moveToNext()) {
                try {
                    C1377a c1377a = new C1377a(this);
                    c1377a.f4683b = rawQuery.getInt(rawQuery.getColumnIndex("core_count"));
                    c1377a.f4684c = rawQuery.getInt(rawQuery.getColumnIndex("g_sensor"));
                    c1377a.f4682a = rawQuery.getString(rawQuery.getColumnIndex(Constants.KEY_MODEL));
                    c1377a.f4685d = rawQuery.getString(rawQuery.getColumnIndex("heart_sensor"));
                    this.f4688a.add(c1377a);
                } catch (Exception e) {
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    cursor = rawQuery;
                    th = th3;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return this.f4688a;
        } catch (Exception e2) {
            rawQuery = cursor;
            if (rawQuery != null) {
                rawQuery.close();
            }
            return this.f4688a;
        } catch (Throwable th4) {
            th = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
