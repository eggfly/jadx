package com.cmcm.p074a.p075a.p114c;

import android.os.Environment;
import android.text.TextUtils;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;
import java.io.File;
import org.json.JSONStringer;

/* renamed from: com.cmcm.a.a.c.s */
public class C2154s extends C2137a {
    private void m8130a(String str, int i, int i2, JSONStringer jSONStringer) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                jSONStringer.key(file.getName());
                if (file.isDirectory()) {
                    jSONStringer.object();
                    if (i2 < i) {
                        m8130a(file.getPath(), i, i2 + 1, jSONStringer);
                    }
                    jSONStringer.endObject();
                } else {
                    jSONStringer.value(0);
                }
            }
        }
    }

    protected void m8131c() {
        Object a = C2126s.m8029a(m8132f(), "paths", null);
        if (!TextUtils.isEmpty(a)) {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.object();
                for (String str : a.split(";")) {
                    String[] split = str.split(":");
                    int parseInt = Integer.parseInt(split[0]);
                    int i = parseInt <= 0 ? 10000 : parseInt;
                    jSONStringer.key(str);
                    jSONStringer.object();
                    String str2 = split[1];
                    if (split[1].contains("[SDCARD]")) {
                        str2 = split[1].replace("[SDCARD]", Environment.getExternalStorageDirectory().getPath());
                    }
                    m8130a(str2, i, 1, jSONStringer);
                    jSONStringer.endObject();
                }
                jSONStringer.endObject();
                m8069a(jSONStringer.toString());
            } catch (Exception e) {
                if (C2133z.f7482a) {
                    ad.m7931a(m8132f(), "can't traverse the paths : %s\n%s", a, e.getMessage());
                }
            }
        }
    }

    public String m8132f() {
        return "path";
    }
}
