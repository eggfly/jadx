package com.xiaomi.market.sdk;

public class Constants {
    public static String f4573a;

    public interface BaseColumns {
    }

    public static final class Update implements BaseColumns {
        public static final String[] f4569a;

        static {
            f4569a = new String[]{"update_download.package_name", "update_download.download_id", "update_download.version_code", "update_download.apk_url", "update_download.apk_hash", "update_download.diff_url", "update_download.diff_hash", "update_download.apk_path"};
        }
    }

    public enum UpdateMethod {
        MARKET,
        DOWNLOAD_MANAGER
    }

    static {
        f4573a = "http://api.developer.xiaomi.com/autoupdate/updateself";
    }

    public static void m6168a() {
        if (Utils.f4610b) {
            f4573a = "http://dev.staging.api.developer.n.xiaomi.com/autoupdate/updateself";
        } else {
            f4573a = "http://api.developer.xiaomi.com/autoupdate/updateself";
        }
    }
}
