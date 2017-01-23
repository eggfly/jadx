package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR;
    final String f244a;
    final int f245b;
    final boolean f246c;
    final int f247d;
    final int f248e;
    final String f249f;
    final boolean f250g;
    final boolean f251h;
    final Bundle f252i;
    Bundle f253j;
    Fragment f254k;

    /* renamed from: android.support.v4.app.FragmentState.1 */
    final class C00211 implements Creator<FragmentState> {
        C00211() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m379a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m380a(i);
        }

        public FragmentState m379a(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] m380a(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f244a = fragment.getClass().getName();
        this.f245b = fragment.f153p;
        this.f246c = fragment.f162y;
        this.f247d = fragment.f128G;
        this.f248e = fragment.f129H;
        this.f249f = fragment.f130I;
        this.f250g = fragment.f133L;
        this.f251h = fragment.f132K;
        this.f252i = fragment.f155r;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f244a = parcel.readString();
        this.f245b = parcel.readInt();
        this.f246c = parcel.readInt() != 0;
        this.f247d = parcel.readInt();
        this.f248e = parcel.readInt();
        this.f249f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f250g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f251h = z2;
        this.f252i = parcel.readBundle();
        this.f253j = parcel.readBundle();
    }

    public Fragment m381a(FragmentHostCallback fragmentHostCallback, Fragment fragment) {
        if (this.f254k != null) {
            return this.f254k;
        }
        Context g = fragmentHostCallback.m242g();
        if (this.f252i != null) {
            this.f252i.setClassLoader(g.getClassLoader());
        }
        this.f254k = Fragment.m138a(g, this.f244a, this.f252i);
        if (this.f253j != null) {
            this.f253j.setClassLoader(g.getClassLoader());
            this.f254k.f151n = this.f253j;
        }
        this.f254k.m153a(this.f245b, fragment);
        this.f254k.f162y = this.f246c;
        this.f254k.f122A = true;
        this.f254k.f128G = this.f247d;
        this.f254k.f129H = this.f248e;
        this.f254k.f130I = this.f249f;
        this.f254k.f133L = this.f250g;
        this.f254k.f132K = this.f251h;
        this.f254k.f124C = fragmentHostCallback.f179d;
        if (FragmentManagerImpl.f215a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f254k);
        }
        return this.f254k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f244a);
        parcel.writeInt(this.f245b);
        parcel.writeInt(this.f246c ? 1 : 0);
        parcel.writeInt(this.f247d);
        parcel.writeInt(this.f248e);
        parcel.writeString(this.f249f);
        if (this.f250g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f251h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f252i);
        parcel.writeBundle(this.f253j);
    }

    static {
        CREATOR = new C00211();
    }
}
