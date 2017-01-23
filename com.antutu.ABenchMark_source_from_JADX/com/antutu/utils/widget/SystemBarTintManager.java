package com.antutu.utils.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.utils.MLog;
import java.lang.reflect.Method;
import org.android.agoo.message.MessageService;

public class SystemBarTintManager {
    public static final int DEFAULT_TINT_COLOR = -16777216;
    private static String sNavBarOverride;
    private final SystemBarConfig mConfig;
    private boolean mNavBarAvailable;
    private boolean mNavBarTintEnabled;
    private View mNavBarTintView;
    private boolean mStatusBarAvailable;
    private boolean mStatusBarTintEnabled;
    private View mStatusBarTintView;

    public static class SystemBarConfig {
        private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
        private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
        private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
        private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
        private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
        private final int mActionBarHeight;
        private final boolean mHasNavigationBar;
        private final boolean mInPortrait;
        private final int mNavigationBarHeight;
        private final int mNavigationBarWidth;
        private final float mSmallestWidthDp;
        private final int mStatusBarHeight;
        private final boolean mTranslucentNavBar;
        private final boolean mTranslucentStatusBar;

        private SystemBarConfig(Activity activity, boolean z, boolean z2) {
            boolean z3 = true;
            Resources resources = activity.getResources();
            this.mInPortrait = resources.getConfiguration().orientation == 1;
            this.mSmallestWidthDp = getSmallestWidthDp(activity);
            this.mStatusBarHeight = getInternalDimensionSize(resources, STATUS_BAR_HEIGHT_RES_NAME);
            this.mActionBarHeight = getActionBarHeight(activity);
            this.mNavigationBarHeight = getNavigationBarHeight(activity);
            this.mNavigationBarWidth = getNavigationBarWidth(activity);
            if (this.mNavigationBarHeight <= 0) {
                z3 = false;
            }
            this.mHasNavigationBar = z3;
            this.mTranslucentStatusBar = z;
            this.mTranslucentNavBar = z2;
        }

        @TargetApi(14)
        private int getActionBarHeight(Context context) {
            if (VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int getInternalDimensionSize(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", C0714a.ANDROID);
            return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        }

        @TargetApi(14)
        private int getNavigationBarHeight(Context context) {
            Resources resources = context.getResources();
            if (VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, this.mInPortrait ? NAV_BAR_HEIGHT_RES_NAME : NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME);
        }

        @TargetApi(14)
        private int getNavigationBarWidth(Context context) {
            return (VERSION.SDK_INT < 14 || !hasNavBar(context)) ? 0 : getInternalDimensionSize(context.getResources(), NAV_BAR_WIDTH_RES_NAME);
        }

        @SuppressLint({"NewApi"})
        private float getSmallestWidthDp(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            boolean z = true;
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", C0714a.ANDROID);
            if (identifier != 0) {
                return MessageService.MSG_DB_NOTIFY_REACHED.equals(SystemBarTintManager.sNavBarOverride) ? false : MessageService.MSG_DB_READY_REPORT.equals(SystemBarTintManager.sNavBarOverride) ? true : resources.getBoolean(identifier);
            } else {
                if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
                    z = false;
                }
                return z;
            }
        }

        public int getActionBarHeight() {
            return this.mActionBarHeight;
        }

        public int getNavigationBarHeight() {
            return this.mNavigationBarHeight;
        }

        public int getNavigationBarWidth() {
            return this.mNavigationBarWidth;
        }

        public int getPixelInsetBottom() {
            return (this.mTranslucentNavBar && isNavigationAtBottom()) ? this.mNavigationBarHeight : 0;
        }

        public int getPixelInsetRight() {
            return (!this.mTranslucentNavBar || isNavigationAtBottom()) ? 0 : this.mNavigationBarWidth;
        }

        public int getPixelInsetTop(boolean z) {
            int i = 0;
            int i2 = this.mTranslucentStatusBar ? this.mStatusBarHeight : 0;
            if (z) {
                i = this.mActionBarHeight;
            }
            return i + i2;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.mHasNavigationBar;
        }

        public boolean isNavigationAtBottom() {
            return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th) {
                sNavBarOverride = null;
            }
        }
    }

    @TargetApi(19)
    public SystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        viewGroup2.setFitsSystemWindows(true);
        viewGroup2.setClipToPadding(false);
        if (VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.mStatusBarAvailable = obtainStyledAttributes.getBoolean(0, false);
                this.mNavBarAvailable = obtainStyledAttributes.getBoolean(1, false);
                LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.mStatusBarAvailable = true;
                }
                MLog.m6864d("mStatusBarAvailable=" + this.mStatusBarAvailable);
                if ((attributes.flags & 134217728) != 0) {
                    this.mNavBarAvailable = true;
                }
                MLog.m6864d("mNavBarAvailable=" + this.mNavBarAvailable);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mConfig = new SystemBarConfig(this.mStatusBarAvailable, this.mNavBarAvailable, null);
        if (!this.mConfig.hasNavigtionBar()) {
            this.mNavBarAvailable = false;
        }
        if (this.mStatusBarAvailable) {
            setupStatusBarView(activity, viewGroup);
        }
        if (this.mNavBarAvailable) {
            setupNavBarView(activity, viewGroup);
        }
    }

    public static void setSystemBar(Activity activity, int i, boolean z) {
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
        int color = activity.getResources().getColor(i);
        systemBarTintManager.setTintColor(Color.argb(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color)));
        systemBarTintManager.setStatusBarTintEnabled(true);
        if (z) {
            systemBarTintManager.setNavigationBarTintEnabled(true);
        }
    }

    private void setupNavBarView(Context context, ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        this.mNavBarTintView = new View(context);
        if (this.mConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.mNavBarTintView.setLayoutParams(layoutParams);
        this.mNavBarTintView.setBackgroundColor(DEFAULT_TINT_COLOR);
        this.mNavBarTintView.setVisibility(8);
        viewGroup.addView(this.mNavBarTintView);
    }

    private void setupStatusBarView(Context context, ViewGroup viewGroup) {
        this.mStatusBarTintView = new View(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.mNavBarAvailable && !this.mConfig.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.mConfig.getNavigationBarWidth();
        }
        this.mStatusBarTintView.setLayoutParams(layoutParams);
        this.mStatusBarTintView.setBackgroundColor(DEFAULT_TINT_COLOR);
        this.mStatusBarTintView.setVisibility(8);
        viewGroup.addView(this.mStatusBarTintView);
    }

    public SystemBarConfig getConfig() {
        return this.mConfig;
    }

    public boolean isNavBarTintEnabled() {
        return this.mNavBarTintEnabled;
    }

    public boolean isStatusBarTintEnabled() {
        return this.mStatusBarTintEnabled;
    }

    @TargetApi(11)
    public void setNavigationBarAlpha(float f) {
        if (this.mNavBarAvailable && VERSION.SDK_INT >= 11) {
            this.mNavBarTintView.setAlpha(f);
        }
    }

    public void setNavigationBarTintColor(int i) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundColor(i);
        }
    }

    public void setNavigationBarTintDrawable(Drawable drawable) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundDrawable(drawable);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        this.mNavBarTintEnabled = z;
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setNavigationBarTintResource(int i) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundResource(i);
        }
    }

    @TargetApi(11)
    public void setStatusBarAlpha(float f) {
        if (this.mStatusBarAvailable && VERSION.SDK_INT >= 11) {
            this.mStatusBarTintView.setAlpha(f);
        }
    }

    public void setStatusBarTintColor(int i) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundColor(i);
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundDrawable(drawable);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.mStatusBarTintEnabled = z;
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintResource(int i) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundResource(i);
        }
    }

    public void setTintAlpha(float f) {
        setStatusBarAlpha(f);
        setNavigationBarAlpha(f);
    }

    public void setTintColor(int i) {
        setStatusBarTintColor(i);
        setNavigationBarTintColor(i);
    }

    public void setTintDrawable(Drawable drawable) {
        setStatusBarTintDrawable(drawable);
        setNavigationBarTintDrawable(drawable);
    }

    public void setTintResource(int i) {
        setStatusBarTintResource(i);
        setNavigationBarTintResource(i);
    }
}
