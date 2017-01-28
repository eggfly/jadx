import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.e;
import java.io.File;

class oj$2 implements y<String> {
    final /* synthetic */ y DW;
    final /* synthetic */ String j6;

    oj$2(String str, y yVar) {
        this.j6 = str;
        this.DW = yVar;
    }

    public void j6(String str) {
        try {
            if (str.endsWith(".xml")) {
                str = str.substring(0, str.length() - ".xml".length());
            }
            String str2 = this.j6 + File.separator + str + ".xml";
            String str3 = "";
            if (qh.Zo(qh.v5(str2)).startsWith("layout")) {
                str3 = "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    android:layout_width=\"fill_parent\"\n    android:layout_height=\"fill_parent\"\n    android:orientation=\"vertical\">\n    \n</LinearLayout>\n";
            } else if (qh.Zo(qh.v5(str2)).startsWith("menu")) {
                str3 = "<menu xmlns:android=\"http://schemas.android.com/apk/res/android\">\n    \n    <item\n        android:id=\"@+id/item\"\n        android:title=\"Item\"/>\n    \n</menu>\n";
            } else {
                str3 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
            }
            qh.v5(str2, str3);
            this.DW.j6(str2);
        } catch (Throwable e) {
            m.j6(e.u7(), "Add Xml", e);
        }
    }
}
