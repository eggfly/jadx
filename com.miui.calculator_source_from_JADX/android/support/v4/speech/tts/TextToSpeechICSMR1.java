package android.support.v4.speech.tts;

import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.speech.tts.UtteranceProgressListener;

class TextToSpeechICSMR1 {

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1.1 */
    final class C00731 extends UtteranceProgressListener {
        final /* synthetic */ UtteranceProgressListenerICSMR1 f665a;

        public void onStart(String str) {
            this.f665a.m1030c(str);
        }

        public void onError(String str) {
            this.f665a.m1029b(str);
        }

        public void onDone(String str) {
            this.f665a.m1028a(str);
        }
    }

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1.2 */
    final class C00742 implements OnUtteranceCompletedListener {
        final /* synthetic */ UtteranceProgressListenerICSMR1 f666a;

        public void onUtteranceCompleted(String str) {
            this.f666a.m1030c(str);
            this.f666a.m1028a(str);
        }
    }

    interface UtteranceProgressListenerICSMR1 {
        void m1028a(String str);

        void m1029b(String str);

        void m1030c(String str);
    }

    TextToSpeechICSMR1() {
    }
}
