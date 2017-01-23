package com.aide.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class UndoManager {
    private Stack<Change> DW;
    private List<a> FH;
    private Stack<Change> j6;

    public interface a {
        void j6(String str, String str2, int i);

        void u7();
    }

    private static class Change implements Parcelable {
        public static final Creator<Change> CREATOR;
        public String DW;
        public int FH;
        public String j6;

        static class 1 implements Creator<Change> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public Change j6(Parcel parcel) {
                return new Change(parcel);
            }

            public Change[] j6(int i) {
                return new Change[i];
            }
        }

        static {
            CREATOR = new 1();
        }

        public Change(String str, String str2, int i) {
            this.j6 = str;
            this.DW = str2;
            this.FH = i;
        }

        public Change(Parcel parcel) {
            this(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.j6);
            parcel.writeString(this.DW);
            parcel.writeInt(this.FH);
        }
    }

    public UndoManager() {
        this.j6 = new Stack();
        this.DW = new Stack();
        this.FH = new ArrayList();
    }

    public void j6(a aVar) {
        this.FH.add(aVar);
    }

    public void DW(a aVar) {
        this.FH.remove(aVar);
    }

    public void j6(String str, String str2, int i) {
        if (str != null && !str2.equals(j6(str))) {
            this.DW.clear();
            this.j6.push(new Change(str, str2, i));
            v5();
        }
    }

    public void DW(String str, String str2, int i) {
        if (str != null) {
            this.DW.clear();
            this.j6.push(new Change(str, str2, i));
            v5();
        }
    }

    public void j6(Bundle bundle) {
        this.j6.clear();
        Collection parcelableArrayList = bundle.getParcelableArrayList("undo");
        if (parcelableArrayList != null) {
            this.j6.addAll(parcelableArrayList);
        }
        this.DW.clear();
        parcelableArrayList = bundle.getParcelableArrayList("redo");
        if (parcelableArrayList != null) {
            this.DW.addAll(parcelableArrayList);
        }
    }

    public void DW(Bundle bundle) {
        bundle.putParcelableArrayList("undo", new ArrayList(this.j6));
        bundle.putParcelableArrayList("redo", new ArrayList(this.DW));
    }

    public boolean j6() {
        Set hashSet = new HashSet();
        for (int size = this.j6.size() - 1; size >= 0; size--) {
            String str = ((Change) this.j6.get(size)).j6;
            if (hashSet.contains(str)) {
                return true;
            }
            hashSet.add(str);
        }
        return false;
    }

    public boolean DW() {
        return this.DW.size() > 0;
    }

    public void FH() {
        Change change = (Change) this.DW.pop();
        this.j6.push(change);
        j6(change);
    }

    public void Hw() {
        Change change = (Change) this.j6.pop();
        this.DW.push(change);
        j6(change);
    }

    private String j6(String str) {
        for (int size = this.j6.size() - 1; size >= 0; size--) {
            if (((Change) this.j6.get(size)).j6.equals(str)) {
                return ((Change) this.j6.get(size)).DW;
            }
        }
        return "";
    }

    private void v5() {
        for (a u7 : this.FH) {
            u7.u7();
        }
    }

    private void j6(Change change) {
        for (a aVar : this.FH) {
            aVar.u7();
            aVar.j6(change.j6, j6(change.j6), change.FH);
        }
    }
}
