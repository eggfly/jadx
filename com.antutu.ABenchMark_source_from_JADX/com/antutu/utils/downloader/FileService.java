package com.antutu.utils.downloader;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseIntArray;
import java.util.concurrent.locks.ReentrantLock;

public class FileService {
    private final ReentrantLock lock;
    private DownloadDBOpenHelper openHelper;

    public FileService(Context context) {
        this.lock = new ReentrantLock();
        this.openHelper = DownloadDBOpenHelper.getInstance(context);
    }

    public void closeDB() {
        this.openHelper.close();
    }

    public void delete(String str) {
        this.lock.lock();
        try {
            this.openHelper.getWritableDatabase().execSQL("delete from filedownlog where downpath=?", new Object[]{str});
        } finally {
            this.lock.unlock();
        }
    }

    public SparseIntArray getData(String str) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        try {
            Cursor rawQuery = this.openHelper.getReadableDatabase().rawQuery("select threadid, downlength from filedownlog where downpath=?", new String[]{str});
            while (rawQuery.moveToNext()) {
                sparseIntArray.put(rawQuery.getInt(0), rawQuery.getInt(1));
            }
            rawQuery.close();
        } catch (Exception e) {
        }
        return sparseIntArray;
    }

    public long getLastModify(String str) {
        long j = 0;
        try {
            Cursor rawQuery = this.openHelper.getReadableDatabase().rawQuery("select modify from filedownlog where downpath=?", new String[]{str});
            if (rawQuery != null) {
                if (rawQuery.moveToNext()) {
                    j = rawQuery.getLong(0);
                }
                rawQuery.close();
            }
        } catch (Exception e) {
        }
        return j;
    }

    public int getTimes(String str) {
        int i = 0;
        try {
            Cursor rawQuery = this.openHelper.getReadableDatabase().rawQuery("select times from filedownlog where downpath=?", new String[]{str});
            if (rawQuery != null) {
                if (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(0);
                }
                rawQuery.close();
            }
        } catch (Exception e) {
        }
        return i;
    }

    public boolean isDownloading(String str) {
        boolean z = true;
        this.lock.lock();
        try {
            if (!this.openHelper.getWritableDatabase().rawQuery("select 1 from filedownlog where downpath=?", new String[]{str}).moveToNext()) {
                z = false;
            }
            this.lock.unlock();
            return z;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public void save(String str, long j, SparseIntArray sparseIntArray) {
        this.lock.lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.openHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                sQLiteDatabase.execSQL("insert into filedownlog(downpath, modify, times, threadid, downlength) values(?,?,?,?,?)", new Object[]{str, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i))});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.lock.unlock();
        }
    }

    public void update(String str, SparseIntArray sparseIntArray) {
        this.lock.lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.openHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                sQLiteDatabase.execSQL("update filedownlog set downlength=? where downpath=? and threadid=?", new Object[]{Integer.valueOf(sparseIntArray.valueAt(i)), str, Integer.valueOf(sparseIntArray.keyAt(i))});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.lock.unlock();
        }
    }

    public void updateTimes(String str) {
        this.lock.lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.openHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("update filedownlog set times = times + 1 where downpath=?", new Object[]{str});
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.lock.unlock();
        }
    }
}
