package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C2686R;
import com.google.android.gms.ads.internal.C2968s;
import com.igexin.download.Downloads;
import com.umeng.message.MsgConstant;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.ek */
public class ek extends eq {
    private final Map<String, String> f10764a;
    private final Context f10765b;
    private String f10766c;
    private long f10767d;
    private long f10768e;
    private String f10769f;
    private String f10770g;

    /* renamed from: com.google.android.gms.b.ek.1 */
    class C31651 implements OnClickListener {
        final /* synthetic */ ek f10760a;

        C31651(ek ekVar) {
            this.f10760a = ekVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C2968s.m11525e().m13033a(this.f10760a.f10765b, this.f10760a.m12597b());
        }
    }

    /* renamed from: com.google.android.gms.b.ek.2 */
    class C31662 implements OnClickListener {
        final /* synthetic */ ek f10761a;

        C31662(ek ekVar) {
            this.f10761a = ekVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10761a.m12589b("Operation denied by user.");
        }
    }

    public ek(ii iiVar, Map<String, String> map) {
        super(iiVar, "createCalendarEvent");
        this.f10764a = map;
        this.f10765b = iiVar.m13243f();
        m12594c();
    }

    private String m12593a(String str) {
        return TextUtils.isEmpty((CharSequence) this.f10764a.get(str)) ? BuildConfig.FLAVOR : (String) this.f10764a.get(str);
    }

    private void m12594c() {
        this.f10766c = m12593a(Downloads.COLUMN_DESCRIPTION);
        this.f10769f = m12593a("summary");
        this.f10767d = m12595e("start_ticks");
        this.f10768e = m12595e("end_ticks");
        this.f10770g = m12593a(MsgConstant.KEY_LOCATION_PARAMS);
    }

    private long m12595e(String str) {
        String str2 = (String) this.f10764a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void m12596a() {
        if (this.f10765b == null) {
            m12589b("Activity context is not available.");
        } else if (C2968s.m11525e().m13066e(this.f10765b).m11781f()) {
            Builder d = C2968s.m11525e().m13063d(this.f10765b);
            d.setTitle(C2968s.m11528h().m12932a(C2686R.string.create_calendar_title, "Create calendar event"));
            d.setMessage(C2968s.m11528h().m12932a(C2686R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            d.setPositiveButton(C2968s.m11528h().m12932a(C2686R.string.accept, HttpRequest.f14552e), new C31651(this));
            d.setNegativeButton(C2968s.m11528h().m12932a(C2686R.string.decline, "Decline"), new C31662(this));
            d.create().show();
        } else {
            m12589b("This feature is not available on the device.");
        }
    }

    @TargetApi(14)
    Intent m12597b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(Downloads.COLUMN_TITLE, this.f10766c);
        data.putExtra("eventLocation", this.f10770g);
        data.putExtra(Downloads.COLUMN_DESCRIPTION, this.f10769f);
        if (this.f10767d > -1) {
            data.putExtra("beginTime", this.f10767d);
        }
        if (this.f10768e > -1) {
            data.putExtra("endTime", this.f10768e);
        }
        data.setFlags(268435456);
        return data;
    }
}
