package com.miui.support.internal.util;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.C0234R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.variable.Android_View_View_class;
import com.miui.support.internal.variable.Android_View_View_class.Factory;
import com.miui.support.util.ViewUtils;
import com.miui.support.view.OnTaggingDrawableState;

public class TaggingDrawableHelper {
    static int[] f2573a;
    private static final Android_View_View_class f2574b;
    private static final Android_Graphics_Drawable_Drawable_class f2575c;
    private static final ThreadLocal<Rect> f2576d;

    private TaggingDrawableHelper() {
    }

    static {
        f2574b = Factory.getInstance().get();
        f2575c = Android_Graphics_Drawable_Drawable_class.Factory.getInstance().get();
        f2573a = new int[]{C0234R.attr.children_sequence_state};
        f2576d = new ThreadLocal();
    }

    public static void m4252a(ViewGroup viewGroup) {
        if (ViewUtils.m5453a(viewGroup)) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    m4250a(childAt, m4248a(viewGroup, i, true), m4248a(viewGroup, i, false));
                }
            }
        }
    }

    private static int m4248a(ViewGroup viewGroup, int i, boolean z) {
        boolean a;
        boolean a2;
        if (viewGroup instanceof OnTaggingDrawableState) {
            OnTaggingDrawableState onTaggingDrawableState = (OnTaggingDrawableState) viewGroup;
            a = onTaggingDrawableState.m5620a(viewGroup, i, z, false);
            a2 = onTaggingDrawableState.m5620a(viewGroup, i, z, true);
        } else {
            a = m4255a(viewGroup, i, z, false);
            a2 = m4255a(viewGroup, i, z, true);
        }
        boolean a3 = ViewUtils.m5452a((View) viewGroup);
        if (!a) {
            return a2 ? a3 ? z ? C0234R.attr.state_last_h : C0234R.attr.state_first_v : z ? C0234R.attr.state_first_h : C0234R.attr.state_first_v : z ? C0234R.attr.state_single_h : C0234R.attr.state_single_v;
        } else {
            if (!a2) {
                return a3 ? z ? C0234R.attr.state_first_h : C0234R.attr.state_last_v : z ? C0234R.attr.state_last_h : C0234R.attr.state_last_v;
            } else {
                if (z) {
                    return C0234R.attr.state_middle_h;
                }
                return C0234R.attr.state_middle_v;
            }
        }
    }

    private static boolean m4256b(ViewGroup viewGroup, int i, boolean z) {
        View view;
        int i2 = -1;
        int i3 = z ? 1 : -1;
        if (z) {
            i2 = viewGroup.getChildCount();
        }
        View childAt = viewGroup.getChildAt(i);
        for (int i4 = i + i3; i4 != i2; i4 += i3) {
            View childAt2 = viewGroup.getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                view = childAt2;
                break;
            }
        }
        view = null;
        if (view == null || view.getVisibility() == 4 || !m4254a(view, childAt)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4255a(android.view.ViewGroup r8, int r9, boolean r10, boolean r11) {
        /*
        r2 = 0;
        r1 = 1;
        r0 = r8 instanceof android.widget.AbsListView;
        if (r0 == 0) goto L_0x00ab;
    L_0x0006:
        r8 = (android.widget.AbsListView) r8;
        r0 = r8 instanceof android.widget.GridView;
        if (r0 == 0) goto L_0x0038;
    L_0x000c:
        r0 = r8;
        r0 = (android.widget.GridView) r0;
        r0 = r0.getNumColumns();
    L_0x0013:
        r3 = r8.getChildCount();
        if (r10 == 0) goto L_0x004d;
    L_0x0019:
        r4 = r9 % r0;
        if (r0 == r1) goto L_0x00d1;
    L_0x001d:
        if (r11 == 0) goto L_0x003a;
    L_0x001f:
        r1 = r4 + 1;
        if (r1 >= r0) goto L_0x00d1;
    L_0x0023:
        r0 = r9 + 1;
        if (r0 >= r3) goto L_0x00d1;
    L_0x0027:
        r0 = r8.getChildAt(r9);
        r1 = r9 + 1;
        r1 = r8.getChildAt(r1);
        r0 = m4254a(r0, r1);
    L_0x0035:
        r1 = r0;
    L_0x0036:
        r2 = r1;
    L_0x0037:
        return r2;
    L_0x0038:
        r0 = r1;
        goto L_0x0013;
    L_0x003a:
        r0 = r4 + -1;
        if (r0 < 0) goto L_0x00d1;
    L_0x003e:
        r0 = r8.getChildAt(r9);
        r1 = r9 + -1;
        r1 = r8.getChildAt(r1);
        r0 = m4254a(r0, r1);
        goto L_0x0035;
    L_0x004d:
        r4 = r8.getFirstVisiblePosition();
        r5 = r8.getAdapter();
        r6 = r8.getCount();
        if (r11 == 0) goto L_0x0082;
    L_0x005b:
        r7 = r9 + r0;
        if (r7 >= r3) goto L_0x006d;
    L_0x005f:
        r1 = r8.getChildAt(r9);
        r0 = r0 + r9;
        r0 = r8.getChildAt(r0);
        r1 = m4254a(r1, r0);
        goto L_0x0036;
    L_0x006d:
        r3 = r9 + r0;
        r3 = r3 + r4;
        if (r3 >= r6) goto L_0x00ce;
    L_0x0072:
        r3 = r9 + r4;
        r3 = r5.getItemViewType(r3);
        r0 = r0 + r9;
        r0 = r0 + r4;
        r0 = r5.getItemViewType(r0);
        if (r3 == r0) goto L_0x0036;
    L_0x0080:
        r1 = r2;
        goto L_0x0036;
    L_0x0082:
        r3 = r9 - r0;
        if (r3 < 0) goto L_0x0095;
    L_0x0086:
        r1 = r8.getChildAt(r9);
        r0 = r9 - r0;
        r0 = r8.getChildAt(r0);
        r1 = m4254a(r1, r0);
        goto L_0x0036;
    L_0x0095:
        r3 = r9 - r0;
        r3 = r3 + r4;
        if (r3 < 0) goto L_0x00ce;
    L_0x009a:
        r3 = r9 + r4;
        r3 = r5.getItemViewType(r3);
        r0 = r9 - r0;
        r0 = r0 + r4;
        r0 = r5.getItemViewType(r0);
        if (r3 == r0) goto L_0x0036;
    L_0x00a9:
        r1 = r2;
        goto L_0x0036;
    L_0x00ab:
        r0 = r8 instanceof android.widget.LinearLayout;
        if (r0 == 0) goto L_0x00cc;
    L_0x00af:
        r0 = r8;
        r0 = (android.widget.LinearLayout) r0;
        r0 = r0.getOrientation();
        if (r10 == 0) goto L_0x00ba;
    L_0x00b8:
        if (r0 == 0) goto L_0x00be;
    L_0x00ba:
        if (r10 != 0) goto L_0x00cc;
    L_0x00bc:
        if (r0 != r1) goto L_0x00cc;
    L_0x00be:
        if (r1 != 0) goto L_0x00c6;
    L_0x00c0:
        r0 = r8 instanceof android.widget.LinearLayout;
        if (r0 != 0) goto L_0x0037;
    L_0x00c4:
        if (r10 == 0) goto L_0x0037;
    L_0x00c6:
        r2 = m4256b(r8, r9, r11);
        goto L_0x0037;
    L_0x00cc:
        r1 = r2;
        goto L_0x00be;
    L_0x00ce:
        r1 = r2;
        goto L_0x0036;
    L_0x00d1:
        r0 = r2;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.util.TaggingDrawableHelper.a(android.view.ViewGroup, int, boolean, boolean):boolean");
    }

    private static boolean m4254a(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        Drawable background = view.getBackground();
        Drawable background2 = view2.getBackground();
        if (background == background2) {
            return true;
        }
        if (background == null || background2 == null) {
            return false;
        }
        int id = f2575c.getId(background);
        int id2 = f2575c.getId(background2);
        if (id == 0 || id != id2) {
            return false;
        }
        return true;
    }

    private static void m4250a(View view, int i, int i2) {
        int horizontalState = f2574b.getHorizontalState(view);
        int verticalState = f2574b.getVerticalState(view);
        if (horizontalState != i || verticalState != i2) {
            f2574b.setHorizontalState(view, i);
            f2574b.setVerticalState(view, i2);
            horizontalState = view.getPaddingLeft();
            verticalState = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingBottom = view.getPaddingBottom();
            view.refreshDrawableState();
            if (horizontalState != view.getPaddingLeft() || verticalState != view.getPaddingTop() || paddingRight != view.getPaddingRight() || paddingBottom != view.getPaddingBottom()) {
                f2574b.relayout(view);
            }
        }
    }

    public static void m4249a(View view) {
        Drawable background = view.getBackground();
        if (background != null && background.isStateful()) {
            ConstantState constantState = background.getConstantState();
            if (background.isStateful() && constantState != null && (constantState instanceof DrawableContainerState) && ((DrawableContainerState) constantState).getConstantPadding() == null) {
                Rect rect = (Rect) f2576d.get();
                if (rect == null) {
                    rect = new Rect();
                    f2576d.set(rect);
                }
                if (!background.getPadding(rect)) {
                    return;
                }
                if (rect.left != view.getPaddingLeft() || rect.top != view.getPaddingTop() || rect.right != view.getPaddingRight() || rect.bottom != view.getPaddingBottom()) {
                    switch (f2575c.getLayoutDirection(background)) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            view.setPadding(rect.right, rect.top, rect.left, rect.bottom);
                        default:
                            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    }
                }
            }
        }
    }

    public static void m4253a(ViewGroup viewGroup, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes(attributeSet, f2573a);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        ViewUtils.m5450a(viewGroup, z);
    }

    public static void m4251a(View view, AttributeSet attributeSet) {
        if (!f2574b.hasInitViewSequenceStates(view)) {
            f2574b.setHasInitViewSequenceStates(view, true);
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, C0234R.styleable.DrawableStates);
            int length = C0234R.styleable.DrawableStates.length;
            int i = C0234R.attr.state_single_h;
            int i2 = C0234R.attr.state_single_v;
            int i3 = 0;
            while (i3 < length) {
                if (obtainStyledAttributes.getBoolean(i3, false)) {
                    if (i3 == C0234R.styleable.DrawableStates_state_first_h || i3 == C0234R.styleable.DrawableStates_state_middle_h || i3 == C0234R.styleable.DrawableStates_state_last_h || i3 == C0234R.styleable.DrawableStates_state_single_h) {
                        i = C0234R.styleable.DrawableStates[i3];
                    } else if (i3 == C0234R.styleable.DrawableStates_state_first_v || i3 == C0234R.styleable.DrawableStates_state_middle_v || i3 == C0234R.styleable.DrawableStates_state_last_v || i3 == C0234R.styleable.DrawableStates_state_single_v) {
                        i2 = C0234R.styleable.DrawableStates[i3];
                    }
                }
                i3++;
            }
            obtainStyledAttributes.recycle();
            f2574b.setHorizontalState(view, i);
            f2574b.setVerticalState(view, i2);
        }
    }
}
