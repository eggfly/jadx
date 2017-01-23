package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader.a;
import e;
import g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
    String EQ;
    e J0;
    Uri VH;
    final a Zo;
    String[] gn;
    String[] tp;
    String u7;
    Cursor we;

    public /* synthetic */ void DW(Object obj) {
        j6((Cursor) obj);
    }

    public /* synthetic */ Object Hw() {
        return gn();
    }

    public /* synthetic */ void j6(Object obj) {
        DW((Cursor) obj);
    }

    public Cursor gn() {
        synchronized (this) {
            if (VH()) {
                throw new g();
            }
            this.J0 = new e();
        }
        Cursor j6;
        try {
            j6 = a.j6(J0().getContentResolver(), this.VH, this.gn, this.u7, this.tp, this.EQ, this.J0);
            if (j6 != null) {
                j6.getCount();
                j6.registerContentObserver(this.Zo);
            }
            synchronized (this) {
                this.J0 = null;
            }
            return j6;
        } catch (RuntimeException e) {
            j6.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
            }
            this.J0 = null;
        }
    }

    public void Zo() {
        super.Zo();
        synchronized (this) {
            if (this.J0 != null) {
                this.J0.FH();
            }
        }
    }

    public void j6(Cursor cursor) {
        if (!QX()) {
            Cursor cursor2 = this.we;
            this.we = cursor;
            if (J8()) {
                super.DW((Object) cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public CursorLoader(Context context) {
        super(context);
        this.Zo = new a(this);
    }

    protected void u7() {
        if (this.we != null) {
            j6(this.we);
        }
        if (a8() || this.we == null) {
            j3();
        }
    }

    protected void tp() {
        aM();
    }

    public void DW(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    protected void EQ() {
        super.EQ();
        tp();
        if (!(this.we == null || this.we.isClosed())) {
            this.we.close();
        }
        this.we = null;
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.j6(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.VH);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.gn));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.u7);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.tp));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.EQ);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.we);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.U2);
    }
}
