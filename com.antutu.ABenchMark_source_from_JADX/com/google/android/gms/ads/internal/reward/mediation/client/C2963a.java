package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.a */
public interface C2963a extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.a.a */
    public static abstract class C2965a extends Binder implements C2963a {

        /* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.a.a.a */
        private static class C2964a implements C2963a {
            private IBinder f10014a;

            C2964a(IBinder iBinder) {
                this.f10014a = iBinder;
            }

            public void m11498a(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11499a(C2687a c2687a, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    obtain.writeInt(i);
                    this.f10014a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11500a(C2687a c2687a, RewardItemParcel rewardItemParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (rewardItemParcel != null) {
                        obtain.writeInt(1);
                        rewardItemParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f10014a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10014a;
            }

            public void m11501b(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11502b(C2687a c2687a, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    obtain.writeInt(i);
                    this.f10014a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11503c(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11504d(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11505e(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11506f(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11507g(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10014a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C2963a m11508a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2963a)) ? new C2964a(iBinder) : (C2963a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11488a(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11489a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11491b(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11493c(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11494d(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11495e(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11490a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt() != 0 ? RewardItemParcel.CREATOR.m11518a(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11496f(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11492b(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    m11497g(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11488a(C2687a c2687a);

    void m11489a(C2687a c2687a, int i);

    void m11490a(C2687a c2687a, RewardItemParcel rewardItemParcel);

    void m11491b(C2687a c2687a);

    void m11492b(C2687a c2687a, int i);

    void m11493c(C2687a c2687a);

    void m11494d(C2687a c2687a);

    void m11495e(C2687a c2687a);

    void m11496f(C2687a c2687a);

    void m11497g(C2687a c2687a);
}
