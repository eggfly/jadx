package com.miui.support.internal.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import com.miui.support.internal.C0264R;
import org.xmlpull.v1.XmlPullParser;

public class PlaceholderDrawable extends Drawable {
    public int f2355a;
    public int f2356b;
    private Rect f2357c;

    public PlaceholderDrawable() {
        this.f2355a = -1;
        this.f2356b = -1;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    String name = xmlPullParser.getName();
                    TypedArray obtainAttributes;
                    if (name.equals("size")) {
                        obtainAttributes = resources.obtainAttributes(attributeSet, C0264R.styleable.PlaceholderDrawableSize);
                        this.f2355a = obtainAttributes.getDimensionPixelSize(C0264R.styleable.PlaceholderDrawableSize_android_width, -1);
                        this.f2356b = obtainAttributes.getDimensionPixelSize(C0264R.styleable.PlaceholderDrawableSize_android_height, -1);
                        obtainAttributes.recycle();
                    } else if (name.equals("padding")) {
                        obtainAttributes = resources.obtainAttributes(attributeSet, C0264R.styleable.PlaceholderDrawablePadding);
                        this.f2357c = new Rect(obtainAttributes.getDimensionPixelOffset(C0264R.styleable.PlaceholderDrawablePadding_android_left, 0), obtainAttributes.getDimensionPixelOffset(C0264R.styleable.PlaceholderDrawablePadding_android_top, 0), obtainAttributes.getDimensionPixelOffset(C0264R.styleable.PlaceholderDrawablePadding_android_right, 0), obtainAttributes.getDimensionPixelOffset(C0264R.styleable.PlaceholderDrawablePadding_android_bottom, 0));
                        obtainAttributes.recycle();
                    } else {
                        Log.w("drawable", "Bad element under <placeholder>: " + name);
                    }
                }
            } else {
                return;
            }
        }
    }

    public void draw(Canvas canvas) {
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public int getIntrinsicWidth() {
        return this.f2355a;
    }

    public int getIntrinsicHeight() {
        return this.f2356b;
    }

    public boolean getPadding(Rect rect) {
        if (this.f2357c == null) {
            return super.getPadding(rect);
        }
        rect.set(this.f2357c);
        return true;
    }
}
