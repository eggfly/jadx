package com.google.android.gms.measurement.internal;

import afq;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.hr.c;
import com.google.android.gms.internal.hr.f;
import com.google.android.gms.internal.ht;
import com.google.android.gms.internal.ht.a;
import com.google.android.gms.internal.ht.d;
import com.google.android.gms.internal.ht.e;
import com.google.android.gms.internal.ht.g;
import com.google.android.gms.internal.m;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class l extends ak {
    l(ai aiVar) {
        super(aiVar);
    }

    public static String DW(d dVar) {
        if (dVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (dVar.j6 != null) {
            for (e eVar : dVar.j6) {
                if (eVar != null) {
                    j6(stringBuilder, 1, eVar);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private int EQ(String str) {
        return "_ldl".equals(str) ? er().gW() : er().yS();
    }

    static long FH(byte[] bArr) {
        long j = null;
        b.j6((Object) bArr);
        b.j6(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean FH(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest gn(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    private Object j6(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? j6(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String j6(hr.b bVar) {
        int i = 0;
        if (bVar == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        j6(stringBuilder, 0, "filter_id", bVar.j6);
        j6(stringBuilder, 0, "event_name", bVar.DW);
        j6(stringBuilder, 1, "event_count_filter", bVar.v5);
        stringBuilder.append("  filters {\n");
        c[] cVarArr = bVar.FH;
        int length = cVarArr.length;
        while (i < length) {
            j6(stringBuilder, 2, cVarArr[i]);
            i++;
        }
        j6(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String j6(hr.e eVar) {
        if (eVar == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        j6(stringBuilder, 0, "filter_id", eVar.j6);
        j6(stringBuilder, 0, "property_name", eVar.DW);
        j6(stringBuilder, 1, eVar.FH);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void j6(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, c cVar) {
        if (cVar != null) {
            j6(stringBuilder, i);
            stringBuilder.append("filter {\n");
            j6(stringBuilder, i, "complement", cVar.FH);
            j6(stringBuilder, i, "param_name", cVar.Hw);
            j6(stringBuilder, i + 1, "string_filter", cVar.j6);
            j6(stringBuilder, i + 1, "number_filter", cVar.DW);
            j6(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, e eVar) {
        if (eVar != null) {
            j6(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            j6(stringBuilder, i, "protocol_version", eVar.j6);
            j6(stringBuilder, i, "platform", eVar.u7);
            j6(stringBuilder, i, "gmp_version", eVar.aM);
            j6(stringBuilder, i, "uploading_gmp_version", eVar.j3);
            j6(stringBuilder, i, "gmp_app_id", eVar.yS);
            j6(stringBuilder, i, "app_id", eVar.QX);
            j6(stringBuilder, i, "app_version", eVar.XL);
            j6(stringBuilder, i, "app_version_major", eVar.P8);
            j6(stringBuilder, i, "firebase_instance_id", eVar.vy);
            j6(stringBuilder, i, "dev_cert_hash", eVar.lg);
            j6(stringBuilder, i, "app_store", eVar.Ws);
            j6(stringBuilder, i, "upload_timestamp_millis", eVar.Hw);
            j6(stringBuilder, i, "start_timestamp_millis", eVar.v5);
            j6(stringBuilder, i, "end_timestamp_millis", eVar.Zo);
            j6(stringBuilder, i, "previous_bundle_start_timestamp_millis", eVar.VH);
            j6(stringBuilder, i, "previous_bundle_end_timestamp_millis", eVar.gn);
            j6(stringBuilder, i, "app_instance_id", eVar.a8);
            j6(stringBuilder, i, "resettable_device_id", eVar.Mr);
            j6(stringBuilder, i, "device_id", eVar.SI);
            j6(stringBuilder, i, "limited_ad_tracking", eVar.U2);
            j6(stringBuilder, i, "os_version", eVar.tp);
            j6(stringBuilder, i, "device_model", eVar.EQ);
            j6(stringBuilder, i, "user_default_language", eVar.we);
            j6(stringBuilder, i, "time_zone_offset_minutes", eVar.J0);
            j6(stringBuilder, i, "bundle_sequential_index", eVar.rN);
            j6(stringBuilder, i, "service_upload", eVar.gW);
            j6(stringBuilder, i, "health_monitor", eVar.er);
            j6(stringBuilder, i, eVar.FH);
            j6(stringBuilder, i, eVar.BT);
            j6(stringBuilder, i, eVar.DW);
            j6(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, String str, hr.d dVar) {
        if (dVar != null) {
            j6(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (dVar.j6 != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (dVar.j6.intValue()) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        obj = "LESS_THAN";
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        obj = "GREATER_THAN";
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        obj = "EQUAL";
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        obj = "BETWEEN";
                        break;
                }
                j6(stringBuilder, i, "comparison_type", obj);
            }
            j6(stringBuilder, i, "match_as_float", dVar.DW);
            j6(stringBuilder, i, "comparison_value", dVar.FH);
            j6(stringBuilder, i, "min_comparison_value", dVar.Hw);
            j6(stringBuilder, i, "max_comparison_value", dVar.v5);
            j6(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, String str, f fVar) {
        if (fVar != null) {
            j6(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (fVar.j6 != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (fVar.j6.intValue()) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        obj = "REGEXP";
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        obj = "BEGINS_WITH";
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        obj = "ENDS_WITH";
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        obj = "PARTIAL";
                        break;
                    case 5:
                        obj = "EXACT";
                        break;
                    case 6:
                        obj = "IN_LIST";
                        break;
                }
                j6(stringBuilder, i, "match_type", obj);
            }
            j6(stringBuilder, i, "expression", fVar.DW);
            j6(stringBuilder, i, "case_sensitive", fVar.FH);
            if (fVar.Hw.length > 0) {
                j6(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : fVar.Hw) {
                    j6(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            j6(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, String str, ht.f fVar) {
        int i2 = 0;
        if (fVar != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            j6(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (fVar.DW != null) {
                j6(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = fVar.DW;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (fVar.j6 != null) {
                j6(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = fVar.j6;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            j6(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            j6(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, a[] aVarArr) {
        if (aVarArr != null) {
            int i2 = i + 1;
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    j6(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    j6(stringBuilder, i2, "audience_id", aVar.j6);
                    j6(stringBuilder, i2, "new_audience", aVar.Hw);
                    j6(stringBuilder, i2, "current_data", aVar.DW);
                    j6(stringBuilder, i2, "previous_data", aVar.FH);
                    j6(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, ht.b[] bVarArr) {
        if (bVarArr != null) {
            int i2 = i + 1;
            for (ht.b bVar : bVarArr) {
                if (bVar != null) {
                    j6(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    j6(stringBuilder, i2, "name", bVar.DW);
                    j6(stringBuilder, i2, "timestamp_millis", bVar.FH);
                    j6(stringBuilder, i2, "previous_timestamp_millis", bVar.Hw);
                    j6(stringBuilder, i2, "count", bVar.v5);
                    j6(stringBuilder, i2, bVar.j6);
                    j6(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, ht.c[] cVarArr) {
        if (cVarArr != null) {
            int i2 = i + 1;
            for (ht.c cVar : cVarArr) {
                if (cVar != null) {
                    j6(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    j6(stringBuilder, i2, "name", cVar.j6);
                    j6(stringBuilder, i2, "string_value", cVar.DW);
                    j6(stringBuilder, i2, "int_value", cVar.FH);
                    j6(stringBuilder, i2, "double_value", cVar.v5);
                    j6(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void j6(StringBuilder stringBuilder, int i, g[] gVarArr) {
        if (gVarArr != null) {
            int i2 = i + 1;
            for (g gVar : gVarArr) {
                if (gVar != null) {
                    j6(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    j6(stringBuilder, i2, "set_timestamp_millis", gVar.j6);
                    j6(stringBuilder, i2, "name", gVar.DW);
                    j6(stringBuilder, i2, "string_value", gVar.FH);
                    j6(stringBuilder, i2, "int_value", gVar.Hw);
                    j6(stringBuilder, i2, "double_value", gVar.Zo);
                    j6(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean j6(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean j6(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean j6(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    static boolean j6(String str) {
        b.j6(str);
        return str.charAt(0) != '_';
    }

    public static boolean j6(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] j6(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static boolean tp(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public int DW(String str) {
        return !DW("event", str) ? 2 : !j6("event", AppMeasurement.a.j6, str) ? 13 : j6("event", er().FH(), str) ? 0 : 2;
    }

    public Object DW(String str, Object obj) {
        if ("_ev".equals(str)) {
            return j6(er().VH(), obj, true);
        }
        return j6(tp(str) ? er().VH() : er().Zo(), obj, false);
    }

    boolean DW(String str, String str2) {
        if (str2 == null) {
            lg().Zo().j6("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            lg().Zo().j6("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        lg().Zo().j6("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            lg().Zo().j6("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public byte[] DW(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            lg().Zo().j6("Failed to ungzip content", e);
            throw e;
        }
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public int FH(String str) {
        return !DW("user property", str) ? 6 : !j6("user property", AppMeasurement.e.j6, str) ? 15 : j6("user property", er().Hw(), str) ? 0 : 6;
    }

    public int FH(String str, Object obj) {
        return "_ldl".equals(str) ? j6("user property referrer", str, EQ(str), obj) : j6("user property", str, EQ(str), obj) ? 0 : 7;
    }

    public int Hw(String str) {
        return !j6("event param", str) ? 3 : !j6("event param", null, str) ? 14 : j6("event param", er().v5(), str) ? 0 : 3;
    }

    public long Hw(byte[] bArr) {
        b.j6((Object) bArr);
        MessageDigest gn = gn("MD5");
        if (gn != null) {
            return FH(gn.digest(bArr));
        }
        lg().Zo().j6("Failed to get MD5");
        return 0;
    }

    public Object Hw(String str, Object obj) {
        return "_ldl".equals(str) ? j6(EQ(str), obj, true) : j6(EQ(str), obj, false);
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    boolean VH(String str) {
        b.j6((Object) str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public boolean Zo(String str) {
        if (TextUtils.isEmpty(str)) {
            lg().Zo().j6("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            lg().yS().j6("Measurement Service called with unknown id version", str);
            return true;
        } else if (VH(str)) {
            return true;
        } else {
            lg().Zo().j6("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    public Bundle j6(String str, Bundle bundle, List<String> list, boolean z) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int DW = er().DW();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int Hw;
            if (list == null || !list.contains(str2)) {
                Hw = z ? Hw(str2) : 0;
                if (Hw == 0) {
                    Hw = v5(str2);
                }
            } else {
                Hw = 0;
            }
            if (Hw != 0) {
                if (j6(bundle2, Hw)) {
                    bundle2.putString("_ev", j6(str2, er().v5(), true));
                }
                bundle2.remove(str2);
            } else if (j6(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (j6(str2)) {
                    i++;
                    if (i > DW) {
                        lg().Zo().j6("Event can't contain more then " + DW + " params", str, bundle);
                        j6(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i = i;
            } else {
                if (j6(bundle2, 4)) {
                    bundle2.putString("_ev", j6(str2, er().v5(), true));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String j6(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    public void j6(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        j6(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.J8.we().j6("auto", "_err", bundle);
    }

    public void j6(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                lg().BT().j6("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void j6(ht.c cVar, Object obj) {
        b.j6(obj);
        cVar.DW = null;
        cVar.FH = null;
        cVar.v5 = null;
        if (obj instanceof String) {
            cVar.DW = (String) obj;
        } else if (obj instanceof Long) {
            cVar.FH = (Long) obj;
        } else if (obj instanceof Double) {
            cVar.v5 = (Double) obj;
        } else {
            lg().Zo().j6("Ignoring invalid (type) event param value", obj);
        }
    }

    public void j6(g gVar, Object obj) {
        b.j6(obj);
        gVar.FH = null;
        gVar.Hw = null;
        gVar.Zo = null;
        if (obj instanceof String) {
            gVar.FH = (String) obj;
        } else if (obj instanceof Long) {
            gVar.Hw = (Long) obj;
        } else if (obj instanceof Double) {
            gVar.Zo = (Double) obj;
        } else {
            lg().Zo().j6("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public boolean j6(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(QX().j6() - j) > j2;
    }

    public boolean j6(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    boolean j6(String str, int i, String str2) {
        if (str2 == null) {
            lg().Zo().j6("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            lg().Zo().j6("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public boolean j6(String str, Object obj) {
        return tp(str) ? j6("param", str, er().VH(), obj) : j6("param", str, er().Zo(), obj);
    }

    boolean j6(String str, String str2) {
        if (str2 == null) {
            lg().Zo().j6("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            lg().Zo().j6("Name is required and can't be empty. Type", str);
            return false;
        } else if (Character.isLetter(str2.charAt(0))) {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    lg().Zo().j6("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        } else {
            lg().Zo().j6("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean j6(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        lg().yS().j6("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    boolean j6(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            lg().Zo().j6("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            lg().Zo().j6("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            lg().Zo().j6("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public byte[] j6(d dVar) {
        try {
            byte[] bArr = new byte[dVar.VH()];
            m j6 = m.j6(bArr);
            dVar.j6(j6);
            j6.DW();
            return bArr;
        } catch (IOException e) {
            lg().Zo().j6("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] j6(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            lg().Zo().j6("Failed to gzip content", e);
            throw e;
        }
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    public boolean u7(String str) {
        tp();
        if (XL().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        lg().P8().j6("Permission not granted", str);
        return false;
    }

    public int v5(String str) {
        return !DW("event param", str) ? 3 : !j6("event param", null, str) ? 14 : j6("event param", er().v5(), str) ? 0 : 3;
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }
}
