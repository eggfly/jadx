package com.antutu.utils;

import android.os.Handler;
import android.os.Message;

public abstract class TaskItem implements Runnable {
    public static final int ERROR = -1;
    protected static final int EXECUTE_ERROR = 2;
    public static final int SUC = 0;
    protected static final int THREAD_FINISHED = 0;
    protected static final int THREAD_RUNNING = 1;
    protected static final int THREAD_WAIT = -1;
    private Handler mHanler;
    private int state;

    /* renamed from: com.antutu.utils.TaskItem.1 */
    class C18081 extends Handler {
        C18081() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            TaskItem.this.handleMsg(message);
        }
    }

    public TaskItem() {
        this.mHanler = new C18081();
        this.state = THREAD_WAIT;
    }

    abstract void conbineUrl();

    abstract Object exe();

    protected int getTaskState() {
        return this.state;
    }

    abstract void handleMsg(Message message);

    public void run() {
        this.state = THREAD_RUNNING;
        Message obtainMessage;
        try {
            conbineUrl();
            Object exe = exe();
            this.state = THREAD_FINISHED;
            obtainMessage = this.mHanler.obtainMessage(THREAD_FINISHED, exe);
        } catch (Exception e) {
            this.state = EXECUTE_ERROR;
            obtainMessage = this.mHanler.obtainMessage(THREAD_WAIT, null);
        } finally {
            this.mHanler.sendMessage(null);
        }
    }
}
