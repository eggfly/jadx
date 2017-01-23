package com.igexin.push.core.p180c;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.util.C3926e;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushService;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.igexin.push.core.c.h */
public class C3844h implements Runnable {
    private Context f12893a;
    private C3826f f12894b;
    private boolean f12895c;
    private int f12896d;

    public C3844h(Context context, C3826f c3826f, boolean z) {
        this.f12893a = context;
        this.f12894b = c3826f;
        this.f12895c = z;
    }

    protected boolean m15822a(String str, String str2, String str3) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        IllegalArgumentException illegalArgumentException;
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception exception;
        HttpURLConnection httpURLConnection2 = null;
        if (TextUtils.isEmpty(str2)) {
            C3688a.m15097b("HttpExtensionDownload | downLoad ext name is invalid name = " + str2);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            this.f12896d = 3;
            C3777e.m15491a().m15547c("url is invalid");
            C3688a.m15097b("HttpExtensionDownload | downLoad ext url is invalid, url = " + str);
            return false;
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            Process.setThreadPriority(10);
            InputStream inputStream2 = null;
            FileOutputStream fileOutputStream2 = null;
            InputStream inputStream3;
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    if (httpURLConnection3.getResponseCode() != Constants.COMMAND_HANDSHAKE) {
                        this.f12896d++;
                        if (null != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e) {
                            }
                        }
                        if (null != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        return false;
                    }
                    inputStream3 = httpURLConnection3.getInputStream();
                    try {
                        String str4 = C3855g.ac + "/" + str2;
                        File file = new File(str4);
                        fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                            while (true) {
                                int read = inputStream3.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            if (C3700a.m15131a(this.f12893a, str4).equals(str3)) {
                                File file2 = new File(C3855g.ac + "/" + this.f12894b.m15719c());
                                file.renameTo(file2);
                                if (this.f12894b.m15727g() || this.f12894b.m15728h() != 0) {
                                    C3688a.m15097b("HttpExtensionDownload | downLoadFile success do not copy ext to local tmp name = " + this.f12894b.m15719c());
                                } else {
                                    File file3 = new File(C3855g.ab + "/" + this.f12894b.m15719c());
                                    if (!file3.exists()) {
                                        C3688a.m15097b("HttpExtensionDownload | downLoadFile success cope ext to local tmp name = " + this.f12894b.m15719c());
                                        C3926e.m16161a(file2, file3, this.f12894b.m15725f());
                                    } else if (!C3700a.m15131a(C3855g.f12969g, file3.getAbsolutePath()).equals(this.f12894b.m15725f())) {
                                        file3.delete();
                                        C3926e.m16161a(file2, file3, this.f12894b.m15725f());
                                        C3688a.m15097b("HttpExtensionDownload | downLoadFile success delete local tmp and copy ext name = " + this.f12894b.m15719c());
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                return true;
                            }
                            C3688a.m15097b("HttpExtensionDownload | download ext failed CheckSum error name = " + this.f12894b.m15719c());
                            if (file.exists()) {
                                file.delete();
                            }
                            this.f12896d = 4;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e5) {
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e6) {
                                }
                            }
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                            return false;
                        } catch (IllegalArgumentException e7) {
                            inputStream = inputStream3;
                            FileOutputStream fileOutputStream3 = fileOutputStream2;
                            httpURLConnection = httpURLConnection3;
                            illegalArgumentException = e7;
                            fileOutputStream = fileOutputStream3;
                            try {
                                this.f12896d = 3;
                                C3777e.m15491a().m15547c(illegalArgumentException.toString());
                                C3688a.m15097b("HttpExtensionDownload | " + illegalArgumentException.toString());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream3 = inputStream;
                                httpURLConnection2 = httpURLConnection;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e11) {
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (Exception e12) {
                            httpURLConnection2 = httpURLConnection3;
                            exception = e12;
                            try {
                                this.f12896d++;
                                C3688a.m15097b("HttpExtensionDownload" + exception.toString());
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e13) {
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e14) {
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            httpURLConnection2 = httpURLConnection3;
                            th = th4;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (IllegalArgumentException e72) {
                        httpURLConnection = httpURLConnection3;
                        illegalArgumentException = e72;
                        fileOutputStream = null;
                        inputStream = inputStream3;
                        this.f12896d = 3;
                        C3777e.m15491a().m15547c(illegalArgumentException.toString());
                        C3688a.m15097b("HttpExtensionDownload | " + illegalArgumentException.toString());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    } catch (Exception e122) {
                        fileOutputStream2 = null;
                        httpURLConnection2 = httpURLConnection3;
                        exception = e122;
                        this.f12896d++;
                        C3688a.m15097b("HttpExtensionDownload" + exception.toString());
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return false;
                    } catch (Throwable th42) {
                        fileOutputStream2 = null;
                        httpURLConnection2 = httpURLConnection3;
                        th = th42;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (IllegalArgumentException e722) {
                    httpURLConnection = httpURLConnection3;
                    illegalArgumentException = e722;
                    fileOutputStream = null;
                    this.f12896d = 3;
                    C3777e.m15491a().m15547c(illegalArgumentException.toString());
                    C3688a.m15097b("HttpExtensionDownload | " + illegalArgumentException.toString());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                } catch (Exception e1222) {
                    fileOutputStream2 = null;
                    inputStream3 = null;
                    httpURLConnection2 = httpURLConnection3;
                    exception = e1222;
                    this.f12896d++;
                    C3688a.m15097b("HttpExtensionDownload" + exception.toString());
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return false;
                } catch (Throwable th422) {
                    fileOutputStream2 = null;
                    inputStream3 = null;
                    httpURLConnection2 = httpURLConnection3;
                    th = th422;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (IllegalArgumentException e15) {
                illegalArgumentException = e15;
                fileOutputStream = null;
                httpURLConnection = null;
                this.f12896d = 3;
                C3777e.m15491a().m15547c(illegalArgumentException.toString());
                C3688a.m15097b("HttpExtensionDownload | " + illegalArgumentException.toString());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Exception e16) {
                exception = e16;
                fileOutputStream2 = null;
                inputStream3 = null;
                this.f12896d++;
                C3688a.m15097b("HttpExtensionDownload" + exception.toString());
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream2 = null;
                inputStream3 = null;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } else {
            this.f12896d = 3;
            C3777e.m15491a().m15547c("httpUrl : " + str + " is invalid ...");
            C3688a.m15097b("HttpExtensionDownload | downLoad ext url is invalid url = " + str);
            return false;
        }
    }

    public void run() {
        Intent intent;
        do {
            C3688a.m15097b("HttpExtensionDownload | downloading " + this.f12894b.m15719c() + ".tmp");
            if (m15822a(this.f12894b.m15723e(), this.f12894b.m15719c() + ".tmp", this.f12894b.m15725f())) {
                C3688a.m15097b("HttpExtensionDownload | download " + this.f12894b.m15719c() + ".tmp, success ########");
                intent = new Intent(this.f12893a, PushService.class);
                intent.putExtra(PushConsts.CMD_ACTION, "com.igexin.sdk.action.extdownloadsuccess");
                intent.putExtra(AgooConstants.MESSAGE_ID, this.f12894b.m15711a());
                intent.putExtra("result", true);
                intent.putExtra("isReload", this.f12895c);
                this.f12893a.startService(intent);
                return;
            }
            C3688a.m15097b("HttpExtensionDownload | download ext = " + this.f12894b.m15719c() + ", downloadFailedTimes = " + this.f12896d);
        } while (this.f12896d < 3);
        intent = new Intent(this.f12893a, PushService.class);
        intent.putExtra(PushConsts.CMD_ACTION, "com.igexin.sdk.action.extdownloadsuccess");
        intent.putExtra(AgooConstants.MESSAGE_ID, this.f12894b.m15711a());
        intent.putExtra("result", false);
        this.f12893a.startService(intent);
    }
}
