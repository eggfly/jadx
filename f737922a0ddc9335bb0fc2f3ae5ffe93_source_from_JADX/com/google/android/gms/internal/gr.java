package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class gr extends gx implements OnCancelListener {
    protected boolean DW;
    protected final com.google.android.gms.common.a FH;
    private final Handler VH;
    private int Zo;
    protected boolean j6;
    private ConnectionResult v5;

    private class a implements Runnable {
        final /* synthetic */ gr j6;

        class 1 extends com.google.android.gms.internal.zzol.a {
            final /* synthetic */ a DW;
            final /* synthetic */ Dialog j6;

            1(a aVar, Dialog dialog) {
                this.DW = aVar;
                this.j6 = dialog;
            }

            public void j6() {
                this.DW.j6.Hw();
                if (this.j6.isShowing()) {
                    this.j6.dismiss();
                }
            }
        }

        private a(gr grVar) {
            this.j6 = grVar;
        }

        public void run() {
            if (!this.j6.j6) {
                return;
            }
            if (this.j6.v5.j6()) {
                this.j6.Hw.startActivityForResult(GoogleApiActivity.DW(this.j6.v5(), this.j6.v5.Hw(), this.j6.Zo, false), 1);
            } else if (this.j6.FH.j6(this.j6.v5.FH())) {
                this.j6.FH.j6(this.j6.v5(), this.j6.Hw, this.j6.v5.FH(), 2, this.j6);
            } else if (this.j6.v5.FH() == 18) {
                this.j6.FH.j6(this.j6.v5().getApplicationContext(), new 1(this, this.j6.FH.j6(this.j6.v5(), this.j6)));
            } else {
                this.j6.j6(this.j6.v5, this.j6.Zo);
            }
        }
    }

    public void DW() {
        super.DW();
        this.j6 = false;
    }

    public void DW(Bundle bundle) {
        super.DW(bundle);
        bundle.putBoolean("resolving_error", this.DW);
        if (this.DW) {
            bundle.putInt("failed_client_id", this.Zo);
            bundle.putInt("failed_status", this.v5.FH());
            bundle.putParcelable("failed_resolution", this.v5.Hw());
        }
    }

    public void DW(ConnectionResult connectionResult, int i) {
        if (!this.DW) {
            this.DW = true;
            this.Zo = i;
            this.v5 = connectionResult;
            this.VH.post(new a());
        }
    }

    protected abstract void FH();

    protected void Hw() {
        this.Zo = -1;
        this.DW = false;
        this.v5 = null;
        FH();
    }

    public void j6() {
        super.j6();
        this.j6 = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003e;
    L_0x000c:
        r5.Hw();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.FH;
        r3 = r5.v5();
        r2 = r2.j6(r3);
        if (r2 != 0) goto L_0x0048;
    L_0x001c:
        r1 = r5.v5;
        r1 = r1.FH();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0046;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0035:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.v5 = r2;
        goto L_0x0009;
    L_0x003e:
        r0 = r5.v5;
        r1 = r5.Zo;
        r5.j6(r0, r1);
        goto L_0x000f;
    L_0x0046:
        r0 = r2;
        goto L_0x0035;
    L_0x0048:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gr.j6(int, int, android.content.Intent):void");
    }

    public void j6(Bundle bundle) {
        super.j6(bundle);
        if (bundle != null) {
            this.DW = bundle.getBoolean("resolving_error", false);
            if (this.DW) {
                this.Zo = bundle.getInt("failed_client_id", -1);
                this.v5 = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void j6(ConnectionResult connectionResult, int i);

    public void onCancel(DialogInterface dialogInterface) {
        j6(new ConnectionResult(13, null), this.Zo);
        Hw();
    }
}
