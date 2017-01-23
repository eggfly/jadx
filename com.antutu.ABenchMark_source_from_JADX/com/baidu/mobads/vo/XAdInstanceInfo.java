package com.baidu.mobads.vo;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.p080j.C1991m;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class XAdInstanceInfo implements Parcelable, IXAdInstanceInfo, Cloneable {
    public static final Creator<XAdInstanceInfo> CREATOR;
    public static final String TAG = "XAdInstanceInfo";
    private Set<String> f7207A;
    private Set<String> f7208B;
    private Set<String> f7209C;
    private Set<String> f7210D;
    private Set<String> f7211E;
    private Set<String> f7212F;
    private Set<String> f7213G;
    private Set<String> f7214H;
    private Set<String> f7215I;
    private int f7216J;
    private boolean f7217K;
    private String f7218L;
    private String f7219M;
    private String f7220N;
    private String f7221O;
    private String f7222P;
    private long f7223Q;
    private int f7224R;
    private String f7225S;
    private int f7226T;
    private boolean f7227U;
    private long f7228V;
    private CreativeType f7229W;
    private String f7230X;
    private int f7231Y;
    private boolean f7232Z;
    private String f7233a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private String ah;
    private String ai;
    private String aj;
    private JSONArray ak;
    private boolean al;
    private boolean am;
    private String an;
    private String f7234b;
    private String f7235c;
    private String f7236d;
    private String f7237e;
    private String f7238f;
    private String f7239g;
    private String f7240h;
    private String f7241i;
    private String f7242j;
    private String f7243k;
    private int f7244l;
    private String f7245m;
    private String f7246n;
    private boolean f7247o;
    private int f7248p;
    @Deprecated
    private boolean f7249q;
    @Deprecated
    private int f7250r;
    private String f7251s;
    private String f7252t;
    private JSONObject f7253u;
    private String f7254v;
    private int f7255w;
    private int f7256x;
    @Deprecated
    private String f7257y;
    private Set<String> f7258z;

    static {
        CREATOR = new C2076a();
    }

    private XAdInstanceInfo(Parcel parcel) {
        this.f7234b = "-1";
        this.f7258z = new HashSet();
        this.f7207A = new HashSet();
        this.f7208B = new HashSet();
        this.f7209C = new HashSet();
        this.f7210D = new HashSet();
        this.f7211E = new HashSet();
        this.f7212F = new HashSet();
        this.f7213G = new HashSet();
        this.f7214H = new HashSet();
        this.f7215I = new HashSet();
        this.f7217K = true;
        this.f7229W = CreativeType.NONE;
        this.f7232Z = true;
        this.ab = true;
        this.ac = true;
        this.al = false;
        this.am = false;
        this.an = null;
        this.f7234b = parcel.readString();
        this.f7235c = parcel.readString();
        this.f7222P = parcel.readString();
        this.f7225S = parcel.readString();
        this.f7221O = parcel.readString();
        this.f7251s = parcel.readString();
        this.ai = parcel.readString();
        this.f7218L = parcel.readString();
        this.f7237e = parcel.readString();
        this.f7243k = parcel.readString();
        this.f7233a = parcel.readString();
        this.f7254v = parcel.readString();
        this.f7242j = parcel.readString();
        this.f7241i = parcel.readString();
        this.f7239g = parcel.readString();
        this.f7256x = parcel.readInt();
        this.f7255w = parcel.readInt();
        this.f7252t = parcel.readString();
        this.f7257y = parcel.readString();
        this.f7240h = parcel.readString();
        this.f7219M = parcel.readString();
        this.f7238f = parcel.readString();
        this.f7236d = parcel.readString();
        this.f7230X = parcel.readString();
        this.f7246n = parcel.readString();
        this.f7248p = parcel.readInt();
        this.ah = parcel.readString();
        this.aj = parcel.readString();
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfo(JSONObject jSONObject) {
        this.f7234b = "-1";
        this.f7258z = new HashSet();
        this.f7207A = new HashSet();
        this.f7208B = new HashSet();
        this.f7209C = new HashSet();
        this.f7210D = new HashSet();
        this.f7211E = new HashSet();
        this.f7212F = new HashSet();
        this.f7213G = new HashSet();
        this.f7214H = new HashSet();
        this.f7215I = new HashSet();
        this.f7217K = true;
        this.f7229W = CreativeType.NONE;
        this.f7232Z = true;
        this.ab = true;
        this.ac = true;
        this.al = false;
        this.am = false;
        this.an = null;
        this.f7253u = jSONObject;
        try {
            String str;
            int i;
            this.f7228V = System.currentTimeMillis();
            this.f7216J = jSONObject.optInt(IXAdRequestInfo.ACT);
            this.f7254v = jSONObject.optString("html", null);
            this.f7234b = jSONObject.optString(AgooConstants.MESSAGE_ID, "-1");
            this.f7235c = jSONObject.optString("src", BuildConfig.FLAVOR);
            this.f7236d = jSONObject.optString("tit", BuildConfig.FLAVOR);
            this.f7237e = jSONObject.optString("desc", BuildConfig.FLAVOR);
            this.f7238f = jSONObject.optString("surl", BuildConfig.FLAVOR);
            this.f7240h = jSONObject.optString("phone", BuildConfig.FLAVOR);
            this.f7241i = jSONObject.optString("w_picurl", BuildConfig.FLAVOR);
            this.f7242j = jSONObject.optString("icon", BuildConfig.FLAVOR);
            this.f7243k = jSONObject.optString("exp2", "{}");
            this.f7244l = jSONObject.optInt("anti_tag");
            this.f7246n = jSONObject.optString("vurl", BuildConfig.FLAVOR);
            this.f7248p = jSONObject.optInt("duration", 0);
            this.f7247o = jSONObject.optInt("sound", 0) != 1;
            this.f7249q = jSONObject.optInt("iv", 0) == 1;
            this.f7250r = jSONObject.optInt("dur", 0);
            this.f7251s = jSONObject.optString("curl", BuildConfig.FLAVOR);
            this.f7252t = jSONObject.optString("ori_curl", BuildConfig.FLAVOR);
            this.f7239g = jSONObject.optString(C4233j.f14402y);
            if (this.f7254v != null && this.f7254v.length() > 0 && (this.f7254v.contains("html") || this.f7254v.contains("HTML"))) {
                this.f7229W = CreativeType.HTML;
            } else if (this.f7239g != null) {
                if (this.f7239g.equals("text")) {
                    this.f7229W = CreativeType.TEXT;
                } else if (this.f7239g.equals("image")) {
                    if (!(this.f7241i == null || this.f7241i.equals(BuildConfig.FLAVOR))) {
                        int lastIndexOf = this.f7241i.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        str = BuildConfig.FLAVOR;
                        if (lastIndexOf >= 0) {
                            str = this.f7241i.toLowerCase(Locale.getDefault()).substring(lastIndexOf);
                        }
                        if (str.equals(".gif")) {
                            this.f7229W = CreativeType.GIF;
                        } else {
                            this.f7229W = CreativeType.STATIC_IMAGE;
                        }
                    }
                } else if (this.f7239g.equals("rm")) {
                    this.f7229W = CreativeType.RM;
                } else if (this.f7239g.equals("video")) {
                    this.f7229W = CreativeType.VIDEO;
                }
            }
            this.f7255w = jSONObject.optInt(IXAdRequestInfo.WIDTH);
            this.f7256x = jSONObject.optInt(IXAdRequestInfo.HEIGHT);
            this.f7257y = jSONObject.optString("lb_phone", BuildConfig.FLAVOR);
            JSONArray optJSONArray = jSONObject.optJSONArray("nwinurl");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                str = jSONObject.optString("winurl", BuildConfig.FLAVOR);
                if (!str.equals(BuildConfig.FLAVOR)) {
                    this.f7258z.add(str);
                }
            } else {
                for (i = 0; i < optJSONArray.length(); i++) {
                    this.f7258z.add(optJSONArray.getString(i));
                }
            }
            str = jSONObject.optString("clklogurl", BuildConfig.FLAVOR);
            if (!str.equals(BuildConfig.FLAVOR)) {
                this.f7258z.add(str);
            }
            optJSONArray = jSONObject.optJSONArray("mon");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("s", BuildConfig.FLAVOR);
                    String optString2 = jSONObject2.optString("c", BuildConfig.FLAVOR);
                    m7751a(optString);
                    m7752b(optString2);
                }
            }
            if (this.f7239g.equalsIgnoreCase("video")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    JSONArray optJSONArray2;
                    if (str.equals("s")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            m7751a(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vskip")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("scard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addScardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("ccard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCcardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vstart")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addStartMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vfullscreen")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addFullScreenMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vclose")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCloseMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("cstartcard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCstartcardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("c")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            m7752b(optJSONArray2.optString(i));
                        }
                    }
                }
            }
            this.f7217K = true;
            this.f7218L = jSONObject.optString("cf", BuildConfig.FLAVOR);
            this.f7219M = jSONObject.optString("qk", BuildConfig.FLAVOR);
            this.f7220N = this.f7219M + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.f7222P = jSONObject.optString("appname", BuildConfig.FLAVOR);
            this.f7221O = jSONObject.optString(IXAdRequestInfo.PACKAGE, BuildConfig.FLAVOR);
            this.f7223Q = jSONObject.optLong("sz", 0);
            this.f7224R = jSONObject.optInt("sb", 0);
            this.f7225S = jSONObject.optString("apo", BuildConfig.FLAVOR);
            this.f7226T = jSONObject.optInt("po", 0);
            this.f7227U = jSONObject.optInt("st", 0) == 1;
        } catch (Exception e) {
            C1991m.m7449a().m7457f().m7400e(TAG, e.getMessage());
        }
    }

    final void m7751a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7207A.add(str);
        }
    }

    public void addCcardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7212F.add(str);
        }
    }

    public void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            this.f7214H.add(str);
        }
    }

    public void addCstartcardMonitorTrackers(String str) {
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            this.f7215I.add(str);
        }
    }

    public void addFullScreenMonitorTrackers(String str) {
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            this.f7213G.add(str);
        }
    }

    public void addScardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7211E.add(str);
        }
    }

    public void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7210D.add(str);
        }
    }

    public void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7209C.add(str);
        }
    }

    final void m7752b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7208B.add(str);
        }
    }

    protected Object clone() {
        return super.clone();
    }

    public int describeContents() {
        return 0;
    }

    public boolean getAPOOpen() {
        return this.am;
    }

    public int getActionType() {
        return this.f7216J;
    }

    public String getAdId() {
        return this.f7234b;
    }

    public String getAdSource() {
        return this.f7235c;
    }

    public int getAntiTag() {
        return this.f7244l;
    }

    public String getAppName() {
        return this.f7222P;
    }

    public String getAppOpenStrs() {
        return this.f7225S;
    }

    public String getAppPackageName() {
        return this.f7221O;
    }

    public long getAppSize() {
        return this.f7223Q;
    }

    public List<String> getCcardTrackers() {
        return new ArrayList(this.f7212F);
    }

    public String getClickThroughUrl() {
        return this.f7251s;
    }

    public String getClklogurl() {
        return this.ai;
    }

    public List<String> getCloseTrackers() {
        return new ArrayList(this.f7214H);
    }

    public String getConfirmBorderPercent() {
        return this.f7218L;
    }

    public long getCreateTime() {
        return this.f7228V;
    }

    public CreativeType getCreativeType() {
        return this.f7229W;
    }

    public List<String> getCstartcardTrackers() {
        return new ArrayList(this.f7215I);
    }

    public String getDescription() {
        return this.f7237e;
    }

    public int getDlTunnel() {
        return this.f7231Y;
    }

    public String getExp2ForSingleAd() {
        return this.f7243k;
    }

    public List<String> getFullScreenTrackers() {
        return new ArrayList(this.f7213G);
    }

    public String getFwt() {
        return this.f7233a;
    }

    public int getHoursInADayToShowAd() {
        return this.f7250r;
    }

    public String getHtmlSnippet() {
        return this.f7254v;
    }

    public String getIconUrl() {
        return this.f7242j;
    }

    public Set<String> getImpressionUrls() {
        return this.f7258z;
    }

    public String getLocalCreativeURL() {
        return this.f7245m;
    }

    public int getMainMaterialHeight() {
        return this.f7256x;
    }

    public int getMainMaterialWidth() {
        return this.f7255w;
    }

    public String getMainPictureUrl() {
        return this.f7241i;
    }

    public String getMaterialType() {
        return this.f7239g;
    }

    public JSONArray getNwinurl() {
        return this.ak;
    }

    public String getOriginClickUrl() {
        return this.f7252t;
    }

    public JSONObject getOriginJsonObject() {
        return this.f7253u;
    }

    public String getPage() {
        return this.an;
    }

    public String getPhoneForLocalBranding() {
        return this.f7257y;
    }

    public String getPhoneNumber() {
        return this.f7240h;
    }

    public int getPointsForWall() {
        return this.f7226T;
    }

    public String getQueryKey() {
        return this.f7219M;
    }

    public List<String> getScardTrackers() {
        return new ArrayList(this.f7211E);
    }

    public List<String> getSkipTrackers() {
        return new ArrayList(this.f7210D);
    }

    public String getSponsorUrl() {
        return this.f7238f;
    }

    public List<String> getStartTrackers() {
        return new ArrayList(this.f7209C);
    }

    public int getSwitchButton() {
        return this.f7224R;
    }

    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.f7208B);
    }

    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.f7207A);
    }

    public String getTitle() {
        return this.f7236d;
    }

    public String getUniqueId() {
        return this.f7220N;
    }

    public String getUrl() {
        return this.f7230X;
    }

    public int getVideoDuration() {
        return this.f7248p;
    }

    public String getVideoUrl() {
        return this.f7246n;
    }

    public String getVurl() {
        return this.ah;
    }

    public String getWinurl() {
        return this.aj;
    }

    public boolean isActionOnlyWifi() {
        return this.f7217K;
    }

    public boolean isAutoOpen() {
        return this.ab;
    }

    public boolean isCanCancel() {
        return this.af;
    }

    public boolean isCanDelete() {
        return this.ag;
    }

    public boolean isClose() {
        return this.aa;
    }

    public boolean isIconVisibleForImageType() {
        return this.f7249q;
    }

    public boolean isInapp() {
        return this.f7232Z;
    }

    public boolean isPopNotif() {
        return this.ac;
    }

    public boolean isSecondConfirmed() {
        return this.al;
    }

    public boolean isTaskDoneForWall() {
        return this.f7227U;
    }

    public boolean isTooLarge() {
        return this.ae;
    }

    public Boolean isValid() {
        return Boolean.valueOf(!"-1".equalsIgnoreCase(getAdId()));
    }

    public boolean isVideoMuted() {
        return this.f7247o;
    }

    public boolean isWifiTargeted() {
        return this.ad;
    }

    public void setAPOOpen(boolean z) {
        this.am = z;
    }

    public void setActionOnlyWifi(boolean z) {
        this.f7217K = z;
    }

    public void setActionType(int i) {
        this.f7216J = i;
    }

    public void setAdId(String str) {
        this.f7234b = str;
    }

    public void setAdSource(String str) {
        this.f7235c = str;
    }

    public void setAntiTag(int i) {
        this.f7244l = i;
    }

    public void setAppName(String str) {
        this.f7222P = str;
    }

    public void setAppOpenStrs(String str) {
        this.f7225S = str;
    }

    public void setAppPackageName(String str) {
        this.f7221O = str;
    }

    public void setAppSize(long j) {
        this.f7223Q = j;
    }

    public void setAutoOpen(boolean z) {
        this.ab = z;
    }

    public void setCanCancel(boolean z) {
        this.af = z;
    }

    public void setCanDelete(boolean z) {
        this.ag = z;
    }

    public void setCcardTrackers(List<String> list) {
        this.f7212F.addAll(list);
    }

    public void setClickThroughUrl(String str) {
        this.f7251s = str;
    }

    public void setClklogurl(String str) {
        this.ai = str;
    }

    public void setClose(boolean z) {
        this.aa = z;
    }

    public void setCloseTrackers(List<String> list) {
        this.f7214H.clear();
        this.f7214H.addAll(list);
    }

    public void setConfirmBorderPercent(String str) {
        this.f7218L = str;
    }

    public void setCreateTime(long j) {
        this.f7228V = j;
    }

    public void setCreativeType(CreativeType creativeType) {
        this.f7229W = creativeType;
    }

    public void setCstartcardTrackers(List<String> list) {
        this.f7215I.clear();
        this.f7215I.addAll(list);
    }

    public void setDescription(String str) {
        this.f7237e = str;
    }

    public void setDlTunnel(int i) {
        this.f7231Y = i;
    }

    public void setExp2ForSingleAd(String str) {
        this.f7243k = str;
    }

    public void setFullScreenTrackers(List<String> list) {
        this.f7213G.addAll(list);
    }

    public void setFwt(String str) {
        this.f7233a = str;
    }

    public void setHoursInADayToShowAd(int i) {
        this.f7250r = i;
    }

    public void setHtmlSnippet(String str) {
        this.f7254v = str;
    }

    public void setIconUrl(String str) {
        this.f7242j = str;
    }

    public void setIconVisibleForImageType(boolean z) {
        this.f7249q = z;
    }

    public void setImpressionUrls(Set<String> set) {
        this.f7258z = set;
    }

    public void setInapp(boolean z) {
        this.f7232Z = z;
    }

    public void setLocalCreativeURL(String str) {
        this.f7245m = str;
    }

    public void setMainMaterialHeight(int i) {
        this.f7256x = i;
    }

    public void setMainMaterialWidth(int i) {
        this.f7255w = i;
    }

    public void setMainPictureUrl(String str) {
        this.f7241i = str;
    }

    public void setMaterialType(String str) {
        this.f7239g = str;
    }

    public void setNwinurl(JSONArray jSONArray) {
        this.ak = jSONArray;
    }

    public void setOriginClickUrl(String str) {
        this.f7252t = str;
    }

    public void setPage(String str) {
        this.an = str;
    }

    public void setPhoneForLocalBranding(String str) {
        this.f7257y = str;
    }

    public void setPhoneNumber(String str) {
        this.f7240h = str;
    }

    public void setPointsForWall(int i) {
        this.f7226T = i;
    }

    public void setPopNotif(boolean z) {
        this.ac = z;
    }

    public void setQueryKey(String str) {
        this.f7219M = str;
    }

    public void setScardTrackers(List<String> list) {
        this.f7211E.addAll(list);
    }

    public void setSecondConfirmed(boolean z) {
        this.al = z;
    }

    public void setSkipTrackers(List<String> list) {
        this.f7210D.addAll(list);
    }

    public void setSponsorUrl(String str) {
        this.f7238f = str;
    }

    public void setStartTrackers(List<String> list) {
        this.f7209C.clear();
        this.f7209C.addAll(list);
    }

    public void setSwitchButton(int i) {
        this.f7224R = i;
    }

    public void setTaskDoneForWall(boolean z) {
        this.f7227U = z;
    }

    public void setThirdClickTrackingUrls(Set<String> set) {
        this.f7208B = set;
    }

    public void setThirdImpressionTrackingUrls(Set<String> set) {
        this.f7207A = set;
    }

    public void setTitle(String str) {
        this.f7236d = str;
    }

    public void setTooLarge(boolean z) {
        this.ae = z;
    }

    public void setUrl(String str) {
        this.f7230X = str;
    }

    public void setVideoDuration(int i) {
        this.f7248p = i;
    }

    public void setVideoMuted(boolean z) {
        this.f7247o = z;
    }

    public void setVideoUrl(String str) {
        this.f7246n = str;
    }

    public void setVurl(String str) {
        this.ah = str;
    }

    public void setWifiTargeted(boolean z) {
        this.ad = z;
    }

    public void setWinurl(String str) {
        this.aj = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7234b);
        parcel.writeString(this.f7235c);
        parcel.writeString(this.f7222P);
        parcel.writeString(this.f7225S);
        parcel.writeString(this.f7221O);
        parcel.writeString(this.f7251s);
        parcel.writeString(this.ai);
        parcel.writeString(this.f7218L);
        parcel.writeString(this.f7237e);
        parcel.writeString(this.f7243k);
        parcel.writeString(this.f7233a);
        parcel.writeString(this.f7254v);
        parcel.writeString(this.f7242j);
        parcel.writeString(this.f7241i);
        parcel.writeString(this.f7239g);
        parcel.writeInt(this.f7256x);
        parcel.writeInt(this.f7255w);
        parcel.writeString(this.f7252t);
        parcel.writeString(this.f7257y);
        parcel.writeString(this.f7240h);
        parcel.writeString(this.f7219M);
        parcel.writeString(this.f7238f);
        parcel.writeString(this.f7236d);
        parcel.writeString(this.f7230X);
        parcel.writeString(this.f7246n);
        parcel.writeInt(this.f7248p);
        parcel.writeString(this.ah);
        parcel.writeString(this.aj);
    }
}
