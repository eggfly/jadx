package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.v;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class p extends v {
    private q DW;
    private ArrayList<SavedState> FH;
    private ArrayList<Fragment> Hw;
    private final n j6;
    private Fragment v5;

    public abstract Fragment j6(int i);

    public p(n nVar) {
        this.DW = null;
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.v5 = null;
        this.j6 = nVar;
    }

    public void j6(ViewGroup viewGroup) {
    }

    public Object j6(ViewGroup viewGroup, int i) {
        if (this.Hw.size() > i) {
            Fragment fragment = (Fragment) this.Hw.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.DW == null) {
            this.DW = this.j6.j6();
        }
        Fragment j6 = j6(i);
        if (this.FH.size() > i) {
            SavedState savedState = (SavedState) this.FH.get(i);
            if (savedState != null) {
                j6.j6(savedState);
            }
        }
        while (this.Hw.size() <= i) {
            this.Hw.add(null);
        }
        j6.Hw(false);
        j6.v5(false);
        this.Hw.set(i, j6);
        this.DW.j6(viewGroup.getId(), j6);
        return j6;
    }

    public void j6(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.DW == null) {
            this.DW = this.j6.j6();
        }
        while (this.FH.size() <= i) {
            this.FH.add(null);
        }
        this.FH.set(i, this.j6.j6(fragment));
        this.Hw.set(i, null);
        this.DW.j6(fragment);
    }

    public void DW(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.v5) {
            if (this.v5 != null) {
                this.v5.Hw(false);
                this.v5.v5(false);
            }
            if (fragment != null) {
                fragment.Hw(true);
                fragment.v5(true);
            }
            this.v5 = fragment;
        }
    }

    public void DW(ViewGroup viewGroup) {
        if (this.DW != null) {
            this.DW.DW();
            this.DW = null;
            this.j6.DW();
        }
    }

    public boolean j6(View view, Object obj) {
        return ((Fragment) obj).Ws() == view;
    }

    public Parcelable j6() {
        Bundle bundle = null;
        if (this.FH.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.FH.size()];
            this.FH.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.Hw.size(); i++) {
            Fragment fragment = (Fragment) this.Hw.get(i);
            if (fragment != null && fragment.we()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.j6.j6(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public void j6(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.FH.clear();
            this.Hw.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.FH.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment j6 = this.j6.j6(bundle, str);
                    if (j6 != null) {
                        while (this.Hw.size() <= parseInt) {
                            this.Hw.add(null);
                        }
                        j6.Hw(false);
                        this.Hw.set(parseInt, j6);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
