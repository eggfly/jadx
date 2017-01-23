package com.miui.support.internal.view;

import android.content.Context;
import android.view.ActionMode.Callback;
import com.miui.support.view.SearchActionMode;

public class SearchActionModeImpl extends ActionModeImpl implements SearchActionMode {
    public SearchActionModeImpl(Context context, Callback callback) {
        super(context, callback);
    }
}
