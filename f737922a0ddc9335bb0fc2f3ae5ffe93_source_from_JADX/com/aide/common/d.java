package com.aide.common;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.aide.ui.R;
import com.aide.uidesigner.ProxyTextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class d {
    private static Locale DW;
    private static Boolean j6;

    static class 1 implements Runnable {
        final /* synthetic */ Activity j6;

        class 1 implements OnClickListener {
            final /* synthetic */ ActionBar DW;
            final /* synthetic */ 1 FH;
            final /* synthetic */ Spinner j6;

            class 1 implements OnMenuItemClickListener {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.j6.DW.selectTab(this.j6.DW.getTabAt(menuItem.getItemId()));
                    return true;
                }
            }

            1(1 1, Spinner spinner, ActionBar actionBar) {
                this.FH = 1;
                this.j6 = spinner;
                this.DW = actionBar;
            }

            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(this.FH.j6, this.j6);
                Menu menu = popupMenu.getMenu();
                for (int i = 0; i < this.DW.getTabCount(); i++) {
                    menu.add(0, i, 0, this.DW.getTabAt(i).getText());
                }
                popupMenu.setOnMenuItemClickListener(new 1(this));
                popupMenu.show();
            }
        }

        1(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            try {
                ActionBar actionBar = this.j6.getActionBar();
                Spinner spinner = (Spinner) d.DW(this.j6.findViewById(this.j6.getResources().getIdentifier("action_bar_container", "id", "android")), Spinner.class);
                if (spinner != null) {
                    1 1 = new 1(this, spinner, actionBar);
                    Method declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener").set(declaredMethod.invoke(spinner, new Object[0]), 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void j6(Activity activity, String str) {
        Locale locale;
        if (str == null || "default".equals(str)) {
            locale = DW;
            DW = null;
        } else {
            locale = new Locale(str);
            DW = Locale.getDefault();
        }
        if (locale != null) {
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            activity.getBaseContext().getResources().updateConfiguration(configuration, activity.getBaseContext().getResources().getDisplayMetrics());
        }
    }

    public static boolean j6(Context context) {
        if (VERSION.SDK_INT >= 20) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.a.theme_name, typedValue, true)) {
                return "Material".equals(typedValue.string);
            }
        }
        return false;
    }

    public static boolean j6() {
        return false;
    }

    @TargetApi(21)
    public static void j6(Activity activity) {
        if (DW((Context) activity)) {
            float f = activity.getResources().getDisplayMetrics().density;
            activity.getActionBar().setElevation(3.0f * f);
            View findViewById = activity.getWindow().getDecorView().findViewById(activity.getResources().getIdentifier("action_bar_container", "id", "android"));
            if (findViewById != null) {
                findViewById.setPadding((int) (48.0f * f), (int) (27.0f * f), (int) (f * 48.0f), 0);
            }
        }
    }

    public static void j6(View view) {
        j6(view, false);
    }

    @TargetApi(21)
    public static void j6(View view, boolean z) {
        if (DW(view.getContext())) {
            Activity activity = (Activity) view.getContext();
            float f = activity.getResources().getDisplayMetrics().density;
            activity.getActionBar().setElevation(3.0f * f);
            view.setPadding((int) (48.0f * f), 0, (int) (48.0f * f), z ? (int) (27.0f * f) : 0);
            View findViewById = activity.getWindow().getDecorView().findViewById(activity.getResources().getIdentifier("action_bar_container", "id", "android"));
            if (findViewById != null) {
                findViewById.setPadding((int) (48.0f * f), (int) (27.0f * f), (int) (f * 48.0f), 0);
            }
        }
    }

    public static void DW(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            View findViewById = activity.findViewById(activity.getResources().getIdentifier("action_bar", "id", "android"));
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).setTouchscreenBlocksFocus(false);
            }
            findViewById = activity.findViewById(activity.getResources().getIdentifier("action_bar_container", "id", "android"));
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).setTouchscreenBlocksFocus(false);
            }
        }
    }

    public static boolean DW(Context context) {
        if (j6 == null) {
            j6 = Boolean.valueOf(false);
            if (VERSION.SDK_INT >= 21) {
                boolean z;
                if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4) {
                    z = true;
                } else {
                    z = false;
                }
                j6 = Boolean.valueOf(z);
            }
        }
        return j6.booleanValue();
    }

    public static boolean FH(Context context) {
        return context.getResources().getConfiguration().keyboard == 2;
    }

    public static boolean Hw(Context context) {
        return (j6() || DW(context)) ? false : true;
    }

    public static boolean j6(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) == 3) {
            return true;
        }
        switch (motionEvent.getSource()) {
            case ProxyTextView.INPUTTYPE_numberDecimal /*8194*/:
            case 1048584:
                return true;
            default:
                return false;
        }
    }

    public static void j6(Activity activity, boolean z) {
        try {
            Method declaredMethod = activity.getActionBar().getClass().getDeclaredMethod("setHasEmbeddedTabs", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity.getActionBar(), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void FH(Activity activity) {
        new Handler().postDelayed(new 1(activity), 200);
    }

    private static <T extends View> T DW(View view, Class<T> cls) {
        if (view == null) {
            return null;
        }
        if (view.getClass() == cls) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View DW = DW(viewGroup.getChildAt(i), (Class) cls);
                if (DW != null) {
                    return DW;
                }
            }
        }
        return null;
    }

    public static void Hw(Activity activity) {
        if (v5(activity) >= 540.0f) {
            try {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(activity);
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            } catch (Exception e) {
            }
        }
    }

    public static float v5(Context context) {
        return Math.min(gn(context), u7(context));
    }

    public static int Zo(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return Math.min(windowManager.getDefaultDisplay().getHeight(), windowManager.getDefaultDisplay().getWidth());
    }

    public static float VH(Context context) {
        Activity activity = (Activity) context;
        float f = activity.getResources().getDisplayMetrics().density;
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return ((float) (rect.bottom - rect.top)) / f;
    }

    public static float gn(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return ((float) windowManager.getDefaultDisplay().getHeight()) / context.getResources().getDisplayMetrics().density;
    }

    public static float u7(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return ((float) windowManager.getDefaultDisplay().getWidth()) / context.getResources().getDisplayMetrics().density;
    }

    public static int j6(Context context, int i) {
        if (v5(context) >= 400.0f) {
            return (int) (((float) i) * 1.3f);
        }
        return i;
    }

    public static void j6(TextView textView) {
        textView.setTextSize(((float) j6(textView.getContext(), (int) textView.getTextSize())) / textView.getContext().getResources().getDisplayMetrics().scaledDensity);
    }

    public static int tp(Context context) {
        if (v5(context) > 720.0f) {
            return 21;
        }
        if (v5(context) >= 400.0f) {
            return 18;
        }
        return 14;
    }

    public static float EQ(Context context) {
        if (v5(context) > 720.0f) {
            return 20.0f;
        }
        if (v5(context) >= 400.0f) {
            return 18.0f;
        }
        return 15.0f;
    }

    public static float we(Context context) {
        if (v5(context) > 720.0f) {
            return 25.0f;
        }
        if (v5(context) >= 400.0f) {
            return 22.0f;
        }
        return 20.0f;
    }

    public static float J0(Context context) {
        if (v5(context) > 720.0f) {
            return 35.0f;
        }
        if (v5(context) >= 400.0f) {
            return 30.0f;
        }
        return 25.0f;
    }

    public static float J8(Context context) {
        if (v5(context) > 720.0f) {
            return 25.0f;
        }
        if (v5(context) >= 400.0f) {
            return 22.0f;
        }
        return 20.0f;
    }

    public static int DW(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Drawable j6(Context context, int i, int i2) {
        Drawable drawable = context.getResources().getDrawable(DW(context, i));
        drawable.setColorFilter(FH(context, i2), Mode.SRC_IN);
        return drawable;
    }

    public static int FH(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        return color;
    }
}
