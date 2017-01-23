package com.miui.support.util.async;

import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.async.Task.Priority;
import com.miui.support.util.async.Task.Status;
import com.miui.support.util.concurrent.ConcurrentRingQueue;
import com.miui.support.util.concurrent.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

class TaskQueue implements Queue<Task<?>> {
    private final Queue<Task<?>> f3763a;
    private final Queue<Task<?>> f3764b;
    private final Queue<Task<?>> f3765c;
    private final Semaphore f3766d;
    private final AtomicBoolean f3767e;
    private final TaskManager f3768f;

    /* renamed from: com.miui.support.util.async.TaskQueue.1 */
    /* synthetic */ class C04411 {
        static final /* synthetic */ int[] f3762a;

        static {
            f3762a = new int[Priority.values().length];
            try {
                f3762a[Priority.Low.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3762a[Priority.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3762a[Priority.High.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3762a[Priority.RealTime.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public /* synthetic */ boolean m5519a(Object obj) {
        return m5521b((Task) obj);
    }

    public /* synthetic */ boolean m5522b(Object obj) {
        return m5518a((Task) obj);
    }

    public /* synthetic */ Object m5523c() {
        return m5517a();
    }

    public TaskQueue(TaskManager taskManager, int i) {
        this.f3768f = taskManager;
        this.f3763a = new ConcurrentRingQueue(i, true, true);
        this.f3764b = new ConcurrentRingQueue(i, true, true);
        this.f3765c = new ConcurrentRingQueue(i, true, true);
        this.f3766d = new Semaphore(0, true);
        this.f3767e = new AtomicBoolean(false);
    }

    public boolean m5518a(Task<?> task) {
        boolean z = false;
        switch (C04411.f3762a[task.m5488f().ordinal()]) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                z = this.f3765c.m5514b(task);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                z = this.f3764b.m5514b(task);
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                z = this.f3763a.m5514b(task);
                break;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                Log.e("async", "Realtime task must NOT be put in Queue");
                break;
        }
        if (z) {
            task.m5474a(Status.Queued, null);
            this.f3766d.release();
        }
        return z;
    }

    private Task<?> m5516d() {
        Task<?> task = (Task) this.f3763a.m5515c();
        if (task == null) {
            task = (Task) this.f3764b.m5515c();
        }
        if (task == null) {
            return (Task) this.f3765c.m5515c();
        }
        return task;
    }

    public Task<?> m5517a() {
        Task<?> task = null;
        if (this.f3768f.m5511c()) {
            while (this.f3766d.tryAcquire()) {
                task = m5516d();
                if (task.m5481b() != Status.Canceled) {
                    return task;
                }
            }
            return task;
        }
        Task<?> task2 = null;
        while (task2 == null) {
            try {
                this.f3766d.acquire();
                if (this.f3767e.get()) {
                    synchronized (this.f3767e) {
                        while (this.f3767e.get()) {
                            try {
                                this.f3767e.wait();
                            } catch (InterruptedException e) {
                                this.f3766d.release();
                                return null;
                            }
                        }
                    }
                }
                task2 = m5516d();
                if (task2.m5481b() == Status.Canceled) {
                    task2 = null;
                }
            } catch (InterruptedException e2) {
                return null;
            }
        }
        return task2;
    }

    public boolean m5521b(Task<?> task) {
        boolean z = false;
        if (this.f3766d.tryAcquire()) {
            z = this.f3763a.m5513a(task);
            if (!z) {
                z = this.f3764b.m5513a(task);
            }
            if (!z) {
                z = this.f3765c.m5513a(task);
            }
            if (!z) {
                this.f3766d.release();
            }
        }
        return z;
    }

    public boolean m5520b() {
        return this.f3766d.availablePermits() == 0;
    }
}
