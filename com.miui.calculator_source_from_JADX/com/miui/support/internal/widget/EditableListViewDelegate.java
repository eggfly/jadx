package com.miui.support.internal.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;
import com.miui.support.C0234R;
import com.miui.support.reflect.Method;
import com.miui.support.util.ViewUtils;
import com.miui.support.view.ActionModeAnimationListener;
import com.miui.support.view.EditActionMode;
import com.miui.support.widget.EditableListView.ItemCheckFilter;
import com.miui.support.widget.EditableListView.MultiChoiceModeListener;
import java.util.ArrayList;
import java.util.List;

public class EditableListViewDelegate {
    private static final Method f3107a;
    private static final Method f3108b;
    private static final Method f3109c;
    private static final Method f3110d;
    private static final Method f3111e;
    private static final Method f3112f;
    private AbsListView f3113g;
    private Class<? extends AbsListView> f3114h;
    private ListAdapterWrapper f3115i;
    private MultiChoiceModeListenerWrapper f3116j;
    private ActionMode f3117k;
    private boolean f3118l;
    private boolean f3119m;
    private int f3120n;
    private int f3121o;
    private List<CheckBox> f3122p;
    private UpdateListener f3123q;
    private RecyclerListener f3124r;
    private ItemCheckFilter f3125s;

    public interface UpdateListener {
        void m4791a(ActionMode actionMode);

        void m4792a(View view, int i, long j);
    }

    /* renamed from: com.miui.support.internal.widget.EditableListViewDelegate.1 */
    class C03871 implements UpdateListener {
        final /* synthetic */ EditableListViewDelegate f3099a;

        C03871(EditableListViewDelegate editableListViewDelegate) {
            this.f3099a = editableListViewDelegate;
        }

        public void m4794a(View view, int i, long j) {
            this.f3099a.m4821a(view, i, j);
        }

        public void m4793a(ActionMode actionMode) {
            this.f3099a.m4820a(actionMode);
        }
    }

    /* renamed from: com.miui.support.internal.widget.EditableListViewDelegate.2 */
    class C03882 implements RecyclerListener {
        final /* synthetic */ EditableListViewDelegate f3100a;

        C03882(EditableListViewDelegate editableListViewDelegate) {
            this.f3100a = editableListViewDelegate;
        }

        public void onMovedToScrapHeap(View view) {
            CheckBox a = this.f3100a.m4804a(view);
            if (a != null) {
                a.setAlpha(1.0f);
                a.setTranslationX(0.0f);
            }
        }
    }

    private class ListAdapterWrapper extends BaseAdapter implements WrapperListAdapter {
        final /* synthetic */ EditableListViewDelegate f3101a;
        private ListAdapter f3102b;

        public ListAdapterWrapper(EditableListViewDelegate editableListViewDelegate, ListAdapter listAdapter) {
            this.f3101a = editableListViewDelegate;
            this.f3102b = listAdapter;
        }

        public ListAdapter getWrappedAdapter() {
            return this.f3102b;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f3102b.registerDataSetObserver(dataSetObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f3102b.unregisterDataSetObserver(dataSetObserver);
        }

        public int getCount() {
            return this.f3102b.getCount();
        }

        public Object getItem(int i) {
            return this.f3102b.getItem(i);
        }

        public long getItemId(int i) {
            return this.f3102b.getItemId(i);
        }

        public boolean hasStableIds() {
            return this.f3102b.hasStableIds();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = 8;
            View view2 = this.f3102b.getView(i, view, viewGroup);
            CheckBox a = this.f3101a.m4804a(view2);
            if (a != null) {
                int choiceMode = this.f3101a.f3113g.getChoiceMode();
                boolean a2 = this.f3101a.m4829a(i);
                if (choiceMode == 3) {
                    if (this.f3101a.f3117k != null) {
                        i2 = 0;
                    }
                    a.setVisibility(i2);
                } else if (choiceMode == 1) {
                    a.setVisibility(8);
                }
                if (a.getVisibility() == 0 && !(a.getTranslationX() == 0.0f && a.getAlpha() == 1.0f)) {
                    a.setTranslationX(0.0f);
                    a.setAlpha(1.0f);
                }
                a.setChecked(a2);
            }
            return view2;
        }

        public int getItemViewType(int i) {
            return this.f3102b.getItemViewType(i);
        }

        public int getViewTypeCount() {
            return this.f3102b.getViewTypeCount();
        }

        public boolean isEmpty() {
            return this.f3102b.isEmpty();
        }

        public boolean areAllItemsEnabled() {
            return this.f3102b.areAllItemsEnabled();
        }

        public boolean isEnabled(int i) {
            return this.f3102b.isEnabled(i);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f3102b instanceof BaseAdapter) {
                return ((BaseAdapter) this.f3102b).getDropDownView(i, view, viewGroup);
            }
            return super.getDropDownView(i, view, viewGroup);
        }
    }

    private class MultiChoiceModeListenerWrapper implements MultiChoiceModeListener {
        final /* synthetic */ EditableListViewDelegate f3104a;
        private AbsListView.MultiChoiceModeListener f3105b;
        private ActionModeAnimationListener f3106c;

        /* renamed from: com.miui.support.internal.widget.EditableListViewDelegate.MultiChoiceModeListenerWrapper.1 */
        class C03891 implements ActionModeAnimationListener {
            final /* synthetic */ MultiChoiceModeListenerWrapper f3103a;

            C03891(MultiChoiceModeListenerWrapper multiChoiceModeListenerWrapper) {
                this.f3103a = multiChoiceModeListenerWrapper;
            }

            public void m4795a(boolean z) {
                if (z) {
                    int i = ViewUtils.m5452a(this.f3103a.f3104a.f3113g) ? -1 : 1;
                    for (CheckBox checkBox : this.f3103a.f3104a.m4816g()) {
                        checkBox.setVisibility(0);
                        checkBox.setTranslationX((float) (checkBox.getWidth() * i));
                        checkBox.setAlpha(0.0f);
                    }
                }
            }

            public void m4796a(boolean z, float f) {
                if (!z) {
                    f = 1.0f - f;
                }
                int i = ViewUtils.m5452a(this.f3103a.f3104a.f3113g) ? -1 : 1;
                for (CheckBox checkBox : this.f3103a.f3104a.m4816g()) {
                    checkBox.setAlpha(f);
                    checkBox.setTranslationX((((float) checkBox.getWidth()) * (1.0f - f)) * ((float) i));
                }
                if (z && f == 1.0f) {
                    int height = this.f3103a.f3104a.f3113g.getHeight();
                    if (this.f3103a.f3104a.f3121o > height) {
                        this.f3103a.f3104a.f3113g.smoothScrollBy(this.f3103a.f3104a.f3121o - height, 100);
                    }
                }
            }

            public void m4797b(boolean z) {
                if (!z) {
                    this.f3103a.f3104a.f3117k = null;
                    for (CheckBox visibility : this.f3103a.f3104a.m4816g()) {
                        visibility.setVisibility(8);
                    }
                }
            }
        }

        public MultiChoiceModeListenerWrapper(EditableListViewDelegate editableListViewDelegate) {
            this.f3104a = editableListViewDelegate;
            this.f3106c = new C03891(this);
        }

        public void m4800a(AbsListView.MultiChoiceModeListener multiChoiceModeListener) {
            this.f3105b = multiChoiceModeListener;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f3105b.onPrepareActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f3104a.f3120n = 0;
            this.f3105b.onDestroyActionMode(actionMode);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            this.f3104a.f3120n = 0;
            actionMode.setTitle(C0234R.string.select_item);
            if (!this.f3105b.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            this.f3104a.f3117k = actionMode;
            ((EditActionMode) this.f3104a.f3117k).m4285a(this.f3106c);
            this.f3104a.f3123q.m4791a(actionMode);
            this.f3104a.f3121o = -1;
            return true;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() == 16908313) {
                actionMode.finish();
            } else if (menuItem.getItemId() == 16908314) {
                this.f3104a.m4827a(!this.f3104a.m4828a());
            }
            return this.f3105b.onActionItemClicked(actionMode, menuItem);
        }

        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            if (!this.f3104a.f3118l) {
                int headerViewsCount = this.f3104a.f3119m ? ((ListView) this.f3104a.f3113g).getHeaderViewsCount() : 0;
                int count = this.f3104a.m4832d().getCount();
                if (i >= headerViewsCount && i < count + headerViewsCount && this.f3104a.m4808b(i - headerViewsCount)) {
                    EditableListViewDelegate editableListViewDelegate = this.f3104a;
                    int h = this.f3104a.f3120n;
                    if (z) {
                        headerViewsCount = 1;
                    } else {
                        headerViewsCount = -1;
                    }
                    editableListViewDelegate.f3120n = headerViewsCount + h;
                    this.f3104a.f3123q.m4792a(this.f3104a.f3113g.getChildAt(i - this.f3104a.f3113g.getFirstVisiblePosition()), i, j);
                    this.f3104a.f3123q.m4791a(actionMode);
                    this.f3105b.onItemCheckedStateChanged(actionMode, i, j, z);
                    if (this.f3104a.f3121o == -1) {
                        this.f3104a.f3121o = this.f3104a.f3113g.getChildAt(i - this.f3104a.f3113g.getFirstVisiblePosition()).getBottom();
                    }
                }
            }
        }

        public void m4799a(ActionMode actionMode, boolean z) {
            AbsListView.MultiChoiceModeListener multiChoiceModeListener = this.f3105b;
            if (multiChoiceModeListener instanceof MultiChoiceModeListener) {
                ((MultiChoiceModeListener) multiChoiceModeListener).m4798a(this.f3104a.f3117k, z);
            }
        }
    }

    public EditableListViewDelegate() {
        this.f3122p = new ArrayList();
        this.f3123q = new C03871(this);
        this.f3124r = new C03882(this);
    }

    static {
        f3107a = Method.of(AbsListView.class, "setAdapter", "(Landroid/widget/ListAdapter;)V");
        f3108b = Method.of(AbsListView.class, "clearChoices", "()V");
        f3109c = Method.of(AbsListView.class, "setItemChecked", "(IZ)V");
        f3110d = Method.of(AbsListView.class, "isItemChecked", "(I)Z");
        f3111e = Method.of(AbsListView.class, "getCheckedItemPositions", "()Landroid/util/SparseBooleanArray;");
        f3112f = Method.of(AbsListView.class, "setMultiChoiceModeListener", "(Landroid/widget/AbsListView$MultiChoiceModeListener;)V");
    }

    private int m4812e() {
        if (this.f3125s != null) {
            return this.f3125s.m5854a();
        }
        return m4832d() != null ? m4832d().getCount() : 0;
    }

    private boolean m4808b(int i) {
        return this.f3125s == null || this.f3125s.m5855a(i);
    }

    public void m4823a(AbsListView absListView, Class<? extends AbsListView> cls) {
        if (absListView == null) {
            throw new IllegalArgumentException("absListView is null");
        }
        this.f3113g = absListView;
        this.f3114h = cls;
        this.f3113g.setChoiceMode(3);
        this.f3113g.setRecyclerListener(this.f3124r);
        this.f3119m = this.f3113g instanceof ListView;
        if (this.f3113g.getAdapter() != null) {
            ListAdapter listAdapter = (ListAdapter) this.f3113g.getAdapter();
            f3107a.invoke(this.f3114h, this.f3113g, (ListAdapter) null);
            m4824a(listAdapter);
        }
    }

    public void m4825a(UpdateListener updateListener) {
        if (updateListener != null) {
            this.f3123q = updateListener;
        }
    }

    public boolean m4828a() {
        return this.f3120n != 0 && m4812e() == this.f3120n;
    }

    public void m4827a(boolean z) {
        this.f3118l = true;
        int count = m4832d().getCount();
        for (int i = 0; i < count; i++) {
            if (m4808b(i)) {
                m4819a(i, z);
            }
        }
        this.f3120n = z ? m4812e() : 0;
        this.f3118l = false;
        this.f3123q.m4791a(this.f3117k);
        m4814f();
        if (this.f3116j != null) {
            this.f3116j.m4799a(this.f3117k, z);
        }
    }

    public void m4830b() {
        f3108b.invoke(this.f3114h, this.f3113g, new Object[0]);
        this.f3120n = 0;
        this.f3123q.m4791a(this.f3117k);
        m4814f();
        this.f3120n = 0;
    }

    public void m4819a(int i, boolean z) {
        int headerViewsCount;
        if (this.f3119m) {
            headerViewsCount = ((ListView) this.f3113g).getHeaderViewsCount();
        } else {
            headerViewsCount = 0;
        }
        f3109c.invoke(this.f3114h, this.f3113g, Integer.valueOf(headerViewsCount + i), Boolean.valueOf(z));
    }

    public boolean m4829a(int i) {
        int headerViewsCount;
        if (this.f3119m) {
            headerViewsCount = ((ListView) this.f3113g).getHeaderViewsCount();
        } else {
            headerViewsCount = 0;
        }
        return f3110d.invokeBoolean(this.f3114h, this.f3113g, Integer.valueOf(headerViewsCount + i));
    }

    public SparseBooleanArray m4831c() {
        return ((SparseBooleanArray) f3111e.invokeObject(this.f3114h, this.f3113g, new Object[0])).clone();
    }

    public ListAdapter m4832d() {
        return this.f3115i != null ? this.f3115i.getWrappedAdapter() : null;
    }

    public void m4826a(ItemCheckFilter itemCheckFilter) {
        this.f3125s = itemCheckFilter;
    }

    public void m4824a(ListAdapter listAdapter) {
        if (listAdapter == m4832d()) {
            return;
        }
        if (listAdapter == null) {
            this.f3115i = null;
            f3107a.invoke(this.f3114h, this.f3113g, (ListAdapter) null);
            return;
        }
        this.f3115i = new ListAdapterWrapper(this, listAdapter);
        f3107a.invoke(this.f3114h, this.f3113g, this.f3115i);
    }

    public void m4822a(AbsListView.MultiChoiceModeListener multiChoiceModeListener) {
        if (this.f3116j == null) {
            this.f3116j = new MultiChoiceModeListenerWrapper(this);
        }
        this.f3116j.m4800a(multiChoiceModeListener);
        f3112f.invoke(this.f3114h, this.f3113g, this.f3116j);
    }

    private void m4814f() {
        int firstVisiblePosition = this.f3113g.getFirstVisiblePosition();
        int childCount = this.f3113g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2 = firstVisiblePosition + i;
            this.f3123q.m4792a(this.f3113g.getChildAt(i), i2, m4832d().getItemId(i2));
        }
    }

    public void m4821a(View view, int i, long j) {
        if (view != null) {
            boolean z = ((SparseBooleanArray) f3111e.invokeObject(this.f3114h, this.f3113g, new Object[0])).get(i);
            CheckBox a = m4804a(view);
            if (a != null) {
                a.setChecked(z);
            } else if (view instanceof Checkable) {
                ((Checkable) view).setChecked(z);
            }
        }
    }

    public void m4820a(ActionMode actionMode) {
        if (actionMode != null) {
            boolean z;
            int i = this.f3120n;
            Resources resources = this.f3113g.getResources();
            if (i == 0) {
                actionMode.setTitle(resources.getString(C0234R.string.select_item));
            } else {
                actionMode.setTitle(String.format(resources.getQuantityString(C0234R.plurals.items_selected, i), new Object[]{Integer.valueOf(i)}));
            }
            ((EditActionMode) actionMode).m4284a(16908314, m4828a() ? C0234R.string.deselect_all : C0234R.string.select_all);
            Menu menu = actionMode.getMenu();
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            menu.setGroupEnabled(0, z);
        }
    }

    private CheckBox m4804a(View view) {
        CheckBox checkBox = (CheckBox) view.getTag(Integer.MAX_VALUE);
        if (checkBox == null) {
            checkBox = (CheckBox) view.findViewById(16908289);
            if (checkBox != null) {
                view.setTag(Integer.MAX_VALUE, checkBox);
            }
        }
        return checkBox;
    }

    private List<CheckBox> m4816g() {
        int childCount = this.f3113g.getChildCount();
        List<CheckBox> list = this.f3122p;
        this.f3122p.clear();
        for (int i = 0; i < childCount; i++) {
            CheckBox a = m4804a(this.f3113g.getChildAt(i));
            if (a != null) {
                list.add(a);
            }
        }
        return list;
    }
}
