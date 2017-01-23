package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int f1164j;
    private int f1165k;
    private LayoutInflater f1166l;

    public View m2320a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1166l.inflate(this.f1164j, viewGroup, false);
    }

    public View m2321b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1166l.inflate(this.f1165k, viewGroup, false);
    }
}
