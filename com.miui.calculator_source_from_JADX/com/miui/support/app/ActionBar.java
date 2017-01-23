package com.miui.support.app;

public abstract class ActionBar extends android.app.ActionBar {

    public interface FragmentViewPagerChangeListener {
        void m3248a(int i);

        void m3249a(int i, float f, boolean z, boolean z2);

        void m3250b(int i);
    }

    public interface OnScrollListener {
        void m3251a();

        void m3252a(float f, int i);

        void m3253a(int i, float f);

        void m3254b();

        boolean m3255c();
    }

    public abstract void m3256a(int i);

    public abstract void m3257a(boolean z);

    public abstract void m3258b(boolean z);

    public abstract void m3259c(boolean z);
}
