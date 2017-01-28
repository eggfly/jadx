import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.NotificationCompat.Builder;
import com.aide.ui.MainActivity;
import com.aide.ui.e;

public class pu {
    public void j6() {
    }

    public boolean DW() {
        if (e.gn().getSharedPreferences("UpdateNotifications", 0).getAll().size() == 0) {
            return true;
        }
        return false;
    }

    private boolean j6(boolean z, String str, long j, long j2) {
        SharedPreferences sharedPreferences = e.gn().getSharedPreferences("UpdateNotifications", 0);
        String str2 = "UpdateTime" + str;
        long j3 = sharedPreferences.getLong(str2, -1);
        Editor edit = sharedPreferences.edit();
        edit.putLong(str2, j2);
        edit.commit();
        if (j == j2) {
            return false;
        }
        if (j3 == -1) {
            if (z) {
                return false;
            }
            return true;
        } else if (j3 < j2) {
            return true;
        } else {
            return false;
        }
    }

    public void j6(boolean z, String str, long j, long j2, int i, String[] strArr) {
        if (j6(z, str, j, j2)) {
            CharSequence charSequence = strArr[0] + " " + strArr[1];
            long currentTimeMillis = System.currentTimeMillis();
            ((NotificationManager) e.gn().getSystemService("notification")).notify(charSequence.hashCode(), new Builder(e.gn()).j6(currentTimeMillis).FH("New " + charSequence + " lessons!").j6(i).j6(charSequence).DW((CharSequence) "Check out the new lessons").j6(MainActivity.Hw(e.gn())).j6(true).FH(1).j6());
        }
    }
}
