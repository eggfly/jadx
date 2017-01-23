package com.cmcm.support.p116a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.cmcm.support.a.f */
public class C2193f {
    private static SimpleDateFormat f7587a;
    private boolean f7588b;
    private Context f7589c;

    static {
        f7587a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    }

    public C2193f() {
        this.f7588b = false;
        this.f7589c = null;
    }

    private File m8245a(String str) {
        if (this.f7589c == null || !m8247a()) {
            return null;
        }
        String str2 = this.f7589c.getFilesDir() + "/Log";
        File file = new File(str2);
        if (!(file == null || file.exists())) {
            if (file == null || file.mkdirs()) {
                Log.e("KSupport", "Create LogDir done");
            } else {
                Log.e("KSupport", "Create LogDir failed");
                return null;
            }
        }
        return new File(str2, str);
    }

    private static String m8246a(long j) {
        return j > 0 ? f7587a.format(new Date(j)) : f7587a.format(new Date());
    }

    private boolean m8247a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private void m8248b(boolean z, String str, String str2) {
        PrintWriter printWriter;
        Throwable th;
        PrintWriter printWriter2 = null;
        PrintWriter printWriter3 = null;
        FileOutputStream fileOutputStream = null;
        try {
            File a = m8245a("cmcm_support.log");
            if (a == null) {
                if (null != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (null != null) {
                    printWriter3.close();
                    return;
                }
                return;
            }
            fileOutputStream = new FileOutputStream(a, true);
            if (fileOutputStream != null) {
                try {
                    String a2 = C2193f.m8246a(0);
                    printWriter = new PrintWriter(fileOutputStream);
                    try {
                        printWriter.println(a2 + '\r');
                        printWriter.println("Parse result:" + (z ? "OK" : "Failed") + '\r');
                        printWriter.println("Table name:" + str + '\r');
                        printWriter.println(str2 + "\r\n");
                        printWriter.flush();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            }
            printWriter = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            printWriter = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            throw th;
        }
    }

    public void m8249a(String str, String str2) {
        if (this.f7588b) {
            Log.d(str, str2);
        }
    }

    public void m8250a(boolean z, Context context) {
        this.f7588b = z;
        this.f7589c = context;
    }

    public void m8251a(boolean z, String str, String str2) {
        if (this.f7588b) {
            Log.i("KSupport", (z ? "ParseOK" : "ParseFailed") + " => [" + str + "] " + str2);
            m8248b(z, str, str2);
        }
    }
}
