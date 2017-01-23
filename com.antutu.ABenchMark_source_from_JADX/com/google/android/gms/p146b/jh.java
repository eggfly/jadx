package com.google.android.gms.p146b;

import android.support.v4.util.ArrayMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.b.jh */
public final class jh {
    public static <K, V> Map<K, V> m13546a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map arrayMap = new ArrayMap(6);
        arrayMap.put(k, v);
        arrayMap.put(k2, v2);
        arrayMap.put(k3, v3);
        arrayMap.put(k4, v4);
        arrayMap.put(k5, v5);
        arrayMap.put(k6, v6);
        return Collections.unmodifiableMap(arrayMap);
    }

    public static <T> Set<T> m13547a() {
        return Collections.emptySet();
    }

    public static <T> Set<T> m13548a(T t) {
        return Collections.singleton(t);
    }

    public static <T> Set<T> m13549a(T t, T t2) {
        Set jcVar = new jc(2);
        jcVar.add(t);
        jcVar.add(t2);
        return Collections.unmodifiableSet(jcVar);
    }

    public static <T> Set<T> m13550a(T t, T t2, T t3) {
        Set jcVar = new jc(3);
        jcVar.add(t);
        jcVar.add(t2);
        jcVar.add(t3);
        return Collections.unmodifiableSet(jcVar);
    }

    public static <T> Set<T> m13551a(T t, T t2, T t3, T t4) {
        Set jcVar = new jc(4);
        jcVar.add(t);
        jcVar.add(t2);
        jcVar.add(t3);
        jcVar.add(t4);
        return Collections.unmodifiableSet(jcVar);
    }

    public static <T> Set<T> m13552a(T... tArr) {
        switch (tArr.length) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return jh.m13547a();
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return jh.m13548a(tArr[0]);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return jh.m13549a(tArr[0], tArr[1]);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return jh.m13550a(tArr[0], tArr[1], tArr[2]);
            case SpdyProtocol.QUIC /*4*/:
                return jh.m13551a(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new jc(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }
}
