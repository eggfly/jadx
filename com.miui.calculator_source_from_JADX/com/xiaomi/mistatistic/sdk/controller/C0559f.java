package com.xiaomi.mistatistic.sdk.controller;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.C0520a;
import com.xiaomi.mistatistic.sdk.C0520a.C0521a;
import com.xiaomi.mistatistic.sdk.MiStatInterface;
import com.xiaomi.mistatistic.sdk.data.StatEventPojo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.f */
public class C0559f {
    public static String f4727a;
    public static boolean f4728b;
    private static C0567i f4729c;
    private C0520a f4730d;
    private boolean f4731e;
    private ServiceConnection f4732f;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.f.1 */
    class C05581 implements ServiceConnection {
        final /* synthetic */ C0559f f4726a;

        C05581(C0559f c0559f) {
            this.f4726a = c0559f;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f4726a.f4731e = true;
            this.f4726a.f4730d = C0521a.m6235a(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f4726a.f4731e = false;
            this.f4726a.f4730d = null;
        }
    }

    public C0559f() {
        this.f4730d = null;
        this.f4731e = false;
        this.f4732f = new C05581(this);
    }

    static {
        f4727a = "";
        f4728b = false;
    }

    public static void m6375a() {
        f4729c = new C0567i(C0551c.m6352a());
    }

    private void m6377f() {
        if (!this.f4731e) {
            try {
                Intent intent = new Intent(C0551c.m6352a(), Class.forName(f4727a));
                C0551c.m6352a().startService(intent);
                if (this.f4730d != null) {
                    C0566h.m6419b("unbind service before bind it again!");
                    C0551c.m6352a().unbindService(this.f4732f);
                }
                C0551c.m6352a().bindService(intent, this.f4732f, 1);
            } catch (Throwable e) {
                C0566h.m6418a("ensureServiceBinded", e);
            }
        }
    }

    public StatEventPojo m6378a(String str, String str2) {
        if (!f4728b) {
            return m6383b(str, str2);
        }
        m6377f();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                if (this.f4731e && this.f4730d != null) {
                    StatEventPojo a = this.f4730d.m6233a(str, str2);
                    C0566h.m6419b("process query, result is: " + a);
                    return a;
                }
            } while (System.currentTimeMillis() - currentTimeMillis <= 1000);
            return null;
        } catch (Throwable e) {
            C0566h.m6418a("queryCustomEvent", e);
            return null;
        }
    }

    public StatEventPojo m6383b(String str, String str2) {
        Cursor query;
        StatEventPojo a;
        Throwable e;
        Cursor cursor = null;
        C0566h.m6422b("EventDAO", "queryCustomEvent key: %s, category: %s", str2, str);
        synchronized (f4729c) {
            try {
                query = f4729c.getReadableDatabase().query("mistat_event", null, "category=? AND key=?", new String[]{str, str2}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            a = C0559f.m6374a(query);
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            C0566h.m6416a("EventDAO", "queryCustomEvent exception", e);
                            if (query != null) {
                                query.close();
                            }
                            f4729c.close();
                            return a;
                        } catch (Throwable th) {
                            e = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            f4729c.close();
                            throw e;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                f4729c.close();
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                C0566h.m6416a("EventDAO", "queryCustomEvent exception", e);
                if (query != null) {
                    query.close();
                }
                f4729c.close();
                return a;
            } catch (Throwable th2) {
                e = th2;
                if (cursor != null) {
                    cursor.close();
                }
                f4729c.close();
                throw e;
            }
        }
        return a;
    }

    public void m6381a(StatEventPojo statEventPojo) {
        if (f4728b) {
            try {
                Intent intent = new Intent(C0551c.m6352a(), Class.forName(f4727a));
                intent.putExtra("type", 1);
                intent.putExtra("StatEventPojo", statEventPojo);
                C0551c.m6352a().startService(intent);
                return;
            } catch (Throwable e) {
                C0566h.m6418a("insertNewEvent", e);
                return;
            }
        }
        m6387b(statEventPojo);
    }

    public void m6387b(StatEventPojo statEventPojo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", statEventPojo.f4821a);
        contentValues.put("key", TextUtils.isEmpty(statEventPojo.f4823c) ? "" : statEventPojo.f4823c);
        contentValues.put("ts", Long.valueOf(statEventPojo.f4822b));
        contentValues.put("type", TextUtils.isEmpty(statEventPojo.f4824d) ? "" : statEventPojo.f4824d);
        contentValues.put("value", TextUtils.isEmpty(statEventPojo.f4825e) ? "" : statEventPojo.f4825e);
        contentValues.put("extra", TextUtils.isEmpty(statEventPojo.f4826f) ? "" : statEventPojo.f4826f);
        synchronized (f4729c) {
            try {
                f4729c.getWritableDatabase().insert("mistat_event", "", contentValues);
                f4729c.close();
            } catch (Throwable e) {
                C0566h.m6416a("EventDAO", "Error to insert data into DB, key=" + statEventPojo.f4823c, e);
                f4729c.close();
            } catch (Throwable th) {
                f4729c.close();
            }
        }
    }

    public void m6382a(String str, String str2, String str3) {
        if (f4728b) {
            try {
                Intent intent = new Intent(C0551c.m6352a(), Class.forName(f4727a));
                intent.putExtra("type", 2);
                intent.putExtra("key", str);
                intent.putExtra("category", str2);
                intent.putExtra("newValue", str3);
                C0551c.m6352a().startService(intent);
                return;
            } catch (Throwable e) {
                C0566h.m6418a("updateEventByKeyAndCategory", e);
                return;
            }
        }
        m6388b(str, str2, str3);
    }

    public void m6388b(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", str3);
        synchronized (f4729c) {
            try {
                f4729c.getWritableDatabase().update("mistat_event", contentValues, "category=? AND key=?", new String[]{str2, str});
                f4729c.close();
            } catch (Throwable e) {
                C0566h.m6416a("EventDAO", "Error to update data from DB, key=" + str, e);
                f4729c.close();
            } catch (Throwable th) {
                f4729c.close();
            }
        }
    }

    public List<StatEventPojo> m6379a(long j) {
        if (!f4728b) {
            return m6384b(j);
        }
        m6377f();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                if (this.f4731e && this.f4730d != null) {
                    List<StatEventPojo> a = this.f4730d.m6234a(j);
                    C0566h.m6419b("process getAll, result size is :" + (a == null ? 0 : a.size()));
                    return a;
                }
            } while (System.currentTimeMillis() - currentTimeMillis <= 1000);
            return new ArrayList();
        } catch (Throwable e) {
            C0566h.m6418a("getAllEventOrderByTimestampDescend", e);
            return new ArrayList();
        }
    }

    public List<StatEventPojo> m6384b(long j) {
        Throwable e;
        ArrayList arrayList = new ArrayList();
        synchronized (f4729c) {
            SQLiteDatabase readableDatabase = f4729c.getReadableDatabase();
            if (readableDatabase == null) {
                return arrayList;
            }
            Cursor query;
            Cursor query2;
            try {
                query2 = readableDatabase.query("mistat_event", null, "ts<?", new String[]{String.valueOf(j)}, null, null, "ts DESC", String.valueOf(500));
                if (query2 != null) {
                    try {
                        if (query2.moveToLast()) {
                            long j2 = query2.getLong(query2.getColumnIndex("ts"));
                            query2.close();
                            query = readableDatabase.query("mistat_event", null, "ts<? AND ts>=?", new String[]{String.valueOf(j), String.valueOf(j2)}, null, null, "ts DESC");
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        do {
                                            arrayList.add(C0559f.m6374a(query));
                                        } while (query.moveToNext());
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    try {
                                        C0566h.m6416a("EventDAO", "Error while reading data from DB", e);
                                        query.close();
                                        f4729c.close();
                                        if (query != null) {
                                            C0566h.m6422b("EventDAO", "get %d DB events by timestamp %d", Integer.valueOf(query.getCount()), Long.valueOf(j));
                                        }
                                        return arrayList;
                                    } catch (Throwable th) {
                                        e = th;
                                        query2 = query;
                                        query2.close();
                                        f4729c.close();
                                        throw e;
                                    }
                                }
                            }
                            query.close();
                            f4729c.close();
                            if (query != null) {
                                C0566h.m6422b("EventDAO", "get %d DB events by timestamp %d", Integer.valueOf(query.getCount()), Long.valueOf(j));
                            }
                            return arrayList;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        query = query2;
                        C0566h.m6416a("EventDAO", "Error while reading data from DB", e);
                        query.close();
                        f4729c.close();
                        if (query != null) {
                            C0566h.m6422b("EventDAO", "get %d DB events by timestamp %d", Integer.valueOf(query.getCount()), Long.valueOf(j));
                        }
                        return arrayList;
                    } catch (Throwable th2) {
                        e = th2;
                        query2.close();
                        f4729c.close();
                        throw e;
                    }
                }
                query = query2;
                if (query != null) {
                    if (query.moveToFirst()) {
                        do {
                            arrayList.add(C0559f.m6374a(query));
                        } while (query.moveToNext());
                    }
                }
                query.close();
                f4729c.close();
            } catch (SQLiteException e4) {
                e = e4;
                query = null;
                C0566h.m6416a("EventDAO", "Error while reading data from DB", e);
                query.close();
                f4729c.close();
                if (query != null) {
                    C0566h.m6422b("EventDAO", "get %d DB events by timestamp %d", Integer.valueOf(query.getCount()), Long.valueOf(j));
                }
                return arrayList;
            } catch (Throwable th3) {
                e = th3;
                query2 = null;
                query2.close();
                f4729c.close();
                throw e;
            }
            if (query != null) {
                C0566h.m6422b("EventDAO", "get %d DB events by timestamp %d", Integer.valueOf(query.getCount()), Long.valueOf(j));
            }
            return arrayList;
        }
    }

    public void m6385b() {
        if (f4728b) {
            try {
                Intent intent = new Intent(C0551c.m6352a(), Class.forName(f4727a));
                intent.putExtra("type", 3);
                C0551c.m6352a().startService(intent);
                return;
            } catch (Throwable e) {
                C0566h.m6418a("deleteOldEvents", e);
                return;
            }
        }
        m6389c();
    }

    public void m6389c() {
        long currentTimeMillis = System.currentTimeMillis() - 259200000;
        synchronized (f4729c) {
            try {
                int delete = f4729c.getWritableDatabase().delete("mistat_event", "ts<=? and category <> ?", new String[]{String.valueOf(currentTimeMillis), "mistat_basic"});
                if (delete > 0) {
                    MiStatInterface.m6265a("quality_monitor", "delete_old_events", (long) delete);
                }
                f4729c.close();
            } catch (Throwable e) {
                C0566h.m6416a("EventDAO", "Error while deleting out-of-date data from DB", e);
                f4729c.close();
            } catch (Throwable th) {
                f4729c.close();
            }
        }
    }

    public int m6391d() {
        if (!f4728b) {
            return m6393e();
        }
        m6377f();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                if (this.f4731e && this.f4730d != null) {
                    int a = this.f4730d.m6232a();
                    C0566h.m6419b("process getCount , result is:" + a);
                    return a;
                }
            } while (System.currentTimeMillis() - currentTimeMillis <= 1000);
            return 0;
        } catch (Throwable e) {
            C0566h.m6418a("getEventCount", e);
            return 0;
        }
    }

    public int m6393e() {
        Throwable e;
        Cursor cursor = null;
        synchronized (f4729c) {
            Cursor query;
            try {
                query = f4729c.getReadableDatabase().query("mistat_event", new String[]{"count(*)"}, null, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            int i = query.getInt(0);
                            if (query != null) {
                                query.close();
                            }
                            f4729c.close();
                            return i;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            C0566h.m6416a("EventDAO", "Error while getting count from DB", e);
                            if (query != null) {
                                query.close();
                            }
                            f4729c.close();
                            return 0;
                        } catch (Throwable th) {
                            e = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            f4729c.close();
                            throw e;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                f4729c.close();
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                C0566h.m6416a("EventDAO", "Error while getting count from DB", e);
                if (query != null) {
                    query.close();
                }
                f4729c.close();
                return 0;
            } catch (Throwable th2) {
                e = th2;
                if (cursor != null) {
                    cursor.close();
                }
                f4729c.close();
                throw e;
            }
            return 0;
        }
    }

    public static StatEventPojo m6374a(Cursor cursor) {
        StatEventPojo statEventPojo = new StatEventPojo();
        long j = cursor.getLong(2);
        String string = cursor.getString(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(1);
        String string4 = cursor.getString(3);
        String string5 = cursor.getString(6);
        statEventPojo.f4821a = string3;
        statEventPojo.f4823c = string4;
        statEventPojo.f4825e = string;
        statEventPojo.f4822b = j;
        statEventPojo.f4824d = string2;
        statEventPojo.f4826f = string5;
        return statEventPojo;
    }

    public void m6390c(long j) {
        if (f4728b) {
            try {
                Intent intent = new Intent(C0551c.m6352a(), Class.forName(f4727a));
                intent.putExtra("type", 4);
                intent.putExtra("timeStamp", j);
                C0551c.m6352a().startService(intent);
                return;
            } catch (Throwable e) {
                C0566h.m6418a("deleteEventsByTS", e);
                return;
            }
        }
        m6392d(j);
    }

    public void m6392d(long j) {
        synchronized (f4729c) {
            try {
                C0566h.m6422b("EventDAO", "deleteEventsByTS, ts:%d", Long.valueOf(j));
                f4729c.getWritableDatabase().delete("mistat_event", "ts<=?", new String[]{String.valueOf(j)});
                f4729c.close();
            } catch (Throwable e) {
                C0566h.m6416a("EventDAO", "Error while deleting event by ts from DB", e);
                f4729c.close();
            } catch (Throwable th) {
                f4729c.close();
            }
        }
    }

    public void m6380a(long j, long j2) {
        if (f4728b) {
            try {
                Intent intent = new Intent(C0551c.m6352a(), Class.forName(f4727a));
                intent.putExtra("type", 5);
                intent.putExtra("startTime", j);
                intent.putExtra("endTime", j2);
                C0551c.m6352a().startService(intent);
                return;
            } catch (Throwable e) {
                C0566h.m6418a("deleteEventsByStartAndEndTS", e);
                return;
            }
        }
        m6386b(j, j2);
    }

    public void m6386b(long j, long j2) {
        synchronized (f4729c) {
            try {
                C0566h.m6422b("EventDAO", "deleteEventsByStartAndEndTS, start:%d, end:%d", Long.valueOf(j), Long.valueOf(j2));
                f4729c.getWritableDatabase().delete("mistat_event", "ts<=? AND ts>=?", new String[]{String.valueOf(j2), String.valueOf(j)});
                f4729c.close();
            } catch (Throwable e) {
                C0566h.m6416a("EventDAO", "Error while deleting event by ts from DB", e);
                f4729c.close();
            } catch (Throwable th) {
                f4729c.close();
            }
        }
    }
}
