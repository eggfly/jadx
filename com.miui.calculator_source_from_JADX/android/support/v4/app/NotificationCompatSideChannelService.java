package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.support.v4.app.INotificationSideChannel.Stub;

public abstract class NotificationCompatSideChannelService extends Service {

    private class NotificationSideChannelStub extends Stub {
        final /* synthetic */ NotificationCompatSideChannelService f349a;

        public void m461a(String str, int i, String str2, Notification notification) {
            this.f349a.m462a(getCallingUid(), str);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.f349a.m466a(str, i, str2, notification);
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void m460a(String str, int i, String str2) {
            this.f349a.m462a(getCallingUid(), str);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.f349a.m465a(str, i, str2);
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void m459a(String str) {
            this.f349a.m462a(getCallingUid(), str);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.f349a.m464a(str);
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void m464a(String str);

    public abstract void m465a(String str, int i, String str2);

    public abstract void m466a(String str, int i, String str2, Notification notification);

    private void m462a(int i, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (i2 < length) {
            if (!packagesForUid[i2].equals(str)) {
                i2++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }
}
