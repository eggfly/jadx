package com.aide.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;

public class p {
    private final String DW;
    private ProgressDialog FH;
    private Handler Hw;
    private int Zo;
    private final Activity j6;
    private Runnable v5;

    class 1 implements Runnable {
        final /* synthetic */ p j6;

        1(p pVar) {
            this.j6 = pVar;
        }

        public void run() {
            this.j6.v5();
        }
    }

    class 2 implements OnCancelListener {
        final /* synthetic */ p j6;

        2(p pVar) {
            this.j6 = pVar;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.j6.Hw();
        }
    }

    public p(Activity activity, String str) {
        this.Hw = new Handler();
        this.j6 = activity;
        this.DW = str;
        this.Zo = 500;
    }

    public void j6() {
        DW();
        this.v5 = new 1(this);
        this.Hw.postDelayed(this.v5, (long) this.Zo);
    }

    public void DW() {
        if (this.v5 != null) {
            this.Hw.removeCallbacks(this.v5);
            this.v5 = null;
        }
        if (this.FH != null) {
            this.FH.dismiss();
            this.FH = null;
        }
    }

    public void FH() {
        DW();
        v5();
    }

    protected void Hw() {
    }

    private void v5() {
        this.FH = new ProgressDialog(this.j6);
        this.FH.setMessage(this.DW);
        this.FH.setOnCancelListener(new 2(this));
        this.FH.getWindow().clearFlags(2);
        this.FH.show();
    }
}
