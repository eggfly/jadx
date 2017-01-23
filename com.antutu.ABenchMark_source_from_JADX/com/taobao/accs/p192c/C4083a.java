package com.taobao.accs.p192c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.antutu.utils.ACPManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.ut.monitor.TrafficsMonitor.C4129a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.taobao.accs.c.a */
public class C4083a extends SQLiteOpenHelper {
    private static volatile C4083a f13600c;
    private static final Lock f13601e;
    public int f13602a;
    LinkedList<C4082a> f13603b;
    private Context f13604d;

    /* renamed from: com.taobao.accs.c.a.a */
    private class C4082a {
        String f13597a;
        Object[] f13598b;
        final /* synthetic */ C4083a f13599c;

        private C4082a(C4083a c4083a, String str, Object[] objArr) {
            this.f13599c = c4083a;
            this.f13597a = str;
            this.f13598b = objArr;
        }
    }

    static {
        f13600c = null;
        f13601e = new ReentrantLock();
    }

    private C4083a(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f13602a = 0;
        this.f13603b = new LinkedList();
        this.f13604d = context;
    }

    public static C4083a m16655a(Context context) {
        if (f13600c == null) {
            synchronized (C4083a.class) {
                if (f13600c == null) {
                    f13600c = new C4083a(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return f13600c;
    }

    private synchronized void m16656a(String str, Object[] objArr, boolean z) {
        SQLiteDatabase writableDatabase;
        try {
            this.f13603b.add(new C4082a(str, objArr, null));
            if (this.f13603b.size() > 5 || z) {
                writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    while (this.f13603b.size() > 0) {
                        C4082a c4082a = (C4082a) this.f13603b.removeFirst();
                        if (c4082a.f13598b != null) {
                            writableDatabase.execSQL(c4082a.f13597a, c4082a.f13598b);
                        } else {
                            writableDatabase.execSQL(c4082a.f13597a);
                        }
                        if (c4082a.f13597a.contains("INSERT")) {
                            this.f13602a++;
                            if (this.f13602a > 4000) {
                                ALog.m16901d("DBHelper", "db is full!", new Object[0]);
                                onUpgrade(writableDatabase, 0, 1);
                                this.f13602a = 0;
                                break;
                            }
                        }
                    }
                    writableDatabase.close();
                }
            }
        } catch (Exception e) {
            ALog.m16901d("DBHelper", e.toString(), new Object[0]);
        } catch (Throwable th) {
            writableDatabase.close();
        }
    }

    private synchronized boolean m16657a(String str, String str2, boolean z, String str3) {
        boolean z2;
        Cursor query;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                z2 = false;
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                query = writableDatabase.query("traffic", new String[]{C4233j.f14384g, "date", C4103b.ELECTION_KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=? AND host=? AND bid=? AND isbackground=?", new String[]{str3, str, str2, String.valueOf(z)}, null, null, null, String.valueOf(100));
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            z2 = true;
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ALog.m16906w("DBHelper", e.toString(), new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            z2 = false;
                            return z2;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                z2 = false;
            }
        } catch (Exception e3) {
            e = e3;
            query = cursor;
            ALog.m16906w("DBHelper", e.toString(), new Object[0]);
            if (query != null) {
                query.close();
            }
            z2 = false;
            return z2;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return z2;
    }

    public List<C4129a> m16658a(boolean z) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this) {
            Cursor cursor2 = null;
            List<C4129a> arrayList = new ArrayList();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    if (null != null) {
                        cursor2.close();
                    }
                    return null;
                }
                Cursor query;
                if (z) {
                    query = writableDatabase.query("traffic", new String[]{C4233j.f14384g, "date", C4103b.ELECTION_KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.formatDay(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    query = writableDatabase.query("traffic", new String[]{C4233j.f14384g, "date", C4103b.ELECTION_KEY_HOST, "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                }
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                try {
                    if (query.moveToFirst()) {
                        do {
                            String string = query.getString(1);
                            String string2 = query.getString(2);
                            String string3 = query.getString(3);
                            String string4 = query.getString(4);
                            boolean booleanValue = Boolean.valueOf(query.getString(5)).booleanValue();
                            long j = query.getLong(6);
                            if (string4 != null && j > 0) {
                                arrayList.add(new C4129a(string, string4, string3, booleanValue, string2, j));
                                ALog.m16901d("DBHelper", "resotre traffics from db bid:" + string4 + " serviceid:" + string3 + " host:" + string2 + " size:" + j, new Object[0]);
                            }
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        ALog.m16906w("DBHelper", e.toString(), new Object[0]);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                ALog.m16906w("DBHelper", e.toString(), new Object[0]);
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        }
    }

    public void m16659a() {
        m16656a("DELETE FROM traffic", null, true);
    }

    public void m16660a(String str, String str2, String str3, boolean z, long j, String str4) {
        if (m16657a(str, str3, z, str4)) {
            m16656a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j), str4, str, str3, String.valueOf(z)}, true);
            return;
        }
        m16656a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j)}, true);
    }

    public SQLiteDatabase getWritableDatabase() {
        return !C4135a.m16911a(super.getWritableDatabase().getPath(), (int) ACPManager.MAX_BUFFER) ? null : super.getWritableDatabase();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            if (f13601e.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            f13601e.unlock();
        } catch (Throwable th) {
            f13601e.unlock();
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }
}
