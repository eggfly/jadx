package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2968s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.dq */
public class dq {
    public List<String> m12342a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void m12343a(Context context, String str, gx gxVar, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT;
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", gxVar.f11194q.f10655f).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", C2968s.m11528h().m12931a()).replaceAll("@gw_seqnum@", gxVar.f11186i);
                if (gxVar.f11191n != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", gxVar.f11191n.f10636b).replaceAll("@gw_allocid@", gxVar.f11191n.f10638d);
                }
                new hq(context, str, replaceAll2).m10975g();
            }
        }
    }
}
