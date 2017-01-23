package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.h */
public class C2891h {
    private static final String f9789a;
    private static final Object f9790c;
    private static C2891h f9791d;
    private final C2890a f9792b;

    /* renamed from: com.google.android.gms.ads.internal.purchase.h.a */
    public class C2890a extends SQLiteOpenHelper {
        final /* synthetic */ C2891h f9788a;

        public C2890a(C2891h c2891h, Context context, String str) {
            this.f9788a = c2891h;
            super(context, str, null, 4);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(C2891h.f9789a);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            C2972b.m11581c("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    static {
        f9789a = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
        f9790c = new Object();
    }

    C2891h(Context context) {
        this.f9792b = new C2890a(this, context, "google_inapp_purchase.db");
    }

    public static C2891h m11244a(Context context) {
        C2891h c2891h;
        synchronized (f9790c) {
            if (f9791d == null) {
                f9791d = new C2891h(context);
            }
            c2891h = f9791d;
        }
        return c2891h;
    }

    public SQLiteDatabase m11246a() {
        try {
            return this.f9792b.getWritableDatabase();
        } catch (SQLiteException e) {
            C2972b.m11583d("Error opening writable conversion tracking database");
            return null;
        }
    }

    public C2887f m11247a(Cursor cursor) {
        return cursor == null ? null : new C2887f(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public List<C2887f> m11248a(long j) {
        SQLiteException e;
        Throwable th;
        synchronized (f9790c) {
            List<C2887f> linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase a = m11246a();
            if (a == null) {
                return linkedList;
            }
            Cursor query;
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                try {
                    if (query.moveToFirst()) {
                        do {
                            linkedList.add(m11247a(query));
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        C2972b.m11583d("Error extracing purchase info: " + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                C2972b.m11583d("Error extracing purchase info: " + e.getMessage());
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            return linkedList;
        }
    }

    public void m11249a(C2887f c2887f) {
        if (c2887f != null) {
            synchronized (f9790c) {
                SQLiteDatabase a = m11246a();
                if (a == null) {
                    return;
                }
                a.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[]{"purchase_id", Long.valueOf(c2887f.f9778a)}), null);
            }
        }
    }

    public int m11250b() {
        Cursor cursor = null;
        int i = 0;
        synchronized (f9790c) {
            SQLiteDatabase a = m11246a();
            if (a == null) {
            } else {
                try {
                    cursor = a.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    C2972b.m11583d("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    public void m11251b(C2887f c2887f) {
        if (c2887f != null) {
            synchronized (f9790c) {
                SQLiteDatabase a = m11246a();
                if (a == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("product_id", c2887f.f9780c);
                contentValues.put("developer_payload", c2887f.f9779b);
                contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                c2887f.f9778a = a.insert("InAppPurchase", null, contentValues);
                if (((long) m11250b()) > 20000) {
                    m11252c();
                }
            }
        }
    }

    public void m11252c() {
        SQLiteException e;
        synchronized (f9790c) {
            SQLiteDatabase a = m11246a();
            if (a == null) {
                return;
            }
            Cursor query;
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", MessageService.MSG_DB_NOTIFY_REACHED);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            m11249a(m11247a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            C2972b.m11583d("Error remove oldest record" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                C2972b.m11583d("Error remove oldest record" + e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        }
    }
}
