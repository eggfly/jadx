package groovyjarjarantlr;

public class CommonHiddenStreamToken extends CommonToken {
    protected CommonHiddenStreamToken DW;
    protected CommonHiddenStreamToken j6;

    public CommonHiddenStreamToken j6() {
        return this.DW;
    }

    public CommonHiddenStreamToken DW() {
        return this.j6;
    }

    protected void j6(CommonHiddenStreamToken commonHiddenStreamToken) {
        this.DW = commonHiddenStreamToken;
    }

    protected void DW(CommonHiddenStreamToken commonHiddenStreamToken) {
        this.j6 = commonHiddenStreamToken;
    }
}
