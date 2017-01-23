package com.antutu.utils.update;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.message.MessageService;

public class UpdateInfo {
    public String pkg;
    public String url;
    public String version;
    public String versionCode;

    UpdateInfo() {
        this.versionCode = MessageService.MSG_DB_READY_REPORT;
        this.version = MessageService.MSG_DB_NOTIFY_REACHED;
        this.url = BuildConfig.FLAVOR;
        this.pkg = BuildConfig.FLAVOR;
        this.versionCode = MessageService.MSG_DB_READY_REPORT;
        this.version = MessageService.MSG_DB_NOTIFY_REACHED;
        this.url = BuildConfig.FLAVOR;
    }

    public static <T> List<T> makeList(T... tArr) {
        List<T> arrayList = new ArrayList();
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public boolean IsNewVersion(int i) {
        try {
            if (Integer.valueOf(this.versionCode).intValue() > i) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean IsNewVersion(String str) {
        try {
            List makeList = makeList(this.version.replace(".", " ").split(" "));
            List makeList2 = makeList(str.replace(".", " ").split(" "));
            int size = makeList2.size();
            int size2 = makeList.size();
            int max = Math.max(size2, size);
            int i = 0;
            while (i < max) {
                int intValue = size > i ? Integer.valueOf((String) makeList2.get(i)).intValue() : 0;
                int intValue2 = size2 > i ? Integer.valueOf((String) makeList.get(i)).intValue() : 0;
                if (intValue2 > intValue) {
                    return true;
                }
                if (intValue2 < intValue) {
                    return false;
                }
                i++;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
