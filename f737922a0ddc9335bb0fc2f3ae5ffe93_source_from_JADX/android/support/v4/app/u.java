package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.b;
import android.support.v4.content.Loader.c;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import n;
import s;

class u extends t {
    static boolean j6;
    final s<a> DW;
    final s<a> FH;
    final String Hw;
    private m VH;
    boolean Zo;
    boolean v5;

    final class a implements b<Object>, c<Object> {
        final Bundle DW;
        boolean EQ;
        android.support.v4.app.t.a<Object> FH;
        Loader<Object> Hw;
        boolean J0;
        a J8;
        Object VH;
        final /* synthetic */ u Ws;
        boolean Zo;
        boolean gn;
        final int j6;
        boolean tp;
        boolean u7;
        boolean v5;
        boolean we;

        void j6() {
            if (this.u7 && this.tp) {
                this.gn = true;
            } else if (!this.gn) {
                this.gn = true;
                if (u.j6) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.Hw == null && this.FH != null) {
                    this.Hw = this.FH.j6(this.j6, this.DW);
                }
                if (this.Hw == null) {
                    return;
                }
                if (!this.Hw.getClass().isMemberClass() || Modifier.isStatic(this.Hw.getClass().getModifiers())) {
                    if (!this.J0) {
                        this.Hw.j6(this.j6, this);
                        this.Hw.j6((b) this);
                        this.J0 = true;
                    }
                    this.Hw.XL();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.Hw);
            }
        }

        void DW() {
            if (u.j6) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.u7 = true;
            this.tp = this.gn;
            this.gn = false;
            this.FH = null;
        }

        void FH() {
            if (this.u7) {
                if (u.j6) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.u7 = false;
                if (!(this.gn == this.tp || this.gn)) {
                    v5();
                }
            }
            if (this.gn && this.v5 && !this.EQ) {
                DW(this.Hw, this.VH);
            }
        }

        void Hw() {
            if (this.gn && this.EQ) {
                this.EQ = false;
                if (this.v5) {
                    DW(this.Hw, this.VH);
                }
            }
        }

        void v5() {
            if (u.j6) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.gn = false;
            if (!this.u7 && this.Hw != null && this.J0) {
                this.J0 = false;
                this.Hw.j6((c) this);
                this.Hw.DW((b) this);
                this.Hw.Mr();
            }
        }

        void Zo() {
            String str;
            android.support.v4.app.t.a aVar = null;
            if (u.j6) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.we = true;
            boolean z = this.Zo;
            this.Zo = false;
            if (this.FH != null && this.Hw != null && this.v5 && z) {
                if (u.j6) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.Ws.VH != null) {
                    String str2 = this.Ws.VH.Hw.U2;
                    this.Ws.VH.Hw.U2 = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.FH.j6(this.Hw);
                } finally {
                    aVar = this.Ws.VH;
                    if (aVar != null) {
                        aVar = this.Ws.VH.Hw;
                        aVar.U2 = str;
                    }
                }
            }
            this.FH = aVar;
            this.VH = aVar;
            this.v5 = false;
            if (this.Hw != null) {
                if (this.J0) {
                    this.J0 = false;
                    this.Hw.j6((c) this);
                    this.Hw.DW((b) this);
                }
                this.Hw.U2();
            }
            if (this.J8 != null) {
                this.J8.Zo();
            }
        }

        public void j6(Loader<Object> loader) {
            if (u.j6) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }
            if (this.we) {
                if (u.j6) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (this.Ws.DW.j6(this.j6) == this) {
                a aVar = this.J8;
                if (aVar != null) {
                    if (u.j6) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + aVar);
                    }
                    this.J8 = null;
                    this.Ws.DW.DW(this.j6, null);
                    Zo();
                    this.Ws.j6(aVar);
                }
            } else if (u.j6) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public void j6(Loader<Object> loader, Object obj) {
            if (u.j6) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.we) {
                if (u.j6) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (this.Ws.DW.j6(this.j6) == this) {
                a aVar = this.J8;
                if (aVar != null) {
                    if (u.j6) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + aVar);
                    }
                    this.J8 = null;
                    this.Ws.DW.DW(this.j6, null);
                    Zo();
                    this.Ws.j6(aVar);
                    return;
                }
                if (!(this.VH == obj && this.v5)) {
                    this.VH = obj;
                    this.v5 = true;
                    if (this.gn) {
                        DW(loader, obj);
                    }
                }
                aVar = (a) this.Ws.FH.j6(this.j6);
                if (!(aVar == null || aVar == this)) {
                    aVar.Zo = false;
                    aVar.Zo();
                    this.Ws.FH.FH(this.j6);
                }
                if (this.Ws.VH != null && !this.Ws.j6()) {
                    this.Ws.VH.Hw.v5();
                }
            } else if (u.j6) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        void DW(Loader<Object> loader, Object obj) {
            String str;
            if (this.FH != null) {
                if (this.Ws.VH != null) {
                    String str2 = this.Ws.VH.Hw.U2;
                    this.Ws.VH.Hw.U2 = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (u.j6) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.FH(obj));
                    }
                    this.FH.j6((Loader) loader, obj);
                    this.Zo = true;
                } finally {
                    if (this.Ws.VH != null) {
                        this.Ws.VH.Hw.U2 = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.j6);
            stringBuilder.append(" : ");
            n.j6(this.Hw, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.j6);
            printWriter.print(" mArgs=");
            printWriter.println(this.DW);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.FH);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.Hw);
            if (this.Hw != null) {
                this.Hw.j6(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.v5 || this.Zo) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.v5);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.Zo);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.VH);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.gn);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.EQ);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.we);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.u7);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.tp);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.J0);
            if (this.J8 != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.J8);
                printWriter.println(":");
                this.J8.j6(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    static {
        j6 = false;
    }

    u(String str, m mVar, boolean z) {
        this.DW = new s();
        this.FH = new s();
        this.Hw = str;
        this.VH = mVar;
        this.v5 = z;
    }

    void j6(m mVar) {
        this.VH = mVar;
    }

    void j6(a aVar) {
        this.DW.DW(aVar.j6, aVar);
        if (this.v5) {
            aVar.j6();
        }
    }

    void DW() {
        if (j6) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.v5) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.v5 = true;
        for (int DW = this.DW.DW() - 1; DW >= 0; DW--) {
            ((a) this.DW.v5(DW)).j6();
        }
    }

    void FH() {
        if (j6) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.v5) {
            for (int DW = this.DW.DW() - 1; DW >= 0; DW--) {
                ((a) this.DW.v5(DW)).v5();
            }
            this.v5 = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void Hw() {
        if (j6) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.v5) {
            this.Zo = true;
            this.v5 = false;
            for (int DW = this.DW.DW() - 1; DW >= 0; DW--) {
                ((a) this.DW.v5(DW)).DW();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void v5() {
        if (this.Zo) {
            if (j6) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.Zo = false;
            for (int DW = this.DW.DW() - 1; DW >= 0; DW--) {
                ((a) this.DW.v5(DW)).FH();
            }
        }
    }

    void Zo() {
        for (int DW = this.DW.DW() - 1; DW >= 0; DW--) {
            ((a) this.DW.v5(DW)).EQ = true;
        }
    }

    void VH() {
        for (int DW = this.DW.DW() - 1; DW >= 0; DW--) {
            ((a) this.DW.v5(DW)).Hw();
        }
    }

    void gn() {
        int DW;
        if (!this.Zo) {
            if (j6) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (DW = this.DW.DW() - 1; DW >= 0; DW--) {
                ((a) this.DW.v5(DW)).Zo();
            }
            this.DW.FH();
        }
        if (j6) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (DW = this.FH.DW() - 1; DW >= 0; DW--) {
            ((a) this.FH.v5(DW)).Zo();
        }
        this.FH.FH();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        n.j6(this.VH, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.DW.DW() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.DW.DW(); i2++) {
                a aVar = (a) this.DW.v5(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.DW.Hw(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j6(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.FH.DW() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.FH.DW()) {
                aVar = (a) this.FH.v5(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.FH.Hw(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j6(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean j6() {
        int DW = this.DW.DW();
        boolean z = false;
        for (int i = 0; i < DW; i++) {
            int i2;
            a aVar = (a) this.DW.v5(i);
            if (!aVar.gn || aVar.Zo) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
