package com.antutu.benchmark.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

/* renamed from: com.antutu.benchmark.view.l */
public class C1682l extends Dialog {
    private Context f6012a;
    private String f6013b;
    private TextView f6014c;

    /* renamed from: com.antutu.benchmark.view.l.a */
    public static class C1681a {
        private Context f6010a;
        private String f6011b;

        public C1681a(Context context) {
            this.f6010a = context;
        }

        public C1681a m6589a(String str) {
            this.f6011b = str;
            return this;
        }

        public C1682l m6590a() {
            C1682l c1682l = new C1682l(this.f6010a, C1082R.style.DialogTheme);
            c1682l.requestWindowFeature(1);
            c1682l.setContentView(C1082R.layout.dialog_loading);
            if (this.f6011b != null) {
                c1682l.m6592a(this.f6011b);
            }
            return c1682l;
        }
    }

    public C1682l(Context context, int i) {
        super(context, i);
        this.f6012a = context;
    }

    private void m6591a() {
        this.f6014c = (TextView) findViewById(C1082R.id.tv_text);
        if (this.f6013b != null) {
            this.f6014c.setText(this.f6013b);
        }
    }

    public void m6592a(String str) {
        this.f6013b = str;
        if (this.f6014c != null) {
            this.f6014c.setText(str);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6591a();
    }
}
