package com.antutu.redacc.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.antutu.redacc.C1692R;

/* renamed from: com.antutu.redacc.view.a */
public class C1779a extends Dialog {
    private Context f6286a;
    private OnClickListener f6287b;
    private Button f6288c;
    private Button f6289d;

    /* renamed from: com.antutu.redacc.view.a.1 */
    class C17771 implements OnClickListener {
        final /* synthetic */ C1779a f6284a;

        C17771(C1779a c1779a) {
            this.f6284a = c1779a;
        }

        public void onClick(View view) {
            if (this.f6284a.f6287b != null) {
                this.f6284a.f6287b.onClick(view);
            }
            this.f6284a.dismiss();
        }
    }

    /* renamed from: com.antutu.redacc.view.a.2 */
    class C17782 implements OnClickListener {
        final /* synthetic */ C1779a f6285a;

        C17782(C1779a c1779a) {
            this.f6285a = c1779a;
        }

        public void onClick(View view) {
            this.f6285a.dismiss();
        }
    }

    public C1779a(Context context, int i) {
        super(context, i);
        m6854a(context, i, null);
    }

    private void m6854a(Context context, int i, OnCancelListener onCancelListener) {
        this.f6286a = context;
        setContentView(C1692R.layout.dialog_accelerate_access);
        this.f6288c = (Button) findViewById(C1692R.id.btn_next_continue);
        this.f6289d = (Button) findViewById(C1692R.id.btn_accelerate);
        this.f6289d.setOnClickListener(new C17771(this));
        this.f6288c.setOnClickListener(new C17782(this));
    }

    public void m6855a(OnClickListener onClickListener) {
        this.f6287b = onClickListener;
    }
}
