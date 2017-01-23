package android.support.v4.content;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader.ForceLoadContentObserver;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
    final ForceLoadContentObserver f410f;
    Uri f411g;
    String[] f412h;
    String f413i;
    String[] f414j;
    String f415k;
    Cursor f416l;
    CancellationSignal f417m;

    public /* synthetic */ void m557a(Object obj) {
        m559b((Cursor) obj);
    }

    public /* synthetic */ void m560b(Object obj) {
        m556a((Cursor) obj);
    }

    public /* synthetic */ Object m561d() {
        return m563h();
    }

    public Cursor m563h() {
        synchronized (this) {
            if (m548g()) {
                throw new OperationCanceledException();
            }
            this.f417m = new CancellationSignal();
        }
        Cursor a;
        try {
            a = ContentResolverCompat.m552a(m525m().getContentResolver(), this.f411g, this.f412h, this.f413i, this.f414j, this.f415k, this.f417m);
            if (a != null) {
                a.getCount();
                a.registerContentObserver(this.f410f);
            }
            synchronized (this) {
                this.f417m = null;
            }
            return a;
        } catch (RuntimeException e) {
            a.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
            }
            this.f417m = null;
        }
    }

    public void m562f() {
        super.m547f();
        synchronized (this) {
            if (this.f417m != null) {
                this.f417m.m1003c();
            }
        }
    }

    public void m556a(Cursor cursor) {
        if (!m528p()) {
            Cursor cursor2 = this.f416l;
            this.f416l = cursor;
            if (m526n()) {
                super.m518b((Object) cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    protected void m564i() {
        if (this.f416l != null) {
            m556a(this.f416l);
        }
        if (m534v() || this.f416l == null) {
            m531s();
        }
    }

    protected void m565j() {
        m530r();
    }

    public void m559b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    protected void m566k() {
        super.m523k();
        m565j();
        if (!(this.f416l == null || this.f416l.isClosed())) {
            this.f416l.close();
        }
        this.f416l = null;
    }

    public void m558a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m541a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f411g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f412h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f413i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f414j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f415k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f416l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.u);
    }
}
