import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

class ave$1 extends avl {
    ave$1() {
    }

    public String j6() {
        return "Amazon S3";
    }

    public Set<String> DW() {
        return Collections.singleton("amazon-s3");
    }

    public Set<avl$a> FH() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.USER, avl$a.HOST, avl$a.PATH));
    }

    public Set<avl$a> Hw() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.PASS));
    }

    public avd j6(avn avn, aoh aoh, String str) {
        return new ave(aoh, avn);
    }
}
