package com.google.android.gms.internal;

import agg;
import agg$a;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public interface bj extends IInterface {

    public static abstract class a extends Binder implements bj {

        private static class a implements bj {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public String DW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List FH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String Hw() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String VH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String Zo() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public Bundle gn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public agg j6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    agg j6 = agg$a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void u7() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public bd v5() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.j6.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    bd j6 = com.google.android.gms.internal.bd.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static bj j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bj)) ? new a(iBinder) : (bj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            String DW;
            switch (i) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    agg j6 = j6();
                    parcel2.writeNoException();
                    if (j6 != null) {
                        iBinder = j6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    DW = DW();
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    List FH = FH();
                    parcel2.writeNoException();
                    parcel2.writeList(FH);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    DW = Hw();
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bd v5 = v5();
                    parcel2.writeNoException();
                    if (v5 != null) {
                        iBinder = v5.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    DW = Zo();
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    DW = VH();
                    parcel2.writeNoException();
                    parcel2.writeString(DW);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    Bundle gn = gn();
                    parcel2.writeNoException();
                    if (gn != null) {
                        parcel2.writeInt(1);
                        gn.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    u7();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String DW();

    List FH();

    String Hw();

    String VH();

    String Zo();

    Bundle gn();

    agg j6();

    void u7();

    bd v5();
}
