package com.cmcm.support.p116a;

import com.cmcm.support.p118c.C2211b;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/* renamed from: com.cmcm.support.a.e */
public class C2192e {
    protected C2211b<String, Properties> f7584a;
    private transient String f7585b;
    private transient Properties f7586c;

    public C2192e(String str) {
        this.f7584a = new C2211b();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        m8243a(bufferedReader);
        bufferedReader.close();
    }

    public int m8241a(String str, String str2, int i) {
        try {
            i = Integer.parseInt(m8242a(str, str2, Integer.toString(i)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return i;
    }

    public String m8242a(String str, String str2, String str3) {
        Properties properties = (Properties) this.f7584a.get(str);
        if (properties == null) {
            return str3;
        }
        String property = properties.getProperty(str2);
        return property != null ? property : str3;
    }

    protected void m8243a(BufferedReader bufferedReader) {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                m8244a(readLine);
            } else {
                return;
            }
        }
    }

    protected void m8244a(String str) {
        String trim = str.trim();
        if (trim.matches("\\[.*\\]")) {
            this.f7585b = trim.replaceFirst("\\[(.*)\\]", "$1");
            this.f7586c = new Properties();
        } else if (trim.matches(".*=.*")) {
            int indexOf = trim.indexOf(61);
            this.f7586c.setProperty(trim.substring(0, indexOf), trim.substring(indexOf + 1));
            this.f7584a.put(this.f7585b, this.f7586c);
        }
    }
}
