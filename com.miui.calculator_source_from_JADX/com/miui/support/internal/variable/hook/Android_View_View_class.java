package com.miui.support.internal.variable.hook;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.miui.support.C0234R;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;

public abstract class Android_View_View_class extends ClassProxy<View> implements IManagedClassProxy {
    private static final com.miui.support.internal.variable.Android_View_View_class ViewClass;
    private static SparseIntArray sStateAttributeIndexes;
    private static SparseArray<int[]> sViewStates;

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

    static {
        sStateAttributeIndexes = new SparseIntArray();
        sViewStates = new SparseArray();
        ViewClass = com.miui.support.internal.variable.Android_View_View_class.Factory.getInstance().get();
        sStateAttributeIndexes.put(16842908, 1);
        sStateAttributeIndexes.put(16842910, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842911, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842912, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842913, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842914, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842915, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842916, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842917, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842918, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842919, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16842921, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(16843518, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_first_h, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_middle_h, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_last_h, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_single_h, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_first_v, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_middle_v, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_last_v, 1 << sStateAttributeIndexes.size());
        sStateAttributeIndexes.put(C0234R.attr.state_single_v, 1 << sStateAttributeIndexes.size());
    }

    public Android_View_View_class() {
        super(View.class);
    }

    private static int getIndexOfStates(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = sStateAttributeIndexes.get(i, 0);
        if (i2 != 0) {
            return i2;
        }
        if (sStateAttributeIndexes.size() >= 32) {
            throw new IllegalArgumentException("State attribute cannot exceed 32!");
        }
        i2 = 1 << sStateAttributeIndexes.size();
        sStateAttributeIndexes.put(i, i2);
        return i2;
    }

    private static int getIndexOfStates(int[] iArr) {
        int i = 0;
        if (iArr != null) {
            int i2 = 0;
            while (i2 < iArr.length) {
                int indexOfStates = getIndexOfStates(iArr[i2]) | i;
                i2++;
                i = indexOfStates;
            }
        }
        return i;
    }

    protected int[] onCreateDrawableState(View view, int[] iArr, int i) {
        Object obj;
        int horizontalState = ViewClass.getHorizontalState(view);
        int verticalState = ViewClass.getVerticalState(view);
        if (horizontalState == 0 || verticalState == 0) {
            obj = iArr;
        } else {
            int indexOfStates = (getIndexOfStates(iArr) | getIndexOfStates(horizontalState)) | getIndexOfStates(verticalState);
            Object obj2 = (int[]) sViewStates.get(indexOfStates);
            if (obj2 == null) {
                int length = iArr != null ? iArr.length : 0;
                obj = new int[(length + 2)];
                if (length != 0) {
                    System.arraycopy(iArr, 0, obj, 0, length);
                }
                obj[length] = horizontalState;
                obj[length + 1] = verticalState;
                sViewStates.put(indexOfStates, obj);
            } else {
                obj = obj2;
            }
        }
        if (i == 0) {
            return obj;
        }
        if (obj == null) {
            return new int[i];
        }
        int[] iArr2 = new int[(obj.length + i)];
        System.arraycopy(obj, 0, iArr2, 0, obj.length);
        return iArr2;
    }
}
