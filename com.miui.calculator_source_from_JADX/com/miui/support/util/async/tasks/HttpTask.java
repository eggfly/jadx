package com.miui.support.util.async.tasks;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.net.http.HttpRequestParams;
import com.miui.support.net.http.HttpResponse;
import com.miui.support.net.http.HttpSession;
import com.miui.support.net.http.HttpSession.ProgressListener;
import com.miui.support.util.async.Task;

public abstract class HttpTask<T> extends Task<T> {
    private final HttpSession f3808a;
    private final Method f3809b;
    private final String f3810c;
    private final HttpRequestParams f3811d;
    private ProgressListener f3812e;

    /* renamed from: com.miui.support.util.async.tasks.HttpTask.1 */
    class C04431 implements ProgressListener {
        final /* synthetic */ HttpTask f3814a;

        C04431(HttpTask httpTask) {
            this.f3814a = httpTask;
        }

        public void m5573a(long j, long j2) {
            if (j > 2147483647L) {
                j = (long) ((int) (((float) (j * 2147483647L)) / 9.223372E18f));
                j2 = (long) ((int) (((float) (j * 2147483647L)) / 9.223372E18f));
            }
            this.f3814a.m5473a((int) j, (int) j2);
        }
    }

    /* renamed from: com.miui.support.util.async.tasks.HttpTask.2 */
    /* synthetic */ class C04442 {
        static final /* synthetic */ int[] f3815a;

        static {
            f3815a = new int[Method.values().length];
            try {
                f3815a[Method.Get.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3815a[Method.Post.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum Method {
        Get,
        Post
    }

    public String m5559d() {
        return this.f3810c;
    }

    protected final HttpResponse m5560j() {
        if (this.f3812e == null) {
            this.f3812e = new C04431(this);
        }
        switch (C04442.f3815a[this.f3809b.ordinal()]) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return this.f3808a.m5149a(this.f3810c, null, this.f3811d, this.f3812e);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return this.f3808a.m5151b(this.f3810c, null, this.f3811d, this.f3812e);
            default:
                return null;
        }
    }
}
