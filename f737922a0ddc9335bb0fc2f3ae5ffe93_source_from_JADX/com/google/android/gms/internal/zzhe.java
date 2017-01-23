package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@eh
public class zzhe extends Handler {
    private final ds j6;

    public zzhe(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this(new zzhf(context));
    }

    public zzhe(ds dsVar) {
        this.j6 = dsVar;
    }

    private void j6(JSONObject jSONObject) {
        try {
            this.j6.j6(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    j6(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
