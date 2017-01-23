package com.antutu.redacc.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1744a;
import com.antutu.redacc.view.CircleCleanView.C1776a;

/* renamed from: com.antutu.redacc.view.b */
public class C1780b implements OnClickListener {
    private Context f6290a;
    private View f6291b;
    private TextView f6292c;
    private TextView f6293d;
    private CircleCleanView f6294e;
    private LinearLayout f6295f;
    private Button f6296g;
    private C1703a f6297h;
    private boolean f6298i;

    /* renamed from: com.antutu.redacc.view.b.a */
    public interface C1703a {
        void m6614a();
    }

    public C1780b(Context context) {
        this.f6298i = false;
        this.f6290a = context;
    }

    public void m6856a() {
        try {
            this.f6291b = ((LayoutInflater) this.f6290a.getSystemService("layout_inflater")).inflate(C1692R.layout.view_float_accelerator, null);
            this.f6293d = (TextView) this.f6291b.findViewById(C1692R.id.tips_text);
            this.f6292c = (TextView) this.f6291b.findViewById(C1692R.id.tv_apps_count);
            this.f6294e = (CircleCleanView) this.f6291b.findViewById(C1692R.id.progress);
            this.f6294e.m6850a(C1776a.Progressing);
            this.f6295f = (LinearLayout) this.f6291b.findViewById(C1692R.id.cleaning_finish_view);
            this.f6296g = (Button) this.f6291b.findViewById(C1692R.id.cleaning_finish_btn);
            this.f6296g.setOnClickListener(this);
            this.f6295f.setVisibility(8);
            WindowManager windowManager = (WindowManager) this.f6290a.getApplicationContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2005;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.width = -1;
            layoutParams.height = -1;
            windowManager.addView(this.f6291b, layoutParams);
            C1744a.m6735a(this.f6290a, 1);
        } catch (Exception e) {
        }
    }

    public void m6857a(C1703a c1703a) {
        this.f6297h = c1703a;
    }

    public void m6858a(String str) {
        try {
            this.f6293d.setText(C1692R.string.acceleratoring_phone);
            this.f6292c.setText(str);
        } catch (Exception e) {
        }
    }

    public void m6859b() {
        this.f6294e.m6850a(C1776a.Success);
        this.f6292c.setVisibility(8);
        this.f6293d.setText(C1692R.string.accelerate_finished);
        this.f6298i = true;
        this.f6295f.setVisibility(0);
    }

    public void m6860c() {
        if (!this.f6298i) {
            try {
                if (this.f6291b != null) {
                    ((WindowManager) this.f6290a.getSystemService("window")).removeView(this.f6291b);
                    this.f6291b = null;
                }
            } catch (Exception e) {
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == C1692R.id.cleaning_finish_btn) {
            try {
                if (this.f6297h != null) {
                    this.f6297h.m6614a();
                }
                if (this.f6291b != null) {
                    ((WindowManager) this.f6290a.getSystemService("window")).removeView(this.f6291b);
                    this.f6291b = null;
                }
                C1744a.m6735a(this.f6290a, 2);
            } catch (Exception e) {
            }
            this.f6298i = false;
        }
    }
}
