package com.google.android.gms.tagmanager;

import afq;
import afs;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzw implements c {
    private static final String j6;
    private final Executor DW;
    private final Context FH;
    private a Hw;
    private int Zo;
    private afq v5;

    class 1 implements Runnable {
        final /* synthetic */ long DW;
        final /* synthetic */ zzw FH;
        final /* synthetic */ List j6;

        1(zzw com_google_android_gms_tagmanager_zzw, List list, long j) {
            this.FH = com_google_android_gms_tagmanager_zzw;
            this.j6 = list;
            this.DW = j;
        }

        public void run() {
            this.FH.DW(this.j6, this.DW);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ zzw DW;
        final /* synthetic */ com.google.android.gms.tagmanager.c.c.a j6;

        2(zzw com_google_android_gms_tagmanager_zzw, com.google.android.gms.tagmanager.c.c.a aVar) {
            this.DW = com_google_android_gms_tagmanager_zzw;
            this.j6 = aVar;
        }

        public void run() {
            this.j6.j6(this.DW.DW());
        }
    }

    class a extends SQLiteOpenHelper {
        final /* synthetic */ zzw j6;

        a(zzw com_google_android_gms_tagmanager_zzw, Context context, String str) {
            this.j6 = com_google_android_gms_tagmanager_zzw;
            super(context, str, null, 1);
        }

        private void j6(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean j6(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            String str2;
            String valueOf;
            Throwable th;
            Cursor cursor2 = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
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
                        str2 = "Error querying for table ";
                        valueOf = String.valueOf(str);
                        r.DW(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
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
                str2 = "Error querying for table ";
                valueOf = String.valueOf(str);
                if (valueOf.length() == 0) {
                }
                r.DW(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
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

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.j6.FH.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            j.j6(sQLiteDatabase.getPath());
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
            if (j6("datalayer", sQLiteDatabase)) {
                j6(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzw.j6);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class b {
        final byte[] DW;
        final String j6;

        b(String str, byte[] bArr) {
            this.j6 = str;
            this.DW = bArr;
        }

        public String toString() {
            String str = this.j6;
            return new StringBuilder(String.valueOf(str).length() + 54).append("KeyAndSerialized: key = ").append(str).append(" serialized hash = ").append(Arrays.hashCode(this.DW)).toString();
        }
    }

    static {
        j6 = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    }

    public zzw(Context context) {
        this(context, afs.Hw(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, afq afq, String str, int i, Executor executor) {
        this.FH = context;
        this.v5 = afq;
        this.Zo = i;
        this.DW = executor;
        this.Hw = new a(this, this.FH, str);
    }

    private List<a> DW() {
        try {
            j6(this.v5.j6());
            List<a> j6 = j6(FH());
            return j6;
        } finally {
            v5();
        }
    }

    private List<String> DW(int i) {
        Cursor query;
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            r.DW("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase j6 = j6("Error opening database for peekEntryIds.");
        if (j6 == null) {
            return arrayList;
        }
        try {
            query = j6.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error in peekEntries fetching entryIds: ";
                    valueOf = String.valueOf(e.getMessage());
                    r.DW(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
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
            str = "Error in peekEntries fetching entryIds: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            r.DW(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private List<b> DW(List<a> list) {
        List<b> arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.j6, j6(aVar.DW)));
        }
        return arrayList;
    }

    private synchronized void DW(List<b> list, long j) {
        try {
            long j6 = this.v5.j6();
            j6(j6);
            j6(list.size());
            FH(list, j6 + j);
            v5();
        } catch (Throwable th) {
            v5();
        }
    }

    private List<b> FH() {
        SQLiteDatabase j6 = j6("Error opening database for loadSerialized.");
        List<b> arrayList = new ArrayList();
        if (j6 == null) {
            return arrayList;
        }
        Cursor query = j6.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private void FH(List<b> list, long j) {
        SQLiteDatabase j6 = j6("Error opening database for writeEntryToDatabase.");
        if (j6 != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.j6);
                contentValues.put("value", bVar.DW);
                j6.insert("datalayer", null, contentValues);
            }
        }
    }

    private int Hw() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase j6 = j6("Error opening database for getNumStoredEntries.");
        if (j6 != null) {
            try {
                cursor = j6.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                r.DW("Error getting numStoredEntries");
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

    private SQLiteDatabase j6(String str) {
        try {
            return this.Hw.getWritableDatabase();
        } catch (SQLiteException e) {
            r.DW(str);
            return null;
        }
    }

    private Object j6(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<a> j6(List<b> list) {
        List<a> arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(new a(bVar.j6, j6(bVar.DW)));
        }
        return arrayList;
    }

    private void j6(int i) {
        int Hw = (Hw() - this.Zo) + i;
        if (Hw > 0) {
            List DW = DW(Hw);
            r.FH("DataLayer store full, deleting " + DW.size() + " entries to make room.");
            j6((String[]) DW.toArray(new String[0]));
        }
    }

    private void j6(long j) {
        SQLiteDatabase j6 = j6("Error opening database for deleteOlderThan.");
        if (j6 != null) {
            try {
                r.Hw("Deleted " + j6.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                r.DW("Error deleting old entries.");
            }
        }
    }

    private void j6(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase j6 = j6("Error opening database for deleteEntries.");
            if (j6 != null) {
                try {
                    j6.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    String str = "Error deleting entries ";
                    String valueOf = String.valueOf(Arrays.toString(strArr));
                    r.DW(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
    }

    private byte[] j6(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private void v5() {
        try {
            this.Hw.close();
        } catch (SQLiteException e) {
        }
    }

    public void j6(com.google.android.gms.tagmanager.c.c.a aVar) {
        this.DW.execute(new 2(this, aVar));
    }

    public void j6(List<a> list, long j) {
        this.DW.execute(new 1(this, DW((List) list), j));
    }
}
