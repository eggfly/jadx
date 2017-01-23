package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.p146b.jd;
import com.google.android.gms.p146b.je;
import com.google.android.gms.p146b.jn;
import com.google.android.gms.p146b.jo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final C3524e CREATOR;
    private final int f12152a;
    private final Parcel f12153b;
    private final int f12154c;
    private final FieldMappingDictionary f12155d;
    private final String f12156e;
    private int f12157f;
    private int f12158g;

    static {
        CREATOR = new C3524e();
    }

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.f12152a = i;
        this.f12153b = (Parcel) C3512u.m14580a((Object) parcel);
        this.f12154c = 2;
        this.f12155d = fieldMappingDictionary;
        if (this.f12155d == null) {
            this.f12156e = null;
        } else {
            this.f12156e = this.f12155d.m14654d();
        }
        this.f12157f = 2;
    }

    public static HashMap<String, String> m14655a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> m14656a(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).m14629g()), entry);
        }
        return hashMap;
    }

    private void m14657a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                stringBuilder.append(obj);
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                stringBuilder.append("\"").append(jn.m13564a(obj.toString())).append("\"");
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                stringBuilder.append("\"").append(je.m13539a((byte[]) obj)).append("\"");
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                stringBuilder.append("\"").append(je.m13540b((byte[]) obj));
                stringBuilder.append("\"");
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                jo.m13565a(stringBuilder, (HashMap) obj);
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m14658a(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.m14626d()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, Integer.valueOf(C3507a.m14531d(parcel, i))));
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, C3507a.m14535h(parcel, i)));
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, Long.valueOf(C3507a.m14533f(parcel, i))));
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, Float.valueOf(C3507a.m14536i(parcel, i))));
            case SpdyProtocol.QUIC /*4*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, Double.valueOf(C3507a.m14537j(parcel, i))));
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, C3507a.m14538k(parcel, i)));
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, Boolean.valueOf(C3507a.m14530c(parcel, i))));
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, C3507a.m14539l(parcel, i)));
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, C3507a.m14542o(parcel, i)));
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                m14659a(stringBuilder, (Field) field, m14637a(field, m14655a(C3507a.m14541n(parcel, i))));
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.m14626d());
        }
    }

    private void m14659a(StringBuilder stringBuilder, Field<?, ?> field, Object obj) {
        if (field.m14625c()) {
            m14660a(stringBuilder, (Field) field, (ArrayList) obj);
        } else {
            m14657a(stringBuilder, field.m14624b(), obj);
        }
    }

    private void m14660a(StringBuilder stringBuilder, Field<?, ?> field, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            m14657a(stringBuilder, field.m14624b(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    private void m14661a(StringBuilder stringBuilder, String str, Field<?, ?> field, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (field.m14632j()) {
            m14658a(stringBuilder, field, parcel, i);
        } else {
            m14663b(stringBuilder, field, parcel, i);
        }
    }

    private void m14662a(StringBuilder stringBuilder, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap a = m14656a((Map) map);
        stringBuilder.append('{');
        int b = C3507a.m14526b(parcel);
        Object obj = null;
        while (parcel.dataPosition() < b) {
            int a2 = C3507a.m14521a(parcel);
            Entry entry = (Entry) a.get(Integer.valueOf(C3507a.m14520a(a2)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                m14661a(stringBuilder, (String) entry.getKey(), (Field) entry.getValue(), parcel, a2);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new C3506a("Overread allowed size end=" + b, parcel);
        }
        stringBuilder.append('}');
    }

    private void m14663b(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        if (field.m14627e()) {
            stringBuilder.append("[");
            switch (field.m14626d()) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    jd.m13534a(stringBuilder, C3507a.m14544q(parcel, i));
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    jd.m13536a(stringBuilder, C3507a.m14546s(parcel, i));
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    jd.m13535a(stringBuilder, C3507a.m14545r(parcel, i));
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    jd.m13533a(stringBuilder, C3507a.m14547t(parcel, i));
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    jd.m13532a(stringBuilder, C3507a.m14548u(parcel, i));
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    jd.m13536a(stringBuilder, C3507a.m14549v(parcel, i));
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    jd.m13538a(stringBuilder, C3507a.m14543p(parcel, i));
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    jd.m13537a(stringBuilder, C3507a.m14550w(parcel, i));
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    Parcel[] z = C3507a.m14553z(parcel, i);
                    int length = z.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        z[i2].setDataPosition(0);
                        m14662a(stringBuilder, field.m14634l(), z[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.m14626d()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                stringBuilder.append(C3507a.m14531d(parcel, i));
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                stringBuilder.append(C3507a.m14535h(parcel, i));
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                stringBuilder.append(C3507a.m14533f(parcel, i));
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                stringBuilder.append(C3507a.m14536i(parcel, i));
            case SpdyProtocol.QUIC /*4*/:
                stringBuilder.append(C3507a.m14537j(parcel, i));
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                stringBuilder.append(C3507a.m14538k(parcel, i));
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                stringBuilder.append(C3507a.m14530c(parcel, i));
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                stringBuilder.append("\"").append(jn.m13564a(C3507a.m14539l(parcel, i))).append("\"");
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                stringBuilder.append("\"").append(je.m13539a(C3507a.m14542o(parcel, i))).append("\"");
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                stringBuilder.append("\"").append(je.m13540b(C3507a.m14542o(parcel, i)));
                stringBuilder.append("\"");
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                Bundle n = C3507a.m14541n(parcel, i);
                Set<String> keySet = n.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(jn.m13564a(n.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                Parcel y = C3507a.m14552y(parcel, i);
                y.setDataPosition(0);
                m14662a(stringBuilder, field.m14634l(), y);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    protected Object m14664a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, Field<?, ?>> m14665a() {
        return this.f12155d == null ? null : this.f12155d.m14650a(this.f12156e);
    }

    protected boolean m14666b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int m14667d() {
        return this.f12152a;
    }

    public int describeContents() {
        C3524e c3524e = CREATOR;
        return 0;
    }

    public Parcel m14668e() {
        switch (this.f12157f) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f12158g = C3508b.m14554a(this.f12153b);
                C3508b.m14555a(this.f12153b, this.f12158g);
                this.f12157f = 2;
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                C3508b.m14555a(this.f12153b, this.f12158g);
                this.f12157f = 2;
                break;
        }
        return this.f12153b;
    }

    FieldMappingDictionary m14669f() {
        switch (this.f12154c) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return null;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return this.f12155d;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return this.f12155d;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f12154c);
        }
    }

    public String toString() {
        C3512u.m14581a(this.f12155d, (Object) "Cannot convert to JSON on client side.");
        Parcel e = m14668e();
        e.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m14662a(stringBuilder, this.f12155d.m14650a(this.f12156e), e);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3524e c3524e = CREATOR;
        C3524e.m14682a(this, parcel, i);
    }
}
