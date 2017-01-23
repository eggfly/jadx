package com.facebook.ads.internal.p127e.p128a;

import com.umeng.message.util.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.e.a.o */
public class C2374o implements Map<String, String> {
    private Map<String, String> f8270a;

    public C2374o() {
        this.f8270a = new HashMap();
    }

    public C2374o m9139a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    public String m9140a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f8270a.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str);
            String str2 = (String) this.f8270a.get(str2);
            if (str2 != null) {
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode(str2, HttpRequest.f14548a));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public String m9141a(Object obj) {
        return (String) this.f8270a.get(obj);
    }

    public String m9142a(String str, String str2) {
        return (String) this.f8270a.put(str, str2);
    }

    public String m9143b(Object obj) {
        return (String) this.f8270a.remove(obj);
    }

    public byte[] m9144b() {
        byte[] bArr = null;
        try {
            bArr = m9140a().getBytes(HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public void clear() {
        this.f8270a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f8270a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f8270a.containsValue(obj);
    }

    public Set<Entry<String, String>> entrySet() {
        return this.f8270a.entrySet();
    }

    public /* synthetic */ Object get(Object obj) {
        return m9141a(obj);
    }

    public boolean isEmpty() {
        return this.f8270a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f8270a.keySet();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m9142a((String) obj, (String) obj2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f8270a.putAll(map);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m9143b(obj);
    }

    public int size() {
        return this.f8270a.size();
    }

    public Collection<String> values() {
        return this.f8270a.values();
    }
}
