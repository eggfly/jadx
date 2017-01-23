package com.appfour.common.gcm;

import android.os.Bundle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class d {
    public final String DW;
    public final String FH;
    public final String Hw;
    public final GregorianCalendar Zo;
    public final String j6;
    public final String v5;

    public static d j6(Bundle bundle) {
        if (1 != Integer.parseInt(bundle.getString("notificationVersion"))) {
            return null;
        }
        String string = bundle.getString("notificationId");
        String string2 = bundle.getString("notificationTitle");
        String string3 = bundle.getString("notificationText");
        String string4 = bundle.getString("notificationTickerText");
        String string5 = bundle.getString("notificationProductId");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(bundle.getString("notificationValidUntil")));
            return new d(string, string2, string3, string4, string5, gregorianCalendar);
        } catch (ParseException e) {
            return null;
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, GregorianCalendar gregorianCalendar) {
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = str4;
        this.v5 = str5;
        this.Zo = gregorianCalendar;
    }
}
