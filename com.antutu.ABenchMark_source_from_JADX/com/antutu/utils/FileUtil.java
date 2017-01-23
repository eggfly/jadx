package com.antutu.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static final String ANTUTU_DIRECTOR = "Antutu";
    public static final String FILE_PATH;
    private static int bufferd;

    static {
        bufferd = IXAdIOUtils.BUFFER_SIZE;
        FILE_PATH = Environment.getExternalStorageDirectory() + File.separator + ANTUTU_DIRECTOR + File.separator;
    }

    private FileUtil() {
    }

    public static boolean createFile(String str) {
        return isFileExist(str) || new File(FILE_PATH + str).mkdirs();
    }

    public static String getAbsolutePath(String str) {
        return FILE_PATH + str;
    }

    public static long getSDAllSizeKB() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getSDAvalibleSizeKB() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static String getUrlLastString(String str) {
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public static boolean isFileExist(String str) {
        return new File(FILE_PATH + str).exists();
    }

    public static boolean isSdcardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void savePic(Bitmap bitmap, String str) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            createFile(FILE_PATH);
            fileOutputStream2 = new FileOutputStream(FILE_PATH + str);
            try {
                bitmap.compress(CompressFormat.PNG, 90, fileOutputStream2);
                fileOutputStream2.flush();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e32 = e6;
                fileOutputStream = fileOutputStream2;
                try {
                    e32.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e7) {
            e2 = e7;
            fileOutputStream2 = null;
            e2.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (IOException e8) {
            e322 = e8;
            e322.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File writeToSDCardFile(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
        r1 = 0;
        r0 = 0;
        r2 = createFile(r7);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        if (r2 != 0) goto L_0x0014;
    L_0x0008:
        if (r1 == 0) goto L_0x000d;
    L_0x000a:
        r0.close();	 Catch:{ IOException -> 0x000f }
    L_0x000d:
        r0 = r1;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x000d;
    L_0x0014:
        r0 = new java.io.File;	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2.<init>();	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r3 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r3 = java.io.File.separator;	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = r2.append(r7);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r3 = java.io.File.separator;	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = r2.append(r8);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x00a3, all -> 0x0094 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00a9, all -> 0x0094 }
        r2.<init>(r0, r11);	 Catch:{ IOException -> 0x00a9, all -> 0x0094 }
        r1 = "";
        r1 = r10.equals(r1);	 Catch:{ IOException -> 0x0068 }
        if (r1 == 0) goto L_0x0060;
    L_0x004b:
        r1 = r9.getBytes();	 Catch:{ IOException -> 0x0068 }
        r2.write(r1);	 Catch:{ IOException -> 0x0068 }
    L_0x0052:
        r2.flush();	 Catch:{ IOException -> 0x0068 }
        if (r2 == 0) goto L_0x000e;
    L_0x0057:
        r2.close();	 Catch:{ IOException -> 0x005b }
        goto L_0x000e;
    L_0x005b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x000e;
    L_0x0060:
        r1 = r9.getBytes(r10);	 Catch:{ IOException -> 0x0068 }
        r2.write(r1);	 Catch:{ IOException -> 0x0068 }
        goto L_0x0052;
    L_0x0068:
        r1 = move-exception;
    L_0x0069:
        r3 = "FileUtil";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a1 }
        r4.<init>();	 Catch:{ all -> 0x00a1 }
        r5 = "writeToSDCardFile:";
        r4 = r4.append(r5);	 Catch:{ all -> 0x00a1 }
        r5 = r1.getMessage();	 Catch:{ all -> 0x00a1 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00a1 }
        r4 = r4.toString();	 Catch:{ all -> 0x00a1 }
        android.util.Log.e(r3, r4);	 Catch:{ all -> 0x00a1 }
        r1.printStackTrace();	 Catch:{ all -> 0x00a1 }
        if (r2 == 0) goto L_0x000e;
    L_0x008a:
        r2.close();	 Catch:{ IOException -> 0x008e }
        goto L_0x000e;
    L_0x008e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x000e;
    L_0x0094:
        r0 = move-exception;
        r2 = r1;
    L_0x0096:
        if (r2 == 0) goto L_0x009b;
    L_0x0098:
        r2.close();	 Catch:{ IOException -> 0x009c }
    L_0x009b:
        throw r0;
    L_0x009c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x009b;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00a3:
        r0 = move-exception;
        r2 = r1;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0069;
    L_0x00a9:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.FileUtil.writeToSDCardFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):java.io.File");
    }

    public static File writeToSDCardFile(String str, String str2, String str3, boolean z) {
        return writeToSDCardFile(str, str2, str3, BuildConfig.FLAVOR, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File writeToSDCardFromInput(java.lang.String r8, java.lang.String r9, java.io.InputStream r10) {
        /*
        r7 = this;
        r1 = 0;
        r0 = 0;
        r2 = createFile(r8);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        if (r2 == 0) goto L_0x0014;
    L_0x0008:
        if (r1 == 0) goto L_0x000d;
    L_0x000a:
        r0.close();	 Catch:{ Exception -> 0x000f }
    L_0x000d:
        r0 = r1;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x000d;
    L_0x0014:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2.<init>();	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r3 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = r2.append(r8);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = r2.append(r9);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0095, all -> 0x0086 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x009b, all -> 0x0086 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x009b, all -> 0x0086 }
        r1 = bufferd;	 Catch:{ Exception -> 0x004d }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x004d }
    L_0x0041:
        r3 = r10.read(r1);	 Catch:{ Exception -> 0x004d }
        r4 = -1;
        if (r3 == r4) goto L_0x0078;
    L_0x0048:
        r4 = 0;
        r2.write(r1, r4, r3);	 Catch:{ Exception -> 0x004d }
        goto L_0x0041;
    L_0x004d:
        r1 = move-exception;
    L_0x004e:
        r3 = "FileUtil";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0093 }
        r4.<init>();	 Catch:{ all -> 0x0093 }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0093 }
        r5 = r1.getMessage();	 Catch:{ all -> 0x0093 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0093 }
        r4 = r4.toString();	 Catch:{ all -> 0x0093 }
        android.util.Log.e(r3, r4);	 Catch:{ all -> 0x0093 }
        r1.printStackTrace();	 Catch:{ all -> 0x0093 }
        if (r2 == 0) goto L_0x000e;
    L_0x006f:
        r2.close();	 Catch:{ Exception -> 0x0073 }
        goto L_0x000e;
    L_0x0073:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x000e;
    L_0x0078:
        r2.flush();	 Catch:{ Exception -> 0x004d }
        if (r2 == 0) goto L_0x000e;
    L_0x007d:
        r2.close();	 Catch:{ Exception -> 0x0081 }
        goto L_0x000e;
    L_0x0081:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x000e;
    L_0x0086:
        r0 = move-exception;
        r2 = r1;
    L_0x0088:
        if (r2 == 0) goto L_0x008d;
    L_0x008a:
        r2.close();	 Catch:{ Exception -> 0x008e }
    L_0x008d:
        throw r0;
    L_0x008e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x008d;
    L_0x0093:
        r0 = move-exception;
        goto L_0x0088;
    L_0x0095:
        r0 = move-exception;
        r2 = r1;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x004e;
    L_0x009b:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.FileUtil.writeToSDCardFromInput(java.lang.String, java.lang.String, java.io.InputStream):java.io.File");
    }
}
