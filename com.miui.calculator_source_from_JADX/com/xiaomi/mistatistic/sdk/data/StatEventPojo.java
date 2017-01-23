package com.xiaomi.mistatistic.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StatEventPojo implements Parcelable {
    public static final Creator<StatEventPojo> CREATOR;
    public String f4821a;
    public long f4822b;
    public String f4823c;
    public String f4824d;
    public String f4825e;
    public String f4826f;

    /* renamed from: com.xiaomi.mistatistic.sdk.data.StatEventPojo.1 */
    final class C05991 implements Creator<StatEventPojo> {
        C05991() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6551a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6552a(i);
        }

        public StatEventPojo m6551a(Parcel parcel) {
            StatEventPojo statEventPojo = new StatEventPojo();
            statEventPojo.f4821a = parcel.readString();
            statEventPojo.f4822b = parcel.readLong();
            statEventPojo.f4823c = parcel.readString();
            statEventPojo.f4824d = parcel.readString();
            statEventPojo.f4825e = parcel.readString();
            statEventPojo.f4826f = parcel.readString();
            return statEventPojo;
        }

        public StatEventPojo[] m6552a(int i) {
            return new StatEventPojo[i];
        }
    }

    public String toString() {
        return "Event [" + "category=" + this.f4821a + "," + "key=" + this.f4823c + "," + "value=" + this.f4825e + ",params=" + this.f4826f + "]";
    }

    static {
        CREATOR = new C05991();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4821a);
        parcel.writeLong(this.f4822b);
        parcel.writeString(this.f4823c);
        parcel.writeString(this.f4824d);
        parcel.writeString(this.f4825e);
        parcel.writeString(this.f4826f);
    }
}
