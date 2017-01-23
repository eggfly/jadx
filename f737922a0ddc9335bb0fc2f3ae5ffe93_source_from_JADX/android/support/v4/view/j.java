package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class j {

    static class a implements Factory {
        final m j6;

        a(m mVar) {
            this.j6 = mVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.j6.j6(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.j6 + "}";
        }
    }

    static void j6(LayoutInflater layoutInflater, m mVar) {
        layoutInflater.setFactory(mVar != null ? new a(mVar) : null);
    }
}
