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

public interface cv extends IInterface {

    public static abstract class a extends Binder implements cv {

        private static class a implements cv {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public List DW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void DW(agg agg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    this.j6.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean EQ() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(14, obtain, obtain2, 0);
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

            public String FH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public bd Hw() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    bd j6 = com.google.android.gms.internal.bd.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String VH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public double Zo() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    double readDouble = obtain2.readDouble();
                    return readDouble;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public String gn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(agg agg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    this.j6.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean tp() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(13, obtain, obtain2, 0);
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

            public void u7() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String v5() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle we() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    this.j6.transact(15, obtain, obtain2, 0);
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
        }

        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        }

        public static cv j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cv)) ? new a(iBinder) : (cv) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            String j6;
            boolean tp;
            switch (i) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    j6 = j6();
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    List DW = DW();
                    parcel2.writeNoException();
                    parcel2.writeList(DW);
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    j6 = FH();
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    bd Hw = Hw();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(Hw != null ? Hw.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    j6 = v5();
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    double Zo = Zo();
                    parcel2.writeNoException();
                    parcel2.writeDouble(Zo);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    j6 = VH();
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    j6 = gn();
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    u7();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    j6(agg$a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    DW(agg$a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    tp = tp();
                    parcel2.writeNoException();
                    if (tp) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    tp = EQ();
                    parcel2.writeNoException();
                    if (tp) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    Bundle we = we();
                    parcel2.writeNoException();
                    if (we != null) {
                        parcel2.writeInt(1);
                        we.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    List DW();

    void DW(agg agg);

    boolean EQ();

    String FH();

    bd Hw();

    String VH();

    double Zo();

    String gn();

    String j6();

    void j6(agg agg);

    boolean tp();

    void u7();

    String v5();

    Bundle we();
}
