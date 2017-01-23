package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.p146b.iy.C3309a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.iz */
public interface iz extends IInterface {

    /* renamed from: com.google.android.gms.b.iz.a */
    public static abstract class C3316a extends Binder implements iz {

        /* renamed from: com.google.android.gms.b.iz.a.a */
        private static class C3315a implements iz {
            private IBinder f11542a;

            C3315a(IBinder iBinder) {
                this.f11542a = iBinder;
            }

            public void m13500a(iy iyVar, LogEventParcelable logEventParcelable) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    if (iyVar != null) {
                        iBinder = iyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (logEventParcelable != null) {
                        obtain.writeInt(1);
                        logEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11542a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11542a;
            }
        }

        public static iz m13501a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof iz)) ? new C3315a(iBinder) : (iz) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    m13499a(C3309a.m13471a(parcel.readStrongBinder()), parcel.readInt() != 0 ? LogEventParcelable.CREATOR.m13947a(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m13499a(iy iyVar, LogEventParcelable logEventParcelable);
}
