package com.igexin.p158b.p159a.p167c;

import android.app.Activity;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.push.config.C3758q;
import com.igexin.push.core.C3855g;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.igexin.b.a.c.a */
public class C3688a extends Activity implements UncaughtExceptionHandler {
    public static boolean f12438a;

    static {
        f12438a = C3758q.f12684a.equals("debug");
    }

    public static synchronized void m15095a(String str) {
        synchronized (C3688a.class) {
            C3688a.m15097b(str);
        }
    }

    public static void m15096a(String str, String str2) {
        if (f12438a) {
            Log.d(str, str2);
        }
    }

    public static synchronized void m15097b(String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        synchronized (C3688a.class) {
            if (f12438a || (C3855g.f12951O && C3855g.f12952P >= System.currentTimeMillis())) {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                Object obj = C3855g.f12967e;
                if (!TextUtils.isEmpty(obj) && Environment.getExternalStorageState().equals("mounted")) {
                    String str2 = "/sdcard/libs/";
                    File file = new File(str2);
                    if (file.exists() || file.mkdir()) {
                        FileOutputStream fileOutputStream2 = null;
                        try {
                            File file2 = new File(str2 + obj + "." + format + MsgConstant.CACHE_LOG_FILE_EXT);
                            if (file2.exists() || file2.createNewFile()) {
                                fileOutputStream = new FileOutputStream(file2, true);
                                try {
                                    fileOutputStream.write(((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(new Date()) + "|" + str) + "\r\n").getBytes());
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e) {
                                        }
                                    }
                                } catch (Exception e2) {
                                    fileOutputStream2 = fileOutputStream;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    throw th;
                                }
                            } else if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e5) {
                                }
                            }
                        } catch (Exception e6) {
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            fileOutputStream = fileOutputStream2;
                            th = th4;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public static void m15098b(String str, String str2) {
        if (f12438a) {
            Log.i(str, str2);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
    }
}
