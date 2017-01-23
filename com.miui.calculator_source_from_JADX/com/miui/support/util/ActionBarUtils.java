package com.miui.support.util;

import android.view.View;
import android.view.ViewGroup;
import com.miui.support.internal.widget.ActionBarOverlayLayout;

public class ActionBarUtils {
    private ActionBarUtils() {
    }

    public static ViewGroup m5257a(View view) {
        for (View view2 = view; view2 != null; view2 = view2.getParent() instanceof View ? (View) view2.getParent() : null) {
            if (view2 instanceof ActionBarOverlayLayout) {
                return (ActionBarOverlayLayout) view2;
            }
        }
        return null;
    }
}
