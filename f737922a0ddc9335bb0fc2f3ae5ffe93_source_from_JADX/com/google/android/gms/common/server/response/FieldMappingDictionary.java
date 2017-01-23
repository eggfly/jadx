package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final c CREATOR;
    private final HashMap<String, Map<String, Field<?, ?>>> DW;
    private final ArrayList<Entry> FH;
    private final String Hw;
    private final int j6;

    public static class Entry extends AbstractSafeParcelable {
        public static final d CREATOR;
        final String DW;
        final ArrayList<FieldMapPair> FH;
        final int j6;

        static {
            CREATOR = new d();
        }

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.j6 = i;
            this.DW = str;
            this.FH = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.j6 = 1;
            this.DW = str;
            this.FH = j6(map);
        }

        private static ArrayList<FieldMapPair> j6(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        HashMap<String, Field<?, ?>> j6() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.FH.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.FH.get(i);
                hashMap.put(fieldMapPair.DW, fieldMapPair.FH);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            d dVar = CREATOR;
            d.j6(this, parcel, i);
        }
    }

    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final b CREATOR;
        final String DW;
        final Field<?, ?> FH;
        final int j6;

        static {
            CREATOR = new b();
        }

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.j6 = i;
            this.DW = str;
            this.FH = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.j6 = 1;
            this.DW = str;
            this.FH = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            b bVar = CREATOR;
            b.j6(this, parcel, i);
        }
    }

    static {
        CREATOR = new c();
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.j6 = i;
        this.FH = null;
        this.DW = j6((ArrayList) arrayList);
        this.Hw = (String) b.j6((Object) str);
        j6();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> j6(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.DW, entry.j6());
        }
        return hashMap;
    }

    int DW() {
        return this.j6;
    }

    ArrayList<Entry> FH() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.DW.keySet()) {
            arrayList.add(new Entry(str, (Map) this.DW.get(str)));
        }
        return arrayList;
    }

    public String Hw() {
        return this.Hw;
    }

    public Map<String, Field<?, ?>> j6(String str) {
        return (Map) this.DW.get(str);
    }

    public void j6() {
        for (String str : this.DW.keySet()) {
            Map map = (Map) this.DW.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).j6(this);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.DW.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.DW.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c cVar = CREATOR;
        c.j6(this, parcel, i);
    }
}
