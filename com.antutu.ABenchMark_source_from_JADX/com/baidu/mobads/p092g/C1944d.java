package com.baidu.mobads.p092g;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.antutu.utils.widget.SystemBarTintManager;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.g.d */
public class C1944d extends LinearLayout {
    protected C1943b f6792a;
    private Context f6793b;
    private IXAdCommonUtils f6794c;

    /* renamed from: com.baidu.mobads.g.d.a */
    class C1942a extends TextView {
        final /* synthetic */ C1944d f6791a;

        public C1942a(C1944d c1944d, Context context, String str) {
            this.f6791a = c1944d;
            super(context);
            m7282a(str);
        }

        private void m7282a(String str) {
            setText(str);
            setTextColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
            setGravity(17);
            setBackgroundColor(-1);
            setTextSize(19.0f);
            setLayoutParams(new LayoutParams(-1, this.f6791a.f6794c.getPixel(this.f6791a.f6793b, 50)));
        }
    }

    /* renamed from: com.baidu.mobads.g.d.b */
    public interface C1943b {
        void m7283a();

        void m7284b();

        void m7285c();
    }

    public C1944d(Context context) {
        super(context);
        this.f6793b = context;
        setBackgroundColor(-2236963);
        this.f6794c = C1991m.m7449a().m7464m();
        setOrientation(1);
        View c1942a = new C1942a(this, context, "\u5237\u65b0");
        LayoutParams layoutParams = (LayoutParams) c1942a.getLayoutParams();
        layoutParams.bottomMargin = this.f6794c.getPixel(this.f6793b, 2);
        addView(c1942a, layoutParams);
        View c1942a2 = new C1942a(this, context, "\u590d\u5236\u7f51\u5740");
        layoutParams = (LayoutParams) c1942a2.getLayoutParams();
        layoutParams.bottomMargin = this.f6794c.getPixel(this.f6793b, 4);
        addView(c1942a2, layoutParams);
        View c1942a3 = new C1942a(this, context, "\u53d6\u6d88");
        addView(c1942a3);
        c1942a.setOnClickListener(new C1945e(this));
        c1942a2.setOnClickListener(new C1946f(this));
        c1942a3.setOnClickListener(new C1947g(this));
    }

    public void m7288a(C1943b c1943b) {
        this.f6792a = c1943b;
    }
}
