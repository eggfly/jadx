package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    private static final AccessibilityNodeProviderImpl f953a;
    private final Object f954b;

    interface AccessibilityNodeProviderImpl {
        Object m1890a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        public Object m1897a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {

        /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1 */
        class C01001 implements AccessibilityNodeInfoBridge {
            final /* synthetic */ AccessibilityNodeProviderCompat f949a;
            final /* synthetic */ AccessibilityNodeProviderJellyBeanImpl f950b;

            C01001(AccessibilityNodeProviderJellyBeanImpl accessibilityNodeProviderJellyBeanImpl, AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
                this.f950b = accessibilityNodeProviderJellyBeanImpl;
                this.f949a = accessibilityNodeProviderCompat;
            }

            public boolean m1896a(int i, int i2, Bundle bundle) {
                return this.f949a.m1911a(i, i2, bundle);
            }

            public List<Object> m1895a(String str, int i) {
                List a = this.f949a.m1910a(str, i);
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((AccessibilityNodeInfoCompat) a.get(i2)).m1797a());
                }
                return arrayList;
            }

            public Object m1894a(int i) {
                AccessibilityNodeInfoCompat a = this.f949a.m1908a(i);
                if (a == null) {
                    return null;
                }
                return a.m1797a();
            }
        }

        AccessibilityNodeProviderJellyBeanImpl() {
        }

        public Object m1898a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatJellyBean.m1913a(new C01001(this, accessibilityNodeProviderCompat));
        }
    }

    static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {

        /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl.1 */
        class C01011 implements AccessibilityNodeInfoBridge {
            final /* synthetic */ AccessibilityNodeProviderCompat f951a;
            final /* synthetic */ AccessibilityNodeProviderKitKatImpl f952b;

            C01011(AccessibilityNodeProviderKitKatImpl accessibilityNodeProviderKitKatImpl, AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
                this.f952b = accessibilityNodeProviderKitKatImpl;
                this.f951a = accessibilityNodeProviderCompat;
            }

            public boolean m1905a(int i, int i2, Bundle bundle) {
                return this.f951a.m1911a(i, i2, bundle);
            }

            public List<Object> m1904a(String str, int i) {
                List a = this.f951a.m1910a(str, i);
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((AccessibilityNodeInfoCompat) a.get(i2)).m1797a());
                }
                return arrayList;
            }

            public Object m1903a(int i) {
                AccessibilityNodeInfoCompat a = this.f951a.m1908a(i);
                if (a == null) {
                    return null;
                }
                return a.m1797a();
            }

            public Object m1906b(int i) {
                AccessibilityNodeInfoCompat b = this.f951a.m1912b(i);
                if (b == null) {
                    return null;
                }
                return b.m1797a();
            }
        }

        AccessibilityNodeProviderKitKatImpl() {
        }

        public Object m1907a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatKitKat.m1914a(new C01011(this, accessibilityNodeProviderCompat));
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f953a = new AccessibilityNodeProviderKitKatImpl();
        } else if (VERSION.SDK_INT >= 16) {
            f953a = new AccessibilityNodeProviderJellyBeanImpl();
        } else {
            f953a = new AccessibilityNodeProviderStubImpl();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.f954b = f953a.m1890a(this);
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f954b = obj;
    }

    public Object m1909a() {
        return this.f954b;
    }

    public AccessibilityNodeInfoCompat m1908a(int i) {
        return null;
    }

    public boolean m1911a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<AccessibilityNodeInfoCompat> m1910a(String str, int i) {
        return null;
    }

    public AccessibilityNodeInfoCompat m1912b(int i) {
        return null;
    }
}
