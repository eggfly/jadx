package com.igexin.push.p169f.p179a;

import android.os.Process;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.util.EncryptUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

/* renamed from: com.igexin.push.f.a.c */
public class C3913c extends C3666d {
    public C3836b f13172a;
    private HttpURLConnection f13173b;

    public C3913c(C3836b c3836b) {
        super(0);
        this.f13172a = c3836b;
    }

    private C3914d m16095a(String str) {
        C3914d b;
        try {
            this.f13173b = m16102b(str);
            byte[] a = m16099a(this.f13173b);
            if (a != null) {
                b = m16101b(this.f13173b, a);
                return b;
            }
            m16104g();
            return new C3914d(this, false, null);
        } catch (Throwable th) {
            b = th;
        } finally {
            m16104g();
        }
    }

    private C3914d m16096a(String str, byte[] bArr) {
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2 = null;
        DataOutputStream dataOutputStream3 = null;
        try {
            this.f13173b = m16103b(str, bArr);
            byte[] a = m16100a(bArr, this.f13173b);
            C3914d c3914d;
            if (a == null) {
                c3914d = new C3914d(this, true, null);
                if (null != null) {
                    try {
                        dataOutputStream3.close();
                    } catch (Exception e) {
                    }
                }
                m16104g();
                return c3914d;
            }
            this.f13173b.connect();
            dataOutputStream3 = new DataOutputStream(this.f13173b.getOutputStream());
            try {
                dataOutputStream3.write(a, 0, a.length);
                dataOutputStream3.flush();
                a = m16099a(this.f13173b);
                if (a != null) {
                    c3914d = m16101b(this.f13173b, a);
                    if (dataOutputStream3 != null) {
                        try {
                            dataOutputStream3.close();
                        } catch (Exception e2) {
                        }
                    }
                    m16104g();
                    return c3914d;
                }
                if (dataOutputStream3 != null) {
                    try {
                        dataOutputStream3.close();
                    } catch (Exception e3) {
                    }
                }
                m16104g();
                return new C3914d(this, false, null);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream3;
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                m16104g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
            m16104g();
            throw th;
        }
    }

    private void m16097a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (httpURLConnection != null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                bArr = bArr2;
            }
            httpURLConnection.addRequestProperty("GT_C_T", String.valueOf(1));
            httpURLConnection.addRequestProperty("GT_C_K", new String(EncryptUtils.getRSAKeyId()));
            httpURLConnection.addRequestProperty("GT_C_V", EncryptUtils.getHttpGTCV());
            String valueOf = String.valueOf(System.currentTimeMillis());
            String httpSignature = EncryptUtils.getHttpSignature(valueOf, bArr);
            httpURLConnection.addRequestProperty("GT_T", valueOf);
            httpURLConnection.addRequestProperty("GT_C_S", httpSignature);
        }
    }

    private void m16098a(byte[] bArr) {
        this.f13172a.m15798a(bArr);
        C3685c.m15060b().m15055a((Object) this.f13172a);
        C3685c.m15060b().m15070c();
    }

    private byte[] m16099a(HttpURLConnection httpURLConnection) {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (httpURLConnection.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                    bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
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
                        } catch (Exception e2) {
                        }
                    }
                } else if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return bArr;
            } catch (Exception e4) {
                e = e4;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Exception e5) {
            Exception exception = e5;
            inputStream = null;
            e = exception;
            throw e;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            inputStream = null;
            th = th4;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                }
            }
            throw th;
        }
    }

    private byte[] m16100a(byte[] bArr, HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getRequestProperties().containsKey("GT_C_S")) {
                String requestProperty = httpURLConnection.getRequestProperty("GT_C_S");
                if (requestProperty != null) {
                    return EncryptUtils.aesEncHttp(bArr, EncryptUtils.md5(requestProperty.getBytes()));
                }
            }
        } catch (Throwable th) {
            C3688a.m15097b("_HttpTask|" + th.toString());
        }
        return null;
    }

    private C3914d m16101b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            String headerField = httpURLConnection.getHeaderField("GT_ERR");
            C3688a.m15097b("_HttpTask|GT_ERR = " + headerField);
            if (headerField == null || !headerField.equals(MessageService.MSG_DB_READY_REPORT)) {
                return new C3914d(this, true, null);
            }
            headerField = httpURLConnection.getHeaderField("GT_T");
            if (headerField == null) {
                C3688a.m15097b("_HttpTask|GT_T = null");
                return new C3914d(this, true, null);
            }
            String headerField2 = httpURLConnection.getHeaderField("GT_C_S");
            if (headerField2 == null) {
                C3688a.m15097b("_HttpTask|GT_C_S = null");
                return new C3914d(this, true, null);
            }
            byte[] aesDecHttp = EncryptUtils.aesDecHttp(bArr, EncryptUtils.md5(headerField.getBytes()));
            headerField = EncryptUtils.getHttpSignature(headerField, aesDecHttp);
            if (headerField != null && headerField.equals(headerField2)) {
                return new C3914d(this, false, aesDecHttp);
            }
            C3688a.m15097b("_HttpTask|signature = null or error");
            return new C3914d(this, true, null);
        } catch (Throwable th) {
            C3688a.m15097b("_HttpTask|" + th.toString());
            return new C3914d(this, true, null);
        }
    }

    private HttpURLConnection m16102b(String str) {
        this.f13173b = (HttpURLConnection) new URL(str).openConnection();
        this.f13173b.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        this.f13173b.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        this.f13173b.setRequestMethod(SpdyRequest.GET_METHOD);
        this.f13173b.setDoInput(true);
        m16097a(this.f13173b, null);
        return this.f13173b;
    }

    private HttpURLConnection m16103b(String str, byte[] bArr) {
        this.f13173b = (HttpURLConnection) new URL(str).openConnection();
        this.f13173b.setDoInput(true);
        this.f13173b.setDoOutput(true);
        this.f13173b.setRequestMethod(SpdyRequest.POST_METHOD);
        this.f13173b.setUseCaches(false);
        this.f13173b.setInstanceFollowRedirects(true);
        this.f13173b.setRequestProperty(MIME.CONTENT_TYPE, "application/octet-stream");
        this.f13173b.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        this.f13173b.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        m16097a(this.f13173b, bArr);
        return this.f13173b;
    }

    private void m16104g() {
        if (this.f13173b != null) {
            try {
                this.f13173b.disconnect();
                this.f13173b = null;
            } catch (Exception e) {
            }
        }
    }

    public final void a_() {
        super.a_();
        Process.setThreadPriority(10);
        if (this.f13172a != null && this.f13172a.f12878b != null) {
            if (this.f13172a.f12879c != null && this.f13172a.f12879c.length > 0) {
                this.f13172a.f12879c = C3687f.m15090c(this.f13172a.f12879c);
            }
            int i = 0;
            while (i < 3) {
                C3914d a = this.f13172a.f12879c == null ? m16095a(this.f13172a.f12878b) : m16096a(this.f13172a.f12878b, this.f13172a.f12879c);
                if (a.f13174a) {
                    throw new Exception("http server resp decode header error");
                } else if (a.f13175b != null) {
                    m16098a(a.f13175b);
                    return;
                } else if (i == 2) {
                    this.f13172a.m15797a(new Exception("try up to limit"));
                    throw new Exception("http request exception, try times = " + (i + 1));
                } else {
                    i++;
                }
            }
        }
    }

    public final int m16105b() {
        return -2147483638;
    }

    public void m16106d() {
        this.n = true;
    }

    protected void m16107e() {
    }

    public void m16108f() {
        super.m14963f();
        m16104g();
    }
}
