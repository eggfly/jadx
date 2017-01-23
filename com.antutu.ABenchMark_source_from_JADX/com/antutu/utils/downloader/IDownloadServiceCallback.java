package com.antutu.utils.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IDownloadServiceCallback extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadServiceCallback {
        private static final String DESCRIPTOR = "com.antutu.utils.downloader.IDownloadServiceCallback";
        static final int TRANSACTION_onDownloadFinished = 2;
        static final int TRANSACTION_onDownloadInterruptted = 3;
        static final int TRANSACTION_onProgress = 1;

        private static class Proxy implements IDownloadServiceCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onDownloadFinished() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_onDownloadFinished, obtain, null, Stub.TRANSACTION_onProgress);
                } finally {
                    obtain.recycle();
                }
            }

            public void onDownloadInterruptted() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_onDownloadInterruptted, obtain, null, Stub.TRANSACTION_onProgress);
                } finally {
                    obtain.recycle();
                }
            }

            public void onProgress(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_onProgress, obtain, null, Stub.TRANSACTION_onProgress);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadServiceCallback)) ? new Proxy(iBinder) : (IDownloadServiceCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case TRANSACTION_onProgress /*1*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    onProgress(parcel.readInt());
                    return true;
                case TRANSACTION_onDownloadFinished /*2*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadFinished();
                    return true;
                case TRANSACTION_onDownloadInterruptted /*3*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadInterruptted();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDownloadFinished();

    void onDownloadInterruptted();

    void onProgress(int i);
}
