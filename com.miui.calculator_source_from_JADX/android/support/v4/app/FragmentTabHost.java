package android.support.v4.app;

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
    private final ArrayList<TabInfo> f261a;
    private Context f262b;
    private FragmentManager f263c;
    private int f264d;
    private OnTabChangeListener f265e;
    private TabInfo f266f;
    private boolean f267g;

    static class DummyTabFactory implements TabContentFactory {
        private final Context f255a;

        public View createTabContent(String str) {
            View view = new View(this.f255a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        String f256a;

        /* renamed from: android.support.v4.app.FragmentTabHost.SavedState.1 */
        final class C00231 implements Creator<SavedState> {
            C00231() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m382a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m383a(i);
            }

            public SavedState m382a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m383a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f256a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f256a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f256a + "}";
        }

        static {
            CREATOR = new C00231();
        }
    }

    static final class TabInfo {
        private final String f257a;
        private final Class<?> f258b;
        private final Bundle f259c;
        private Fragment f260d;
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.f261a = new ArrayList();
        m390a(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f261a = new ArrayList();
        m390a(context, attributeSet);
    }

    private void m390a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f264d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f265e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f261a.size(); i++) {
            TabInfo tabInfo = (TabInfo) this.f261a.get(i);
            tabInfo.f260d = this.f263c.m304a(tabInfo.f257a);
            if (!(tabInfo.f260d == null || tabInfo.f260d.m193l())) {
                if (tabInfo.f257a.equals(currentTabTag)) {
                    this.f266f = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f263c.m305a();
                    }
                    fragmentTransaction.m90b(tabInfo.f260d);
                }
            }
        }
        this.f267g = true;
        FragmentTransaction a = m389a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.m86a();
            this.f263c.m308b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f267g = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f256a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f256a);
    }

    public void onTabChanged(String str) {
        if (this.f267g) {
            FragmentTransaction a = m389a(str, null);
            if (a != null) {
                a.m86a();
            }
        }
        if (this.f265e != null) {
            this.f265e.onTabChanged(str);
        }
    }

    private FragmentTransaction m389a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo = null;
        int i = 0;
        while (i < this.f261a.size()) {
            TabInfo tabInfo2 = (TabInfo) this.f261a.get(i);
            if (!tabInfo2.f257a.equals(str)) {
                tabInfo2 = tabInfo;
            }
            i++;
            tabInfo = tabInfo2;
        }
        if (tabInfo == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f266f != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f263c.m305a();
            }
            if (!(this.f266f == null || this.f266f.f260d == null)) {
                fragmentTransaction.m90b(this.f266f.f260d);
            }
            if (tabInfo != null) {
                if (tabInfo.f260d == null) {
                    tabInfo.f260d = Fragment.m138a(this.f262b, tabInfo.f258b.getName(), tabInfo.f259c);
                    fragmentTransaction.m87a(this.f264d, tabInfo.f260d, tabInfo.f257a);
                } else {
                    fragmentTransaction.m91c(tabInfo.f260d);
                }
            }
            this.f266f = tabInfo;
        }
        return fragmentTransaction;
    }
}
