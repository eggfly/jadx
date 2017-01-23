package com.miui.support.widget;

import android.view.ActionMode;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.miui.support.internal.widget.EditableListViewDelegate;
import com.miui.support.internal.widget.EditableListViewDelegate.UpdateListener;

public class EditableListViewWrapper {
    private final EditableListViewDelegate f4161a;

    /* renamed from: com.miui.support.widget.EditableListViewWrapper.1 */
    class C04831 implements UpdateListener {
        final /* synthetic */ EditableListViewWrapper f4160a;

        C04831(EditableListViewWrapper editableListViewWrapper) {
            this.f4160a = editableListViewWrapper;
        }

        public void m5859a(View view, int i, long j) {
            this.f4160a.m5862a(view, i, j);
        }

        public void m5858a(ActionMode actionMode) {
            this.f4160a.m5861a(actionMode);
        }
    }

    public EditableListViewWrapper(AbsListView absListView) {
        if (absListView == null) {
            throw new IllegalArgumentException("absListView is null");
        }
        this.f4161a = new EditableListViewDelegate();
        this.f4161a.m4823a(absListView, absListView.getClass());
        this.f4161a.m4825a(new C04831(this));
    }

    public boolean m5865a() {
        return this.f4161a.m4828a();
    }

    public void m5864a(boolean z) {
        this.f4161a.m4827a(z);
    }

    public void m5860a(int i, boolean z) {
        this.f4161a.m4819a(i, z);
    }

    public void m5863a(ListAdapter listAdapter) {
        this.f4161a.m4824a(listAdapter);
    }

    protected void m5862a(View view, int i, long j) {
        this.f4161a.m4821a(view, i, j);
    }

    protected void m5861a(ActionMode actionMode) {
        this.f4161a.m4820a(actionMode);
    }
}
