package com.miui.support.media;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.miui.support.internal.variable.Android_Media_AudioRecord_class;
import com.miui.support.internal.variable.Android_Media_AudioRecord_class.Factory;
import com.miui.support.media.Recorder.OnErrorListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

class LocalWavRecorder implements Recorder {
    private static final Android_Media_AudioRecord_class f3344a;
    private final int f3345b;
    private final int f3346c;
    private final int f3347d;
    private int f3348e;
    private int f3349f;
    private String f3350g;
    private File f3351h;
    private int f3352i;
    private int f3353j;
    private long f3354k;
    private long f3355l;
    private long f3356m;
    private short[] f3357n;
    private DataOutputStream f3358o;
    private AudioRecord f3359p;
    private int f3360q;
    private OnErrorListener f3361r;
    private Handler f3362s;

    private class EventHandler extends Handler {
        final /* synthetic */ LocalWavRecorder f3342a;

        public EventHandler(LocalWavRecorder localWavRecorder, Looper looper) {
            this.f3342a = localWavRecorder;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1 && this.f3342a.f3361r != null) {
                this.f3342a.f3361r.m5047a(this.f3342a, RecorderUtils.m5048a(message.arg1, false));
            }
            super.handleMessage(message);
        }
    }

    private class RecordingThread extends Thread {
        final /* synthetic */ LocalWavRecorder f3343a;

        public void run() {
            Process.setThreadPriority(-19);
            Log.v("WavRecorder", "RecordingThread started");
            if (this.f3343a.f3360q != 2) {
                Log.e("WavRecorder", "Error illegal state: " + this.f3343a.f3360q);
                this.f3343a.m5031a(1001);
            } else if (this.f3343a.f3358o == null) {
                Log.e("WavRecorder", "Error out put stream not ready");
                this.f3343a.m5031a(1002);
            } else {
                while (this.f3343a.f3360q == 2) {
                    int read = this.f3343a.f3359p.read(this.f3343a.f3357n, 0, this.f3343a.f3357n.length);
                    this.f3343a.f3355l = this.f3343a.f3355l + ((long) read);
                    if (read <= 0) {
                        Log.e("WavRecorder", "Error record sample failed, read size: " + read);
                        this.f3343a.m5031a(1003);
                        break;
                    }
                    this.f3343a.f3353j = this.f3343a.m5029a(this.f3343a.f3357n, read);
                    if (!this.f3343a.f3351h.exists()) {
                        this.f3343a.m5031a(1009);
                        break;
                    }
                    try {
                        this.f3343a.f3358o.write(RecorderUtils.m5049a(this.f3343a.f3357n, read));
                        this.f3343a.f3356m = this.f3343a.f3356m + ((long) (read * 2));
                        if (this.f3343a.f3356m >= this.f3343a.f3354k) {
                            this.f3343a.m5031a(1007);
                            break;
                        }
                    } catch (IOException e) {
                        Log.e("WavRecorder", "Error when write sample to file: " + this.f3343a.f3350g);
                        this.f3343a.m5031a(1005);
                    }
                }
                this.f3343a.f3353j = 0;
                Log.v("WavRecorder", "RecordingThread stoped");
            }
        }
    }

    static {
        f3344a = Factory.getInstance().get();
    }

    public LocalWavRecorder() {
        this.f3345b = 44;
        this.f3346c = 4;
        this.f3347d = 40;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.f3362s = new EventHandler(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.f3362s = new EventHandler(this, myLooper);
            } else {
                Log.e("WavRecorder", "Could not create event handler");
                this.f3362s = null;
            }
        }
        m5044a();
    }

    public void m5044a() {
        this.f3360q = 0;
        this.f3359p = null;
        this.f3348e = 1;
        this.f3349f = 44100;
        this.f3352i = 16;
        this.f3360q = 0;
        this.f3355l = 0;
        this.f3356m = 0;
        this.f3354k = Long.MAX_VALUE;
    }

    private int m5029a(short[] sArr, int i) {
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

    private void m5031a(int i) {
        if (this.f3362s != null) {
            this.f3362s.sendMessage(this.f3362s.obtainMessage(1, i, 0));
        }
    }
}
