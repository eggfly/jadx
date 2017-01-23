package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends AbstractSafeParcelable {
    public static final Creator<BitmapTeleporter> CREATOR;
    ParcelFileDescriptor DW;
    final int FH;
    private Bitmap Hw;
    private File Zo;
    final int j6;
    private boolean v5;

    static {
        CREATOR = new a();
    }

    BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.j6 = i;
        this.DW = parcelFileDescriptor;
        this.FH = i2;
        this.Hw = null;
        this.v5 = false;
    }

    private FileOutputStream j6() {
        if (this.Zo == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.Zo);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.DW = ParcelFileDescriptor.open(createTempFile, 268435456);
                createTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    private void j6(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.DW == null) {
            Bitmap bitmap = this.Hw;
            Buffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            Closeable dataOutputStream = new DataOutputStream(j6());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                j6(dataOutputStream);
            } catch (Throwable e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                j6(dataOutputStream);
            }
        }
        a.j6(this, parcel, i | 1);
        this.DW = null;
    }
}
