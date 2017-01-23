package com.miui.support.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AttributeResolver;

public class ActionBarPolicy {
    private Context f2583a;

    public static ActionBarPolicy m4264a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f2583a = context;
    }

    public int m4265a() {
        return this.f2583a.getResources().getInteger(C0264R.integer.abc_max_action_buttons);
    }

    public boolean m4266b() {
        return VERSION.SDK_INT >= 11;
    }

    public int m4267c() {
        return this.f2583a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m4268d() {
        return AttributeResolver.m5319a(this.f2583a, C0234R.attr.actionBarEmbedTabs, false);
    }

    public boolean m4269e() {
        return AttributeResolver.m5319a(this.f2583a, C0264R.attr.actionBarTightTitle, false);
    }

    public int m4270f() {
        TypedArray obtainStyledAttributes = this.f2583a.obtainStyledAttributes(null, C0234R.styleable.ActionBar, 16843508, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0234R.styleable.ActionBar_android_height, 0);
        obtainStyledAttributes.recycle();
        if (layoutDimension > 0) {
            return layoutDimension;
        }
        obtainStyledAttributes = this.f2583a.obtainStyledAttributes(null, C0234R.styleable.ActionBar, 16843470, 0);
        layoutDimension = obtainStyledAttributes.getLayoutDimension(C0234R.styleable.ActionBar_android_height, 0);
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m4271g() {
        return this.f2583a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m4272h() {
        return this.f2583a.getResources().getDimensionPixelSize(C0264R.dimen.action_bar_stacked_tab_max_width);
    }
}
