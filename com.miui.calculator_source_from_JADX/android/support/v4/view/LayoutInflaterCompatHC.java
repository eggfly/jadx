package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

class LayoutInflaterCompatHC {
    private static Field f774a;
    private static boolean f775b;

    static class FactoryWrapperHC extends FactoryWrapper implements Factory2 {
        FactoryWrapperHC(LayoutInflaterFactory layoutInflaterFactory) {
            super(layoutInflaterFactory);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.m310a(view, str, context, attributeSet);
        }
    }

    LayoutInflaterCompatHC() {
    }

    static void m1253a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        Factory2 factoryWrapperHC;
        if (layoutInflaterFactory != null) {
            factoryWrapperHC = new FactoryWrapperHC(layoutInflaterFactory);
        } else {
            factoryWrapperHC = null;
        }
        layoutInflater.setFactory2(factoryWrapperHC);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            m1254a(layoutInflater, (Factory2) factory);
        } else {
            m1254a(layoutInflater, factoryWrapperHC);
        }
    }

    static void m1254a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f775b) {
            try {
                f774a = LayoutInflater.class.getDeclaredField("mFactory2");
                f774a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f775b = true;
        }
        if (f774a != null) {
            try {
                f774a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
