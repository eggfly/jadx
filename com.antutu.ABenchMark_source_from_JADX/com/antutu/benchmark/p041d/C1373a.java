package com.antutu.benchmark.p041d;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.antutu.utils.MLog;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.antutu.benchmark.d.a */
public class C1373a {
    private static String f4666a;
    private static String f4667b;
    private static C1373a f4668e;
    private Map<String, SQLiteDatabase> f4669c;
    private Context f4670d;

    static {
        f4666a = "AssetsDatabase";
        f4667b = "/data/data/com.antutu.ABenchMark/database";
        f4668e = null;
    }

    private C1373a(Context context) {
        this.f4669c = new HashMap();
        this.f4670d = null;
        this.f4670d = context;
    }

    public static C1373a m5441a() {
        return f4668e;
    }

    public static void m5442a(Context context) {
        if (f4668e == null) {
            f4668e = new C1373a(context);
        }
    }

    private boolean m5443a(String str, String str2) {
        InputStream inputStream = null;
        MLog.m6871i(f4666a, "Copy " + str + " to " + str2);
        OutputStream fileOutputStream;
        try {
            InputStream open = this.f4670d.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception e) {
                fileOutputStream = null;
                inputStream = open;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                        return false;
                    }
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            }
            try {
                byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        open.close();
                        fileOutputStream.close();
                        return true;
                    }
                }
            } catch (Exception e3) {
                inputStream = open;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            }
        } catch (Exception e4) {
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        }
    }

    private String m5444b() {
        return String.format(f4667b, new Object[]{this.f4670d.getApplicationInfo().packageName});
    }

    private String m5445b(String str) {
        return m5444b() + "/" + str;
    }

    public SQLiteDatabase m5446a(String str) {
        if (this.f4669c.get(str) != null) {
            MLog.m6871i(f4666a, String.format("Return a database copy of %s", new Object[]{str}));
            return (SQLiteDatabase) this.f4669c.get(str);
        } else if (this.f4670d == null) {
            return null;
        } else {
            MLog.m6871i(f4666a, String.format("Create database %s", new Object[]{str}));
            String b = m5444b();
            String b2 = m5445b(str);
            File file = new File(b2);
            SharedPreferences sharedPreferences = this.f4670d.getSharedPreferences(C1373a.class.toString(), 0);
            if (!(sharedPreferences.getBoolean(str, false) && file.exists())) {
                file = new File(b);
                if (!file.exists() && !file.mkdirs()) {
                    MLog.m6871i(f4666a, "Create \"" + b + "\" fail!");
                    return null;
                } else if (m5443a(str, b2)) {
                    sharedPreferences.edit().putBoolean(str, true).commit();
                } else {
                    MLog.m6871i(f4666a, String.format("Copy %s to %s fail!", new Object[]{str, b2}));
                    return null;
                }
            }
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(b2, null, 16);
            if (openDatabase == null) {
                return openDatabase;
            }
            this.f4669c.put(str, openDatabase);
            return openDatabase;
        }
    }
}
