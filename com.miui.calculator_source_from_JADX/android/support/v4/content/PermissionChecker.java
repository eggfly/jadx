package android.support.v4.content;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionChecker {

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }
}
