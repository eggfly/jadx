package p000a;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p000a.p001a.C0037c;

/* renamed from: a.q */
public final class C0127q {
    private final String[] f525a;

    /* renamed from: a.q.a */
    public static final class C0126a {
        final List<String> f524a;

        public C0126a() {
            this.f524a = new ArrayList(20);
        }

        private void m540d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '\u007f') {
                        throw new IllegalArgumentException(C0037c.m153a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                length = str2.length();
                i = 0;
                while (i < length) {
                    charAt = str2.charAt(i);
                    if ((charAt > '\u001f' || charAt == '\t') && charAt < '\u007f') {
                        i++;
                    } else {
                        throw new IllegalArgumentException(C0037c.m153a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                    }
                }
            }
        }

        C0126a m541a(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? m545b(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? m545b(BuildConfig.FLAVOR, str.substring(1)) : m545b(BuildConfig.FLAVOR, str);
        }

        public C0126a m542a(String str, String str2) {
            m540d(str, str2);
            return m545b(str, str2);
        }

        public C0127q m543a() {
            return new C0127q(this);
        }

        public C0126a m544b(String str) {
            int i = 0;
            while (i < this.f524a.size()) {
                if (str.equalsIgnoreCase((String) this.f524a.get(i))) {
                    this.f524a.remove(i);
                    this.f524a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        C0126a m545b(String str, String str2) {
            this.f524a.add(str);
            this.f524a.add(str2.trim());
            return this;
        }

        public C0126a m546c(String str, String str2) {
            m540d(str, str2);
            m544b(str);
            m545b(str, str2);
            return this;
        }
    }

    C0127q(C0126a c0126a) {
        this.f525a = (String[]) c0126a.f524a.toArray(new String[c0126a.f524a.size()]);
    }

    private static String m547a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int m548a() {
        return this.f525a.length / 2;
    }

    public String m549a(int i) {
        return this.f525a[i * 2];
    }

    public String m550a(String str) {
        return C0127q.m547a(this.f525a, str);
    }

    public C0126a m551b() {
        C0126a c0126a = new C0126a();
        Collections.addAll(c0126a.f524a, this.f525a);
        return c0126a;
    }

    public String m552b(int i) {
        return this.f525a[(i * 2) + 1];
    }

    public List<String> m553b(String str) {
        int a = m548a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(m549a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(m552b(i));
            }
        }
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0127q) && Arrays.equals(((C0127q) obj).f525a, this.f525a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f525a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int a = m548a();
        for (int i = 0; i < a; i++) {
            stringBuilder.append(m549a(i)).append(": ").append(m552b(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
