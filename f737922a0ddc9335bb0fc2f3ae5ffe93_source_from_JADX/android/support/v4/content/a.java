package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import e;

public class a {
    private static final a j6;

    interface a {
        Cursor j6(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, e eVar);
    }

    static class b implements a {
        b() {
        }

        public Cursor j6(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, e eVar) {
            if (eVar != null) {
                eVar.DW();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
    }

    static class c extends b {
        c() {
        }

        public Cursor j6(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, e eVar) {
            return b.j6(contentResolver, uri, strArr, str, strArr2, str2, eVar != null ? eVar.Hw() : null);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            j6 = new c();
        } else {
            j6 = new b();
        }
    }

    public static Cursor j6(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, e eVar) {
        return j6.j6(contentResolver, uri, strArr, str, strArr2, str2, eVar);
    }
}
