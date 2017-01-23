package com.aide.appwizard;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class d {
    public static String j6(String str) {
        Throwable th;
        if (str == null) {
            return "";
        }
        BufferedReader bufferedReader;
        String stringBuffer;
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer2.append(String.valueOf(cArr, 0, read));
                }
                bufferedReader.close();
                stringBuffer = stringBuffer2.toString();
                if (bufferedReader == null) {
                    return stringBuffer;
                }
                try {
                    bufferedReader.close();
                    return stringBuffer;
                } catch (Exception e) {
                    return stringBuffer;
                }
            } catch (IOException e2) {
                try {
                    stringBuffer = "";
                    if (bufferedReader != null) {
                        return stringBuffer;
                    }
                    try {
                        bufferedReader.close();
                        return stringBuffer;
                    } catch (Exception e3) {
                        return stringBuffer;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            bufferedReader = null;
            stringBuffer = "";
            if (bufferedReader != null) {
                return stringBuffer;
            }
            bufferedReader.close();
            return stringBuffer;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static String j6() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists()) {
            return externalStorageDirectory.getPath();
        }
        return "/mnt/sdcard";
    }
}
