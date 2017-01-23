package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.string.C4329d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.xiaomi.channel.commonutils.android.c */
public class C4291c {
    public static boolean m17604a(Context context, String str, String str2) {
        InputStream inputStream;
        Exception e;
        Throwable th;
        OutputStream outputStream = null;
        InputStream open;
        InputStream fileInputStream;
        try {
            byte[] b;
            File file;
            open = context.getAssets().open(str);
            try {
                b = C4298a.m17637b(open);
                file = new File(str2);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        Object a = C4329d.m17745a(C4298a.m17637b(fileInputStream));
                        String a2 = C4329d.m17745a(b);
                        if (TextUtils.isEmpty(a) || !a.equals(a2)) {
                            inputStream = fileInputStream;
                        } else {
                            C4298a.m17632a(open);
                            C4298a.m17632a(fileInputStream);
                            C4298a.m17633a(null);
                            return false;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = open;
                        try {
                            e.printStackTrace();
                            C4298a.m17632a(inputStream);
                            C4298a.m17632a(fileInputStream);
                            C4298a.m17633a(outputStream);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            open = inputStream;
                            C4298a.m17632a(open);
                            C4298a.m17632a(fileInputStream);
                            C4298a.m17633a(outputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        C4298a.m17632a(open);
                        C4298a.m17632a(fileInputStream);
                        C4298a.m17633a(outputStream);
                        throw th;
                    }
                }
                inputStream = null;
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                inputStream = open;
                e.printStackTrace();
                C4298a.m17632a(inputStream);
                C4298a.m17632a(fileInputStream);
                C4298a.m17633a(outputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                C4298a.m17632a(open);
                C4298a.m17632a(fileInputStream);
                C4298a.m17633a(outputStream);
                throw th;
            }
            try {
                OutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(b);
                    fileOutputStream.flush();
                    C4298a.m17632a(open);
                    C4298a.m17632a(inputStream);
                    C4298a.m17633a(fileOutputStream);
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    outputStream = fileOutputStream;
                    fileInputStream = inputStream;
                    inputStream = open;
                    e.printStackTrace();
                    C4298a.m17632a(inputStream);
                    C4298a.m17632a(fileInputStream);
                    C4298a.m17633a(outputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = fileOutputStream;
                    fileInputStream = inputStream;
                    C4298a.m17632a(open);
                    C4298a.m17632a(fileInputStream);
                    C4298a.m17633a(outputStream);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = inputStream;
                inputStream = open;
                e.printStackTrace();
                C4298a.m17632a(inputStream);
                C4298a.m17632a(fileInputStream);
                C4298a.m17633a(outputStream);
                return false;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = inputStream;
                C4298a.m17632a(open);
                C4298a.m17632a(fileInputStream);
                C4298a.m17633a(outputStream);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            inputStream = null;
            e.printStackTrace();
            C4298a.m17632a(inputStream);
            C4298a.m17632a(fileInputStream);
            C4298a.m17633a(outputStream);
            return false;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            open = null;
            C4298a.m17632a(open);
            C4298a.m17632a(fileInputStream);
            C4298a.m17633a(outputStream);
            throw th;
        }
    }
}
