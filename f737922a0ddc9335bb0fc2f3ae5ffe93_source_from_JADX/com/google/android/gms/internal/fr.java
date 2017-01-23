package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

@eh
@TargetApi(14)
public final class fr extends fp {
    public fr(fj fjVar) {
        super(fjVar);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        j6(view, i, customViewCallback);
    }
}
