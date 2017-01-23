package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.xiaomi.channel.commonutils.android.a */
public class C4288a {
    private static int m17590a(List<String> list, String str) {
        int i = 0;
        while (list != null && i < list.size()) {
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase((String) list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static String m17591a(String str) {
        if (str == null) {
            return str;
        }
        String[] split = str.split("/");
        return (split == null || split.length <= 0) ? str : split[split.length - 1];
    }

    public static List<String> m17592a(Context context) {
        List<String> arrayList = new ArrayList();
        CharSequence b = C4288a.m17594b(context);
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(b);
        }
        b = C4296h.m17623a("ro.product.cpu.abi", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(b);
        }
        b = C4296h.m17623a("ro.product.cpu.abi2", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(b);
        }
        Object a = C4296h.m17623a("ro.product.cpu.abilist", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int i = 0;
            while (split != null && i < split.length) {
                if (!TextUtils.isEmpty(split[i])) {
                    arrayList.add(split[i]);
                }
                i++;
            }
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    public static void m17593a(Context context, String str, String str2) {
        Exception e;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        if (str != null) {
            try {
                if (!str.endsWith(File.separator)) {
                    str = str + File.separator;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                            return;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = null;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th2;
            }
        }
        if (!(str2 == null || str2.endsWith(File.separator))) {
            str2 = str2 + File.separator;
        }
        HashMap hashMap = new HashMap();
        List a = C4288a.m17592a(context);
        zipFile = new ZipFile(str);
        try {
            Enumeration entries = zipFile.entries();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                C4302b.m17652b("ze.getName() = " + zipEntry.getName());
                if (zipEntry.getName().startsWith("lib/") && !zipEntry.isDirectory()) {
                    String a2 = C4288a.m17591a(zipEntry.getName());
                    String b = C4288a.m17595b(zipEntry.getName());
                    String str3 = (String) hashMap.get(a2);
                    if (!TextUtils.isEmpty(str3)) {
                        int a3 = C4288a.m17590a(a, b);
                        if (a3 < 0) {
                            continue;
                        } else if (a3 >= C4288a.m17590a(a, str3)) {
                            continue;
                        }
                    }
                    C4302b.m17652b("use abi " + b);
                    hashMap.put(a2, b);
                    File file = new File(str2 + a2);
                    if (file.exists()) {
                        file.delete();
                    }
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    InputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    C4298a.m17632a(bufferedInputStream);
                    C4298a.m17633a(fileOutputStream);
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (Exception e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            zipFile2 = zipFile;
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    public static String m17594b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field declaredField = Class.forName("android.content.pm.ApplicationInfo").getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (Throwable th) {
            return null;
        }
    }

    private static String m17595b(String str) {
        if (str != null) {
            String[] split = str.split("/");
            if (split != null && split.length > 1) {
                return split[split.length - 2];
            }
        }
        return "armeabi";
    }
}
