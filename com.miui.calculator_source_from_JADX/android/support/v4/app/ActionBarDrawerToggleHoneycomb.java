package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb {
    private static final int[] f50a;

    private static class SetIndicatorInfo {
        public Method f47a;
        public Method f48b;
        public ImageView f49c;

        SetIndicatorInfo(Activity activity) {
            try {
                this.f47a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f48b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
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
                            this.f49c = (ImageView) findViewById;
                        }
                    }
                }
            }
        }
    }

    ActionBarDrawerToggleHoneycomb() {
    }

    static {
        f50a = new int[]{16843531};
    }

    public static Object m62a(Object obj, Activity activity, int i) {
        Object setIndicatorInfo;
        if (obj == null) {
            setIndicatorInfo = new SetIndicatorInfo(activity);
        } else {
            setIndicatorInfo = obj;
        }
        SetIndicatorInfo setIndicatorInfo2 = (SetIndicatorInfo) setIndicatorInfo;
        if (setIndicatorInfo2.f47a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo2.f48b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return setIndicatorInfo;
    }
}
