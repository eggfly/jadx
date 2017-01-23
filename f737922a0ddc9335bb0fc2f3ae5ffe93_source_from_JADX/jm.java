import com.aide.common.m;
import com.aide.ui.AIDEEditor;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

public class jm implements qk {
    public int f_() {
        return R.b.filetabMenuCloseAll;
    }

    public boolean DW() {
        boolean z = false;
        for (AIDEEditor filePath : e.u7().sh().getFileEditors()) {
            boolean z2;
            if (e.j3().DW(filePath.getFilePath()).gn()) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z) {
            m.j6(e.u7(), (int) R.f.dialog_save_files_title, (int) R.f.dialog_save_files_message, new jm$1(this), null);
        } else {
            Hw();
        }
        return true;
    }

    private void Hw() {
        List<AIDEEditor> fileEditors = e.u7().sh().getFileEditors();
        List<String> arrayList = new ArrayList();
        for (AIDEEditor filePath : fileEditors) {
            arrayList.add(filePath.getFilePath());
        }
        for (String Hw : arrayList) {
            e.j3().Hw(Hw);
        }
    }

    public boolean g_() {
        return true;
    }
}
