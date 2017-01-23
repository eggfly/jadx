package com.igexin.download;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import com.umeng.message.MsgConstant;
import java.util.Locale;

/* renamed from: com.igexin.download.g */
public class C3707g extends Thread {
    private Context f12511a;
    private DownloadInfo f12512b;

    public C3707g(Context context, DownloadInfo downloadInfo) {
        this.f12511a = context;
        this.f12512b = downloadInfo;
    }

    private String m15187a() {
        String str = this.f12512b.mUserAgent;
        if (str != null) {
            return str != null ? "AndroidDownloadManager" : str;
        } else {
            if (str != null) {
            }
        }
    }

    private String m15188a(String str) {
        try {
            String toLowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            int indexOf = toLowerCase.indexOf(59);
            return indexOf != -1 ? toLowerCase.substring(0, indexOf) : toLowerCase;
        } catch (NullPointerException e) {
            return null;
        }
    }

    private void m15189a(int i, boolean z, int i2, int i3, boolean z2, String str, String str2, String str3) {
        m15190b(i, z, i2, i3, z2, str, str2, str3);
    }

    private void m15190b(int i, boolean z, int i2, int i3, boolean z2, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(i));
        contentValues.put(Downloads._DATA, str);
        if (str2 != null) {
            contentValues.put(Downloads.COLUMN_URI, str2);
        }
        contentValues.put(Downloads.COLUMN_MIME_TYPE, str3);
        contentValues.put(Downloads.COLUMN_LAST_MODIFICATION, Long.valueOf(System.currentTimeMillis()));
        contentValues.put("method", Integer.valueOf((i3 << 28) + i2));
        if (!z) {
            contentValues.put("numfailed", Integer.valueOf(0));
        } else if (z2) {
            contentValues.put("numfailed", Integer.valueOf(1));
        } else {
            contentValues.put("numfailed", Integer.valueOf(this.f12512b.mNumFailed + 1));
        }
        this.f12511a.getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) this.f12512b.mId), contentValues, null, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r33 = this;
        r2 = 10;
        android.os.Process.setThreadPriority(r2);
        r20 = 491; // 0x1eb float:6.88E-43 double:2.426E-321;
        r19 = 0;
        r18 = 0;
        r0 = r33;
        r2 = r0.f12512b;
        r0 = r2.mRedirectCount;
        r17 = r0;
        r16 = 0;
        r15 = 0;
        r5 = 0;
        r0 = r33;
        r2 = r0.f12512b;
        r2 = r2.mMimeType;
        r0 = r33;
        r13 = r0.m15188a(r2);
        r14 = 0;
        r12 = 0;
        r3 = 0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = com.igexin.download.Downloads.f12492a;
        r2 = r2.append(r4);
        r4 = "/";
        r2 = r2.append(r4);
        r0 = r33;
        r4 = r0.f12512b;
        r4 = r4.mId;
        r2 = r2.append(r4);
        r2 = r2.toString();
        r27 = android.net.Uri.parse(r2);
        r11 = 0;
        r7 = 0;
        r10 = 0;
        r6 = 0;
        r4 = 0;
        r9 = 0;
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x12ed, RuntimeException -> 0x0829, ClassNotFoundException -> 0x08db, IllegalAccessException -> 0x098d, InvocationTargetException -> 0x0a3f, all -> 0x0af1 }
        r28 = r0;
        r23 = 0;
        r0 = r33;
        r2 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x12ed, RuntimeException -> 0x0829, ClassNotFoundException -> 0x08db, IllegalAccessException -> 0x098d, InvocationTargetException -> 0x0a3f, all -> 0x0af1 }
        r8 = "power";
        r2 = r2.getSystemService(r8);	 Catch:{ FileNotFoundException -> 0x12ed, RuntimeException -> 0x0829, ClassNotFoundException -> 0x08db, IllegalAccessException -> 0x098d, InvocationTargetException -> 0x0a3f, all -> 0x0af1 }
        r2 = (android.os.PowerManager) r2;	 Catch:{ FileNotFoundException -> 0x12ed, RuntimeException -> 0x0829, ClassNotFoundException -> 0x08db, IllegalAccessException -> 0x098d, InvocationTargetException -> 0x0a3f, all -> 0x0af1 }
        r8 = 1;
        r21 = "GexinSdkDownloadService";
        r0 = r21;
        r21 = r2.newWakeLock(r8, r0);	 Catch:{ FileNotFoundException -> 0x12ed, RuntimeException -> 0x0829, ClassNotFoundException -> 0x08db, IllegalAccessException -> 0x098d, InvocationTargetException -> 0x0a3f, all -> 0x0af1 }
        r21.acquire();	 Catch:{ FileNotFoundException -> 0x12fd, RuntimeException -> 0x11d5, ClassNotFoundException -> 0x1066, IllegalAccessException -> 0x0ef7, InvocationTargetException -> 0x0d88, all -> 0x0bcf }
        r0 = r33;
        r2 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x12fd, RuntimeException -> 0x11d5, ClassNotFoundException -> 0x1066, IllegalAccessException -> 0x0ef7, InvocationTargetException -> 0x0d88, all -> 0x0bcf }
        r8 = r2.mFileName;	 Catch:{ FileNotFoundException -> 0x12fd, RuntimeException -> 0x11d5, ClassNotFoundException -> 0x1066, IllegalAccessException -> 0x0ef7, InvocationTargetException -> 0x0d88, all -> 0x0bcf }
        if (r8 == 0) goto L_0x148c;
    L_0x0077:
        r2 = com.igexin.download.C3708h.m15200a(r8);	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x1079, IllegalAccessException -> 0x0f0a, InvocationTargetException -> 0x0d9b, all -> 0x0be7 }
        if (r2 != 0) goto L_0x0133;
    L_0x007d:
        r3 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r9 = 0;
        r0 = r33;
        r2 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x108b, IllegalAccessException -> 0x0f1c, InvocationTargetException -> 0x0dad, all -> 0x0bfe }
        r10 = r2.mMimeType;	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x108b, IllegalAccessException -> 0x0f1c, InvocationTargetException -> 0x0dad, all -> 0x0bfe }
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x108b, IllegalAccessException -> 0x0f1c, InvocationTargetException -> 0x0dad, all -> 0x0bfe }
        r0 = r33;
        r2 = r0.f12512b;
        r4 = 0;
        r2.mHasActiveThread = r4;
        if (r21 == 0) goto L_0x009b;
    L_0x0098:
        r21.release();
    L_0x009b:
        if (r12 == 0) goto L_0x00b0;
    L_0x009d:
        r2 = r12.getClass();
        r4 = "close";
        r5 = 0;
        r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x145c }
        r2 = r2.getMethod(r4, r5);	 Catch:{ Exception -> 0x145c }
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x145c }
        r2.invoke(r12, r4);	 Catch:{ Exception -> 0x145c }
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();	 Catch:{ IOException -> 0x0ba7 }
    L_0x00b5:
        if (r8 == 0) goto L_0x00c6;
    L_0x00b7:
        r2 = com.igexin.download.Downloads.isStatusError(r3);
        if (r2 == 0) goto L_0x00d6;
    L_0x00bd:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x00c6:
        r2 = r33;
        r4 = r19;
        r5 = r18;
        r6 = r17;
        r7 = r15;
        r9 = r16;
        r10 = r13;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
    L_0x00d5:
        return;
    L_0x00d6:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x00c6;
    L_0x00dc:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x1459 }
        r5 = r2.getMethods();	 Catch:{ Exception -> 0x1459 }
        r2 = 0;
        r4 = 0;
    L_0x00e8:
        r6 = r5.length;	 Catch:{ Exception -> 0x1459 }
        if (r4 >= r6) goto L_0x00fb;
    L_0x00eb:
        r6 = r5[r4];	 Catch:{ Exception -> 0x1459 }
        r6 = r6.getName();	 Catch:{ Exception -> 0x1459 }
        r7 = "setPermissions";
        r6 = r6.endsWith(r7);	 Catch:{ Exception -> 0x1459 }
        if (r6 == 0) goto L_0x0130;
    L_0x00f9:
        r2 = r5[r4];	 Catch:{ Exception -> 0x1459 }
    L_0x00fb:
        if (r2 == 0) goto L_0x0120;
    L_0x00fd:
        r4 = 0;
        r5 = 4;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x1459 }
        r6 = 0;
        r5[r6] = r8;	 Catch:{ Exception -> 0x1459 }
        r6 = 1;
        r7 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x1459 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x1459 }
        r6 = 2;
        r7 = -1;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x1459 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x1459 }
        r6 = 3;
        r7 = -1;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x1459 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x1459 }
        r2.invoke(r4, r5);	 Catch:{ Exception -> 0x1459 }
    L_0x0120:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x012e, SyncFailedException -> 0x1456, IOException -> 0x1453, RuntimeException -> 0x1450 }
        r4 = 1;
        r2.<init>(r8, r4);	 Catch:{ FileNotFoundException -> 0x012e, SyncFailedException -> 0x1456, IOException -> 0x1453, RuntimeException -> 0x1450 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x012e, SyncFailedException -> 0x1456, IOException -> 0x1453, RuntimeException -> 0x1450 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x012e, SyncFailedException -> 0x1456, IOException -> 0x1453, RuntimeException -> 0x1450 }
        goto L_0x00c6;
    L_0x012e:
        r2 = move-exception;
        goto L_0x00c6;
    L_0x0130:
        r4 = r4 + 1;
        goto L_0x00e8;
    L_0x0133:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x1079, IllegalAccessException -> 0x0f0a, InvocationTargetException -> 0x0d9b, all -> 0x0be7 }
        r2.<init>(r8);	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x1079, IllegalAccessException -> 0x0f0a, InvocationTargetException -> 0x0d9b, all -> 0x0be7 }
        r3 = r2.exists();	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x1079, IllegalAccessException -> 0x0f0a, InvocationTargetException -> 0x0d9b, all -> 0x0be7 }
        if (r3 == 0) goto L_0x148c;
    L_0x013e:
        r22 = r2.length();	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x1079, IllegalAccessException -> 0x0f0a, InvocationTargetException -> 0x0d9b, all -> 0x0be7 }
        r4 = 0;
        r3 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x1489;
    L_0x0148:
        r2.delete();	 Catch:{ FileNotFoundException -> 0x130e, RuntimeException -> 0x11e6, ClassNotFoundException -> 0x1079, IllegalAccessException -> 0x0f0a, InvocationTargetException -> 0x0d9b, all -> 0x0be7 }
        r5 = 0;
    L_0x014c:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x131e, RuntimeException -> 0x11f6, ClassNotFoundException -> 0x109b, IllegalAccessException -> 0x0f2c, InvocationTargetException -> 0x0dbd, all -> 0x0c13 }
        r3 = 1;
        r2.<init>(r5, r3);	 Catch:{ FileNotFoundException -> 0x131e, RuntimeException -> 0x11f6, ClassNotFoundException -> 0x109b, IllegalAccessException -> 0x0f2c, InvocationTargetException -> 0x0dbd, all -> 0x0c13 }
        r0 = r22;
        r0 = (int) r0;
        r23 = r0;
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
        r3 = r3.mTotalBytes;	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
        r4 = -1;
        if (r3 == r4) goto L_0x1486;
    L_0x0160:
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
        r3 = r3.mTotalBytes;	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
        r4 = java.lang.Integer.toString(r3);	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
    L_0x016a:
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
        r8 = r3.mETag;	 Catch:{ FileNotFoundException -> 0x132f, RuntimeException -> 0x1207, ClassNotFoundException -> 0x10ae, IllegalAccessException -> 0x0f3f, InvocationTargetException -> 0x0dd0, all -> 0x0c2b }
        r11 = 1;
        r14 = r5;
    L_0x0172:
        r24 = 0;
        r3 = "android.net.http.AndroidHttpClient";
        r3 = java.lang.Class.forName(r3);	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r10 = r3.getMethods();	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r3 = 0;
        r5 = 0;
    L_0x0180:
        r0 = r10.length;	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r22 = r0;
        r0 = r22;
        if (r5 >= r0) goto L_0x019b;
    L_0x0187:
        r22 = r10[r5];	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r22 = r22.getName();	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r26 = "newInstance";
        r0 = r22;
        r1 = r26;
        r22 = r0.endsWith(r1);	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        if (r22 == 0) goto L_0x02be;
    L_0x0199:
        r3 = r10[r5];	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
    L_0x019b:
        if (r3 == 0) goto L_0x1482;
    L_0x019d:
        r5 = 0;
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r22 = 0;
        r26 = r33.m15187a();	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r10[r22] = r26;	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
        r22 = r3.invoke(r5, r10);	 Catch:{ FileNotFoundException -> 0x1340, RuntimeException -> 0x1218, ClassNotFoundException -> 0x10c1, IllegalAccessException -> 0x0f52, InvocationTargetException -> 0x0de3, all -> 0x0c40 }
    L_0x01ad:
        if (r2 == 0) goto L_0x147f;
    L_0x01af:
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1351, RuntimeException -> 0x1229, ClassNotFoundException -> 0x10d4, IllegalAccessException -> 0x0f65, InvocationTargetException -> 0x0df6, all -> 0x0c55 }
        r3 = r3.mDestination;	 Catch:{ FileNotFoundException -> 0x1351, RuntimeException -> 0x1229, ClassNotFoundException -> 0x10d4, IllegalAccessException -> 0x0f65, InvocationTargetException -> 0x0df6, all -> 0x0c55 }
        if (r3 != 0) goto L_0x147f;
    L_0x01b7:
        r2.close();	 Catch:{ IOException -> 0x02c2 }
        r2 = 0;
        r12 = r2;
    L_0x01bc:
        r29 = new org.apache.http.client.methods.HttpGet;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r33;
        r2 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2 = r2.mUri;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r29;
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r33;
        r2 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2 = r2.mCookies;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 == 0) goto L_0x01de;
    L_0x01d1:
        r2 = "Cookie";
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = r3.mCookies;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r29;
        r0.addHeader(r2, r3);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x01de:
        r0 = r33;
        r2 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2 = r2.mReferer;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 == 0) goto L_0x01f3;
    L_0x01e6:
        r2 = "Referer";
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = r3.mReferer;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r29;
        r0.addHeader(r2, r3);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x01f3:
        if (r11 == 0) goto L_0x0220;
    L_0x01f5:
        if (r8 == 0) goto L_0x01fe;
    L_0x01f7:
        r2 = "If-Match";
        r0 = r29;
        r0.addHeader(r2, r8);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x01fe:
        r2 = "Range";
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r5 = "bytes=";
        r3 = r3.append(r5);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r23;
        r3 = r3.append(r0);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r5 = "-";
        r3 = r3.append(r5);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r29;
        r0.addHeader(r2, r3);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x0220:
        r3 = 0;
        r2 = r22.getClass();	 Catch:{ IllegalArgumentException -> 0x02ca, Exception -> 0x02dd }
        r5 = "execute";
        r10 = 1;
        r10 = new java.lang.Class[r10];	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r26 = 0;
        r30 = org.apache.http.client.methods.HttpUriRequest.class;
        r10[r26] = r30;	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r2 = r2.getMethod(r5, r10);	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r10 = 0;
        r5[r10] = r29;	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r0 = r22;
        r2 = r2.invoke(r0, r5);	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r2 = (org.apache.http.HttpResponse) r2;	 Catch:{ NoSuchMethodException -> 0x02c6 }
        r10 = r2;
    L_0x0243:
        r2 = r10.getStatusLine();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2 = r2.getStatusCode();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r2 != r3) goto L_0x0339;
    L_0x024f:
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = r3.mNumFailed;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r5 = 5;
        if (r3 >= r5) goto L_0x0339;
    L_0x0258:
        r3 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r4 = 1;
        r2 = "Retry-After";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x1377, RuntimeException -> 0x1246, ClassNotFoundException -> 0x10f5, IllegalAccessException -> 0x0f86, InvocationTargetException -> 0x0e17, all -> 0x0c7d }
        if (r2 == 0) goto L_0x0335;
    L_0x0263:
        r2 = r2.getValue();	 Catch:{ NumberFormatException -> 0x0331 }
        r18 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0331 }
        if (r18 >= 0) goto L_0x0310;
    L_0x026d:
        r2 = 0;
    L_0x026e:
        r5 = r2;
    L_0x026f:
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1388, RuntimeException -> 0x1252, ClassNotFoundException -> 0x1101, IllegalAccessException -> 0x0f92, InvocationTargetException -> 0x0e23, all -> 0x0c8e }
        r2 = r11;
        r8 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r11 = r14;
    L_0x027b:
        r0 = r33;
        r12 = r0.f12512b;
        r13 = 0;
        r12.mHasActiveThread = r13;
        if (r21 == 0) goto L_0x0287;
    L_0x0284:
        r21.release();
    L_0x0287:
        if (r22 == 0) goto L_0x029e;
    L_0x0289:
        r12 = r22.getClass();
        r13 = "close";
        r14 = 0;
        r14 = new java.lang.Class[r14];	 Catch:{ Exception -> 0x1442 }
        r12 = r12.getMethod(r13, r14);	 Catch:{ Exception -> 0x1442 }
        r13 = 0;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x1442 }
        r0 = r22;
        r12.invoke(r0, r13);	 Catch:{ Exception -> 0x1442 }
    L_0x029e:
        if (r8 == 0) goto L_0x02a3;
    L_0x02a0:
        r8.close();	 Catch:{ IOException -> 0x0bad }
    L_0x02a3:
        if (r11 == 0) goto L_0x145f;
    L_0x02a5:
        r8 = com.igexin.download.Downloads.isStatusError(r3);
        if (r8 == 0) goto L_0x075d;
    L_0x02ab:
        if (r2 != 0) goto L_0x145f;
    L_0x02ad:
        r2 = new java.io.File;
        r2.<init>(r11);
        r2.delete();
        r11 = 0;
        r8 = r11;
    L_0x02b7:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x00d5;
    L_0x02be:
        r5 = r5 + 1;
        goto L_0x0180;
    L_0x02c2:
        r3 = move-exception;
        r12 = r2;
        goto L_0x01bc;
    L_0x02c6:
        r2 = move-exception;
        r10 = r3;
        goto L_0x0243;
    L_0x02ca:
        r2 = move-exception;
        r4 = 1;
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1377, RuntimeException -> 0x1246, ClassNotFoundException -> 0x10f5, IllegalAccessException -> 0x0f86, InvocationTargetException -> 0x0e17, all -> 0x0c7d }
        r2 = r11;
        r8 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r11 = r14;
        goto L_0x027b;
    L_0x02dd:
        r2 = move-exception;
        r0 = r33;
        r2 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2 = com.igexin.download.C3708h.m15198a(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 != 0) goto L_0x02fb;
    L_0x02e8:
        r3 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r4 = r19;
    L_0x02ec:
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1377, RuntimeException -> 0x1246, ClassNotFoundException -> 0x10f5, IllegalAccessException -> 0x0f86, InvocationTargetException -> 0x0e17, all -> 0x0c7d }
        r2 = r11;
        r8 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r11 = r14;
        goto L_0x027b;
    L_0x02fb:
        r0 = r33;
        r2 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2 = r2.mNumFailed;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = 5;
        if (r2 >= r3) goto L_0x030b;
    L_0x0304:
        r3 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r19 = 1;
        r4 = r19;
        goto L_0x02ec;
    L_0x030b:
        r3 = 495; // 0x1ef float:6.94E-43 double:2.446E-321;
        r4 = r19;
        goto L_0x02ec;
    L_0x0310:
        r2 = 30;
        r0 = r18;
        if (r0 >= r2) goto L_0x0326;
    L_0x0316:
        r18 = 30;
    L_0x0318:
        r2 = com.igexin.download.C3708h.f12513a;	 Catch:{ NumberFormatException -> 0x0331 }
        r5 = 31;
        r2 = r2.nextInt(r5);	 Catch:{ NumberFormatException -> 0x0331 }
        r2 = r2 + r18;
        r2 = r2 * 1000;
        goto L_0x026e;
    L_0x0326:
        r2 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r0 = r18;
        if (r0 <= r2) goto L_0x0318;
    L_0x032d:
        r18 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        goto L_0x0318;
    L_0x0331:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ FileNotFoundException -> 0x1377, RuntimeException -> 0x1246, ClassNotFoundException -> 0x10f5, IllegalAccessException -> 0x0f86, InvocationTargetException -> 0x0e17, all -> 0x0c7d }
    L_0x0335:
        r5 = r18;
        goto L_0x026f;
    L_0x0339:
        r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r2 == r3) goto L_0x0349;
    L_0x033d:
        r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r2 == r3) goto L_0x0349;
    L_0x0341:
        r3 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r2 == r3) goto L_0x0349;
    L_0x0345:
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r2 != r3) goto L_0x03ad;
    L_0x0349:
        r3 = 5;
        r0 = r17;
        if (r0 < r3) goto L_0x0362;
    L_0x034e:
        r3 = 497; // 0x1f1 float:6.96E-43 double:2.456E-321;
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x110b, IllegalAccessException -> 0x0f9c, InvocationTargetException -> 0x0e2d, all -> 0x0c9d }
        r2 = r11;
        r8 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r11 = r14;
        goto L_0x027b;
    L_0x0362:
        r3 = "Location";
        r3 = r10.getFirstHeader(r3);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r3 == 0) goto L_0x03ad;
    L_0x036a:
        r2 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0398 }
        r0 = r33;
        r4 = r0.f12512b;	 Catch:{ URISyntaxException -> 0x0398 }
        r4 = r4.mUri;	 Catch:{ URISyntaxException -> 0x0398 }
        r2.<init>(r4);	 Catch:{ URISyntaxException -> 0x0398 }
        r4 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0398 }
        r3 = r3.getValue();	 Catch:{ URISyntaxException -> 0x0398 }
        r4.<init>(r3);	 Catch:{ URISyntaxException -> 0x0398 }
        r2 = r2.resolve(r4);	 Catch:{ URISyntaxException -> 0x0398 }
        r9 = r2.toString();	 Catch:{ URISyntaxException -> 0x0398 }
        r6 = r17 + 1;
        r3 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1397, RuntimeException -> 0x125c, ClassNotFoundException -> 0x1119, IllegalAccessException -> 0x0faa, InvocationTargetException -> 0x0e3b, all -> 0x0cb0 }
        r2 = r11;
        r8 = r12;
        r10 = r13;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        r11 = r14;
        goto L_0x027b;
    L_0x0398:
        r2 = move-exception;
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x110b, IllegalAccessException -> 0x0f9c, InvocationTargetException -> 0x0e2d, all -> 0x0c9d }
        r2 = r11;
        r8 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r11 = r14;
        goto L_0x027b;
    L_0x03ad:
        if (r11 != 0) goto L_0x03b3;
    L_0x03af:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r3) goto L_0x03b9;
    L_0x03b3:
        if (r11 == 0) goto L_0x0400;
    L_0x03b5:
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r2 == r3) goto L_0x0400;
    L_0x03b9:
        r3 = com.igexin.download.Downloads.isStatusError(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r3 == 0) goto L_0x03d5;
    L_0x03bf:
        r3 = r11;
    L_0x03c0:
        r29.abort();	 Catch:{ FileNotFoundException -> 0x13a6, RuntimeException -> 0x1266, ClassNotFoundException -> 0x1123, IllegalAccessException -> 0x0fb4, InvocationTargetException -> 0x0e45, all -> 0x0cbf }
        r4 = 1;
        r8 = r12;
        r10 = r13;
        r11 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r32 = r3;
        r3 = r2;
        r2 = r32;
        goto L_0x027b;
    L_0x03d5:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r2 < r3) goto L_0x03e1;
    L_0x03d9:
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r2 >= r3) goto L_0x03e1;
    L_0x03dd:
        r2 = 493; // 0x1ed float:6.91E-43 double:2.436E-321;
        r3 = r11;
        goto L_0x03c0;
    L_0x03e1:
        if (r11 == 0) goto L_0x03fc;
    L_0x03e3:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r3) goto L_0x03fc;
    L_0x03e7:
        r20 = 412; // 0x19c float:5.77E-43 double:2.036E-321;
        r11 = 0;
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r2.<init>(r14);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r3 = r2.exists();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r3 == 0) goto L_0x03f8;
    L_0x03f5:
        r2.delete();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x03f8:
        r3 = r11;
        r2 = r20;
        goto L_0x03c0;
    L_0x03fc:
        r2 = 494; // 0x1ee float:6.92E-43 double:2.44E-321;
        r3 = r11;
        goto L_0x03c0;
    L_0x0400:
        if (r11 != 0) goto L_0x1479;
    L_0x0402:
        r2 = "Accept-Ranges";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 == 0) goto L_0x040d;
    L_0x040a:
        r2.getValue();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x040d:
        r2 = "Content-Disposition";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 == 0) goto L_0x1476;
    L_0x0415:
        r5 = r2.getValue();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x0419:
        r2 = "Content-Location";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 == 0) goto L_0x0425;
    L_0x0421:
        r6 = r2.getValue();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
    L_0x0425:
        if (r13 != 0) goto L_0x1473;
    L_0x0427:
        r2 = "Content-Type";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        if (r2 == 0) goto L_0x1473;
    L_0x042f:
        r2 = r2.getValue();	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r0 = r33;
        r13 = r0.m15188a(r2);	 Catch:{ FileNotFoundException -> 0x1364, RuntimeException -> 0x1238, ClassNotFoundException -> 0x10e5, IllegalAccessException -> 0x0f76, InvocationTargetException -> 0x0e07, all -> 0x0c68 }
        r7 = r13;
    L_0x043a:
        r2 = "ETag";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r2 == 0) goto L_0x146f;
    L_0x0442:
        r2 = r2.getValue();	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r26 = r2;
    L_0x0448:
        r2 = "Transfer-Encoding";
        r2 = r10.getFirstHeader(r2);	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r2 == 0) goto L_0x146c;
    L_0x0450:
        r2 = r2.getValue();	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
    L_0x0454:
        if (r2 != 0) goto L_0x1469;
    L_0x0456:
        r3 = "Content-Length";
        r3 = r10.getFirstHeader(r3);	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r3 == 0) goto L_0x1469;
    L_0x045e:
        r4 = r3.getValue();	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r13 = r4;
    L_0x0463:
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r3 = r3.mNoIntegrity;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r3 != 0) goto L_0x048b;
    L_0x046b:
        if (r13 != 0) goto L_0x048b;
    L_0x046d:
        if (r2 == 0) goto L_0x0477;
    L_0x046f:
        r3 = "chunked";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r2 != 0) goto L_0x048b;
    L_0x0477:
        r3 = 411; // 0x19b float:5.76E-43 double:2.03E-321;
        r29.abort();	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1143, IllegalAccessException -> 0x0fd4, InvocationTargetException -> 0x0e65, all -> 0x0ce8 }
        r2 = r11;
        r8 = r12;
        r10 = r7;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r11 = r14;
        r7 = r15;
        goto L_0x027b;
    L_0x048b:
        r0 = r33;
        r2 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r3 = r3.mUri;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r0 = r33;
        r4 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r4 = r4.mHint;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r0 = r33;
        r8 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r8 = r8.mDestination;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r13 == 0) goto L_0x04c3;
    L_0x04a3:
        r9 = java.lang.Integer.parseInt(r13);	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
    L_0x04a7:
        r2 = com.igexin.download.C3708h.m15191a(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r3 = r2.f12502a;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r3 != 0) goto L_0x04c5;
    L_0x04af:
        r3 = r2.f12504c;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r29.abort();	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1143, IllegalAccessException -> 0x0fd4, InvocationTargetException -> 0x0e65, all -> 0x0ce8 }
        r2 = r11;
        r8 = r12;
        r10 = r7;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r11 = r14;
        r7 = r15;
        goto L_0x027b;
    L_0x04c3:
        r9 = 0;
        goto L_0x04a7;
    L_0x04c5:
        r14 = r2.f12502a;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r12 = r2.f12503b;	 Catch:{ FileNotFoundException -> 0x13ba, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r3 = new android.content.ContentValues;	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r2 = "_data";
        r3.put(r2, r14);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        if (r26 == 0) goto L_0x04dc;
    L_0x04d5:
        r2 = "etag";
        r0 = r26;
        r3.put(r2, r0);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
    L_0x04dc:
        if (r7 == 0) goto L_0x04e3;
    L_0x04de:
        r2 = "mimetype";
        r3.put(r2, r7);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
    L_0x04e3:
        r2 = -1;
        if (r13 == 0) goto L_0x04ea;
    L_0x04e6:
        r2 = java.lang.Integer.parseInt(r13);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
    L_0x04ea:
        r4 = "total_bytes";
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r3.put(r4, r2);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r0 = r33;
        r2 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r2 = r2.getContentResolver();	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r4 = 0;
        r5 = 0;
        r0 = r27;
        r2.update(r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x13cd, RuntimeException -> 0x1275, ClassNotFoundException -> 0x1133, IllegalAccessException -> 0x0fc4, InvocationTargetException -> 0x0e55, all -> 0x0cd3 }
        r2 = r12;
        r5 = r14;
        r14 = r13;
    L_0x0505:
        r3 = r10.getEntity();	 Catch:{ IOException -> 0x056c }
        r26 = r3.getContent();	 Catch:{ IOException -> 0x056c }
        r13 = r23;
        r3 = r11;
        r4 = r15;
        r10 = r24;
    L_0x0513:
        r0 = r26;
        r1 = r28;
        r8 = r0.read(r1);	 Catch:{ IOException -> 0x05a0 }
        r6 = -1;
        if (r8 != r6) goto L_0x0626;
    L_0x051e:
        r6 = new android.content.ContentValues;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6.<init>();	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r8 = "current_bytes";
        r9 = java.lang.Integer.valueOf(r23);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6.put(r8, r9);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        if (r14 != 0) goto L_0x0537;
    L_0x052e:
        r8 = "total_bytes";
        r9 = java.lang.Integer.valueOf(r23);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6.put(r8, r9);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
    L_0x0537:
        r0 = r33;
        r8 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r8 = r8.getContentResolver();	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r9 = 0;
        r10 = 0;
        r0 = r27;
        r8.update(r0, r6, r9, r10);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        if (r14 == 0) goto L_0x074b;
    L_0x0548:
        r6 = java.lang.Integer.parseInt(r14);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r0 = r23;
        if (r0 == r6) goto L_0x074b;
    L_0x0550:
        r0 = r33;
        r6 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6 = com.igexin.download.C3708h.m15198a(r6);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        if (r6 != 0) goto L_0x05f6;
    L_0x055a:
        r6 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r8 = r2;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r4;
        r2 = r3;
        r5 = r18;
        r4 = r19;
        r3 = r6;
        r6 = r17;
        goto L_0x027b;
    L_0x056c:
        r3 = move-exception;
        r0 = r33;
        r3 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x13e0, RuntimeException -> 0x1283, ClassNotFoundException -> 0x1151, IllegalAccessException -> 0x0fe2, InvocationTargetException -> 0x0e73, all -> 0x0cfb }
        r3 = com.igexin.download.C3708h.m15198a(r3);	 Catch:{ FileNotFoundException -> 0x13e0, RuntimeException -> 0x1283, ClassNotFoundException -> 0x1151, IllegalAccessException -> 0x0fe2, InvocationTargetException -> 0x0e73, all -> 0x0cfb }
        if (r3 != 0) goto L_0x058b;
    L_0x0577:
        r3 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r4 = r19;
    L_0x057b:
        r29.abort();	 Catch:{ FileNotFoundException -> 0x13f3, RuntimeException -> 0x1292, ClassNotFoundException -> 0x1162, IllegalAccessException -> 0x0ff3, InvocationTargetException -> 0x0e84, all -> 0x0d0e }
        r8 = r2;
        r10 = r7;
        r9 = r16;
        r6 = r17;
        r7 = r15;
        r2 = r11;
        r11 = r5;
        r5 = r18;
        goto L_0x027b;
    L_0x058b:
        r0 = r33;
        r3 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x13e0, RuntimeException -> 0x1283, ClassNotFoundException -> 0x1151, IllegalAccessException -> 0x0fe2, InvocationTargetException -> 0x0e73, all -> 0x0cfb }
        r3 = r3.mNumFailed;	 Catch:{ FileNotFoundException -> 0x13e0, RuntimeException -> 0x1283, ClassNotFoundException -> 0x1151, IllegalAccessException -> 0x0fe2, InvocationTargetException -> 0x0e73, all -> 0x0cfb }
        r4 = 5;
        if (r3 >= r4) goto L_0x059b;
    L_0x0594:
        r3 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r19 = 1;
        r4 = r19;
        goto L_0x057b;
    L_0x059b:
        r3 = 495; // 0x1ef float:6.94E-43 double:2.446E-321;
        r4 = r19;
        goto L_0x057b;
    L_0x05a0:
        r6 = move-exception;
        r6 = new android.content.ContentValues;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6.<init>();	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r8 = "current_bytes";
        r9 = java.lang.Integer.valueOf(r23);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6.put(r8, r9);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r0 = r33;
        r8 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r8 = r8.getContentResolver();	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r9 = 0;
        r10 = 0;
        r0 = r27;
        r8.update(r0, r6, r9, r10);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r0 = r33;
        r6 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6 = com.igexin.download.C3708h.m15198a(r6);	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        if (r6 != 0) goto L_0x05e1;
    L_0x05c8:
        r8 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r6 = r19;
    L_0x05cc:
        r29.abort();	 Catch:{ FileNotFoundException -> 0x1418, RuntimeException -> 0x12af, ClassNotFoundException -> 0x1181, IllegalAccessException -> 0x1012, InvocationTargetException -> 0x0ea3, all -> 0x0d30 }
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r4;
        r5 = r18;
        r4 = r6;
        r6 = r17;
        r32 = r2;
        r2 = r3;
        r3 = r8;
        r8 = r32;
        goto L_0x027b;
    L_0x05e1:
        r0 = r33;
        r6 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6 = r6.mNumFailed;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r8 = 5;
        if (r6 >= r8) goto L_0x05f1;
    L_0x05ea:
        r8 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r19 = 1;
        r6 = r19;
        goto L_0x05cc;
    L_0x05f1:
        r8 = 495; // 0x1ef float:6.94E-43 double:2.446E-321;
        r6 = r19;
        goto L_0x05cc;
    L_0x05f6:
        r0 = r33;
        r6 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r6 = r6.mNumFailed;	 Catch:{ FileNotFoundException -> 0x1404, RuntimeException -> 0x129f, ClassNotFoundException -> 0x116f, IllegalAccessException -> 0x1000, InvocationTargetException -> 0x0e91, all -> 0x0d1d }
        r8 = 5;
        if (r6 >= r8) goto L_0x0614;
    L_0x05ff:
        r8 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r6 = 1;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r4;
        r5 = r18;
        r4 = r6;
        r6 = r17;
        r32 = r2;
        r2 = r3;
        r3 = r8;
        r8 = r32;
        goto L_0x027b;
    L_0x0614:
        r6 = 495; // 0x1ef float:6.94E-43 double:2.446E-321;
        r8 = r2;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r4;
        r2 = r3;
        r5 = r18;
        r4 = r19;
        r3 = r6;
        r6 = r17;
        goto L_0x027b;
    L_0x0626:
        r6 = 1;
    L_0x0627:
        if (r2 != 0) goto L_0x0630;
    L_0x0629:
        r4 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0698 }
        r9 = 1;
        r4.<init>(r5, r9);	 Catch:{ IOException -> 0x0698 }
        r2 = r4;
    L_0x0630:
        r4 = 0;
        r0 = r28;
        r2.write(r0, r4, r8);	 Catch:{ IOException -> 0x0698 }
        r0 = r33;
        r4 = r0.f12512b;	 Catch:{ IOException -> 0x0698 }
        r4 = r4.mDestination;	 Catch:{ IOException -> 0x0698 }
        if (r4 != 0) goto L_0x0642;
    L_0x063e:
        r2.close();	 Catch:{ IOException -> 0x0baa }
        r2 = 0;
    L_0x0642:
        r12 = r23 + r8;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r4 = r12 - r13;
        r15 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        if (r4 <= r15) goto L_0x1462;
    L_0x064e:
        r24 = r8 - r10;
        r30 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r4 = (r24 > r30 ? 1 : (r24 == r30 ? 0 : -1));
        if (r4 <= 0) goto L_0x1462;
    L_0x0656:
        r4 = new android.content.ContentValues;	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r10 = "current_bytes";
        r11 = java.lang.Integer.valueOf(r12);	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r4.put(r10, r11);	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r0 = r33;
        r10 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r10 = r10.getContentResolver();	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r11 = 0;
        r13 = 0;
        r0 = r27;
        r10.update(r0, r4, r11, r13);	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r4 = r12;
    L_0x0674:
        r0 = r33;
        r10 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        monitor-enter(r10);	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r0 = r33;
        r11 = r0.f12512b;	 Catch:{ all -> 0x06eb }
        r11 = r11.mControl;	 Catch:{ all -> 0x06eb }
        r13 = 1;
        if (r11 != r13) goto L_0x06ce;
    L_0x0682:
        r4 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r29.abort();	 Catch:{ all -> 0x1445 }
        monitor-exit(r10);	 Catch:{ all -> 0x1445 }
        r8 = r2;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r6;
        r2 = r3;
        r5 = r18;
        r6 = r17;
        r3 = r4;
        r4 = r19;
        goto L_0x027b;
    L_0x0698:
        r4 = move-exception;
        r4 = r2;
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ FileNotFoundException -> 0x142b, RuntimeException -> 0x12ce, ClassNotFoundException -> 0x11a3, IllegalAccessException -> 0x1034, InvocationTargetException -> 0x0ec5, all -> 0x0d54 }
        r9 = "mounted";
        r2 = r2.equals(r9);	 Catch:{ FileNotFoundException -> 0x142b, RuntimeException -> 0x12ce, ClassNotFoundException -> 0x11a3, IllegalAccessException -> 0x1034, InvocationTargetException -> 0x0ec5, all -> 0x0d54 }
        if (r2 != 0) goto L_0x06ab;
    L_0x06a6:
        r2 = 1;
    L_0x06a7:
        r3 = r2;
        r2 = r4;
        goto L_0x0627;
    L_0x06ab:
        r0 = r33;
        r2 = r0.f12511a;	 Catch:{ FileNotFoundException -> 0x142b, RuntimeException -> 0x12ce, ClassNotFoundException -> 0x11a3, IllegalAccessException -> 0x1034, InvocationTargetException -> 0x0ec5, all -> 0x0d54 }
        r24 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = r24;
        r2 = com.igexin.download.C3708h.m15199a(r2, r0);	 Catch:{ FileNotFoundException -> 0x142b, RuntimeException -> 0x12ce, ClassNotFoundException -> 0x11a3, IllegalAccessException -> 0x1034, InvocationTargetException -> 0x0ec5, all -> 0x0d54 }
        if (r2 != 0) goto L_0x1466;
    L_0x06b9:
        r2 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
        r8 = r4;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r6;
        r5 = r18;
        r4 = r19;
        r6 = r17;
        r32 = r3;
        r3 = r2;
        r2 = r32;
        goto L_0x027b;
    L_0x06ce:
        monitor-exit(r10);	 Catch:{ all -> 0x06eb }
        r0 = r33;
        r10 = r0.f12512b;	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r10 = r10.mStatus;	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x1191, IllegalAccessException -> 0x1022, InvocationTargetException -> 0x0eb3, all -> 0x0d41 }
        r11 = 490; // 0x1ea float:6.87E-43 double:2.42E-321;
        if (r10 != r11) goto L_0x0744;
    L_0x06d9:
        r4 = 490; // 0x1ea float:6.87E-43 double:2.42E-321;
        r8 = r2;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r6;
        r2 = r3;
        r5 = r18;
        r6 = r17;
        r3 = r4;
        r4 = r19;
        goto L_0x027b;
    L_0x06eb:
        r4 = move-exception;
        r8 = r20;
    L_0x06ee:
        monitor-exit(r10);	 Catch:{ all -> 0x144d }
        throw r4;	 Catch:{ FileNotFoundException -> 0x06f0, RuntimeException -> 0x12be, ClassNotFoundException -> 0x11b5, IllegalAccessException -> 0x1046, InvocationTargetException -> 0x0ed7, all -> 0x0d67 }
    L_0x06f0:
        r4 = move-exception;
        r11 = r3;
        r12 = r22;
        r13 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r4 = r19;
        r2 = r21;
        r5 = r18;
        r7 = r6;
        r6 = r17;
    L_0x0702:
        r3 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
        r0 = r33;
        r14 = r0.f12512b;
        r15 = 0;
        r14.mHasActiveThread = r15;
        if (r2 == 0) goto L_0x0710;
    L_0x070d:
        r2.release();
    L_0x0710:
        if (r12 == 0) goto L_0x0725;
    L_0x0712:
        r2 = r12.getClass();
        r14 = "close";
        r15 = 0;
        r15 = new java.lang.Class[r15];	 Catch:{ Exception -> 0x12ea }
        r2 = r2.getMethod(r14, r15);	 Catch:{ Exception -> 0x12ea }
        r14 = 0;
        r14 = new java.lang.Object[r14];	 Catch:{ Exception -> 0x12ea }
        r2.invoke(r12, r14);	 Catch:{ Exception -> 0x12ea }
    L_0x0725:
        if (r13 == 0) goto L_0x072a;
    L_0x0727:
        r13.close();	 Catch:{ IOException -> 0x0bb0 }
    L_0x072a:
        if (r8 == 0) goto L_0x073d;
    L_0x072c:
        r2 = com.igexin.download.Downloads.isStatusError(r3);
        if (r2 == 0) goto L_0x07ca;
    L_0x0732:
        if (r11 != 0) goto L_0x073d;
    L_0x0734:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x073d:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x00d5;
    L_0x0744:
        r10 = r8;
        r13 = r4;
        r23 = r12;
        r4 = r6;
        goto L_0x0513;
    L_0x074b:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r8 = r2;
        r10 = r7;
        r11 = r5;
        r9 = r16;
        r7 = r4;
        r2 = r3;
        r5 = r18;
        r4 = r19;
        r3 = r6;
        r6 = r17;
        goto L_0x027b;
    L_0x075d:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x145f;
    L_0x0763:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x143f }
        r12 = r2.getMethods();	 Catch:{ Exception -> 0x143f }
        r2 = 0;
        r8 = 0;
    L_0x076f:
        r13 = r12.length;	 Catch:{ Exception -> 0x143f }
        if (r8 >= r13) goto L_0x0782;
    L_0x0772:
        r13 = r12[r8];	 Catch:{ Exception -> 0x143f }
        r13 = r13.getName();	 Catch:{ Exception -> 0x143f }
        r14 = "setPermissions";
        r13 = r13.endsWith(r14);	 Catch:{ Exception -> 0x143f }
        if (r13 == 0) goto L_0x07b7;
    L_0x0780:
        r2 = r12[r8];	 Catch:{ Exception -> 0x143f }
    L_0x0782:
        if (r2 == 0) goto L_0x07a7;
    L_0x0784:
        r8 = 0;
        r12 = 4;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x143f }
        r13 = 0;
        r12[r13] = r11;	 Catch:{ Exception -> 0x143f }
        r13 = 1;
        r14 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x143f }
        r12[r13] = r14;	 Catch:{ Exception -> 0x143f }
        r13 = 2;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x143f }
        r12[r13] = r14;	 Catch:{ Exception -> 0x143f }
        r13 = 3;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x143f }
        r12[r13] = r14;	 Catch:{ Exception -> 0x143f }
        r2.invoke(r8, r12);	 Catch:{ Exception -> 0x143f }
    L_0x07a7:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x07ba, SyncFailedException -> 0x07be, IOException -> 0x07c2, RuntimeException -> 0x07c6 }
        r8 = 1;
        r2.<init>(r11, r8);	 Catch:{ FileNotFoundException -> 0x07ba, SyncFailedException -> 0x07be, IOException -> 0x07c2, RuntimeException -> 0x07c6 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x07ba, SyncFailedException -> 0x07be, IOException -> 0x07c2, RuntimeException -> 0x07c6 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x07ba, SyncFailedException -> 0x07be, IOException -> 0x07c2, RuntimeException -> 0x07c6 }
        r8 = r11;
        goto L_0x02b7;
    L_0x07b7:
        r8 = r8 + 1;
        goto L_0x076f;
    L_0x07ba:
        r2 = move-exception;
        r8 = r11;
        goto L_0x02b7;
    L_0x07be:
        r2 = move-exception;
        r8 = r11;
        goto L_0x02b7;
    L_0x07c2:
        r2 = move-exception;
        r8 = r11;
        goto L_0x02b7;
    L_0x07c6:
        r2 = move-exception;
        r8 = r11;
        goto L_0x02b7;
    L_0x07ca:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x073d;
    L_0x07d0:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x12e7 }
        r12 = r2.getMethods();	 Catch:{ Exception -> 0x12e7 }
        r2 = 0;
        r11 = 0;
    L_0x07dc:
        r13 = r12.length;	 Catch:{ Exception -> 0x12e7 }
        if (r11 >= r13) goto L_0x07ef;
    L_0x07df:
        r13 = r12[r11];	 Catch:{ Exception -> 0x12e7 }
        r13 = r13.getName();	 Catch:{ Exception -> 0x12e7 }
        r14 = "setPermissions";
        r13 = r13.endsWith(r14);	 Catch:{ Exception -> 0x12e7 }
        if (r13 == 0) goto L_0x0826;
    L_0x07ed:
        r2 = r12[r11];	 Catch:{ Exception -> 0x12e7 }
    L_0x07ef:
        if (r2 == 0) goto L_0x0814;
    L_0x07f1:
        r11 = 0;
        r12 = 4;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x12e7 }
        r13 = 0;
        r12[r13] = r8;	 Catch:{ Exception -> 0x12e7 }
        r13 = 1;
        r14 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x12e7 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x12e7 }
        r13 = 2;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x12e7 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x12e7 }
        r13 = 3;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x12e7 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x12e7 }
        r2.invoke(r11, r12);	 Catch:{ Exception -> 0x12e7 }
    L_0x0814:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0823, SyncFailedException -> 0x12e4, IOException -> 0x12e1, RuntimeException -> 0x12de }
        r11 = 1;
        r2.<init>(r8, r11);	 Catch:{ FileNotFoundException -> 0x0823, SyncFailedException -> 0x12e4, IOException -> 0x12e1, RuntimeException -> 0x12de }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x0823, SyncFailedException -> 0x12e4, IOException -> 0x12e1, RuntimeException -> 0x12de }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x0823, SyncFailedException -> 0x12e4, IOException -> 0x12e1, RuntimeException -> 0x12de }
        goto L_0x073d;
    L_0x0823:
        r2 = move-exception;
        goto L_0x073d;
    L_0x0826:
        r11 = r11 + 1;
        goto L_0x07dc;
    L_0x0829:
        r2 = move-exception;
        r21 = r3;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
    L_0x083a:
        r3 = 491; // 0x1eb float:6.88E-43 double:2.426E-321;
        r0 = r33;
        r2 = r0.f12512b;
        r13 = 0;
        r2.mHasActiveThread = r13;
        if (r21 == 0) goto L_0x0848;
    L_0x0845:
        r21.release();
    L_0x0848:
        if (r22 == 0) goto L_0x085f;
    L_0x084a:
        r2 = r22.getClass();
        r13 = "close";
        r14 = 0;
        r14 = new java.lang.Class[r14];	 Catch:{ Exception -> 0x11d2 }
        r2 = r2.getMethod(r13, r14);	 Catch:{ Exception -> 0x11d2 }
        r13 = 0;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x11d2 }
        r0 = r22;
        r2.invoke(r0, r13);	 Catch:{ Exception -> 0x11d2 }
    L_0x085f:
        if (r12 == 0) goto L_0x0864;
    L_0x0861:
        r12.close();	 Catch:{ IOException -> 0x0bb3 }
    L_0x0864:
        if (r8 == 0) goto L_0x0877;
    L_0x0866:
        r2 = com.igexin.download.Downloads.isStatusError(r3);
        if (r2 == 0) goto L_0x087e;
    L_0x086c:
        if (r11 != 0) goto L_0x0877;
    L_0x086e:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x0877:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x00d5;
    L_0x087e:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x0877;
    L_0x0884:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x11cf }
        r12 = r2.getMethods();	 Catch:{ Exception -> 0x11cf }
        r2 = 0;
        r11 = 0;
    L_0x0890:
        r13 = r12.length;	 Catch:{ Exception -> 0x11cf }
        if (r11 >= r13) goto L_0x08a3;
    L_0x0893:
        r13 = r12[r11];	 Catch:{ Exception -> 0x11cf }
        r13 = r13.getName();	 Catch:{ Exception -> 0x11cf }
        r14 = "setPermissions";
        r13 = r13.endsWith(r14);	 Catch:{ Exception -> 0x11cf }
        if (r13 == 0) goto L_0x08d8;
    L_0x08a1:
        r2 = r12[r11];	 Catch:{ Exception -> 0x11cf }
    L_0x08a3:
        if (r2 == 0) goto L_0x08c8;
    L_0x08a5:
        r11 = 0;
        r12 = 4;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x11cf }
        r13 = 0;
        r12[r13] = r8;	 Catch:{ Exception -> 0x11cf }
        r13 = 1;
        r14 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x11cf }
        r12[r13] = r14;	 Catch:{ Exception -> 0x11cf }
        r13 = 2;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x11cf }
        r12[r13] = r14;	 Catch:{ Exception -> 0x11cf }
        r13 = 3;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x11cf }
        r12[r13] = r14;	 Catch:{ Exception -> 0x11cf }
        r2.invoke(r11, r12);	 Catch:{ Exception -> 0x11cf }
    L_0x08c8:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x08d6, SyncFailedException -> 0x11cc, IOException -> 0x11c9, RuntimeException -> 0x11c6 }
        r11 = 1;
        r2.<init>(r8, r11);	 Catch:{ FileNotFoundException -> 0x08d6, SyncFailedException -> 0x11cc, IOException -> 0x11c9, RuntimeException -> 0x11c6 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x08d6, SyncFailedException -> 0x11cc, IOException -> 0x11c9, RuntimeException -> 0x11c6 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x08d6, SyncFailedException -> 0x11cc, IOException -> 0x11c9, RuntimeException -> 0x11c6 }
        goto L_0x0877;
    L_0x08d6:
        r2 = move-exception;
        goto L_0x0877;
    L_0x08d8:
        r11 = r11 + 1;
        goto L_0x0890;
    L_0x08db:
        r2 = move-exception;
        r21 = r3;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
        r3 = r20;
    L_0x08ee:
        r0 = r33;
        r2 = r0.f12512b;
        r13 = 0;
        r2.mHasActiveThread = r13;
        if (r21 == 0) goto L_0x08fa;
    L_0x08f7:
        r21.release();
    L_0x08fa:
        if (r22 == 0) goto L_0x0911;
    L_0x08fc:
        r2 = r22.getClass();
        r13 = "close";
        r14 = 0;
        r14 = new java.lang.Class[r14];	 Catch:{ Exception -> 0x1063 }
        r2 = r2.getMethod(r13, r14);	 Catch:{ Exception -> 0x1063 }
        r13 = 0;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x1063 }
        r0 = r22;
        r2.invoke(r0, r13);	 Catch:{ Exception -> 0x1063 }
    L_0x0911:
        if (r12 == 0) goto L_0x0916;
    L_0x0913:
        r12.close();	 Catch:{ IOException -> 0x0bb6 }
    L_0x0916:
        if (r8 == 0) goto L_0x0929;
    L_0x0918:
        r2 = com.igexin.download.Downloads.isStatusError(r3);
        if (r2 == 0) goto L_0x0930;
    L_0x091e:
        if (r11 != 0) goto L_0x0929;
    L_0x0920:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x0929:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x00d5;
    L_0x0930:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x0929;
    L_0x0936:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x1060 }
        r12 = r2.getMethods();	 Catch:{ Exception -> 0x1060 }
        r2 = 0;
        r11 = 0;
    L_0x0942:
        r13 = r12.length;	 Catch:{ Exception -> 0x1060 }
        if (r11 >= r13) goto L_0x0955;
    L_0x0945:
        r13 = r12[r11];	 Catch:{ Exception -> 0x1060 }
        r13 = r13.getName();	 Catch:{ Exception -> 0x1060 }
        r14 = "setPermissions";
        r13 = r13.endsWith(r14);	 Catch:{ Exception -> 0x1060 }
        if (r13 == 0) goto L_0x098a;
    L_0x0953:
        r2 = r12[r11];	 Catch:{ Exception -> 0x1060 }
    L_0x0955:
        if (r2 == 0) goto L_0x097a;
    L_0x0957:
        r11 = 0;
        r12 = 4;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x1060 }
        r13 = 0;
        r12[r13] = r8;	 Catch:{ Exception -> 0x1060 }
        r13 = 1;
        r14 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x1060 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x1060 }
        r13 = 2;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x1060 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x1060 }
        r13 = 3;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x1060 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x1060 }
        r2.invoke(r11, r12);	 Catch:{ Exception -> 0x1060 }
    L_0x097a:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0988, SyncFailedException -> 0x105d, IOException -> 0x105a, RuntimeException -> 0x1057 }
        r11 = 1;
        r2.<init>(r8, r11);	 Catch:{ FileNotFoundException -> 0x0988, SyncFailedException -> 0x105d, IOException -> 0x105a, RuntimeException -> 0x1057 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x0988, SyncFailedException -> 0x105d, IOException -> 0x105a, RuntimeException -> 0x1057 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x0988, SyncFailedException -> 0x105d, IOException -> 0x105a, RuntimeException -> 0x1057 }
        goto L_0x0929;
    L_0x0988:
        r2 = move-exception;
        goto L_0x0929;
    L_0x098a:
        r11 = r11 + 1;
        goto L_0x0942;
    L_0x098d:
        r2 = move-exception;
        r21 = r3;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
        r3 = r20;
    L_0x09a0:
        r0 = r33;
        r2 = r0.f12512b;
        r13 = 0;
        r2.mHasActiveThread = r13;
        if (r21 == 0) goto L_0x09ac;
    L_0x09a9:
        r21.release();
    L_0x09ac:
        if (r22 == 0) goto L_0x09c3;
    L_0x09ae:
        r2 = r22.getClass();
        r13 = "close";
        r14 = 0;
        r14 = new java.lang.Class[r14];	 Catch:{ Exception -> 0x0ef4 }
        r2 = r2.getMethod(r13, r14);	 Catch:{ Exception -> 0x0ef4 }
        r13 = 0;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x0ef4 }
        r0 = r22;
        r2.invoke(r0, r13);	 Catch:{ Exception -> 0x0ef4 }
    L_0x09c3:
        if (r12 == 0) goto L_0x09c8;
    L_0x09c5:
        r12.close();	 Catch:{ IOException -> 0x0bb9 }
    L_0x09c8:
        if (r8 == 0) goto L_0x09db;
    L_0x09ca:
        r2 = com.igexin.download.Downloads.isStatusError(r3);
        if (r2 == 0) goto L_0x09e2;
    L_0x09d0:
        if (r11 != 0) goto L_0x09db;
    L_0x09d2:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x09db:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x00d5;
    L_0x09e2:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x09db;
    L_0x09e8:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x0ef1 }
        r12 = r2.getMethods();	 Catch:{ Exception -> 0x0ef1 }
        r2 = 0;
        r11 = 0;
    L_0x09f4:
        r13 = r12.length;	 Catch:{ Exception -> 0x0ef1 }
        if (r11 >= r13) goto L_0x0a07;
    L_0x09f7:
        r13 = r12[r11];	 Catch:{ Exception -> 0x0ef1 }
        r13 = r13.getName();	 Catch:{ Exception -> 0x0ef1 }
        r14 = "setPermissions";
        r13 = r13.endsWith(r14);	 Catch:{ Exception -> 0x0ef1 }
        if (r13 == 0) goto L_0x0a3c;
    L_0x0a05:
        r2 = r12[r11];	 Catch:{ Exception -> 0x0ef1 }
    L_0x0a07:
        if (r2 == 0) goto L_0x0a2c;
    L_0x0a09:
        r11 = 0;
        r12 = 4;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x0ef1 }
        r13 = 0;
        r12[r13] = r8;	 Catch:{ Exception -> 0x0ef1 }
        r13 = 1;
        r14 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0ef1 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x0ef1 }
        r13 = 2;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0ef1 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x0ef1 }
        r13 = 3;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0ef1 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x0ef1 }
        r2.invoke(r11, r12);	 Catch:{ Exception -> 0x0ef1 }
    L_0x0a2c:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0a3a, SyncFailedException -> 0x0eee, IOException -> 0x0eeb, RuntimeException -> 0x0ee8 }
        r11 = 1;
        r2.<init>(r8, r11);	 Catch:{ FileNotFoundException -> 0x0a3a, SyncFailedException -> 0x0eee, IOException -> 0x0eeb, RuntimeException -> 0x0ee8 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x0a3a, SyncFailedException -> 0x0eee, IOException -> 0x0eeb, RuntimeException -> 0x0ee8 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x0a3a, SyncFailedException -> 0x0eee, IOException -> 0x0eeb, RuntimeException -> 0x0ee8 }
        goto L_0x09db;
    L_0x0a3a:
        r2 = move-exception;
        goto L_0x09db;
    L_0x0a3c:
        r11 = r11 + 1;
        goto L_0x09f4;
    L_0x0a3f:
        r2 = move-exception;
        r21 = r3;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
        r3 = r20;
    L_0x0a52:
        r0 = r33;
        r2 = r0.f12512b;
        r13 = 0;
        r2.mHasActiveThread = r13;
        if (r21 == 0) goto L_0x0a5e;
    L_0x0a5b:
        r21.release();
    L_0x0a5e:
        if (r22 == 0) goto L_0x0a75;
    L_0x0a60:
        r2 = r22.getClass();
        r13 = "close";
        r14 = 0;
        r14 = new java.lang.Class[r14];	 Catch:{ Exception -> 0x0d85 }
        r2 = r2.getMethod(r13, r14);	 Catch:{ Exception -> 0x0d85 }
        r13 = 0;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x0d85 }
        r0 = r22;
        r2.invoke(r0, r13);	 Catch:{ Exception -> 0x0d85 }
    L_0x0a75:
        if (r12 == 0) goto L_0x0a7a;
    L_0x0a77:
        r12.close();	 Catch:{ IOException -> 0x0bbc }
    L_0x0a7a:
        if (r8 == 0) goto L_0x0a8d;
    L_0x0a7c:
        r2 = com.igexin.download.Downloads.isStatusError(r3);
        if (r2 == 0) goto L_0x0a94;
    L_0x0a82:
        if (r11 != 0) goto L_0x0a8d;
    L_0x0a84:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x0a8d:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x00d5;
    L_0x0a94:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x0a8d;
    L_0x0a9a:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x0d82 }
        r12 = r2.getMethods();	 Catch:{ Exception -> 0x0d82 }
        r2 = 0;
        r11 = 0;
    L_0x0aa6:
        r13 = r12.length;	 Catch:{ Exception -> 0x0d82 }
        if (r11 >= r13) goto L_0x0ab9;
    L_0x0aa9:
        r13 = r12[r11];	 Catch:{ Exception -> 0x0d82 }
        r13 = r13.getName();	 Catch:{ Exception -> 0x0d82 }
        r14 = "setPermissions";
        r13 = r13.endsWith(r14);	 Catch:{ Exception -> 0x0d82 }
        if (r13 == 0) goto L_0x0aee;
    L_0x0ab7:
        r2 = r12[r11];	 Catch:{ Exception -> 0x0d82 }
    L_0x0ab9:
        if (r2 == 0) goto L_0x0ade;
    L_0x0abb:
        r11 = 0;
        r12 = 4;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x0d82 }
        r13 = 0;
        r12[r13] = r8;	 Catch:{ Exception -> 0x0d82 }
        r13 = 1;
        r14 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0d82 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x0d82 }
        r13 = 2;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0d82 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x0d82 }
        r13 = 3;
        r14 = -1;
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0d82 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x0d82 }
        r2.invoke(r11, r12);	 Catch:{ Exception -> 0x0d82 }
    L_0x0ade:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0aec, SyncFailedException -> 0x0d7f, IOException -> 0x0d7c, RuntimeException -> 0x0d79 }
        r11 = 1;
        r2.<init>(r8, r11);	 Catch:{ FileNotFoundException -> 0x0aec, SyncFailedException -> 0x0d7f, IOException -> 0x0d7c, RuntimeException -> 0x0d79 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x0aec, SyncFailedException -> 0x0d7f, IOException -> 0x0d7c, RuntimeException -> 0x0d79 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x0aec, SyncFailedException -> 0x0d7f, IOException -> 0x0d7c, RuntimeException -> 0x0d79 }
        goto L_0x0a8d;
    L_0x0aec:
        r2 = move-exception;
        goto L_0x0a8d;
    L_0x0aee:
        r11 = r11 + 1;
        goto L_0x0aa6;
    L_0x0af1:
        r2 = move-exception;
        r21 = r3;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
        r3 = r20;
        r32 = r11;
        r11 = r2;
        r2 = r32;
    L_0x0b09:
        r0 = r33;
        r13 = r0.f12512b;
        r14 = 0;
        r13.mHasActiveThread = r14;
        if (r21 == 0) goto L_0x0b15;
    L_0x0b12:
        r21.release();
    L_0x0b15:
        if (r22 == 0) goto L_0x0b2c;
    L_0x0b17:
        r13 = r22.getClass();
        r14 = "close";
        r15 = 0;
        r15 = new java.lang.Class[r15];	 Catch:{ Exception -> 0x0bcc }
        r13 = r13.getMethod(r14, r15);	 Catch:{ Exception -> 0x0bcc }
        r14 = 0;
        r14 = new java.lang.Object[r14];	 Catch:{ Exception -> 0x0bcc }
        r0 = r22;
        r13.invoke(r0, r14);	 Catch:{ Exception -> 0x0bcc }
    L_0x0b2c:
        if (r12 == 0) goto L_0x0b31;
    L_0x0b2e:
        r12.close();	 Catch:{ IOException -> 0x0bbf }
    L_0x0b31:
        if (r8 == 0) goto L_0x0b44;
    L_0x0b33:
        r12 = com.igexin.download.Downloads.isStatusError(r3);
        if (r12 == 0) goto L_0x0b4a;
    L_0x0b39:
        if (r2 != 0) goto L_0x0b44;
    L_0x0b3b:
        r2 = new java.io.File;
        r2.<init>(r8);
        r2.delete();
        r8 = 0;
    L_0x0b44:
        r2 = r33;
        r2.m15189a(r3, r4, r5, r6, r7, r8, r9, r10);
        throw r11;
    L_0x0b4a:
        r2 = com.igexin.download.Downloads.isStatusSuccess(r3);
        if (r2 == 0) goto L_0x0b44;
    L_0x0b50:
        r2 = "android.os.FileUtils";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x0bca }
        r13 = r2.getMethods();	 Catch:{ Exception -> 0x0bca }
        r2 = 0;
        r12 = 0;
    L_0x0b5c:
        r14 = r13.length;	 Catch:{ Exception -> 0x0bca }
        if (r12 >= r14) goto L_0x0b6f;
    L_0x0b5f:
        r14 = r13[r12];	 Catch:{ Exception -> 0x0bca }
        r14 = r14.getName();	 Catch:{ Exception -> 0x0bca }
        r15 = "setPermissions";
        r14 = r14.endsWith(r15);	 Catch:{ Exception -> 0x0bca }
        if (r14 == 0) goto L_0x0ba4;
    L_0x0b6d:
        r2 = r13[r12];	 Catch:{ Exception -> 0x0bca }
    L_0x0b6f:
        if (r2 == 0) goto L_0x0b94;
    L_0x0b71:
        r12 = 0;
        r13 = 4;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x0bca }
        r14 = 0;
        r13[r14] = r8;	 Catch:{ Exception -> 0x0bca }
        r14 = 1;
        r15 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Exception -> 0x0bca }
        r13[r14] = r15;	 Catch:{ Exception -> 0x0bca }
        r14 = 2;
        r15 = -1;
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Exception -> 0x0bca }
        r13[r14] = r15;	 Catch:{ Exception -> 0x0bca }
        r14 = 3;
        r15 = -1;
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Exception -> 0x0bca }
        r13[r14] = r15;	 Catch:{ Exception -> 0x0bca }
        r2.invoke(r12, r13);	 Catch:{ Exception -> 0x0bca }
    L_0x0b94:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0ba2, SyncFailedException -> 0x0bc7, IOException -> 0x0bc4, RuntimeException -> 0x0bc2 }
        r12 = 1;
        r2.<init>(r8, r12);	 Catch:{ FileNotFoundException -> 0x0ba2, SyncFailedException -> 0x0bc7, IOException -> 0x0bc4, RuntimeException -> 0x0bc2 }
        r2 = r2.getFD();	 Catch:{ FileNotFoundException -> 0x0ba2, SyncFailedException -> 0x0bc7, IOException -> 0x0bc4, RuntimeException -> 0x0bc2 }
        r2.sync();	 Catch:{ FileNotFoundException -> 0x0ba2, SyncFailedException -> 0x0bc7, IOException -> 0x0bc4, RuntimeException -> 0x0bc2 }
        goto L_0x0b44;
    L_0x0ba2:
        r2 = move-exception;
        goto L_0x0b44;
    L_0x0ba4:
        r12 = r12 + 1;
        goto L_0x0b5c;
    L_0x0ba7:
        r2 = move-exception;
        goto L_0x00b5;
    L_0x0baa:
        r4 = move-exception;
        goto L_0x0642;
    L_0x0bad:
        r8 = move-exception;
        goto L_0x02a3;
    L_0x0bb0:
        r2 = move-exception;
        goto L_0x072a;
    L_0x0bb3:
        r2 = move-exception;
        goto L_0x0864;
    L_0x0bb6:
        r2 = move-exception;
        goto L_0x0916;
    L_0x0bb9:
        r2 = move-exception;
        goto L_0x09c8;
    L_0x0bbc:
        r2 = move-exception;
        goto L_0x0a7a;
    L_0x0bbf:
        r12 = move-exception;
        goto L_0x0b31;
    L_0x0bc2:
        r2 = move-exception;
        goto L_0x0b44;
    L_0x0bc4:
        r2 = move-exception;
        goto L_0x0b44;
    L_0x0bc7:
        r2 = move-exception;
        goto L_0x0b44;
    L_0x0bca:
        r2 = move-exception;
        goto L_0x0b94;
    L_0x0bcc:
        r13 = move-exception;
        goto L_0x0b2c;
    L_0x0bcf:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r5 = r18;
        r12 = r14;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0be7:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0bfe:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r14;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0c13:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r5 = r18;
        r12 = r14;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0c2b:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r2;
        r2 = r11;
        r11 = r3;
        r3 = r20;
        goto L_0x0b09;
    L_0x0c40:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r2;
        r2 = r11;
        r11 = r3;
        r3 = r20;
        goto L_0x0b09;
    L_0x0c55:
        r3 = move-exception;
        r12 = r2;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r2 = r11;
        r11 = r3;
        r3 = r20;
        goto L_0x0b09;
    L_0x0c68:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0c7d:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0c8e:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r32 = r11;
        r11 = r2;
        r2 = r32;
        goto L_0x0b09;
    L_0x0c9d:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r32 = r11;
        r11 = r2;
        r2 = r32;
        goto L_0x0b09;
    L_0x0cb0:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        r32 = r11;
        r11 = r2;
        r2 = r32;
        goto L_0x0b09;
    L_0x0cbf:
        r4 = move-exception;
        r11 = r4;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r32 = r3;
        r3 = r2;
        r2 = r32;
        goto L_0x0b09;
    L_0x0cd3:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        r32 = r2;
        r2 = r11;
        r11 = r32;
        goto L_0x0b09;
    L_0x0ce8:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r7 = r15;
        r32 = r11;
        r11 = r2;
        r2 = r32;
        goto L_0x0b09;
    L_0x0cfb:
        r3 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r2 = r11;
        r5 = r18;
        r7 = r15;
        r11 = r3;
        r3 = r20;
        goto L_0x0b09;
    L_0x0d0e:
        r6 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r15;
        r2 = r11;
        r5 = r18;
        r11 = r6;
        r6 = r17;
        goto L_0x0b09;
    L_0x0d1d:
        r6 = move-exception;
        r11 = r6;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r4;
        r2 = r3;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x0b09;
    L_0x0d30:
        r9 = move-exception;
        r11 = r9;
        r12 = r2;
        r10 = r7;
        r2 = r3;
        r7 = r4;
        r9 = r16;
        r4 = r6;
        r3 = r8;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x0b09;
    L_0x0d41:
        r4 = move-exception;
        r11 = r4;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r2 = r3;
        r5 = r18;
        r4 = r19;
        r6 = r17;
        r3 = r20;
        goto L_0x0b09;
    L_0x0d54:
        r2 = move-exception;
        r11 = r2;
        r12 = r4;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r2 = r3;
        r5 = r18;
        r4 = r19;
        r6 = r17;
        r3 = r20;
        goto L_0x0b09;
    L_0x0d67:
        r4 = move-exception;
        r11 = r4;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r7 = r6;
        r2 = r3;
        r4 = r19;
        r6 = r17;
        r3 = r8;
        r8 = r5;
        r5 = r18;
        goto L_0x0b09;
    L_0x0d79:
        r2 = move-exception;
        goto L_0x0a8d;
    L_0x0d7c:
        r2 = move-exception;
        goto L_0x0a8d;
    L_0x0d7f:
        r2 = move-exception;
        goto L_0x0a8d;
    L_0x0d82:
        r2 = move-exception;
        goto L_0x0ade;
    L_0x0d85:
        r2 = move-exception;
        goto L_0x0a75;
    L_0x0d88:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r5 = r18;
        goto L_0x0a52;
    L_0x0d9b:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        goto L_0x0a52;
    L_0x0dad:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r14;
        goto L_0x0a52;
    L_0x0dbd:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r5 = r18;
        goto L_0x0a52;
    L_0x0dd0:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r2;
        r5 = r18;
        goto L_0x0a52;
    L_0x0de3:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r2;
        goto L_0x0a52;
    L_0x0df6:
        r3 = move-exception;
        r12 = r2;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x0a52;
    L_0x0e07:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x0a52;
    L_0x0e17:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        goto L_0x0a52;
    L_0x0e23:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        goto L_0x0a52;
    L_0x0e2d:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        goto L_0x0a52;
    L_0x0e3b:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        goto L_0x0a52;
    L_0x0e45:
        r4 = move-exception;
        r11 = r3;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r2;
        goto L_0x0a52;
    L_0x0e55:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        goto L_0x0a52;
    L_0x0e65:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r7 = r15;
        goto L_0x0a52;
    L_0x0e73:
        r3 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        r5 = r18;
        goto L_0x0a52;
    L_0x0e84:
        r6 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r15;
        r5 = r18;
        goto L_0x0a52;
    L_0x0e91:
        r6 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r4;
        r5 = r18;
        r3 = r20;
        r4 = r19;
        goto L_0x0a52;
    L_0x0ea3:
        r9 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r7 = r4;
        r3 = r8;
        r4 = r6;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x0a52;
    L_0x0eb3:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r4 = r19;
        r5 = r18;
        r7 = r6;
        r3 = r20;
        r6 = r17;
        goto L_0x0a52;
    L_0x0ec5:
        r2 = move-exception;
        r11 = r3;
        r12 = r4;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r6 = r17;
        goto L_0x0a52;
    L_0x0ed7:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r4 = r19;
        r7 = r6;
        r3 = r8;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x0a52;
    L_0x0ee8:
        r2 = move-exception;
        goto L_0x09db;
    L_0x0eeb:
        r2 = move-exception;
        goto L_0x09db;
    L_0x0eee:
        r2 = move-exception;
        goto L_0x09db;
    L_0x0ef1:
        r2 = move-exception;
        goto L_0x0a2c;
    L_0x0ef4:
        r2 = move-exception;
        goto L_0x09c3;
    L_0x0ef7:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r5 = r18;
        goto L_0x09a0;
    L_0x0f0a:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        goto L_0x09a0;
    L_0x0f1c:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r14;
        goto L_0x09a0;
    L_0x0f2c:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r5 = r18;
        goto L_0x09a0;
    L_0x0f3f:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r2;
        r5 = r18;
        goto L_0x09a0;
    L_0x0f52:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r2;
        goto L_0x09a0;
    L_0x0f65:
        r3 = move-exception;
        r12 = r2;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x09a0;
    L_0x0f76:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x09a0;
    L_0x0f86:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        goto L_0x09a0;
    L_0x0f92:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        goto L_0x09a0;
    L_0x0f9c:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        goto L_0x09a0;
    L_0x0faa:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        goto L_0x09a0;
    L_0x0fb4:
        r4 = move-exception;
        r11 = r3;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r2;
        goto L_0x09a0;
    L_0x0fc4:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        goto L_0x09a0;
    L_0x0fd4:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r7 = r15;
        goto L_0x09a0;
    L_0x0fe2:
        r3 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        r5 = r18;
        goto L_0x09a0;
    L_0x0ff3:
        r6 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r15;
        r5 = r18;
        goto L_0x09a0;
    L_0x1000:
        r6 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r4;
        r5 = r18;
        r3 = r20;
        r4 = r19;
        goto L_0x09a0;
    L_0x1012:
        r9 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r7 = r4;
        r3 = r8;
        r4 = r6;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x09a0;
    L_0x1022:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r4 = r19;
        r5 = r18;
        r7 = r6;
        r3 = r20;
        r6 = r17;
        goto L_0x09a0;
    L_0x1034:
        r2 = move-exception;
        r11 = r3;
        r12 = r4;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r6 = r17;
        goto L_0x09a0;
    L_0x1046:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r4 = r19;
        r7 = r6;
        r3 = r8;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x09a0;
    L_0x1057:
        r2 = move-exception;
        goto L_0x0929;
    L_0x105a:
        r2 = move-exception;
        goto L_0x0929;
    L_0x105d:
        r2 = move-exception;
        goto L_0x0929;
    L_0x1060:
        r2 = move-exception;
        goto L_0x097a;
    L_0x1063:
        r2 = move-exception;
        goto L_0x0911;
    L_0x1066:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r5 = r18;
        goto L_0x08ee;
    L_0x1079:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        goto L_0x08ee;
    L_0x108b:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r14;
        goto L_0x08ee;
    L_0x109b:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r14;
        r5 = r18;
        goto L_0x08ee;
    L_0x10ae:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r12 = r2;
        r5 = r18;
        goto L_0x08ee;
    L_0x10c1:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r12 = r2;
        goto L_0x08ee;
    L_0x10d4:
        r3 = move-exception;
        r12 = r2;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x08ee;
    L_0x10e5:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        goto L_0x08ee;
    L_0x10f5:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        goto L_0x08ee;
    L_0x1101:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        goto L_0x08ee;
    L_0x110b:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        goto L_0x08ee;
    L_0x1119:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        goto L_0x08ee;
    L_0x1123:
        r4 = move-exception;
        r11 = r3;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r2;
        goto L_0x08ee;
    L_0x1133:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        goto L_0x08ee;
    L_0x1143:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r7 = r15;
        goto L_0x08ee;
    L_0x1151:
        r3 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r3 = r20;
        r7 = r15;
        r5 = r18;
        goto L_0x08ee;
    L_0x1162:
        r6 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r15;
        r5 = r18;
        goto L_0x08ee;
    L_0x116f:
        r6 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r4;
        r5 = r18;
        r3 = r20;
        r4 = r19;
        goto L_0x08ee;
    L_0x1181:
        r9 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r7 = r4;
        r3 = r8;
        r4 = r6;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x08ee;
    L_0x1191:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r4 = r19;
        r5 = r18;
        r7 = r6;
        r3 = r20;
        r6 = r17;
        goto L_0x08ee;
    L_0x11a3:
        r2 = move-exception;
        r11 = r3;
        r12 = r4;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r5 = r18;
        r4 = r19;
        r3 = r20;
        r6 = r17;
        goto L_0x08ee;
    L_0x11b5:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r9 = r16;
        r4 = r19;
        r7 = r6;
        r3 = r8;
        r8 = r5;
        r6 = r17;
        r5 = r18;
        goto L_0x08ee;
    L_0x11c6:
        r2 = move-exception;
        goto L_0x0877;
    L_0x11c9:
        r2 = move-exception;
        goto L_0x0877;
    L_0x11cc:
        r2 = move-exception;
        goto L_0x0877;
    L_0x11cf:
        r2 = move-exception;
        goto L_0x08c8;
    L_0x11d2:
        r2 = move-exception;
        goto L_0x085f;
    L_0x11d5:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
        goto L_0x083a;
    L_0x11e6:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r14;
        goto L_0x083a;
    L_0x11f6:
        r2 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r14;
        goto L_0x083a;
    L_0x1207:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r12 = r2;
        goto L_0x083a;
    L_0x1218:
        r3 = move-exception;
        r22 = r12;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r2;
        goto L_0x083a;
    L_0x1229:
        r3 = move-exception;
        r12 = r2;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        goto L_0x083a;
    L_0x1238:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        goto L_0x083a;
    L_0x1246:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        goto L_0x083a;
    L_0x1252:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        goto L_0x083a;
    L_0x125c:
        r2 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        goto L_0x083a;
    L_0x1266:
        r2 = move-exception;
        r11 = r3;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        goto L_0x083a;
    L_0x1275:
        r2 = move-exception;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r7 = r15;
        goto L_0x083a;
    L_0x1283:
        r3 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r7 = r15;
        goto L_0x083a;
    L_0x1292:
        r3 = move-exception;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r15;
        r5 = r18;
        goto L_0x083a;
    L_0x129f:
        r6 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r7 = r4;
        r5 = r18;
        r4 = r19;
        goto L_0x083a;
    L_0x12af:
        r8 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r4;
        r5 = r18;
        r4 = r6;
        r6 = r17;
        goto L_0x083a;
    L_0x12be:
        r4 = move-exception;
        r11 = r3;
        r12 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r4 = r19;
        r5 = r18;
        r7 = r6;
        r6 = r17;
        goto L_0x083a;
    L_0x12ce:
        r2 = move-exception;
        r11 = r3;
        r12 = r4;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r5 = r18;
        r4 = r19;
        r6 = r17;
        goto L_0x083a;
    L_0x12de:
        r2 = move-exception;
        goto L_0x073d;
    L_0x12e1:
        r2 = move-exception;
        goto L_0x073d;
    L_0x12e4:
        r2 = move-exception;
        goto L_0x073d;
    L_0x12e7:
        r2 = move-exception;
        goto L_0x0814;
    L_0x12ea:
        r2 = move-exception;
        goto L_0x0725;
    L_0x12ed:
        r2 = move-exception;
        r2 = r3;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r13 = r14;
        goto L_0x0702;
    L_0x12fd:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r13 = r14;
        goto L_0x0702;
    L_0x130e:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r13 = r14;
        goto L_0x0702;
    L_0x131e:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r13 = r14;
        goto L_0x0702;
    L_0x132f:
        r3 = move-exception;
        r10 = r13;
        r8 = r5;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r5 = r18;
        r13 = r2;
        r2 = r21;
        goto L_0x0702;
    L_0x1340:
        r3 = move-exception;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r13 = r2;
        r2 = r21;
        goto L_0x0702;
    L_0x1351:
        r3 = move-exception;
        r12 = r22;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r13 = r2;
        r2 = r21;
        goto L_0x0702;
    L_0x1364:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r13 = r12;
        r12 = r22;
        goto L_0x0702;
    L_0x1377:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r13 = r12;
        r12 = r22;
        goto L_0x0702;
    L_0x1388:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r13 = r12;
        r12 = r22;
        goto L_0x0702;
    L_0x1397:
        r2 = move-exception;
        r2 = r21;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r5 = r18;
        r4 = r19;
        r13 = r12;
        r12 = r22;
        goto L_0x0702;
    L_0x13a6:
        r2 = move-exception;
        r11 = r3;
        r2 = r21;
        r10 = r13;
        r8 = r14;
        r7 = r15;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r13 = r12;
        r12 = r22;
        goto L_0x0702;
    L_0x13ba:
        r2 = move-exception;
        r2 = r21;
        r13 = r12;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r22;
        r7 = r15;
        goto L_0x0702;
    L_0x13cd:
        r2 = move-exception;
        r2 = r21;
        r13 = r12;
        r10 = r7;
        r8 = r14;
        r9 = r16;
        r6 = r17;
        r5 = r18;
        r4 = r19;
        r12 = r22;
        r7 = r15;
        goto L_0x0702;
    L_0x13e0:
        r3 = move-exception;
        r12 = r22;
        r13 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r4 = r19;
        r7 = r15;
        r5 = r18;
        r2 = r21;
        goto L_0x0702;
    L_0x13f3:
        r3 = move-exception;
        r12 = r22;
        r13 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r2 = r21;
        r7 = r15;
        r5 = r18;
        goto L_0x0702;
    L_0x1404:
        r6 = move-exception;
        r11 = r3;
        r12 = r22;
        r13 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r6 = r17;
        r2 = r21;
        r7 = r4;
        r5 = r18;
        r4 = r19;
        goto L_0x0702;
    L_0x1418:
        r8 = move-exception;
        r11 = r3;
        r12 = r22;
        r13 = r2;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r4;
        r2 = r21;
        r5 = r18;
        r4 = r6;
        r6 = r17;
        goto L_0x0702;
    L_0x142b:
        r2 = move-exception;
        r11 = r3;
        r2 = r21;
        r12 = r22;
        r13 = r4;
        r10 = r7;
        r8 = r5;
        r9 = r16;
        r7 = r6;
        r5 = r18;
        r4 = r19;
        r6 = r17;
        goto L_0x0702;
    L_0x143f:
        r2 = move-exception;
        goto L_0x07a7;
    L_0x1442:
        r12 = move-exception;
        goto L_0x029e;
    L_0x1445:
        r8 = move-exception;
        r32 = r8;
        r8 = r4;
        r4 = r32;
        goto L_0x06ee;
    L_0x144d:
        r4 = move-exception;
        goto L_0x06ee;
    L_0x1450:
        r2 = move-exception;
        goto L_0x00c6;
    L_0x1453:
        r2 = move-exception;
        goto L_0x00c6;
    L_0x1456:
        r2 = move-exception;
        goto L_0x00c6;
    L_0x1459:
        r2 = move-exception;
        goto L_0x0120;
    L_0x145c:
        r2 = move-exception;
        goto L_0x00b0;
    L_0x145f:
        r8 = r11;
        goto L_0x02b7;
    L_0x1462:
        r8 = r10;
        r4 = r13;
        goto L_0x0674;
    L_0x1466:
        r2 = r3;
        goto L_0x06a7;
    L_0x1469:
        r13 = r4;
        goto L_0x0463;
    L_0x146c:
        r2 = r9;
        goto L_0x0454;
    L_0x146f:
        r26 = r8;
        goto L_0x0448;
    L_0x1473:
        r7 = r13;
        goto L_0x043a;
    L_0x1476:
        r5 = r7;
        goto L_0x0419;
    L_0x1479:
        r2 = r12;
        r7 = r13;
        r5 = r14;
        r14 = r4;
        goto L_0x0505;
    L_0x147f:
        r12 = r2;
        goto L_0x01bc;
    L_0x1482:
        r22 = r12;
        goto L_0x01ad;
    L_0x1486:
        r4 = r10;
        goto L_0x016a;
    L_0x1489:
        r5 = r8;
        goto L_0x014c;
    L_0x148c:
        r2 = r14;
        r14 = r8;
        r8 = r4;
        r4 = r10;
        goto L_0x0172;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.download.g.run():void");
    }
}
