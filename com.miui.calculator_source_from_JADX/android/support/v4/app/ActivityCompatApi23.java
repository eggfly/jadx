package android.support.v4.app;

import android.app.Activity;

class ActivityCompatApi23 {

    public interface RequestPermissionsRequestCodeValidator {
        void m81a(int i);
    }

    ActivityCompatApi23() {
    }

    public static void m82a(Activity activity, String[] strArr, int i) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).m81a(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
