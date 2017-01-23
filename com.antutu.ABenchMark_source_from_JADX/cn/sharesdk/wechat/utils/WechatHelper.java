package cn.sharesdk.wechat.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler.Callback;
import android.os.Message;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0979d;
import cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;

public class WechatHelper {
    private static boolean f3508a;
    private static WechatHelper f3509b;
    private C1052h f3510c;
    private C1053i f3511d;

    public static class ShareParams extends cn.sharesdk.framework.Platform.ShareParams {
        @Deprecated
        public String extInfo;
        @Deprecated
        public String filePath;
        @Deprecated
        public Bitmap imageData;
        @Deprecated
        public String imageUrl;
        @Deprecated
        public String musicUrl;
        @Deprecated
        protected int scene;
        @Deprecated
        public int shareType;
        @Deprecated
        public String title;
        @Deprecated
        public String url;
    }

    /* renamed from: cn.sharesdk.wechat.utils.WechatHelper.1 */
    class C10411 implements Callback {
        int f3501a;
        final /* synthetic */ DeviceHelper f3502b;
        final /* synthetic */ String f3503c;
        final /* synthetic */ PlatformActionListener f3504d;
        final /* synthetic */ Platform f3505e;
        final /* synthetic */ HashMap f3506f;
        final /* synthetic */ WechatHelper f3507g;

        C10411(WechatHelper wechatHelper, DeviceHelper deviceHelper, String str, PlatformActionListener platformActionListener, Platform platform, HashMap hashMap) {
            this.f3507g = wechatHelper;
            this.f3502b = deviceHelper;
            this.f3503c = str;
            this.f3504d = platformActionListener;
            this.f3505e = platform;
            this.f3506f = hashMap;
            this.f3501a = 0;
        }

        public boolean handleMessage(Message message) {
            if (this.f3503c.equals(this.f3502b.getTopTaskPackageName())) {
                if (this.f3501a < 5) {
                    this.f3501a++;
                    UIHandler.sendEmptyMessageDelayed(0, 500, this);
                }
            } else if (this.f3504d != null) {
                this.f3504d.onComplete(this.f3505e, 9, this.f3506f);
            }
            return true;
        }
    }

    static {
        f3508a = false;
    }

    private WechatHelper() {
        this.f3510c = new C1052h();
    }

    private Bitmap m4634a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double sqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) / sqrt), (int) (((double) height) / sqrt), true);
    }

    public static WechatHelper m4635a() {
        if (f3509b == null) {
            f3509b = new WechatHelper();
        }
        return f3509b;
    }

    private void m4636a(Context context, String str, String str2, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXImageObject = new WXImageObject();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        wXImageObject.imageData = byteArrayOutputStream.toByteArray();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m4644a(context, bitmap);
        m4642a(wXMediaMessage, "img", i, c1053i);
    }

    private void m4637a(Context context, String str, String str2, String str3, int i, C1053i c1053i) {
        Object wXImageObject = new WXImageObject();
        if (str3.startsWith("/data/")) {
            wXImageObject.imageData = m4646a(str3);
        } else {
            wXImageObject.imagePath = str3;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m4653b(context, str3);
        m4642a(wXMediaMessage, "img", i, c1053i);
    }

    private void m4638a(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = m4644a(context, bitmap);
        m4642a(wXMediaMessage, "video", i, c1053i);
    }

    private void m4639a(Context context, String str, String str2, String str3, String str4, int i, C1053i c1053i) {
        IMediaObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = m4653b(context, str4);
        m4642a(wXMediaMessage, "video", i, c1053i);
    }

    private void m4640a(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = m4644a(context, bitmap);
        m4642a(wXMediaMessage, "music", i, c1053i);
    }

    private void m4641a(Context context, String str, String str2, String str3, String str4, String str5, int i, C1053i c1053i) {
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = m4653b(context, str5);
        m4642a(wXMediaMessage, "music", i, c1053i);
    }

    private void m4642a(WXMediaMessage wXMediaMessage, String str, int i, C1053i c1053i) {
        Class cls;
        String str2 = DeviceHelper.getInstance(c1053i.m4713b().getContext()).getPackageName() + ".wxapi.WXEntryActivity";
        try {
            cls = Class.forName(str2);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            cls = null;
        }
        if (!(cls == null || WechatHandlerActivity.class.isAssignableFrom(cls))) {
            String str3 = str2 + " does not extend from " + WechatHandlerActivity.class.getName();
            if (f3508a) {
                throw new Throwable(str3);
            }
            new Throwable(str3).printStackTrace();
        }
        C1042j c1046d = new C1046d();
        c1046d.c = str + System.currentTimeMillis();
        c1046d.f3524a = wXMediaMessage;
        c1046d.f3525b = i;
        this.f3511d = c1053i;
        this.f3510c.m4702a(c1046d);
    }

    private void m4643a(String str, String str2, int i, C1053i c1053i) {
        IMediaObject wXTextObject = new WXTextObject();
        wXTextObject.text = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = str2;
        m4642a(wXMediaMessage, "text", i, c1053i);
    }

    private byte[] m4644a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        } else if (!bitmap.isRecycled()) {
            return m4645a(context, bitmap, CompressFormat.PNG);
        } else {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
    }

    private byte[] m4645a(Context context, Bitmap bitmap, CompressFormat compressFormat) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        } else if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        } else {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            int length = toByteArray.length;
            while (length > com.taobao.accs.data.Message.FLAG_DATA_TYPE) {
                bitmap = m4634a(bitmap, ((double) length) / 32768.0d);
                byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                toByteArray = byteArrayOutputStream.toByteArray();
                length = toByteArray.length;
            }
            return toByteArray;
        }
    }

    private byte[] m4646a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            fileInputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return null;
        }
    }

    private void m4647b(Context context, String str, String str2, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXEmojiObject = new WXEmojiObject();
        byte[] a = m4644a(context, bitmap);
        wXEmojiObject.emojiData = a;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a;
        m4642a(wXMediaMessage, "emoji", i, c1053i);
    }

    private void m4648b(Context context, String str, String str2, String str3, int i, C1053i c1053i) {
        IMediaObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m4653b(context, str3);
        m4642a(wXMediaMessage, "emoji", i, c1053i);
    }

    private void m4649b(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (!(bitmap == null || bitmap.isRecycled())) {
            wXMediaMessage.thumbData = m4644a(context, bitmap);
            if (wXMediaMessage.thumbData == null) {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            } else if (wXMediaMessage.thumbData.length > com.taobao.accs.data.Message.FLAG_DATA_TYPE) {
                throw new RuntimeException("checkArgs fail, thumbData is too large: " + wXMediaMessage.thumbData.length + " > " + com.taobao.accs.data.Message.FLAG_DATA_TYPE);
            }
        }
        m4642a(wXMediaMessage, "webpage", i, c1053i);
    }

    private void m4650b(Context context, String str, String str2, String str3, String str4, int i, C1053i c1053i) {
        IMediaObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (str4 != null && new File(str4).exists()) {
            wXMediaMessage.thumbData = m4653b(context, str4);
            if (wXMediaMessage.thumbData == null) {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            } else if (wXMediaMessage.thumbData.length > com.taobao.accs.data.Message.FLAG_DATA_TYPE) {
                throw new RuntimeException("checkArgs fail, thumbData is too large: " + wXMediaMessage.thumbData.length + " > " + com.taobao.accs.data.Message.FLAG_DATA_TYPE);
            }
        }
        m4642a(wXMediaMessage, "webpage", i, c1053i);
    }

    private void m4651b(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = m4644a(context, bitmap);
        m4642a(wXMediaMessage, "appdata", i, c1053i);
    }

    private void m4652b(Context context, String str, String str2, String str3, String str4, String str5, int i, C1053i c1053i) {
        IMediaObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = m4653b(context, str5);
        m4642a(wXMediaMessage, "appdata", i, c1053i);
    }

    private byte[] m4653b(Context context, String str) {
        if (new File(str).exists()) {
            return m4645a(context, BitmapHelper.getBitmap(str), BitmapHelper.getBmpFormat(str));
        }
        throw new FileNotFoundException();
    }

    private void m4654c(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C1053i c1053i) {
        IMediaObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = m4644a(context, bitmap);
        m4642a(wXMediaMessage, "filedata", i, c1053i);
    }

    private void m4655c(Context context, String str, String str2, String str3, String str4, int i, C1053i c1053i) {
        IMediaObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = m4653b(context, str4);
        m4642a(wXMediaMessage, "filedata", i, c1053i);
    }

    public void m4656a(C1053i c1053i) {
        this.f3511d = c1053i;
        C1042j c1043a = new C1043a();
        c1043a.f3516a = "snsapi_userinfo";
        c1043a.f3517b = "sharesdk_wechat_auth";
        this.f3510c.m4702a(c1043a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4657a(cn.sharesdk.wechat.utils.C1053i r12, cn.sharesdk.framework.Platform.ShareParams r13, cn.sharesdk.framework.PlatformActionListener r14) {
        /*
        r11 = this;
        r10 = 0;
        r5 = r12.m4713b();
        r0 = r13.getImagePath();
        r1 = r13.getImageUrl();
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x001e;
    L_0x0013:
        r2 = new java.io.File;
        r2.<init>(r0);
        r2 = r2.exists();
        if (r2 != 0) goto L_0x0066;
    L_0x001e:
        r2 = r13.getImageData();
        if (r2 == 0) goto L_0x0151;
    L_0x0024:
        r3 = r2.isRecycled();
        if (r3 != 0) goto L_0x0151;
    L_0x002a:
        r0 = r5.getContext();
        r1 = "images";
        r0 = com.mob.tools.utils.C4021R.getCachePath(r0, r1);
        r1 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r6 = java.lang.System.currentTimeMillis();
        r3 = r3.append(r6);
        r4 = ".png";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.<init>(r0, r3);
        r0 = new java.io.FileOutputStream;
        r0.<init>(r1);
        r3 = android.graphics.Bitmap.CompressFormat.PNG;
        r4 = 100;
        r2.compress(r3, r4, r0);
        r0.flush();
        r0.close();
        r0 = r1.getAbsolutePath();
    L_0x0066:
        r3 = new android.content.Intent;
        r1 = "android.intent.action.SEND";
        r3.<init>(r1);
        r1 = r13.getText();
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0085;
    L_0x0077:
        r1 = r5.getShortLintk(r1, r10);
        r2 = "android.intent.extra.TEXT";
        r3.putExtra(r2, r1);
        r2 = "Kdescription";
        r3.putExtra(r2, r1);
    L_0x0085:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x016b;
    L_0x008b:
        r2 = new java.io.File;
        r2.<init>(r0);
        r1 = r2.exists();
        if (r1 == 0) goto L_0x00ff;
    L_0x0096:
        r1 = "/data/";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0181;
    L_0x009e:
        r1 = r5.getContext();
        r4 = "images";
        r4 = com.mob.tools.utils.C4021R.getCachePath(r1, r4);
        r1 = new java.io.File;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r8 = java.lang.System.currentTimeMillis();
        r6 = r6.append(r8);
        r7 = r2.getName();
        r6 = r6.append(r7);
        r6 = r6.toString();
        r1.<init>(r4, r6);
        r4 = r1.getAbsolutePath();
        r1.createNewFile();
        r4 = com.mob.tools.utils.C4021R.copyFile(r0, r4);
        if (r4 == 0) goto L_0x0181;
    L_0x00d3:
        r2 = android.os.Build.VERSION.SDK_INT;
        r4 = 24;
        if (r2 < r4) goto L_0x0161;
    L_0x00d9:
        r2 = "android.intent.extra.STREAM";
        r4 = r5.getContext();
        r1 = r1.getAbsolutePath();
        r1 = com.mob.tools.utils.C4021R.pathToContentUri(r4, r1);
        r3.putExtra(r2, r1);
    L_0x00ea:
        r1 = java.net.URLConnection.getFileNameMap();
        r0 = r1.getContentTypeFor(r0);
        if (r0 == 0) goto L_0x00fa;
    L_0x00f4:
        r1 = r0.length();
        if (r1 > 0) goto L_0x00fc;
    L_0x00fa:
        r0 = "image/*";
    L_0x00fc:
        r3.setType(r0);
    L_0x00ff:
        r0 = "scene";
        r1 = java.lang.Integer.class;
        r0 = r13.get(r0, r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = 1;
        if (r0 != r1) goto L_0x0171;
    L_0x0110:
        r0 = "com.tencent.mm.ui.tools.ShareToTimeLineUI";
    L_0x0112:
        r1 = "com.tencent.mm";
        r3.setClassName(r1, r0);
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r3.addFlags(r0);
        r0 = r5.getContext();
        r0.startActivity(r3);
        r0 = r5.getContext();
        r2 = com.mob.tools.utils.DeviceHelper.getInstance(r0);
        r0 = r5.getContext();
        r3 = r0.getPackageName();
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = "ShareParams";
        r6.put(r0, r13);
        r0 = r2.getTopTaskPackageName();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0174;
    L_0x0147:
        if (r14 == 0) goto L_0x0150;
    L_0x0149:
        if (r14 == 0) goto L_0x0150;
    L_0x014b:
        r0 = 9;
        r14.onComplete(r5, r0, r6);
    L_0x0150:
        return;
    L_0x0151:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0066;
    L_0x0157:
        r0 = r5.getContext();
        r0 = com.mob.tools.utils.BitmapHelper.downloadBitmap(r0, r1);
        goto L_0x0066;
    L_0x0161:
        r2 = "android.intent.extra.STREAM";
        r1 = android.net.Uri.fromFile(r1);
        r3.putExtra(r2, r1);
        goto L_0x00ea;
    L_0x016b:
        r0 = "text/plain";
        r3.setType(r0);
        goto L_0x00ff;
    L_0x0171:
        r0 = "com.tencent.mm.ui.tools.ShareImgUI";
        goto L_0x0112;
    L_0x0174:
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = new cn.sharesdk.wechat.utils.WechatHelper$1;
        r1 = r11;
        r4 = r14;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        com.mob.tools.utils.UIHandler.sendEmptyMessageDelayed(r10, r8, r0);
        goto L_0x0150;
    L_0x0181:
        r1 = r2;
        goto L_0x00d3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.wechat.utils.WechatHelper.a(cn.sharesdk.wechat.utils.i, cn.sharesdk.framework.Platform$ShareParams, cn.sharesdk.framework.PlatformActionListener):void");
    }

    public boolean m4658a(Context context, String str) {
        return this.f3510c.m4704a(context, str);
    }

    public boolean m4659a(WechatHandlerActivity wechatHandlerActivity) {
        return this.f3510c.m4705a(wechatHandlerActivity, this.f3511d);
    }

    public void m4660b(C1053i c1053i) {
        Platform b = c1053i.m4713b();
        cn.sharesdk.framework.Platform.ShareParams a = c1053i.m4708a();
        PlatformActionListener c = c1053i.m4714c();
        int shareType = a.getShareType();
        String title = a.getTitle();
        String text = a.getText();
        int scence = a.getScence();
        String imagePath = a.getImagePath();
        String imageUrl = a.getImageUrl();
        Bitmap imageData = a.getImageData();
        String musicUrl = a.getMusicUrl();
        String url = a.getUrl();
        String filePath = a.getFilePath();
        String extInfo = a.getExtInfo();
        Context context = b.getContext();
        switch (shareType) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m4643a(title, text, scence, c1053i);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (imagePath != null && imagePath.length() > 0) {
                    m4637a(context, title, text, imagePath, scence, c1053i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m4636a(context, title, text, imageData, scence, c1053i);
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m4637a(context, title, text, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4637a(context, title, text, BitmapHelper.downloadBitmap(b.getContext(), imageUrl), scence, c1053i);
                }
            case SpdyProtocol.QUIC /*4*/:
                filePath = b.getShortLintk(url, false);
                if (imagePath != null && imagePath.length() > 0) {
                    m4650b(context, title, text, filePath, imagePath, scence, c1053i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m4649b(context, title, text, filePath, imageData, scence, c1053i);
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m4650b(context, title, text, filePath, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4650b(context, title, text, filePath, BitmapHelper.downloadBitmap(b.getContext(), imageUrl), scence, c1053i);
                }
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                String shortLintk = b.getShortLintk(musicUrl + " " + url, false);
                filePath = shortLintk.split(" ")[0];
                extInfo = shortLintk.split(" ")[1];
                if (imagePath != null && imagePath.length() > 0) {
                    m4641a(context, title, text, filePath, extInfo, imagePath, scence, c1053i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m4640a(context, title, text, filePath, extInfo, imageData, scence, c1053i);
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m4641a(context, title, text, filePath, extInfo, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4641a(context, title, text, filePath, extInfo, BitmapHelper.downloadBitmap(b.getContext(), imageUrl), scence, c1053i);
                }
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                filePath = b.getShortLintk(url, false);
                if (imagePath != null && imagePath.length() > 0) {
                    m4639a(context, title, text, filePath, imagePath, scence, c1053i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m4638a(context, title, text, filePath, imageData, scence, c1053i);
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m4639a(context, title, text, filePath, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4639a(context, title, text, filePath, BitmapHelper.downloadBitmap(b.getContext(), imageUrl), scence, c1053i);
                }
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SAHRE_APP");
                } else if (scence == 2) {
                    throw new Throwable("WechatFavorite does not support SAHRE_APP");
                } else if (imagePath != null && imagePath.length() > 0) {
                    m4652b(context, title, text, filePath, extInfo, imagePath, scence, c1053i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m4651b(context, title, text, filePath, extInfo, imageData, scence, c1053i);
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m4652b(context, title, text, filePath, extInfo, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4652b(context, title, text, filePath, extInfo, BitmapHelper.downloadBitmap(b.getContext(), imageUrl), scence, c1053i);
                }
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_FILE");
                } else if (imagePath != null && imagePath.length() > 0) {
                    m4655c(context, title, text, filePath, imagePath, scence, c1053i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m4654c(context, title, text, filePath, imageData, scence, c1053i);
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m4655c(context, title, text, filePath, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4655c(context, title, text, filePath, BitmapHelper.downloadBitmap(b.getContext(), imageUrl), scence, c1053i);
                }
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_EMOJI");
                } else if (scence == 2) {
                    throw new Throwable("WechatFavorite does not support SHARE_EMOJI");
                } else if (imagePath != null && imagePath.length() > 0) {
                    m4648b(context, title, text, imagePath, scence, c1053i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m4648b(context, title, text, new NetworkHelper().downloadCache(b.getContext(), imageUrl, "images", true, null), scence, c1053i);
                } else if (imageData == null || imageData.isRecycled()) {
                    m4648b(context, title, text, BuildConfig.FLAVOR, scence, c1053i);
                } else {
                    m4647b(context, title, text, imageData, scence, c1053i);
                }
            default:
                if (c != null) {
                    c.onError(b, 9, new IllegalArgumentException("shareType = " + shareType));
                }
        }
    }

    public boolean m4661b() {
        return this.f3510c.m4703a();
    }

    public boolean m4662c() {
        return this.f3510c.m4706b();
    }

    public boolean m4663d() {
        return this.f3510c.m4707c();
    }
}
