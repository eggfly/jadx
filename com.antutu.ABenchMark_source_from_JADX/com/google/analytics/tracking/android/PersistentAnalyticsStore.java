package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import com.umeng.analytics.C4156a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore implements AnalyticsStore {
    @VisibleForTesting
    static final String BACKEND_LIBRARY_VERSION = "";
    private static final String CREATE_HITS_TABLE;
    private static final String DATABASE_FILENAME = "google_analytics_v2.db";
    @VisibleForTesting
    static final String HITS_TABLE = "hits2";
    @VisibleForTesting
    static final String HIT_APP_ID = "hit_app_id";
    @VisibleForTesting
    static final String HIT_ID = "hit_id";
    @VisibleForTesting
    static final String HIT_STRING = "hit_string";
    @VisibleForTesting
    static final String HIT_TIME = "hit_time";
    @VisibleForTesting
    static final String HIT_URL = "hit_url";
    private Clock mClock;
    private final Context mContext;
    private final String mDatabaseName;
    private final AnalyticsDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final AnalyticsStoreStateListener mListener;

    /* renamed from: com.google.analytics.tracking.android.PersistentAnalyticsStore.1 */
    class C26821 implements Clock {
        C26821() {
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.PersistentAnalyticsStore.2 */
    class C26832 implements HttpClientFactory {
        C26832() {
        }

        public HttpClient newInstance() {
            return new DefaultHttpClient();
        }
    }

    @VisibleForTesting
    class AnalyticsDatabaseHelper extends SQLiteOpenHelper {
        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime;

        AnalyticsDatabaseHelper(Context context, String str) {
            super(context, str, null, 1);
            this.mLastDatabaseCheckTime = 0;
        }

        private boolean tablePresent(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        Log.m10260w("error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                Log.m10260w("error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        private void validateColumnsPresent(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove(PersistentAnalyticsStore.HIT_ID) && hashSet.remove(PersistentAnalyticsStore.HIT_URL) && hashSet.remove(PersistentAnalyticsStore.HIT_STRING) && hashSet.remove(PersistentAnalyticsStore.HIT_TIME)) {
                    if (!hashSet.remove(PersistentAnalyticsStore.HIT_APP_ID)) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.mBadDatabase || this.mLastDatabaseCheckTime + C4156a.f13949k <= PersistentAnalyticsStore.this.mClock.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.mBadDatabase = true;
                this.mLastDatabaseCheckTime = PersistentAnalyticsStore.this.mClock.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    PersistentAnalyticsStore.this.mContext.getDatabasePath(PersistentAnalyticsStore.this.mDatabaseName).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.mBadDatabase = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        boolean isBadDatabase() {
            return this.mBadDatabase;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            FutureApis.setOwnerOnlyReadWrite(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (tablePresent(PersistentAnalyticsStore.HITS_TABLE, sQLiteDatabase)) {
                validateColumnsPresent(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        void setBadDatabase(boolean z) {
            this.mBadDatabase = z;
        }
    }

    static {
        CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{HITS_TABLE, HIT_ID, HIT_TIME, HIT_URL, HIT_STRING, HIT_APP_ID});
    }

    PersistentAnalyticsStore(AnalyticsStoreStateListener analyticsStoreStateListener, Context context) {
        this(analyticsStoreStateListener, context, DATABASE_FILENAME);
    }

    @VisibleForTesting
    PersistentAnalyticsStore(AnalyticsStoreStateListener analyticsStoreStateListener, Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mDatabaseName = str;
        this.mListener = analyticsStoreStateListener;
        this.mClock = new C26821();
        this.mDbHelper = new AnalyticsDatabaseHelper(this.mContext, this.mDatabaseName);
        this.mDispatcher = new SimpleNetworkDispatcher(this, createDefaultHttpClientFactory(), this.mContext);
        this.mLastDeleteStaleHitsTime = 0;
    }

    private HttpClientFactory createDefaultHttpClientFactory() {
        return new C26832();
    }

    private void fillVersionParametersIfNecessary(Map<String, String> map, Collection<Command> collection) {
        for (Command command : collection) {
            if (command.getId().equals(Command.APPEND_VERSION)) {
                storeVersion(map, command.getUrlParam(), command.getValue());
                return;
            }
        }
    }

    public static String generateHitString(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + HitBuilder.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    private SQLiteDatabase getWritableDatabase(String str) {
        try {
            return this.mDbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            Log.m10260w(str);
            return null;
        }
    }

    private void removeOldHitIfFull() {
        int numStoredHits = (getNumStoredHits() - 2000) + 1;
        if (numStoredHits > 0) {
            Collection peekHits = peekHits(numStoredHits);
            Log.wDebug("Store full, deleting " + peekHits.size() + " hits to make room");
            deleteHits(peekHits);
        }
    }

    private void storeVersion(Map<String, String> map, String str, String str2) {
        Object obj = str2 == null ? BACKEND_LIBRARY_VERSION : str2 + BACKEND_LIBRARY_VERSION;
        if (str != null) {
            map.put(str, obj);
        }
    }

    private void writeHitToDatabase(Map<String, String> map, long j, String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase("Error opening database for putHit");
        if (writableDatabase != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put(HIT_STRING, generateHitString(map));
            contentValues.put(HIT_TIME, Long.valueOf(j));
            if (map.containsKey(ModelFields.ANDROID_APP_UID)) {
                try {
                    parseLong = Long.parseLong((String) map.get(ModelFields.ANDROID_APP_UID));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put(HIT_APP_ID, Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                Log.m10260w("empty path: not sending hit");
                return;
            }
            contentValues.put(HIT_URL, str);
            try {
                writableDatabase.insert(HITS_TABLE, null, contentValues);
                this.mListener.reportStoreIsEmpty(false);
            } catch (SQLiteException e2) {
                Log.m10260w("Error storing hit");
            }
        }
    }

    public void clearHits(long j) {
        boolean z = true;
        SQLiteDatabase writableDatabase = getWritableDatabase("Error opening database for clearHits");
        if (writableDatabase != null) {
            if (j == 0) {
                writableDatabase.delete(HITS_TABLE, null, null);
            } else {
                writableDatabase.delete(HITS_TABLE, "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            AnalyticsStoreStateListener analyticsStoreStateListener = this.mListener;
            if (getNumStoredHits() != 0) {
                z = false;
            }
            analyticsStoreStateListener.reportStoreIsEmpty(z);
        }
    }

    public void close() {
        try {
            this.mDbHelper.getWritableDatabase().close();
        } catch (SQLiteException e) {
            Log.m10260w("Error opening database for close");
        }
    }

    public void deleteHits(Collection<Hit> collection) {
        boolean z = false;
        if (collection == null) {
            throw new NullPointerException("hits cannot be null");
        } else if (!collection.isEmpty()) {
            SQLiteDatabase writableDatabase = getWritableDatabase("Error opening database for deleteHit");
            if (writableDatabase != null) {
                String[] strArr = new String[collection.size()];
                String format = String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, Collections.nCopies(strArr.length, "?"))});
                int i = 0;
                for (Hit hitId : collection) {
                    int i2 = i + 1;
                    strArr[i] = Long.toString(hitId.getHitId());
                    i = i2;
                }
                try {
                    writableDatabase.delete(HITS_TABLE, format, strArr);
                    AnalyticsStoreStateListener analyticsStoreStateListener = this.mListener;
                    if (getNumStoredHits() == 0) {
                        z = true;
                    }
                    analyticsStoreStateListener.reportStoreIsEmpty(z);
                } catch (SQLiteException e) {
                    Log.m10260w("Error deleting hit " + collection);
                }
            }
        }
    }

    int deleteStaleHits() {
        boolean z = true;
        long currentTimeMillis = this.mClock.currentTimeMillis();
        if (currentTimeMillis <= this.mLastDeleteStaleHitsTime + C4156a.f13948j) {
            return 0;
        }
        this.mLastDeleteStaleHitsTime = currentTimeMillis;
        SQLiteDatabase writableDatabase = getWritableDatabase("Error opening database for deleteStaleHits");
        if (writableDatabase == null) {
            return 0;
        }
        long currentTimeMillis2 = this.mClock.currentTimeMillis() - 2592000000L;
        int delete = writableDatabase.delete(HITS_TABLE, "HIT_TIME < ?", new String[]{Long.toString(currentTimeMillis2)});
        AnalyticsStoreStateListener analyticsStoreStateListener = this.mListener;
        if (getNumStoredHits() != 0) {
            z = false;
        }
        analyticsStoreStateListener.reportStoreIsEmpty(z);
        return delete;
    }

    public void dispatch() {
        Log.vDebug("dispatch running...");
        if (this.mDispatcher.okToDispatch()) {
            List peekHits = peekHits(40);
            if (peekHits.isEmpty()) {
                Log.vDebug("...nothing to dispatch");
                this.mListener.reportStoreIsEmpty(true);
                return;
            }
            int dispatchHits = this.mDispatcher.dispatchHits(peekHits);
            Log.vDebug("sent " + dispatchHits + " of " + peekHits.size() + " hits");
            deleteHits(peekHits.subList(0, Math.min(dispatchHits, peekHits.size())));
            if (dispatchHits == peekHits.size() && getNumStoredHits() > 0) {
                GAServiceManager.getInstance().dispatch();
            }
        }
    }

    @VisibleForTesting
    public AnalyticsDatabaseHelper getDbHelper() {
        return this.mDbHelper;
    }

    @VisibleForTesting
    AnalyticsDatabaseHelper getHelper() {
        return this.mDbHelper;
    }

    int getNumStoredHits() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase writableDatabase = getWritableDatabase("Error opening database for requestNumHitsPending");
        if (writableDatabase != null) {
            try {
                cursor = writableDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                Log.m10260w("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.analytics.tracking.android.Hit> peekHits(int r17) {
        /*
        r16 = this;
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.getWritableDatabase(r2);
        if (r2 != 0) goto L_0x0010;
    L_0x000a:
        r4 = new java.util.ArrayList;
        r4.<init>();
    L_0x000f:
        return r4;
    L_0x0010:
        r11 = 0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r3 = "hits2";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r5 = 2;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC, %s ASC";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r12 = 0;
        r13 = "hit_url";
        r10[r12] = r13;	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r12 = 1;
        r13 = "hit_id";
        r10[r12] = r13;	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r12 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00dd, all -> 0x0105 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r3 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        if (r3 == 0) goto L_0x0075;
    L_0x0054:
        r4 = new com.google.analytics.tracking.android.Hit;	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r5 = 0;
        r3 = 0;
        r6 = r12.getLong(r3);	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r3 = 1;
        r8 = r12.getLong(r3);	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r4.<init>(r5, r6, r8);	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r3 = 2;
        r3 = r12.getString(r3);	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r4.setHitUrl(r3);	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r11.add(r4);	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        r3 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x01aa, all -> 0x01a2 }
        if (r3 != 0) goto L_0x0054;
    L_0x0075:
        if (r12 == 0) goto L_0x007a;
    L_0x0077:
        r12.close();
    L_0x007a:
        r13 = 0;
        r3 = "hits2";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x01a0 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x01a0 }
        r5 = 1;
        r6 = "hit_string";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x01a0 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x01a0 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x01a0 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x01a0 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x01a0 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x01a0 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        if (r2 == 0) goto L_0x00d5;
    L_0x00aa:
        r4 = r13;
    L_0x00ab:
        r2 = r3 instanceof android.database.sqlite.SQLiteCursor;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        if (r2 == 0) goto L_0x017c;
    L_0x00af:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = (android.database.CursorWindow) r2;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        if (r2 <= 0) goto L_0x010c;
    L_0x00bf:
        r2 = r11.get(r4);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = (com.google.analytics.tracking.android.Hit) r2;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2.setHitString(r5);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
    L_0x00cd:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        if (r4 != 0) goto L_0x01ae;
    L_0x00d5:
        if (r3 == 0) goto L_0x00da;
    L_0x00d7:
        r3.close();
    L_0x00da:
        r4 = r11;
        goto L_0x000f;
    L_0x00dd:
        r2 = move-exception;
        r3 = r11;
    L_0x00df:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a6 }
        r4.<init>();	 Catch:{ all -> 0x01a6 }
        r5 = "error in peekHits fetching hitIds: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x01a6 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x01a6 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x01a6 }
        r2 = r2.toString();	 Catch:{ all -> 0x01a6 }
        com.google.analytics.tracking.android.Log.m10260w(r2);	 Catch:{ all -> 0x01a6 }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x01a6 }
        r4.<init>();	 Catch:{ all -> 0x01a6 }
        if (r3 == 0) goto L_0x000f;
    L_0x0100:
        r3.close();
        goto L_0x000f;
    L_0x0105:
        r2 = move-exception;
    L_0x0106:
        if (r11 == 0) goto L_0x010b;
    L_0x0108:
        r11.close();
    L_0x010b:
        throw r2;
    L_0x010c:
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r5 = "hitString for hitId ";
        r5 = r2.append(r5);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = r11.get(r4);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = (com.google.analytics.tracking.android.Hit) r2;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r6 = r2.getHitId();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = r5.append(r6);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r5 = " too large.  Hit will be deleted.";
        r2 = r2.append(r5);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = r2.toString();	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        com.google.analytics.tracking.android.Log.m10260w(r2);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        goto L_0x00cd;
    L_0x0133:
        r2 = move-exception;
        r12 = r3;
    L_0x0135:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x019e }
        r3.<init>();	 Catch:{ all -> 0x019e }
        r4 = "error in peekHits fetching hitString: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x019e }
        r2 = r2.getMessage();	 Catch:{ all -> 0x019e }
        r2 = r3.append(r2);	 Catch:{ all -> 0x019e }
        r2 = r2.toString();	 Catch:{ all -> 0x019e }
        com.google.analytics.tracking.android.Log.m10260w(r2);	 Catch:{ all -> 0x019e }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x019e }
        r4.<init>();	 Catch:{ all -> 0x019e }
        r5 = 0;
        r6 = r11.iterator();	 Catch:{ all -> 0x019e }
    L_0x0159:
        r2 = r6.hasNext();	 Catch:{ all -> 0x019e }
        if (r2 == 0) goto L_0x0173;
    L_0x015f:
        r3 = r6.next();	 Catch:{ all -> 0x019e }
        r0 = r3;
        r0 = (com.google.analytics.tracking.android.Hit) r0;	 Catch:{ all -> 0x019e }
        r2 = r0;
        r2 = r2.getHitParams();	 Catch:{ all -> 0x019e }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x019e }
        if (r2 == 0) goto L_0x0196;
    L_0x0171:
        if (r5 == 0) goto L_0x0194;
    L_0x0173:
        r4 = (java.util.List) r4;	 Catch:{ all -> 0x019e }
        if (r12 == 0) goto L_0x000f;
    L_0x0177:
        r12.close();
        goto L_0x000f;
    L_0x017c:
        r2 = r11.get(r4);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2 = (com.google.analytics.tracking.android.Hit) r2;	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        r2.setHitString(r5);	 Catch:{ SQLiteException -> 0x0133, all -> 0x018c }
        goto L_0x00cd;
    L_0x018c:
        r2 = move-exception;
        r12 = r3;
    L_0x018e:
        if (r12 == 0) goto L_0x0193;
    L_0x0190:
        r12.close();
    L_0x0193:
        throw r2;
    L_0x0194:
        r2 = 1;
        r5 = r2;
    L_0x0196:
        r0 = r4;
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x019e }
        r2 = r0;
        r2.add(r3);	 Catch:{ all -> 0x019e }
        goto L_0x0159;
    L_0x019e:
        r2 = move-exception;
        goto L_0x018e;
    L_0x01a0:
        r2 = move-exception;
        goto L_0x0135;
    L_0x01a2:
        r2 = move-exception;
        r11 = r12;
        goto L_0x0106;
    L_0x01a6:
        r2 = move-exception;
        r11 = r3;
        goto L_0x0106;
    L_0x01aa:
        r2 = move-exception;
        r3 = r12;
        goto L_0x00df;
    L_0x01ae:
        r4 = r2;
        goto L_0x00ab;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.PersistentAnalyticsStore.peekHits(int):java.util.List<com.google.analytics.tracking.android.Hit>");
    }

    public void putHit(Map<String, String> map, long j, String str, Collection<Command> collection) {
        deleteStaleHits();
        fillVersionParametersIfNecessary(map, collection);
        removeOldHitIfFull();
        writeHitToDatabase(map, j, str);
    }

    @VisibleForTesting
    public void setClock(Clock clock) {
        this.mClock = clock;
    }

    public void setDispatch(boolean z) {
        this.mDispatcher = z ? new SimpleNetworkDispatcher(this, createDefaultHttpClientFactory(), this.mContext) : new NoopDispatcher();
    }

    @VisibleForTesting
    void setDispatcher(Dispatcher dispatcher) {
        this.mDispatcher = dispatcher;
    }

    @VisibleForTesting
    void setLastDeleteStaleHitsTime(long j) {
        this.mLastDeleteStaleHitsTime = j;
    }
}
