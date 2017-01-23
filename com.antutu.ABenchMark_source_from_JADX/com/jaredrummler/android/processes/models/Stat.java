package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;

public final class Stat extends ProcFile {
    public static final Creator<Stat> CREATOR;
    private final String[] f13305a;

    /* renamed from: com.jaredrummler.android.processes.models.Stat.1 */
    class C39691 implements Creator<Stat> {
        C39691() {
        }

        public Stat m16327a(Parcel parcel) {
            return new Stat(null);
        }

        public Stat[] m16328a(int i) {
            return new Stat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16327a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16328a(i);
        }
    }

    static {
        CREATOR = new C39691();
    }

    private Stat(Parcel parcel) {
        super(parcel);
        this.f13305a = parcel.createStringArray();
    }

    private Stat(String str) {
        super(str);
        this.f13305a = this.b.split("\\s+");
    }

    public static Stat m16329a(int i) {
        return new Stat(String.format("/proc/%d/stat", new Object[]{Integer.valueOf(i)}));
    }

    public String m16330a() {
        return this.f13305a[1].replace(C4233j.f14396s, BuildConfig.FLAVOR).replace(C4233j.f14397t, BuildConfig.FLAVOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.f13305a);
    }
}
