package com.igexin.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.webkit.MimeTypeMap;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.igexin.download.h */
public class C3708h {
    public static Random f12513a;
    private static final Pattern f12514b;

    static {
        f12513a = new Random(SystemClock.uptimeMillis());
        f12514b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    }

    public static C3701a m15191a(Context context, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        String a;
        String str6;
        int indexOf;
        String a2 = C3708h.m15194a(str, str2, str3, str4, i);
        int indexOf2 = a2.indexOf(46);
        if (indexOf2 < 0) {
            a = C3708h.m15195a(str5, true);
            str6 = a2;
        } else {
            a = C3708h.m15193a(str5, i, a2, indexOf2);
            str6 = a2.substring(0, indexOf2);
        }
        if (a != null && a.equals(".bin")) {
            indexOf = str.indexOf("?");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            indexOf = str.lastIndexOf(".");
            int lastIndexOf = str.lastIndexOf("/");
            if (indexOf >= 0 && lastIndexOf >= 0 && indexOf > lastIndexOf) {
                a = str.substring(indexOf);
            }
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return new C3701a(null, null, Downloads.STATUS_FILE_ERROR);
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        File file = new File(path + SdkDownLoader.f12495b);
        if (!file.isDirectory()) {
            String[] split = SdkDownLoader.f12495b.split("/");
            indexOf = 0;
            while (indexOf < split.length) {
                if (split[indexOf] != null && split[indexOf].length() > 0) {
                    File file2 = new File(path + "/" + split[indexOf]);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                }
                indexOf++;
            }
            if (!file.mkdir()) {
                return new C3701a(null, null, Downloads.STATUS_FILE_ERROR);
            }
        }
        StatFs statFs = new StatFs(file.getPath());
        if (((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4) < ((long) i2)) {
            return new C3701a(null, null, Downloads.STATUS_FILE_ERROR);
        }
        a2 = C3708h.m15192a(i, file.getPath() + File.separator + str6, a, "recovery".equalsIgnoreCase(str6 + a));
        return a2 != null ? new C3701a(a2, new FileOutputStream(a2), 0) : new C3701a(null, null, Downloads.STATUS_FILE_ERROR);
    }

    private static String m15192a(int i, String str, String str2, boolean z) {
        int i2 = 1;
        String str3 = str + str2;
        if (!new File(str3).exists()) {
            if (!z) {
                return str3;
            }
            if (!(i == 1 || i == 2 || i == 3)) {
                return str3;
            }
        }
        String str4 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        int i3 = 1;
        while (i3 < 1000000000) {
            int i4 = i2;
            for (i2 = 0; i2 < 9; i2++) {
                str3 = str4 + i4 + str2;
                if (!new File(str3).exists()) {
                    return str3;
                }
                i4 += f12513a.nextInt(i3) + 1;
            }
            i3 *= 10;
            i2 = i4;
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m15193a(java.lang.String r3, int r4, java.lang.String r5, int r6) {
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x0026;
    L_0x0003:
        r1 = 46;
        r1 = r5.lastIndexOf(r1);
        r2 = android.webkit.MimeTypeMap.getSingleton();
        r1 = r1 + 1;
        r1 = r5.substring(r1);
        r1 = r2.getMimeTypeFromExtension(r1);
        if (r1 == 0) goto L_0x001f;
    L_0x0019:
        r1 = r1.equalsIgnoreCase(r3);
        if (r1 != 0) goto L_0x0026;
    L_0x001f:
        r0 = 0;
        r0 = com.igexin.download.C3708h.m15195a(r3, r0);
        if (r0 == 0) goto L_0x0026;
    L_0x0026:
        if (r0 != 0) goto L_0x002c;
    L_0x0028:
        r0 = r5.substring(r6);
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.download.h.a(java.lang.String, int, java.lang.String, int):java.lang.String");
    }

    private static String m15194a(String str, String str2, String str3, String str4, int i) {
        String decode;
        int lastIndexOf;
        String str5 = null;
        if (null == null && str2 != null && !str2.endsWith("/") && str2.length() > 0) {
            int lastIndexOf2 = str2.lastIndexOf(47) + 1;
            str5 = lastIndexOf2 > 0 ? str2.substring(lastIndexOf2) : str2;
        }
        if (str5 == null && str3 != null) {
            str5 = C3708h.m15201b(str3);
            if (str5 != null) {
                lastIndexOf2 = str5.lastIndexOf(47) + 1;
                if (lastIndexOf2 > 0) {
                    str5 = str5.substring(lastIndexOf2);
                }
            }
        }
        if (str5 == null && str4 != null) {
            decode = Uri.decode(str4);
            if (!(decode == null || decode.endsWith("/") || decode.indexOf(63) >= 0)) {
                int lastIndexOf3 = decode.lastIndexOf(47) + 1;
                if (lastIndexOf3 > 0) {
                    decode = decode.substring(lastIndexOf3);
                }
                if (decode == null) {
                    str5 = Uri.decode(str);
                    if (!(str5 == null || str5.endsWith("/") || str5.indexOf(63) >= 0)) {
                        lastIndexOf = str5.lastIndexOf(47) + 1;
                        if (lastIndexOf > 0) {
                            decode = str5.substring(lastIndexOf);
                        }
                    }
                }
                return decode != null ? "downloadfile" : decode;
            }
        }
        decode = str5;
        if (decode == null) {
            str5 = Uri.decode(str);
            lastIndexOf = str5.lastIndexOf(47) + 1;
            if (lastIndexOf > 0) {
                decode = str5.substring(lastIndexOf);
            }
        }
        if (decode != null) {
        }
    }

    private static String m15195a(String str, boolean z) {
        String str2 = null;
        if (str != null) {
            str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            if (str2 != null) {
                str2 = "." + str2;
            }
        }
        return str2 == null ? (str == null || !str.toLowerCase().startsWith("text/")) ? z ? ".bin" : str2 : str.equalsIgnoreCase("text/html") ? ".html" : z ? ".txt" : str2 : str2;
    }

    private static void m15196a(C3709i c3709i) {
        while (true) {
            if (c3709i.m15207a() == 1) {
                c3709i.m15208b();
                C3708h.m15196a(c3709i);
                if (c3709i.m15207a() != 2) {
                    break;
                }
                c3709i.m15208b();
            } else {
                C3708h.m15202b(c3709i);
            }
            if (c3709i.m15207a() == 3) {
                c3709i.m15208b();
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("syntax error, unmatched parenthese");
    }

    public static void m15197a(String str, Set set) {
        if (str != null) {
            try {
                C3709i c3709i = new C3709i(str, set);
                C3708h.m15196a(c3709i);
                if (c3709i.m15207a() != 9) {
                    throw new IllegalArgumentException("syntax error");
                }
            } catch (RuntimeException e) {
                throw e;
            }
        }
    }

    public static boolean m15198a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m15199a(android.content.Context r11, long r12) {
        /*
        r8 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r11.getContentResolver();	 Catch:{ Exception -> 0x0076, all -> 0x006b }
        r1 = com.igexin.download.Downloads.f12492a;	 Catch:{ Exception -> 0x0076, all -> 0x006b }
        r2 = 0;
        r3 = "( status = '200' AND destination = '2' )";
        r4 = 0;
        r5 = "lastmod";
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0076, all -> 0x006b }
        if (r0 != 0) goto L_0x001a;
    L_0x0016:
        r0.close();
    L_0x0019:
        return r6;
    L_0x001a:
        r0.moveToFirst();	 Catch:{ Exception -> 0x007a, all -> 0x0072 }
        r2 = r8;
    L_0x001e:
        r1 = r0.isAfterLast();	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        if (r1 != 0) goto L_0x0067;
    L_0x0024:
        r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r1 >= 0) goto L_0x0067;
    L_0x0028:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r4 = "_data";
        r4 = r0.getColumnIndex(r4);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r4 = r0.getString(r4);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r4 = r1.length();	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r2 = r2 + r4;
        r1.delete();	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r1 = "_id";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r4 = r0.getLong(r1);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r1 = r11.getContentResolver();	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r7 = com.igexin.download.Downloads.f12492a;	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r4 = android.content.ContentUris.withAppendedId(r7, r4);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r5 = 0;
        r7 = 0;
        r1.delete(r4, r5, r7);	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        r0.moveToNext();	 Catch:{ Exception -> 0x005c, all -> 0x0072 }
        goto L_0x001e;
    L_0x005c:
        r1 = move-exception;
    L_0x005d:
        r0.close();
    L_0x0060:
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0070;
    L_0x0064:
        r0 = 1;
    L_0x0065:
        r6 = r0;
        goto L_0x0019;
    L_0x0067:
        r0.close();
        goto L_0x0060;
    L_0x006b:
        r0 = move-exception;
    L_0x006c:
        r7.close();
        throw r0;
    L_0x0070:
        r0 = r6;
        goto L_0x0065;
    L_0x0072:
        r1 = move-exception;
        r7 = r0;
        r0 = r1;
        goto L_0x006c;
    L_0x0076:
        r0 = move-exception;
        r0 = r7;
        r2 = r8;
        goto L_0x005d;
    L_0x007a:
        r1 = move-exception;
        r2 = r8;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.download.h.a(android.content.Context, long):boolean");
    }

    public static boolean m15200a(String str) {
        File parentFile = new File(str).getParentFile();
        return parentFile.equals(Environment.getDownloadCacheDirectory()) || parentFile.equals(new File(Environment.getExternalStorageDirectory() + "/libs/tmp"));
    }

    private static String m15201b(String str) {
        try {
            Matcher matcher = f12514b.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException e) {
        }
        return null;
    }

    private static void m15202b(C3709i c3709i) {
        if (c3709i.m15207a() != 4) {
            throw new IllegalArgumentException("syntax error, expected column name");
        }
        c3709i.m15208b();
        if (c3709i.m15207a() == 5) {
            c3709i.m15208b();
            if (c3709i.m15207a() != 6) {
                throw new IllegalArgumentException("syntax error, expected quoted string");
            }
            c3709i.m15208b();
        } else if (c3709i.m15207a() == 7) {
            c3709i.m15208b();
            if (c3709i.m15207a() != 8) {
                throw new IllegalArgumentException("syntax error, expected NULL");
            }
            c3709i.m15208b();
        } else {
            throw new IllegalArgumentException("syntax error after column name");
        }
    }

    public static boolean m15203b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean m15204c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && telephonyManager.isNetworkRoaming()) {
                    return true;
                }
            }
        }
        return false;
    }
}
