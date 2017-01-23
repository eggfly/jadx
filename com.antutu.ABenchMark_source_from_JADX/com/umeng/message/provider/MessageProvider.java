package com.umeng.message.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.proguard.C4239k;
import com.umeng.message.provider.C4243a.C4242a;

public class MessageProvider extends ContentProvider {
    private static final String f14446a;
    private static final UriMatcher f14447b;
    private static final int f14448g = 1;
    private static final int f14449h = 2;
    private static final int f14450i = 3;
    private static final int f14451j = 4;
    private static final int f14452k = 5;
    private static final int f14453l = 6;
    private static final int f14454m = 7;
    private static final int f14455n = 8;
    private static final int f14456o = 9;
    private static Context f14457p;
    private C4240a f14458c;
    private SQLiteDatabase f14459d;
    private C4241b f14460e;
    private SQLiteDatabase f14461f;

    /* renamed from: com.umeng.message.provider.MessageProvider.a */
    private class C4240a extends SQLiteOpenHelper {
        final /* synthetic */ MessageProvider f14444a;

        public C4240a(MessageProvider messageProvider, Context context) {
            this.f14444a = messageProvider;
            super(context, C4233j.f14379b, null, MessageProvider.f14449h);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            UmLog.m17136d(MessageProvider.f14446a, "MessageStoreHelper-->onCreate-->start");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
            sQLiteDatabase.execSQL("create table if not exists MsgTemp(tempkey varchar default NULL, tempvalue varchar default NULL,PRIMARY KEY(tempkey))");
            sQLiteDatabase.execSQL("create table if not exists MsgAlias(time long,type varchar default NULL,alias varchar default NULL,exclusive int,error int,message varchar,PRIMARY KEY(time))");
            UmLog.m17136d(MessageProvider.f14446a, "MessageStoreHelper-->onCreate-->end");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onCreate(sQLiteDatabase);
            UmLog.m17136d(MessageProvider.f14446a, "MessageStoreHelper-->onUpgrade");
        }
    }

    /* renamed from: com.umeng.message.provider.MessageProvider.b */
    private class C4241b extends SQLiteOpenHelper {
        final /* synthetic */ MessageProvider f14445a;

        public C4241b(MessageProvider messageProvider, Context context) {
            this.f14445a = messageProvider;
            super(context, C4239k.f14422a, null, MessageProvider.f14451j);
        }

        private boolean m17329a(SQLiteDatabase sQLiteDatabase, String str) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type = 'table' and name = '" + str.trim() + "'", null);
                    if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                        z = true;
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Exception e) {
                }
            }
            return z;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, Time long, PRIMARY KEY(MsgId, MsgStatus))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, PRIMARY KEY(MsgId))");
            boolean a = m17329a(sQLiteDatabase, C4239k.f14428g);
            sQLiteDatabase.execSQL("create table if not exists MsgConfigInfo (SerialNo integer default 1, AppLaunchAt long default 0, UpdateResponse varchar default NULL)");
            if (a) {
                sQLiteDatabase.execSQL("alter table MsgConfigInfo add column UpdateResponse varchar");
            }
            UmLog.m17136d(MessageProvider.f14446a, "MsgLogStoreHelper-->onCreate");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onCreate(sQLiteDatabase);
            UmLog.m17136d(MessageProvider.f14446a, "MsgLogStoreHelper-->onUpgrade");
        }
    }

    static {
        f14446a = MessageProvider.class.getSimpleName();
        f14447b = new UriMatcher(-1);
    }

    private void m17331b() {
        synchronized (this) {
            this.f14458c = new C4240a(this, getContext());
            this.f14460e = new C4241b(this, getContext());
            if (this.f14459d == null) {
                this.f14459d = this.f14458c.getWritableDatabase();
            }
            if (this.f14461f == null) {
                this.f14461f = this.f14460e.getWritableDatabase();
            }
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i = 0;
        switch (f14447b.match(uri)) {
            case f14449h /*2*/:
                i = this.f14459d.delete(C4233j.f14381d, str, strArr);
                break;
            case f14450i /*3*/:
                i = this.f14459d.delete(C4233j.f14382e, str, strArr);
                break;
            case f14451j /*4*/:
                i = this.f14459d.delete(C4233j.f14382e, null, null);
                break;
            case f14452k /*5*/:
                i = this.f14461f.delete(C4239k.f14424c, str, strArr);
                break;
            case f14453l /*6*/:
                i = this.f14461f.delete(C4239k.f14425d, str, strArr);
                break;
            case f14454m /*7*/:
                i = this.f14461f.delete(C4239k.f14426e, str, strArr);
                break;
            case f14455n /*8*/:
                i = this.f14461f.delete(C4239k.f14427f, str, strArr);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }

    public String getType(Uri uri) {
        switch (f14447b.match(uri)) {
            case f14448g /*1*/:
            case f14449h /*2*/:
            case f14450i /*3*/:
            case f14452k /*5*/:
            case f14454m /*7*/:
            case f14455n /*8*/:
            case f14456o /*9*/:
                return C4242a.f14471j;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        long insertWithOnConflict;
        Uri withAppendedId;
        switch (f14447b.match(uri)) {
            case f14448g /*1*/:
                insertWithOnConflict = this.f14459d.insertWithOnConflict(C4233j.f14380c, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    withAppendedId = ContentUris.withAppendedId(C4243a.f14475b, insertWithOnConflict);
                    getContext().getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                break;
            case f14449h /*2*/:
                insertWithOnConflict = this.f14459d.insertWithOnConflict(C4233j.f14381d, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    withAppendedId = ContentUris.withAppendedId(C4243a.f14475b, insertWithOnConflict);
                    getContext().getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                break;
            case f14450i /*3*/:
                insertWithOnConflict = this.f14459d.insertWithOnConflict(C4233j.f14382e, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    withAppendedId = ContentUris.withAppendedId(C4243a.f14477d, insertWithOnConflict);
                    getContext().getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                break;
            case f14452k /*5*/:
                insertWithOnConflict = this.f14461f.insertWithOnConflict(C4239k.f14424c, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    withAppendedId = ContentUris.withAppendedId(C4243a.f14479f, insertWithOnConflict);
                    getContext().getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                break;
            case f14453l /*6*/:
                insertWithOnConflict = this.f14461f.insertWithOnConflict(C4239k.f14425d, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    return ContentUris.withAppendedId(C4243a.f14480g, insertWithOnConflict);
                }
                break;
            case f14454m /*7*/:
                insertWithOnConflict = this.f14461f.insertWithOnConflict(C4239k.f14426e, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    return ContentUris.withAppendedId(C4243a.f14481h, insertWithOnConflict);
                }
                break;
            case f14455n /*8*/:
                insertWithOnConflict = this.f14461f.insertWithOnConflict(C4239k.f14427f, null, contentValues, f14452k);
                if (insertWithOnConflict > 0) {
                    C4243a.m17332a(f14457p);
                    return ContentUris.withAppendedId(C4243a.f14482i, insertWithOnConflict);
                }
                break;
        }
        return null;
    }

    public boolean onCreate() {
        m17331b();
        f14457p = getContext();
        UriMatcher uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MessageStores", f14448g);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgTemps", f14449h);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, C4233j.f14382e, f14450i);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgAliasDeleteAll", f14451j);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgLogStores", f14452k);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgLogIdTypeStores", f14453l);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgLogStoreForAgoos", f14454m);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgLogIdTypeStoreForAgoos", f14455n);
        uriMatcher = f14447b;
        C4243a.m17332a(f14457p);
        uriMatcher.addURI(C4243a.f14474a, "MsgConfigInfos", f14456o);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor = null;
        switch (f14447b.match(uri)) {
            case f14449h /*2*/:
                cursor = this.f14459d.query(C4233j.f14381d, strArr, str, strArr2, null, null, str2);
                break;
            case f14450i /*3*/:
                cursor = this.f14459d.query(C4233j.f14382e, strArr, str, strArr2, null, null, str2);
                break;
            case f14452k /*5*/:
                cursor = this.f14461f.query(C4239k.f14424c, strArr, str, strArr2, null, null, str2);
                break;
            case f14454m /*7*/:
                cursor = this.f14461f.query(C4239k.f14426e, strArr, str, strArr2, null, null, str2);
                break;
            case f14455n /*8*/:
                cursor = this.f14461f.query(C4239k.f14427f, strArr, str, strArr2, null, null, str2);
                break;
            case f14456o /*9*/:
                cursor = this.f14461f.query(C4239k.f14428g, strArr, str, strArr2, null, null, str2);
                break;
        }
        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int updateWithOnConflict;
        switch (f14447b.match(uri)) {
            case f14448g /*1*/:
                updateWithOnConflict = this.f14459d.updateWithOnConflict(C4233j.f14380c, contentValues, str, strArr, f14452k);
                break;
            case f14449h /*2*/:
                updateWithOnConflict = this.f14459d.updateWithOnConflict(C4233j.f14381d, contentValues, str, strArr, f14452k);
                break;
            case f14450i /*3*/:
                this.f14459d.updateWithOnConflict(C4233j.f14382e, contentValues, str, strArr, f14452k);
                updateWithOnConflict = 0;
                break;
            case f14456o /*9*/:
                updateWithOnConflict = this.f14461f.updateWithOnConflict(C4239k.f14428g, contentValues, str, strArr, f14452k);
                break;
            default:
                updateWithOnConflict = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return updateWithOnConflict;
    }
}
