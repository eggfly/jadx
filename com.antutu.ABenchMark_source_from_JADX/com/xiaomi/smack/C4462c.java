package com.xiaomi.smack;

import com.antutu.redacc.C1692R;
import com.taobao.accs.common.Constants;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.smack.c */
public class C4462c {
    public static int m18486a(Throwable th) {
        Throwable a = (!(th instanceof C4477p) || ((C4477p) th).m18566a() == null) ? th : ((C4477p) th).m18566a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        return a instanceof SocketTimeoutException ? Constants.COMMAND_ELECTION : a instanceof SocketException ? message.indexOf("Network is unreachable") != -1 ? Constants.COMMAND_SEND_STATIST : message.indexOf("Connection refused") != -1 ? Constants.COMMAND_CONNECT_INFO : message.indexOf("Connection timed out") != -1 ? Constants.COMMAND_ELECTION : message.endsWith("EACCES (Permission denied)") ? Constants.COMMAND_RECEIVE_DATA : message.indexOf("Connection reset by peer") != -1 ? C1692R.styleable.AppCompatTheme_seekBarStyle : message.indexOf("Broken pipe") != -1 ? C1692R.styleable.AppCompatTheme_spinnerStyle : message.indexOf("No route to host") != -1 ? Constants.COMMAND_ANTI_BRUSH : message.endsWith("EINVAL (Invalid argument)") ? Constants.COMMAND_ROUTING_ACK : 199 : a instanceof UnknownHostException ? C1692R.styleable.AppCompatTheme_ratingBarStyleIndicator : th instanceof C4477p ? 399 : 0;
    }
}
