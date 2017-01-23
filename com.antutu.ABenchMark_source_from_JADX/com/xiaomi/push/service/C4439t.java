package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.C4378a.C4377a;
import com.xiaomi.stats.C4509f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.service.t */
public class C4439t {
    private static final Pattern f15153a;
    private static long f15154b;
    private static ThreadPoolExecutor f15155c;

    static {
        f15153a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        f15154b = 0;
        f15155c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static void m18346a() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((f15155c.getActiveCount() <= 0 || currentTimeMillis - f15154b >= 1800000) && C4509f.m18692a().m18700c()) {
            C4377a d = ah.m18136a().m18149d();
            if (d != null && d.m17996l() > 0) {
                f15154b = currentTimeMillis;
                C4439t.m18347a(d.m17995k(), true);
            }
        }
    }

    public static void m18347a(List<String> list, boolean z) {
        f15155c.execute(new C4444u(list, z));
    }

    public static void m18349b() {
        String c = C4439t.m18351c("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(c)) {
            C4302b.m17649a("dump tcp for uid = " + Process.myUid());
            C4302b.m17649a(c);
        }
        c = C4439t.m18351c("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(c)) {
            C4302b.m17649a("dump tcp6 for uid = " + Process.myUid());
            C4302b.m17649a(c);
        }
    }

    private static boolean m18350b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C4302b.m17649a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(Host.m17914b(str, 5222), BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            socket.setTcpNoDelay(true);
            C4302b.m17649a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            C4302b.m17654d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    private static String m18351c(String str) {
        Reader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append("\n");
                    stringBuilder.append(readLine);
                }
                str2 = stringBuilder.toString();
                C4298a.m17634a(bufferedReader);
            } catch (Exception e) {
                C4298a.m17634a(bufferedReader);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                C4298a.m17634a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            Object obj = str2;
            C4298a.m17634a(bufferedReader);
            return str2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = str2;
            th = th4;
            C4298a.m17634a(bufferedReader);
            throw th;
        }
        return str2;
    }
}
