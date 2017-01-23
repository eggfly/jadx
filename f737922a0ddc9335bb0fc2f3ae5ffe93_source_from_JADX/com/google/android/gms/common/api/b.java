package com.google.android.gms.common.api;

import com.aide.uidesigner.ProxyTextView;

public class b {
    public static String j6(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return "SUCCESS";
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "SERVICE_MISSING";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return "SERVICE_DISABLED";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return "API_NOT_CONNECTED";
            case 3000:
                return "AUTH_API_INVALID_CREDENTIALS";
            case 3001:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case 3002:
                return "AUTH_API_CLIENT_ERROR";
            case 3003:
                return "AUTH_API_SERVER_ERROR";
            case 3004:
                return "AUTH_TOKEN_ERROR";
            case 3005:
                return "AUTH_URL_RESOLUTION";
            default:
                return "unknown status code: " + i;
        }
    }
}
