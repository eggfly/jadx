package com.antutu.benchmark.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.antutu.utils.downloader.FileDownloadingService;
import org.android.spdy.SpdyProtocol;

public class DownloadProvider extends ContentProvider {
    public static final Uri f5588a;
    private static UriMatcher f5589b;
    private FileDownloadingService f5590c;

    static {
        f5589b = new UriMatcher(-1);
        f5588a = Uri.parse("content://com.antutu.benchmark.provider.download/downloading");
        f5589b.addURI("com.antutu.benchmark.provider.download", "downloading", 1);
        f5589b.addURI("com.antutu.benchmark.provider.download", "downloading/*", 0);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i = 0;
        switch (f5589b.match(uri)) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                i = this.f5590c.delete(str, strArr);
                if (i > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                    break;
                }
                break;
        }
        return i;
    }

    public String getType(Uri uri) {
        switch (f5589b.match(uri)) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "vnd.android.cursor.item/com.antutu.benchmark.provider.download.downloading";
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (f5589b.match(uri)) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                long insert = this.f5590c.insert(contentValues);
                if (insert > 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insert);
                    getContext().getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                break;
        }
        return null;
    }

    public boolean onCreate() {
        this.f5590c = new FileDownloadingService(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        switch (f5589b.match(uri)) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return this.f5590c.query(strArr, str, strArr2, str2);
            default:
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
