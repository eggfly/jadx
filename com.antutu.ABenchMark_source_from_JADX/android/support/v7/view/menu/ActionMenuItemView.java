package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0439m.C0436a;
import android.support.v7.view.menu.C0447f.C0438b;
import android.support.v7.widget.ActionMenuView.C0437a;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.aa;
import android.support.v7.widget.ap;
import android.support.v7.widget.ap.C0433b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends aa implements C0436a, C0437a, OnClickListener, OnLongClickListener {
    private C0450h f1137a;
    private CharSequence f1138b;
    private Drawable f1139c;
    private C0438b f1140d;
    private C0433b f1141e;
    private C0435b f1142f;
    private boolean f1143g;
    private boolean f1144h;
    private int f1145i;
    private int f1146j;
    private int f1147k;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView.a */
    private class C0434a extends C0433b {
        final /* synthetic */ ActionMenuItemView f1133a;

        public C0434a(ActionMenuItemView actionMenuItemView) {
            this.f1133a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public ap m1307a() {
            return this.f1133a.f1142f != null ? this.f1133a.f1142f.m1309a() : null;
        }

        protected boolean m1308b() {
            if (this.f1133a.f1140d == null || !this.f1133a.f1140d.m1323a(this.f1133a.f1137a)) {
                return false;
            }
            ap a = m1307a();
            return a != null && a.m2371k();
        }
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView.b */
    public static abstract class C0435b {
        public abstract ap m1309a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1143g = resources.getBoolean(C0417R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.ActionMenuItemView, i, 0);
        this.f1145i = obtainStyledAttributes.getDimensionPixelSize(C0417R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1147k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1146j = -1;
    }

    private void m1317e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1138b) ? 1 : 0;
        if (this.f1139c == null || (this.f1137a.m1458l() && (this.f1143g || this.f1144h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1138b : null);
    }

    public void m1318a(C0450h c0450h, int i) {
        this.f1137a = c0450h;
        setIcon(c0450h.getIcon());
        setTitle(c0450h.m1438a((C0436a) this));
        setId(c0450h.getItemId());
        setVisibility(c0450h.isVisible() ? 0 : 8);
        setEnabled(c0450h.isEnabled());
        if (c0450h.hasSubMenu() && this.f1141e == null) {
            this.f1141e = new C0434a(this);
        }
    }

    public boolean m1319a() {
        return true;
    }

    public boolean m1320b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean m1321c() {
        return m1320b() && this.f1137a.getIcon() == null;
    }

    public boolean m1322d() {
        return m1320b();
    }

    public C0450h getItemData() {
        return this.f1137a;
    }

    public void onClick(View view) {
        if (this.f1140d != null) {
            this.f1140d.m1323a(this.f1137a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1143g = getContext().getResources().getBoolean(C0417R.bool.abc_config_allowActionMenuItemTextWithIcon);
        m1317e();
    }

    public boolean onLongClick(View view) {
        if (m1320b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ViewCompat.getLayoutDirection(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1137a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m1320b();
        if (b && this.f1146j >= 0) {
            super.setPadding(this.f1146j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == LinearLayoutManager.INVALID_OFFSET ? Math.min(size, this.f1145i) : this.f1145i;
        if (mode != 1073741824 && this.f1145i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1139c != null) {
            super.setPadding((getMeasuredWidth() - this.f1139c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1137a.hasSubMenu() && this.f1141e != null && this.f1141e.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1144h != z) {
            this.f1144h = z;
            if (this.f1137a != null) {
                this.f1137a.m1453g();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1139c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1147k) {
                f = ((float) this.f1147k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1147k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1147k) {
                f = ((float) this.f1147k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1147k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1317e();
    }

    public void setItemInvoker(C0438b c0438b) {
        this.f1140d = c0438b;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1146j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0435b c0435b) {
        this.f1142f = c0435b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1138b = charSequence;
        setContentDescription(this.f1138b);
        m1317e();
    }
}
