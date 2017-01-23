package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smack.util.C4496g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.xiaomi.smack.packet.a */
public class C4479a implements C4478e {
    private String f15373a;
    private String f15374b;
    private String[] f15375c;
    private String[] f15376d;
    private String f15377e;
    private List<C4479a> f15378f;

    public C4479a(String str, String str2, String[] strArr, String[] strArr2) {
        this.f15375c = null;
        this.f15376d = null;
        this.f15378f = null;
        this.f15373a = str;
        this.f15374b = str2;
        this.f15375c = strArr;
        this.f15376d = strArr2;
    }

    public C4479a(String str, String str2, String[] strArr, String[] strArr2, String str3, List<C4479a> list) {
        this.f15375c = null;
        this.f15376d = null;
        this.f15378f = null;
        this.f15373a = str;
        this.f15374b = str2;
        this.f15375c = strArr;
        this.f15376d = strArr2;
        this.f15377e = str3;
        this.f15378f = list;
    }

    public static C4479a m18568a(Bundle bundle) {
        List arrayList;
        int i = 0;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i2 = 0;
        for (String str : keySet) {
            strArr[i2] = str;
            strArr2[i2] = bundle2.getString(str);
            i2++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            arrayList = new ArrayList(parcelableArray.length);
            int length = parcelableArray.length;
            while (i < length) {
                arrayList.add(C4479a.m18568a((Bundle) parcelableArray[i]));
                i++;
            }
        } else {
            arrayList = null;
        }
        return new C4479a(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] m18569a(List<C4479a> list) {
        return C4479a.m18570a((C4479a[]) list.toArray(new C4479a[list.size()]));
    }

    public static Parcelable[] m18570a(C4479a[] c4479aArr) {
        if (c4479aArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[c4479aArr.length];
        for (int i = 0; i < c4479aArr.length; i++) {
            parcelableArr[i] = c4479aArr[i].m18578f();
        }
        return parcelableArr;
    }

    public String m18571a() {
        return this.f15373a;
    }

    public String m18572a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f15375c != null) {
            for (int i = 0; i < this.f15375c.length; i++) {
                if (str.equals(this.f15375c[i])) {
                    return this.f15376d[i];
                }
            }
        }
        return null;
    }

    public String m18573b() {
        return this.f15374b;
    }

    public void m18574b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f15377e = str;
        } else {
            this.f15377e = C4496g.m18647a(str);
        }
    }

    public String m18575c() {
        return !TextUtils.isEmpty(this.f15377e) ? C4496g.m18651b(this.f15377e) : this.f15377e;
    }

    public String m18576d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(this.f15373a);
        if (!TextUtils.isEmpty(this.f15374b)) {
            stringBuilder.append(" ").append("xmlns=").append("\"").append(this.f15374b).append("\"");
        }
        if (this.f15375c != null && this.f15375c.length > 0) {
            for (int i = 0; i < this.f15375c.length; i++) {
                if (!TextUtils.isEmpty(this.f15376d[i])) {
                    stringBuilder.append(" ").append(this.f15375c[i]).append("=\"").append(C4496g.m18647a(this.f15376d[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f15377e)) {
            stringBuilder.append(">").append(this.f15377e).append("</").append(this.f15373a).append(">");
        } else if (this.f15378f == null || this.f15378f.size() <= 0) {
            stringBuilder.append("/>");
        } else {
            stringBuilder.append(">");
            for (C4479a d : this.f15378f) {
                stringBuilder.append(d.m18576d());
            }
            stringBuilder.append("</").append(this.f15373a).append(">");
        }
        return stringBuilder.toString();
    }

    public Bundle m18577e() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f15373a);
        bundle.putString("ext_ns", this.f15374b);
        bundle.putString("ext_text", this.f15377e);
        Bundle bundle2 = new Bundle();
        if (this.f15375c != null && this.f15375c.length > 0) {
            for (int i = 0; i < this.f15375c.length; i++) {
                bundle2.putString(this.f15375c[i], this.f15376d[i]);
            }
        }
        bundle.putBundle("attributes", bundle2);
        if (this.f15378f != null && this.f15378f.size() > 0) {
            bundle.putParcelableArray("children", C4479a.m18569a(this.f15378f));
        }
        return bundle;
    }

    public Parcelable m18578f() {
        return m18577e();
    }

    public String toString() {
        return m18576d();
    }
}
