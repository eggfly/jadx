package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.n */
public interface C3468n extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.n.a */
    public static abstract class C3469a extends Binder implements C3468n {

        /* renamed from: com.google.android.gms.common.internal.n.a.a */
        private static class C3496a implements C3468n {
            private IBinder f12112a;

            C3496a(IBinder iBinder) {
                this.f12112a = iBinder;
            }

            public Account m14418a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
                    this.f12112a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    Account account = obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return account;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f12112a;
            }
        }

        public static C3468n m14328a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C3468n)) ? new C3496a(iBinder) : (C3468n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    Account a = m14327a();
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IAccountAccessor");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Account m14327a();
}
