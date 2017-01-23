package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import org.android.agoo.common.C4575b;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: org.android.agoo.control.a */
class C4582a implements Runnable {
    final /* synthetic */ byte[] f16413a;
    final /* synthetic */ String f16414b;
    final /* synthetic */ AgooFactory f16415c;

    C4582a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.f16415c = agooFactory;
        this.f16413a = bArr;
        this.f16414b = str;
    }

    public void run() {
        CharSequence charSequence = null;
        try {
            String str = new String(this.f16413a, "utf-8");
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String str2 = null;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        str2 = jSONObject.getString("i");
                        charSequence = jSONObject.getString("p");
                    }
                }
                if (ALog.isPrintLog(Level.I)) {
                    ALog.m16904i("AgooFactory", "saveMsg msgId:" + str2 + ",message=" + str + ",currentPack=" + charSequence + ",reportTimes=" + C4575b.m19248c(AgooFactory.mContext), new Object[0]);
                }
                if (!TextUtils.isEmpty(charSequence) && TextUtils.equals(charSequence, AgooFactory.mContext.getPackageName())) {
                    if (TextUtils.isEmpty(this.f16414b)) {
                        this.f16415c.messageService.m19274a(str2, str, MessageService.MSG_DB_READY_REPORT);
                    } else {
                        this.f16415c.messageService.m19274a(str2, str, this.f16414b);
                    }
                }
            }
        } catch (Throwable th) {
            ALog.m16903e("AgooFactory", "saveMsg fail:" + th.toString(), new Object[0]);
        }
    }
}
