package com.antutu.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.View;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p043g.C1503b;

public class ShareUtil {
    public static final String SHARE_APP_FILE_NAME = "share_imagev6beta3.png";
    public static final String SHARE_ICON = "app_icon.png";
    public static final String SOFT_URL = "http://soft.antutu.com";

    public static void showShare(Context context, String str, String str2, String str3, String str4) {
        try {
            OnekeyShare onekeyShare = new OnekeyShare();
            if (str3 != null) {
                onekeyShare.setTitle(str3);
                onekeyShare.setText(str4 + str);
            } else {
                onekeyShare.setTitle(context.getString(C1082R.string.title_share_news));
            }
            onekeyShare.setUrl(str);
            onekeyShare.setSiteUrl(str);
            onekeyShare.setTitleUrl(str);
            if (str2 != null) {
                onekeyShare.setImageUrl(str2);
            } else {
                FileUtil.savePic(BitmapFactory.decodeResource(context.getResources(), C1082R.drawable.app_icon), SHARE_ICON);
                onekeyShare.setImagePath(FileUtil.getAbsolutePath(SHARE_ICON));
            }
            onekeyShare.setSilent(false);
            onekeyShare.setTheme(OnekeyShareTheme.CLASSIC);
            onekeyShare.setDialogMode();
            onekeyShare.disableSSOWhenAuthorize();
            if ("CN".equals(Utils.getLocalLanguage(context))) {
                onekeyShare.addHiddenPlatform(Facebook.NAME);
                onekeyShare.addHiddenPlatform(Twitter.NAME);
            } else {
                onekeyShare.addHiddenPlatform(SinaWeibo.NAME);
                onekeyShare.addHiddenPlatform(Wechat.NAME);
                onekeyShare.addHiddenPlatform(WechatMoments.NAME);
                onekeyShare.addHiddenPlatform(QZone.NAME);
                onekeyShare.addHiddenPlatform(QQ.NAME);
            }
            onekeyShare.show(context);
        } catch (Exception e) {
        }
    }

    public static void showShareApp(Context context, String str) {
        try {
            OnekeyShare onekeyShare = new OnekeyShare();
            onekeyShare.setTitle(context.getString(C1082R.string.share_all_title));
            onekeyShare.setTitleUrl(SOFT_URL);
            onekeyShare.setText(context.getString(C1082R.string.share_all_text));
            if (!FileUtil.isFileExist(SHARE_APP_FILE_NAME)) {
                FileUtil.savePic(BitmapFactory.decodeResource(context.getResources(), C1082R.drawable.share_image), SHARE_APP_FILE_NAME);
            }
            onekeyShare.setImagePath(FileUtil.getAbsolutePath(SHARE_APP_FILE_NAME));
            onekeyShare.setUrl(SOFT_URL);
            onekeyShare.setSiteUrl(SOFT_URL);
            onekeyShare.setSilent(false);
            onekeyShare.setTheme(OnekeyShareTheme.CLASSIC);
            if (str != null) {
                onekeyShare.setPlatform(str);
            }
            onekeyShare.setDialogMode();
            onekeyShare.disableSSOWhenAuthorize();
            if ("CN".equals(Utils.getLocalLanguage(context))) {
                onekeyShare.addHiddenPlatform(Facebook.NAME);
                onekeyShare.addHiddenPlatform(Twitter.NAME);
            } else {
                onekeyShare.addHiddenPlatform(SinaWeibo.NAME);
                onekeyShare.addHiddenPlatform(Wechat.NAME);
                onekeyShare.addHiddenPlatform(WechatMoments.NAME);
                onekeyShare.addHiddenPlatform(QZone.NAME);
                onekeyShare.addHiddenPlatform(QQ.NAME);
            }
            onekeyShare.show(context);
        } catch (Exception e) {
        }
    }

    public static void showShareApp(Context context, String str, View view, String str2) {
        try {
            String d = C1503b.m5915c().m5940d(Build.MODEL);
            OnekeyShare onekeyShare = new OnekeyShare();
            onekeyShare.setTitle(context.getString(C1082R.string.share_compare_title));
            onekeyShare.setTitleUrl(SOFT_URL);
            onekeyShare.setText(d + " VS " + str2 + context.getString(C1082R.string.share_compare_text));
            onekeyShare.setViewToShare(view);
            onekeyShare.setUrl(SOFT_URL);
            onekeyShare.setSiteUrl(SOFT_URL);
            onekeyShare.setSilent(false);
            onekeyShare.setTheme(OnekeyShareTheme.CLASSIC);
            if (str != null) {
                onekeyShare.setPlatform(str);
            }
            onekeyShare.setDialogMode();
            onekeyShare.disableSSOWhenAuthorize();
            if ("CN".equals(Utils.getLocalLanguage(context))) {
                onekeyShare.addHiddenPlatform(Facebook.NAME);
                onekeyShare.addHiddenPlatform(Twitter.NAME);
            } else {
                onekeyShare.addHiddenPlatform(SinaWeibo.NAME);
                onekeyShare.addHiddenPlatform(Wechat.NAME);
                onekeyShare.addHiddenPlatform(WechatMoments.NAME);
                onekeyShare.addHiddenPlatform(QZone.NAME);
                onekeyShare.addHiddenPlatform(QQ.NAME);
            }
            onekeyShare.show(context);
        } catch (Exception e) {
        }
    }

    public static void showShareApp(Context context, String str, String str2, String str3, View view, String str4, String str5) {
        try {
            OnekeyShare onekeyShare = new OnekeyShare();
            if (str3 != null) {
                onekeyShare.setTitle(str3);
                onekeyShare.setText(str5 + str2);
            } else {
                onekeyShare.setTitle(context.getString(C1082R.string.title_share_news));
            }
            if (str2 != null) {
                onekeyShare.setUrl(str2);
                onekeyShare.setSiteUrl(str2);
                onekeyShare.setTitleUrl(str2);
                onekeyShare.setImageUrl(str2);
            } else {
                onekeyShare.setUrl(SOFT_URL);
            }
            if (str4 != null) {
                onekeyShare.setImageUrl(str4);
            } else if (view != null) {
                onekeyShare.setViewToShare(view);
            } else {
                FileUtil.savePic(BitmapFactory.decodeResource(context.getResources(), C1082R.drawable.app_icon), SHARE_ICON);
                onekeyShare.setImagePath(FileUtil.getAbsolutePath(SHARE_ICON));
            }
            onekeyShare.setSilent(false);
            onekeyShare.setTheme(OnekeyShareTheme.CLASSIC);
            if (str != null) {
                onekeyShare.setPlatform(str);
            }
            onekeyShare.setDialogMode();
            onekeyShare.disableSSOWhenAuthorize();
            if ("CN".equals(Utils.getLocalLanguage(context))) {
                onekeyShare.addHiddenPlatform(Facebook.NAME);
                onekeyShare.addHiddenPlatform(Twitter.NAME);
            } else {
                onekeyShare.addHiddenPlatform(SinaWeibo.NAME);
                onekeyShare.addHiddenPlatform(Wechat.NAME);
                onekeyShare.addHiddenPlatform(WechatMoments.NAME);
                onekeyShare.addHiddenPlatform(QZone.NAME);
                onekeyShare.addHiddenPlatform(QQ.NAME);
            }
            onekeyShare.show(context);
        } catch (Exception e) {
        }
    }
}
