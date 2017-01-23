package com.google.android.gms.common.internal;

import aeq$c;
import aft;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;

public final class o {
    public static String DW(Context context, int i) {
        return i == 6 ? context.getResources().getString(aeq$c.common_google_play_services_resolution_required_title) : j6(context, i);
    }

    public static String DW(Context context, int i, String str) {
        return i == 6 ? context.getResources().getString(aeq$c.common_google_play_services_resolution_required_text) : j6(context, i, str);
    }

    public static String FH(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return resources.getString(aeq$c.common_google_play_services_install_button);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return resources.getString(aeq$c.common_google_play_services_update_button);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return resources.getString(aeq$c.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static String j6(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return resources.getString(aeq$c.common_google_play_services_install_title);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 42:
                return resources.getString(aeq$c.common_google_play_services_update_title);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return resources.getString(aeq$c.common_google_play_services_enable_title);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(aeq$c.common_google_play_services_invalid_account_title);
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(aeq$c.common_google_play_services_network_error_title);
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(aeq$c.common_google_play_services_unsupported_title);
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(aeq$c.common_google_play_services_sign_in_failed_title);
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return resources.getString(aeq$c.common_google_play_services_updating_title);
            case ProxyTextView.INPUTTYPE_date /*20*/:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return resources.getString(aeq$c.common_google_play_services_restricted_profile_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String j6(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (aft.j6(resources)) {
                    return resources.getString(aeq$c.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(aeq$c.common_google_play_services_install_text_phone, new Object[]{str});
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return resources.getString(aeq$c.common_google_play_services_update_text, new Object[]{str});
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return resources.getString(aeq$c.common_google_play_services_enable_text, new Object[]{str});
            case 5:
                return resources.getString(aeq$c.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(aeq$c.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(aeq$c.common_google_play_services_unsupported_text, new Object[]{str});
            case 16:
                return resources.getString(aeq$c.common_google_play_services_api_unavailable_text, new Object[]{str});
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return resources.getString(aeq$c.common_google_play_services_sign_in_failed_text);
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return resources.getString(aeq$c.common_google_play_services_updating_text, new Object[]{str});
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return resources.getString(aeq$c.common_google_play_services_restricted_profile_text);
            case 42:
                return resources.getString(aeq$c.common_google_play_services_wear_update_text);
            default:
                return resources.getString(aeq$c.common_google_play_services_unknown_issue, new Object[]{str});
        }
    }
}
