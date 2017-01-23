package com.antutu.utils.downloader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.common.AgooConstants;

public class FileDownloadingService {
    private static final String TABLE_NAME = "filedownloading";
    DownloadDBOpenHelper dbOpenHelper;
    private final ReentrantLock lock;
    private Context mContext;

    public FileDownloadingService(Context context) {
        this.lock = new ReentrantLock();
        this.mContext = context;
        this.dbOpenHelper = DownloadDBOpenHelper.getInstance(context);
    }

    public int delete(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            this.lock.lock();
            sQLiteDatabase = this.dbOpenHelper.getWritableDatabase();
            sQLiteDatabase.delete(TABLE_NAME, str, strArr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            this.lock.unlock();
        }
        return 0;
    }

    public int deleteByDownpath(String str) {
        int i = 0;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            this.lock.lock();
            sQLiteDatabase = this.dbOpenHelper.getWritableDatabase();
            i = sQLiteDatabase.delete(TABLE_NAME, "downpath = ?", new String[]{str});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            this.lock.unlock();
        }
        return i;
    }

    public long insert(ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = null;
        long j = 0;
        try {
            this.lock.lock();
            sQLiteDatabase = this.dbOpenHelper.getWritableDatabase();
            j = sQLiteDatabase.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            this.lock.unlock();
        }
        return j;
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return this.dbOpenHelper.getReadableDatabase().query(TABLE_NAME, strArr, str, strArr2, null, null, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer query(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Exception exception;
        Throwable th;
        Cursor cursor2 = null;
        try {
            this.lock.lock();
            SQLiteDatabase readableDatabase = this.dbOpenHelper.getReadableDatabase();
            try {
                Cursor query = readableDatabase.query(TABLE_NAME, null, "downpath = ?", new String[]{str}, null, null, null);
                try {
                    Integer valueOf = query.moveToNext() ? Integer.valueOf(query.getInt(query.getColumnIndex(AgooConstants.MESSAGE_ID))) : null;
                    if (query != null) {
                        query.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    this.lock.unlock();
                    return valueOf;
                } catch (Exception e) {
                    Exception exception2 = e;
                    cursor = query;
                    sQLiteDatabase = readableDatabase;
                    exception = exception2;
                    try {
                        exception.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        this.lock.unlock();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        this.lock.unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor2 = query;
                    sQLiteDatabase = readableDatabase;
                    th = th3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    this.lock.unlock();
                    throw th;
                }
            } catch (Exception e2) {
                sQLiteDatabase = readableDatabase;
                exception = e2;
                cursor = null;
                exception.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                this.lock.unlock();
                return null;
            } catch (Throwable th32) {
                sQLiteDatabase = readableDatabase;
                th = th32;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                this.lock.unlock();
                throw th;
            }
        } catch (Exception e3) {
            exception = e3;
            cursor = null;
            sQLiteDatabase = null;
            exception.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            this.lock.unlock();
            return null;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabase = null;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            this.lock.unlock();
            throw th;
        }
    }
}
