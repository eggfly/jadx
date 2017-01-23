package com.igexin.push.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.p158b.p159a.p160a.C3658a;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.p180c.C3844h;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushService;
import com.igexin.sdk.p186a.C3940b;
import com.taobao.accs.ErrorCode;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.igexin.push.util.e */
public class C3926e {
    private static final Object f13194a;

    static {
        f13194a = new Object();
    }

    public static void m16156a() {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(C3855g.f12960X);
            if (file.exists() || file.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(C3855g.f12960X);
                try {
                    fileOutputStream2.write(C3658a.m14938d((("v01" + C3855g.f12987y) + String.valueOf(C3855g.f12981s) + "|" + C3855g.f12963a + "|" + C3855g.f12982t).getBytes(), C3855g.f12939C));
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    return;
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C3688a.m15097b("FileUtils | " + e.toString());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
            C3688a.m15097b("FileUtils | create file : " + file.toString() + " failed !!!");
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                }
            }
        } catch (Exception e7) {
            e = e7;
            C3688a.m15097b("FileUtils | " + e.toString());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static void m16158a(C3826f c3826f) {
        File file = new File(C3855g.ab + "/" + c3826f.m15719c());
        File file2 = new File(C3855g.ac + "/" + c3826f.m15719c());
        if (file2.exists()) {
            if (C3700a.m15131a(C3855g.f12969g, file2.getAbsolutePath()).equals(c3826f.m15725f())) {
                C3688a.m15097b("FileUtils|downloadExt ext is exsit " + file2);
                Intent intent = new Intent(C3855g.f12969g, PushService.class);
                intent.putExtra(PushConsts.CMD_ACTION, "com.igexin.sdk.action.extdownloadsuccess");
                intent.putExtra(AgooConstants.MESSAGE_ID, c3826f.m15711a());
                intent.putExtra("result", true);
                C3855g.f12969g.startService(intent);
                return;
            }
            file2.delete();
        }
        if (file.exists() && C3700a.m15131a(C3855g.f12969g, file.getAbsolutePath()).equals(c3826f.m15725f())) {
            C3688a.m15097b("FileUtils|downloadExt ext is exsit do copy " + file);
            if (C3926e.m16161a(file, file2, c3826f.m15725f())) {
                intent = new Intent(C3855g.f12969g, PushService.class);
                intent.putExtra(PushConsts.CMD_ACTION, "com.igexin.sdk.action.extdownloadsuccess");
                intent.putExtra(AgooConstants.MESSAGE_ID, c3826f.m15711a());
                intent.putExtra("result", true);
                C3855g.f12969g.startService(intent);
                return;
            }
        }
        C3688a.m15097b("FileUtils|ext is not exsit start download name = " + c3826f.m15719c());
        new Thread(new C3844h(C3855g.f12969g, c3826f, false)).start();
    }

    public static void m16159a(byte[] bArr, String str, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str), z);
            try {
                fileOutputStream.write(bArr);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileOutputStream2 = fileOutputStream;
                th = th3;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean m16160a(Context context) {
        return !new C3940b(context).m16222b();
    }

    public static boolean m16161a(File file, File file2, String str) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Throwable th2;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        Object obj = new byte[IXAdIOUtils.BUFFER_SIZE];
                        while (true) {
                            int read = fileInputStream2.read(obj);
                            if (read == -1) {
                                break;
                            }
                            Object obj2 = new byte[read];
                            System.arraycopy(obj, 0, obj2, 0, read);
                            bufferedOutputStream.write(obj2);
                        }
                        bufferedOutputStream.flush();
                        if (C3700a.m15131a(C3855g.f12969g, file2.getAbsolutePath()).equals(str)) {
                            C3688a.m15097b("FileUtils|copyFile success from : " + file + " to : " + file2);
                            z = true;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                        } else {
                            file2.delete();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e6) {
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedOutputStream = null;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                bufferedOutputStream = null;
                fileOutputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th2;
            }
        } catch (Throwable th6) {
            th2 = th6;
            bufferedOutputStream = null;
            fileOutputStream2 = null;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th2;
        }
        return z;
    }

    public static byte[] m16162a(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        if (new File(str).exists()) {
            byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream = bArr;
                    try {
                        C3688a.m15097b("FileUtils|" + e.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e8) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e9) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    byteArrayOutputStream = bArr;
                    th = th3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                byteArrayOutputStream = bArr;
                fileInputStream = bArr;
                C3688a.m15097b("FileUtils|" + e.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th32) {
                byteArrayOutputStream = bArr;
                fileInputStream = bArr;
                th = th32;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        C3688a.m15097b("FileUtils|get data from file = " + str + " file not exist ######");
        return bArr;
    }

    public static String m16163b() {
        String str = null;
        try {
            byte[] a = C3926e.m16162a(C3855g.f12960X);
            if (a == null) {
                C3688a.m15097b("FileUtils | read file cid id = null");
                return str;
            }
            String[] split = new String(C3658a.m14937c(a, C3855g.f12939C)).split("\\|");
            if (split.length > 2) {
                String str2 = split[2];
                if (str2 != null) {
                    try {
                        if (!str2.equals("null")) {
                            str = str2;
                        }
                    } catch (Exception e) {
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            }
            C3688a.m15097b("FileUtils|get cid from file cid = " + str);
            return str;
        } catch (Exception e2) {
        }
    }

    public static void m16164b(Context context) {
        File file = new File(context.getFilesDir().getPath() + "/" + "init_c.pid");
        if (file.exists()) {
            file.delete();
        }
        if (!C3754m.f12680x) {
            C3688a.m15097b("FileUtils|isReportInitialize = false");
        } else if (C3855g.f12970h.get()) {
            C3685c.m15060b().m15053a(new C3927f(null, context), false, true);
        } else {
            new Thread(new C3928g(context)).start();
        }
    }

    private static void m16165b(Context context, String str) {
        if (context != null && str != null) {
            String str2 = context.getFilesDir().getPath() + "/" + "init_c1.pid";
            synchronized (f13194a) {
                if (str.length() == 0) {
                    C3926e.m16159a(str.getBytes(), str2, false);
                } else {
                    C3926e.m16159a((str + "|").getBytes(), str2, true);
                }
            }
        }
    }

    public static boolean m16166b(String str) {
        boolean z = true;
        C3688a.m15097b("FileUtils|removeExt " + str);
        try {
            String str2 = C3855g.ac + "/" + str;
            C3688a.m15097b("FileUtils|removeExt delete ext path = " + str2);
            File file = new File(str2);
            boolean delete = file.exists() ? file.delete() : true;
            String str3 = C3855g.ac + "/" + str + ".dex";
            C3688a.m15097b("FileUtils|removeExt delete ext dex path = " + str3);
            File file2 = new File(str3);
            if (!file2.exists()) {
                z = delete;
            } else if (!(delete && file2.delete())) {
                z = false;
            }
            str2 = C3700a.m15132a(str).substring(12, 20);
            C3688a.m15097b("FileUtils|removeExt renamedExtName = " + str2);
            if (str2 == null) {
                return z;
            }
            file = new File(C3855g.ac + "/" + str2);
            if (!file.exists()) {
                return z;
            }
            C3688a.m15097b("FileUtils|removeExt, delete ext rename Ext path = " + file.getAbsolutePath());
            delete = file.delete();
            z &= delete;
            C3688a.m15097b("FileUtils|removeExt, delete ext renamedExt succeed = " + delete);
            return z;
        } catch (Throwable th) {
            C3688a.m15097b("FileUtils|" + th.toString());
            return false;
        }
    }

    public static String m16167c() {
        String str;
        Exception e;
        try {
            C3688a.m15097b("FileUtils|get device id from file : " + C3855g.f12961Y);
            byte[] a = C3926e.m16162a(C3855g.f12961Y);
            if (a == null) {
                C3688a.m15097b("FileUtils|read file device id = null");
                return null;
            }
            str = new String(a, "utf-8");
            try {
                C3688a.m15097b("FileUtils|read file device id = " + str);
                return str;
            } catch (Exception e2) {
                e = e2;
                C3688a.m15097b("FileUtils|get device id from file : " + e.toString());
                return str;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str = null;
            e = exception;
            C3688a.m15097b("FileUtils|get device id from file : " + e.toString());
            return str;
        }
    }

    private static String m16168c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        stringBuilder.append("|");
        stringBuilder.append(C3855g.f12982t);
        stringBuilder.append("|");
        stringBuilder.append(C3855g.f12963a);
        stringBuilder.append("|");
        stringBuilder.append(MessageService.MSG_DB_NOTIFY_REACHED);
        stringBuilder.append("|");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m16169d() {
        /*
        r2 = 0;
        r0 = com.igexin.push.core.C3855g.f12960X;	 Catch:{ Exception -> 0x005c }
        r0 = com.igexin.push.util.C3926e.m16162a(r0);	 Catch:{ Exception -> 0x005c }
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = "FileUtils|read session from file, not exist";
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ Exception -> 0x005c }
    L_0x000f:
        return r2;
    L_0x0010:
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x005c }
        r4 = com.igexin.push.core.C3855g.f12939C;	 Catch:{ Exception -> 0x005c }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r0, r4);	 Catch:{ Exception -> 0x005c }
        r1.<init>(r0);	 Catch:{ Exception -> 0x005c }
        r0 = "null";
        r0 = r1.contains(r0);	 Catch:{ Exception -> 0x005c }
        if (r0 == 0) goto L_0x0055;
    L_0x0023:
        r0 = 7;
        r0 = r1.substring(r0);	 Catch:{ Exception -> 0x005c }
    L_0x0028:
        r1 = "|";
        r1 = r0.indexOf(r1);	 Catch:{ Exception -> 0x005c }
        if (r1 < 0) goto L_0x0035;
    L_0x0030:
        r4 = 0;
        r0 = r0.substring(r4, r1);	 Catch:{ Exception -> 0x005c }
    L_0x0035:
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x005c }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x0077;
    L_0x003d:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "FileUtils|session : ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r2);
        r2 = r0;
        goto L_0x000f;
    L_0x0055:
        r0 = 20;
        r0 = r1.substring(r0);	 Catch:{ Exception -> 0x005c }
        goto L_0x0028;
    L_0x005c:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "FileUtils|";
        r1 = r1.append(r4);
        r0 = r0.toString();
        r0 = r1.append(r0);
        r0 = r0.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);
    L_0x0077:
        r0 = r2;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.e.d():long");
    }

    public static void m16170e() {
        Exception e;
        Throwable th;
        if (C3855g.f12937A != null) {
            C3688a.m15097b("FileUtils|save device id to file : " + C3855g.f12961Y);
            FileOutputStream fileOutputStream = null;
            WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
            try {
                FileOutputStream fileOutputStream2;
                if (writeLock.tryLock()) {
                    File file = new File(C3855g.f12961Y);
                    if (file.exists() || file.createNewFile()) {
                        fileOutputStream2 = new FileOutputStream(C3855g.f12961Y);
                        try {
                            fileOutputStream2.write(C3855g.f12937A.getBytes("utf-8"));
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            try {
                                C3688a.m15097b("FileUtils|" + e.toString());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                writeLock.unlock();
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                writeLock.unlock();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            writeLock.unlock();
                            throw th;
                        }
                    }
                    C3688a.m15097b("FileUtils|create file : " + file.toString() + " failed !!!");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    writeLock.unlock();
                    return;
                }
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                writeLock.unlock();
            } catch (Exception e7) {
                e = e7;
                C3688a.m15097b("FileUtils|" + e.toString());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                writeLock.unlock();
            }
        }
    }

    public static void m16171f() {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        String str = "/data/data/" + C3855g.f12967e + "/files/" + "init.pid";
        try {
            FileOutputStream fileOutputStream2;
            if (new File(str).exists()) {
                byte[] bytes = C3855g.f12982t.getBytes();
                byte[] bArr = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    bArr[i] = (byte) (bytes[i] ^ C3855g.ad[i]);
                }
                fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C3688a.m15097b("FileUtils|" + e.toString());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
            e = e6;
            C3688a.m15097b("FileUtils|" + e.toString());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static void m16172g() {
        C3926e.m16165b(C3855g.f12969g, BuildConfig.FLAVOR);
    }

    public static String m16173h() {
        String str = null;
        try {
            byte[] a;
            synchronized (f13194a) {
                a = C3926e.m16162a(C3855g.f12969g.getFilesDir().getPath() + "/" + "init_c1.pid");
            }
            if (a != null) {
                String str2 = new String(a);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.endsWith("|")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    String[] split = str2.split("\\|");
                    if (split.length <= ErrorCode.APP_NOT_BIND || System.currentTimeMillis() - Long.parseLong(split[0]) <= 604800000) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (String parseLong : split) {
                            stringBuilder.append(C3926e.m16168c(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(Long.parseLong(parseLong))))).append("\n");
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        str = stringBuilder.toString();
                    } else {
                        C3926e.m16172g();
                    }
                }
            }
        } catch (Throwable th) {
            C3688a.m15097b("FileUtils|upload init data error = " + th.getMessage());
            C3926e.m16172g();
        }
        return str;
    }
}
