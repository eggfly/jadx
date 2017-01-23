package com.baidu.mobads.p089d;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.p088c.C1928f;
import java.net.URL;

/* renamed from: com.baidu.mobads.d.a */
public class C1929a extends C1928f implements IXAdStaticImgDownloader {
    public C1929a(Context context, URL url, String str, String str2) {
        super(context, url, str, str2, true);
    }

    protected void m7271a() {
        super.m7266a();
    }

    public Bitmap getBitmap() {
        return null;
    }
}
