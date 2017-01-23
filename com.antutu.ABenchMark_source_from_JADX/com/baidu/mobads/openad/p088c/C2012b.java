package com.baidu.mobads.openad.p088c;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p082b.C1913a;
import com.baidu.mobads.p082b.C1916b;
import com.baidu.mobads.p084c.C1918a;
import com.igexin.download.Downloads;
import com.umeng.message.MsgConstant;
import com.umeng.message.entity.UMessage;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.openad.c.b */
public class C2012b implements Observer {
    private static NotificationManager f7018a;
    private static int f7019b;
    private static HashMap<String, C2012b> f7020g;
    private C1924a f7021c;
    private Context f7022d;
    private C1916b f7023e;
    private String f7024f;
    private Handler f7025h;

    static {
        f7019b = 10091;
        f7020g = new HashMap();
    }

    public C2012b(Context context, C1924a c1924a) {
        this.f7021c = null;
        this.f7023e = null;
        this.f7024f = BuildConfig.FLAVOR;
        this.f7025h = new Handler(Looper.getMainLooper());
        C1991m.m7449a().m7457f().m7393d("OAdApkDownloaderObserver", "observer created");
        if (f7018a == null) {
            f7018a = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        }
        this.f7022d = context.getApplicationContext();
        this.f7021c = c1924a;
        C2012b.m7508a(this.f7021c.f6738i, this);
    }

    public static synchronized C2012b m7506a(String str) {
        C2012b c2012b;
        synchronized (C2012b.class) {
            c2012b = (C2012b) f7020g.get(str);
        }
        return c2012b;
    }

    public static synchronized void m7508a(String str, C2012b c2012b) {
        synchronized (C2012b.class) {
            f7020g.put(str, c2012b);
        }
    }

    public static synchronized C2012b m7510b(String str) {
        C2012b c2012b;
        synchronized (C2012b.class) {
            c2012b = (C2012b) f7020g.remove(str);
        }
        return c2012b;
    }

    public static synchronized int m7511c(String str) {
        int i;
        synchronized (C2012b.class) {
            C2012b c2012b = (C2012b) f7020g.get(str);
            if (c2012b == null || c2012b.m7515a() == null) {
                i = f7019b;
                f7019b = i + 1;
            } else {
                i = c2012b.m7515a().f6735f;
            }
        }
        return i;
    }

    @TargetApi(16)
    private Notification m7513d() {
        CharSequence charSequence = this.f7021c.f6730a;
        CharSequence charSequence2 = "\u6b63\u5728\u4e0b\u8f7d " + this.f7021c.f6730a;
        CharSequence charSequence3 = BuildConfig.FLAVOR;
        int i = 17301633;
        if (this.f7021c.f6736g == DownloadStatus.COMPLETED) {
            charSequence = this.f7021c.f6736g.getMessage() + ": " + charSequence;
            charSequence3 = " \u70b9\u51fb\u8fd9\u91cc\u5b89\u88c5\u5e94\u7528";
            i = 17301634;
        } else if (this.f7021c.f6736g == DownloadStatus.PAUSED) {
            r4 = this.f7021c.f6736g.getMessage() + ": " + charSequence;
            Object obj = "\u5df2\u4e3a\u60a8\u6682\u505c\u4e0b\u8f7d\uff0c \u70b9\u51fb\u901a\u77e5\u680f\u7ee7\u7eed\u4e0b\u8f7d";
            r2 = "\u76ee\u524d\u4e0d\u5728wifi\u7f51\u7edc\u4e0b\uff0c \u70b9\u51fb\u8fd9\u91cc\u7ee7\u7eed\u4e0b\u8f7d";
            i = 17301634;
        } else if (this.f7021c.f6736g == DownloadStatus.ERROR) {
            r4 = this.f7021c.f6736g.getMessage() + ": " + charSequence;
            r2 = " \u7a0d\u540e\u70b9\u51fb\u8fd9\u91cc\u91cd\u65b0\u4e0b\u8f7d";
            i = 17301634;
        } else if (this.f7021c.f6736g == DownloadStatus.DOWNLOADING) {
            r4 = this.f7021c.f6736g.getMessage() + ": " + charSequence;
            r2 = "\u4e0b\u8f7d\u8fdb\u5ea6: " + this.f7021c.f6734e + "%  \u5e94\u7528\u5927\u5c0f: " + this.f7024f;
        } else if (this.f7021c.f6736g == DownloadStatus.INITING) {
            r4 = this.f7021c.f6736g.getMessage() + ": " + charSequence;
            r2 = this.f7021c.f6736g.getMessage();
        }
        Intent intent = new Intent(this.f7022d, AppActivity.class);
        intent.putExtra("dealWithDownload", true);
        intent.putExtra(MsgConstant.KEY_STATUS, this.f7021c.f6736g.getCode());
        intent.putExtra(IXAdRequestInfo.PACKAGE, this.f7021c.f6738i);
        intent.putExtra("localApkPath", this.f7021c.f6732c + this.f7021c.f6731b);
        intent.putExtra(Downloads.COLUMN_TITLE, charSequence);
        intent.addFlags(268435456);
        intent.setAction(Long.toString(System.currentTimeMillis()));
        PendingIntent activity = PendingIntent.getActivity(this.f7022d, this.f7021c.f6735f, intent, 134217728);
        if (VERSION.SDK_INT >= 16) {
            if (this.f7021c.f6737h == null) {
                this.f7021c.f6737h = new Builder(this.f7022d);
            }
            return ((Builder) this.f7021c.f6737h).setContentTitle(charSequence).setContentText(charSequence3).setTicker(charSequence2).setSmallIcon(i).setContentIntent(activity).setAutoCancel(true).setProgress(100, this.f7021c.f6734e, false).build();
        }
        if (this.f7021c.f6737h == null) {
            this.f7021c.f6737h = new Notification();
        }
        Notification notification = (Notification) this.f7021c.f6737h;
        notification.icon = i;
        notification.flags |= 16;
        notification.tickerText = charSequence2;
        notification.contentIntent = activity;
        try {
            notification.getClass().getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{this.f7022d, charSequence, charSequence3, activity});
            return notification;
        } catch (NoSuchMethodException e) {
            return notification;
        } catch (IllegalAccessException e2) {
            return notification;
        } catch (IllegalArgumentException e3) {
            return notification;
        } catch (InvocationTargetException e4) {
            return notification;
        }
    }

    private void m7514d(String str) {
        Toast.makeText(this.f7022d, str, 0).show();
    }

    public C1924a m7515a() {
        return this.f7021c;
    }

    public void m7516b() {
        this.f7025h.post(new C2013c(this));
    }

    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        this.f7021c.f6736g = iOAdDownloader.getState();
        if (this.f7021c.f6736g == DownloadStatus.DOWNLOADING) {
            if (this.f7021c.f6733d < 0) {
                C1991m.m7449a().m7457f().m7393d("OAdApkDownloaderObserver", "download update---mExtraInfo.contentLength < 0");
                this.f7021c.f6733d = (long) iOAdDownloader.getFileSize();
                this.f7021c.f6740k = iOAdDownloader.getTargetURL();
                this.f7021c.m7251a(this.f7022d);
                this.f7024f = String.format(Locale.CHINA, "%.1fM", new Object[]{Float.valueOf(((float) this.f7021c.f6733d) / 1048576.0f)});
            }
            if (iOAdDownloader.getProgress() > 0.0f) {
                int progress = (int) iOAdDownloader.getProgress();
                if (progress > this.f7021c.f6734e) {
                    this.f7021c.f6734e = progress;
                    m7516b();
                    return;
                }
                return;
            }
            return;
        }
        if (this.f7021c.f6736g == DownloadStatus.COMPLETED) {
            C1991m.m7449a().m7457f().m7393d("OAdApkDownloaderObserver", "download success-->>" + iOAdDownloader.getOutputPath());
            boolean z = this.f7021c.f6741l;
            C1991m.m7449a().m7457f().m7393d("OAdApkDownloaderObserver", "launch installing .............");
            String str = this.f7021c.f6732c + this.f7021c.f6731b;
            if (!this.f7021c.f6738i.contains(".")) {
                ApkInfo localApkFileInfo = C1991m.m7449a().m7463l().getLocalApkFileInfo(this.f7022d, str);
                this.f7021c.f6738i = localApkFileInfo.packageName;
            }
            if (this.f7023e == null) {
                BroadcastReceiver c1913a = new C1913a(this.f7021c);
                this.f7023e = new C1916b(this.f7022d, this.f7021c.f6738i, new File(str), z);
                this.f7023e.m7216a(c1913a);
                this.f7023e.m7215a();
            }
            C1918a.m7217a().m7224a(this.f7022d, this.f7021c);
        } else if (this.f7021c.f6736g == DownloadStatus.ERROR) {
            this.f7021c.f6740k = iOAdDownloader.getTargetURL();
            C1991m.m7449a().m7457f().m7400e("OAdApkDownloaderObserver", "download failed-->>" + iOAdDownloader.getOutputPath());
            C1918a.m7217a().m7225a(this.f7021c);
        } else if (iOAdDownloader.getState() == DownloadStatus.INITING) {
            C1924a c1924a = this.f7021c;
            c1924a.f6746q++;
        }
        m7516b();
        this.f7021c.m7251a(this.f7022d);
    }
}
