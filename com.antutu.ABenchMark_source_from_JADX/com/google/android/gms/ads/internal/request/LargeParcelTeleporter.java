package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.jm;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@gb
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Creator<LargeParcelTeleporter> CREATOR;
    final int f9918a;
    ParcelFileDescriptor f9919b;
    private Parcelable f9920c;
    private boolean f9921d;

    /* renamed from: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.1 */
    class C29051 implements Runnable {
        final /* synthetic */ OutputStream f9915a;
        final /* synthetic */ byte[] f9916b;
        final /* synthetic */ LargeParcelTeleporter f9917c;

        C29051(LargeParcelTeleporter largeParcelTeleporter, OutputStream outputStream, byte[] bArr) {
            this.f9917c = largeParcelTeleporter;
            this.f9915a = outputStream;
            this.f9916b = bArr;
        }

        public void run() {
            Throwable e;
            Closeable dataOutputStream;
            try {
                dataOutputStream = new DataOutputStream(this.f9915a);
                try {
                    dataOutputStream.writeInt(this.f9916b.length);
                    dataOutputStream.write(this.f9916b);
                    if (dataOutputStream == null) {
                        jm.m13561a(this.f9915a);
                    } else {
                        jm.m13561a(dataOutputStream);
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C2972b.m11580b("Error transporting the ad response", e);
                        C2968s.m11528h().m12941a(e, true);
                        if (dataOutputStream != null) {
                            jm.m13561a(this.f9915a);
                        } else {
                            jm.m13561a(dataOutputStream);
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (dataOutputStream != null) {
                            jm.m13561a(this.f9915a);
                        } else {
                            jm.m13561a(dataOutputStream);
                        }
                        throw e;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                dataOutputStream = null;
                C2972b.m11580b("Error transporting the ad response", e);
                C2968s.m11528h().m12941a(e, true);
                if (dataOutputStream != null) {
                    jm.m13561a(dataOutputStream);
                } else {
                    jm.m13561a(this.f9915a);
                }
            } catch (Throwable th2) {
                e = th2;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                    jm.m13561a(dataOutputStream);
                } else {
                    jm.m13561a(this.f9915a);
                }
                throw e;
            }
        }
    }

    static {
        CREATOR = new C2938l();
    }

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f9918a = i;
        this.f9919b = parcelFileDescriptor;
        this.f9920c = null;
        this.f9921d = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.f9918a = 1;
        this.f9919b = null;
        this.f9920c = safeParcelable;
        this.f9921d = false;
    }

    protected <T> ParcelFileDescriptor m11299a(byte[] bArr) {
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        Closeable autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new C29051(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            C2972b.m11580b("Error transporting the ad response", e);
            C2968s.m11528h().m12941a(e, true);
            jm.m13561a(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }

    public <T extends SafeParcelable> T m11300a(Creator<T> creator) {
        if (this.f9921d) {
            if (this.f9919b == null) {
                C2972b.m11579b("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.f9919b));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                jm.m13561a(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.f9920c = (SafeParcelable) creator.createFromParcel(obtain);
                    this.f9921d = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                jm.m13561a(dataInputStream);
            }
        }
        return (SafeParcelable) this.f9920c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f9919b == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f9920c.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.f9919b = m11299a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        C2938l.m11423a(this, parcel, i);
    }
}
