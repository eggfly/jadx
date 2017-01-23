package com.ijinshan.cloudconfig.deepcloudconfig;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ConfigInfo implements Parcelable, Serializable, Comparable<ConfigInfo> {
    public static final Creator<ConfigInfo> CREATOR;
    private int f13267a;
    private String f13268b;
    private int f13269c;
    private String f13270d;

    /* renamed from: com.ijinshan.cloudconfig.deepcloudconfig.ConfigInfo.1 */
    class C39561 implements Creator<ConfigInfo> {
        C39561() {
        }

        public ConfigInfo m16270a(Parcel parcel) {
            return new ConfigInfo(parcel);
        }

        public ConfigInfo[] m16271a(int i) {
            return new ConfigInfo[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16270a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16271a(i);
        }
    }

    static {
        CREATOR = new C39561();
    }

    public ConfigInfo(Parcel parcel) {
        this.f13267a = parcel.readInt();
        this.f13268b = parcel.readString();
        this.f13269c = parcel.readInt();
        this.f13270d = parcel.readString();
    }

    public int m16272a(ConfigInfo configInfo) {
        return this.f13269c - configInfo.f13269c;
    }

    public String m16273a() {
        return this.f13270d;
    }

    public void m16274a(int i) {
        this.f13267a = i;
    }

    public void m16275a(String str) {
        this.f13268b = str;
    }

    public void m16276b(int i) {
        this.f13269c = i;
    }

    public void m16277b(String str) {
        this.f13270d = str;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m16272a((ConfigInfo) obj);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ConfigInfo [func_type=" + this.f13267a + ", section=" + this.f13268b + ", priority=" + this.f13269c + ", data=" + this.f13270d + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13267a);
        parcel.writeString(this.f13268b);
        parcel.writeInt(this.f13269c);
        parcel.writeString(this.f13270d);
    }
}
