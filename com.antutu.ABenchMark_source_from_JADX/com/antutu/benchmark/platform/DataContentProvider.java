package com.antutu.benchmark.platform;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.antutu.benchmark.BenchmarkService;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.utils.Methods;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4209a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class DataContentProvider extends ContentProvider {
    public static final Uri f5361a;
    private static final UriMatcher f5362b;
    private String[] f5363c;
    private String f5364d;
    private String f5365e;

    static {
        f5361a = Uri.parse("content://com.antutu.benchmark.provider.udata/data");
        f5362b = m6097a();
    }

    public DataContentProvider() {
        this.f5363c = new String[3];
        this.f5364d = BuildConfig.FLAVOR;
        this.f5365e = BuildConfig.FLAVOR;
    }

    private static UriMatcher m6097a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.antutu.benchmark.provider.udata", Constants.KEY_DATA, 1);
        uriMatcher.addURI("com.antutu.benchmark.provider.udata", C4233j.f14402y, 2);
        uriMatcher.addURI("com.antutu.benchmark.provider.udata", "type2", 3);
        uriMatcher.addURI("com.antutu.benchmark.provider.udata", "hide", 4);
        return uriMatcher;
    }

    private void m6098b() {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            String str = BuildConfig.FLAVOR;
            String str2 = BuildConfig.FLAVOR;
            String str3 = BuildConfig.FLAVOR;
            String str4 = BuildConfig.FLAVOR;
            String str5 = BuildConfig.FLAVOR;
            String str6 = str4;
            str4 = str3;
            str3 = str2;
            str2 = str;
            for (int i = 1; i < 100; i++) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("Hardware")) {
                    this.f5365e = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                } else if (readLine.contains("CPU implementer")) {
                    str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                } else if (readLine.contains("CPU variant")) {
                    str4 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                } else if (readLine.contains("CPU part")) {
                    str6 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                } else if (readLine.contains("CPU revision")) {
                    str5 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                } else if (readLine.contains("CPU architecture")) {
                    str3 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
            }
            this.f5364d = str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str6 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5;
            lineNumberReader.close();
        } catch (Exception e) {
        }
    }

    private String m6099c() {
        C1545a a = C1545a.m6117a();
        if (a.m6122a(Build.BRAND, Build.MODEL)) {
            m6098b();
            if (a.m6123a(Build.BRAND, Build.MODEL, this.f5364d, this.f5365e)) {
                return "vnd.android.cursor.deferred/vnd.com.antutu.benchmark.provider.udata";
            }
        }
        return BuildConfig.FLAVOR;
    }

    private String m6100d() {
        if (Methods.getAvaliableMemSize(getContext()) < Constants.COMMAND_HANDSHAKE) {
            return "vnd.android.cursor.load3/vnd.com.antutu.benchmark.provider.udata";
        }
        try {
            if (C1545a.m6117a().m6124a(Build.BRAND, Build.MODEL, C1516b.m6035i(), C1516b.m6036j(), C1516b.m6037k())) {
                return "vnd.android.cursor.load4/vnd.com.antutu.benchmark.provider.udata";
            }
        } catch (Exception e) {
        }
        switch (C1516b.m6027e(getContext())) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "vnd.android.cursor.load2/vnd.com.antutu.benchmark.provider.udata";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "vnd.android.cursor.load3/vnd.com.antutu.benchmark.provider.udata";
            case SpdyProtocol.QUIC /*4*/:
                return "vnd.android.cursor.load4/vnd.com.antutu.benchmark.provider.udata";
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return "vnd.android.cursor.load5/vnd.com.antutu.benchmark.provider.udata";
            default:
                return BuildConfig.FLAVOR;
        }
    }

    private String m6101e() {
        try {
            int d = C1516b.m6024d(getContext());
            if (d == 1) {
                return "vnd.android.cursor.hide/vnd.com.antutu.benchmark.provider.udata";
            }
            if (d == 2) {
                return "vnd.android.cursor.hide_run/vnd.com.antutu.benchmark.provider.udata";
            }
            if (d == 3) {
                return "vnd.android.cursor.show/vnd.com.antutu.benchmark.provider.udata";
            }
            if (d == 4) {
                return "vnd.android.cursor.show_run/vnd.com.antutu.benchmark.provider.udata";
            }
            return BuildConfig.FLAVOR;
        } catch (Exception e) {
        }
    }

    public int m6102a(byte[] bArr, String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            OutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        switch (f5362b.match(uri)) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                for (int i = 0; i < 3; i++) {
                    new File(this.f5363c[i]).delete();
                }
                try {
                    getContext().getContentResolver().notifyChange(uri, null);
                } catch (Exception e) {
                }
                return 0;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    public String getType(Uri uri) {
        String str = BuildConfig.FLAVOR;
        switch (f5362b.match(uri)) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "vnd.android.cursor.item/vnd.com.antutu.benchmark.provider.udata";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return m6099c();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return m6100d();
            case SpdyProtocol.QUIC /*4*/:
                return m6101e();
            default:
                return str;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        String str;
        Uri uri2 = null;
        int intValue = contentValues.getAsInteger("uid").intValue();
        switch (intValue) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                BenchmarkService.m4814c(4);
                str = this.f5363c[0];
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                BenchmarkService.m4814c(2);
                str = this.f5363c[0];
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                BenchmarkService.m4814c(3);
                str = this.f5363c[0];
                break;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                str = this.f5363c[0] + MessageService.MSG_DB_NOTIFY_REACHED;
                break;
            case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                str = this.f5363c[0] + MessageService.MSG_DB_NOTIFY_CLICK;
                break;
            default:
                return uri2;
        }
        m6102a(contentValues.getAsByteArray(Constants.KEY_DATA), str);
        uri2 = ContentUris.withAppendedId(f5361a, (long) intValue);
        try {
            getContext().getContentResolver().notifyChange(uri2, null);
        } catch (Exception e) {
        }
        return uri2;
    }

    public boolean onCreate() {
        for (int i = 0; i < 3; i++) {
            this.f5363c[i] = null;
        }
        try {
            this.f5363c[0] = getContext().getFilesDir().getAbsolutePath();
            StringBuilder stringBuilder = new StringBuilder();
            String[] strArr = this.f5363c;
            strArr[0] = stringBuilder.append(strArr[0]).append("/95du3_data.gz").toString();
            this.f5363c[1] = this.f5363c[0] + MessageService.MSG_DB_NOTIFY_REACHED;
            this.f5363c[2] = this.f5363c[0] + MessageService.MSG_DB_NOTIFY_CLICK;
        } catch (Exception e) {
        }
        return this.f5363c[0] != null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        int intValue = contentValues.getAsInteger("uid").intValue();
        switch (intValue) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                str2 = this.f5363c[0];
                break;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
            case C4209a.f14215r /*22*/:
                str2 = this.f5363c[intValue - 10];
                break;
            default:
                return 0;
        }
        m6102a(contentValues.getAsByteArray(Constants.KEY_DATA), str2);
        return intValue;
    }
}
