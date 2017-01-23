package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0450h;
import android.support.v7.view.menu.C0455i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import cn.sharesdk.framework.Platform;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.view.g */
public class C0430g extends MenuInflater {
    private static final Class<?>[] f1108a;
    private static final Class<?>[] f1109b;
    private final Object[] f1110c;
    private final Object[] f1111d;
    private Context f1112e;
    private Object f1113f;

    /* renamed from: android.support.v7.view.g.a */
    private static class C0428a implements OnMenuItemClickListener {
        private static final Class<?>[] f1079a;
        private Object f1080b;
        private Method f1081c;

        static {
            f1079a = new Class[]{MenuItem.class};
        }

        public C0428a(Object obj, String str) {
            this.f1080b = obj;
            Class cls = obj.getClass();
            try {
                this.f1081c = cls.getMethod(str, f1079a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1081c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1081c.invoke(this.f1080b, new Object[]{menuItem})).booleanValue();
                }
                this.f1081c.invoke(this.f1080b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: android.support.v7.view.g.b */
    private class C0429b {
        final /* synthetic */ C0430g f1082a;
        private Menu f1083b;
        private int f1084c;
        private int f1085d;
        private int f1086e;
        private int f1087f;
        private boolean f1088g;
        private boolean f1089h;
        private boolean f1090i;
        private int f1091j;
        private int f1092k;
        private CharSequence f1093l;
        private CharSequence f1094m;
        private int f1095n;
        private char f1096o;
        private char f1097p;
        private int f1098q;
        private boolean f1099r;
        private boolean f1100s;
        private boolean f1101t;
        private int f1102u;
        private int f1103v;
        private String f1104w;
        private String f1105x;
        private String f1106y;
        private ActionProvider f1107z;

        public C0429b(C0430g c0430g, Menu menu) {
            this.f1082a = c0430g;
            this.f1083b = menu;
            m1268a();
        }

        private char m1264a(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        private <T> T m1266a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f1082a.f1112e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void m1267a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1099r).setVisible(this.f1100s).setEnabled(this.f1101t).setCheckable(this.f1098q >= 1).setTitleCondensed(this.f1094m).setIcon(this.f1095n).setAlphabeticShortcut(this.f1096o).setNumericShortcut(this.f1097p);
            if (this.f1102u >= 0) {
                MenuItemCompat.setShowAsAction(menuItem, this.f1102u);
            }
            if (this.f1106y != null) {
                if (this.f1082a.f1112e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0428a(this.f1082a.m1280c(), this.f1106y));
            }
            if (menuItem instanceof C0450h) {
                C0450h c0450h = (C0450h) menuItem;
            }
            if (this.f1098q >= 2) {
                if (menuItem instanceof C0450h) {
                    ((C0450h) menuItem).m1441a(true);
                } else if (menuItem instanceof C0455i) {
                    ((C0455i) menuItem).m1464a(true);
                }
            }
            if (this.f1104w != null) {
                MenuItemCompat.setActionView(menuItem, (View) m1266a(this.f1104w, C0430g.f1108a, this.f1082a.f1110c));
            } else {
                z = false;
            }
            if (this.f1103v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    MenuItemCompat.setActionView(menuItem, this.f1103v);
                }
            }
            if (this.f1107z != null) {
                MenuItemCompat.setActionProvider(menuItem, this.f1107z);
            }
        }

        public void m1268a() {
            this.f1084c = 0;
            this.f1085d = 0;
            this.f1086e = 0;
            this.f1087f = 0;
            this.f1088g = true;
            this.f1089h = true;
        }

        public void m1269a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f1082a.f1112e.obtainStyledAttributes(attributeSet, C0417R.styleable.MenuGroup);
            this.f1084c = obtainStyledAttributes.getResourceId(C0417R.styleable.MenuGroup_android_id, 0);
            this.f1085d = obtainStyledAttributes.getInt(C0417R.styleable.MenuGroup_android_menuCategory, 0);
            this.f1086e = obtainStyledAttributes.getInt(C0417R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f1087f = obtainStyledAttributes.getInt(C0417R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1088g = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuGroup_android_visible, true);
            this.f1089h = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m1270b() {
            this.f1090i = true;
            m1267a(this.f1083b.add(this.f1084c, this.f1091j, this.f1092k, this.f1093l));
        }

        public void m1271b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f1082a.f1112e.obtainStyledAttributes(attributeSet, C0417R.styleable.MenuItem);
            this.f1091j = obtainStyledAttributes.getResourceId(C0417R.styleable.MenuItem_android_id, 0);
            this.f1092k = (obtainStyledAttributes.getInt(C0417R.styleable.MenuItem_android_menuCategory, this.f1085d) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(C0417R.styleable.MenuItem_android_orderInCategory, this.f1086e) & Platform.CUSTOMER_ACTION_MASK);
            this.f1093l = obtainStyledAttributes.getText(C0417R.styleable.MenuItem_android_title);
            this.f1094m = obtainStyledAttributes.getText(C0417R.styleable.MenuItem_android_titleCondensed);
            this.f1095n = obtainStyledAttributes.getResourceId(C0417R.styleable.MenuItem_android_icon, 0);
            this.f1096o = m1264a(obtainStyledAttributes.getString(C0417R.styleable.MenuItem_android_alphabeticShortcut));
            this.f1097p = m1264a(obtainStyledAttributes.getString(C0417R.styleable.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0417R.styleable.MenuItem_android_checkable)) {
                this.f1098q = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1098q = this.f1087f;
            }
            this.f1099r = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuItem_android_checked, false);
            this.f1100s = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuItem_android_visible, this.f1088g);
            this.f1101t = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuItem_android_enabled, this.f1089h);
            this.f1102u = obtainStyledAttributes.getInt(C0417R.styleable.MenuItem_showAsAction, -1);
            this.f1106y = obtainStyledAttributes.getString(C0417R.styleable.MenuItem_android_onClick);
            this.f1103v = obtainStyledAttributes.getResourceId(C0417R.styleable.MenuItem_actionLayout, 0);
            this.f1104w = obtainStyledAttributes.getString(C0417R.styleable.MenuItem_actionViewClass);
            this.f1105x = obtainStyledAttributes.getString(C0417R.styleable.MenuItem_actionProviderClass);
            if (this.f1105x == null) {
                z = false;
            }
            if (z && this.f1103v == 0 && this.f1104w == null) {
                this.f1107z = (ActionProvider) m1266a(this.f1105x, C0430g.f1109b, this.f1082a.f1111d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1107z = null;
            }
            obtainStyledAttributes.recycle();
            this.f1090i = false;
        }

        public SubMenu m1272c() {
            this.f1090i = true;
            SubMenu addSubMenu = this.f1083b.addSubMenu(this.f1084c, this.f1091j, this.f1092k, this.f1093l);
            m1267a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m1273d() {
            return this.f1090i;
        }
    }

    static {
        f1108a = new Class[]{Context.class};
        f1109b = f1108a;
    }

    public C0430g(Context context) {
        super(context);
        this.f1112e = context;
        this.f1110c = new Object[]{context};
        this.f1111d = this.f1110c;
    }

    private Object m1275a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m1275a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1276a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m1269a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m1271b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m1272c();
        r10.m1276a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m1268a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.m1273d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1107z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.f1107z;
        r3 = r3.hasSubMenu();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.m1272c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.m1270b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object m1280c() {
        if (this.f1113f == null) {
            this.f1113f = m1275a(this.f1112e);
        }
        return this.f1113f;
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof SupportMenu) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1112e.getResources().getLayout(i);
                m1276a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
