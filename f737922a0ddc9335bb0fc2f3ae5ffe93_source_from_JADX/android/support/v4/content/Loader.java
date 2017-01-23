package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import n;

public class Loader<D> {
    int J8;
    boolean Mr;
    b<D> QX;
    boolean U2;
    c<D> Ws;
    Context XL;
    boolean a8;
    boolean aM;
    boolean j3;

    public interface b<D> {
        void j6(Loader<D> loader);
    }

    public interface c<D> {
        void j6(Loader<D> loader, D d);
    }

    public final class a extends ContentObserver {
        final /* synthetic */ Loader j6;

        public a(Loader loader) {
            this.j6 = loader;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.j6.er();
        }
    }

    public Loader(Context context) {
        this.aM = false;
        this.j3 = false;
        this.Mr = true;
        this.U2 = false;
        this.a8 = false;
        this.XL = context.getApplicationContext();
    }

    public void DW(D d) {
        if (this.Ws != null) {
            this.Ws.j6(this, d);
        }
    }

    public void we() {
        if (this.QX != null) {
            this.QX.j6(this);
        }
    }

    public Context J0() {
        return this.XL;
    }

    public void j6(int i, c<D> cVar) {
        if (this.Ws != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.Ws = cVar;
        this.J8 = i;
    }

    public void j6(c<D> cVar) {
        if (this.Ws == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.Ws != cVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.Ws = null;
        }
    }

    public void j6(b<D> bVar) {
        if (this.QX != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.QX = bVar;
    }

    public void DW(b<D> bVar) {
        if (this.QX == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.QX != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.QX = null;
        }
    }

    public boolean J8() {
        return this.aM;
    }

    public boolean Ws() {
        return this.j3;
    }

    public boolean QX() {
        return this.Mr;
    }

    public final void XL() {
        this.aM = true;
        this.Mr = false;
        this.j3 = false;
        u7();
    }

    protected void u7() {
    }

    public boolean aM() {
        return DW();
    }

    protected boolean DW() {
        return false;
    }

    public void j3() {
        j6();
    }

    protected void j6() {
    }

    public void Mr() {
        this.aM = false;
        tp();
    }

    protected void tp() {
    }

    public void U2() {
        EQ();
        this.Mr = true;
        this.aM = false;
        this.j3 = false;
        this.U2 = false;
        this.a8 = false;
    }

    protected void EQ() {
    }

    public boolean a8() {
        boolean z = this.U2;
        this.U2 = false;
        this.a8 |= z;
        return z;
    }

    public void lg() {
        this.a8 = false;
    }

    public void rN() {
        if (this.a8) {
            this.U2 = true;
        }
    }

    public void er() {
        if (this.aM) {
            j3();
        } else {
            this.U2 = true;
        }
    }

    public String FH(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        n.j6(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        n.j6(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.J8);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.J8);
        printWriter.print(" mListener=");
        printWriter.println(this.Ws);
        if (this.aM || this.U2 || this.a8) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.aM);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.U2);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.a8);
        }
        if (this.j3 || this.Mr) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.j3);
            printWriter.print(" mReset=");
            printWriter.println(this.Mr);
        }
    }
}
