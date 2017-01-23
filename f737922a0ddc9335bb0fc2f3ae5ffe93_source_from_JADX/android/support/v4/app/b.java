package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class b {
    private static final int[] j6;

    private static class a {
        public Method DW;
        public ImageView FH;
        public Method j6;

        a(Activity activity) {
            try {
                this.j6 = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.DW = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException e) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        findViewById = viewGroup.getChildAt(1);
                        if (childAt.getId() != 16908332) {
                            findViewById = childAt;
                        }
                        if (findViewById instanceof ImageView) {
                            this.FH = (ImageView) findViewById;
                        }
                    }
                }
            }
        }
    }

    static {
        j6 = new int[]{16843531};
    }

    public static Object j6(Object obj, Activity activity, Drawable drawable, int i) {
        Object aVar;
        if (obj == null) {
            aVar = new a(activity);
        } else {
            aVar = obj;
        }
        a aVar2 = (a) aVar;
        if (aVar2.j6 != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar2.j6.invoke(actionBar, new Object[]{drawable});
                aVar2.DW.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (aVar2.FH != null) {
            aVar2.FH.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return aVar;
    }

    public static Object j6(Object obj, Activity activity, int i) {
        Object aVar;
        if (obj == null) {
            aVar = new a(activity);
        } else {
            aVar = obj;
        }
        a aVar2 = (a) aVar;
        if (aVar2.j6 != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar2.DW.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return aVar;
    }

    public static Drawable j6(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(j6);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
}
