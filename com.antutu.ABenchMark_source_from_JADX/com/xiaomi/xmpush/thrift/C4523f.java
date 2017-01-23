package com.xiaomi.xmpush.thrift;

import java.util.Map;

/* renamed from: com.xiaomi.xmpush.thrift.f */
public enum C4523f {
    Invalid("INVALID"),
    BarClick("bar:click"),
    BarCancel("bar:cancel"),
    AppOpen("app:open"),
    PackageUninstall("package uninstalled"),
    AppUninstall("app_uninstalled"),
    ClientInfoUpdate("client_info_update"),
    ClientInfoUpdateOk("client_info_update_ok"),
    PullOfflineMessage("pull"),
    IosSleep("ios_sleep"),
    IosWakeUp("ios_wakeup"),
    AwakeApp("awake_app"),
    NormalClientConfigUpdate("normal_client_config_update"),
    CustomClientConfigUpdate("custom_client_config_update"),
    DailyCheckClientConfig("daily_check_client_config"),
    DataCollection("data_collection"),
    RegIdExpired("registration id expired"),
    ConnectionDisabled("!!!MILINK CONNECTION DISABLED!!!"),
    PackageUnregistered("package_unregistered"),
    DecryptMessageFail("decrypt_msg_fail"),
    SyncInfo("sync_info"),
    SyncInfoResult("sync_info_result"),
    ForceSync("force_sync"),
    UploadClientLog("upload_client_log"),
    NotificationBarInfo("notification_bar_info");
    
    public static Map<String, C4523f> f15721A;
    public final String f15748z;

    static {
        f15721A = null;
    }

    private C4523f(String str) {
        this.f15748z = str;
    }

    public String toString() {
        return this.f15748z;
    }
}
