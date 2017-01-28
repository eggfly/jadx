import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

class pq$1$3 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ pq$1 FH;
    final /* synthetic */ String j6;

    pq$1$3(pq$1 pq_1, String str, String str2) {
        this.FH = pq_1;
        this.j6 = str;
        this.DW = str2;
    }

    public void run() {
        e.u7().J0();
        m.j6(e.u7(), e.j6((int) R.f.dialog_rename_title, new Object[0]), e.j6((int) R.f.dialog_rename_message_for, this.j6), this.DW, new pq$1$3$1(this));
    }
}
