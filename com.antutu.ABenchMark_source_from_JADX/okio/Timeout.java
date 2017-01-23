package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
    public static final Timeout NONE;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* renamed from: okio.Timeout.1 */
    static class C45731 extends Timeout {
        C45731() {
        }

        public Timeout deadlineNanoTime(long j) {
            return this;
        }

        public void throwIfReached() {
        }

        public Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }
    }

    static {
        NONE = new C45731();
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + j);
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) {
        long j = 0;
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (hasDeadline || timeoutNanos != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline && timeoutNanos != 0) {
                    timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline) {
                    timeoutNanos = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos > 0) {
                    j = timeoutNanos / 1000000;
                    obj.wait(j, (int) (timeoutNanos - (j * 1000000)));
                    j = System.nanoTime() - nanoTime;
                }
                if (j >= timeoutNanos) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException("interrupted");
        }
    }
}
