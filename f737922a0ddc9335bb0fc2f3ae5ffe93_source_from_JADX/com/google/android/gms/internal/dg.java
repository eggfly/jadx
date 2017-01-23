package com.google.android.gms.internal;

import aeq$c;
import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import java.util.Map;

@eh
public class dg extends dm {
    private final Context DW;
    private String FH;
    private long Hw;
    private String VH;
    private String Zo;
    private final Map<String, String> j6;
    private long v5;

    class 1 implements OnClickListener {
        final /* synthetic */ dg j6;

        1(dg dgVar) {
            this.j6 = dgVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            f.FH().j6(this.j6.DW, this.j6.DW());
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ dg j6;

        2(dg dgVar) {
            this.j6 = dgVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.DW("Operation denied by user.");
        }
    }

    public dg(fj fjVar, Map<String, String> map) {
        super(fjVar, "createCalendarEvent");
        this.j6 = map;
        this.DW = fjVar.VH();
        FH();
    }

    private void FH() {
        this.FH = j6("description");
        this.Zo = j6("summary");
        this.Hw = v5("start_ticks");
        this.v5 = v5("end_ticks");
        this.VH = j6("location");
    }

    private String j6(String str) {
        return TextUtils.isEmpty((CharSequence) this.j6.get(str)) ? "" : (String) this.j6.get(str);
    }

    private long v5(String str) {
        String str2 = (String) this.j6.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @TargetApi(14)
    Intent DW() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.FH);
        data.putExtra("eventLocation", this.VH);
        data.putExtra("description", this.Zo);
        if (this.Hw > -1) {
            data.putExtra("beginTime", this.Hw);
        }
        if (this.v5 > -1) {
            data.putExtra("endTime", this.v5);
        }
        data.setFlags(268435456);
        return data;
    }

    public void j6() {
        if (this.DW == null) {
            DW("Activity context is not available.");
        } else if (f.FH().FH(this.DW).Zo()) {
            Builder DW = f.FH().DW(this.DW);
            Resources Hw = f.Zo().Hw();
            DW.setTitle(Hw != null ? Hw.getString(aeq$c.create_calendar_title) : "Create calendar event");
            DW.setMessage(Hw != null ? Hw.getString(aeq$c.create_calendar_message) : "Allow Ad to create a calendar event?");
            DW.setPositiveButton(Hw != null ? Hw.getString(aeq$c.accept) : "Accept", new 1(this));
            DW.setNegativeButton(Hw != null ? Hw.getString(aeq$c.decline) : "Decline", new 2(this));
            DW.create().show();
        } else {
            DW("This feature is not available on the device.");
        }
    }
}
