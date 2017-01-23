package p023b.p024a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p023b.p024a.C0909w.C0897d;
import p023b.p024a.C0909w.C0898e;

/* renamed from: b.a.a */
public class C0773a {
    private static ContentValues m3058a(cf cfVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", cfVar.m3662a());
        contentValues.put("label", cfVar.m3672c());
        contentValues.put("count", Long.valueOf(cfVar.m3677g()));
        contentValues.put("value", Long.valueOf(cfVar.m3676f()));
        contentValues.put("totalTimestamp", Long.valueOf(cfVar.m3675e()));
        contentValues.put("timeWindowNum", cfVar.m3678h());
        return contentValues;
    }

    public static String m3059a(SQLiteDatabase sQLiteDatabase) {
        String valueOf;
        Cursor rawQuery;
        Object obj;
        SQLException sQLException;
        SQLException sQLException2;
        Throwable th;
        Cursor cursor = null;
        try {
            sQLiteDatabase.beginTransaction();
            if (C0773a.m3069b(sQLiteDatabase, "aggregated_cache") <= 0) {
                valueOf = String.valueOf(0);
                if (cursor != null) {
                    cursor.close();
                }
                sQLiteDatabase.endTransaction();
            } else {
                rawQuery = sQLiteDatabase.rawQuery("select * from aggregated_cache", null);
                try {
                    if (rawQuery.moveToLast()) {
                        valueOf = rawQuery.getString(rawQuery.getColumnIndex("timeWindowNum"));
                    } else {
                        obj = cursor;
                    }
                } catch (SQLException e) {
                    sQLException = e;
                    obj = cursor;
                    sQLException2 = sQLException;
                    try {
                        ap.m3391d("queryLastTimeWindowNumFromCache error " + sQLException2.toString());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        sQLiteDatabase.endTransaction();
                        return valueOf;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        sQLiteDatabase.endTransaction();
                        throw th;
                    }
                }
                try {
                    sQLiteDatabase.setTransactionSuccessful();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    sQLiteDatabase.endTransaction();
                } catch (SQLException e2) {
                    sQLException2 = e2;
                    ap.m3391d("queryLastTimeWindowNumFromCache error " + sQLException2.toString());
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    sQLiteDatabase.endTransaction();
                    return valueOf;
                }
            }
        } catch (SQLException e3) {
            rawQuery = cursor;
            sQLException = e3;
            valueOf = cursor;
            sQLException2 = sQLException;
            ap.m3391d("queryLastTimeWindowNumFromCache error " + sQLException2.toString());
            if (rawQuery != null) {
                rawQuery.close();
            }
            sQLiteDatabase.endTransaction();
            return valueOf;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = cursor;
            if (rawQuery != null) {
                rawQuery.close();
            }
            sQLiteDatabase.endTransaction();
            throw th;
        }
        return valueOf;
    }

    public static Map<String, List<C0898e>> m3060a(cd cdVar, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        SQLException e;
        Throwable th;
        try {
            Cursor cursor;
            Map<String, List<C0898e>> hashMap = new HashMap();
            if (C0773a.m3069b(sQLiteDatabase, "system") > 0) {
                rawQuery = sQLiteDatabase.rawQuery("select * from system", null);
                while (rawQuery.moveToNext()) {
                    List list;
                    String string = rawQuery.getString(rawQuery.getColumnIndex("key"));
                    if (hashMap.containsKey(string)) {
                        list = (List) hashMap.get(string);
                        hashMap.remove(string);
                    } else {
                        try {
                            list = new ArrayList();
                        } catch (SQLException e2) {
                            e = e2;
                        }
                    }
                    C0898e c0898e = new C0898e();
                    c0898e.f3001b = rawQuery.getLong(rawQuery.getColumnIndex("timeStamp"));
                    c0898e.f3000a = (int) rawQuery.getLong(rawQuery.getColumnIndex("count"));
                    list.add(c0898e);
                    hashMap.put(string, list);
                }
                cursor = rawQuery;
            } else {
                cursor = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (SQLException e3) {
            e = e3;
            rawQuery = null;
            try {
                cdVar.m3414a("faild", false);
                ap.m3391d("readAllSystemDataForUpload error " + e.toString());
                if (rawQuery == null) {
                    return null;
                }
                rawQuery.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public static void m3061a(SQLiteDatabase sQLiteDatabase, String str, long j, long j2) {
        try {
            int b = C0773a.m3069b(sQLiteDatabase, "system");
            int c = cj.m3741a().m3748c();
            ContentValues contentValues;
            if (b < c) {
                contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put("timeStamp", Long.valueOf(j2));
                contentValues.put("count", Long.valueOf(j));
                sQLiteDatabase.insert("system", null, contentValues);
            } else if (b == c) {
                contentValues = new ContentValues();
                contentValues.put("key", C4156a.f13959u);
                contentValues.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("count", Integer.valueOf(1));
                sQLiteDatabase.insert("system", null, contentValues);
            } else {
                C0773a.m3073c(sQLiteDatabase, C4156a.f13959u);
            }
        } catch (SQLException e) {
        }
    }

    public static void m3062a(SQLiteDatabase sQLiteDatabase, Map<String, cg> map, cd cdVar) {
        int i = 0;
        Cursor cursor = null;
        try {
            cg cgVar = (cg) map.get(C4156a.f13956r);
            if (cgVar != null) {
                String str = "system where key=\"__ag_of\"";
                cursor = sQLiteDatabase.rawQuery("select * from " + str, null);
                cursor.moveToFirst();
                long j = 0;
                while (!cursor.isAfterLast()) {
                    if (cursor.getCount() > 0) {
                        i = cursor.getInt(cursor.getColumnIndex("count"));
                        j = cursor.getLong(cursor.getColumnIndex("timeStamp"));
                        sQLiteDatabase.execSQL("delete from " + str);
                    }
                    cursor.moveToNext();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", cgVar.m3680b());
                contentValues.put("count", Long.valueOf(i == 0 ? cgVar.m3682d() : ((long) i) + cgVar.m3682d()));
                String str2 = "timeStamp";
                if (j == 0) {
                    j = cgVar.m3681c();
                }
                contentValues.put(str2, Long.valueOf(j));
                sQLiteDatabase.insert("system", null, contentValues);
                cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLException e) {
            ap.m3391d("save to system table error " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static void m3063a(SQLiteDatabase sQLiteDatabase, boolean z, cd cdVar) {
        C0773a.m3066a(sQLiteDatabase, "system");
        C0773a.m3066a(sQLiteDatabase, "aggregated");
        if (!z) {
            C0773a.m3066a(sQLiteDatabase, "limitedck");
            cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
        }
    }

    public static void m3064a(cd cdVar, SQLiteDatabase sQLiteDatabase, List<String> list) {
        try {
            sQLiteDatabase.beginTransaction();
            if (C0773a.m3069b(sQLiteDatabase, "limitedck") > 0) {
                C0773a.m3066a(sQLiteDatabase, "limitedck");
            }
            for (String str : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ck", str);
                sQLiteDatabase.insert("limitedck", null, contentValues);
            }
            sQLiteDatabase.setTransactionSuccessful();
            cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
        } catch (SQLException e) {
            ap.m3391d("insertToLimitCKTable error " + e.toString());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean m3065a(SQLiteDatabase sQLiteDatabase, cd cdVar) {
        try {
            sQLiteDatabase.beginTransaction();
            if (C0773a.m3069b(sQLiteDatabase, "aggregated_cache") <= 0) {
                cdVar.m3414a("faild", false);
                return false;
            }
            sQLiteDatabase.execSQL("insert into aggregated(key, count, value, totalTimestamp, timeWindowNum, label) select key, count, value, totalTimestamp, timeWindowNum, label from aggregated_cache");
            sQLiteDatabase.setTransactionSuccessful();
            C0773a.m3066a(sQLiteDatabase, "aggregated_cache");
            cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            cdVar.m3414a(Boolean.valueOf(false), false);
            ap.m3391d("cacheToAggregatedTable happen " + e.toString());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean m3066a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            if (C0773a.m3069b(sQLiteDatabase, str) >= 0) {
                sQLiteDatabase.execSQL("delete from " + str);
            }
            return true;
        } catch (SQLException e) {
            ap.m3391d("cleanTableData faild!" + e.toString());
            return false;
        }
    }

    public static boolean m3067a(android.database.sqlite.SQLiteDatabase r4, java.util.Collection<p023b.p024a.cf> r5) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:20:? in {3, 8, 15, 17, 18, 19, 22, 23} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r4.beginTransaction();	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r0 = "aggregated_cache";	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r0 = p023b.p024a.C0773a.m3069b(r4, r0);	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        if (r0 <= 0) goto L_0x0010;	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
    L_0x000b:
        r0 = "aggregated_cache";	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        p023b.p024a.C0773a.m3066a(r4, r0);	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
    L_0x0010:
        r1 = r5.iterator();	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
    L_0x0014:
        r0 = r1.hasNext();	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        if (r0 == 0) goto L_0x0036;	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
    L_0x001a:
        r0 = r1.next();	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r0 = (p023b.p024a.cf) r0;	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r0 = p023b.p024a.C0773a.m3058a(r0);	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r2 = "aggregated_cache";	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r3 = 0;	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r4.insert(r2, r3, r0);	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        goto L_0x0014;
    L_0x002b:
        r0 = move-exception;
        r0 = "insert to Aggregated cache table faild!";	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        p023b.p024a.ap.m3391d(r0);	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r0 = 0;
        r4.endTransaction();
    L_0x0035:
        return r0;
    L_0x0036:
        r4.setTransactionSuccessful();	 Catch:{ SQLException -> 0x002b, all -> 0x003e }
        r4.endTransaction();
        r0 = 1;
        goto L_0x0035;
    L_0x003e:
        r0 = move-exception;
        r4.endTransaction();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a(android.database.sqlite.SQLiteDatabase, java.util.Collection):boolean");
    }

    public static boolean m3068a(cd cdVar, SQLiteDatabase sQLiteDatabase, Collection<cf> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            for (cf a : collection) {
                sQLiteDatabase.insert("aggregated", null, C0773a.m3058a(a));
            }
            sQLiteDatabase.setTransactionSuccessful();
            C0773a.m3066a(sQLiteDatabase, "aggregated_cache");
            cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
            return true;
        } catch (SQLException e) {
            ap.m3391d("insert to Aggregated cache table faild!");
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static int m3069b(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from " + str, null);
            i = cursor.getCount();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ap.m3391d("count error " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public static Map<String, List<C0897d>> m3070b(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        SQLException e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            if (C0773a.m3069b(sQLiteDatabase, "aggregated") > 0) {
                rawQuery = sQLiteDatabase.rawQuery("select * from aggregated", null);
                try {
                    Map<String, List<C0897d>> hashMap = new HashMap();
                    while (rawQuery.moveToNext()) {
                        List list;
                        String string = rawQuery.getString(rawQuery.getColumnIndex("key"));
                        if (hashMap.containsKey(string)) {
                            list = (List) hashMap.get(string);
                            hashMap.remove(string);
                        } else {
                            list = new ArrayList();
                        }
                        C0897d c0897d = new C0897d();
                        c0897d.f2999e = br.m3620a(rawQuery.getString(rawQuery.getColumnIndex("label")));
                        c0897d.f2995a = rawQuery.getLong(rawQuery.getColumnIndex("value"));
                        c0897d.f2996b = rawQuery.getLong(rawQuery.getColumnIndex("totalTimestamp"));
                        c0897d.f2997c = Integer.parseInt(rawQuery.getString(rawQuery.getColumnIndex("timeWindowNum")));
                        c0897d.f2998d = (int) rawQuery.getLong(rawQuery.getColumnIndex("count"));
                        list.add(c0897d);
                        hashMap.put(string, list);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return hashMap;
                } catch (SQLException e2) {
                    e = e2;
                    cursor = rawQuery;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                if (cursor2 != null) {
                    cursor2.close();
                }
                return cursor2;
            }
        } catch (SQLException e3) {
            e = e3;
            cursor = cursor2;
            try {
                ap.m3391d("readAllAggregatedDataForUpload error " + e.toString());
                if (cursor != null) {
                    cursor.close();
                }
                return cursor2;
            } catch (Throwable th3) {
                th = th3;
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            rawQuery = cursor2;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public static boolean m3071b(SQLiteDatabase sQLiteDatabase, cd cdVar) {
        Cursor cursor = null;
        try {
            Map hashMap = new HashMap();
            cursor = sQLiteDatabase.rawQuery("select * from aggregated_cache", null);
            while (cursor.moveToNext()) {
                cf cfVar = new cf();
                cfVar.m3667a(br.m3620a(cursor.getString(cursor.getColumnIndex("key"))));
                cfVar.m3671b(br.m3620a(cursor.getString(cursor.getColumnIndex("label"))));
                cfVar.m3673c((long) cursor.getInt(cursor.getColumnIndex("count")));
                cfVar.m3669b((long) cursor.getInt(cursor.getColumnIndex("value")));
                cfVar.m3670b(cursor.getString(cursor.getColumnIndex("timeWindowNum")));
                cfVar.m3663a(Long.parseLong(cursor.getString(cursor.getColumnIndex("totalTimestamp"))));
                hashMap.put(br.m3620a(cursor.getString(cursor.getColumnIndex("key"))), cfVar);
            }
            if (hashMap.size() > 0) {
                cdVar.m3414a(hashMap, false);
            } else {
                cdVar.m3414a("faild", false);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLException e) {
            cdVar.m3414a(Boolean.valueOf(false), false);
            ap.m3391d("cacheToMemory happen " + e.toString());
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return false;
    }

    public static List<String> m3072c(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        SQLException e;
        Throwable th;
        Cursor cursor = null;
        try {
            if (C0773a.m3069b(sQLiteDatabase, "limitedck") > 0) {
                rawQuery = sQLiteDatabase.rawQuery("select * from limitedck", null);
                try {
                    List<String> arrayList = new ArrayList();
                    while (rawQuery.moveToNext()) {
                        arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("ck")));
                    }
                    if (rawQuery == null) {
                        return arrayList;
                    }
                    rawQuery.close();
                    return arrayList;
                } catch (SQLException e2) {
                    e = e2;
                    try {
                        ap.m3391d("loadLimitCKFromDB error " + e.toString());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return cursor;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return cursor;
        } catch (SQLException e3) {
            e = e3;
            rawQuery = cursor;
            ap.m3391d("loadLimitCKFromDB error " + e.toString());
            if (rawQuery != null) {
                rawQuery.close();
            }
            return cursor;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = cursor;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    private static void m3073c(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("update system set count=count+1 where key like '" + str + "'");
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }
}
