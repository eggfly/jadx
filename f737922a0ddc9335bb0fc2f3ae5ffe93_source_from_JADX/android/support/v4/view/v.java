package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class v {
    private DataSetObservable j6;

    public abstract int DW();

    public abstract boolean j6(View view, Object obj);

    public v() {
        this.j6 = new DataSetObservable();
    }

    public void j6(ViewGroup viewGroup) {
        j6((View) viewGroup);
    }

    public Object j6(ViewGroup viewGroup, int i) {
        return j6((View) viewGroup, i);
    }

    public void j6(ViewGroup viewGroup, int i, Object obj) {
        j6((View) viewGroup, i, obj);
    }

    public void DW(ViewGroup viewGroup, int i, Object obj) {
        DW((View) viewGroup, i, obj);
    }

    public void DW(ViewGroup viewGroup) {
        DW((View) viewGroup);
    }

    public void j6(View view) {
    }

    public Object j6(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void j6(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void DW(View view, int i, Object obj) {
    }

    public void DW(View view) {
    }

    public Parcelable j6() {
        return null;
    }

    public void j6(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int j6(Object obj) {
        return -1;
    }

    public void FH() {
        this.j6.notifyChanged();
    }

    public void j6(DataSetObserver dataSetObserver) {
        this.j6.registerObserver(dataSetObserver);
    }

    public void DW(DataSetObserver dataSetObserver) {
        this.j6.unregisterObserver(dataSetObserver);
    }

    public CharSequence DW(int i) {
        return null;
    }

    public float FH(int i) {
        return 1.0f;
    }
}
