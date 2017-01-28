package okio;

import com.umeng.message.proguard.C4233j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
    static final Logger logger;

    /* renamed from: okio.Okio.1 */
    static class C45671 implements Sink {
        final /* synthetic */ OutputStream val$out;
        final /* synthetic */ Timeout val$timeout;

        C45671(Timeout timeout, OutputStream outputStream) {
            this.val$timeout = timeout;
            this.val$out = outputStream;
        }

        public void close() {
            this.val$out.close();
        }

        public void flush() {
            this.val$out.flush();
        }

        public Timeout timeout() {
            return this.val$timeout;
        }

        public String toString() {
            return "sink(" + this.val$out + C4233j.f14397t;
        }

        public void write(Buffer buffer, long j) {
            Util.checkOffsetAndCount(buffer.size, 0, j);
            while (j > 0) {
                this.val$timeout.throwIfReached();
                Segment segment = buffer.head;
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                this.val$out.write(segment.data, segment.pos, min);
                segment.pos += min;
                j -= (long) min;
                buffer.size -= (long) min;
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            }
        }
    }

    /* renamed from: okio.Okio.2 */
    static class C45682 implements Source {
        final /* synthetic */ InputStream val$in;
        final /* synthetic */ Timeout val$timeout;

        C45682(Timeout timeout, InputStream inputStream) {
            this.val$timeout = timeout;
            this.val$in = inputStream;
        }

        public void close() {
            this.val$in.close();
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (j == 0) {
                return 0;
            } else {
                try {
                    this.val$timeout.throwIfReached();
                    Segment writableSegment = buffer.writableSegment(1);
                    int read = this.val$in.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                    if (read == -1) {
                        return -1;
                    }
                    writableSegment.limit += read;
                    buffer.size += (long) read;
                    return (long) read;
                } catch (Throwable e) {
                    if (Okio.isAndroidGetsocknameError(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        public Timeout timeout() {
            return this.val$timeout;
        }

        public String toString() {
            return "source(" + this.val$in + C4233j.f14397t;
        }
    }

    /* renamed from: okio.Okio.3 */
    static class C45693 implements Sink {
        C45693() {
        }

        public void close() {
        }

        public void flush() {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j) {
            buffer.skip(j);
        }
    }

    /* renamed from: okio.Okio.4 */
    static class C45704 extends AsyncTimeout {
        final /* synthetic */ Socket val$socket;

        C45704(Socket socket) {
            this.val$socket = socket;
        }

        protected IOException newTimeoutException(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected void timedOut() {
            try {
                this.val$socket.close();
            } catch (Throwable e) {
                Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + this.val$socket, e);
            } catch (Throwable e2) {
                if (Okio.isAndroidGetsocknameError(e2)) {
                    Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + this.val$socket, e2);
                    return;
                }
                throw e2;
            }
        }
    }

    static {
        logger = Logger.getLogger(Okio.class.getName());
    }

    private Okio() {
    }

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new C45693();
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new C45671(timeout, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        Timeout timeout = timeout(socket);
        return timeout.sink(sink(socket.getOutputStream(), timeout));
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(File file) {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new C45682(timeout, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source source(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        Timeout timeout = timeout(socket);
        return timeout.source(source(socket.getInputStream(), timeout));
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    private static AsyncTimeout timeout(Socket socket) {
        return new C45704(socket);
    }
}
