package com.miui.support.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AttributeResolver;
import com.miui.support.util.DrawableUtil;

public class FloatingActionButton extends ImageView {
    private Drawable f4169a;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getBackground() == null) {
            setBackground(getDefaultBackground());
        }
    }

    private Drawable getDefaultBackground() {
        if (this.f4169a == null) {
            this.f4169a = AttributeResolver.m5320b(getContext(), C0264R.attr.actionButtonMainBackground);
            if (DrawableUtil.m5370a(this.f4169a)) {
                Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
                shapeDrawable.getPaint().setColor(AttributeResolver.m5322c(getContext(), C0234R.attr.colorAccent));
                new ShapeDrawable(new OvalShape()).getPaint().setColor(218103808);
                Drawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, r0});
                this.f4169a = new StateListDrawable();
                ((StateListDrawable) this.f4169a).addState(PRESSED_ENABLED_STATE_SET, layerDrawable);
                ((StateListDrawable) this.f4169a).addState(ENABLED_SELECTED_STATE_SET, layerDrawable);
                ((StateListDrawable) this.f4169a).addState(EMPTY_STATE_SET, shapeDrawable);
            }
        }
        return this.f4169a;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == null) {
            drawable = getDefaultBackground();
        }
        super.setBackground(drawable);
    }

    public void setBackgroundResource(int i) {
        if (i == 0) {
            setBackground(getDefaultBackground());
        } else {
            super.setBackgroundResource(i);
        }
    }
}
