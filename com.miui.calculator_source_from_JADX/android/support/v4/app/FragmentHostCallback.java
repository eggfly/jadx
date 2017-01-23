package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity f176a;
    final Context f177b;
    final int f178c;
    final FragmentManagerImpl f179d;
    private final Handler f180e;
    private SimpleArrayMap<String, LoaderManager> f181f;
    private LoaderManagerImpl f182g;
    private boolean f183h;
    private boolean f184i;

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.f189a, 0);
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.f179d = new FragmentManagerImpl();
        this.f176a = activity;
        this.f177b = context;
        this.f180e = handler;
        this.f178c = i;
    }

    public void m231a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean m234a(Fragment fragment) {
        return true;
    }

    public LayoutInflater m235b() {
        return (LayoutInflater) this.f177b.getSystemService("layout_inflater");
    }

    public void m238c() {
    }

    public boolean m239d() {
        return true;
    }

    public int m240e() {
        return this.f178c;
    }

    @Nullable
    public View m228a(int i) {
        return null;
    }

    public boolean m233a() {
        return true;
    }

    Activity m241f() {
        return this.f176a;
    }

    Context m242g() {
        return this.f177b;
    }

    Handler m243h() {
        return this.f180e;
    }

    FragmentManagerImpl m244i() {
        return this.f179d;
    }

    void m230a(String str) {
        if (this.f181f != null) {
            LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f181f.get(str);
            if (loaderManagerImpl != null && !loaderManagerImpl.f322f) {
                loaderManagerImpl.m455h();
                this.f181f.remove(str);
            }
        }
    }

    void m236b(Fragment fragment) {
    }

    void m245j() {
        if (!this.f184i) {
            this.f184i = true;
            if (this.f182g != null) {
                this.f182g.m449b();
            } else if (!this.f183h) {
                this.f182g = m227a("(root)", this.f184i, false);
                if (!(this.f182g == null || this.f182g.f321e)) {
                    this.f182g.m449b();
                }
            }
            this.f183h = true;
        }
    }

    void m232a(boolean z) {
        if (this.f182g != null && this.f184i) {
            this.f184i = false;
            if (z) {
                this.f182g.m451d();
            } else {
                this.f182g.m450c();
            }
        }
    }

    void m246k() {
        if (this.f182g != null) {
            this.f182g.m455h();
        }
    }

    void m247l() {
        if (this.f181f != null) {
            int size = this.f181f.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) this.f181f.m1087c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                loaderManagerImpl.m452e();
                loaderManagerImpl.m454g();
            }
        }
    }

    LoaderManagerImpl m227a(String str, boolean z, boolean z2) {
        if (this.f181f == null) {
            this.f181f = new SimpleArrayMap();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f181f.get(str);
        if (loaderManagerImpl != null) {
            loaderManagerImpl.m445a(this);
            return loaderManagerImpl;
        } else if (!z2) {
            return loaderManagerImpl;
        } else {
            loaderManagerImpl = new LoaderManagerImpl(str, this, z);
            this.f181f.put(str, loaderManagerImpl);
            return loaderManagerImpl;
        }
    }

    SimpleArrayMap<String, LoaderManager> m248m() {
        int i;
        int i2 = 0;
        if (this.f181f != null) {
            int size = this.f181f.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                loaderManagerImplArr[i3] = (LoaderManagerImpl) this.f181f.m1087c(i3);
            }
            i = 0;
            while (i2 < size) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                if (loaderManagerImpl.f322f) {
                    i = 1;
                } else {
                    loaderManagerImpl.m455h();
                    this.f181f.remove(loaderManagerImpl.f320d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f181f;
        }
        return null;
    }

    void m229a(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        this.f181f = simpleArrayMap;
    }

    void m237b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f184i);
        if (this.f182g != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f182g)));
            printWriter.println(":");
            this.f182g.m447a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
