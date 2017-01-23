package com.github.mikephil.charting.p039d;

import com.github.mikephil.charting.p138c.C2541g;
import java.text.DecimalFormat;
import org.android.agoo.message.MessageService;

/* renamed from: com.github.mikephil.charting.d.d */
public class C2558d implements C2557h {
    private DecimalFormat f8914a;

    public C2558d(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(MessageService.MSG_DB_READY_REPORT);
        }
        this.f8914a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String m9741a(float f, C2541g c2541g) {
        return this.f8914a.format((double) f);
    }
}
