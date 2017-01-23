package com.google.android.gms.p146b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.ez */
public class ez extends Handler {
    private final ex f10831a;

    public ez(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this(new fa(context));
    }

    public ez(ex exVar) {
        this.f10831a = exVar;
    }

    private void m12664a(JSONObject jSONObject) {
        try {
            this.f10831a.m12660a(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString(Constants.KEY_DATA));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    m12664a(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
