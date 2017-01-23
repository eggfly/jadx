package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    int f394n;
    OnLoadCompleteListener<D> f395o;
    OnLoadCanceledListener<D> f396p;
    Context f397q;
    boolean f398r;
    boolean f399s;
    boolean f400t;
    boolean f401u;
    boolean f402v;

    public interface OnLoadCanceledListener<D> {
        void m432a(Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void m433a(Loader<D> loader, D d);
    }

    public final class ForceLoadContentObserver extends ContentObserver {
        final /* synthetic */ Loader f425a;

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f425a.m537y();
        }
    }

    public void m518b(D d) {
        if (this.f395o != null) {
            this.f395o.m433a(this, d);
        }
    }

    public void m524l() {
        if (this.f396p != null) {
            this.f396p.m432a(this);
        }
    }

    public Context m525m() {
        return this.f397q;
    }

    public void m513a(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f395o != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f395o = onLoadCompleteListener;
        this.f394n = i;
    }

    public void m515a(OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f395o == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f395o != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f395o = null;
        }
    }

    public void m514a(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f396p != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f396p = onLoadCanceledListener;
    }

    public void m517b(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f396p == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f396p != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f396p = null;
        }
    }

    public boolean m526n() {
        return this.f398r;
    }

    public boolean m527o() {
        return this.f399s;
    }

    public boolean m528p() {
        return this.f400t;
    }

    public final void m529q() {
        this.f398r = true;
        this.f400t = false;
        this.f399s = false;
        m521i();
    }

    protected void m521i() {
    }

    public boolean m530r() {
        return m519b();
    }

    protected boolean m519b() {
        return false;
    }

    public void m531s() {
        m512a();
    }

    protected void m512a() {
    }

    public void m532t() {
        this.f398r = false;
        m522j();
    }

    protected void m522j() {
    }

    public void m533u() {
        m523k();
        this.f400t = true;
        this.f398r = false;
        this.f399s = false;
        this.f401u = false;
        this.f402v = false;
    }

    protected void m523k() {
    }

    public boolean m534v() {
        boolean z = this.f401u;
        this.f401u = false;
        this.f402v |= z;
        return z;
    }

    public void m535w() {
        this.f402v = false;
    }

    public void m536x() {
        if (this.f402v) {
            this.f401u = true;
        }
    }

    public void m537y() {
        if (this.f398r) {
            m531s();
        } else {
            this.f401u = true;
        }
    }

    public String m520c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m1096a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m1096a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f394n);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m516a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f394n);
        printWriter.print(" mListener=");
        printWriter.println(this.f395o);
        if (this.f398r || this.f401u || this.f402v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f398r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f401u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f402v);
        }
        if (this.f399s || this.f400t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f399s);
            printWriter.print(" mReset=");
            printWriter.println(this.f400t);
        }
    }
}
