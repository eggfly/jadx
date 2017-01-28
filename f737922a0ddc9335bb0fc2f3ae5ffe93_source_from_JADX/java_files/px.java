import com.aide.ui.AIDEEditor;

public class px {
    public static boolean j6(AIDEEditor aIDEEditor, char c, int i, int i2) {
        if (c == '/' && aIDEEditor.FH(i).substring(0, i2 - 2).endsWith("<")) {
            return false;
        }
        return true;
    }

    public static boolean j6(AIDEEditor aIDEEditor, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i5 > 1 && aIDEEditor.FH(i5).trim().length() == 0) {
            i5--;
        }
        int Hw = aIDEEditor.Hw(i5);
        String FH = aIDEEditor.FH(i);
        String FH2 = aIDEEditor.FH(i5);
        String FH3 = aIDEEditor.FH(i + 1);
        if (FH.endsWith(">") && FH3.startsWith("</")) {
            aIDEEditor.VH(i + 1, 1);
            aIDEEditor.Hw(i + 1, 1);
            aIDEEditor.gn(i + 1, Hw + i3);
            aIDEEditor.gn(i + 2, Hw);
        } else {
            FH = FH2.trim();
            if (FH.startsWith("<") && !FH.startsWith("</")) {
                i5 = 0;
                while (i4 < FH.length()) {
                    if (FH.charAt(i4) == '>') {
                        i5++;
                    }
                    i4++;
                }
                if (i5 <= 1) {
                    aIDEEditor.gn(i + 1, Hw + i3);
                } else {
                    aIDEEditor.gn(i + 1, Hw);
                }
            } else if (!FH.endsWith("/>") || FH.contains("<")) {
                aIDEEditor.gn(i + 1, Hw);
            } else {
                aIDEEditor.gn(i + 1, Math.max(0, Hw - i3));
            }
        }
        return true;
    }
}
