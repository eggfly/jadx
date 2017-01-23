package p023b.p024a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* renamed from: b.a.cc */
public class cc extends ContextWrapper {
    private String f2802a;

    public cc(Context context, String str) {
        super(context);
        this.f2802a = str;
    }

    public File getDatabasePath(String str) {
        File file = new File(this.f2802a + str);
        if (!(file.getParentFile().exists() || file.getParentFile().isDirectory())) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, databaseErrorHandler);
    }
}
