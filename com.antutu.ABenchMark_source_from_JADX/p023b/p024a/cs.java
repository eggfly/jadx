package p023b.p024a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;

/* renamed from: b.a.cs */
public class cs extends cn {
    private Context f2882a;

    public cs(Context context) {
        super(Constants.KEY_IMEI);
        this.f2882a = context;
    }

    public String m3803a() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2882a.getSystemService("phone");
        if (telephonyManager == null) {
        }
        try {
            return am.m3336a(this.f2882a, MsgConstant.PERMISSION_READ_PHONE_STATE) ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            return null;
        }
    }
}
