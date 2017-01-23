import java.util.ArrayList;
import java.util.List;

class avi$a implements aut {
    final /* synthetic */ avi j6;

    private avi$a(avi avi) {
        this.j6 = avi;
    }

    public Process j6(String str, int i) {
        String j6 = axi.FH().j6("GIT_SSH");
        boolean contains = j6.toLowerCase().contains("plink");
        List arrayList = new ArrayList();
        arrayList.add(j6);
        if (contains && !j6.toLowerCase().contains("tortoiseplink")) {
            arrayList.add("-batch");
        }
        if (this.j6.Hw().VH() > 0) {
            arrayList.add(contains ? "-P" : "-p");
            arrayList.add(String.valueOf(this.j6.Hw().VH()));
        }
        if (this.j6.Hw().v5() != null) {
            arrayList.add(new StringBuilder(String.valueOf(this.j6.Hw().v5())).append("@").append(this.j6.Hw().j6()).toString());
        } else {
            arrayList.add(this.j6.Hw().j6());
        }
        arrayList.add(str);
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command(arrayList);
        if (this.j6.FH.DW() != null) {
            processBuilder.environment().put("GIT_DIR", this.j6.FH.DW().getPath());
        }
        try {
            return processBuilder.start();
        } catch (Throwable e) {
            throw new amb(e.getMessage(), e);
        }
    }

    public void j6() {
    }
}
