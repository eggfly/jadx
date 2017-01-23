package com.miui.support.util.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.Pools.Manager;
import com.miui.support.util.Pools.Pool;
import com.miui.support.util.concurrent.ConcurrentRingQueue;
import com.miui.support.util.concurrent.Queue.Predicate;

class TaskInfoDeliverer {
    private static final Pool<TaskDeliveryInfo> f3750a;
    private TaskManager f3751b;
    private DeliverHandler f3752c;
    private ConcurrentRingQueue<TaskDeliveryInfo> f3753d;

    /* renamed from: com.miui.support.util.async.TaskInfoDeliverer.1 */
    final class C04361 extends Manager<TaskDeliveryInfo> {
        C04361() {
        }

        public /* synthetic */ Object m5494b() {
            return m5491a();
        }

        public TaskDeliveryInfo m5491a() {
            return new TaskDeliveryInfo();
        }

        public void m5492a(TaskDeliveryInfo taskDeliveryInfo) {
            taskDeliveryInfo.m5499a();
        }
    }

    /* renamed from: com.miui.support.util.async.TaskInfoDeliverer.2 */
    class C04372 extends Thread {
        final /* synthetic */ TaskInfoDeliverer f3744a;

        public void run() {
            Looper.prepare();
            this.f3744a.f3752c = new DeliverHandler(Looper.myLooper());
            Looper.loop();
        }
    }

    /* renamed from: com.miui.support.util.async.TaskInfoDeliverer.3 */
    class C04383 implements Predicate<TaskDeliveryInfo> {
        final /* synthetic */ Task f3745a;
        final /* synthetic */ TaskInfoDeliverer f3746b;

        C04383(TaskInfoDeliverer taskInfoDeliverer, Task task) {
            this.f3746b = taskInfoDeliverer;
            this.f3745a = task;
        }

        public boolean m5496a(TaskDeliveryInfo taskDeliveryInfo) {
            return taskDeliveryInfo != null && taskDeliveryInfo.f3747a == this.f3745a;
        }
    }

    private static class DeliverHandler extends Handler {
        public DeliverHandler(Looper looper) {
            super(looper);
        }

        public void m5498a(TaskInfoDeliverer taskInfoDeliverer) {
            obtainMessage(0, taskInfoDeliverer).sendToTarget();
        }

        public void handleMessage(Message message) {
            ((TaskInfoDeliverer) message.obj).m5501a();
            message.obj = null;
        }
    }

    static class TaskDeliveryInfo {
        public Task<?> f3747a;
        public Delivery f3748b;
        public Object f3749c;

        TaskDeliveryInfo() {
        }

        public void m5499a() {
            this.f3747a = null;
            this.f3748b = null;
            this.f3749c = null;
        }
    }

    static {
        f3750a = Pools.m5431a(new C04361(), 8);
    }

    public TaskInfoDeliverer(TaskManager taskManager) {
        this.f3751b = taskManager;
        this.f3752c = new DeliverHandler(AppConstants.m4227a().getMainLooper());
        this.f3753d = new ConcurrentRingQueue(20, true, true);
    }

    public void m5503a(Task<?> task, Delivery delivery, Object obj) {
        Object obj2 = (TaskDeliveryInfo) f3750a.m5400b();
        obj2.f3747a = task;
        obj2.f3748b = delivery;
        obj2.f3749c = obj;
        if (delivery == Delivery.Result && obj == null) {
            this.f3753d.m5612a(new C04383(this, task));
        }
        this.f3753d.m5618b(obj2);
        m5501a();
    }

    private void m5501a() {
        if (Looper.myLooper() == this.f3752c.getLooper()) {
            while (!this.f3753d.m5614a()) {
                TaskDeliveryInfo taskDeliveryInfo = (TaskDeliveryInfo) this.f3753d.m5619c();
                if (taskDeliveryInfo != null) {
                    taskDeliveryInfo.f3747a.m5476a(this.f3751b, taskDeliveryInfo.f3748b, taskDeliveryInfo.f3749c);
                    f3750a.m5401b(taskDeliveryInfo);
                }
            }
            return;
        }
        this.f3752c.m5498a(this);
    }
}
