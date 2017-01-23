package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.mob.tools.network.KVPair;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

/* renamed from: cn.sharesdk.framework.utils.a */
public class C0974a {
    private C0973b f3343a;
    private C0976b f3344b;

    /* renamed from: cn.sharesdk.framework.utils.a.1 */
    static /* synthetic */ class C09711 {
        static final /* synthetic */ int[] f3334a;

        static {
            f3334a = new int[C0972a.values().length];
            try {
                f3334a[C0972a.HMAC_SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3334a[C0972a.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: cn.sharesdk.framework.utils.a.a */
    public enum C0972a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* renamed from: cn.sharesdk.framework.utils.a.b */
    public static class C0973b {
        public String f3338a;
        public String f3339b;
        public String f3340c;
        public String f3341d;
        public String f3342e;
    }

    public C0974a() {
        this.f3343a = new C0973b();
        this.f3344b = new C0976b("-._~", false);
    }

    private ArrayList<KVPair<String>> m4351a(long j, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList();
        arrayList.add(new KVPair("oauth_consumer_key", this.f3343a.f3338a));
        arrayList.add(new KVPair("oauth_signature_method", str));
        arrayList.add(new KVPair("oauth_timestamp", String.valueOf(j / 1000)));
        arrayList.add(new KVPair("oauth_nonce", String.valueOf(j)));
        arrayList.add(new KVPair("oauth_version", BuildConfig.VERSION_NAME));
        String str2 = this.f3343a.f3340c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair("oauth_token", str2));
        }
        return arrayList;
    }

    private ArrayList<KVPair<String>> m4352a(long j, ArrayList<KVPair<String>> arrayList, String str) {
        Iterator it;
        int i = 0;
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair kVPair = (KVPair) it.next();
                hashMap.put(m4356a(kVPair.name), m4356a((String) kVPair.value));
            }
        }
        ArrayList a = m4351a(j, str);
        if (a != null) {
            it = a.iterator();
            while (it.hasNext()) {
                kVPair = (KVPair) it.next();
                hashMap.put(m4356a(kVPair.name), m4356a((String) kVPair.value));
            }
        }
        String[] strArr = new String[hashMap.size()];
        int i2 = 0;
        for (Entry key : hashMap.entrySet()) {
            strArr[i2] = (String) key.getKey();
            i2++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList();
        i2 = strArr.length;
        while (i < i2) {
            String str2 = strArr[i];
            arrayList2.add(new KVPair(str2, hashMap.get(str2)));
            i++;
        }
        return arrayList2;
    }

    private ArrayList<KVPair<String>> m4353a(String str, String str2, ArrayList<KVPair<String>> arrayList, C0972a c0972a) {
        Object trim;
        String str3 = null;
        long currentTimeMillis = System.currentTimeMillis();
        switch (C09711.f3334a[c0972a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                str3 = "HMAC-SHA1";
                Key secretKeySpec = new SecretKeySpec((m4356a(this.f3343a.f3339b) + '&' + m4356a(this.f3343a.f3341d)).getBytes("utf-8"), "HMAC-SHA1");
                Mac instance = Mac.getInstance("HMAC-SHA1");
                instance.init(secretKeySpec);
                trim = new String(Base64.encode(instance.doFinal((str2 + '&' + m4356a(str) + '&' + m4356a(m4354b(m4352a(currentTimeMillis, (ArrayList) arrayList, str3)))).getBytes("utf-8")), 0)).trim();
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                str3 = "PLAINTEXT";
                trim = m4356a(this.f3343a.f3339b) + '&' + m4356a(this.f3343a.f3341d);
                break;
            default:
                trim = null;
                break;
        }
        ArrayList<KVPair<String>> a = m4351a(currentTimeMillis, str3);
        a.add(new KVPair("oauth_signature", trim));
        return a;
    }

    private String m4354b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            KVPair kVPair = (KVPair) it.next();
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(kVPair.name).append('=').append((String) kVPair.value);
            i++;
        }
        return stringBuilder.toString();
    }

    public C0973b m4355a() {
        return this.f3343a;
    }

    public String m4356a(String str) {
        return str == null ? BuildConfig.FLAVOR : this.f3344b.escape(str);
    }

    public ArrayList<KVPair<String>> m4357a(String str, ArrayList<KVPair<String>> arrayList) {
        return m4358a(str, (ArrayList) arrayList, C0972a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> m4358a(String str, ArrayList<KVPair<String>> arrayList, C0972a c0972a) {
        return m4353a(str, SpdyRequest.POST_METHOD, arrayList, c0972a);
    }

    public ArrayList<KVPair<String>> m4359a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder("OAuth ");
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            KVPair kVPair = (KVPair) it.next();
            if (i > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(kVPair.name).append("=\"").append(m4356a((String) kVPair.value)).append("\"");
            i++;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14555h, stringBuilder.toString()));
        arrayList2.add(new KVPair(MIME.CONTENT_TYPE, HttpRequest.f14549b));
        return arrayList2;
    }

    public void m4360a(String str, String str2) {
        this.f3343a.f3340c = str;
        this.f3343a.f3341d = str2;
    }

    public void m4361a(String str, String str2, String str3) {
        this.f3343a.f3338a = str;
        this.f3343a.f3339b = str2;
        this.f3343a.f3342e = str3;
    }

    public ArrayList<KVPair<String>> m4362b(String str, ArrayList<KVPair<String>> arrayList) {
        return m4363b(str, arrayList, C0972a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> m4363b(String str, ArrayList<KVPair<String>> arrayList, C0972a c0972a) {
        return m4353a(str, SpdyRequest.GET_METHOD, arrayList, c0972a);
    }

    public ArrayList<KVPair<String>> m4364c(String str, ArrayList<KVPair<String>> arrayList, C0972a c0972a) {
        return m4353a(str, HttpRequest.f14536B, arrayList, c0972a);
    }
}
