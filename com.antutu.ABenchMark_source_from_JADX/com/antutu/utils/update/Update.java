package com.antutu.utils.update;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Methods;
import com.antutu.utils.NetUtils;
import com.antutu.utils.SPConstants;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.message.MessageService;

public class Update {
    public static final String UPDATE_DIALOG = "show_update_dialog";
    private static final int WHAT_NEW_DOWNLOAD = 2;
    private static final int WHAT_NEW_SHOW_DIALOG = 0;
    private static final int WHAT_NOT = 1;
    private static Context _context;
    private static Handler handler;
    private static UpdateInfo info;
    public static String newPkg;
    public static String newUrl;
    public static String newVersion;
    private static int oem_id;
    private static boolean showInfo;
    private static updateTask upTask;
    private static int versionCode;
    private static String versionName;

    /* renamed from: com.antutu.utils.update.Update.1 */
    static class C18291 extends Handler {
        C18291() {
        }

        public void handleMessage(Message message) {
            try {
                if (Update._context != null) {
                    switch (message.what) {
                        case Update.WHAT_NEW_SHOW_DIALOG /*0*/:
                            Update.newVersion = " v" + Update.info.version;
                            Update.newUrl = Update.info.url;
                            Update.newPkg = Update.info.pkg;
                            Update._context.startActivity(new Intent(Update._context, UpdateActivity.class).setAction(Update.UPDATE_DIALOG).setFlags(335544320));
                        case Update.WHAT_NOT /*1*/:
                            if (Update.showInfo) {
                                Toast.makeText(Update._context, Update._context.getString(C1692R.string.update_uptodate), Update.WHAT_NEW_SHOW_DIALOG).show();
                            }
                        case Update.WHAT_NEW_DOWNLOAD /*2*/:
                            Update.newVersion = " v" + Update.info.version;
                            Update.newUrl = Update.info.url;
                            Update.newPkg = Update.info.pkg;
                            DownloadInfos downloadInfos = new DownloadInfos();
                            downloadInfos.setUrl(Update.newUrl);
                            downloadInfos.setNeedRename(true);
                            downloadInfos.setIsQuietDownload(true);
                            DownloadsService.startDownload(Update._context, downloadInfos);
                        default:
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private static class updateTask extends Thread {
        private updateTask() {
        }

        public void run() {
            try {
                Update.checkUpdate();
            } catch (Exception e) {
            }
            Update.upTask = null;
        }
    }

    static {
        upTask = null;
        _context = null;
        info = null;
        versionName = MessageService.MSG_DB_NOTIFY_REACHED;
        versionCode = WHAT_NEW_SHOW_DIALOG;
        oem_id = WHAT_NEW_SHOW_DIALOG;
        newVersion = BuildConfig.FLAVOR;
        newUrl = BuildConfig.FLAVOR;
        newPkg = BuildConfig.FLAVOR;
        showInfo = false;
        handler = new C18291();
    }

    public static void CheckUpdate(Context context, boolean z) {
        if (upTask == null && context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    Toast.makeText(context, context.getString(C1692R.string.network_error), WHAT_NEW_SHOW_DIALOG).show();
                    return;
                }
                try {
                    XmlResourceParser xml = context.getResources().getXml(C1692R.xml.default_settings);
                    while (true) {
                        int next = xml.next();
                        if (next == WHAT_NEW_DOWNLOAD) {
                            if (xml.getName().equals("setting")) {
                                int attributeCount = xml.getAttributeCount();
                                for (next = WHAT_NEW_SHOW_DIALOG; next < attributeCount; next += WHAT_NOT) {
                                    String attributeName = xml.getAttributeName(next);
                                    String attributeValue = xml.getAttributeValue(next);
                                    if (attributeName.equals("oemid")) {
                                        oem_id = Integer.valueOf(attributeValue).intValue();
                                        break;
                                    }
                                }
                            }
                        } else if (next == WHAT_NOT) {
                            break;
                        }
                    }
                } catch (Exception e) {
                }
                _context = context;
                showInfo = z;
                upTask = new updateTask();
                upTask.start();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), WHAT_NEW_SHOW_DIALOG);
                versionName = packageInfo.versionName;
                versionCode = packageInfo.versionCode;
                if (showInfo) {
                    Toast.makeText(context, context.getString(C1692R.string.check_update_now), WHAT_NEW_SHOW_DIALOG).show();
                }
            } catch (Exception e2) {
            }
        }
    }

    private static void checkUpdate() {
        try {
            info = new DomUpdateParser("http://" + getHostName("update.antutu.net/newversion/update_") + getAppName() + ".xml").parse();
            if (info == null) {
                handler.sendEmptyMessage(WHAT_NOT);
            } else if (info.IsNewVersion(versionCode) || info.IsNewVersion(versionName)) {
                boolean sharedPreferencesBoolean = Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_UPDATE, true);
                if (NetUtils.getNetWorkType(_context) == 4 && !showInfo && sharedPreferencesBoolean) {
                    handler.sendEmptyMessage(WHAT_NEW_DOWNLOAD);
                } else {
                    handler.sendEmptyMessage(WHAT_NEW_SHOW_DIALOG);
                }
            } else {
                handler.sendEmptyMessage(WHAT_NOT);
            }
        } catch (Exception e) {
        }
    }

    private static String getAppName() {
        String str = BuildConfig.FLAVOR;
        if (_context == null) {
            return str;
        }
        str = _context.getPackageName();
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf > 0 ? str.substring(lastIndexOf + WHAT_NOT) : str;
    }

    public static String getHostName(String str) {
        return oem_id <= 100 ? "com." + str : str;
    }
}
