package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class LayoutInflaterCompatBase {

    static class FactoryWrapper implements Factory {
        final LayoutInflaterFactory mDelegateFactory;

        FactoryWrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    LayoutInflaterCompatBase() {
    }

    static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof FactoryWrapper ? ((FactoryWrapper) factory).mDelegateFactory : null;
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory(layoutInflaterFactory != null ? new FactoryWrapper(layoutInflaterFactory) : null);
    }
}
