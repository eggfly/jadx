package com.miui.support.util.async;

import com.miui.support.util.async.Task.Status;
import com.miui.support.util.cache.Cache;

class TaskThread extends Thread {
    private final TaskManager f3771a;
    private final TaskQueue f3772b;
    private volatile boolean f3773c;

    /* renamed from: com.miui.support.util.async.TaskThread.1 */
    final class C04421 extends Thread {
        final /* synthetic */ TaskManager f3769a;
        final /* synthetic */ Task f3770b;

        C04421(TaskManager taskManager, Task task) {
            this.f3769a = taskManager;
            this.f3770b = task;
        }

        public void run() {
            TaskThread.m5526b(this.f3769a, this, this.f3770b);
        }
    }

    public TaskThread(TaskManager taskManager, TaskQueue taskQueue, int i) {
        this.f3771a = taskManager;
        this.f3772b = taskQueue;
        this.f3773c = false;
        setName("TaskThread-" + i);
    }

    public static void m5524a(TaskManager taskManager, Task<?> task) {
        Thread c04421 = new C04421(taskManager, task);
        c04421.setName("TaskThread-RealTime");
        c04421.start();
    }

    public void m5527a() {
        this.f3773c = true;
        interrupt();
    }

    public void run() {
        TaskQueue taskQueue = this.f3772b;
        while (!this.f3773c) {
            Task a = taskQueue.m5517a();
            if (a != null) {
                m5526b(this.f3771a, this, a);
                setPriority(5);
            }
        }
    }

    private static void m5526b(TaskManager taskManager, Thread thread, Task<?> task) {
        Object h;
        Object obj;
        Exception e;
        Cache d;
        Cacheable cacheable;
        if (taskManager != null && task != null) {
            task.m5474a(Status.Executing, null);
            task.m5479a(thread);
            try {
                h = task.m5490h();
                try {
                    task.m5474a(Status.Done, h == null ? new NullPointerException("result is null") : h);
                    obj = h;
                } catch (Exception e2) {
                    e = e2;
                    task.m5474a(Status.Done, new TaskExecutingException(e));
                    obj = h;
                    d = taskManager.m5512d();
                    cacheable = (Cacheable) task;
                    if (cacheable.m5455a() != null) {
                        d.m5600a(cacheable.m5455a(), obj, cacheable.m5454a(obj));
                    }
                    task.m5479a(null);
                }
            } catch (Exception e3) {
                e = e3;
                h = null;
                task.m5474a(Status.Done, new TaskExecutingException(e));
                obj = h;
                d = taskManager.m5512d();
                cacheable = (Cacheable) task;
                if (cacheable.m5455a() != null) {
                    d.m5600a(cacheable.m5455a(), obj, cacheable.m5454a(obj));
                }
                task.m5479a(null);
            }
            d = taskManager.m5512d();
            if (!(d == null || obj == null || !(task instanceof Cacheable))) {
                cacheable = (Cacheable) task;
                if (cacheable.m5455a() != null) {
                    d.m5600a(cacheable.m5455a(), obj, cacheable.m5454a(obj));
                }
            }
            task.m5479a(null);
        }
    }
}
