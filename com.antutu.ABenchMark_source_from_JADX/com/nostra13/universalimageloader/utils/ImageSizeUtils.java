package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import org.android.spdy.SpdyProtocol;

public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* renamed from: com.nostra13.universalimageloader.utils.ImageSizeUtils.1 */
    static /* synthetic */ class C40381 {
        static final /* synthetic */ int[] f13380x841fdc36;

        static {
            f13380x841fdc36 = new int[ViewScaleType.values().length];
            try {
                f13380x841fdc36[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13380x841fdc36[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], DEFAULT_MAX_BITMAP_DIMENSION);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int max;
        int i = 1;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i2;
        int i3;
        switch (C40381.f13380x841fdc36[viewScaleType.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (!z) {
                    max = Math.max(width / width2, height / height2);
                    break;
                }
                i2 = width / 2;
                i3 = height / 2;
                max = 1;
                while (true) {
                    if (i2 / max <= width2 && i3 / max <= height2) {
                        break;
                    }
                    max *= 2;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (!z) {
                    max = Math.min(width / width2, height / height2);
                    break;
                }
                i2 = width / 2;
                i3 = height / 2;
                max = 1;
                while (i2 / max > width2 && i3 / max > height2) {
                    max *= 2;
                }
                break;
            default:
                max = 1;
                break;
        }
        if (max >= 1) {
            i = max;
        }
        return considerMaxTextureSize(width, height, i, z);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int i;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = ((float) width) / ((float) width2);
        float f2 = ((float) height) / ((float) height2);
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f < f2) && (viewScaleType != ViewScaleType.CROP || f >= f2)) {
            i = (int) (((float) width) / f2);
            width2 = height2;
        } else {
            i = width2;
            width2 = (int) (((float) height) / f);
        }
        return ((z || i >= width || width2 >= height) && (!z || i == width || width2 == height)) ? 1.0f : ((float) i) / ((float) width);
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil((double) (((float) width) / ((float) maxBitmapSize.getWidth()))), (int) Math.ceil((double) (((float) height) / ((float) maxBitmapSize.getHeight()))));
    }

    private static int considerMaxTextureSize(int i, int i2, int i3, boolean z) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i / i3 <= width && i2 / i3 <= height) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
