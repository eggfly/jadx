package com.baidu.mobads.production.p100d;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

/* renamed from: com.baidu.mobads.production.d.a */
public interface C2036a {
    void m7651a(int i, int i2);

    void m7652a(Activity activity);

    void m7653a(Activity activity, RelativeLayout relativeLayout);

    boolean m7654a(int i, KeyEvent keyEvent);

    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void m7655k();

    void m7656l();

    boolean m7657q();

    void request();
}
