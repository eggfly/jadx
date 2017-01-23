package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat {
    final Context f662a;
    Options f663b;
    private final Object f664c;

    public interface OnPrintFinishCallback {
        void m1012a();
    }

    /* renamed from: android.support.v4.print.PrintHelperKitkat.1 */
    class C00691 extends PrintDocumentAdapter {
        final /* synthetic */ String f642a;
        final /* synthetic */ Bitmap f643b;
        final /* synthetic */ int f644c;
        final /* synthetic */ OnPrintFinishCallback f645d;
        final /* synthetic */ PrintHelperKitkat f646e;
        private PrintAttributes f647f;

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
            boolean z = true;
            this.f647f = printAttributes2;
            PrintDocumentInfo build = new Builder(this.f642a).setContentType(1).setPageCount(1).build();
            if (printAttributes2.equals(printAttributes)) {
                z = false;
            }
            layoutResultCallback.onLayoutFinished(build, z);
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.f646e.f662a, this.f647f);
            Bitmap a = this.f646e.m1020a(this.f643b, this.f647f.getColorMode());
            try {
                Page startPage = printedPdfDocument.startPage(1);
                startPage.getCanvas().drawBitmap(a, this.f646e.m1025a(a.getWidth(), a.getHeight(), new RectF(startPage.getInfo().getContentRect()), this.f644c), null);
                printedPdfDocument.finishPage(startPage);
                printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } catch (Throwable e) {
                Log.e("PrintHelperKitkat", "Error writing printed content", e);
                writeResultCallback.onWriteFailed(null);
            } catch (Throwable th) {
                if (printedPdfDocument != null) {
                    printedPdfDocument.close();
                }
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e2) {
                    }
                }
                if (a != this.f643b) {
                    a.recycle();
                }
            }
            if (printedPdfDocument != null) {
                printedPdfDocument.close();
            }
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e3) {
                }
            }
            if (a != this.f643b) {
                a.recycle();
            }
        }

        public void onFinish() {
            if (this.f645d != null) {
                this.f645d.m1012a();
            }
        }
    }

    /* renamed from: android.support.v4.print.PrintHelperKitkat.2 */
    class C00722 extends PrintDocumentAdapter {
        AsyncTask<Uri, Boolean, Bitmap> f654a;
        Bitmap f655b;
        final /* synthetic */ String f656c;
        final /* synthetic */ Uri f657d;
        final /* synthetic */ OnPrintFinishCallback f658e;
        final /* synthetic */ int f659f;
        final /* synthetic */ PrintHelperKitkat f660g;
        private PrintAttributes f661h;

        /* renamed from: android.support.v4.print.PrintHelperKitkat.2.1 */
        class C00711 extends AsyncTask<Uri, Boolean, Bitmap> {
            final /* synthetic */ CancellationSignal f649a;
            final /* synthetic */ PrintAttributes f650b;
            final /* synthetic */ PrintAttributes f651c;
            final /* synthetic */ LayoutResultCallback f652d;
            final /* synthetic */ C00722 f653e;

            /* renamed from: android.support.v4.print.PrintHelperKitkat.2.1.1 */
            class C00701 implements OnCancelListener {
                final /* synthetic */ C00711 f648a;

                C00701(C00711 c00711) {
                    this.f648a = c00711;
                }

                public void onCancel() {
                    this.f648a.f653e.m1018a();
                    this.f648a.cancel(false);
                }
            }

            C00711(C00722 c00722, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, LayoutResultCallback layoutResultCallback) {
                this.f653e = c00722;
                this.f649a = cancellationSignal;
                this.f650b = printAttributes;
                this.f651c = printAttributes2;
                this.f652d = layoutResultCallback;
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m1015a((Uri[]) objArr);
            }

            protected /* synthetic */ void onCancelled(Object obj) {
                m1017b((Bitmap) obj);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m1016a((Bitmap) obj);
            }

            protected void onPreExecute() {
                this.f649a.setOnCancelListener(new C00701(this));
            }

            protected Bitmap m1015a(Uri... uriArr) {
                try {
                    return this.f653e.f660g.m1021a(this.f653e.f657d, 3500);
                } catch (FileNotFoundException e) {
                    return null;
                }
            }

            protected void m1016a(Bitmap bitmap) {
                boolean z = true;
                super.onPostExecute(bitmap);
                this.f653e.f655b = bitmap;
                if (bitmap != null) {
                    PrintDocumentInfo build = new Builder(this.f653e.f656c).setContentType(1).setPageCount(1).build();
                    if (this.f650b.equals(this.f651c)) {
                        z = false;
                    }
                    this.f652d.onLayoutFinished(build, z);
                } else {
                    this.f652d.onLayoutFailed(null);
                }
                this.f653e.f654a = null;
            }

            protected void m1017b(Bitmap bitmap) {
                this.f652d.onLayoutCancelled();
                this.f653e.f654a = null;
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
            boolean z = true;
            this.f661h = printAttributes2;
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f655b != null) {
                PrintDocumentInfo build = new Builder(this.f656c).setContentType(1).setPageCount(1).build();
                if (printAttributes2.equals(printAttributes)) {
                    z = false;
                }
                layoutResultCallback.onLayoutFinished(build, z);
            } else {
                this.f654a = new C00711(this, cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
            }
        }

        private void m1018a() {
            synchronized (this.f660g.f664c) {
                if (this.f660g.f663b != null) {
                    this.f660g.f663b.requestCancelDecode();
                    this.f660g.f663b = null;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            m1018a();
            if (this.f654a != null) {
                this.f654a.cancel(true);
            }
            if (this.f658e != null) {
                this.f658e.m1012a();
            }
            if (this.f655b != null) {
                this.f655b.recycle();
                this.f655b = null;
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.f660g.f662a, this.f661h);
            Bitmap a = this.f660g.m1020a(this.f655b, this.f661h.getColorMode());
            try {
                Page startPage = printedPdfDocument.startPage(1);
                startPage.getCanvas().drawBitmap(a, this.f660g.m1025a(this.f655b.getWidth(), this.f655b.getHeight(), new RectF(startPage.getInfo().getContentRect()), this.f659f), null);
                printedPdfDocument.finishPage(startPage);
                printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } catch (Throwable e) {
                Log.e("PrintHelperKitkat", "Error writing printed content", e);
                writeResultCallback.onWriteFailed(null);
            } catch (Throwable th) {
                if (printedPdfDocument != null) {
                    printedPdfDocument.close();
                }
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e2) {
                    }
                }
                if (a != this.f655b) {
                    a.recycle();
                }
            }
            if (printedPdfDocument != null) {
                printedPdfDocument.close();
            }
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e3) {
                }
            }
            if (a != this.f655b) {
                a.recycle();
            }
        }
    }

    private Matrix m1025a(int i, int i2, RectF rectF, int i3) {
        Matrix matrix = new Matrix();
        float width = rectF.width() / ((float) i);
        if (i3 == 2) {
            width = Math.max(width, rectF.height() / ((float) i2));
        } else {
            width = Math.min(width, rectF.height() / ((float) i2));
        }
        matrix.postScale(width, width);
        matrix.postTranslate((rectF.width() - (((float) i) * width)) / 2.0f, (rectF.height() - (width * ((float) i2))) / 2.0f);
        return matrix;
    }

    private Bitmap m1021a(Uri uri, int i) {
        int i2 = 1;
        Bitmap bitmap = null;
        if (i <= 0 || uri == null || this.f662a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        m1022a(uri, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > 0 && i4 > 0) {
            int max = Math.max(i3, i4);
            while (max > i) {
                max >>>= 1;
                i2 <<= 1;
            }
            if (i2 > 0 && Math.min(i3, i4) / i2 > 0) {
                Options options2;
                synchronized (this.f664c) {
                    this.f663b = new Options();
                    this.f663b.inMutable = true;
                    this.f663b.inSampleSize = i2;
                    options2 = this.f663b;
                }
                try {
                    bitmap = m1022a(uri, options2);
                    synchronized (this.f664c) {
                        this.f663b = null;
                    }
                } catch (Throwable th) {
                    synchronized (this.f664c) {
                    }
                    this.f663b = null;
                }
            }
        }
        return bitmap;
    }

    private Bitmap m1022a(Uri uri, Options options) {
        InputStream inputStream = null;
        if (uri == null || this.f662a == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        try {
            inputStream = this.f662a.getContentResolver().openInputStream(uri);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    Log.w("PrintHelperKitkat", "close fail ", e);
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    Log.w("PrintHelperKitkat", "close fail ", e2);
                }
            }
        }
    }

    private Bitmap m1020a(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
