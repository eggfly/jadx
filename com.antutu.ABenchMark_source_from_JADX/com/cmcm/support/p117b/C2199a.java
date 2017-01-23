package com.cmcm.support.p117b;

import android.text.TextUtils;
import com.cmcm.support.p116a.C2189b;

/* renamed from: com.cmcm.support.b.a */
public class C2199a {
    public long f7593a;
    public int f7594b;
    public byte[] f7595c;

    public C2199a() {
        this.f7593a = 0;
        this.f7594b = 0;
        this.f7595c = null;
    }

    public static C2199a m8265a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() > 7 && !str.startsWith("[common]")) {
            str = str.substring(7);
        }
        String[] split = str.split("\r\n");
        C2199a c2199a = new C2199a();
        if (split != null && split.length >= 3) {
            if (!split[0].endsWith("common]")) {
                return null;
            }
            String str2 = "result=";
            if (!split[1].startsWith(str2)) {
                return null;
            }
            try {
                c2199a.f7594b = Integer.parseInt(split[1].substring(str2.length()).trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            str2 = "time=";
            if (!split[2].startsWith(str2)) {
                return null;
            }
            try {
                c2199a.f7593a = Long.parseLong(split[2].substring(str2.length()).trim());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            if (split.length == 3) {
                return c2199a;
            }
            str2 = "key=";
            if (!split[3].startsWith(str2)) {
                return null;
            }
            try {
                c2199a.f7595c = C2189b.m8232a(split[3].substring(str2.length()).trim());
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
            }
        }
        return c2199a;
    }
}
