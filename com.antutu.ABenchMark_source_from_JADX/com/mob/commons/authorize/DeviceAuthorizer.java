package com.mob.commons.authorize;

import android.content.Context;
import com.mob.commons.C3972a;
import com.mob.commons.C3983b;
import com.mob.commons.MobProduct;

public final class DeviceAuthorizer {

    /* renamed from: com.mob.commons.authorize.DeviceAuthorizer.1 */
    static class C39791 implements MobProduct {
        final /* synthetic */ MobProduct f13326a;

        C39791(MobProduct mobProduct) {
            this.f13326a = mobProduct;
        }

        public String getProductAppkey() {
            return this.f13326a.getProductAppkey();
        }

        public String getProductTag() {
            return this.f13326a.getProductTag();
        }

        public int getSdkver() {
            return this.f13326a.getSdkver();
        }
    }

    public static synchronized String authorize(Context context, MobProduct mobProduct) {
        String a;
        synchronized (DeviceAuthorizer.class) {
            C3983b.m16407a(context).m16410a(mobProduct);
            C3982a c3982a = new C3982a();
            a = (mobProduct == null || !C3972a.m16346f(context)) ? c3982a.m16405a(context) : c3982a.m16406a(context, mobProduct);
        }
        return a;
    }

    public static String authorize(Context context, MobProduct mobProduct) {
        return authorize(context, new C39791(mobProduct));
    }
}
