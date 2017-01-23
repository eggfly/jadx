package com.antutu.benchmark.p040c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.benchmark.modelreflact.CommonResponseModel;
import com.antutu.benchmark.modelreflact.ExposureResponseModel;
import com.antutu.benchmark.modelreflact.ExposureResponseModel.DataEntity;
import com.antutu.benchmark.modelreflact.HomeFlagResponseModel;
import com.antutu.benchmark.modelreflact.PhoneNotiModel;
import com.antutu.benchmark.modelreflact.PhoneNotiResponseModel;
import com.antutu.benchmark.modelreflact.PraiseModel;
import com.antutu.benchmark.modelreflact.PraiseResponseModel;
import com.antutu.benchmark.modelreflact.ShareInfoModel;
import com.antutu.benchmark.modelreflact.ShareInfoResponseModel;
import com.antutu.benchmark.modelreflact.TestResultResponseModel;
import com.antutu.benchmark.modelreflact.WxMainModel;
import com.antutu.benchmark.modelreflact.WxMainResponseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.HttpRequestTask;
import com.antutu.utils.IO;
import com.antutu.utils.JsonParseUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.antutu.utils.RequestListener;
import com.antutu.utils.SPConstants;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.c.d */
public class C1371d {
    private Context f4664a;

    /* renamed from: com.antutu.benchmark.c.d.1 */
    class C13631 implements RequestListener {
        final /* synthetic */ C1095a f4648a;
        final /* synthetic */ C1371d f4649b;

        C13631(C1371d c1371d, C1095a c1095a) {
            this.f4649b = c1371d;
            this.f4648a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4648a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4648a.m4843a(BuildConfig.FLAVOR);
            } else {
                this.f4648a.m4842a((Object) str);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.2 */
    class C13642 implements RequestListener {
        final /* synthetic */ C1095a f4650a;
        final /* synthetic */ C1371d f4651b;

        C13642(C1371d c1371d, C1095a c1095a) {
            this.f4651b = c1371d;
            this.f4650a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4650a.m4843a(BuildConfig.FLAVOR);
                return;
            }
            String sharedPreferencesString = Methods.getSharedPreferencesString("get_phone_praise_cache", null);
            if (str == null && sharedPreferencesString == null) {
                this.f4650a.m4843a(BuildConfig.FLAVOR);
                return;
            }
            if (str != null) {
                Methods.editSharedPreferences("get_phone_praise_cache", str);
            } else {
                str = sharedPreferencesString;
            }
            try {
                String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                if (commonResponseModel.getIsdata() != 1) {
                    this.f4650a.m4843a(commonResponseModel.getDesc());
                    return;
                }
                PraiseResponseModel praiseResponseModel = (PraiseResponseModel) JsonParseUtil.parse(stringSafe, PraiseResponseModel.class);
                try {
                    Methods.editSharedPreferences(SPConstants.SHARE_PREF_KEY_MODEL_ID, (long) praiseResponseModel.getData().getMid().intValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f4650a.m4842a(praiseResponseModel.getData());
            } catch (Exception e2) {
                this.f4650a.m4843a(BuildConfig.FLAVOR);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.3 */
    class C13653 implements RequestListener {
        final /* synthetic */ C1095a f4652a;
        final /* synthetic */ C1371d f4653b;

        C13653(C1371d c1371d, C1095a c1095a) {
            this.f4653b = c1371d;
            this.f4652a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4652a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4652a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4652a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4652a.m4842a(((ShareInfoResponseModel) JsonParseUtil.parse(stringSafe, ShareInfoResponseModel.class)).getData().getSharedinfo());
                } catch (Exception e) {
                    this.f4652a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.4 */
    class C13664 implements RequestListener {
        final /* synthetic */ C1095a f4654a;
        final /* synthetic */ C1371d f4655b;

        C13664(C1371d c1371d, C1095a c1095a) {
            this.f4655b = c1371d;
            this.f4654a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4654a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4654a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4654a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4654a.m4842a((HomeFlagResponseModel) JsonParseUtil.parse(stringSafe, HomeFlagResponseModel.class));
                } catch (Exception e) {
                    this.f4654a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.5 */
    class C13675 implements RequestListener {
        final /* synthetic */ C1095a f4656a;
        final /* synthetic */ C1371d f4657b;

        C13675(C1371d c1371d, C1095a c1095a) {
            this.f4657b = c1371d;
            this.f4656a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4656a.m4843a(BuildConfig.FLAVOR);
                return;
            }
            String sharedPreferencesString = Methods.getSharedPreferencesString("getNewPhoneExposure_cache", str);
            if (str == null && sharedPreferencesString == null) {
                this.f4656a.m4843a(BuildConfig.FLAVOR);
                return;
            }
            if (str == null) {
                str = sharedPreferencesString;
            } else {
                Methods.editSharedPreferences("getNewPhoneExposure_cache", str);
            }
            try {
                String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                if (commonResponseModel.getIsdata() != 1) {
                    this.f4656a.m4843a(commonResponseModel.getDesc());
                    return;
                }
                this.f4656a.m4842a(((ExposureResponseModel) JsonParseUtil.parse(stringSafe, ExposureResponseModel.class)).getData());
            } catch (Exception e) {
                this.f4656a.m4843a(BuildConfig.FLAVOR);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.6 */
    class C13686 implements RequestListener {
        final /* synthetic */ C1095a f4658a;
        final /* synthetic */ C1371d f4659b;

        C13686(C1371d c1371d, C1095a c1095a) {
            this.f4659b = c1371d;
            this.f4658a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4658a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4658a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4658a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4658a.m4842a(((WxMainResponseModel) JsonParseUtil.parse(stringSafe, WxMainResponseModel.class)).getData());
                } catch (Exception e) {
                    this.f4658a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.7 */
    class C13697 implements RequestListener {
        final /* synthetic */ C1095a f4660a;
        final /* synthetic */ C1371d f4661b;

        C13697(C1371d c1371d, C1095a c1095a) {
            this.f4661b = c1371d;
            this.f4660a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4660a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4660a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4660a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4660a.m4842a((TestResultResponseModel) JsonParseUtil.parse(stringSafe, TestResultResponseModel.class));
                } catch (Exception e) {
                    this.f4660a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.d.8 */
    class C13708 implements RequestListener {
        final /* synthetic */ C1095a f4662a;
        final /* synthetic */ C1371d f4663b;

        C13708(C1371d c1371d, C1095a c1095a) {
            this.f4663b = c1371d;
            this.f4662a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4662a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4662a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4662a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4662a.m4842a(((PhoneNotiResponseModel) JsonParseUtil.parse(stringSafe, PhoneNotiResponseModel.class)).getData());
                } catch (Exception e) {
                    this.f4662a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    public C1371d(Context context) {
        this.f4664a = context;
    }

    public void m5429a(C1095a<PraiseModel> c1095a) {
        String cPUSerial = Utils.getCPUSerial();
        HashMap hashMap = new HashMap();
        hashMap.put("cfos", C0714a.ANDROID);
        hashMap.put(Constants.KEY_BRAND, Build.BRAND);
        hashMap.put(Constants.KEY_MODEL, Build.MODEL);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("cpuid", cPUSerial);
        hashMap.put("score", Integer.valueOf(C1503b.m5915c().m5967t()));
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?action=getmodel&act=model", new C13642(this, c1095a)).submit();
    }

    public void m5430a(C1095a<String> c1095a, String str) {
        new HttpRequestTask(new HashMap(), "http://autovote.antutu.net/other/getdata.php?ftype=" + str, new C13631(this, c1095a)).submit();
    }

    public void m5431b(C1095a<HomeFlagResponseModel> c1095a) {
        String str = "http://interface.antutu.net/proMoudule/index.php?action=label&act=done&data=1";
        HashMap hashMap = new HashMap();
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        hashMap.put("cfos", C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLanguage(this.f4664a));
        hashMap.put("version_os", VERSION.RELEASE);
        hashMap.put("version_app", Utils.getVersionCode());
        hashMap.put("istest", Integer.valueOf(C1503b.m5915c().m5967t() > 0 ? 1 : 0));
        new HttpRequestTask(hashMap, str, new C13664(this, c1095a)).submit();
    }

    public void m5432b(C1095a<ShareInfoModel> c1095a, String str) {
        Object obj = null;
        String str2 = "http://autovote.antutu.net/antuapi.php?m=more&c=shareapi&a=get_score_info";
        String x = C1503b.m5915c().m5971x();
        try {
            obj = new JSONObject(jni.getStringSafe(jni.benchmarkGetData(this.f4664a, IO.getJaonStr(this.f4664a)), null)).get("tid").toString();
        } catch (Exception e) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("version_api", "1.1");
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(AgooConstants.MESSAGE_ID, x);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageLower(this.f4664a));
        hashMap.put("tid", obj);
        if (str != null) {
            hashMap.put("level", str);
        }
        hashMap.put("score", Integer.valueOf(C1503b.m5915c().m5967t()));
        hashMap.put(Constants.KEY_MODEL, Build.MODEL);
        hashMap.put("cpu_score", Integer.valueOf(C1503b.m5915c().m5932b(this.f4664a)));
        hashMap.put("mem_score", Integer.valueOf(jni.benchmarkScore(this.f4664a, 30)));
        hashMap.put("3d_score", Integer.valueOf(C1503b.m5915c().m5936c(this.f4664a)));
        new HttpRequestTask(hashMap, str2, new C13653(this, c1095a)).submit();
    }

    public void m5433c(C1095a<DataEntity> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        hashMap.put("cfos", C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLanguage(this.f4664a));
        hashMap.put("version_os", VERSION.RELEASE);
        hashMap.put("version_app", Utils.getVersionCode());
        new HttpRequestTask(hashMap, "http://interface.antutu.net/proMoudule/index.php?action=newmodel&act=done&data=1", new C13675(this, c1095a)).submit();
    }

    public void m5434d(C1095a<WxMainModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put("stype", "get_wx");
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageLower(this.f4664a));
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/proMoudule/index.php?action=getmore&act=done&data=1", new C13686(this, c1095a)).submit();
    }

    public void m5435e(C1095a<TestResultResponseModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageInt(this.f4664a));
        hashMap.put("version_app", Utils.getVersionCode());
        hashMap.put("version_api", Integer.valueOf(6000005));
        hashMap.put(ModelFields.PAGE, Integer.valueOf(1));
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        hashMap.put("sort", Integer.valueOf(100028));
        hashMap.put(Constants.KEY_BRAND, Build.BRAND);
        hashMap.put(Constants.KEY_MODEL, Build.MODEL);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("cpuid", C1503b.m5915c().m5961n());
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/antuapi.php?m=content&c=infoapi&a=recmdindex", new C13697(this, c1095a)).submit();
    }

    public void m5436f(C1095a<PhoneNotiModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put("cfos", C0714a.ANDROID);
        hashMap.put(Constants.KEY_BRAND, Build.BRAND);
        hashMap.put(Constants.KEY_MODEL, Build.MODEL);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("cpuid", C1503b.m5915c().m5961n());
        new HttpRequestTask(hashMap, "http://gujiguji.antutu.net/proMoudule/?action=more&act=getprice&data=1", new C13708(this, c1095a)).submit();
    }
}
