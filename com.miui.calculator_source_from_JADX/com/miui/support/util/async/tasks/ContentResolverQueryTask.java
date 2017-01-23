package com.miui.support.util.async.tasks;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.async.Task;
import com.miui.support.util.async.TaskManager;
import java.lang.ref.WeakReference;

public abstract class ContentResolverQueryTask<T> extends Task<T> {
    private final Uri f3788a;
    private final String[] f3789b;
    private final String f3790c;
    private final String[] f3791d;
    private final String f3792e;
    private boolean f3793f;
    private boolean f3794g;
    private boolean f3795h;
    private UriObserver f3796i;
    private WeakReference<TaskManager> f3797j;
    private String f3798k;

    public class Cookie {
    }

    private static class UriObserver extends ContentObserver {
        private final WeakReference<ContentResolverQueryTask> f3787a;

        public void onChange(boolean z) {
            ContentResolverQueryTask contentResolverQueryTask = (ContentResolverQueryTask) this.f3787a.get();
            if (contentResolverQueryTask != null) {
                contentResolverQueryTask.m5544k();
            }
        }
    }

    public void m5542i() {
        this.f3793f = false;
        if (this.f3796i != null) {
            AppConstants.m4227a().getContentResolver().unregisterContentObserver(this.f3796i);
            this.f3796i = null;
        }
    }

    public String m5541d() {
        int i = 1;
        if (this.f3798k == null) {
            StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
            if (this.f3789b != null) {
                stringBuilder.append('[');
                stringBuilder.append(this.f3789b[0]);
                for (int i2 = 1; i2 < this.f3789b.length; i2++) {
                    stringBuilder.append(';');
                    stringBuilder.append(this.f3789b[i2]);
                }
                stringBuilder.append("]@");
            }
            stringBuilder.append(this.f3788a);
            if (this.f3790c != null) {
                stringBuilder.append(" WHERE ");
                if (this.f3791d != null) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.f3791d[0]);
                    while (i < this.f3791d.length) {
                        stringBuilder.append(';');
                        stringBuilder.append(this.f3791d[i]);
                        i++;
                    }
                    stringBuilder.append("]@");
                }
                stringBuilder.append(this.f3790c);
            }
            if (this.f3792e != null) {
                stringBuilder.append(" ORDER BY ");
                stringBuilder.append(this.f3792e);
            }
            this.f3798k = stringBuilder.toString();
            Pools.m5430a().m5401b(stringBuilder);
        }
        return this.f3798k;
    }

    protected Cursor m5543j() {
        return AppConstants.m4227a().getContentResolver().query(this.f3788a, this.f3789b, this.f3790c, this.f3791d, this.f3792e);
    }

    void m5544k() {
        if (this.f3794g) {
            this.f3795h = true;
        } else if (this.f3797j != null) {
            TaskManager taskManager = (TaskManager) this.f3797j.get();
            if (taskManager != null) {
                m5489g();
                taskManager.m5507a(this);
                return;
            }
            m5542i();
        }
    }

    public void m5540b(TaskManager taskManager) {
        this.f3797j = new WeakReference(taskManager);
    }
}
