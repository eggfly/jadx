package com.google.android.gms.common.internal;

import java.util.Iterator;

public class ac {
    private final String j6;

    private ac(String str) {
        this.j6 = str;
    }

    public static ac j6(String str) {
        return new ac(str);
    }

    CharSequence j6(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String j6(Iterable<?> iterable) {
        return j6(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder j6(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(j6(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.j6);
                stringBuilder.append(j6(it.next()));
            }
        }
        return stringBuilder;
    }
}
