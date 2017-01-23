package com.google.android.gms.p146b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.av */
public abstract class av {
    @gb
    public static final av f10328a;
    @gb
    public static final av f10329b;
    @gb
    public static final av f10330c;

    /* renamed from: com.google.android.gms.b.av.1 */
    static class C30331 extends av {
        C30331() {
        }

        public String m11837a(String str, String str2) {
            return str2;
        }
    }

    /* renamed from: com.google.android.gms.b.av.2 */
    static class C30342 extends av {
        C30342() {
        }

        public String m11838a(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    /* renamed from: com.google.android.gms.b.av.3 */
    static class C30353 extends av {
        C30353() {
        }

        private String m11839a(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String m11840a(String str, String str2) {
            String a = m11839a(str);
            String a2 = m11839a(str2);
            return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : a + Constants.ACCEPT_TIME_SEPARATOR_SP + a2;
        }
    }

    static {
        f10328a = new C30331();
        f10329b = new C30342();
        f10330c = new C30353();
    }

    public abstract String m11835a(String str, String str2);

    public final void m11836a(Map<String, String> map, String str, String str2) {
        map.put(str, m11835a((String) map.get(str), str2));
    }
}
