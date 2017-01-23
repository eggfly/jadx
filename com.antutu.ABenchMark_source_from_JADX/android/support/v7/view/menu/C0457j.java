package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.menu.C0455i.C0451a;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* renamed from: android.support.v7.view.menu.j */
class C0457j extends C0455i {

    /* renamed from: android.support.v7.view.menu.j.a */
    class C0456a extends C0451a implements VisibilityListener {
        ActionProvider.VisibilityListener f1266c;
        final /* synthetic */ C0457j f1267d;

        public C0456a(C0457j c0457j, Context context, android.view.ActionProvider actionProvider) {
            this.f1267d = c0457j;
            super(c0457j, context, actionProvider);
        }

        public boolean isVisible() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1266c != null) {
                this.f1266c.onActionProviderVisibilityChanged(z);
            }
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.a.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            VisibilityListener visibilityListener2;
            this.f1266c = visibilityListener;
            android.view.ActionProvider actionProvider = this.a;
            if (visibilityListener == null) {
                visibilityListener2 = null;
            }
            actionProvider.setVisibilityListener(visibilityListener2);
        }
    }

    C0457j(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    C0451a m1465a(android.view.ActionProvider actionProvider) {
        return new C0456a(this, this.a, actionProvider);
    }
}
