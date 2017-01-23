package com.antutu.utils.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.text.TextUtils;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.model.C1533j.C1530a;
import com.antutu.benchmark.model.C1533j.C1531b;
import com.antutu.benchmark.model.C1533j.C1532c;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeInfoCache {
    private static final String ADS_BODY = "ibody";
    private static final String ADS_EXIST = "existscore";
    private static final String ADS_ID = "id";
    private static final String ADS_LINK = "ilink";
    private static final String ADS_TITLE = "ititle";
    private static final String ADS_URL = "iurl";
    private static final String CMCM = "cmcm";
    private static final String CM_CHECKBOX = "cm_checkbox";
    private static final String DEV = "dev";
    public static final String DEV_IMG_PATH;
    private static final String DEV_LEVE = "dev_leve";
    private static final String DEV_TIME = "dev_time";
    private static final String DEV_URL = "dev_url";
    private static final String DSR = "dsr";
    private static final String EXIST = "exist";
    private static final String LEVE1 = "leve1";
    private static final String LEVE2 = "leve2";
    private static final String LEVE3 = "leve3";
    private static final String MACF = "macf";
    private static final String MSG_BACKGROUND_URL = "bg_url";
    private static final String MSG_DESCRIPTION = "description";
    private static final String MSG_DESCRIPTION_URL = "description_url";
    private static final String MSG_ICON_URL = "icon_url";
    private static final String MSG_TITLE = "title";
    private static final String MSG_TITLE_URL = "title_url";
    private static final String OFFICER_VERSION_CODE = "officer_version_code";
    public static String SHARE_HOMEINFO = null;
    private static final String SHOW_CM = "show_cm";
    private static final String SUB_LEVEL1_DESP = "sublevel_1_description";
    private static final String SUB_LEVEL2_DESP = "sublevel_2_description";
    private static final String SUB_LEVEL3_DESP = "sublevel_3_description";
    public static final long UPDATE_TIME = 86400000;
    private static HomeInfoCache mCache;
    private Editor editor;
    private Dev mDev;
    private SharedPreferences share;

    public class Dev {
        private C1530a ads;
        private int devLeve;
        private boolean isStuffed;
        private int leve1;
        private int leve2;
        private int leve3;
        private String mDevDescribe;
        private Bitmap mDevImg;
        private String mDevName;
        private List<C1532c> mPolicyModels;
        private String mafacture;
        private int model_id;
        private String msgBackgroudUrl;
        private String msgDescription;
        private String msgDescriptionUrl;
        private String msgIconUrl;
        private String msgTitle;
        private String msgTitleUrl;
        private int officerVersionCode;
        private boolean showCMBanner;
        private boolean showCMCM;
        private boolean showCMCheckbox;
        private String strUrl;
        public String sub1Describe;
        public String sub2Describe;
        public String sub3Describe;
        private long time;

        public Dev() {
            this.sub1Describe = null;
            this.sub2Describe = null;
            this.sub3Describe = null;
            this.devLeve = -1;
        }

        public C1530a getAds() {
            return this.ads;
        }

        public int getDevLeve() {
            return this.devLeve;
        }

        public int getLeve1() {
            return this.leve1;
        }

        public int getLeve2() {
            return this.leve2;
        }

        public int getLeve3() {
            return this.leve3;
        }

        public String getMafacture() {
            return this.mafacture;
        }

        public int getModel_id() {
            return this.model_id;
        }

        public String getMsgBackgroudUrl() {
            return this.msgBackgroudUrl;
        }

        public String getMsgDescription() {
            return this.msgDescription;
        }

        public String getMsgDescriptionUrl() {
            return this.msgDescriptionUrl;
        }

        public String getMsgIconUrl() {
            return this.msgIconUrl;
        }

        public String getMsgTitle() {
            return this.msgTitle;
        }

        public String getMsgTitleUrl() {
            return this.msgTitleUrl;
        }

        public int getOfficerVersionCode() {
            return this.officerVersionCode;
        }

        public String getStrUrl() {
            return this.strUrl;
        }

        public String getSub1Describe() {
            return this.sub1Describe;
        }

        public String getSub2Describe() {
            return this.sub2Describe;
        }

        public String getSub3Describe() {
            return this.sub3Describe;
        }

        public long getTime() {
            return this.time;
        }

        public String getmDevDescribe() {
            return this.mDevDescribe;
        }

        public Bitmap getmDevImg() {
            return this.mDevImg;
        }

        public String getmDevName() {
            return this.mDevName;
        }

        public List<C1532c> getmPolicyModels() {
            return this.mPolicyModels;
        }

        public boolean isShowCMBanner() {
            return this.showCMBanner;
        }

        public boolean isShowCMCM() {
            return this.showCMCM;
        }

        public boolean isShowCMCheckbox() {
            return this.showCMCheckbox;
        }

        public boolean isStuffed() {
            return this.isStuffed;
        }

        public void setAds(String str, String str2, String str3, String str4, String str5, boolean z) {
            C1530a c1530a = new C1530a();
            c1530a.f5301d = str;
            c1530a.f5298a = str2;
            c1530a.f5299b = str3;
            c1530a.f5300c = str4;
            c1530a.f5302e = str5;
            c1530a.f5303f = z;
            this.ads = c1530a;
        }

        public void setDevLeve(int i) {
            this.devLeve = i;
        }

        public void setLeve1(int i) {
            this.leve1 = i;
        }

        public void setLeve2(int i) {
            this.leve2 = i;
        }

        public void setLeve3(int i) {
            this.leve3 = i;
        }

        public void setMafacture(String str) {
            this.mafacture = str;
        }

        public void setModel_id(int i) {
            this.model_id = i;
        }

        public void setMsgBackgroudUrl(String str) {
            this.msgBackgroudUrl = str;
        }

        public void setMsgDescription(String str) {
            this.msgDescription = str;
        }

        public void setMsgDescriptionUrl(String str) {
            this.msgDescriptionUrl = str;
        }

        public void setMsgIconUrl(String str) {
            this.msgIconUrl = str;
        }

        public void setMsgTitle(String str) {
            this.msgTitle = str;
        }

        public void setMsgTitleUrl(String str) {
            this.msgTitleUrl = str;
        }

        public void setOfficerVersionCode(int i) {
            this.officerVersionCode = i;
        }

        public void setShowCMBanner(boolean z) {
            this.showCMBanner = z;
        }

        public void setShowCMCM(boolean z) {
            this.showCMCM = z;
        }

        public void setShowCMCheckbox(boolean z) {
            this.showCMCheckbox = z;
        }

        public void setStrUrl(String str) {
            this.strUrl = str;
        }

        public void setStuffed(boolean z) {
            this.isStuffed = z;
        }

        public void setSub1Describe(String str) {
            this.sub1Describe = str;
        }

        public void setSub2Describe(String str) {
            this.sub2Describe = str;
        }

        public void setSub3Describe(String str) {
            this.sub3Describe = str;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public void setmDevDescribe(String str) {
            this.mDevDescribe = str;
        }

        public void setmDevImg(Bitmap bitmap) {
            this.mDevImg = bitmap;
        }

        public void setmDevName(String str) {
            this.mDevName = str;
        }

        public void setmPolicyModels(List<C1532c> list) {
            List arrayList;
            if (list == null) {
                arrayList = new ArrayList();
            }
            this.mPolicyModels = arrayList;
        }
    }

    static {
        SHARE_HOMEINFO = "home_info";
        DEV_IMG_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/.antutu/benchmark/dev_info/";
        mCache = null;
    }

    private HomeInfoCache() {
        makeCacheDir(DEV_IMG_PATH);
        this.share = ABenchmarkApplication.getContext().getSharedPreferences(SHARE_HOMEINFO, 2);
        this.editor = this.share.edit();
        this.mDev = new Dev();
    }

    private void deleteFiles(File[] fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (fileArr != null) {
                    file.delete();
                }
            }
        }
    }

    public static HomeInfoCache getInstance() {
        if (mCache == null) {
            mCache = new HomeInfoCache();
        }
        return mCache;
    }

    private void makeCacheDir(String str) {
        try {
            File file = new File(str);
            if (!file.getParentFile().exists()) {
                makeCacheDir(file.getParent());
            }
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
        }
    }

    public void clearCache() {
        File file = new File(DEV_IMG_PATH);
        if (file.exists()) {
            deleteFiles(file.listFiles());
        }
    }

    public File getAvatarFile(String str) {
        File file = new File(DEV_IMG_PATH + str);
        return file.exists() ? file : null;
    }

    public Dev getInfo() {
        if (this.mDev.isStuffed()) {
            return this.mDev;
        }
        this.mDev.setMafacture(this.share.getString(MACF, "Unknown"));
        this.mDev.setmDevName(this.share.getString(DEV, "Unknown"));
        this.mDev.setmDevDescribe(this.share.getString(DSR, "Unknown"));
        this.mDev.setLeve1(this.share.getInt(LEVE1, 0));
        this.mDev.setLeve2(this.share.getInt(LEVE2, 0));
        this.mDev.setLeve3(this.share.getInt(LEVE3, 0));
        this.mDev.setDevLeve(this.share.getInt(DEV_LEVE, 0));
        this.mDev.setSub1Describe(this.share.getString(SUB_LEVEL1_DESP, BuildConfig.FLAVOR));
        this.mDev.setSub2Describe(this.share.getString(SUB_LEVEL2_DESP, BuildConfig.FLAVOR));
        this.mDev.setSub3Describe(this.share.getString(SUB_LEVEL3_DESP, BuildConfig.FLAVOR));
        this.mDev.setStrUrl(this.share.getString(DEV_URL, BuildConfig.FLAVOR));
        this.mDev.setShowCMCheckbox(this.share.getBoolean(CM_CHECKBOX, false));
        this.mDev.setShowCMBanner(this.share.getBoolean(SHOW_CM, false));
        this.mDev.setShowCMCM(this.share.getBoolean(CMCM, false));
        this.mDev.setOfficerVersionCode(this.share.getInt(OFFICER_VERSION_CODE, 4030100));
        this.mDev.setMsgTitle(this.share.getString(MSG_TITLE, BuildConfig.FLAVOR));
        this.mDev.setMsgTitleUrl(this.share.getString(MSG_TITLE_URL, BuildConfig.FLAVOR));
        this.mDev.setMsgDescription(this.share.getString(MSG_DESCRIPTION, BuildConfig.FLAVOR));
        this.mDev.setMsgDescriptionUrl(this.share.getString(MSG_DESCRIPTION_URL, BuildConfig.FLAVOR));
        this.mDev.setMsgBackgroudUrl(this.share.getString(MSG_BACKGROUND_URL, BuildConfig.FLAVOR));
        this.mDev.setMsgIconUrl(this.share.getString(MSG_ICON_URL, BuildConfig.FLAVOR));
        this.mDev.setAds(this.share.getString(ADS_ID, BuildConfig.FLAVOR), this.share.getString(ADS_LINK, BuildConfig.FLAVOR), this.share.getString(ADS_URL, BuildConfig.FLAVOR), this.share.getString(ADS_BODY, BuildConfig.FLAVOR), this.share.getString(ADS_TITLE, BuildConfig.FLAVOR), this.share.getBoolean(ADS_EXIST, true));
        this.mDev.setStuffed(true);
        return this.mDev;
    }

    public boolean isDataIn() {
        return this.share.getBoolean(EXIST, false);
    }

    public String saveImage(String str, Bitmap bitmap) {
        String str2 = null;
        if (!(TextUtils.isEmpty(str) || bitmap == null)) {
            String str3 = DEV_IMG_PATH;
            File file = new File(str3 + str);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file = new File(str3 + str);
            try {
                OutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                str2 = file.getAbsolutePath();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
        return str2;
    }

    public void saveInfo(C1531b c1531b) {
        this.mDev.setStuffed(false);
        this.mDev.setMafacture(c1531b.f5314g);
        String str = c1531b.f5315h;
        str = c1531b.f5314g.contains(c1531b.f5315h) ? c1531b.f5314g : c1531b.f5315h.contains(c1531b.f5314g) ? c1531b.f5315h : c1531b.f5314g + " " + c1531b.f5315h;
        this.mDev.setModel_id(c1531b.f5308a);
        if (c1531b.f5308a != 131) {
            this.mDev.setmDevName(str);
            this.editor.putString(DEV, str);
        }
        this.mDev.setmDevDescribe(c1531b.f5310c);
        this.mDev.setLeve1(c1531b.f5324q);
        this.mDev.setLeve2(c1531b.f5326s);
        this.mDev.setLeve3(c1531b.f5328u);
        this.mDev.setSub1Describe(c1531b.f5325r);
        this.mDev.setSub2Describe(c1531b.f5327t);
        this.mDev.setSub3Describe(c1531b.f5329v);
        this.mDev.setDevLeve(c1531b.f5309b);
        this.mDev.setStrUrl(c1531b.f5316i);
        this.mDev.setMsgTitle(c1531b.f5330w);
        this.mDev.setMsgTitleUrl(c1531b.f5331x);
        this.mDev.setMsgDescription(c1531b.f5332y);
        this.mDev.setMsgDescriptionUrl(c1531b.f5333z);
        this.mDev.setMsgBackgroudUrl(c1531b.f5304A);
        this.mDev.setMsgIconUrl(c1531b.f5305B);
        this.mDev.setShowCMCheckbox(c1531b.f5321n);
        this.mDev.setShowCMBanner(c1531b.f5322o);
        this.mDev.setShowCMCM(c1531b.f5323p);
        long currentTimeMillis = System.currentTimeMillis();
        this.mDev.setTime(currentTimeMillis);
        if (c1531b.f5312e != null) {
            this.mDev.setAds(c1531b.f5312e.f5301d, c1531b.f5312e.f5298a, c1531b.f5312e.f5299b, c1531b.f5312e.f5300c, c1531b.f5312e.f5302e, c1531b.f5312e.f5303f);
        }
        this.mDev.setmPolicyModels(c1531b.f5306C);
        this.mDev.setOfficerVersionCode(c1531b.f5307D);
        this.editor.putBoolean(CM_CHECKBOX, c1531b.f5321n);
        this.editor.putBoolean(SHOW_CM, c1531b.f5322o);
        this.editor.putBoolean(CMCM, c1531b.f5323p);
        this.editor.putString(MACF, c1531b.f5314g);
        this.editor.putString(DSR, c1531b.f5310c);
        this.editor.putInt(LEVE1, c1531b.f5324q);
        this.editor.putInt(LEVE2, c1531b.f5326s);
        this.editor.putInt(LEVE3, c1531b.f5328u);
        this.editor.putString(SUB_LEVEL1_DESP, c1531b.f5325r);
        this.editor.putString(SUB_LEVEL2_DESP, c1531b.f5327t);
        this.editor.putString(SUB_LEVEL3_DESP, c1531b.f5329v);
        this.editor.putInt(DEV_LEVE, c1531b.f5309b);
        this.editor.putString(DEV_URL, c1531b.f5316i);
        this.editor.putString(MSG_TITLE, c1531b.f5330w);
        this.editor.putString(MSG_TITLE_URL, c1531b.f5331x);
        this.editor.putString(MSG_DESCRIPTION, c1531b.f5332y);
        this.editor.putString(MSG_DESCRIPTION_URL, c1531b.f5333z);
        this.editor.putString(MSG_BACKGROUND_URL, c1531b.f5304A);
        this.editor.putString(MSG_ICON_URL, c1531b.f5305B);
        this.editor.putLong(DEV_TIME, currentTimeMillis);
        this.editor.putInt(OFFICER_VERSION_CODE, c1531b.f5307D);
        if (c1531b.f5312e != null) {
            this.editor.putString(ADS_ID, c1531b.f5312e.f5301d);
            this.editor.putString(ADS_LINK, c1531b.f5312e.f5298a);
            this.editor.putString(ADS_URL, c1531b.f5312e.f5299b);
            this.editor.putString(ADS_BODY, c1531b.f5312e.f5300c);
            this.editor.putString(ADS_TITLE, c1531b.f5312e.f5302e);
            this.editor.putBoolean(ADS_EXIST, c1531b.f5312e.f5303f);
        }
        this.editor.putBoolean(EXIST, true);
        this.editor.apply();
    }
}
