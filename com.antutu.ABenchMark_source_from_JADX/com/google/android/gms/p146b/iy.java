package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.iy */
public interface iy extends IInterface {

    /* renamed from: com.google.android.gms.b.iy.a */
    public static abstract class C3309a extends Binder implements iy {

        /* renamed from: com.google.android.gms.b.iy.a.a */
        private static class C3314a implements iy {
            private IBinder f11541a;

            C3314a(IBinder iBinder) {
                this.f11541a = iBinder;
            }

            public void m13498a(Status status) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11541a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11541a;
            }
        }

        public C3309a() {
            attachInterface(this, "com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
        }

        public static iy m13471a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof iy)) ? new C3314a(iBinder) : (iy) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
                    m13470a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m13470a(Status status);
}
