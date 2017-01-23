package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ControlGroup implements Parcelable {
    public static final Creator<ControlGroup> CREATOR;
    public final int f13302a;
    public final String f13303b;
    public final String f13304c;

    /* renamed from: com.jaredrummler.android.processes.models.ControlGroup.1 */
    class C39671 implements Creator<ControlGroup> {
        C39671() {
        }

        public ControlGroup m16323a(Parcel parcel) {
            return new ControlGroup(parcel);
        }

        public ControlGroup[] m16324a(int i) {
            return new ControlGroup[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m16323a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m16324a(i);
        }
    }

    static {
        CREATOR = new C39671();
    }

    protected ControlGroup(Parcel parcel) {
        this.f13302a = parcel.readInt();
        this.f13303b = parcel.readString();
        this.f13304c = parcel.readString();
    }

    protected ControlGroup(String str) {
        String[] split = str.split(":");
        this.f13302a = Integer.parseInt(split[0]);
        this.f13303b = split[1];
        this.f13304c = split[2];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13302a);
        parcel.writeString(this.f13303b);
        parcel.writeString(this.f13304c);
    }
}
