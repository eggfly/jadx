package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;

public class ContentResolverCompat {
    private static final ContentResolverCompatImpl f409a;

    interface ContentResolverCompatImpl {
        Cursor m549a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    static class ContentResolverCompatImplBase implements ContentResolverCompatImpl {
        ContentResolverCompatImplBase() {
        }

        public Cursor m550a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            if (cancellationSignal != null) {
                cancellationSignal.m1002b();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
    }

    static class ContentResolverCompatImplJB extends ContentResolverCompatImplBase {
        ContentResolverCompatImplJB() {
        }

        public Cursor m551a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            Object d;
            if (cancellationSignal != null) {
                try {
                    d = cancellationSignal.m1004d();
                } catch (Exception e) {
                    if (ContentResolverCompatJellybean.m554a(e)) {
                        throw new OperationCanceledException();
                    }
                    throw e;
                }
            }
            d = null;
            return ContentResolverCompatJellybean.m553a(contentResolver, uri, strArr, str, strArr2, str2, d);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f409a = new ContentResolverCompatImplJB();
        } else {
            f409a = new ContentResolverCompatImplBase();
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor m552a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return f409a.m549a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal);
    }
}
