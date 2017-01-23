package groovyjarjarantlr.build;

public class Tool {
    public String j6;

    public Tool() {
        this.j6 = null;
        this.j6 = System.getProperty("os.name");
    }

    public void j6(String str) {
        System.out.println(str);
    }

    public void DW(String str) {
        System.err.println(str);
    }
}
