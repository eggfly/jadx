package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import r;

public abstract class m<E> extends k {
    final Context DW;
    final int FH;
    final o Hw;
    private u VH;
    private r<String, t> Zo;
    private boolean gn;
    private final Activity j6;
    private boolean u7;
    private final Handler v5;

    m(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.j6, 0);
    }

    m(Activity activity, Context context, Handler handler, int i) {
        this.Hw = new o();
        this.j6 = activity;
        this.DW = context;
        this.v5 = handler;
        this.FH = i;
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean j6(Fragment fragment) {
        return true;
    }

    public LayoutInflater DW() {
        return (LayoutInflater) this.DW.getSystemService("layout_inflater");
    }

    public void FH() {
    }

    public void j6(Fragment fragment, Intent intent, int i) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.DW.startActivity(intent);
    }

    public boolean Hw() {
        return true;
    }

    public int v5() {
        return this.FH;
    }

    public View j6(int i) {
        return null;
    }

    public boolean j6() {
        return true;
    }

    Activity Zo() {
        return this.j6;
    }

    Context VH() {
        return this.DW;
    }

    Handler gn() {
        return this.v5;
    }

    o u7() {
        return this.Hw;
    }

    void j6(String str) {
        if (this.Zo != null) {
            u uVar = (u) this.Zo.get(str);
            if (uVar != null && !uVar.Zo) {
                uVar.gn();
                this.Zo.remove(str);
            }
        }
    }

    void DW(Fragment fragment) {
    }

    void tp() {
        if (!this.u7) {
            this.u7 = true;
            if (this.VH != null) {
                this.VH.DW();
            } else if (!this.gn) {
                this.VH = j6("(root)", this.u7, false);
                if (!(this.VH == null || this.VH.v5)) {
                    this.VH.DW();
                }
            }
            this.gn = true;
        }
    }

    void j6(boolean z) {
        if (this.VH != null && this.u7) {
            this.u7 = false;
            if (z) {
                this.VH.Hw();
            } else {
                this.VH.FH();
            }
        }
    }

    void EQ() {
        if (this.VH != null) {
            this.VH.gn();
        }
    }

    void we() {
        if (this.Zo != null) {
            int size = this.Zo.size();
            u[] uVarArr = new u[size];
            for (int i = size - 1; i >= 0; i--) {
                uVarArr[i] = (u) this.Zo.FH(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                u uVar = uVarArr[i2];
                uVar.v5();
                uVar.VH();
            }
        }
    }

    u j6(String str, boolean z, boolean z2) {
        if (this.Zo == null) {
            this.Zo = new r();
        }
        u uVar = (u) this.Zo.get(str);
        if (uVar != null) {
            uVar.j6(this);
            return uVar;
        } else if (!z2) {
            return uVar;
        } else {
            uVar = new u(str, this, z);
            this.Zo.put(str, uVar);
            return uVar;
        }
    }

    r<String, t> J0() {
        int i;
        int i2 = 0;
        if (this.Zo != null) {
            int size = this.Zo.size();
            u[] uVarArr = new u[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                uVarArr[i3] = (u) this.Zo.FH(i3);
            }
            i = 0;
            while (i2 < size) {
                u uVar = uVarArr[i2];
                if (uVar.Zo) {
                    i = 1;
                } else {
                    uVar.gn();
                    this.Zo.remove(uVar.Hw);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.Zo;
        }
        return null;
    }

    void j6(r<String, t> rVar) {
        this.Zo = rVar;
    }

    void DW(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.u7);
        if (this.VH != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.VH)));
            printWriter.println(":");
            this.VH.j6(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
