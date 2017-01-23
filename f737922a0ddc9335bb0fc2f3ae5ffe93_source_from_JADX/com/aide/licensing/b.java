package com.aide.licensing;

import android.text.TextUtils;
import io;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class b {
    public long DW;
    public String FH;
    public String Hw;
    public String VH;
    public long Zo;
    public long gn;
    public int j6;
    public long u7;
    public String v5;

    public static b j6(String str) {
        String str2;
        int indexOf = str.indexOf(58);
        if (-1 == indexOf) {
            str2 = "";
        } else {
            String substring = str.substring(0, indexOf);
            str2 = indexOf >= str.length() ? "" : str.substring(indexOf + 1);
            str = substring;
        }
        String[] split = TextUtils.split(str, Pattern.quote("|"));
        if (split.length < 6) {
            throw new IllegalArgumentException("Wrong number of fields.");
        }
        b bVar = new b();
        bVar.VH = str2;
        bVar.j6 = Integer.parseInt(split[0]);
        bVar.DW = Long.parseLong(split[1]);
        bVar.FH = split[2];
        bVar.Hw = split[3];
        bVar.v5 = split[4];
        bVar.Zo = Long.parseLong(split[5]);
        io.j6("timestamp: " + new Date(bVar.Zo).toString());
        if (bVar.j6 == 0 || bVar.j6 == 2) {
            Map hashMap = new HashMap();
            try {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI("?" + bVar.VH), "UTF-8")) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
                bVar.gn = Long.parseLong((String) hashMap.get("VT"));
                bVar.u7 = Long.parseLong((String) hashMap.get("GT"));
                io.j6("validity timestamp: " + new Date(bVar.gn).toString());
                io.j6("grace timestamp: " + new Date(bVar.u7).toString());
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }
        return bVar;
    }

    public String toString() {
        return TextUtils.join("|", new Object[]{Integer.valueOf(this.j6), Long.valueOf(this.DW), this.FH, this.Hw, this.v5, Long.valueOf(this.Zo)});
    }
}
