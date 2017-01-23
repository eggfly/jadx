package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.p146b.je;
import com.google.android.gms.p146b.jn;
import com.google.android.gms.p146b.jo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

public abstract class FastJsonResponse {

    /* renamed from: com.google.android.gms.common.server.response.FastJsonResponse.a */
    public interface C3516a<I, O> {
        I m14604a(O o);
    }

    public static class Field<I, O> implements SafeParcelable {
        public static final C3520a CREATOR;
        protected final int f12131a;
        protected final boolean f12132b;
        protected final int f12133c;
        protected final boolean f12134d;
        protected final String f12135e;
        protected final int f12136f;
        protected final Class<? extends FastJsonResponse> f12137g;
        protected final String f12138h;
        private final int f12139i;
        private FieldMappingDictionary f12140j;
        private C3516a<I, O> f12141k;

        static {
            CREATOR = new C3520a();
        }

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.f12139i = i;
            this.f12131a = i2;
            this.f12132b = z;
            this.f12133c = i3;
            this.f12134d = z2;
            this.f12135e = str;
            this.f12136f = i4;
            if (str2 == null) {
                this.f12137g = null;
                this.f12138h = null;
            } else {
                this.f12137g = SafeParcelResponse.class;
                this.f12138h = str2;
            }
            if (converterWrapper == null) {
                this.f12141k = null;
            } else {
                this.f12141k = converterWrapper.m14603c();
            }
        }

        public int m14621a() {
            return this.f12139i;
        }

        public I m14622a(O o) {
            return this.f12141k.m14604a(o);
        }

        public void m14623a(FieldMappingDictionary fieldMappingDictionary) {
            this.f12140j = fieldMappingDictionary;
        }

        public int m14624b() {
            return this.f12131a;
        }

        public boolean m14625c() {
            return this.f12132b;
        }

        public int m14626d() {
            return this.f12133c;
        }

        public int describeContents() {
            C3520a c3520a = CREATOR;
            return 0;
        }

        public boolean m14627e() {
            return this.f12134d;
        }

        public String m14628f() {
            return this.f12135e;
        }

        public int m14629g() {
            return this.f12136f;
        }

        public Class<? extends FastJsonResponse> m14630h() {
            return this.f12137g;
        }

        String m14631i() {
            return this.f12138h == null ? null : this.f12138h;
        }

        public boolean m14632j() {
            return this.f12141k != null;
        }

        ConverterWrapper m14633k() {
            return this.f12141k == null ? null : ConverterWrapper.m14600a(this.f12141k);
        }

        public Map<String, Field<?, ?>> m14634l() {
            C3512u.m14580a(this.f12138h);
            C3512u.m14580a(this.f12140j);
            return this.f12140j.m14650a(this.f12138h);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.f12139i).append('\n');
            stringBuilder.append("                 typeIn=").append(this.f12131a).append('\n');
            stringBuilder.append("            typeInArray=").append(this.f12132b).append('\n');
            stringBuilder.append("                typeOut=").append(this.f12133c).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.f12134d).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.f12135e).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.f12136f).append('\n');
            stringBuilder.append("       concreteTypeName=").append(m14631i()).append('\n');
            if (m14630h() != null) {
                stringBuilder.append("     concreteType.class=").append(m14630h().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.f12141k == null ? "null" : this.f12141k.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            C3520a c3520a = CREATOR;
            C3520a.m14670a(this, parcel, i);
        }
    }

    private void m14635a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.m14624b() == 11) {
            stringBuilder.append(((FastJsonResponse) field.m14630h().cast(obj)).toString());
        } else if (field.m14624b() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(jn.m13564a((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m14636a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m14635a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m14637a(Field<I, O> field, Object obj) {
        return field.f12141k != null ? field.m14622a(obj) : obj;
    }

    protected abstract Object m14638a(String str);

    public abstract Map<String, Field<?, ?>> m14639a();

    protected boolean m14640a(Field field) {
        return field.m14626d() == 11 ? field.m14627e() ? m14646d(field.m14628f()) : m14645c(field.m14628f()) : m14643b(field.m14628f());
    }

    protected Object m14641b(Field field) {
        String f = field.m14628f();
        if (field.m14630h() == null) {
            return m14638a(field.m14628f());
        }
        C3512u.m14586a(m14638a(field.m14628f()) == null, "Concrete field shouldn't be value object: %s", field.m14628f());
        Map c = field.m14627e() ? m14644c() : m14642b();
        if (c != null) {
            return c.get(f);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(f.charAt(0)) + f.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Object> m14642b() {
        return null;
    }

    protected abstract boolean m14643b(String str);

    public HashMap<String, Object> m14644c() {
        return null;
    }

    protected boolean m14645c(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean m14646d(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        Map a = m14639a();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : a.keySet()) {
            Field field = (Field) a.get(str);
            if (m14640a(field)) {
                Object a2 = m14637a(field, m14641b(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a2 != null) {
                    switch (field.m14626d()) {
                        case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                            stringBuilder.append("\"").append(je.m13539a((byte[]) a2)).append("\"");
                            break;
                        case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                            stringBuilder.append("\"").append(je.m13540b((byte[]) a2)).append("\"");
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                            jo.m13565a(stringBuilder, (HashMap) a2);
                            break;
                        default:
                            if (!field.m14625c()) {
                                m14635a(stringBuilder, field, a2);
                                break;
                            }
                            m14636a(stringBuilder, field, (ArrayList) a2);
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
