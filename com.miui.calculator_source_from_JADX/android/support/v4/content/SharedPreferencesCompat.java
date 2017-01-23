package android.support.v4.content;

import android.os.Build.VERSION;

public class SharedPreferencesCompat {

    public static class EditorCompat {
        private final Helper f446a;

        private interface Helper {
        }

        private static class EditorHelperApi9Impl implements Helper {
            private EditorHelperApi9Impl() {
            }
        }

        private static class EditorHelperBaseImpl implements Helper {
            private EditorHelperBaseImpl() {
            }
        }

        private EditorCompat() {
            if (VERSION.SDK_INT >= 9) {
                this.f446a = new EditorHelperApi9Impl();
            } else {
                this.f446a = new EditorHelperBaseImpl();
            }
        }
    }
}
