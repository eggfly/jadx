package com.miui.support.app;

import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public interface IFragment extends IImmersionMenu {
    Context m3283a();

    View m3284a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void m3285a(int i, View view, Menu menu);

    void m3286a(ActionMode actionMode);

    boolean m3287a(int i, Menu menu);

    boolean m3288a(Menu menu);

    void m3289b(ActionMode actionMode);
}
