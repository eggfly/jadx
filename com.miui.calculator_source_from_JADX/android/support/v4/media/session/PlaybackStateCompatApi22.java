package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;

class PlaybackStateCompatApi22 {
    PlaybackStateCompatApi22() {
    }

    public static Bundle m998a(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }
}
