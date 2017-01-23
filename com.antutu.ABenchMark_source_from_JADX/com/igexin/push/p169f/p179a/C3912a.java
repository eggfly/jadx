package com.igexin.push.p169f.p179a;

import android.os.Process;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

/* renamed from: com.igexin.push.f.a.a */
public class C3912a extends C3666d {
    public static final String f13169a;
    public C3836b f13170b;
    private HttpURLConnection f13171c;

    static {
        f13169a = C3912a.class.getName();
    }

    public C3912a(C3836b c3836b) {
        super(0);
        this.f13170b = c3836b;
    }

    private byte[] m16088a(String str) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            this.f13171c = (HttpURLConnection) new URL(str).openConnection();
            this.f13171c.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            this.f13171c.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            this.f13171c.setRequestMethod(SpdyRequest.GET_METHOD);
            this.f13171c.setDoInput(true);
            inputStream = this.f13171c.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e) {
                byteArrayOutputStream2 = null;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e2) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e3) {
                    }
                }
                m16090g();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception e5) {
                    }
                }
                m16090g();
                throw th;
            }
            try {
                if (this.f13171c.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                    byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    m16090g();
                    return bArr;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e8) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e9) {
                    }
                }
                m16090g();
                return null;
            } catch (Exception e10) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                m16090g();
                return null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream3 = byteArrayOutputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream3 != null) {
                    byteArrayOutputStream3.close();
                }
                m16090g();
                throw th;
            }
        } catch (Exception e11) {
            byteArrayOutputStream2 = null;
            inputStream2 = null;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            m16090g();
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.close();
            }
            m16090g();
            throw th;
        }
    }

    private byte[] m16089a(String str, byte[] bArr) {
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            this.f13171c = (HttpURLConnection) new URL(str).openConnection();
            this.f13171c.setDoInput(true);
            this.f13171c.setDoOutput(true);
            this.f13171c.setRequestMethod(SpdyRequest.POST_METHOD);
            this.f13171c.setUseCaches(false);
            this.f13171c.setInstanceFollowRedirects(true);
            this.f13171c.setRequestProperty(MIME.CONTENT_TYPE, "application/octet-stream");
            this.f13171c.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            this.f13171c.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            this.f13171c.connect();
            dataOutputStream = new DataOutputStream(this.f13171c.getOutputStream());
            try {
                dataOutputStream.write(bArr, 0, bArr.length);
                dataOutputStream.flush();
                if (this.f13171c.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                    inputStream = this.f13171c.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream4.write(bArr2, 0, read);
                            }
                            bArr2 = byteArrayOutputStream4.toByteArray();
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                }
                            }
                            if (byteArrayOutputStream4 != null) {
                                try {
                                    byteArrayOutputStream4.close();
                                } catch (Exception e3) {
                                }
                            }
                            m16090g();
                            return bArr2;
                        } catch (Exception e4) {
                            byteArrayOutputStream = byteArrayOutputStream4;
                            inputStream2 = inputStream;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e6) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e7) {
                                }
                            }
                            m16090g();
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream2 = byteArrayOutputStream4;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e8) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e9) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e10) {
                                }
                            }
                            m16090g();
                            throw th;
                        }
                    } catch (Exception e11) {
                        byteArrayOutputStream = null;
                        inputStream2 = inputStream;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                            dataOutputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        m16090g();
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        m16090g();
                        throw th;
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e12) {
                    }
                }
                if (null != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e13) {
                    }
                }
                if (null != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception e14) {
                    }
                }
                m16090g();
                return null;
            } catch (Exception e15) {
                byteArrayOutputStream = null;
                inputStream2 = null;
                dataOutputStream2 = dataOutputStream;
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                m16090g();
                return null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                m16090g();
                throw th;
            }
        } catch (Exception e16) {
            byteArrayOutputStream = null;
            inputStream2 = null;
            dataOutputStream2 = null;
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            m16090g();
            return null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            dataOutputStream = null;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            m16090g();
            throw th;
        }
    }

    private void m16090g() {
        if (this.f13171c != null) {
            try {
                this.f13171c.disconnect();
                this.f13171c = null;
            } catch (Exception e) {
            }
        }
    }

    public final void a_() {
        Exception e;
        super.a_();
        Process.setThreadPriority(10);
        if (this.f13170b != null && this.f13170b.f12878b != null) {
            try {
                byte[] a = this.f13170b.f12879c == null ? m16088a(this.f13170b.f12878b) : m16089a(this.f13170b.f12878b, this.f13170b.f12879c);
                if (a != null) {
                    try {
                        this.f13170b.m15798a(a);
                        C3685c.m15060b().m15055a((Object) this.f13170b);
                        C3685c.m15060b().m15070c();
                        return;
                    } catch (Exception e2) {
                        this.f13170b.m15797a(e2);
                        throw e2;
                    }
                }
                e2 = new Exception("Http response \uff1d\uff1d null");
                this.f13170b.m15797a(e2);
                throw e2;
            } catch (Exception e22) {
                this.f13170b.m15797a(e22);
                throw e22;
            }
        }
    }

    public final int m16091b() {
        return -2147483639;
    }

    public void m16092d() {
        this.n = true;
    }

    protected void m16093e() {
    }

    public void m16094f() {
        super.m14963f();
        m16090g();
    }
}
