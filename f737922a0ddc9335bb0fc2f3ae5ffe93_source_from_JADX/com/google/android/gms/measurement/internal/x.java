package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public interface x extends IInterface {

    public static abstract class a extends Binder implements x {

        private static class a implements x {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public void DW(AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public List<UserAttributeParcel> j6(AppMetadata appMetadata, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.j6.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    List<UserAttributeParcel> createTypedArrayList = obtain2.createTypedArrayList(UserAttributeParcel.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(EventParcel eventParcel, AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(EventParcel eventParcel, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.j6.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (userAttributeParcel != null) {
                        obtain.writeInt(1);
                        userAttributeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] j6(EventParcel eventParcel, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }

        public static x j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof x)) ? new a(iBinder) : (x) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    j6(parcel.readInt() != 0 ? (EventParcel) EventParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    j6(parcel.readInt() != 0 ? (UserAttributeParcel) UserAttributeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    j6(parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    j6(parcel.readInt() != 0 ? (EventParcel) EventParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    DW(parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    List j6 = j6(parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(j6);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    byte[] j62 = j6(parcel.readInt() != 0 ? (EventParcel) EventParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(j62);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void DW(AppMetadata appMetadata);

    List<UserAttributeParcel> j6(AppMetadata appMetadata, boolean z);

    void j6(AppMetadata appMetadata);

    void j6(EventParcel eventParcel, AppMetadata appMetadata);

    void j6(EventParcel eventParcel, String str, String str2);

    void j6(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata);

    byte[] j6(EventParcel eventParcel, String str);
}
