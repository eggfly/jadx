package com.miui.support.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.miui.support.internal.view.menu.MenuBuilder.ItemInvoker;
import com.miui.support.internal.view.menu.MenuView.ItemView;

public class ActionMenuItemView extends Button implements ItemView {
    private MenuItemImpl f2603a;
    private ItemInvoker f2604b;
    private boolean f2605c;

    public ActionMenuItemView(Context context) {
        this(context, null, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m4291a(MenuItemImpl menuItemImpl, int i) {
        this.f2603a = menuItemImpl;
        setSelected(false);
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setClickable(true);
    }

    public MenuItemImpl getItemData() {
        return this.f2603a;
    }

    public void setTitle(CharSequence charSequence) {
        setText(charSequence);
    }

    public void setCheckable(boolean z) {
        this.f2605c = z;
    }

    public void setChecked(boolean z) {
        if (this.f2605c) {
            setSelected(z);
        }
    }

    public void setIcon(Drawable drawable) {
        if (getCompoundDrawables()[1] != drawable) {
            setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }
    }

    public boolean m4292a() {
        return false;
    }

    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        if (this.f2604b == null || !this.f2604b.m4389a(this.f2603a)) {
            return false;
        }
        playSoundEffect(0);
        return true;
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        this.f2604b = itemInvoker;
    }
}
