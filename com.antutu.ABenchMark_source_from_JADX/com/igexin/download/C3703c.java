package com.igexin.download;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* renamed from: com.igexin.download.c */
class C3703c extends CursorWrapper implements CrossProcessCursor {
    final /* synthetic */ DownloadProvider f12506a;
    private CrossProcessCursor f12507b;

    public C3703c(DownloadProvider downloadProvider, Cursor cursor) {
        this.f12506a = downloadProvider;
        super(cursor);
        this.f12507b = (CrossProcessCursor) cursor;
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.f12507b.fillWindow(i, cursorWindow);
    }

    public CursorWindow getWindow() {
        return this.f12507b.getWindow();
    }

    public boolean onMove(int i, int i2) {
        return this.f12507b.onMove(i, i2);
    }
}
