package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.C2772z.C2773a;
import com.google.android.gms.ads.internal.client.aa.C2739a;
import com.google.android.gms.ads.internal.client.ag.C2750a;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.p146b.bo;
import com.google.android.gms.p146b.bo.C3050a;
import com.google.android.gms.p146b.bp;
import com.google.android.gms.p146b.bp.C3052a;
import com.google.android.gms.p146b.bq;
import com.google.android.gms.p146b.bq.C3054a;
import com.google.android.gms.p146b.br;
import com.google.android.gms.p146b.br.C3056a;
import org.android.spdy.SpdyProtocol;

public interface ab extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.ab.a */
    public static abstract class C2741a extends Binder implements ab {

        /* renamed from: com.google.android.gms.ads.internal.client.ab.a.a */
        private static class C2740a implements ab {
            private IBinder f9352a;

            C2740a(IBinder iBinder) {
                this.f9352a = iBinder;
            }

            public aa m10519a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.f9352a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    aa a = C2739a.m10511a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10520a(ag agVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(agVar != null ? agVar.asBinder() : null);
                    this.f9352a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10521a(C2772z c2772z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(c2772z != null ? c2772z.asBinder() : null);
                    this.f9352a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10522a(NativeAdOptionsParcel nativeAdOptionsParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9352a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10523a(bo boVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(boVar != null ? boVar.asBinder() : null);
                    this.f9352a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10524a(bp bpVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    this.f9352a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m10525a(String str, br brVar, bq bqVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(brVar != null ? brVar.asBinder() : null);
                    if (bqVar != null) {
                        iBinder = bqVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f9352a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9352a;
            }
        }

        public C2741a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static ab m10526a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ab)) ? new C2740a(iBinder) : (ab) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            NativeAdOptionsParcel nativeAdOptionsParcel = null;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    aa a = m10512a();
                    parcel2.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    m10514a(C2773a.m10706a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    m10516a(C3050a.m11942a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    m10517a(C3052a.m11945a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    m10518a(parcel.readString(), C3056a.m11951a(parcel.readStrongBinder()), C3054a.m11948a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (parcel.readInt() != 0) {
                        nativeAdOptionsParcel = NativeAdOptionsParcel.CREATOR.m10903a(parcel);
                    }
                    m10515a(nativeAdOptionsParcel);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    m10513a(C2750a.m10561a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    aa m10512a();

    void m10513a(ag agVar);

    void m10514a(C2772z c2772z);

    void m10515a(NativeAdOptionsParcel nativeAdOptionsParcel);

    void m10516a(bo boVar);

    void m10517a(bp bpVar);

    void m10518a(String str, br brVar, bq bqVar);
}
