package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCanceledListener;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
    static boolean f317a;
    final SparseArrayCompat<LoaderInfo> f318b;
    final SparseArrayCompat<LoaderInfo> f319c;
    final String f320d;
    boolean f321e;
    boolean f322f;
    private FragmentHostCallback f323g;

    final class LoaderInfo implements OnLoadCanceledListener<Object>, OnLoadCompleteListener<Object> {
        final int f302a;
        final Bundle f303b;
        LoaderCallbacks<Object> f304c;
        Loader<Object> f305d;
        boolean f306e;
        boolean f307f;
        Object f308g;
        boolean f309h;
        boolean f310i;
        boolean f311j;
        boolean f312k;
        boolean f313l;
        boolean f314m;
        LoaderInfo f315n;
        final /* synthetic */ LoaderManagerImpl f316o;

        void m434a() {
            if (this.f310i && this.f311j) {
                this.f309h = true;
            } else if (!this.f309h) {
                this.f309h = true;
                if (LoaderManagerImpl.f317a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f305d == null && this.f304c != null) {
                    this.f305d = this.f304c.m428a(this.f302a, this.f303b);
                }
                if (this.f305d == null) {
                    return;
                }
                if (!this.f305d.getClass().isMemberClass() || Modifier.isStatic(this.f305d.getClass().getModifiers())) {
                    if (!this.f314m) {
                        this.f305d.m513a(this.f302a, this);
                        this.f305d.m514a((OnLoadCanceledListener) this);
                        this.f314m = true;
                    }
                    this.f305d.m529q();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f305d);
            }
        }

        void m438b() {
            if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f310i = true;
            this.f311j = this.f309h;
            this.f309h = false;
            this.f304c = null;
        }

        void m440c() {
            if (this.f310i) {
                if (LoaderManagerImpl.f317a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f310i = false;
                if (!(this.f309h == this.f311j || this.f309h)) {
                    m442e();
                }
            }
            if (this.f309h && this.f306e && !this.f312k) {
                m439b(this.f305d, this.f308g);
            }
        }

        void m441d() {
            if (this.f309h && this.f312k) {
                this.f312k = false;
                if (this.f306e) {
                    m439b(this.f305d, this.f308g);
                }
            }
        }

        void m442e() {
            if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f309h = false;
            if (!this.f310i && this.f305d != null && this.f314m) {
                this.f314m = false;
                this.f305d.m515a((OnLoadCompleteListener) this);
                this.f305d.m517b((OnLoadCanceledListener) this);
                this.f305d.m532t();
            }
        }

        void m443f() {
            String str;
            LoaderCallbacks loaderCallbacks = null;
            if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f313l = true;
            boolean z = this.f307f;
            this.f307f = false;
            if (this.f304c != null && this.f305d != null && this.f306e && z) {
                if (LoaderManagerImpl.f317a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f316o.f323g != null) {
                    String str2 = this.f316o.f323g.f179d.f236u;
                    this.f316o.f323g.f179d.f236u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f304c.m429a(this.f305d);
                } finally {
                    loaderCallbacks = this.f316o.f323g;
                    if (loaderCallbacks != null) {
                        loaderCallbacks = this.f316o.f323g.f179d;
                        loaderCallbacks.f236u = str;
                    }
                }
            }
            this.f304c = loaderCallbacks;
            this.f308g = loaderCallbacks;
            this.f306e = false;
            if (this.f305d != null) {
                if (this.f314m) {
                    this.f314m = false;
                    this.f305d.m515a((OnLoadCompleteListener) this);
                    this.f305d.m517b((OnLoadCanceledListener) this);
                }
                this.f305d.m533u();
            }
            if (this.f315n != null) {
                this.f315n.m443f();
            }
        }

        public void m435a(Loader<Object> loader) {
            if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }
            if (this.f313l) {
                if (LoaderManagerImpl.f317a) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (this.f316o.f318b.m1108a(this.f302a) == this) {
                LoaderInfo loaderInfo = this.f315n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f317a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo);
                    }
                    this.f315n = null;
                    this.f316o.f318b.m1112b(this.f302a, null);
                    m443f();
                    this.f316o.m446a(loaderInfo);
                }
            } else if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public void m436a(Loader<Object> loader, Object obj) {
            if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.f313l) {
                if (LoaderManagerImpl.f317a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (this.f316o.f318b.m1108a(this.f302a) == this) {
                LoaderInfo loaderInfo = this.f315n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f317a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo);
                    }
                    this.f315n = null;
                    this.f316o.f318b.m1112b(this.f302a, null);
                    m443f();
                    this.f316o.m446a(loaderInfo);
                    return;
                }
                if (!(this.f308g == obj && this.f306e)) {
                    this.f308g = obj;
                    this.f306e = true;
                    if (this.f309h) {
                        m439b(loader, obj);
                    }
                }
                loaderInfo = (LoaderInfo) this.f316o.f319c.m1108a(this.f302a);
                if (!(loaderInfo == null || loaderInfo == this)) {
                    loaderInfo.f307f = false;
                    loaderInfo.m443f();
                    this.f316o.f319c.m1114c(this.f302a);
                }
                if (this.f316o.f323g != null && !this.f316o.m448a()) {
                    this.f316o.f323g.f179d.m355d();
                }
            } else if (LoaderManagerImpl.f317a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        void m439b(Loader<Object> loader, Object obj) {
            String str;
            if (this.f304c != null) {
                if (this.f316o.f323g != null) {
                    String str2 = this.f316o.f323g.f179d.f236u;
                    this.f316o.f323g.f179d.f236u = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (LoaderManagerImpl.f317a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.m520c(obj));
                    }
                    this.f304c.m430a((Loader) loader, obj);
                    this.f307f = true;
                } finally {
                    if (this.f316o.f323g != null) {
                        this.f316o.f323g.f179d.f236u = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f302a);
            stringBuilder.append(" : ");
            DebugUtils.m1096a(this.f305d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void m437a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f302a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f303b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f304c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f305d);
            if (this.f305d != null) {
                this.f305d.m516a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f306e || this.f307f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f306e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f307f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f308g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f309h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f312k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f313l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f310i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f311j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f314m);
            if (this.f315n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f315n);
                printWriter.println(":");
                this.f315n.m437a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    static {
        f317a = false;
    }

    LoaderManagerImpl(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        this.f318b = new SparseArrayCompat();
        this.f319c = new SparseArrayCompat();
        this.f320d = str;
        this.f323g = fragmentHostCallback;
        this.f321e = z;
    }

    void m445a(FragmentHostCallback fragmentHostCallback) {
        this.f323g = fragmentHostCallback;
    }

    void m446a(LoaderInfo loaderInfo) {
        this.f318b.m1112b(loaderInfo.f302a, loaderInfo);
        if (this.f321e) {
            loaderInfo.m434a();
        }
    }

    void m449b() {
        if (f317a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f321e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f321e = true;
        for (int b = this.f318b.m1110b() - 1; b >= 0; b--) {
            ((LoaderInfo) this.f318b.m1116e(b)).m434a();
        }
    }

    void m450c() {
        if (f317a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f321e) {
            for (int b = this.f318b.m1110b() - 1; b >= 0; b--) {
                ((LoaderInfo) this.f318b.m1116e(b)).m442e();
            }
            this.f321e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m451d() {
        if (f317a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f321e) {
            this.f322f = true;
            this.f321e = false;
            for (int b = this.f318b.m1110b() - 1; b >= 0; b--) {
                ((LoaderInfo) this.f318b.m1116e(b)).m438b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m452e() {
        if (this.f322f) {
            if (f317a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f322f = false;
            for (int b = this.f318b.m1110b() - 1; b >= 0; b--) {
                ((LoaderInfo) this.f318b.m1116e(b)).m440c();
            }
        }
    }

    void m453f() {
        for (int b = this.f318b.m1110b() - 1; b >= 0; b--) {
            ((LoaderInfo) this.f318b.m1116e(b)).f312k = true;
        }
    }

    void m454g() {
        for (int b = this.f318b.m1110b() - 1; b >= 0; b--) {
            ((LoaderInfo) this.f318b.m1116e(b)).m441d();
        }
    }

    void m455h() {
        int b;
        if (!this.f322f) {
            if (f317a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f318b.m1110b() - 1; b >= 0; b--) {
                ((LoaderInfo) this.f318b.m1116e(b)).m443f();
            }
            this.f318b.m1113c();
        }
        if (f317a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f319c.m1110b() - 1; b >= 0; b--) {
            ((LoaderInfo) this.f319c.m1116e(b)).m443f();
        }
        this.f319c.m1113c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.m1096a(this.f323g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m447a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f318b.m1110b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f318b.m1110b(); i2++) {
                LoaderInfo loaderInfo = (LoaderInfo) this.f318b.m1116e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f318b.m1115d(i2));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.m437a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f319c.m1110b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f319c.m1110b()) {
                loaderInfo = (LoaderInfo) this.f319c.m1116e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f319c.m1115d(i));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.m437a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean m448a() {
        int b = this.f318b.m1110b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            LoaderInfo loaderInfo = (LoaderInfo) this.f318b.m1116e(i);
            if (!loaderInfo.f309h || loaderInfo.f307f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
