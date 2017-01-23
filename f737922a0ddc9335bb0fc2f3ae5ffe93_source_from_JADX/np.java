import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

public class np extends m {
    private String DW;
    private String j6;

    public np(String str) {
        this.j6 = str;
        this.DW = "/";
    }

    protected Dialog j6(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.c.downloaddropbox, null);
        Builder builder = new Builder(activity);
        builder.setTitle("Download Dropbox Folder").setView(inflate).setCancelable(true).setPositiveButton("Download", new np$3(this)).setNegativeButton("Cancel", new np$2(this)).setNeutralButton("Logout", new np$1(this));
        Dialog create = builder.create();
        create.setOnShowListener(new np$4(this));
        return create;
    }

    private void j6(AlertDialog alertDialog) {
        boolean z = true;
        v5(alertDialog).setText("Local Folder: " + DW());
        Zo(alertDialog).setText("Dropbox Folder: " + Hw());
        Button button = alertDialog.getButton(-1);
        if (Hw().length() <= 1 || qh.VH(DW())) {
            z = false;
        }
        button.setEnabled(z);
    }

    private String DW() {
        return v5() + "/" + FH();
    }

    private void DW(AlertDialog alertDialog) {
        Hw(alertDialog).setVisibility(0);
        FH(alertDialog).setEnabled(false);
        alertDialog.getButton(-1).setEnabled(false);
        e.nw().j6(Hw(), new np$5(this, alertDialog));
    }

    private void j6(AlertDialog alertDialog, List<String> list) {
        j6(alertDialog);
        Hw(alertDialog).setVisibility(8);
        FH(alertDialog).setEnabled(true);
        List arrayList = new ArrayList();
        if (Hw().length() > 1) {
            arrayList.add("..");
        }
        for (String str : list) {
            arrayList.add(str.substring(str.lastIndexOf(47) + 1));
        }
        FH(alertDialog).setAdapter(new ArrayAdapter(e.gn(), R.c.downloaddropbox_entry, R.b.downloaddropboxEntryName, arrayList));
        FH(alertDialog).setOnItemClickListener(new np$6(this, alertDialog));
    }

    private String FH() {
        return this.DW.substring(this.DW.lastIndexOf(47) + 1);
    }

    private String Hw() {
        return this.DW;
    }

    private ListView FH(AlertDialog alertDialog) {
        return (ListView) alertDialog.findViewById(R.b.downloadDropboxList);
    }

    private View Hw(AlertDialog alertDialog) {
        return alertDialog.findViewById(R.b.downloadDropboxProgress);
    }

    private TextView v5(AlertDialog alertDialog) {
        return (TextView) alertDialog.findViewById(R.b.downloadDropboxLocation);
    }

    private TextView Zo(AlertDialog alertDialog) {
        return (TextView) alertDialog.findViewById(R.b.downloadDropboxFolder);
    }

    private String v5() {
        return this.j6;
    }
}
