package com.miui.support.util.async.tasks.listeners;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import com.miui.support.app.ProgressDialog;
import com.miui.support.util.async.Task;
import com.miui.support.util.async.Task.Listener;
import com.miui.support.util.async.TaskManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

public class ProgressDialogListener extends BaseTaskListener {
    static final LinkedHashMap<String, ProgressDialogListener> f3828a;
    FragmentManager f3829b;
    WeakReference<Task<?>> f3830c;
    ProgressDialogFragment f3831d;
    int f3832e;
    int f3833f;
    CharSequence f3834g;
    int f3835h;
    CharSequence f3836i;
    boolean f3837j;
    boolean f3838k;
    int f3839l;
    int f3840m;
    int f3841n;

    public static class ProgressDialogFragment extends DialogFragment implements OnClickListener {
        private ProgressDialogListener f3827a;

        void m5591a(boolean z) {
            Dialog dialog = getDialog();
            if (dialog instanceof ProgressDialog) {
                ((ProgressDialog) dialog).m3319a(z);
            }
        }

        void m5590a(int i) {
            Dialog dialog = getDialog();
            if (dialog instanceof ProgressDialog) {
                ((ProgressDialog) dialog).m3316a(i);
            }
        }

        void m5592b(int i) {
            Dialog dialog = getDialog();
            if (dialog instanceof ProgressDialog) {
                ((ProgressDialog) dialog).m3322c(i);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            if (this.f3827a != null) {
                this.f3827a.f3831d = null;
                this.f3827a.f3829b = null;
                this.f3827a = null;
            }
        }

        public void onResume() {
            super.onResume();
            this.f3827a = (ProgressDialogListener) ProgressDialogListener.f3828a.get(getArguments().getString("ProgressDialogListener"));
            if (this.f3827a == null) {
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.remove(this);
                beginTransaction.commit();
                return;
            }
            this.f3827a.f3831d = this;
            this.f3827a.f3829b = getFragmentManager();
            WeakReference weakReference = this.f3827a.f3830c;
            Task task = null;
            if (weakReference != null) {
                task = (Task) weakReference.get();
            }
            if (task == null || !task.m5484c()) {
                dismiss();
                ProgressDialogListener.f3828a.remove(getArguments().getString("ProgressDialogListener"));
            }
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.f3827a != null && this.f3827a.f3837j) {
                WeakReference weakReference = this.f3827a.f3830c;
                if (weakReference != null) {
                    Task task = (Task) weakReference.get();
                    if (task != null) {
                        task.m5487e();
                    }
                }
            }
            super.onCancel(dialogInterface);
        }

        public Dialog onCreateDialog(Bundle bundle) {
            if (this.f3827a == null) {
                return super.onCreateDialog(bundle);
            }
            Dialog progressDialog = new ProgressDialog(getActivity(), this.f3827a.f3832e);
            if (this.f3827a.f3833f != 0) {
                progressDialog.setTitle(this.f3827a.f3833f);
            } else {
                progressDialog.setTitle(this.f3827a.f3834g);
            }
            if (this.f3827a.f3835h != 0) {
                progressDialog.setTitle(this.f3827a.f3835h);
            } else {
                progressDialog.m3318a(this.f3827a.f3836i);
            }
            progressDialog.m3325f(this.f3827a.f3840m);
            progressDialog.m3319a(this.f3827a.f3838k);
            if (this.f3827a.f3838k) {
                progressDialog.m3322c(this.f3827a.f3839l);
                progressDialog.m3316a(this.f3827a.f3841n);
            }
            if (this.f3827a.f3837j) {
                progressDialog.m2969a(-2, progressDialog.getContext().getText(17039360), this);
                progressDialog.setCancelable(true);
            } else {
                progressDialog.m2969a(-2, null, (OnClickListener) null);
                progressDialog.setCancelable(false);
            }
            return progressDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            onCancel(dialogInterface);
        }
    }

    static {
        f3828a = new LinkedHashMap();
    }

    public ProgressDialogListener m5594a(boolean z) {
        this.f3838k = z;
        return this;
    }

    public ProgressDialogListener m5593a(int i) {
        this.f3839l = i;
        return this;
    }

    public void m5595a(TaskManager taskManager, Task<?> task) {
        this.f3830c = new WeakReference(task);
        try {
            String str = "ProgressDialogListener@" + hashCode();
            f3828a.put(str, this);
            this.f3831d = new ProgressDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ProgressDialogListener", str);
            this.f3831d.setArguments(bundle);
            this.f3831d.show(this.f3829b, str);
        } catch (Throwable e) {
            Log.w("ProgressDialogListener", "cannot show dialog", e);
            this.f3831d = null;
            this.f3829b = null;
            task.m5472a((Listener) this);
        }
    }

    public void m5596a(TaskManager taskManager, Task<?> task, int i, int i2) {
        ProgressDialogFragment progressDialogFragment = this.f3831d;
        if (i >= 0) {
            if (this.f3838k) {
                m5594a(false);
                if (progressDialogFragment != null) {
                    progressDialogFragment.m5591a(this.f3838k);
                }
            }
            if (this.f3839l != i) {
                m5593a(i);
                if (progressDialogFragment != null) {
                    progressDialogFragment.m5592b(this.f3839l);
                }
            }
            if (this.f3841n != i2) {
                this.f3841n = i2;
                if (progressDialogFragment != null) {
                    progressDialogFragment.m5590a(this.f3841n);
                }
            }
        } else if (!this.f3838k) {
            m5594a(true);
            if (progressDialogFragment != null) {
                progressDialogFragment.m5591a(this.f3838k);
            }
        }
    }

    public void m5597c(TaskManager taskManager, Task<?> task) {
        if (this.f3831d != null) {
            this.f3831d.dismiss();
        }
        f3828a.remove("ProgressDialogListener@" + hashCode());
    }
}
