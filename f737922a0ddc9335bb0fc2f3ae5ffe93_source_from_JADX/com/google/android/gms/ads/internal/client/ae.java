package com.google.android.gms.ads.internal.client;

import agg;
import agg$a;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.reward.client.d;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dy;

public interface ae extends IInterface {

    public static abstract class a extends Binder implements ae {

        private static class a implements ae {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public void DW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(23, obtain, obtain2, 0);
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

            public boolean FH() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(3, obtain, obtain2, 0);
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

            public void Hw() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void VH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void Zo() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void gn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public agg j6() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    agg j6 = agg$a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(AdSizeParcel adSizeParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(VideoOptionsParcel videoOptionsParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (videoOptionsParcel != null) {
                        obtain.writeInt(1);
                        videoOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(aa aaVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
                    this.j6.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(ag agVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(agVar != null ? agVar.asBinder() : null);
                    this.j6.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(ai aiVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(aiVar != null ? aiVar.asBinder() : null);
                    this.j6.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(z zVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zVar != null ? zVar.asBinder() : null);
                    this.j6.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(bb bbVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(bbVar != null ? bbVar.asBinder() : null);
                    this.j6.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(du duVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(duVar != null ? duVar.asBinder() : null);
                    this.j6.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(dy dyVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(dyVar != null ? dyVar.asBinder() : null);
                    obtain.writeString(str);
                    this.j6.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeString(str);
                    this.j6.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.j6.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean j6(AdRequestParcel adRequestParcel) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(4, obtain, obtain2, 0);
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

            public String tp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AdSizeParcel u7() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    AdSizeParcel adSizeParcel = obtain2.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return adSizeParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void v5() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public c we() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.j6.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    c j6 = com.google.android.gms.ads.internal.client.c.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static ae j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ae)) ? new a(iBinder) : (ae) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            VideoOptionsParcel videoOptionsParcel = null;
            int i3 = 0;
            IBinder asBinder;
            boolean FH;
            AdSizeParcel u7;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    agg j6 = j6();
                    parcel2.writeNoException();
                    if (j6 != null) {
                        asBinder = j6.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    DW();
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    FH = FH();
                    parcel2.writeNoException();
                    parcel2.writeInt(FH ? 1 : 0);
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    AdRequestParcel adRequestParcel;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        adRequestParcel = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcel);
                    }
                    FH = j6(adRequestParcel);
                    parcel2.writeNoException();
                    if (FH) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    Hw();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    v5();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.ads.internal.client.aa.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.ads.internal.client.ag.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    Zo();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    VH();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    gn();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    u7 = u7();
                    parcel2.writeNoException();
                    if (u7 != null) {
                        parcel2.writeInt(1);
                        u7.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        u7 = (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel);
                    }
                    j6(u7);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.internal.du.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.internal.dy.a.j6(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    String tp = tp();
                    parcel2.writeNoException();
                    parcel2.writeString(tp);
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.internal.bb.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.ads.internal.client.z.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.ads.internal.client.ai.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean z;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    j6(z);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    FH = EQ();
                    parcel2.writeNoException();
                    if (FH) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(com.google.android.gms.ads.internal.reward.client.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    j6(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    c we = we();
                    parcel2.writeNoException();
                    if (we != null) {
                        asBinder = we.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    if (parcel.readInt() != 0) {
                        videoOptionsParcel = (VideoOptionsParcel) VideoOptionsParcel.CREATOR.createFromParcel(parcel);
                    }
                    j6(videoOptionsParcel);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void DW();

    boolean EQ();

    boolean FH();

    void Hw();

    void VH();

    void Zo();

    void gn();

    agg j6();

    void j6(AdSizeParcel adSizeParcel);

    void j6(VideoOptionsParcel videoOptionsParcel);

    void j6(aa aaVar);

    void j6(ag agVar);

    void j6(ai aiVar);

    void j6(z zVar);

    void j6(d dVar);

    void j6(bb bbVar);

    void j6(du duVar);

    void j6(dy dyVar, String str);

    void j6(String str);

    void j6(boolean z);

    boolean j6(AdRequestParcel adRequestParcel);

    String tp();

    AdSizeParcel u7();

    void v5();

    c we();
}
