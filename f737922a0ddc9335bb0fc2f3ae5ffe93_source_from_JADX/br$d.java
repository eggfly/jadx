import java.io.File;

class br$d {
    private br$d() {
    }

    protected void j6(String str) {
    }

    protected void FH(String str) {
    }

    protected void DW(String str) {
    }

    public void Hw(String str) {
        String trim = str.trim();
        if (trim.endsWith(":") && trim.indexOf("\\") == -1) {
            str = trim + "\\";
        }
        File file = new File(str);
        if (file != null) {
            if (file.isDirectory()) {
                if (str != null) {
                    FH(str);
                }
            } else if (file.isFile() && str != null) {
                j6(str);
            }
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    Hw(str + File.separator + str2);
                }
                DW(str);
            }
        }
    }
}
