package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hh;

public final class an {
    public static a<String> BT;
    public static a<Boolean> DW;
    public static a<Long> EQ;
    public static a<String> FH;
    public static a<Long> Hw;
    public static a<Long> J0;
    public static a<Long> J8;
    public static a<String> KD;
    public static a<String> Mr;
    public static a<Long> P8;
    public static a<Integer> QX;
    public static a<Long> SI;
    public static a<Long> Sf;
    public static a<Integer> U2;
    public static a<Integer> VH;
    public static a<Integer> Ws;
    public static a<String> XL;
    public static a<Integer> Zo;
    public static a<String> a8;
    public static a<String> aM;
    public static a<Long> cb;
    public static a<Boolean> cn;
    public static a<Long> dx;
    public static a<Long> ef;
    public static a<Integer> ei;
    public static a<Integer> er;
    public static a<Integer> gW;
    public static a<Integer> gn;
    public static a<String> j3;
    public static a<Boolean> j6;
    public static a<String> lg;
    public static a<Integer> nw;
    public static a<Integer> rN;
    public static a<Integer> ro;
    public static a<Long> sG;
    public static a<Long> sh;
    public static a<Long> tp;
    public static a<Long> u7;
    public static a<Float> v5;
    public static a<Long> vJ;
    public static a<Integer> vy;
    public static a<Long> we;
    public static a<Integer> yS;

    public static final class a<V> {
        private final hh<V> DW;
        private final V j6;

        private a(hh<V> hhVar, V v) {
            b.j6((Object) hhVar);
            this.DW = hhVar;
            this.j6 = v;
        }

        static a<Float> j6(String str, float f) {
            return j6(str, f, f);
        }

        static a<Float> j6(String str, float f, float f2) {
            return new a(hh.j6(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static a<Integer> j6(String str, int i) {
            return j6(str, i, i);
        }

        static a<Integer> j6(String str, int i, int i2) {
            return new a(hh.j6(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static a<Long> j6(String str, long j) {
            return j6(str, j, j);
        }

        static a<Long> j6(String str, long j, long j2) {
            return new a(hh.j6(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static a<String> j6(String str, String str2) {
            return j6(str, str2, str2);
        }

        static a<String> j6(String str, String str2, String str3) {
            return new a(hh.j6(str, str3), str2);
        }

        static a<Boolean> j6(String str, boolean z) {
            return j6(str, z, z);
        }

        static a<Boolean> j6(String str, boolean z, boolean z2) {
            return new a(hh.j6(str, z2), Boolean.valueOf(z));
        }

        public V j6() {
            return this.j6;
        }
    }

    static {
        j6 = a.j6("analytics.service_enabled", false);
        DW = a.j6("analytics.service_client_enabled", true);
        FH = a.j6("analytics.log_tag", "GAv4", "GAv4-SVC");
        Hw = a.j6("analytics.max_tokens", 60);
        v5 = a.j6("analytics.tokens_per_sec", 0.5f);
        Zo = a.j6("analytics.max_stored_hits", 2000, 20000);
        VH = a.j6("analytics.max_stored_hits_per_app", 2000);
        gn = a.j6("analytics.max_stored_properties_per_app", 100);
        u7 = a.j6("analytics.local_dispatch_millis", 1800000, 120000);
        tp = a.j6("analytics.initial_local_dispatch_millis", 5000, 5000);
        EQ = a.j6("analytics.min_local_dispatch_millis", 120000);
        we = a.j6("analytics.max_local_dispatch_millis", 7200000);
        J0 = a.j6("analytics.dispatch_alarm_millis", 7200000);
        J8 = a.j6("analytics.max_dispatch_alarm_millis", 32400000);
        Ws = a.j6("analytics.max_hits_per_dispatch", 20);
        QX = a.j6("analytics.max_hits_per_batch", 20);
        XL = a.j6("analytics.insecure_host", "http://www.google-analytics.com");
        aM = a.j6("analytics.secure_host", "https://ssl.google-analytics.com");
        j3 = a.j6("analytics.simple_endpoint", "/collect");
        Mr = a.j6("analytics.batching_endpoint", "/batch");
        U2 = a.j6("analytics.max_get_length", 2036);
        a8 = a.j6("analytics.batching_strategy.k", ab.BATCH_BY_COUNT.name(), ab.BATCH_BY_COUNT.name());
        lg = a.j6("analytics.compression_strategy.k", ad.GZIP.name());
        rN = a.j6("analytics.max_hits_per_request.k", 20);
        er = a.j6("analytics.max_hit_length.k", 8192);
        yS = a.j6("analytics.max_post_length.k", 8192);
        gW = a.j6("analytics.max_batch_post_length", 8192);
        BT = a.j6("analytics.fallback_responses.k", "404,502");
        vy = a.j6("analytics.batch_retry_interval.seconds.k", 3600);
        P8 = a.j6("analytics.service_monitor_interval", 86400000);
        ei = a.j6("analytics.http_connection.connect_timeout_millis", 60000);
        nw = a.j6("analytics.http_connection.read_timeout_millis", 61000);
        SI = a.j6("analytics.campaigns.time_limit", 86400000);
        KD = a.j6("analytics.first_party_experiment_id", "");
        ro = a.j6("analytics.first_party_experiment_variant", 0);
        cn = a.j6("analytics.test.disable_receiver", false);
        sh = a.j6("analytics.service_client.idle_disconnect_millis", 10000, 10000);
        cb = a.j6("analytics.service_client.connect_timeout_millis", 5000);
        dx = a.j6("analytics.service_client.second_connect_delay_millis", 5000);
        sG = a.j6("analytics.service_client.unexpected_reconnect_millis", 60000);
        ef = a.j6("analytics.service_client.reconnect_throttle_millis", 1800000);
        Sf = a.j6("analytics.monitoring.sample_period_millis", 86400000);
        vJ = a.j6("analytics.initialization_warning_threshold", 5000);
    }
}
