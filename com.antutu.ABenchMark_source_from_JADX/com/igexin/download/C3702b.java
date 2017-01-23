package com.igexin.download;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;

/* renamed from: com.igexin.download.b */
final class C3702b extends SQLiteOpenHelper {
    final /* synthetic */ DownloadProvider f12505a;

    public C3702b(DownloadProvider downloadProvider, Context context) {
        this.f12505a = downloadProvider;
        super(context, DownloadProvider.f12477a, null, Constants.COMMAND_RECEIVE_DATA);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f12505a.m15138a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != 31 || i2 != 100) {
            this.f12505a.m15142b(sQLiteDatabase);
            this.f12505a.m15138a(sQLiteDatabase);
        }
    }
}
