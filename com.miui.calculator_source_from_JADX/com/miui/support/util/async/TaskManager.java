package com.miui.support.util.async;

import android.util.Log;
import com.miui.support.os.Environment;
import com.miui.support.util.SoftReferenceSingleton;
import com.miui.support.util.async.Task.Priority;
import com.miui.support.util.async.Task.Status;
import com.miui.support.util.cache.Cache;
import com.miui.support.util.cache.LruCache;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskManager {
    private static final SoftReferenceSingleton<TaskManager> f3755a;
    private volatile boolean f3756b;
    private final TaskQueue f3757c;
    private Cache<String, Object> f3758d;
    private TaskInfoDeliverer f3759e;
    private ArrayList<TaskThread> f3760f;
    private Object f3761g;

    /* renamed from: com.miui.support.util.async.TaskManager.1 */
    final class C04391 extends SoftReferenceSingleton<TaskManager> {
        C04391() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5504a();
        }

        protected TaskManager m5504a() {
            return new TaskManager();
        }
    }

    /* renamed from: com.miui.support.util.async.TaskManager.2 */
    class C04402 {
        final /* synthetic */ TaskManager f3754a;

        C04402(TaskManager taskManager) {
            this.f3754a = taskManager;
        }

        protected void finalize() {
            try {
                this.f3754a.m5509b();
            } finally {
                super.finalize();
            }
        }
    }

    static {
        f3755a = new C04391();
    }

    public TaskManager() {
        this(10, -1, -1);
    }

    public TaskManager(int i, int i2, int i3) {
        this.f3761g = new C04402(this);
        this.f3756b = false;
        this.f3757c = new TaskQueue(this, i);
        if (i2 < 0) {
            i2 = Environment.m5178d();
            if (i2 <= 0) {
                i2 = 4;
            }
        }
        this.f3760f = new ArrayList(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            this.f3760f.add(new TaskThread(this, this.f3757c, i4));
            ((TaskThread) this.f3760f.get(i4)).start();
        }
        this.f3759e = new TaskInfoDeliverer(this);
        this.f3758d = new LruCache(i3);
    }

    public static TaskManager m5505a() {
        return (TaskManager) f3755a.get();
    }

    public void m5507a(Task<?> task) {
        if (this.f3756b) {
            Log.e("async", "Cannot add task into a shut down task manager");
        } else if (task.m5484c()) {
            String str = "Task " + task + " has already added into task manager and not finish yet";
            Log.e("async", str);
            throw new IllegalArgumentException(str);
        } else if (task.m5481b() != Status.New && !task.m5489g()) {
            throw new IllegalArgumentException("Status of task " + task + " is not New, and cannot restart.");
        } else if (task.m5480a(this)) {
            if (this.f3758d != null && (task instanceof Cacheable)) {
                Object a = this.f3758d.m5598a(((Cacheable) task).m5455a());
                if (a != null) {
                    task.m5474a(Status.Queued, null);
                    task.m5474a(Status.Executing, null);
                    task.m5474a(Status.Done, a);
                    return;
                }
            }
            if (task.m5488f() == Priority.RealTime) {
                task.m5474a(Status.Queued, null);
                TaskThread.m5524a(this, task);
                return;
            }
            this.f3757c.m5518a((Task) task);
        } else {
            throw new IllegalArgumentException("Task " + task + " has already added into task manager and not finish yet");
        }
    }

    public void m5509b() {
        if (this != m5505a() && !this.f3756b) {
            this.f3756b = true;
            Iterator it = this.f3760f.iterator();
            while (it.hasNext()) {
                ((TaskThread) it.next()).m5527a();
            }
            this.f3760f.clear();
            this.f3758d.m5599a();
            m5506e();
        }
    }

    private void m5506e() {
        while (!this.f3757c.m5520b()) {
            Task a = this.f3757c.m5517a();
            if (a != null) {
                a.m5474a(Status.Canceled, null);
            }
        }
    }

    boolean m5511c() {
        return this.f3756b;
    }

    Cache<String, Object> m5512d() {
        return this.f3758d;
    }

    boolean m5510b(Task<?> task) {
        return this.f3757c.m5521b((Task) task);
    }

    void m5508a(Task<?> task, Delivery delivery, Object obj) {
        this.f3759e.m5503a(task, delivery, obj);
    }
}
