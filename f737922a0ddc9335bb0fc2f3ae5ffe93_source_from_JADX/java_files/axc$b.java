public class axc$b extends axc$a {
    public String j6(String str) {
        if (str.matches("^~[A-Za-z0-9_-]+$")) {
            return new StringBuilder(String.valueOf(str)).append("/").toString();
        }
        if (!str.matches("^~[A-Za-z0-9_-]*/.*$")) {
            return super.j6(str);
        }
        int indexOf = str.indexOf(47) + 1;
        if (indexOf != str.length()) {
            return str.substring(0, indexOf) + super.j6(str.substring(indexOf));
        }
        return str;
    }
}
