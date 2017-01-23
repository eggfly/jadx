package com.xiaomi.xmpush.thrift;

import com.facebook.ads.AdError;

/* renamed from: com.xiaomi.xmpush.thrift.b */
public enum C4518b {
    UploadSwitch(1),
    UploadFrequency(2),
    ScreenSizeCollectionSwitch(3),
    MacCollectionSwitch(4),
    IMSICollectionSwitch(5),
    AndroidVnCollectionSwitch(6),
    AndroidVcCollectionSwitch(7),
    AndroidIdCollectionSwitch(8),
    DeviceInfoCollectionFrequency(9),
    AppInstallListCollectionSwitch(10),
    AppInstallListCollectionFrequency(11),
    AppActiveListCollectionSwitch(12),
    AppActiveListCollectionFrequency(13),
    BluetoothCollectionSwitch(14),
    BluetoothCollectionFrequency(15),
    LocationCollectionSwitch(16),
    LocationCollectionFrequency(17),
    AccountCollectionSwitch(18),
    AccountCollectionFrequency(19),
    WifiCollectionSwitch(20),
    WifiCollectionFrequency(21),
    CellularCollectionSwitch(22),
    CellularCollectionFrequency(23),
    TopAppCollectionSwitch(24),
    TopAppCollectionFrequency(25),
    DataCollectionSwitch(26),
    OcVersionCheckFrequency(27),
    SyncInfoFrequency(28),
    UploadNotificationInfoFrequency(29),
    UploadNotificationInfoMaxNum(30),
    CollectionNotificationInfoBaseSwitch(31),
    CollectionNotificationInfoAppSwitch(32),
    CollectionNotificationInfoRemovedSwitch(33),
    ForegroundServiceSwitch(34),
    CollectionDataPluginVersion(AdError.NO_FILL_ERROR_CODE),
    CollectionPluginDownloadUrl(AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE),
    CollectionPluginMd5(1003),
    CollectionPluginForceStop(1004);
    
    private final int f15694M;

    private C4518b(int i) {
        this.f15694M = i;
    }

    public int m18794a() {
        return this.f15694M;
    }
}
