package com.miui.support.util.async.tasks;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.async.Task;
import java.util.ArrayList;

public class ContentResolverBatchTask extends Task<ContentProviderResult[]> {
    private final String f3774a;
    private final ArrayList<ContentProviderOperation> f3775b;
    private String f3776c;

    public /* synthetic */ Object m5530h() {
        return m5528a();
    }

    public String m5529d() {
        if (this.f3776c == null) {
            StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
            stringBuilder.append('[');
            if (this.f3775b.size() == 0) {
                stringBuilder.append("NULL");
            } else {
                stringBuilder.append(this.f3775b.get(0));
                int size = this.f3775b.size();
                for (int i = 1; i < size; i++) {
                    stringBuilder.append("; ");
                    stringBuilder.append(this.f3775b.get(i));
                }
            }
            stringBuilder.append("]@");
            stringBuilder.append(this.f3774a);
            this.f3776c = stringBuilder.toString();
            Pools.m5430a().m5401b(stringBuilder);
        }
        return this.f3776c;
    }

    public ContentProviderResult[] m5528a() {
        return AppConstants.m4227a().getContentResolver().applyBatch(this.f3774a, this.f3775b);
    }
}
