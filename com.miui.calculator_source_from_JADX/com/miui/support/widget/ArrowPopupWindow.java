package com.miui.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Widget_PopupWindow_class.Factory;
import com.miui.support.internal.widget.ArrowPopupView;
import com.miui.support.util.AttributeResolver;

public class ArrowPopupWindow extends PopupWindow {
    protected ArrowPopupView f3974a;
    private Context f3975b;
    private int f3976c;

    public ArrowPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ArrowPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3975b = context;
        m5686e();
    }

    public Context m5688a() {
        return this.f3975b;
    }

    private void m5686e() {
        this.f3976c = this.f3975b.getResources().getDimensionPixelOffset(C0264R.dimen.arrow_popup_window_list_max_height);
        this.f3974a = (ArrowPopupView) m5692b().inflate(C0264R.layout.arrow_popup_view, null, false);
        super.setContentView(this.f3974a);
        super.setWidth(-1);
        super.setHeight(-1);
        setSoftInputMode(3);
        this.f3974a.setArrowPopupWindow(this);
        super.setTouchInterceptor(m5694d());
        m5693c();
        update();
    }

    protected LayoutInflater m5692b() {
        return LayoutInflater.from(this.f3975b);
    }

    protected void m5693c() {
    }

    public final void setContentView(View view) {
        this.f3974a.setContentView(view);
    }

    public View getContentView() {
        return this.f3974a.getContentView();
    }

    public void m5689a(View view, int i, int i2) {
        m5685a(view);
        this.f3974a.setAnchor(view);
        this.f3974a.m4783a(i, i2);
        Factory.getInstance().get().setLayoutInScreenEnabled(this, m5687f());
        showAtLocation(view, 8388659, 0, 0);
        this.f3974a.m4782a();
    }

    private boolean m5687f() {
        if (m5688a().getResources().getInteger(C0264R.integer.window_translucent_status) == 0 || AttributeResolver.m5317a(m5688a(), C0264R.attr.windowTranslucentStatus, 0) == 0) {
            return false;
        }
        return true;
    }

    public void showAsDropDown(View view, int i, int i2) {
        m5689a(view, i, i2);
    }

    private void m5685a(View view) {
        View rootView = view.getRootView();
        if (rootView != null && (rootView.getLayoutParams() instanceof LayoutParams) && ((LayoutParams) rootView.getLayoutParams()).type != 1) {
            this.f3974a.setBackgroundColor(0);
        }
    }

    public void m5691a(boolean z) {
        if (z) {
            this.f3974a.m4786b();
        } else {
            dismiss();
        }
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        m5689a(view, i, i2);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        super.update(0, 0, -1, -1, z);
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.f3974a.setTouchInterceptor(onTouchListener);
    }

    public int getWidth() {
        View contentView = getContentView();
        if (contentView != null) {
            return contentView.getWidth();
        }
        return 0;
    }

    public void setWidth(int i) {
        View contentView = getContentView();
        if (contentView != null) {
            ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            layoutParams.width = i;
            contentView.setLayoutParams(layoutParams);
        }
    }

    public int getHeight() {
        View contentView = getContentView();
        if (contentView != null) {
            return contentView.getHeight();
        }
        return 0;
    }

    public void setHeight(int i) {
        View contentView = getContentView();
        if ((contentView instanceof ListView) && i > this.f3976c) {
            i = this.f3976c;
        }
        if (contentView != null) {
            ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            layoutParams.height = i;
            contentView.setLayoutParams(layoutParams);
        }
    }

    public void m5690a(CharSequence charSequence) {
        this.f3974a.setTitle(charSequence);
    }

    public OnTouchListener m5694d() {
        return this.f3974a;
    }
}
