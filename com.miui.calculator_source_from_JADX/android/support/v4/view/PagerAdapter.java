package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    private DataSetObservable f4a;

    public abstract int m1a();

    public abstract boolean m12a(View view, Object obj);

    public PagerAdapter() {
        this.f4a = new DataSetObservable();
    }

    public void m10a(ViewGroup viewGroup) {
        m8a((View) viewGroup);
    }

    public Object m5a(ViewGroup viewGroup, int i) {
        return m4a((View) viewGroup, i);
    }

    public void m11a(ViewGroup viewGroup, int i, Object obj) {
        m9a((View) viewGroup, i, obj);
    }

    public void m19b(ViewGroup viewGroup, int i, Object obj) {
        m17b((View) viewGroup, i, obj);
    }

    public void m18b(ViewGroup viewGroup) {
        m16b((View) viewGroup);
    }

    public void m8a(View view) {
    }

    public Object m4a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m9a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m17b(View view, int i, Object obj) {
    }

    public void m16b(View view) {
    }

    public Parcelable m14b() {
        return null;
    }

    public void m7a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int m2a(Object obj) {
        return -1;
    }

    public void m6a(DataSetObserver dataSetObserver) {
        this.f4a.registerObserver(dataSetObserver);
    }

    public void m15b(DataSetObserver dataSetObserver) {
        this.f4a.unregisterObserver(dataSetObserver);
    }

    public CharSequence m3a(int i) {
        return null;
    }

    public float m13b(int i) {
        return 1.0f;
    }
}
