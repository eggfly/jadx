package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

class k {
    private static boolean DW;
    private static Field j6;

    static class a extends a implements Factory2 {
        a(m mVar) {
            super(mVar);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.j6.j6(view, str, context, attributeSet);
        }
    }

    static void j6(LayoutInflater layoutInflater, m mVar) {
        Factory2 aVar;
        if (mVar != null) {
            aVar = new a(mVar);
        } else {
            aVar = null;
        }
        layoutInflater.setFactory2(aVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            j6(layoutInflater, (Factory2) factory);
        } else {
            j6(layoutInflater, aVar);
        }
    }

    static void j6(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!DW) {
            try {
                j6 = LayoutInflater.class.getDeclaredField("mFactory2");
                j6.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            DW = true;
        }
        if (j6 != null) {
            try {
                j6.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
