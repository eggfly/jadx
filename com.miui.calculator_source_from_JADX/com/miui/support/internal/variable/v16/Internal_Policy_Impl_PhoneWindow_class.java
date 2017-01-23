package com.miui.support.internal.variable.v16;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.ActivityDelegate;
import com.miui.support.internal.graphics.drawable.PlaceholderDrawable;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.util.AttributeResolver;
import java.lang.reflect.Field;

public class Internal_Policy_Impl_PhoneWindow_class extends com.miui.support.internal.variable.Internal_Policy_Impl_PhoneWindow_class {
    private static final Field FieldLayoutInflater;

    private static class LayoutInflaterWrapper extends LayoutInflater {
        private static final com.miui.support.reflect.Field FieldContext;
        private static final Field FieldTitle;
        private Window mDecorViewWindow;
        private LayoutInflater mLayoutInflater;

        static {
            FieldContext = com.miui.support.reflect.Field.of(LayoutInflater.class, "mContext", "Landroid/content/Context;");
            FieldTitle = Internal_Policy_Impl_PhoneWindow_class.getField(Internal_Policy_Impl_PhoneWindow_class.TARGET_CLASS, "mTitle");
        }

        private LayoutInflaterWrapper(LayoutInflater layoutInflater, Window window) {
            super((Context) FieldContext.get(layoutInflater));
            this.mLayoutInflater = layoutInflater;
            this.mDecorViewWindow = window;
        }

        public LayoutInflater cloneInContext(Context context) {
            return new LayoutInflaterWrapper(this.mLayoutInflater.cloneInContext(context), this.mDecorViewWindow);
        }

        public View inflate(int i, ViewGroup viewGroup, boolean z) {
            if (DeviceHelper.f2560l) {
                this.mDecorViewWindow.getAttributes().dimAmount = ((float) AttributeResolver.m5317a(this.mDecorViewWindow.getContext(), C0264R.attr.backgroundDim, 20)) / 100.0f;
            }
            int a = ActivityDelegate.m3693a(this.mDecorViewWindow);
            View inflate = this.mLayoutInflater.inflate(a, viewGroup, z);
            if (!(a == C0264R.layout.screen_action_bar || a == C0264R.layout.screen_action_bar_movable || a == C0264R.layout.screen_simple)) {
                Context context = this.mDecorViewWindow.getContext();
                setStatusBarHeight(context, inflate);
                if (a == C0264R.layout.starting_window_simple) {
                    initDefaultStartingWindow(context, inflate);
                }
            }
            return inflate;
        }

        private void setStatusBarHeight(Context context, View view) {
            View findViewById = view.findViewById(C0234R.id.status_bar);
            if (findViewById != null) {
                LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = getStatusBarHeight(context);
                findViewById.setLayoutParams(layoutParams);
            }
        }

        private int getStatusBarHeight(Context context) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return context.getResources().getDimensionPixelSize(C0264R.dimen.status_bar_height);
        }

        private void initDefaultStartingWindow(Context context, View view) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0234R.styleable.ActionBar, 16843470, 0);
            int resourceId = obtainStyledAttributes.getResourceId(C0234R.styleable.ActionBar_android_titleTextStyle, 0);
            boolean z = obtainStyledAttributes.getBoolean(C0264R.styleable.ActionBar_titleCenter, false);
            int i = obtainStyledAttributes.getInt(C0234R.styleable.ActionBar_android_displayOptions, 0);
            obtainStyledAttributes.recycle();
            View findViewById = view.findViewById(C0264R.id.action_bar);
            if (findViewById.getBackground() instanceof PlaceholderDrawable) {
                findViewById.setBackground(new ColorDrawable(AttributeResolver.m5322c(context, C0234R.attr.colorPrimary)));
            }
            View findViewById2 = view.findViewById(C0264R.id.title_layout);
            TextView textView = (TextView) findViewById2.findViewById(C0264R.id.action_bar_title);
            ImageView imageView = (ImageView) findViewById2.findViewById(C0264R.id.up);
            if ((i & 8) == 0) {
                findViewById2.setVisibility(4);
                return;
            }
            CharSequence charSequence;
            if (z && (i & 2) == 0 && (i & 4) == 0) {
                findViewById2.setPadding(0, findViewById2.getPaddingTop(), 0, findViewById2.getPaddingBottom());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams.gravity = 1;
                findViewById2.setLayoutParams(layoutParams);
            } else {
                imageView.setVisibility(0);
            }
            if (resourceId != 0) {
                textView.setTextAppearance(context, resourceId);
            }
            try {
                charSequence = (CharSequence) FieldTitle.get(this.mDecorViewWindow);
            } catch (IllegalAccessException e) {
                charSequence = null;
            }
            if (charSequence != null) {
                textView.setText(charSequence);
            }
        }
    }

    static {
        FieldLayoutInflater = getField(TARGET_CLASS, "mLayoutInflater");
    }

    private static Field getField(Class<? extends Object> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public LayoutInflater replaceLayoutInflater(Window window) {
        try {
            LayoutInflater layoutInflaterWrapper = new LayoutInflaterWrapper(window, null);
            FieldLayoutInflater.set(window, layoutInflaterWrapper);
            return layoutInflaterWrapper;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void restoreLayoutInflater(Window window, LayoutInflater layoutInflater) {
        try {
            FieldLayoutInflater.set(window, ((LayoutInflaterWrapper) layoutInflater).mLayoutInflater);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
