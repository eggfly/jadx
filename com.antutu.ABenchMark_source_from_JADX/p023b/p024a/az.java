package p023b.p024a;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: b.a.az */
class az extends SQLiteOpenHelper {
    private static Context f2728b;
    private String f2729a;

    /* renamed from: b.a.az.a */
    private static class C0840a {
        private static final az f2727a;

        static {
            f2727a = new az(br.m3618a(az.f2728b), "cc.db", null, 1, null);
        }
    }

    private az(Context context, String str, CursorFactory cursorFactory, int i) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            str = "cc.db";
        }
        super(context, str, cursorFactory, i);
        m3473b();
    }

    private az(Context context, String str, String str2, CursorFactory cursorFactory, int i) {
        this(new cc(context, str), str2, cursorFactory, i);
    }

    public static synchronized az m3471a(Context context) {
        az a;
        synchronized (az.class) {
            f2728b = context;
            a = C0840a.f2727a;
        }
        return a;
    }

    private boolean m3472a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2729a = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
            sQLiteDatabase.execSQL(this.f2729a);
            return true;
        } catch (SQLException e) {
            ap.m3391d("create reference table error!");
            return false;
        }
    }

    private void m3473b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!(m3476a("aggregated", writableDatabase) && m3476a("aggregated_cache", writableDatabase))) {
                m3475c(writableDatabase);
            }
            if (!m3476a("system", writableDatabase)) {
                m3474b(writableDatabase);
            }
            if (!m3476a("limitedck", writableDatabase)) {
                m3472a(writableDatabase);
            }
        } catch (Exception e) {
        }
    }

    private boolean m3474b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2729a = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
            sQLiteDatabase.execSQL(this.f2729a);
            return true;
        } catch (SQLException e) {
            ap.m3391d("create system table error!");
            return false;
        }
    }

    private boolean m3475c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2729a = "create table if not exists aggregated_cache(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f2729a);
            this.f2729a = "create table if not exists aggregated(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f2729a);
            return true;
        } catch (SQLException e) {
            ap.m3391d("create aggregated table error!");
            return false;
        }
    }

    public boolean m3476a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        boolean z = false;
        if (str != null) {
            try {
                cursor = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type ='table' and name ='" + str.trim() + "' ", null);
                if (cursor.moveToNext() && cursor.getInt(0) > 0) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return z;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            m3475c(sQLiteDatabase);
            m3474b(sQLiteDatabase);
            m3472a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
