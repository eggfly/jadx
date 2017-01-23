package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p010a.p011a.C0149b;
import android.support.p010a.p011a.C0163f;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v7.widget.l */
public final class C0616l {
    private static final Mode f2075a;
    private static C0616l f2076b;
    private static final C0614b f2077c;
    private static final int[] f2078d;
    private static final int[] f2079e;
    private static final int[] f2080f;
    private static final int[] f2081g;
    private static final int[] f2082h;
    private static final int[] f2083i;
    private WeakHashMap<Context, SparseArray<ColorStateList>> f2084j;
    private ArrayMap<String, C0612c> f2085k;
    private SparseArray<String> f2086l;
    private final Object f2087m;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> f2088n;
    private TypedValue f2089o;

    /* renamed from: android.support.v7.widget.l.c */
    private interface C0612c {
        Drawable m2660a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* renamed from: android.support.v7.widget.l.a */
    private static class C0613a implements C0612c {
        private C0613a() {
        }

        public Drawable m2661a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0149b.m708a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: android.support.v7.widget.l.b */
    private static class C0614b extends LruCache<Integer, PorterDuffColorFilter> {
        public C0614b(int i) {
            super(i);
        }

        private static int m2662b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter m2663a(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(C0614b.m2662b(i, mode)));
        }

        PorterDuffColorFilter m2664a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(C0614b.m2662b(i, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: android.support.v7.widget.l.d */
    private static class C0615d implements C0612c {
        private C0615d() {
        }

        public Drawable m2665a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0163f.m771a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    static {
        f2075a = Mode.SRC_IN;
        f2077c = new C0614b(6);
        f2078d = new int[]{C0417R.drawable.abc_textfield_search_default_mtrl_alpha, C0417R.drawable.abc_textfield_default_mtrl_alpha, C0417R.drawable.abc_ab_share_pack_mtrl_alpha};
        f2079e = new int[]{C0417R.drawable.abc_ic_ab_back_mtrl_am_alpha, C0417R.drawable.abc_ic_go_search_api_mtrl_alpha, C0417R.drawable.abc_ic_search_api_mtrl_alpha, C0417R.drawable.abc_ic_commit_search_api_mtrl_alpha, C0417R.drawable.abc_ic_clear_mtrl_alpha, C0417R.drawable.abc_ic_menu_share_mtrl_alpha, C0417R.drawable.abc_ic_menu_copy_mtrl_am_alpha, C0417R.drawable.abc_ic_menu_cut_mtrl_alpha, C0417R.drawable.abc_ic_menu_selectall_mtrl_alpha, C0417R.drawable.abc_ic_menu_paste_mtrl_am_alpha, C0417R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha, C0417R.drawable.abc_ic_voice_search_api_mtrl_alpha};
        f2080f = new int[]{C0417R.drawable.abc_textfield_activated_mtrl_alpha, C0417R.drawable.abc_textfield_search_activated_mtrl_alpha, C0417R.drawable.abc_cab_background_top_mtrl_alpha, C0417R.drawable.abc_text_cursor_material};
        f2081g = new int[]{C0417R.drawable.abc_popup_background_mtrl_mult, C0417R.drawable.abc_cab_background_internal_bg, C0417R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        f2082h = new int[]{C0417R.drawable.abc_edit_text_material, C0417R.drawable.abc_tab_indicator_material, C0417R.drawable.abc_textfield_search_material, C0417R.drawable.abc_spinner_mtrl_am_alpha, C0417R.drawable.abc_spinner_textfield_background_material, C0417R.drawable.abc_ratingbar_full_material, C0417R.drawable.abc_switch_track_mtrl_alpha, C0417R.drawable.abc_switch_thumb_material, C0417R.drawable.abc_btn_default_mtrl_shape, C0417R.drawable.abc_btn_borderless_material};
        f2083i = new int[]{C0417R.drawable.abc_btn_check_material, C0417R.drawable.abc_btn_radio_material};
    }

    public C0616l() {
        this.f2087m = new Object();
        this.f2088n = new WeakHashMap(0);
    }

    private static long m2666a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private ColorStateList m2667a(Context context) {
        int a = bc.m2491a(context, C0417R.attr.colorControlNormal);
        int a2 = bc.m2491a(context, C0417R.attr.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{bc.f1969a, bc.m2495c(context, C0417R.attr.colorControlNormal), bc.f1970b, a2, bc.f1971c, a2, bc.f1972d};
        iArr[3] = a2;
        r2[4] = bc.f1973e;
        iArr[4] = a2;
        r2[5] = bc.f1974f;
        iArr[5] = a2;
        r2[6] = bc.f1976h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    public static PorterDuffColorFilter m2668a(int i, Mode mode) {
        PorterDuffColorFilter a = f2077c.m2663a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2077c.m2664a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter m2669a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : C0616l.m2668a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable m2670a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m2698b(context, i);
        if (b != null) {
            if (ak.m2322c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(drawable, b);
            Mode a = m2694a(i);
            if (a == null) {
                return drawable;
            }
            DrawableCompat.setTintMode(drawable, a);
            return drawable;
        } else if (i == C0417R.drawable.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0616l.m2674a(r0.findDrawableByLayerId(16908288), bc.m2491a(context, C0417R.attr.colorControlNormal), f2075a);
            C0616l.m2674a(r0.findDrawableByLayerId(16908303), bc.m2491a(context, C0417R.attr.colorControlNormal), f2075a);
            C0616l.m2674a(r0.findDrawableByLayerId(16908301), bc.m2491a(context, C0417R.attr.colorControlActivated), f2075a);
            return drawable;
        } else if (i != C0417R.drawable.abc_ratingbar_indicator_material && i != C0417R.drawable.abc_ratingbar_small_material) {
            return (C0616l.m2678a(context, i, drawable) || !z) ? drawable : null;
        } else {
            r0 = (LayerDrawable) drawable;
            C0616l.m2674a(r0.findDrawableByLayerId(16908288), bc.m2495c(context, C0417R.attr.colorControlNormal), f2075a);
            C0616l.m2674a(r0.findDrawableByLayerId(16908303), bc.m2491a(context, C0417R.attr.colorControlActivated), f2075a);
            C0616l.m2674a(r0.findDrawableByLayerId(16908301), bc.m2491a(context, C0417R.attr.colorControlActivated), f2075a);
            return drawable;
        }
    }

    private Drawable m2671a(Context context, long j) {
        synchronized (this.f2087m) {
            LongSparseArray longSparseArray = (LongSparseArray) this.f2088n.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) longSparseArray.get(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                longSparseArray.delete(j);
            }
            return null;
        }
    }

    public static C0616l m2672a() {
        if (f2076b == null) {
            f2076b = new C0616l();
            C0616l.m2676a(f2076b);
        }
        return f2076b;
    }

    private void m2673a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2084j == null) {
            this.f2084j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f2084j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f2084j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private static void m2674a(Drawable drawable, int i, Mode mode) {
        if (ak.m2322c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2075a;
        }
        drawable.setColorFilter(C0616l.m2668a(i, mode));
    }

    public static void m2675a(Drawable drawable, bf bfVar, int[] iArr) {
        if (!ak.m2322c(drawable) || drawable.mutate() == drawable) {
            if (bfVar.f1985d || bfVar.f1984c) {
                drawable.setColorFilter(C0616l.m2669a(bfVar.f1985d ? bfVar.f1982a : null, bfVar.f1984c ? bfVar.f1983b : f2075a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static void m2676a(C0616l c0616l) {
        int i = VERSION.SDK_INT;
        if (i < 23) {
            c0616l.m2677a("vector", new C0615d());
            if (i >= 11) {
                c0616l.m2677a("animated-vector", new C0613a());
            }
        }
    }

    private void m2677a(String str, C0612c c0612c) {
        if (this.f2085k == null) {
            this.f2085k = new ArrayMap();
        }
        this.f2085k.put(str, c0612c);
    }

    static boolean m2678a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f2075a;
        if (C0616l.m2680a(f2078d, i)) {
            i2 = C0417R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0616l.m2680a(f2080f, i)) {
            i2 = C0417R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0616l.m2680a(f2081g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0417R.drawable.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (ak.m2322c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0616l.m2668a(bc.m2491a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean m2679a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f2087m) {
            LongSparseArray longSparseArray = (LongSparseArray) this.f2088n.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.f2088n.put(context, longSparseArray);
            }
            longSparseArray.put(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean m2680a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList m2681b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f1969a, bc.m2495c(context, C0417R.attr.colorControlNormal), bc.f1973e};
        iArr[1] = bc.m2491a(context, C0417R.attr.colorControlActivated);
        r0[2] = bc.f1976h;
        iArr[2] = bc.m2491a(context, C0417R.attr.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m2682c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f1969a, bc.m2492a(context, 16842800, 0.1f), bc.f1973e};
        iArr[1] = bc.m2492a(context, C0417R.attr.colorControlActivated, 0.3f);
        r0[2] = bc.f1976h;
        iArr[2] = bc.m2492a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private Drawable m2683c(Context context, int i) {
        if (this.f2089o == null) {
            this.f2089o = new TypedValue();
        }
        TypedValue typedValue = this.f2089o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0616l.m2666a(typedValue);
        Drawable a2 = m2671a(context, a);
        if (a2 == null) {
            if (i == C0417R.drawable.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m2695a(context, C0417R.drawable.abc_cab_background_internal_bg), m2695a(context, C0417R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m2679a(context, a, a2);
            }
        }
        return a2;
    }

    private ColorStateList m2684d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = bc.m2494b(context, C0417R.attr.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = bc.f1969a;
            iArr2[0] = bc.m2495c(context, C0417R.attr.colorSwitchThumbNormal);
            iArr[1] = bc.f1973e;
            iArr2[1] = bc.m2491a(context, C0417R.attr.colorControlActivated);
            iArr[2] = bc.f1976h;
            iArr2[2] = bc.m2491a(context, C0417R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = bc.f1969a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = bc.f1973e;
            iArr2[1] = bc.m2491a(context, C0417R.attr.colorControlActivated);
            iArr[2] = bc.f1976h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2685d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f2085k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f2085k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f2086l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f2086l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f2085k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f2086l = r0;
    L_0x0036:
        r0 = r9.f2089o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f2089o = r0;
    L_0x0041:
        r2 = r9.f2089o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0616l.m2666a(r2);
        r1 = r9.m2671a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f2086l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2086l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2085k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0616l.C0612c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.m2660a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m2679a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList m2686e(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f1969a, bc.m2495c(context, C0417R.attr.colorControlNormal), bc.f1975g};
        iArr[1] = bc.m2491a(context, C0417R.attr.colorControlNormal);
        r0[2] = bc.f1976h;
        iArr[2] = bc.m2491a(context, C0417R.attr.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m2687e(Context context, int i) {
        if (this.f2084j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f2084j.get(context);
        return sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
    }

    private ColorStateList m2688f(Context context) {
        return m2689f(context, bc.m2491a(context, C0417R.attr.colorButtonNormal));
    }

    private ColorStateList m2689f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = bc.m2491a(context, C0417R.attr.colorControlHighlight);
        r0[0] = bc.f1969a;
        r1[0] = bc.m2495c(context, C0417R.attr.colorButtonNormal);
        r0[1] = bc.f1972d;
        r1[1] = ColorUtils.compositeColors(a, i);
        r0[2] = bc.f1970b;
        r1[2] = ColorUtils.compositeColors(a, i);
        r0[3] = bc.f1976h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m2690g(Context context) {
        return m2689f(context, 0);
    }

    private ColorStateList m2691h(Context context) {
        return m2689f(context, bc.m2491a(context, C0417R.attr.colorAccent));
    }

    private ColorStateList m2692i(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{bc.f1969a, bc.m2495c(context, C0417R.attr.colorControlNormal), bc.f1975g};
        iArr[1] = bc.m2491a(context, C0417R.attr.colorControlNormal);
        r0[2] = bc.f1976h;
        iArr[2] = bc.m2491a(context, C0417R.attr.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m2693j(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{bc.f1969a, bc.m2495c(context, C0417R.attr.colorControlActivated)};
        r0[1] = bc.f1976h;
        iArr[1] = bc.m2491a(context, C0417R.attr.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    final Mode m2694a(int i) {
        return i == C0417R.drawable.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public Drawable m2695a(Context context, int i) {
        return m2696a(context, i, false);
    }

    public Drawable m2696a(Context context, int i, boolean z) {
        Drawable d = m2685d(context, i);
        if (d == null) {
            d = m2683c(context, i);
        }
        if (d == null) {
            d = ContextCompat.getDrawable(context, i);
        }
        if (d != null) {
            d = m2670a(context, i, z, d);
        }
        if (d != null) {
            ak.m2321b(d);
        }
        return d;
    }

    public final Drawable m2697a(Context context, bj bjVar, int i) {
        Drawable d = m2685d(context, i);
        if (d == null) {
            d = bjVar.m2568a(i);
        }
        return d != null ? m2670a(context, i, false, d) : null;
    }

    public final ColorStateList m2698b(Context context, int i) {
        ColorStateList e = m2687e(context, i);
        if (e == null) {
            if (i == C0417R.drawable.abc_edit_text_material) {
                e = m2686e(context);
            } else if (i == C0417R.drawable.abc_switch_track_mtrl_alpha) {
                e = m2682c(context);
            } else if (i == C0417R.drawable.abc_switch_thumb_material) {
                e = m2684d(context);
            } else if (i == C0417R.drawable.abc_btn_default_mtrl_shape) {
                e = m2688f(context);
            } else if (i == C0417R.drawable.abc_btn_borderless_material) {
                e = m2690g(context);
            } else if (i == C0417R.drawable.abc_btn_colored_material) {
                e = m2691h(context);
            } else if (i == C0417R.drawable.abc_spinner_mtrl_am_alpha || i == C0417R.drawable.abc_spinner_textfield_background_material) {
                e = m2692i(context);
            } else if (C0616l.m2680a(f2079e, i)) {
                e = bc.m2494b(context, C0417R.attr.colorControlNormal);
            } else if (C0616l.m2680a(f2082h, i)) {
                e = m2667a(context);
            } else if (C0616l.m2680a(f2083i, i)) {
                e = m2681b(context);
            } else if (i == C0417R.drawable.abc_seekbar_thumb_material) {
                e = m2693j(context);
            }
            if (e != null) {
                m2673a(context, i, e);
            }
        }
        return e;
    }
}
