package com.p105c.p106a.p109b.p110a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.android.spdy.SpdyProtocol;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.c.a.b.a.a */
class C2092a implements XmlSerializer {
    private static final String[] f7347a;
    private final char[] f7348b;
    private int f7349c;
    private Writer f7350d;
    private OutputStream f7351e;
    private CharsetEncoder f7352f;
    private ByteBuffer f7353g;
    private boolean f7354h;

    static {
        f7347a = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    }

    C2092a() {
        this.f7348b = new char[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        this.f7353g = ByteBuffer.allocate(SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    }

    private void m7811a() {
        int position = this.f7353g.position();
        if (position > 0) {
            this.f7353g.flip();
            this.f7351e.write(this.f7353g.array(), 0, position);
            this.f7353g.clear();
        }
    }

    private void m7812a(char c) {
        int i = this.f7349c;
        if (i >= 8191) {
            flush();
            i = this.f7349c;
        }
        this.f7348b[i] = c;
        this.f7349c = i + 1;
    }

    private void m7813a(String str) {
        m7814a(str, 0, str.length());
    }

    private void m7814a(String str, int i, int i2) {
        if (i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
                m7814a(str, i, i4 < i3 ? SpdyProtocol.SLIGHTSSL_1_RTT_MODE : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f7349c;
        if (i5 + i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            flush();
            i5 = this.f7349c;
        }
        str.getChars(i, i + i2, this.f7348b, i5);
        this.f7349c = i5 + i2;
    }

    private void m7815a(char[] cArr, int i, int i2) {
        if (i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
                m7815a(cArr, i, i4 < i3 ? SpdyProtocol.SLIGHTSSL_1_RTT_MODE : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f7349c;
        if (i5 + i2 > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            flush();
            i5 = this.f7349c;
        }
        System.arraycopy(cArr, i, this.f7348b, i5, i2);
        this.f7349c = i5 + i2;
    }

    private void m7816b(String str) {
        int i = 0;
        int length = str.length();
        char length2 = (char) f7347a.length;
        String[] strArr = f7347a;
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2) {
                String str2 = strArr[charAt];
                if (str2 != null) {
                    if (i < i2) {
                        m7814a(str, i, i2 - i);
                    }
                    i = i2 + 1;
                    m7813a(str2);
                }
            }
            i2++;
        }
        if (i < i2) {
            m7814a(str, i, i2 - i);
        }
    }

    private void m7817b(char[] cArr, int i, int i2) {
        char length = (char) f7347a.length;
        String[] strArr = f7347a;
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length) {
                String str = strArr[c];
                if (str != null) {
                    if (i4 < i) {
                        m7815a(cArr, i4, i - i4);
                    }
                    i4 = i + 1;
                    m7813a(str);
                }
            }
            i++;
        }
        if (i4 < i) {
            m7815a(cArr, i4, i - i4);
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) {
        m7812a(' ');
        if (str != null) {
            m7813a(str);
            m7812a(':');
        }
        m7813a(str2);
        m7813a("=\"");
        m7816b(str3);
        m7812a('\"');
        return this;
    }

    public void cdsect(String str) {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String str) {
        throw new UnsupportedOperationException();
    }

    public void endDocument() {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) {
        if (this.f7354h) {
            m7813a(" />\n");
        } else {
            m7813a("</");
            if (str != null) {
                m7813a(str);
                m7812a(':');
            }
            m7813a(str2);
            m7813a(">\n");
        }
        this.f7354h = false;
        return this;
    }

    public void entityRef(String str) {
        throw new UnsupportedOperationException();
    }

    public void flush() {
        if (this.f7349c > 0) {
            if (this.f7351e != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f7348b, 0, this.f7349c);
                CoderResult encode = this.f7352f.encode(wrap, this.f7353g, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        m7811a();
                        encode = this.f7352f.encode(wrap, this.f7353g, true);
                    } else {
                        m7811a();
                        this.f7351e.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f7350d.write(this.f7348b, 0, this.f7349c);
            this.f7350d.flush();
            this.f7349c = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String str, boolean z) {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    public void setOutput(OutputStream outputStream, String str) {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f7352f = Charset.forName(str).newEncoder();
            this.f7351e = outputStream;
        } catch (Throwable e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (Throwable e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    public void setOutput(Writer writer) {
        this.f7350d = writer;
    }

    public void setPrefix(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) {
        m7813a("<?xml version='1.0' encoding='utf-8' standalone='" + (bool.booleanValue() ? "yes" : "no") + "' ?>\n");
    }

    public XmlSerializer startTag(String str, String str2) {
        if (this.f7354h) {
            m7813a(">\n");
        }
        m7812a('<');
        if (str != null) {
            m7813a(str);
            m7812a(':');
        }
        m7813a(str2);
        this.f7354h = true;
        return this;
    }

    public XmlSerializer text(String str) {
        if (this.f7354h) {
            m7813a(">");
            this.f7354h = false;
        }
        m7816b(str);
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) {
        if (this.f7354h) {
            m7813a(">");
            this.f7354h = false;
        }
        m7817b(cArr, i, i2);
        return this;
    }
}
