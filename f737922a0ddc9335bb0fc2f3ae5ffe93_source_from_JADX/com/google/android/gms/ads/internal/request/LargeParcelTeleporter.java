package com.google.android.gms.ads.internal.request;

import afx;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.eh;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@eh
public final class LargeParcelTeleporter extends AbstractSafeParcelable {
    public static final Creator<LargeParcelTeleporter> CREATOR;
    ParcelFileDescriptor DW;
    private Parcelable FH;
    private boolean Hw;
    final int j6;

    class 1 implements Runnable {
        final /* synthetic */ byte[] DW;
        final /* synthetic */ LargeParcelTeleporter FH;
        final /* synthetic */ OutputStream j6;

        1(LargeParcelTeleporter largeParcelTeleporter, OutputStream outputStream, byte[] bArr) {
            this.FH = largeParcelTeleporter;
            this.j6 = outputStream;
            this.DW = bArr;
        }

        public void run() {
            Closeable dataOutputStream;
            Throwable e;
            try {
                dataOutputStream = new DataOutputStream(this.j6);
                try {
                    dataOutputStream.writeInt(this.DW.length);
                    dataOutputStream.write(this.DW);
                    afx.j6(dataOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        b.DW("Error transporting the ad response", e);
                        f.Zo().j6(e, true);
                        if (dataOutputStream != null) {
                            afx.j6(this.j6);
                        } else {
                            afx.j6(dataOutputStream);
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (dataOutputStream != null) {
                            afx.j6(this.j6);
                        } else {
                            afx.j6(dataOutputStream);
                        }
                        throw e;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                dataOutputStream = null;
                b.DW("Error transporting the ad response", e);
                f.Zo().j6(e, true);
                if (dataOutputStream != null) {
                    afx.j6(dataOutputStream);
                } else {
                    afx.j6(this.j6);
                }
            } catch (Throwable th2) {
                e = th2;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                    afx.j6(dataOutputStream);
                } else {
                    afx.j6(this.j6);
                }
                throw e;
            }
        }
    }

    static {
        CREATOR = new f();
    }

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.j6 = i;
        this.DW = parcelFileDescriptor;
        this.FH = null;
        this.Hw = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.j6 = 1;
        this.DW = null;
        this.FH = safeParcelable;
        this.Hw = false;
    }

    protected <T> ParcelFileDescriptor j6(byte[] bArr) {
        Closeable autoCloseOutputStream;
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new 1(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            b.DW("Error transporting the ad response", e);
            f.Zo().j6(e, true);
            afx.j6(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }

    public <T extends SafeParcelable> T j6(Creator<T> creator) {
        if (this.Hw) {
            if (this.DW == null) {
                b.DW("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.DW));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                afx.j6(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.FH = (SafeParcelable) creator.createFromParcel(obtain);
                    this.Hw = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                afx.j6(dataInputStream);
            }
        }
        return (SafeParcelable) this.FH;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.DW == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.FH.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.DW = j6(marshall);
            } finally {
                obtain.recycle();
            }
        }
        f.j6(this, parcel, i);
    }
}
