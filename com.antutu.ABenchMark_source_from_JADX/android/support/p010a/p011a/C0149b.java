package android.support.p010a.p011a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* renamed from: android.support.a.a.b */
public class C0149b extends C0148e implements Animatable {
    private C0146a f676b;
    private Context f677c;
    private ArgbEvaluator f678d;
    private final Callback f679e;

    /* renamed from: android.support.a.a.b.1 */
    class C01451 implements Callback {
        final /* synthetic */ C0149b f669a;

        C01451(C0149b c0149b) {
            this.f669a = c0149b;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f669a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f669a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f669a.unscheduleSelf(runnable);
        }
    }

    /* renamed from: android.support.a.a.b.a */
    private static class C0146a extends ConstantState {
        int f670a;
        C0163f f671b;
        ArrayList<Animator> f672c;
        ArrayMap<Animator, String> f673d;

        public C0146a(Context context, C0146a c0146a, Callback callback, Resources resources) {
            int i = 0;
            if (c0146a != null) {
                this.f670a = c0146a.f670a;
                if (c0146a.f671b != null) {
                    ConstantState constantState = c0146a.f671b.getConstantState();
                    if (resources != null) {
                        this.f671b = (C0163f) constantState.newDrawable(resources);
                    } else {
                        this.f671b = (C0163f) constantState.newDrawable();
                    }
                    this.f671b = (C0163f) this.f671b.mutate();
                    this.f671b.setCallback(callback);
                    this.f671b.setBounds(c0146a.f671b.getBounds());
                    this.f671b.m778a(false);
                }
                if (c0146a.f672c != null) {
                    int size = c0146a.f672c.size();
                    this.f672c = new ArrayList(size);
                    this.f673d = new ArrayMap(size);
                    while (i < size) {
                        Animator animator = (Animator) c0146a.f672c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0146a.f673d.get(animator);
                        clone.setTarget(this.f671b.m777a(str));
                        this.f672c.add(clone);
                        this.f673d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f670a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }
    }

    /* renamed from: android.support.a.a.b.b */
    private static class C0147b extends ConstantState {
        private final ConstantState f674a;

        public C0147b(ConstantState constantState) {
            this.f674a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f674a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f674a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C0149b c0149b = new C0149b();
            c0149b.a = this.f674a.newDrawable();
            c0149b.a.setCallback(c0149b.f679e);
            return c0149b;
        }

        public Drawable newDrawable(Resources resources) {
            C0149b c0149b = new C0149b();
            c0149b.a = this.f674a.newDrawable(resources);
            c0149b.a.setCallback(c0149b.f679e);
            return c0149b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C0149b c0149b = new C0149b();
            c0149b.a = this.f674a.newDrawable(resources, theme);
            c0149b.a.setCallback(c0149b.f679e);
            return c0149b;
        }
    }

    private C0149b() {
        this(null, null, null);
    }

    private C0149b(Context context) {
        this(context, null, null);
    }

    private C0149b(Context context, C0146a c0146a, Resources resources) {
        this.f678d = null;
        this.f679e = new C01451(this);
        this.f677c = context;
        if (c0146a != null) {
            this.f676b = c0146a;
        } else {
            this.f676b = new C0146a(context, c0146a, this.f679e, resources);
        }
    }

    static TypedArray m706a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static C0149b m708a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0149b c0149b = new C0149b(context);
        c0149b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0149b;
    }

    private void m709a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m709a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f678d == null) {
                    this.f678d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f678d);
            }
        }
    }

    private void m710a(String str, Animator animator) {
        animator.setTarget(this.f676b.f671b.m777a(str));
        if (VERSION.SDK_INT < 21) {
            m709a(animator);
        }
        if (this.f676b.f672c == null) {
            this.f676b.f672c = new ArrayList();
            this.f676b.f673d = new ArrayMap();
        }
        this.f676b.f672c.add(animator);
        this.f676b.f673d.put(animator, str);
    }

    private boolean m711a() {
        ArrayList arrayList = this.f676b.f672c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            DrawableCompat.applyTheme(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.a != null ? DrawableCompat.canApplyTheme(this.a) : false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.f676b.f671b.draw(canvas);
        if (m711a()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.a != null ? DrawableCompat.getAlpha(this.a) : this.f676b.f671b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.f676b.f670a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        return this.a != null ? new C0147b(this.a.getConstantState()) : null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : this.f676b.f671b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : this.f676b.f671b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a != null ? this.a.getOpacity() : this.f676b.f671b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            DrawableCompat.inflate(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = C0149b.m706a(resources, theme, attributeSet, C0144a.f667e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0163f a2 = C0163f.m770a(resources, resourceId, theme);
                        a2.m778a(false);
                        a2.setCallback(this.f679e);
                        if (this.f676b.f671b != null) {
                            this.f676b.f671b.setCallback(null);
                        }
                        this.f676b.f671b = a2;
                    }
                    a.recycle();
                } else if (Constants.KEY_TARGET.equals(name)) {
                    a = resources.obtainAttributes(attributeSet, C0144a.f668f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f677c != null) {
                            m710a(string, AnimatorInflater.loadAnimator(this.f677c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.f676b.f672c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.a != null ? this.a.isStateful() : this.f676b.f671b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.f676b.f671b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.a != null ? this.a.setLevel(i) : this.f676b.f671b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.a != null ? this.a.setState(iArr) : this.f676b.f671b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.f676b.f671b.setAlpha(i);
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.f676b.f671b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.a != null) {
            DrawableCompat.setTint(this.a, i);
        } else {
            this.f676b.f671b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            DrawableCompat.setTintList(this.a, colorStateList);
        } else {
            this.f676b.f671b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            DrawableCompat.setTintMode(this.a, mode);
        } else {
            this.f676b.f671b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.f676b.f671b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!m711a()) {
            ArrayList arrayList = this.f676b.f672c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.f676b.f672c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
