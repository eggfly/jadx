package com.facebook.ads.internal.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.util.f */
public class C2494f {

    /* renamed from: com.facebook.ads.internal.util.f.a */
    public interface C2325a {
        C2493e m8845C();

        String m8846D();

        Collection<String> m8847E();
    }

    public static Collection<String> m9465a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        Set hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean m9466a(Context context, C2325a c2325a) {
        C2493e C = c2325a.m8845C();
        if (C == null || C == C2493e.NONE) {
            return false;
        }
        Collection<String> E = c2325a.m8847E();
        if (E == null || E.isEmpty()) {
            return false;
        }
        for (String a : E) {
            if (C2494f.m9467a(context, a)) {
                int i = 1;
                break;
            }
        }
        boolean z = false;
        if (C == C2493e.INSTALLED) {
            int i2 = 1;
        } else {
            boolean z2 = false;
        }
        if (i != i2) {
            return false;
        }
        if (C2510r.m9516a(c2325a.m8846D())) {
            return true;
        }
        new C2507o().execute(new String[]{a});
        return false;
    }

    public static boolean m9467a(Context context, String str) {
        if (C2510r.m9516a(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
