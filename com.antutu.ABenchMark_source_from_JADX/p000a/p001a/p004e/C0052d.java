package p000a.p001a.p004e;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import anet.channel.util.HttpConstant;
import com.igexin.download.Downloads;
import com.taobao.accs.internal.C4103b;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import p000a.p001a.C0037c;

/* renamed from: a.a.e.d */
final class C0052d {
    static final C0049c[] f190a;
    static final Map<ByteString, Integer> f191b;

    /* renamed from: a.a.e.d.a */
    static final class C0050a {
        C0049c[] f172a;
        int f173b;
        int f174c;
        int f175d;
        private final List<C0049c> f176e;
        private final BufferedSource f177f;
        private final int f178g;
        private int f179h;

        C0050a(int i, int i2, Source source) {
            this.f176e = new ArrayList();
            this.f172a = new C0049c[8];
            this.f173b = this.f172a.length - 1;
            this.f174c = 0;
            this.f175d = 0;
            this.f178g = i;
            this.f179h = i2;
            this.f177f = Okio.buffer(source);
        }

        C0050a(int i, Source source) {
            this(i, i, source);
        }

        private int m191a(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f172a.length - 1; length >= this.f173b && i > 0; length--) {
                    i -= this.f172a[length].f171i;
                    this.f175d -= this.f172a[length].f171i;
                    this.f174c--;
                    i2++;
                }
                System.arraycopy(this.f172a, this.f173b + 1, this.f172a, (this.f173b + 1) + i2, this.f174c);
                this.f173b += i2;
            }
            return i2;
        }

        private void m192a(int i, C0049c c0049c) {
            this.f176e.add(c0049c);
            int i2 = c0049c.f171i;
            if (i != -1) {
                i2 -= this.f172a[m194c(i)].f171i;
            }
            if (i2 > this.f179h) {
                m197e();
                return;
            }
            int a = m191a((this.f175d + i2) - this.f179h);
            if (i == -1) {
                if (this.f174c + 1 > this.f172a.length) {
                    Object obj = new C0049c[(this.f172a.length * 2)];
                    System.arraycopy(this.f172a, 0, obj, this.f172a.length, this.f172a.length);
                    this.f173b = this.f172a.length - 1;
                    this.f172a = obj;
                }
                a = this.f173b;
                this.f173b = a - 1;
                this.f172a[a] = c0049c;
                this.f174c++;
            } else {
                this.f172a[(a + m194c(i)) + i] = c0049c;
            }
            this.f175d = i2 + this.f175d;
        }

        private void m193b(int i) {
            if (m202g(i)) {
                this.f176e.add(C0052d.f190a[i]);
                return;
            }
            int c = m194c(i - C0052d.f190a.length);
            if (c < 0 || c > this.f172a.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f176e.add(this.f172a[c]);
        }

        private int m194c(int i) {
            return (this.f173b + 1) + i;
        }

        private void m195d() {
            if (this.f179h >= this.f175d) {
                return;
            }
            if (this.f179h == 0) {
                m197e();
            } else {
                m191a(this.f175d - this.f179h);
            }
        }

        private void m196d(int i) {
            this.f176e.add(new C0049c(m199f(i), m207c()));
        }

        private void m197e() {
            Arrays.fill(this.f172a, null);
            this.f173b = this.f172a.length - 1;
            this.f174c = 0;
            this.f175d = 0;
        }

        private void m198e(int i) {
            m192a(-1, new C0049c(m199f(i), m207c()));
        }

        private ByteString m199f(int i) {
            return m202g(i) ? C0052d.f190a[i].f169g : this.f172a[m194c(i - C0052d.f190a.length)].f169g;
        }

        private void m200f() {
            this.f176e.add(new C0049c(C0052d.m217a(m207c()), m207c()));
        }

        private void m201g() {
            m192a(-1, new C0049c(C0052d.m217a(m207c()), m207c()));
        }

        private boolean m202g(int i) {
            return i >= 0 && i <= C0052d.f190a.length - 1;
        }

        private int m203h() {
            return this.f177f.readByte() & MotionEventCompat.ACTION_MASK;
        }

        int m204a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int h = m203h();
                if ((h & SpdyProtocol.SLIGHTSSLV2) == 0) {
                    return (h << i3) + i2;
                }
                i2 += (h & TransportMediator.KEYCODE_MEDIA_PAUSE) << i3;
                i3 += 7;
            }
        }

        void m205a() {
            while (!this.f177f.exhausted()) {
                int readByte = this.f177f.readByte() & MotionEventCompat.ACTION_MASK;
                if (readByte == SpdyProtocol.SLIGHTSSLV2) {
                    throw new IOException("index == 0");
                } else if ((readByte & SpdyProtocol.SLIGHTSSLV2) == SpdyProtocol.SLIGHTSSLV2) {
                    m193b(m204a(readByte, (int) TransportMediator.KEYCODE_MEDIA_PAUSE) - 1);
                } else if (readByte == 64) {
                    m201g();
                } else if ((readByte & 64) == 64) {
                    m198e(m204a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f179h = m204a(readByte, 31);
                    if (this.f179h < 0 || this.f179h > this.f178g) {
                        throw new IOException("Invalid dynamic table size update " + this.f179h);
                    }
                    m195d();
                } else if (readByte == 16 || readByte == 0) {
                    m200f();
                } else {
                    m196d(m204a(readByte, 15) - 1);
                }
            }
        }

        public List<C0049c> m206b() {
            List arrayList = new ArrayList(this.f176e);
            this.f176e.clear();
            return arrayList;
        }

        ByteString m207c() {
            int h = m203h();
            Object obj = (h & SpdyProtocol.SLIGHTSSLV2) == SpdyProtocol.SLIGHTSSLV2 ? 1 : null;
            h = m204a(h, (int) TransportMediator.KEYCODE_MEDIA_PAUSE);
            return obj != null ? ByteString.of(C0079k.m346a().m351a(this.f177f.readByteArray((long) h))) : this.f177f.readByteString((long) h);
        }
    }

    /* renamed from: a.a.e.d.b */
    static final class C0051b {
        int f180a;
        int f181b;
        C0049c[] f182c;
        int f183d;
        int f184e;
        int f185f;
        private final Buffer f186g;
        private final boolean f187h;
        private int f188i;
        private boolean f189j;

        C0051b(int i, boolean z, Buffer buffer) {
            this.f188i = Integer.MAX_VALUE;
            this.f182c = new C0049c[8];
            this.f183d = this.f182c.length - 1;
            this.f184e = 0;
            this.f185f = 0;
            this.f180a = i;
            this.f181b = i;
            this.f187h = z;
            this.f186g = buffer;
        }

        C0051b(Buffer buffer) {
            this(SpdyProtocol.SLIGHTSSL_0_RTT_MODE, true, buffer);
        }

        private void m208a() {
            Arrays.fill(this.f182c, null);
            this.f183d = this.f182c.length - 1;
            this.f184e = 0;
            this.f185f = 0;
        }

        private void m209a(C0049c c0049c) {
            int i = c0049c.f171i;
            if (i > this.f181b) {
                m208a();
                return;
            }
            m210b((this.f185f + i) - this.f181b);
            if (this.f184e + 1 > this.f182c.length) {
                Object obj = new C0049c[(this.f182c.length * 2)];
                System.arraycopy(this.f182c, 0, obj, this.f182c.length, this.f182c.length);
                this.f183d = this.f182c.length - 1;
                this.f182c = obj;
            }
            int i2 = this.f183d;
            this.f183d = i2 - 1;
            this.f182c[i2] = c0049c;
            this.f184e++;
            this.f185f = i + this.f185f;
        }

        private int m210b(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f182c.length - 1; length >= this.f183d && i > 0; length--) {
                    i -= this.f182c[length].f171i;
                    this.f185f -= this.f182c[length].f171i;
                    this.f184e--;
                    i2++;
                }
                System.arraycopy(this.f182c, this.f183d + 1, this.f182c, (this.f183d + 1) + i2, this.f184e);
                Arrays.fill(this.f182c, this.f183d + 1, (this.f183d + 1) + i2, null);
                this.f183d += i2;
            }
            return i2;
        }

        private void m211b() {
            if (this.f181b >= this.f185f) {
                return;
            }
            if (this.f181b == 0) {
                m208a();
            } else {
                m210b(this.f185f - this.f181b);
            }
        }

        void m212a(int i) {
            this.f180a = i;
            int min = Math.min(i, SpdyProtocol.SLIGHTSSL_L7E);
            if (this.f181b != min) {
                if (min < this.f181b) {
                    this.f188i = Math.min(this.f188i, min);
                }
                this.f189j = true;
                this.f181b = min;
                m211b();
            }
        }

        void m213a(int i, int i2, int i3) {
            if (i < i2) {
                this.f186g.writeByte(i3 | i);
                return;
            }
            this.f186g.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= SpdyProtocol.SLIGHTSSLV2) {
                this.f186g.writeByte((i4 & TransportMediator.KEYCODE_MEDIA_PAUSE) | SpdyProtocol.SLIGHTSSLV2);
                i4 >>>= 7;
            }
            this.f186g.writeByte(i4);
        }

        void m214a(List<C0049c> list) {
            if (this.f189j) {
                if (this.f188i < this.f181b) {
                    m213a(this.f188i, 31, 32);
                }
                this.f189j = false;
                this.f188i = Integer.MAX_VALUE;
                m213a(this.f181b, 31, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int intValue;
                int i2;
                C0049c c0049c = (C0049c) list.get(i);
                ByteString toAsciiLowercase = c0049c.f169g.toAsciiLowercase();
                ByteString byteString = c0049c.f170h;
                Integer num = (Integer) C0052d.f191b.get(toAsciiLowercase);
                if (num != null) {
                    intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (C0037c.m163a(C0052d.f190a[intValue - 1].f170h, (Object) byteString)) {
                            i2 = intValue;
                        } else if (C0037c.m163a(C0052d.f190a[intValue].f170h, (Object) byteString)) {
                            i2 = intValue + 1;
                        }
                    }
                    i2 = -1;
                } else {
                    intValue = -1;
                    i2 = -1;
                }
                if (i2 == -1) {
                    int length = this.f182c.length;
                    for (int i3 = this.f183d + 1; i3 < length; i3++) {
                        if (C0037c.m163a(this.f182c[i3].f169g, (Object) toAsciiLowercase)) {
                            if (C0037c.m163a(this.f182c[i3].f170h, (Object) byteString)) {
                                i2 = (i3 - this.f183d) + C0052d.f190a.length;
                                break;
                            } else if (intValue == -1) {
                                intValue = (i3 - this.f183d) + C0052d.f190a.length;
                            }
                        }
                    }
                }
                if (i2 != -1) {
                    m213a(i2, TransportMediator.KEYCODE_MEDIA_PAUSE, SpdyProtocol.SLIGHTSSLV2);
                } else if (intValue == -1) {
                    this.f186g.writeByte(64);
                    m215a(toAsciiLowercase);
                    m215a(byteString);
                    m209a(c0049c);
                } else if (!toAsciiLowercase.startsWith(C0049c.f163a) || C0049c.f168f.equals(toAsciiLowercase)) {
                    m213a(intValue, 63, 64);
                    m215a(byteString);
                    m209a(c0049c);
                } else {
                    m213a(intValue, 15, 0);
                    m215a(byteString);
                }
            }
        }

        void m215a(ByteString byteString) {
            if (!this.f187h || C0079k.m346a().m349a(byteString) >= byteString.size()) {
                m213a(byteString.size(), TransportMediator.KEYCODE_MEDIA_PAUSE, 0);
                this.f186g.write(byteString);
                return;
            }
            Object buffer = new Buffer();
            C0079k.m346a().m350a(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            m213a(readByteString.size(), TransportMediator.KEYCODE_MEDIA_PAUSE, SpdyProtocol.SLIGHTSSLV2);
            this.f186g.write(readByteString);
        }
    }

    static {
        f190a = new C0049c[]{new C0049c(C0049c.f168f, BuildConfig.FLAVOR), new C0049c(C0049c.f165c, SpdyRequest.GET_METHOD), new C0049c(C0049c.f165c, SpdyRequest.POST_METHOD), new C0049c(C0049c.f166d, "/"), new C0049c(C0049c.f166d, "/index.html"), new C0049c(C0049c.f167e, HttpConstant.HTTP), new C0049c(C0049c.f167e, HttpConstant.HTTPS), new C0049c(C0049c.f164b, "200"), new C0049c(C0049c.f164b, "204"), new C0049c(C0049c.f164b, "206"), new C0049c(C0049c.f164b, "304"), new C0049c(C0049c.f164b, "400"), new C0049c(C0049c.f164b, "404"), new C0049c(C0049c.f164b, "500"), new C0049c("accept-charset", BuildConfig.FLAVOR), new C0049c("accept-encoding", "gzip, deflate"), new C0049c("accept-language", BuildConfig.FLAVOR), new C0049c("accept-ranges", BuildConfig.FLAVOR), new C0049c("accept", BuildConfig.FLAVOR), new C0049c("access-control-allow-origin", BuildConfig.FLAVOR), new C0049c("age", BuildConfig.FLAVOR), new C0049c("allow", BuildConfig.FLAVOR), new C0049c("authorization", BuildConfig.FLAVOR), new C0049c("cache-control", BuildConfig.FLAVOR), new C0049c("content-disposition", BuildConfig.FLAVOR), new C0049c("content-encoding", BuildConfig.FLAVOR), new C0049c("content-language", BuildConfig.FLAVOR), new C0049c("content-length", BuildConfig.FLAVOR), new C0049c("content-location", BuildConfig.FLAVOR), new C0049c("content-range", BuildConfig.FLAVOR), new C0049c("content-type", BuildConfig.FLAVOR), new C0049c("cookie", BuildConfig.FLAVOR), new C0049c("date", BuildConfig.FLAVOR), new C0049c("etag", BuildConfig.FLAVOR), new C0049c("expect", BuildConfig.FLAVOR), new C0049c("expires", BuildConfig.FLAVOR), new C0049c("from", BuildConfig.FLAVOR), new C0049c(C4103b.ELECTION_KEY_HOST, BuildConfig.FLAVOR), new C0049c("if-match", BuildConfig.FLAVOR), new C0049c("if-modified-since", BuildConfig.FLAVOR), new C0049c("if-none-match", BuildConfig.FLAVOR), new C0049c("if-range", BuildConfig.FLAVOR), new C0049c("if-unmodified-since", BuildConfig.FLAVOR), new C0049c("last-modified", BuildConfig.FLAVOR), new C0049c("link", BuildConfig.FLAVOR), new C0049c(MsgConstant.KEY_LOCATION_PARAMS, BuildConfig.FLAVOR), new C0049c("max-forwards", BuildConfig.FLAVOR), new C0049c("proxy-authenticate", BuildConfig.FLAVOR), new C0049c("proxy-authorization", BuildConfig.FLAVOR), new C0049c("range", BuildConfig.FLAVOR), new C0049c(Downloads.COLUMN_REFERER, BuildConfig.FLAVOR), new C0049c("refresh", BuildConfig.FLAVOR), new C0049c("retry-after", BuildConfig.FLAVOR), new C0049c("server", BuildConfig.FLAVOR), new C0049c("set-cookie", BuildConfig.FLAVOR), new C0049c("strict-transport-security", BuildConfig.FLAVOR), new C0049c("transfer-encoding", BuildConfig.FLAVOR), new C0049c("user-agent", BuildConfig.FLAVOR), new C0049c("vary", BuildConfig.FLAVOR), new C0049c("via", BuildConfig.FLAVOR), new C0049c("www-authenticate", BuildConfig.FLAVOR)};
        f191b = C0052d.m216a();
    }

    private static Map<ByteString, Integer> m216a() {
        Map linkedHashMap = new LinkedHashMap(f190a.length);
        for (int i = 0; i < f190a.length; i++) {
            if (!linkedHashMap.containsKey(f190a[i].f169g)) {
                linkedHashMap.put(f190a[i].f169g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static ByteString m217a(ByteString byteString) {
        int i = 0;
        int size = byteString.size();
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < 65 || b > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
