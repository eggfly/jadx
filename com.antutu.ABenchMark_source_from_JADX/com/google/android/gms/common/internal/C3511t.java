package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.t */
public final class C3511t {

    /* renamed from: com.google.android.gms.common.internal.t.a */
    public static final class C3510a {
        private final List<String> f12117a;
        private final Object f12118b;

        private C3510a(Object obj) {
            this.f12118b = C3512u.m14580a(obj);
            this.f12117a = new ArrayList();
        }

        public C3510a m14576a(String str, Object obj) {
            this.f12117a.add(((String) C3512u.m14580a((Object) str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f12118b.getClass().getSimpleName()).append('{');
            int size = this.f12117a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f12117a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m14577a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C3510a m14578a(Object obj) {
        return new C3510a(null);
    }

    public static boolean m14579a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
