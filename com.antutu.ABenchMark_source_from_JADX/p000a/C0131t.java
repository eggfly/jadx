package p000a;

import com.umeng.message.util.HttpRequest;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: a.t */
public final class C0131t {
    private static final Pattern f550a;
    private static final Pattern f551b;
    private final String f552c;
    private final String f553d;
    private final String f554e;
    private final String f555f;

    static {
        f550a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f551b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private C0131t(String str, String str2, String str3, String str4) {
        this.f552c = str;
        this.f553d = str2;
        this.f554e = str3;
        this.f555f = str4;
    }

    public static C0131t m607a(String str) {
        Matcher matcher = f550a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f551b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase(HttpRequest.f14538D)) {
                group = matcher2.group(2);
                if (group == null) {
                    group = matcher2.group(3);
                } else if (group.startsWith("'") && group.endsWith("'") && group.length() > 2) {
                    group = group.substring(1, group.length() - 1);
                }
                if (str2 == null || group.equalsIgnoreCase(str2)) {
                    str2 = group;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new C0131t(str, toLowerCase, toLowerCase2, str2);
    }

    public Charset m608a() {
        return this.f555f != null ? Charset.forName(this.f555f) : null;
    }

    public Charset m609a(Charset charset) {
        return this.f555f != null ? Charset.forName(this.f555f) : charset;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0131t) && ((C0131t) obj).f552c.equals(this.f552c);
    }

    public int hashCode() {
        return this.f552c.hashCode();
    }

    public String toString() {
        return this.f552c;
    }
}
