package com.umeng.analytics.social;

import android.text.TextUtils;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Locale;

public class UMPlatformData {
    private UMedia f14042a;
    private String f14043b;
    private String f14044c;
    private String f14045d;
    private GENDER f14046e;

    public enum GENDER {
        MALE(0) {
            public String toString() {
                return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.value)});
            }
        },
        FEMALE(1) {
            public String toString() {
                return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.value)});
            }
        };
        
        public int value;

        private GENDER(int i) {
            this.value = i;
        }
    }

    public enum UMedia {
        SINA_WEIBO {
            public String toString() {
                return "sina";
            }
        },
        TENCENT_WEIBO {
            public String toString() {
                return "tencent";
            }
        },
        TENCENT_QZONE {
            public String toString() {
                return "qzone";
            }
        },
        TENCENT_QQ {
            public String toString() {
                return "qq";
            }
        },
        WEIXIN_FRIENDS {
            public String toString() {
                return "wxsesion";
            }
        },
        WEIXIN_CIRCLE {
            public String toString() {
                return "wxtimeline";
            }
        },
        RENREN {
            public String toString() {
                return "renren";
            }
        },
        DOUBAN {
            public String toString() {
                return "douban";
            }
        };
    }

    public UMPlatformData(UMedia uMedia, String str) {
        this.f14043b = BuildConfig.FLAVOR;
        this.f14044c = BuildConfig.FLAVOR;
        if (uMedia == null || TextUtils.isEmpty(str)) {
            C4185b.m17056b(C4156a.f13942d, "parameter is not valid");
            return;
        }
        this.f14042a = uMedia;
        this.f14043b = str;
    }

    public GENDER getGender() {
        return this.f14046e;
    }

    public UMedia getMeida() {
        return this.f14042a;
    }

    public String getName() {
        return this.f14045d;
    }

    public String getUsid() {
        return this.f14043b;
    }

    public String getWeiboId() {
        return this.f14044c;
    }

    public boolean isValid() {
        return (this.f14042a == null || TextUtils.isEmpty(this.f14043b)) ? false : true;
    }

    public void setGender(GENDER gender) {
        this.f14046e = gender;
    }

    public void setName(String str) {
        this.f14045d = str;
    }

    public void setWeiboId(String str) {
        this.f14044c = str;
    }

    public String toString() {
        return "UMPlatformData [meida=" + this.f14042a + ", usid=" + this.f14043b + ", weiboId=" + this.f14044c + ", name=" + this.f14045d + ", gender=" + this.f14046e + "]";
    }
}
