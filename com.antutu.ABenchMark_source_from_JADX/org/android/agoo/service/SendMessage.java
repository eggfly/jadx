package org.android.agoo.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface SendMessage extends IInterface {

    public static abstract class Stub extends Binder implements SendMessage {
        private static final String DESCRIPTOR = "org.android.agoo.service.SendMessage";
        static final int TRANSACTION_doSend = 1;

        private static class Proxy implements SendMessage {
            private IBinder f16437a;

            Proxy(IBinder iBinder) {
                this.f16437a = iBinder;
            }

            public IBinder asBinder() {
                return this.f16437a;
            }

            public int doSend(Intent intent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(Stub.TRANSACTION_doSend);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f16437a.transact(Stub.TRANSACTION_doSend, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SendMessage asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof SendMessage)) ? new Proxy(iBinder) : (SendMessage) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case TRANSACTION_doSend /*1*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    int doSend = doSend(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(doSend);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int doSend(Intent intent);
}
