package com.miui.support.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.view.menu.MenuBuilder.ItemInvoker;
import com.miui.support.internal.view.menu.MenuView.ItemView;
import com.miui.support.util.AttributeResolver;

public class ListMenuItemView extends LinearLayout implements ItemView {
    private MenuItemImpl f2701a;
    private ImageView f2702b;
    private RadioButton f2703c;
    private TextView f2704d;
    private CheckBox f2705e;
    private TextView f2706f;
    private View f2707g;
    private Drawable f2708h;
    private int f2709i;
    private Context f2710j;
    private boolean f2711k;
    private Context f2712l;
    private LayoutInflater f2713m;
    private boolean f2714n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f2712l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.MenuView, i, 0);
        this.f2708h = obtainStyledAttributes.getDrawable(C0234R.styleable.MenuView_android_itemBackground);
        this.f2709i = obtainStyledAttributes.getResourceId(C0234R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f2711k = obtainStyledAttributes.getBoolean(C0264R.styleable.MenuView_android_preserveIconSpacing, false);
        this.f2710j = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f2708h);
        this.f2704d = (TextView) findViewById(C0264R.id.title);
        if (this.f2709i != -1) {
            this.f2704d.setTextAppearance(this.f2710j, this.f2709i);
        }
        this.f2706f = (TextView) findViewById(C0264R.id.shortcut);
        this.f2707g = getChildAt(0);
    }

    public void m4467a(MenuItemImpl menuItemImpl, int i) {
        this.f2701a = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m4484a((ItemView) this));
        setCheckable(menuItemImpl.isCheckable());
        m4468a(menuItemImpl.m4496e(), menuItemImpl.m4491c());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f2714n = z;
        this.f2711k = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2704d.setText(charSequence);
            if (this.f2704d.getVisibility() != 0) {
                this.f2704d.setVisibility(0);
            }
        } else if (this.f2704d.getVisibility() != 8) {
            this.f2704d.setVisibility(8);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f2701a;
    }

    public void setCheckable(boolean z) {
        int i = 0;
        if (z || this.f2703c != null || this.f2705e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f2701a.m4497f()) {
                if (this.f2703c == null) {
                    m4465c();
                }
                compoundButton = this.f2703c;
                compoundButton2 = this.f2705e;
            } else {
                if (this.f2705e == null) {
                    m4466d();
                }
                compoundButton = this.f2705e;
                compoundButton2 = this.f2703c;
            }
            if (z) {
                compoundButton.setChecked(this.f2701a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility() == 8)) {
                    compoundButton2.setVisibility(8);
                }
            } else {
                if (this.f2705e != null) {
                    this.f2705e.setVisibility(8);
                }
                if (this.f2703c != null) {
                    this.f2703c.setVisibility(8);
                }
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f2707g.getLayoutParams();
            if (!(z && this.f2701a.m4497f())) {
                i = AttributeResolver.m5324e(getContext(), 16843683);
            }
            marginLayoutParams.setMarginStart(i);
            this.f2707g.setLayoutParams(marginLayoutParams);
            setActivated(this.f2701a.isChecked());
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2701a.m4497f()) {
            if (this.f2703c == null) {
                m4465c();
            }
            compoundButton = this.f2703c;
        } else {
            if (this.f2705e == null) {
                m4466d();
            }
            compoundButton = this.f2705e;
        }
        compoundButton.setChecked(z);
        setActivated(z);
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        throw new UnsupportedOperationException();
    }

    public void m4468a(boolean z, char c) {
        int i = (z && this.f2701a.m4496e()) ? 0 : 8;
        if (i == 0) {
            this.f2706f.setText(this.f2701a.m4493d());
        }
        if (this.f2706f.getVisibility() != i) {
            this.f2706f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f2701a.m4498g() || this.f2714n) ? 1 : 0;
        if (i == 0 && !this.f2711k) {
            return;
        }
        if (this.f2702b != null || drawable != null || this.f2711k) {
            if (this.f2702b == null) {
                m4464b();
            }
            if (drawable != null || this.f2711k) {
                ImageView imageView = this.f2702b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f2702b.getVisibility() != 0) {
                    this.f2702b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f2702b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f2702b != null && this.f2711k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2702b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m4464b() {
        this.f2702b = (ImageView) getInflater().inflate(C0264R.layout.list_menu_item_icon, this, false);
        addView(this.f2702b, 0);
    }

    private void m4465c() {
        this.f2703c = (RadioButton) getInflater().inflate(C0264R.layout.list_menu_item_radio, this, false);
        addView(this.f2703c, 0);
    }

    private void m4466d() {
        this.f2705e = (CheckBox) getInflater().inflate(C0264R.layout.list_menu_item_checkbox, this, false);
        addView(this.f2705e);
    }

    public boolean m4469a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f2713m == null) {
            this.f2713m = LayoutInflater.from(this.f2712l);
        }
        return this.f2713m;
    }
}
