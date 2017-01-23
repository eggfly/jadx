package com.miui.support.internal.hybrid;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SecurityManager {
    private static String f2471a;
    private Config f2472b;
    private long f2473c;
    private String f2474d;
    private Boolean f2475e;

    public SecurityManager(Config config, Context context) {
        this.f2472b = config;
        if (!(config == null || config.m3994a() == null)) {
            this.f2473c = config.m3994a().m4075b();
            this.f2474d = config.m3994a().m4072a();
        }
        if (f2471a == null) {
            f2471a = m4076a(context);
        }
    }

    public boolean m4080a() {
        return 0 < this.f2473c && this.f2473c < System.currentTimeMillis();
    }

    public boolean m4081b() {
        if (this.f2475e == null) {
            try {
                this.f2475e = Boolean.valueOf(m4078a(ConfigUtils.m4008a(this.f2472b), this.f2474d));
            } catch (Exception e) {
                this.f2475e = Boolean.valueOf(false);
            }
        }
        return this.f2475e.booleanValue();
    }

    private boolean m4078a(String str, String str2) {
        return str2 != null && SignUtils.m4085a(str, SignUtils.m4082a(f2471a), str2);
    }

    private String m4076a(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        File file = new File(m4079b(context), "hybrid_key.pem");
        BufferedReader bufferedReader2 = null;
        try {
            InputStream fileInputStream;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
            } else {
                fileInputStream = context.getResources().getAssets().open("keys/hybrid_key.pem");
            }
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            try {
                String a = m4077a(bufferedReader);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return a;
            } catch (IOException e2) {
                bufferedReader2 = bufferedReader;
                try {
                    throw new IllegalStateException("cannot read hybrid key.");
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    th2 = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        } catch (IOException e4) {
            throw new IllegalStateException("cannot read hybrid key.");
        } catch (Throwable th32) {
            th = th32;
            bufferedReader = null;
            th2 = th;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
    }

    private String m4077a(BufferedReader bufferedReader) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return stringBuilder.substring(0, stringBuilder.length() - 1);
            }
            if (!("".equals(readLine.trim()) || readLine.startsWith("-----"))) {
                stringBuilder.append(readLine);
                stringBuilder.append('\r');
            }
        }
    }

    private File m4079b(Context context) {
        return new File(context.getFilesDir(), "miuisdk");
    }
}
