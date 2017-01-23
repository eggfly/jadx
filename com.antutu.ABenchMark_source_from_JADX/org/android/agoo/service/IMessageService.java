package org.android.agoo.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IMessageService extends IInterface {

    public static abstract class Stub extends Binder implements IMessageService {
        private static final String DESCRIPTOR = "org.android.agoo.service.IMessageService";
        static final int TRANSACTION_ping = 1;
        static final int TRANSACTION_probe = 2;

        private static class Proxy implements IMessageService {
            private IBinder f16436a;

            Proxy(IBinder iBinder) {
                this.f16436a = iBinder;
            }

            public IBinder asBinder() {
                return this.f16436a;
            }

            public boolean ping() {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f16436a.transact(Stub.TRANSACTION_ping, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void probe() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f16436a.transact(Stub.TRANSACTION_probe, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMessageService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMessageService)) ? new Proxy(iBinder) : (IMessageService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case TRANSACTION_ping /*1*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean ping = ping();
                    parcel2.writeNoException();
                    parcel2.writeInt(ping ? TRANSACTION_ping : 0);
                    return true;
                case TRANSACTION_probe /*2*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    probe();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean ping();

    void probe();
}
