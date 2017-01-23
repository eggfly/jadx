package com.miui.support.widget;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class SimpleDialogFragment extends DialogFragment {
    private String f4441a;
    private boolean f4442b;
    private String f4443c;
    private int f4444d;
    private int f4445e;
    private int f4446f;
    private OnClickListener f4447g;
    private OnClickListener f4448h;
    private OnDismissListener f4449i;

    public static final class AlertDialogFragmentBuilder {
    }

    public SimpleDialogFragment() {
        this.f4442b = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            throw new IllegalStateException("no argument");
        }
        this.f4444d = arguments.getInt("type");
        this.f4441a = arguments.getString("msg_res_id");
        this.f4443c = arguments.getString("title");
        this.f4442b = arguments.getBoolean("cancelable", true);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        switch (this.f4444d) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                Builder title = new Builder(getActivity()).setMessage(this.f4441a).setCancelable(this.f4442b).setTitle(this.f4443c);
                if (this.f4445e > 0) {
                    title.setPositiveButton(this.f4445e, this.f4447g);
                }
                if (this.f4446f > 0) {
                    title.setNegativeButton(this.f4446f, this.f4448h);
                }
                return title.create();
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                Dialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage(this.f4441a);
                progressDialog.setCancelable(this.f4442b);
                return progressDialog;
            default:
                throw new IllegalStateException("unknown dialog type:" + this.f4444d);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f4449i != null) {
            this.f4449i.onDismiss(dialogInterface);
        }
    }
}
