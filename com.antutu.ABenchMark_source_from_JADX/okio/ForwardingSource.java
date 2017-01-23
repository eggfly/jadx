package okio;

import com.umeng.message.proguard.C4233j;

public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = source;
    }

    public void close() {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long read(Buffer buffer, long j) {
        return this.delegate.read(buffer, j);
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + C4233j.f14396s + this.delegate.toString() + C4233j.f14397t;
    }
}
