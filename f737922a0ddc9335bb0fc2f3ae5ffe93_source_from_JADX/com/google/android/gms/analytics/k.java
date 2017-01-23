package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class k implements r {
    private static final Uri j6;
    private final LogPrinter DW;

    class 1 implements Comparator<n> {
        final /* synthetic */ k j6;

        1(k kVar) {
            this.j6 = kVar;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((n) obj, (n) obj2);
        }

        public int j6(n nVar, n nVar2) {
            return nVar.getClass().getCanonicalName().compareTo(nVar2.getClass().getCanonicalName());
        }
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        j6 = builder.build();
    }

    public k() {
        this.DW = new LogPrinter(4, "GA/LogCatTransport");
    }

    public Uri j6() {
        return j6;
    }

    public void j6(l lVar) {
        List<n> arrayList = new ArrayList(lVar.DW());
        Collections.sort(arrayList, new 1(this));
        StringBuilder stringBuilder = new StringBuilder();
        for (n obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.DW.println(stringBuilder.toString());
    }
}
