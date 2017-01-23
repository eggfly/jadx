package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface ILicensingService extends IInterface {

    public static abstract class a extends Binder implements ILicensingService {

        private static class a implements ILicensingService {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(long j, String str, a aVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static ILicensingService j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ILicensingService)) {
                return new a(iBinder);
            }
            return (ILicensingService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.android.vending.licensing.ILicensingService");
                    j6(parcel.readLong(), parcel.readString(), com.android.vending.licensing.a.a.j6(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.android.vending.licensing.ILicensingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void j6(long j, String str, a aVar);
}
