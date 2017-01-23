package com.miui.support.util.async.tasks;

import android.content.ContentValues;
import android.net.Uri;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.async.Task;

public class ContentResolverUpdateTask extends Task<Integer> {
    private final Uri f3799a;
    private final ContentValues f3800b;
    private final String f3801c;
    private final String[] f3802d;
    private String f3803e;

    public /* synthetic */ Object m5547h() {
        return m5545a();
    }

    public String m5546d() {
        if (this.f3803e == null) {
            if (this.f3801c == null) {
                this.f3803e = this.f3799a.toString();
            } else {
                StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
                stringBuilder.append(this.f3799a.toString());
                stringBuilder.append(" WHERE ");
                if (this.f3802d != null) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.f3802d[0]);
                    for (int i = 1; i < this.f3802d.length; i++) {
                        stringBuilder.append(';');
                        stringBuilder.append(this.f3802d[i]);
                    }
                    stringBuilder.append("]@");
                }
                stringBuilder.append(this.f3801c);
                this.f3803e = stringBuilder.toString();
                Pools.m5430a().m5401b(stringBuilder);
            }
        }
        return this.f3803e;
    }

    public Integer m5545a() {
        return Integer.valueOf(AppConstants.m4227a().getContentResolver().update(this.f3799a, this.f3800b, this.f3801c, this.f3802d));
    }
}
