package groovyjarjarantlr;

public class ActionTransInfo {
    public String DW;
    public String FH;
    public boolean j6;

    public ActionTransInfo() {
        this.j6 = false;
        this.DW = null;
        this.FH = null;
    }

    public String toString() {
        return new StringBuffer().append("assignToRoot:").append(this.j6).append(", refRuleRoot:").append(this.DW).append(", FOLLOW Set:").append(this.FH).toString();
    }
}
