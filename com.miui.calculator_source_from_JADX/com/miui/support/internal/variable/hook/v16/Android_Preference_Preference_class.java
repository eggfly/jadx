package com.miui.support.internal.variable.hook.v16;

import android.content.Context;
import android.graphics.Rect;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.miui.support.internal.C0264R;
import com.miui.support.reflect.Field;
import com.miui.support.util.AttributeResolver;

public class Android_Preference_Preference_class extends com.miui.support.internal.variable.hook.Android_Preference_Preference_class {
    protected static final Field mCanRecycleLayout;

    static {
        mCanRecycleLayout = Field.of(Preference.class, "mCanRecycleLayout", Field.BOOLEAN_SIGNATURE_PRIMITIVE);
    }

    public void buildProxy() {
        attachConstructor("(Landroid/content/Context;Landroid/util/AttributeSet;I)V");
        attachMethod("onBindView", "(Landroid/view/View;)V");
    }

    protected void handle() {
        handle_init_(0, null, null, null, 0);
        handleOnBindView(0, null, null);
    }

    protected void handleOnBindView(long j, Preference preference, View view) {
        int order;
        if (preference instanceof PreferenceCategory) {
            order = preference.getOrder();
            if (TextUtils.isEmpty(preference.getTitle())) {
                if (order == 0) {
                    view.setBackgroundResource(C0264R.drawable.preference_category_background_first_no_title);
                } else {
                    view.setBackgroundResource(C0264R.drawable.preference_category_background_no_title);
                }
            } else if (order == 0) {
                view.setBackgroundResource(C0264R.drawable.preference_category_background_first);
            } else {
                view.setBackgroundResource(C0264R.drawable.preference_category_background);
            }
            Rect rect = new Rect();
            view.getBackground().getPadding(rect);
            view.setPadding(view.getPaddingLeft(), rect.top, view.getPaddingRight(), rect.bottom);
        } else if (view.getBackground() == null) {
            view.setBackground(AttributeResolver.m5320b(preference.getContext(), C0264R.attr.preferenceBackground));
        }
        View findViewById = view.findViewById(C0264R.id.arrow_right);
        if (findViewById != null) {
            findViewById.setVisibility(preference.getWidgetLayoutResource() == 0 ? 0 : 8);
        }
        order = view.getContext().getResources().getDimensionPixelSize(C0264R.dimen.preference_horizontal_extra_padding);
        view.setPaddingRelative(view.getPaddingStart() + order, view.getPaddingTop(), order + view.getPaddingEnd(), view.getPaddingBottom());
        originalOnBindView(j, preference, view);
    }

    protected void originalOnBindView(long j, Preference preference, View view) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Preference_Preference_class.originalOnBindView(long, Preference, View)");
    }

    protected void handle_init_(long j, Preference preference, Context context, AttributeSet attributeSet, int i) {
        original_init_(j, preference, context, attributeSet, i);
        mCanRecycleLayout.set((Object) preference, true);
    }

    protected void original_init_(long j, Preference preference, Context context, AttributeSet attributeSet, int i) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Preference_Preference_class.original_init_(long, View, Context, AttributeSet, int)");
    }
}
