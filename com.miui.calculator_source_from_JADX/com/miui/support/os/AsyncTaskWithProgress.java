package com.miui.support.os;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import com.miui.support.app.ProgressDialog;
import java.util.HashMap;

public abstract class AsyncTaskWithProgress<Params, Result> extends AsyncTask<Params, Integer, Result> {
    private static final HashMap<String, AsyncTaskWithProgress<?, ?>> f3467a;
    private int f3468b;
    private int f3469c;
    private CharSequence f3470d;
    private int f3471e;
    private CharSequence f3472f;
    private boolean f3473g;
    private boolean f3474h;
    private int f3475i;
    private int f3476j;
    private int f3477k;
    private volatile ProgressDialogFragment f3478l;
    private final Listeners f3479m;

    private class Listeners implements OnCancelListener, OnClickListener {
        final /* synthetic */ AsyncTaskWithProgress f3465a;

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f3465a.f3478l != null) {
                DialogInterface dialog = this.f3465a.f3478l.getDialog();
                if (dialog != null && dialogInterface == dialog && i == -2) {
                    this.f3465a.cancel(true);
                }
            }
        }

        public void onCancel(DialogInterface dialogInterface) {
            onClick(dialogInterface, -2);
        }
    }

    public static class ProgressDialogFragment extends DialogFragment {
        private AsyncTaskWithProgress<?, ?> f3466a;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f3466a = (AsyncTaskWithProgress) AsyncTaskWithProgress.f3467a.get(getArguments().getString("task"));
            if (this.f3466a == null) {
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.remove(this);
                beginTransaction.commit();
            }
        }

        public void onStart() {
            super.onStart();
            if (this.f3466a != null) {
                this.f3466a.f3478l = this;
            }
        }

        public void onStop() {
            if (this.f3466a != null) {
                this.f3466a.f3478l = null;
            }
            super.onStop();
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.f3466a != null && this.f3466a.f3473g) {
                this.f3466a.f3479m.onCancel(dialogInterface);
            }
            super.onCancel(dialogInterface);
        }

        public Dialog onCreateDialog(Bundle bundle) {
            if (this.f3466a == null) {
                return super.onCreateDialog(bundle);
            }
            Dialog progressDialog = new ProgressDialog(getActivity(), this.f3466a.f3468b);
            if (this.f3466a.f3469c != 0) {
                progressDialog.setTitle(this.f3466a.f3469c);
            } else {
                progressDialog.setTitle(this.f3466a.f3470d);
            }
            if (this.f3466a.f3471e != 0) {
                progressDialog.m3318a(getActivity().getText(this.f3466a.f3471e));
            } else {
                progressDialog.m3318a(this.f3466a.f3472f);
            }
            progressDialog.m3325f(this.f3466a.f3476j);
            progressDialog.m3319a(this.f3466a.f3474h);
            if (!this.f3466a.f3474h) {
                progressDialog.m3322c(this.f3466a.f3475i);
                progressDialog.m3316a(this.f3466a.f3477k);
            }
            if (this.f3466a.f3473g) {
                progressDialog.m2969a(-2, progressDialog.getContext().getText(17039360), this.f3466a.f3479m);
                progressDialog.setCancelable(true);
            } else {
                progressDialog.m2969a(-2, null, (OnClickListener) null);
                progressDialog.setCancelable(false);
            }
            return progressDialog;
        }
    }

    static {
        f3467a = new HashMap();
    }
}
