package com.antutu.utils.process;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.antutu.utils.process.DaemonSocket.Client;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

public class DaemonUtil {
    private static final String TAG;

    /* renamed from: com.antutu.utils.process.DaemonUtil.1 */
    class C18281 extends Thread {
        final /* synthetic */ String val$codePath;
        final /* synthetic */ Map val$pExtrasMap;
        final /* synthetic */ String val$packageName;

        /* renamed from: com.antutu.utils.process.DaemonUtil.1.1 */
        class C18271 extends TimerTask {
            C18271() {
            }

            public void run() {
                try {
                    DaemonUtil.this.startdaemon(C18281.this.val$packageName, C18281.this.val$codePath, C18281.this.val$pExtrasMap);
                } catch (Throwable e) {
                    Log.e(DaemonUtil.TAG, "start daemon failed when delay", e);
                }
            }
        }

        C18281(String str, String str2, Map map) {
            this.val$packageName = str;
            this.val$codePath = str2;
            this.val$pExtrasMap = map;
        }

        public void run() {
            try {
                int access$000 = DaemonUtil.this.checkDaemonActive();
                if (access$000 < 0) {
                    DaemonUtil.this.startdaemon(this.val$packageName, this.val$codePath, this.val$pExtrasMap);
                } else if (access$000 == 2) {
                    DaemonUtil.this.updatePid();
                } else {
                    DaemonUtil.this.exit();
                    new Timer().schedule(new C18271(), 1000);
                }
            } catch (Throwable e) {
                Log.e(DaemonUtil.TAG, "start daemon failed", e);
            } catch (InterruptedException e2) {
                Log.w(DaemonUtil.TAG, "shell InterruptedException");
            }
        }
    }

    static {
        TAG = DaemonUtil.class.getSimpleName();
    }

    private int checkDaemonActive() {
        return Client.cmd_check();
    }

    private void exit() {
        Client.cmd_exit();
    }

    private void startdaemon(String str, String str2, Map<String, String> map) {
        Process newShellProcessWithDeaultEnv = Shell.newShellProcessWithDeaultEnv();
        StringBuilder append = new StringBuilder("export CLASSPATH=").append(str2).append("\n");
        Log.d(TAG, "cmd: " + append);
        newShellProcessWithDeaultEnv.getOutputStream().write(append.toString().getBytes());
        append.setLength(0);
        append.append("exec /system/bin/app_process /data/app ");
        append.append(Daemon.class.getName()).append(" ");
        append.append(Process.myPid()).append(" ");
        append.append(str).append(" ");
        append.append(str2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                append.append(" ").append((String) entry.getKey()).append("=").append((String) entry.getValue());
            }
        }
        append.append(" &\n");
        Log.d(TAG, "cmd: " + append);
        newShellProcessWithDeaultEnv.getOutputStream().write(append.toString().getBytes());
        newShellProcessWithDeaultEnv.getOutputStream().flush();
        Log.i(TAG, "start daemon success");
        newShellProcessWithDeaultEnv.waitFor();
        newShellProcessWithDeaultEnv.destroy();
        Log.i(TAG, "start daemon success2");
    }

    private void updatePid() {
        Client.cmd_update_pid(Process.myPid());
    }

    public void setupDaemon(Context context, Map<String, String> map) {
        new C18281(context.getPackageName(), context.getPackageCodePath(), map).start();
    }
}
