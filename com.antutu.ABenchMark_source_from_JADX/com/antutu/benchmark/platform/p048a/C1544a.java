package com.antutu.benchmark.platform.p048a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.antutu.utils.log;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.AdError;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.antutu.benchmark.platform.a.a */
public class C1544a {
    byte[] f5377a;
    byte[] f5378b;
    private Context f5379c;

    public C1544a(Context context) {
        this.f5379c = context;
    }

    void m6113a(byte[] bArr, String str) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.f5379c.openFileOutput(str, 0));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e) {
            log.m6882e(e.toString());
        }
    }

    byte[] m6114a(int i) {
        try {
            InputStream openRawResource = this.f5379c.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            log.m6882e(e.toString());
            return null;
        }
    }

    byte[] m6115a(String str) {
        try {
            InputStream openFileInput = this.f5379c.openFileInput(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            log.m6882e(e.toString());
            return null;
        }
    }

    public double m6116b(int i) {
        this.f5377a = m6114a(i);
        String str = "test.golden";
        Options options = new Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        int i2 = 0;
        double d = 0.0d;
        while (true) {
            long nanoTime = System.nanoTime();
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.f5377a, 0, this.f5377a.length, options);
            long nanoTime2 = System.nanoTime();
            options.inBitmap = decodeByteArray;
            if (i2 == 0) {
                Buffer allocate = ByteBuffer.allocate(decodeByteArray.getByteCount());
                decodeByteArray.copyPixelsToBuffer(allocate);
                m6113a(allocate.array(), "test.golden");
                this.f5378b = m6115a("test.golden");
                try {
                    new File("test.golden").delete();
                } catch (Exception e) {
                }
                if (!Arrays.equals(allocate.array(), this.f5378b)) {
                    return 0.0d;
                }
            }
            d += (((double) (nanoTime2 - nanoTime)) / 1000.0d) / 1000.0d;
            if (d > 5000.0d) {
                return ((double) (i2 * AdError.NETWORK_ERROR_CODE)) / d;
            }
            i2++;
        }
    }
}
