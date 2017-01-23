package com.miui.support.util.async.tasks;

import android.content.ContentValues;
import android.net.Uri;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.async.Task;

public class ContentResolverBulkInsertTask extends Task<Integer> {
    private final Uri f3777a;
    private final ContentValues[] f3778b;
    private String f3779c;

    public /* synthetic */ Object m5533h() {
        return m5531a();
    }

    public String m5532d() {
        if (this.f3779c == null) {
            StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
            stringBuilder.append('[');
            if (this.f3778b.length == 0) {
                stringBuilder.append("NULL");
            } else {
                stringBuilder.append(this.f3778b[0]);
                int length = this.f3778b.length;
                for (int i = 1; i < length; i++) {
                    stringBuilder.append("; ");
                    stringBuilder.append(this.f3778b[i]);
                }
            }
            stringBuilder.append("]@");
            stringBuilder.append(this.f3777a);
            this.f3779c = stringBuilder.toString();
            Pools.m5430a().m5401b(stringBuilder);
        }
        return this.f3779c;
    }

    public Integer m5531a() {
        return Integer.valueOf(AppConstants.m4227a().getContentResolver().bulkInsert(this.f3777a, this.f3778b));
    }
}
