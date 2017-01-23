package com.google.android.gms.p146b;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.ah.C3025a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

@gb
/* renamed from: com.google.android.gms.b.ae */
public class ae {
    private final int f10239a;
    private final int f10240b;
    private final int f10241c;
    private final ad f10242d;

    /* renamed from: com.google.android.gms.b.ae.1 */
    class C30221 implements Comparator<String> {
        final /* synthetic */ ae f10235a;

        C30221(ae aeVar) {
            this.f10235a = aeVar;
        }

        public int m11754a(String str, String str2) {
            return str2.length() - str.length();
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m11754a((String) obj, (String) obj2);
        }
    }

    /* renamed from: com.google.android.gms.b.ae.2 */
    class C30232 implements Comparator<C3025a> {
        final /* synthetic */ ae f10236a;

        C30232(ae aeVar) {
            this.f10236a = aeVar;
        }

        public int m11755a(C3025a c3025a, C3025a c3025a2) {
            int i = c3025a.f10246c - c3025a2.f10246c;
            return i != 0 ? i : (int) (c3025a.f10244a - c3025a2.f10244a);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m11755a((C3025a) obj, (C3025a) obj2);
        }
    }

    /* renamed from: com.google.android.gms.b.ae.a */
    static class C3024a {
        ByteArrayOutputStream f10237a;
        Base64OutputStream f10238b;

        public C3024a() {
            this.f10237a = new ByteArrayOutputStream(SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
            this.f10238b = new Base64OutputStream(this.f10237a, 10);
        }

        public void m11756a(byte[] bArr) {
            this.f10238b.write(bArr);
        }

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.f10238b.close();
            } catch (Throwable e) {
                C2972b.m11580b("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.f10237a.close();
                byteArrayOutputStream = this.f10237a.toString();
            } catch (Throwable e2) {
                C2972b.m11580b("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = BuildConfig.FLAVOR;
            } finally {
                this.f10237a = null;
                this.f10238b = null;
            }
            return byteArrayOutputStream;
        }
    }

    public ae(int i) {
        this.f10242d = new ag();
        this.f10240b = i;
        this.f10239a = 6;
        this.f10241c = 0;
    }

    private String m11757b(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return BuildConfig.FLAVOR;
        }
        C3024a a = m11758a();
        Arrays.sort(split, new C30221(this));
        int i = 0;
        while (i < split.length && i < this.f10240b) {
            if (split[i].trim().length() != 0) {
                try {
                    a.m11756a(this.f10242d.m11753a(split[i]));
                } catch (Throwable e) {
                    C2972b.m11580b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return a.toString();
    }

    C3024a m11758a() {
        return new C3024a();
    }

    String m11759a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return BuildConfig.FLAVOR;
        }
        C3024a a = m11758a();
        PriorityQueue priorityQueue = new PriorityQueue(this.f10240b, new C30232(this));
        for (String b : split) {
            String[] b2 = af.m11765b(b);
            if (b2.length != 0) {
                ah.m11773a(b2, this.f10240b, this.f10239a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                a.m11756a(this.f10242d.m11753a(((C3025a) it.next()).f10245b));
            } catch (Throwable e) {
                C2972b.m11580b("Error while writing hash to byteStream", e);
            }
        }
        return a.toString();
    }

    public String m11760a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.f10241c) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return m11759a(stringBuffer.toString());
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return m11757b(stringBuffer.toString());
            default:
                return BuildConfig.FLAVOR;
        }
    }
}
