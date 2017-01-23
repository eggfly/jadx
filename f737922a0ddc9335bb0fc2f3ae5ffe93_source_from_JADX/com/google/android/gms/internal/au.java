package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@eh
public abstract class au {
    @eh
    public static final au DW;
    @eh
    public static final au FH;
    @eh
    public static final au j6;

    class 1 extends au {
        1() {
        }

        public String j6(String str, String str2) {
            return str2;
        }
    }

    class 2 extends au {
        2() {
        }

        public String j6(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    class 3 extends au {
        3() {
        }

        private String j6(String str) {
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

        public String j6(String str, String str2) {
            String j6 = j6(str);
            String j62 = j6(str2);
            return TextUtils.isEmpty(j6) ? j62 : TextUtils.isEmpty(j62) ? j6 : new StringBuilder((String.valueOf(j6).length() + 1) + String.valueOf(j62).length()).append(j6).append(",").append(j62).toString();
        }
    }

    static {
        j6 = new 1();
        DW = new 2();
        FH = new 3();
    }

    public abstract String j6(String str, String str2);

    public final void j6(Map<String, String> map, String str, String str2) {
        map.put(str, j6((String) map.get(str), str2));
    }
}
