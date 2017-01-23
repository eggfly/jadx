package com.antutu.utils.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.android.spdy.SpdyProtocol;

public class FileCacheProvider {
    public static final String HEAD_IMG_PATH;
    public static final String MEDAL_IMG_PATH;
    private static FileCacheProvider mCache;

    /* renamed from: com.antutu.utils.cache.FileCacheProvider.1 */
    static /* synthetic */ class C18091 {
        static final /* synthetic */ int[] $SwitchMap$com$antutu$utils$cache$FileCacheProvider$ImageType;

        static {
            $SwitchMap$com$antutu$utils$cache$FileCacheProvider$ImageType = new int[ImageType.values().length];
            try {
                $SwitchMap$com$antutu$utils$cache$FileCacheProvider$ImageType[ImageType.THUBMNAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$antutu$utils$cache$FileCacheProvider$ImageType[ImageType.MEDAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum ImageType {
        THUBMNAIL,
        MEDAL
    }

    static {
        HEAD_IMG_PATH = Environment.getExternalStorageDirectory().getPath() + "/.antutu/benchmark/avatars/";
        MEDAL_IMG_PATH = Environment.getExternalStorageDirectory().getPath() + "/.antutu/benchmark/medals/";
        mCache = null;
    }

    private FileCacheProvider() {
        makeCacheDir(HEAD_IMG_PATH);
        makeCacheDir(MEDAL_IMG_PATH);
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

    public static FileCacheProvider getInstance() {
        if (mCache == null) {
            mCache = new FileCacheProvider();
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
        File file = new File(HEAD_IMG_PATH);
        if (file.exists()) {
            deleteFiles(file.listFiles());
        }
    }

    public File getAvatarFile(String str) {
        File file = new File(HEAD_IMG_PATH + str);
        return file.exists() ? file : null;
    }

    public File getMedalFile(String str) {
        File file = new File(MEDAL_IMG_PATH + str);
        return file.exists() ? file : null;
    }

    public String saveImage(ImageType imageType, String str, Bitmap bitmap) {
        String str2 = null;
        if (!(TextUtils.isEmpty(str) || bitmap == null)) {
            String str3;
            switch (C18091.$SwitchMap$com$antutu$utils$cache$FileCacheProvider$ImageType[imageType.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    str3 = HEAD_IMG_PATH;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str3 = MEDAL_IMG_PATH;
                    break;
                default:
                    str3 = str2;
                    break;
            }
            File file = new File(str3 + str);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file = new File(str3 + str);
            try {
                OutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.close();
                str2 = file.getAbsolutePath();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
        return str2;
    }
}
