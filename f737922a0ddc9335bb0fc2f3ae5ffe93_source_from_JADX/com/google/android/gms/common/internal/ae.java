package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ae {

    public static final class a {
        private final Object DW;
        private final List<String> j6;

        private a(Object obj) {
            this.DW = b.j6(obj);
            this.j6 = new ArrayList();
        }

        public a j6(String str, Object obj) {
            List list = this.j6;
            String str2 = (String) b.j6((Object) str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.DW.getClass().getSimpleName()).append('{');
            int size = this.j6.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.j6.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int j6(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a j6(Object obj) {
        return new a(null);
    }

    public static boolean j6(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
