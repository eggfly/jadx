package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.aide.uidesigner.ProxyTextView;

public class j extends Fragment implements OnCancelListener, OnDismissListener {
    int DW;
    boolean FH;
    boolean Hw;
    boolean VH;
    Dialog Zo;
    boolean gn;
    int j6;
    boolean u7;
    int v5;

    public j() {
        this.j6 = 0;
        this.DW = 0;
        this.FH = true;
        this.Hw = true;
        this.v5 = -1;
    }

    public void j6(n nVar, String str) {
        this.gn = false;
        this.u7 = true;
        q j6 = nVar.j6();
        j6.j6((Fragment) this, str);
        j6.j6();
    }

    void j6(boolean z) {
        if (!this.gn) {
            this.gn = true;
            this.u7 = false;
            if (this.Zo != null) {
                this.Zo.dismiss();
                this.Zo = null;
            }
            this.VH = true;
            if (this.v5 >= 0) {
                tp().j6(this.v5, 1);
                this.v5 = -1;
                return;
            }
            q j6 = tp().j6();
            j6.j6(this);
            if (z) {
                j6.DW();
            } else {
                j6.j6();
            }
        }
    }

    public int j6() {
        return this.DW;
    }

    public void DW(boolean z) {
        this.Hw = z;
    }

    public void j6(Activity activity) {
        super.j6(activity);
        if (!this.u7) {
            this.gn = false;
        }
    }

    public void DW() {
        super.DW();
        if (!this.u7 && !this.gn) {
            this.gn = true;
        }
    }

    public void j6(Bundle bundle) {
        super.j6(bundle);
        this.Hw = this.KD == 0;
        if (bundle != null) {
            this.j6 = bundle.getInt("android:style", 0);
            this.DW = bundle.getInt("android:theme", 0);
            this.FH = bundle.getBoolean("android:cancelable", true);
            this.Hw = bundle.getBoolean("android:showsDialog", this.Hw);
            this.v5 = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater DW(Bundle bundle) {
        if (!this.Hw) {
            return super.DW(bundle);
        }
        this.Zo = FH(bundle);
        if (this.Zo == null) {
            return (LayoutInflater) this.P8.VH().getSystemService("layout_inflater");
        }
        j6(this.Zo, this.j6);
        return (LayoutInflater) this.Zo.getContext().getSystemService("layout_inflater");
    }

    public void j6(Dialog dialog, int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog FH(Bundle bundle) {
        return new Dialog(gn(), j6());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.VH) {
            j6(true);
        }
    }

    public void Hw(Bundle bundle) {
        super.Hw(bundle);
        if (this.Hw) {
            View Ws = Ws();
            if (Ws != null) {
                if (Ws.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.Zo.setContentView(Ws);
            }
            this.Zo.setOwnerActivity(gn());
            this.Zo.setCancelable(this.FH);
            this.Zo.setOnCancelListener(this);
            this.Zo.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.Zo.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void FH() {
        super.FH();
        if (this.Zo != null) {
            this.VH = false;
            this.Zo.show();
        }
    }

    public void v5(Bundle bundle) {
        super.v5(bundle);
        if (this.Zo != null) {
            Bundle onSaveInstanceState = this.Zo.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.j6 != 0) {
            bundle.putInt("android:style", this.j6);
        }
        if (this.DW != 0) {
            bundle.putInt("android:theme", this.DW);
        }
        if (!this.FH) {
            bundle.putBoolean("android:cancelable", this.FH);
        }
        if (!this.Hw) {
            bundle.putBoolean("android:showsDialog", this.Hw);
        }
        if (this.v5 != -1) {
            bundle.putInt("android:backStackId", this.v5);
        }
    }

    public void Hw() {
        super.Hw();
        if (this.Zo != null) {
            this.Zo.hide();
        }
    }

    public void v5() {
        super.v5();
        if (this.Zo != null) {
            this.VH = true;
            this.Zo.dismiss();
            this.Zo = null;
        }
    }
}
