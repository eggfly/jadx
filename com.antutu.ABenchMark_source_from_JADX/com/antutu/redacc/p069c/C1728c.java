package com.antutu.redacc.p069c;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1762r;

/* renamed from: com.antutu.redacc.c.c */
public class C1728c extends DialogFragment {
    protected Activity f6133a;
    Handler f6134b;

    /* renamed from: com.antutu.redacc.c.c.1 */
    class C17261 extends Thread {
        final /* synthetic */ Context f6130a;
        final /* synthetic */ C1728c f6131b;

        C17261(C1728c c1728c, Context context) {
            this.f6131b = c1728c;
            this.f6130a = context;
        }

        public void run() {
            try {
                C1762r.m6776e().m6807i();
                Editor edit;
                if (C1762r.m6776e().m6791a()) {
                    edit = PreferenceManager.getDefaultSharedPreferences(this.f6131b.getActivity()).edit();
                    edit.putBoolean("show_tips", false);
                    edit.apply();
                    this.f6131b.f6134b.sendEmptyMessage(0);
                } else if (VERSION.SDK_INT >= 16) {
                    edit = PreferenceManager.getDefaultSharedPreferences(this.f6130a).edit();
                    edit.putBoolean("show_tips", false);
                    edit.putString("work_mode", "unroot");
                    edit.apply();
                    this.f6131b.f6134b.sendEmptyMessage(1);
                } else {
                    this.f6131b.f6134b.sendEmptyMessage(2);
                }
            } catch (Exception e) {
            }
            super.run();
        }
    }

    /* renamed from: com.antutu.redacc.c.c.2 */
    class C17272 extends Handler {
        final /* synthetic */ C1728c f6132a;

        C17272(C1728c c1728c) {
            this.f6132a = c1728c;
        }

        public void handleMessage(Message message) {
            View view = null;
            if (message.what == 0) {
                this.f6132a.getDialog().dismiss();
            } else if (message.what == 1) {
                View view2;
                try {
                    view = ((LayoutInflater) this.f6132a.f6133a.getSystemService("layout_inflater")).inflate(C1692R.layout.toast_view, null);
                    try {
                        ((TextView) view.findViewById(C1692R.id.info)).setText(String.format(this.f6132a.getString(C1692R.string.accessibility_enable), new Object[]{this.f6132a.getString(C1692R.string.app_name)}));
                        view2 = view;
                    } catch (Exception e) {
                        view2 = view;
                    }
                } catch (Exception e2) {
                    view2 = view;
                }
                C1762r.m6776e().m6786a(this.f6132a.getActivity(), view2);
                C1762r.m6776e().m6811m();
                this.f6132a.getDialog().dismiss();
            } else if (message.what == 2) {
                this.f6132a.getDialog().dismiss();
            }
            super.handleMessage(message);
        }
    }

    public C1728c() {
        this.f6134b = new C17272(this);
    }

    public static void m6692a(Activity activity) {
        C1728c c1728c = new C1728c();
        c1728c.setCancelable(false);
        c1728c.show(activity.getFragmentManager(), "RootDialog");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6133a = getActivity();
        setStyle(0, 16974130);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().setTitle(C1692R.string.app_name);
        getDialog().setCanceledOnTouchOutside(false);
        View inflate = layoutInflater.inflate(C1692R.layout.fragment_root, viewGroup, false);
        new C17261(this, inflate.getContext()).start();
        return inflate;
    }
}
