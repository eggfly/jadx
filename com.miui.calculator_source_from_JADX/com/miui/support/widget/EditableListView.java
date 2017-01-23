package com.miui.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.miui.support.internal.widget.EditableListViewDelegate;
import com.miui.support.internal.widget.EditableListViewDelegate.UpdateListener;

public class EditableListView extends ListView {
    private EditableListViewDelegate f4159a;

    public interface MultiChoiceModeListener extends android.widget.AbsListView.MultiChoiceModeListener {
        void m4798a(ActionMode actionMode, boolean z);
    }

    /* renamed from: com.miui.support.widget.EditableListView.1 */
    class C04821 implements UpdateListener {
        final /* synthetic */ EditableListView f4158a;

        C04821(EditableListView editableListView) {
            this.f4158a = editableListView;
        }

        public void m5853a(View view, int i, long j) {
            this.f4158a.m5857a(view, i, j);
        }

        public void m5852a(ActionMode actionMode) {
            this.f4158a.m5856a(actionMode);
        }
    }

    public interface ItemCheckFilter {
        int m5854a();

        boolean m5855a(int i);
    }

    public EditableListView(Context context) {
        super(context);
        getDelegate();
    }

    public EditableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getDelegate();
    }

    public EditableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getDelegate();
    }

    private EditableListViewDelegate getDelegate() {
        if (this.f4159a == null) {
            this.f4159a = new EditableListViewDelegate();
            this.f4159a.m4823a((AbsListView) this, ListView.class);
            this.f4159a.m4825a(new C04821(this));
        }
        return this.f4159a;
    }

    public void setAdapter(ListAdapter listAdapter) {
        getDelegate().m4824a(listAdapter);
    }

    public void setMultiChoiceModeListener(android.widget.AbsListView.MultiChoiceModeListener multiChoiceModeListener) {
        getDelegate().m4822a(multiChoiceModeListener);
    }

    public void setAllItemsChecked(boolean z) {
        getDelegate().m4827a(z);
    }

    public void clearChoices() {
        getDelegate().m4830b();
    }

    public void setItemChecked(int i, boolean z) {
        getDelegate().m4819a(i, z);
    }

    public boolean isItemChecked(int i) {
        return getDelegate().m4829a(i);
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return getDelegate().m4831c();
    }

    protected void m5857a(View view, int i, long j) {
        getDelegate().m4821a(view, i, j);
    }

    protected void m5856a(ActionMode actionMode) {
        getDelegate().m4820a(actionMode);
    }

    public void setItemCheckFilter(ItemCheckFilter itemCheckFilter) {
        getDelegate().m4826a(itemCheckFilter);
    }
}
