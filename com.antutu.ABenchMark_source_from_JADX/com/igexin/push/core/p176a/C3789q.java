package com.igexin.push.core.p176a;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3753l;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p180c.C3842f;
import com.igexin.push.p169f.p179a.C3915e;
import com.igexin.push.p174c.C3726e;
import com.igexin.push.p174c.C3730i;
import com.igexin.push.util.EncryptUtils;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.q */
public class C3789q extends C3773b {
    private static final String f12717a;

    static {
        f12717a = C3753l.f12646a + "_RedirectServerAction";
    }

    private void m15597a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str2.equals(str)) {
            C3688a.m15097b(f12717a + "|new location = " + str + "; pre location = " + str2 + ", send snl retire broadcast");
            Intent intent = new Intent();
            intent.setAction("com.igexin.sdk.action.snlretire");
            intent.putExtra("groupid", str2);
            intent.putExtra("branch", PushBuildConfig.sdk_conf_channelid);
            C3855g.f12969g.sendBroadcast(intent);
        }
    }

    private void m15598a(String str, JSONArray jSONArray) {
        try {
            C3688a.m15097b(f12717a + "|start fetch idc config, url : " + str);
            C3685c.m15060b().m15053a(new C3915e(new C3842f(str, jSONArray)), false, true);
        } catch (Exception e) {
            C3688a.m15097b(f12717a + e.toString());
        }
    }

    public static String[] m15599a(JSONArray jSONArray) {
        String[] strArr;
        Exception e;
        try {
            strArr = new String[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    strArr[i] = "http://" + jSONArray.getString(i);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            strArr = null;
            e = exception;
            C3688a.m15097b(f12717a + "|parseIDCConfigURL exception" + e.toString());
            return strArr;
        }
        return strArr;
    }

    public boolean m15600a(Object obj, JSONObject jSONObject) {
        C3688a.m15097b(f12717a + "|redirect server resp data : " + jSONObject);
        try {
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("redirect_server")) {
                long parseLong;
                String string = jSONObject.getString("delay");
                List arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("address_list");
                C3688a.m15097b("redirect|" + string + "|" + jSONArray.toString());
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string2 = jSONArray.getString(i);
                    int indexOf = string2.indexOf(44);
                    if (indexOf > 0) {
                        String substring = string2.substring(0, indexOf);
                        string2 = string2.substring(indexOf + 1);
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            long parseLong2 = Long.parseLong(string2);
                            C3726e c3726e = new C3726e();
                            c3726e.f12569a = "socket://" + substring;
                            c3726e.f12570b = (parseLong2 * 1000) + currentTimeMillis;
                            arrayList.add(c3726e);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
                try {
                    parseLong = Long.parseLong(string) * 1000;
                } catch (Exception e2) {
                    parseLong = 0;
                }
                if (parseLong >= 0) {
                    C3855g.f12941E = parseLong;
                }
                if (jSONObject.has("loc") && jSONObject.has("conf")) {
                    try {
                        String string3 = jSONObject.getString("loc");
                        string = C3855g.f12966d;
                        SDKUrlConfig.setLocation(string3);
                        if (C3754m.f12670n) {
                            m15597a(string3, string);
                        }
                        C3688a.m15097b(f12717a + " set group id : " + C3855g.f12966d);
                        JSONArray jSONArray2 = jSONObject.getJSONArray("conf");
                        String[] a = C3789q.m15599a(jSONArray2);
                        if (a != null && a.length > 0) {
                            String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                            if (idcConfigUrl != null && a[0].equals(idcConfigUrl[0])) {
                                C3688a.m15097b(f12717a + "|current idc config URL equals new fetch idc config URL");
                            } else if (C3855g.av == 0) {
                                m15598a(a[0], jSONArray2);
                            } else if (System.currentTimeMillis() - C3855g.av > 7200000) {
                                m15598a(a[0], jSONArray2);
                            } else {
                                C3688a.m15097b(f12717a + "|get idc cfg last time less than 2 hours return");
                            }
                        }
                    } catch (Exception e3) {
                        C3688a.m15097b(f12717a + e3.toString());
                    }
                }
                C3730i.m15273a().m15277e().m15258a(arrayList);
                C3777e.m15491a().m15548c(true);
                if (EncryptUtils.isLoadSuccess()) {
                    C3688a.m15097b(f12717a + "|redirect reInit so ~~~~~");
                    EncryptUtils.reset();
                }
            }
        } catch (Exception e32) {
            C3688a.m15097b(f12717a + e32.toString());
        }
        return true;
    }
}
