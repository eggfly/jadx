package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter extends Filter {
    CursorFilterClient f1024a;

    interface CursorFilterClient {
        Cursor m2051a();

        Cursor m2052a(CharSequence charSequence);

        void m2053a(Cursor cursor);

        CharSequence m2054c(Cursor cursor);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f1024a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1024a.m2054c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1024a.m2052a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1024a.m2051a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1024a.m2053a((Cursor) filterResults.values);
        }
    }
}
