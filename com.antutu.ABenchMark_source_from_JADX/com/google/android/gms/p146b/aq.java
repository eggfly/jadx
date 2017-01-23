package com.google.android.gms.p146b;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import com.google.android.gms.ads.internal.C2968s;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@gb
/* renamed from: com.google.android.gms.b.aq */
public final class aq {
    public static final am<Boolean> f10261A;
    public static final am<Boolean> f10262B;
    public static final am<Boolean> f10263C;
    public static final am<String> f10264D;
    public static final am<String> f10265E;
    public static final am<String> f10266F;
    public static final am<Boolean> f10267G;
    public static final am<String> f10268H;
    public static final am<Boolean> f10269I;
    public static final am<Boolean> f10270J;
    public static final am<Integer> f10271K;
    public static final am<Integer> f10272L;
    public static final am<Integer> f10273M;
    public static final am<Integer> f10274N;
    public static final am<Integer> f10275O;
    public static final am<Boolean> f10276P;
    public static final am<Boolean> f10277Q;
    public static final am<Long> f10278R;
    public static final am<String> f10279S;
    public static final am<String> f10280T;
    public static final am<Boolean> f10281U;
    public static final am<Boolean> f10282V;
    public static final am<Boolean> f10283W;
    public static final am<String> f10284X;
    public static final am<Boolean> f10285Y;
    public static final am<Boolean> f10286Z;
    public static final am<String> f10287a;
    public static final am<Boolean> aA;
    public static final am<Boolean> aB;
    public static final am<Boolean> aC;
    public static final am<Boolean> aD;
    public static final am<Boolean> aE;
    public static final am<Long> aF;
    public static final am<Boolean> aG;
    public static final am<Integer> aa;
    public static final am<String> ab;
    public static final am<String> ac;
    public static final am<Boolean> ad;
    public static final am<Boolean> ae;
    public static final am<String> af;
    public static final am<Integer> ag;
    public static final am<Integer> ah;
    public static final am<Integer> ai;
    public static final am<String> aj;
    public static final am<Boolean> ak;
    public static final am<Boolean> al;
    public static final am<Long> am;
    public static final am<Boolean> an;
    public static final am<Boolean> ao;
    public static final am<Boolean> ap;
    public static final am<Boolean> aq;
    public static final am<Boolean> ar;
    public static final am<Boolean> as;
    public static final am<Boolean> at;
    public static final am<Long> au;
    public static final am<Boolean> av;
    public static final am<Boolean> aw;
    public static final am<Long> ax;
    public static final am<Long> ay;
    public static final am<Boolean> az;
    public static final am<String> f10288b;
    public static final am<Boolean> f10289c;
    public static final am<String> f10290d;
    public static final am<Boolean> f10291e;
    public static final am<String> f10292f;
    public static final am<Boolean> f10293g;
    public static final am<Boolean> f10294h;
    public static final am<Boolean> f10295i;
    public static final am<String> f10296j;
    public static final am<String> f10297k;
    public static final am<String> f10298l;
    public static final am<Boolean> f10299m;
    public static final am<String> f10300n;
    public static final am<Integer> f10301o;
    public static final am<Integer> f10302p;
    public static final am<Integer> f10303q;
    public static final am<Long> f10304r;
    public static final am<Long> f10305s;
    public static final am<Integer> f10306t;
    public static final am<Boolean> f10307u;
    public static final am<String> f10308v;
    public static final am<Long> f10309w;
    public static final am<String> f10310x;
    public static final am<Boolean> f10311y;
    public static final am<String> f10312z;

    /* renamed from: com.google.android.gms.b.aq.1 */
    static class C30311 implements Callable<Void> {
        final /* synthetic */ Context f10260a;

        C30311(Context context) {
            this.f10260a = context;
        }

        public Void m11812a() {
            C2968s.m11534n().m11811a(this.f10260a);
            return null;
        }

        public /* synthetic */ Object call() {
            return m11812a();
        }
    }

    static {
        f10287a = am.m11785a(0, "gads:sdk_core_experiment_id");
        f10288b = am.m11789a(0, "gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
        f10289c = am.m11788a(0, "gads:request_builder:singleton_webview", Boolean.valueOf(false));
        f10290d = am.m11785a(0, "gads:request_builder:singleton_webview_experiment_id");
        f10291e = am.m11788a(0, "gads:sdk_use_dynamic_module", Boolean.valueOf(false));
        f10292f = am.m11785a(0, "gads:sdk_use_dynamic_module_experiment_id");
        f10293g = am.m11788a(0, "gads:sdk_crash_report_enabled", Boolean.valueOf(false));
        f10294h = am.m11788a(0, "gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
        f10295i = am.m11788a(0, "gads:block_autoclicks", Boolean.valueOf(false));
        f10296j = am.m11785a(0, "gads:block_autoclicks_experiment_id");
        f10297k = am.m11790b(0, "gads:prefetch:experiment_id");
        f10298l = am.m11785a(0, "gads:spam_app_context:experiment_id");
        f10299m = am.m11788a(0, "gads:spam_app_context:enabled", Boolean.valueOf(false));
        f10300n = am.m11785a(0, "gads:video_stream_cache:experiment_id");
        f10301o = am.m11786a(0, "gads:video_stream_cache:limit_count", 5);
        f10302p = am.m11786a(0, "gads:video_stream_cache:limit_space", (int) GravityCompat.RELATIVE_LAYOUT_DIRECTION);
        f10303q = am.m11786a(0, "gads:video_stream_exo_cache:buffer_size", (int) GravityCompat.RELATIVE_LAYOUT_DIRECTION);
        f10304r = am.m11787a(0, "gads:video_stream_cache:limit_time_sec", 300);
        f10305s = am.m11787a(0, "gads:video_stream_cache:notify_interval_millis", 1000);
        f10306t = am.m11786a(0, "gads:video_stream_cache:connect_timeout_millis", 10000);
        f10307u = am.m11788a(0, "gads:video:metric_reporting_enabled", Boolean.valueOf(false));
        f10308v = am.m11789a(0, "gads:video:metric_frame_hash_times", BuildConfig.FLAVOR);
        f10309w = am.m11787a(0, "gads:video:metric_frame_hash_time_leniency", 500);
        f10310x = am.m11790b(0, "gads:spam_ad_id_decorator:experiment_id");
        f10311y = am.m11788a(0, "gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
        f10312z = am.m11790b(0, "gads:looper_for_gms_client:experiment_id");
        f10261A = am.m11788a(0, "gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
        f10262B = am.m11788a(0, "gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
        f10263C = am.m11788a(0, "gads:sw_dynamite:enabled", Boolean.valueOf(true));
        f10264D = am.m11789a(0, "gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
        f10265E = am.m11789a(0, "gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
        f10266F = am.m11789a(0, "gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
        f10267G = am.m11788a(0, "gads:enabled_sdk_csi", Boolean.valueOf(false));
        f10268H = am.m11789a(0, "gads:sdk_csi_server", "https://csi.gstatic.com/csi");
        f10269I = am.m11788a(0, "gads:sdk_csi_write_to_file", Boolean.valueOf(false));
        f10270J = am.m11788a(0, "gads:enable_content_fetching", Boolean.valueOf(true));
        f10271K = am.m11786a(0, "gads:content_length_weight", 1);
        f10272L = am.m11786a(0, "gads:content_age_weight", 1);
        f10273M = am.m11786a(0, "gads:min_content_len", 11);
        f10274N = am.m11786a(0, "gads:fingerprint_number", 10);
        f10275O = am.m11786a(0, "gads:sleep_sec", 10);
        f10276P = am.m11788a(0, "gad:app_index_enabled", Boolean.valueOf(true));
        f10277Q = am.m11788a(0, "gads:app_index:without_content_info_present:enabled", Boolean.valueOf(true));
        f10278R = am.m11787a(0, "gads:app_index:timeout_ms", 1000);
        f10279S = am.m11785a(0, "gads:app_index:experiment_id");
        f10280T = am.m11785a(0, "gads:kitkat_interstitial_workaround:experiment_id");
        f10281U = am.m11788a(0, "gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
        f10282V = am.m11788a(0, "gads:interstitial_follow_url", Boolean.valueOf(true));
        f10283W = am.m11788a(0, "gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
        f10284X = am.m11785a(0, "gads:interstitial_follow_url:experiment_id");
        f10285Y = am.m11788a(0, "gads:analytics_enabled", Boolean.valueOf(true));
        f10286Z = am.m11788a(0, "gads:ad_key_enabled", Boolean.valueOf(false));
        aa = am.m11786a(0, "gads:webview_cache_version", 0);
        ab = am.m11790b(0, "gads:pan:experiment_id");
        ac = am.m11789a(0, "gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
        ad = am.m11788a(0, "gads:ad_manager_creator:enabled", Boolean.valueOf(true));
        ae = am.m11788a(1, "gads:interstitial_ad_pool:enabled", Boolean.valueOf(false));
        af = am.m11789a(1, "gads:interstitial_ad_pool:schema", "customTargeting");
        ag = am.m11786a(1, "gads:interstitial_ad_pool:max_pools", 3);
        ah = am.m11786a(1, "gads:interstitial_ad_pool:max_pool_depth", 2);
        ai = am.m11786a(1, "gads:interstitial_ad_pool:time_limit_sec", 1200);
        aj = am.m11785a(1, "gads:interstitial_ad_pool:experiment_id");
        ak = am.m11788a(0, "gads:log:verbose_enabled", Boolean.valueOf(false));
        al = am.m11788a(0, "gads:device_info_caching:enabled", Boolean.valueOf(true));
        am = am.m11787a(0, "gads:device_info_caching_expiry_ms:expiry", 300000);
        an = am.m11788a(0, "gads:gen204_signals:enabled", Boolean.valueOf(false));
        ao = am.m11788a(0, "gads:webview:error_reporting_enabled", Boolean.valueOf(false));
        ap = am.m11788a(0, "gads:adid_reporting:enabled", Boolean.valueOf(false));
        aq = am.m11788a(0, "gads:ad_settings_page_reporting:enabled", Boolean.valueOf(false));
        ar = am.m11788a(0, "gads:adid_info_gmscore_upgrade_reporting:enabled", Boolean.valueOf(false));
        as = am.m11788a(0, "gads:request_pkg:enabled", Boolean.valueOf(true));
        at = am.m11788a(0, "gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
        au = am.m11787a(0, "gads:network:cache_prediction_duration_s", 300);
        av = am.m11788a(0, "gads:mediation:dynamite_first:admobadapter", Boolean.valueOf(true));
        aw = am.m11788a(0, "gads:mediation:dynamite_first:adurladapter", Boolean.valueOf(true));
        ax = am.m11787a(0, "gads:ad_loader:timeout_ms", 60000);
        ay = am.m11787a(0, "gads:rendering:timeout_ms", 60000);
        az = am.m11788a(0, "gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
        aA = am.m11788a(0, "gass:enabled", Boolean.valueOf(false));
        aB = am.m11788a(0, "gass:enable_int_signal", Boolean.valueOf(true));
        aC = am.m11788a(0, "gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
        aD = am.m11788a(0, "gads:edu_device_helper:enabled", Boolean.valueOf(true));
        aE = am.m11788a(0, "gads:support_screen_shot", Boolean.valueOf(true));
        aF = am.m11787a(0, "gads:js_flags:update_interval", TimeUnit.HOURS.toMillis(12));
        aG = am.m11788a(0, "gads:custom_render:ping_on_ad_rendered", Boolean.valueOf(false));
    }

    public static List<String> m11813a() {
        return C2968s.m11533m().m11803a();
    }

    public static void m11814a(Context context) {
        hu.m13160a(new C30311(context));
    }

    public static List<String> m11815b() {
        return C2968s.m11533m().m11805b();
    }
}
