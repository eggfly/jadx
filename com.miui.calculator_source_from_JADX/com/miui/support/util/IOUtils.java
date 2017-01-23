package com.miui.support.util;

import com.miui.support.util.Pools.Manager;
import com.miui.support.util.Pools.Pool;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class IOUtils {
    private static final ThreadLocal<SoftReference<byte[]>> f3670a;
    private static final ThreadLocal<SoftReference<char[]>> f3671b;
    private static final Pool<ByteArrayOutputStream> f3672c;
    private static final Pool<CharArrayWriter> f3673d;
    private static final Pool<StringWriter> f3674e;
    private static final String f3675f;

    /* renamed from: com.miui.support.util.IOUtils.1 */
    final class C04281 extends Manager<ByteArrayOutputStream> {
        C04281() {
        }

        public /* synthetic */ Object m5375b() {
            return m5372a();
        }

        public ByteArrayOutputStream m5372a() {
            return new ByteArrayOutputStream();
        }

        public void m5373a(ByteArrayOutputStream byteArrayOutputStream) {
            byteArrayOutputStream.reset();
        }
    }

    /* renamed from: com.miui.support.util.IOUtils.2 */
    final class C04292 extends Manager<CharArrayWriter> {
        C04292() {
        }

        public /* synthetic */ Object m5379b() {
            return m5376a();
        }

        public CharArrayWriter m5376a() {
            return new CharArrayWriter();
        }

        public void m5377a(CharArrayWriter charArrayWriter) {
            charArrayWriter.reset();
        }
    }

    /* renamed from: com.miui.support.util.IOUtils.3 */
    final class C04303 extends Manager<StringWriter> {
        C04303() {
        }

        public /* synthetic */ Object m5383b() {
            return m5380a();
        }

        public StringWriter m5380a() {
            return new StringWriter();
        }

        public void m5381a(StringWriter stringWriter) {
            stringWriter.getBuffer().setLength(0);
        }
    }

    static {
        f3670a = new ThreadLocal();
        f3671b = new ThreadLocal();
        f3672c = Pools.m5435b(new C04281(), 2);
        f3673d = Pools.m5435b(new C04292(), 2);
        f3674e = Pools.m5435b(new C04303(), 2);
        StringWriter stringWriter = (StringWriter) f3674e.m5400b();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println();
        printWriter.flush();
        f3675f = stringWriter.toString();
        printWriter.close();
        f3674e.m5401b(stringWriter);
    }

    protected IOUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static void m5390a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m5387a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m5389a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
            }
            try {
                outputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static byte[] m5392b(InputStream inputStream) {
        OutputStream outputStream = (ByteArrayOutputStream) f3672c.m5400b();
        m5384a(inputStream, outputStream);
        byte[] toByteArray = outputStream.toByteArray();
        f3672c.m5401b(outputStream);
        return toByteArray;
    }

    public static String m5386a(InputStream inputStream, String str) {
        StringWriter stringWriter = (StringWriter) f3674e.m5400b();
        m5388a(inputStream, stringWriter, str);
        String stringWriter2 = stringWriter.toString();
        f3674e.m5401b(stringWriter);
        return stringWriter2;
    }

    public static long m5384a(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] a = m5391a();
        while (true) {
            int read = inputStream.read(a);
            if (read != -1) {
                outputStream.write(a, 0, read);
                j += (long) read;
            } else {
                outputStream.flush();
                return j;
            }
        }
    }

    public static void m5388a(InputStream inputStream, Writer writer, String str) {
        Reader inputStreamReader = (str == null || str.length() == 0) ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str);
        m5385a(inputStreamReader, writer);
    }

    public static long m5385a(Reader reader, Writer writer) {
        long j = 0;
        char[] b = m5393b();
        while (true) {
            int read = reader.read(b);
            if (read != -1) {
                writer.write(b, 0, read);
                j += (long) read;
            } else {
                writer.flush();
                return j;
            }
        }
    }

    private static byte[] m5391a() {
        byte[] bArr;
        SoftReference softReference = (SoftReference) f3670a.get();
        if (softReference != null) {
            bArr = (byte[]) softReference.get();
        } else {
            bArr = null;
        }
        if (bArr != null) {
            return bArr;
        }
        Object obj = new byte[4096];
        f3670a.set(new SoftReference(obj));
        return obj;
    }

    private static char[] m5393b() {
        char[] cArr;
        SoftReference softReference = (SoftReference) f3671b.get();
        if (softReference != null) {
            cArr = (char[]) softReference.get();
        } else {
            cArr = null;
        }
        if (cArr != null) {
            return cArr;
        }
        Object obj = new char[4096];
        f3671b.set(new SoftReference(obj));
        return obj;
    }
}
