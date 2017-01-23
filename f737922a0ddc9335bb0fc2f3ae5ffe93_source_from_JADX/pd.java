import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.aide.analytics.a;
import com.aide.ui.e;
import com.aide.ui.h;
import java.io.File;
import java.util.List;

public class pd {
    private boolean DW;
    private boolean j6;

    public void j6(String str, String str2) {
        e.Sf().DW();
        boolean z = e.Mr().FH() && h.EQ();
        j6(z, new pd$1(this, str, str2), new pd$2(this, str));
    }

    private void j6(boolean z, Runnable runnable, Runnable runnable2) {
        if (!z) {
            runnable2.run();
        } else if (!this.DW) {
            this.DW = true;
            new Thread(new pd$3(this, runnable, runnable2)).start();
        } else if (this.j6) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    private void j6(String str) {
        if (!e.VH() || e.EQ().j6()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(4096);
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            List<ResolveInfo> queryIntentActivities = e.gn().getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if ("com.android.packageinstaller".equals(activityInfo.applicationInfo.packageName)) {
                        intent.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
                        break;
                    }
                }
            }
            e.gn().startActivity(intent);
            a.DW("Run app without root");
        }
    }

    private void DW(String str, String str2) {
        a.DW("Run app with root");
        new Thread(new pd$4(this, str, str2)).start();
    }
}
