package com.umeng.message.proguard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.provider.C4243a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.k */
public class C4239k {
    public static final String f14422a = "MsgLogStore.db";
    public static final int f14423b = 4;
    public static final String f14424c = "MsgLogStore";
    public static final String f14425d = "MsgLogIdTypeStore";
    public static final String f14426e = "MsgLogStoreForAgoo";
    public static final String f14427f = "MsgLogIdTypeStoreForAgoo";
    public static final String f14428g = "MsgConfigInfo";
    public static final String f14429h = "MsgId";
    public static final String f14430i = "MsgType";
    public static final String f14431j = "ActionType";
    public static final String f14432k = "Time";
    public static final String f14433l = "TaskId";
    public static final String f14434m = "MsgStatus";
    public static final String f14435n = "SerialNo";
    public static final String f14436o = "AppLaunchAt";
    public static final String f14437p = "UpdateResponse";
    private static final String f14438q;
    private static C4239k f14439r = null;
    private static final String f14440t = " And ";
    private static final String f14441u = " Asc ";
    private static final String f14442v = " Desc ";
    private Context f14443s;

    /* renamed from: com.umeng.message.proguard.k.1 */
    class C42341 implements FilenameFilter {
        final /* synthetic */ C4239k f14405a;

        C42341(C4239k c4239k) {
            this.f14405a = c4239k;
        }

        public boolean accept(File file, String str) {
            return !TextUtils.isEmpty(str) && str.startsWith(MsgConstant.CACHE_LOG_FILE_PREFIX);
        }
    }

    /* renamed from: com.umeng.message.proguard.k.a */
    public class C4235a {
        public String f14406a;
        public long f14407b;
        public int f14408c;
        final /* synthetic */ C4239k f14409d;

        public C4235a(C4239k c4239k, Cursor cursor) {
            this.f14409d = c4239k;
            this.f14406a = cursor.getString(cursor.getColumnIndex(C4239k.f14429h));
            this.f14407b = cursor.getLong(cursor.getColumnIndex(C4239k.f14432k));
            this.f14408c = cursor.getInt(cursor.getColumnIndex(C4239k.f14431j));
        }

        public C4235a(C4239k c4239k, String str, int i, long j) {
            this.f14409d = c4239k;
            this.f14406a = str;
            this.f14408c = i;
            this.f14407b = j;
        }

        public ContentValues m17297a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C4239k.f14429h, this.f14406a);
            contentValues.put(C4239k.f14432k, Long.valueOf(this.f14407b));
            contentValues.put(C4239k.f14431j, Integer.valueOf(this.f14408c));
            return contentValues;
        }
    }

    /* renamed from: com.umeng.message.proguard.k.b */
    public class C4236b {
        public String f14410a;
        public String f14411b;
        public String f14412c;
        public long f14413d;
        final /* synthetic */ C4239k f14414e;

        public C4236b(C4239k c4239k, Cursor cursor) {
            this.f14414e = c4239k;
            this.f14410a = cursor.getString(cursor.getColumnIndex(C4239k.f14429h));
            this.f14411b = cursor.getString(cursor.getColumnIndex(C4239k.f14433l));
            this.f14412c = cursor.getString(cursor.getColumnIndex(C4239k.f14434m));
            this.f14413d = cursor.getLong(cursor.getColumnIndex(C4239k.f14432k));
        }

        public C4236b(C4239k c4239k, String str, String str2, String str3, long j) {
            this.f14414e = c4239k;
            this.f14410a = str;
            this.f14411b = str2;
            this.f14412c = str3;
            this.f14413d = j;
        }

        public ContentValues m17298a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C4239k.f14429h, this.f14410a);
            contentValues.put(C4239k.f14433l, this.f14411b);
            contentValues.put(C4239k.f14434m, this.f14412c);
            contentValues.put(C4239k.f14432k, Long.valueOf(this.f14413d));
            return contentValues;
        }
    }

    /* renamed from: com.umeng.message.proguard.k.c */
    public class C4237c {
        public String f14415a;
        public String f14416b;
        final /* synthetic */ C4239k f14417c;

        public C4237c(C4239k c4239k, Cursor cursor) {
            this.f14417c = c4239k;
            this.f14415a = cursor.getString(cursor.getColumnIndex(C4239k.f14429h));
            this.f14416b = cursor.getString(cursor.getColumnIndex(C4239k.f14430i));
        }

        public C4237c(C4239k c4239k, String str, String str2) {
            this.f14417c = c4239k;
            this.f14415a = str;
            this.f14416b = str2;
        }

        public ContentValues m17299a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C4239k.f14429h, this.f14415a);
            contentValues.put(C4239k.f14430i, this.f14416b);
            return contentValues;
        }
    }

    /* renamed from: com.umeng.message.proguard.k.d */
    public class C4238d {
        public String f14418a;
        public String f14419b;
        public String f14420c;
        final /* synthetic */ C4239k f14421d;

        public C4238d(C4239k c4239k, Cursor cursor) {
            this.f14421d = c4239k;
            this.f14418a = cursor.getString(cursor.getColumnIndex(C4239k.f14429h));
            this.f14419b = cursor.getString(cursor.getColumnIndex(C4239k.f14433l));
            this.f14420c = cursor.getString(cursor.getColumnIndex(C4239k.f14434m));
        }

        public C4238d(C4239k c4239k, String str, String str2, String str3) {
            this.f14421d = c4239k;
            this.f14418a = str;
            this.f14419b = str2;
            this.f14420c = str3;
        }

        public ContentValues m17300a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C4239k.f14429h, this.f14418a);
            contentValues.put(C4239k.f14433l, this.f14419b);
            contentValues.put(C4239k.f14434m, this.f14420c);
            return contentValues;
        }
    }

    static {
        f14438q = C4239k.class.getName();
    }

    private C4239k(Context context) {
        this.f14443s = context.getApplicationContext();
    }

    public static C4239k m17301a(Context context) {
        if (f14439r == null) {
            f14439r = new C4239k(context);
            f14439r.m17304h();
        }
        return f14439r;
    }

    private void m17302a(File file) {
        try {
            JSONObject jSONObject = new JSONObject(m17303b(file));
            m17311a(jSONObject.optString(MsgConstant.KEY_MSG_ID), jSONObject.optInt(MsgConstant.KEY_ACTION_TYPE), jSONObject.optLong(MsgConstant.KEY_TS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String m17303b(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String str = BuildConfig.FLAVOR;
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                str = stringBuilder.toString();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    private void m17304h() {
        if (!MessageSharedPrefs.getInstance(this.f14443s).hasTransferedCacheFileDataToSQL()) {
            File[] listFiles = this.f14443s.getCacheDir().listFiles(new C42341(this));
            if (listFiles != null) {
                for (File file : listFiles) {
                    m17302a(file);
                    file.delete();
                }
            }
            MessageSharedPrefs.getInstance(this.f14443s).finishTransferedCacheFileDataToSQL();
        }
    }

    public C4235a m17305a(String str) {
        C4235a c4235a = null;
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = new String[0];
            ContentResolver contentResolver = this.f14443s.getContentResolver();
            C4243a.m17332a(this.f14443s);
            Cursor query = contentResolver.query(C4243a.f14479f, null, "MsgId=?", strArr, null);
            if (query.moveToFirst()) {
                c4235a = new C4235a(this, query);
            }
            if (query != null) {
                query.close();
            }
        }
        return c4235a;
    }

    public ArrayList<C4235a> m17306a() {
        ArrayList<C4235a> arrayList = new ArrayList();
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14479f, null, null, null, "Time Asc ");
        if (query == null) {
            return arrayList;
        }
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4235a(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public ArrayList<C4235a> m17307a(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<C4235a> arrayList = new ArrayList();
        C4243a.m17332a(this.f14443s);
        Uri build = C4243a.f14479f.buildUpon().appendQueryParameter("limit", i + BuildConfig.FLAVOR).build();
        Cursor query = this.f14443s.getContentResolver().query(build, null, null, null, "Time Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4235a(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public void m17308a(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f14436o, j + BuildConfig.FLAVOR);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        contentResolver.update(C4243a.f14483j, contentValues, null, null);
    }

    public void m17309a(Object obj) {
        String a = C4230g.m17260a(obj);
        ContentValues contentValues = new ContentValues();
        contentValues.put(f14437p, a);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        contentResolver.update(C4243a.f14483j, contentValues, null, null);
    }

    public boolean m17310a(String str, int i) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str, i + BuildConfig.FLAVOR};
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        if (contentResolver.delete(C4243a.f14479f, "MsgId=? And ActionType=?", strArr) != 1) {
            z = false;
        }
        return z;
    }

    public boolean m17311a(String str, int i, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C4235a c4235a = new C4235a(this, str, i, j);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        return contentResolver.insert(C4243a.f14479f, c4235a.m17297a()) != null;
    }

    public boolean m17312a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C4237c c4237c = new C4237c(this, str, str2);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        return contentResolver.insert(C4243a.f14480g, c4237c.m17299a()) != null;
    }

    public boolean m17313a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C4238d c4238d = new C4238d(this, str, str2, str3);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        return contentResolver.insert(C4243a.f14482i, c4238d.m17300a()) != null;
    }

    public boolean m17314a(String str, String str2, String str3, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C4236b c4236b = new C4236b(this, str, str2, str3, j);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        return contentResolver.insert(C4243a.f14481h, c4236b.m17298a()) != null;
    }

    public ArrayList<C4237c> m17315b() {
        ArrayList<C4237c> arrayList = new ArrayList();
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14480g, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4237c(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public ArrayList<C4237c> m17316b(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<C4237c> arrayList = new ArrayList();
        C4243a.m17332a(this.f14443s);
        Uri build = C4243a.f14480g.buildUpon().appendQueryParameter("limit", i + BuildConfig.FLAVOR).build();
        Cursor query = this.f14443s.getContentResolver().query(build, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4237c(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public boolean m17317b(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str};
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        if (contentResolver.delete(C4243a.f14480g, "MsgId=?", strArr) != 1) {
            z = false;
        }
        return z;
    }

    public boolean m17318b(String str, String str2) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str, str2};
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        if (contentResolver.delete(C4243a.f14481h, "MsgId=? And MsgStatus=?", strArr) != 1) {
            z = false;
        }
        return z;
    }

    public C4236b m17319c(String str) {
        C4236b c4236b = null;
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = new String[]{str};
            ContentResolver contentResolver = this.f14443s.getContentResolver();
            C4243a.m17332a(this.f14443s);
            Cursor query = contentResolver.query(C4243a.f14481h, null, "MsgId=?", strArr, null);
            if (query.moveToFirst()) {
                c4236b = new C4236b(this, query);
            }
            if (query != null) {
                query.close();
            }
        }
        return c4236b;
    }

    public ArrayList<C4236b> m17320c() {
        ArrayList<C4236b> arrayList = new ArrayList();
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14481h, null, null, null, "Time Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4236b(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public ArrayList<C4236b> m17321c(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<C4236b> arrayList = new ArrayList();
        C4243a.m17332a(this.f14443s);
        Uri build = C4243a.f14481h.buildUpon().appendQueryParameter("limit", i + BuildConfig.FLAVOR).build();
        Cursor query = this.f14443s.getContentResolver().query(build, null, null, null, "Time Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4236b(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public ArrayList<C4238d> m17322d() {
        ArrayList<C4238d> arrayList = new ArrayList();
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14482i, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4238d(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public ArrayList<C4238d> m17323d(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<C4238d> arrayList = new ArrayList();
        C4243a.m17332a(this.f14443s);
        Uri build = C4243a.f14482i.buildUpon().appendQueryParameter("limit", i + BuildConfig.FLAVOR).build();
        Cursor query = this.f14443s.getContentResolver().query(build, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new C4238d(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public boolean m17324d(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str};
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        if (contentResolver.delete(C4243a.f14482i, "MsgId=?", strArr) != 1) {
            z = false;
        }
        return z;
    }

    public int m17325e() {
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14483j, new String[]{f14435n}, null, null, null);
        int i = query.moveToFirst() ? query.getInt(query.getColumnIndex(f14435n)) : 0;
        if (query != null) {
            query.close();
        }
        return i;
    }

    public void m17326e(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f14435n, i + BuildConfig.FLAVOR);
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        contentResolver.update(C4243a.f14483j, contentValues, null, null);
    }

    public long m17327f() {
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14483j, new String[]{f14436o}, null, null, null);
        if (query == null) {
            return 0;
        }
        long j = query.moveToFirst() ? query.getLong(query.getColumnIndex(f14436o)) : 0;
        if (query != null) {
            query.close();
        }
        Log.d(f14438q, "appLaunchAt=" + j);
        return j;
    }

    public Object m17328g() {
        String str = null;
        ContentResolver contentResolver = this.f14443s.getContentResolver();
        C4243a.m17332a(this.f14443s);
        Cursor query = contentResolver.query(C4243a.f14483j, new String[]{f14437p}, null, null, null);
        if (query.moveToFirst()) {
            str = query.getString(query.getColumnIndex(f14437p));
        }
        if (query != null) {
            query.close();
        }
        Log.d(f14438q, "updateResponse=" + str);
        return C4230g.m17284f(str);
    }
}
