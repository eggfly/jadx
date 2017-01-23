package com.miui.support.media;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.variable.Android_Media_AudioRecord_class;
import com.miui.support.internal.variable.Android_Media_AudioRecord_class.Factory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mp3Recorder {
    private static final Android_Media_AudioRecord_class f3319a;
    private int f3320b;
    private int f3321c;
    private String f3322d;
    private File f3323e;
    private int f3324f;
    private int f3325g;
    private int f3326h;
    private int f3327i;
    private int f3328j;
    private int f3329k;
    private long f3330l;
    private long f3331m;
    private long f3332n;
    private short[] f3333o;
    private byte[] f3334p;
    private FileOutputStream f3335q;
    private AudioRecord f3336r;
    private Mp3Encoder f3337s;
    private int f3338t;
    private RecordingErrorListener f3339u;
    private Handler f3340v;

    public interface RecordingErrorListener {
        void m5002a(Mp3Recorder mp3Recorder, int i);
    }

    private class EventHandler extends Handler {
        final /* synthetic */ Mp3Recorder f3371a;

        public EventHandler(Mp3Recorder mp3Recorder, Looper looper) {
            this.f3371a = mp3Recorder;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f3371a.f3339u != null) {
                        this.f3371a.f3339u.m5002a(this.f3371a, message.arg1);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }

    private class RecordingThread extends Thread {
        final /* synthetic */ Mp3Recorder f3372a;

        public void run() {
            Process.setThreadPriority(-19);
            Log.v("Mp3Recorder", "RecordingThread started");
            if (this.f3372a.f3338t != 2) {
                Log.e("Mp3Recorder", "Error illegal state: " + this.f3372a.f3338t);
                this.f3372a.m5008a(1);
            } else if (this.f3372a.f3335q == null) {
                Log.e("Mp3Recorder", "Error out put stream not ready");
                this.f3372a.m5008a(2);
            } else {
                while (this.f3372a.f3338t == 2) {
                    int read = this.f3372a.f3336r.read(this.f3372a.f3333o, 0, this.f3372a.f3333o.length);
                    this.f3372a.f3330l = this.f3372a.f3330l + ((long) read);
                    if (read <= 0) {
                        Log.e("Mp3Recorder", "Error record sample failed, read size: " + read);
                        this.f3372a.m5008a(3);
                        break;
                    }
                    int a;
                    this.f3372a.f3326h = this.f3372a.m5006a(this.f3372a.f3333o, read);
                    if (this.f3372a.f3324f == 16) {
                        a = this.f3372a.f3337s.m5046a(this.f3372a.f3333o, this.f3372a.f3333o, read, this.f3372a.f3334p, this.f3372a.f3334p.length);
                    } else {
                        a = this.f3372a.f3337s.m5045a(this.f3372a.f3333o, read / this.f3372a.f3328j, this.f3372a.f3334p, this.f3372a.f3334p.length);
                    }
                    if (a <= 0) {
                        if (a == 0) {
                            Log.e("Mp3Recorder", "Not a complete frame samples to encode: skiped");
                        } else {
                            Log.e("Mp3Recorder", "Error encode PCM failed, encode size: " + a + " read size: " + read);
                            if (this.f3372a.f3339u != null) {
                                this.f3372a.m5008a(4);
                            }
                        }
                    } else if (!this.f3372a.f3323e.exists()) {
                        this.f3372a.m5008a(8);
                        break;
                    } else {
                        try {
                            this.f3372a.f3335q.write(this.f3372a.f3334p, 0, a);
                            this.f3372a.f3331m = this.f3372a.f3331m + ((long) a);
                            if (this.f3372a.f3331m >= this.f3372a.f3332n) {
                                this.f3372a.m5008a(7);
                                break;
                            }
                        } catch (IOException e) {
                            Log.e("Mp3Recorder", "Error when write sample to file: " + this.f3372a.f3322d);
                            this.f3372a.m5008a(5);
                        }
                    }
                }
                this.f3372a.f3326h = 0;
                Log.v("Mp3Recorder", "RecordingThread stoped");
            }
        }
    }

    static {
        f3319a = Factory.getInstance().get();
    }

    public Mp3Recorder() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.f3340v = new EventHandler(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.f3340v = new EventHandler(this, myLooper);
            } else {
                Log.e("Mp3Recorder", "Could not create event handler");
                this.f3340v = null;
            }
        }
        m5025a();
    }

    public void m5025a() {
        this.f3338t = 0;
        this.f3336r = null;
        this.f3320b = 1;
        this.f3321c = 44100;
        this.f3324f = 16;
        this.f3325g = 0;
        this.f3338t = 0;
        this.f3327i = 64;
        this.f3330l = 0;
        this.f3331m = 0;
        this.f3332n = Long.MAX_VALUE;
        this.f3329k = -1;
        this.f3337s = new Mp3Encoder();
    }

    private int m5006a(short[] sArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = sArr[i2] < (short) 0 ? -sArr[i2] : sArr[i2];
            if (i4 <= i3) {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    private void m5008a(int i) {
        if (this.f3340v != null) {
            Message obtainMessage = this.f3340v.obtainMessage(1);
            obtainMessage.arg1 = i;
            this.f3340v.sendMessage(obtainMessage);
        }
    }
}
