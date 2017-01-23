package com.miui.support.internal.variable.v16;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Android_App_PreferenceActivity_class extends com.miui.support.internal.variable.Android_App_PreferenceActivity_class {
    private static final String ID_HEADERS = "headers";
    private static final String ID_PREFS_FRAME = "prefs_frame";
    private static final String PACKAGE_ANDROID = "android";
    private static final String TYPE_ID = "id";

    public void onCreate(Activity activity, Bundle bundle) {
        View findViewById;
        int identifier = activity.getResources().getIdentifier(ID_HEADERS, TYPE_ID, PACKAGE_ANDROID);
        if (identifier > 0) {
            findViewById = activity.findViewById(identifier);
            if (findViewById != null) {
                findViewById.setBackground(null);
                findViewById.setPadding(0, 0, 0, 0);
            }
        }
        identifier = activity.getResources().getIdentifier(ID_PREFS_FRAME, TYPE_ID, PACKAGE_ANDROID);
        if (identifier > 0) {
            findViewById = activity.findViewById(identifier);
            if (findViewById != null) {
                findViewById.setBackground(null);
                findViewById.setPadding(0, 0, 0, 0);
            }
        }
    }
}
