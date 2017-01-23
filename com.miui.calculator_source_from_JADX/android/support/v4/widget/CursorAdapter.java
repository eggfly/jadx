package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements CursorFilterClient, Filterable {
    protected boolean f1015a;
    protected boolean f1016b;
    protected Cursor f1017c;
    protected Context f1018d;
    protected int f1019e;
    protected ChangeObserver f1020f;
    protected DataSetObserver f1021g;
    protected CursorFilter f1022h;
    protected FilterQueryProvider f1023i;

    private class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter f1013a;

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1013a.m2062b();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter f1014a;

        public void onChanged() {
            this.f1014a.f1015a = true;
            this.f1014a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1014a.f1015a = false;
            this.f1014a.notifyDataSetInvalidated();
        }
    }

    public abstract View m2057a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void m2059a(View view, Context context, Cursor cursor);

    public Cursor m2055a() {
        return this.f1017c;
    }

    public int getCount() {
        if (!this.f1015a || this.f1017c == null) {
            return 0;
        }
        return this.f1017c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f1015a || this.f1017c == null) {
            return null;
        }
        this.f1017c.moveToPosition(i);
        return this.f1017c;
    }

    public long getItemId(int i) {
        if (this.f1015a && this.f1017c != null && this.f1017c.moveToPosition(i)) {
            return this.f1017c.getLong(this.f1019e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1015a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1017c.moveToPosition(i)) {
            if (view == null) {
                view = m2057a(this.f1018d, this.f1017c, viewGroup);
            }
            m2059a(view, this.f1018d, this.f1017c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1015a) {
            return null;
        }
        this.f1017c.moveToPosition(i);
        if (view == null) {
            view = m2061b(this.f1018d, this.f1017c, viewGroup);
        }
        m2059a(view, this.f1018d, this.f1017c);
        return view;
    }

    public View m2061b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return m2057a(context, cursor, viewGroup);
    }

    public void m2058a(Cursor cursor) {
        Cursor b = m2060b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m2060b(Cursor cursor) {
        if (cursor == this.f1017c) {
            return null;
        }
        Cursor cursor2 = this.f1017c;
        if (cursor2 != null) {
            if (this.f1020f != null) {
                cursor2.unregisterContentObserver(this.f1020f);
            }
            if (this.f1021g != null) {
                cursor2.unregisterDataSetObserver(this.f1021g);
            }
        }
        this.f1017c = cursor;
        if (cursor != null) {
            if (this.f1020f != null) {
                cursor.registerContentObserver(this.f1020f);
            }
            if (this.f1021g != null) {
                cursor.registerDataSetObserver(this.f1021g);
            }
            this.f1019e = cursor.getColumnIndexOrThrow("_id");
            this.f1015a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1019e = -1;
        this.f1015a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence m2063c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor m2056a(CharSequence charSequence) {
        if (this.f1023i != null) {
            return this.f1023i.runQuery(charSequence);
        }
        return this.f1017c;
    }

    public Filter getFilter() {
        if (this.f1022h == null) {
            this.f1022h = new CursorFilter(this);
        }
        return this.f1022h;
    }

    protected void m2062b() {
        if (this.f1016b && this.f1017c != null && !this.f1017c.isClosed()) {
            this.f1015a = this.f1017c.requery();
        }
    }
}
