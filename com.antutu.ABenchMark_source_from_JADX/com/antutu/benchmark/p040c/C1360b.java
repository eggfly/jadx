package com.antutu.benchmark.p040c;

import android.content.Context;
import android.database.Cursor;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.benchmark.modelreflact.CommonResponseModel;
import com.antutu.benchmark.modelreflact.HotNewsBannerResponseModel;
import com.antutu.benchmark.modelreflact.HotNewsBannerResponseModel.DataBean;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.modelreflact.NewsResponseModel;
import com.antutu.benchmark.modelreflact.NewsResponseModel.DataEntity;
import com.antutu.benchmark.modelreflact.RedPointModel;
import com.antutu.benchmark.modelreflact.RedPointResponseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p041d.C1376c.C1375a;
import com.antutu.benchmark.p041d.C1380f;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.HttpRequestTask;
import com.antutu.utils.JsonParseUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.antutu.utils.RequestListener;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.google.analytics.tracking.android.ModelFields;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4210b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.antutu.benchmark.c.b */
public class C1360b {
    private Context f4644a;

    /* renamed from: com.antutu.benchmark.c.b.1 */
    class C13541 implements RequestListener {
        final /* synthetic */ C1095a f4632a;
        final /* synthetic */ C1360b f4633b;

        C13541(C1360b c1360b, C1095a c1095a) {
            this.f4633b = c1360b;
            this.f4632a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4632a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4632a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4632a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4632a.m4842a(((HotNewsBannerResponseModel) JsonParseUtil.parse(stringSafe, HotNewsBannerResponseModel.class)).getData());
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.b.2 */
    class C13552 implements RequestListener {
        final /* synthetic */ C1095a f4634a;
        final /* synthetic */ int f4635b;
        final /* synthetic */ C1360b f4636c;

        C13552(C1360b c1360b, C1095a c1095a, int i) {
            this.f4636c = c1360b;
            this.f4634a = c1095a;
            this.f4635b = i;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4634a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4634a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4634a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    NewsResponseModel newsResponseModel = (NewsResponseModel) JsonParseUtil.parse(stringSafe, NewsResponseModel.class);
                    this.f4634a.m4842a(newsResponseModel.getData());
                    if (this.f4635b == 1) {
                        this.f4636c.m5424b();
                    }
                    this.f4636c.m5423a(newsResponseModel.getData().getInfolist());
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.b.3 */
    class C13563 implements RequestListener {
        final /* synthetic */ C1095a f4637a;
        final /* synthetic */ C1360b f4638b;

        C13563(C1360b c1360b, C1095a c1095a) {
            this.f4638b = c1360b;
            this.f4637a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4637a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4637a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4637a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    this.f4637a.m4842a(((NewsResponseModel) JsonParseUtil.parse(stringSafe, NewsResponseModel.class)).getData());
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.b.4 */
    class C13574 implements RequestListener {
        final /* synthetic */ C1095a f4639a;
        final /* synthetic */ C1360b f4640b;

        C13574(C1360b c1360b, C1095a c1095a) {
            this.f4640b = c1360b;
            this.f4639a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4639a.m4843a(BuildConfig.FLAVOR);
                return;
            }
            try {
                String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                if (commonResponseModel.getIsdata() != 1) {
                    this.f4639a.m4843a(commonResponseModel.getDesc());
                    return;
                }
                this.f4639a.m4842a(((NewsResponseModel) JsonParseUtil.parse(stringSafe, NewsResponseModel.class)).getData());
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.c.b.5 */
    class C13585 implements RequestListener {
        final /* synthetic */ C1360b f4641a;

        C13585(C1360b c1360b) {
            this.f4641a = c1360b;
        }

        public void setRespond(int i, String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.c.b.6 */
    class C13596 implements RequestListener {
        final /* synthetic */ C1095a f4642a;
        final /* synthetic */ C1360b f4643b;

        C13596(C1360b c1360b, C1095a c1095a) {
            this.f4643b = c1360b;
            this.f4642a = c1095a;
        }

        public void setRespond(int i, String str) {
            if (i == -1) {
                this.f4642a.m4843a(BuildConfig.FLAVOR);
            } else if (str == null) {
                this.f4642a.m4843a(BuildConfig.FLAVOR);
            } else {
                try {
                    String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                    CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                    if (commonResponseModel.getIsdata() != 1) {
                        this.f4642a.m4843a(commonResponseModel.getDesc());
                        return;
                    }
                    RedPointModel data = ((RedPointResponseModel) JsonParseUtil.parse(stringSafe, RedPointResponseModel.class)).getData();
                    Methods.editSharedPreferences("news_lattime", data.getLasttime() + BuildConfig.FLAVOR);
                    Methods.editSharedPreferences("lastid", data.getLastid() + BuildConfig.FLAVOR);
                    if (data.getUnread() == 1) {
                        this.f4642a.m4842a(Boolean.valueOf(true));
                    } else {
                        this.f4642a.m4842a(Boolean.valueOf(false));
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public C1360b(Context context) {
        this.f4644a = context;
    }

    public List<NewsInfoData> m5419a() {
        Exception e;
        Throwable th;
        List<NewsInfoData> arrayList = new ArrayList();
        Cursor a;
        try {
            a = C1375a.m5449a(this.f4644a).m5452a(C1380f.class, null, null, null, null);
            while (a != null) {
                if (!a.moveToNext()) {
                    break;
                }
                String string = a.getString(a.getColumnIndex(AgooConstants.MESSAGE_ID));
                String string2 = a.getString(a.getColumnIndex("picture"));
                String string3 = a.getString(a.getColumnIndex(Downloads.COLUMN_TITLE));
                Long valueOf = Long.valueOf(a.getLong(a.getColumnIndex("addtime")));
                String string4 = a.getString(a.getColumnIndex("origin"));
                String string5 = a.getString(a.getColumnIndex("hits"));
                String string6 = a.getString(a.getColumnIndex("url"));
                String string7 = a.getString(a.getColumnIndex("summary"));
                String string8 = a.getString(a.getColumnIndex("style"));
                String string9 = a.getString(a.getColumnIndex("IMG1"));
                String string10 = a.getString(a.getColumnIndex("IMG2"));
                String string11 = a.getString(a.getColumnIndex("IMG3"));
                String string12 = a.getString(a.getColumnIndex("extend_type"));
                String string13 = a.getString(a.getColumnIndex("apk_url"));
                Integer valueOf2 = Integer.valueOf(a.getInt(a.getColumnIndex("love")));
                Integer valueOf3 = Integer.valueOf(a.getInt(a.getColumnIndex("comment")));
                NewsInfoData newsInfoData = new NewsInfoData();
                newsInfoData.setId(string);
                newsInfoData.setPicture(string2);
                newsInfoData.setTitle(string3);
                newsInfoData.setAddtime(valueOf);
                newsInfoData.setOrigin(string4);
                newsInfoData.setHits(string5);
                newsInfoData.setUrl(string6);
                newsInfoData.setSummary(string7);
                try {
                    newsInfoData.setStyle(Integer.valueOf(Integer.parseInt(string8)));
                    if (Integer.parseInt(string8) == 3) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(string9);
                        arrayList2.add(string10);
                        arrayList2.add(string11);
                        newsInfoData.setImglist(arrayList2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    newsInfoData.setZan(valueOf2);
                    newsInfoData.setComment(valueOf3);
                    newsInfoData.setExtend_type(string12);
                    newsInfoData.setApk_url(string13);
                    arrayList.add(newsInfoData);
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e4) {
            e2 = e4;
            a = null;
            try {
                e2.printStackTrace();
                if (a != null) {
                    a.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void m5420a(int i, int i2, C1095a<DataEntity> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C4210b.f14219D);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageInt(this.f4644a));
        hashMap.put(ModelFields.PAGE, Integer.valueOf(i));
        hashMap.put("version_app", Utils.getVersionCode());
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        hashMap.put("sort", Integer.valueOf(i2));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4644a, true));
        hashMap.put("version_api", "6000008");
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/antuapi.php?m=content&c=infoapi&a=thelist", new C13552(this, c1095a, i)).submit();
    }

    public void m5421a(C1095a<DataBean> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put("version_app", Utils.getVersionCode());
        hashMap.put("version_api", BuildConfig.VERSION_NAME);
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageInt(this.f4644a));
        hashMap.put(Constants.KEY_IMEI, C1503b.m5915c().m5925a(this.f4644a, true));
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        hashMap.put("banner_id", Integer.valueOf(1));
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/antuapi.php?m=content&c=infoapi&a=banner", new C13541(this, c1095a)).submit();
    }

    public void m5422a(String str) {
        if (str != null && !BuildConfig.FLAVOR.equals(str)) {
            new HttpRequestTask(new HashMap(), str, new C13585(this)).submit();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5423a(java.util.List<com.antutu.benchmark.modelreflact.NewsInfoData> r8) {
        /*
        r7 = this;
        r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00cf }
        r2.<init>();	 Catch:{ Exception -> 0x00cf }
        r3 = r8.iterator();	 Catch:{ Exception -> 0x00cf }
    L_0x0009:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x00cf }
        if (r0 == 0) goto L_0x00d4;
    L_0x000f:
        r0 = r3.next();	 Catch:{ Exception -> 0x00cf }
        r0 = (com.antutu.benchmark.modelreflact.NewsInfoData) r0;	 Catch:{ Exception -> 0x00cf }
        r4 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00cf }
        r4.<init>();	 Catch:{ Exception -> 0x00cf }
        r1 = "id";
        r5 = r0.getId();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "picture";
        r5 = r0.getPicture();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "title";
        r5 = r0.getTitle();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "addtime";
        r5 = r0.getAddtime();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "origin";
        r5 = r0.getOrigin();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "hits";
        r5 = r0.getHits();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "url";
        r5 = r0.getUrl();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "summary";
        r5 = r0.getSummary();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "style";
        r5 = r0.getStyle();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "love";
        r5 = r0.getZan();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "comment";
        r5 = r0.getComment();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = r0.getStyle();	 Catch:{ Exception -> 0x00e3 }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x00e3 }
        r5 = 3;
        if (r1 != r5) goto L_0x00b8;
    L_0x0088:
        r5 = "IMG1";
        r1 = r0.getImglist();	 Catch:{ Exception -> 0x00e3 }
        r6 = 0;
        r1 = r1.get(r6);	 Catch:{ Exception -> 0x00e3 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00e3 }
        r4.put(r5, r1);	 Catch:{ Exception -> 0x00e3 }
        r5 = "IMG2";
        r1 = r0.getImglist();	 Catch:{ Exception -> 0x00e3 }
        r6 = 1;
        r1 = r1.get(r6);	 Catch:{ Exception -> 0x00e3 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00e3 }
        r4.put(r5, r1);	 Catch:{ Exception -> 0x00e3 }
        r5 = "IMG3";
        r1 = r0.getImglist();	 Catch:{ Exception -> 0x00e3 }
        r6 = 2;
        r1 = r1.get(r6);	 Catch:{ Exception -> 0x00e3 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00e3 }
        r4.put(r5, r1);	 Catch:{ Exception -> 0x00e3 }
    L_0x00b8:
        r1 = "extend_type";
        r5 = r0.getExtend_type();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r5);	 Catch:{ Exception -> 0x00cf }
        r1 = "apk_url";
        r0 = r0.getApk_url();	 Catch:{ Exception -> 0x00cf }
        r4.put(r1, r0);	 Catch:{ Exception -> 0x00cf }
        r2.add(r4);	 Catch:{ Exception -> 0x00cf }
        goto L_0x0009;
    L_0x00cf:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00e1 }
    L_0x00d3:
        return;
    L_0x00d4:
        r0 = r7.f4644a;	 Catch:{ Exception -> 0x00cf }
        r0 = com.antutu.benchmark.p041d.C1376c.C1375a.m5449a(r0);	 Catch:{ Exception -> 0x00cf }
        r1 = com.antutu.benchmark.p041d.C1380f.class;
        r3 = 5;
        r0.m5451a(r1, r2, r3);	 Catch:{ Exception -> 0x00cf }
        goto L_0x00d3;
    L_0x00e1:
        r0 = move-exception;
        throw r0;
    L_0x00e3:
        r1 = move-exception;
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.benchmark.c.b.a(java.util.List):void");
    }

    public void m5424b() {
        C1375a.m5449a(this.f4644a).m5453a(C1380f.class, null, null);
    }

    public void m5425b(C1095a<DataEntity> c1095a) {
        HashMap hashMap = new HashMap();
        hashMap.put("version_api", "6000002");
        hashMap.put(Constants.KEY_OS_VERSION, C4210b.f14219D);
        hashMap.put("version_app", Utils.getVersionCode());
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageInt(this.f4644a));
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/antuapi.php?m=content&c=infoapi&a=recmdindex", new C13563(this, c1095a)).submit();
    }

    public void m5426c(C1095a<DataEntity> c1095a) {
        String str = "http://cdn.antutu.com/web/v6/news/android_en_news_data_6000300.data";
        if (C1503b.m5915c().m5939d() == 1) {
            str = "http://cdn.antutu.com/web/v6/news/android_cn_news_data_6000300.data";
        }
        new HttpRequestTask(new HashMap(), str, new C13574(this, c1095a)).submit();
    }

    public void m5427d(C1095a<Boolean> c1095a) {
        String sharedPreferencesString = Methods.getSharedPreferencesString("news_lattime", MessageService.MSG_DB_READY_REPORT);
        String sharedPreferencesString2 = Methods.getSharedPreferencesString("lastid", MessageService.MSG_DB_READY_REPORT);
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageInt(this.f4644a));
        hashMap.put("lasttime", sharedPreferencesString);
        hashMap.put("lastid", sharedPreferencesString2);
        hashMap.put("oem", Integer.valueOf(C1503b.m5915c().m5954k()));
        new HttpRequestTask(hashMap, "http://autovote.antutu.net/antuapi.php?m=content&c=infoapi&a=isunread", new C13596(this, c1095a)).submit();
    }
}
