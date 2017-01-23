package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
    private final ViewGroup f785a;
    private int f786b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.f785a = viewGroup;
    }

    public void m1310a(View view, View view2, int i) {
        this.f786b = i;
    }

    public int m1308a() {
        return this.f786b;
    }

    public void m1309a(View view) {
        this.f786b = 0;
    }
}
