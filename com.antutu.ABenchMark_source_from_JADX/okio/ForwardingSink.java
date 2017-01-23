package okio;

import com.umeng.message.proguard.C4233j;

public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = sink;
    }

    public void close() {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    public void flush() {
        this.delegate.flush();
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + C4233j.f14396s + this.delegate.toString() + C4233j.f14397t;
    }

    public void write(Buffer buffer, long j) {
        this.delegate.write(buffer, j);
    }
}
