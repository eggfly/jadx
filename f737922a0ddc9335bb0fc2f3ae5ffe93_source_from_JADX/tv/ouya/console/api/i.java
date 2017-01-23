package tv.ouya.console.api;

import android.os.Bundle;
import android.util.Log;

public abstract class i<T> implements Runnable {
    protected h<T> DW;
    private String j6;

    abstract void j6();

    public i(h<T> hVar, String str) {
        this.DW = hVar;
        this.j6 = str;
    }

    public void run() {
        try {
            j6();
        } catch (Throwable e) {
            Log.e("OUYASDK", "Remote exception while " + this.j6, e);
            this.DW.j6(3003, "", new Bundle());
        }
    }
}
