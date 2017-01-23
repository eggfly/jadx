package com.qq.p035e.comm.managers.plugin;

import android.content.Context;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.qq.p035e.comm.constants.Constants.PLUGIN;
import com.qq.p035e.comm.net.NetworkCallBack;
import com.qq.p035e.comm.net.NetworkClient.Priority;
import com.qq.p035e.comm.net.NetworkClientImpl;
import com.qq.p035e.comm.net.rr.PlainRequest;
import com.qq.p035e.comm.net.rr.Request.Method;
import com.qq.p035e.comm.net.rr.Response;
import com.qq.p035e.comm.util.FileUtil;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.Md5Util;
import com.qq.p035e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;

/* renamed from: com.qq.e.comm.managers.plugin.a */
final class C4052a {
    private static final Pattern f13467a;
    private final Context f13468b;

    /* renamed from: com.qq.e.comm.managers.plugin.a.a */
    class C4051a implements NetworkCallBack {
        private final String f13464a;
        private final int f13465b;
        private /* synthetic */ C4052a f13466c;

        public C4051a(C4052a c4052a, String str, int i) {
            this.f13466c = c4052a;
            this.f13464a = str;
            this.f13465b = i;
        }

        private static String m16550a(Response response, File file) {
            InputStream streamContent;
            OutputStream fileOutputStream;
            Throwable e;
            Object obj;
            Throwable th;
            String str = null;
            try {
                MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
                streamContent = response.getStreamContent();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    obj = str;
                    try {
                        GDTLogger.m16601e("IOException While Update Plugin", e);
                        FileUtil.tryClose(streamContent);
                        FileUtil.tryClose(fileOutputStream);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        FileUtil.tryClose(streamContent);
                        FileUtil.tryClose(fileOutputStream);
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    obj = str;
                    GDTLogger.m16601e("MD5SUMException While Update Plugin", e);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return str;
                } catch (Throwable e4) {
                    obj = str;
                    th = e4;
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                    while (true) {
                        int read = streamContent.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                        fileOutputStream.write(bArr, 0, read);
                    }
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    str = Md5Util.byteArrayToHexString(instance.digest());
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                } catch (IOException e5) {
                    e4 = e5;
                    GDTLogger.m16601e("IOException While Update Plugin", e4);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return str;
                } catch (NoSuchAlgorithmException e6) {
                    e4 = e6;
                    GDTLogger.m16601e("MD5SUMException While Update Plugin", e4);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return str;
                }
            } catch (IOException e7) {
                e4 = e7;
                obj = str;
                Object obj2 = str;
                GDTLogger.m16601e("IOException While Update Plugin", e4);
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                return str;
            } catch (NoSuchAlgorithmException e8) {
                e4 = e8;
                fileOutputStream = str;
                streamContent = str;
                GDTLogger.m16601e("MD5SUMException While Update Plugin", e4);
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                return str;
            } catch (Throwable e42) {
                fileOutputStream = str;
                streamContent = str;
                th = e42;
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                throw th;
            }
            return str;
        }

        private boolean m16551a(File file) {
            try {
                StringUtil.writeTo(this.f13465b + "#####" + this.f13464a, file);
                return true;
            } catch (Throwable e) {
                GDTLogger.m16601e("IOException While Update Plugin", e);
                return false;
            }
        }

        public final void onException(Exception exception) {
            GDTLogger.m16604w("Exception While Update Plugin", exception);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onResponse(com.qq.p035e.comm.net.rr.Request r6, com.qq.p035e.comm.net.rr.Response r7) {
            /*
            r5 = this;
            r0 = r7.getStatusCode();
            r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r0 != r1) goto L_0x00ee;
        L_0x0008:
            r0 = r5.f13466c;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.f13468b;	 Catch:{ Throwable -> 0x00a1 }
            r1 = new java.io.File;	 Catch:{ Throwable -> 0x00a1 }
            r2 = "e_qq_com_plugin";
            r3 = 0;
            r0 = r0.getDir(r2, r3);	 Catch:{ Throwable -> 0x00a1 }
            r2 = "gdt_plugin.tmp";
            r1.<init>(r0, r2);	 Catch:{ Throwable -> 0x00a1 }
            r0 = r5.f13466c;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.f13468b;	 Catch:{ Throwable -> 0x00a1 }
            r2 = new java.io.File;	 Catch:{ Throwable -> 0x00a1 }
            r3 = "e_qq_com_plugin";
            r4 = 0;
            r0 = r0.getDir(r3, r4);	 Catch:{ Throwable -> 0x00a1 }
            r3 = "gdt_plugin.tmp.sig";
            r2.<init>(r0, r3);	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.qq.p035e.comm.managers.plugin.C4052a.C4051a.m16550a(r7, r1);	 Catch:{ Throwable -> 0x00a1 }
            r3 = com.qq.p035e.comm.util.C4068a.m16605a();	 Catch:{ Throwable -> 0x00a1 }
            r4 = r5.f13464a;	 Catch:{ Throwable -> 0x00a1 }
            r3 = r3.m16609b(r4, r0);	 Catch:{ Throwable -> 0x00a1 }
            if (r3 == 0) goto L_0x0089;
        L_0x0040:
            r0 = r5.m16551a(r2);	 Catch:{ Throwable -> 0x00a1 }
            if (r0 == 0) goto L_0x0066;
        L_0x0046:
            r0 = r5.f13466c;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.f13468b;	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.qq.p035e.comm.managers.plugin.C4054c.m16555b(r0);	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.qq.p035e.comm.util.FileUtil.renameTo(r1, r0);	 Catch:{ Throwable -> 0x00a1 }
            if (r0 == 0) goto L_0x0066;
        L_0x0056:
            r0 = r5.f13466c;	 Catch:{ Throwable -> 0x00a1 }
            r0 = r0.f13468b;	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.qq.p035e.comm.managers.plugin.C4054c.m16557d(r0);	 Catch:{ Throwable -> 0x00a1 }
            r0 = com.qq.p035e.comm.util.FileUtil.renameTo(r2, r0);	 Catch:{ Throwable -> 0x00a1 }
            if (r0 == 0) goto L_0x0066;
        L_0x0066:
            r0 = new java.lang.StringBuilder;
            r1 = "TIMESTAMP_AFTER_DOWNPLUGIN:";
            r0.<init>(r1);
            r2 = java.lang.System.nanoTime();
            r0 = r0.append(r2);
            r1 = ";sig=";
            r0 = r0.append(r1);
            r1 = r5.f13464a;
            r0 = r0.append(r1);
            r0 = r0.toString();
            com.qq.p035e.comm.util.GDTLogger.m16599d(r0);
        L_0x0088:
            return;
        L_0x0089:
            r1.delete();	 Catch:{ Throwable -> 0x00a1 }
            r1 = "Fail to update plugin while verifying,sig=%s,md5=%s";
            r2 = 2;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00a1 }
            r3 = 0;
            r4 = r5.f13464a;	 Catch:{ Throwable -> 0x00a1 }
            r2[r3] = r4;	 Catch:{ Throwable -> 0x00a1 }
            r3 = 1;
            r2[r3] = r0;	 Catch:{ Throwable -> 0x00a1 }
            r0 = java.lang.String.format(r1, r2);	 Catch:{ Throwable -> 0x00a1 }
            com.qq.p035e.comm.util.GDTLogger.report(r0);	 Catch:{ Throwable -> 0x00a1 }
            goto L_0x0066;
        L_0x00a1:
            r0 = move-exception;
            r1 = "UnknownException While Update Plugin";
            com.qq.p035e.comm.util.GDTLogger.m16601e(r1, r0);	 Catch:{ all -> 0x00ca }
            r0 = new java.lang.StringBuilder;
            r1 = "TIMESTAMP_AFTER_DOWNPLUGIN:";
            r0.<init>(r1);
            r2 = java.lang.System.nanoTime();
            r0 = r0.append(r2);
            r1 = ";sig=";
            r0 = r0.append(r1);
            r1 = r5.f13464a;
            r0 = r0.append(r1);
            r0 = r0.toString();
            com.qq.p035e.comm.util.GDTLogger.m16599d(r0);
            goto L_0x0088;
        L_0x00ca:
            r0 = move-exception;
            r1 = new java.lang.StringBuilder;
            r2 = "TIMESTAMP_AFTER_DOWNPLUGIN:";
            r1.<init>(r2);
            r2 = java.lang.System.nanoTime();
            r1 = r1.append(r2);
            r2 = ";sig=";
            r1 = r1.append(r2);
            r2 = r5.f13464a;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.qq.p035e.comm.util.GDTLogger.m16599d(r1);
            throw r0;
        L_0x00ee:
            r0 = new java.lang.StringBuilder;
            r1 = "DownLoad Plugin Jar Status error,response status code=";
            r0.<init>(r1);
            r1 = r7.getStatusCode();
            r0 = r0.append(r1);
            r0 = r0.toString();
            com.qq.p035e.comm.util.GDTLogger.report(r0);
            goto L_0x0088;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.a.a.onResponse(com.qq.e.comm.net.rr.Request, com.qq.e.comm.net.rr.Response):void");
        }
    }

    static {
        f13467a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    }

    public C4052a(Context context) {
        this.f13468b = context.getApplicationContext();
    }

    public final void m16553a(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            int i;
            String str3 = MessageService.MSG_DB_READY_REPORT;
            Matcher matcher = f13467a.matcher(str2);
            if (matcher.matches()) {
                str3 = matcher.group(1);
            }
            int parseInteger = StringUtil.parseInteger(str3, 0);
            if (parseInteger < PLUGIN.ASSET_PLUGIN_VERSION) {
                GDTLogger.m16602i("online plugin version is smaller than asset plugin version" + parseInteger + ",524" + ".download give up");
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Method.GET, null), Priority.High, new C4051a(this, str, parseInteger));
            }
        }
    }
}
