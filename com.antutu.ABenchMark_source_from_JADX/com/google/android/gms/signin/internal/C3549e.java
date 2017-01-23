package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.C3468n;
import com.google.android.gms.common.internal.C3468n.C3469a;
import com.google.android.gms.common.internal.C3502r;
import com.google.android.gms.common.internal.C3502r.C3504a;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.C3413d.C3414a;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.signin.internal.e */
public interface C3549e extends IInterface {

    /* renamed from: com.google.android.gms.signin.internal.e.a */
    public static abstract class C3551a extends Binder implements C3549e {

        /* renamed from: com.google.android.gms.signin.internal.e.a.a */
        private static class C3550a implements C3549e {
            private IBinder f12262a;

            C3550a(IBinder iBinder) {
                this.f12262a = iBinder;
            }

            public void m14784a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.f12262a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14785a(int i, Account account, C3413d c3413d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c3413d != null ? c3413d.asBinder() : null);
                    this.f12262a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14786a(AuthAccountRequest authAccountRequest, C3413d c3413d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c3413d != null ? c3413d.asBinder() : null);
                    this.f12262a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14787a(ResolveAccountRequest resolveAccountRequest, C3502r c3502r) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c3502r != null ? c3502r.asBinder() : null);
                    this.f12262a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14788a(C3468n c3468n, int i, boolean z) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(c3468n != null ? c3468n.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f12262a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14789a(CheckServerAuthResult checkServerAuthResult) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12262a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14790a(RecordConsentRequest recordConsentRequest, C3413d c3413d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        obtain.writeInt(1);
                        recordConsentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c3413d != null ? c3413d.asBinder() : null);
                    this.f12262a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14791a(SignInRequest signInRequest, C3413d c3413d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest != null) {
                        obtain.writeInt(1);
                        signInRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c3413d != null ? c3413d.asBinder() : null);
                    this.f12262a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14792a(C3413d c3413d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(c3413d != null ? c3413d.asBinder() : null);
                    this.f12262a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14793a(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f12262a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f12262a;
            }
        }

        public static C3549e m14794a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C3549e)) ? new C3550a(iBinder) : (C3549e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            SignInRequest signInRequest = null;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    AuthAccountRequest authAccountRequest;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        authAccountRequest = (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    m14776a(authAccountRequest, C3414a.m14061a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    CheckServerAuthResult checkServerAuthResult;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        checkServerAuthResult = (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                    }
                    m14779a(checkServerAuthResult);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    m14783a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    ResolveAccountRequest resolveAccountRequest;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        resolveAccountRequest = (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    m14777a(resolveAccountRequest, C3504a.m14515a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    m14774a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    Account account;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(parcel);
                    }
                    m14775a(readInt, account, C3414a.m14061a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    C3468n a = C3469a.m14328a(parcel.readStrongBinder());
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m14778a(a, readInt2, z);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    RecordConsentRequest recordConsentRequest;
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        recordConsentRequest = (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel);
                    }
                    m14780a(recordConsentRequest, C3414a.m14061a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    m14782a(C3414a.m14061a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    if (parcel.readInt() != 0) {
                        signInRequest = (SignInRequest) SignInRequest.CREATOR.createFromParcel(parcel);
                    }
                    m14781a(signInRequest, C3414a.m14061a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m14774a(int i);

    void m14775a(int i, Account account, C3413d c3413d);

    void m14776a(AuthAccountRequest authAccountRequest, C3413d c3413d);

    void m14777a(ResolveAccountRequest resolveAccountRequest, C3502r c3502r);

    void m14778a(C3468n c3468n, int i, boolean z);

    void m14779a(CheckServerAuthResult checkServerAuthResult);

    void m14780a(RecordConsentRequest recordConsentRequest, C3413d c3413d);

    void m14781a(SignInRequest signInRequest, C3413d c3413d);

    void m14782a(C3413d c3413d);

    void m14783a(boolean z);
}
