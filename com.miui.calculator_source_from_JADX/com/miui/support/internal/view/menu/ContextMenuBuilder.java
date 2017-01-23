package com.miui.support.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.EventLog;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewParent;
import com.miui.support.internal.variable.Android_View_View_class;
import com.miui.support.internal.variable.Android_View_View_class.Factory;

public class ContextMenuBuilder extends MenuBuilder implements ContextMenu {
    public ContextMenuBuilder(Context context) {
        super(context);
    }

    public ContextMenu setHeaderIcon(Drawable drawable) {
        return (ContextMenu) super.m4414a(drawable);
    }

    public ContextMenu setHeaderIcon(int i) {
        return (ContextMenu) super.m4439e(i);
    }

    public ContextMenu setHeaderTitle(CharSequence charSequence) {
        return (ContextMenu) super.m4416a(charSequence);
    }

    public ContextMenu setHeaderTitle(int i) {
        return (ContextMenu) super.m4437d(i);
    }

    public ContextMenu setHeaderView(View view) {
        return (ContextMenu) super.m4415a(view);
    }

    public MenuDialogHelper m4453a(View view, IBinder iBinder) {
        if (view != null) {
            m4452a(view, (ContextMenu) this);
        }
        if (m4443h().size() <= 0) {
            return null;
        }
        EventLog.writeEvent(50001, 1);
        MenuDialogHelper menuDialogHelper = new MenuDialogHelper(this);
        menuDialogHelper.m4294a(iBinder);
        return menuDialogHelper;
    }

    private void m4452a(View view, ContextMenu contextMenu) {
        Android_View_View_class android_View_View_class = Factory.getInstance().get();
        ContextMenuInfo contextMenuInfo = android_View_View_class.getContextMenuInfo(view);
        ((ContextMenuBuilder) contextMenu).m4418a(contextMenuInfo);
        android_View_View_class.onCreateContextMenu(view, contextMenu);
        OnCreateContextMenuListener onCreateContextMenuListener = android_View_View_class.getOnCreateContextMenuListener(view);
        if (onCreateContextMenuListener != null) {
            onCreateContextMenuListener.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
        ((ContextMenuBuilder) contextMenu).m4418a(null);
        ViewParent parent = view.getParent();
        if (parent == null) {
            return;
        }
        if (parent instanceof View) {
            m4452a((View) view.getParent(), contextMenu);
        } else {
            parent.createContextMenu(contextMenu);
        }
    }
}
