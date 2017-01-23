package com.antutu.benchmark.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.antutu.utils.InfocUtil;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.receiver.a */
public class C1602a extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("action.infoc.report".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("table");
            int i = -1;
            switch (stringExtra.hashCode()) {
                case 346057076:
                    if (stringExtra.equals("antutu_temp_main")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1655500174:
                    if (stringExtra.equals("antutu_temp_finish")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    InfocUtil.antutu_temp_main(context, intent.getIntExtra("temp_main", 0), intent.getIntExtra("app_select", 0));
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    InfocUtil.antutu_temp_finish(context, intent.getIntExtra("temp_finish", 0));
                default:
            }
        }
    }
}
