package com.umeng.message;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.proguard.C4239k;
import com.umeng.message.provider.C4243a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Calendar;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.message.MessageService;

public class MessageSharedPrefs {
    private static final String f14083a;
    private static MessageSharedPrefs f14084c = null;
    private static final String f14085d = "tempkey";
    private static final String f14086e = "tempvalue";
    private Context f14087b;

    static {
        f14083a = MessageSharedPrefs.class.getName();
    }

    private MessageSharedPrefs(Context context) {
        this.f14087b = context;
    }

    public static synchronized MessageSharedPrefs getInstance(Context context) {
        MessageSharedPrefs messageSharedPrefs;
        synchronized (MessageSharedPrefs.class) {
            if (f14084c == null) {
                f14084c = new MessageSharedPrefs(context);
            }
            messageSharedPrefs = f14084c;
        }
        return messageSharedPrefs;
    }

    int m17082a() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_NO_DISTURB_START_HOUR, AgooConstants.REPORT_DUPLICATE_FAIL)).intValue();
    }

    void m17083a(int i, int i2, int i3, int i4) {
        setKeyAndValue(MsgConstant.KEY_NO_DISTURB_START_HOUR, i + BuildConfig.FLAVOR);
        setKeyAndValue(MsgConstant.KEY_NO_DISTURB_START_HOUR, i2 + BuildConfig.FLAVOR);
        setKeyAndValue(MsgConstant.KEY_NO_DISTURB_END_HOUR, i3 + BuildConfig.FLAVOR);
        setKeyAndValue(MsgConstant.KEY_NO_DISTURB_END_MINUTE, i4 + BuildConfig.FLAVOR);
    }

    boolean m17084a(String str) {
        return getTempValue(MsgConstant.KEY_DEVICE_TOKEN, BuildConfig.FLAVOR).equalsIgnoreCase(str);
    }

    public void addAlias(String str, String str2, int i, int i2, String str3) {
        try {
            String str4 = "alias=? and type=? and exclusive=?";
            String[] strArr = new String[]{str, str2, i + BuildConfig.FLAVOR};
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            Cursor query = contentResolver.query(C4243a.f14477d, new String[]{C4233j.f14375B}, str4, strArr, "time desc");
            ContentValues contentValues;
            ContentResolver contentResolver2;
            if (query == null) {
                contentValues = new ContentValues();
                contentValues.put(C4233j.f14377D, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(C4233j.f14402y, str2);
                contentValues.put(C4233j.f14403z, str);
                contentValues.put(C4233j.f14374A, Integer.valueOf(i));
                contentValues.put(C4233j.f14375B, Integer.valueOf(i2));
                contentValues.put(C4233j.f14376C, str3);
                contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.insert(C4243a.f14477d, contentValues);
            } else if (query.getCount() > 0) {
                query.moveToFirst();
                contentValues = new ContentValues();
                contentValues.put(C4233j.f14377D, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(C4233j.f14402y, str2);
                contentValues.put(C4233j.f14403z, str);
                contentValues.put(C4233j.f14374A, Integer.valueOf(i));
                contentValues.put(C4233j.f14375B, Integer.valueOf(i2));
                contentValues.put(C4233j.f14376C, str3);
                contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.update(C4243a.f14477d, contentValues, str4, strArr);
            } else {
                contentValues = new ContentValues();
                contentValues.put(C4233j.f14377D, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(C4233j.f14402y, str2);
                contentValues.put(C4233j.f14403z, str);
                contentValues.put(C4233j.f14374A, Integer.valueOf(i));
                contentValues.put(C4233j.f14375B, Integer.valueOf(i2));
                contentValues.put(C4233j.f14376C, str3);
                contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.insert(C4243a.f14477d, contentValues);
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTags(String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String format = String.format("UMENG_TAG_%s", new Object[]{strArr[i]});
            if (!Boolean.valueOf(getTempValue(format, "false")).booleanValue()) {
                setKeyAndValue(format, "true");
                setKeyAndValue("UMENG_TAG_COUNT", (getTagCount() + 1) + BuildConfig.FLAVOR);
            }
        }
    }

    int m17085b() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_NO_DISTURB_START_MINUTE, MessageService.MSG_DB_READY_REPORT)).intValue();
    }

    int m17086c() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_NO_DISTURB_END_HOUR, MsgConstant.MESSAGE_NOTIFY_ARRIVAL)).intValue();
    }

    int m17087d() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_NO_DISTURB_END_MINUTE, MessageService.MSG_DB_READY_REPORT)).intValue();
    }

    void m17088e() {
        setKeyAndValue(MsgConstant.KEY_ENEABLED, "true");
    }

    void m17089f() {
        setKeyAndValue(MsgConstant.KEY_ENEABLED, "false");
    }

    public boolean finishTransferedCacheFileDataToSQL() {
        return getTempValue(MsgConstant.KEY_CACHE_FILE_TRANSFER_TO_SQL, "true").equalsIgnoreCase("true");
    }

    boolean m17090g() {
        return getTempValue(MsgConstant.KEY_ENEABLED, "false").equalsIgnoreCase("true");
    }

    public int getAppLaunchLogSendPolicy() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, "-1")).intValue();
    }

    public String getAppVersion() {
        return getTempValue(C4575b.PROPERTY_APP_VERSION, BuildConfig.FLAVOR);
    }

    public String getDeviceToken() {
        return getTempValue(MsgConstant.KEY_DEVICE_TOKEN, BuildConfig.FLAVOR);
    }

    public int getDisplayNotificationNumber() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_NOTIFICATION_NUMBER, MessageService.MSG_DB_NOTIFY_REACHED)).intValue();
    }

    public boolean getHasRegister() {
        return getTempValue(MsgConstant.KEY_HASREGISTER, "false").equalsIgnoreCase("true");
    }

    public String getLastAlias(int i, String str) {
        String str2;
        Exception e;
        String str3 = BuildConfig.FLAVOR;
        try {
            String[] strArr = new String[]{str, i + BuildConfig.FLAVOR};
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            Cursor query = contentResolver.query(C4243a.f14477d, new String[]{C4233j.f14403z}, "type=? and exclusive=?", strArr, "time desc");
            if (query == null || query.getCount() <= 0) {
                str2 = str3;
            } else {
                query.moveToFirst();
                str2 = query.getString(query.getColumnIndex(C4233j.f14403z));
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str3;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    public String getLastMessageMsgID() {
        return getTempValue(MsgConstant.KEY_LAST_MSG_ID, BuildConfig.FLAVOR);
    }

    public int getLocationInterval() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_LOCATION_INTERVAL, "600")).intValue();
    }

    public String getMessageAppKey() {
        return getTempValue(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY, BuildConfig.FLAVOR);
    }

    public String getMessageAppSecret() {
        return getTempValue(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, BuildConfig.FLAVOR);
    }

    public String getMessageChannel() {
        return getTempValue(MsgConstant.KEY_UMENG_MESSAGE_APP_CHANNEL, BuildConfig.FLAVOR);
    }

    public int getMuteDuration() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_MUTE_DURATION, "60")).intValue();
    }

    public boolean getNotificaitonOnForeground() {
        return getTempValue(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, "true").equals("true");
    }

    public int getNotificationPlayLights() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, MessageService.MSG_DB_READY_REPORT)).intValue();
    }

    public int getNotificationPlaySound() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, MessageService.MSG_DB_READY_REPORT)).intValue();
    }

    public int getNotificationPlayVibrate() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, MessageService.MSG_DB_READY_REPORT)).intValue();
    }

    public String getPushIntentServiceClass() {
        String tempValue = getTempValue(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, BuildConfig.FLAVOR);
        if (tempValue.equalsIgnoreCase(BuildConfig.FLAVOR)) {
            return BuildConfig.FLAVOR;
        }
        try {
            Class.forName(tempValue);
            return tempValue;
        } catch (ClassNotFoundException e) {
            return BuildConfig.FLAVOR;
        }
    }

    public String getResourcePackageName() {
        return getTempValue(MsgConstant.KEY_SET_RESOURCE_PACKAGENAME, BuildConfig.FLAVOR);
    }

    public int getSerialNo() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_SERIA_NO, MessageService.MSG_DB_NOTIFY_REACHED)).intValue();
    }

    public int getTagCount() {
        return Integer.valueOf(getTempValue("UMENG_TAG_COUNT", MessageService.MSG_DB_READY_REPORT)).intValue();
    }

    public int getTagRemain() {
        return Integer.valueOf(getTempValue("UMENG_TAG_REMAIN", "64")).intValue();
    }

    public int getTagSendPolicy() {
        return Integer.valueOf(getTempValue(MsgConstant.KEY_TAG_SEND_POLICY, "-1")).intValue();
    }

    public String getTempValue(String str, String str2) {
        String string;
        try {
            new ContentValues().put(f14085d, str);
            String[] strArr = new String[]{str};
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            Cursor query = contentResolver.query(C4243a.f14476c, new String[]{f14086e}, "tempkey=?", strArr, null);
            if (query == null) {
                return str2;
            }
            string = query.moveToFirst() ? query.getString(query.getColumnIndex(f14086e)) : str2;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e) {
                }
            }
            return string;
        } catch (Exception e2) {
            string = str2;
        }
    }

    public boolean hasAppLaunchLogSentToday() {
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTimeInMillis(C4239k.m17301a(this.f14087b).m17327f());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(f14083a, e.toString());
        }
        Calendar instance2 = Calendar.getInstance();
        return instance.get(6) == instance2.get(6) && instance.get(1) == instance2.get(1);
    }

    public boolean hasMessageResourceDownloaded(String str) {
        return getTempValue(new StringBuilder().append(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX).append(str).toString(), "false").equals("true");
    }

    public boolean hasTransferedCacheFileDataToSQL() {
        return getTempValue(MsgConstant.KEY_CACHE_FILE_TRANSFER_TO_SQL, "false").equalsIgnoreCase("true");
    }

    public boolean isAliasSet(int i, String str, String str2) {
        try {
            boolean z;
            String[] strArr = new String[]{str2, str, i + BuildConfig.FLAVOR, MessageService.MSG_DB_READY_REPORT};
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            Cursor query = contentResolver.query(C4243a.f14477d, new String[]{C4233j.f14402y, C4233j.f14403z}, "type=? and alias=? and exclusive=? and error=?", strArr, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(C4233j.f14402y));
                String string2 = query.getString(query.getColumnIndex(C4233j.f14403z));
                if (string.equalsIgnoreCase(str2) && string2.equalsIgnoreCase(str)) {
                    z = true;
                    if (query != null) {
                        return z;
                    }
                    try {
                        query.close();
                        return z;
                    } catch (Exception e) {
                        return z;
                    }
                }
            }
            z = false;
            if (query != null) {
                return z;
            }
            query.close();
            return z;
        } catch (Exception e2) {
            return false;
        }
    }

    public boolean isEnabled() {
        String tempValue = getTempValue(MsgConstant.KEY_ISENABLED, BuildConfig.FLAVOR);
        return tempValue.equalsIgnoreCase("true") || tempValue.equalsIgnoreCase(BuildConfig.FLAVOR);
    }

    public boolean isTagSet(String str) {
        return Boolean.valueOf(getTempValue(String.format("UMENG_TAG_%s", new Object[]{str}), "false")).booleanValue();
    }

    public void removeAlias(int i, String str, String str2) {
        try {
            String[] strArr = new String[]{str2, str, i + BuildConfig.FLAVOR};
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            contentResolver.delete(C4243a.f14477d, "type=? and alias=? and exclusive=? ", strArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeKeyAndValue(String str) {
        try {
            new ContentValues().put(f14085d, str);
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            Cursor query = contentResolver.query(C4243a.f14476c, new String[]{f14086e}, null, null, null);
            if (query != null) {
                String[] strArr = new String[]{str};
                ContentResolver contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.delete(C4243a.f14476c, "tempkey=?", strArr);
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeMessageAppKey() {
        removeKeyAndValue(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY);
    }

    public void removeMessageAppSecret() {
        removeKeyAndValue(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET);
    }

    public void removeMessageResouceRecord(String str) {
        removeKeyAndValue(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str);
    }

    public void removeTags(String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String format = String.format("UMENG_TAG_%s", new Object[]{strArr[i]});
            if (Boolean.valueOf(getTempValue(format, "false")).booleanValue()) {
                removeKeyAndValue(format);
                setKeyAndValue("UMENG_TAG_COUNT", (getTagCount() - 1) + BuildConfig.FLAVOR);
            }
        }
    }

    public void resetTags() {
    }

    public void setAppLaunchLogSendPolicy(int i) {
        setKeyAndValue(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, i + BuildConfig.FLAVOR);
    }

    public void setAppVersion(String str) {
        if (str == null) {
            removeKeyAndValue(C4575b.PROPERTY_APP_VERSION);
        } else {
            setKeyAndValue(C4575b.PROPERTY_APP_VERSION, str);
        }
    }

    public void setDeviceToken(String str) {
        if (str == null) {
            removeKeyAndValue(MsgConstant.KEY_DEVICE_TOKEN);
        } else {
            setKeyAndValue(MsgConstant.KEY_DEVICE_TOKEN, str);
        }
    }

    public void setDisplayNotificationNumber(int i) {
        setKeyAndValue(MsgConstant.KEY_NOTIFICATION_NUMBER, i + BuildConfig.FLAVOR);
    }

    public void setHasResgister(boolean z) {
        setKeyAndValue(MsgConstant.KEY_HASREGISTER, String.valueOf(z));
    }

    public void setIsEnabled(boolean z) {
        setKeyAndValue(MsgConstant.KEY_ISENABLED, String.valueOf(z));
    }

    public void setKeyAndValue(String str, String str2) {
        try {
            String str3 = "tempkey=?";
            String[] strArr = new String[]{str};
            ContentResolver contentResolver = this.f14087b.getContentResolver();
            C4243a.m17332a(this.f14087b);
            Cursor query = contentResolver.query(C4243a.f14476c, new String[]{f14086e}, str3, strArr, null);
            ContentValues contentValues;
            ContentResolver contentResolver2;
            if (query == null) {
                contentValues = new ContentValues();
                contentValues.put(f14085d, str);
                contentValues.put(f14086e, str2);
                contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.insert(C4243a.f14476c, contentValues);
            } else if (query.moveToFirst()) {
                contentValues = new ContentValues();
                contentValues.put(f14086e, str2);
                contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.update(C4243a.f14476c, contentValues, str3, strArr);
            } else {
                contentValues = new ContentValues();
                contentValues.put(f14085d, str);
                contentValues.put(f14086e, str2);
                contentResolver2 = this.f14087b.getContentResolver();
                C4243a.m17332a(this.f14087b);
                contentResolver2.insert(C4243a.f14476c, contentValues);
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    public void setLastMessageMsgID(String str) {
        setKeyAndValue(MsgConstant.KEY_LAST_MSG_ID, str);
    }

    public void setLocationInterval(int i) {
        if (i < 2 || i > 1800) {
            UmLog.m17136d("LBS", "The interval of LBS should not be smaller than 2 seconds");
        } else {
            setKeyAndValue(MsgConstant.KEY_LOCATION_INTERVAL, i + BuildConfig.FLAVOR);
        }
    }

    public void setMessageAppKey(String str) {
        setKeyAndValue(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY, str);
    }

    public void setMessageAppSecret(String str) {
        setKeyAndValue(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, str);
    }

    public void setMessageChannel(String str) {
        setKeyAndValue(MsgConstant.KEY_UMENG_MESSAGE_APP_CHANNEL, str);
    }

    public void setMessageResourceDownloaded(String str) {
        setKeyAndValue(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str, "true");
    }

    public void setMuteDuration(int i) {
        setKeyAndValue(MsgConstant.KEY_MUTE_DURATION, i + BuildConfig.FLAVOR);
    }

    public void setNotificaitonOnForeground(boolean z) {
        setKeyAndValue(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, String.valueOf(z));
    }

    public void setNotificationPlayLights(int i) {
        setKeyAndValue(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, i + BuildConfig.FLAVOR);
    }

    public void setNotificationPlaySound(int i) {
        setKeyAndValue(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, i + BuildConfig.FLAVOR);
    }

    public void setNotificationPlayVibrate(int i) {
        setKeyAndValue(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, i + BuildConfig.FLAVOR);
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        if (cls == null) {
            removeKeyAndValue(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME);
        } else {
            setKeyAndValue(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, cls.getName());
        }
    }

    public void setResourcePackageName(String str) {
        setKeyAndValue(MsgConstant.KEY_SET_RESOURCE_PACKAGENAME, str);
    }

    public void setSerialNo(int i) {
        setKeyAndValue(MsgConstant.KEY_SERIA_NO, i + BuildConfig.FLAVOR);
    }

    public void setTagRemain(int i) {
        setKeyAndValue("UMENG_TAG_REMAIN", i + BuildConfig.FLAVOR);
    }

    public void setTagSendPolicy(int i) {
        setKeyAndValue(MsgConstant.KEY_TAG_SEND_POLICY, i + BuildConfig.FLAVOR);
    }
}
