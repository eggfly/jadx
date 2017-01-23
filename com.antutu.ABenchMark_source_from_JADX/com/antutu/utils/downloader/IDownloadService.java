package com.antutu.utils.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IDownloadService extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadService {
        private static final String DESCRIPTOR = "com.antutu.utils.downloader.IDownloadService";
        static final int TRANSACTION_cancelDownload = 3;
        static final int TRANSACTION_isDownloading = 2;
        static final int TRANSACTION_startDownload = 1;

        private static class Proxy implements IDownloadService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancelDownload(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_cancelDownload, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean isDownloading(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_isDownloading, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startDownload(DownloadInfos downloadInfos, IDownloadServiceCallback iDownloadServiceCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (downloadInfos != null) {
                        obtain.writeInt(Stub.TRANSACTION_startDownload);
                        downloadInfos.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iDownloadServiceCallback != null ? iDownloadServiceCallback.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_startDownload, obtain, obtain2, 0);
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

        public static IDownloadService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadService)) ? new Proxy(iBinder) : (IDownloadService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case TRANSACTION_startDownload /*1*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    startDownload(parcel.readInt() != 0 ? (DownloadInfos) DownloadInfos.CREATOR.createFromParcel(parcel) : null, com.antutu.utils.downloader.IDownloadServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_isDownloading /*2*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isDownloading = isDownloading(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(isDownloading ? TRANSACTION_startDownload : 0);
                    return true;
                case TRANSACTION_cancelDownload /*3*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelDownload(parcel.readString());
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

    void cancelDownload(String str);

    boolean isDownloading(String str);

    void startDownload(DownloadInfos downloadInfos, IDownloadServiceCallback iDownloadServiceCallback);
}
