package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.C4021R;
import java.lang.reflect.Method;

public class RegisterView extends ResizeLayout {
    private TitleLayout f3190a;
    private RelativeLayout f3191b;
    private WebView f3192c;
    private TextView f3193d;

    /* renamed from: cn.sharesdk.framework.authorize.RegisterView.1 */
    class C09341 implements OnClickListener {
        final /* synthetic */ RegisterView f3186a;

        C09341(RegisterView registerView) {
            this.f3186a = registerView;
        }

        public void onClick(View view) {
            try {
                int stringRes = C4021R.getStringRes(view.getContext(), "ssdk_website");
                Object obj = null;
                if (stringRes > 0) {
                    obj = view.getResources().getString(stringRes);
                }
                if (!TextUtils.isEmpty(obj)) {
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(obj)));
                }
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.authorize.RegisterView.2 */
    class C09352 extends WebChromeClient {
        final /* synthetic */ int f3187a;
        final /* synthetic */ RegisterView f3188b;

        C09352(RegisterView registerView, int i) {
            this.f3188b = registerView;
            this.f3187a = i;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            LayoutParams layoutParams = (LayoutParams) this.f3188b.f3193d.getLayoutParams();
            layoutParams.width = (this.f3187a * i) / 100;
            this.f3188b.f3193d.setLayoutParams(layoutParams);
            if (i <= 0 || i >= 100) {
                this.f3188b.f3193d.setVisibility(8);
            } else {
                this.f3188b.f3193d.setVisibility(0);
            }
        }
    }

    public RegisterView(Context context) {
        super(context);
        m4110a(context);
    }

    public RegisterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4110a(context);
    }

    private void m4110a(Context context) {
        int bitmapRes;
        setBackgroundColor(-1);
        setOrientation(1);
        int b = m4111b(context);
        this.f3190a = new TitleLayout(context);
        try {
            bitmapRes = C4021R.getBitmapRes(context, "ssdk_auth_title_back");
            if (bitmapRes > 0) {
                this.f3190a.setBackgroundResource(bitmapRes);
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        this.f3190a.getBtnRight().setVisibility(8);
        bitmapRes = C4021R.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
        if (bitmapRes > 0) {
            this.f3190a.getTvTitle().setText(bitmapRes);
        }
        addView(this.f3190a);
        View imageView = new ImageView(context);
        int bitmapRes2 = C4021R.getBitmapRes(context, "ssdk_logo");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setPadding(0, 0, C4021R.dipToPx(context, 10), 0);
        imageView.setLayoutParams(new LayoutParams(-2, -1));
        imageView.setOnClickListener(new C09341(this));
        this.f3190a.addView(imageView);
        this.f3191b = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.f3191b.setLayoutParams(layoutParams);
        addView(this.f3191b);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f3191b.addView(linearLayout);
        this.f3193d = new TextView(context);
        this.f3193d.setLayoutParams(new LayoutParams(-1, 5));
        this.f3193d.setBackgroundColor(-12929302);
        linearLayout.addView(this.f3193d);
        this.f3193d.setVisibility(8);
        this.f3192c = new WebView(context);
        layoutParams = new LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.f3192c.setLayoutParams(layoutParams);
        WebChromeClient c09352 = new C09352(this, b);
        if (VERSION.SDK_INT > 10 && VERSION.SDK_INT < 17) {
            try {
                Method method = this.f3192c.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});
                method.setAccessible(true);
                method.invoke(this.f3192c, new Object[]{"searchBoxJavaBridge_"});
            } catch (Throwable th2) {
                C0979d.m4390a().m4376d(th2);
            }
        }
        this.f3192c.setWebChromeClient(c09352);
        linearLayout.addView(this.f3192c);
        this.f3192c.requestFocus();
    }

    private int m4111b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(context instanceof Activity)) {
            return 0;
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        if (windowManager == null) {
            return 0;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public View m4112a() {
        return this.f3190a.getBtnBack();
    }

    public void m4113a(boolean z) {
        this.f3190a.setVisibility(z ? 8 : 0);
    }

    public WebView m4114b() {
        return this.f3192c;
    }

    public TitleLayout m4115c() {
        return this.f3190a;
    }

    public RelativeLayout m4116d() {
        return this.f3191b;
    }
}
