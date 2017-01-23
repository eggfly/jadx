package anet.channel.appmonitor;

import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;
import anet.channel.statist.StatObject;

public class AppMonitor {
    private static volatile IAppMonitor appMonitor;

    /* renamed from: anet.channel.appmonitor.AppMonitor.1 */
    final class C06481 implements IAppMonitor {
        final /* synthetic */ IAppMonitor val$appMonitor;

        C06481(IAppMonitor iAppMonitor) {
            this.val$appMonitor = iAppMonitor;
        }

        public void commitAlarm(AlarmObject alarmObject) {
            if (this.val$appMonitor != null) {
                this.val$appMonitor.commitAlarm(alarmObject);
            }
        }

        public void commitCount(CountObject countObject) {
            if (this.val$appMonitor != null) {
                this.val$appMonitor.commitCount(countObject);
            }
        }

        public void commitStat(StatObject statObject) {
            if (this.val$appMonitor != null) {
                this.val$appMonitor.commitStat(statObject);
            }
        }

        public void register() {
            if (this.val$appMonitor != null) {
                this.val$appMonitor.register();
            }
        }

        public void register(Class<?> cls) {
            if (this.val$appMonitor != null) {
                this.val$appMonitor.register(cls);
            }
        }
    }

    static {
        appMonitor = new DefaultAppMonitor();
    }

    public static IAppMonitor getInstance() {
        return appMonitor;
    }

    public static void setInstance(IAppMonitor iAppMonitor) {
        appMonitor = new C06481(iAppMonitor);
    }
}
