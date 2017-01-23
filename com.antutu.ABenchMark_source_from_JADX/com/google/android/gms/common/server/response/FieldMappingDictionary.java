package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final C3522c CREATOR;
    private final int f12148a;
    private final HashMap<String, Map<String, Field<?, ?>>> f12149b;
    private final ArrayList<Entry> f12150c;
    private final String f12151d;

    public static class Entry implements SafeParcelable {
        public static final C3523d CREATOR;
        final int f12142a;
        final String f12143b;
        final ArrayList<FieldMapPair> f12144c;

        static {
            CREATOR = new C3523d();
        }

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.f12142a = i;
            this.f12143b = str;
            this.f12144c = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.f12142a = 1;
            this.f12143b = str;
            this.f12144c = m14647a(map);
        }

        private static ArrayList<FieldMapPair> m14647a(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        HashMap<String, Field<?, ?>> m14648a() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.f12144c.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.f12144c.get(i);
                hashMap.put(fieldMapPair.f12146b, fieldMapPair.f12147c);
            }
            return hashMap;
        }

        public int describeContents() {
            C3523d c3523d = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C3523d c3523d = CREATOR;
            C3523d.m14679a(this, parcel, i);
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final C3521b CREATOR;
        final int f12145a;
        final String f12146b;
        final Field<?, ?> f12147c;

        static {
            CREATOR = new C3521b();
        }

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.f12145a = i;
            this.f12146b = str;
            this.f12147c = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.f12145a = 1;
            this.f12146b = str;
            this.f12147c = field;
        }

        public int describeContents() {
            C3521b c3521b = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C3521b c3521b = CREATOR;
            C3521b.m14673a(this, parcel, i);
        }
    }

    static {
        CREATOR = new C3522c();
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.f12148a = i;
        this.f12150c = null;
        this.f12149b = m14649a((ArrayList) arrayList);
        this.f12151d = (String) C3512u.m14580a((Object) str);
        m14651a();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> m14649a(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.f12143b, entry.m14648a());
        }
        return hashMap;
    }

    public Map<String, Field<?, ?>> m14650a(String str) {
        return (Map) this.f12149b.get(str);
    }

    public void m14651a() {
        for (String str : this.f12149b.keySet()) {
            Map map = (Map) this.f12149b.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).m14623a(this);
            }
        }
    }

    int m14652b() {
        return this.f12148a;
    }

    ArrayList<Entry> m14653c() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.f12149b.keySet()) {
            arrayList.add(new Entry(str, (Map) this.f12149b.get(str)));
        }
        return arrayList;
    }

    public String m14654d() {
        return this.f12151d;
    }

    public int describeContents() {
        C3522c c3522c = CREATOR;
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f12149b.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.f12149b.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3522c c3522c = CREATOR;
        C3522c.m14676a(this, parcel, i);
    }
}
