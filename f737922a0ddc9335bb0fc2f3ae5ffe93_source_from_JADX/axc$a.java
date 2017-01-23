import com.aide.uidesigner.ProxyTextView;

public class axc$a extends axc {
    public String j6(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\'');
        int i2 = 0;
        while (i < str.length()) {
            switch (str.charAt(i)) {
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                case '\'':
                    stringBuilder.append(str, i2, i);
                    stringBuilder.append('\'');
                    stringBuilder.append('\\');
                    stringBuilder.append(str.charAt(i));
                    stringBuilder.append('\'');
                    i2 = i + 1;
                    break;
                default:
                    break;
            }
            i++;
        }
        stringBuilder.append(str, i2, i);
        stringBuilder.append('\'');
        return stringBuilder.toString();
    }
}
