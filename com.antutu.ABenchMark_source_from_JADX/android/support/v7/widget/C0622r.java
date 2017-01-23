package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.r */
public class C0622r extends PopupWindow {
    private static final boolean f2104a;
    private boolean f2105b;

    /* renamed from: android.support.v7.widget.r.1 */
    static class C06211 implements OnScrollChangedListener {
        final /* synthetic */ Field f2101a;
        final /* synthetic */ PopupWindow f2102b;
        final /* synthetic */ OnScrollChangedListener f2103c;

        C06211(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
            this.f2101a = field;
            this.f2102b = popupWindow;
            this.f2103c = onScrollChangedListener;
        }

        public void onScrollChanged() {
            try {
                WeakReference weakReference = (WeakReference) this.f2101a.get(this.f2102b);
                if (weakReference != null && weakReference.get() != null) {
                    this.f2103c.onScrollChanged();
                }
            } catch (IllegalAccessException e) {
            }
        }
    }

    static {
        f2104a = VERSION.SDK_INT < 21;
    }

    public C0622r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bh a = bh.m2502a(context, attributeSet, C0417R.styleable.PopupWindow, i, 0);
        if (a.m2517f(C0417R.styleable.PopupWindow_overlapAnchor)) {
            m2702a(a.m2507a(C0417R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m2505a(C0417R.styleable.PopupWindow_android_popupBackground));
        a.m2506a();
        if (VERSION.SDK_INT < 14) {
            C0622r.m2701a((PopupWindow) this);
        }
    }

    private static void m2701a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new C06211(declaredField, popupWindow, (OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m2702a(boolean z) {
        if (f2104a) {
            this.f2105b = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2104a && this.f2105b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2104a && this.f2105b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (f2104a && this.f2105b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
