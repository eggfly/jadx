package com.aide.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface IAideLicensingService extends IInterface {

    public static abstract class a extends Binder implements IAideLicensingService {

        private static class a implements IAideLicensingService {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(d dVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.licensing.IAideLicensingService");
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static IAideLicensingService j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.licensing.IAideLicensingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAideLicensingService)) {
                return new a(iBinder);
            }
            return (IAideLicensingService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.licensing.IAideLicensingService");
                    j6(com.aide.licensing.d.a.j6(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.licensing.IAideLicensingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6(d dVar);
}
