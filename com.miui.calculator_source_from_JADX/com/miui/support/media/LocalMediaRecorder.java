package com.miui.support.media;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.miui.support.media.Recorder.OnErrorListener;
import com.miui.support.reflect.Method;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class LocalMediaRecorder implements Recorder {
    private static final Method f3297c;
    private Object f3298a;
    private MediaRecorder f3299b;
    private String f3300d;
    private int f3301e;
    private int f3302f;
    private int f3303g;
    private int f3304h;
    private int f3305i;
    private long f3306j;
    private int f3307k;
    private long f3308l;
    private int f3309m;
    private OnErrorListener f3310n;
    private long f3311o;

    /* renamed from: com.miui.support.media.LocalMediaRecorder.1 */
    class C04011 implements MediaRecorder.OnErrorListener {
        final /* synthetic */ LocalMediaRecorder f3313a;

        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            this.f3313a.f3310n.m5047a(this.f3313a, RecorderUtils.m5048a(i, true));
        }
    }

    /* renamed from: com.miui.support.media.LocalMediaRecorder.2 */
    class C04022 implements OnInfoListener {
        final /* synthetic */ LocalMediaRecorder f3314a;

        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
            this.f3314a.f3310n.m5047a(this.f3314a, RecorderUtils.m5048a(i, true));
        }
    }

    private class RecorderAppendThread extends Thread {
        final /* synthetic */ LocalMediaRecorder f3315a;
        private ParcelFileDescriptor f3316b;
        private AtomicBoolean f3317c;

        public void run() {
            InputStream fileInputStream;
            Throwable e;
            InputStream inputStream = null;
            int i = 0;
            if (this.f3315a.m4997a()) {
                this.f3317c = new AtomicBoolean(true);
                byte[] bArr = new byte[1024];
                OutputStream fileOutputStream;
                try {
                    fileInputStream = new FileInputStream(this.f3316b.getFileDescriptor());
                    try {
                        fileOutputStream = new FileOutputStream(this.f3315a.f3300d, true);
                        try {
                            int b = this.f3315a.m4998b();
                            while (b - i > 0) {
                                i = fileInputStream.read(bArr, 0, b);
                                b -= i;
                            }
                            while (true) {
                                i = fileInputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e2) {
                                    Log.e("Media:LocalMediaRecorder", "IOException", e2);
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f3316b.close();
                            synchronized (this.f3317c) {
                                this.f3317c.set(false);
                                this.f3317c.notify();
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            inputStream = fileInputStream;
                            try {
                                Log.e("Media:LocalMediaRecorder", "IOException", e2);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e22) {
                                        Log.e("Media:LocalMediaRecorder", "IOException", e22);
                                        synchronized (this.f3317c) {
                                            this.f3317c.set(false);
                                            this.f3317c.notify();
                                        }
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                this.f3316b.close();
                                synchronized (this.f3317c) {
                                    this.f3317c.set(false);
                                    this.f3317c.notify();
                                }
                            } catch (Throwable th) {
                                e22 = th;
                                fileInputStream = inputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e4) {
                                        Log.e("Media:LocalMediaRecorder", "IOException", e4);
                                        synchronized (this.f3317c) {
                                            this.f3317c.set(false);
                                            this.f3317c.notify();
                                        }
                                        throw e22;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                this.f3316b.close();
                                synchronized (this.f3317c) {
                                    this.f3317c.set(false);
                                    this.f3317c.notify();
                                }
                                throw e22;
                            }
                        } catch (Throwable th2) {
                            e22 = th2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f3316b.close();
                            synchronized (this.f3317c) {
                                this.f3317c.set(false);
                                this.f3317c.notify();
                            }
                            throw e22;
                        }
                    } catch (IOException e5) {
                        e22 = e5;
                        fileOutputStream = null;
                        inputStream = fileInputStream;
                        Log.e("Media:LocalMediaRecorder", "IOException", e22);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        this.f3316b.close();
                        synchronized (this.f3317c) {
                            this.f3317c.set(false);
                            this.f3317c.notify();
                        }
                    } catch (Throwable th3) {
                        e22 = th3;
                        fileOutputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        this.f3316b.close();
                        synchronized (this.f3317c) {
                            this.f3317c.set(false);
                            this.f3317c.notify();
                        }
                        throw e22;
                    }
                } catch (IOException e6) {
                    e22 = e6;
                    fileOutputStream = null;
                    Log.e("Media:LocalMediaRecorder", "IOException", e22);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    this.f3316b.close();
                    synchronized (this.f3317c) {
                        this.f3317c.set(false);
                        this.f3317c.notify();
                    }
                } catch (Throwable th4) {
                    e22 = th4;
                    fileOutputStream = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    this.f3316b.close();
                    synchronized (this.f3317c) {
                        this.f3317c.set(false);
                        this.f3317c.notify();
                    }
                    throw e22;
                }
            }
        }
    }

    static {
        Method method = null;
        try {
            method = Method.of(MediaRecorder.class, "setParameter", "(Ljava/lang/String;)V");
        } catch (Throwable e) {
            Log.e("Media:LocalMediaRecorder", "Could not get method:setParameter", e);
        }
        f3297c = method;
    }

    public LocalMediaRecorder() {
        this.f3298a = new Object();
        this.f3301e = -1;
        this.f3302f = -1;
        this.f3303g = -1;
        this.f3304h = -1;
        this.f3305i = -1;
        this.f3306j = -1;
        this.f3307k = -1;
        this.f3308l = 0;
        this.f3309m = -1;
        this.f3311o = 0;
        this.f3299b = new MediaRecorder();
    }

    public boolean m4997a() {
        synchronized (this.f3298a) {
        }
        return false;
    }

    protected int m4998b() {
        return 0;
    }
}
