package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ah;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.push.log.a */
class C4367a {
    private static String f14868b;
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f14869a;
    private String f14870c;
    private String f14871d;
    private boolean f14872e;
    private int f14873f;
    private int f14874g;
    private ArrayList<File> f14875h;

    static {
        f14868b = "/MiPushLog";
    }

    C4367a() {
        this.f14869a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f14874g = AccessibilityNodeInfoCompat.ACTION_SET_TEXT;
        this.f14875h = new ArrayList();
    }

    private void m17942a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            boolean z2;
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (i < read && matcher.find(i)) {
                i = matcher.start();
                String substring = str.substring(i, this.f14870c.length() + i);
                if (this.f14872e) {
                    if (substring.compareTo(this.f14871d) > 0) {
                        z2 = true;
                        break;
                    }
                } else if (substring.compareTo(this.f14870c) >= 0) {
                    this.f14872e = true;
                    i2 = i;
                }
                int indexOf = str.indexOf(10, i);
                i = indexOf != -1 ? i + indexOf : i + this.f14870c.length();
            }
            i = read;
            z2 = z;
            if (this.f14872e) {
                i -= i2;
                this.f14873f += i;
                if (z2) {
                    bufferedWriter.write(cArr, i2, i);
                    return;
                }
                bufferedWriter.write(cArr, i2, i);
                if (this.f14873f > this.f14874g) {
                    return;
                }
            }
            z = z2;
            read = bufferedReader.read(cArr);
        }
    }

    private void m17943b(File file) {
        Writer bufferedWriter;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        Reader reader = null;
        String str = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("model :").append(Build.MODEL);
                stringBuilder.append("; os :").append(VERSION.INCREMENTAL);
                stringBuilder.append("; uid :").append(ah.m18140e());
                stringBuilder.append("; lng :").append(Locale.getDefault().toString());
                stringBuilder.append("; sdk :").append(21);
                stringBuilder.append("\n");
                bufferedWriter.write(stringBuilder.toString());
                this.f14873f = 0;
                Iterator it = this.f14875h.iterator();
                Reader reader2 = null;
                while (it.hasNext()) {
                    try {
                        reader = new BufferedReader(new InputStreamReader(new FileInputStream((File) it.next())));
                        m17942a(reader, bufferedWriter, compile);
                        reader.close();
                        reader2 = reader;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        reader = reader2;
                    } catch (IOException e4) {
                        e2 = e4;
                        reader = reader2;
                    } catch (Throwable th2) {
                        th = th2;
                        reader = reader2;
                    }
                }
                C4298a.m17635a(bufferedWriter);
                C4298a.m17634a(reader2);
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e2 = e6;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            bufferedWriter = null;
            try {
                C4302b.m17653c("LOG: filter error = " + e.getMessage());
                C4298a.m17635a(bufferedWriter);
                C4298a.m17634a(reader);
            } catch (Throwable th3) {
                th = th3;
                C4298a.m17635a(bufferedWriter);
                C4298a.m17634a(reader);
                throw th;
            }
        } catch (IOException e8) {
            e2 = e8;
            bufferedWriter = null;
            C4302b.m17653c("LOG: filter error = " + e2.getMessage());
            C4298a.m17635a(bufferedWriter);
            C4298a.m17634a(reader);
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            C4298a.m17635a(bufferedWriter);
            C4298a.m17634a(reader);
            throw th;
        }
    }

    C4367a m17944a(File file) {
        if (file.exists()) {
            this.f14875h.add(file);
        }
        return this;
    }

    C4367a m17945a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f14870c = this.f14869a.format(date2);
            this.f14871d = this.f14869a.format(date);
        } else {
            this.f14870c = this.f14869a.format(date);
            this.f14871d = this.f14869a.format(date2);
        }
        return this;
    }

    File m17946a(Context context, Date date, Date date2, File file) {
        File filesDir;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            filesDir = context.getFilesDir();
            m17944a(new File(filesDir, "xmsf.log.1"));
            m17944a(new File(filesDir, "xmsf.log"));
        } else {
            filesDir = new File(context.getExternalFilesDir(null) + f14868b);
            m17944a(new File(filesDir, "log0.txt"));
            m17944a(new File(filesDir, "log1.txt"));
        }
        if (!filesDir.isDirectory()) {
            return null;
        }
        filesDir = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (filesDir.exists()) {
            return null;
        }
        m17945a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(file, "log.txt");
        m17943b(file2);
        C4302b.m17653c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file2.exists()) {
            currentTimeMillis = System.currentTimeMillis();
            C4298a.m17631a(filesDir, file2);
            C4302b.m17653c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis));
            file2.delete();
            if (filesDir.exists()) {
                return filesDir;
            }
        }
        return null;
    }

    void m17947a(int i) {
        if (i != 0) {
            this.f14874g = i;
        }
    }
}
