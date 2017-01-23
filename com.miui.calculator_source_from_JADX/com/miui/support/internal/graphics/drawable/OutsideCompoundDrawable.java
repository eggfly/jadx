package com.miui.support.internal.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class OutsideCompoundDrawable extends Drawable implements Callback {
    private static int f2351d;
    private Drawable f2352a;
    private Drawable f2353b;
    private Drawable f2354c;

    static {
        f2351d = 0;
    }

    public OutsideCompoundDrawable() {
        if (f2351d == 0) {
            try {
                f2351d = Class.forName("com.android.internal.R$attr").getDeclaredField("drawable").getInt(null);
            } catch (Exception e) {
            }
        }
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
                    Drawable drawable;
                    String name = xmlPullParser.getName();
                    if (name.equals("item-top")) {
                        next = 0;
                    } else if (name.equals("item-base")) {
                        next = 1;
                    } else if (name.equals("item-bottom")) {
                        next = 2;
                    } else {
                        continue;
                    }
                    int attributeCount = attributeSet.getAttributeCount();
                    depth2 = 0;
                    while (depth2 < attributeCount) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(depth2);
                        if (attributeNameResource == 0) {
                            depth2 = 0;
                            break;
                        } else if (attributeNameResource == f2351d) {
                            depth2 = attributeSet.getAttributeResourceValue(depth2, 0);
                            break;
                        } else {
                            depth2++;
                        }
                    }
                    depth2 = 0;
                    if (depth2 != 0) {
                        drawable = resources.getDrawable(depth2);
                    } else {
                        do {
                            depth2 = xmlPullParser.next();
                        } while (depth2 == 4);
                        if (depth2 != 2) {
                            break;
                        }
                        drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                    if (drawable != null) {
                        if (next == 0) {
                            this.f2352a = drawable;
                            this.f2352a.setCallback(this);
                        } else if (next == 1) {
                            this.f2353b = drawable;
                            this.f2353b.setCallback(this);
                        } else if (next == 2) {
                            this.f2354c = drawable;
                            this.f2354c.setCallback(this);
                        }
                    }
                }
            } else {
                return;
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public void draw(Canvas canvas) {
        if (this.f2353b != null) {
            this.f2353b.draw(canvas);
        }
        if (this.f2352a != null) {
            this.f2352a.draw(canvas);
        }
        if (this.f2354c != null) {
            this.f2354c.draw(canvas);
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        int intrinsicHeight;
        int i5 = 1;
        super.setBounds(i, i2, i3, i4);
        if (this.f2353b != null) {
            this.f2353b.setBounds(i, i2, i3, i4);
        }
        if (this.f2352a != null) {
            intrinsicHeight = this.f2352a.getIntrinsicHeight();
            if (intrinsicHeight <= 0) {
                intrinsicHeight = 1;
            }
            this.f2352a.setBounds(i, i2 - intrinsicHeight, i3, i2);
        }
        if (this.f2354c != null) {
            intrinsicHeight = this.f2354c.getIntrinsicHeight();
            if (intrinsicHeight > 0) {
                i5 = intrinsicHeight;
            }
            this.f2354c.setBounds(i, i4, i3, i5 + i4);
        }
    }

    public boolean isStateful() {
        return (this.f2352a != null && this.f2352a.isStateful()) || ((this.f2353b != null && this.f2353b.isStateful()) || (this.f2354c != null && this.f2354c.isStateful()));
    }

    public void setAlpha(int i) {
        if (this.f2352a != null) {
            this.f2352a.setAlpha(i);
        }
        if (this.f2353b != null) {
            this.f2353b.setAlpha(i);
        }
        if (this.f2354c != null) {
            this.f2354c.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2352a != null) {
            this.f2352a.setColorFilter(colorFilter);
        }
        if (this.f2353b != null) {
            this.f2353b.setColorFilter(colorFilter);
        }
        if (this.f2354c != null) {
            this.f2354c.setColorFilter(colorFilter);
        }
    }

    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        boolean z2 = (this.f2352a == null || !this.f2352a.isStateful()) ? false : this.f2352a.setState(iArr);
        if (this.f2353b != null && this.f2353b.isStateful()) {
            if (this.f2353b.setState(iArr) || r0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (this.f2354c == null || !this.f2354c.isStateful()) {
            return z2;
        }
        if (this.f2354c.setState(iArr) || z2) {
            z = true;
        }
        return z;
    }

    protected boolean onLevelChange(int i) {
        boolean z = this.f2352a != null ? this.f2352a.setLevel(i) : false;
        if (this.f2353b != null) {
            if (this.f2353b.setLevel(i) || r0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (this.f2354c == null) {
            return z;
        }
        if (this.f2354c.setLevel(i) || z) {
            return true;
        }
        return false;
    }

    public void jumpToCurrentState() {
        if (this.f2352a != null) {
            this.f2352a.jumpToCurrentState();
        }
        if (this.f2353b != null) {
            this.f2353b.jumpToCurrentState();
        }
        if (this.f2354c != null) {
            this.f2354c.jumpToCurrentState();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2352a != null) {
            this.f2352a.setVisible(z, z2);
        }
        if (this.f2353b != null) {
            this.f2353b.setVisible(z, z2);
        }
        if (this.f2354c != null) {
            this.f2354c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public int getOpacity() {
        if (this.f2353b == null || !this.f2353b.isVisible()) {
            return -2;
        }
        return this.f2353b.getOpacity();
    }

    public int getIntrinsicWidth() {
        return this.f2353b == null ? -1 : this.f2353b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f2353b == null ? -1 : this.f2353b.getIntrinsicHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f2353b != null) {
            return this.f2353b.getPadding(rect);
        }
        rect.set(0, 0, 0, 0);
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
