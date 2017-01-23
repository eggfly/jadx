package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.jg;
import com.google.android.gms.p146b.ji;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR;
    public static jg f10128a;
    private static Comparator<Scope> f10129l;
    final int f10130b;
    List<Scope> f10131c;
    private String f10132d;
    private String f10133e;
    private String f10134f;
    private String f10135g;
    private Uri f10136h;
    private String f10137i;
    private long f10138j;
    private String f10139k;

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInAccount.1 */
    static class C29971 implements Comparator<Scope> {
        C29971() {
        }

        public int m11650a(Scope scope, Scope scope2) {
            return scope.m13956a().compareTo(scope2.m13956a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m11650a((Scope) obj, (Scope) obj2);
        }
    }

    static {
        CREATOR = new C3005b();
        f10128a = ji.m13553d();
        f10129l = new C29971();
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list) {
        this.f10130b = i;
        this.f10132d = str;
        this.f10133e = str2;
        this.f10134f = str3;
        this.f10135g = str4;
        this.f10136h = uri;
        this.f10137i = str5;
        this.f10138j = j;
        this.f10139k = str6;
        this.f10131c = list;
    }

    public static GoogleSignInAccount m11651a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return m11652a(jSONObject.optString(AgooConstants.MESSAGE_ID), jSONObject.optString("tokenId", null), jSONObject.optString(NotificationCompatApi21.CATEGORY_EMAIL, null), jSONObject.optString("displayName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).m11655b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount m11652a(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f10128a.m13543a() / 1000);
        }
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, null, l.longValue(), C3512u.m14582a(str5), new ArrayList((Collection) C3512u.m14580a((Object) set)));
    }

    private JSONObject m11653j() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m11654a() != null) {
                jSONObject.put(AgooConstants.MESSAGE_ID, m11654a());
            }
            if (m11656b() != null) {
                jSONObject.put("tokenId", m11656b());
            }
            if (m11657c() != null) {
                jSONObject.put(NotificationCompatApi21.CATEGORY_EMAIL, m11657c());
            }
            if (m11658d() != null) {
                jSONObject.put("displayName", m11658d());
            }
            if (m11659e() != null) {
                jSONObject.put("photoUrl", m11659e().toString());
            }
            if (m11660f() != null) {
                jSONObject.put("serverAuthCode", m11660f());
            }
            jSONObject.put("expirationTime", this.f10138j);
            jSONObject.put("obfuscatedIdentifier", m11662h());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f10131c, f10129l);
            for (Scope a : this.f10131c) {
                jSONArray.put(a.m13956a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String m11654a() {
        return this.f10132d;
    }

    public GoogleSignInAccount m11655b(String str) {
        this.f10137i = str;
        return this;
    }

    public String m11656b() {
        return this.f10133e;
    }

    public String m11657c() {
        return this.f10134f;
    }

    public String m11658d() {
        return this.f10135g;
    }

    public int describeContents() {
        return 0;
    }

    public Uri m11659e() {
        return this.f10136h;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m11663i().equals(m11663i());
    }

    public String m11660f() {
        return this.f10137i;
    }

    public long m11661g() {
        return this.f10138j;
    }

    public String m11662h() {
        return this.f10139k;
    }

    public String m11663i() {
        return m11653j().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3005b.m11686a(this, parcel, i);
    }
}
