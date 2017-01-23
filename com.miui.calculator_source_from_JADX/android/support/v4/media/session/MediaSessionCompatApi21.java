package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.os.ResultReceiver;

class MediaSessionCompatApi21 {

    public interface Callback {
        void m838a();

        void m839a(long j);

        void m840a(Object obj);

        void m841a(String str, Bundle bundle);

        void m842a(String str, Bundle bundle, ResultReceiver resultReceiver);

        boolean m843a(Intent intent);

        void m844b();

        void m845b(long j);

        void m846b(String str, Bundle bundle);

        void m847c();

        void m848c(String str, Bundle bundle);

        void m849d();

        void m850e();

        void m851f();

        void m852g();
    }

    static class CallbackProxy<T extends Callback> extends android.media.session.MediaSession.Callback {
        protected final T f594a;

        public CallbackProxy(T t) {
            this.f594a = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f594a.m842a(str, bundle, resultReceiver);
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return this.f594a.m843a(intent) || super.onMediaButtonEvent(intent);
        }

        public void onPlay() {
            this.f594a.m838a();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.f594a.m841a(str, bundle);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            this.f594a.m846b(str, bundle);
        }

        public void onSkipToQueueItem(long j) {
            this.f594a.m839a(j);
        }

        public void onPause() {
            this.f594a.m844b();
        }

        public void onSkipToNext() {
            this.f594a.m847c();
        }

        public void onSkipToPrevious() {
            this.f594a.m849d();
        }

        public void onFastForward() {
            this.f594a.m850e();
        }

        public void onRewind() {
            this.f594a.m851f();
        }

        public void onStop() {
            this.f594a.m852g();
        }

        public void onSeekTo(long j) {
            this.f594a.m845b(j);
        }

        public void onSetRating(Rating rating) {
            this.f594a.m840a((Object) rating);
        }

        public void onCustomAction(String str, Bundle bundle) {
            this.f594a.m848c(str, bundle);
        }
    }

    static class QueueItem {
        QueueItem() {
        }
    }

    MediaSessionCompatApi21() {
    }

    public static Object m958a(Callback callback) {
        return new CallbackProxy(callback);
    }
}
