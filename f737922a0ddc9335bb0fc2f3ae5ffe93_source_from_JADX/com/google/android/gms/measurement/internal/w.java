package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hh;

public final class w {
    public static a<Boolean> DW;
    public static a<Integer> EQ;
    public static a<String> FH;
    public static a<Long> Hw;
    public static a<Integer> J0;
    public static a<Integer> J8;
    public static a<Long> Mr;
    public static a<Integer> QX;
    public static a<Long> U2;
    public static a<String> VH;
    public static a<Integer> Ws;
    public static a<String> XL;
    public static a<Long> Zo;
    public static a<Long> a8;
    public static a<Long> aM;
    public static a<Long> er;
    public static a<Long> gW;
    public static a<String> gn;
    public static a<Long> j3;
    public static a<Boolean> j6;
    public static a<Long> lg;
    public static a<Integer> rN;
    public static a<Integer> tp;
    public static a<Integer> u7;
    public static a<Long> v5;
    public static a<Integer> we;
    public static a<Integer> yS;

    public static final class a<V> {
        private final hh<V> DW;
        private final String FH;
        private final V j6;

        private a(String str, hh<V> hhVar, V v) {
            b.j6((Object) hhVar);
            this.DW = hhVar;
            this.j6 = v;
            this.FH = str;
        }

        static a<Integer> j6(String str, int i) {
            return j6(str, i, i);
        }

        static a<Integer> j6(String str, int i, int i2) {
            return new a(str, hh.j6(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static a<Long> j6(String str, long j) {
            return j6(str, j, j);
        }

        static a<Long> j6(String str, long j, long j2) {
            return new a(str, hh.j6(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static a<String> j6(String str, String str2) {
            return j6(str, str2, str2);
        }

        static a<String> j6(String str, String str2, String str3) {
            return new a(str, hh.j6(str, str3), str2);
        }

        static a<Boolean> j6(String str, boolean z) {
            return j6(str, z, z);
        }

        static a<Boolean> j6(String str, boolean z, boolean z2) {
            return new a(str, hh.j6(str, z2), Boolean.valueOf(z));
        }

        public V DW() {
            return this.j6;
        }

        public V j6(V v) {
            return v != null ? v : this.j6;
        }

        public String j6() {
            return this.FH;
        }
    }

    static {
        j6 = a.j6("measurement.service_enabled", true);
        DW = a.j6("measurement.service_client_enabled", true);
        FH = a.j6("measurement.log_tag", "FA", "FA-SVC");
        Hw = a.j6("measurement.ad_id_cache_time", 10000);
        v5 = a.j6("measurement.monitoring.sample_period_millis", 86400000);
        Zo = a.j6("measurement.config.cache_time", 86400000, 3600000);
        VH = a.j6("measurement.config.url_scheme", "https");
        gn = a.j6("measurement.config.url_authority", "app-measurement.com");
        u7 = a.j6("measurement.upload.max_bundles", 100);
        tp = a.j6("measurement.upload.max_batch_size", 65536);
        EQ = a.j6("measurement.upload.max_bundle_size", 65536);
        we = a.j6("measurement.upload.max_events_per_bundle", 1000);
        J0 = a.j6("measurement.upload.max_events_per_day", 100000);
        J8 = a.j6("measurement.upload.max_public_events_per_day", 50000);
        Ws = a.j6("measurement.upload.max_conversions_per_day", 500);
        QX = a.j6("measurement.store.max_stored_events_per_app", 100000);
        XL = a.j6("measurement.upload.url", "https://app-measurement.com/a");
        aM = a.j6("measurement.upload.backoff_period", 43200000);
        j3 = a.j6("measurement.upload.window_interval", 3600000);
        Mr = a.j6("measurement.upload.interval", 3600000);
        U2 = a.j6("measurement.upload.stale_data_deletion_interval", 86400000);
        a8 = a.j6("measurement.upload.initial_upload_delay_time", 15000);
        lg = a.j6("measurement.upload.retry_time", 1800000);
        rN = a.j6("measurement.upload.retry_count", 6);
        er = a.j6("measurement.upload.max_queue_time", 2419200000L);
        yS = a.j6("measurement.lifetimevalue.max_currency_tracked", 4);
        gW = a.j6("measurement.service_client.idle_disconnect_millis", 5000);
    }
}
