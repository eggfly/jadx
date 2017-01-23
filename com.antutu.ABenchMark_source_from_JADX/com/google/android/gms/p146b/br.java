package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bn.C2808a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.br */
public interface br extends IInterface {

    /* renamed from: com.google.android.gms.b.br.a */
    public static abstract class C3056a extends Binder implements br {

        /* renamed from: com.google.android.gms.b.br.a.a */
        private static class C3055a implements br {
            private IBinder f10378a;

            C3055a(IBinder iBinder) {
                this.f10378a = iBinder;
            }

            public void m11950a(bn bnVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                    obtain.writeStrongBinder(bnVar != null ? bnVar.asBinder() : null);
                    this.f10378a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10378a;
            }
        }

        public static br m11951a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof br)) ? new C3055a(iBinder) : (br) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                    m11949a(C2808a.m10852a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11949a(bn bnVar);
}
