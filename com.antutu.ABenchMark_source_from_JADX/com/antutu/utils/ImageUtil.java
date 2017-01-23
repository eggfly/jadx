package com.antutu.utils;

import android.graphics.Bitmap.Config;
import android.widget.ImageView;
import com.antutu.ABenchMark.C1082R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class ImageUtil {
    private static DisplayImageOptions avatarOption;
    private static DisplayImageOptions newsOption;

    static {
        newsOption = new Builder().showImageOnLoading((int) C1082R.drawable.news_loading).showImageForEmptyUri((int) C1082R.drawable.news_load_fail).showImageOnFail((int) C1082R.drawable.news_load_fail).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(Config.RGB_565).resetViewBeforeLoading(true).displayer(new FadeInBitmapDisplayer(100)).build();
        avatarOption = new Builder().cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(Config.RGB_565).resetViewBeforeLoading(true).displayer(new FadeInBitmapDisplayer(100)).build();
    }

    public static void displayImageAvatar(String str, ImageView imageView) {
        ImageLoader.getInstance().displayImage(str, imageView, avatarOption);
    }

    public static void displayImageNews(String str, ImageView imageView) {
        ImageLoader.getInstance().displayImage(str, imageView, newsOption);
    }
}
