package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

public interface IAnalyticsService extends IInterface {

    public static abstract class Stub extends Binder implements IAnalyticsService {
        private static final String DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
        static final int TRANSACTION_clearHits = 2;
        static final int TRANSACTION_sendHit = 1;

        private static class Proxy implements IAnalyticsService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void clearHits() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_clearHits, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void sendHit(Map map, long j, String str, List<Command> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(Stub.TRANSACTION_sendHit, obtain, obtain2, 0);
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

        public static IAnalyticsService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAnalyticsService)) ? new Proxy(iBinder) : (IAnalyticsService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case TRANSACTION_sendHit /*1*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendHit(parcel.readHashMap(getClass().getClassLoader()), parcel.readLong(), parcel.readString(), parcel.createTypedArrayList(Command.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_clearHits /*2*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearHits();
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

    void clearHits();

    void sendHit(Map map, long j, String str, List<Command> list);
}
