package com.miui.support.util.async.tasks;

import android.net.Uri;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.async.Task;

public class ContentResolverDeleteTask extends Task<Integer> {
    private final Uri f3780a;
    private final String f3781b;
    private final String[] f3782c;
    private String f3783d;

    public /* synthetic */ Object m5536h() {
        return m5534a();
    }

    public String m5535d() {
        if (this.f3783d == null) {
            if (this.f3781b == null) {
                this.f3783d = this.f3780a.toString();
            } else {
                StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
                stringBuilder.append(this.f3780a);
                stringBuilder.append(" WHERE ");
                if (this.f3782c != null) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.f3782c[0]);
                    for (int i = 1; i < this.f3782c.length; i++) {
                        stringBuilder.append(';');
                        stringBuilder.append(this.f3782c[i]);
                    }
                    stringBuilder.append("]@");
                }
                stringBuilder.append(this.f3781b);
                this.f3783d = stringBuilder.toString();
                Pools.m5430a().m5401b(stringBuilder);
            }
        }
        return this.f3783d;
    }

    public Integer m5534a() {
        return Integer.valueOf(AppConstants.m4227a().getContentResolver().delete(this.f3780a, this.f3781b, this.f3782c));
    }
}
