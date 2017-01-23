package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class Statm extends ProcFile {
    public static final Creator<Statm> CREATOR;
    public final String[] f13306a;

    /* renamed from: com.jaredrummler.android.processes.models.Statm.1 */
    class C39701 implements Creator<Statm> {
        C39701() {
        }

        public Statm m16331a(Parcel parcel) {
            return new Statm(null);
        }

        public Statm[] m16332a(int i) {
            return new Statm[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16331a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16332a(i);
        }
    }

    static {
        CREATOR = new C39701();
    }

    private Statm(Parcel parcel) {
        super(parcel);
        this.f13306a = parcel.createStringArray();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.f13306a);
    }
}
