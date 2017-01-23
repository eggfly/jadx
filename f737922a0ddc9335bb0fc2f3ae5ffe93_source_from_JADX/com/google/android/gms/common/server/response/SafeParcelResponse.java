package com.google.android.gms.common.server.response;

import afn;
import afo;
import afy;
import afz;
import android.os.Bundle;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final e CREATOR;
    private final Parcel DW;
    private final int FH;
    private final FieldMappingDictionary Hw;
    private int VH;
    private int Zo;
    private final int j6;
    private final String v5;

    static {
        CREATOR = new e();
    }

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.j6 = i;
        this.DW = (Parcel) b.j6((Object) parcel);
        this.FH = 2;
        this.Hw = fieldMappingDictionary;
        if (this.Hw == null) {
            this.v5 = null;
        } else {
            this.v5 = this.Hw.Hw();
        }
        this.Zo = 2;
    }

    private void DW(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        if (field.v5()) {
            stringBuilder.append("[");
            switch (field.Hw()) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    afn.j6(stringBuilder, a.j3(parcel, i));
                    break;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    afn.j6(stringBuilder, a.U2(parcel, i));
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    afn.j6(stringBuilder, a.Mr(parcel, i));
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    afn.j6(stringBuilder, a.a8(parcel, i));
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    afn.j6(stringBuilder, a.lg(parcel, i));
                    break;
                case 5:
                    afn.j6(stringBuilder, a.rN(parcel, i));
                    break;
                case 6:
                    afn.j6(stringBuilder, a.aM(parcel, i));
                    break;
                case 7:
                    afn.j6(stringBuilder, a.er(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] BT = a.BT(parcel, i);
                    int length = BT.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        BT[i2].setDataPosition(0);
                        j6(stringBuilder, field.we(), BT[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.Hw()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                stringBuilder.append(a.Hw(parcel, i));
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuilder.append(a.gn(parcel, i));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuilder.append(a.Zo(parcel, i));
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                stringBuilder.append(a.u7(parcel, i));
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuilder.append(a.EQ(parcel, i));
            case 5:
                stringBuilder.append(a.J0(parcel, i));
            case 6:
                stringBuilder.append(a.FH(parcel, i));
            case 7:
                stringBuilder.append("\"").append(afy.j6(a.J8(parcel, i))).append("\"");
            case 8:
                stringBuilder.append("\"").append(afo.j6(a.XL(parcel, i))).append("\"");
            case 9:
                stringBuilder.append("\"").append(afo.DW(a.XL(parcel, i)));
                stringBuilder.append("\"");
            case 10:
                Bundle QX = a.QX(parcel, i);
                Set<String> keySet = QX.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(afy.j6(QX.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case 11:
                Parcel gW = a.gW(parcel, i);
                gW.setDataPosition(0);
                j6(stringBuilder, field.we(), gW);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public static HashMap<String, String> j6(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> j6(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).VH()), entry);
        }
        return hashMap;
    }

    private void j6(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
                stringBuilder.append(obj);
            case 7:
                stringBuilder.append("\"").append(afy.j6(obj.toString())).append("\"");
            case 8:
                stringBuilder.append("\"").append(afo.j6((byte[]) obj)).append("\"");
            case 9:
                stringBuilder.append("\"").append(afo.DW((byte[]) obj));
                stringBuilder.append("\"");
            case 10:
                afz.j6(stringBuilder, (HashMap) obj);
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void j6(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.Hw()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j6(stringBuilder, (Field) field, j6(field, Integer.valueOf(a.Hw(parcel, i))));
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6(stringBuilder, (Field) field, j6(field, a.gn(parcel, i)));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6(stringBuilder, (Field) field, j6(field, Long.valueOf(a.Zo(parcel, i))));
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6(stringBuilder, (Field) field, j6(field, Float.valueOf(a.u7(parcel, i))));
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j6(stringBuilder, (Field) field, j6(field, Double.valueOf(a.EQ(parcel, i))));
            case 5:
                j6(stringBuilder, (Field) field, j6(field, a.J0(parcel, i)));
            case 6:
                j6(stringBuilder, (Field) field, j6(field, Boolean.valueOf(a.FH(parcel, i))));
            case 7:
                j6(stringBuilder, (Field) field, j6(field, a.J8(parcel, i)));
            case 8:
            case 9:
                j6(stringBuilder, (Field) field, j6(field, a.XL(parcel, i)));
            case 10:
                j6(stringBuilder, (Field) field, j6(field, j6(a.QX(parcel, i))));
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.Hw());
        }
    }

    private void j6(StringBuilder stringBuilder, Field<?, ?> field, Object obj) {
        if (field.FH()) {
            j6(stringBuilder, (Field) field, (ArrayList) obj);
        } else {
            j6(stringBuilder, field.DW(), obj);
        }
    }

    private void j6(StringBuilder stringBuilder, Field<?, ?> field, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            j6(stringBuilder, field.DW(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    private void j6(StringBuilder stringBuilder, String str, Field<?, ?> field, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (field.tp()) {
            j6(stringBuilder, field, parcel, i);
        } else {
            DW(stringBuilder, field, parcel, i);
        }
    }

    private void j6(StringBuilder stringBuilder, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap j6 = j6((Map) map);
        stringBuilder.append('{');
        int DW = a.DW(parcel);
        Object obj = null;
        while (parcel.dataPosition() < DW) {
            int j62 = a.j6(parcel);
            Entry entry = (Entry) j6.get(Integer.valueOf(a.j6(j62)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                j6(stringBuilder, (String) entry.getKey(), (Field) entry.getValue(), parcel, j62);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != DW) {
            throw new a.a("Overread allowed size end=" + DW, parcel);
        }
        stringBuilder.append('}');
    }

    public boolean DW(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int Hw() {
        return this.j6;
    }

    FieldMappingDictionary Zo() {
        switch (this.FH) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return null;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return this.Hw;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return this.Hw;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.FH);
        }
    }

    public Object j6(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, Field<?, ?>> j6() {
        return this.Hw == null ? null : this.Hw.j6(this.v5);
    }

    public String toString() {
        b.j6(this.Hw, (Object) "Cannot convert to JSON on client side.");
        Parcel v5 = v5();
        v5.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        j6(stringBuilder, this.Hw.j6(this.v5), v5);
        return stringBuilder.toString();
    }

    public Parcel v5() {
        switch (this.Zo) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.VH = com.google.android.gms.common.internal.safeparcel.b.j6(this.DW);
                com.google.android.gms.common.internal.safeparcel.b.j6(this.DW, this.VH);
                this.Zo = 2;
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                com.google.android.gms.common.internal.safeparcel.b.j6(this.DW, this.VH);
                this.Zo = 2;
                break;
        }
        return this.DW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        e eVar = CREATOR;
        e.j6(this, parcel, i);
    }
}
