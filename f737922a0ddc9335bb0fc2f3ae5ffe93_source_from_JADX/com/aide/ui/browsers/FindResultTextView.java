package com.aide.ui.browsers;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.aide.engine.FindResult;
import com.aide.engine.FindResult.Highlighting;
import com.aide.ui.h;
import com.aide.uidesigner.ProxyTextView;

public class FindResultTextView extends TextView {
    public FindResultTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j6();
    }

    public FindResultTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j6();
    }

    public FindResultTextView(Context context) {
        super(context);
        j6();
    }

    private void j6() {
    }

    public void setContent(FindResult findResult) {
        int i = findResult.DW;
        String str = findResult.v5;
        int i2 = 0;
        while (i2 < str.length() && Character.isWhitespace(str.charAt(i2))) {
            i2++;
        }
        String substring = str.substring(i2, str.length());
        setText(substring, BufferType.SPANNABLE);
        Spannable spannable = (Spannable) getText();
        spannable.setSpan(new UnderlineSpan(), j6(i, i2, substring, findResult.DW, findResult.FH), j6(i, i2, substring, findResult.DW, findResult.Hw), 33);
        boolean cn = h.cn();
        for (int i3 = 0; i3 < findResult.Zo.size(); i3++) {
            Highlighting highlighting = (Highlighting) findResult.Zo.get(i3);
            if (highlighting.v5 != null) {
                int i4;
                int j6 = highlighting.v5.j6(getContext(), cn);
                switch (highlighting.v5.j6()) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        i4 = 1;
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        i4 = 2;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                int j62 = j6(i, i2, substring, highlighting.j6, highlighting.DW);
                int j63 = j6(i, i2, substring, highlighting.FH, highlighting.Hw);
                if (j62 >= 0 && j63 >= 0) {
                    spannable.setSpan(new ForegroundColorSpan(j6), j62, j63, 33);
                    switch (i4) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            spannable.setSpan(new StyleSpan(i4), j62, j63, 33);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (VERSION.SDK_INT >= 20) {
            setTypeface(Typeface.MONOSPACE);
        }
    }

    private int j6(int i, int i2, String str, int i3, int i4) {
        int i5 = (i3 - i) + 1;
        if (i5 == 1) {
            i4 -= i2;
        }
        if (i5 < 1) {
            return 0;
        }
        if (i5 > 1) {
            return str.length();
        }
        return Math.min(str.length(), i4 - 1);
    }
}
