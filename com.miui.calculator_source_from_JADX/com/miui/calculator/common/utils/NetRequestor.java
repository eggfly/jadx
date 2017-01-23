package com.miui.calculator.common.utils;

import android.text.TextUtils;
import android.util.Log;
import com.miui.calculator.CalculatorApplication;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class NetRequestor {
    public static String m2865a(String str) {
        return m2866a(str, 20000);
    }

    public static String m2868a(String str, String str2) {
        return m2867a(str, 20000, str2);
    }

    public static String m2866a(String str, int i) {
        return m2867a(str, i, null);
    }

    public static String m2867a(String str, int i, String str2) {
        String stringBuilder;
        Throwable e;
        if (!DefaultPreferenceHelper.m2835a(CalculatorApplication.m2559b())) {
            return null;
        }
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, TextUtils.isEmpty(str2) ? Charset.defaultCharset() : Charset.forName(str2)));
                StringBuilder stringBuilder2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder2.append(readLine);
                }
                stringBuilder = stringBuilder2.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("Calculator:NetRequestor", "Exception", e);
                        return stringBuilder;
                    }
                }
            }
            stringBuilder = null;
        } catch (Throwable e3) {
            Throwable th = e3;
            stringBuilder = null;
            e = th;
            Log.e("Calculator:NetRequestor", "Exception", e);
            return stringBuilder;
        } catch (Throwable th2) {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return stringBuilder;
    }
}
