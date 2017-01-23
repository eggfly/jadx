package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public abstract class Task implements Parcelable {
    private final String DW;
    private final boolean FH;
    private final boolean Hw;
    private final b VH;
    private final boolean Zo;
    private final Bundle gn;
    private final String j6;
    private final int v5;

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.j6 = parcel.readString();
        this.DW = parcel.readString();
        this.FH = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.Hw = z;
        this.v5 = 2;
        this.Zo = false;
        this.VH = b.j6;
        this.gn = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.j6);
        parcel.writeString(this.DW);
        parcel.writeInt(this.FH ? 1 : 0);
        if (!this.Hw) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
