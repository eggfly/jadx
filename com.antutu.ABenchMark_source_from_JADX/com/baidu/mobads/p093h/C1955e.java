package com.baidu.mobads.p093h;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.h.e */
public class C1955e implements Parcelable {
    public static final Creator<C1955e> f6823a;
    private JSONObject f6824b;
    private double f6825c;
    private String f6826d;
    private String f6827e;
    private String f6828f;
    private int f6829g;
    private int f6830h;

    static {
        f6823a = new C1956f();
    }

    private C1955e(Parcel parcel) {
        this.f6827e = parcel.readString();
        this.f6830h = parcel.readInt();
        this.f6826d = parcel.readString();
        this.f6825c = parcel.readDouble();
        this.f6828f = parcel.readString();
        this.f6829g = parcel.readInt();
    }

    public C1955e(C1955e c1955e, String str, Boolean bool) {
        int i = 1;
        this.f6825c = c1955e.m7312b();
        this.f6826d = c1955e.m7313c();
        this.f6827e = c1955e.m7314d();
        this.f6830h = c1955e.m7311a().booleanValue() ? 1 : 0;
        this.f6828f = str;
        if (!bool.booleanValue()) {
            i = 0;
        }
        this.f6829g = i;
    }

    public C1955e(String str) {
        int i = 1;
        try {
            this.f6824b = new JSONObject(str);
            this.f6825c = this.f6824b.getDouble(Constants.SP_KEY_VERSION);
            this.f6826d = this.f6824b.getString("url");
            this.f6827e = this.f6824b.getString(Constants.KEY_SECURITY_SIGN);
            this.f6830h = 1;
            this.f6828f = BuildConfig.FLAVOR;
            this.f6829g = 0;
        } catch (JSONException e) {
            this.f6830h = 0;
        }
        if (m7313c() == null) {
            i = 0;
        }
        this.f6830h = i;
    }

    public Boolean m7311a() {
        boolean z = true;
        if (this.f6830h != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public double m7312b() {
        return this.f6825c;
    }

    public String m7313c() {
        return this.f6826d;
    }

    public String m7314d() {
        return this.f6827e;
    }

    public int describeContents() {
        return 0;
    }

    public String m7315e() {
        return this.f6828f;
    }

    public String toString() {
        return this.f6824b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6827e);
        parcel.writeInt(this.f6830h);
        parcel.writeString(this.f6826d);
        parcel.writeDouble(this.f6825c);
        parcel.writeString(this.f6828f);
        parcel.writeInt(this.f6829g);
    }
}
