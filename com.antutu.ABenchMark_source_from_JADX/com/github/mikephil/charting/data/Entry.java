package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Entry implements Parcelable {
    public static final Creator<Entry> CREATOR;
    private float f8915a;
    private int f8916b;
    private Object f8917c;

    /* renamed from: com.github.mikephil.charting.data.Entry.1 */
    static class C25591 implements Creator<Entry> {
        C25591() {
        }

        public Entry m9748a(Parcel parcel) {
            return new Entry(parcel);
        }

        public Entry[] m9749a(int i) {
            return new Entry[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m9748a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m9749a(i);
        }
    }

    static {
        CREATOR = new C25591();
    }

    public Entry(float f, int i) {
        this.f8915a = 0.0f;
        this.f8916b = 0;
        this.f8917c = null;
        this.f8915a = f;
        this.f8916b = i;
    }

    protected Entry(Parcel parcel) {
        this.f8915a = 0.0f;
        this.f8916b = 0;
        this.f8917c = null;
        this.f8915a = parcel.readFloat();
        this.f8916b = parcel.readInt();
        if (parcel.readInt() == 1) {
            this.f8917c = parcel.readParcelable(Object.class.getClassLoader());
        }
    }

    public float m9742b() {
        return this.f8915a;
    }

    public int m9743d() {
        return this.f8916b;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Entry, xIndex: " + this.f8916b + " val (sum): " + m9742b();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f8915a);
        parcel.writeInt(this.f8916b);
        if (this.f8917c == null) {
            parcel.writeInt(0);
        } else if (this.f8917c instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) this.f8917c, i);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }
}
