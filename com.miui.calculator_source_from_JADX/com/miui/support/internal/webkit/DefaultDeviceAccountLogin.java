package com.miui.support.internal.webkit;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.miui.support.app.ProgressDialog;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.hybrid.provider.AbsWebView;

public class DefaultDeviceAccountLogin extends DeviceAccountLogin {
    private AbsWebView f2837c;
    private Handler f2838d;
    private ProgressDialogFragment f2839e;

    /* renamed from: com.miui.support.internal.webkit.DefaultDeviceAccountLogin.1 */
    class C03671 extends Handler {
        final /* synthetic */ DefaultDeviceAccountLogin f2833a;

        C03671(DefaultDeviceAccountLogin defaultDeviceAccountLogin) {
            this.f2833a = defaultDeviceAccountLogin;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f2833a.m4600e();
            } else if (message.what == 1) {
                this.f2833a.m4601f();
                this.f2833a.f2837c.m4109a(0);
            }
        }
    }

    public static class ProgressDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            Dialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.m3318a(getString(C0264R.string.web_sso_login_message));
            progressDialog.m3319a(true);
            progressDialog.setCancelable(false);
            return progressDialog;
        }
    }

    public DefaultDeviceAccountLogin(Activity activity, AbsWebView absWebView) {
        super(activity);
        this.f2837c = absWebView;
        this.f2838d = new C03671(this);
    }

    private void m4600e() {
        m4601f();
        this.f2839e = new ProgressDialogFragment();
        try {
            this.f2839e.show(this.a.getFragmentManager(), "dialog");
        } catch (IllegalStateException e) {
        }
    }

    private void m4601f() {
        this.f2838d.removeMessages(0);
        if (this.f2839e != null && this.f2839e.isAdded()) {
            this.f2839e.dismissAllowingStateLoss();
        }
        this.f2839e = null;
    }

    public void m4602a() {
        this.f2838d.sendEmptyMessageDelayed(0, 500);
    }

    public void m4603a(String str) {
        this.f2837c.m4113a(str);
    }

    public void m4604b() {
        m4601f();
        this.f2837c.m4109a(0);
        Toast.makeText(this.a, C0264R.string.web_sso_login_fail, 0).show();
    }

    public void m4605c() {
        m4601f();
        this.f2837c.m4109a(0);
    }

    public void m4606d() {
        this.f2838d.sendEmptyMessageDelayed(1, 500);
    }
}
