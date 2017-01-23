package com.antutu.benchmark.p041d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.utils.MLog;
import com.igexin.download.Downloads;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.antutu.benchmark.d.c */
public class C1376c {
    static String f4677a;
    static int f4678b;
    static Map<Class<? extends C1374b>, C1374b> f4679c;
    static String[] f4680d;
    private static Context f4681e;

    /* renamed from: com.antutu.benchmark.d.c.a */
    public static class C1375a extends SQLiteOpenHelper {
        private static C1375a f4674a;
        private SQLiteDatabase f4675b;
        private final ReentrantLock f4676c;

        private C1375a(Context context) {
            super(context, C1376c.f4677a, null, C1376c.f4678b);
            this.f4676c = new ReentrantLock();
        }

        private ContentValues m5448a(String str, String str2, String str3, String str4, String str5, int i, int i2, long j) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_id", str);
            contentValues.put(Downloads.COLUMN_TITLE, str2);
            contentValues.put("summary", str3);
            contentValues.put("content", str4);
            contentValues.put("url", str5);
            contentValues.put("is_html", Integer.valueOf(i));
            contentValues.put("is_read", Integer.valueOf(i2));
            contentValues.put(C4233j.f14377D, Long.valueOf(j));
            return contentValues;
        }

        public static C1375a m5449a(Context context) {
            if (context == null) {
                context = ABenchmarkApplication.getContext();
            }
            if (f4674a == null) {
                f4674a = new C1375a(context);
            }
            return f4674a;
        }

        private void m5450a(SQLiteDatabase sQLiteDatabase) {
            MLog.m6871i(BuildConfig.FLAVOR, "hzd, pushMessageForNewVersion");
            Context context = ABenchmarkApplication.getContext();
            ContentValues a = m5448a("r2342734972389478237ce", context.getString(C1082R.string.update_title), context.getString(C1082R.string.update_summary), context.getString(C1082R.string.update_content), BuildConfig.FLAVOR, 0, 0, System.currentTimeMillis());
            ContentValues a2 = m5448a("r2342734972389478237ed", context.getString(C1082R.string.faq_title), context.getString(C1082R.string.faq_summary), context.getString(C1082R.string.faq_content), BuildConfig.FLAVOR, 0, 0, System.currentTimeMillis());
            this.f4676c.lock();
            try {
                C1374b c1374b = (C1374b) C1376c.f4679c.get(C1379e.class);
                sQLiteDatabase.insertWithOnConflict(c1374b.f4671a, null, a2, 5);
                sQLiteDatabase.insertWithOnConflict(c1374b.f4671a, null, a, 5);
                Message obtain = Message.obtain();
                obtain.what = 5;
                obtain.obj = null;
                MainActivity.m5138a(obtain);
            } finally {
                this.f4676c.unlock();
            }
        }

        public long m5451a(Class<? extends C1374b> cls, List<ContentValues> list, int i) {
            this.f4676c.lock();
            long j = 0;
            try {
                this.f4675b = getWritableDatabase();
                this.f4675b.beginTransaction();
                C1374b c1374b = (C1374b) C1376c.f4679c.get(cls);
                for (ContentValues insertWithOnConflict : list) {
                    j = this.f4675b.insertWithOnConflict(c1374b.f4671a, null, insertWithOnConflict, i);
                }
                this.f4675b.setTransactionSuccessful();
                return j;
            } catch (Exception e) {
                long j2 = 0;
                return j2;
            } finally {
                this.f4675b.endTransaction();
                this.f4676c.unlock();
            }
        }

        public Cursor m5452a(Class<? extends C1374b> cls, String[] strArr, String str, String[] strArr2, String str2) {
            this.f4676c.lock();
            try {
                this.f4675b = getReadableDatabase();
                Cursor query = this.f4675b.query(((C1374b) C1376c.f4679c.get(cls)).f4671a, strArr, str, strArr2, null, null, str2);
                return query;
            } finally {
                this.f4676c.unlock();
            }
        }

        public void m5453a(Class<? extends C1374b> cls, String str, String[] strArr) {
            this.f4676c.lock();
            try {
                this.f4675b = getWritableDatabase();
                this.f4675b.delete(((C1374b) C1376c.f4679c.get(cls)).f4671a, str, strArr);
            } finally {
                this.f4676c.unlock();
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MLog.m6871i("DatabaseProvider", "-------create table ");
            for (Entry value : C1376c.f4679c.entrySet()) {
                sQLiteDatabase.execSQL(((C1374b) value.getValue()).m5447a());
            }
            m5450a(sQLiteDatabase);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            MLog.m6871i("DatabaseProvider", "DOWNGRADEING");
            for (String str : C1376c.f4680d) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            C1376c.f4681e.getSharedPreferences("MY_PREF", 0).edit().putBoolean("isDowngradeDatabase", true).commit();
            onCreate(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            MLog.m6871i("BaseAdapter", "hzd, onUpgrade...");
            for (String str : C1376c.f4680d) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            C1376c.f4681e.getSharedPreferences("MY_PREF", 0).edit().putBoolean("isUpgradeDatabase", true).commit();
            onCreate(sQLiteDatabase);
        }
    }

    static {
        f4677a = "antutu.db";
        f4678b = 13;
        f4679c = new HashMap();
        f4680d = new String[]{"account", "tempinfo", "medal", "temp"};
        f4679c.put(C1379e.class, C1379e.m5457b());
        f4679c.put(C1380f.class, C1380f.m5459b());
    }

    public C1376c(Context context) {
        f4681e = context;
    }
}
