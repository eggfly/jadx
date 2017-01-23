package com.baidu.mobads.openad.p088c;

import android.content.Context;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p080j.C1991m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* renamed from: com.baidu.mobads.openad.c.f */
public class C1928f extends Observable implements IOAdDownloader, Runnable {
    protected Context f6758a;
    protected URL f6759b;
    protected String f6760c;
    protected String f6761d;
    protected int f6762e;
    protected DownloadStatus f6763f;
    protected int f6764g;
    protected int f6765h;
    private boolean f6766i;

    protected C1928f(Context context, URL url, String str, String str2, boolean z) {
        this.f6766i = false;
        this.f6758a = context;
        this.f6759b = url;
        this.f6760c = str;
        this.f6766i = z;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f6761d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f6761d = str2;
        }
        this.f6762e = -1;
        this.f6763f = DownloadStatus.DOWNLOADING;
        this.f6764g = 0;
        this.f6765h = 0;
    }

    private void m7265d() {
        m7268a(DownloadStatus.ERROR);
    }

    protected void m7266a() {
        C1991m.m7449a().m7462k().renameFile(this.f6760c + this.f6761d + ".tmp", this.f6760c + this.f6761d);
    }

    protected void m7267a(int i, float f) {
        this.f6764g += i;
        m7270c();
    }

    protected void m7268a(DownloadStatus downloadStatus) {
        this.f6763f = downloadStatus;
        m7270c();
    }

    protected void m7269b() {
        new Thread(this).start();
    }

    protected void m7270c() {
        setChanged();
        notifyObservers();
    }

    @Deprecated
    public void cancel() {
    }

    public int getFileSize() {
        return this.f6762e;
    }

    public String getOutputPath() {
        return this.f6760c + this.f6761d;
    }

    @Deprecated
    public String getPackageName() {
        return null;
    }

    public float getProgress() {
        return Math.abs((((float) this.f6764g) / ((float) this.f6762e)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.f6763f;
    }

    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Deprecated
    public String getTitle() {
        return null;
    }

    public String getURL() {
        return this.f6759b.toString();
    }

    @Deprecated
    public void pause() {
    }

    public void removeObservers() {
    }

    @Deprecated
    public void resume() {
    }

    public void run() {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        HttpURLConnection httpURLConnection;
        Exception exception;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        BufferedOutputStream bufferedOutputStream2;
        Throwable th2;
        Exception exception2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.f6759b.openConnection();
            try {
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.connect();
                if (httpURLConnection3.getResponseCode() / 100 != 2) {
                    m7265d();
                }
                int contentLength = httpURLConnection3.getContentLength();
                if (contentLength > 0) {
                    this.f6762e = contentLength;
                }
                File file = new File(this.f6760c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
            } catch (Exception e) {
                bufferedInputStream2 = null;
                httpURLConnection = httpURLConnection3;
                exception = e;
                bufferedOutputStream = null;
                try {
                    C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", exception.getMessage());
                    m7265d();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e2.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e22.getMessage());
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e222) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e222.getMessage());
                        }
                    }
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
                    httpURLConnection2 = httpURLConnection;
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e3) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e3.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e4.getMessage());
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e42) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e42.getMessage());
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                bufferedOutputStream2 = null;
                bufferedInputStream = null;
                th2 = th4;
                httpURLConnection2 = httpURLConnection3;
                th = th2;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
            try {
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
                try {
                    byte[] bArr = new byte[10240];
                    ByteArrayOutputStream byteArrayOutputStream2 = this.f6766i ? new ByteArrayOutputStream() : null;
                    int i = 0;
                    while (this.f6763f == DownloadStatus.DOWNLOADING) {
                        try {
                            int read = bufferedInputStream.read(bArr, 0, 10240);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream2.write(bArr, 0, read);
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            i += read;
                            m7267a(read, ((float) i) / ((float) this.f6762e));
                        } catch (Exception e5) {
                            exception2 = e5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream2 = bufferedInputStream;
                            httpURLConnection = httpURLConnection3;
                            exception = exception2;
                        } catch (Throwable th5) {
                            th2 = th5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            httpURLConnection2 = httpURLConnection3;
                            th = th2;
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (this.f6763f == DownloadStatus.DOWNLOADING) {
                        m7266a();
                        m7268a(DownloadStatus.COMPLETED);
                    } else if (this.f6763f == DownloadStatus.ERROR) {
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e422) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e422.getMessage());
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e6) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e6.getMessage());
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e62) {
                            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", e62.getMessage());
                        }
                    }
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Exception e7) {
                    exception2 = e7;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream2 = bufferedInputStream;
                    httpURLConnection = httpURLConnection3;
                    exception = exception2;
                    C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", exception.getMessage());
                    m7265d();
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th42) {
                    th2 = th42;
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e72) {
                bufferedInputStream2 = bufferedInputStream;
                httpURLConnection = httpURLConnection3;
                exception = e72;
                bufferedOutputStream = null;
                C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", exception.getMessage());
                m7265d();
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th422) {
                bufferedOutputStream2 = null;
                th2 = th422;
                httpURLConnection2 = httpURLConnection3;
                th = th2;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e8) {
            exception = e8;
            bufferedOutputStream = null;
            bufferedInputStream2 = null;
            httpURLConnection = null;
            C1991m.m7449a().m7457f().m7400e("OAdSimpleFileDownloader", exception.getMessage());
            m7265d();
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = null;
            bufferedInputStream = null;
            httpURLConnection2 = null;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public void start() {
        m7268a(DownloadStatus.DOWNLOADING);
        m7269b();
    }
}
