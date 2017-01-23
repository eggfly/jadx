package com.miui.support.util.async;

import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Task<T> {
    private WeakReference<TaskManager> f3737a;
    private Priority f3738b;
    private Thread f3739c;
    private HashSet<Task<?>> f3740d;
    private final AtomicBoolean f3741e;
    private volatile Status f3742f;
    private ArrayList<Listener> f3743g;

    /* renamed from: com.miui.support.util.async.Task.1 */
    /* synthetic */ class C04351 {
        static final /* synthetic */ int[] f3718a;
        static final /* synthetic */ int[] f3719b;
        static final /* synthetic */ int[] f3720c;

        static {
            f3720c = new int[Delivery.values().length];
            try {
                f3720c[Delivery.Prepare.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3720c[Delivery.Finalize.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3720c[Delivery.Result.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3720c[Delivery.Progress.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f3719b = new int[Priority.values().length];
            try {
                f3719b[Priority.Low.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3719b[Priority.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3719b[Priority.High.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f3719b[Priority.RealTime.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            f3718a = new int[Status.values().length];
            try {
                f3718a[Status.Queued.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f3718a[Status.Canceled.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f3718a[Status.Executing.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f3718a[Status.Done.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f3718a[Status.New.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    enum Delivery {
        Prepare,
        Result,
        Progress,
        Finalize
    }

    public interface Listener {
        Object m5456a(TaskManager taskManager, Task<?> task, Object obj);

        void m5457a(TaskManager taskManager, Task<?> task);

        void m5458a(TaskManager taskManager, Task<?> task, int i, int i2);

        void m5459a(TaskManager taskManager, Task<?> task, Exception exception);

        void m5460b(TaskManager taskManager, Task<?> task);

        void m5461c(TaskManager taskManager, Task<?> task);
    }

    public enum Priority {
        Low,
        Normal,
        High,
        RealTime
    }

    public enum Status {
        New,
        Queued,
        Executing,
        Done,
        Canceled
    }

    public abstract T m5490h();

    public Task() {
        this(Priority.Normal);
    }

    public Task(Priority priority) {
        this.f3741e = new AtomicBoolean(false);
        this.f3742f = Status.New;
        this.f3738b = priority;
    }

    final void m5474a(Status status, Object obj) {
        switch (C04351.f3718a[this.f3742f.ordinal()]) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                switch (C04351.f3718a[status.ordinal()]) {
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        m5462a(Delivery.Result, null);
                        m5462a(Delivery.Finalize, null);
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        break;
                    default:
                        Log.w("async", "Task " + this + " error status change=> " + status);
                        return;
                }
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                Log.w("async", "Task " + this + " error status change=> " + status);
                return;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                switch (C04351.f3718a[status.ordinal()]) {
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        m5462a(Delivery.Result, null);
                        m5462a(Delivery.Finalize, null);
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        m5462a(Delivery.Result, obj);
                        m5462a(Delivery.Finalize, null);
                        break;
                    default:
                        Log.w("async", "Task " + this + " error status change=> " + status);
                        return;
                }
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                switch (C04351.f3718a[status.ordinal()]) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        m5462a(Delivery.Prepare, null);
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        m5462a(Delivery.Result, null);
                        m5462a(Delivery.Finalize, null);
                        break;
                    default:
                        Log.w("async", "Task " + this + " error status change=> " + status);
                        return;
                }
        }
        this.f3742f = status;
    }

    public final Status m5481b() {
        return this.f3742f;
    }

    public final boolean m5484c() {
        return this.f3742f == Status.Queued || this.f3742f == Status.Executing;
    }

    private final boolean m5463a() {
        return this.f3742f == Status.Canceled;
    }

    final void m5479a(Thread thread) {
        this.f3739c = thread;
        if (thread != null) {
            switch (C04351.f3719b[this.f3738b.ordinal()]) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    thread.setPriority(1);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    thread.setPriority(5);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    thread.setPriority(10);
                default:
            }
        }
    }

    final boolean m5480a(TaskManager taskManager) {
        if (this.f3737a != null && this.f3737a.get() != null) {
            return false;
        }
        this.f3737a = new WeakReference(taskManager);
        return true;
    }

    private void m5467e(TaskManager taskManager) {
        synchronized (this.f3741e) {
            if (this.f3740d != null) {
                Iterator it = this.f3740d.iterator();
                while (it.hasNext()) {
                    taskManager.m5507a((Task) it.next());
                }
            }
            this.f3741e.set(true);
        }
    }

    private boolean m5471i() {
        if (this.f3742f == Status.Executing) {
            return false;
        }
        synchronized (this.f3741e) {
            if (this.f3742f != Status.Done || this.f3741e.get()) {
                if (this.f3740d != null) {
                    Iterator it = this.f3740d.iterator();
                    while (it.hasNext()) {
                        if (!((Task) it.next()).m5471i()) {
                            return false;
                        }
                    }
                }
                return true;
            }
            Log.e("async", "Task " + this + " is DONE but successor not done yet");
            return false;
        }
    }

    private void m5462a(Delivery delivery, Object obj) {
        TaskManager taskManager = (TaskManager) this.f3737a.get();
        if (taskManager != null) {
            taskManager.m5508a(this, delivery, obj);
        } else {
            Log.e("async", "Task has delivery " + delivery + ", but has no task manager");
        }
    }

    final void m5476a(TaskManager taskManager, Delivery delivery, Object obj) {
        switch (C04351.f3720c[delivery.ordinal()]) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                m5470h(taskManager);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                m5469g(taskManager);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (obj == null || m5463a()) {
                    m5468f(taskManager);
                } else if (obj instanceof TaskExecutingException) {
                    m5465b(taskManager, (Exception) ((TaskExecutingException) obj).getCause());
                } else {
                    try {
                        m5466b(taskManager, obj);
                        m5467e(taskManager);
                    } catch (Exception e) {
                        Log.e("async", "Task " + this + " return result cannot cast to expectation class");
                        m5465b(taskManager, e);
                    }
                }
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                m5464b(taskManager, ((int[]) obj)[0], ((int[]) obj)[1]);
            default:
        }
    }

    private void m5468f(TaskManager taskManager) {
        if (this.f3743g != null) {
            Iterator it = this.f3743g.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).m5460b(taskManager, this);
            }
        }
        m5483c(taskManager);
    }

    private void m5464b(TaskManager taskManager, int i, int i2) {
        if (this.f3743g != null) {
            Iterator it = this.f3743g.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).m5458a(taskManager, this, i, i2);
            }
        }
        m5475a(taskManager, i, i2);
    }

    private void m5466b(TaskManager taskManager, T t) {
        Object a;
        if (this.f3743g != null) {
            Iterator it = this.f3743g.iterator();
            while (it.hasNext()) {
                a = ((Listener) it.next()).m5456a(taskManager, this, a);
            }
        }
        m5478a(taskManager, a);
    }

    private void m5465b(TaskManager taskManager, Exception exception) {
        if (this.f3743g != null) {
            Iterator it = this.f3743g.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).m5459a(taskManager, this, exception);
            }
        }
        m5477a(taskManager, exception);
    }

    private void m5469g(TaskManager taskManager) {
        if (this.f3743g != null) {
            Iterator it = this.f3743g.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).m5461c(taskManager, this);
            }
        }
        m5486d(taskManager);
        this.f3737a.clear();
    }

    private void m5470h(TaskManager taskManager) {
        if (this.f3743g != null) {
            Iterator it = this.f3743g.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).m5457a(taskManager, this);
            }
        }
        m5482b(taskManager);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        String d = m5485d();
        if (d != null) {
            stringBuilder.append('<');
            stringBuilder.append(d);
            stringBuilder.append('>');
        }
        stringBuilder.append(": Status=");
        stringBuilder.append(this.f3742f);
        stringBuilder.append(", Priority=");
        stringBuilder.append(this.f3738b);
        return stringBuilder.toString();
    }

    public String m5485d() {
        return null;
    }

    public final void m5473a(int i, int i2) {
        m5462a(Delivery.Progress, new int[]{i, i2});
    }

    public final Task<T> m5472a(Listener listener) {
        if (this.f3743g != null) {
            this.f3743g.remove(listener);
        }
        return this;
    }

    public final void m5487e() {
        if (this.f3742f != Status.Done) {
            if (this.f3742f == Status.Queued) {
                TaskManager taskManager = (TaskManager) this.f3737a.get();
                if (taskManager != null) {
                    taskManager.m5510b(this);
                }
            }
            m5474a(Status.Canceled, null);
        }
    }

    public final Priority m5488f() {
        return this.f3738b;
    }

    public final boolean m5489g() {
        if (!m5471i()) {
            return false;
        }
        if (this.f3742f == Status.Queued) {
            TaskManager taskManager = (TaskManager) this.f3737a.get();
            if (taskManager == null || !taskManager.m5510b(this)) {
                return false;
            }
        }
        if (this.f3742f == Status.Executing) {
            return false;
        }
        synchronized (this.f3741e) {
            if (this.f3740d != null) {
                Iterator it = this.f3740d.iterator();
                while (it.hasNext()) {
                    ((Task) it.next()).m5489g();
                }
            }
            this.f3741e.set(true);
        }
        this.f3742f = Status.New;
        return true;
    }

    public void m5482b(TaskManager taskManager) {
    }

    public void m5483c(TaskManager taskManager) {
    }

    public void m5478a(TaskManager taskManager, T t) {
    }

    public void m5477a(TaskManager taskManager, Exception exception) {
    }

    public void m5475a(TaskManager taskManager, int i, int i2) {
    }

    public void m5486d(TaskManager taskManager) {
    }
}
