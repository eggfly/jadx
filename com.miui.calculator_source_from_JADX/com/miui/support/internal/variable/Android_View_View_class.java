package com.miui.support.internal.variable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import java.util.WeakHashMap;

public abstract class Android_View_View_class {
    private static WeakHashMap<View, CustomizedValue> sCustomizedValues;

    public static class CustomizedValue {
        public boolean mHasInitViewSequenceStates;
        public int mHorizontalState;
        public boolean mTagChildrenSequenceState;
        public int mVerticalState;

        public CustomizedValue() {
            this.mHorizontalState = 0;
            this.mVerticalState = 0;
            this.mTagChildrenSequenceState = false;
            this.mHasInitViewSequenceStates = false;
        }
    }

    public static class Factory extends AbsClassFactory {
        private Android_View_View_class Android_View_View_class;

        private static class Holder {
            static final Factory INSTANCE;

            private Holder() {
            }

            static {
                INSTANCE = new Factory();
            }
        }

        private Factory() {
            this.Android_View_View_class = (Android_View_View_class) create("Android_View_View_class");
        }

        public static Factory getInstance() {
            return Holder.INSTANCE;
        }

        public Android_View_View_class get() {
            return this.Android_View_View_class;
        }
    }

    public abstract Bitmap createSnapshot(View view, Config config, int i, boolean z);

    public abstract ContextMenuInfo getContextMenuInfo(View view);

    public abstract OnCreateContextMenuListener getOnCreateContextMenuListener(View view);

    public abstract void onCreateContextMenu(View view, ContextMenu contextMenu);

    public abstract void relayout(View view);

    public abstract void setLeftDirectly(View view, int i);

    public abstract void setRightDirectly(View view, int i);

    public abstract void setScrollXDirectly(View view, int i);

    public abstract void setScrollYDirectly(View view, int i);

    static {
        sCustomizedValues = new WeakHashMap();
    }

    public CustomizedValue getCustomizedValue(View view) {
        CustomizedValue customizedValue = (CustomizedValue) sCustomizedValues.get(view);
        if (customizedValue != null) {
            return customizedValue;
        }
        customizedValue = new CustomizedValue();
        sCustomizedValues.put(view, customizedValue);
        return customizedValue;
    }

    public int getHorizontalState(View view) {
        return getCustomizedValue(view).mHorizontalState;
    }

    public void setHorizontalState(View view, int i) {
        getCustomizedValue(view).mHorizontalState = i;
    }

    public int getVerticalState(View view) {
        return getCustomizedValue(view).mVerticalState;
    }

    public void setVerticalState(View view, int i) {
        getCustomizedValue(view).mVerticalState = i;
    }

    public boolean hasInitViewSequenceStates(View view) {
        return getCustomizedValue(view).mHasInitViewSequenceStates;
    }

    public void setHasInitViewSequenceStates(View view, boolean z) {
        getCustomizedValue(view).mHasInitViewSequenceStates = z;
    }
}
