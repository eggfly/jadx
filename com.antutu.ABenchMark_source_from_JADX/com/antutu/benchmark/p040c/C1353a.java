package com.antutu.benchmark.p040c;

import android.content.Context;
import android.os.Build;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.benchmark.modelreflact.AddCommentModel;
import com.antutu.benchmark.modelreflact.AddCommentModel.DataEntity.CmtinfoEntity;
import com.antutu.benchmark.modelreflact.CommentNotRedResponseModel;
import com.antutu.benchmark.modelreflact.CommentResponseModel;
import com.antutu.benchmark.modelreflact.CommentResponseModel.DataBean;
import com.antutu.benchmark.modelreflact.CommentSendResponseModel;
import com.antutu.benchmark.modelreflact.CommonResponseModel;
import com.antutu.benchmark.modelreflact.OtherCommentResponseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.HttpRequestTask;
import com.antutu.utils.JsonParseUtil;
import com.antutu.utils.PointMark;
import com.antutu.utils.RequestListener;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;

/* renamed from: com.antutu.benchmark.c.a */
public class C1353a {
    private Context f4631a;

    /* renamed from: com.antutu.benchmark.c.a.1 */
    class C13441 implements RequestListener {
        final /* synthetic */ C1095a f4613a;
        final /* synthetic */ C1353a f4614b;

        C13441(C1353a c1353a, C1095a c1095a) {
            this.f4614b = c1353a;
            this.f4613a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4613a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4613a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    Object obj = (CommentResponseModel) JsonParseUtil.parse(jni.getStringSafe(str, BuildConfig.FLAVOR), CommentResponseModel.class);
                    if (obj.getIsdata() != 1) {
                        this.f4613a.m4843a(obj.getDesc());
                    } else {
                        this.f4613a.m4842a(obj);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.2 */
    class C13452 implements RequestListener {
        final /* synthetic */ C1095a f4615a;
        final /* synthetic */ C1353a f4616b;

        C13452(C1353a c1353a, C1095a c1095a) {
            this.f4616b = c1353a;
            this.f4615a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4615a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4615a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4615a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4615a.m4842a(((AddCommentModel) JsonParseUtil.parse(stringSafe, AddCommentModel.class)).getData().getCmtinfo());
                } catch (Exception e) {
                    this.f4615a.m4843a(BuildConfig.FLAVOR);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.3 */
    class C13463 implements RequestListener {
        final /* synthetic */ C1095a f4617a;
        final /* synthetic */ C1353a f4618b;

        C13463(C1353a c1353a, C1095a c1095a) {
            this.f4618b = c1353a;
            this.f4617a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4617a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4617a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4617a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4617a.m4842a(((CommentResponseModel) JsonParseUtil.parse(stringSafe, CommentResponseModel.class)).getData());
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.4 */
    class C13474 implements RequestListener {
        final /* synthetic */ C1095a f4619a;
        final /* synthetic */ C1353a f4620b;

        C13474(C1353a c1353a, C1095a c1095a) {
            this.f4620b = c1353a;
            this.f4619a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4619a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4619a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4619a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4619a.m4842a(((CommentResponseModel) JsonParseUtil.parse(stringSafe, CommentResponseModel.class)).getData());
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.5 */
    class C13485 implements RequestListener {
        final /* synthetic */ C1095a f4621a;
        final /* synthetic */ C1353a f4622b;

        C13485(C1353a c1353a, C1095a c1095a) {
            this.f4622b = c1353a;
            this.f4621a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4621a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4621a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4621a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4621a.m4842a((CommentSendResponseModel) JsonParseUtil.parse(stringSafe, CommentSendResponseModel.class));
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.6 */
    class C13496 implements RequestListener {
        final /* synthetic */ C1095a f4623a;
        final /* synthetic */ C1353a f4624b;

        C13496(C1353a c1353a, C1095a c1095a) {
            this.f4624b = c1353a;
            this.f4623a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4623a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4623a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4623a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4623a.m4842a((CommentSendResponseModel) JsonParseUtil.parse(stringSafe, CommentSendResponseModel.class));
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.7 */
    class C13507 implements RequestListener {
        final /* synthetic */ C1095a f4625a;
        final /* synthetic */ C1353a f4626b;

        C13507(C1353a c1353a, C1095a c1095a) {
            this.f4626b = c1353a;
            this.f4625a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4625a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4625a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    Object obj = (OtherCommentResponseModel) JsonParseUtil.parse(jni.getStringSafe(str, BuildConfig.FLAVOR), OtherCommentResponseModel.class);
                    if (obj.getIsdata() != 1) {
                        this.f4625a.m4843a(obj.getDesc());
                    } else {
                        this.f4625a.m4842a(obj);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.8 */
    class C13518 implements RequestListener {
        final /* synthetic */ C1095a f4627a;
        final /* synthetic */ C1353a f4628b;

        C13518(C1353a c1353a, C1095a c1095a) {
            this.f4628b = c1353a;
            this.f4627a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4627a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4627a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    Object obj = (CommonResponseModel) JsonParseUtil.parse(jni.getStringSafe(str, BuildConfig.FLAVOR), CommonResponseModel.class);
                    if (obj.getIsdata() != 1) {
                        this.f4627a.m4843a(obj.getDesc());
                    } else {
                        this.f4627a.m4842a(obj);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.a.9 */
    class C13529 implements RequestListener {
        final /* synthetic */ C1095a f4629a;
        final /* synthetic */ C1353a f4630b;

        C13529(C1353a c1353a, C1095a c1095a) {
            this.f4630b = c1353a;
            this.f4629a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4629a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4629a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4629a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4629a.m4842a(((CommentNotRedResponseModel) JsonParseUtil.parse(stringSafe, CommentNotRedResponseModel.class)).getData());
                } catch (Exception e) {
                }
            }
        }
    }

    public C1353a(Context context) {
        this.f4631a = context;
    }

    public void m5410a(int i, C1095a<CommentSendResponseModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put("uid", Long.valueOf(C1503b.m5915c().m5973z()));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        hashMap.put(ModelFields.PAGE, Integer.valueOf(i));
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?&action=modelcmt&data=1&act=published", new C13485(this, c1095a)).submit();
    }

    public void m5411a(int i, String str, C1095a<CmtinfoEntity> c1095a) {
        String cPUSerial = Utils.getCPUSerial();
        HashMap hashMap = new HashMap();
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put(Constants.KEY_BRAND, Build.BRAND);
        hashMap.put(Constants.KEY_MODEL, Build.MODEL);
        hashMap.put("device", Build.DEVICE);
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        hashMap.put("cpuid", cPUSerial);
        hashMap.put("level", Integer.valueOf(i));
        hashMap.put("content", str);
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?action=modelcmt&act=cmt&data=1", new C13452(this, c1095a)).submit();
    }

    public void m5412a(long j, int i, C1095a<CommentResponseModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("version_api", "1.2");
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put(PointMark.T_MODELID, Long.valueOf(j));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        hashMap.put("last_id", Integer.valueOf(i));
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?action=modelcmt&act=cmtlist&data=1", new C13441(this, c1095a)).submit();
    }

    public void m5413a(long j, int i, String str, C1095a<DataBean> c1095a) {
        String str2 = "http://bu.antutu.net/api/?action=modelcmt&act=reply&data=1";
        HashMap hashMap = new HashMap();
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put(PointMark.T_MODELID, Long.valueOf(j));
        hashMap.put("reply_id", Integer.valueOf(i));
        hashMap.put("content", str);
        long z = C1503b.m5915c().m5973z();
        if (z == -1) {
            hashMap.put(Constants.KEY_BRAND, Build.BRAND);
            hashMap.put(Constants.KEY_MODEL, Build.MODEL);
            hashMap.put("device", Build.DEVICE);
            hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
            hashMap.put("cpuid", Utils.getCPUSerial());
        } else {
            hashMap.put("uid", Long.valueOf(z));
        }
        new HttpRequestTask(hashMap, str2, new C13474(this, c1095a)).submit();
    }

    public void m5414a(long j, C1095a<DataBean> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put("version_api", "1.1");
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put(PointMark.T_MODELID, Long.valueOf(j));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?action=modelcmt&act=hotcmtlist&data=1", new C13463(this, c1095a)).submit();
    }

    public void m5415a(C1095a<OtherCommentResponseModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?&action=modelcmt&data=1&act=moremodel", new C13507(this, c1095a)).submit();
    }

    public void m5416a(boolean z, int i, C1095a<CommonResponseModel> c1095a) {
        String str = z ? "http://bu.antutu.net/api/?action=modelcmt&act=zan&data=1" : "http://bu.antutu.net/api/?action=modelcmt&act=zancancel&data=1";
        HashMap hashMap = new HashMap();
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put(PointMark.T_MODELID, Long.valueOf(C1503b.m5915c().m5960n(this.f4631a)));
        hashMap.put("cmt_id", Integer.valueOf(i));
        long z2 = C1503b.m5915c().m5973z();
        if (z2 == -1) {
            hashMap.put(Constants.KEY_BRAND, Build.BRAND);
            hashMap.put(Constants.KEY_MODEL, Build.MODEL);
            hashMap.put("device", Build.DEVICE);
            hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
            hashMap.put("cpuid", Utils.getCPUSerial());
        } else {
            hashMap.put("uid", Long.valueOf(z2));
        }
        new HttpRequestTask(hashMap, str, new C13518(this, c1095a)).submit();
    }

    public void m5417b(int i, C1095a<CommentSendResponseModel> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put("uid", Long.valueOf(C1503b.m5915c().m5973z()));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        hashMap.put(ModelFields.PAGE, Integer.valueOf(i));
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?&action=modelcmt&data=1&act=received", new C13496(this, c1095a)).submit();
    }

    public void m5418b(C1095a<CommentNotRedResponseModel.DataBean> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguage(this.f4631a));
        hashMap.put("uid", Long.valueOf(C1503b.m5915c().m5973z()));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4631a, true));
        new HttpRequestTask(hashMap, "http://bu.antutu.net/api/?&action=modelcmt&data=1&act=remind", new C13529(this, c1095a)).submit();
    }
}
