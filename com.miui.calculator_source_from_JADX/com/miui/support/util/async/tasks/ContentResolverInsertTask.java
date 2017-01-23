package com.miui.support.util.async.tasks;

import android.content.ContentValues;
import android.net.Uri;
import com.miui.support.util.AppConstants;
import com.miui.support.util.async.Task;

public class ContentResolverInsertTask extends Task<Uri> {
    private final Uri f3784a;
    private final ContentValues f3785b;
    private String f3786c;

    public /* synthetic */ Object m5539h() {
        return m5537a();
    }

    public String m5538d() {
        if (this.f3786c == null) {
            this.f3786c = this.f3785b.toString() + '@' + this.f3784a;
        }
        return this.f3786c;
    }

    public Uri m5537a() {
        return AppConstants.m4227a().getContentResolver().insert(this.f3784a, this.f3785b);
    }
}
