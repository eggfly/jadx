package android.support.v4.view;

import android.view.LayoutInflater;

class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    static void m1255a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new FactoryWrapperHC(layoutInflaterFactory) : null);
    }
}
