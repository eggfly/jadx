package com.antutu.utils;

import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

public class log {
    private static final String TAG = "AntutuUtility";
    private static final int Type_D = 1;
    private static final int Type_E = 2;
    private static final int Type_I = 0;
    private static final int Type_V = 4;
    private static final int Type_W = 3;

    public static void m6880d(Object obj) {
        logt(Type_D, BuildConfig.FLAVOR, obj);
    }

    public static void m6881d(String str, Object obj) {
        logt(Type_D, str, obj);
    }

    public static void m6882e(Object obj) {
        logt(Type_E, BuildConfig.FLAVOR, obj);
    }

    public static void m6883e(String str, Object obj) {
        logt(Type_E, str, obj);
    }

    public static void m6884i(Object obj) {
        logt(Type_I, BuildConfig.FLAVOR, obj);
    }

    public static void m6885i(String str, Object obj) {
        logt(Type_I, str, obj);
    }

    private static void logt(int i, String str, Object obj) {
        String str2 = BuildConfig.FLAVOR;
        if (!(str == null || str.trim().isEmpty())) {
            str2 = "[" + str.trim() + "]  ";
        }
        switch (i) {
            case Type_I /*0*/:
                Log.i(TAG, str2 + obj.toString());
            case Type_D /*1*/:
                Log.d(TAG, str2 + obj.toString());
            case Type_E /*2*/:
                Log.e(TAG, str2 + obj.toString());
            case Type_W /*3*/:
                Log.w(TAG, str2 + obj.toString());
            case Type_V /*4*/:
                Log.v(TAG, str2 + obj.toString());
            default:
        }
    }

    public static void showLogs(String str) {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.antutu/" + str + "_log.txt")));
            String readLine;
            do {
                readLine = lineNumberReader.readLine();
                if (readLine != null) {
                    m6884i(readLine);
                    continue;
                }
            } while (readLine != null);
            lineNumberReader.close();
        } catch (Exception e) {
            m6882e(e.toString());
        }
    }

    public static void m6886v(Object obj) {
        logt(Type_V, BuildConfig.FLAVOR, obj);
    }

    public static void m6887v(String str, Object obj) {
        logt(Type_V, str, obj);
    }

    public static void m6888w(Object obj) {
        logt(Type_W, BuildConfig.FLAVOR, obj);
    }

    public static void m6889w(String str, Object obj) {
        logt(Type_W, str, obj);
    }

    public static void write(String str, String str2) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.antutu/" + str + "_log.txt", true));
            outputStreamWriter.write(DateFormat.format("[MM/dd kk:mm:ss]   ", System.currentTimeMillis()).toString() + str2 + "\n");
            outputStreamWriter.flush();
            outputStreamWriter.close();
            m6884i(str2);
        } catch (Exception e) {
            m6882e(e.toString());
        }
    }
}
