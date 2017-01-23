package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.C0417R;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.view.a */
public class C0422a {
    private Context f1062a;

    private C0422a(Context context) {
        this.f1062a = context;
    }

    public static C0422a m1230a(Context context) {
        return new C0422a(context);
    }

    public int m1231a() {
        return this.f1062a.getResources().getInteger(C0417R.integer.abc_max_action_buttons);
    }

    public boolean m1232b() {
        return VERSION.SDK_INT >= 19 || !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.f1062a));
    }

    public int m1233c() {
        return this.f1062a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m1234d() {
        return this.f1062a.getApplicationInfo().targetSdkVersion >= 16 ? this.f1062a.getResources().getBoolean(C0417R.bool.abc_action_bar_embed_tabs) : this.f1062a.getResources().getBoolean(C0417R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m1235e() {
        TypedArray obtainStyledAttributes = this.f1062a.obtainStyledAttributes(null, C0417R.styleable.ActionBar, C0417R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0417R.styleable.ActionBar_height, 0);
        Resources resources = this.f1062a.getResources();
        if (!m1234d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0417R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m1236f() {
        return this.f1062a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m1237g() {
        return this.f1062a.getResources().getDimensionPixelSize(C0417R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
