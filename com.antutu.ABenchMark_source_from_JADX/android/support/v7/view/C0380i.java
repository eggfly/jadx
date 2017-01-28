package android.support.v7.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.view.i */
public class C0380i implements Callback {
    final Callback f965d;

    public C0380i(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f965d = callback;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f965d.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f965d.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f965d.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f965d.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f965d.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f965d.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f965d.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f965d.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f965d.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f965d.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f965d.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.f965d.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        this.f965d.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f965d.onMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f965d.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f965d.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f965d.onPreparePanel(i, view, menu);
    }

    public boolean onSearchRequested() {
        return this.f965d.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f965d.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f965d.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f965d.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f965d.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f965d.onWindowStartingActionMode(callback, i);
    }
}
