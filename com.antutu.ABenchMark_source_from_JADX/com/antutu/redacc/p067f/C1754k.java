package com.antutu.redacc.p067f;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.antutu.redacc.f.k */
public class C1754k {
    private static final String f6187a;

    static {
        f6187a = C1754k.class.getSimpleName();
    }

    public static String m6759a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), IXAdIOUtils.BUFFER_SIZE);
            try {
                String readLine = bufferedReader3.readLine();
                bufferedReader3.close();
                if (bufferedReader3 == null) {
                    return readLine;
                }
                try {
                    bufferedReader3.close();
                    return readLine;
                } catch (IOException e) {
                    return readLine;
                }
            } catch (IOException e2) {
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }
}
