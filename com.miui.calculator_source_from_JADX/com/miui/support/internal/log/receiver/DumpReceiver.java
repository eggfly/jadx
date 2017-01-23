package com.miui.support.internal.log.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.miui.support.internal.log.util.Config;
import com.miui.support.os.FileUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class DumpReceiver extends BroadcastReceiver {
    private final String f2534a;
    private final String f2535b;

    /* renamed from: com.miui.support.internal.log.receiver.DumpReceiver.1 */
    final class C02871 implements FileFilter {
        C02871() {
        }

        public boolean accept(File file) {
            file.delete();
            return false;
        }
    }

    public DumpReceiver() {
        this(Config.m4211a(), Config.m4214b());
    }

    public DumpReceiver(String str, String str2) {
        this.f2534a = str;
        this.f2535b = str2;
    }

    public void onReceive(Context context, Intent intent) {
        Log.d("DumpReceiver", "dumpCachedLog start");
        m4208a(this.f2534a, this.f2535b);
        Log.d("DumpReceiver", "dumpCachedLog end");
    }

    private static void m4208a(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                Log.i("DumpReceiver", "Skip dumpCachedLog, logNames=" + Arrays.toString(list));
                return;
            }
            file = new File(str2);
            if (file.exists() || file.mkdirs() || file.exists()) {
                file.listFiles(new C02871());
                for (String str3 : list) {
                    File file2 = new File(str + File.separatorChar + str3);
                    File file3 = new File(str2 + File.separatorChar + str3);
                    FileUtils.m5180a(file2, file3);
                    Log.d("DumpReceiver", "Dump log from " + file2.getPath() + " to " + file3.getPath());
                }
                return;
            }
            Log.e("DumpReceiver", "Fail to make dump dir: " + file.getPath());
            return;
        }
        Log.i("DumpReceiver", "Skip dumpCachedLog, cacheLogDir is not exist: " + str);
    }
}
