package okio;

import com.umeng.message.proguard.C4233j;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* renamed from: okio.AsyncTimeout.1 */
    class C45631 implements Sink {
        final /* synthetic */ Sink val$sink;

        C45631(Sink sink) {
            this.val$sink = sink;
        }

        public void close() {
            AsyncTimeout.this.enter();
            try {
                this.val$sink.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
            }
        }

        public void flush() {
            AsyncTimeout.this.enter();
            try {
                this.val$sink.flush();
                AsyncTimeout.this.exit(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.val$sink + C4233j.f14397t;
        }

        public void write(Buffer buffer, long j) {
            Util.checkOffsetAndCount(buffer.size, AsyncTimeout.IDLE_TIMEOUT_NANOS, j);
            long j2 = j;
            while (j2 > AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                Segment segment = buffer.head;
                long j3 = AsyncTimeout.IDLE_TIMEOUT_NANOS;
                while (j3 < 65536) {
                    long j4 = ((long) (buffer.head.limit - buffer.head.pos)) + j3;
                    if (j4 >= j2) {
                        j3 = j2;
                        break;
                    } else {
                        segment = segment.next;
                        j3 = j4;
                    }
                }
                AsyncTimeout.this.enter();
                try {
                    this.val$sink.write(buffer, j3);
                    j2 -= j3;
                    AsyncTimeout.this.exit(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.exit(e);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                }
            }
        }
    }

    /* renamed from: okio.AsyncTimeout.2 */
    class C45642 implements Source {
        final /* synthetic */ Source val$source;

        C45642(Source source) {
            this.val$source = source;
        }

        public void close() {
            try {
                this.val$source.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
            }
        }

        public long read(Buffer buffer, long j) {
            AsyncTimeout.this.enter();
            try {
                long read = this.val$source.read(buffer, j);
                AsyncTimeout.this.exit(true);
                return read;
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.val$source + C4233j.f14397t;
        }
    }

    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        AsyncTimeout awaitTimeout = AsyncTimeout.awaitTimeout();
                        if (awaitTimeout == null) {
                        } else if (awaitTimeout == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        } else {
                            awaitTimeout.timedOut();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static {
        IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    }

    static AsyncTimeout awaitTimeout() {
        AsyncTimeout asyncTimeout = head.next;
        long nanoTime;
        if (asyncTimeout == null) {
            nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            return (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) ? null : head;
        } else {
            nanoTime = asyncTimeout.remainingNanos(System.nanoTime());
            if (nanoTime > IDLE_TIMEOUT_NANOS) {
                long j = nanoTime / 1000000;
                AsyncTimeout.class.wait(j, (int) (nanoTime - (1000000 * j)));
                return null;
            }
            head.next = asyncTimeout.next;
            asyncTimeout.next = null;
            return asyncTimeout;
        }
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        boolean z;
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (head == null) {
                head = new AsyncTimeout();
                new Watchdog().start();
            }
            long nanoTime = System.nanoTime();
            if (j != IDLE_TIMEOUT_NANOS && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != IDLE_TIMEOUT_NANOS) {
                asyncTimeout.timeoutAt = nanoTime + j;
            } else if (z) {
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
            AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2.next != null && remainingNanos >= asyncTimeout2.next.remainingNanos(nanoTime)) {
                asyncTimeout2 = asyncTimeout2.next;
            }
            asyncTimeout.next = asyncTimeout2.next;
            asyncTimeout2.next = asyncTimeout;
            if (asyncTimeout2 == head) {
                AsyncTimeout.class.notify();
            }
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != IDLE_TIMEOUT_NANOS || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    final IOException exit(IOException iOException) {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    final void exit(boolean z) {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        return new C45631(sink);
    }

    public final Source source(Source source) {
        return new C45642(source);
    }

    protected void timedOut() {
    }
}
