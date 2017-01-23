import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aot {
    public String j6(List<aoc> list, aoc aoc) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Merge ");
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        Collection arrayList5 = new ArrayList();
        for (aoc aoc2 : list) {
            if (aoc2.j6().startsWith("refs/heads/")) {
                arrayList.add("'" + aoh.v5(aoc2.j6()) + "'");
            } else if (aoc2.j6().startsWith("refs/remotes/")) {
                arrayList2.add("'" + aoh.v5(aoc2.j6()) + "'");
            } else if (aoc2.j6().startsWith("refs/tags/")) {
                arrayList3.add("'" + aoh.v5(aoc2.j6()) + "'");
            } else if (aoc2.j6().equals(aoc2.v5().FH())) {
                arrayList4.add("'" + aoc2.j6() + "'");
            } else {
                arrayList5.add(aoc2.j6());
            }
        }
        Collection arrayList6 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList6.add(j6(arrayList, "branch", "branches"));
        }
        if (!arrayList2.isEmpty()) {
            arrayList6.add(j6(arrayList2, "remote-tracking branch", "remote-tracking branches"));
        }
        if (!arrayList3.isEmpty()) {
            arrayList6.add(j6(arrayList3, "tag", "tags"));
        }
        if (!arrayList4.isEmpty()) {
            arrayList6.add(j6(arrayList4, "commit", "commits"));
        }
        if (!arrayList5.isEmpty()) {
            arrayList6.add(axh.j6(arrayList5, ", ", " and "));
        }
        stringBuilder.append(axh.j6(arrayList6, ", "));
        String j6 = aoc.FH().j6();
        if (!j6.equals("refs/heads/master")) {
            stringBuilder.append(" into " + aoh.v5(j6));
        }
        return stringBuilder.toString();
    }

    public String j6(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!str.endsWith("\n")) {
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Conflicts:\n");
        for (String append : list) {
            stringBuilder.append('\t').append(append).append('\n');
        }
        return stringBuilder.toString();
    }

    private static String j6(List<String> list, String str, String str2) {
        if (list.size() == 1) {
            return new StringBuilder(String.valueOf(str)).append(" ").append((String) list.get(0)).toString();
        }
        return new StringBuilder(String.valueOf(str2)).append(" ").append(axh.j6(list, ", ", " and ")).toString();
    }
}
