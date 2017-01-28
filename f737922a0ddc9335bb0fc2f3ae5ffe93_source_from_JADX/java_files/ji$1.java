import android.content.Context;
import android.text.Editable;
import android.text.method.CharacterPickerDialog;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.aide.ui.e;

class ji$1 extends CharacterPickerDialog {
    final /* synthetic */ ji j6;

    ji$1(ji jiVar, Context context, View view, Editable editable, String str, boolean z) {
        this.j6 = jiVar;
        super(context, view, editable, str, z);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (!j6(view)) {
            super.onItemClick(adapterView, view, i, j);
        }
    }

    public void onClick(View view) {
        if (!j6(view)) {
            super.onClick(view);
        }
    }

    private boolean j6(View view) {
        int i = 0;
        String charSequence = ((Button) view).getText().toString();
        if (charSequence.length() != 1) {
            return false;
        }
        if (this.j6.j6 == null) {
            this.j6.j6 = KeyCharacterMap.load(0);
        }
        KeyEvent[] events = this.j6.j6.getEvents(charSequence.toCharArray());
        if (events != null) {
            int length = events.length;
            while (i < length) {
                e.u7().dispatchKeyEvent(events[i]);
                i++;
            }
        }
        dismiss();
        return true;
    }
}
