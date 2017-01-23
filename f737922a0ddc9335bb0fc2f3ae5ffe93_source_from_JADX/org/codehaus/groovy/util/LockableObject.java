package org.codehaus.groovy.util;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class LockableObject extends AbstractQueuedSynchronizer {
    transient Thread Hw;

    protected final boolean isHeldExclusively() {
        return getState() != 0 && this.Hw == Thread.currentThread();
    }

    public final void Hw() {
        if (compareAndSetState(0, 1)) {
            this.Hw = Thread.currentThread();
        } else {
            acquire(1);
        }
    }

    public final void v5() {
        release(1);
    }

    protected final boolean tryAcquire(int i) {
        Thread currentThread = Thread.currentThread();
        int state = getState();
        if (state == 0) {
            if (compareAndSetState(0, i)) {
                this.Hw = currentThread;
                return true;
            }
        } else if (currentThread == this.Hw) {
            setState(state + i);
            return true;
        }
        return false;
    }

    protected final boolean tryRelease(int i) {
        int state = getState() - i;
        if (Thread.currentThread() != this.Hw) {
            throw new IllegalMonitorStateException();
        }
        boolean z = false;
        if (state == 0) {
            z = true;
            this.Hw = null;
        }
        setState(state);
        return z;
    }
}
