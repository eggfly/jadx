package com.nostra13.universalimageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Video.Thumbnails;
import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyProtocol;

public class BaseImageDownloader implements ImageDownloader {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    /* renamed from: com.nostra13.universalimageloader.core.download.BaseImageDownloader.1 */
    static /* synthetic */ class C40371 {
        static final /* synthetic */ int[] f13379x4730d1a3;

        static {
            f13379x4730d1a3 = new int[Scheme.values().length];
            try {
                f13379x4730d1a3[Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13379x4730d1a3[Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13379x4730d1a3[Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13379x4730d1a3[Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13379x4730d1a3[Scheme.ASSETS.ordinal()] = BaseImageDownloader.MAX_REDIRECT_COUNT;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13379x4730d1a3[Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f13379x4730d1a3[Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this(context, DEFAULT_HTTP_CONNECT_TIMEOUT, DEFAULT_HTTP_READ_TIMEOUT);
    }

    public BaseImageDownloader(Context context, int i, int i2) {
        this.context = context.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }

    @TargetApi(8)
    private InputStream getVideoThumbnailStream(String str) {
        if (VERSION.SDK_INT >= 8) {
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
            if (createVideoThumbnail != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createVideoThumbnail.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        }
        return null;
    }

    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }

    protected HttpURLConnection createConnection(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    @TargetApi(14)
    protected InputStream getContactPhotoStream(Uri uri) {
        ContentResolver contentResolver = this.context.getContentResolver();
        return VERSION.SDK_INT >= 14 ? Contacts.openContactPhotoInputStream(contentResolver, uri, true) : Contacts.openContactPhotoInputStream(contentResolver, uri);
    }

    public InputStream getStream(String str, Object obj) {
        switch (C40371.f13379x4730d1a3[Scheme.ofUri(str).ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return getStreamFromNetwork(str, obj);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return getStreamFromFile(str, obj);
            case SpdyProtocol.QUIC /*4*/:
                return getStreamFromContent(str, obj);
            case MAX_REDIRECT_COUNT /*5*/:
                return getStreamFromAssets(str, obj);
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    protected InputStream getStreamFromAssets(String str, Object obj) {
        return this.context.getAssets().open(Scheme.ASSETS.crop(str));
    }

    protected InputStream getStreamFromContent(String str, Object obj) {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVideoContentUri(parse)) {
            Bitmap thumbnail = Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(CONTENT_CONTACTS_URI_PREFIX)) {
            return getContactPhotoStream(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    protected InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(Scheme.DRAWABLE.crop(str)));
    }

    protected InputStream getStreamFromFile(String str, Object obj) {
        String crop = Scheme.FILE.crop(str);
        return isVideoFileUri(str) ? getVideoThumbnailStream(crop) : new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), BUFFER_SIZE), (int) new File(crop).length());
    }

    protected InputStream getStreamFromNetwork(String str, Object obj) {
        HttpURLConnection createConnection = createConnection(str, obj);
        int i = 0;
        while (createConnection.getResponseCode() / 100 == 3 && i < MAX_REDIRECT_COUNT) {
            createConnection = createConnection(createConnection.getHeaderField(HttpRequest.f14565r), obj);
            i++;
        }
        try {
            Object inputStream = createConnection.getInputStream();
            if (shouldBeProcessed(createConnection)) {
                return new ContentLengthInputStream(new BufferedInputStream(inputStream, BUFFER_SIZE), createConnection.getContentLength());
            }
            IoUtils.closeSilently(inputStream);
            throw new IOException("Image request failed with response code " + createConnection.getResponseCode());
        } catch (IOException e) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e;
        }
    }

    protected InputStream getStreamFromOtherSource(String str, Object obj) {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, new Object[]{str}));
    }

    protected boolean shouldBeProcessed(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getResponseCode() == Constants.COMMAND_HANDSHAKE;
    }
}
