package okio;

import java.io.IOException;

public final class Pipe {
    final Buffer buffer;
    final long maxBufferSize;
    private final Sink sink;
    boolean sinkClosed;
    private final Source source;
    boolean sourceClosed;

    final class PipeSink implements Sink {
        final Timeout timeout;

        PipeSink() {
            this.timeout = new Timeout();
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    return;
                }
                try {
                    flush();
                } finally {
                    Pipe.this.sinkClosed = true;
                    Pipe.this.buffer.notifyAll();
                }
            }
        }

        public void flush() {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    throw new IllegalStateException("closed");
                }
                while (Pipe.this.buffer.size() > 0) {
                    if (Pipe.this.sourceClosed) {
                        throw new IOException("source is closed");
                    }
                    this.timeout.waitUntilNotified(Pipe.this.buffer);
                }
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j) {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    throw new IllegalStateException("closed");
                }
                while (j > 0) {
                    if (Pipe.this.sourceClosed) {
                        throw new IOException("source is closed");
                    }
                    long size = Pipe.this.maxBufferSize - Pipe.this.buffer.size();
                    if (size == 0) {
                        this.timeout.waitUntilNotified(Pipe.this.buffer);
                    } else {
                        size = Math.min(size, j);
                        Pipe.this.buffer.write(buffer, size);
                        j -= size;
                        Pipe.this.buffer.notifyAll();
                    }
                }
            }
        }
    }

    final class PipeSource implements Source {
        final Timeout timeout;

        PipeSource() {
            this.timeout = new Timeout();
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                Pipe.this.sourceClosed = true;
                Pipe.this.buffer.notifyAll();
            }
        }

        public long read(Buffer buffer, long j) {
            long j2;
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sourceClosed) {
                    throw new IllegalStateException("closed");
                }
                while (Pipe.this.buffer.size() == 0) {
                    if (Pipe.this.sinkClosed) {
                        j2 = -1;
                        break;
                    }
                    this.timeout.waitUntilNotified(Pipe.this.buffer);
                }
                j2 = Pipe.this.buffer.read(buffer, j);
                Pipe.this.buffer.notifyAll();
            }
            return j2;
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        this.buffer = new Buffer();
        this.sink = new PipeSink();
        this.source = new PipeSource();
        if (j < 1) {
            throw new IllegalArgumentException("maxBufferSize < 1: " + j);
        }
        this.maxBufferSize = j;
    }

    public Sink sink() {
        return this.sink;
    }

    public Source source() {
        return this.source;
    }
}
