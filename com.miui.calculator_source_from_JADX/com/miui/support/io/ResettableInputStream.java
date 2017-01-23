package com.miui.support.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.AssetManager.AssetInputStream;
import android.net.Uri;
import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResettableInputStream extends InputStream {
    private final Object f3286a;
    private final Type f3287b;
    private final Context f3288c;
    private final Uri f3289d;
    private final String f3290e;
    private final AssetManager f3291f;
    private final String f3292g;
    private final byte[] f3293h;
    private volatile InputStream f3294i;
    private IOException f3295j;
    private Throwable f3296k;

    /* renamed from: com.miui.support.io.ResettableInputStream.1 */
    class C03991 {
        final /* synthetic */ ResettableInputStream f3279a;

        protected void finalize() {
            try {
                if (this.f3279a.f3296k != null) {
                    Log.e("ResettableInputStream", "InputStream is opened but never closed here", this.f3279a.f3296k);
                }
                this.f3279a.close();
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: com.miui.support.io.ResettableInputStream.2 */
    /* synthetic */ class C04002 {
        static final /* synthetic */ int[] f3280a;

        static {
            f3280a = new int[Type.values().length];
            try {
                f3280a[Type.Uri.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3280a[Type.File.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3280a[Type.Asset.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3280a[Type.ByteArray.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private enum Type {
        File,
        Uri,
        Asset,
        ByteArray
    }

    private void m4994a() {
        if (this.f3295j != null) {
            throw this.f3295j;
        } else if (this.f3294i == null) {
            synchronized (this.f3286a) {
                if (this.f3294i != null) {
                    return;
                }
                switch (C04002.f3280a[this.f3287b.ordinal()]) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        this.f3294i = this.f3288c.getContentResolver().openInputStream(this.f3289d);
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        this.f3294i = new FileInputStream(this.f3290e);
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        this.f3294i = this.f3291f.open(this.f3292g);
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        this.f3294i = new ByteArrayInputStream(this.f3293h);
                        break;
                    default:
                        throw new IllegalStateException("Unkown type " + this.f3287b);
                }
                this.f3296k = new Throwable();
            }
        }
    }

    public int available() {
        m4994a();
        return this.f3294i.available();
    }

    public void close() {
        if (this.f3294i != null) {
            synchronized (this.f3286a) {
                if (this.f3294i == null) {
                    return;
                }
                try {
                    this.f3294i.close();
                    this.f3296k = null;
                    this.f3294i = null;
                    this.f3295j = null;
                } catch (Throwable th) {
                    this.f3296k = null;
                    this.f3294i = null;
                    this.f3295j = null;
                }
            }
        }
    }

    public void mark(int i) {
        try {
            m4994a();
            this.f3294i.mark(i);
        } catch (IOException e) {
            this.f3295j = e;
        }
    }

    public boolean markSupported() {
        try {
            m4994a();
            return this.f3294i.markSupported();
        } catch (IOException e) {
            this.f3295j = e;
            return super.markSupported();
        }
    }

    public int read() {
        m4994a();
        return this.f3294i.read();
    }

    public int read(byte[] bArr) {
        m4994a();
        return this.f3294i.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) {
        m4994a();
        return this.f3294i.read(bArr, i, i2);
    }

    public synchronized void reset() {
        if (this.f3294i != null) {
            if (this.f3294i instanceof FileInputStream) {
                ((FileInputStream) this.f3294i).getChannel().position(0);
            } else if ((this.f3294i instanceof AssetInputStream) || (this.f3294i instanceof ByteArrayInputStream)) {
                this.f3294i.reset();
            } else {
                close();
            }
        }
    }

    public long skip(long j) {
        m4994a();
        return this.f3294i.skip(j);
    }
}
