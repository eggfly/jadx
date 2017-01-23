package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat {
    private static final AccessibilityDelegateImpl f754b;
    private static final Object f755c;
    final Object f756a;

    interface AccessibilityDelegateImpl {
        AccessibilityNodeProviderCompat m1137a(Object obj, View view);

        Object m1138a();

        Object m1139a(AccessibilityDelegateCompat accessibilityDelegateCompat);

        void m1140a(Object obj, View view, int i);

        void m1141a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        boolean m1142a(Object obj, View view, int i, Bundle bundle);

        boolean m1143a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean m1144a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m1145b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m1146c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m1147d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
        }

        public Object m1149a() {
            return null;
        }

        public Object m1150a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return null;
        }

        public boolean m1154a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void m1156b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void m1152a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void m1157c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean m1155a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void m1151a(Object obj, View view, int i) {
        }

        public void m1158d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public AccessibilityNodeProviderCompat m1148a(Object obj, View view) {
            return null;
        }

        public boolean m1153a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {

        /* renamed from: android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl.1 */
        class C00791 implements AccessibilityDelegateBridge {
            final /* synthetic */ AccessibilityDelegateCompat f750a;
            final /* synthetic */ AccessibilityDelegateIcsImpl f751b;

            C00791(AccessibilityDelegateIcsImpl accessibilityDelegateIcsImpl, AccessibilityDelegateCompat accessibilityDelegateCompat) {
                this.f751b = accessibilityDelegateIcsImpl;
                this.f750a = accessibilityDelegateCompat;
            }

            public boolean m1132a(View view, AccessibilityEvent accessibilityEvent) {
                return this.f750a.m1196b(view, accessibilityEvent);
            }

            public void m1134b(View view, AccessibilityEvent accessibilityEvent) {
                this.f750a.m1198d(view, accessibilityEvent);
            }

            public void m1131a(View view, Object obj) {
                this.f750a.m1192a(view, new AccessibilityNodeInfoCompat(obj));
            }

            public void m1135c(View view, AccessibilityEvent accessibilityEvent) {
                this.f750a.m1197c(view, accessibilityEvent);
            }

            public boolean m1133a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f750a.m1195a(viewGroup, view, accessibilityEvent);
            }

            public void m1130a(View view, int i) {
                this.f750a.m1191a(view, i);
            }

            public void m1136d(View view, AccessibilityEvent accessibilityEvent) {
                this.f750a.m1193a(view, accessibilityEvent);
            }
        }

        AccessibilityDelegateIcsImpl() {
        }

        public Object m1159a() {
            return AccessibilityDelegateCompatIcs.m1199a();
        }

        public Object m1160a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return AccessibilityDelegateCompatIcs.m1200a(new C00791(this, accessibilityDelegateCompat));
        }

        public boolean m1163a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.m1203a(obj, view, accessibilityEvent);
        }

        public void m1165b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m1205b(obj, view, accessibilityEvent);
        }

        public void m1162a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityDelegateCompatIcs.m1202a(obj, view, accessibilityNodeInfoCompat.m1797a());
        }

        public void m1166c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m1206c(obj, view, accessibilityEvent);
        }

        public boolean m1164a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.m1204a(obj, viewGroup, view, accessibilityEvent);
        }

        public void m1161a(Object obj, View view, int i) {
            AccessibilityDelegateCompatIcs.m1201a(obj, view, i);
        }

        public void m1167d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m1207d(obj, view, accessibilityEvent);
        }
    }

    static class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateIcsImpl {

        /* renamed from: android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl.1 */
        class C00801 implements AccessibilityDelegateBridgeJellyBean {
            final /* synthetic */ AccessibilityDelegateCompat f752a;
            final /* synthetic */ AccessibilityDelegateJellyBeanImpl f753b;

            C00801(AccessibilityDelegateJellyBeanImpl accessibilityDelegateJellyBeanImpl, AccessibilityDelegateCompat accessibilityDelegateCompat) {
                this.f753b = accessibilityDelegateJellyBeanImpl;
                this.f752a = accessibilityDelegateCompat;
            }

            public boolean m1181a(View view, AccessibilityEvent accessibilityEvent) {
                return this.f752a.m1196b(view, accessibilityEvent);
            }

            public void m1183b(View view, AccessibilityEvent accessibilityEvent) {
                this.f752a.m1198d(view, accessibilityEvent);
            }

            public void m1179a(View view, Object obj) {
                this.f752a.m1192a(view, new AccessibilityNodeInfoCompat(obj));
            }

            public void m1184c(View view, AccessibilityEvent accessibilityEvent) {
                this.f752a.m1197c(view, accessibilityEvent);
            }

            public boolean m1182a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f752a.m1195a(viewGroup, view, accessibilityEvent);
            }

            public void m1178a(View view, int i) {
                this.f752a.m1191a(view, i);
            }

            public void m1185d(View view, AccessibilityEvent accessibilityEvent) {
                this.f752a.m1193a(view, accessibilityEvent);
            }

            public Object m1177a(View view) {
                AccessibilityNodeProviderCompat a = this.f752a.m1189a(view);
                return a != null ? a.m1909a() : null;
            }

            public boolean m1180a(View view, int i, Bundle bundle) {
                return this.f752a.m1194a(view, i, bundle);
            }
        }

        AccessibilityDelegateJellyBeanImpl() {
        }

        public Object m1187a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return AccessibilityDelegateCompatJellyBean.m1208a(new C00801(this, accessibilityDelegateCompat));
        }

        public AccessibilityNodeProviderCompat m1186a(Object obj, View view) {
            Object a = AccessibilityDelegateCompatJellyBean.m1209a(obj, view);
            if (a != null) {
                return new AccessibilityNodeProviderCompat(a);
            }
            return null;
        }

        public boolean m1188a(Object obj, View view, int i, Bundle bundle) {
            return AccessibilityDelegateCompatJellyBean.m1210a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f754b = new AccessibilityDelegateJellyBeanImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f754b = new AccessibilityDelegateIcsImpl();
        } else {
            f754b = new AccessibilityDelegateStubImpl();
        }
        f755c = f754b.m1138a();
    }

    public AccessibilityDelegateCompat() {
        this.f756a = f754b.m1139a(this);
    }

    Object m1190a() {
        return this.f756a;
    }

    public void m1191a(View view, int i) {
        f754b.m1140a(f755c, view, i);
    }

    public void m1193a(View view, AccessibilityEvent accessibilityEvent) {
        f754b.m1147d(f755c, view, accessibilityEvent);
    }

    public boolean m1196b(View view, AccessibilityEvent accessibilityEvent) {
        return f754b.m1143a(f755c, view, accessibilityEvent);
    }

    public void m1197c(View view, AccessibilityEvent accessibilityEvent) {
        f754b.m1146c(f755c, view, accessibilityEvent);
    }

    public void m1198d(View view, AccessibilityEvent accessibilityEvent) {
        f754b.m1145b(f755c, view, accessibilityEvent);
    }

    public void m1192a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f754b.m1141a(f755c, view, accessibilityNodeInfoCompat);
    }

    public boolean m1195a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f754b.m1144a(f755c, viewGroup, view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat m1189a(View view) {
        return f754b.m1137a(f755c, view);
    }

    public boolean m1194a(View view, int i, Bundle bundle) {
        return f754b.m1142a(f755c, view, i, bundle);
    }
}
