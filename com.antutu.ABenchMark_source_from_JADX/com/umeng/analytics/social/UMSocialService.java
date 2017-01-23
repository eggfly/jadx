package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONObject;

public abstract class UMSocialService {

    /* renamed from: com.umeng.analytics.social.UMSocialService.a */
    private static class C4182a extends AsyncTask<Void, Void, C4187d> {
        String f14047a;
        String f14048b;
        C4183b f14049c;
        UMPlatformData[] f14050d;

        public C4182a(String[] strArr, C4183b c4183b, UMPlatformData[] uMPlatformDataArr) {
            this.f14047a = strArr[0];
            this.f14048b = strArr[1];
            this.f14049c = c4183b;
            this.f14050d = uMPlatformDataArr;
        }

        protected C4187d m17048a(Void... voidArr) {
            try {
                JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(this.f14048b) ? C4186c.m17065a(this.f14047a) : C4186c.m17066a(this.f14047a, this.f14048b));
                int optInt = jSONObject.optInt("st");
                C4187d c4187d = new C4187d(optInt == 0 ? C4188e.f14077t : optInt);
                String optString = jSONObject.optString(XAdErrorCode.ERROR_CODE_MESSAGE);
                if (!TextUtils.isEmpty(optString)) {
                    c4187d.m17069a(optString);
                }
                Object optString2 = jSONObject.optString(Constants.KEY_DATA);
                if (TextUtils.isEmpty(optString2)) {
                    return c4187d;
                }
                c4187d.m17071b(optString2);
                return c4187d;
            } catch (Exception e) {
                return new C4187d(-99, e);
            }
        }

        protected void m17049a(C4187d c4187d) {
            if (this.f14049c != null) {
                this.f14049c.m17051a(c4187d, this.f14050d);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m17048a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m17049a((C4187d) obj);
        }

        protected void onPreExecute() {
            if (this.f14049c != null) {
                this.f14049c.m17050a();
            }
        }
    }

    /* renamed from: com.umeng.analytics.social.UMSocialService.b */
    public interface C4183b {
        void m17050a();

        void m17051a(C4187d c4187d, UMPlatformData... uMPlatformDataArr);
    }

    private static void m17052a(Context context, C4183b c4183b, String str, UMPlatformData... uMPlatformDataArr) {
        int i = 0;
        if (uMPlatformDataArr != null) {
            try {
                int length = uMPlatformDataArr.length;
                while (i < length) {
                    if (uMPlatformDataArr[i].isValid()) {
                        i++;
                    } else {
                        throw new C4184a("parameter is not valid.");
                    }
                }
            } catch (Throwable e) {
                Log.e(C4156a.f13942d, "unable send event.", e);
                return;
            } catch (Throwable e2) {
                Log.e(C4156a.f13942d, BuildConfig.FLAVOR, e2);
                return;
            }
        }
        new C4182a(C4189f.m17078a(context, str, uMPlatformDataArr), c4183b, uMPlatformDataArr).execute(new Void[0]);
    }

    public static void share(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        m17052a(context, null, str, uMPlatformDataArr);
    }

    public static void share(Context context, UMPlatformData... uMPlatformDataArr) {
        m17052a(context, null, null, uMPlatformDataArr);
    }
}
