package com.miui.calculator.common.utils;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AssetReader {
    public static String m2800a(Context context, String str) {
        InputStream open;
        Throwable e;
        Throwable th;
        String str2 = null;
        try {
            open = context.getAssets().open(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                str2 = stringBuilder.toString();
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e2) {
                        Log.e("Calculator:AssetReader", "IOException", e2);
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Log.e("Calculator:AssetReader", "IOException", e2);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable e22) {
                            Log.e("Calculator:AssetReader", "IOException", e22);
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable e222) {
                            Log.e("Calculator:AssetReader", "IOException", e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            Object obj = str2;
            Log.e("Calculator:AssetReader", "IOException", e222);
            if (open != null) {
                open.close();
            }
            return str2;
        } catch (Throwable e2222) {
            open = str2;
            th = e2222;
            if (open != null) {
                open.close();
            }
            throw th;
        }
        return str2;
    }
}
