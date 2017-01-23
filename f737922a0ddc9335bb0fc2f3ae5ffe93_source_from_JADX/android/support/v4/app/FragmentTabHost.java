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
    private Context DW;
    private n FH;
    private int Hw;
    private boolean VH;
    private a Zo;
    private final ArrayList<a> j6;
    private OnTabChangeListener v5;

    static class DummyTabFactory implements TabContentFactory {
        private final Context j6;

        public DummyTabFactory(Context context) {
            this.j6 = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.j6);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        String j6;

        static class 1 implements Creator<SavedState> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public SavedState j6(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] j6(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.j6 = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.j6);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.j6 + "}";
        }

        static {
            CREATOR = new 1();
        }
    }

    static final class a {
        private final Class<?> DW;
        private final Bundle FH;
        private Fragment Hw;
        private final String j6;
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.j6 = new ArrayList();
        j6(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new ArrayList();
        j6(context, attributeSet);
    }

    private void j6(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.Hw = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.v5 = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        q qVar = null;
        for (int i = 0; i < this.j6.size(); i++) {
            a aVar = (a) this.j6.get(i);
            aVar.Hw = this.FH.j6(aVar.j6);
            if (!(aVar.Hw == null || aVar.Hw.J0())) {
                if (aVar.j6.equals(currentTabTag)) {
                    this.Zo = aVar;
                } else {
                    if (qVar == null) {
                        qVar = this.FH.j6();
                    }
                    qVar.DW(aVar.Hw);
                }
            }
        }
        this.VH = true;
        q j6 = j6(currentTabTag, qVar);
        if (j6 != null) {
            j6.j6();
            this.FH.DW();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.VH = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.j6 = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.j6);
    }

    public void onTabChanged(String str) {
        if (this.VH) {
            q j6 = j6(str, null);
            if (j6 != null) {
                j6.j6();
            }
        }
        if (this.v5 != null) {
            this.v5.onTabChanged(str);
        }
    }

    private q j6(String str, q qVar) {
        a aVar = null;
        int i = 0;
        while (i < this.j6.size()) {
            a aVar2 = (a) this.j6.get(i);
            if (!aVar2.j6.equals(str)) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.Zo != aVar) {
            if (qVar == null) {
                qVar = this.FH.j6();
            }
            if (!(this.Zo == null || this.Zo.Hw == null)) {
                qVar.DW(this.Zo.Hw);
            }
            if (aVar != null) {
                if (aVar.Hw == null) {
                    aVar.Hw = Fragment.j6(this.DW, aVar.DW.getName(), aVar.FH);
                    qVar.j6(this.Hw, aVar.Hw, aVar.j6);
                } else {
                    qVar.FH(aVar.Hw);
                }
            }
            this.Zo = aVar;
        }
        return qVar;
    }
}
