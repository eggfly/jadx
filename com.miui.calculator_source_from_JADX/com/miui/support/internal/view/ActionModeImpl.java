package com.miui.support.internal.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;
import com.miui.support.internal.widget.ActionModeView;
import com.miui.support.view.ActionModeAnimationListener;
import java.lang.ref.WeakReference;

public class ActionModeImpl extends ActionMode implements Callback, ActionModeAnimationListener {
    protected Context f2584a;
    protected WeakReference<ActionModeView> f2585b;
    boolean f2586c;
    private ActionMode.Callback f2587d;
    private MenuBuilder f2588e;
    private ActionModeCallback f2589f;

    public interface ActionModeCallback {
        void m3643a(ActionMode actionMode);
    }

    public ActionModeImpl(Context context, ActionMode.Callback callback) {
        this.f2586c = false;
        this.f2584a = context;
        this.f2587d = callback;
        this.f2588e = new MenuBuilder(context).m4413a(1);
        this.f2588e.m4420a((Callback) this);
    }

    public void m4276a(ActionModeCallback actionModeCallback) {
        this.f2589f = actionModeCallback;
    }

    public void m4277a(ActionModeView actionModeView) {
        actionModeView.m4631a((ActionModeAnimationListener) this);
        this.f2585b = new WeakReference(actionModeView);
    }

    public boolean m4280a() {
        this.f2588e.m4441f();
        try {
            boolean onCreateActionMode = this.f2587d.onCreateActionMode(this, this.f2588e);
            return onCreateActionMode;
        } finally {
            this.f2588e.m4442g();
        }
    }

    public void setTitle(CharSequence charSequence) {
        throw new UnsupportedOperationException("setTitle not supported");
    }

    public void setSubtitle(CharSequence charSequence) {
        throw new UnsupportedOperationException("setSubTitle not supported");
    }

    public void invalidate() {
        this.f2588e.m4441f();
        try {
            this.f2587d.onPrepareActionMode(this, this.f2588e);
        } finally {
            this.f2588e.m4442g();
        }
    }

    public void finish() {
        if (!this.f2586c) {
            this.f2586c = true;
            ((ActionModeView) this.f2585b.get()).m4633g();
            if (this.f2589f != null) {
                this.f2589f.m3643a(this);
            }
        }
    }

    public Menu getMenu() {
        return this.f2588e;
    }

    public CharSequence getTitle() {
        throw new UnsupportedOperationException("getTitle not supported");
    }

    public void setTitle(int i) {
        throw new UnsupportedOperationException("setTitle not supported");
    }

    public CharSequence getSubtitle() {
        throw new UnsupportedOperationException("getSubtitle not supported");
    }

    public void setSubtitle(int i) {
        throw new UnsupportedOperationException("setSubTitle not supported");
    }

    public View getCustomView() {
        throw new UnsupportedOperationException("getCustomView not supported");
    }

    public void setCustomView(View view) {
        throw new UnsupportedOperationException("setCustomView not supported");
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.f2584a);
    }

    public boolean m4281a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f2587d != null && this.f2587d.onActionItemClicked(this, menuItem);
    }

    public void m4283c(MenuBuilder menuBuilder) {
        if (this.f2587d != null) {
            invalidate();
        }
    }

    public void m4278a(boolean z) {
    }

    public void m4279a(boolean z, float f) {
    }

    public void m4282b(boolean z) {
        if (!z) {
            this.f2587d.onDestroyActionMode(this);
            this.f2587d = null;
        }
    }
}
