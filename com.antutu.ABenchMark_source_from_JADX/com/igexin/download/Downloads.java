package com.igexin.download;

import android.net.Uri;
import android.provider.BaseColumns;
import com.qq.p035e.comm.constants.ErrorCode.AdError;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.ErrorCode;

public final class Downloads implements BaseColumns {
    public static final String ACTION_DOWNLOAD_COMPLETED = "android.intent.action.DOWNLOAD_COMPLETED";
    public static final String ACTION_NOTIFICATION_CLICKED = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    public static final String COLUMN_APP_DATA = "entity";
    public static final String COLUMN_CONTROL = "control";
    public static final String COLUMN_COOKIE_DATA = "cookiedata";
    public static final String COLUMN_CREATE_MODIFICATION = "createmod";
    public static final String COLUMN_CURRENT_BYTES = "current_bytes";
    public static final String COLUMN_DATA1 = "data_1";
    public static final String COLUMN_DATA10 = "data_10";
    public static final String COLUMN_DATA2 = "data_2";
    public static final String COLUMN_DATA3 = "data_3";
    public static final String COLUMN_DATA4 = "data_4";
    public static final String COLUMN_DATA5 = "data_5";
    public static final String COLUMN_DATA6 = "data_6";
    public static final String COLUMN_DATA7 = "data_7";
    public static final String COLUMN_DATA8 = "data_8";
    public static final String COLUMN_DATA9 = "data_9";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DESTINATION = "destination";
    public static final String COLUMN_EXTRAS = "extras";
    public static final String COLUMN_FILE_NAME_HINT = "hint";
    public static final String COLUMN_IS_WEB_ICON = "iswebicon";
    public static final String COLUMN_LAST_MODIFICATION = "lastmod";
    public static final String COLUMN_MIME_TYPE = "mimetype";
    public static final String COLUMN_NO_INTEGRITY = "no_integrity";
    public static final String COLUMN_OTHER_UID = "otheruid";
    public static final String COLUMN_REFERER = "referer";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TOTAL_BYTES = "total_bytes";
    public static final String COLUMN_URI = "uri";
    public static final String COLUMN_USER_AGENT = "useragent";
    public static final String COLUMN_VISIBILITY = "visibility";
    public static final int CONTROL_PAUSED = 1;
    public static final int CONTROL_RUN = 0;
    public static final int DESTINATION_CACHE_PARTITION = 1;
    public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
    public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
    public static final int DESTINATION_EXTERNAL = 0;
    public static final String PERMISSION_ACCESS = "android.permission.ACCESS_DOWNLOAD_MANAGER";
    public static final String PERMISSION_ACCESS_ADVANCED = "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
    public static final String PERMISSION_CACHE = "android.permission.ACCESS_CACHE_FILESYSTEM";
    public static final String PERMISSION_SEND_INTENTS = "android.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
    public static final int STATUS_BAD_REQUEST = 400;
    public static final int STATUS_CANCELED = 490;
    public static final int STATUS_FILE_ERROR = 492;
    public static final int STATUS_HTTP_DATA_ERROR = 495;
    public static final int STATUS_HTTP_EXCEPTION = 496;
    public static final int STATUS_LENGTH_REQUIRED = 411;
    public static final int STATUS_NOT_ACCEPTABLE = 406;
    public static final int STATUS_PENDING = 190;
    public static final int STATUS_PENDING_PAUSED = 191;
    public static final int STATUS_PRECONDITION_FAILED = 412;
    public static final int STATUS_RUNNING = 192;
    public static final int STATUS_RUNNING_PAUSED = 193;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_TOO_MANY_REDIRECTS = 497;
    public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
    public static final int STATUS_UNHANDLED_REDIRECT = 493;
    public static final int STATUS_UNKNOWN_ERROR = 491;
    public static final int VISIBILITY_HIDDEN = 2;
    public static final int VISIBILITY_VISIBLE = 0;
    public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
    public static final String _DATA = "_data";
    static Uri f12492a;
    public static String authority;
    static Uri f12493b;

    static {
        f12492a = null;
        f12493b = null;
    }

    private Downloads() {
    }

    public static boolean isStatusClientError(int i) {
        return i >= STATUS_BAD_REQUEST && i < AdError.PLACEMENT_ERROR;
    }

    public static boolean isStatusCompleted(int i) {
        return (i >= STATUS_SUCCESS && i < ErrorCode.APP_NOT_BIND) || (i >= STATUS_BAD_REQUEST && i < OtherError.CONTAINER_INVISIBLE_ERROR);
    }

    public static boolean isStatusError(int i) {
        return i >= STATUS_BAD_REQUEST && i < OtherError.CONTAINER_INVISIBLE_ERROR;
    }

    public static boolean isStatusInformational(int i) {
        return i >= 100 && i < STATUS_SUCCESS;
    }

    public static boolean isStatusServerError(int i) {
        return i >= AdError.PLACEMENT_ERROR && i < OtherError.CONTAINER_INVISIBLE_ERROR;
    }

    public static boolean isStatusSuccess(int i) {
        return i >= STATUS_SUCCESS && i < ErrorCode.APP_NOT_BIND;
    }

    public static boolean isStatusSuspended(int i) {
        return i == STATUS_PENDING_PAUSED || i == STATUS_RUNNING_PAUSED;
    }

    public static void setContentUrl(String str) {
        authority = str;
        f12492a = Uri.parse("content://" + str + "/download");
        f12493b = Uri.parse("content://" + str + "/download/full/item");
    }
}
