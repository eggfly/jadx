package com.google.android.gms.common.server.response;

import afo;
import afy;
import afz;
import android.os.Parcel;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface a<I, O> {
        I j6(O o);
    }

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR;
        protected final boolean DW;
        private a<I, O> EQ;
        protected final int FH;
        protected final boolean Hw;
        protected final Class<? extends FastJsonResponse> VH;
        protected final int Zo;
        protected final String gn;
        protected final int j6;
        private FieldMappingDictionary tp;
        private final int u7;
        protected final String v5;

        static {
            CREATOR = new a();
        }

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.u7 = i;
            this.j6 = i2;
            this.DW = z;
            this.FH = i3;
            this.Hw = z2;
            this.v5 = str;
            this.Zo = i4;
            if (str2 == null) {
                this.VH = null;
                this.gn = null;
            } else {
                this.VH = SafeParcelResponse.class;
                this.gn = str2;
            }
            if (converterWrapper == null) {
                this.EQ = null;
            } else {
                this.EQ = converterWrapper.FH();
            }
        }

        public int DW() {
            return this.j6;
        }

        ConverterWrapper EQ() {
            return this.EQ == null ? null : ConverterWrapper.j6(this.EQ);
        }

        public boolean FH() {
            return this.DW;
        }

        public int Hw() {
            return this.FH;
        }

        public int VH() {
            return this.Zo;
        }

        public String Zo() {
            return this.v5;
        }

        public Class<? extends FastJsonResponse> gn() {
            return this.VH;
        }

        public int j6() {
            return this.u7;
        }

        public I j6(O o) {
            return this.EQ.j6(o);
        }

        public void j6(FieldMappingDictionary fieldMappingDictionary) {
            this.tp = fieldMappingDictionary;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.u7).append('\n');
            stringBuilder.append("                 typeIn=").append(this.j6).append('\n');
            stringBuilder.append("            typeInArray=").append(this.DW).append('\n');
            stringBuilder.append("                typeOut=").append(this.FH).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.Hw).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.v5).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.Zo).append('\n');
            stringBuilder.append("       concreteTypeName=").append(u7()).append('\n');
            if (gn() != null) {
                stringBuilder.append("     concreteType.class=").append(gn().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.EQ == null ? "null" : this.EQ.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public boolean tp() {
            return this.EQ != null;
        }

        String u7() {
            return this.gn == null ? null : this.gn;
        }

        public boolean v5() {
            return this.Hw;
        }

        public Map<String, Field<?, ?>> we() {
            b.j6(this.gn);
            b.j6(this.tp);
            return this.tp.j6(this.gn);
        }

        public void writeToParcel(Parcel parcel, int i) {
            a aVar = CREATOR;
            a.j6(this, parcel, i);
        }
    }

    private void j6(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.DW() == 11) {
            stringBuilder.append(((FastJsonResponse) field.gn().cast(obj)).toString());
        } else if (field.DW() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(afy.j6((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void j6(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                j6(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected Object DW(Field field) {
        String Zo = field.Zo();
        if (field.gn() == null) {
            return j6(field.Zo());
        }
        b.j6(j6(field.Zo()) == null, "Concrete field shouldn't be value object: %s", field.Zo());
        Map FH = field.v5() ? FH() : DW();
        if (FH != null) {
            return FH.get(Zo);
        }
        try {
            char toUpperCase = Character.toUpperCase(Zo.charAt(0));
            String valueOf = String.valueOf(Zo.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(valueOf).length() + 4).append("get").append(toUpperCase).append(valueOf).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Object> DW() {
        return null;
    }

    protected abstract boolean DW(String str);

    public HashMap<String, Object> FH() {
        return null;
    }

    protected boolean FH(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean Hw(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected <O, I> I j6(Field<I, O> field, Object obj) {
        return field.EQ != null ? field.j6(obj) : obj;
    }

    protected abstract Object j6(String str);

    public abstract Map<String, Field<?, ?>> j6();

    protected boolean j6(Field field) {
        return field.Hw() == 11 ? field.v5() ? Hw(field.Zo()) : FH(field.Zo()) : DW(field.Zo());
    }

    public String toString() {
        Map j6 = j6();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : j6.keySet()) {
            Field field = (Field) j6.get(str);
            if (j6(field)) {
                Object j62 = j6(field, DW(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (j62 != null) {
                    switch (field.Hw()) {
                        case 8:
                            stringBuilder.append("\"").append(afo.j6((byte[]) j62)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(afo.DW((byte[]) j62)).append("\"");
                            break;
                        case 10:
                            afz.j6(stringBuilder, (HashMap) j62);
                            break;
                        default:
                            if (!field.FH()) {
                                j6(stringBuilder, field, j62);
                                break;
                            }
                            j6(stringBuilder, field, (ArrayList) j62);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
