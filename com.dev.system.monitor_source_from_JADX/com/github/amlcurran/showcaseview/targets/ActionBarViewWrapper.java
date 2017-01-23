package com.github.amlcurran.showcaseview.targets;

import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ActionBarViewWrapper {
    private Class mAbsActionBarViewClass;
    private ViewParent mActionBarView;
    private Class mActionBarViewClass;

    public ActionBarViewWrapper(ViewParent actionBarView) {
        if (!actionBarView.getClass().getName().contains("ActionBarView")) {
            String previousP = actionBarView.getClass().getName();
            actionBarView = actionBarView.getParent();
            String throwP = actionBarView.getClass().getName();
            if (!actionBarView.getClass().getName().contains("ActionBarView")) {
                throw new IllegalStateException("Cannot find ActionBarView for Activity, instead found " + previousP + " and " + throwP);
            }
        }
        this.mActionBarView = actionBarView;
        this.mActionBarViewClass = actionBarView.getClass();
        this.mAbsActionBarViewClass = actionBarView.getClass().getSuperclass();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getSpinnerView() {
        /*
        r4 = this;
        r2 = r4.mActionBarViewClass;	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r3 = "mSpinner";
        r1 = r2.getDeclaredField(r3);	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = 1;
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = r4.mActionBarView;	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = r1.get(r2);	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = (android.view.View) r2;	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
    L_0x0014:
        return r2;
    L_0x0015:
        r0 = move-exception;
        r2 = "TAG";
        r3 = "Failed to find actionbar spinner";
        android.util.Log.e(r2, r3, r0);
    L_0x001d:
        r2 = 0;
        goto L_0x0014;
    L_0x001f:
        r0 = move-exception;
        r2 = "TAG";
        r3 = "Failed to access actionbar spinner";
        android.util.Log.e(r2, r3, r0);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.amlcurran.showcaseview.targets.ActionBarViewWrapper.getSpinnerView():android.view.View");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getTitleView() {
        /*
        r4 = this;
        r2 = r4.mActionBarViewClass;	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r3 = "mTitleView";
        r1 = r2.getDeclaredField(r3);	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = 1;
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = r4.mActionBarView;	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = r1.get(r2);	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
        r2 = (android.view.View) r2;	 Catch:{ NoSuchFieldException -> 0x0015, IllegalAccessException -> 0x001f }
    L_0x0014:
        return r2;
    L_0x0015:
        r0 = move-exception;
        r2 = "TAG";
        r3 = "Failed to find actionbar title";
        android.util.Log.e(r2, r3, r0);
    L_0x001d:
        r2 = 0;
        goto L_0x0014;
    L_0x001f:
        r0 = move-exception;
        r2 = "TAG";
        r3 = "Failed to access actionbar title";
        android.util.Log.e(r2, r3, r0);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.amlcurran.showcaseview.targets.ActionBarViewWrapper.getTitleView():android.view.View");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getOverflowView() {
        /*
        r6 = this;
        r4 = r6.mAbsActionBarViewClass;	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r5 = "mActionMenuPresenter";
        r1 = r4.getDeclaredField(r5);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = 1;
        r1.setAccessible(r4);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = r6.mActionBarView;	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r0 = r1.get(r4);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = r0.getClass();	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r5 = "mOverflowButton";
        r3 = r4.getDeclaredField(r5);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = 1;
        r3.setAccessible(r4);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = r3.get(r0);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = (android.view.View) r4;	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
    L_0x0026:
        return r4;
    L_0x0027:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x002b:
        r4 = 0;
        goto L_0x0026;
    L_0x002d:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.amlcurran.showcaseview.targets.ActionBarViewWrapper.getOverflowView():android.view.View");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getMediaRouterButtonView() {
        /*
        r6 = this;
        r4 = r6.mAbsActionBarViewClass;	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r5 = "mActionMenuPresenter";
        r1 = r4.getDeclaredField(r5);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = 1;
        r1.setAccessible(r4);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = r6.mActionBarView;	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r0 = r1.get(r4);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = r0.getClass();	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r5 = "mScrapActionButtonView";
        r3 = r4.getDeclaredField(r5);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = 1;
        r3.setAccessible(r4);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = r3.get(r0);	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
        r4 = (android.view.View) r4;	 Catch:{ IllegalAccessException -> 0x0027, NoSuchFieldException -> 0x002d }
    L_0x0026:
        return r4;
    L_0x0027:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x002b:
        r4 = 0;
        goto L_0x0026;
    L_0x002d:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.amlcurran.showcaseview.targets.ActionBarViewWrapper.getMediaRouterButtonView():android.view.View");
    }

    public View getActionItem(int actionItemId) {
        try {
            Field mChField;
            Field actionMenuPresenterField = this.mAbsActionBarViewClass.getDeclaredField("mActionMenuPresenter");
            actionMenuPresenterField.setAccessible(true);
            Object actionMenuPresenter = actionMenuPresenterField.get(this.mActionBarView);
            Field menuViewField = actionMenuPresenter.getClass().getSuperclass().getDeclaredField("mMenuView");
            menuViewField.setAccessible(true);
            Object menuView = menuViewField.get(actionMenuPresenter);
            if (menuView.getClass().toString().contains("com.actionbarsherlock")) {
                mChField = menuView.getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            } else if (menuView.getClass().toString().contains("android.support.v7")) {
                mChField = menuView.getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            } else {
                mChField = menuView.getClass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            }
            mChField.setAccessible(true);
            for (Object mCh : (Object[]) mChField.get(menuView)) {
                if (mCh != null) {
                    View v = (View) mCh;
                    if (v.getId() == actionItemId) {
                        return v;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
