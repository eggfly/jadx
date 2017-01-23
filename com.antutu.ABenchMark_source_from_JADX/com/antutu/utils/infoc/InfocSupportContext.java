package com.antutu.utils.infoc;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.antutu.redacc.C1692R;
import com.antutu.utils.DeviceInfoUtil;
import com.cmcm.support.C1821b;
import com.cmcm.support.C2242k.C1820a;
import com.cmcm.support.C2244m;
import org.android.agoo.message.MessageService;

public class InfocSupportContext implements C1821b {
    private static final boolean DEBUG = false;
    private static final String TAG;
    private static int sOemId;
    private static String sPublicDataString;
    private Context mApplicationContext;

    static {
        TAG = InfocSupportContext.class.getSimpleName();
        sOemId = -289657543;
    }

    public InfocSupportContext(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    private static String createPublicData(Context context) {
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("xaid=").append(DeviceInfoUtil.getAndroidId(context)).append("&ver=").append("6.3.3").append("&cn1=").append(getOemId(context)).append("&cn2=").append(MessageService.MSG_DB_READY_REPORT).append("&manufacturer=").append(DeviceInfoUtil.getManufacturer()).append("&brand=").append(DeviceInfoUtil.getBrand()).append("&model=").append(DeviceInfoUtil.getModel()).append("&resolution=").append(DeviceInfoUtil.getResolution(context)).append("&capi=").append(DeviceInfoUtil.getSDKVersionNumber()).append("&osversion=").append(DeviceInfoUtil.getOSVersion()).append("&cl=").append(DeviceInfoUtil.getLocale(context)).append("&gpuser=").append(DeviceInfoUtil.hasGooglePlayApp(context) ? 1 : 0).append("&root=");
        if (!DeviceInfoUtil.isRoot()) {
            i = 0;
        }
        append.append(i).append("&net=").append(DeviceInfoUtil.getNetworkName(context)).append("&imei=").append(DeviceInfoUtil.getIMEI(context)).append("&mcc=").append(DeviceInfoUtil.getSimMCC(context)).append("&mnc=").append(DeviceInfoUtil.getSimMNC(context)).append("&uptime2=").append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    public static int getOemId(Context context) {
        if (sOemId == -289657543) {
            try {
                XmlResourceParser xml = context.getResources().getXml(C1692R.xml.default_settings);
                while (true) {
                    int next = xml.next();
                    if (next == 2) {
                        if (xml.getName().equals("setting")) {
                            int attributeCount = xml.getAttributeCount();
                            for (next = 0; next < attributeCount; next++) {
                                String attributeName = xml.getAttributeName(next);
                                String attributeValue = xml.getAttributeValue(next);
                                if (attributeName.equals("oemid")) {
                                    sOemId = Integer.valueOf(attributeValue).intValue();
                                }
                            }
                        }
                    } else if (next == 1) {
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        return sOemId;
    }

    private static synchronized String getPublicData(Context context) {
        String str;
        synchronized (InfocSupportContext.class) {
            if (sPublicDataString == null) {
                sPublicDataString = createPublicData(context);
            }
            str = sPublicDataString;
        }
        return str;
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public C1820a getEnv() {
        return new InfocEnvironment();
    }

    public C2244m getPublicBean() {
        return new C2244m(this.mApplicationContext);
    }

    public String getPublicData() {
        return getPublicData(this.mApplicationContext);
    }

    public Boolean isDebugMode() {
        return Boolean.valueOf(false);
    }
}
