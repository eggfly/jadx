package com.antutu.redacc.p069c;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.antutu.redacc.C1692R;

/* renamed from: com.antutu.redacc.c.d */
public class C1731d extends DialogFragment {
    protected Activity f6137a;
    private Button f6138b;
    private Button f6139c;

    /* renamed from: com.antutu.redacc.c.d.1 */
    class C17291 implements OnClickListener {
        final /* synthetic */ C1731d f6135a;

        C17291(C1731d c1731d) {
            this.f6135a = c1731d;
        }

        public void onClick(View view) {
            this.f6135a.getDialog().dismiss();
        }
    }

    /* renamed from: com.antutu.redacc.c.d.2 */
    class C17302 implements OnClickListener {
        final /* synthetic */ C1731d f6136a;

        C17302(C1731d c1731d) {
            this.f6136a = c1731d;
        }

        public void onClick(View view) {
            Context context = this.f6136a.f6137a;
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putBoolean("show_tips_ex", false);
            edit.apply();
            Intent intent = new Intent();
            intent.setAction("MSG_BR_ON_DLG_OPT_CLICK");
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            this.f6136a.getDialog().dismiss();
        }
    }

    public static void m6693a(Activity activity) {
        C1731d c1731d = new C1731d();
        c1731d.setCancelable(false);
        c1731d.show(activity.getFragmentManager(), "TipsDialog");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6137a = getActivity();
        setStyle(0, 16974130);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().setTitle(C1692R.string.tips_new);
        getDialog().setCanceledOnTouchOutside(false);
        View inflate = layoutInflater.inflate(C1692R.layout.fragment_tips, viewGroup, false);
        this.f6138b = (Button) inflate.findViewById(C1692R.id.cancel);
        this.f6139c = (Button) inflate.findViewById(C1692R.id.ok);
        this.f6138b.setOnClickListener(new C17291(this));
        this.f6139c.setOnClickListener(new C17302(this));
        return inflate;
    }
}
