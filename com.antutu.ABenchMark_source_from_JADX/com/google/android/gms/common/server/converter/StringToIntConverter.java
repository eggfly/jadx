package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.C3516a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, C3516a<String, Integer> {
    public static final C3518b CREATOR;
    private final int f12127a;
    private final HashMap<String, Integer> f12128b;
    private final HashMap<Integer, String> f12129c;
    private final ArrayList<Entry> f12130d;

    public static final class Entry implements SafeParcelable {
        public static final C3519c CREATOR;
        final int f12124a;
        final String f12125b;
        final int f12126c;

        static {
            CREATOR = new C3519c();
        }

        Entry(int i, String str, int i2) {
            this.f12124a = i;
            this.f12125b = str;
            this.f12126c = i2;
        }

        Entry(String str, int i) {
            this.f12124a = 1;
            this.f12125b = str;
            this.f12126c = i;
        }

        public int describeContents() {
            C3519c c3519c = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C3519c c3519c = CREATOR;
            C3519c.m14617a(this, parcel, i);
        }
    }

    static {
        CREATOR = new C3518b();
    }

    public StringToIntConverter() {
        this.f12127a = 1;
        this.f12128b = new HashMap();
        this.f12129c = new HashMap();
        this.f12130d = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.f12127a = i;
        this.f12128b = new HashMap();
        this.f12129c = new HashMap();
        this.f12130d = null;
        m14605a((ArrayList) arrayList);
    }

    private void m14605a(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            m14607a(entry.f12125b, entry.f12126c);
        }
    }

    int m14606a() {
        return this.f12127a;
    }

    public StringToIntConverter m14607a(String str, int i) {
        this.f12128b.put(str, Integer.valueOf(i));
        this.f12129c.put(Integer.valueOf(i), str);
        return this;
    }

    public /* synthetic */ Object m14608a(Object obj) {
        return m14609a((Integer) obj);
    }

    public String m14609a(Integer num) {
        String str = (String) this.f12129c.get(num);
        return (str == null && this.f12128b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    ArrayList<Entry> m14610b() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.f12128b.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.f12128b.get(str)).intValue()));
        }
        return arrayList;
    }

    public int describeContents() {
        C3518b c3518b = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3518b c3518b = CREATOR;
        C3518b.m14614a(this, parcel, i);
    }
}
