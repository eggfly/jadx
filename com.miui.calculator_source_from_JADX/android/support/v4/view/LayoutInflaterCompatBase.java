package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class LayoutInflaterCompatBase {

    static class FactoryWrapper implements Factory {
        final LayoutInflaterFactory f773a;

        FactoryWrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.f773a = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f773a.m310a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f773a + "}";
        }
    }

    LayoutInflaterCompatBase() {
    }

    static void m1252a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory(layoutInflaterFactory != null ? new FactoryWrapper(layoutInflaterFactory) : null);
    }
}
