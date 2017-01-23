package com.aide.ui.scm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        private static class a implements c {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(GitConfiguration gitConfiguration, String str, String str2, String str3, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    if (gitConfiguration != null) {
                        obtain.writeInt(1);
                        gitConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(GitConfiguration gitConfiguration, String str, String str2, List<String> list, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    if (gitConfiguration != null) {
                        obtain.writeInt(1);
                        gitConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringList(list);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(GitConfiguration gitConfiguration, String str, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    if (gitConfiguration != null) {
                        obtain.writeInt(1);
                        gitConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void DW(GitConfiguration gitConfiguration, String str, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    if (gitConfiguration != null) {
                        obtain.writeInt(1);
                        gitConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public GitStatus j6(String str, d dVar) {
                GitStatus gitStatus = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        gitStatus = (GitStatus) GitStatus.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return gitStatus;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(GitConfiguration gitConfiguration, String str, List<ModifiedFile> list, String str2, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    if (gitConfiguration != null) {
                        obtain.writeInt(1);
                        gitConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(String str, List<ModifiedFile> list, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j6(String str, String str2, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String DW(String str, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<String> FH(String str, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    List<String> createStringArrayList = obtain2.createStringArrayList();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void Hw(String str, String str2, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(String str, String str2, String str3, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void FH(String str, String str2, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void DW(String str, String str2, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.j6.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.ui.scm.IExternalGitService");
                    this.j6.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.ui.scm.IExternalGitService");
        }

        public static c j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.ui.scm.IExternalGitService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            GitConfiguration gitConfiguration = null;
            GitConfiguration gitConfiguration2;
            String j6;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    if (parcel.readInt() != 0) {
                        gitConfiguration = (GitConfiguration) GitConfiguration.CREATOR.createFromParcel(parcel);
                    }
                    j6(gitConfiguration, parcel.readString(), parcel.readString(), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    if (parcel.readInt() != 0) {
                        gitConfiguration = (GitConfiguration) GitConfiguration.CREATOR.createFromParcel(parcel);
                    }
                    j6(gitConfiguration, parcel.readString(), parcel.readString(), parcel.createStringArrayList(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    if (parcel.readInt() != 0) {
                        gitConfiguration2 = (GitConfiguration) GitConfiguration.CREATOR.createFromParcel(parcel);
                    } else {
                        gitConfiguration2 = null;
                    }
                    j6(gitConfiguration2, parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    if (parcel.readInt() != 0) {
                        gitConfiguration2 = (GitConfiguration) GitConfiguration.CREATOR.createFromParcel(parcel);
                    } else {
                        gitConfiguration2 = null;
                    }
                    DW(gitConfiguration2, parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    GitStatus j62 = j6(parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (j62 != null) {
                        parcel2.writeInt(1);
                        j62.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    if (parcel.readInt() != 0) {
                        gitConfiguration = (GitConfiguration) GitConfiguration.CREATOR.createFromParcel(parcel);
                    }
                    j6(gitConfiguration, parcel.readString(), parcel.createTypedArrayList(ModifiedFile.CREATOR), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    j6(parcel.readString(), parcel.createTypedArrayList(ModifiedFile.CREATOR), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    j6 = j6(parcel.readString(), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case 9:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    j6 = DW(parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(j6);
                    return true;
                case 10:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    List FH = FH(parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStringList(FH);
                    return true;
                case 11:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    Hw(parcel.readString(), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    j6(parcel.readString(), parcel.readString(), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    FH(parcel.readString(), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    DW(parcel.readString(), parcel.readString(), com.aide.ui.scm.d.a.j6(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.aide.ui.scm.IExternalGitService");
                    j6();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.ui.scm.IExternalGitService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String DW(String str, d dVar);

    void DW(GitConfiguration gitConfiguration, String str, d dVar);

    void DW(String str, String str2, d dVar);

    List<String> FH(String str, d dVar);

    void FH(String str, String str2, d dVar);

    void Hw(String str, String str2, d dVar);

    GitStatus j6(String str, d dVar);

    String j6(String str, String str2, d dVar);

    void j6();

    void j6(GitConfiguration gitConfiguration, String str, d dVar);

    void j6(GitConfiguration gitConfiguration, String str, String str2, String str3, d dVar);

    void j6(GitConfiguration gitConfiguration, String str, String str2, List<String> list, d dVar);

    void j6(GitConfiguration gitConfiguration, String str, List<ModifiedFile> list, String str2, d dVar);

    void j6(String str, String str2, String str3, d dVar);

    void j6(String str, List<ModifiedFile> list, d dVar);
}
