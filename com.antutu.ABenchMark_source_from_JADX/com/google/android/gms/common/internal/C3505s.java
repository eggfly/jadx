package com.google.android.gms.common.internal;

import java.util.Iterator;

/* renamed from: com.google.android.gms.common.internal.s */
public class C3505s {
    private final String f12116a;

    private C3505s(String str) {
        this.f12116a = str;
    }

    public static C3505s m14516a(String str) {
        return new C3505s(str);
    }

    CharSequence m14517a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String m14518a(Iterable<?> iterable) {
        return m14519a(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder m14519a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(m14517a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.f12116a);
                stringBuilder.append(m14517a(it.next()));
            }
        }
        return stringBuilder;
    }
}
