package com.google.android.gms.ads.internal.client;

import agg;
import agg$a;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.reward.client.b;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.dv;

public interface ah extends IInterface {

    public static abstract class a extends Binder implements ah {

        private static class a implements ah {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public ae DW(agg agg, AdSizeParcel adSizeParcel, String str, cr crVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (crVar != null) {
                        iBinder = crVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    ae j6 = com.google.android.gms.ads.internal.client.ae.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public dv DW(agg agg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    this.j6.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    dv j6 = com.google.android.gms.internal.dv.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public dp FH(agg agg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    this.j6.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    dp j6 = com.google.android.gms.internal.dp.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public ac j6(agg agg, String str, cr crVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    obtain.writeString(str);
                    if (crVar != null) {
                        iBinder = crVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    ac j6 = com.google.android.gms.ads.internal.client.ac.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ae j6(agg agg, AdSizeParcel adSizeParcel, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    ae j6 = com.google.android.gms.ads.internal.client.ae.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ae j6(agg agg, AdSizeParcel adSizeParcel, String str, cr crVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (crVar != null) {
                        iBinder = crVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ae j6 = com.google.android.gms.ads.internal.client.ae.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public aj j6(agg agg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    aj j6 = com.google.android.gms.ads.internal.client.aj.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public aj j6(agg agg, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    obtain.writeInt(i);
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    aj j6 = com.google.android.gms.ads.internal.client.aj.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public b j6(agg agg, cr crVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    if (crVar != null) {
                        iBinder = crVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.j6.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    b j6 = com.google.android.gms.ads.internal.reward.client.b.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public bf j6(agg agg, agg agg2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(agg != null ? agg.asBinder() : null);
                    if (agg2 != null) {
                        iBinder = agg2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    bf j6 = com.google.android.gms.internal.bf.a.j6(obtain2.readStrongBinder());
                    return j6;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ah j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ah)) ? new a(iBinder) : (ah) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            ae j6;
            aj j62;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    j6 = j6(agg$a.j6(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), com.google.android.gms.internal.cr.a.j6(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (j6 != null) {
                        iBinder = j6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    j6 = DW(agg$a.j6(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), com.google.android.gms.internal.cr.a.j6(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (j6 != null) {
                        iBinder = j6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    ac j63 = j6(agg$a.j6(parcel.readStrongBinder()), parcel.readString(), com.google.android.gms.internal.cr.a.j6(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (j63 != null) {
                        iBinder = j63.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    j62 = j6(agg$a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (j62 != null) {
                        iBinder = j62.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    bf j64 = j6(agg$a.j6(parcel.readStrongBinder()), agg$a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (j64 != null) {
                        iBinder = j64.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    b j65 = j6(agg$a.j6(parcel.readStrongBinder()), com.google.android.gms.internal.cr.a.j6(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (j65 != null) {
                        iBinder = j65.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    dv DW = DW(agg$a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (DW != null) {
                        iBinder = DW.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    dp FH = FH(agg$a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (FH != null) {
                        iBinder = FH.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    j62 = j6(agg$a.j6(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (j62 != null) {
                        iBinder = j62.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    j6 = j6(agg$a.j6(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (j6 != null) {
                        iBinder = j6.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    ae DW(agg agg, AdSizeParcel adSizeParcel, String str, cr crVar, int i);

    dv DW(agg agg);

    dp FH(agg agg);

    ac j6(agg agg, String str, cr crVar, int i);

    ae j6(agg agg, AdSizeParcel adSizeParcel, String str, int i);

    ae j6(agg agg, AdSizeParcel adSizeParcel, String str, cr crVar, int i);

    aj j6(agg agg);

    aj j6(agg agg, int i);

    b j6(agg agg, cr crVar, int i);

    bf j6(agg agg, agg agg2);
}
