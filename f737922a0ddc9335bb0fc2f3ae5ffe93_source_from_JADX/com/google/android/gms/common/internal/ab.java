package com.google.android.gms.common.internal;

import agg;
import agg$a;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public interface ab extends IInterface {

    public static abstract class a extends Binder implements ab {

        private static class a implements ab {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public agg j6(agg agg, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    agg j6 = agg$a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public agg j6(agg agg, SignInButtonConfig signInButtonConfig) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    if (signInButtonConfig != null) {
                        obtain.writeInt(1);
                        signInButtonConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    agg j6 = agg$a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ab j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ab)) ? new a(iBinder) : (ab) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            agg j6;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    j6 = j6(agg$a.j6(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(j6 != null ? j6.asBinder() : null);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    j6 = j6(agg$a.j6(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInButtonConfig) SignInButtonConfig.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (j6 != null) {
                        iBinder = j6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    agg j6(agg agg, int i, int i2);

    agg j6(agg agg, SignInButtonConfig signInButtonConfig);
}
