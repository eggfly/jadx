package com.github.mikephil.charting.p039d;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p145i.C2621g;
import java.text.DecimalFormat;
import org.android.agoo.message.MessageService;

/* renamed from: com.github.mikephil.charting.d.b */
public class C2554b implements C1202f {
    private DecimalFormat f8913a;

    public C2554b(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(MessageService.MSG_DB_READY_REPORT);
        }
        this.f8913a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String m9737a(float f, Entry entry, int i, C2621g c2621g) {
        return this.f8913a.format((double) f);
    }
}
