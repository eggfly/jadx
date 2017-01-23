package com.google.android.gms.measurement;

import afr;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.measurement.internal.ai;
import java.util.Map;

@Deprecated
public class AppMeasurement {
    private final ai j6;

    public static final class a {
        public static final Map<String, String> j6;

        static {
            j6 = afr.j6(new String[]{"app_clear_data", "app_exception", "app_uninstall", "app_update", "firebase_campaign", "error", "first_open", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement"}, new String[]{"_cd", "_ae", "_ui", "_au", "_cmp", "_err", "_f", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e"});
        }
    }

    public interface b {
        void j6(String str, String str2, Bundle bundle, long j);
    }

    public interface c {
        void j6(String str, String str2, Bundle bundle, long j);
    }

    public static final class d {
        public static final Map<String, String> j6;

        static {
            j6 = afr.j6(new String[]{"firebase_conversion", "engagement_time_msec", "firebase_error", "error_value", "firebase_event_origin", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic"}, new String[]{"_c", "_et", "_err", "_ev", "_o", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt"});
        }
    }

    public static final class e {
        public static final Map<String, String> j6;

        static {
            j6 = afr.j6(new String[]{"firebase_last_notification", "first_open_time", "last_deep_link_referrer", "user_id"}, new String[]{"_ln", "_fot", "_ldl", "_id"});
        }
    }

    public AppMeasurement(ai aiVar) {
        com.google.android.gms.common.internal.b.j6((Object) aiVar);
        this.j6 = aiVar;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return ai.j6(context).J0();
    }
}
