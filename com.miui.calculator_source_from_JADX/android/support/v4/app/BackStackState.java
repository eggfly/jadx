package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR;
    final int[] f109a;
    final int f110b;
    final int f111c;
    final String f112d;
    final int f113e;
    final int f114f;
    final CharSequence f115g;
    final int f116h;
    final CharSequence f117i;
    final ArrayList<String> f118j;
    final ArrayList<String> f119k;

    /* renamed from: android.support.v4.app.BackStackState.1 */
    final class C00111 implements Creator<BackStackState> {
        C00111() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m133a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m134a(i);
        }

        public BackStackState m133a(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] m134a(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int i = 0;
        for (Op op = backStackRecord.f89c; op != null; op = op.f73a) {
            if (op.f81i != null) {
                i += op.f81i.size();
            }
        }
        this.f109a = new int[(i + (backStackRecord.f91e * 7))];
        if (backStackRecord.f98l) {
            i = 0;
            for (Op op2 = backStackRecord.f89c; op2 != null; op2 = op2.f73a) {
                int i2 = i + 1;
                this.f109a[i] = op2.f75c;
                int i3 = i2 + 1;
                this.f109a[i2] = op2.f76d != null ? op2.f76d.f153p : -1;
                int i4 = i3 + 1;
                this.f109a[i3] = op2.f77e;
                i2 = i4 + 1;
                this.f109a[i4] = op2.f78f;
                i4 = i2 + 1;
                this.f109a[i2] = op2.f79g;
                i2 = i4 + 1;
                this.f109a[i4] = op2.f80h;
                if (op2.f81i != null) {
                    int size = op2.f81i.size();
                    i4 = i2 + 1;
                    this.f109a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f109a[i4] = ((Fragment) op2.f81i.get(i2)).f153p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f109a[i2] = 0;
                }
            }
            this.f110b = backStackRecord.f96j;
            this.f111c = backStackRecord.f97k;
            this.f112d = backStackRecord.f100n;
            this.f113e = backStackRecord.f102p;
            this.f114f = backStackRecord.f103q;
            this.f115g = backStackRecord.f104r;
            this.f116h = backStackRecord.f105s;
            this.f117i = backStackRecord.f106t;
            this.f118j = backStackRecord.f107u;
            this.f119k = backStackRecord.f108v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f109a = parcel.createIntArray();
        this.f110b = parcel.readInt();
        this.f111c = parcel.readInt();
        this.f112d = parcel.readString();
        this.f113e = parcel.readInt();
        this.f114f = parcel.readInt();
        this.f115g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f116h = parcel.readInt();
        this.f117i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f118j = parcel.createStringArrayList();
        this.f119k = parcel.createStringArrayList();
    }

    public BackStackRecord m135a(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f109a.length) {
            Op op = new Op();
            int i3 = i2 + 1;
            op.f75c = this.f109a[i2];
            if (FragmentManagerImpl.f215a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.f109a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f109a[i3];
            if (i2 >= 0) {
                op.f76d = (Fragment) fragmentManagerImpl.f221f.get(i2);
            } else {
                op.f76d = null;
            }
            i3 = i4 + 1;
            op.f77e = this.f109a[i4];
            i4 = i3 + 1;
            op.f78f = this.f109a[i3];
            i3 = i4 + 1;
            op.f79g = this.f109a[i4];
            int i5 = i3 + 1;
            op.f80h = this.f109a[i3];
            i4 = i5 + 1;
            int i6 = this.f109a[i5];
            if (i6 > 0) {
                op.f81i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (FragmentManagerImpl.f215a) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.f109a[i4]);
                    }
                    i5 = i4 + 1;
                    op.f81i.add((Fragment) fragmentManagerImpl.f221f.get(this.f109a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            backStackRecord.m125a(op);
            i++;
            i2 = i4;
        }
        backStackRecord.f96j = this.f110b;
        backStackRecord.f97k = this.f111c;
        backStackRecord.f100n = this.f112d;
        backStackRecord.f102p = this.f113e;
        backStackRecord.f98l = true;
        backStackRecord.f103q = this.f114f;
        backStackRecord.f104r = this.f115g;
        backStackRecord.f105s = this.f116h;
        backStackRecord.f106t = this.f117i;
        backStackRecord.f107u = this.f118j;
        backStackRecord.f108v = this.f119k;
        backStackRecord.m124a(1);
        return backStackRecord;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f109a);
        parcel.writeInt(this.f110b);
        parcel.writeInt(this.f111c);
        parcel.writeString(this.f112d);
        parcel.writeInt(this.f113e);
        parcel.writeInt(this.f114f);
        TextUtils.writeToParcel(this.f115g, parcel, 0);
        parcel.writeInt(this.f116h);
        TextUtils.writeToParcel(this.f117i, parcel, 0);
        parcel.writeStringList(this.f118j);
        parcel.writeStringList(this.f119k);
    }

    static {
        CREATOR = new C00111();
    }
}
