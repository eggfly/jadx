package com.aide.ui.scm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GitStatus implements Parcelable {
    public static final Creator<GitStatus> CREATOR;
    public final List<ModifiedFile> DW;
    public final String j6;

    static class 1 implements Creator<GitStatus> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public GitStatus j6(Parcel parcel) {
            return new GitStatus(parcel);
        }

        public GitStatus[] j6(int i) {
            return new GitStatus[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public GitStatus(Parcel parcel) {
        List arrayList = new ArrayList(parcel.readInt());
        parcel.readTypedList(arrayList, ModifiedFile.CREATOR);
        this.DW = Collections.unmodifiableList(arrayList);
        this.j6 = parcel.readString();
    }

    public GitStatus(String str, Collection<ModifiedFile> collection) {
        this.j6 = str;
        this.DW = Collections.unmodifiableList(new ArrayList(collection));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.DW.size());
        parcel.writeTypedList(this.DW);
        parcel.writeString(this.j6);
    }

    public boolean j6() {
        return this.DW.isEmpty();
    }
}
