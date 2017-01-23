package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int f164a;
    int f165b;
    boolean f166c;
    boolean f167d;
    int f168e;
    Dialog f169f;
    boolean f170g;
    boolean f171h;
    boolean f172i;

    @Retention(RetentionPolicy.SOURCE)
    private @interface DialogStyle {
    }

    public DialogFragment() {
        this.f164a = 0;
        this.f165b = 0;
        this.f166c = true;
        this.f167d = true;
        this.f168e = -1;
    }

    void m212a(boolean z) {
        if (!this.f171h) {
            this.f171h = true;
            this.f172i = false;
            if (this.f169f != null) {
                this.f169f.dismiss();
                this.f169f = null;
            }
            this.f170g = true;
            if (this.f168e >= 0) {
                m188i().m306a(this.f168e, 1);
                this.f168e = -1;
                return;
            }
            FragmentTransaction a = m188i().m305a();
            a.m88a(this);
            if (z) {
                a.m89b();
            } else {
                a.m86a();
            }
        }
    }

    @StyleRes
    public int m208a() {
        return this.f165b;
    }

    public void m209a(Activity activity) {
        super.m155a(activity);
        if (!this.f172i) {
            this.f171h = false;
        }
    }

    public void m214b() {
        super.m168b();
        if (!this.f172i && !this.f171h) {
            this.f171h = true;
        }
    }

    public void m211a(@Nullable Bundle bundle) {
        super.m160a(bundle);
        this.f167d = this.H == 0;
        if (bundle != null) {
            this.f164a = bundle.getInt("android:style", 0);
            this.f165b = bundle.getInt("android:theme", 0);
            this.f166c = bundle.getBoolean("android:cancelable", true);
            this.f167d = bundle.getBoolean("android:showsDialog", this.f167d);
            this.f168e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater m213b(Bundle bundle) {
        if (!this.f167d) {
            return super.m166b(bundle);
        }
        this.f169f = m215c(bundle);
        if (this.f169f == null) {
            return (LayoutInflater) this.D.m242g().getSystemService("layout_inflater");
        }
        m210a(this.f169f, this.f164a);
        return (LayoutInflater) this.f169f.getContext().getSystemService("layout_inflater");
    }

    public void m210a(Dialog dialog, int i) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    @NonNull
    public Dialog m215c(Bundle bundle) {
        return new Dialog(m184g(), m208a());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f170g) {
            m212a(true);
        }
    }

    public void m218d(Bundle bundle) {
        super.m177d(bundle);
        if (this.f167d) {
            View n = m195n();
            if (n != null) {
                if (n.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f169f.setContentView(n);
            }
            this.f169f.setOwnerActivity(m184g());
            this.f169f.setCancelable(this.f166c);
            this.f169f.setOnCancelListener(this);
            this.f169f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f169f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void m216c() {
        super.m173c();
        if (this.f169f != null) {
            this.f170g = false;
            this.f169f.show();
        }
    }

    public void m220e(Bundle bundle) {
        super.m181e(bundle);
        if (this.f169f != null) {
            Bundle onSaveInstanceState = this.f169f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f164a != 0) {
            bundle.putInt("android:style", this.f164a);
        }
        if (this.f165b != 0) {
            bundle.putInt("android:theme", this.f165b);
        }
        if (!this.f166c) {
            bundle.putBoolean("android:cancelable", this.f166c);
        }
        if (!this.f167d) {
            bundle.putBoolean("android:showsDialog", this.f167d);
        }
        if (this.f168e != -1) {
            bundle.putInt("android:backStackId", this.f168e);
        }
    }

    public void m217d() {
        super.m176d();
        if (this.f169f != null) {
            this.f169f.hide();
        }
    }

    public void m219e() {
        super.m180e();
        if (this.f169f != null) {
            this.f170g = true;
            this.f169f.dismiss();
            this.f169f = null;
        }
    }
}
