package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter extends AbstractSafeParcelable implements a<String, Integer> {
    public static final b CREATOR;
    private final HashMap<String, Integer> DW;
    private final HashMap<Integer, String> FH;
    private final ArrayList<Entry> Hw;
    private final int j6;

    public static final class Entry extends AbstractSafeParcelable {
        public static final c CREATOR;
        final String DW;
        final int FH;
        final int j6;

        static {
            CREATOR = new c();
        }

        Entry(int i, String str, int i2) {
            this.j6 = i;
            this.DW = str;
            this.FH = i2;
        }

        Entry(String str, int i) {
            this.j6 = 1;
            this.DW = str;
            this.FH = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            c cVar = CREATOR;
            c.j6(this, parcel, i);
        }
    }

    static {
        CREATOR = new b();
    }

    public StringToIntConverter() {
        this.j6 = 1;
        this.DW = new HashMap();
        this.FH = new HashMap();
        this.Hw = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.j6 = i;
        this.DW = new HashMap();
        this.FH = new HashMap();
        this.Hw = null;
        j6((ArrayList) arrayList);
    }

    private void j6(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            j6(entry.DW, entry.FH);
        }
    }

    ArrayList<Entry> DW() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.DW.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.DW.get(str)).intValue()));
        }
        return arrayList;
    }

    int j6() {
        return this.j6;
    }

    public StringToIntConverter j6(String str, int i) {
        this.DW.put(str, Integer.valueOf(i));
        this.FH.put(Integer.valueOf(i), str);
        return this;
    }

    public /* synthetic */ Object j6(Object obj) {
        return j6((Integer) obj);
    }

    public String j6(Integer num) {
        String str = (String) this.FH.get(num);
        return (str == null && this.DW.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b bVar = CREATOR;
        b.j6(this, parcel, i);
    }
}
