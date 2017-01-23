package com.antutu.utils;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

public class SmartBarUtils {
    @SuppressLint({"NewApi"})
    public static void InitActionBar(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.setDisplayOptions(0);
        actionBar.hide();
    }

    @SuppressLint({"NewApi"})
    public static void InitActionBar(Activity activity, int i) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.setDisplayOptions(0);
        try {
            setBackIcon(actionBar, activity.getResources().getDrawable(i));
        } catch (NotFoundException e) {
        } catch (Exception e2) {
        }
        actionBar.hide();
    }

    public static boolean hasSmartBar() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            return Build.DEVICE.equals("mx2") ? true : (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) ? false : false;
        }
    }

    public static void setActionBarTabsShowAtBottom(ActionBar actionBar, boolean z) {
        try {
            try {
                Class.forName("android.app.ActionBar").getMethod("setTabsShowAtBottom", new Class[]{Boolean.TYPE}).invoke(actionBar, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        } catch (SecurityException e4) {
        } catch (NoSuchMethodException e5) {
        } catch (ClassNotFoundException e6) {
        }
    }

    public static void setActionBarViewCollapsable(ActionBar actionBar, boolean z) {
        try {
            try {
                Class.forName("android.app.ActionBar").getMethod("setActionBarViewCollapsable", new Class[]{Boolean.TYPE}).invoke(actionBar, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        } catch (SecurityException e4) {
        }
    }

    public static void setActionModeHeaderHidden(ActionBar actionBar, boolean z) {
        try {
            try {
                Class.forName("android.app.ActionBar").getMethod("setActionModeHeaderHidden", new Class[]{Boolean.TYPE}).invoke(actionBar, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        } catch (SecurityException e4) {
        } catch (NoSuchMethodException e5) {
        } catch (ClassNotFoundException e6) {
        }
    }

    public static void setBackIcon(ActionBar actionBar, Drawable drawable) {
        try {
            Class.forName("android.app.ActionBar").getMethod("setBackButtonDrawable", new Class[]{Drawable.class}).invoke(actionBar, new Object[]{drawable});
        } catch (IllegalArgumentException e) {
        } catch (NotFoundException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
    }
}
