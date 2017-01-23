import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class np$6 implements OnItemClickListener {
    final /* synthetic */ np DW;
    final /* synthetic */ AlertDialog j6;

    np$6(np npVar, AlertDialog alertDialog) {
        this.DW = npVar;
        this.j6 = alertDialog;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) adapterView.getItemAtPosition(i);
        if (str.equals("..")) {
            this.DW.DW = this.DW.DW.substring(0, this.DW.DW.lastIndexOf(47));
            if (this.DW.DW.length() == 0) {
                this.DW.DW = "/";
            }
        } else {
            if (this.DW.DW.length() > 1) {
                this.DW.DW = this.DW.DW + "/";
            }
            this.DW.DW = this.DW.DW + str;
        }
        this.DW.DW(this.j6);
    }
}
