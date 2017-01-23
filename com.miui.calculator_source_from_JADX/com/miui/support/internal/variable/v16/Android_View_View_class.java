package com.miui.support.internal.variable.v16;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;
import com.miui.support.reflect.Method;

public class Android_View_View_class extends com.miui.support.internal.variable.Android_View_View_class {
    private static final Method createSnapshot;
    private static Method mGetContextMenuInfo;
    private static final Field mLeft;
    private static Field mListenerInfo;
    private static final Field mOldHeightMeasureSpec;
    private static final Field mOldWidthMeasureSpec;
    private static Method mOnCreateContextMenu;
    private static Field mOnCreateContextMenuListener;
    private static final Field mPrivateFlags;
    private static final Field mRight;
    private static final Field mScrollX;
    private static final Field mScrollY;

    static {
        mPrivateFlags = Field.of(View.class, "mPrivateFlags", Field.INT_SIGNATURE_PRIMITIVE);
        mOldWidthMeasureSpec = Field.of(View.class, "mOldWidthMeasureSpec", Field.INT_SIGNATURE_PRIMITIVE);
        mOldHeightMeasureSpec = Field.of(View.class, "mOldHeightMeasureSpec", Field.INT_SIGNATURE_PRIMITIVE);
        mScrollX = Field.of(View.class, "mScrollX", Field.INT_SIGNATURE_PRIMITIVE);
        mScrollY = Field.of(View.class, "mScrollY", Field.INT_SIGNATURE_PRIMITIVE);
        mLeft = Field.of(View.class, "mLeft", Field.INT_SIGNATURE_PRIMITIVE);
        mRight = Field.of(View.class, "mRight", Field.INT_SIGNATURE_PRIMITIVE);
        createSnapshot = Method.of(View.class, "createSnapshot", "(Landroid/graphics/Bitmap$Config;IZ)Landroid/graphics/Bitmap;");
    }

    private int getPrivateFlags(View view) {
        try {
            return mPrivateFlags.getInt(view);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mPrivateFlags", e);
            return 0;
        }
    }

    private void setPrivateFlags(View view, int i) {
        try {
            mPrivateFlags.set((Object) view, i);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mPrivateFlags", e);
        }
    }

    private int getOldWidthMeasureSpec(View view) {
        try {
            return mOldWidthMeasureSpec.getInt(view);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mOldWidthMeasureSpec", e);
            return 0;
        }
    }

    private int getOldHeightMeasureSpec(View view) {
        try {
            return mOldHeightMeasureSpec.getInt(view);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mOldHeightMeasureSpec", e);
            return 0;
        }
    }

    public void relayout(View view) {
        if (view.getHeight() != 0 && view.getWidth() != 0) {
            int privateFlags = getPrivateFlags(view);
            view.forceLayout();
            view.measure(getOldWidthMeasureSpec(view), getOldHeightMeasureSpec(view));
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            setPrivateFlags(view, privateFlags);
        }
    }

    public void setScrollXDirectly(View view, int i) {
        try {
            mScrollX.set((Object) view, i);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mScrollX", e);
        }
    }

    public void setScrollYDirectly(View view, int i) {
        try {
            mScrollY.set((Object) view, i);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mScrollY", e);
        }
    }

    public void setLeftDirectly(View view, int i) {
        try {
            mLeft.set((Object) view, i);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mScrollY", e);
        }
    }

    public void setRightDirectly(View view, int i) {
        try {
            mRight.set((Object) view, i);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.view.View.mScrollY", e);
        }
    }

    public Bitmap createSnapshot(View view, Config config, int i, boolean z) {
        if (createSnapshot != null) {
            try {
                return (Bitmap) createSnapshot.invokeObject(View.class, view, config, Integer.valueOf(i), Boolean.valueOf(z));
            } catch (Throwable e) {
                VariableExceptionHandler.getInstance().onThrow("invoke createSnapshot failed", e);
            }
        }
        return null;
    }

    public ContextMenuInfo getContextMenuInfo(View view) {
        try {
            if (mGetContextMenuInfo == null) {
                mGetContextMenuInfo = Method.of(View.class, "getContextMenuInfo", "()Landroid/view/ContextMenu$ContextMenuInfo;");
            }
            return (ContextMenuInfo) mGetContextMenuInfo.invokeObject(view.getClass(), view, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("invoke getContextMenuInfo failed", e);
            return null;
        }
    }

    public void onCreateContextMenu(View view, ContextMenu contextMenu) {
        try {
            if (mOnCreateContextMenu == null) {
                mOnCreateContextMenu = Method.of(View.class, "onCreateContextMenu", "(Landroid/view/ContextMenu;)V");
            }
            mOnCreateContextMenu.invoke(view.getClass(), view, contextMenu);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("invoke onCreateContextMenu failed", e);
        }
    }

    public OnCreateContextMenuListener getOnCreateContextMenuListener(View view) {
        try {
            if (mListenerInfo == null || mOnCreateContextMenuListener == null) {
                mListenerInfo = Field.of(View.class, "mListenerInfo", "Landroid/view/View$ListenerInfo;");
                mOnCreateContextMenuListener = Field.of(Class.forName("android.view.View$ListenerInfo"), "mOnCreateContextMenuListener", "Landroid/view/View$OnCreateContextMenuListener;");
            }
            Object obj = mListenerInfo.get(view);
            if (obj != null) {
                return (OnCreateContextMenuListener) mOnCreateContextMenuListener.get(obj);
            }
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("get OnCreateContextMenuListener failed", e);
        }
        return null;
    }
}
