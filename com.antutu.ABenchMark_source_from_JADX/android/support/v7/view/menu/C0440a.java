package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.a */
public class C0440a implements SupportMenuItem {
    private final int f1165a;
    private final int f1166b;
    private final int f1167c;
    private final int f1168d;
    private CharSequence f1169e;
    private CharSequence f1170f;
    private Intent f1171g;
    private char f1172h;
    private char f1173i;
    private Drawable f1174j;
    private int f1175k;
    private Context f1176l;
    private OnMenuItemClickListener f1177m;
    private int f1178n;

    public C0440a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1175k = 0;
        this.f1178n = 16;
        this.f1176l = context;
        this.f1165a = i2;
        this.f1166b = i;
        this.f1167c = i3;
        this.f1168d = i4;
        this.f1169e = charSequence;
    }

    public SupportMenuItem m1333a(int i) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m1334a(View view) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m1335b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f1173i;
    }

    public int getGroupId() {
        return this.f1166b;
    }

    public Drawable getIcon() {
        return this.f1174j;
    }

    public Intent getIntent() {
        return this.f1171g;
    }

    public int getItemId() {
        return this.f1165a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1172h;
    }

    public int getOrder() {
        return this.f1168d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public android.support.v4.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1169e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1170f != null ? this.f1170f : this.f1169e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1178n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1178n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1178n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1178n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m1333a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m1334a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1173i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1178n = (z ? 1 : 0) | (this.f1178n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1178n = (z ? 2 : 0) | (this.f1178n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1178n = (z ? 16 : 0) | (this.f1178n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1175k = i;
        this.f1174j = ContextCompat.getDrawable(this.f1176l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1174j = drawable;
        this.f1175k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1171g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1172h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1177m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1172h = c;
        this.f1173i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m1335b(i);
    }

    public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1169e = this.f1176l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1169e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1170f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1178n = (z ? 0 : 8) | (this.f1178n & 8);
        return this;
    }
}
