import com.aide.ui.AIDEEditor;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;

public class jo implements qk {
    public int f_() {
        return R.b.filetabMenuCloseOthers;
    }

    public boolean DW() {
        String Hw = e.j3().Hw();
        List<String> arrayList = new ArrayList();
        for (AIDEEditor filePath : e.u7().sh().getFileEditors()) {
            String filePath2 = filePath.getFilePath();
            if (!(Hw.equals(filePath2) || e.j3().DW(filePath2).gn())) {
                arrayList.add(filePath2);
            }
        }
        for (String filePath22 : arrayList) {
            e.j3().Hw(filePath22);
        }
        return true;
    }

    public boolean g_() {
        return e.j3().VH();
    }
}
