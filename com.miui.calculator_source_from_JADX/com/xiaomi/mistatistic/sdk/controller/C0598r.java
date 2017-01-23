package com.xiaomi.mistatistic.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.GridView;
import android.widget.ListView;
import com.xiaomi.mistatistic.sdk.data.C0600a;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* renamed from: com.xiaomi.mistatistic.sdk.controller.r */
public class C0598r {
    private List<C0600a> f4807a;

    public C0598r() {
        this.f4807a = new ArrayList();
    }

    public void m6540a(View view) {
        if (VERSION.SDK_INT >= 15) {
            if (view.hasOnClickListeners()) {
                this.f4807a.add(new C0600a(view));
            } else if (m6537b(view)) {
                this.f4807a.add(new C0600a(view));
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m6540a(viewGroup.getChildAt(i));
                }
            }
        }
    }

    private boolean m6537b(View view) {
        ViewParent parent = view.getParent();
        return (parent instanceof ListView) || (parent instanceof GridView);
    }

    public void m6539a(Activity activity) {
        m6540a(activity.getWindow().getDecorView().getRootView());
    }

    public List<C0600a> m6538a() {
        return this.f4807a;
    }
}
