package com.miui.support.net.http;

import com.miui.support.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class SimpleMultipartEntity implements HttpEntity {
    private static final char[] f3460a;
    private String f3461b;
    private String f3462c;
    private ArrayList<Object> f3463d;
    private long f3464e;

    private static class EntityStream extends InputStream {
        List<Object> f3457a;
        int f3458b;
        int f3459c;

        public EntityStream(List<Object> list) {
            this.f3457a = list;
            this.f3458b = 0;
            this.f3459c = 0;
        }

        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read(byte[] r7, int r8, int r9) {
            /*
            r6 = this;
            r3 = -1;
            r2 = 0;
            r1 = r2;
        L_0x0003:
            r0 = r6.f3458b;
            r4 = r6.f3457a;
            r4 = r4.size();
            if (r0 < r4) goto L_0x000f;
        L_0x000d:
            if (r9 != 0) goto L_0x005e;
        L_0x000f:
            r0 = r6.f3457a;
            r4 = r6.f3458b;
            r0 = r0.get(r4);
            r4 = r0 instanceof byte[];
            if (r4 == 0) goto L_0x0052;
        L_0x001b:
            r0 = (byte[]) r0;
            r0 = (byte[]) r0;
            r4 = r0.length;
            r5 = r6.f3459c;
            if (r4 != r5) goto L_0x002f;
        L_0x0024:
            r0 = r6.f3458b;
            r0 = r0 + 1;
            r6.f3458b = r0;
            r6.f3459c = r2;
        L_0x002c:
            r0 = r1;
        L_0x002d:
            r1 = r0;
            goto L_0x0003;
        L_0x002f:
            r4 = r0.length;
            r5 = r6.f3459c;
            r4 = r4 - r5;
            r4 = java.lang.Math.min(r4, r9);
            r5 = r6.f3459c;
            java.lang.System.arraycopy(r0, r5, r7, r8, r4);
            r5 = r6.f3459c;
            r5 = r5 + r4;
            r6.f3459c = r5;
            r8 = r8 + r4;
            r9 = r9 - r4;
            r1 = r1 + r4;
            r0 = r0.length;
            r4 = r6.f3459c;
            if (r0 != r4) goto L_0x002c;
        L_0x0049:
            r0 = r6.f3458b;
            r0 = r0 + 1;
            r6.f3458b = r0;
            r6.f3459c = r2;
            goto L_0x002c;
        L_0x0052:
            r4 = r0 instanceof java.io.InputStream;
            if (r4 == 0) goto L_0x007c;
        L_0x0056:
            r0 = (java.io.InputStream) r0;
            r0 = r0.read(r7, r8, r9);
            if (r0 != 0) goto L_0x006c;
        L_0x005e:
            if (r1 != 0) goto L_0x006b;
        L_0x0060:
            r0 = r6.f3458b;
            r2 = r6.f3457a;
            r2 = r2.size();
            if (r0 != r2) goto L_0x006b;
        L_0x006a:
            r1 = r3;
        L_0x006b:
            return r1;
        L_0x006c:
            if (r0 != r3) goto L_0x0078;
        L_0x006e:
            r0 = r6.f3458b;
            r0 = r0 + 1;
            r6.f3458b = r0;
            r6.f3459c = r2;
        L_0x0076:
            r0 = r1;
            goto L_0x002d;
        L_0x0078:
            r8 = r8 + r0;
            r9 = r9 - r0;
            r1 = r1 + r0;
            goto L_0x0076;
        L_0x007c:
            r0 = new java.io.IOException;
            r1 = "Unexpected value";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.miui.support.net.http.SimpleMultipartEntity.EntityStream.read(byte[], int, int):int");
        }

        public int read() {
            int i = -1;
            while (this.f3458b < this.f3457a.size()) {
                int i2;
                Object obj = this.f3457a.get(this.f3458b);
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    this.f3459c++;
                    if (this.f3459c < bArr.length) {
                        return bArr[this.f3459c];
                    }
                    this.f3458b++;
                    this.f3459c = 0;
                    i2 = i;
                } else if (obj instanceof InputStream) {
                    i2 = ((InputStream) obj).read();
                    if (i2 >= 0) {
                        return i2;
                    }
                    this.f3458b++;
                    this.f3459c = 0;
                } else {
                    throw new IOException("Unexpected value");
                }
                i = i2;
            }
            return i;
        }
    }

    static {
        f3460a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public SimpleMultipartEntity(String str, Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 30; i++) {
            stringBuilder.append(f3460a[random.nextInt(f3460a.length)]);
        }
        this.f3461b = stringBuilder.toString();
        this.f3462c = str;
        this.f3463d = new ArrayList();
        this.f3464e = 0;
        byte[] bytes = ("\r\n--" + this.f3461b + "\r\n").getBytes(this.f3462c);
        Object bytes2 = ("\r\n--" + this.f3461b + "--\r\n").getBytes(this.f3462c);
        m5157a("--" + this.f3461b + "\r\n");
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                m5159a((String) entry.getKey(), (String) value);
            } else if (value instanceof List) {
                List list = (List) value;
                String str2 = (String) entry.getKey();
                for (int i2 = 0; i2 < list.size() - 1; i2++) {
                    m5159a(str2, (String) list.get(i2));
                    m5160a(bytes);
                }
                m5159a(str2, (String) list.get(list.size() - 1));
            } else if (!(value instanceof FileWrapper)) {
                throw new IOException("Unexpected parameters " + ((String) entry.getKey()) + ":" + entry.getValue());
            }
            m5160a(bytes);
        }
        for (Entry entry2 : map.entrySet()) {
            value = entry2.getValue();
            if (value instanceof FileWrapper) {
                m5158a((String) entry2.getKey(), (FileWrapper) value);
                m5160a(bytes);
            }
        }
        this.f3463d.set(this.f3463d.size() - 1, bytes2);
        this.f3464e += 2;
    }

    private void m5159a(String str, String str2) {
        try {
            m5157a("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n");
            m5157a(str2);
        } catch (UnsupportedEncodingException e) {
        }
    }

    private void m5158a(String str, FileWrapper fileWrapper) {
        try {
            String str2;
            m5157a("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + fileWrapper.f3436c + "\"\r\n");
            if (fileWrapper.f3437d == null || fileWrapper.f3437d.length() == 0) {
                str2 = "application/octet-stream";
            } else {
                str2 = fileWrapper.f3437d;
            }
            m5157a("Content-Type: " + str2 + "\r\n");
            m5157a("Content-Transfer-Encoding: binary\r\n\r\n");
            m5156a(fileWrapper.f3434a, fileWrapper.f3435b);
        } catch (UnsupportedEncodingException e) {
        }
    }

    private void m5157a(String str) {
        m5160a(str.getBytes(this.f3462c));
    }

    private void m5160a(byte[] bArr) {
        this.f3463d.add(bArr);
        this.f3464e += (long) bArr.length;
    }

    private void m5156a(InputStream inputStream, long j) {
        this.f3463d.add(inputStream);
        this.f3464e += j;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isChunked() {
        return false;
    }

    public long getContentLength() {
        return this.f3464e;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.f3461b);
    }

    public Header getContentEncoding() {
        return null;
    }

    public InputStream getContent() {
        return new EntityStream(this.f3463d);
    }

    public void writeTo(OutputStream outputStream) {
        IOUtils.m5384a(getContent(), outputStream);
    }

    public boolean isStreaming() {
        return false;
    }

    public void consumeContent() {
        Iterator it = this.f3463d.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof InputStream) {
                IOUtils.m5387a((InputStream) next);
            }
        }
        this.f3463d.clear();
    }
}
