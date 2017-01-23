package com.miui.support.media;

import com.miui.support.media.Mp3Recorder.RecordingErrorListener;
import com.miui.support.media.Recorder.OnErrorListener;

class LocalMp3Recorder extends Mp3Recorder implements Recorder {
    private OnErrorListener f3341a;

    /* renamed from: com.miui.support.media.LocalMp3Recorder.1 */
    class C04031 implements RecordingErrorListener {
        final /* synthetic */ LocalMp3Recorder f3318a;

        public void m5003a(Mp3Recorder mp3Recorder, int i) {
            this.f3318a.f3341a.m5047a(this.f3318a, RecorderUtils.m5048a(i, false));
        }
    }

    LocalMp3Recorder() {
    }
}
