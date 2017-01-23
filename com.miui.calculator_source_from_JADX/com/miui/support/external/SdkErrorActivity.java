package com.miui.support.external;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.miui.support.external.SdkConstants.SdkError;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SdkErrorActivity extends Activity implements SdkConstants {
    private String f2000a;
    private OnClickListener f2001b;
    private OnClickListener f2002c;

    /* renamed from: com.miui.support.external.SdkErrorActivity.1 */
    class C02461 implements OnClickListener {
        final /* synthetic */ SdkErrorActivity f1993a;

        C02461(SdkErrorActivity sdkErrorActivity) {
            this.f1993a = sdkErrorActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f1993a.finish();
            System.exit(0);
        }
    }

    /* renamed from: com.miui.support.external.SdkErrorActivity.2 */
    class C02482 implements OnClickListener {
        final /* synthetic */ SdkErrorActivity f1996a;

        /* renamed from: com.miui.support.external.SdkErrorActivity.2.1 */
        class C02471 extends AsyncTask<Void, Void, Boolean> {
            final /* synthetic */ Dialog f1994a;
            final /* synthetic */ C02482 f1995b;

            C02471(C02482 c02482, Dialog dialog) {
                this.f1995b = c02482;
                this.f1994a = dialog;
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m3447a((Void[]) objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m3448a((Boolean) obj);
            }

            protected Boolean m3447a(Void... voidArr) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Boolean.valueOf(this.f1995b.f1996a.m3462h());
            }

            protected void m3448a(Boolean bool) {
                this.f1994a.dismiss();
                new SdkDialogFragment(this.f1995b.f1996a, bool.booleanValue() ? this.f1995b.f1996a.m3459e() : this.f1995b.f1996a.m3460f()).show(this.f1995b.f1996a.getFragmentManager(), "SdkUpdateFinishDialog");
            }
        }

        C02482(SdkErrorActivity sdkErrorActivity) {
            this.f1996a = sdkErrorActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            Dialog a = this.f1996a.m3457d();
            new SdkDialogFragment(this.f1996a, a).show(this.f1996a.getFragmentManager(), "SdkUpdatePromptDialog");
            new C02471(this, a).execute(new Void[0]);
        }
    }

    /* renamed from: com.miui.support.external.SdkErrorActivity.3 */
    /* synthetic */ class C02493 {
        static final /* synthetic */ int[] f1997a;

        static {
            f1997a = new int[SdkError.values().length];
            try {
                f1997a[SdkError.NO_SDK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1997a[SdkError.LOW_SDK_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    class SdkDialogFragment extends DialogFragment {
        final /* synthetic */ SdkErrorActivity f1998a;
        private Dialog f1999b;

        public SdkDialogFragment(SdkErrorActivity sdkErrorActivity, Dialog dialog) {
            this.f1998a = sdkErrorActivity;
            this.f1999b = dialog;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return this.f1999b;
        }
    }

    public SdkErrorActivity() {
        this.f2001b = new C02461(this);
        this.f2002c = new C02482(this);
    }

    protected void onCreate(Bundle bundle) {
        Dialog b;
        setTheme(16973909);
        super.onCreate(bundle);
        this.f2000a = Locale.getDefault().getLanguage();
        SdkError sdkError = null;
        Intent intent = getIntent();
        if (intent != null) {
            sdkError = (SdkError) intent.getSerializableExtra("com.miui.sdk.error");
        }
        if (sdkError == null) {
            sdkError = SdkError.GENERIC;
        }
        switch (C02493.f1997a[sdkError.ordinal()]) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                b = m3453b();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                b = m3455c();
                break;
            default:
                b = m3449a();
                break;
        }
        new SdkDialogFragment(this, b).show(getFragmentManager(), "SdkErrorPromptDialog");
    }

    private Dialog m3451a(String str, String str2, OnClickListener onClickListener) {
        return new Builder(this).setTitle(str).setMessage(str2).setPositiveButton(17039370, onClickListener).setIcon(17301543).setCancelable(false).create();
    }

    private Dialog m3452a(String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return new Builder(this).setTitle(str).setMessage(str2).setPositiveButton(17039370, onClickListener).setNegativeButton(17039360, onClickListener2).setIcon(17301543).setCancelable(false).create();
    }

    private Dialog m3449a() {
        String str;
        String str2;
        if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
            str = "MIUI SDK\u53d1\u751f\u9519\u8bef";
            str2 = "\u8bf7\u91cd\u65b0\u5b89\u88c5MIUI SDK\u518d\u8fd0\u884c\u672c\u7a0b\u5e8f\u3002";
        } else {
            str = "MIUI SDK encounter errors";
            str2 = "Please re-install MIUI SDK and then re-run this application.";
        }
        return m3451a(str, str2, this.f2001b);
    }

    private Dialog m3453b() {
        String str;
        String str2;
        if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
            str = "\u6ca1\u6709\u627e\u5230MIUI SDK";
            str2 = "\u8bf7\u5148\u5b89\u88c5MIUI SDK\u518d\u8fd0\u884c\u672c\u7a0b\u5e8f\u3002";
        } else {
            str = "MIUI SDK not found";
            str2 = "Please install MIUI SDK and then re-run this application.";
        }
        return m3451a(str, str2, this.f2001b);
    }

    private Dialog m3455c() {
        String str;
        String str2;
        if (m3461g()) {
            if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
                str = "MIUI SDK\u7248\u672c\u8fc7\u4f4e";
                str2 = "\u8bf7\u5148\u5347\u7ea7MIUI SDK\u518d\u8fd0\u884c\u672c\u7a0b\u5e8f\u3002\u662f\u5426\u73b0\u5728\u5347\u7ea7\uff1f";
            } else {
                str = "MIUI SDK too old";
                str2 = "Please upgrade MIUI SDK and then re-run this application. Upgrade now?";
            }
            return m3452a(str, str2, this.f2002c, this.f2001b);
        }
        if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
            str = "MIUI SDK\u7248\u672c\u8fc7\u4f4e";
            str2 = "\u8bf7\u5148\u5347\u7ea7MIUI SDK\u518d\u8fd0\u884c\u672c\u7a0b\u5e8f\u3002";
        } else {
            str = "MIUI SDK too old";
            str2 = "Please upgrade MIUI SDK and then re-run this application.";
        }
        return m3451a(str, str2, this.f2001b);
    }

    private Dialog m3457d() {
        CharSequence charSequence;
        CharSequence charSequence2;
        if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
            charSequence = "MIUI SDK\u6b63\u5728\u66f4\u65b0";
            charSequence2 = "\u8bf7\u7a0d\u5019...";
        } else {
            charSequence = "MIUI SDK updating";
            charSequence2 = "Please wait...";
        }
        return ProgressDialog.show(this, charSequence, charSequence2, true, false);
    }

    private Dialog m3459e() {
        String str;
        String str2;
        if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
            str = "MIUI SDK\u66f4\u65b0\u5b8c\u6210";
            str2 = "\u8bf7\u91cd\u65b0\u8fd0\u884c\u672c\u7a0b\u5e8f\u3002";
        } else {
            str = "MIUI SDK updated";
            str2 = "Please re-run this application.";
        }
        return m3451a(str, str2, this.f2001b);
    }

    private Dialog m3460f() {
        String str;
        String str2;
        if (Locale.CHINESE.getLanguage().equals(this.f2000a)) {
            str = "MIUI SDK\u66f4\u65b0\u5931\u8d25";
            str2 = "\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
        } else {
            str = "MIUI SDK update failed";
            str2 = "Please try it later.";
        }
        return m3451a(str, str2, this.f2001b);
    }

    private boolean m3461g() {
        try {
            return ((Boolean) SdkEntranceHelper.m3446a().getMethod("supportUpdate", new Class[]{Map.class}).invoke(null, new Object[]{null})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean m3462h() {
        try {
            HashMap hashMap = new HashMap();
            return ((Boolean) SdkEntranceHelper.m3446a().getMethod("update", new Class[]{Map.class}).invoke(null, new Object[]{hashMap})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
