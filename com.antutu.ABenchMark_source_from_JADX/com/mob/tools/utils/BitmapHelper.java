package com.mob.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import com.antutu.utils.widget.SystemBarTintManager;
import com.mob.tools.MobLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.entity.mime.MIME;

public class BitmapHelper {

    /* renamed from: com.mob.tools.utils.BitmapHelper.1 */
    static class C40191 implements HttpResponseCallback {
        final /* synthetic */ HashMap val$buffer;
        final /* synthetic */ String val$imageUrl;
        final /* synthetic */ String val$path;

        /* renamed from: com.mob.tools.utils.BitmapHelper.1.1 */
        class C40181 extends FilterInputStream {
            C40181(InputStream inputStream) {
                super(inputStream);
            }

            public long skip(long j) {
                long j2 = 0;
                while (j2 < j) {
                    long skip = this.in.skip(j - j2);
                    if (skip == 0) {
                        break;
                    }
                    j2 += skip;
                }
                return j2;
            }
        }

        C40191(String str, String str2, HashMap hashMap) {
            this.val$imageUrl = str;
            this.val$path = str2;
            this.val$buffer = hashMap;
        }

        public void onResponse(HttpConnection httpConnection) {
            int responseCode = httpConnection.getResponseCode();
            String access$000;
            if (responseCode == Constants.COMMAND_HANDSHAKE) {
                access$000 = BitmapHelper.getFileName(httpConnection, this.val$imageUrl);
                File file = new File(this.val$path, access$000);
                if (file.exists()) {
                    this.val$buffer.put("bitmap", file.getAbsolutePath());
                    return;
                }
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                try {
                    Bitmap bitmap = BitmapHelper.getBitmap(new C40181(httpConnection.getInputStream()), 1);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        OutputStream fileOutputStream = new FileOutputStream(file);
                        if (access$000.toLowerCase().endsWith(".gif") || access$000.toLowerCase().endsWith(".png")) {
                            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        } else {
                            bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.val$buffer.put("bitmap", file.getAbsolutePath());
                    }
                } catch (Throwable th) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                for (access$000 = bufferedReader.readLine(); access$000 != null; access$000 = bufferedReader.readLine()) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('\n');
                    }
                    stringBuilder.append(access$000);
                }
                bufferedReader.close();
                HashMap hashMap = new HashMap();
                hashMap.put(C4233j.f14375B, stringBuilder.toString());
                hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
                throw new Throwable(new Hashon().fromHashMap(hashMap));
            }
        }
    }

    public static Bitmap blur(Bitmap bitmap, int i, int i2) {
        int i3 = (int) ((((float) i) / ((float) i2)) + 0.5f);
        Bitmap createBitmap = Bitmap.createBitmap((int) ((((float) bitmap.getWidth()) / ((float) i2)) + 0.5f), (int) ((((float) bitmap.getHeight()) / ((float) i2)) + 0.5f), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(1.0f / ((float) i2), 1.0f / ((float) i2));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        blur(createBitmap, i3, true);
        return createBitmap;
    }

    private static Bitmap blur(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        if (z) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i < 1) {
            return null;
        }
        int i2;
        int i3;
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = width * height;
        int i7 = (i + i) + 1;
        int[] iArr2 = new int[i6];
        int[] iArr3 = new int[i6];
        int[] iArr4 = new int[i6];
        int[] iArr5 = new int[Math.max(width, height)];
        i6 = (i7 + 1) >> 1;
        int i8 = i6 * i6;
        int[] iArr6 = new int[(i8 * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY)];
        for (i6 = 0; i6 < i8 * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i6++) {
            iArr6[i6] = i6 / i8;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i7, 3});
        int i9 = i + 1;
        int i10 = 0;
        int i11 = 0;
        for (i2 = 0; i2 < height; i2++) {
            int i12;
            i8 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            for (i3 = -i; i3 <= i; i3++) {
                i12 = iArr[Math.min(i4, Math.max(i3, 0)) + i11];
                int[] iArr8 = iArr7[i3 + i];
                iArr8[0] = (16711680 & i12) >> 16;
                iArr8[1] = (MotionEventCompat.ACTION_POINTER_INDEX_MASK & i12) >> 8;
                iArr8[2] = i12 & MotionEventCompat.ACTION_MASK;
                i12 = i9 - Math.abs(i3);
                i19 += iArr8[0] * i12;
                i18 += iArr8[1] * i12;
                i17 += i12 * iArr8[2];
                if (i3 > 0) {
                    i13 += iArr8[0];
                    i20 += iArr8[1];
                    i8 += iArr8[2];
                } else {
                    i16 += iArr8[0];
                    i15 += iArr8[1];
                    i14 += iArr8[2];
                }
            }
            i12 = i19;
            i19 = i18;
            i18 = i17;
            i3 = i11;
            i11 = i;
            for (i17 = 0; i17 < width; i17++) {
                iArr2[i3] = iArr6[i12];
                iArr3[i3] = iArr6[i19];
                iArr4[i3] = iArr6[i18];
                i12 -= i16;
                i19 -= i15;
                i18 -= i14;
                iArr8 = iArr7[((i11 - i) + i7) % i7];
                i16 -= iArr8[0];
                i15 -= iArr8[1];
                i14 -= iArr8[2];
                if (i2 == 0) {
                    iArr5[i17] = Math.min((i17 + i) + 1, i4);
                }
                int i21 = iArr[iArr5[i17] + i10];
                iArr8[0] = (16711680 & i21) >> 16;
                iArr8[1] = (MotionEventCompat.ACTION_POINTER_INDEX_MASK & i21) >> 8;
                iArr8[2] = i21 & MotionEventCompat.ACTION_MASK;
                i13 += iArr8[0];
                i20 += iArr8[1];
                i8 += iArr8[2];
                i12 += i13;
                i19 += i20;
                i18 += i8;
                i11 = (i11 + 1) % i7;
                iArr8 = iArr7[i11 % i7];
                i16 += iArr8[0];
                i15 += iArr8[1];
                i14 += iArr8[2];
                i13 -= iArr8[0];
                i20 -= iArr8[1];
                i8 -= iArr8[2];
                i3++;
            }
            i10 += width;
            i11 = i3;
        }
        for (i17 = 0; i17 < width; i17++) {
            i20 = 0;
            i8 = (-i) * width;
            i14 = 0;
            i15 = 0;
            i16 = 0;
            i11 = 0;
            i12 = -i;
            i3 = 0;
            i18 = 0;
            i19 = 0;
            i13 = 0;
            while (i12 <= i) {
                i2 = Math.max(0, i8) + i17;
                int[] iArr9 = iArr7[i12 + i];
                iArr9[0] = iArr2[i2];
                iArr9[1] = iArr3[i2];
                iArr9[2] = iArr4[i2];
                int abs = i9 - Math.abs(i12);
                i10 = (iArr2[i2] * abs) + i19;
                i19 = (iArr3[i2] * abs) + i18;
                i18 = (iArr4[i2] * abs) + i3;
                if (i12 > 0) {
                    i14 += iArr9[0];
                    i13 += iArr9[1];
                    i20 += iArr9[2];
                } else {
                    i11 += iArr9[0];
                    i16 += iArr9[1];
                    i15 += iArr9[2];
                }
                if (i12 < i5) {
                    i8 += width;
                }
                i12++;
                i3 = i18;
                i18 = i19;
                i19 = i10;
            }
            i12 = i18;
            i10 = i19;
            i19 = i3;
            i3 = i17;
            i8 = i20;
            i20 = i13;
            i13 = i14;
            i14 = i15;
            i15 = i16;
            i16 = i11;
            i11 = i;
            for (i18 = 0; i18 < height; i18++) {
                iArr[i3] = (((SystemBarTintManager.DEFAULT_TINT_COLOR & iArr[i3]) | (iArr6[i10] << 16)) | (iArr6[i12] << 8)) | iArr6[i19];
                i10 -= i16;
                i12 -= i15;
                i19 -= i14;
                int[] iArr10 = iArr7[((i11 - i) + i7) % i7];
                i16 -= iArr10[0];
                i15 -= iArr10[1];
                i14 -= iArr10[2];
                if (i17 == 0) {
                    iArr5[i18] = Math.min(i18 + i9, i5) * width;
                }
                i4 = iArr5[i18] + i17;
                iArr10[0] = iArr2[i4];
                iArr10[1] = iArr3[i4];
                iArr10[2] = iArr4[i4];
                i13 += iArr10[0];
                i20 += iArr10[1];
                i8 += iArr10[2];
                i10 += i13;
                i12 += i20;
                i19 += i8;
                i11 = (i11 + 1) % i7;
                iArr10 = iArr7[i11];
                i16 += iArr10[0];
                i15 += iArr10[1];
                i14 += iArr10[2];
                i13 -= iArr10[0];
                i20 -= iArr10[1];
                i8 -= iArr10[2];
                i3 += width;
            }
        }
        bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap2;
    }

    private static boolean bytesStartWith(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static Bitmap captureView(View view, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        int width = (bitmap.getWidth() - i) - i3;
        int height = (bitmap.getHeight() - i2) - i4;
        if (width == bitmap.getWidth() && height == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, (float) (-i), (float) (-i2), new Paint());
        return createBitmap;
    }

    public static String downloadBitmap(Context context, String str) {
        String cachePath = C4021R.getCachePath(context, "images");
        File file = new File(cachePath, Data.MD5(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        HashMap hashMap = new HashMap();
        new NetworkHelper().rawGet(str, new C40191(str, cachePath, hashMap), null);
        return (String) hashMap.get("bitmap");
    }

    public static int[] fixRect(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        if (((float) iArr[0]) / ((float) iArr[1]) > ((float) iArr2[0]) / ((float) iArr2[1])) {
            iArr3[0] = iArr2[0];
            iArr3[1] = (int) (((((float) iArr[1]) * ((float) iArr2[0])) / ((float) iArr[0])) + 0.5f);
        } else {
            iArr3[1] = iArr2[1];
            iArr3[0] = (int) (((((float) iArr[0]) * ((float) iArr2[1])) / ((float) iArr[1])) + 0.5f);
        }
        return iArr3;
    }

    public static int[] fixRect_2(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        if (((float) iArr[0]) / ((float) iArr[1]) > ((float) iArr2[0]) / ((float) iArr2[1])) {
            iArr3[1] = iArr2[1];
            iArr3[0] = (int) (((((float) iArr[0]) * ((float) iArr2[1])) / ((float) iArr[1])) + 0.5f);
        } else {
            iArr3[0] = iArr2[0];
            iArr3[1] = (int) (((((float) iArr[1]) * ((float) iArr2[0])) / ((float) iArr[0])) + 0.5f);
        }
        return iArr3;
    }

    public static Bitmap getBitmap(Context context, String str) {
        return getBitmap(downloadBitmap(context, str));
    }

    public static Bitmap getBitmap(File file, int i) {
        if (file == null || !file.exists()) {
            return null;
        }
        InputStream fileInputStream = new FileInputStream(file);
        Bitmap bitmap = getBitmap(fileInputStream, i);
        fileInputStream.close();
        return bitmap;
    }

    public static Bitmap getBitmap(InputStream inputStream, int i) {
        if (inputStream == null) {
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap getBitmap(String str) {
        return getBitmap(str, 1);
    }

    public static Bitmap getBitmap(String str, int i) {
        return TextUtils.isEmpty(str) ? null : getBitmap(new File(str), i);
    }

    public static CompressFormat getBmpFormat(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.endsWith("png") || toLowerCase.endsWith("gif")) {
            return CompressFormat.PNG;
        }
        if (toLowerCase.endsWith("jpg") || toLowerCase.endsWith("jpeg") || toLowerCase.endsWith("bmp") || toLowerCase.endsWith("tif")) {
            return CompressFormat.JPEG;
        }
        toLowerCase = getMime(str);
        return (toLowerCase.endsWith("png") || toLowerCase.endsWith("gif")) ? CompressFormat.PNG : CompressFormat.JPEG;
    }

    public static CompressFormat getBmpFormat(byte[] bArr) {
        String mime = getMime(bArr);
        CompressFormat compressFormat = CompressFormat.JPEG;
        return mime != null ? (mime.endsWith("png") || mime.endsWith("gif")) ? CompressFormat.PNG : compressFormat : compressFormat;
    }

    private static String getFileName(HttpConnection httpConnection, String str) {
        List list;
        String str2;
        String MD5;
        int lastIndexOf;
        Map headerFields = httpConnection.getHeaderFields();
        if (headerFields != null) {
            list = (List) headerFields.get(MIME.CONTENT_DISPOSITION);
            if (list != null && list.size() > 0) {
                str2 = null;
                for (String str3 : ((String) list.get(0)).split(";")) {
                    if (str3.trim().startsWith("filename")) {
                        str2 = str3.split("=")[1];
                        if (str2.startsWith("\"") && str2.endsWith("\"")) {
                            str2 = str2.substring(1, str2.length() - 1);
                        }
                    }
                }
                if (str2 == null) {
                    return str2;
                }
                MD5 = Data.MD5(str);
                if (headerFields != null) {
                    list = (List) headerFields.get(MIME.CONTENT_TYPE);
                    if (list != null && list.size() > 0) {
                        str2 = (String) list.get(0);
                        str2 = str2 != null ? BuildConfig.FLAVOR : str2.trim();
                        if (str2.startsWith("image/")) {
                            int lastIndexOf2 = str.lastIndexOf(47);
                            str2 = lastIndexOf2 <= 0 ? str.substring(lastIndexOf2 + 1) : null;
                            if (str2 != null && str2.length() > 0) {
                                lastIndexOf = str2.lastIndexOf(46);
                                if (lastIndexOf > 0 && str2.length() - lastIndexOf < 10) {
                                    return MD5 + str2.substring(lastIndexOf);
                                }
                            }
                        }
                        str2 = str2.substring("image/".length());
                        StringBuilder append = new StringBuilder().append(MD5).append(".");
                        if ("jpeg".equals(str2)) {
                            str2 = "jpg";
                        }
                        return append.append(str2).toString();
                    }
                }
                return MD5;
            }
        }
        str2 = null;
        if (str2 == null) {
            return str2;
        }
        MD5 = Data.MD5(str);
        if (headerFields != null) {
            list = (List) headerFields.get(MIME.CONTENT_TYPE);
            str2 = (String) list.get(0);
            if (str2 != null) {
            }
            if (str2.startsWith("image/")) {
                int lastIndexOf22 = str.lastIndexOf(47);
                if (lastIndexOf22 <= 0) {
                }
                lastIndexOf = str2.lastIndexOf(46);
                return MD5 + str2.substring(lastIndexOf);
            }
            str2 = str2.substring("image/".length());
            StringBuilder append2 = new StringBuilder().append(MD5).append(".");
            if ("jpeg".equals(str2)) {
                str2 = "jpg";
            }
            return append2.append(str2).toString();
        }
        return MD5;
    }

    private static String getMime(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return getMime(bArr);
        } catch (Throwable e) {
            MobLog.getInstance().m4388w(e);
            return null;
        }
    }

    private static String getMime(byte[] bArr) {
        byte[] bArr2 = new byte[]{(byte) -1, (byte) -40, (byte) -1, (byte) -31};
        if (bytesStartWith(bArr, new byte[]{(byte) -1, (byte) -40, (byte) -1, (byte) -32}) || bytesStartWith(bArr, bArr2)) {
            return "jpg";
        }
        if (bytesStartWith(bArr, new byte[]{(byte) -119, (byte) 80, (byte) 78, (byte) 71})) {
            return "png";
        }
        if (bytesStartWith(bArr, "GIF".getBytes())) {
            return "gif";
        }
        if (bytesStartWith(bArr, "BM".getBytes())) {
            return "bmp";
        }
        return (bytesStartWith(bArr, new byte[]{(byte) 73, (byte) 73, (byte) 42}) || bytesStartWith(bArr, new byte[]{(byte) 77, (byte) 77, (byte) 42})) ? "tif" : null;
    }

    public static boolean isBlackBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return true;
        }
        boolean z;
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i : iArr) {
            if ((i & ViewCompat.MEASURED_SIZE_MASK) != 0) {
                z = true;
                break;
            }
        }
        z = false;
        return !z;
    }

    public static int mixAlpha(int i, int i2) {
        int i3 = i >>> 24;
        return ((((255 - i3) * (i2 & MotionEventCompat.ACTION_MASK)) + (i3 * (i & MotionEventCompat.ACTION_MASK))) / MotionEventCompat.ACTION_MASK) | ((((((((16711680 & i) >>> 16) * i3) + (((16711680 & i2) >>> 16) * (255 - i3))) / MotionEventCompat.ACTION_MASK) << 16) | SystemBarTintManager.DEFAULT_TINT_COLOR) | ((((((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >>> 8) * i3) + ((255 - i3) * ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i2) >>> 8))) / MotionEventCompat.ACTION_MASK) << 8));
    }

    public static Bitmap roundBitmap(Bitmap bitmap, int i, int i2, float f, float f2, float f3, float f4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        Bitmap createBitmap = (width == i && height == i2) ? Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888) : Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect2 = new Rect(0, 0, i, i2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float[] fArr = new float[]{f, f, f2, f2, f3, f3, f4, f4};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr));
        shapeDrawable.setBounds(rect2);
        shapeDrawable.draw(canvas);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static String saveBitmap(Context context, Bitmap bitmap) {
        return saveBitmap(context, bitmap, CompressFormat.JPEG, 80);
    }

    public static String saveBitmap(Context context, Bitmap bitmap, CompressFormat compressFormat, int i) {
        String cachePath = C4021R.getCachePath(context, "images");
        String str = ".jpg";
        if (compressFormat == CompressFormat.PNG) {
            str = ".png";
        }
        File file = new File(cachePath, String.valueOf(System.currentTimeMillis()) + str);
        OutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(compressFormat, i, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static String saveViewToImage(View view) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        return (width <= 0 || height <= 0) ? null : saveViewToImage(view, width, height);
    }

    public static String saveViewToImage(View view, int i, int i2) {
        Bitmap captureView = captureView(view, i, i2);
        if (captureView == null || captureView.isRecycled()) {
            return null;
        }
        File file = new File(C4021R.getCachePath(view.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
        OutputStream fileOutputStream = new FileOutputStream(file);
        captureView.compress(CompressFormat.JPEG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static Bitmap scaleBitmapByHeight(Context context, int i, int i2) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        Object obj = i2 != decodeResource.getHeight() ? 1 : null;
        Bitmap scaleBitmapByHeight = scaleBitmapByHeight(decodeResource, i2);
        if (obj != null) {
            decodeResource.recycle();
        }
        return scaleBitmapByHeight;
    }

    public static Bitmap scaleBitmapByHeight(Bitmap bitmap, int i) {
        return Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * i) / bitmap.getHeight(), i, true);
    }
}
