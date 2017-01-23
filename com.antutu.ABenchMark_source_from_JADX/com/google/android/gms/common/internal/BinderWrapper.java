package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR;
    private IBinder f12023a;

    /* renamed from: com.google.android.gms.common.internal.BinderWrapper.1 */
    static class C34671 implements Creator<BinderWrapper> {
        C34671() {
        }

        public BinderWrapper m14308a(Parcel parcel) {
            return new BinderWrapper(null);
        }

        public BinderWrapper[] m14309a(int i) {
            return new BinderWrapper[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m14308a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m14309a(i);
        }
    }

    static {
        CREATOR = new C34671();
    }

    public BinderWrapper() {
        this.f12023a = null;
    }

    private BinderWrapper(Parcel parcel) {
        this.f12023a = null;
        this.f12023a = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f12023a);
    }
}
