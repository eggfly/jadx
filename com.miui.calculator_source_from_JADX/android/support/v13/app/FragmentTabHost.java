package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<TabInfo> f11a;
    private Context f12b;
    private FragmentManager f13c;
    private int f14d;
    private OnTabChangeListener f15e;
    private TabInfo f16f;
    private boolean f17g;

    static class DummyTabFactory implements TabContentFactory {
        private final Context f5a;

        public View createTabContent(String str) {
            View view = new View(this.f5a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        String f6a;

        /* renamed from: android.support.v13.app.FragmentTabHost.SavedState.1 */
        final class C00021 implements Creator<SavedState> {
            C00021() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m20a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m21a(i);
            }

            public SavedState m20a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m21a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f6a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f6a + "}";
        }

        static {
            CREATOR = new C00021();
        }
    }

    static final class TabInfo {
        private final String f7a;
        private final Class<?> f8b;
        private final Bundle f9c;
        private Fragment f10d;
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.f11a = new ArrayList();
        m28a(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11a = new ArrayList();
        m28a(context, attributeSet);
    }

    private void m28a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f14d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f15e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f11a.size(); i++) {
            TabInfo tabInfo = (TabInfo) this.f11a.get(i);
            tabInfo.f10d = this.f13c.findFragmentByTag(tabInfo.f7a);
            if (!(tabInfo.f10d == null || tabInfo.f10d.isDetached())) {
                if (tabInfo.f7a.equals(currentTabTag)) {
                    this.f16f = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f13c.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.f10d);
                }
            }
        }
        this.f17g = true;
        FragmentTransaction a = m27a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f13c.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17g = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f6a);
    }

    public void onTabChanged(String str) {
        if (this.f17g) {
            FragmentTransaction a = m27a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.f15e != null) {
            this.f15e.onTabChanged(str);
        }
    }

    private FragmentTransaction m27a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo = null;
        int i = 0;
        while (i < this.f11a.size()) {
            TabInfo tabInfo2 = (TabInfo) this.f11a.get(i);
            if (!tabInfo2.f7a.equals(str)) {
                tabInfo2 = tabInfo;
            }
            i++;
            tabInfo = tabInfo2;
        }
        if (tabInfo == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f16f != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f13c.beginTransaction();
            }
            if (!(this.f16f == null || this.f16f.f10d == null)) {
                fragmentTransaction.detach(this.f16f.f10d);
            }
            if (tabInfo != null) {
                if (tabInfo.f10d == null) {
                    tabInfo.f10d = Fragment.instantiate(this.f12b, tabInfo.f8b.getName(), tabInfo.f9c);
                    fragmentTransaction.add(this.f14d, tabInfo.f10d, tabInfo.f7a);
                } else {
                    fragmentTransaction.attach(tabInfo.f10d);
                }
            }
            this.f16f = tabInfo;
        }
        return fragmentTransaction;
    }
}
