package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class PlaybackStateCompatApi21 {

    static final class CustomAction {
        CustomAction() {
        }

        public static String m985a(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getAction();
        }

        public static CharSequence m986b(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getName();
        }

        public static int m987c(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle m988d(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getExtras();
        }
    }

    PlaybackStateCompatApi21() {
    }

    public static int m989a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long m990b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long m991c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float m992d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long m993e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence m994f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long m995g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> m996h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long m997i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
