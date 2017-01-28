import android.text.Editable.Factory;
import android.view.KeyCharacterMap;
import android.view.View;
import com.aide.common.k;
import com.aide.ui.e;
import java.util.Arrays;
import java.util.List;

public class ji implements qn {
    private KeyCharacterMap j6;

    public k j6() {
        return new k(63, false, false, false);
    }

    public List<k> Hw() {
        return Arrays.asList(new k[]{new k(94, false, false, false), new k(116, false, false, false)});
    }

    public boolean g_() {
        return true;
    }

    public boolean DW() {
        j6(e.u7().sh());
        return true;
    }

    public String v5() {
        return "Show Character Picker";
    }

    public void j6(View view) {
        View view2 = view;
        new ji$1(this, view.getContext(), view2, Factory.getInstance().newEditable(""), "(){}[]\\!@#$%&*?/:_\"'-+;,.\ufffd~=^<>|\ufffd", true).show();
    }
}
