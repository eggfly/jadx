package com.miui.support.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class ActionMenuItem implements MenuItem {
    private final int f2590a;
    private final int f2591b;
    private final int f2592c;
    private final int f2593d;
    private CharSequence f2594e;
    private CharSequence f2595f;
    private Intent f2596g;
    private char f2597h;
    private char f2598i;
    private Drawable f2599j;
    private Context f2600k;
    private OnMenuItemClickListener f2601l;
    private int f2602m;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f2602m = 16;
        this.f2600k = context;
        this.f2590a = i2;
        this.f2591b = i;
        this.f2592c = i3;
        this.f2593d = i4;
        this.f2594e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f2598i;
    }

    public int getGroupId() {
        return this.f2591b;
    }

    public Drawable getIcon() {
        return this.f2599j;
    }

    public Intent getIntent() {
        return this.f2596g;
    }

    public int getItemId() {
        return this.f2590a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f2597h;
    }

    public int getOrder() {
        return this.f2593d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f2594e;
    }

    public CharSequence getTitleCondensed() {
        return this.f2595f;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f2602m & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f2602m & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f2602m & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f2602m & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f2598i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f2602m = (z ? 1 : 0) | (this.f2602m & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f2602m = (z ? 2 : 0) | (this.f2602m & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f2602m = (z ? 16 : 0) | (this.f2602m & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2599j = drawable;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2599j = this.f2600k.getResources().getDrawable(i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2596g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f2597h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2601l = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2597h = c;
        this.f2598i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2594e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f2594e = this.f2600k.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2595f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f2602m = (z ? 0 : 8) | (this.f2602m & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }
}
